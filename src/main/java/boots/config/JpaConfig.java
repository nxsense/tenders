package boots.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {"boots.repository"})
@EnableTransactionManagement
public class JpaConfig {
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory(){
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("TendersDB");
        return factoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }
}
