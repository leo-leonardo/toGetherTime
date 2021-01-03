package edu.gdut.togethertime.constant;

/**
 * 微信接口使用的信息
 *
 * @author Leonardo
 */
public class WxConstant {

    /**
     * 以下为登录及获取AccessToken的接口
     */
    public static final String LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    /**
     * 以下为：
     * 创建二维码接口
     * 用户unionId信息接口
     */
    public static final String QR_CODE_URL = "https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token=%s";
    public static final String USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN";

    /**
     * AppId与秘钥，上传时注意不要泄露
     */
    public static final String APPID = "";
    public static final String APP_SECRET = "";

}
