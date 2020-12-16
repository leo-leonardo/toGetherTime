package edu.gdut.togethertime.model.query;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

public class WxProgramLoginQuery {
    @ApiModelProperty(value = "用户名，通过wx.login取得的名字", required = true)
    private String username;
    @ApiModelProperty(value = "加密的用户信息", required = true)
    @NotEmpty(message = "encryptedData不能为空")
    private String encryptedData;
    @ApiModelProperty(value = "加密算法初始向量", required = true)
    @NotEmpty(message = "iv不能为空")
    private String iv;
    @ApiModelProperty(value = "用户登录凭证", required = true)
    @NotEmpty(message = "code不能为空")
    private String code;

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "WxProgramLoginQuery{" +
                "username='" + username + '\'' +
                ", encryptedData='" + encryptedData + '\'' +
                ", iv='" + iv + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
