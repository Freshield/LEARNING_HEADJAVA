package chp18_2;

import java.rmi.*;
import java.util.*;
import java.rmi.server.*;

public class ServiceServerImpl extends UnicastRemoteObject implements ServiceServer{
	
	HashMap serviceList;
	
	public ServiceServerImpl() throws RemoteException{
		setUpServices();
	}
	
	private void setUpServices(){
		serviceList = new HashMap();
		serviceList.put("Dice_Rolling_Service", new DiceService());
		serviceList.put("Day_of_the_Week_Service", new DayOfTheWeekService());
		serviceList.put("Visual_Music_Service", new MiniMusicService());
		
	}
	
	public Object[] getServiceList(){
		System.out.println("in remote");
		return serviceList.keySet().toArray();
	}
	
	public Service getService(Object serviceKey) throws RemoteException{
		Service theServie = (Service) serviceList.get(serviceKey);
		return theServie;
	}

	public static void main(String[] args) {
		try{
			
			Naming.rebind("ServiceServer", new ServiceServerImpl());
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		System.out.println("Remote service is running");

	}

}
