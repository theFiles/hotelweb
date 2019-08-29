package com.vip.home.controller;


import com.vip.home.domain.entity.TCompany;
import com.vip.home.service.UpdateService;
import com.vip.home.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UpdateController {
    @Resource
    UpdateService updateService;

    @RequestMapping("/update")
//    public Result<List<TCompany>> update(String companyLogo,
//                                         String companyDescribe,
//                                         String companyAddress,
//                                         String companyHotline){
//        try{
//            List<TCompany> update = updateService.update(companyLogo, companyDescribe, companyAddress, companyHotline);
//            return Result.success(update);
//        }catch (Exception e){
//            return Result.error();
//        }
//    }
    public Result updateTcompany(String companyLogo,
                                 String companyDescribe,
                                 String companyAddress,
                                 String companyHotline){
        int update = updateService.update(companyLogo, companyDescribe, companyAddress, companyHotline);
        return update>0?
                Result.success(update):
                Result.error();
    }
}
