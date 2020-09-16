package po;


public class optionalStockPO {
String date;
double openPrice;
double highestPrice;
double closePrice;
double lowestPrice;
int num;
int money;
public optionalStockPO(){
	
}
public optionalStockPO(String date,double openPrice,double highestPrice,double closePrice,double lowestPrice,int num,int money){
	this.date = date;
	this.openPrice = openPrice;
	this.highestPrice = highestPrice;
	this.closePrice = closePrice;
	this.lowestPrice = lowestPrice;
	this.num = num;
	this.money = money;
}
public void setDate(String stuff){
	this.date=stuff;
}
public void setOpenPrice(double stuff){
	this.openPrice=stuff;
}
public void setHighestPrice(double stuff){
	this.highestPrice=stuff;
}
public void setClosePrice(double stuff){
	this.closePrice=stuff;
}
public void setLowestPrice(double stuff){
	this.lowestPrice=stuff;
}
public void setNum(int stuff){
	this.num=stuff;
}
public void setMoney(int stuff){
	this.money=stuff;
}
public String getDate(){
	return date;
}
public double getOpenPrice(){
	return openPrice;
}
public double getHighestPrice(){
	return highestPrice;
}
public double getClosePrice(){
	return closePrice;
}
public double getLowestPrice(){
	return lowestPrice;
}
public int getNum(){
	return num;
}
public int getMoney(){
	return money;
}
}
