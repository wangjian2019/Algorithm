package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Group Anagrams
 * 
 * Given an array of strings, group anagrams together.
 *
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Return:
 * [
 *    ["ate", "eat","tea"],
 *    ["nat","tan"],
 *    ["bat"]
 * ]
 * Note: All inputs will be in lower-case.
 * 
 * 题解：
 * 把字符串中的字符排序后，若都相等则为同一组。
 * 
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] str2char = s.toCharArray();
            //每个字符串排序
            Arrays.sort(str2char);
            String sortedStr = String.valueOf(str2char);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(s);
            } else {
                ArrayList<String> tmp = new ArrayList<String>();
                tmp.add(s);
                map.put(sortedStr, tmp);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for (List<String> list : map.values()) {
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }

}