package ThreadTest;

public class MyThread implements Runnable{
    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        System.out.println("Thread name: " + currentThread.getName());
        for(int i=1; i<=10; i++) {
            System.out.println("Thread "+currentThread.getName()+" is running: " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread());
        t1.setName("Allahu");
        t2.setName("Akbar");
        t1.setPriority(10);
        t2.setPriority(1);
        t1.start();
        try {
            t1.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
