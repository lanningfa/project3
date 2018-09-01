package com.oralce.sport.Utils;

public class Array2String {
	
	public static String array2String(String[] strs) {
		
		String paramImgUrls="";
		for(int i=0;i<strs.length;i++) {
			
			if(i == strs.length-1) {
			paramImgUrls += strs[i];
		}else {
			paramImgUrls += strs[i]+",";
		}
			
	}
		return paramImgUrls;
		
}
	
}