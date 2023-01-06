public class DynamicCircularQueue extends CircularQueue {
    public DynamicCircularQueue(){
        super();
    }
    public DynamicCircularQueue(int size){
        super(size);
    }

    public boolean insert( int item ) throws Exception{
        if( this.isFull() ){
            //create new array of double size
            int[] temp = new int[data.length*2];
            //copy all the previous element in the new array
            for( int i = 0 ; i < size ; i++){
                temp[i] = data[(front + i) % data.length];
            }
            front = 0;
            end = data.length;
            data = temp;
        }
        super.insert(item);
        return true;
    }
}
