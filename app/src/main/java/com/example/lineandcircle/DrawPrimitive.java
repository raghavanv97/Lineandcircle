package com.example.lineandcircle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by SASI on 16/04/2017.
 */

public class DrawPrimitive extends View {

    Paint paint=new Paint();

    public DrawPrimitive(Context context,String name) {
        super(context);
        paint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
/*        canvas.drawLine(0,0,200,200,paint);
        canvas.drawLine(200,0,0,200,paint);*/
        canvas.drawCircle(160,150,100,paint);
    }
}
