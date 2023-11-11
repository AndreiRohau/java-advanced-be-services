package any.thing.config.datasourceBuilder;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Profile("DEV")
public class DatasourceBuilderDevImpl implements DatasourceBuilder {
    @Override
    public DataSource build() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:dev_test"); // test
        dataSourceBuilder.username("SA");
        dataSourceBuilder.password("password");
        return dataSourceBuilder.build();
    }
}
