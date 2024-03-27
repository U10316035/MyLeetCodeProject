package medium.Q36;

import java.util.Arrays;
import java.util.List;

// 0,0 2,2  0,3 2,5  0,6 2,8
// 3,0 5,2  3,3 5,5  3,6 5,8
// 6,0 8,2  6,3 8,5  6,6 8,8

// 可以優化解法，縮短程式碼
class Solution {
    public static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length ; i++){
            char[] temp = board[i];
            if(isRepeat(temp)) return false;
        }

        for(int i = 0; i < board.length ; i++){
            char[] temp = new char[9];
            for(int j = 0; j < board.length ; j++){
                temp[j] = board[j][i];
            }
//            for(char x: temp){
//                System.out.println(x);
//            }
            if(isRepeat(temp)) return false;
//            System.out.println(' ');
        }

        int left = 0;
        int right = 0;
        int idx = 0;
        while(left <= 8 && right <= 8){
            char[] temp = new char[9];
            for(int i = left; i <= left + 2 ; i++){
                for(int j = right; j <= right + 2 ; j++){
                    temp[idx++] = board[i][j];
                }
            }

            if(isRepeat(temp)){
//                for(char x: temp){
//                    System.out.println(x);
//                }
                return false;
            }

            right = right + 3;
            idx = 0;
            if(right > 8 && left < 8){
                left = left + 3;
                right = 0;
            }
        }

        return true;
    }

    static boolean isRepeat(char[] ccc){
        for(int i = 0 ; i < ccc.length -1 ; i++){
            if(ccc[i] == '.' || ccc[i] == '\u0000') continue;
            for(int j = i+1 ; j < ccc.length ; j++){
                if(ccc[j] == '.' || ccc[i] == '\u0000') continue;
                if(ccc[i] == ccc[j]) return true;
            }
        }
        return false;
    }
}
public class ValidSudoku {
    public static void main(String[] args) {
//        char[][] test = new char[][]{{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
//        System.out.println(Solution.isValidSudoku(test));

        char[][] test2 = new char[][]{{'.','.','.','.','5','.','.','1','.'}, {'.','4','.','3','.','.','.','.','.'}, {'.','.','.','.','.','3','.','.','1'},{'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},{'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}};
        System.out.println(Solution.isValidSudoku(test2));
    }
}
