import java.util.ArrayList;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=401 lang=java
 *
 * [401] 二进制手表
 *
 * https://leetcode-cn.com/problems/binary-watch/description/
 *
 * algorithms
 * Easy (45.14%)
 * Total Accepted:    2.6K
 * Total Submissions: 5.8K
 * Testcase Example:  '0'
 *
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 * 
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * 
 * 
 * 
 * 例如，上面的二进制手表读取 “3:25”。
 * 
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 * 
 * 案例:
 * 
 * 
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16",
 * "0:32"]
 * 
 * 
 * 
 * 注意事项:
 * 
 * 
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 * 
 * 
 */
class Solution {
    private HashSet<String> ans = new HashSet<String>();
    private int[] nums = new int[] { 1, 2, 4, 8, 16, 32, 60, 120, 240, 480 };
    private boolean[] visited = new boolean[10];
    private int num;

    public List<String> readBinaryWatch(int num) {
        this.num = num;
        getAll(0, 0);
        return new ArrayList<String>(ans);
    }

    private void getAll(int count, int time) {
        if (count == num) {
            int hour = time / 60;
            int minu = time % 60;
            if ((hour >= 12) || (visited[2] && visited[3] && visited[4] && visited[5])) {
                return;
            }
            if (minu < 10)
                ans.add(hour + ":0" + minu);
            else
                ans.add(hour + ":" + minu);
            return;
        }
        for (int i = count; i < 10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                time += nums[i];
                getAll(count + 1, time);
                time -= nums[i];
                visited[i] = false;
            }
        }
    }
}
