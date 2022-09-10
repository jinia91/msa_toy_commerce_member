package com.toycommerce.member.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfig: WebSecurityConfigurerAdapter() {

    override fun configure(web: HttpSecurity) {
        http
            /**
             * 인증 설정
             */
            .authorizeRequests()
            .anyRequest().permitAll()
    }

    @Bean
    fun getPasswordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}