package com.stripcode.core.util.excelUtil;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.ps.model.PSPolicySupportImplementationModel;
import com.stripcode.mybatis.sf.model.SFTrafficcountDetail;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 操作Excel表格的功能类
 */
public class ImportExcel1 {
	private POIFSFileSystem fs;
	private Workbook wb;
	private Sheet sheet;
	private Row row;

	/**
	 * 读取Excel表格表头的内容
	 * @param is
	 * @return String 表头内容的数组
	 */
	public String[] readExcelTitle(InputStream is) {
		try {
			wb = WorkbookFactory.create(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		row = sheet.getRow(0);
		// 标题总列数
		int colNum = row.getPhysicalNumberOfCells();
		System.out.println("colNum:" + colNum);
		String[] title = new String[colNum];
		for (int i = 0; i < colNum; i++) {
			title[i] = getCellFormatValue(row.getCell(i));
		}
		return title;
	}

	/**
	 * 读取Excel数据内容
	 * @param is
	 * @return Map 包含单元格数据内容的Map对象
	 */
	public Map<String, Object> readExcelContent(InputStream is,String checkId) {
		Map<String, Object> content = new HashMap<String, Object>();
		List<PSPolicySupportImplementationModel> list = new ArrayList<PSPolicySupportImplementationModel>();
		PSPolicySupportImplementationModel trafficcount = new PSPolicySupportImplementationModel();
		String str = "";
		Boolean result = true;
		try {
			wb = WorkbookFactory.create(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
		// 正文内容应该从第二行开始,第一行为表头的标题
		SFTrafficcountDetail trafficcountDetail = null;
		try{
			for (int i = 2; i <= rowNum; i++) {
				row = sheet.getRow(i);
				if(i==2)
				{
					trafficcount.setSuperiorCompany(getCellFormatValue(row.getCell(1)).trim());
					trafficcount.setErpCode(getCellFormatValue(row.getCell(2)).trim());
					trafficcount.setErpName(getCellFormatValue(row.getCell(3)).trim());
					trafficcount.setPpCode(getCellFormatValue(row.getCell(4)).trim());
					trafficcount.setCnSiteName(getCellFormatValue(row.getCell(5)).trim());
					trafficcount.setStoreProperty(getCellFormatValue(row.getCell(6)).trim());
					trafficcount.setSupportItem(getCellFormatValue(row.getCell(7)).trim());
					trafficcount.setSupportMode(getCellFormatValue(row.getCell(8)).trim());
					String sales = getCellFormatValue(row.getCell(9)).trim();
					if(StringUtils.isNotBlank(sales)){
						trafficcount.setSales(Double.valueOf(sales));
					}
					trafficcount.setStartDate(getCellFormatValue(row.getCell(10)).trim());
					trafficcount.setEndDate2(getCellFormatValue(row.getCell(11)).trim());
					trafficcount.setAssessmentItem(getCellFormatValue(row.getCell(12)).trim());

					String target = getCellFormatValue(row.getCell(13)).trim();
					if(StringUtils.isNotBlank(target)){
						trafficcount.setTarget(Double.valueOf(target));
					}
					trafficcount.setReturnRatio(getCellFormatValue(row.getCell(14)).trim());
					String returnSales = getCellFormatValue(row.getCell(15)).trim();
					if(StringUtils.isNotBlank(returnSales)){
						trafficcount.setReturnSales(Double.valueOf(returnSales));
					}
					String actualreturnsales = getCellFormatValue(row.getCell(16)).trim();
					if(StringUtils.isNotBlank(actualreturnsales)){
						trafficcount.setReturnSales(Double.valueOf(actualreturnsales));
					}
					trafficcount.setProcessingScheme(getCellFormatValue(row.getCell(17)).trim());
					trafficcount.setRowId(UUIDUtils.generateKey());
					trafficcount.setCheckId(checkId);
					list.add(trafficcount);
					continue;
				}
			}
		}catch (Exception e){
			result = false;
		}
		content.put("result",result);
		content.put("list",list);
		content.put("trafficcount",trafficcount);
		return content;
	}

	/**
	 * 获取单元格数据内容为字符串类型的数据
	 *
	 * @param cell Excel单元格
	 * @return String 单元格数据内容
	 */
	private String getStringCellValue(HSSFCell cell) {
		String strCell = "";
		switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_STRING:
				strCell = cell.getStringCellValue();
				break;
			case HSSFCell.CELL_TYPE_NUMERIC:
				strCell = String.valueOf(cell.getNumericCellValue());
				break;
			case HSSFCell.CELL_TYPE_BOOLEAN:
				strCell = String.valueOf(cell.getBooleanCellValue());
				break;
			case HSSFCell.CELL_TYPE_BLANK:
				strCell = "";
				break;
			default:
				strCell = "";
				break;
		}
		if (strCell.equals("") || strCell == null) {
			return "";
		}
		if (cell == null) {
			return "";
		}
		return strCell;
	}

	/**
	 * 获取单元格数据内容为日期类型的数据
	 *
	 * @param cell
	 *            Excel单元格
	 * @return String 单元格数据内容
	 */
	private String getDateCellValue(HSSFCell cell) {
		String result = "";
		try {
			int cellType = cell.getCellType();
			if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
				Date date = cell.getDateCellValue();
				result = (date.getYear() + 1900) + "-" + (date.getMonth() + 1)
						+ "-" + date.getDate();
			} else if (cellType == HSSFCell.CELL_TYPE_STRING) {
				String date = getStringCellValue(cell);
				result = date.replaceAll("[年月]", "-").replace("日", "").trim();
			} else if (cellType == HSSFCell.CELL_TYPE_BLANK) {
				result = "";
			}
		} catch (Exception e) {
			System.out.println("日期格式不正确!");
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 根据HSSFCell类型设置数据
	 * @param cell
	 * @return
	 */
	private String getCellFormatValue(Cell cell) {
		String cellvalue = "";
		if (cell != null) {
			// 判断当前Cell的Type
			switch (cell.getCellType()) {
				// 如果当前Cell的Type为NUMERIC
				case HSSFCell.CELL_TYPE_NUMERIC:
				case HSSFCell.CELL_TYPE_FORMULA: {
					// 判断当前的cell是否为Date
					if (HSSFDateUtil.isCellDateFormatted(cell)) {
						// 如果是Date类型则，转化为Data格式

						//方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
						//cellvalue = cell.getDateCellValue().toLocaleString();

						//方法2：这样子的data格式是不带带时分秒的：2011-10-12
						Date date = cell.getDateCellValue();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						cellvalue = sdf.format(date);

					}
					// 如果是纯数字
					else {
						// 取得当前Cell的数值
						BigDecimal bd = new BigDecimal(cell.getNumericCellValue());
						cellvalue = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()+"";
					}
					break;
				}
				// 如果当前Cell的Type为STRIN
				case HSSFCell.CELL_TYPE_STRING:
					// 取得当前的Cell字符串
					cellvalue = cell.getRichStringCellValue().getString();
					break;
				// 默认的Cell值
				default:
					cellvalue = " ";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;

	}

}