public class Task implements Runnable {

    public int jobNum;
    public Task(int jobNum){
        this.jobNum = jobNum;
    }


    @Override
    public void run() {
        System.out.println("Task: " + jobNum + " now complete");
    }
}
