package org.kasapbasi.eggtimerweek7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
SeekBar sb;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb=(SeekBar)findViewById(R.id.timerSeekBar);
        sb.setMax(600); //10 dakika için
        sb.setMin(1);
        tv= (TextView)findViewById(R.id.tvTimer);



        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                //ilk önce saniyeden dakika ve saniyeye dönüştürmek

                int minute;
                int seconds;
                minute=(int) progress/60;
                seconds= progress-60*minute;
                tv.setText(Integer.toString(minute)+":"+Integer.toString(seconds));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
