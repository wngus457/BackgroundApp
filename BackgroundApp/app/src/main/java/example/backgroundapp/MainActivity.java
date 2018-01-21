package example.backgroundapp;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("홈");

        GridView gv = (GridView)findViewById(R.id.mainbackground);  //그리드뷰 생성
        GridAdapter gadapter = new GridAdapter(this);
        gv.setAdapter(gadapter);

        //권한설정
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CALENDAR) == PackageManager.PERMISSION_GRANTED){
            //Manifest.permission.READ_CALENDAR이 접근 승낙 상태 일때
        } else{
            //Manifest.permission.READ_CALENDAR이 접근 거절 상태 일때
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_CALENDAR)){
                //사용자가 다시 보지 않기에 체크를 하지 않고, 권한 설정을 거절한 이력이 있는 경우
            } else{
                //사용자가 다시 보지 않기에 체크하고, 권한 설정을 거절한 이력이 있는 경우
            }

            //사용자에게 접근권한 설정을 요구하는 다이얼로그를 띄운다.
            //만약 사용자가 다시 보지 않기에 체크를 했을 경우엔 권한 설정 다이얼로그가 뜨지 않고,
            //곧바로 OnRequestPermissionResult가 실행된다.
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.RECEIVE_SMS, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.CALL_PHONE},0);

        }

    }

    //권한설정
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults){
        switch (requestCode){
            case 0: {   //리퀘스트 코드가 0이기때문에 0에대한 코드 작성
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){ //권한의 개수가 0보다 크고 권한요청이 배열의 0번째부터 실행
                    //승낙했을경우

                }else{
                    //거부할경우
                    Toast.makeText(this, "권한 거부됨.앱을 종료합니다", Toast.LENGTH_LONG).show();
                    finish(); //앱종료
                }
                return;
            }

        }
    }
    //타이틀바 설정
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.maintitle, menu); //타이틀바 디자인을 매칭시킨다
        return true;
    }
    //타이틀바 아이템 설정
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){     //타이틀바 아이템 아이디
            case R.id.settingbtn:
                Intent intent = new Intent(getApplicationContext(), SettingActivity.class);  //해당클래스로 이동
                startActivity(intent);
                return true;
            case R.id.menubutton:
                Intent intent2 = new Intent(getApplicationContext(), MenuActivity.class);   //해당클래스로 이동
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public class GridAdapter extends BaseAdapter{

        Context context;
        public GridAdapter(Context c){
            context = c;
        }
        public int getCount(){
            return backgroundID.length;  //이미지 숫자만큼 리턴
        }
        public Object getItem(int arg0){
            return null;
        }
        public long getItemId(int arg0) {
            return 0;
        }
        Integer[] backgroundID = {                     //이미지 파일
                R.drawable.space, R.drawable.movie, R.drawable.nature, R.drawable.sport, R.drawable.classic, R.drawable.game};

        public View getView(int arg0, View arg1, ViewGroup arg2){   //int arg0의 값은 backgourndID의 길이값
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(535, 650));        //그리드뷰 사이즈 설정
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);             //xy축 기준으로 사이즈 맞춤
            imageView.setImageResource(backgroundID[arg0]);

            final int pos = arg0;  //이미지 리스트를 pos에 저장
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(pos == 0){   //첫 번째 이미지에 대한 클릭 리스너  엑티비티 이동
                        Intent intent = new Intent(getApplicationContext(), Space.class);
                        startActivity(intent);
                        Log.d("메인인텐트", "space클래스 이동");
                    }
                    if(pos == 1){  //두 번째 이미지에 대한 클릭 리스너  엑티비티 이동
                        Intent intent = new Intent(getApplicationContext(), Movie.class);
                        startActivity(intent);
                        Log.d("메인인텐트", "movie클래스 이동");
                    }
                    if(pos == 2){  //세 번째 이미지에 대한 클릭 리스너  엑티비티 이동
                        Intent intent = new Intent(getApplicationContext(), Nature.class);
                        startActivity(intent);
                        Log.d("메인인텐트", "nature클래스 이동");
                    }
                    if(pos == 3){  //네 번째 이미지에 대한 클릭 리스너  엑티비티 이동
                        Intent intent = new Intent(getApplicationContext(), Sport.class);
                        startActivity(intent);
                        Log.d("메인인텐트", "sport클래스 이동");
                    }
                    if(pos == 4){  //다섯 번째 이미지에 대한 클릭 리스너  엑티비티 이동
                        Intent intent = new Intent(getApplicationContext(), Classic.class);
                        startActivity(intent);
                        Log.d("메인인텐트", "classic클래스 이동");
                    }
                    if(pos == 5){  //여섯 번째 이미지에 대한 클릭 리스너  엑티비티 이동
                        Intent intent = new Intent(getApplicationContext(), Game.class);
                        startActivity(intent);
                        Log.d("메인인텐트", "game클래스 이동");
                    }

                }
            });
            return imageView;
        }
    }
    public class DownloadTask extends AsyncTask<String, Integer, String>{         //AsyncTask클래스를 상속받아 쓰레드와 핸들러를 통해 UI를 처리했던 것을 한번에 작업할 수 있도록 함
        ProgressDialog progressDialog;            //프로그레스 다이얼로그 변수

        @Override
        protected void onPreExecute() {            // UI스레드 상에서 실행되고 dolnbackground메소드 전에 호출. 필요한 작업을 위한 메소드
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("다운로드 중...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);        //스타일을 가로스타일로 지정
            progressDialog.setMax(100);            //맥스치를 100으로 설정
            progressDialog.setProgress(0);         //0부터 시작
            progressDialog.show();                 //프로그레스다이얼로그를 보여줌
            Log.d("onpreexecute:", "정상실행");
        }

        @Override
        protected String doInBackground(String... params) {         // 백그라운드 작업을 위한 메소드. UI적용하면 안됨
            String path = params[0];    //웹 서버 쪽 파일이 있는 경로
            int file_length = 0;
            try {
                URL url = new URL(path);
                URLConnection urlConnection = url.openConnection();
                urlConnection.connect();
                file_length = urlConnection.getContentLength();
                String savePath = Environment.getExternalStorageDirectory().toString()+"/DCIM/moamoaback";       //폴더 경로 설정
                File new_folder = new File(savePath);    //해당 경로로 폴더 생성
                if(!new_folder.exists()){          //만약 해당 폴더가 없으면
                    new_folder.mkdir();            //폴더 생성
                    Log.d("donlnbackgournd:", "폴더 생성");
                }
                Date day = new Date();    //날짜 생성
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.KOREA);  //한국 시간으로 날짜를 맞춰줌. 패턴을 20170101_113322같이 설정
                String filename = String.valueOf(simpleDateFormat.format(day));  //파일이름을 정해진 패턴과 날짜로 저장
                File input_file = new File(new_folder, filename+".jpg");  //정해진 파일 이름과 확장자 .jpg로 파일 생성

                sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,     //이미지파일을 다운을 받으면 미디어 스캐닝을 통해 해당 경로에 있는 파일을 스캐닝
                        Uri.parse("file://"+input_file)));

                InputStream inputStream = new BufferedInputStream(url.openStream(), 8192);  //inputstream을 이용해 받아온 데이터를 바이트로 변환
                byte[] data = new byte[1024];
                int total = 0;
                int count = 0;
                OutputStream outputStream = new FileOutputStream(input_file);
                while ((count=inputStream.read(data))!=-1){    //내려받는 파일 사이즈 합산 작업
                    total+= count;
                    outputStream.write(data, 0, count);
                    int progress = (int)total*100/file_length;
                    publishProgress(progress);
                }
                inputStream.close();          //inputstream종료
                Log.d("donlnbackgournd:", "inputstream종료");
                outputStream.close();         //outputstream종료
                Log.d("donlnbackgournd:", "outputstream종료");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d("donlnbackgournd:", "정상실행");
            return "다운로드를 완료하였습니다.";         //다운이 완료되면 다운로드를 완료했다는 메시지를 리턴함
        }

        @Override
        protected void onProgressUpdate(Integer... values) {        //파일 다운로드 퍼센티지 표시 작업
            progressDialog.setProgress(values[0]);    //넘겨받은 프로그레스 다이얼로그 실행
            Log.d("onProgressUpdate:", "정상실행");

        }

        @Override
        protected void onPostExecute(String result) {       //dolnbackground메소드 종료 후 실행되는 메소드
            progressDialog.hide();
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            Log.d("onPostExecute:", "정상실행");

        }
    }

}
