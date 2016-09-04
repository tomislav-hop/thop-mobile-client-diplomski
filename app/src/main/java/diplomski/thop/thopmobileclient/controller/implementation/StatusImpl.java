package diplomski.thop.thopmobileclient.controller.implementation;


import java.util.List;

import diplomski.thop.thopmobileclient.controller.requests.GetStatusList;
import diplomski.thop.thopmobileclient.model.Status;

public class StatusImpl {
	
	public List<Status> getAllStatuses(){
		return new GetStatusList().getStatusList();
	}
	
	public int getStatusId(List<Status> statusList, String selectedStatus) {
		for (Status s : statusList) {
			if (s.getStatusName().equalsIgnoreCase(selectedStatus)) {
				return s.getStatusId();
			}
		}
		return -1;
	}
	
	public String getStatusName(List<Status> statusList, int idStatus) {
		for (Status s : statusList) {
			if (s.getStatusId()==idStatus) {
				return s.getStatusName();
			}
		}
		return null;
	}


}
