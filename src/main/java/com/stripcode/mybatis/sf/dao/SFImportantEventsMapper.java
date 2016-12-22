package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFImportantEvents;

import java.util.List;

/**
 * @author Metro
 */
public interface SFImportantEventsMapper {
    List<SFImportantEvents> queryImportantEvents(String handoverId);

    Integer insertImportantEvents(SFImportantEvents model);

    Integer updaterImportantEvents(SFImportantEvents model);
}
