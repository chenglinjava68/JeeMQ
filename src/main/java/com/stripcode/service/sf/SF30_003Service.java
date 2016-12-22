package com.stripcode.service.sf;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stripcode.core.dto.sf.QueryCSpipeLineDto;
import com.stripcode.mybatis.cp.dao.CpMarketInfoMapper;
import com.stripcode.mybatis.cp.model.CpMarketInfo;
import com.stripcode.mybatis.cs.model.CSSfPipeline;
import com.stripcode.mybatis.sf.dao.SFSfPipelineMapper;
import com.stripcode.mybatis.user.dao.TCodeMacroDefineMapper;
import com.stripcode.mybatis.user.model.TCodeMacroDefine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Metro on 2016/12/5.
 */
@Service
public class SF30_003Service {
    @Autowired
    private SFSfPipelineMapper sfSfPipelineMapper;
    @Autowired
    private TCodeMacroDefineMapper tCodeMacroDefineMapper;
    @Autowired
    private CpMarketInfoMapper cpMarketInfoMapper;
    public PageInfo<CSSfPipeline> selectMapListForPage(QueryCSpipeLineDto params){
            PageHelper.startPage(params);
            return new PageInfo<CSSfPipeline>(sfSfPipelineMapper.selectMapListForPage(params));
    }
    public List<TCodeMacroDefine> selectOperationModeList(){
        return tCodeMacroDefineMapper.selectByMacroType("OPERATION_MODE");
    }
    public List<TCodeMacroDefine> selectStoreImageList(){
        return tCodeMacroDefineMapper.selectByMacroType("STORE_IMAGE");
    }

    public List<CpMarketInfo> getAreaInfo(String  parentId,String cityName) {
        return cpMarketInfoMapper.selectByParentId(parentId,cityName);
    }
}
