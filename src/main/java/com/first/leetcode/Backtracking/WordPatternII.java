package com.first.leetcode.Backtracking;

import java.util.HashMap;

public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern.length()==0 && str.length()==0)
            return true;
        if(pattern.length()==0)
            return false;

        HashMap<Character, String> map = new HashMap<>();

        return helper(pattern, str, 0, 0, map);
    }

    public boolean helper(String pattern, String str, int i, int j, HashMap<Character, String> map){
        if(i==pattern.length() && j==str.length()){
            return true;
        }

        if(i>=pattern.length() || j>=str.length())
            return false;

        char c = pattern.charAt(i);
        for(int k=j+1; k<=str.length(); k++){
            String sub = str.substring(j, k);
            if(!map.containsKey(c) && !map.containsValue(sub)){
                map.put(c, sub);
                if(helper(pattern, str, i+1, k, map))
                    return true;
                map.remove(c);
            }else if(map.containsKey(c) && map.get(c).equals(sub)){
                if(helper(pattern, str, i+1, k, map))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordPatternII so = new WordPatternII();
        boolean isTrue = so.wordPatternMatch("abab", "redblueredblue");
        System.out.println(isTrue);
    }
}
