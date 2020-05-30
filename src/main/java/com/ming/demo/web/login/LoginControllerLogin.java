package com.ming.demo.web.login;

import com.ming.demo.bean.Audience;
import com.ming.demo.bean.Result;
import com.ming.demo.model.User;
import com.ming.demo.service.login.LoginService;
import com.ming.demo.utils.JwtTokenUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

// 登录
@RestController
@RequestMapping("/login")
@Api(tags = "登录")
public class LoginControllerLogin {

    @Autowired
    private LoginService loginService;

    @Autowired
    private Audience audience;


    // 正常登陆
    @RequestMapping("/loginControllerOld")
    public Result loginController(HttpServletResponse response, String username, String password){
        // 进行登录
        Boolean res = loginService.login(username, password);
        if(res){
            String userId = loginService.getLonginId(username);
            String role = "admin";
            // 创建Token
            String token = JwtTokenUtil.createJWT(userId, username, role, audience);
            System.out.println("登陆成功" + token);
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

    // 微信小程序登录
    @RequestMapping("/weichatwxLogin")
    public Result weichatwxLogin(HttpServletResponse response, String code){
        System.out.println(code);
        // 这里关系对应如下  openid-username     session_key-password
        User weixinxiaocengxudengnu = loginService.login(code);
        if(weixinxiaocengxudengnu != null){
            // 已经登录成功，返回JWT。
            String userId = weixinxiaocengxudengnu.getId() + "";
            String token = JwtTokenUtil.createJWT(userId, weixinxiaocengxudengnu.getName(), "admin", audience);
            System.out.println("登陆成功" + token);
            response.setHeader(JwtTokenUtil.AUTH_HEADER_KEY, JwtTokenUtil.TOKEN_PREFIX + token);
        }
        Result result = new Result();
        result.setMsg(code);
        return result;
    }

    @RequestMapping("/test")
    public void test(){
        System.out.println(audience.getBase64Secret());
        try {
            System.out.println(JwtTokenUtil.parseJWT(JwtTokenUtil.createJWT("ming", "ming","ming", audience), audience.getBase64Secret()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
