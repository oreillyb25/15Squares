package com.example.puzzle;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

public class PuzzleController implements SeekBar.OnSeekBarChangeListener {
    PuzzleModel pm;
    PuzzleView pv;

    public PuzzleController(PuzzleView pvo){
        pv = pvo;
        pm = pv.getPuzzleModel();
    }

    public boolean onTouch(View view, MotionEvent e) {
        pm.x = (int) e.getX();
        pm.y = (int) e.getY();
        Log.d(null, "move");
        pm.move = true;
        pv.invalidate();
        return pm.move;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        Log.d(null, "seekbar");
        //pm.board = true;
        pm.rows = i;
        pv.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
