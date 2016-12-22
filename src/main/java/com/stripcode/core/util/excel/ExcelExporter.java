package com.stripcode.core.util.excel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

/**
 * Created by Metro on 2016/9/4.
 */
public class ExcelExporter {
    private HttpServletRequest request;

    public ExcelExporter() {
    }

    public ExcelExporter(HttpServletRequest request, HttpServletResponse response) {

        this.request = request;
        this.response = response;
    }

    private HttpServletResponse response;
    public void export(ExcelDocument excelDocument){
        try {
            HttpSession session =  request.getSession();
            session.setAttribute("isExporting",true);
            if (request.getHeader("user-agent").toUpperCase().indexOf("FIREFOX") == -1) {
                excelDocument.setFileName(URLEncoder.encode(excelDocument.getFileName(), "UTF-8")) ;
            }
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="
                    + excelDocument.getFileName()+excelDocument.getSubfix());
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
            excelDocument.book.write(response.getOutputStream());
            response.getOutputStream().flush();
            response.getOutputStream().close();
            session.removeAttribute("isExporting");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
