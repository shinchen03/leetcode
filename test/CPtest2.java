// 下図のように、両端に1を置き、左上と右上との数を足すという規則で数を配置していきます。
// コマンドラインオプションで何段目かを指定すると、その段にあらわれる数をすべて出力するプログラムを作成してください。
// たとえば、4段目を指定した場合には「1 3 3 1」を出力します。




package cookpad;
import java.util.*;

public class Main {
	  public static void main(String args[]) {
		  Scanner scanner = new Scanner(System.in);
		  String input = scanner.nextLine();
		  problem2(Integer.parseInt(input));
		  scanner.close();
	  }
	  
	  public static void flower(String input) {
		  String[] strs = input.split("}");
		  String[] colors = strs[0].substring(1, strs[0].length()).split(",");
		  for (int i=0; i<colors.length; i++) {
			  System.out.println(colors[i] + strs[1]);
		  }
	  }
	  
	  public static void problem2(int level) {
		  if (level < 1) {
			  System.out.println("null");
			  return;
		  }
		  List<Integer> pre = new ArrayList<>();
		  List<Integer> temp = new ArrayList<>();
		  temp = new ArrayList<Integer>(helper(pre, temp, level, 1));
		  for (int i=0; i<temp.size(); i++) {
			  System.out.print(temp.get(i));
			  if (i != temp.size()-1) {
				  System.out.print(" ");
			  }
		  }
	  }
	  
	  public static List<Integer> helper(List<Integer> pre, List<Integer> temp, int level, int cur) {
		  //System.out.println(cur);
		  if (pre.size() == 0) {
			  pre.add(1);
			  return helper(pre, temp, level, cur+1);
		  }
		  for (int i=0; i<pre.size()+1; i++) {
			  int num = 0;
			  if (i == 0 || i == pre.size()) {
				  temp.add(1);
			  }
			  else {
				  num = pre.get(i-1) + pre.get(i);
				  temp.add(num);
			  }
		  }
		  if (cur == level) {

			  return temp;
		  }
		  pre = new ArrayList<Integer>(temp);
		  temp.clear();
		  return helper(pre, temp, level, cur+1);
	  }
}
