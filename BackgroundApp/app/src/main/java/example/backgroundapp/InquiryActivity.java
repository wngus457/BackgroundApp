package example.backgroundapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 박주현 on 2017-11-22.
 */

public class InquiryActivity extends MainActivity {

    Button smsbtn, callbtn;         //sms전송버튼과 전화연결 버튼
    EditText smstxt;                 //sms에 보내질 문자열
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquiry);
        setTitle("문의");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        smstxt = (EditText)findViewById(R.id.smstxt);
        smsbtn = (Button)findViewById(R.id.smsbtn);
        smsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager = android.telephony.SmsManager.getDefault();  //sms즉시 전송
                smsManager.sendTextMessage("01040322159", null,
                        (smstxt.getText().toString()), null, null); //전송될 번호는 01040322159번호, 내용은 사용자가 쓴 edittext의 내용
                Toast.makeText(getApplicationContext(), "관리자에게 메시지 전송이 완료되었습니다. 감사합니다.", Toast.LENGTH_LONG).show();  //전송 후 토스트메시지를 보여줌

            }
        });

        callbtn = (Button)findViewById(R.id.callbtn);
        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01040322159"));  //지정된번호로 다이얼 이동
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.inquiry, menu);
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
