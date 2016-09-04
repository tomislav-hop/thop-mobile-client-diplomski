package diplomski.thop.thopmobileclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        final Button btnAddOrder = (Button) findViewById(R.id.btnAddOrder);
        final Button btnViewHistory = (Button) findViewById(R.id.btnViewOrderHistory);
        final Button btnbakeTime = (Button) findViewById(R.id.btnBakeTime);


        btnbakeTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainMenu = new Intent(MainMenu.this, BakeTimeActivity.class);
                MainMenu.this.startActivity(mainMenu);
            }
        });

    }
}
