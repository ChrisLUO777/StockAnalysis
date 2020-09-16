package po;

import java.io.Serializable;

public class UserStockPO implements Serializable{
	private String userid;
	private String stockid;
	public UserStockPO(String userid,String stockid){
		setuserid(userid);
		setstockid(stockid);
	}
	public void setuserid(String userid){
		this.userid = userid;
	}
	public void setstockid(String stockid){
		this.stockid = stockid;
	}
	public String getuserid(){
		return userid;
	}
	public String getstockid(){
		return stockid;
	}
}
