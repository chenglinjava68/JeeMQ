package com.stripcode.service.cs;

import com.stripcode.mybatis.cs.dao.CSCustomerInfoMapper;
import com.stripcode.mybatis.cs.dao.CSCustomerPPMapper;
import com.stripcode.mybatis.cs.dao.CSSfPipelineMapper;
import com.stripcode.mybatis.cs.model.CSCustomerInfo;
import com.stripcode.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

/**
 * Created by Metro on 2016/8/26.
 */
@Service
@CacheConfig(cacheNames = "csCustomerPP")
public class CS20_010Service extends BaseService{
        @Autowired
        private CSCustomerPPMapper  csCustomerPPMapper;
        @Autowired
        private CSCustomerInfoMapper csCustomerInfoMapper;
        @Autowired
        private CSSfPipelineMapper csSfPipelineMapper;

        /*
        查询客户意向店 客户信息
         */
        public CSCustomerInfo selectCPById(String customerId){
            return csCustomerInfoMapper.selectById(customerId);
        }


        //意向店列表
       /* public List<CSSfPipeline> selectList(){
                return csSfPipelineMapper.selectList();
        }*/

}
