package com.sweetpotato.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sweetpotato.util.EmailUtil;

@Configuration
public class AppConfig {

	@Bean
	public EmailUtil emailUtil() {
		return new EmailUtil();
	}
}
