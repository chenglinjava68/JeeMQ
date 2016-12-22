package com.stripcode.core.util.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * Created by Metro on 2016/9/4.
 */
public interface ExcelFormatter {
    public Object formatter(Row row, Cell cell,Object value,Integer  rowIndex);
}
