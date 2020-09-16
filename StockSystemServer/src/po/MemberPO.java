package po;

import java.io.Serializable;

public class MemberPO implements Serializable{
	
	private String adminid;
	private String key;
	private String right;

	
	public MemberPO(String adminid,String key,String right){
		setadminid(adminid);
		setkey(key);
		setright(right);
	}

	public MemberPO() {
		// TODO Auto-generated constructor stub
	}

	public void setright(String right) {
		// TODO Auto-generated method stub
		this.right=right;
	}

	public void setkey(String key) {
		// TODO Auto-generated method stub
		this.key=key;
	}

	public void setadminid(String adminid) {
		// TODO Auto-generated method stub
		this.adminid=adminid;
	}
	public String getadminid(){
		return adminid;
	}
	public String getkey(){
		return key;
	}
	public String getright(){
		return right;
	}

}
