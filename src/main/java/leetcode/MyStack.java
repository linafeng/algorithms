package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> inputQueue;
    private Queue<Integer> outputQueue;

    /** Initialize your data structure here. */
    public MyStack() {
        inputQueue=new LinkedList<Integer>();
        outputQueue=new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (inputQueue.isEmpty()) {
            outputQueue.offer(x);
        }else{
            inputQueue.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(inputQueue.isEmpty()){
            int lastone=0;
            while (!outputQueue.isEmpty()){
                lastone=outputQueue.poll();
                if(!outputQueue.isEmpty()){
                    inputQueue.offer(lastone);
                }
            }
            return lastone;
        }else{
            int lastone=0;
            while (!inputQueue.isEmpty()){
                lastone=inputQueue.poll();
                if(!inputQueue.isEmpty()) {
                    outputQueue.offer(lastone);
                }
            }
            return lastone;
        }
    }

    /** Get the top element. */
    public int top() {
        if(inputQueue.isEmpty()){
            int lastone=0;
            while (!outputQueue.isEmpty()){
                lastone=outputQueue.poll();
                inputQueue.offer(lastone);
            }
            return lastone;
        }else{
            int lastone=0;
            while (!inputQueue.isEmpty()){
                lastone=inputQueue.poll();
                outputQueue.offer(lastone);
            }
            return lastone;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return inputQueue.isEmpty()&&outputQueue.isEmpty();
    }
}


