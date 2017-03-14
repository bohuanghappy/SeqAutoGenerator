package com.dang.seq.dao;

import com.dang.seq.dto.OrderIdDto;
import com.dang.seq.mapper.OrderIdMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangbojs
 */
@Repository
public class OrderIdDao {
    
    @Autowired
    private OrderIdMapper orderIdMapper;
    
    public Long selectById(String tableName) {
        Map<String, Object> map = new HashMap<>();
        map.put("table", tableName);
        map.put("id", 0L);
        long id = orderIdMapper.selectLastInsertId(map);
        return Long.valueOf((map.get("id").toString()));
    }
    
}
