import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 *
 * https://leetcode-cn.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (47.49%)
 * Total Accepted:    17.7K
 * Total Submissions: 37.2K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * 
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 
 * 
 * 示例:
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 
 * 
 */
class MinStack {

    /** initialize your data structure here. */
    private ArrayList<Integer> array;
    private LinkedList<Integer> linkedlist;

    public MinStack() {
        array = new ArrayList<>();
        linkedlist = new LinkedList<>();
    }

    public void push(int x) {

        linkedlist.add(x);

        int size = array.size();

        for (int i = 0; i < size; i++) {
            if (x < array.get(i)) {
                // System.out.println(i + " " + x);
                array.add(i, x);
                break;
            }
        }

        if (array.size() == size) {
            // System.out.println(size - 1 > 0 ? size - 1 : 0 + " " + x);
            array.add(size, x);
        }
    }

    public void pop() {
        int x = linkedlist.removeLast();
        array.remove((Integer) x);
    }

    public int top() {
        return linkedlist.getLast();
    }

    public int getMin() {
        // System.out.println(array.get(0));
        return array.get(0);
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
