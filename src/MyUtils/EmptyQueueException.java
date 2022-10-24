package MyUtils;

public class EmptyQueueException extends Throwable{
    public EmptyQueueException(){
        this(null);
    }

    public EmptyQueueException(String message){
        super("Empty Deque");
    }
}
