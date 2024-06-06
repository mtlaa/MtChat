package com.mtlaa.mtchat;

import com.mtlaa.mtchat.utils.sensitive.impl.ACFilter;
import com.mtlaa.mtchat.utils.sensitive.impl.DFAFilter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.locks.LockSupport;


@Slf4j
public class OtherTest {
    @Test
    public void test1() throws InterruptedException {
        System.out.println((new int[]{1,2,3,1}));
    }


}

class MinStack {
    Deque<Integer> data;
    Deque<Integer> minStack;

    public MinStack() {
        data = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        data.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop() {
        int val = data.pop();
        if (!minStack.isEmpty() && val == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }