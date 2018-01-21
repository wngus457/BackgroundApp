package example.backgroundapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by 박주현 on 2017-11-22.
 */

public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            Thread.sleep(2000); //2초뒤 메인화면 넘어감 (1000당 1초)
        }
        catch(InterruptedException e){  //오류발생시
            e.printStackTrace();
        }
        startActivity(new Intent(this,MainActivity.class)); //메인클래스로 넘어가고 종료
        finish();
    }

}
