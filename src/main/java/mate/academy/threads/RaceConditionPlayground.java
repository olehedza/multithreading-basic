package mate.academy.threads;

public class RaceConditionPlayground {
    private Long sharedCounter;

    public RaceConditionPlayground(Long sharedCounter) {
        this.sharedCounter = sharedCounter;
    }

    public Long getSharedCounter() {
        return sharedCounter;
    }

    public void setSharedCounter(Long sharedCounter) {
        this.sharedCounter = sharedCounter;
    }

    public static void main(String[] args) {
        RaceConditionPlayground playground = new RaceConditionPlayground(-1L);

        Thread thread1 = new Thread(new RunnableModel("Thread-1", playground));
        Thread thread2 = new ThreadModel("Thread-2", playground);
        thread1.start();
        thread2.start();
    }
}
