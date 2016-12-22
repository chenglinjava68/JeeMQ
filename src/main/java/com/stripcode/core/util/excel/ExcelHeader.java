package com.stripcode.core.util.excel;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

/**
 * Created by Metro on 2016/9/4.
 */
public class ExcelHeader<E> {
    private String title;
    private String name;
    private ExcelHeaderStyle excelHeaderStyle = new ExcelHeaderStyle();
    private ExcelCellStyle excelCellStyle = new ExcelCellStyle();
    private ExcelFormatter excelFormatter;

    public ExcelCellStyle getExcelCellStyle() {
        return excelCellStyle;
    }

    public void setExcelCellStyle(ExcelCellStyle excelCellStyle) {
        this.excelCellStyle = excelCellStyle;
    }

    public String getTitle() {
        return title;
    }

    public ExcelHeader(String title, String name, ExcelHeaderStyle excelHeaderStyle, ExcelCellStyle excelCellStyle, ExcelFormatter excelFormatter) {
        this.title = title;
        this.name = name;
        this.excelHeaderStyle = excelHeaderStyle;
        this.excelCellStyle = excelCellStyle;
        this.excelFormatter = excelFormatter;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ExcelHeader(String title, String name, ExcelHeaderStyle excelHeaderStyle) {
        this.title = title;
        this.name = name;
        this.excelHeaderStyle = excelHeaderStyle;
    }

    public ExcelHeader() {

    }

    public ExcelHeader(String title, String name, ExcelFormatter excelFormatter) {
        this.title = title;
        this.name = name;
        this.excelFormatter = excelFormatter;
    }

    public ExcelHeader(String title, String name) {
        this.title = title;
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public ExcelHeader(String title, String name, ExcelHeaderStyle excelHeaderStyle, ExcelFormatter excelFormatter) {
        this.title = title;
        this.name = name;
        this.excelHeaderStyle = excelHeaderStyle;
        this.excelFormatter = excelFormatter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExcelHeaderStyle getExcelHeaderStyle() {
        return excelHeaderStyle;
    }

    public void setExcelHeaderStyle(ExcelHeaderStyle excelHeaderStyle) {
        this.excelHeaderStyle = excelHeaderStyle;
    }

    public ExcelFormatter getExcelFormatter() {
        return excelFormatter;
    }

    public void setExcelFormatter(ExcelFormatter excelFormatter) {
        this.excelFormatter = excelFormatter;
    }


    public void setHeaderStyle(CellStyle cellStyle, Font font, ExcelHeaderStyle excelHeaderStyle) {
        if(excelHeaderStyle != null){
            if(excelHeaderStyle.getFontBoldWeight() != null){
                font.setBoldweight(excelHeaderStyle.getFontBoldWeight());
            }
            if(excelHeaderStyle.getFontHeight() != null){
                font.setFontHeight(excelHeaderStyle.getFontHeight());
            }
            if(excelHeaderStyle.getFontName() != null){
                font.setFontName(excelHeaderStyle.getFontName());
            }
            if(excelHeaderStyle.getBorderTop() != null){
                cellStyle.setBorderTop(excelHeaderStyle.getFontBoldWeight());
            }
            if(excelHeaderStyle.getBorderRight() != null){
                cellStyle.setBorderRight(excelHeaderStyle.getBorderRight());
            }
            if(excelHeaderStyle.getBorderBottom() != null){
                cellStyle.setBorderBottom(excelHeaderStyle.getBorderBottom());
            }
            if(excelHeaderStyle.getBorderLeft() != null){
                cellStyle.setBorderLeft(excelHeaderStyle.getBorderLeft());
            }
            if(excelHeaderStyle.getTopBorderColor() != null){
                cellStyle.setTopBorderColor(excelHeaderStyle.getTopBorderColor());
            }
            if(excelHeaderStyle.getFillBackgroundColor() != null){
                cellStyle.setFillBackgroundColor(excelHeaderStyle.getFillBackgroundColor());
            }
            if(excelHeaderStyle.getFillForegroundColor() != null){
                cellStyle.setFillForegroundColor(excelHeaderStyle.getFillForegroundColor());
            }
            if(excelHeaderStyle.getFillPattern() != null){
                cellStyle.setFillPattern(excelHeaderStyle.getFillPattern());
            }
            if(excelHeaderStyle.getRightBorderColor() != null){
                cellStyle.setRightBorderColor(excelHeaderStyle.getRightBorderColor());
            }
            if(excelHeaderStyle.getBottomBorderColor() != null){
                cellStyle.setBottomBorderColor(excelHeaderStyle.getBottomBorderColor());
            }
            if(excelHeaderStyle.getLeftBorderColor() != null){
                cellStyle.setLeftBorderColor(excelHeaderStyle.getLeftBorderColor());
            }
            if(excelHeaderStyle.getAlignment() != null){
                cellStyle.setAlignment(excelHeaderStyle.getAlignment());
            }
            if(excelHeaderStyle.getVerticalalignment() != null){
                cellStyle.setVerticalAlignment(excelHeaderStyle.getVerticalalignment());
            }
        }

    }

    public void setExcelCellStyle(CellStyle cellStyle, Font font,ExcelCellStyle excelCellStyle){
        if(excelCellStyle != null){
            if(excelCellStyle.getFontBoldWeight() != null){
                font.setBoldweight(excelCellStyle.getFontBoldWeight());
            }
            if(excelCellStyle.getFontHeight() != null){
                font.setFontHeight(excelCellStyle.getFontHeight());
            }
            if(excelCellStyle.getFontName() != null){
                font.setFontName(excelCellStyle.getFontName());
            }
            if(excelCellStyle.getBorderTop() != null){
                cellStyle.setBorderTop(excelCellStyle.getFontBoldWeight());
            }
            if(excelCellStyle.getBorderRight() != null){
                cellStyle.setBorderRight(excelCellStyle.getBorderRight());
            }
            if(excelCellStyle.getBorderBottom() != null){
                cellStyle.setBorderBottom(excelCellStyle.getBorderBottom());
            }
            if(excelCellStyle.getBorderLeft() != null){
                cellStyle.setBorderLeft(excelCellStyle.getBorderLeft());
            }
            if(excelCellStyle.getTopBorderColor() != null){
                cellStyle.setTopBorderColor(excelCellStyle.getTopBorderColor());
            }
            if(excelCellStyle.getFillBackgroundColor() != null){
                cellStyle.setFillBackgroundColor(excelCellStyle.getFillBackgroundColor());
            }
            if(excelCellStyle.getFillForegroundColor() != null){
                cellStyle.setFillForegroundColor(excelCellStyle.getFillForegroundColor());
            }
            if(excelCellStyle.getFillPattern() != null){
                cellStyle.setFillPattern(excelCellStyle.getFillPattern());
            }
            if(excelCellStyle.getRightBorderColor() != null){
                cellStyle.setRightBorderColor(excelCellStyle.getRightBorderColor());
            }
            if(excelCellStyle.getBottomBorderColor() != null){
                cellStyle.setBottomBorderColor(excelCellStyle.getBottomBorderColor());
            }
            if(excelCellStyle.getLeftBorderColor() != null){
                cellStyle.setLeftBorderColor(excelCellStyle.getLeftBorderColor());
            }
            if(excelCellStyle.getAlignment() != null){
                cellStyle.setAlignment(excelCellStyle.getAlignment());
            }
            if(excelCellStyle.getVerticalalignment() != null){
                cellStyle.setVerticalAlignment(excelCellStyle.getVerticalalignment());
            }
        }
    }
}
