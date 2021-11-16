package lab.six;

public class Main {

    public static void main(String[] args) {

        CircularBuffer buffer = new CircularBuffer();
        for(int i = 0; i < 20; i++){
            buffer.put(i);
        }
        for(int i = 0; i < 10; i++){
            System.out.println(buffer.get());
        }
    }
}
