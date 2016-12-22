package com.stripcode.service.user.impl;

import com.stripcode.core.util.tree.TreeModel;

import java.util.List;

/**
 * Created by Metro on 2016/9/22.
 */

public interface TSysFunctionService {

    public List<TreeModel> selectForTree();
    public List<TreeModel> selectForMenu(String userId);
}
