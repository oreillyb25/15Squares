package com.example.puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PuzzleView sf = findViewById(R.id.puzzleview);
        //custom surfaceview i think!
        PuzzleController pc = new PuzzleController(sf);

        SeekBar puzz = findViewById(R.id.rowCount);
        puzz.setOnSeekBarChangeListener(pc);

        //SurfaceView sf = findViewById(R.id.surfaceview);
        //sf.draw(pc);
    }
}