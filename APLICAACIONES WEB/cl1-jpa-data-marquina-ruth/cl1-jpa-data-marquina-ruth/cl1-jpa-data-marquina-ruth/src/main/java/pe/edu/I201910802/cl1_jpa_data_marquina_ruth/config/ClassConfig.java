package pe.edu.I201910802.cl1_jpa_data_marquina_ruth.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClassConfig {
    @Value("${DB_WORLD_URL}")
    private String dbWorldUrl;

    @Value("${DB_WORLD_USER}")
    private String dbWorldUser;

    @Value("${DB_WORLD_PASS}")
    private String dbWorldPass;

    @Value("${DB_WORLD_DRIVER}")
    private String dbWorldDriver;

    @Bean
    public HikariDataSource hikariDataSource() {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(dbWorldUrl);
        config.setUsername(dbWorldUser);
        config.setPassword(dbWorldPass);
        config.setDriverClassName(dbWorldDriver);

        config.setMaximumPoolSize(30);
        config.setMinimumIdle(4);
        config.setIdleTimeout(240000);
        config.setConnectionTimeout(45000);

        return new HikariDataSource(config);
    }
}
