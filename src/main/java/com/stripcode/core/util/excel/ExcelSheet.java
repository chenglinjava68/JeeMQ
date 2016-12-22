package com.stripcode.core.util.excel;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Metro on 2016/9/4.
 */
public class ExcelSheet<E> {
    private String name;
    private ExcelTitleStyle excelTitleStyle  = new ExcelTitleStyle();
    private ExcelCommentsStyle excelCommentsStyle = new ExcelCommentsStyle();
    private List<E> data;
    private Sheet sheet;
    private String creator;
    private ExcelDocument<E> excelDocument;
    private List<ExcelHeader<E>> headers;
    private List<Row> rows = new ArrayList<Row>();
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExcelTitleStyle getExcelTitleStyle() {
        return excelTitleStyle;
    }

    public void setExcelTitleStyle(ExcelTitleStyle excelTitleStyle) {
        this.excelTitleStyle = excelTitleStyle;
    }

    public ExcelCommentsStyle getExcelCommentsStyle() {
        return excelCommentsStyle;
    }

    public void setExcelCommentsStyle(ExcelCommentsStyle excelCommentsStyle) {
        this.excelCommentsStyle = excelCommentsStyle;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    public Sheet getSheet() {
        return sheet;
    }

    public void setSheet(Sheet sheet) {
        this.sheet = sheet;
    }

    public List<ExcelHeader<E>> getHeaders() {
        return headers;
    }

    public void setHeaders(List<ExcelHeader<E>> headers) {
        this.headers = headers;
    }

    public ExcelDocument<E> getExcelDocument() {
        return excelDocument;
    }

    public void setExcelDocument(ExcelDocument<E> excelDocument) {
        this.excelDocument = excelDocument;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    /**
     *
     * @param name
     * @param creator
     * @param headers
     * @param rows
     * @param excelTitleStyle
     * @param excelCommentsStyle
     * @param data
     * @param excelDocument
     */
    //声明构造函数开始
    public ExcelSheet(String name, String creator, List<ExcelHeader<E>> headers, List<Row> rows, ExcelTitleStyle excelTitleStyle, ExcelCommentsStyle excelCommentsStyle, List<E> data,ExcelDocument<E> excelDocument) {
        this.name = name;
        this.creator = creator;
        this.headers = headers;
        this.rows = rows;
        this.excelTitleStyle = excelTitleStyle;
        this.excelCommentsStyle = excelCommentsStyle;
        this.data = data;
        this.excelDocument = excelDocument;
        init();
    }

    public ExcelSheet() {


    }
    public ExcelSheet(String name, String creator, List<ExcelHeader<E>> headers, List<E> data,ExcelDocument<E> excelDocument) {
        this.name = name;
        this.creator = creator;
        this.headers = headers;
        this.data = data;
        this.excelDocument = excelDocument;
        init();
    }

    public ExcelSheet(String name, List<Row> rows, List<ExcelHeader<E>> headers, List<E> data,ExcelDocument<E> excelDocument) {
        this.name = name;
        this.rows = rows;
        this.headers = headers;
        this.data = data;
        this.excelDocument = excelDocument;
        init();
    }
    //声明构造函数结束
    //初始化sheet
    public void init(){
        if(excelDocument== null){
            return;
        }
        int rowIndex = 0;
        Workbook book =excelDocument.getBook();
        this.sheet = book.createSheet();
        Row title = sheet.createRow(rowIndex++);
        CellStyle cellStyle = book.createCellStyle();
        Font font = book.createFont();
        if(excelTitleStyle != null ){
            if(excelTitleStyle.getAlignment() != null){
                cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
            }
            if(excelTitleStyle.getVerticalalignment() != null){
                cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
            }
            if(excelTitleStyle.getBorderBottom() != null){
                cellStyle.setBorderBottom(CellStyle.BORDER_THICK);
            }
            if(excelTitleStyle.getBorderRight() != null){
                cellStyle.setBorderRight(CellStyle.BORDER_THICK);
            }
            if(excelTitleStyle.getFontBoldWeight() != null){
                cellStyle.setAlignment(HSSFColor.BLACK.index);
            }
            if(excelTitleStyle.getFontName() != null){
                font.setFontName(excelTitleStyle.getFontName());
            }
            if(excelTitleStyle.getFontHeight() != null){
                font.setFontHeight(excelTitleStyle.getFontHeight());
            }
            cellStyle.setFont(font);
        }

        Cell cell = title.createCell(0);
        cell.setCellValue(name);
        cell.setCellStyle(cellStyle);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));
        Row pageTitle = sheet.createRow(rowIndex++);
        setTitleStyle(cellStyle, font);
        font = book.createFont();
        cellStyle = book.createCellStyle();
        setCommentsStyle(cellStyle, font);
        cell = pageTitle.createCell(0);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("");
        cell = pageTitle.createCell(1);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(creator);
        cell = pageTitle.createCell(2);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("创建时间：");
        cell = pageTitle.createCell(3);
        cell.setCellStyle(cellStyle);
        cell.setCellValue(com.stripcode.core.util.DateUtil.getDateTime());
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);
        Row headerRow = sheet.createRow(rowIndex++);
        for(int i = 0 ; i< headers.size();i++){
            cellStyle = book.createCellStyle();
            font = book.createFont();
            cell = headerRow.createCell(i);
            ExcelHeaderStyle excelHeaderStyle = headers.get(i).getExcelHeaderStyle();
            headers.get(i).setHeaderStyle(cellStyle, font, excelHeaderStyle);
            cellStyle.setFont(font);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(headers.get(i).getTitle());
            sheet.autoSizeColumn(i);
        }
        for(E item : data){
            Row row = sheet.createRow(rowIndex++);
            for(int i=0;i<headers.size();i++){
                cell = row.createCell(i);
                String fieldName = headers.get(i).getName();
                Object cellValue = getFieldValue(item,fieldName);
                if(cellValue == null){
                    cellValue =  "";
                }
                if(headers.get(i).getExcelFormatter() != null){
                    cellValue = headers.get(i).getExcelFormatter().formatter(row,cell,cellValue,rowIndex-1);
                }
                if(cellValue instanceof Date){
                    cellValue = com.stripcode.core.util.DateUtil.format((Date) cellValue,"yyyy-MM-dd HH:mm:ss");
                }
                cell.setCellValue(cellValue.toString());
                sheet.autoSizeColumn(i);
            }
        }
    }
    //获取元素域值
   private Object getFieldValue(Object obj,String fieldName){

       try {
           Method method = null;
           if(obj == null){
               return null;
           }
           Class clazz = obj.getClass();
           if(fieldName == null){
               return null;
           }
           if(fieldName.indexOf(".") == -1){
               method = clazz.getMethod("get"+fieldName.replaceFirst(fieldName.substring(0,1),fieldName.substring(0,1).toUpperCase()));
               if(method==null){
                   return null;
               }
               return method.invoke(obj);
           }
           method =  clazz.getMethod("get"+fieldName.replaceFirst(fieldName.split("\\.")[0].substring(0,1),fieldName.split("\\.")[0].substring(0,1).toUpperCase()));
            return getFieldValue(method.invoke(obj),fieldName.substring(fieldName.indexOf(".")+1));
       } catch (Exception ex) {
           ex.printStackTrace();
           return null;
       }

   }

    //设置sheet标题样式
    private void setTitleStyle(CellStyle cellStyle, Font font) {
        if(excelTitleStyle != null ){
            if(excelTitleStyle.getAlignment() != null){
                cellStyle.setAlignment(excelTitleStyle.getAlignment());
            }
            if(excelTitleStyle.getVerticalalignment() != null){
                cellStyle.setVerticalAlignment(excelTitleStyle.getVerticalalignment());
            }
            if(excelTitleStyle.getBorderBottom() != null){
                cellStyle.setBorderBottom(excelTitleStyle.getBorderBottom());
            }
            if(excelTitleStyle.getBorderRight() != null){
                cellStyle.setBorderRight(excelTitleStyle.getBorderRight());
            }
            if(excelTitleStyle.getFontBoldWeight() != null){
                font.setBoldweight(excelTitleStyle.getFontBoldWeight());
            }
            if(excelTitleStyle.getFontName() != null){
                font.setFontName(excelTitleStyle.getFontName());
            }
            if(excelTitleStyle.getFontHeight() != null){
                font.setFontHeight(excelTitleStyle.getFontHeight());
            }
            cellStyle.setFont(font);
        }
    }
    //设置sheet描述样式
    private void setCommentsStyle(CellStyle cellStyle, Font font) {
        if(excelCommentsStyle != null ){
            if(excelCommentsStyle.getAlignment() != null){
                cellStyle.setAlignment(excelCommentsStyle.getAlignment());
            }
            if(excelCommentsStyle.getBorderBottom() != null){
                cellStyle.setBorderBottom(excelCommentsStyle.getBorderBottom());
            }
            if(excelCommentsStyle.getBorderRight() != null){
                cellStyle.setBorderRight(excelCommentsStyle.getBorderRight());
            }
            if(excelCommentsStyle.getFontBoldWeight() != null){
                cellStyle.setAlignment(HSSFColor.BLACK.index);
            }
            if(excelCommentsStyle.getColor() != null){
                font.setColor(excelCommentsStyle.getColor());
            }
            if(excelCommentsStyle.getFontHeight() != null){
                font.setFontHeight(excelCommentsStyle.getFontHeight());
            }
            if(excelCommentsStyle.getItalic() != null){
                font.setItalic(excelCommentsStyle.getItalic());
            }
            cellStyle.setFont(font);
        }
    }
    //获取excelSheet原始值
    public Sheet toOrigal(){
        return this.sheet;
    }
}
