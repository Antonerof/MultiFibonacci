import java.math.BigInteger;

public class Action {

    private BigInteger fib;

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public Action() {
        semafor = 0;
        stop = false;
    }

    private int semafor;
    private boolean stop;

    public synchronized void calculate(BigInteger fib) {

        while (semafor != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        setFib(fib);
        semafor = 1;
        notifyAll();
    }

    public synchronized void printFib() {
        while (semafor != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        semafor = 2;
        notifyAll();
    }

    public synchronized void saveFib() {
        while (semafor != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        semafor = 0;
        notifyAll();
    }

    public BigInteger getFib() {
        return fib;
    }

    public void setFib(BigInteger fib) {
        this.fib = fib;
    }
}
