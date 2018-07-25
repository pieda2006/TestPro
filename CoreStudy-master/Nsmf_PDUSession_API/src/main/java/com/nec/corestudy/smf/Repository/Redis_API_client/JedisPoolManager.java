package com.nec.corestudy.smf.Repository.Redis_API_client;

import com.nec.corestudy.smf.Service.NFInfo_Mng.NFInfo_Mng;

import redis.clients.jedis.*;


public class JedisPoolManager
{
  private static JedisPoolManager instance = new JedisPoolManager();
  private JedisPool pool;

  private JedisPoolManager(){

    JedisPoolConfig config = new JedisPoolConfig();
    NFInfo_Mng nfinfo = NFInfo_Mng.getInstance();

//    config.setMaxTotal(4);
//    config.setMaxWaitMillis(1000);

    pool = new JedisPool(config,
                         nfinfo.GetRedisHost(),
                         Integer.parseInt(nfinfo.GetRedisPort()));
  }

  public Jedis getJedisObj(){
    Jedis jedis = pool.getResource();
    return jedis;
  }

  public void returnJedisObj(Jedis jedis){
    pool.returnResource(jedis);
    return;
  }

  public static JedisPoolManager getInstance(){
    return instance;
  }
}
