/**
 * 
 */
package fr.pizzeria.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author ETY11
 * @since 9 janv. 2017
 */
@Configuration
@EnableWebMvc
@EnableJpaRepositories
@ComponentScan("fr.pizzeria")
@EnableTransactionManagement
public class StockSpringconfig {

	@Bean
	public ModelAndView modelAndView() {

		return new ModelAndView();
	}

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {

		LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
		emf.setPersistenceUnitName("pizza-db");
		return emf;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory().getObject());
	}

	@Bean
	public InternalResourceViewResolver internalResourceResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setPrefix("/WEB-INF/views/");
		irvr.setSuffix(".jsp");
		return irvr;

	}

}
