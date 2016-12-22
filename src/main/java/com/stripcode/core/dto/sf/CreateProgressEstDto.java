package com.stripcode.core.dto.sf;

import com.stripcode.mybatis.sf.model.SFProgressEst;

import java.util.List;

/**
 * Created by Metro on 2016/10/19.
 */
public class CreateProgressEstDto {
    public List<SFProgressEst> getProgressEstList() {
        return ProgressEstList;
    }

    public void setProgressEstList(List<SFProgressEst> progressEstList) {
        ProgressEstList = progressEstList;
    }

    private List<SFProgressEst> ProgressEstList;

}
