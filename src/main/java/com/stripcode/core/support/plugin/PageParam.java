package com.stripcode.core.support.plugin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页实体
 * 
 * @author Metro
 * @date 2014年4月10日 上午11:18:24
 * 
 */
public class PageParam implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 当前页
	 */
	private int pageIndex = 1;
	/**
	 * 每页显示条数
	 */
	private int pageSize = 10;
	/**
	 * 总条数
	 */
	private long totalCount;
	/**
	 * 总页数
	 */
	private long totalPage;
	/**
	 * 页面列表
	 */
	private List<Long> pageSelectList;

	/**
	 * 禁用分页标识
	 */
	private String disableFlag;

	public int getFirstResult() {
		return (pageIndex > 0 ? pageIndex : 1 - 1) * pageSize;
	}

	public String getDisableFlag() {
		return disableFlag;
	}

	public void setDisableFlag(String disableFlag) {
		this.disableFlag = disableFlag;
	}

	public PageParam(int pageIndex, int pageSize, long totalPage) {
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
	}

	public PageParam() {

	}

	/**
	 * 获取分页下拉列表信息
	 * 
	 * @return the orderByClauses
	 */
	public List<Long> getPageSelectList() {
		long disPlayNum = 10;
		pageSelectList = new ArrayList<Long>();
		long firstPage = 1;
		long endPage = disPlayNum;

		// 计算列表起始页码
		if (pageIndex > disPlayNum) {
			firstPage = pageIndex - disPlayNum;
		}

		// 计算列表结束页码
		if (totalPage < disPlayNum) {
			// 总页码少于10页
			endPage = totalPage;
		} else {
			// 总页码大于20页
			if (pageIndex + disPlayNum <= totalPage) {
				if (pageIndex == 1) {
					endPage = disPlayNum;
				} else {
					endPage = pageIndex + disPlayNum;
				}
			} else {
				// 总页码大于10页少于20页
				endPage = totalPage;
			}
		}

		// 构造页码列表
		for (long i = firstPage; i <= endPage; i++) {
			pageSelectList.add(i);
		}

		return pageSelectList;
	}

	/**
	 * 获取pageIndex属性信息
	 * 
	 * @return the pageIndex
	 */
	public int getPageIndex() {
		return pageIndex;
	}

	/**
	 * 设置pageIndex属性信息
	 * 
	 * @param pageIndex
	 *            the pageIndex to set
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * 获取pageSize属性信息
	 * 
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置pageSize属性信息
	 * 
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 获取totalCount属性信息
	 * 
	 * @return the totalCount
	 */
	public long getTotalCount() {
		return totalCount;
	}

	/**
	 * 设置totalCount属性信息
	 * 
	 * @param totalCount
	 *            the totalCount to set
	 */
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * 获取totalPage属性信息
	 * 
	 * @return the totalPage
	 */
	public long getTotalPage() {
		if (0 != pageSize) {
			totalPage = (totalCount + pageSize - 1) / pageSize;
		}
		return totalPage;
	}

}
