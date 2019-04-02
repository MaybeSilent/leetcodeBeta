import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 *
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/description/
 *
 * algorithms
 * Easy (57.52%)
 * Total Accepted:    7.4K
 * Total Submissions: 12.8K
 * Testcase Example:  '["MyQueue","push","push","peek","pop","empty"]\n[[],[1],[2],[],[],[]]'
 *
 * 使用栈实现队列的下列操作：
 * 
 * 
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 
 * 
 * 示例:
 * 
 * MyQueue queue = new MyQueue();
 * 
 * queue.push(1);
 * queue.push(2);  
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * 
 * 说明:
 * 
 * 
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty
 * 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 * 
 * 
 */
class MyQueue {

    /** Initialize your data structure here. */
    // use two linkedlist to realize stack
    /**
     * just use the push and pop to relize add and remove
     */
    LinkedList<Integer> firstList = new LinkedList<>();
    LinkedList<Integer> secondList = new LinkedList<>();

    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        firstList.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */

    private void judgeMent() {
        if (secondList.isEmpty()) {
            int size = firstList.size();
            for (int i = 0; i < size; i++) {
                secondList.push(firstList.pop());
            }
        }
    }

    public int pop() {
        judgeMent();
        return secondList.pop();
    }

    /** Get the front element. */
    public int peek() {
        judgeMent();
        return secondList.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return firstList.isEmpty() && secondList.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */
