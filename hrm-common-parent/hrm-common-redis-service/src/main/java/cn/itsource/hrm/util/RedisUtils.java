package cn.itsource.hrm.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description: TODO
 * @Date: 2019/12/27 18:08
 * @Author: yjz
 * @Version 1.0
 **/
@Component
@Scope("singleton")
public class RedisUtils {
    private String host = "127.0.0.1";
    private Integer port = 6379;
    private String password = "itsource";
    private Integer maxIdle = 1;
    private Integer maxTotal = 11;
    private Long maxWaitMillis = 10 * 1000L;
    private boolean testOnBorrow = true;
    private JedisPool jedisPool = null;

    public RedisUtils() {
        //1 创建连接池配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        //2 进行配置-四个配置
        config.setMaxIdle(maxIdle);//最小连接数
        config.setMaxTotal(maxTotal);//最大连接数
        config.setMaxWaitMillis(maxWaitMillis);//最长等待时间
        config.setTestOnBorrow(testOnBorrow);//测试连接时是否畅通
        //3 通过配置对象创建连接池对象
        jedisPool = new JedisPool(config, host, port, maxWaitMillis.intValue(), password);
    }

    //获取连接
    public Jedis getSource() {
        return jedisPool.getResource();
    }

    //关闭连接
    public void jedisClose(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    /**
     * 设置字符
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        Jedis jedis = getSource();
        jedis.set(key, value);
        jedisClose(jedis);

    }

    /**
     * 设置字符
     *
     * @param key
     * @param value
     */
    public void set(byte[] key, byte[] value) {
        Jedis jedis = getSource();
        jedis.set(key, value);
        jedisClose(jedis);
    }

    /**
     *
     * @param key
     * @return
     */
    public byte[] get(byte[] key) {
        Jedis jedis = getSource();
        try {
            return jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedisClose(jedis);
        }
        return null;
    }

    /**
     *
     * @param key
     * @return
     */
    public String get(String key) {
        Jedis jedis = getSource();
        try {
            return jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedisClose(jedis);
        }
        return null;
    }
}
