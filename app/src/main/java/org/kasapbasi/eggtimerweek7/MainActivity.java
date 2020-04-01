package org.kasapbasi.eggtimerweek7;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
SeekBar sb;
TextView tv;
Button btn;
boolean CounterisActive=false;
CountDownTimer str;

    public void controller(View v) {


        if (CounterisActive == false) {
            CounterisActive = true;
            sb.setEnabled(false);


            str = new CountDownTimer(sb.getProgress() * 1000 + 100, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {

                    progressTimer((int) millisUntilFinished / 1000);

                }

                @Override
                public void onFinish() {
                    MediaPlayer mc= MediaPlayer.create(MainActivity.this,R.raw.horn);
                    mc.start();
                    sb.setEnabled(true);
                    CounterisActive=false;
                    btn.setText("Go");
                }
            };

                btn.setText("Reset");
                str.start();

        }else
        {
            CounterisActive=false;
            str.cancel();
            btn.setText("Go");
            sb.setEnabled(true);
            sb.setProgress(30);
            progressTimer(30);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb=(SeekBar)findViewById(R.id.timerSeekBar);
        sb.setMax(600); //10 dakika için
        sb.setMin(1);
        sb.setProgress(30);
        btn=(Button)findViewById(R.id.btnController);

        tv= (TextView)findViewById(R.id.tvTimer);




        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                //ilk önce saniyeden dakika ve saniyeye dönüştürmek

                progressTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void progressTimer(int progress) {
        int minute;
        int seconds;
        minute= progress /60;
        seconds= progress-60*minute;
        String secondStr=Integer.toString(seconds);
        if(secondStr.equals("0"))
            secondStr="00";
        if(secondStr.length()<2)
            secondStr="0" +secondStr;
        tv.setText(Integer.toString(minute)+":"+secondStr);
    }
}
