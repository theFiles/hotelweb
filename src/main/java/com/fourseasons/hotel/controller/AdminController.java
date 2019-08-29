package com.fourseasons.hotel.controller;

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
        try {
            // token检测
            return ((TokenService) adminService).ckToken(name, token);
        }
        catch (Exception e){
            return false;
        }
    }

    @GetMapping("/CheckRoot")
    public Result checkRoot(@ModelAttribute("root") boolean root){
        return root?
                Result.success(null):
                Result.root();
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
     * 创建管理员
     * @param user      用户名
     * @param pwd       密码
     * @return          结果对象
     */
    @PostMapping(value = "/Add", params = {"user","pwd"})
    public Result add(String user,String pwd,@ModelAttribute("root") boolean root){
        return root?
                adminService.addAdmin(user,pwd):
                Result.root();
    }

    /**
     * 删除管理员
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
     * @param page          页码
     * @return              结果对象
     */
    @GetMapping("/SearchUsers/{page}")
    public Result searchUsers(
            String search,
            @PathVariable int page,
            @ModelAttribute("root") boolean root
    ){
        return root?
                adminService.getUsers(search,page):
                Result.root();
    }

    /**
     * 获取用户详情
     * @param uid       用户id
     * @return          结果对象
     */
    @GetMapping("/UserInfo")
    public Result userInfo(@RequestParam int uid,@ModelAttribute("root") boolean root){
        return root?
                adminService.getUserInfo(uid):
                Result.root();
    }

    @GetMapping("/SearchAdmin/{page}")
    public Result searchAdmin(
            String search,
            @PathVariable int page,
            @ModelAttribute("root") boolean root
    ){
        return root?
                adminService.getAdmins(search,page):
                Result.root();
    }

}
