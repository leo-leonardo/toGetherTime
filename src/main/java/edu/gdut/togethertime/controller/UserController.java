package edu.gdut.togethertime.controller;

import edu.gdut.togethertime.model.dto.UserDTO;
import edu.gdut.togethertime.model.entity.User;
import edu.gdut.togethertime.model.query.WxProgramLoginQuery;
import edu.gdut.togethertime.service.UserService;
import edu.gdut.togethertime.utils.Result;
import edu.gdut.togethertime.utils.ResultFactory;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @ApiOperation(value = "登录接口,将wx.login的信息封装给我")
    @PostMapping("login")
    public Result<UserDTO> login(@RequestBody WxProgramLoginQuery query) {
        System.out.println(query);
        User loginUser = userService.login(query);
        UserDTO userDTO = UserDTO.castToDTO(loginUser);
        //登录完毕
        return ResultFactory.success(userDTO);
    }
}
