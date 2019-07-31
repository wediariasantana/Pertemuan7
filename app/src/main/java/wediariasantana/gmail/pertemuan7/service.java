package wediariasantana.gmail.pertemuan7;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class service extends Service {
    //TODO 1 : membuat media player
    MediaPlayer mediaPlayer;

    //TODO 2 : membuat antarmuka service

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        //TODO 3 : membuat media player dengan lagu perfect dan mengeset looping menjadi true
        mediaPlayer = MediaPlayer.create(this, R.raw.jamrud);
        mediaPlayer.setLooping(true);
    }

    //TODO 4 : method pada saat command dijalankan maka akan menjalankan media player
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return START_STICKY;
    }

    //TODO 5 : method pada saat destroy maka akan menghentikan media player
    @Override
    public void onDestroy() {
        mediaPlayer.stop();
    }
}
