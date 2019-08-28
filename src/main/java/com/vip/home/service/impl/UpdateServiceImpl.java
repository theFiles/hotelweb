package com.vip.home.service.impl;

import com.vip.home.domain.entity.TCompany;
import com.vip.home.mapper.TCompanyMapper;
import com.vip.home.service.UpdateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UpdateServiceImpl implements UpdateService {
    @Resource
    TCompanyMapper tCompanyMapper;

    @Override
    public int update(String companyLogo, String companyDescribe, String companyAddress, String companyHotline) {
        return tCompanyMapper.updateTcompany(companyLogo,  companyDescribe,  companyAddress,  companyHotline);
    }
}
