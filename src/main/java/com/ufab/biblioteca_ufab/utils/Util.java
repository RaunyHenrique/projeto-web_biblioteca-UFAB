package com.ufab.biblioteca_ufab.utils;

public class Util {
	
	public static String ajustaCamposBusca(String tableParams, String param) {
		
		String sql = "where id LIKE '%" + param + "%' OR ";
		
		String[] campos = tableParams.split(",");
	       
	       for (int i = 0; i < campos.length; i++) {
	    	   
	     	   if (i == campos.length - 1) {//ultima posição
	    		   sql += campos[i] + " LIKE '%" + param + "%' ";
	    	   } else {
	    		   sql += campos[i] + " LIKE '%" + param + "%' OR ";
	    	   }
			
	       }
	       		
	       return sql;
	}
	
	public static String ajustaCamposAlterar(String tableParams) {
		
		String sql = "";
		
		String[] campos = tableParams.split(",");
	       
	       for (int i = 0; i < campos.length; i++) {
	    	   
	     	   if (i == campos.length - 1) {//ultima posição
	    		   sql += campos[i] + " = ?";
	    	   } else {
	    		   sql += campos[i] + " = ?, ";
	    	   }
			
	       }
	       		
	       return sql;
	}

}
