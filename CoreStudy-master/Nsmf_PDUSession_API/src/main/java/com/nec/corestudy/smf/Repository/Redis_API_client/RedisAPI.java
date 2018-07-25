package com.nec.corestudy.smf.Repository.Redis_API_client;

import redis.clients.jedis.*;


public class RedisAPI {

  private JedisPoolManager pool_mng;

  public RedisAPI() {
    pool_mng = JedisPoolManager.getInstance();
  }

  public void Set(String key, String value) {

    Jedis jedis = pool_mng.getJedisObj();

    String status_code = jedis.set(key, value);
    if(!status_code.equals("OK")){
      System.err.println("Redis Set Error: " + status_code);
    }

    pool_mng.returnJedisObj(jedis);
    return;
  }

  public String Get(String key) {

    Jedis jedis = pool_mng.getJedisObj();

    String value = jedis.get(key);
    if(null == value){
      System.err.println("Redis Get Error key: " + key);
    }

    pool_mng.returnJedisObj(jedis);
    return value;
  }

  public void Del(String key) {

    Jedis jedis = pool_mng.getJedisObj();

    Long delnum = jedis.del(key);
    if(0 == delnum){
      System.err.println("Redis Del Error key: " + key);
    }

    pool_mng.returnJedisObj(jedis);
    return;
  }

}

