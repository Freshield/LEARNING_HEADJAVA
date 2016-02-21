package chp18_2;

import java.rmi.*;

public interface ServiceServer extends Remote{
	
	public Object[] getServiceList() throws RemoteException;
	
	public Service getService(Object serviceKey) throws RemoteException;

}
