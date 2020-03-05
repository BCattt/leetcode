package com.bcat.mt.easy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Solution for LeetCode multi-thread problem 1114.Print in Order.
 *
 * Suppose we have a class:
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().
 *
 *  
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: "firstsecondthird"
 * Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
 * Example 2:
 *
 * Input: [1,3,2]
 * Output: "firstsecondthird"
 * Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.
 *  
 *
 * <b>Note:</b>
 *
 * We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seems to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.
 *
 * @author <a href="zjebusiness@gmail.com">赵峻</a>
 */
public class PrintInOrderSol {
    static class Foo {
        private AtomicInteger atomInt = new AtomicInteger(0);
        private Lock lock = new ReentrantLock();

        public Foo() {

        }

        public void first(Runnable printFirst) {
            if (atomInt.get() == 0) {
                try {
                    lock.lock();
                    printFirst.run();
                    atomInt.getAndIncrement();
                } finally {
                    lock.unlock();
                }
            }
        }
        public void second(Runnable printSecond) throws InterruptedException {
            while (atomInt.get() != 1) {
                TimeUnit.MILLISECONDS.sleep(10);
            }
            try {
                lock.lock();
                printSecond.run();
                atomInt.getAndIncrement();
            } finally {
                lock.unlock();
            }
        }
        public void third(Runnable printThird) throws InterruptedException {
            while (atomInt.get() != 2) {
                TimeUnit.MILLISECONDS.sleep(10);
            }
            try {
                lock.lock();
                printThird.run();
                atomInt.getAndIncrement();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Runnable p1 = () -> System.out.print("First");
        Runnable p2 = () -> System.out.print("Second");
        Runnable p3 = () -> System.out.print("Third");

//        final Foo foo = new Foo();
//        // [1, 2, 3]
//        new Thread(() -> foo.first(p1)).run();
//        new Thread(() -> foo.second(p2)).run();
//        new Thread(() -> foo.third(p3)).run();

        System.out.println();

        final Foo foo1 = new Foo();
        // [2, 1, 3]
        new Thread(() -> {
            try {
                foo1.second(p2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> foo1.first(p1)).start();
        new Thread(() -> {
            try {
                foo1.third(p3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
