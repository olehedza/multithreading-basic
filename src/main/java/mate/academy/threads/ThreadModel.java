package mate.academy.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadModel extends Thread {
    private final String threadName;
    private final RaceConditionPlayground playground;

    public ThreadModel(String name, RaceConditionPlayground playground) {
        threadName = name;
        this.playground = playground;
    }

    public void run() {
        try {
            while (playground.getSharedCounter() < 100) {
                playground.setSharedCounter(playground.getSharedCounter() + 1);
                log.debug(threadName + ": counter = "
                        + playground.getSharedCounter());
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }
}
