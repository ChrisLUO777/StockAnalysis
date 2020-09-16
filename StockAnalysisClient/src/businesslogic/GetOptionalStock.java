package businesslogic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;   

import po.optionalStockPO;
public class GetOptionalStock {
	public ArrayList<optionalStockPO> getOptionalStock(String code,String start,String end){
		 try{  
			 String store="";
				ArrayList<optionalStockPO> output=new ArrayList<optionalStockPO>();
				 String input=code+"."+start+"."+end;
				 Process pr = Runtime.getRuntime().exec("python getdata.py");  
				 BufferedWriter out=new BufferedWriter(new OutputStreamWriter(pr.getOutputStream()));
				out.write("optional.");				
				out.write(input);
				out.flush();
				out.close();
				  BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));  
				   String line;  
				  while ((line = in.readLine()) != null) {  
				     store=store+line;
				    }  
				   in.close();  
				   pr.waitFor();  
				   System.out.println(store);
				   store=store.substring(store.indexOf("[")+1);
					 String[] trans=store.toString().split("\\}, \\{");
			 
			 for(int i=0;i<trans.length;i++){
				 optionalStockPO po=new optionalStockPO();
				 String[] data=trans[i].split(",");
				 po.setNum(Integer.parseInt(data[0].substring(data[0].indexOf(":")+2)));
				 po.setHighestPrice(Double.parseDouble(data[1].substring(data[1].indexOf(":")+1)));			 
				 po.setLowestPrice(Double.parseDouble(data[2].substring(data[2].indexOf(":")+1)));
				 po.setDate(data[3].substring(data[3].indexOf(":")+2));
				 po.setClosePrice(Double.parseDouble(data[4].substring(data[4].indexOf(":")+1)));
				 if(data[5].lastIndexOf("}")==-1){
				 po.setOpenPrice(Double.parseDouble(data[5].substring(data[5].indexOf(":")+1)));
				 }
				 else{
					 po.setOpenPrice(Double.parseDouble(data[5].substring(data[5].indexOf(":")+1,data[5].lastIndexOf("}"))));
				 }
				 po.setMoney((int)(po.getHighestPrice()+po.getLowestPrice())*po.getNum()/2);
				 output.add(po);
			 }
			 return output;
			 } catch (Exception e){  
			   e.printStackTrace();  
			   return null;
			  }  
		
		
	}
	public ArrayList<optionalStockPO> getOptionalStock(String code,int days){
		 try{  
			    String store="";
			    String start="";
				String end="";
				Date d=new Date();   
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				end=df.format(d);
				start=df.format(new Date(d.getTime() - days * 24 * 60 * 60 * 1000L));
				System.out.println("今天的日期："+end);   
				System.out.println("30天前的日期：" + start);  				
				ArrayList<optionalStockPO> output=new ArrayList<optionalStockPO>();
				 String input=code+"."+start+"."+end;
				 Process pr = Runtime.getRuntime().exec("python getdata.py");  
				 BufferedWriter out=new BufferedWriter(new OutputStreamWriter(pr.getOutputStream()));
				out.write("optional.");				
				out.write(input);
				out.flush();
				out.close();
				  BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));  
				   String line;  
				  while ((line = in.readLine()) != null) {  
				     store=store+line;
				    }  
				   in.close();  
				   pr.waitFor();  
				   System.out.println(store);
				   store=store.substring(store.indexOf("[")+1);
					 String[] trans=store.toString().split("\\}, \\{");
			 
			 for(int i=0;i<trans.length;i++){
				 optionalStockPO po=new optionalStockPO();
				 String[] data=trans[i].split(",");
				 po.setNum(Integer.parseInt(data[0].substring(data[0].indexOf(":")+2)));
				 po.setHighestPrice(Double.parseDouble(data[1].substring(data[1].indexOf(":")+1)));			 
				 po.setLowestPrice(Double.parseDouble(data[2].substring(data[2].indexOf(":")+1)));
				 po.setDate(data[3].substring(data[3].indexOf(":")+2));
				 po.setClosePrice(Double.parseDouble(data[4].substring(data[4].indexOf(":")+1)));
				 if(data[5].lastIndexOf("}")==-1){
				 po.setOpenPrice(Double.parseDouble(data[5].substring(data[5].indexOf(":")+1)));
				 }
				 else{
					 po.setOpenPrice(Double.parseDouble(data[5].substring(data[5].indexOf(":")+1,data[5].lastIndexOf("}"))));
				 }
				 po.setMoney((int)(po.getHighestPrice()+po.getLowestPrice())*po.getNum()/2);
				 output.add(po);
			 }
			 return output;
			 } catch (Exception e){  
			   e.printStackTrace();  
			   return null;
			  }  
		
		
	}
public static void main(String args[]){
	 ArrayList<optionalStockPO> testpo=new ArrayList<optionalStockPO>();
	 GetOptionalStock test=new GetOptionalStock();
	 testpo=test.getOptionalStock("sh600000",30);
	 System.out.println(testpo.size());
	 for(int i=0;i<testpo.size();i++){
		 System.out.println(testpo.get(i).getDate());
		 System.out.println(testpo.get(i).getOpenPrice());
		 System.out.println(testpo.get(i).getHighestPrice());
		 System.out.println(testpo.get(i).getClosePrice());
		 System.out.println(testpo.get(i).getLowestPrice());
		 System.out.println(testpo.get(i).getNum());
		 System.out.println(testpo.get(i).getMoney());
	 }
}
}