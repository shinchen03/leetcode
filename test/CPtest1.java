// 標準入力から入力を受け取り、ブレース展開をして標準出力へ出力するプログラムを作成してください。

// 入力例

// {あかい,あおい,きいろい}はな
// 出力例

// あかいはな
// あおいはな
// きいろいはな

package cookpad;
import java.util.*;

public class Main {
	  public static void main(String args[]) {
		  Scanner scanner = new Scanner(System.in);
		  String input = scanner.nextLine();
		  flower(input);
		  scanner.close();
	  }
	  
	  public static void flower(String input) {
		  String[] strs = input.split("}");
		  String[] colors = strs[0].substring(1, strs[0].length()).split(",");
		  for (int i=0; i<colors.length; i++) {
			  System.out.println(colors[i] + strs[1]);
		  }
	  }
}
