package edu.gdut.togethertime.utils;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RedisUtils {
    private static final JedisPool REDIS_POOL;

    static {
        REDIS_POOL = new JedisPool(new JedisPoolConfig(), "localhost");
    }

    public static <T> T invoke(Class clz, String methodName, Object... object) {
        T result = null;
        try {
            Method method = clz.getDeclaredMethod(methodName);
            result = (T) method.invoke(REDIS_POOL, object);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }
}
