package com.kristin.java.lockDemo;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2018/7/4 11:02
 * @desc CLH锁
 **/

/**
 * 差异：
 * 从代码实现来看，CLH比MCS要简单得多。
 * 从自旋的条件来看，CLH是在前驱节点的属性上自旋，而MCS是在本地属性变量上自旋。
 * 从链表队列来看，CLH的队列是隐式的，CLHNode并不实际持有下一个节点；MCS的队列是物理存在的。
 * CLH锁释放时只需要改变自己的属性，MCS锁释放则需要改变后继节点的属性。
 */
public class CLHLock {
    private static final AtomicReferenceFieldUpdater<CLHLock, CLHNode> UPDATER = AtomicReferenceFieldUpdater
            .newUpdater(CLHLock.class, CLHNode.class, "tail");
    @SuppressWarnings("unused")
    private volatile CLHNode tail;

    public void lock(CLHNode currentThread) {
        CLHNode preNode = UPDATER.getAndSet(this, currentThread);
        if (preNode != null) {//已有线程占用了锁，进入自旋
            while (preNode.isLocked) {
            }
        }
    }

    public void unlock(CLHNode currentThread) {
        // 如果队列里只有当前线程，则释放对当前线程的引用（for GC）。
        if (!UPDATER.compareAndSet(this, currentThread, null)) {
            // 还有后续线程
            currentThread.isLocked = false;// 改变状态，让后续线程结束自旋
        }
    }

    public static class CLHNode {
        private volatile boolean isLocked = true; // 默认是在等待锁
    }
}
