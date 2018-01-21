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

public class Classic extends MainActivity {
    String[] classicimgurl = {"https://bsrl.org/images/wp-content/uploads/2016/05/Best-mobile-wallpapers6.jpg", "http://upload2.inven.co.kr/upload/2015/12/16/bbs/i11189873924.png",
    "http://livewallpapers.info/wp-content/uploads/2017/10/cool-iphone-wallpapers-hd-7.jpg", "http://media.idownloadblog.com/wp-content/uploads/2015/12/Christmas-Scenery-iPhone-Wallpaper-AR7.jpeg",
    "https://s-media-cache-ak0.pinimg.com/originals/f6/c9/82/f6c982de5cda2490762e2f56dd81ca53.jpg", "http://cfile29.uf.tistory.com/image/9947073359F04487320833",
    "http://www.hdwallpaper.kr/files/attach/images/6109/282/082/35f9b99681404b11b71d4f3b4b379070.jpg", "http://chzbk.com/xe/files/attach/images/128/533/033/002/2ecd88b69be617520536d51b77e328ae.png",
    "http://media.idownloadblog.com/wp-content/uploads/2015/08/Redmi-Note-2-for-iPhone-blocks-opt-AR2014.jpg", "https://bsrl.org/wallpaper/wp-content/uploads/2016/05/Apple-Iphone-6s-wallpaper-tumblr-clear-the-moon.jpg"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classic);
        setTitle("클래식");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GridView gv = (GridView)findViewById(R.id.classicbackground);  //그리드뷰 생성
        Classic.GridAdapterclassic gadapter = new Classic.GridAdapterclassic(this);
        gv.setAdapter(gadapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.classic, menu);
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
    public class GridAdapterclassic extends BaseAdapter {

        Context context;
        public GridAdapterclassic(Context c){
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
                R.drawable.classic01, R.drawable.classic02, R.drawable.classic03, R.drawable.classic04, R.drawable.classic05, R.drawable.classic06,
                R.drawable.classic07, R.drawable.classic08, R.drawable.classic09, R.drawable.classic10
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
                    View dialogView = (View)View.inflate(Classic.this, R.layout.dialog, null);   //다이얼로그 레이아웃을 보여줌
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Classic.this);
                    final ImageView backgournd = (ImageView)dialogView.findViewById(R.id.imagebackgournd);
                    backgournd.setImageResource(backgroundID[pos]);   //보여질 이미지는 누르는 이미지의 이미지를 보여줌
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("저장", new DialogInterface.OnClickListener() {       //다이얼로그의 저장부분에 대한 클릭 이벤트
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(pos == 0){                     //첫번째 이미지에대한 리스너
                                DownloadTask downloadTask = new DownloadTask();     //Downloadtask 클래스를 상속받아 변수값에 저장
                                downloadTask.execute(classicimgurl[0]);        //정해진 url로 downloadtask클래스 실행

                            }
                            else if(pos == 1){         //두번째 이미지에 대한 리스너
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(classicimgurl[1]);

                            }
                            else if(pos == 2){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(classicimgurl[2]);

                            }
                            else if(pos == 3){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(classicimgurl[3]);

                            }
                            else if(pos == 4){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(classicimgurl[4]);

                            }
                            else if(pos == 5){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(classicimgurl[5]);

                            }
                            else if(pos == 6){         //두번째 이미지에 대한 리스너
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(classicimgurl[6]);

                            }
                            else if(pos == 7){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(classicimgurl[7]);

                            }
                            else if(pos == 8){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(classicimgurl[8]);

                            }
                            else if(pos == 9){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(classicimgurl[9]);

                            }
                            else if(pos == 10){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(classicimgurl[10]);

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
