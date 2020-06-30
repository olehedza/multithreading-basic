package mate.academy.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunnableModel implements Runnable {
    private Thread thread;
    private final String threadName;

    public RunnableModel(String name) {
        threadName = name;
    }

    public void run() {
        try {
            for (int i = 0; i <= 50; i++) {
                RaceConditionPlayground.sharedCounter++;
                log.debug(threadName + ": counter = "
                        + RaceConditionPlayground.sharedCounter);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting");
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}
