import org.testng.annotations.Test;

import java.util.Arrays;


public class Day2 {
    @Test
    public void testPrintEvenNumbers() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0)
                System.out.println(i);
        }
    }

    @Test
    public void printHelloAtEvenNumbers() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) System.out.println("hello world");
        }
    }

    @Test
    public void testCountLetters() {
        String input = "hello world";
        int result = 0;
        for (char eachChar : input.toCharArray()) {
            if (eachChar == 'l') result++;
        }
        System.out.println(result);
    }

    @Test
    public void testswapTwoNumbersInArray() {
        int[] array = {1, 2, 3, 4};
        swap(array, 1, 2);
        System.out.println(Arrays.toString(array));

    }

    private void swap(int[] array, int indexL, int indexR) {
        int temp = array[indexL];
        array[indexL] = array[indexR];
        array[indexR] = temp;
    }


    @Test
    public void testClassObjects() {
        Actor actor1 = new Actor();
        Actor actor2 = new Actor( "Arnold","Schwarzenegger", 45 );
        actor2.act();
        actor2.play();
        actor2.retire();
    }

    @Test
    public void testLoops() {
        int i = 0;
        while (i <5){
            System.out.println("While loop: i="+i);
            i++;
        }
    }
}











