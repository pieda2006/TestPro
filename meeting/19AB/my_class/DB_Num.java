package javax.servlet;
import javax.servlet.*;
import java.lang.*;
public class DB_Num {
	final int max = 999999;
	int[] no = new int[max];

	DB_Operation db;
	String sql = "select no from input;";
	
	public DB_Num() throws Exception{
		db = new DB_Operation();
	}
	public void set_Table(String table){
		sql = "select no from " + table + ";";
	}
	public void numGet() throws Exception{
		int i;
		for(i=0;i<max;i++){
			no[i] = 0;
		}
		db.getQuery(sql);
		while(db.getNext()){
			no[Integer.parseInt(db.getResult("no"))] = 1;
		}
	}
	public boolean numBool(int n){
		if(no[n] == 1){
			return false;
		}
		else {
			return true;
		}
	}
}
