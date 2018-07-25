package javax.servlet;
import javax.servlet.*;
import java.lang.*;

public class Tree {
 int MAX = 10000;
 Tree_Struct[] sort_Tree = new Tree_Struct[MAX];

 public Tree(){
  int i;
  for(i = 0;i < MAX;i++){
   sort_Tree[i] = new Tree_Struct();
  }
  set_Before(sort_Tree[0],0);
  set_Next(sort_Tree[1],0);
  for(i = 1;i < MAX-1;i++){
   set_Next(sort_Tree[i+1],i);
   set_Before(sort_Tree[i-1],i);
  }
  set_Before(sort_Tree[MAX-2],MAX-1);
  set_Next(sort_Tree[MAX-1],MAX-1);
 }
 public void sort(){
  int i;
  boolean bool = true;

  for(i = 0;true;i++){
   if(i == MAX){
    i = 0;
    if(bool){
     break;
    }
    bool = true;
   }
   if(sort_Tree[i].getPID() != -1 && sort_Tree[i].getPID() != i && sort_Tree[i].pid != sort_Tree[i].get_Before().pid){
   	sort_Tree[i].get_Next().before_Topic = sort_Tree[i].get_Before();
   	sort_Tree[i].get_Before().next_Topic = sort_Tree[i].get_Next();
    set_Next(sort_Tree[sort_Tree[i].getPID()].get_Next(),i);
    set_Before(sort_Tree[sort_Tree[i].getPID()],i);
    set_Next(sort_Tree[i],sort_Tree[i].getPID());
	   sort_Tree[i].get_Next().before_Topic = sort_Tree[i];
    sort_Tree[i].pid = sort_Tree[i].get_Before().pid;
    bool = false;
   }
  }
 }
 public void set_Next(Tree_Struct next,int i){
  sort_Tree[i].set_Next(next);
 }
 public void set_Before(Tree_Struct before,int i){
  sort_Tree[i].set_Before(before);
 }
 public void set_Topic(Topic_Struct topic,int i){
  sort_Tree[i].set_Topic(topic);
 }
 public void set_Deep(){
  int i;
  Tree_Struct tree_deep = null;
  tree_deep = sort_Tree[0];
  while (true){
   if(tree_deep.topic_Info.topic_id == -1){
    break;
   }
   else {
    tree_deep.set_Deep(sort_Tree[tree_deep.getPID()].get_Deep() + 1);
    tree_deep = tree_deep.get_Next();
   }
  }
 }
 public Tree_Struct get_Start_Tree_Struct(){
  return sort_Tree[0];
 }
}
