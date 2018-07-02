package controllers;

//import java.sql.ResultSet;
import redis.clients.jedis.Jedis;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

public class RedisManager {

    private static RedisManager myinstance = null;

    private String hostname = "test-redis";
    private Jedis jedis = null;

    public static RedisManager getInstance(){
        if(myinstance == null){
            myinstance = new RedisManager();
        }
        return myinstance;
    }

    public RedisManager() {
        jedis = new Jedis(hostname);
    }

    public String getData(String key){
        return jedis.get(key);
    }
    public void setData(String key, String value){
        jedis.set(key, value);
        return;
    }
    public void delData(String key){
        jedis.del(key);
        return;
    }
}
