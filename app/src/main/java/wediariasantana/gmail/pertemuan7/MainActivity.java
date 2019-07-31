package wediariasantana.gmail.pertemuan7;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    EditText editWaktu;
    Button tombolMain, tombolStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 1 : mengambil komponen dari layout seperti et_waktu, bt_play, dan bt_stop
        editWaktu = findViewById(R.id.et_waktu);
        tombolMain = findViewById(R.id.bt_play);
        tombolStop = findViewById(R.id.bt_stop);

        //TODO 2 : mengeset listener pada tombol main dan tombol stop
        tombolMain.setOnClickListener(this);
        tombolStop.setOnClickListener(this);
    }

    //TODO 3 : method pada saat terjadi klik
    public void onClick(View view){
        switch (view.getId()){
            //TODO 3.1 : pada bt_play akan memanggil method callPlay
            case R.id.bt_play:
                callPlay();
                break;
            //TODo 3.2 : pada bt_stop akan memanggil method stopPlay
            case R.id.bt_stop:
                stopPlay();
                break;
        }
    }

    //TODO 4 : method callPlay
    public void callPlay(){
        //TODO 4.1 : membuat variabel detik yang mengambil nilai dari variabel editWaktu
        int detik = Integer.parseInt(editWaktu.getText().toString());
        //TODO 4.2 : membuat intent untuk memanggil kelas MyService
        Intent intent = new Intent(MainActivity.this, service.class);
        PendingIntent pendingIntent = PendingIntent.getService(MainActivity.this,
                0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        //TODO 4.3 : membuat alarm manager
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //TODO 4.4 : jika alarm manager tidak null maka akan memanggil alarm manager
        if (alarmManager != null){
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +
                    (detik * 1000), pendingIntent);
            Toast.makeText(getApplicationContext(), "Song Play After "+detik+" seconds !",
                    Toast.LENGTH_LONG).show();
        }
    }

    //TODO 5 : method stopPlay yaitu akan mengentikan service pada mainactivity
    public void stopPlay() {
        stopService(new Intent(MainActivity.this, service.class));
    }
}
