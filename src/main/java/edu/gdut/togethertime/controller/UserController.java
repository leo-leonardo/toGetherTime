package edu.gdut.togethertime.controller;

import com.alibaba.fastjson.JSONObject;
import edu.gdut.togethertime.constant.WxConstant;
import edu.gdut.togethertime.model.dto.UserDTO;
import edu.gdut.togethertime.model.entity.User;
import edu.gdut.togethertime.model.query.WxProgramLoginQuery;
import edu.gdut.togethertime.service.LoginService;
import edu.gdut.togethertime.utils.HttpUtils;
import edu.gdut.togethertime.utils.Result;
import edu.gdut.togethertime.utils.ResultFactory;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private LoginService loginService;

    @ResponseBody
    @ApiOperation(value = "登录接口,将wx.login的信息封装给我")
    @PostMapping("login")
    public Result<UserDTO> login(@RequestBody WxProgramLoginQuery query) {
        User loginUser = loginService.login(query);
        UserDTO userDTO = UserDTO.castToDTO(loginUser);
        //登录完毕
        return ResultFactory.success(userDTO);
    }
}
