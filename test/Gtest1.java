package Gtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
	 public static void main(String[] args) throws IOException {
		    FileInputStream is = new FileInputStream("E:\\eclipse\\workspace\\Google_test\\src\\Gtest\\task2-sample-input.txt");
		    InputStreamReader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
		    BufferedReader in = new BufferedReader(reader);
		    String line;
		    int m=0;
		    int n=0;
		    int i=0;
		    int num = 0;
            List<List<Integer>> input = new ArrayList<>();
		    while ((line = in.readLine()) != null) {
		      if (i==0) {
		    	  //num = Integer.parseInt(line);
		    	  num++;
		    	  i++;
		    	  input.clear();
		      }
		      if(line !=null && line.matches("^[0-9]+.*")){
		            String[] strs = line.split(" ");
		            if (strs.length > 1) {
		            	n = Integer.parseInt(strs[0]);
			            m = Integer.parseInt(strs[1]);
			            List<Integer> temp = new ArrayList<>();
			            temp.add(n);
			            temp.add(m);
			            input.add(temp);
		            }
		           }
		      else if (!input.isEmpty()){
		          helper(num, input);
		    	  i=0;
		       }
		    }
		  }
	 
	 public static void helper (int num, List<List<Integer>> input) {
		 //System.out.println(num);
		 double peri = 0;
		 double min = Double.MAX_VALUE;
		 for (int i=0; i<input.size(); i++) {
			 int x1 = input.get(i).get(0);
			 int y1 = input.get(i).get(1);
			 for (int j=i+1; j<input.size(); j++) {
				 int x2 = input.get(j).get(0);
				 int y2 = input.get(j).get(1);
				 for (int k=j+1; k<input.size(); k++) {
					 int x3 = input.get(k).get(0);
					 int y3 = input.get(k).get(1);
					 peri = dis(x1, y1, x2, y2) + dis(x1, y1, x3, y3) + dis(x2, y2, x3, y3);
					 min = min < peri ? min : peri;
				 }
			 }
		 }
		 System.out.println("Case #"+num+":"+" "+min);
	 }
	 
	 public static double dis (int x1, int y1, int x2, int y2) {
		 return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	 }
}
