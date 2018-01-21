package example.backgroundapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by 박주현 on 2017-11-22.
 */

public class MenuActivity extends MainActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setTitle("메뉴");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);      //타이틀바에 홈버튼 생성


        final String[] menu = {"이용약관", "문의", "사진보관함", "환경설정", "도움말"};      //리스트 뷰에 들어갈 리스트 목록
        ListView menulist = (ListView)findViewById(R.id.menulist);        //레이아웃 리스트와 연결

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu);  //arrayadapter를 이용해 리스트 목록 만듦
        menulist.setAdapter(adapter);   //리스트에 어뎁터 추가

        menulist.setOnItemClickListener(new AdapterView.OnItemClickListener() {          //리스트를 눌렀을 때 동작하는 코드
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){                             //0번 포지션 즉 menu배열의 첫번째 이용약관을 눌렀을 때 동작 하는 코드. 이용약관 엑티비티로 전환
                    Intent intent = new Intent(getApplicationContext(), LicenseActivity.class);
                    startActivity(intent);
                }
                else if(position == 1){                      //1번 포지션 문의를 눌렀을 때 동작 문의엑티비티로 전환
                    Intent intent = new Intent(getApplicationContext(), InquiryActivity.class);
                    startActivity(intent);
                }
                else if(position == 2){                      //2번 포지션 사진보관함으로 이동
                    Intent intent = new Intent(Intent.ACTION_PICK);                 //사진 보관함 이동
                    intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                    intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivity(intent);
                }
                else if(position == 3){                     //환경설정엑티비티로 이동
                    Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                    startActivity(intent);
                }
                else if(position == 4){                     //도움말 엑티비티로 이동
                    Intent intent = new Intent(getApplicationContext(), HelpActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {            //타이틀 바 이미지 지정
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == android.R.id.home){             //<-표시 아이템에 대한 설정
            finish();                             //현재 엑티비티를 종료함
        }

        return super.onOptionsItemSelected(item);
    }

}
