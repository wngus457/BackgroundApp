package example.backgroundapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by 박주현 on 2017-12-10.
 */

public class RatingActivity extends MainActivity {
    RatingBar ratingbar;
    Button retrunbtn;
    TextView resulttv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        setTitle("평점");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //이전 버튼 활성화
        Intent intent = getIntent();     //인텐트로 넘겨준 데이터를 받아옴
        int data = intent.getIntExtra("result", 0);  //해당 인텐트 이름 값으로 넘겨받음 인트형 데이터

        Log.d("result", String.valueOf(data));  //넘어온 데이터 값 확인

        resulttv = (TextView)findViewById(R.id.resulttv);
        resulttv.setText("등록하신 평점은"+String.valueOf(data) + "/5 입니다.");  //평점을 텍스트로 출력

        retrunbtn = (Button)findViewById(R.id.retrunbtn);
        retrunbtn.setOnClickListener(new View.OnClickListener() {   //돌아가기 버튼 리스너
            @Override
            public void onClick(View v) {
                finish();                   //엑티비티 종료
            }
        });

        ratingbar = (RatingBar)findViewById(R.id.ratingbar);
        ratingbar.setRating(data);   //레이팅 바의 개수를 설정해줌

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.rating, menu); //타이틀바 디자인을 매칭시킨다
        return true;
    }
    //타이틀바 아이템 설정
    @Override
    public boolean onOptionsItemSelected(MenuItem item){   //타이틀바 아이템에대한 리스너
        int id = item.getItemId();

        if(id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
