package database;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.translator.R;

public class inserting extends AppCompatActivity {

    EditText edEng, edJpn;
    DatabaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserting);

        edEng = findViewById(R.id.title);
        edJpn = findViewById(R.id.content);

        dbHandler = new DatabaseHandler(this);
    }
    public void btnAdd(View v){

        String titles = edEng.getText().toString();
        String contents = edJpn.getText().toString();

        boolean  status = dbHandler.addWord(titles,contents);

        if (status)
            Toast.makeText(this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Insert Failed", Toast.LENGTH_SHORT).show();


    }
}