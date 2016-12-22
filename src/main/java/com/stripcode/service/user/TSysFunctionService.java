package com.stripcode.service.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stripcode.core.util.tree.TreeModel;
import com.stripcode.mybatis.user.dao.TSysActionMapper;
import com.stripcode.mybatis.user.dao.TSysFunctionMapper;
import com.stripcode.mybatis.user.model.TSysAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/9/22.
 */
@Service
public class TSysFunctionService {
    @Autowired
    private TSysFunctionMapper tSysFunctionMapper;
    @Autowired
    private TSysActionMapper tSysActionMapper;
    public List<TreeModel> selectForTree() {
        List<TreeModel> treeModels = tSysFunctionMapper.selectForTree();
        for(TreeModel treeModel : treeModels){
            List<TSysAction> actions = tSysActionMapper.selectByFunctionId(treeModel.getRowId());
            List<Map<String,Object>> columns = new ArrayList<Map<String,Object>>();
            if(actions.size() !=0 ){
                ObjectMapper objectMapper = new ObjectMapper();
                for(TSysAction tSysAction : actions){
                    Map<String,Object> map = new HashMap<String,Object>();
                    map.put("id",tSysAction.getActionId());
                    map.put("text",tSysAction.getActionLabel());
                    map.put("parentId",tSysAction.getDef1());
                    columns.add(map);
                }
            }
            treeModel.setColumns(columns);
        }
        return treeModels;
    }

    public List<TreeModel> selectForMenu(String userId) {
        return tSysFunctionMapper.selectForMenu(userId);
    }
}
