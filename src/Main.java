
public class Main {

    public static void main(String[] args) {
        Action ac = new Action();

        Thread calc = new Thread(new CalculateThread(ac, 10));
        Thread print = new Thread(new PrintThread(ac));
        Thread save = new Thread(new SaveThread(ac));

        calc.start();
        print.start();
        save.start();
        try {
            save.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
