package br.com.bryan.primetec.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import br.com.bryan.primetec.enuns.EnumEmailConfig;

@Configuration
public class JavaEmailConfig {
	@Bean
	public JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost(EnumEmailConfig.HOST.getValor());
	    mailSender.setPort(Integer.valueOf(EnumEmailConfig.PORT.getValor()));
	    
	    mailSender.setUsername(EnumEmailConfig.USERNAME_EMAIL.getValor());
	    mailSender.setPassword(EnumEmailConfig.PASSWORD.getValor());
	    
	    Properties props = mailSender.getJavaMailProperties();
	    
	    
	    for (EnumEmailConfig config : EnumEmailConfig.values()) {
			if(config.getPropriedade() != null) {
				props.put(config.getPropriedade(), config.getValor());
			}
		}
	            
	    return mailSender;
	}
}
