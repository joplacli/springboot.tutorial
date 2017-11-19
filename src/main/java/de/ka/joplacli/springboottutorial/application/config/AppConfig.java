package de.ka.joplacli.springboottutorial.application.config;

import java.util.Properties;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.ErrorPageFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(basePackages = { "de.ka.joplacli.springboottutorial.batch.csv.config", "de.ka.joplacli.springboottutorial.batch.csv.listener", "de.ka.joplacli.springboottutorial.batch.csv.scheduled" })
@EnableScheduling
public class AppConfig {

	@Bean
	public Properties configBean() {
		final Properties properties = new Properties();
		return properties;
	}

	@Bean
	public ErrorPageFilter errorPageFilter() {
		return new ErrorPageFilter();
	}

	@Bean
	public FilterRegistrationBean disableSpringBootErrorFilter(final ErrorPageFilter filter) {
		final FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(filter);
		filterRegistrationBean.setEnabled(false);
		return filterRegistrationBean;
	}
}