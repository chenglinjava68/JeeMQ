package com.stripcode.core.util.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Metro on 2016/9/4.
 */
public class ExcelDocument<E> {
    public  Workbook book;
    private  String subfix;

    public String getSubfix() {
        return subfix;
    }
    private Integer SHEET_MAX_ROW;
    private String fileName;
    private List<ExcelHeader<E>> headers;

    public List<ExcelHeader<E>> getHeaders() {
        return headers;
    }

    public void setHeaders(List<ExcelHeader<E>> headers) {
        this.headers = headers;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    private void getInstance() {
        try {
            book = new HSSFWorkbook();
            subfix = ".xls";
        } catch (Exception e) {
            book = new XSSFWorkbook();
            subfix = ".xlsx";
        }
        ;
    }

    public ExcelDocument(Integer SHEET_MAX_ROW, String fileName, String creator, List<ExcelHeader<E>> headers, List<E> data) {
        getInstance();
        this.SHEET_MAX_ROW = SHEET_MAX_ROW;
        this.fileName = fileName;
        this.creator = creator;
        this.headers = headers;
        this.data = data;
        this.SHEET_MAX_ROW = SHEET_MAX_ROW;
        this.fileName = fileName;
        this.creator = creator;
        this.headers = headers;
        this.data = data;
        if (data == null) {
            return;
        }
        int total = data.size();
        int totalPage = (int) Math.ceil(total * 1.0 / SHEET_MAX_ROW);
        for (int i = 0; i < totalPage; i++) {
            List<E> tempData = new ArrayList<E>();
            for (int j = i * SHEET_MAX_ROW; j < j + SHEET_MAX_ROW; j++) {
                if (j == data.size()) {
                    break;
                }
                tempData.add(data.get(j));
            }
            ExcelSheet excelSheet = new ExcelSheet<E>(fileName, creator, headers, tempData,this);
            sheets.add(excelSheet);
            if(book != null){
                int pageSize = i+SHEET_MAX_ROW > data.size() ? data.size() :  i+SHEET_MAX_ROW;
                book.setSheetName(i,"第"+(i+1)+"-"+pageSize+"条");
            }
        }
    }

    private String creator;
    private List<ExcelSheet> sheets = new ArrayList<ExcelSheet>();

    private List<E> data;

    public Workbook getBook() {
        return book;
    }
    public ExcelDocument() {
        getInstance();

    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getSHEET_MAX_ROW() {
        return SHEET_MAX_ROW;
    }

    public void setSHEET_MAX_ROW(Integer SHEET_MAX_ROW) {
        this.SHEET_MAX_ROW = SHEET_MAX_ROW;
    }

    public List<ExcelSheet> getSheets() {
        return sheets;
    }

    public void setSheets(List<ExcelSheet> sheets) {
        this.sheets = sheets;
    }
}
