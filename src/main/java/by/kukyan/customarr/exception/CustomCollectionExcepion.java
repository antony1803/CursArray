package by.kukyan.customarr.exception;

public class CustomCollectionExcepion extends Exception{
    public CustomCollectionExcepion(){
        super();
    }
    public CustomCollectionExcepion(String message){
        super(message);
    }
    public CustomCollectionExcepion(Throwable cause){
        super(cause);
    }
    public CustomCollectionExcepion(String message, Throwable cause){
        super(message, cause);
    }
}
