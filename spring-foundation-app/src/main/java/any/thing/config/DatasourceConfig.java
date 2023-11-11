package any.thing.config;

import any.thing.config.datasourceBuilder.DatasourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("!PROD")
public class DatasourceConfig {

    @Bean
    public DataSource datasource(DatasourceBuilder datasourceBuilder) {
        return datasourceBuilder.build();
    }
}
