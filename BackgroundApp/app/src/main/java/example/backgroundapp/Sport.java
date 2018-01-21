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

public class Sport extends MainActivity {
    String[] soprtimgurl = {"http://kstatic.inven.co.kr/upload/2016/04/16/bbs/i11586546200.jpg","http://www.city.kr/files/attach/images/1326/219/431/001/d0e3055f66b0f8ad0aa724cea15f1256.JPG",
            "http://rucid.dothome.co.kr/wp-content/uploads/2017/05/27_cwc_01_m.jpg","http://www.fmkorea.com/files/attach/new/20151108/3658281/70036608/251714186/8481728f75894c890a36c4720bd91f44.png",
            "http://www.fmkorea.com/files/attach/new/20170615/486616/194878583/682536225/0712b3c8ae4945847cce09bab1ddf76c.png", "http://kstatic.inven.co.kr/upload/2017/06/25/bbs/i14712403542.jpg",
            "http://www.bluewings.kr/files/attach/images/294181/328/821/98ee557744340e5cc94ed96708ec848a.jpg", "http://www.fmkorea.com/files/attach/new/20161023/486616/290158820/490832214/aa4807168011142c7479adaa148a2401.jpg",
   "https://img.fmnation.net/files/attach/images/3378/399/875/003/6599b3eaf9540918ac9046176db92b78.png", "http://www.fmkorea.com/files/attach/new/20170811/486616/48551030/739124925/b9b80be68796e9521d69e229fa4155c1.jpg",
    "http://rucid.dothome.co.kr/wp-content/uploads/2016/10/wc_01_m.jpg"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sport);
        setTitle("스포츠");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GridView gv = (GridView)findViewById(R.id.sportbackground);  //그리드뷰 생성
        Sport.GridAdaptersport gadapter = new Sport.GridAdaptersport(this);
        gv.setAdapter(gadapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sport, menu);
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
    public class GridAdaptersport extends BaseAdapter {

        Context context;
        public GridAdaptersport(Context c){
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
                R.drawable.sport01, R.drawable.sport02, R.drawable.sport03, R.drawable.sport04, R.drawable.sport05, R.drawable.sport06, R.drawable.sport07, R.drawable.sport08,
                R.drawable.sport09, R.drawable.sport10, R.drawable.sport11
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
                    View dialogView = (View)View.inflate(Sport.this, R.layout.dialog, null);   //다이얼로그 레이아웃을 보여줌
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Sport.this);
                    final ImageView backgournd = (ImageView)dialogView.findViewById(R.id.imagebackgournd);
                    backgournd.setImageResource(backgroundID[pos]);   //보여질 이미지는 누르는 이미지의 이미지를 보여줌
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("저장", new DialogInterface.OnClickListener() {       //다이얼로그의 저장부분에 대한 클릭 이벤트
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(pos == 0){                     //첫번째 이미지에대한 리스너
                                DownloadTask downloadTask = new DownloadTask();     //Downloadtask 클래스를 상속받아 변수값에 저장
                                downloadTask.execute(soprtimgurl[0]);        //정해진 url로 downloadtask클래스 실행

                            }
                            else if(pos == 1){         //두번째 이미지에 대한 리스너
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(soprtimgurl[1]);

                            }
                            else if(pos == 2){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(soprtimgurl[2]);

                            }
                            else if(pos == 3){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(soprtimgurl[3]);

                            }
                            else if(pos == 4){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(soprtimgurl[4]);

                            }
                            else if(pos == 5){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(soprtimgurl[5]);

                            }
                            else if(pos == 6){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(soprtimgurl[6]);

                            }
                            else if(pos == 7){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(soprtimgurl[7]);

                            }
                            else if(pos == 8){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(soprtimgurl[8]);

                            }
                            else if(pos == 9){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(soprtimgurl[9]);

                            }
                            else if(pos == 10){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(soprtimgurl[10]);

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