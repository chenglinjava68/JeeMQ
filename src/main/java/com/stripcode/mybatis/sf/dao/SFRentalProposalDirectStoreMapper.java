package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFEstInvestmentDetailDiretStore;
import com.stripcode.mybatis.sf.model.SFRentalDetail;
import com.stripcode.mybatis.sf.model.SFRentalProposalDirectStore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Metro on 2016/11/10.
 */
public interface SFRentalProposalDirectStoreMapper {
    //添加租金信息
    Integer insertRenStore(SFRentalProposalDirectStore sfRentalProposalDirectStore);
    //修改租金信息
    Integer updateRenStore(SFRentalProposalDirectStore sfRentalProposalDirectStore);
    //是否存在
    Integer isExistsRenStore(@Param("ppId") String ppId,@Param("rowId") String rowId);
    //查询租金信息
    SFRentalProposalDirectStore selectRenStoreAll(String ppId);
    //直营店相关信息查询
    SFEstInvestmentDetailDiretStore selectForDirect(String ppId);
    //查询租赁期年份信息
    List<SFRentalDetail> selectRentalDetailAll(String ppId);
    //修改租赁期年份信息
    Integer updateRentalDetail(SFRentalDetail sfRentalDetail);
    //添加租赁期年份信息
    Integer insertRentalDetail(SFRentalDetail sfRentalDetail);
    //是否存在
    Integer isExistsRentalDetail(@Param("rowId")String rowId,@Param("rentId")String rentId);
    //删除年份信息
    Integer deleteRentalDetail(String rentId);

}
