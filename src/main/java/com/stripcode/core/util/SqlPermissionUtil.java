package com.stripcode.core.util;


import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SqlPermissionUtil {

	public String getPermissionSql(String orginSql) {
		boolean brandFlag0 = false;
		boolean brandFlag1 = false;
		boolean brandFlag2 = false;
		boolean brandFlag3 = false;
		Statement stmt = null;
		// 得到SQL第一个正确的FROM的的插入点
		int index = getAfterFormInsertPoint(orginSql);
		String columnSql = orginSql.substring(0, index);
		try {
			stmt = CCJSqlParserUtil.parse(columnSql);
		} catch (JSQLParserException e) {
			e.printStackTrace();
		}
		Select select = (Select) stmt;
		SelectBody selectBody = select.getSelectBody();
		Map<String,String> map = processSelectBody(selectBody);
		// 是否存在品牌字段
		if(map.containsKey("CUSTOMERID"))brandFlag0 = true;
		if(map.containsKey("CUSTOMER_ID"))brandFlag1 = true;
		if(map.containsKey("BRAND_CODE"))brandFlag2 = true;
		if(map.containsKey("MARKET_ID"))brandFlag3 = true;

		StringBuffer sqlBuffer = new StringBuffer();
		if(brandFlag0||brandFlag1)
		{//需要控制权限
			String positionId = WebUtil.getCurryUserPositionId();
			sqlBuffer.append("select a.* from (");
			sqlBuffer.append(orginSql);
			sqlBuffer.append(")a ");
			sqlBuffer.append("where EXISTS (select t.* from (select b.CUSTOMER_ID,b.BRAND from T_SYS_POSITION A inner join T_SYS_USER_DATA_RIGHT B ");
			sqlBuffer.append("on a.position_id = b.position_id where a.position_id = '");
			sqlBuffer.append(positionId);
			sqlBuffer.append("'and ifnull(b.CUSTOMER_ID,'') !='' union select c.customer_Id,b.BRAND from T_SYS_POSITION A ");
			sqlBuffer.append("inner join T_SYS_USER_DATA_RIGHT B on a.position_id = b.position_id and ifnull(b.branch_company_id,'') !='' ");
			sqlBuffer.append("AND IFNULL(b.CUSTOMER_ID, '') = '' ");
			sqlBuffer.append("inner join T_CS_CUSTOMER_OFFICE_MAPPING C on b.branch_company_id = c.office_Id where a.position_id = '");
			sqlBuffer.append(positionId);
			sqlBuffer.append("'union select c.customer_Id,b.BRAND from T_SYS_POSITION A inner join T_SYS_USER_DATA_RIGHT B ");
			sqlBuffer.append("on a.position_id = b.position_id and ifnull(b.branch_company_id,'')='' inner join T_SYS_BRANCH_OFFICE D ");
			sqlBuffer.append("on b.brand = d.brand inner join T_CS_CUSTOMER_OFFICE_MAPPING C on d.ROW_ID = c.office_Id where a.position_id = '");
			sqlBuffer.append(positionId);
			sqlBuffer.append("')t ");
			if(brandFlag2)
			{
				sqlBuffer.append("where t.brand = a.BRAND_CODE");
				if(brandFlag0)sqlBuffer.append(" and a.customerId = t.CUSTOMER_ID)");
				if(brandFlag1)sqlBuffer.append(" and a.customer_id = t.CUSTOMER_ID)");
			}else
			{
				if(brandFlag0)sqlBuffer.append("where a.customerId = t.CUSTOMER_ID)");
				if(brandFlag1)sqlBuffer.append("where a.customer_id = t.CUSTOMER_ID)");
			}
			return sqlBuffer.toString();
		}else if(!brandFlag0 && !brandFlag1 && !brandFlag2 && brandFlag3)
		{
			String userId = WebUtil.getCurrentUser();
			sqlBuffer.append("select a.* from (");
			sqlBuffer.append(orginSql);
			sqlBuffer.append(")a ");
			sqlBuffer.append("where EXISTS (SELECT c.market_id FROM t_sys_user A INNER JOIN T_SYS_BRANCH_OFFICE B ");
			sqlBuffer.append("ON a.COMP_CODE = b.ROW_ID AND b.del_flag = 'M0015' INNER JOIN T_SYS_BRANCH_OFFICE_MG_SCOPE C ");
			sqlBuffer.append("ON b.row_id = c.BRANCHES_ID AND c.del_flag = 'M0015' where a.user_id = '");
			sqlBuffer.append(userId);
			sqlBuffer.append("' and c.market_id=a.market_id)");
			return sqlBuffer.toString();
		}
		return orginSql;
	}

	public Map<String,String> processSelectBody(SelectBody selectBody) {
		Map<String,String> map = new HashMap<String,String>();
		if (selectBody instanceof PlainSelect) {
			PlainSelect plainSelect = (PlainSelect) selectBody;
			List<SelectItem> selectItems= plainSelect.getSelectItems();
			if(selectItems!=null)
			{
				for(SelectItem item :selectItems)
				{
					if(item instanceof AllColumns)return map;
					if(item instanceof SelectExpressionItem)
					{
						SelectExpressionItem expressionItem= (SelectExpressionItem) item;
						if(expressionItem.getAlias()!=null)
						{
							String mapStr = expressionItem.getAlias().getName().toUpperCase();
							map.put(mapStr, mapStr);
						}else
						{
							if(expressionItem.getExpression() instanceof Column)
							{
								String mapStr = ((Column)expressionItem.getExpression()).getColumnName().toUpperCase();
								map.put(mapStr, mapStr);
							}
						}
					}
				}
			}
		}
		return map;
	}

	/**
	 * 得到SQL第一个正确的FROM的的插入点
	 */
	private int getAfterFormInsertPoint(String querySelect) {
		String regex = "\\s+FROM\\s+";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(querySelect);
		while (matcher.find()) {
			int fromStartIndex = matcher.start(0);
			String text = querySelect.substring(0, fromStartIndex);
			if (isBracketCanPartnership(text)) {
				return fromStartIndex;
			}
		}
		return 0;
	}

	/**
	 * 判断括号"()"是否匹配,并不会判断排列顺序是否正确
	 *
	 * @param text
	 *            要判断的文本
	 * @return 如果匹配返回TRUE,否则返回FALSE
	 */
	private boolean isBracketCanPartnership(String text) {
		if (text == null || getIndexOfCount(text, '(') != getIndexOfCount(text, ')')) {
			return false;
		}
		return true;
	}


	/**
	 * 得到一个字符在另一个字符串中出现的次数
	 *
	 * @param text
	 *            文本
	 * @param ch
	 *            字符
	 */
	private int getIndexOfCount(String text, char ch) {
		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			count = text.charAt(i) == ch ? count + 1 : count;
		}
		return count;
	}
}