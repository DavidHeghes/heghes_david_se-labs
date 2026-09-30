package lab00.challenge2;

import lab00.challenge1.Box;

public class Swap {

    static void swap(Box a, Box b) {
        Box tmp = a;
        a = b;
        b = tmp;
    }

    static void swapContents(Box a, Box b) {
        int tmp = a.value;
        a.value = b.value;
        b.value = tmp;
    }

    public static void run() {
        Box a = new Box();
        Box b = new Box();
        a.value = 1;
        b.value = 2;

        swap(a, b);
        System.out.println("after swap:         a = " + a.value + ", b = " + b.value);

        swapContents(a, b);
        System.out.println("after swapContents: a = " + a.value + ", b = " + b.value);
    }
}
