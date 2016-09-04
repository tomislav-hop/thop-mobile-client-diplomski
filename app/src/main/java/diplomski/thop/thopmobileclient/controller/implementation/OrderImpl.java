package diplomski.thop.thopmobileclient.controller.implementation;

import java.util.List;

import diplomski.thop.thopmobileclient.controller.requests.AddOrder;
import diplomski.thop.thopmobileclient.controller.requests.GetOrderItemsList;
import diplomski.thop.thopmobileclient.controller.requests.GetOrders;
import diplomski.thop.thopmobileclient.model.Order;
import diplomski.thop.thopmobileclient.model.OrderItems;

public class OrderImpl {

	public int sendAddOrderRequest(String orderedBy, String adress, String orderDate, String additionalNotes, int status_id, int user_id) {
		return new AddOrder().sendAddOrderRequest(orderedBy, adress, orderDate, additionalNotes, status_id, user_id);
	}

	public boolean addItemsToOrder(int orderId, List<OrderItems> orderItemsList) {
		return new AddOrder().addItemsToOrder(orderId, orderItemsList);
	}

	public List<Order> getOrderList(int userId) {
		return new GetOrders().getOrderList(userId);
	}

	public List<OrderItems> getOrderItemsList(String orderId) {
		return new GetOrderItemsList().getOrderItemsList(orderId);
	}

	public int parseCheckboxValue(String value) {
		if (value.equalsIgnoreCase("Yes")) {
			return 1;
		} else {
			return 0;
		}
	}
}
