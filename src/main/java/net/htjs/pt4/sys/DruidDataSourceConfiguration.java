package net.htjs.pt4.sys;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Description  com.alibaba.druid.pool.DruidDataSource连接池性能监控配置类
 * @Author ming.js
 * @Date 2018/6/19
 */
@Configuration
@ConditionalOnClass(DruidDataSource.class)
@ConditionalOnProperty(name = "spring.datasource.type", havingValue = "com.alibaba.druid.pool.DruidDataSource", matchIfMissing = true)
public class DruidDataSourceConfiguration {

    @SuppressWarnings("unchecked")
    protected <T> T createDataSource(DataSourceProperties properties,
                                     Class<? extends DataSource> type) {
        return (T) properties.initializeDataSourceBuilder().type(type).build();
    }


    @Bean(destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties("spring.datasource.druid")
    public DruidDataSource druidDataSource(DataSourceProperties properties){
        DruidDataSource dataSource = createDataSource(properties, DruidDataSource.class);
        DatabaseDriver databaseDriver = DatabaseDriver
                .fromJdbcUrl(properties.determineUrl());
        String validationQuery = databaseDriver.getValidationQuery();
        if (validationQuery != null) {
            dataSource.setTestOnBorrow(true);
            dataSource.setValidationQuery(validationQuery);
        }
        return dataSource;
    }

    @Bean
    public ServletRegistrationBean druidStatViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        bean.addInitParameter("loginUsername", "admin");
        bean.addInitParameter("loginPassword", "admin");
        return bean;
    }

    @Bean
    public FilterRegistrationBean druidWebStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        bean.addUrlPatterns("/*");
        bean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return bean;
    }
}
