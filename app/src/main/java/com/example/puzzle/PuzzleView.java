package com.example.puzzle;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PuzzleView extends SurfaceView {
    PuzzleModel pm = new PuzzleModel();
    Paint drawSquare = new Paint();
    Paint numPaint = new Paint();

    Paint squares[];
    Paint forL[][];
    Paint new_arr[];
    public static final float boxWidth = 70f;
    public static final float boxHeight = 70f;



    Random rand = new Random();

    //may have to implement Runnable()

    //all constructors from api of surfaceview

    public PuzzleView(Context context) {
        super(context);
    }

    public PuzzleView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        setWillNotDraw(false);
        drawSquare.setColor(Color.WHITE);
        drawSquare.setStyle(Paint.Style.FILL);
        numPaint.setTextSize(15);

        setBackgroundColor(Color.WHITE);
    }

    public PuzzleModel getPuzzleModel(){
        return pm;
    }


    public void drawGrid(Canvas canvas, int num) {
        num = pm.rows;
        squares = new Paint[num*num];

        for(int i = 0; i < num*num; i++){
            squares[i] = new Paint();
            squares[i].setColor(Color.WHITE);
            canvas.drawRect(i*boxWidth, boxHeight, boxWidth + (i*boxWidth), boxHeight + boxHeight,squares[i]);
            squares[i].setColor(Color.BLACK);
            squares[i].setStyle(Paint.Style.STROKE);
            squares[i].setStrokeWidth(4f);
            canvas.drawRect(i*boxWidth, boxHeight, boxWidth + (i*boxWidth), boxHeight + boxHeight,squares[i]);
            if(i != (num*num)-1) {
                squares[i].setColor(Color.BLACK);
                squares[i].setTextSize(50f);
                canvas.drawText(String.valueOf(i + 1), boxWidth * i + boxWidth / 7, boxHeight + boxHeight / 1.5f, squares[i]);
            }
        }


        forL = new Paint[num][num];
        int i = 0;
        int j = 0;
        int counter = 1;
        for(i = 0; i < num; i++){
            for(j = 0; j < num; j++){
                forL[i][j] = new Paint();
                forL[i][j].setColor(Color.WHITE);
                canvas.drawRect(i*boxWidth, j*boxHeight, boxWidth + (i*boxWidth), boxHeight + j*boxHeight,forL[i][j]);
                forL[i][j].setColor(Color.BLACK);
                forL[i][j].setStyle(Paint.Style.STROKE);
                forL[i][j].setStrokeWidth(4f);
                canvas.drawRect(i*boxWidth, j*boxHeight, boxWidth + (i*boxWidth), boxHeight + j*boxHeight,forL[i][j]);
                if(i != num-1 && j != num-1) {
                    forL[i][j].setColor(Color.BLACK);
                    forL[i][j].setTextSize(50f);
                    canvas.drawText(String.valueOf(counter), boxWidth*i + boxWidth/8, boxHeight*j - boxHeight/4, forL[i][j]);
                }
                counter++;
            }
        }

        //Shuffle(squares);
    }

    public Paint[] Shuffle(Canvas canvas, Paint [] array){
        //this.drawGrid(canvas, pm.rows);
        new_arr = new Paint[pm.rows*pm.rows];
        List<Paint> list = Arrays.asList(squares);
        Collections.shuffle(list);
        list.toArray(new_arr);
        return new_arr;
    }

    public void onDraw(Canvas canvas){
        if(pm.board){
            //Shuffle(arr);
            //drawGrid dg = new drawGrid(canvas, pm.rows);
            //Shuffle(canvas, squares);
            drawGrid(canvas, pm.rows);
        }
    }

    }

