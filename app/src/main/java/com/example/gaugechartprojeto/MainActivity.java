package com.example.gaugechartprojeto;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import com.ekn.gruzer.gaugelibrary.HalfGauge;
import com.ekn.gruzer.gaugelibrary.Range;

public class MainActivity extends AppCompatActivity {

    private HalfGauge halfGauge;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        halfGauge = findViewById(R.id.halfGauge);
        seekBar = findViewById(R.id.seekBar);

        // Configurar os intervalos de cor
        Range range1 = new Range();
        range1.setColor(Color.parseColor("#008000"));
        range1.setFrom(0.0);
        range1.setTo(50.0);

        Range range2 = new Range();
        range2.setColor(Color.parseColor("#eead2d"));
        range2.setFrom(50.0);
        range2.setTo(100.0);

        Range range3 = new Range();
        range3.setColor(Color.parseColor("#FF0000"));
        range3.setFrom(100.0);
        range3.setTo(150.0);

        // Adicionando os intervalos de cor ao gauge
        halfGauge.addRange(range1);
        halfGauge.addRange(range2);
        halfGauge.addRange(range3);

        // Definindo os valores mínimo, máximo e atual
        halfGauge.setMinValue(0.0);
        halfGauge.setMaxValue(150.0);
        halfGauge.setValue(0.0);

        // Configurando o SeekBar
        seekBar.setMax(150);
        seekBar.setProgress(0);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                halfGauge.setValue(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Não há nada aqui propositalmente.
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Não há nada aqui propositalmente.
            }
        });
    }
}