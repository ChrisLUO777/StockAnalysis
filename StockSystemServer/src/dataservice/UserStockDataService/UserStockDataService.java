package dataservice.UserStockDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserStockPO;

public interface UserStockDataService  extends Remote {
	public ArrayList<String> getstocklist(UserStockPO user) throws RemoteException;
	public boolean insertStock(UserStockPO user) throws RemoteException;
	public boolean deleteStock(UserStockPO user) throws RemoteException;
}
