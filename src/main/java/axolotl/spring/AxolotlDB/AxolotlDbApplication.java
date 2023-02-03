package axolotl.spring.AxolotlDB;

import axolotl.spring.AxolotlDB.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AxolotlDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(AxolotlDbApplication.class, args);
	}//main

	/*
	 * @Bean public FilterRegistrationBean<JwtFilter> jwtFilter(){
	 * FilterRegistrationBean<JwtFilter> registrationBean = new
	 * FilterRegistrationBean<>(); registrationBean.setFilter(new JwtFilter());
	 * registrationBean.addUrlPatterns("/api/actividades/*");
	 * registrationBean.addUrlPatterns("/api/clientes/*");
	 * registrationBean.addUrlPatterns("/api/compras/*"); return registrationBean;
	 * }//jwtFilter
	 */

}//class AxolotlDbAplication
