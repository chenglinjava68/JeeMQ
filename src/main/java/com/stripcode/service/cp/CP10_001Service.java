/**
 * 
 */
package com.stripcode.service.cp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.DataUtil;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.core.util.excelUtil.ExportExcel;
import com.stripcode.mybatis.cp.dao.CpMarketInfoMapper;
import com.stripcode.mybatis.cp.model.CpMarketInfo;
import com.stripcode.mybatis.cs.model.CSCustomerInfo;
import com.stripcode.service.BaseService;
import com.stripcode.service.user.RscSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "CP10_001Service")
public class CP10_001Service extends BaseService {
	@Autowired
    private CpMarketInfoMapper cpMarketInfoMapper;

	@Autowired
	private RscSysUserService rscSysUserService;

	public PageInfo<CpMarketInfo> queryForPage(Map<String, Object> params) {
		PageSortUtil.unoinSortBySord(params);
		PageHelper.startPage(params);
		return new PageInfo<CpMarketInfo>( cpMarketInfoMapper.queryForPage(params));
	}

	public List<CpMarketInfo> selectCpMInfoForID(String customerId) {
		return cpMarketInfoMapper.selectCpMInfoForID(customerId);
	}

	public List<CpMarketInfo> selectCpMarket(String marketId){
		if("".equals(marketId)||marketId==null){
			marketId = "86";
		}
		return cpMarketInfoMapper.selectCpMarket(marketId);
	}

	public PageInfo<CSCustomerInfo> queryCustomerByMarketForPage(Map<String,Object> map){
		PageHelper.startPage(map);
		return new PageInfo<CSCustomerInfo>(cpMarketInfoMapper.queryCustomerByMarketForPage(map));
	}

	public void exportMarket(Map<String,Object> params, HttpServletRequest request, HttpServletResponse response){
		/*List<ExcelHeader<CpMarketInfo>> headers = new ArrayList<ExcelHeader<CpMarketInfo>>();
		headers.add(new ExcelHeader<CpMarketInfo>("编码","marketId"));
		headers.add(new ExcelHeader<CpMarketInfo>("名称","marketName"));
		headers.add(new ExcelHeader<CpMarketInfo>("国家","country"));
		headers.add(new ExcelHeader<CpMarketInfo>("区域","region"));
		headers.add(new ExcelHeader<CpMarketInfo>("省份","province"));
		headers.add(new ExcelHeader<CpMarketInfo>("城市","city"));
		headers.add(new ExcelHeader<CpMarketInfo>("区县","district"));
		headers.add(new ExcelHeader<CpMarketInfo>("街道","street"));
		headers.add(new ExcelHeader<CpMarketInfo>("品牌","brandNumber"));
		headers.add(new ExcelHeader<CpMarketInfo>("授权客户","customerNumber"));
		headers.add(new ExcelHeader<CpMarketInfo>("已开店","openStoreNumber"));
		RscSysUser creator = rscSysUserService.queryById(WebUtil.getCurrentUser());
		List<CpMarketInfo> data = cpMarketInfoMapper.selectForExport(params);
		new ExcelExporter(request,response).export(new ExcelDocument<CpMarketInfo>(5000,"全部市场信息",creator == null ? "" : creator.getUserName(),headers,data));*/

		try {
			Page<CpMarketInfo> page = cpMarketInfoMapper.queryForPage(params);
			String fileName = "市场管理"+ DataUtil.getDate("yyyyMMddHHmmss")+".xlsx";
			List<CpMarketInfo> data = page.getResult();
			new ExportExcel("市场管理", CpMarketInfo.class).setDataList(data).write(response, fileName).dispose();
		} catch (Exception e) {

		}
	}
}
