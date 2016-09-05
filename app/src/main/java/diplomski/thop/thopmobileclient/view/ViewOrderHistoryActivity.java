package diplomski.thop.thopmobileclient.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import diplomski.thop.thopmobileclient.model.Constants;
import diplomski.thop.thopmobileclient.adapters.ListViewAdapter;
import diplomski.thop.thopmobileclient.R;
import diplomski.thop.thopmobileclient.controller.implementation.OrderImpl;
import diplomski.thop.thopmobileclient.model.Order;

public class ViewOrderHistoryActivity extends AppCompatActivity {

    private ArrayList<HashMap<String, String>> list;
    public static String orderID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order_history);
        final ListView viewOrderHistoryListView = (ListView) findViewById(R.id.orderHistoryListView);
        OrderImpl oi = new OrderImpl();
        List<Order> orderList = oi.getOrderList(LoginActivity.userID);
        populateList(orderList);
        ListViewAdapter adapter = new ListViewAdapter(this, list);
        viewOrderHistoryListView.setAdapter(adapter);
        viewOrderHistoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getItemAtPosition(position).toString();
                orderID = getSelectedId(selected);
                Intent orderItems = new Intent(ViewOrderHistoryActivity.this, OrderItemsActivity.class);
                ViewOrderHistoryActivity.this.startActivity(orderItems);
            }
        });

    }

    private void populateList(List<Order> orderList) {
        list = new ArrayList<HashMap<String, String>>();
        for (Order o : orderList) {
            HashMap<String, String> temp = new HashMap<String, String>();
            temp.put(Constants.FIRST_COLUMN, String.valueOf(o.getOrderId()));
            temp.put(Constants.SECOND_COLUMN, o.getOrderOrdered());
            temp.put(Constants.THIRD_COLUMN, o.getOrderAdress());
            //temp.put(Constants.FOURTH_COLUMN,o.getOrderDate());
            //temp.put(Constants.FIFTH_COLUMN, o.getAdditionalNotes());
            temp.put(Constants.SIXTH_COLUMN, String.valueOf(o.getStatusId()));
            list.add(temp);
        }
    }

    private String getSelectedId(String selected){
        String segments[] = selected.split("=");
        String returnString = "";
        int counter = 0;
        for(String s : segments){
            if(s.contains("First")){
                String segments2[] = segments[counter+1].split(",");
                return returnString = segments2[0];
            }
            counter++;
        }
        return null;
    }
}
