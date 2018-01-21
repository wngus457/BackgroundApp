package example.backgroundapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 박주현 on 2017-12-10.
 */

public class ServiceActivity extends MainActivity {
    Button setokbtn;
    EditText markedt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        setTitle("고객센터");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //홈버튼 활성화

        markedt = (EditText)findViewById(R.id.markedt);
        setokbtn = (Button)findViewById(R.id.setokbtn);
        setokbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RatingActivity.class);
                intent.putExtra("result", Integer.parseInt(markedt.getText().toString()));   //edit텍스트에서 입력받은 값을 integer형태로 인텐트롤 통해 값을 전달한다.
                startActivity(intent);     //해당 인텐트로 이동
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.service, menu); //타이틀바 디자인을 매칭시킨다
        return true;
    }
    //타이틀바 아이템 설정
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
