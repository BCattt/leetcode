package com.bcat.interview.medium;

/**
 * Solution for LeetCode interview problem 59-II 队列的最大值.
 *
 * <p>请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * <p><b>示例1: </b>
 * {@code
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * }
 * <p><b>示例2: </b>
 * {@code
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 * }
 *
 * <p><b>解题思路: </b>
 * 此题的描述不清楚，首先，输入未描述清楚; 其次，输出未描述清楚。
 * 应该是这样的:
 * 输入是一系列操作及给的参数, 输出是操作结果.
 * <p>思路1:
 * 此Queue仅仅做push_back和pop_front操作, 可以使用单向链表实现。由于要求max_value的时间复杂度为O(1),
 * 可以考虑增加一个指针来记录当前链表的排序, 当进行push_back和pop_front时, 维护此升序序列;
 *
 * @author <a href="zjebusiness@gmail.com">BCat</a>
 */
public class MaxValueInQueueSol {
    private static class Node {
        int val;
        Node next;
        // 升序序列中下一个节点
        Node orderNext;
        // 升序序列中上一个节点
        Node orderPrev;
        public Node(int x) {
            val = x;
        }
    }

    /**
     * 队首
     */
    private Node queueHead;
    private Node queueRear;
    /**
     * 当前最大值节点
     */
    private Node maxNode;

    public MaxValueInQueueSol() {
        queueHead = queueRear = new Node(-1);
    }

    public int max_value() {
        return null == maxNode ? -1 : maxNode.val;
    }

    public void push_back(int value) {
        Node newNode = new Node(value);
        // 将新节点增加到队列
        queueRear.next = newNode;
        queueRear = newNode;

        if (maxNode == null) {
            maxNode = newNode;
            return;
        } else if (maxNode.val <= value) {
            maxNode.orderNext = newNode;
            newNode.orderPrev = maxNode;
            maxNode = newNode;
            return;
        }

        Node insertPos = maxNode;
        // 将节点插入到升序序列的适当位置
        while (null != insertPos.orderPrev && insertPos.val > newNode.val) {
            insertPos = insertPos.orderPrev;
        }
        if (null == insertPos.orderPrev && insertPos.val > newNode.val) {
            insertPos.orderPrev = newNode;
            newNode.orderNext = insertPos;
        } else {
            newNode.orderNext = insertPos.orderNext;
            insertPos.orderNext.orderPrev = newNode;
            insertPos.orderNext = newNode;
            newNode.orderPrev = insertPos;
        }
    }

    public int pop_front() {
        if (queueHead == queueRear) {
            return -1;
        }
        Node popNode = queueHead.next;
        queueHead.next = popNode.next;
        // 维护升序序列
        if (null != popNode.orderPrev) {
            popNode.orderPrev.orderNext = popNode.orderNext;
        }
        if (null != popNode.orderNext) {
            popNode.orderNext.orderPrev = popNode.orderPrev;
        }
        if (maxNode == popNode) {
            maxNode = popNode.orderPrev;
        }
        if (popNode == queueRear) {
            queueRear = queueHead;
        }
        return popNode.val;
    }

    public static void main(String[] args) {
        MaxValueInQueueSol queue = new MaxValueInQueueSol();
        String[] opArray = {"MaxQueue","max_value","pop_front","pop_front","max_value","max_value","pop_front","pop_front","push_back","pop_front","pop_front","max_value","push_back","max_value","push_back","push_back","max_value","pop_front","pop_front","push_back","push_back","push_back","push_back","push_back","pop_front","pop_front","push_back","pop_front","max_value","max_value","max_value","max_value","pop_front","max_value","pop_front","push_back","push_back","pop_front","pop_front","pop_front","push_back","max_value","pop_front","push_back","pop_front","pop_front","push_back","max_value","push_back","push_back","pop_front","pop_front","max_value","pop_front","push_back","push_back","pop_front","push_back","pop_front","max_value","push_back","max_value","max_value","pop_front","push_back","pop_front","push_back","push_back","max_value","max_value","max_value","pop_front","max_value","pop_front","push_back","push_back","pop_front","max_value","push_back","pop_front","pop_front","pop_front","push_back","push_back","push_back","max_value","pop_front","push_back","push_back","max_value","max_value","pop_front","pop_front","max_value","pop_front","max_value","pop_front","max_value","push_back","max_value"};
        int[][] operandArray = {{},{},{},{},{},{},{},{},{450},{},{},{},{717},{},{567},{383},{},{},{},{673},{689},{636},{473},{674},{},{},{706},{},{},{},{},{},{},{},{},{718},{608},{},{},{},{172},{},{},{837},{},{},{756},{},{756},{126},{},{},{},{},{538},{6},{},{737},{},{},{383},{},{},{},{898},{},{426},{636},{},{},{},{},{},{},{54},{573},{},{},{534},{},{},{},{783},{940},{377},{},{},{565},{586},{},{},{},{},{},{},{},{},{},{63},{}};
        System.out.println(operations(queue, opArray, operandArray));
    }

    public static String operations(MaxValueInQueueSol queue, String[] opArray, int[][] operandArray) {
        StringBuilder result = new StringBuilder("null,");
        for(int i = 0; i < opArray.length; ++i) {
            switch (opArray[i]) {
                case "max_value" :
                    result.append(queue.max_value()).append(",");
                    break;
                case "pop_front":
                    result.append(queue.pop_front()).append(",");
                    break;
                case "push_back":
                    queue.push_back(operandArray[i][0]);
                    result.append("null,");
                    break;
                default:
                    break;
            }
        }
        return result.toString();
    }
}


