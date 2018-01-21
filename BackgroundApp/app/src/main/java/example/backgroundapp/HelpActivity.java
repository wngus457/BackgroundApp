package example.backgroundapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by 박주현 on 2017-11-22.
 */

public class HelpActivity extends MainActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        setTitle("도움말");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //홈버튼 생성
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {   //타이틀바 설정
        getMenuInflater().inflate(R.menu.help, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){  //타이틀바 아이템 리스너
        int id = item.getItemId();

        if(id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
