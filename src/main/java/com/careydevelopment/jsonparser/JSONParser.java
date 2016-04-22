package com.careydevelopment.jsonparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JSONParser {
	private static final Logger LOGGER = LoggerFactory.getLogger(JSONParser.class);
	
	public static JSONObject readJsonFromUrl(String url) throws JSONException {
	    InputStream is = null;
	    JSONObject json = null;
	    
	    try {
	      is = new URL(url).openStream();
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      //LOGGER.info(jsonText);
	      
	      json = new JSONObject(jsonText);
	    } catch (IOException ie) {
	    	LOGGER.error("Problem reading URL " + url,ie);
	    } finally {
	      if (is!=null) try {
	    	  is.close();
	      } catch(IOException ie) {
	    	  LOGGER.warn("Problem closing stream!",ie);
	      }
	    }
	 
	    return json;
	}
	
	
	private static String readAll(Reader rd) throws JSONException {
		try {
		    StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		    }
		    return sb.toString();
		} catch (IOException ie) {
			LOGGER.error("Problem reading URL!",ie);
			throw new JSONException(ie);
		}
	}

}
