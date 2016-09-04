package diplomski.thop.thopmobileclient.controller.implementation;

import java.util.List;

import diplomski.thop.thopmobileclient.controller.requests.GetPackageList;
import diplomski.thop.thopmobileclient.model.Package;


public class PackageImpl {

	public List<Package> getPackageList(){
		return new GetPackageList().getPackageList();
	}
	
	public int getPackageId(List<Package> packageList, String packageName) {
		for (Package p : packageList) {
			if (p.getPackageName().equalsIgnoreCase(packageName)) {
				return p.getPackageId();
			}
		}
		return -1;
	}
	
	public String getPackageName(List<Package> packageList, int packageId) {
		for (Package p : packageList) {
			if (p.getPackageId() == packageId) {
				return p.getPackageName();
			}
		}
		return null;
	}
}
