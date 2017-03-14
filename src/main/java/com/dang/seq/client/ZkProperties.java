package com.dang.seq.client;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author huangbojs
 */
@Configuration
@ConfigurationProperties(prefix = "zk")
@Getter
@Setter
public class ZkProperties {
    
    private String connectStr;
    private String namespace;
    private Integer timeout;
    private String charset = "utf-8";
}
