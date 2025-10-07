package tn.rnu.isi.healthapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class ResultActivity extends AppCompatActivity {

    TextView txtInfo;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtInfo = findViewById(R.id.txtInfo);
        btnBack = findViewById(R.id.btnBack);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString("name");
            String age = bundle.getString("age");
            String weightStr = bundle.getString("weight");
            double weight = Double.parseDouble(weightStr);
            String heightStr = bundle.getString("height");
            double height = Double.parseDouble(heightStr);
            double bmr =10*weight+6.25*height-5*Double.parseDouble(age)+5;
            txtInfo.setText("Hello " + name + " 👋\nYou are " + age + " years old.\nKeep staying healthy by providing "+String.valueOf(bmr*1.55)+" Calories");
        }

        btnBack.setOnClickListener(v -> finish());
    }
}
