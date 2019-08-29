package com.vip.home.mapper;

import com.vip.home.domain.entity.TCompany;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TCompanyMapper {
   List<TCompany> findTCompany ();

   int updateTcompany(

                                  @Param("companyLogo") String companyLogo,
                                  @Param("companyDescribe") String companyDescribe,
                                  @Param("companyAddress") String companyAddress,
                                  @Param("companyHotline") String companyHotline
                                  );
}