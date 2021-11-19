public class IntegerObj {
    public int value;
    public IntegerObj(int num){
        this.value = num;
    }
    void inc(){
        try {
            this.value++;
        }
        catch(Exception e){
        }
        //return this.value;
    }
}
