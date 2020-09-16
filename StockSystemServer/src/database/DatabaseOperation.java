package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ErrorFrame.errorFrame;
import po.MemberPO;


public class DatabaseOperation{
	    private Connection con=null;
	    private int num = 0;
	    //��ݿ�����
		public DatabaseOperation() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stockdatabase?autoReconnect=true&useUnicode=true&characterEncoding=utf8","root","");
				System.out.println("Success!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				errorFrame.getInstance();
				System.out.println("Fail to connect the database!");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Fail to connect the database!");
			}
		}
		
		 public boolean checkUser(String userId) {
		        boolean isOK = false;
		        try {
		            Statement st = con.createStatement();
		            ResultSet rs = st
		                    .executeQuery("select * from user where userid='"
		                            + userId + "';");
		            while (rs.next()) {
		                isOK = true;
		                break;
		            }
		            st.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        return isOK;
		    }
		
		public boolean login(MemberPO user) {
			boolean issuccess = false;
			String userid = user.getadminid();
			String password = user.getkey();
	        try {
	            Statement st = con.createStatement();
	            ResultSet rs = st
	                    .executeQuery("select * from user where userid='" + userid
	                    		+ "' and password='" + password+"';");
//	            + "' and right='"+ right
	            if (rs.next()) {
	                issuccess = true;
	            }
	           
	            st.close();
	        } catch (Exception e) {
	            return issuccess;
	        }
	        return issuccess;
	    }
		
		 public boolean insertUser(MemberPO user) {
		        boolean isSuccess = false;
		        if (!checkUser(user.getadminid())) {
			        try {
			            Statement st = con.createStatement();
			            int rs = st.executeUpdate("insert into user values('"+user.getadminid()+"','"+user.getkey()+"','"+user.getright()+"')");
			            if (rs > 0) {
			                isSuccess = true;
			            }
			            st.close();
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
		        }
		        else{
		        	System.out.println("have existed this user");
		        }
		        return isSuccess;
		    }
		 
		 public boolean deleteUser(String id) {
		        boolean isSuccess = false;
		        if (checkUser(id)) {
		            try {
		                Statement st = con.createStatement();
		                int rs = st.executeUpdate("delete from user where userid='"
		                        + id + "';");
		        
		                if (rs > 0) {
		                    isSuccess = true;
		                }
		                st.close();
		            } catch (Exception e) {
		                return false;
		            }
		        } else {
		            System.out.println("No such man!");
		        }
		        return isSuccess;
		    }
		 
		    public boolean changeUserPassword(MemberPO user) {
		        // TODO Auto-generated method stub
		        boolean isSuccess = false;

		        try {
		            Statement st = con.createStatement();
		            int rs = st.executeUpdate("update user set password='"
		                    + user.getkey() + "' where userid='" + user.getadminid() + "';");
		            if (rs > 0) {
		                isSuccess = true;
		            }
		            st.close();
		        } catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		        return isSuccess;
		    }
		    public boolean changeUserright(MemberPO user) {
		        // TODO Auto-generated method stub
		        boolean isSuccess = false;
//		        System.out.println(user.getright());
//		        System.out.println(user.getadminid());
		        try {
		            Statement st = con.createStatement();
		            int rs = st.executeUpdate("update user set `right`='"
		                    + user.getright() + "' where userid='" + user.getadminid() + "';");
		            if (rs > 0) {
		                isSuccess = true;
		            }
		            st.close();
		        } catch (SQLException e) {
		            // TODO Auto-generated catch block
		        	
		            e.printStackTrace();
		        }
		        return isSuccess;
		    }
		    
			public MemberPO getUserInfo(MemberPO user) {
				MemberPO resultUser = new MemberPO("","","");
				String userid = user.getadminid();
				String password = user.getkey();
		        try {
		            Statement st = con.createStatement();
		            ResultSet rs = st
		                    .executeQuery("select * from user where userid='" + userid
		                    		+ "' and password='" + password+"';");
//		            + "' and right='"+ right
		            if (rs.next()) {
		            	resultUser.setadminid(userid);
		            	resultUser.setkey(password);
		            	resultUser.setright(rs.getString("right"));
		            }
		           
		            st.close();
		        } catch (Exception e) {
		            return resultUser;
		        }
		        return resultUser;
		    }
			
			public ArrayList<MemberPO> getAllUserInfo(){
				ArrayList<MemberPO>  memeberPOs=new ArrayList();
		        try {
		            Statement st = con.createStatement();
		            ResultSet rs = st
		                    .executeQuery("select * from user");
//		            + "' and right='"+ right
		            while (rs.next()) {
		            	MemberPO resultUser = new MemberPO("","","");
		            	resultUser.setadminid(rs.getString("userid"));
		            	resultUser.setkey(rs.getString("password"));
		            	resultUser.setright(rs.getString("right"));
		            	memeberPOs.add(resultUser);
		            }
		           
		            st.close();
		        } catch (Exception e) {
		            return memeberPOs;
		        }
		        return memeberPOs;
			}

		 public static void main(String[] args){
			 MemberPO member = new MemberPO("storage","","storage");
			 MemberPO test1 = new MemberPO("administrator","111111","");
			 DatabaseOperation test = new DatabaseOperation();
			 if(test.changeUserright(member)){
				 System.out.println("true");
			 }
//			 if(test.insertUser(member)){
//				 System.out.println("true");
//			 }
//			 ArrayList<MemberPO> memberPOs=test.getAllUserInfo();
//			 for(int i = 0;i<memberPOs.size();i++){
//				 System.out.println(""+memberPOs.get(i).getadminid()+" "+memberPOs.get(i).getkey()+" "+memberPOs.get(i).getright());
//			 }
//			 if(test.deleteUser(member.getadminid())){
//				 System.out.println("delete");
//			 }
//			 if(test.login(test1)){ 
//				 System.out.println("exist");
//
//			 }
//			 else{
//				 System.out.println("not exist");
//
//			 }
			 
//			 if (test.changeUserPassword(test1)){
//				 System.out.println("password has been changed");
//			 }
//			 
//			 System.out.println(test.getUserInfo(test1).getright());
		 }
}
