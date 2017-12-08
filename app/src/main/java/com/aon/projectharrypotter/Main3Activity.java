package com.aon.projectharrypotter;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    private ImageView imange;
    private Button button;
    private TextView textview;
    static private boolean check[];
    static private boolean check2[];
    static private boolean correct = false;
    static private int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        final ImageView imange;
        Button c,d,e;
        final TextView textview;

        final int[] a = {R.drawable.h, R.drawable.hh, R.drawable.hhh, R.drawable.hhhh};
        final String[] b = {"พระเอกขอเรื่องนี้ใส่เสื้อแดงใช่ไหม ?", "ไม้กวาดนี้บินได้ใช่หรือไม่ ?","พระเอกจูบกับนางเอกใช่หรือไม่ ?", "ในภาพใช่หลุมศพหรือไม่ ?"};
        check = new boolean[4];
        check2 = new boolean[4];
        imange = (ImageView) findViewById(R.id.image);
        c = (Button) findViewById(R.id.button3);
        d = (Button) findViewById(R.id.button1);
        e = (Button) findViewById(R.id.button2);
        textview = (TextView) findViewById(R.id.textview);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count<4) {
                    int ran;
                    ran = random(0, 3);
                    imange.setImageResource(a[c(ran)]);
                    textview.setText(b[c2(ran)]);
                    ++count;
                }
                else{
                    Intent a = new Intent(Main3Activity.this,Main4Activity.class);
                    startActivity(a);
                }
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"ถูก",Toast.LENGTH_LONG).show();

            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"ผิด",Toast.LENGTH_LONG).show();

            }
        });
    }
        private int random(int min, int max) {
            return min + (int) Math.round(Math.random() * (max - min));
        }

        private int c(int ran) {
            if(check[ran] == false) {
                check[ran] = true;
                return ran;
            }
            else
                return c(random(0, 3));
        }
        private int c2(int ran){
            if(check2[ran]==false){
                check2[ran] = true;
                return ran;
            }
            else
                return c2(random(0,3));
        }
    }

