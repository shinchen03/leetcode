/*
プログラミング チャレンジの説明:
ボブはサーカスで電灯を操作しています。最近、回路基板が故障してしまい、仕事に支障が出ています。この回路基板はN×M個の長方形のライトをコントロールしており、ショーのタイミングに応じてオン/オフにすることができます。しかし、彼が特定のライトのオン/オフを切り替えると、そのライトだけでなく上下左右のライトのオン/オフも切り替わってしまいます。

O = オン . = オフ

例： （行2、列2のライトを切り替えた場合）

.O..     ....
OOO. - > ....
.O..     ....
（行1、列2のライトを切り替えた場合）

OOO.     ....
.O.. - > ....
....     ....
（ライトを次のように切り替えた場合　行1、列4→行2、列3→行2、列4→行3、列4）

....     ..OO     ...O     ....     ....
.O.. - > .O.O - > ..O. - > ...O - > ....
....     ....     ..O.     ..OO     ....
ボブは全てのライトをオフにする必要があります。全てのライトをオフにするために最低限必要なスイッチの操作回数を求めるプログラムを書いて下さい。ただし、全てのライトを消すことが不可能な場合は「-1」を出力するものとします。


入力:
入力値は、スペースで区切られた2つの整数N、M（1 <= N、M <= 10）から始まります。その後、M個の「.」か「O」で構成される文字列がN行続きます。これらの文字は各位置のライトが現在オンまたはオフであることを意味します。


出力:
全てのライトをオフにするために必要な最小限のスイッチ操作回数を出力して下さい。ただし、N×M回以内の操作で全てのライトを消すことができない場合「-1」を出力して下さい。


Test 1
テストの入力 テスト入力のダウンロード4 5
.....
.O...
.....
.....
期待される出力 テスト出力のダウンロード9
Test 2
テストの入力 テスト入力のダウンロード3 4
....
.O..
....
期待される出力 テスト出力のダウンロード4

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
    String input = "";
    int m=0;
    int n=0;
    while ((line = in.readLine()) != null) {
      if(line !=null && line.matches("^[0-9]+$")){
            String[] strs = line.split(" ");
            n = Integer.parseInt(strs[0]);
            m = Integer.parseInt(strs[1]);
           }
      else {
        input += line;
       }
    }
    helper(input, m, n);
  }
  
  public static void helper(String input, int m, int n) {
    Character[][] board = new Character[n][m];
    for (int i=0; i<n; i++) {
      for (int j=0; j<m; j++) {
        board[i][j] = input.charAt(i+j);
      }
    }
    dfs(board, 0, 0, 0);
    System.out.println(-1);
  }
  
  public static void dfs(Character[][] board, int num, int n, int m) {
    if (num > board.length * board[0].length) return;
    if (check(board)) {
      System.out.println(num);
      System.exit(0);
    }
    for (int i=n; i<board.length; i++) {
      for (int j=m; j<board.length; j++) {
        board = swi(board, i, j);
        dfs (board, num+1, i+1, j+1);
        board = swi(board, i, j);
      }
    }
  }
  
  public static Character[][] swi(Character[][] board, int i, int j) {
    if (i>0) {
      board[i-1][j] = change(board[i-1][j]);
    }
    if (j>0) {
      board[i][j-1] = change(board[i][j]);
    }
    if (i<board.length-1) {
      board[i+1][j] = change(board[i+1][j]);
    }
    if (j<board[0].length) {
      board[i][j+1] = change(board[i][j+1]);
    }
    return board;
  }
  
  public static Character change(Character c) {
    if (c == '.') return 'O';
    else return '.';
  }
  
  public static boolean check(Character[][] board) {
    for (int i=0; i<board.length; i++) {
      for (int j=0; j<board[0].length; j++) {
        if (board[i][j] == 'O') return false;
      }
    }
    return true;
  }
}
