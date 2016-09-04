package diplomski.thop.thopmobileclient.controller.implementation;

import java.util.List;

import diplomski.thop.thopmobileclient.controller.requests.GetBakeTime;
import diplomski.thop.thopmobileclient.controller.requests.GetItemList;
import diplomski.thop.thopmobileclient.model.Item;

public class ItemImpl {

	public List<Item> getItemList() {
		return new GetItemList().getItemList();
	}

	public String getBakeTime(int itemId, String kg){
		return new GetBakeTime().getBakeTimeResponse(itemId, kg);
	}

	public int getItemId(List<Item> itemList, String itemName) {

		for (Item i : itemList) {
			if (i.getItemName().equalsIgnoreCase(itemName)) {
				return i.getItemId();
			}
		}
		return -1;
	}

	public String getItemName(List<Item> itemList, int itemId) {

		for (Item i : itemList) {
			if (i.getItemId() == itemId) {
				return i.getItemName();
			}
		}
		return null;
	}
}
