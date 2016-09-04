package diplomski.thop.thopmobileclient.controller.requests;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import diplomski.thop.thopmobileclient.model.OrderItems;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import diplomski.thop.thopmobileclient.controller.implementation.ItemImpl;
import diplomski.thop.thopmobileclient.controller.implementation.OrderImpl;
import diplomski.thop.thopmobileclient.controller.implementation.PackageImpl;
import diplomski.thop.thopmobileclient.controller.implementation.Urls;
import diplomski.thop.thopmobileclient.model.Order;

public class AddOrder {

	OkHttpClient client;
	OrderImpl orderImpl = new OrderImpl();
	PackageImpl packageImpl = new PackageImpl();
	ItemImpl itemImpl = new ItemImpl();
	
	

	public AddOrder() {
		client = new OkHttpClient();
	}

	public int sendAddOrderRequest(String orderedBy, String adress, String orderDate, String additionalNotes, int status_id, int user_id) {
		Order order = new Order(0, orderedBy, adress, orderDate, additionalNotes, status_id, user_id);
		String requestJson = new Gson().toJson(order);
		RequestBody body = RequestBody.create(Urls.JSON, requestJson);
		Request request = new Request.Builder().url(Urls.ADD_ORDER).post(body).build();
		try (Response response = client.newCall(request).execute()) {
			String returnResponse = response.body().string();
			if (returnResponse.contains("Order add failed:")) {
				return -1;
			} else {
				return Integer.parseInt(returnResponse);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
	}


	public boolean addItemsToOrder(int orderId, List<OrderItems> orderItemsList) {
		/*String[][] tableData = orderImpl.getTableData(model);
		List<OrderItems> orderItemList = new ArrayList<>();
		for (int i = 0; i < tableData.length; i++) {
			//TODO: Check dates which you are adding
			OrderItems oi = new OrderItems(0, itemImpl.getItemId(itemList, tableData[i][0]), tableData[i][1], Double.parseDouble(tableData[i][2]), tableData[i][1], orderImpl.parseCheckboxValue(tableData[i][3]), orderImpl.parseCheckboxValue(tableData[i][4]), orderImpl.parseCheckboxValue(tableData[i][5]), packageImpl.getPackageId(packageList, tableData[i][6]), tableData[i][7], tableData[i][9], idOrder, Integer.parseInt(tableData[i][8]));
			orderItemList.add(oi);
		}*/

		//TODO: Parse to json and send to server
		String requestJson = new Gson().toJson(orderItemsList);
		System.out.println(requestJson);

		RequestBody body = RequestBody.create(Urls.JSON, requestJson);
		Request request = new Request.Builder().url(Urls.ADD_FULL_ORDER + orderId).post(body).build();
		try (Response response = client.newCall(request).execute()) {
			String returnResponse = response.body().string();
			if (returnResponse.contains("Successfully added")) {
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
