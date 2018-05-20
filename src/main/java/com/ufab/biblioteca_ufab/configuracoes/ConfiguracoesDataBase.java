package com.ufab.biblioteca_ufab.configuracoes;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//Configura��es basicas para web
@Configuration

@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.ufab.biblioteca_ufab.models.repositorios")
/**
 * Classe responsável por manter as configurações de acesso ao banco de dados e entidades
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */
public class ConfiguracoesDataBase {

	public ConfiguracoesDataBase() {
	}

	/**
	 * Define as configurações de conexão ao banco de dados
	 * 
	 * @return dataSource
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Bean
	public DataSource dataSource() throws IllegalStateException, PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl(
				"jdbc:mysql://127.0.0.1:3306/biblioteca_ufab?useLegacyDatetimeCode=false&serverTimezone=America/Recife&useSSL=false");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	/**
	 * Define as configurações de acesso e criação de entidades
	 * 
	 * @return entityManagerFactoryBean
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan("com.ufab.biblioteca_ufab.models.entidades");
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setJpaDialect(new HibernateJpaDialect());

		Properties jpaProterties = new Properties();
		jpaProterties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		jpaProterties.put("hibernate.hbm2ddl.auto", "update");
		entityManagerFactoryBean.setJpaProperties(jpaProterties);
		return entityManagerFactoryBean;
	}

	/**
	 * Gerencia as transações do hibernate
	 * 
	 * @param auth
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Bean
	public JpaTransactionManager transactionManager() throws Exception {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

}
