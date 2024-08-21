package com.example.demo.controller;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {

        //Implement a stack using two queues.
        Stack<Queue> stk = new Stack<>();

        Queue<String> que1 = new LinkedList<>();
        que1.add("one");
        que1.add("two");
        stk.add(que1);

        Queue<String> que2 = new LinkedList<>();
        que2.add("three");
        que2.add("four");
        stk.add(que2);

        System.out.println(stk);



    }
}
