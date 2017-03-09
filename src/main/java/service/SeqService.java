package service;

import com.dang.seq.client.ZkClient;
import com.dang.seq.dao.ApiAuthorizeMapDao;
import com.dang.seq.dto.ApiAuthorizeMapDto;
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
    private ApiAuthorizeMapDao apiAuthorizeMapDao;
    
    private static Integer retryTime = 3;
    
    public Long generator(String token) {
    
    
        String tableName = null;
        while (retryTime-- > 0) {
            try {
                tableName = zkClient.getData("/" + token);
                break;
            } catch (Exception e) {
                log.error("从zk上获取[{}]节点值异常", token);
            }
        }
        if (StringUtils.isEmpty(tableName)) {
            throw new RuntimeException("从zk上获取值异常");
        }
        
        
        ApiAuthorizeMapDto apiAuthorizeMapDto = apiAuthorizeMapDao.selectById(10008001L);
        
        return String.valueOf(apiAuthorizeMapDto.getApi_id());
    }
    
    
}
