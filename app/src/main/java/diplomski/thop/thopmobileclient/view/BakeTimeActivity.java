package diplomski.thop.thopmobileclient.view;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import diplomski.thop.thopmobileclient.R;
import diplomski.thop.thopmobileclient.controller.implementation.ItemImpl;
import diplomski.thop.thopmobileclient.model.Item;

public class BakeTimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bake_time);

        final EditText txtWeight = (EditText) findViewById(R.id.txtWeight);
       // final EditText txtBakeTime = (EditText) findViewById(R.id.txtBakeTime);
        final Button btnCalculate = (Button) findViewById(R.id.btnCalculate);
        final TextView lblBakeTime = (TextView) findViewById(R.id.lblBakeTime);

        ItemImpl ii = new ItemImpl();
        List<Item> itemList = ii.getItemList();

        List<String> itemNames = new ArrayList<String>();
        for (Item i : itemList) {
            itemNames.add(i.getItemName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinnerItems = (Spinner) findViewById(R.id.itemSpinner);
        spinnerItems.setAdapter(adapter);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemId = ii.getItemId(itemList, spinnerItems.getSelectedItem().toString());
                //txtBakeTime.setText(ii.getBakeTime(itemId, txtWeight.getText().toString()));
                //txtBakeTime.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                lblBakeTime.append(" " + ii.getBakeTime(itemId, txtWeight.getText().toString()));
                //testlblBakeTime.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
            }
        });
    }
}
