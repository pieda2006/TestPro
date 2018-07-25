package javax.servlet;
import java.sql.*;
import java.io.*;

public class DB_Operation{
	Connection con;
	Statement stmt;
	ResultSet rs;

/*        public static void main(String args[]){
            System.out.println("Hello");
            try {
                Class.forName("org.postgresql.Driver");
                Connection conection = DriverManager.getConnection("jdbc:postgresql:postgres","postgres","postgres");
                Statement s = conection.createStatement();
                s.execute("create table test(colum1 text);");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/


	public DB_Operation() throws Exception{
		Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection("jdbc:postgresql:postgres","postgres","postgres");
		stmt = con.createStatement();
	}
	public void exeQuery(String sql) throws Exception{
		
		
		stmt.execute(sql);
	}
	public void getQuery(String sql) throws Exception{
		
		
		rs = stmt.executeQuery(sql);
	}
	public boolean getNext() throws Exception{
		
		
		return rs.next();
	}
	public String getResult(String name) throws Exception{
		
		
		return rs.getString(name);
	}
	public void closeDB() throws Exception{
			stmt.close();
			con.close();
	}
}
