package com.ming.demo.web.admin;

import com.ming.demo.bean.Audience;
import com.ming.demo.bean.Result;
import com.ming.demo.service.admin.AdminServer;
import com.ming.demo.utils.JwtTokenUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 后台管理系统 控制器
@RestController
@RequestMapping("/admin")
@Api(tags = "后台管理系统控制器")
public class AdminController {
    @Autowired
    private AdminServer adminServer;

    @Autowired
    private Audience audience;


    // 登录
    @RequestMapping("/login")
    public Result login(String name, String password, HttpServletResponse response){
        // 进行相关的登录
        if(adminServer.login(name, password)){
            // 颁发jwt
            String userId = adminServer.getId(name);
            String role = "admin";
            // 创建Token
            String token = JwtTokenUtil.createJWT(userId,name,role, audience);
            System.out.println("登录成功 " + token);
            response.setHeader(JwtTokenUtil.AUTH_HEADER_KEY, JwtTokenUtil.TOKEN_PREFIX + token);
            Result result = new Result();
            result.setMsg(token);
            return result;
        }else{
            Result result = new Result();
            result.setMsg("error");
            return result;
        }
    }

}
