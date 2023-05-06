import java.util.LinkedList;

public class ProducerConsumer {

    private static final LinkedList<Integer> BUFFER = new LinkedList<Integer>();
    private static final int BUFFER_SIZE = 5;

    public static void main(String[] args) {
        
        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());

        
        producer.start();
        consumer.start();
    }

    private static class Producer implements Runnable {
        private int value = 0;

        @Override
        public void run() {
            while (true) {
                synchronized (BUFFER) {
                    
                    while (BUFFER.size() == BUFFER_SIZE) {
                        try {
                            BUFFER.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    
                    BUFFER.add(value);
                    System.out.println("Produced: " + value);
                    value++;

                   
                    BUFFER.notify();
                }

               
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (BUFFER) {
                    
                    while (BUFFER.isEmpty()) {
                        try {
                            BUFFER.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    
                    int value = BUFFER.removeFirst();
                    System.out.println("Consumed: " + value);

                    
                    BUFFER.notify();
                }

               
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
