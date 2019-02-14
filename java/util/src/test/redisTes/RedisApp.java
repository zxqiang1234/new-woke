package test.redisTes;

import redis.clients.jedis.Jedis;

/**
 * @description:
 * @author: xuqiang
 * @createDate: 2018-10-22 09:46
 **/
public class RedisApp {

    public static void main( String[] args )
    {
//        //JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxTotal(10);
//        final JedisPool localhost = new JedisPool(jedisPoolConfig, "localhost");
//        System.out.println("连接池初始化成功");

//        Jedis jedis = new Jedis("localhost");
//        System.out.println("连接成功");
//        //查看服务是否运行
//        System.out.println("服务正在运行: "+jedis.ping());
//        jedis.set("runoobkey", "www.runoob.com");
//        // 获取存储的数据并输出
//        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
//
//        Jedis jedis = new Jedis("localhost");
//        System.out.println("连接成功");
//        jedis.set("username", "我是你爸爸");
//        jedis.set("usernaem","我是你哥哥");
        //存储数据到列表中
//        jedis.lpush("site-list", "Runoob");
//        jedis.lpush("site-list", "Google");
//        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
//        List<String> list = jedis.get("position");
//        for(int i=0; i<list.size(); i++) {
//            System.out.println("列表项为: "+list.get(i));
//        }
//        System.out.println("redis 存储的字符串为: "+ jedis.get("position"));
//    }
        insert("username", "xiaoming1");
        System.out.println(get("username"));
        delete("username");
        System.out.println(get("username"));
    }
    static void insert(String key, String value){
        Jedis jedis = RedisPool.getJedis();
        jedis.set(key, value);
    }
    static void delete(String key){
        Jedis jedis = RedisPool.getJedis();
        jedis.del(key);
    }
    static String get(String key){
        Jedis jedis = RedisPool.getJedis();
        return jedis.get(key);
    }


}
