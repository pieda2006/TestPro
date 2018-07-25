package javax.servlet;
import java.io.*;

public class WriteCSV{
	BufferedWriter out;
	public WriteCSV(String filename) throws Exception{
		out = new BufferedWriter(new FileWriter(filename));
	}

	public void writeString(String input) throws Exception{
		out.write(input);
		out.newLine();
	}

	public void writeClose() throws Exception{
		out.flush();
		out.close();
	}
}
