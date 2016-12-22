package com.stripcode.core.util.excel;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;

/**
 * Created by Metro on 2016/9/4.
 */
public class ExcelHeaderStyle {
    private Short fontBoldWeight = 900;
    private String fontName = "宋体";
    private Short fontHeight = 450;
    private Short borderTop = CellStyle.BORDER_THIN;
    private Short borderRight = CellStyle.BORDER_THIN;

    public Short getFontBoldWeight() {
        return fontBoldWeight;
    }

    public void setFontBoldWeight(Short fontBoldWeight) {
        this.fontBoldWeight = fontBoldWeight;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public Short getFontHeight() {
        return fontHeight;
    }

    public void setFontHeight(Short fontHeight) {
        this.fontHeight = fontHeight;
    }

    public Short getBorderTop() {
        return borderTop;
    }

    public void setBorderTop(Short borderTop) {
        this.borderTop = borderTop;
    }

    public Short getBorderRight() {
        return borderRight;
    }

    public void setBorderRight(Short borderRight) {
        this.borderRight = borderRight;
    }

    public Short getBorderBottom() {
        return borderBottom;
    }

    public void setBorderBottom(Short borderBottom) {
        this.borderBottom = borderBottom;
    }

    public Short getBorderLeft() {
        return borderLeft;
    }

    public void setBorderLeft(Short borderLeft) {
        this.borderLeft = borderLeft;
    }

    public Short getTopBorderColor() {
        return topBorderColor;
    }

    public void setTopBorderColor(Short topBorderColor) {
        this.topBorderColor = topBorderColor;
    }

    public Short getFillBackgroundColor() {
        return fillBackgroundColor;
    }

    public void setFillBackgroundColor(Short fillBackgroundColor) {
        this.fillBackgroundColor = fillBackgroundColor;
    }

    public Short getFillForegroundColor() {
        return fillForegroundColor;
    }

    public void setFillForegroundColor(Short fillForegroundColor) {
        this.fillForegroundColor = fillForegroundColor;
    }

    public Short getFillPattern() {
        return fillPattern;
    }

    public void setFillPattern(Short fillPattern) {
        this.fillPattern = fillPattern;
    }

    public Short getRightBorderColor() {
        return rightBorderColor;
    }

    public void setRightBorderColor(Short rightBorderColor) {
        this.rightBorderColor = rightBorderColor;
    }

    public Short getBottomBorderColor() {
        return bottomBorderColor;
    }

    public void setBottomBorderColor(Short bottomBorderColor) {
        this.bottomBorderColor = bottomBorderColor;
    }

    public Short getLeftBorderColor() {
        return leftBorderColor;
    }

    public void setLeftBorderColor(Short leftBorderColor) {
        this.leftBorderColor = leftBorderColor;
    }

    public Short getAlignment() {
        return alignment;
    }

    public void setAlignment(Short alignment) {
        this.alignment = alignment;
    }

    public Short getVerticalalignment() {
        return verticalalignment;
    }

    public void setVerticalalignment(Short verticalalignment) {
        this.verticalalignment = verticalalignment;
    }

    private Short borderBottom = CellStyle.BORDER_THIN;
    private Short borderLeft = CellStyle.BORDER_THIN;
    private Short topBorderColor = HSSFColor.TURQUOISE.index;
    private Short fillBackgroundColor = HSSFColor.DARK_RED.index;
    private Short fillForegroundColor = HSSFColor.PALE_BLUE.index;
    private Short fillPattern = CellStyle.SOLID_FOREGROUND;
    private Short rightBorderColor = HSSFColor.TURQUOISE.index;
    private Short bottomBorderColor = HSSFColor.TURQUOISE.index;
    private Short leftBorderColor = HSSFColor.TURQUOISE.index;
    private Short alignment = CellStyle.ALIGN_CENTER;
    private Short verticalalignment = CellStyle.VERTICAL_CENTER;
}


