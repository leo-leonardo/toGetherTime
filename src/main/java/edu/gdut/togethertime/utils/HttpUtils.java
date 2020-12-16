package edu.gdut.togethertime.utils;

import edu.gdut.togethertime.exception.ExceptionEnum;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class HttpUtils {
    private static final HttpClient CLIENT = HttpClients.createDefault();
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtils.class);

    public static String get(String url) {
        HttpGet httpGet = new HttpGet(url);
        return response(httpGet, 0);
    }

    public static String post(String url, String data) {
        StringEntity entity = new StringEntity(data, "utf-8");
        entity.setContentEncoding("utf-8");
        entity.setContentType("application/json");
        HttpPost post = new HttpPost(url);
        post.setEntity(entity);
        return response(post, 0);
    }

    private static String response(HttpUriRequest request, int times) {
        try {
            times ++;
            if (times >=3) throw ExceptionEnum.exception(ExceptionEnum.REQUEST_ERROR);
            HttpResponse response = CLIENT.execute(request);
            if (!(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK)) {
                throw ExceptionEnum.exception(ExceptionEnum.REQUEST_ERROR);
            }
            return EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.info("第" + (times + 1)  + "次请求失败！重试");
        return response(request, times + 1);
    }

    public static String concatUrl(String url, Map<String, Object> paramMap) {
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(url).append("?");
        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            urlBuilder.append(URLEncoder.encode(entry.getKey()) + "=" + URLEncoder.encode((String) entry.getValue())).append("&");
        }
        return urlBuilder.toString();
    }
}
