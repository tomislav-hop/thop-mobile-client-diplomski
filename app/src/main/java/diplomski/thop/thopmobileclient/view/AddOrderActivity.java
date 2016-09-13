package diplomski.thop.thopmobileclient.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import diplomski.thop.thopmobileclient.R;
import diplomski.thop.thopmobileclient.controller.implementation.OrderImpl;
import diplomski.thop.thopmobileclient.controller.implementation.StatusImpl;
import diplomski.thop.thopmobileclient.model.Order;
import diplomski.thop.thopmobileclient.model.Status;

public class AddOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);

        StatusImpl si = new StatusImpl();
        List<Status> statusList= si.getAllStatuses();

        List<String> statusNames = new ArrayList<String>();
        for (Status s : statusList) {
            statusNames.add(s.getStatusName());
        }

        String[] timeList = { "00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30" };
        List<String> timeStrings = new ArrayList<>();
        for(String s :timeList){
            timeStrings.add(s);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, statusNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinnerStatus = (Spinner)findViewById(R.id.spinner);
        spinnerStatus.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, timeStrings);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner timeSpinner = (Spinner)findViewById(R.id.timeSpinner);
        timeSpinner.setAdapter(adapter2);


        TextView name = (TextView)findViewById(R.id.txtName);
        TextView address =(TextView)findViewById(R.id.txtAddress);
        TextView notes = (TextView)findViewById(R.id.txtNotes);
        String selectedTime = timeSpinner.getSelectedItem().toString();


        DatePicker dp = (DatePicker)findViewById(R.id.datePicker);
        int day = dp.getDayOfMonth();
        int month = dp.getMonth() + 1;
        int year = dp.getYear();

        Button addOrder = (Button)findViewById(R.id.btnAddOrder);


        addOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monthString = "";
                if(month>9){
                    monthString = Integer.toString(month);
                }else{
                    monthString = "0" + Integer.toString(month);
                }

                String dayString = "";
                if(day>9){
                    dayString = Integer.toString(day);
                }else{
                    dayString = "0" + Integer.toString(day);
                }
                String dateAdd = year + "-" + monthString + "-" + dayString + " " + selectedTime + ":00";


                String selectedStatus = spinnerStatus.getSelectedItem().toString();
                int statusId = new StatusImpl().getStatusId(statusList, selectedStatus);


                Order addOrder = new Order(0, name.getText().toString(), address.getText().toString(), dateAdd, notes.getText().toString(), si.getStatusId(statusList, selectedStatus), LoginActivity.userID);
                OrderImpl oi = new OrderImpl();
                oi.sendAddOrderRequest(name.getText().toString(), address.getText().toString(), dateAdd, notes.getText().toString(), si.getStatusId(statusList, selectedStatus), LoginActivity.userID);
            }
        });
    }
}
