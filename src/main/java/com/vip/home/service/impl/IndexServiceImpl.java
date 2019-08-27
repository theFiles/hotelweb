package com.vip.home.service.impl;

import com.vip.home.domain.entity.TCompany;
import com.vip.home.domain.vo.TRoomTypeVo;
import com.vip.home.mapper.TCompanyMapper;
import com.vip.home.mapper.TRoomTypeMapper;
import com.vip.home.service.IndexService;
import com.vip.home.utils.HomePage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Service("indexService")
public class IndexServiceImpl implements IndexService {
    @Resource
    TCompanyMapper tCompanyMapper;
    @Resource
    TRoomTypeMapper tRoomTypeMapper;


    @Override
    public HomePage getHomePage() {
        HomePage homePage = new HomePage();
        List<TCompany> tCompany = tCompanyMapper.findTCompany();


        homePage.setTCompanies(tCompany);
        return homePage;
    }

    @Override
    public List<TRoomTypeVo> getContent() {
        List<TRoomTypeVo> all = tRoomTypeMapper.findAll();
        return  all;
    }


}
