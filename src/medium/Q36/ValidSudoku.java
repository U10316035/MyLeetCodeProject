package medium.Q36;

import java.util.Arrays;
import java.util.List;

// 0,0 2,2  0,3 2,5  0,6 2,8
// 3,0 5,2  3,3 5,5  3,6 5,8
// 6,0 8,2  6,3 8,5  6,6 8,8
class Solution {
    public static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length ; i++){
            char[] temp = board[i];
            if(isRepeat(temp)) return false;
        }

        for(int i = 0; i < board.length ; i++){
            char[] temp = new char[9];
            for(int j = 0; j < board.length ; j++){
                temp[j] = board[i][j];
            }
            if(isRepeat(temp)) return false;
        }
        return true;
    }

    static boolean isRepeat(char[] ccc){
        for(int i = 0 ; i < ccc.length -1 ; i++){
            if(ccc[i] == '.') continue;
            for(int j = i+1 ; j < ccc.length ; j++){
                if(ccc[j] == '.') continue;
                if(ccc[i] == ccc[j]) return true;
            }
        }
        return false;
    }
}
public class ValidSudoku {
    public static void main(String[] args) {
        System.out.println();
    }
}
