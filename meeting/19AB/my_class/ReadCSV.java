package javax.servlet;
import java.io.*;

public class ReadCSV{
	BufferedReader in;
	public ReadCSV(String filename) throws Exception{//filename 
		in = new BufferedReader(new FileReader(filename));
	}
	public String readString() throws Exception{
		return in.readLine();
	}
	public void readClose() throws Exception{
		in.close();
	}
}
