package com.example.board;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Food_screen extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_screen_layout);

        Button back_main = (Button) findViewById(R.id.back_main);
        back_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),Mainpage.class);
                startActivity(intent1);
            }
        }); //천안 시장 알아보기 버튼
        Button koreanButton = (Button) findViewById(R.id.food_korea);
        koreanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Food_korea.class);
                startActivity(intent);
            }
        });
        Button asianButton = (Button) findViewById(R.id.food_china);
        Button snackButton = (Button) findViewById(R.id.food_snack);
    }

}