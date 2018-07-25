package javax.servlet;

public class Day_Operation{
	public String editDate(String s){
		return s.replace('-','/');
	}
	public String undoDate(String s){
		return s.replace('/','-');
	}
}