package javax.servlet;

public class PriceOperation{
	public String editPrice(String s){
		int strlen,remainder,sol;
		int i,j=0;
		String price="\\";
		char[] pchar = new char[1];
		boolean bool = true;
		strlen = s.length();
		remainder = strlen%3;
		sol = strlen/3;
		for(i=0;i<strlen;i++){
			j++;
			pchar[0] = s.charAt(i);
			price = price.concat(new String(pchar));
			if(j==remainder && bool && sol != 0){
			price = price.concat(",");
			bool = false;
			j=0;
			}
			else if(j==3){
				if(i != strlen-1){
				price = price.concat(",");
				}
				j=0;
			}
		}
		return price;
	}
	public String undoPrice(String s){
		char[] pchar = new char[1];
		int strlen = s.length(),i;
		String price="";
		for(i=0;i<strlen;i++){
			pchar[0] = s.charAt(i);
			if(pchar[0] != ',' && pchar[0] != '\\'){
				price = price.concat(new String(pchar));
			}
		}
		return price;
	}
}