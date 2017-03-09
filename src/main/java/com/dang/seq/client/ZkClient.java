package com.dang.seq.client;

import lombok.Getter;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author huangbojs
 */
@Service
@Getter
public class ZkClient {
    
    private CuratorFramework client;
    
    @Value("${zk.connectStr}")
    private String connectStr;
    @Value("${zk.namespace}")
    private String zkNamespace;
    @Value("${zk.connection.timeout}")
    private Integer timeout;
    @Value("${zk.charset:utf-8} ")
    private String charset;
    
    public ZkClient() {
        client = CuratorFrameworkFactory.builder()
                .namespace("zookeeper")
                .connectString(connectStr)
                .connectionTimeoutMs(timeout)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();
        client.start();
    }
    
/*    public static void main(String[] args) throws Exception {
        CuratorFramework client = new ZkClient().getClient();
        System.out.println(new String(client.getData().forPath("/test"), "utf-8"));
    }*/
    

    public String getData(String path) throws Exception {
        return new String(client.getData().forPath(path), charset);
    }
}
