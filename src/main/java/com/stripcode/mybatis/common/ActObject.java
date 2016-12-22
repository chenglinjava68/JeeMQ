package com.stripcode.mybatis.common;

import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.Page;

import java.util.List;

/**
 * Created by Metro on 2016/8/17.
 */
public class ActObject {
    private Integer page;
    private Integer total;
    private Long records;
    private List<?> rows;
    private PageInfo<?> pageInfo;

    public ActObject(Page<org.activiti.engine.repository.ProcessDefinition> page) {
        this.page = page.getPageNo();
        this.total = page.getTotalPage();
        this.records = page.getCount();
        this.rows = page.getList();
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Long getRecords() {
        return records;
    }

    public void setRecords(Long records) {
        this.records = records;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
