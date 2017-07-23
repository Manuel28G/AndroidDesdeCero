package ve.com.latinsoft.appnotepad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    private static boolean press=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.texto);
        button = (Button)findViewById(R.id.boton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!press) {
                    textView.setText("Este texto se ha cambiado");
                }
                else
                {
                    textView.setText("Hola Mundo");
                }
                press = !press;

            }
        });
    }
}
