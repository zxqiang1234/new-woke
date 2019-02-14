package test.redisTes;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @description:
 * @author: xuqiang
 * @createDate: 2018-10-22 09:47
 **/
public final class RedisPool {

    private static String ADDR = "localhost";
    //Redis的端口号
    private static int PORT = 6379;
    //访问密码
    private static String AUTH = "123456";
    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private static int MAX_ACTIVE = 1024;
    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE = 200;
    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static int MAX_WAIT = 10000;
    private static int TIMEOUT = 10000;
    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;
    private static JedisPool jedisPool = null;
    /**
     * 初始化Redis连接池
     */
    static {
        try { JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(10);
            //连接超时时是否阻塞，false时报异常,ture阻塞直到超时, 默认true
            jedisPoolConfig.setBlockWhenExhausted(true);
            //逐出策略（默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)）
            jedisPoolConfig.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");

            //最大空闲连接数, 默认8个
            jedisPoolConfig.setMaxIdle(8);

            //最大连接数, 默认8个
            jedisPoolConfig.setMaxTotal(8);

            //获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
            jedisPoolConfig.setMaxWaitMillis(-1);

            //逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
            jedisPoolConfig.setMinEvictableIdleTimeMillis(1800000);

            //最小空闲连接数, 默认0
            jedisPoolConfig.setMinIdle(0);

            //每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
            jedisPoolConfig.setNumTestsPerEvictionRun(3);

            //对象空闲多久后逐出, 当空闲时间>该值 且 空闲连接>最大空闲数 时直接逐出,不再根据MinEvictableIdleTimeMillis判断  (默认逐出策略)
            jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(1800000);

            // 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,
            // 默认-1
            jedisPoolConfig.setMaxWaitMillis(100);

            //对拿到的connection进行validateObject校验
            jedisPoolConfig.setTestOnBorrow(true);

            //在进行returnObject对返回的connection进行validateObject校验
            jedisPoolConfig.setTestOnReturn(true);

            //定时对线程池中空闲的链接进行validateObject校验
            jedisPoolConfig.setTestWhileIdle(true);
                         jedisPool = new JedisPool(jedisPoolConfig, ADDR, PORT, TIMEOUT, AUTH);
                     } catch (Exception e) {
                         e.printStackTrace();
                     }
             }
    /**
     * 获取Jedis实例
     * @return
     */
    public synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 释放jedis资源
     * @param jedis
     */
    public static void returnResource(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.close();
        }
    }
}
