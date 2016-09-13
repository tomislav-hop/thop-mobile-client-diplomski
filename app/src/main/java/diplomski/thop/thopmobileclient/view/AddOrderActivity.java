package diplomski.thop.thopmobileclient.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.List;

import diplomski.thop.thopmobileclient.R;
import diplomski.thop.thopmobileclient.controller.implementation.StatusImpl;
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

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, statusNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinnerStatus = (Spinner)findViewById(R.id.spinner);
        spinnerStatus.setAdapter(adapter);

        TimePicker tp = (TimePicker)findViewById(R.id.timePicker);
        tp.setIs24HourView(true);
    }
}
