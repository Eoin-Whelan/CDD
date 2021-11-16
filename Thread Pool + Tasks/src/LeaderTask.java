public class LeaderTask implements Runnable {

    public int nextNum;
    public LeaderTask(int nextNum){
        this.nextNum = nextNum;
    }

    @Override
    public void run() {
        System.out.print(nextNum + " : ");
    }
}