//编写一个程序，找出第 n 个丑数。 
//
// 丑数就是质因数只包含 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划

// 思路： 暴力法 循环所有数，获取前n个丑数, 返回最后一个即可  --- 时间复杂度O(n)
// 优化判断之前已经判断的数

package com.start621.leetcode.editor.cn;

import java.util.HashSet;
import java.util.PriorityQueue;

public class UglyNumberIi {
    public static void main(String[] args) {
        Solution solution = new UglyNumberIi().new Solution();
        System.out.println(solution.nthUglyNumber(1096));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            if (n < 1 || n > 1690) return 0;
            int[] result = new int[1690];
            result[0] = 1;
//        int index = 1;
//        int i = 2;
//        while (index < n) {
//            if (isUgly(i, result[index - 1])) {
//                result[index] = i;
//                index++;
//            }
//            i++;
//        }
//
//        return result[n -1];
//    }
//
//    private boolean isUgly(int i, int last) {
//        if (i <= 0) return false;
//
//        if (i % last == 0) {
//            i = i / last;
//        } else return false;
//
//        while (i % 2 == 0 || i % 3 == 0 || i % 5 == 0 ) {
//            while (i % 2 == 0) {
//                i = i/2;
//            }
//            while (i % 3 == 0) {
//                i = i/3;
//            }
//            while (i % 5 == 0) {
//                i = i/5;
//            }
//        }
//
//        return i == 1;
//    }
            // 对元素去重，如12 = 2 * 2 * 3 也可以为 4 * 3
            HashSet<Long> seenSet = new HashSet<>();
            PriorityQueue<Long> heap = new PriorityQueue<>();
            seenSet.add(1L);
            heap.add(1L);

            long currentUgly, newUgly;
            int[] primes = new int[]{2, 3, 5};
            for (int i = 0; i < 1690; i++) {
                currentUgly = heap.poll();
                result[i] = (int) currentUgly;

                for (int j : primes) {
                    newUgly = currentUgly * j;
                    if (!seenSet.contains(newUgly)) {
                        seenSet.add(newUgly);
                        heap.add(newUgly);
                    }
                }
            }
            return result[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}