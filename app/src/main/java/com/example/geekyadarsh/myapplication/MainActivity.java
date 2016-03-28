package com.example.geekyadarsh.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    char[][] val = new char[3][3];
    char user,userx;
    static final char user1 = 'X';
    static final char user2 = 'O';
    int counter,Xwon,Owon;
    Button b00,b01,b02,b10,b11,b12,b20,b21,b22;
    TextView TextO,TextX;
    boolean Done;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start();
    }


    public void start() {

        user = user1;
        userx = user1;
        Xwon = 0;
        Owon = 0;

        int ch = 65;
        for (int i = 0; i < 3 ; i++){
            for (int j = 0; j < 3 ; j++){
                val[i][j] = (char)ch;
                ch++;
            }
        }

        Done = false;
        counter = 0;

        TextX = (TextView) findViewById(R.id.textX);
        TextO = (TextView) findViewById(R.id.textO);

        TextX.setText("Player X = 0");
        TextO.setText("Player O = 0");

        b00 = (Button) findViewById(R.id.b00);
        b01 = (Button) findViewById(R.id.b01);
        b02 = (Button) findViewById(R.id.b02);
        b10 = (Button) findViewById(R.id.b10);
        b11 = (Button) findViewById(R.id.b11);
        b12 = (Button) findViewById(R.id.b12);
        b20 = (Button) findViewById(R.id.b20);
        b21 = (Button) findViewById(R.id.b21);
        b22 = (Button) findViewById(R.id.b22);

        b00.setText("");
        b01.setText("");
        b02.setText("");
        b10.setText("");
        b11.setText("");
        b12.setText("");
        b20.setText("");
        b21.setText("");
        b22.setText("");
    }

    public void reset(View v) {

        if (userx == user2)
            user = user1;
        else
            user = user2;
        userx = user;
        Done = false;

        int ch = 65;
        for (int i = 0; i < 3 ; i++){
            for (int j = 0; j < 3 ; j++){
                val[i][j] = (char)ch;
                ch++;
            }
        }

        counter = 0;

        b00.setText("");
        b01.setText("");
        b02.setText("");
        b10.setText("");
        b11.setText("");
        b12.setText("");
        b20.setText("");
        b21.setText("");
        b22.setText("");
    }

    public void bCall(View V) {
        String tag = V.getTag().toString();
        int x = Integer.parseInt(tag.split(",")[0]);
        int y = Integer.parseInt(tag.split(",")[1]);

        b00 = (Button) findViewById(R.id.b00);
        b01 = (Button) findViewById(R.id.b01);
        b02 = (Button) findViewById(R.id.b02);
        b10 = (Button) findViewById(R.id.b10);
        b11 = (Button) findViewById(R.id.b11);
        b12 = (Button) findViewById(R.id.b12);
        b20 = (Button) findViewById(R.id.b20);
        b21 = (Button) findViewById(R.id.b21);
        b22 = (Button) findViewById(R.id.b22);

        if (Done){
            Toast.makeText(MainActivity.this, "Game Over! Please press reset to continue", Toast.LENGTH_SHORT).show();
        }
        else if (val[x][y] == user1 || val[x][y] == user2){
            Toast.makeText(MainActivity.this, "AlreadyClicked!!", Toast.LENGTH_SHORT).show();
        }else{
            String btName = "b" + x + y;
            Button btn = b00;
            if (btName.equals("b00"))
                btn = b00;
            if (btName.equals("b01"))
                btn = b01;
            if (btName.equals("b02"))
                btn = b02;
            if (btName.equals("b10"))
                btn = b10;
            if (btName.equals("b11"))
                btn = b11;
            if (btName.equals("b12"))
                btn = b12;
            if (btName.equals("b20"))
                btn = b20;
            if (btName.equals("b21"))
                btn = b21;
            if (btName.equals("b22"))
                btn = b22;

            if (user == user1){
                btn.setText("X");
                val[x][y] = user1;
                counter++;
                checkIt();
                user = user2;
            }else if (user == user2){
                btn.setText("O");
                val[x][y] = user2;
                counter++;
                checkIt();
                user = user1;
            }
        }
    }


    public void checkIt () {
        for (int i = 0; i < 3; i++) {
            if (val[i][0] == val[i][1] && val[i][0] == val[i][2]) {
                Result(user);
            }
            if (val[0][i] == val[1][i] && val[2][i] == val[1][i]) {
                Result(user);
            }
        }
        if(val[0][0] == val[1][1] && val[0][0] == val[2][2]){
            Result(user);
        }else
        if(val[2][0] == val[1][1] && val[2][0] == val[0][2]){
            Result(user);
        }else
        if(counter==9){
            Toast.makeText(MainActivity.this, "Game Draw!!", Toast.LENGTH_SHORT).show();
        }
    }
    public void Result (char player) {
        Toast.makeText(MainActivity.this, "Player " + player + " Won!", Toast.LENGTH_SHORT).show();
        if (player == 'X') {
            Xwon += 1;
            TextX.setText("Player X = " + Xwon);
        }
        else if (player == 'O') {
            Owon += 1;
            TextO.setText("Player O = " + Owon);
        }
        Done = !Done;

    }
}
