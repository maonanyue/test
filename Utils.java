package com.yf.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;

import android.content.Context;

public final class Utils {
	public static String getStackTrace(Exception e){
		final StringWriter stackTrace = new StringWriter();
		e.printStackTrace(new PrintWriter(stackTrace));		
		return stackTrace.toString();
	}
	
	 public static String readAsset(Context context, String assetName, String defaultS) {
	        try {
	            InputStream is = context.getResources().getAssets().open(assetName);
	            BufferedReader r = new BufferedReader(new InputStreamReader(is, "UTF8"));
	            StringBuilder sb = new StringBuilder();
	            String line = r.readLine();
	            if(line != null) {
	                sb.append(line);
	                line = r.readLine();
	                while(line != null) {
	                    sb.append('\n');
	                    sb.append(line);
	                    line = r.readLine();
	                }
	            }
	            return sb.toString();
	        } catch (IOException e) {
	            return defaultS;
	        }
	    }
}
