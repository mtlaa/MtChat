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
        Supplier<String> supplier = this::toString;
        System.out.println(supplier.get());
    }
//    给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
//    判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
//
//    叶子节点 是指没有子节点的节点。
    boolean ret = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root==null){
            return;
        }
        targetSum = targetSum - root.val;
        if (root.left==null&&root.right==null&&targetSum==0) ret = true;
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
    }
//    给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//    你可以假设数组是非空的，并且给定的数组总是存在多数元素。
    public int majorityElement(int[] nums) {
        int ret = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==ret){
                count++;
            } else {
                count--;
            }
            if (count == 0){
                count = 1;
                ret = nums[i];
            }
        }
        return ret;
    }
//    给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//    请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ret = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])){
                continue;
            }
            int count = 0;
            for (int j = nums[i];set.contains(j);j++){
                count++;
                set.remove(j);
            }
            for (int j = nums[i]-1;set.contains(j);j--){
                count++;
                set.remove(j);
            }
            ret = Math.max(ret, count);
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