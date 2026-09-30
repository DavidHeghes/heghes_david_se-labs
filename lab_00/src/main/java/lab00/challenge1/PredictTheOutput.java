package lab00.challenge1;

public class PredictTheOutput {

    static void mutate(Box b) {
        b.value = 42;
    }

    static void replace(Box b) {
        b = new Box();
        b.value = 99;
    }

    public static void run() {
        Box box = new Box();
        mutate(box);
        replace(box);
        System.out.println("box.value = " + box.value);
    }
}
