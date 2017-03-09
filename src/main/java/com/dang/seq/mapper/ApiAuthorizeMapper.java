package com.dang.seq.mapper;

import com.dang.seq.dto.ApiAuthorizeMapDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author huangbojs
 */
@Mapper
public interface ApiAuthorizeMapper {
    
    @Select("select * from ${table} where partner_id = #{id}")
    public ApiAuthorizeMapDto getById(@Param("id") Long id, @Param("table") String table);
    
}
