package com.dang.seq.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @Author huangbojs
 */
@Mapper
public interface OrderIdMapper {
    
    //xml自动注入
    public Long selectLastInsertId(Map<String, Object> table);
}
