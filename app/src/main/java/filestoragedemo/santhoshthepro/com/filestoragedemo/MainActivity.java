package filestoragedemo.santhoshthepro.com.filestoragedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText edtMessage;
    TextView txtMessage;
    Button btnSave,btnRead;

    String data;
    private String file = "mydata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMessage=(EditText)findViewById(R.id.edtMessage);
        txtMessage=(TextView)findViewById(R.id.txtMessage);
        btnSave=(Button)findViewById(R.id.btnSave);
        btnRead=(Button)findViewById(R.id.btnRead);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=edtMessage.getText().toString();

                try {
                    FileOutputStream fOut = openFileOutput(file,MODE_WORLD_READABLE);
                    fOut.write(data.getBytes());
                    fOut.close();
                    Toast.makeText(getBaseContext(),"File saved successfully!",Toast.LENGTH_SHORT).show();
                }

                catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileInputStream fin = openFileInput(file);
                    int c;
                    String temp="";

                    while( (c = fin.read()) != -1){
                        temp = temp + Character.toString((char)c);
                    }

                    txtMessage.setText(temp);
                    Toast.makeText(getBaseContext(),"File read successfully!",Toast.LENGTH_SHORT).show();
                }
                catch(Exception e){
                }
            }
        });
    }
}
