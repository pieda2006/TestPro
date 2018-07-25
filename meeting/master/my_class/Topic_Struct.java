package javax.servlet;
import javax.servlet.*;
import java.lang.*;

public class Topic_Struct {
 public int topic_id;
 public int topic_sub_id;
 public String topic_name;
 public int kind_id;
 public String time_limit;
 public int state_id;
 public String topic_date;
 public String user_id;
 public String topic_delete;
 public String plan_topic_date;
 public String plan_limit_date;

 public Topic_Struct(){
  topic_id = -1;
  topic_sub_id = -1;
  topic_name = null;
  kind_id = -1;
  time_limit = null;
  state_id = -1;
  topic_date = null;
  user_id = null;
  topic_delete = null;
  plan_topic_date = null;
  plan_limit_date = null;
 }
}
