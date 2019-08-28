package com.vip.home.service;

import com.vip.home.domain.entity.TCompany;

import java.util.List;

public interface UpdateService {
    int update(  String companyLogo,
                            String companyDescribe,
                            String companyAddress,
                            String companyHotline);
}
