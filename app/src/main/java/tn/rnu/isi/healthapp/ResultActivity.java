package tn.rnu.isi.healthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
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
        String recommendation;

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String name = bundle.getString("name");
            String age = bundle.getString("age");
            String weightStr = bundle.getString("weight");
            double weight = Double.parseDouble(weightStr);
            String heightStr = bundle.getString("height");
            double height = Double.parseDouble(heightStr);
            double calories =10*weight+6.25*height-5*Double.parseDouble(age)+5;
            double protein = (calories * 0.20) / 4;
            double carbs = (calories * 0.50) / 4;
            double fat = (calories * 0.30) / 9;
            txtInfo.setText("Hello " + name + " 👋\nYou are " + age + " years old.\nKeep staying healthy by providing \n"+"Calories: " + String.format("%.0f", calories) + " kcal\n" +
                    "Protein " + String.format("%.0f", protein) + " g\n" +
                    "Carbs: " + String.format("%.0f", carbs) + " g\n" +
                    "Fat: " + String.format("%.0f", fat) + " g");
            recommendation="to build muscle: take "+weight*1.8+" g protein\n"+"For fat loss: reduce to"+(calories-(calories*0.2))+"kcal";
        } else {
            recommendation = "";
        }


        btnBack.setOnClickListener(v -> {
            Intent retourIntent = new Intent();
            retourIntent.putExtra("message",  recommendation);
            setResult(Activity.RESULT_OK, retourIntent);
            finish();
        });
    }
}
