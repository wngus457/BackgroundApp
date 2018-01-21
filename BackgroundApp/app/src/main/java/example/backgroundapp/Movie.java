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

public class Movie extends MainActivity {
    //밑에 스트링 배열은 이미지를 다운받기위한 주소
    String[] moiveimgurl = {"https://www.city.kr/files/attach/images/1326/468/249/dbc8249c99fc35465bf8bf1b718dce65.jpg", "https://www.city.kr/files/attach/images/1326/481/249/2cb490ec3c183d2f947279805600b031.jpg",
    "https://www.city.kr/files/attach/images/1326/436/249/98beb27e0cc5b7287ad1a3b7ce5b5550.jpg","https://www.city.kr/files/attach/images/1326/570/249/5e0cddd66127779952de9ffcdfa4fcd3.jpg",
    "https://bsrl.org/wallpaper/wp-content/uploads/2016/05/harry-potter-iphone-wallpaper4.jpg","https://cdn.wallpapersafari.com/75/19/98QASO.jpg",
    "http://down.humoruniv.org/hwiparambbs/data/comment/2016/06/pdswait_4023609_1466766385.93018.png","http://www.pixgraphiz.tk/image/mobileimage/3SlgeG2.jpg",
    "http://www.vactualpapers.com/web/images/July%202016/Batman%20Artistic%20View%20Mobile%20HD%20Wallpaper.jpg"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie);
        setTitle("영화");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GridView gv = (GridView)findViewById(R.id.moviebackground);  //그리드뷰 생성
        Movie.GridAdaptermovie gadapter = new Movie.GridAdaptermovie(this);
        gv.setAdapter(gadapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.movie, menu);
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
    public class GridAdaptermovie extends BaseAdapter {       //어뎁터 클래스를 만듦

        Context context;
        public GridAdaptermovie(Context c){
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
        Integer[] backgroundID = {                     //이미지 파일을 배열로 만듦
                R.drawable.movie01, R.drawable.movie02, R.drawable.movie03, R.drawable.movie04, R.drawable.movie05, R.drawable.movie06,
                R.drawable.movie07, R.drawable.movie08, R.drawable.movie09
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
                    View dialogView = (View)View.inflate(Movie.this, R.layout.dialog, null);   //다이얼로그 레이아웃을 맵핑
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Movie.this);   //다이얼로그 생성
                    final ImageView backgournd = (ImageView)dialogView.findViewById(R.id.imagebackgournd);
                    backgournd.setImageResource(backgroundID[pos]);   //보여질 이미지는 누르는 이미지의 이미지를 보여줌
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("저장", new DialogInterface.OnClickListener() {       //다이얼로그의 저장부분에 대한 클릭 이벤트
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(pos == 0){                     //첫번째 이미지에대한 리스너
                                DownloadTask downloadTask = new DownloadTask();     //Downloadtask 클래스를 상속받아 변수값에 저장
                                downloadTask.execute(moiveimgurl[0]);        //정해진 url로 downloadtask클래스 실행

                            }
                            else if(pos == 1){         //두번째 이미지에 대한 리스너
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(moiveimgurl[1]);

                            }
                            else if(pos == 2){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(moiveimgurl[2]);

                            }
                            else if(pos == 3){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(moiveimgurl[3]);

                            }
                            else if(pos == 4){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(moiveimgurl[4]);

                            }
                            else if(pos == 5){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(moiveimgurl[5]);

                            }
                            else if(pos == 6){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(moiveimgurl[6]);

                            }
                            else if(pos == 7){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(moiveimgurl[7]);

                            }
                            else if(pos == 8){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(moiveimgurl[8]);

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
