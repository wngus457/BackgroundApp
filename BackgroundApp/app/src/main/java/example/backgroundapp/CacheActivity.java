package example.backgroundapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by 박주현 on 2017-11-22.
 */

public class CacheActivity extends MainActivity {

    Button cachedelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache);
        setTitle("캐시삭제");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cachedelete = (Button)findViewById(R.id.cachedelete);
        cachedelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearApplicationCache(null);   //캐시에 null값을 넣어줌으로 인해 전부 삭제됨
                Toast.makeText(getApplicationContext(), "캐시가 삭제되었습니다.", Toast.LENGTH_LONG).show();
            }
        });

    }

   /* @Override
    public void onDestroy() {           //캐시삭제
        super.onDestroy();
        clearApplicationCache(null);
        android.os.Process.killProcess(android.os.Process.myPid() );
    }*/

    public void clearApplicationCache(java.io.File dir){
        if(dir==null) dir = getCacheDir();     //캐시디렉토리를 불러움
        if(dir==null) return;
        java.io.File[] children = dir.listFiles();     //캐시디렉토리를 리스트파일로 만들어 배열로 저장
        try{
            // 쿠키 삭제
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.removeSessionCookie();

            for(int i=0;i<children.length;i++)      //반복문 실행. 캐시파일의 개수만큼
                if(children[i].isDirectory()){
                    clearApplicationCache(children[i]);
                }

                else {
                    children[i].delete();
                }
        }
        catch(Exception e){}
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cache, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
