package data;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.MemberPO;
import database.DatabaseOperation;
import dataservice.AdministratorDataService.AdministratorDataService;



public class AdministratorData   extends UnicastRemoteObject implements AdministratorDataService {
	DatabaseOperation db=new DatabaseOperation();
	public AdministratorData() throws RemoteException {
		super();
	}

	@Override
	public boolean login(MemberPO user) throws RemoteException {
		boolean isSuccess = false;

		if(db.login(user)){
			isSuccess = true;
		}
		return isSuccess;
	}

	@Override
	public String getright(MemberPO user) throws RemoteException {
		MemberPO result = db.getUserInfo(user);
		return result.getright();
	}

	@Override
	public boolean register(MemberPO user) throws RemoteException {
		boolean isSuccess = false;
		if(db.insertUser(user)){
			isSuccess = true;
		}
		return isSuccess;
	}

	@Override
	public ArrayList<MemberPO> getallUserInfo() throws RemoteException{
		// TODO Auto-generated method stub
		return db.getAllUserInfo();
	}

	@Override
	public boolean change(MemberPO user) throws RemoteException {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		if(db.changeUserPassword(user)){
			isSuccess = true;
		}
		return isSuccess;
	}

	@Override
	public boolean changeright(MemberPO user) throws RemoteException {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		if(db.changeUserright(user)){
			isSuccess = true;
		}
		return isSuccess;
	}

}
