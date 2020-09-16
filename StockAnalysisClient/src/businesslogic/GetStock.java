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

import po.stockPO;
public class GetStock {
	public ArrayList<stockPO> getStock(String code,String start,String end){
		 try{  
				String store="";
				ArrayList<stockPO> output=new ArrayList<stockPO>();				 
				 String input=code+"."+start+"."+end;
				 Process pr = Runtime.getRuntime().exec("python getdata.py");  
				 BufferedWriter out=new BufferedWriter(new OutputStreamWriter(pr.getOutputStream()));
				out.write("stock.");				
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
				 stockPO po=new stockPO();
				 String[] data=trans[i].split(",");
				 po.setId(code);
				 po.setDate(data[0].substring(data[0].indexOf(":")+2));
				 po.setClosePrice(Double.parseDouble(data[1].substring(data[1].indexOf(":")+1)));
				 if(data[2].lastIndexOf("}")==-1){
				 po.setOpenPrice(Double.parseDouble(data[2].substring(data[2].indexOf(":")+1)));
				 }
				 else{
					 po.setOpenPrice(Double.parseDouble(data[2].substring(data[2].indexOf(":")+1,data[2].lastIndexOf("}"))));
				 }
				 output.add(po);
			 }
			 return output;
			 } catch (Exception e){  
			   e.printStackTrace();  
			   return null;
			  }  
		
		
	}
	public ArrayList<stockPO> getStock(String code,int days){
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
				ArrayList<stockPO> output=new ArrayList<stockPO>();				 
				 String input=code+"."+start+"."+end;
				 Process pr = Runtime.getRuntime().exec("python getdata.py");  
				 BufferedWriter out=new BufferedWriter(new OutputStreamWriter(pr.getOutputStream()));
				out.write("stock.");				
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
				 stockPO po=new stockPO();
				 String[] data=trans[i].split(",");
				 po.setId(code);
				 po.setDate(data[0].substring(data[0].indexOf(":")+2));
				 po.setClosePrice(Double.parseDouble(data[1].substring(data[1].indexOf(":")+1)));
				 if(data[2].lastIndexOf("}")==-1){
				 po.setOpenPrice(Double.parseDouble(data[2].substring(data[2].indexOf(":")+1)));
				 }
				 else{
					 po.setOpenPrice(Double.parseDouble(data[2].substring(data[2].indexOf(":")+1,data[2].lastIndexOf("}"))));
				 }
				 output.add(po);
			 }
			 return output;
			 } catch (Exception e){  
			   e.printStackTrace();  
			   return null;
			  }  
		
		
	}
	public stockPO getStock(String code){
		 try{  
			 int days=10;
				String store="";
				String start="";
				String end="";
				Date d=new Date();   
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
				end=df.format(d);
				start=df.format(new Date(d.getTime() - days * 24 * 60 * 60 * 1000L));
				System.out.println("今天的日期："+end);   
				System.out.println("30天前的日期：" + start);  				
				ArrayList<stockPO> output=new ArrayList<stockPO>();				 
				 String input=code+"."+start+"."+end;
				 Process pr = Runtime.getRuntime().exec("python getdata.py");  
				 BufferedWriter out=new BufferedWriter(new OutputStreamWriter(pr.getOutputStream()));
				out.write("stock.");				
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
				 stockPO po=new stockPO();
				 String[] data=trans[i].split(",");
				 po.setDate(data[0].substring(data[0].indexOf(":")+2));
				 po.setClosePrice(Double.parseDouble(data[1].substring(data[1].indexOf(":")+1)));
				 if(data[2].lastIndexOf("}")==-1){
				 po.setOpenPrice(Double.parseDouble(data[2].substring(data[2].indexOf(":")+1)));
				 }
				 else{
					 po.setOpenPrice(Double.parseDouble(data[2].substring(data[2].indexOf(":")+1,data[2].lastIndexOf("}"))));
				 }
				 output.add(po);
			 }
			 return output.get(output.size()-1);
			 } catch (Exception e){  
			   e.printStackTrace();  
			   return null;
			  }  
		
		
	}
public static void main(String args[]){
	 ArrayList<stockPO> testpo=new ArrayList<stockPO>();
	 GetStock test=new GetStock();
	 testpo=test.getStock("sh600519",30);
	 System.out.println(testpo.size());
	 for(int i=0;i<testpo.size();i++){
		 System.out.println(testpo.get(i).getDate());
		 System.out.println(testpo.get(i).getClosePrice());
		 System.out.println(testpo.get(i).getOpenPrice());
	 }
}
}