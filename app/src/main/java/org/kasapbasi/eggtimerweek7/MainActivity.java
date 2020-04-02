package org.kasapbasi.eggtimerweek7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
SeekBar sb;
TextView tv;
Button btn;

public void tiklaBeni(View v){

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
                int minute;
                int second;
                minute =(int) progress/60;
                second = progress-60*minute;

                tv.setText(minute+":"+second);


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
