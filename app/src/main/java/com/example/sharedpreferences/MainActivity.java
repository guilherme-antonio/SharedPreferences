package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button buttonSalvar;
    private TextView textResultado;
    private EditText editText;

    private static final String PREFERENCIAS_FILE = "Notas";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSalvar = findViewById(R.id.buttonSalvar);
        editText = findViewById(R.id.editText);
        textResultado = findViewById(R.id.textView);

        buttonSalvar.setOnClickListener(clickSalvar);
        sharedPreferences = getSharedPreferences(PREFERENCIAS_FILE, 0);
        editor = sharedPreferences.edit();
    }

    private final Button.OnClickListener clickSalvar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            editor.putString("nota",editText.getText().toString());
            editor.commit();
        }
    };
}
