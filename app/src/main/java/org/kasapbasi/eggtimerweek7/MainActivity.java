package org.kasapbasi.eggtimerweek7;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.*;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
SeekBar sb;
TextView tv;
Button btn;
CountDownTimer cdt;


public void tiklaBeni(View v){

cdt = new CountDownTimer(sb.getProgress()*1000,1000) {
    @Override
    public void onTick(long millisUntilFinished) {

        timerUpdate((int) millisUntilFinished/1000);
    }

    @Override
    public void onFinish() {
        MediaPlayer mp= MediaPlayer.create(MainActivity.this,R.raw.horn);
        mp.start();

    }
};

cdt.start();

}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb=(SeekBar)findViewById(R.id.timerSeekBar);
        tv=(TextView)findViewById(R.id.tvTimer);

        sb.setMax(600);
        sb.setMin(0);
        sb.setProgress(30);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                timerUpdate(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




    }

    private void timerUpdate(int progress) {
        int minute;
        int second;
        minute = progress /60;
        second = progress-60*minute;

        tv.setText(minute+":"+second);
    }
}
