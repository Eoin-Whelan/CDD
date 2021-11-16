package lab.six;

public class CircularBuffer {

    final int BUFFER_SIZE = 9;
    int writePos = -1;
    int readPos = 0;

    int[] buffer = new int[BUFFER_SIZE];

    public CircularBuffer(){

    }

    public Integer get(){
        if(!isEmpty()){
            int retrievedInt = buffer[readPos];
            readPos++;
            return retrievedInt;
        }
        else{
            return null;
        }
    }

    public void put(int inputNum){
        if(isFull()){
            writePos = 0;
        }
        else{
            writePos++;
        }
        buffer[writePos] = inputNum;
    }

    private boolean isEmpty(){
        return (writePos < readPos);
    }

    private boolean isFull(){
        return (writePos >= BUFFER_SIZE -1);
    }
}
