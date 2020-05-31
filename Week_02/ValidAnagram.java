//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表

// 思路一：将两个字符串按字典序排序，如果一样则证明是 时间复杂度 排序 O(nlog(n)) arrays自带的快排算法
// 思路二：分别统计各个字符出现的次数 时间复杂度 排序 O(n)
  
package com.start621.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ValidAnagram{
  public static void main(String[] args) {
       Solution solution = new ValidAnagram().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) return true;

        if (s.length() != t.length()) return false;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
//
//        Arrays.sort(sArray);
//        Arrays.sort(tArray);
//
//        return String.valueOf(sArray).equals(String.valueOf(tArray));

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < sArray.length; i++) {
            if (!sMap.containsKey(sArray[i])) {
                sMap.put(sArray[i], 0);
            } else {
                sMap.put(sArray[i], sMap.get(sArray[i]) + 1);
            }
        }

        for (int i = 0; i < tArray.length; i++) {
            if (!tMap.containsKey(tArray[i])) {
                tMap.put(tArray[i], 0);
            } else {
                tMap.put(tArray[i], tMap.get(tArray[i]) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            if (!entry.getValue().equals(tMap.get(entry.getKey()))) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}