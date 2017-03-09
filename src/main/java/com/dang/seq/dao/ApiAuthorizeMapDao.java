package com.dang.seq.dao;

import com.dang.seq.dto.ApiAuthorizeMapDto;
import com.dang.seq.mapper.ApiAuthorizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author huangbojs
 */
@Repository
public class ApiAuthorizeMapDao {
    
    @Autowired
    private ApiAuthorizeMapper apiAuthorizeMapper;
    
    public ApiAuthorizeMapDto selectById(Long id) {
        ApiAuthorizeMapDto dto = apiAuthorizeMapper.getById(id, "api_authorize_map");
        return dto;
    }
}
