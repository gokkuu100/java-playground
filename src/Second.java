public class Second extends Thread {
    public static int amount = 0;

    public static void main(String[] args) {
        Second thread = new Second();
        thread.start();
        System.out.println(amount);
        amount++;
        System.out.println(amount);
    }

    @Override
    public void run() {
        amount++;
    }
}




