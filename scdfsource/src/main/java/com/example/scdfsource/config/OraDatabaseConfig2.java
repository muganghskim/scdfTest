//package com.example.scdfsource.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.support.TransactionTemplate;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@EnableJpaRepositories(
//        basePackages = "com.example.scdfsource.orarepository2",
//        entityManagerFactoryRef = "oracleEntityManagerFactory2",
//        transactionManagerRef = "oracleTransactionManager2")
//public class OraDatabaseConfig2 {
//    @Value("${spring.jpa.oramodel.Rcs111Recovery}")
//    private String hbmddle2;
//
//    @Value("${spring.datasource.oracle.database-platform}")
//    private String dialect;
//
//    @Bean(name = "oracleDataSource2")
//    @ConfigurationProperties(prefix = "spring.datasource.oracle")
//    public DataSource oracleDataSource() {
//        HikariDataSource dataSource = new HikariDataSource();
//        return dataSource;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory2(
//            @Qualifier("oracleDataSource2") DataSource dataSource
//    ) {
//        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactory.setDataSource(dataSource);
//        entityManagerFactory.setPackagesToScan("com.example.scdfsource.oramodel");
//        entityManagerFactory.setPersistenceUnitName("oracle");
//        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//        entityManagerFactory.setJpaPropertyMap(hibernateProperties());
//
//        return entityManagerFactory;
//    }
//
//    @Bean
//    public PlatformTransactionManager oracleTransactionManager2(
//            @Qualifier("oracleEntityManagerFactory2") EntityManagerFactory entityManagerFactory
//    ) {
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//
//    @Bean
//    public TransactionTemplate oracleTransactionTemplate2(
//            @Qualifier("oracleTransactionManager2") PlatformTransactionManager oracleTransactionManager
//    ) {
//        return new TransactionTemplate(oracleTransactionManager);
//    }
//
//    private Map<String, Object> hibernateProperties() {
//        Map<String, Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto", hbmddle2);
//        properties.put("hibernate.dialect", dialect);
//        return properties;
//    }
//}
//
