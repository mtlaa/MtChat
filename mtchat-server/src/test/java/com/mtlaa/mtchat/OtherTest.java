package com.mtlaa.mtchat;

import com.mtlaa.mtchat.utils.sensitive.impl.ACFilter;
import com.mtlaa.mtchat.utils.sensitive.impl.DFAFilter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.locks.LockSupport;
import java.util.function.Supplier;


@Slf4j
public class OtherTest {
    @Test
    public void test1() throws InterruptedException {

    }
//    给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
//    树的 最大宽度 是所有层中最大的 宽度 。
//    每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。
//    将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
//    题目数据保证答案将会在  32 位 带符号整数范围内。
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int ret = 0;
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        Queue<Integer> indexQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        indexQueue.offer(1);
        while (!nodeQueue.isEmpty()){
            int n = nodeQueue.size();
            int start = 0, end = 0;
            for (int i = 0; i < n; i++) {
                TreeNode node = nodeQueue.poll();
                Integer index = indexQueue.poll();
                if (i == 0){
                    start = index;
                }
                if (i == n-1){
                    end = index;
                }
                if (node.left!=null){
                    nodeQueue.offer(node.left);
                    indexQueue.offer(index*2);
                }
                if (node.right!=null){
                    nodeQueue.offer(node.right);
                    indexQueue.offer(index*2+1);
                }
            }
            ret = Math.max(ret, end-start+1);
        }
        return ret;
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