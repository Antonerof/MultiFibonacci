
public class PrintThread implements Runnable {
    public PrintThread(Action ac) {
        this.ac = ac;
    }

    private Action ac;

    @Override
    public void run() {
        while (!ac.isStop()) {
            ac.printFib();
            System.out.println(ac.getFib());
        }

    }
}
