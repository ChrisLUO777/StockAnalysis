package data;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.MemberPO;
import po.UserStockPO;
import database.UserStockDatabase;
import dataservice.UserStockDataService.UserStockDataService;



public class UserStockData extends UnicastRemoteObject implements UserStockDataService {
		UserStockDatabase db=new UserStockDatabase();
		public UserStockData() throws RemoteException {
			super();
		}
		@Override
		public ArrayList<String> getstocklist(UserStockPO userstock) throws RemoteException{
			ArrayList<String> result=db.getStockList(userstock);
			return result;
		}
		@Override
		public boolean insertStock(UserStockPO userstock) throws RemoteException {
			boolean isOK = false;
			if(db.insertStock(userstock)){
				isOK=true;
			}
			return isOK;
		}
		@Override
		public boolean deleteStock(UserStockPO userstock) throws RemoteException {
			boolean isOK = false;
			if(db.deleteStock(userstock)){
				isOK=true;
			}
			return isOK;
		}



}
