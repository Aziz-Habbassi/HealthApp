package tn.rnu.isi.healthapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.content.Intent;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText editName, editAge,editHeight,editWeight;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editAge = findViewById(R.id.editAge);
        editHeight = findViewById(R.id.editHeight);
        editWeight = findViewById(R.id.editWeight);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(v -> {
            String name = editName.getText().toString();
            String age = editAge.getText().toString();
            String height = editHeight.getText().toString();
            String weight = editWeight.getText().toString();


            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("name", name);
            bundle.putString("age", age);
            bundle.putString("height", height);
            bundle.putString("weight", weight);
            intent.putExtras(bundle);
            startActivityForResult(intent, 101);
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == RESULT_OK) {
            String retour = data.getStringExtra("message");
            Snackbar.make(findViewById(android.R.id.content), retour, Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK", v -> {})
                    .show();
        }

    }


}
