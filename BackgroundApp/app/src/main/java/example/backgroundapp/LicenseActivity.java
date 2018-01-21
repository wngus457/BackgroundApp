package example.backgroundapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by 박주현 on 2017-11-22.
 */

public class LicenseActivity extends MainActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license);
        setTitle("이용약관");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //타이틀 바에 홈버튼 생성
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {    //타이틀 바 설정
        getMenuInflater().inflate(R.menu.license, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){   //타이틀 바 아이템 리스너 구현
        int id = item.getItemId();

        if(id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
