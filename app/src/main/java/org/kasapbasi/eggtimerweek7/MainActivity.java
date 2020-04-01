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
        sb.setProgress(30);
        tv= (TextView)findViewById(R.id.tvTimer);



        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                //ilk önce saniyeden dakika ve saniyeye dönüştürmek

                int minute;
                int seconds;
                minute=(int) progress/60;
                seconds= progress-60*minute;
                String secondStr=Integer.toString(seconds);
                if(secondStr.equals("0"))
                    secondStr="00";
                if(secondStr.length()<2)
                    secondStr="0" +secondStr;
                tv.setText(Integer.toString(minute)+":"+secondStr);
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
