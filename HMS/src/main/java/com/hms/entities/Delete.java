package com.hms.entities;

public class Delete {
	
	public static void main(String[] args) {
		
		
		String s="a";
		long n=1000000000000L;
		
		String finalstr="";
        long count=0; 
        long times=n/s.length();
        long remaining=0L;
        if(times<n)
        remaining=n-(times*(s.length()));
        String substring=s.substring(0,(int)(remaining));
    for(int i=0;i<(int)times;i++){
            finalstr=finalstr+s;
    }
finalstr=finalstr+substring;
for(int i=0;i<finalstr.length();i++){
    if(finalstr.charAt(i)=='a'){
        count=count+1;
    }
}
System.out.println(count);
	}

}
