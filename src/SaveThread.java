import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SaveThread implements Runnable {

    private Action ac;

    public SaveThread(Action ac) {
        this.ac = ac;
    }

    @Override
    public void run() {

        try (PrintWriter writer = new PrintWriter("fib.txt")) {
            while (!ac.isStop()) {
                ac.saveFib();
                writer.println(ac.getFib());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
