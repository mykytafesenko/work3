package com.example.labwork3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Button myButton;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.edit);
        Spinner spinner = findViewById(R.id.spin);
        Button button = findViewById(R.id.button1);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        button.setOnClickListener(view -> {
            String text = editText.getText().toString();
            if (!TextUtils.isEmpty(text)) {
                adapter.add(text);
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        });
        myButton = findViewById(R.id.button2);
        radioButton1 = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener((radioGroup1, checkedId) -> {
            if (checkedId == R.id.radioButton) {
                myButton.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.radioButton2) {
                myButton.setVisibility(View.GONE);
            }
        });
    }
}
