package com.lrn.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.StringTokenizer;

public class StringUtils
{

    public StringUtils()
    {
    }

    public static String[] parseString(String text, String token)
    {
        StringTokenizer parser = new StringTokenizer(text, token);
        int numTokens = parser.countTokens();
        String list[] = new String[numTokens];
        for(int i = 0; i < numTokens; i++)
            list[i] = parser.nextToken();

        return list;
    }

    public static String arrayToString(Object array, String openChar, String closeChar)
    {
        String nullMember = "[NULL]";
        if(array == null)
            return nullMember;
        Object obj = null;
        if(array instanceof Collection)
            array = ((Object) (((Collection)array).toArray()));
        int length = Array.getLength(array);
        int lastItem = length - 1;
        StringBuffer sb = new StringBuffer(openChar);
        for(int i = 0; i < length; i++)
        {
            obj = Array.get(array, i);
            if(obj != null)
                sb.append(obj);
            else
                sb.append(nullMember);
            if(i < lastItem)
                sb.append(", ");
        }

        sb.append(closeChar);
        return sb.toString();
    }

    public static String arrayToString(Object array)
    {
        return arrayToString(array, "<", ">");
    }

    public static String substituteParams(String str, String params[])
    {
        return substituteParams(str, params, DEFAULT_TOKEN);
    }

    public static String substituteParams(String str, String params[], String placeHolder)
    {
        int i = 0;
        String outString = "";
        StringTokenizer st = new StringTokenizer(str, placeHolder);
        if(str.startsWith(placeHolder))
            outString = getNextToken(params, i++) + st.nextToken();
        else
            outString = outString + st.nextToken();
        while(st.hasMoreTokens()) 
            outString = outString + getNextToken(params, i++) + st.nextToken();
        if(str.endsWith(placeHolder))
            outString = outString + getNextToken(params, i++);
        return outString;
    }

    private static String getNextToken(String pm[], int i)
    {
        if(pm == null)
            return EMPTY_MESSAGE_TOKEN;
        if(pm.length > i)
        {
            if(pm[i] == null)
                return EMPTY_MESSAGE_TOKEN;
            else
                return pm[i];
        } else
        {
            return EMPTY_MESSAGE_TOKEN;
        }
    }

    public static String replace(String input, String lookFor, String repWith)
    {
        if(input == null)
            return "";
        if(lookFor == null || repWith == null)
            return input;
        if(lookFor.length() == 1 && repWith.length() == 1)
            return input.replace(lookFor.charAt(0), repWith.charAt(0));
        int i = -1;
        int offset = 0;
        StringBuffer sb = new StringBuffer();
        while((i = input.indexOf(lookFor, i + 1)) != -1) 
        {
            sb.append(input.substring(offset, i)).append(repWith);
            offset = i + lookFor.length();
        }
        if(!input.endsWith(lookFor))
            sb.append(input.substring(offset));
        return sb.toString();
    }

    public static String getStringFromBytes(byte[] b) {
		
		StringBuffer result = new StringBuffer();
		ByteArrayInputStream is = new ByteArrayInputStream(b);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));

		char[] buf = new char[1000];
		int num;
	    
	    try {
	    	num = reader.read(buf);
	      while (-1 != num) {
	        result.append(buf, 0, num);
	        num = reader.read(buf);
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    
	    return result.toString();
	}

    private static final String DEFAULT_TOKEN = "$$";
    private static final String EMPTY_MESSAGE_TOKEN = "[EMPTY]";
}