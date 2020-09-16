package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import po.MemberPO;
import po.UserStockPO;


public class UserStockDatabase {
    private Connection con=null;
    private int num = 0;
    //��ݿ�����
	public UserStockDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stockdatabase?autoReconnect=true&useUnicode=true&characterEncoding=utf8","root","");
			System.out.println("Success!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Fail to connect the database!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Fail to connect the database!");
		}
	}
	

	 public boolean checkUserStock(String userid,String stockid) {
	        boolean isOK = true;
	        try {
	            Statement st = con.createStatement();
	            ResultSet rs = st
	                    .executeQuery("select * from userstock where userid='" + userid
	                    		+ "' and stockid='" + stockid+"';");
	            if (rs.next()) {
	                isOK = false;
	            }
	            st.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return isOK;
	    }
	
	
	 public boolean insertStock(UserStockPO userstock) {
	        boolean isSuccess = false;
	        if(checkUserStock(userstock.getuserid(),userstock.getstockid())){
		        try {
		            Statement st = con.createStatement();
		            int rs = st.executeUpdate("insert into userstock values('"+userstock.getuserid()+"','"+userstock.getstockid()+"')");
		            if (rs > 0) {
		                isSuccess = true;
		            }
		            st.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
	        }
	        else{
	        	System.out.println("已经存在");
	        }
	        return isSuccess;
	    }
	 
	 public boolean deleteStock(UserStockPO userstock) {
	        boolean isSuccess = false;

	            try {
	                Statement st = con.createStatement();
	                int rs = st.executeUpdate("delete from userstock where userid='"
	                        + userstock.getuserid() + "' and stockid='" + userstock.getstockid()+"';");
	        
	                if (rs > 0) {
	                    isSuccess = true;
	                }
	                st.close();
	            } catch (Exception e) {
	                return false;
	            }
	        return isSuccess;
	    }
	 

	    
		public ArrayList<String> getStockList(UserStockPO userstock) {

			ArrayList<String> result = new ArrayList<String>() ;
			String userid = userstock.getuserid();
	        try {
	            Statement st = con.createStatement();
	            ResultSet rs = st
	                    .executeQuery("select * from userstock where userid='" + userid +"';");
	            while (rs.next()) {
	            	String tempstock = rs.getString("stockid");
	            	result.add(tempstock);
	            }
	           
	            st.close();
	        } catch (Exception e) {
	            return result;
	        }
	        return result;
	    }
		


	 public static void main(String[] args){
		 UserStockPO test2 = new UserStockPO("user","sh512110");
		 UserStockDatabase test = new UserStockDatabase();
		 if(test.deleteStock(test2)){
			 System.out.println("true");
		 }
		 ArrayList<String> a = test.getStockList(test2);
		 for(int i = 0;i<a.size();i++){
			 System.out.println(a.get(i));
		 }
//		 if(test.insertUser(member)){
//			 System.out.println("true");
//		 }
//		 ArrayList<MemberPO> memberPOs=test.getAllUserInfo();
//		 for(int i = 0;i<memberPOs.size();i++){
//			 System.out.println(""+memberPOs.get(i).getadminid()+" "+memberPOs.get(i).getkey()+" "+memberPOs.get(i).getright());
//		 }
//		 if(test.deleteUser(member.getadminid())){
//			 System.out.println("delete");
//		 }
//		 if(test.login(test1)){ 
//			 System.out.println("exist");
//
//		 }
//		 else{
//			 System.out.println("not exist");
//
//		 }
		 
//		 if (test.changeUserPassword(test1)){
//			 System.out.println("password has been changed");
//		 }
//		 
//		 System.out.println(test.getUserInfo(test1).getright());
	 }
}
