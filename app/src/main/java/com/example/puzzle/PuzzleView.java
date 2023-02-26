package com.example.puzzle;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

public class PuzzleView extends SurfaceView {
    PuzzleModel pm = new PuzzleModel();
    Paint drawSquare = new Paint();
    Paint numPaint = new Paint();

    Paint squares[][];
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

    public void Shuffle(){
//pass in paint double array omg SLAYYYYYYYYY
    }

    public void drawGrid(Canvas canvas, int num) {
        num = pm.rows;
        int row = 0;
        int col = 0;
        boolean check = true;
        int x = 0;
        int[][] array = new int[num][num];
        squares = new Paint[num][num];
        //squares[0][0].setColor(Color.WHITE);
        for(row = 0; row < num; row++) {
            for(col = 0; col < num; col++){
                squares[row][col] = new Paint();
                squares[row][col].setColor(Color.WHITE);
                canvas.drawRect(col*boxWidth, row*boxHeight, boxWidth + (col*boxWidth), boxHeight + (row*boxHeight),squares[row][col]);
                squares[row][col].setColor(Color.BLACK);
                squares[row][col].setStyle(Paint.Style.STROKE);
                squares[row][col].setStrokeWidth(4f);
                canvas.drawRect(col*boxWidth, row*boxHeight, boxWidth + (col*boxWidth), boxHeight + (row*boxHeight),squares[row][col]);
                if(check){
                    x = row+col;
                    squares[row][col].setColor(Color.BLACK);
                    squares[row][col].setTextSize(50f);
                    canvas.drawText(String.valueOf(x), boxWidth*row + boxWidth/8, boxHeight*col - boxHeight/4, squares[row][col]);

                }
            }

            /*for(int i = 0; i < squares.length; i++){
                for(int j = 0; j < squares[i].length; i++){
                    x = x+j;
                    squares[i][j] = new Paint();
                    squares[i][j].setColor(Color.BLACK);
                    squares[i][j].setTextSize(50f);
                    canvas.drawText(String.valueOf(x), boxWidth*i + boxWidth/8, boxHeight*j - boxHeight/4, squares[i][j]);
                }
                x++;
            }*/
        }

        /*for(int i = 0; i < num; i++){
                for(int j = 0; j < num; i++){
                    x = x+j;
                    squares[i][j] = new Paint();
                    squares[i][j].setColor(Color.BLACK);
                    squares[i][j].setTextSize(50f);
                    canvas.drawText(String.valueOf(x), boxWidth*i + boxWidth/8, boxHeight*j - boxHeight/4, squares[i][j]);
                }

            }*/
        //drawSquare.setColor(Color.BLUE);
        //canvas.drawRect(num*boxWidth, num*boxHeight, boxWidth + (num*boxWidth), boxHeight + (num*boxHeight), drawSquare);
        /*for(int row = 0; row < num; row++){
            for(int col = 0; col < num; col++){
                canvas.drawRect(col*boxWidth, row*boxHeight, boxWidth + (col*boxWidth), boxHeight + (row*boxHeight), drawSquare);
                drawSquare.setColor(Color.BLACK);
                drawSquare.setStrokeWidth(10f);
                drawSquare.setStyle(Paint.Style.STROKE);
                canvas.drawRect(col*boxWidth, row*boxHeight, boxWidth + (col*boxWidth), boxHeight + (row*boxHeight), drawSquare);
             if(row*col != num*num){
                 //draw number in the box
                 int x = row+col+1;
                 numPaint.setColor(Color.BLACK);
                 numPaint.setTextSize(50f);
                 canvas.drawText(String.valueOf(x), boxWidth*row + boxWidth/4, boxHeight + boxHeight/2, numPaint);
             }
            }

        }*/
    }

    public void onDraw(Canvas canvas){
        if(pm.board){
            drawGrid(canvas, pm.rows);
        }
    }
    }

