package easy.Q17;

import java.util.*;

//可思考遞迴解
class Solution {
    public static List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();

        Map<Character, Character[]> temp = new HashMap<>();
        temp.put('2', new Character[]{'a', 'b', 'c'});
        temp.put('3', new Character[]{'d', 'e', 'f'});
        temp.put('4', new Character[]{'g', 'h', 'i'});
        temp.put('5', new Character[]{'j', 'k', 'l'});
        temp.put('6', new Character[]{'m', 'n', 'o'});
        temp.put('7', new Character[]{'p', 'q', 'r', 's'});
        temp.put('8', new Character[]{'t', 'u', 'v'});
        temp.put('9', new Character[]{'w', 'x', 'y', 'z'});

        int len = digits.length();
        switch (len){
            case 0:{
                return output;
            }
            case 1:{
                return Arrays.stream(temp.get(digits.charAt(0))).map(Object::toString).toList();
            }
            case 2:{
                Character[] a = temp.get(digits.charAt(0));
                Character[] b = temp.get(digits.charAt(1));
                for(int i = 0 ; i < a.length ; i++){
                    for(int j = 0 ; j < b.length ; j++){
                        output.add(a[i].toString() + b[j].toString());
                    }
                }
                break;
            }
            case 3:{
                Character[] a = temp.get(digits.charAt(0));
                Character[] b = temp.get(digits.charAt(1));
                Character[] c = temp.get(digits.charAt(2));
                for(int i = 0 ; i < a.length ; i++){
                    for(int j = 0 ; j < b.length ; j++){
                        for(int k = 0 ; k < c.length ; k++){
                            output.add(a[i].toString() + b[j].toString() + c[k].toString());
                        }
                    }
                }
                break;
            }
            case 4:{
                Character[] a = temp.get(digits.charAt(0));
                Character[] b = temp.get(digits.charAt(1));
                Character[] c = temp.get(digits.charAt(2));
                Character[] d = temp.get(digits.charAt(3));
                for(int i = 0 ; i < a.length ; i++){
                    for(int j = 0 ; j < b.length ; j++){
                        for(int k = 0 ; k < c.length ; k++){
                            for(int l = 0 ; l < d.length ; l++){
                                output.add(a[i].toString() + b[j].toString() + c[k].toString() + d[l].toString());
                            }
                        }
                    }
                }
                break;
            }

        }

        return output;
    }
}

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args){
        System.out.println(Solution.letterCombinations("23"));
    }
}
