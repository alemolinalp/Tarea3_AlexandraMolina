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

    int a = 8;

    protected MediaPlayer mediaPlayer = new MediaPlayer();
    AudioManager audioManager;

    int [] songsMP3 = {R.raw.today, R.raw.musicaligera,R.raw.allthesmallthings,R.raw.stressedout,R.raw.sugar
            ,R.raw.starboy,R.raw.demons,R.raw.hymn};

    String [] artist = {"Smashing Pumpkins", "Soda Stereo","Blink-182","Twenty One Pilots","Maroon 5","The Weeknd","Imagine Dragons","Coldplay"};
    String [] song = {"Today", "De Música Ligera","All the Small Things", "Stressed Out","Sugar","Starboy","Demons","Hymn for the Weekend"};

    private static final String lyricsToday = "\n\n\n\n\n\nTODAY\n\n\n\n\n\nToday is the greatest Day I've ever known  Can't live for tomorrow, Tomorrow's much too long I'll burn my eyes out Before I get out \n\n\n\nI wanted more Than life could ever grant me Bored by the chore Of saving face\n\nToday is the greatest Day I've never known Can't wait for tomorrow I might not have that long I'll tear my heart out Before I get out\n\nPink ribbon scars  That never forget I tried so hard To cleanse these regrets My angel wings Were bruised and restrained My belly stings\nToday is Today is Today is The greatest day\nI want to turn you on x4 \nToday is the greatest Today is the greatest day Today is the greatest day That I have ever really known";

    private static final String lyricsMusicaLigera = "\n\n\n\n\n\nDE MÚSICA LIGERA\n\n\n\nElla durmió al calor de las masas y yo desperté queriendo soñarla algún tiempo atrás pensé en escribirle que nunca sorteé las trampas del amor De aquel amor de música ligera nada nos libra nada mas queda\n\n\n\n\n\n No le enviaré cenizas de rosas ni pienso evitar un roce secreto De aquel amor de música ligera nada nos libra nada mas queda\n\n\n\n\nDe aquel amor de música ligera nada nos libra nada más queda\n\n\n\n nada más queda \n\n nada más queda \n\n nada más queda";

    private static final String lyricsAlltheSmallThings = "ALL THE SMALL THINGS\n\n\n\nAll the small things True care, truth brings I'll take one lift Your ride best trip\nAlways I know You'll be at my show Watching, waiting, commiserating Say it ain't so, I will not go, Turn the lights off, Carry me home\n\n\n\n\n\n\n Late night, come home Work sucks, I know She left me roses by the stairs, Surprises, let me know she cares Say it ain't so, I will not go, Turn the lights off, Carry me home\n\n\n\n\n\nSay it ain't so, I will not go, Turn the lights off, Carry me home Keep your head still, I'll be your thrill, The night will go on, My little windmill Say it ain't so, I will not go, Turn the lights off, Carry me home Keep your head still, I'll be your thrill, The night will go on x2 My little windmill";

    private static final String lyricsStressedOut ="STRESSED OUT \n\nI wish I found some better sounds no one's ever heard I wish I had a better voice that sang some better words I wish I found some chords in an order that is new I wish I didn't have to rhyme every time I sang \n I was told when I get older all my fears would shrink But now I'm insecure and I care what people think\nMy name's 'Blurryface' and I care what you think x2\nWish we could turn back time, to the good old days When our momma sang us to sleep but now we're stressed out x2\nWe're stressed out\nSometimes a certain smell will take me back to when I was young How come I'm never able to identify where it's coming from I'd make a candle out of it if I ever found it Try to sell it, never sell out of it, I'd probably only sell one\nIt'd be to my brother, 'cause we have the same nose Same clothes homegrown a stone's throw from a creek we used to roam But it would remind us of when nothing really mattered Out of student loans and tree-house homes we all would take the latter\nMy name's 'Blurryface' and I care what you think x2 Wish we could turn back time, to the good old days When our momma sang us to sleep but now we're stressed out x2 \nWe used to play pretend, give each other different names We would build a rocket ship and then we'd fly it far away Used to dream of outer space but now they're laughing at our face Saying, Wake up, you need to make money x2\nWish we could turn back time, to the good old days When our momma sang us to sleep but now we're stressed out x2\n Used to play pretend, used to play pretend, bunny We used to play pretend, wake up, you need the money x3";

    private static final String lyricsSugar = "SUGAR\n\n\n\n\n\nI’m hurting, baby, I'm broken down I need your loving, loving I need it now When I'm without you I'm something weak You got me begging, begging I'm on my knees\n\nI don't wanna be needing your love I just wanna be deep in your love And it's killing me when you're away, ooh, baby, Cause I really don't care where you are I just wanna be there where you are And I gotta get one little taste\n\nYour sugar Yes, please Won't you come and put it down on me? I'm right here, 'cause I need Little love, a little sympathy Yeah, you show me good loving Make it alright Need a little sweetness in my life\n\n\nYour sugar Yes, please Won't you come and put it down on me?\n\n\n\n\nMy broken pieces You pick them up Don't leave me hanging, hanging Come give me some When I'm without ya I'm so insecure You are the one thing, one thing I'm living for\n\n\n\n\nI don't wanna be needing your love I just wanna be deep in your love And it's killing me when you're away, ooh, baby, Cause I really don't care where you are I just wanna be there where you are And I gotta get one little taste\n\n\n\nYour sugar Yes, please Won't you come and put it down on me? \nI'm right here, Cause I need Little love, a little sympathy\nYeah, you show me good loving Make it alright Need a little sweetness in my life\nYour sugar! (sugar!) Yes, please (yes, please) Won't you come and put it down on me?\n\nI want that red velvet I want that sugar sweet Don't let nobody touch it Unless that somebody's me I gotta be your man There ain't no other way Cause girl you're hotter than a southern California day I don't wanna play no games You don't gotta be afraid Don't give me all that shy shit No make-up on That's my\nSugar Yes, please Won't you come and put it down on me? I'm right here, 'cause I need Little love, a little sympathy So, baby, you show me good loving Make it alright Need a little sweetness in my life x2";

    private static final String lyricsStarboy = "STARBOY\n\n\n\n\nI'm tryna put you in the worst mood, P1 cleaner than your church shoes, Milli point two just to hurt you, All red lamb just to tease you, None of these toys on lease too, Made your whole year in a week too, yeah Main bitch out of your league too, Side bitch out of your league too,\n\nHouse so empty, need a centerpiece Twenty racks, a table cut from ebony Cut that ivory into skinny pieces \nThen she clean it with her face, man I love my baby You talking money, need a hearing aid \nYou talking 'bout me, I don't see the shade Switch up my style, I take any lane I switch up my cup, I kill any pain\n\n\nLook what you've done! \nI'm a motherfuckin' Starboy x2\nEvery day a nigga try to test me, Every day a nigga try to end me, \n\nPull off in that roadster SV, Pockets over weight getting hefty, Coming for the king, that's a far cry I come alive in the fall time I No competition, I don't really listen I'm in the blue Mulsanne bumping New Edition\n\n\nHouse so empty, need a centerpiece Twenty racks, a table cut from ebony Cut that ivory into skinny pieces\nThen she clean it with her face, man I love my baby You talking money, need a hearing aid You talking 'bout me,\nI don't see the shade Switch up my style, I take any lane I switch up my cup, I kill any pain\n\n\nLook what you've done! I'm a motherfuckin' Starboyx2\n\n\n\n\nLet a nigga brag Pitt Legend of the fall took the year like a bandit Bought mama a crib and a brand new wagon Now she hit the grocery shop looking lavish Star Trek roof in that Wraith of Khan Girls get loose when they hear this song Hundred on the dash get me close to God We don't pray for love, we just pray for cars House so empty, need a centerpiece Twenty racks, a table cut from ebony Cut that ivory into skinny pieces Then she clean it with her face Man, I love my baby You talking money, need a hearing aid You talking 'bout me, I don't see the shade Switch up my style, I take any lane I switch up my cup, I kill any pain\nLook what you've done! I'm a motherfuckin' Starboy x4";

    private static final String lyricsDemons = "DEMONS\n\nWhen the days are cold And the cards all fold And the saints we see Are all made of gold\nWhen your dreams all fail And the ones we hail Are the worst of all And the blood's run stale\nI wanna hide the truth I wanna shelter you But with the beast inside There's nowhere we can hide \nNo matter what we breed We still are made of greed This is my kingdom come This is my kingdom come\nWhen you feel my heat Look into my eyes It's where my demons hide It's where my demons hide\nDon't get too close It's dark inside It's where my demons hide It's where my demons hide\nAt the curtain's call It's the last of all When the lights fade out All the sinners crawl\nSo they dug your grave And the masquerade Will come calling out At the mess you made\n\nDon't wanna let you down But I am hell bound Though this is all for you Don't wanna hide the truth\nNo matter what we breed We still are made of greed This is my kingdom come This is my kingdom come\nWhen you feel my heat Look into my eyes It's where my demons hide It's where my demons hide Don't get too close It's dark inside It's where my demons hide It's where my demons hide\nThey say it's what you make I say it's up to fate It's woven in my soul I need to let you go\nYour eyes, they shine so bright I wanna save that light I can't escape this now Unless you show me how\nWhen you feel my heat Look into my eyes It's where my demons hide It's where my demons hide Don't get too close It's dark inside It's where my demons hide It's where my demons hide";

    private static final String lyricsHymn = "HYMN FOR THE WEEKEND\n\n\n\n\n\nOh, angel sent from up above\n You know you make my world light up When I was down, when I was hurt You came to lift me up Life is a drink, and love's a drug Oh, now I think I must be miles up When I was a river, dried up You came to rain a flood\n\nAnd said drink from me, drink from me When I was so thirsty Pour on a symphony Now I just can't get enough Put your wings on me, wings on me When I was so heavy Pour on a symphony When I'm low, low, low, low\n\n\nI, oh, I, oh, I Got me feeling drunk and high So high, so high Oh, I, oh, I, oh, I Now I'm feeling drunk and high So high, so high\n\n\n\nOh, angel sent from up above I feel it coursing through my blood Life is a drink, your love's about To make the stars come out\n\n Put your wings on me, wings on me When I was so heavy Pour on a symphony When I'm low, low, low, low\n\n\nI, oh, I, oh, I Got me feeling drunk and high So high, so high Oh I, oh, I, oh, I I'm feeling drunk and high So high, so high x2\nThen we'll shoot across the sky x8";

    public void playClicked(View view){
        cambiarLetra();
        if(a != 8) {
            if (sonando()) {
                mediaPlayer.pause();
                boton.setBackground(play);
            } else {
                boton.setBackground(pause);
                mediaPlayer.start();
            }
        }
    }
    public void rightClicked(View view){
        if(a!=8) {
            if (sonando()) {
                mediaPlayer.stop();
            }
            if (a == 7) {
                a = 0;
            } else {
                a++;
            }
            cambiarCancion();
            cambiarLetra();
            mediaPlayer.start();
        }

    }
    public void leftClicked(View view){
        if(a != 8) {
            if (sonando()) {
                mediaPlayer.stop();
            }
            if (a == 0) {
                a = 7;
            } else {
                a--;
            }
            cambiarCancion();
            cambiarLetra();
            mediaPlayer.start();
        }
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
            String error = "No ha puesto ninguna canción";
            txtlyrics.setText(error);
            Log.d("No ha puesto", "ninguna canción");
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
    public void cambiarLetra(){
        if(a == 0) {
            txtlyrics.setText(lyricsToday);
            txtlyrics.animate().translationYBy(-1000f).setDuration(150000);
        }
        else if(a == 1){
            txtlyrics.setText(lyricsMusicaLigera);
            txtlyrics.animate().translationYBy(-1000f).setDuration(150000);
        }
        else if(a == 2){
            txtlyrics.setText(lyricsAlltheSmallThings);
            txtlyrics.animate().translationYBy(-1000f).setDuration(150000);
        }
        else if(a == 3){
            txtlyrics.setText(lyricsStressedOut);
            txtlyrics.animate().translationYBy(-1000f).setDuration(150000);
        }
        else if(a == 4){
            txtlyrics.setText(lyricsSugar);
            txtlyrics.animate().translationYBy(-2000f).setDuration(150000);
        }
        else if(a == 5){
            txtlyrics.setText(lyricsStarboy);
            txtlyrics.animate().translationYBy(-2000f).setDuration(200000);
        }
        else if(a == 6){
            txtlyrics.setText(lyricsDemons);
            txtlyrics.animate().translationYBy(-1000f).setDuration(150000);
        }
        else if(a == 7){
            txtlyrics.setText(lyricsHymn);
            txtlyrics.animate().translationYBy(-1000f).setDuration(150000);
        }
        else{
            String error = "No ha puesto ninguna canción";
            txtlyrics.setText(error);

            Log.d("No ha puesto", "ninguna canción");
        }
    }


}
