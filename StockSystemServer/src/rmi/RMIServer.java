package rmi;

import ip.IP;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ErrorFrame.errorFrame;
import ErrorFrame.ipErrorFrame;
import data.AdministratorData;
import data.UserStockData;
import dataservice.AdministratorDataService.AdministratorDataService;
import dataservice.UserStockDataService.UserStockDataService;


public class RMIServer {
	public static void startserver(){
		try {

			AdministratorDataService adminstratordata = new AdministratorData();
			UserStockDataService userstockdata = new UserStockData();
			LocateRegistry.createRegistry(7777);
			Naming.rebind("rmi://"+IP.ip+"/rmi.adminstratordata", adminstratordata);
			Naming.rebind("rmi://"+IP.ip+"/rmi.userstockdata", userstockdata);            
			System.out.println("start");
		} catch (RemoteException e) {
			errorFrame.getInstance();
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			
			ipErrorFrame.getInstance();
			e.printStackTrace();
		} 
	}
}
