import java.math.BigInteger;

public class CalculateThread implements Runnable {

    Action ac;
    int n;

    public CalculateThread(Action ac, int n) {
        this.ac = ac;
        this.n = n;
    }

    @Override
    public void run() {
        BigInteger last = new BigInteger("0");
        BigInteger last2 = new BigInteger("1");
        BigInteger fib;

        for (int i = 0; i < n; i++) {
            fib = last.add(last2);
            ac.calculate(fib);
            last2 = last;
            last = fib;
        }

        ac.setStop(true);
    }
}
