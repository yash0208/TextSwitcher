package com.rajaryan.textswitcher;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextSwitcher textSwitcher;
    private Button nextButton;
    private int stringIndex = 0;
    private String[] row = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX"};
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textSwitcher = findViewById(R.id.textSwitcher);
        nextButton = findViewById(R.id.button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stringIndex == row.length - 1) {
                    stringIndex = 0;
                    textSwitcher.setText(row[stringIndex]);
                } else {
                    textSwitcher.setText(row[++stringIndex]);
                }
            }
        });
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                textView = new TextView(MainActivity.this);
                textView.setTextColor(Color.BLACK);
                textView.setTextSize(60);
                textView.setGravity(Gravity.CENTER_HORIZONTAL);
                return textView;
            }
        });
        textSwitcher.setText(row[stringIndex]);
    }
}