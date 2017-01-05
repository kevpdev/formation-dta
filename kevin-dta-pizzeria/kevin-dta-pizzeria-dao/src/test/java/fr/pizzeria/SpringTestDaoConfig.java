package fr.pizzeria;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.spring.PizzaDaojdbcTemplate;

@Configuration
@ComponentScan("fr.pizzeria")
public class SpringTestDaoConfig {

	@Bean
	public DataSource getDataSource() {

		// DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		// dataSource.setUrl("jdbc:mysql://localhost:3306/pizzeria");
		// dataSource.setUsername("root");
		// dataSource.setPassword("");
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase dataSource = builder.setType(EmbeddedDatabaseType.H2).addScript("pizzeria.sql").build();
		return dataSource;

	}

	@Bean
	public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}

	@Bean
	public PizzaDao getPizzaDaoTest() {
		return new PizzaDaojdbcTemplate();
	}

}
