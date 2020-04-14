package net.saltedgrove.refrigerator.configuration

import org.springframework.context.ApplicationContextAware
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter(), ApplicationContextAware {
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
    }

    @Throws(Exception::class)
    protected fun registerAuthentication(authManagerBuilder: AuthenticationManagerBuilder) {
        authManagerBuilder
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("ADMIN")
    }
}