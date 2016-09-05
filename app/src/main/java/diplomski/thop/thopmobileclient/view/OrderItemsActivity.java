package diplomski.thop.thopmobileclient.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import diplomski.thop.thopmobileclient.R;
import diplomski.thop.thopmobileclient.adapters.ListViewAdapterItems;
import diplomski.thop.thopmobileclient.controller.implementation.OrderImpl;
import diplomski.thop.thopmobileclient.model.Constants;
import diplomski.thop.thopmobileclient.model.Order;
import diplomski.thop.thopmobileclient.model.OrderItems;

public class OrderItemsActivity extends AppCompatActivity {

    private ArrayList<HashMap<String, String>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_items);
        final ListView viewOrderItems = (ListView) findViewById(R.id.itemListView);
        OrderImpl oi = new OrderImpl();
        List<OrderItems> orderItemsList = oi.getOrderItemsList(ViewOrderHistoryActivity.orderID);
        populateList(orderItemsList);
        ListViewAdapterItems adapter = new ListViewAdapterItems(this, list);
        viewOrderItems.setAdapter(adapter);
    }

    private void populateList(List<OrderItems> orderItemsList) {
        list = new ArrayList<HashMap<String, String>>();
        for (OrderItems o : orderItemsList) {
            HashMap<String, String> temp = new HashMap<String, String>();
            temp.put(Constants.FIRST_COLUMN, String.valueOf(o.getId_item()));
            temp.put(Constants.SECOND_COLUMN, o.getDeadline());
            temp.put(Constants.THIRD_COLUMN, String.valueOf(o.getWeight()));
            temp.put(Constants.FOURTH_COLUMN, (o.getDelivery() == 1) ? "Yes" : "No");
            temp.put(Constants.FIFTH_COLUMN, (o.getCool() == 1) ? "Yes" : "No");
            temp.put(Constants.SIXTH_COLUMN, (o.getCut() == 1) ? "Yes" : "No");
            temp.put(Constants.SEVENTH_COLUMN, String.valueOf(o.getId_package()));
            temp.put(Constants.EIGTH_COLUMN, o.getAdditionalNotes());
            temp.put(Constants.NINTH_COLUMN, String.valueOf(o.getAmount()));
            temp.put(Constants.TENTH_COLUMN, o.getDeliveryTime());
            list.add(temp);
        }
    }
}
