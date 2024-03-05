package medium.Q8;

class Solution {
    public static int myAtoi(String s) {
        int value = 0;
        StringBuilder sb = new StringBuilder();
        boolean reading = false;
        for(int i = 0 ; i < s.length() ; i++){
            char temp = s.charAt(i);
            if(!reading && temp == ' ') continue;
            else if(!reading && (temp == '-' || temp == '+')){
                sb.append(temp);
                reading = true;
            }else if(checkIsDigital(temp)){
                sb.append(temp);
                reading = true;
            }else break;
        }

        String ans = sb.toString();
        try{
            value = Integer.parseInt(ans);
        }catch(Exception e){
            if(ans.length() >= 1)
                if(ans.charAt(0) == '+' && ans.length() >= 11){
                    return Integer.MAX_VALUE;
                }else if(ans.charAt(0) == '-' && ans.length() >= 11){
                    return Integer.MIN_VALUE;
                }else if(checkIsDigital(ans.charAt(0)) && ans.length() >= 10){
                    return Integer.MAX_VALUE;
                }
        }
        return value;
    }

    static boolean checkIsDigital(char checkChar){
        if((int) checkChar >= 48 && (int) checkChar <= 57) return true;
        return false;
    }
}

public class Atoi {
    public static void main(String[] args){
        System.out.println(Solution.myAtoi("   +0 123"));

//        System.out.println(Solution.myAtoi("   +111111111111111111111111111111111111111111"));
    }
}
