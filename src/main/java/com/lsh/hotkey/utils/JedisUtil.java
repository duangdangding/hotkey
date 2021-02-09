package com.lsh.hotkey.utils;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import redis.clients.jedis.JedisPoolConfig;

import javax.swing.*;

/**
 * @Author:LuShao
 * @Description:
 * @Date:Created in 15:15 2021/1/10
 * @Modified By:
 */
public class JedisUtil {
    private RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    private JOptionPane dialog = new JOptionPane();
    public JedisUtil() {
        /**
         * 非SpringBoot项目 配置RedisTemplate
         * @return
         */
        JedisConnectionFactory fac = new JedisConnectionFactory(new JedisPoolConfig());
        fac.setPort(6379);
        fac.setHostName("127.0.0.1");
        fac.afterPropertiesSet();
        redisTemplate.setConnectionFactory(fac);
        redisTemplate.afterPropertiesSet();
    }

    /**
     * 实现命令：SET key value，设置一个key-value（将字符串值 value关联到 key）
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        try{
            redisTemplate.opsForValue().set(key, value);
        } catch (Exception e) {
            dialog.showMessageDialog(null,e.getMessage());
        }

    }
    /**
     * 实现命令：GET key，返回 key所关联的字符串值。
     *
     * @param key
     * @return value
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /*public static void main(String[] args) {
        JedisUtil jedisUtil = new JedisUtil();
        ValueOperations<String, Object> ops = jedisUtil.redisTemplate.opsForValue();
        ops.set("abc",123);
        Object abc = ops.get("abc");
        System.out.println(abc);
    }*/
}
