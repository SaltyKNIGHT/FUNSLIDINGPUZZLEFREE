package com.example.funslidingpuzzlegamefree;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int[][] pos = new int[10][10];
    private Button restart_btn;
    private Random rand = new Random();
    int id = 0, id2 = 0;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restart_btn = findViewById(R.id.restart);
        restart_btn.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    shuffleTable(view);
                }
            }
        );

        img = findViewById(R.id.imageView1);
        id = 1;
        img.setId(id);
        ImageView image1 = findViewById(id);
        image1.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Swap(1);
                }
            }
        );
        img = findViewById(R.id.imageView2);
        id = 2;
        img.setId(id);
        ImageView image2 = findViewById(id);
        image2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Swap(2);
                    }
                }
        );
        img = findViewById(R.id.imageView3);
        id = 3;
        img.setId(id);
        ImageView image3 = findViewById(id);
        image3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Swap(3);
                    }
                }
        );
        img = findViewById(R.id.imageView4);
        id = 4;
        img.setId(id);
        ImageView image4 = findViewById(id);
        image4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Swap(4);
                    }
                }
        );
        img = findViewById(R.id.imageView5);
        id = 5;
        img.setId(id);
        ImageView image5 = findViewById(id);
        image5.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Swap(5);
                    }
                }
        );
        img = findViewById(R.id.imageView6);
        id = 6;
        img.setId(id);
        ImageView image6 = findViewById(id);
        image6.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Swap(6);
                    }
                }
        );
        img = findViewById(R.id.imageView7);
        id = 7;
        img.setId(id);
        ImageView image7 = findViewById(id);
        image7.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Swap(7);
                    }
                }
        );
        img = findViewById(R.id.imageView8);
        id = 8;
        img.setId(id);
        ImageView image8 = findViewById(id);
        image8.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Swap(8);
                    }
                }
        );
        img = findViewById(R.id.imageView9);
        id = 9;
        img.setId(id);
        ImageView image9 = findViewById(id);
        image9.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Swap(9);
                    }
                }
        );
        shuffleTable(getWindow().getDecorView().getRootView());
    }


    public void shuffleTable(View view){
        Boolean[] visited = new Boolean[100];
        for(int i = 0; i <= 9; i++){
            visited[i] = false;
        }

        for(int i = 1; i <= 3; i++){
            for(int j = 1; j <= 3; j++){
                Boolean filled = false;
                while(!filled){
                    int tmp = rand.nextInt(10);
                    if(tmp > 0 && !visited[tmp]){
                        visited[tmp] = true;
                        filled = true;
                        pos[i][j] = tmp;
                    }
                }
            }
        }

        int cnt = 1;
        for(int i = 1; i <= 3; i++){
            for(int j = 1; j <= 3; j++){
                if(pos[i][j] == 9){
                    id = getResources().getIdentifier("white", "drawable", this.getPackageName());
                    img = findViewById(cnt);
                    img.setImageResource(id);
                } else {
                    id = getResources().getIdentifier("pic" + pos[i][j], "drawable", this.getPackageName());
                    img = findViewById(cnt);
                    img.setImageResource(id);
                }
                cnt += 1;
            }
        }
        String s = "";
        for(int i = 1; i <= 3; i++){
            for(int j = 1; j <= 3; j++){
                s += pos[i][j];
            }
        }
//        Toast toast = Toast.makeText(this, s, Toast.LENGTH_LONG);
//        toast.show();
    }

    void Swap(int ids){
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int cur_x = (ids / 3) + 1;
        int cur_y = (ids % 3);
        if(ids % 3 == 0){
            cur_x = ids / 3;
            cur_y = 3;
        }

        Boolean swappable = false;

        for(int i = 0; i < 4; i++){
            if(cur_x + dir[i][0] > 0 && cur_y + dir[i][1] > 0 && cur_x + dir[i][0] <= 3 && cur_y + dir[i][1] <= 3){
//                String s = "";
//                s += cur_x + dir[i][0]; s += cur_y + dir[i][1];
//                Toast toast = Toast.makeText(this, s, Toast.LENGTH_SHORT);
//                toast.show();
                if(pos[cur_x + dir[i][0]][cur_y + dir[i][1]] == 9){
                    id = getResources().getIdentifier("white", "drawable", this.getPackageName());
                    img = findViewById(ids);
                    img.setImageResource(id);
                    id = getResources().getIdentifier("pic" + pos[cur_x][cur_y], "drawable", this.getPackageName());
                    int x = ((cur_x + dir[i][0] - 1) * 3) + cur_y + dir[i][1];
                    img = findViewById(x);
                    img.setImageResource(id);
                    int tmp = pos[cur_x + dir[i][0]][cur_y + dir[i][1]];
                    pos[cur_x + dir[i][0]][cur_y + dir[i][1]] = pos[cur_x][cur_y];
                    pos[cur_x][cur_y] = tmp;
                    swappable = true;
                    break;
                }
            }
        }
        if(swappable){
            int num = 1;
            for(int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    if (pos[i][j] == num) {
                        num += 1;
                    }
                }
            }

            if(num == 9){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("ok");
                builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                shuffleTable(getWindow().getDecorView().getRootView());
            }
        }
    }
}


