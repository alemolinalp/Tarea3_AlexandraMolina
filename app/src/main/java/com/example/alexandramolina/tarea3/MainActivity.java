package com.example.alexandramolina.tarea3;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SeekBar;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import android.widget.Button;
import android.graphics.drawable.Drawable;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private ArrayList<Musica> arraylist;
    private CustomMusicAdapter adapter;
    private ListView canciones;
    Button boton;
    Drawable pause;
    Drawable play;
    SeekBar volumeSeekBar;
    SeekBar advanceSeekBar;
    TextView txtlyrics;

    int a = 0;



    protected MediaPlayer mediaPlayer = new MediaPlayer();
    AudioManager audioManager;

    int [] songsMP3 = {R.raw.today, R.raw.musicaligera,R.raw.allthesmallthings,R.raw.stressedout,R.raw.sugar
            ,R.raw.starboy,R.raw.demons,R.raw.hymn};

    String [] artist = {"Smashing Pumpkins", "Soda Stereo","Blink 182","Twenty One Pilots","Maroon 5","The Weeknd","Imagine Dragons","Coldplay"};
    String [] song = {"Today", "De Música Ligera","All the Small Things", "Stressed Out","Sugar","Starboy","Demons","Hymn for the Weekend"};

    private static final String lyricsToday = "TODAY\n\nToday is the greatest Day I've ever known Can't live for tomorrow, Tomorrow's much too long I'll burn my eyes out Before I get out I wanted more Than life could ever grant me Bored by the chore Of saving face\n\nToday is the greatestDay I've never known Can't wait for tomorrow I might not have that long I'll tear my heart out Before I get out\n\nPink ribbon scars That never forget I tried so hard To cleanse these regrets My angel wings Were bruised and restrained My belly stings\n\nToday is Today is Today is The greatest day\n\nI want to turn you on I want to turn you on I want to turn you on I want to turn you\n\nToday is the greatest Today is the greatest day Today is the greatest day That I have ever really known";

    public void playClicked(View view){

        txtlyrics.setText(lyricsToday);
        txtlyrics.animate().translationYBy(-2000f).setDuration(75000);

        if(sonando()) {
            mediaPlayer.pause();
            boton.setBackground(play);
        }
        else{
            boton.setBackground(pause);
            mediaPlayer.start();
        }
    }
    public void rightClicked(View view){
        if(sonando()) {
            mediaPlayer.stop();
        }
        if(a == 7){
            a = 0;
        }
        else{
            a++;
        }
        cambiarCancion();
        mediaPlayer.start();

    }
    public void leftClicked(View view){
        if(sonando()) {
            mediaPlayer.stop();
        }
        if(a == 0){
            a = 7;
        }
        else{
            a--;
        }
        cambiarCancion();
        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pause = getResources().getDrawable(R.drawable.pause);
        play  = getResources().getDrawable(R.drawable.play);

        canciones = findViewById(R.id.basicListView);
        boton = findViewById(R.id.btnplay);
        volumeSeekBar = findViewById(R.id.volumeSeekBar);
        advanceSeekBar = findViewById(R.id.advanceSeekBar);
        txtlyrics = findViewById(R.id.textView);


        arraylist = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
            arraylist.add(new Musica(song[i],artist[i], songsMP3[i]));
        }

        adapter = new CustomMusicAdapter(this, R.layout.custom_music_item, arraylist);
        canciones.setAdapter(adapter);

        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        volumeSeekBar.setMax(maxVolume);
        volumeSeekBar.setProgress(currentVolume);

        volumeSeekBar.getProgressDrawable().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
        volumeSeekBar.getThumb().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);

        advanceSeekBar.getProgressDrawable().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
        advanceSeekBar.getThumb().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);

        txtlyrics.setTranslationY(1000f);

        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
                //mediaPlayer.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                advanceSeekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,1000);

        canciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(), canciones.get(i), Toast.LENGTH_SHORT).show();
                if(sonando()){
                    mediaPlayer.stop();
                }
                a = i;
                Log.d("Cancion",Integer.toString(a));
                cambiarCancion();
                int duration = mediaPlayer.getDuration();
                int progress = mediaPlayer.getCurrentPosition();

                advanceSeekBar.setMax(duration);
                advanceSeekBar.setProgress(progress);
            }

        });
    }
    public void cambiarCancion(){
        if(a == 0) {
            mediaPlayer = mediaPlayer.create(this, songsMP3[a]);
        }
        else if(a == 1){
            mediaPlayer = mediaPlayer.create(this, songsMP3[a]);
        }
        else if(a == 2){
            mediaPlayer = mediaPlayer.create(this, songsMP3[a]);
        }
        else if(a == 3){
            mediaPlayer = mediaPlayer.create(this, songsMP3[a]);
        }
        else if(a == 4){
            mediaPlayer = mediaPlayer.create(this, songsMP3[a]);
        }
        else if(a == 5){
            mediaPlayer = mediaPlayer.create(this, songsMP3[a]);
        }
        else if(a == 6){
            mediaPlayer = mediaPlayer.create(this, songsMP3[a]);
        }
        else if(a == 7){
            mediaPlayer = mediaPlayer.create(this, songsMP3[a]);
        }
        else{
            Log.d("No ha puesto", "cancion");
        }
    }
    public boolean sonando(){
        boolean r;
        if(mediaPlayer.isPlaying()){
            r = true;
        }
        else{
            r = false;
        }
        return r;
    }


}
