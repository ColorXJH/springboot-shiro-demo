package com.master.bean;

import com.master.dao.UserDao;
import com.master.util.JWTUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

/**
 * @author ColorXJH
 * @version 1.0
 * @description 自定义realm
 * @date 2020/9/24 14:10
 */

public class CustomRealm  extends AuthorizingRealm {
    Logger log= LoggerFactory.getLogger(CustomRealm.class);
    @Autowired
    private UserDao dao;


    /**  add-use-jwt
     * 必须重写此方法，不然会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }


    //2
    /**
     * 获取授权信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("-------------角色权限认证-------------");
        /*String username= (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info =new SimpleAuthorizationInfo ();
        //获得该用户角色
        List<String> roles=dao.getRoles(username);
        //获得该用户权限
        List<String>permissions=dao.getPermissions(username);
        info.setRoles(new HashSet<>(roles));
        info.setStringPermissions(new HashSet<>(permissions));
        return info;*/

        /*
         *注释掉上方方法使用jwt
         */

        String username=JWTUtil.getUsername(principalCollection.toString());
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //获得该用户角色
        List<String> role=dao.getRoles(username);
        //获取权限
        List<String>permission=dao.getPermissions(username);
        info.setRoles(new HashSet<>(role));
        info.setStringPermissions(new HashSet<>(permission));
        return info;
    }

    //1
    /**
     * 获取身份验证信息
     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     *
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("-----------身份认证------------");
        /*UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        //从数据库获取对应用户名密码的用户
        String password=dao.getPasswd(token.getUsername());
        if(StringUtils.isEmpty(password)){
            log.info("用户名不正确");
            throw new AccountException("用户名不正确");
        }else if(!password.equals(new String((char[]) token.getCredentials()))){
            log.info("密码不正确");
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(token.getPrincipal(),password,getName());
        */

        /*
         *注释掉上方方法使用jwt
         */
        String token=(String)authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username= JWTUtil.getUsername(token);
        if (username == null || !JWTUtil.verify(token, username)) {
            throw new AuthenticationException("token认证失败！");
        }
        String password = dao.getPasswd(username);
        if (password == null) {
            throw new AuthenticationException("该用户不存在！");
        }
        return new SimpleAuthenticationInfo(token, token, "MyRealm");

    }
}
