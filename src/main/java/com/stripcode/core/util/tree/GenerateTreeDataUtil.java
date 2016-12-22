package com.stripcode.core.util.tree;

import com.mysql.jdbc.StringUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Metro on 2016/9/29.
 */
public class GenerateTreeDataUtil {

    public  static  void main(String [] args){
        List<TreeModel> sourceData = new ArrayList<TreeModel>();
        for(int i = 0 ;i<100;i++){
            TreeModel tempTreeModel = new TreeModel();
            tempTreeModel.setRowId(String.valueOf(i));
            tempTreeModel.setParentId("");
            sourceData.add(tempTreeModel);
            for(int j = 0;j<100;j++){
                TreeModel temp1TreeModel = new TreeModel();
                temp1TreeModel.setRowId(String.valueOf(i)+"_"+String.valueOf(j));
                temp1TreeModel.setParentId(String.valueOf(i));
                sourceData.add(temp1TreeModel);
                for(int k = 0;k<2;k++){
                    TreeModel temp2TreeModel = new TreeModel();
                    temp2TreeModel.setRowId(String.valueOf(i)+"_"+String.valueOf(j)+"_"+String.valueOf(k));
                    temp2TreeModel.setParentId(String.valueOf(i)+"_"+String.valueOf(j));
                    sourceData.add(temp2TreeModel);
                }
            }
        }
        List<TreeNode> treeNode;
        treeNode =  recursionChildren("",sourceData);
        TreeNode tempTreeNode = treeNode.get(0);
    }

    /**
     *  递归查询出子节点
     * @param fromRowId 父节点ＩＤ
     * @param sourceData　数据集
     * @return 返回树结构数据{ID:ID,TEXT:TEXT, children:[{ID:ID,TEXT:TEXT, children:[]},{ID:ID,TEXT:TEXT, children:[]}]}
     */
    static public List<TreeNode>  recursionChildren(String fromRowId,List<TreeModel> sourceData){
        // 子节点列表
        List<TreeNode> treeNodeChildrenLst = new ArrayList<TreeNode>();
        if(sourceData != null && sourceData.size()>0) for (int i = 0; i < sourceData.size(); i++) {
            TreeModel treeModelreeModel = sourceData.get(i);
            // ROW_ID
            String rowId = treeModelreeModel.getRowId();
            // 节点名称
            String tagName = treeModelreeModel.getTagName();
            // 父节点
            String parentId = treeModelreeModel.getParentId();
            // 节点
            TreeNode treeNode = new TreeNode();
            treeNode.setId(rowId);
            treeNode.setText(tagName);
            BeanUtils.copyProperties(treeModelreeModel,treeNode);
            // 空字符处理
            if (StringUtils.isNullOrEmpty(parentId)) {
                parentId = "";
            }
            // 返回字节点并且递归出下一级子节点
            if (parentId.equalsIgnoreCase(fromRowId)) {
                treeNodeChildrenLst.add(treeNode);
                // 去除已经处理过的节点
                List<TreeModel> tempSourceData = new ArrayList<TreeModel>();
                tempSourceData.addAll(sourceData);
                tempSourceData.remove(treeModelreeModel);
                // 递归查询子节点
                treeNode.setChildren(recursionChildren(rowId, tempSourceData));
            }
        }
        return treeNodeChildrenLst;
    }

}
