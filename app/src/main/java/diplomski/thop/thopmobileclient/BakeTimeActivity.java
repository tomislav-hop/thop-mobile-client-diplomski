package diplomski.thop.thopmobileclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class BakeTimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bake_time);

        final EditText txtItem = (EditText) findViewById(R.id.txtItem);
        final EditText txtWeight = (EditText) findViewById(R.id.txtWeight);
        final EditText txtBakeTime = (EditText) findViewById(R.id.txtBakeTime);
        final Button btnCalculate = (Button) findViewById(R.id.btnCalculate);





    }
}
