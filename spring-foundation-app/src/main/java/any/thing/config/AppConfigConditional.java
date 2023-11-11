package any.thing.config;

import any.thing.service.AnyService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@ConditionalOnMissingBean(AnyService.class)
@Profile("PROD")
public class AppConfigConditional {

    @Bean
//    @ConditionalOnProperty(
//            name = "source",
//            havingValue = "test_condition")
    @Primary
    public DataSource dataSourceCond() {
        System.out.println("prod_test_condition");
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:prod_test_condition"); // test_condition
        dataSourceBuilder.username("SA");
        dataSourceBuilder.password("password");
        return dataSourceBuilder.build();
    }
}
