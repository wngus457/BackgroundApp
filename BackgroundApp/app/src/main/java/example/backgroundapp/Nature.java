package example.backgroundapp;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by 박주현 on 2017-12-06.
 */

public class Nature extends MainActivity {
    String[] natureimgurl = {"http://1080x1920-wallpapers.ko.russianwomen.club/%EA%B7%B8%EB%A6%BC/1080x1920-%EB%B0%94%ED%83%95-%ED%99%94%EB%A9%B4-%EB%AC%B4%EB%A3%8C-%EB%B0%B0%EA%B2%BD-%ED%99%94%EB%A9%B4-112.jpg",
    "http://media.idownloadblog.com/wp-content/uploads/2016/11/macOS-wallpaper-mod-2-by-AR72014.png", "http://media.idownloadblog.com/wp-content/uploads/2016/05/macinmac_-iphone-wallpaper-sky-sunset-beach.jpg",
    "http://www.hdwallpaper.kr/files/attach/images/6109/835/160/f1986adc68ac2bdc439281f32ff964fa.jpg", "http://www.sebastienpage.com/wp-content/uploads/2017/04/Dreamy-Underwater-Bubbles-Sun-Light-iPhone-6-HD-Wallpaper.jpg",
    "https://cdn.clien.net/web/api/file//F01/3305895/0639f1c7c33a4142beb.JPG", "https://s-media-cache-ak0.pinimg.com/originals/c4/0a/68/c40a680f52ac4895b8ee3ae1565f46d3.jpg",
    "http://cfile3.uf.tistory.com/image/230816365800979320CD3C"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nature);
        setTitle("자연");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GridView gv = (GridView)findViewById(R.id.naturebackground);  //그리드뷰 생성
        Nature.GridAdapternature gadapter = new Nature.GridAdapternature(this);
        gv.setAdapter(gadapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nature, menu);
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
    public class GridAdapternature extends BaseAdapter {

        Context context;
        public GridAdapternature(Context c){
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
                R.drawable.nature01, R.drawable.nature02, R.drawable.nature03, R.drawable.nature04, R.drawable.nature05, R.drawable.nature06, R.drawable.nature07, R.drawable.nature08
        };
        public View getView(int arg0, View arg1, ViewGroup arg2){   //int arg0의 값은 backgourndID의 길이값
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(535, 650));        //그리드뷰 사이즈 설정
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);             //xy축 기준으로 사이즈 맞춤
            imageView.setImageResource(backgroundID[arg0]);

            final int pos = arg0;  //이미지 리스트를 pos에 저장
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View)View.inflate(Nature.this, R.layout.dialog, null);   //다이얼로그 레이아웃을 보여줌
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Nature.this);
                    final ImageView backgournd = (ImageView)dialogView.findViewById(R.id.imagebackgournd);
                    backgournd.setImageResource(backgroundID[pos]);   //보여질 이미지는 누르는 이미지의 이미지를 보여줌
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("저장", new DialogInterface.OnClickListener() {       //다이얼로그의 저장부분에 대한 클릭 이벤트
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(pos == 0){                     //첫번째 이미지에대한 리스너
                                DownloadTask downloadTask = new DownloadTask();     //Downloadtask 클래스를 상속받아 변수값에 저장
                                downloadTask.execute(natureimgurl[0]);        //정해진 url로 downloadtask클래스 실행

                            }
                            else if(pos == 1){         //두번째 이미지에 대한 리스너
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(natureimgurl[1]);

                            }
                            else if(pos == 2){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(natureimgurl[2]);

                            }
                            else if(pos == 3){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(natureimgurl[3]);

                            }
                            else if(pos == 4){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(natureimgurl[4]);

                            }
                            else if(pos == 5){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(natureimgurl[5]);

                            }
                            else if(pos == 6){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(natureimgurl[6]);

                            }
                            else if(pos == 7){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(natureimgurl[7]);

                            }

                        }
                    });
                    dlg.setPositiveButton("닫기", null);
                    dlg.show();
                }
            });
            return imageView;
        }
    }
}
