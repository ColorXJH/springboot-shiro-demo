package com.master.controller;

import com.master.bean.ResultMap;
import com.master.dao.UserDao;
import com.master.util.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;

/**
 * @author ColorXJH
 * @version 1.0
 * @description 用户权限
 * @date 2020/9/24 12:32
 */
@RestController
public class TestController {

    @Autowired
    private ResultMap resultMap;
    @Autowired
    private UserDao dao;

    @RequestMapping("user/getMessage")
    private ResultMap getMessageUser(){
        return resultMap.success().message("你拥有用户权限");
    }

    @RequestMapping("admin/getMessage")
    private ResultMap getMessageAdmin(){
        return resultMap.success().message("你拥有管理员权限");
    }

    @RequestMapping("guest/getMessage")
    private ResultMap getMessageGuest(){
        return resultMap.success().message("你拥有游客权限");
    }
    //一般情况下不适用@RestController,可以直接返回类型为string,协商返回的路径
    //如果需要使用@RestController则需要配合ModelAndView来返回
    @RequestMapping("/myLogin")
    public ModelAndView myLogin()  {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("/noRole")
    public ResultMap noRole(){
        return resultMap.success().message("您没有权限");
    }

    @RequestMapping("/logOut")
    public ResultMap logOut(){
        Subject subject= SecurityUtils.getSubject();
        subject.logout();
        return resultMap.success().message("成功注销");
    }
    //subject.login(token);开始进入realm方法验证权限
    @RequestMapping("/login")
    public ResultMap login(String username,String password){
        /*//创建一个subject
        Subject subject= SecurityUtils.getSubject();
        //在认证提交前准备token（令牌）
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        //执行认证登陆
        subject.login(token);
        //获取权限，指定返回数据
        List<String> roles=dao.getRoles(username);
        for(String r:roles){
            if("user".equals(r)||"admin".equals(r)||"mang".equals(r)){
                return resultMap.success().message("欢迎登陆");
            }else{
                return resultMap.success().message("没有权限："+r);
            }

        }
        return resultMap.error().message("没有权限：");*/


        //use-jwt
        String readpassword=dao.getPasswd(username);
        if(StringUtils.isEmpty(readpassword)){
            return resultMap.error().message("用户名错误");
        }else if(!readpassword.equals(password)){
            return resultMap.error().message("密码错误");
        }else{
            //返回生成的jwt
            return resultMap.success().message(JWTUtil.createToken(username));
        }

    }

    @RequestMapping(path = "/unauthorized/{message}")
    public ResultMap unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
        return resultMap.success().message(message);
    }

}
