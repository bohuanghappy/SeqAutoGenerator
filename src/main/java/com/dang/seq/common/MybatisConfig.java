package com.dang.seq.common;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Author huangbojs
 */
@Configuration
@MapperScan("com.dang.seq.mapper")
@PropertySource(value = "config/jdbc.properties")
public class MybatisConfig {
   
    @Autowired
    private Environment env;
    
    /**
     * 创建单一数据源
     *
     * @return
     * @throws Exception
     */
    @Bean
    //@ConfigurationProperties(prefix = "")
    public DataSource getDataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("jdbc.seq0.driverClassName"));
        props.put("url", env.getProperty("jdbc.seq0.url"));
        props.put("username", env.getProperty("jdbc.seq0.username"));
        props.put("password", env.getProperty("jdbc.seq0.password"));
    
        DataSourceBuilder.create().build();
        
        return DruidDataSourceFactory.createDataSource(props);
        //return DataSourceBuilder.create().build();
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
    
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setTypeAliasesPackage("com.dang.seq.dto");
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
    
        return sqlSessionFactoryBean.getObject();
    }
}
