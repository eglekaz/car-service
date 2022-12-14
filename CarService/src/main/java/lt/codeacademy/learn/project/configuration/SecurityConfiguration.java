package lt.codeacademy.learn.project.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserAuthenticationSuccessHandler successHandler;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
	  throws Exception {
		 auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
	      .dataSource(dataSource)
	      .usersByUsernameQuery("select username, password, enabled from users where username=?")
	        .authoritiesByUsernameQuery("select username, role from users where username=?");
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().antMatchers("/service-advisor/**")
                .hasAuthority("ROLE_ADMIN")
                .antMatchers("/technician/**")
                .hasAuthority("ROLE_USER")
                .anyRequest().permitAll()
                .and()
                .formLogin().successHandler(successHandler)
                .loginPage("/login").loginProcessingUrl("/process-login").permitAll()
                .and()
                .logout().logoutSuccessUrl("/?logout=true")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID").permitAll()
                .and()
                .csrf()
                .disable();
              

	}
	
}
