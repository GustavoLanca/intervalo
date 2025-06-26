package com.example.intervalo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText itNum;
    public Button btnAdicionar;
    private TextView tvResultado;

    String s1to25 = "Valores inseridos nesse intervalo: ";
    String s26to50 = "Valores inseridos nesse intervalo: ";
    String s51to75 = "Valores inseridos nesse intervalo: ";
    String s76to100 = "Valores inseridos nesse intervalo: ";
    boolean cond = false;
    int n1to25 = 0;
    int n26to50 = 0;
    int n51to75 = 0;
    int n76to100 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvResultado = findViewById(R.id.tvResultado);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        itNum = findViewById(R.id.itNum);

        btnAdicionar.setOnClickListener(op -> calc());
    }

    private void calc(){

        float num = Float.parseFloat(itNum.getText().toString());
            if (num >= 1 && num <= 25) {
                n1to25 = n1to25 + 1;
                s1to25 = s1to25 + "; " + num;
            } else if (num >= 26 && num <= 50) {
                n26to50 = n26to50 + 1;
                s26to50 = s26to50 + "; " + num;
            } else if (num >= 51 && num <= 75) {
                n51to75 = n51to75 + 1;
                s51to75 = s51to75 + "; " + num;
            } else if (num >= 76 && num <= 100) {
                n76to100 = n76to100 + 1;
                s76to100 = s76to100 + "; " + num;
            } else if (num == 0) {
                cond = true;
            }
        if (cond) {
            String s1 = "Resultado: Intervalo [1 - 25] = " + n1to25 + "\n " + s1to25;
            String s2 = "\nResultado: Intervalo [26 - 50] = " + n26to50 + "\n " + s26to50;
            String s3 = "\nResultado: Intervalo [51 - 75] = " + n51to75 + "\n " + s51to75;
            String s4 = "\nResultado: Intervalo [76 - 100] = " + n76to100 + "\n " + s76to100;
            String res = s1 + s2 + s3 + s4;
            tvResultado.setText(res);
            n1to25 = 0;
            n26to50 = 0;
            n51to75 = 0;
            n76to100 = 0;
            cond = false;
            s1to25 = "Valores inseridos nesse intervalo: ";
            s26to50 = "Valores inseridos nesse intervalo: ";
            s51to75 = "Valores inseridos nesse intervalo: ";
            s76to100 = "Valores inseridos nesse intervalo: ";
        }
        itNum.setText("");
    }

}