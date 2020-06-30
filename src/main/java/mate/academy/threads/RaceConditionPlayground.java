package mate.academy.threads;

public class RaceConditionPlayground {
    public static int sharedCounter = -1;

    public static void main(String[] args) {
        RunnableModel thread1 = new RunnableModel("Thread-1");
        ThreadModel thread2 = new ThreadModel("Thread-2");
        thread1.start();
        thread2.start();
    }
}
