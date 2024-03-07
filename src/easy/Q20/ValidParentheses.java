package easy.Q20;

import java.util.LinkedList;

class Solution {
    public static boolean isValid(String s) {
        LinkedList list = new LinkedList();
        for(int i = 0;i<s.length();i++){
            char temp = s.charAt(i);
            if(temp == '(' || temp == '[' || temp == '{'){
                list.add(temp);
            }else{
                if(list.size() == 0) return false;
                char last = list.getLast().toString().charAt(0);
                switch(temp){
                    case '}':{
                        if(last!='{') return false;
                        break;
                    }
                    case ']':{
                        if(last!='[') return false;
                        break;
                    }
                    case ')':{
                        if(last!='(') return false;
                        break;
                    }
                }
                list.removeLast();
            }
        }
        if(list.size() == 0) return true;
        return false;
    }
}
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(Solution.isValid("(]"));
    }
}
