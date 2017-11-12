package ve.com.latinsoft.appnotepad.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ve.com.latinsoft.appnotepad.R;

public class LoginActivity extends AppCompatActivity {

    EditText ET_userName, ET_password;
    Button BT_login, BT_register;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences shared = getSharedPreferences("Usuarios", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putString("user","ed");
        editor.putString("password","ed");
        editor.commit();

        ET_userName = (EditText) findViewById(R.id.userName);
        ET_password = (EditText) findViewById(R.id.password);

        BT_login = (Button) findViewById(R.id.login);
        BT_register = (Button) findViewById(R.id.register);

        BT_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= ET_userName.getText().toString();
                String password= ET_password.getText().toString();
                SharedPreferences tmp = getSharedPreferences("Usuarios",Context.MODE_PRIVATE);
                String message ;
                boolean login =false;
                if(user.equals(tmp.getString("user",""))
                        && password.equals(tmp.getString("password",""))){
                    message = "Bienvenido a la aplicación "+user;
                    login = true;
                }
                else
                {
                    message = "Usuario o contraseña incorrecta";
                }

                Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();
                if(login){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        BT_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
