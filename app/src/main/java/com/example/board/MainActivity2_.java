package com.example.board;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class MainActivity2_ extends AppCompatActivity {

    EditText nameEdit; //닉네임
    EditText titleEdit; // 제목
    EditText reviewEdit; // 리뷰글
    RatingBar ratingBar2;
    DBHelper helper; //핼퍼클래스 변수 선언

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_);
       Button backButton = (Button) findViewById(R.id.btn_back); //뒤로가기 버튼
       backButton.setOnClickListener(new View.OnClickListener() { //뒤로가기 버튼
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), MainActivity.class);
               startActivity(intent);
           }
       });//뒤로가기 버튼
       final RatingBar r2 = (RatingBar) findViewById(R.id.ratingBar2);
       r2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
           @Override
           public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
               int value = (int)r2.getRating();
           }
       });

        nameEdit = (EditText)findViewById(R.id.nameEdit);
        titleEdit = (EditText)findViewById(R.id.titleEdit);
        reviewEdit = (EditText)findViewById(R.id.reviewEdit);

        SQLiteDatabase db;
        helper = new DBHelper(MainActivity2_.this, "Board.db", null, 1);
        db = helper.getWritableDatabase();
        helper.onCreate(db);
    }

    public void mOnClick(View v){
       SQLiteDatabase db;
       String sql;
       switch (v.getId()) {
           case R.id.save: // 저장버튼(save)
               String name = nameEdit.getText().toString();
               String title = titleEdit.getText().toString();
               String review = reviewEdit.getText().toString();
            //   String rate = String.valueOf(ratingBar2);
               db = helper.getWritableDatabase();
               sql = String.format("INSERT INTO mytable VALUES(NULL,'%s','%s','%s');", name, title, review); // Board 테이블에 값 입력
               db.execSQL(sql);
               //result.append("\nInsert success"); //값 입력 성공
               break;
           case R.id.delete: //전체삭제 버튼(delete)
               db = helper.getWritableDatabase();
               sql = "DELETE FROM mytable;";
               db.execSQL(sql);
               //result.append("\nDelete Success");
               break;
       }
       helper.close();
       }
    }
