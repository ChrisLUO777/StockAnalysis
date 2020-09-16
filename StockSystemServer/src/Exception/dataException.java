package Exception;

public class dataException extends Exception{
public dataException(String s){
	super(s);
}
public dataException(Exception e){
	super(e);
}
}
