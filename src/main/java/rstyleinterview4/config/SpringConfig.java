package rstyleinterview4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;


@Configuration
@ComponentScan("rstyleinterview4")
@PropertySource("classpath:application.properties")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {


    @Value("${jdbc.Url}")
    private String jdbcUrl;

    @Value("${jdbc.userName}")
    private String jdbcUserName;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Autowired
    public SpringConfig() {

    }


    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUserName);
        dataSource.setPassword(jdbcPassword);

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate((dataSource()));
    }


}
