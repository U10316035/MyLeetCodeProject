package easy.Q13;

class Solution {
    public static int romanToInt(String s) {
        char[] cA = s.toCharArray();
        int total = 0;
        int currentIndex = 0;
        for(int i=0;i<cA.length;i++){
            int current = convertCToInt(cA[i]);
            if(i==cA.length-1){
                total = total + current;
                break;
            }
            int next = convertCToInt(cA[i+1]);
            if(next > current){
                total = total + (next - current);
                i = i +1;
            }else{
                total = total + current;
            }
        }
        return total;
    }

    static int convertCToInt(char c){
        int value = 0;
        switch(c){
            case 'I':{
                value = 1;
                break;
            }
            case 'V':{
                value = 5;
                break;
            }
            case 'X':{
                value = 10;
                break;
            }
            case 'L':{
                value = 50;
                break;
            }
            case 'C':{
                value = 100;
                break;
            }
            case 'D':{
                value = 500;
                break;
            }
            case 'M':{
                value = 1000;
                break;
            }
        }
        return value;
    }
}
public class RomanToInteger {
    public static void main(String[] args){
        System.out.println(Solution.romanToInt("MCMXCIV"));
    }
}
