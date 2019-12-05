package leetcode;

import java.util.*;

/***
 * 有效括号
 */
public class Parentheses {
    private static Map<Character,Character> map=new HashMap<>();
    public static void main(String[] args) {
        map.put(']','[');
        map.put(')','(');
        map.put('}','{');
        System.out.println(testStr("((([]))[]()"));
    }

    /**
     * 纯括号无其他字符
     * @param str
     * @return
     */
    public static boolean testStr(String str){
        char[] chars=str.toCharArray();
        Stack tmp=new Stack();
        for(int i=0;i<chars.length;i++){
            if(Objects.isNull(map.get(chars[i]))) {
                tmp.push(chars[i]);
            }else if(!Objects.equals(map.get(chars[i]),tmp.pop())){
                return false;
            }

        }
        return tmp.empty();
    }
}
