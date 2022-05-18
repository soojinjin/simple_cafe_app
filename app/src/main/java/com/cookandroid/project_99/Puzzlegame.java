package com.cookandroid.project_99;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class Puzzlegame extends Activity {

    private Button bs[] = new Button[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        Button btnRetry = (Button) findViewById(R.id.btnRetry);
        Button btnAnother = (Button) findViewById(R.id.btnAnother);
        ((Button) findViewById(R.id.btnRetry)).setOnClickListener(start);

        bs[0] = (Button) findViewById(R.id.btn01);
        bs[1] = (Button) findViewById(R.id.btn02);
        bs[2] = (Button) findViewById(R.id.btn03);
        bs[3] = (Button) findViewById(R.id.btn04);
        bs[4] = (Button) findViewById(R.id.btn05);
        bs[5] = (Button) findViewById(R.id.btn06);
        bs[6] = (Button) findViewById(R.id.btn07);
        bs[7] = (Button) findViewById(R.id.btn08);
        bs[8] = (Button) findViewById(R.id.blank);

        for (int i = 0; i < bs.length; i++) {
            bs[i].setOnClickListener(click);
        }
    }
    public View.OnClickListener click = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Button A = (Button) v;
            Button blank = (Button)findViewById(R.id.blank);
            if(Vert(A,blank) || Hori(A, blank)) {
                SwapButton(A, blank);
            }
        }
    };
    public View.OnClickListener start = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int x,y;
            for (y=0; y<3; y++){
                for (x=0; x<3; x++){
                    bs[y*3+x].layout(x*75, y*75, x*75+75, y*75+75);
                }
            }
            Random puzzleRandom = new Random();
            for (int i=0; i<1000; i++) {
                click.onClick(bs[puzzleRandom.nextInt(8)]);
            }
        }
    };
    protected void SwapButton(Button a, Button blank) {
        int Left = a.getLeft();
        int Top = a.getTop();
        int Right = a.getRight();
        int Bottom = a.getBottom();
        a.layout(blank.getLeft(), blank.getTop(), blank.getRight(), blank.getBottom());
        blank.layout(Left, Top, Right, Bottom);
    }
    protected boolean Hori(Button a, Button blank) {
        return (a.getTop()==blank.getTop() && Math.abs(a.getLeft()-blank.getLeft()) < 100);
    }
    protected boolean Vert(Button a, Button blank) {
        return (a.getLeft()==blank.getLeft()&&Math.abs(a.getTop()-blank.getTop()) < 100);
    }

}
