package com.packageMatching.ravindra;

public class KMP {

	 public static void main(String args[])
	 {
	     String txt = "ABABDABACDABABCABAB";
	     String pat = "ABABCABAB";
	     int end = KMPSearch(pat,txt);
	     System.out.println(txt.substring(txt.length()-pat.length(), end+1));
	 }
	 
	 public static int KMPSearch(String pat, String txt){
		 
		 if(pat.length()>txt.length()){
			 return -1;
		 }
		 int[] longestProperPrefix = new int[pat.length()];
		 
		 buildPrefixArray(longestProperPrefix,pat);
		 
		 int i =0; int j=0;
		 while(i<txt.length()){
			 
			 if(j<longestProperPrefix.length && txt.charAt(i) == pat.charAt(j)){
				 i++;
				 j++;
			 }else{
				 if(j!=0){
					 j = longestProperPrefix[j-1];
				 }else{
					 i++;
				 }
				 
			 }
			 
			 if(j==longestProperPrefix.length){
				 break;
			 }
		 }
		 
		 return i-1;
	 }
	 
	 public static void buildPrefixArray(int[] lps,String pat){
		 
		 int j=0; int i=1;
		 lps[0] =0;
		 
		 while(i<pat.length()){
			 if(pat.charAt(i)==pat.charAt(j)){
				 
				 lps[i] =j+1;
				 i++;
				 j++;
			 }else{
				 if(j!=0){
					 
					 j= lps[j-1];
				 }else{
					 lps[i] =j;
					 i++;
				 }
				 
				
			 }
		 }
		 
		 System.out.println("****");
	 }
}
