package diplomski.thop.thopmobileclient.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import diplomski.thop.thopmobileclient.R;
import diplomski.thop.thopmobileclient.controller.implementation.LoginImpl;

public class LoginActivity extends AppCompatActivity {

    public static int userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText txtUsername = (EditText) findViewById(R.id.txtUsername);
        final EditText txtPassword = (EditText) findViewById(R.id.txtPassword);
        final Button btnLogin = (Button) findViewById(R.id.btnLogin);

        txtUsername.setText("test");
        txtPassword.setText("test");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    LoginImpl li = new LoginImpl();
                    userID = li.login(txtUsername.getText().toString(), txtPassword.getText().toString());

                    if (userID != -1) {
                        Intent mainMenu = new Intent(LoginActivity.this, MainMenuActivity.class);
                        LoginActivity.this.startActivity(mainMenu);
                    } else {
                        new AlertDialog.Builder(LoginActivity.this)
                                .setTitle("Login failed")
                                .setMessage("Incorrect username or password!")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                }).show();
                    }
                }
            }
        });
    }
}
