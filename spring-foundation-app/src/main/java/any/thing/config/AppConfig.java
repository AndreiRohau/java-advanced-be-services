package any.thing.config;

import any.thing.service.AnyService;
import any.thing.service.AnyServiceImpl;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("PROD")
public class AppConfig {

    @Bean // comment his line to remove AnyService from the context
    public AnyService anyService() {
        return new AnyServiceImpl();
    }

    @Bean
//    @ConditionalOnProperty(
//            name = "source",
//            havingValue = "test")
    public DataSource dataSource() {
        System.out.println("prod_test");
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:prod_test"); // test
        dataSourceBuilder.username("SA");
        dataSourceBuilder.password("password");
        return dataSourceBuilder.build();
    }
}
