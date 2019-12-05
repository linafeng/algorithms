package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 242
 * 判断字母异位词
 */
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("cat","tac"));
        System.out.println(isAnagram1("cat","tac"));
        System.out.println(isAnagram2("cat","tac"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Objects.equals(String.valueOf(str1),String.valueOf(str2));
    }
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character,Integer> maps=new HashMap<>();
        Map<Character,Integer> mapt=new HashMap<>();
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        for(int i=0;i<str1.length;i++){
            if(Objects.isNull(maps.get(str1[i]))){
                maps.put(str1[i],1);
            }else{
                maps.put(str1[i], maps.get(str1[i])+1);
            }

        }
        for(int i=0;i<str2.length;i++){
            if(Objects.isNull(mapt.get(str2[i]))){
                mapt.put(str2[i],1);
            }else{
                mapt.put(str2[i], mapt.get(str2[i])+1);
            }

        }
        return Objects.equals(maps,mapt);
    }
}
