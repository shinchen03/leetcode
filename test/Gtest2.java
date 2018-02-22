package Gtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	 public static void main(String[] args) throws IOException {
		    FileInputStream is = new FileInputStream("E:\\eclipse\\workspace\\Google_test\\src\\Gtest\\task2-test-input.txt");
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
		          helper2(num, input);
		    	  i=0;
		       }
		    }
		  }
	 
	 public static void helper2(int num, List<List<Integer>> input) {
		 if (input.size() == 1) {
			 System.out.println("Case #"+num+":"+" "+1);
			 return;
		 }
		 int goal = input.get(0).get(0);
		 int curA = 0;
		 int curB = 0;
		 int time = 0;
		 List<Integer> listA = new ArrayList<>();
		 int[] waitB = new int[51];
		 for (int i=1; i<input.size(); i++) {
			 curA = input.get(i).get(0);
			 curB = input.get(i).get(1);
			 waitB[0] = curB;
			 Arrays.sort(waitB);
			 int j=waitB.length-1;
			 while (waitB[j] != 0) {
				 if (listA.contains(waitB[j])) {
					 waitB[j] = 0;
					 goal--;
				 }
				 j--;
			 }
			 goal--;
			 time++;
			 listA.add(curA);
			 if (goal <= 0) {
				 System.out.println("Case #"+num+":"+" "+time);
				 break;
			 }
		 }
		 int j=waitB.length-1;
		 while (waitB[j] != 0) {
			 if (listA.contains(waitB[j])) {
				 time++;
				 break;
			 }
			 j--;
		 }
		 if (goal > 0) {
			 System.out.println("Case #"+num+":"+" "+time);
		 }
	 }
}
