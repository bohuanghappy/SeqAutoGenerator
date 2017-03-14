package com.dang.seq.service;

import com.dang.seq.client.ZkClient;
import com.dang.seq.dao.OrderIdDao;
import com.dang.seq.dto.OrderIdDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author huangbojs
 */
@Service
@Slf4j
public class SeqService {
    
    @Resource
    private ZkClient zkClient;
    @Resource
    private OrderIdDao orderIdDao;
    
    
    public Long generator(String token) {
    
        Integer retryTime = 3;
    
        String tableName = null;
        while (retryTime-- > 0) {
            try {
                tableName = zkClient.getData("/" + token);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (StringUtils.isEmpty(tableName)) {
            throw new RuntimeException("从zk上获取值异常");
        }
    
        System.out.println("table name: " + tableName);
        
        return orderIdDao.selectById(tableName);
    
    }
    
    
}
