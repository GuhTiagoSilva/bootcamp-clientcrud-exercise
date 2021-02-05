package com.clientcrud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {
    
	private static final String JWT_SECRET = "MY-JWT-SECRET";
	
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
    	
    	JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
    	accessTokenConverter.setSigningKey(JWT_SECRET);
    	return accessTokenConverter;
    }
    
    
    @Bean
    public JwtTokenStore tokenStore() {
    	return new JwtTokenStore(accessTokenConverter());
    }

}
