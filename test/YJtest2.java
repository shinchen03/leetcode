/*
プログラミング チャレンジの説明:
標準入力から最も長い行から上位N個を求めるプログラムを書いて下さい。


入力:
標準入力から数行のテキストを読み込む必要があります。最初の行は正の整数Nを含みます。入力値の中に含まれる空行は無視します。入力値は少なくともN行の空ではない行で構成されていると仮定して下さい。


出力:
最長の行から最短の行までをソートして、上位N個までの行を出力して下さい。出力した各行の末尾にスペースが入っていたり、空行が無いように注意して下さい。


Test 1
テストの入力 テスト入力のダウンロード1
Salt Lake City
Seattle

Denver
Phoenix
期待される出力 テスト出力のダウンロードSalt Lake City
Test 2
テストの入力 テスト入力のダウンロード2
Hello World

CodeEval
Quick Fox
A
San Francisco
期待される出力 テスト出力のダウンロードSan Francisco
Hello World


*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    int num = 0;
    String strs = "";
    while ((line = in.readLine()) != null) {
      if(line !=null && line.matches("^[0-9]+$")){
        // if the input is an integer, means this input is the max number of output.
            num = Integer.parseInt(line);   
           }
      else {
        // if the input is string, add all the string together
        strs += line;
        strs += ";";
      }
      //System.out.println(line);
    }
    helper(strs, num);
  }
  
  public static void helper(String strs, int num) {
    String[] args = strs.split(";"); // return the input to the every sigle line
    for (int i=args.length-1; i>0; i--) {
      // bubble sort to sort the input. due to the limited time and the test case is not too long, I choose the bubble sort. Or quick sort may better
      for (int j=0; j<i; j++) {
        if (args[j].length() < args[j+1].length()) {
          String temp = args[j];
          args[j] = args[j+1];
          args[j+1] = temp;
        }
      }
    }
    for (int i=0; i<num; i++) {
      // output the result
      System.out.println(args[i]);
    }
  }
}


// YJ did a lot of problem about probability
// ex: there are 7 people in round table. the combination
//     a coin with the probability of being a tail is 0.4...
//     a coin with unknown P, when I round the coin 3 times, the coin always tail.
//     what is the P and describe your answer. 最尤推定? 


