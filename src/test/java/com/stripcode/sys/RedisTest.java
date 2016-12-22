package com.stripcode.sys;

import com.stripcode.core.util.JedisUtil;
import com.stripcode.core.util.RedisNewUtil;
import com.stripcode.core.util.RedisUtil;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/7/22.
 */
public class RedisTest {
    public static void main(String[] args){
        //连接redis
        Jedis jedis = new Jedis("127.0.0.1",6379);

        //简单的key-value 存储
        RedisNewUtil.set("redis","jeemq");
        System.out.println(RedisNewUtil.get("redis"));

        //在原有值得基础上添加,如若之前没有该key，则导入该key
        //之前已经设定了 redis 对应" jeemq ",此句执行便会使 redis 对应" stripcode "
        JedisUtil.append("redis","soft");

        // mset  是设置多个key-value值   参数（key1,value1,key2,value2,..., keyn , valuen ）
        // mget  是获取多个key所对应的value值  参数（key1,key2,key3,..., keyn ）  返回的是个list
        jedis.mset( "name1" , "yangw" , "name2" , "demon" , "name3" , "elena" );
        System. out .println(jedis.mget( "name1" , "name2" , "name3" ));

        Map<String,String> user = new HashMap<String,String>();
        user.put("name","cd");
        user.put("passward","123456");
        //map存入redis
        RedisUtil.hmset("user",user);
        // mapkey 个数
        System. out .println(String. format ( "len:%d" , RedisUtil.hlen( "user" )));
        //map中的所有键值
        System.out.println(String. format ( "values: %s" , RedisUtil.hvals( "user" ) ));

        //取出map中的name字段值
        List<String> rsmap = RedisUtil.hmget("user","name","passward");
        System.out.println(rsmap);

        //删除map中的某一个键值 password
        RedisUtil.hdel("user","password");
        System. out .println(jedis.hmget( "user" ,  "name" ,  "password" ));

        //list
        jedis.del( "listDemo" );
        System. out .println(jedis.lrange( "listDemo" , 0, -1));
        jedis.lpush( "listDemo" ,  "A" );
        jedis.lpush( "listDemo" ,  "B" );
        jedis.lpush( "listDemo" ,  "C" );
        System. out .println(jedis.lrange( "listDemo" , 0, -1));
        System. out .println(jedis.lrange( "listDemo" , 0, 1));

        //list 同上
        RedisUtil.del( "listDemo" );
        System. out .println(RedisUtil.lrange( "listDemo" , 0, -1));
        RedisUtil.lpush( "listDemo" ,  "A" );
        RedisUtil.lpush( "listDemo" ,  "B" );
        RedisUtil.lpush( "listDemo" ,  "C" );
        System. out .println(RedisUtil.lrange( "listDemo" , 0, -1));
        System. out .println(RedisUtil.lrange( "listDemo" , 0, 1));

        //set
        jedis.sadd( "sname" ,  "wobby" );
        jedis.sadd( "sname" ,  "kings" );
        jedis.sadd( "sname" ,  "demon" );
        System. out .println(String. format ( "set num: %d" , jedis.scard( "sname" )));
        System. out .println(String. format ( "all members: %s" , jedis.smembers( "sname" )));
        System. out .println(String. format ( "is member: %B" , jedis.sismember( "sname" ,  "wobby" )));
        System. out .println(String. format ( "rand member: %s" , jedis.srandmember( "sname" )));

        //set  同上
        RedisUtil.sadd( "sname" ,  "wobby" );
        RedisUtil.sadd( "sname" ,  "kings" );
        RedisUtil.sadd( "sname" ,  "demon" );
        System. out .println(String. format ( "set num: %d" , RedisUtil.scard( "sname" )));
        System. out .println(String. format ( "all members: %s" , RedisUtil.smembers( "sname" )));
        System. out .println(String. format ( "is member: %B" , RedisUtil.sismember( "sname" ,  "wobby" )));
        System. out .println(String. format ( "rand member: %s" , RedisUtil.srandmember( "sname" )));

        //删除一个对象
        RedisUtil.srem( "sname" ,  "demon" );
        System. out .println(String. format ( "all members: %s" , RedisUtil.smembers( "sname" )));


    }
}
