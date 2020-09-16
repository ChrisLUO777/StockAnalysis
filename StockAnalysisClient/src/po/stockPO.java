package po;


public class stockPO{
		String id;
		double openPrice;
		double closePrice;
		String date;
		public stockPO(){
			
		}
		public stockPO(String id,double openPrice,double closePrice){
			this.id = id;
			this.openPrice = openPrice;
			this.closePrice = closePrice;
		}
		public void setDate(String stuff){
			this.date=stuff;
		}
		public void setId(String stuff){
			this.id=stuff;
		}
		public void setOpenPrice(double stuff){
			this.openPrice=stuff;
		}
		public void setClosePrice(double stuff){
			this.closePrice=stuff;
		}
		public String getId(){
			return id;
		}
		public double getOpenPrice(){
			return openPrice;
		}
		public double getClosePrice(){
			return closePrice;
		}
		public String getDate(){
			return date;
		}
	}
