package practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class line {
	
	static String[] nums = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	static String[] tens = new String[] {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	static String[] strs = new String[] {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		FileInputStream is = new FileInputStream("E:\\eclipse\\workspace\\Line\\src\\practice\\input.txt");
	    InputStreamReader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
	    BufferedReader in = new BufferedReader(reader);
	    String line;
	    while ((line = in.readLine()) != null) {
	      if (line !=null){
	            try {
	            	Double.parseDouble(line);
	            } catch (NumberFormatException e){
	            	System.out.println("invalid");
	            	continue;
	            	//System.exit(1);	
	            }
	            if (line.charAt(0) == '0' && !line.contains(".")) {
	            	System.exit(1);
	            }
	            Double num = Double.parseDouble(line);
	  	      	numToEng(num);
	            //stupidThree(line);
	       }
	    }
	}
	
	public static void stupidThree(String num) {
		boolean flag = false;
		for (int i=0; i<num.length(); i++) {
			if (num.charAt(i) == '3') {
				flag = true;
				break;
			}
		}
		int n = Integer.parseInt(num);
		if (n%3 == 0) {
			if (flag) {
				System.out.println("dump");
			} else {
				System.out.println("idiot");
			}
			return;
		}
		if (flag) {
			System.out.println("stupid");
		} else {
			System.out.println("smart");
		}
	}
	
	
	public static void numToEng(Double num) {
		StringBuffer res = new StringBuffer();
		int billian = (int) (num/Math.pow(10,9)) % 1000;
		int millian = (int) (num/Math.pow(10,6)) % 1000;
		int thousand = (int) (num/Math.pow(10,3)) % 1000;
		int hundred = (int) (num%Math.pow(10,3));
		double temp = num.longValue();
		double point = num - temp;
		if (billian != 0) {
			res = helper(res, billian);
			res.append(" " + "billion");
		}
		if (millian != 0) {
			res = helper(res, millian);
			res.append(" " + "million");
		}
		if (thousand != 0) {
			res = helper(res, thousand);
			res.append(" " + "thousand");
		}
		if (hundred != 0) {
			res = helper (res, hundred);
		}
		if (point != 0) {
			res = getPoint(res, num);
		}
		if (billian == 0 && millian == 0 && thousand == 0 && hundred == 0) {
			res.insert(0, " zero");
		}
		res.deleteCharAt(0);
		Character c = res.charAt(0);
		res.deleteCharAt(0);
		res.insert(0,  Character.toUpperCase(c));
		System.out.println(res.toString());
	}
	
	public static StringBuffer helper(StringBuffer res, int n) {
		if (n/100 != 0) {
			res.append(" " + nums[n/100] + " " + "hundred");
		}
		if ((n/10)%10 > 1) {
			res.append(" " + strs[(n/10)%10-2]);
		} else
		if ((n/10)%10 != 0) {
			res.append(" " + tens[n%10]);
			return res;
		} 
		if ((n%10)>0 && (n%10)<10) {
			res.append(" " + nums[n%10]);			
		}
		return res;
	}
	
	public static StringBuffer getPoint(StringBuffer res, double num) {
		String point = String.valueOf(num);
		int i = point.indexOf(".");
		i++;
		res.append(" " + "point");
		for (; i<point.length(); i++) {
			int index = point.charAt(i) - '0';
			res.append(" " + nums[index]);
		}
		return res;
	}
}
