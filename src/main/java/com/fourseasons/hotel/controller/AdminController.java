package com.fourseasons.hotel.controller;

import com.fourseasons.hotel.domain.entity.Admin;
import com.fourseasons.hotel.domain.vo.AdminVo;
import com.fourseasons.hotel.service.AdminService;
import com.fourseasons.hotel.service.TokenService;
import com.fourseasons.hotel.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lidaye
 */
@RestController
@RequestMapping("/Admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    @ModelAttribute("root")
    public boolean ckroot(String name,String token){
        // token检测
        return ((TokenService)adminService).ckToken(name,token);
    }

    @GetMapping("/checkRoot")
    public Result checkRoot(@ModelAttribute("root") boolean root){
        return root?
                Result.success(null):
                Result.error();
    }

    /**
     * 登录
     * @param name      用户名
     * @param pwd       密码
     * @return          Result结果对象
     */
    @GetMapping(value = "/Login",params = {"name","pwd"})
    public Result login(String name, String pwd){
        return adminService.login(name,pwd);
    }

    /**
     * 登出
     * @return          Result结果对象
     */
    @GetMapping("/Logout")
    public Result logout(@RequestParam int id){
        return adminService.logout(id);
    }

    /**
     * 添加
     * @param admin     管理员对象
     * @return          Result结果对象
     */
    @GetMapping("/Add")
    public Result add(@RequestParam Admin admin){
        return adminService.addAdmin(admin);
    }

    /**
     *
     * @param id        管理员id
     * @return          Result结果对象
     */
    @GetMapping("/Del")
    public Result del(@RequestParam int id){
        return adminService.delAdmin(id);
    }

    /**
     * 查看用户列表
     * @param search        查询关键字
     * @param page
     * @return
     */
    @GetMapping("/SearchUsers/{page}/{search}")
    public Result searchUsers(
            @PathVariable String search,
            @PathVariable int page,
            @ModelAttribute("root") boolean root
    ){
        return root?
                adminService.getUsers(search,page):
                Result.loss();
    }

}
