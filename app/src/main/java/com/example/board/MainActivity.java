package com.example.board;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SimpleCursorAdapter;



public class MainActivity extends AppCompatActivity {
    DBHelper helper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button reviewButton = (Button) findViewById(R.id.btn_review);
        reviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2_.class);
                startActivity(intent);
            }
        });
        // 리뷰버튼
        Button back_korea_Button = (Button) findViewById(R.id.back_food_korea);
        back_korea_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Food_korea.class);
                startActivity(intent);
            }
        });
        // 뒤로가기 버튼(한식)
       // final FirebaseFirestore db = FirebaseFirestore.getInstance(); //파이어베이스 연동.

        ListView listView =(ListView)findViewById(R.id.listview);

        helper = new DBHelper(MainActivity.this, "Board.db", null, 1);
        db = helper.getWritableDatabase();
        helper.onCreate(db);

        String sql = "select * from mytable;";
        Cursor c = db.rawQuery(sql,null);
        String[] columns = new String[]{"name","title","review"};


        //int[] ints = new int[] {R.id.listview_txt};
        int[] ints = new int[] {R.id.nameEdit,R.id.titleEdit,R.id.reviewEdit};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(listView.getContext(), R.layout.listview, c, columns, ints,0);
        //adapter = new SimpleCursorAdapter(listView.getContext(), R.layout.listview,c,columns,ints,);

        listView.setAdapter(adapter);

        final RatingBar r1 = (RatingBar) findViewById(R.id.ratingBar1);
        r1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                int grade = (int)r1.getRating();

            }
        });
    }

}