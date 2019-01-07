package ma.tetouan.factoryrest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${admin.name}")
	private String ADMIN_USERNAME;
	
	@Value("${admin.password}")
	private String ADMIN_PASSWORD;
	
	@Value("${user.name}")
	private String USER_USERNAME;
	
	@Value("${user.password}")
	private String USER_PASSWORD;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(USER_USERNAME).password("{noop}"+USER_PASSWORD).roles("USER");
        auth.inMemoryAuthentication().withUser(ADMIN_USERNAME).password("{noop}"+ADMIN_PASSWORD).roles("USER", "ADMIN");
    }	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//        http.addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class);
        http
        .authorizeRequests()
        .antMatchers("/login").permitAll()
        .anyRequest()
        .authenticated()
		.and()
		.formLogin()
		.and()
		.csrf().disable();
	}
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers("/**js")
            .antMatchers("/**css")
            .antMatchers("/fontawesome**");
    }
    
}