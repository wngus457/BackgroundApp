package example.backgroundapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by 박주현 on 2017-11-22.
 */

public class SettingActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setTitle("환경설정");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final String[] setting = {"버전", "의견보내기", "캐시삭제", "고객센터"};   //스트링배열로 리스트뷰에 쓰여질 내용을 만듦
        ListView settinglist = (ListView)findViewById(R.id.settinglist);   //리스트뷰를 xml과 매칭시킨다.

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, setting);  //어뎁터를 이용해 리스트뷰의 디자인과 해당 항목을 넣어줌
        settinglist.setAdapter(adapter);  //리스트뷰 어뎁터에 적용시킴
        settinglist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){   //해당 항목에 따라 다른 결과값을 줌 포지션 즉 배열의 0번째 를 나타냄 현재는 버전항목을 뜻함
                    Intent intent = new Intent(getApplicationContext(), VersionActivity.class);
                    startActivity(intent);
                }
                else if(position == 1){
                    Intent intent = new Intent(getApplicationContext(), InquiryActivity.class);
                    startActivity(intent);
                }
                else if(position == 2){
                    Intent intent = new Intent(getApplicationContext(), CacheActivity.class);
                    startActivity(intent);
                }
                else if(position == 3){
                    Intent intent = new Intent(getApplicationContext(), ServiceActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {       // 타이틀바 설정
        getMenuInflater().inflate(R.menu.setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){  //타이틀 바 아이템에 대한 리스너
        int id = item.getItemId();

        if(id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
