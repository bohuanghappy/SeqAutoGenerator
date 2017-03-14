package com.dang.seq.client;

import lombok.Getter;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Author huangbojs
 */
@Service
@Getter
public class ZkClient {
    
    private CuratorFramework client;
    
    @Autowired
    private ZkProperties zkProperties;
    
    public ZkClient() {
        
    }
    
    @PostConstruct
    public void ZkClientBuild() {
        client = CuratorFrameworkFactory.builder()
                .namespace(zkProperties.getNamespace())
                .connectString(zkProperties.getConnectStr())
                .connectionTimeoutMs(zkProperties.getTimeout())
                .retryPolicy(new ExponentialBackoffRetry(1000, 10))
                .build();
        client.start();
    }
    
/*    public static void main(String[] args) throws Exception {
        CuratorFramework client = new ZkClient().getClient();
        System.out.println(new String(client.getData().forPath("/test"), "utf-8"));
    }*/
    

    public String getData(String path) throws Exception {
        return new String(client.getData().forPath(path), zkProperties.getCharset());
    }
}
