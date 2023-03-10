package com.library.mytoysblizz.configs;


import com.google.common.base.Preconditions;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.mapping.model.PreferredConstructorDiscoverer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Configuration
@EnableTransactionManagement
@RequiredArgsConstructor
public class ConexionDb {

    private Environment env;

    private static final String PERSISTENCE_DATA_CONNECTION = "spring.datasource.toysdb";
    private static final String PACKAGE = "com.library.mytoysblizz";


    @Primary
    @Bean(name = "toysdbDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.toysdb")
    public DataSource toysdbDataSource(){

        DriverManagerDataSource conexion = new DriverManagerDataSource();
        conexion.setDriverClassName("com.mysql.jdbc.Driver");
        conexion.setUsername("root");
        conexion.setPassword("Asd.123*-");
        conexion.setUrl("jdbc:mysql://localhost:3306/mycloths?useSSL=false&allowMultiQueries=true&serverTimezone=UTC");

        return conexion;
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            @Qualifier("toysdbDataSource") DataSource dataSource
    ) {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean em  = new LocalContainerEntityManagerFactoryBean();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setDataSource(dataSource);
        em.setPackagesToScan(PACKAGE);
        em.setPersistenceUnitName("toysdb");
        Map<String,String> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto" , "update");
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Bean(name = "myTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory
    ) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }
}
