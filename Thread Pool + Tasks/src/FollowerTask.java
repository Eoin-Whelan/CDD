public class FollowerTask implements Runnable {

    public int nextChar;
    public FollowerTask(int nextChar){
        this.nextChar = nextChar;
    }


    @Override
    public void run() {
        System.out.println((char) nextChar);
    }
}
