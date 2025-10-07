package tn.rnu.isi.healthapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ProgressBar;

public class Screen3Activity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button btnNext;
    private int progress = 0;
    private Handler handler = new Handler();
    private boolean isRunning = true;

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (isRunning) {
                progress++;
                progressBar.setProgress(progress);
                if (progress < 100) {
                    handler.postDelayed(this, 100); // update every 100ms
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);

        // Initialize views
        progressBar = findViewById(R.id.progressBar);
        btnNext = findViewById(R.id.btnNext);

        // Start the progress bar
        handler.post(runnable);

        // Next button navigates to Screen2Activity
        btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(Screen3Activity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        isRunning = false; // Pause progress bar when app is paused
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (progress < 100) {
            isRunning = true;
            handler.post(runnable); // Resume progress bar
        }
    }
}
