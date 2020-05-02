package 每日一练算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 计算字符串不重复最长子串长度
 * @author Leiming
 */
public class LengthOfLongestSubstring {

    /**
     * 方法1：暴力破解，以此遍历每一种子串
     * @param s
     * @return
     */
    static int method_1(String s){
        int max = 0;
        int length = s.length();
        List<Character> list = new ArrayList<>();
        if (s.isEmpty()){
            return 0;
        }
        for (int i = 0; i < length; i++) {
            for (int j = length; j > i; j--) {
                //i,k
                for (int k = i; k < j; k++) {

                    if (list.contains(s.charAt(k))){
                        max = Math.max(max,list.size());
                        list.clear();
                        list.add(s.charAt(k));
                    }else {
                        list.add(s.charAt(k));
                    }
                }
                max = Math.max(max,list.size());
                list.clear();
            }
        }
        return max;
    }

    /**
     * 滑动窗口法
     * @param s
     * @return
     */
    static int method_2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;

    }

}
