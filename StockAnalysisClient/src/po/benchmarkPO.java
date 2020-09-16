package po;



public class benchmarkPO {
private String date="";
private double close=0;
private double open=0;
public String getDate(){
	return this.date;
}
public double getOpen(){
	return this.open;
}
public double getClose(){
return this.close;
}
public void setDate(String input){
	this.date=input;
}
public void setOpen(double input){
	this.open=input;
}
public void setClose(double input){
	this.close=input;
}
}
