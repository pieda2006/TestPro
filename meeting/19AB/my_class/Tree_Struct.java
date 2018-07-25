package javax.servlet;
import javax.servlet.*;
import java.lang.*;

public class Tree_Struct {
 public Tree_Struct next_Topic;
 public Tree_Struct before_Topic;
 public Topic_Struct topic_Info;
 public int deep;
 public int pid;
 
 public Tree_Struct() {
  topic_Info = new Topic_Struct();
  next_Topic = null;
  before_Topic = null;
  deep = 0;
  pid = 0;
 }

 public void set_Next(Tree_Struct next){
  next_Topic = next;
 }

 public void set_Before(Tree_Struct before){
  before_Topic = before;
 }
 public Tree_Struct get_Before(){
  return before_Topic;
 }
 public Tree_Struct get_Next(){
  return next_Topic;
 }
 public void set_Topic(Topic_Struct topic){
  topic_Info.topic_id = topic.topic_id;
  topic_Info.topic_sub_id = topic.topic_sub_id;
  topic_Info.topic_name = topic.topic_name;
  topic_Info.kind_id = topic.kind_id;
  topic_Info.time_limit = topic.time_limit;
  topic_Info.state_id = topic.state_id;
  topic_Info.topic_date = topic.topic_date;
  topic_Info.user_id = topic.user_id;
  topic_Info.topic_delete = topic.topic_delete;
  topic_Info.plan_topic_date = topic.plan_topic_date;
  topic_Info.plan_limit_date = topic.plan_limit_date;
  pid = topic.topic_sub_id;
 }
 public void set_Deep(int i){
  deep = i;
 }
 public int get_Deep(){
  return deep;
 }
 public int getPID(){
  return topic_Info.topic_sub_id;
 }
}
