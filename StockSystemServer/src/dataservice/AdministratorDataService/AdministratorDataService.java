package dataservice.AdministratorDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.MemberPO;

public interface AdministratorDataService  extends Remote {
	public boolean login(MemberPO user) throws RemoteException;
	public String getright(MemberPO user) throws RemoteException;
	public boolean register(MemberPO user) throws RemoteException;
	public ArrayList<MemberPO> getallUserInfo() throws RemoteException;
	public boolean change(MemberPO user) throws RemoteException;
	public boolean changeright(MemberPO user) throws RemoteException;
}
