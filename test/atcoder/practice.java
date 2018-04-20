、package atcoder;

import java.lang.reflect.Array;
import java.util.*;
public class Main {
	public static void main(String[] args){
		Otoshidama();
	}
	
	public static void Otoshidama() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		long target = sc.nextInt();
		int i=num, j=0, k=0;
		long cur = 0;
		for (;i>=0; i--) {
			if (i*10000 > target) continue;
			j = num-i;
			k = 0;
			cur = j*5000 + k*1000 + i*10000;
			while (cur > target) {
				cur = j*5000 + k*1000 + i*10000;
				if (j == 0 || k > num) break;
				j--;
				k++;
			} 	
			if (cur == target) {
				System.out.print(i);
				System.out.print(" ");
				System.out.print(j);
				System.out.print(" ");
				System.out.println(k);
				return;
			}
		}
		System.out.print(-1);
		System.out.print(" ");
		System.out.print(-1);
		System.out.print(" ");
		System.out.println(-1);
	}
	
	public static void Mochi() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] l = new int[num];
		int i=0;
		while (i < num) {
			l[i] = sc.nextInt();
			i++;
		}
		Arrays.sort(l);
		int res = 0;
		int last = 0;
		for (i=0; i<l.length; i++) {
			if (l[i] > last) {
				res ++;
			}
			last = l[i];
		}
		System.out.println(res);
	}
	
	public static void cardGame() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] l = new int[num];
		int i=0;
		while (i < num) {
			l[i] = sc.nextInt();
			i++;
		}
		int res = 0;
		Arrays.sort(l);
		for (i=0; i<l.length; i++) {
			if (i % 2 == 0) {
				res += l[l.length - i - 1];
			}
			else {
				res -= l[l.length - i- 1];
			}
		}
		System.out.println(res);
	}
	
	public static void SomeSums() {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int low = sc.nextInt();
		int hi = sc.nextInt();
		int res = 0;
		for (int i=1; i<=m; i++) {
			int temp = 0;
			int j = i;
			while (j != 0) {
				temp += j%10;
				j /= 10;
			}
			if (temp >= low && temp <= hi) {
				res += i;
			}
		}
		System.out.println(res);
	}
	
	public static void Product() {
		Scanner sc = new Scanner(System.in);
		// 整数の入力
		int a = sc.nextInt();
		// スペース区切りの整数の入力
		int b = sc.nextInt();
		// 文字列の入力
		if (a*b%2 == 0) System.out.println("Even");
		else System.out.println("Odd");
		// 出力
	}
	
	public static void Marbles() {
		Scanner sc = new Scanner(System.in);
		// 整数の入力
		String str = sc.nextLine();
		int res = 0;
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i) == '1') {
				res++;
			}
		}
		System.out.println(res);
	}
	
	public static void shiftOnly() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] l = new int[num];
		int i=0;
		while (i < num) {
			l[i] = sc.nextInt();
			i++;
		}
		int res = 0;
		boolean flag = true;
		while (flag) {
			for (i=0; i<num; i++) {
				if (l[i] % 2 != 0) {
					flag = false;
					System.out.println(res);
					break;
				}
				else {
					l[i] /= 2;
				}
			}
			res++;
		}
	}
	
	public static void Coins() {
		Scanner sc = new Scanner(System.in);
		int fh = sc.nextInt();
		int oh = sc.nextInt();
		int fifty = sc.nextInt();
		int target = sc.nextInt();
		int cur = 0;
		int[] l = new int[target/50+1];
//		if (target == 50) { 
//			System.out.println(1);
//			return;
//		}
//		if (target == 100) {
//			System.out.println(2);
//			return;
//		}
		if (fifty > 0) {
			l[1] = 1;	
			fifty--;
		}
		if (fifty > 0) {
			l[2]++;
			fifty--;
		}
		if (oh > 0) {
			l[2]++;
			oh--;
		}
		for (int i=3; i<l.length; i++) {
			if (i < 9) {
				l[i] += l[i-1]*(fifty>0 ? 1:0) + l[i-2]*(oh>0 ? 1:0);
				fifty--;
				oh--;
			}
			else {
				l[i] += l[i-1]*(fifty>0 ? 1:0) + l[i-2]*(oh>0 ? 1:0) + l[i-9]*(fh>0 ? 1:0);
				fifty--;
				oh--;
				fh--;
			}	
			System.out.println(l[i]);
		}
		System.out.println(l[l.length-1]);
	}
	
	public static void Coins2() {
		Scanner sc = new Scanner(System.in);
		int fh = sc.nextInt();
		int oh = sc.nextInt();
		int fifty = sc.nextInt();
		int target = sc.nextInt();
		int cur = 0;
		int res = helper(fh, oh, fifty, target, cur, 0, 0, 0, 0);
		System.out.println(res);
	}
	
	public static int helper (int fh, int oh, int fifty, int target, int cur, int res, int o, int p, int q) {
		if (cur == target) {
			res++;
			return res;
		}
		if (cur > target) {
			return res;
		}
		for (int i=o; i<=fh; i++) {
			for (int j=p; j<=oh; j++) {
				for (int k=q; k<=fifty; k++) {
					res = helper (fh, oh, fifty, target, i*500+j*100+k*50, res, i+1, j+1, k+1);
				}
			}
		}
		return res;
	}
}
