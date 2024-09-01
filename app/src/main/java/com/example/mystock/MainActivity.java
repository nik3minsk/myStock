package com.example.mystock;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> zxingActivityResultLauncher;
    private TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button scanButton = findViewById(R.id.scan_button);

        // Инициация сканирования
        IntentIntegrator intentIntegrator = new IntentIntegrator(this);
        zxingActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    IntentResult intentResult = IntentIntegrator.parseActivityResult(result.getResultCode(), result.getData());
                    if (intentResult != null && intentResult.getContents() != null) {
                        Toast.makeText(this, intentResult.getContents(), Toast.LENGTH_LONG).show();
                    }
                }
        );

        // Запуск сканирования
        scanButton.setOnClickListener(v -> {
            statusTextView.setText("Подготовка к сканированию");
            statusTextView.setVisibility(TextView.VISIBLE);

            new Handler().postDelayed(() -> {
                statusTextView.setVisibility(TextView.GONE);
                zxingActivityResultLauncher.launch(intentIntegrator.createScanIntent());
            }, 2000); // Задержка 2 секунды
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                // Обработка отмены сканирования
                System.out.println("Сканирование отменено");
            } else {
                // Обработка результата сканирования
                System.out.println("Отсканировано: " + result.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
