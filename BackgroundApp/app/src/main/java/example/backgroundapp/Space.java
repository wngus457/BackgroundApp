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

public class Space extends MainActivity {
    String[] spaceimgurl = {"http://appdata.hungryapp.co.kr/data_file/data_img_m/201502/24/1424775371_6pfUOT7h.jpg", "http://www.hdwallpaper.kr/files/attach/images/6109/859/081/0dd1964d1a1511b88c9d9737e1846398.jpg",
    "http://kr.wallpaperforgirls.com/son/byeogji-leul-wihae-sonyeo-1080x1920-751-f2252226.jpg","http://file2.instiz.net/data/cached_img/upload/2015/12/31/1/248889e2286f754da6c8ecf163787967.jpg",
    "http://www.city.kr/files/attach/images/1326/920/274/001/2ffcebb800a0b6624203f79763f25841.JPG","https://cdn.clien.net/web/api/file//F01/5036546/af0fd58c69f74cd6bc2.JPG",
    "https://cdn.clien.net/web/api/file//F01/5315342/42e2cd90520b45dfba1.JPG","http://www.hdwallpaper.kr/files/attach/images/6109/591/161/632127f08b2e734d4df47fa5ecf9f46d.jpg",
    "http://image.aladin.co.kr/img/events/book/2015/b_1080x1920_m.jpg","https://bsrl.org/images/wp-content/uploads/2016/06/galaxy-wallpaper-for-iphone2.jpg"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.space);
        setTitle("우주");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);        //타이틀바에 홈버튼 생성

        GridView gv = (GridView)findViewById(R.id.spacebackground);  //그리드뷰 생성
        Space.GridAdapterspace gadapter = new Space.GridAdapterspace(this);  //이전 엑티비티와 마찬가지
        gv.setAdapter(gadapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.space, menu);
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
    public class GridAdapterspace extends BaseAdapter {

        Context context;
        public GridAdapterspace(Context c){
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
                R.drawable.space01, R.drawable.space02, R.drawable.space03, R.drawable.space04, R.drawable.space05, R.drawable.space06,
                R.drawable.space07, R.drawable.space08, R.drawable.space09, R.drawable.space10
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
                    View dialogView = (View)View.inflate(Space.this, R.layout.dialog, null);   //다이얼로그 레이아웃을 보여줌
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Space.this);
                    final ImageView backgournd = (ImageView)dialogView.findViewById(R.id.imagebackgournd);
                    backgournd.setImageResource(backgroundID[pos]);   //보여질 이미지는 누르는 이미지의 이미지를 보여줌
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("저장", new DialogInterface.OnClickListener() {       //다이얼로그의 저장부분에 대한 클릭 이벤트
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(pos == 0){                     //첫번째 이미지에대한 리스너
                                DownloadTask downloadTask = new DownloadTask();     //Downloadtask 클래스를 상속받아 변수값에 저장
                                downloadTask.execute(spaceimgurl[0]);        //정해진 url로 downloadtask클래스 실행

                            }
                            else if(pos == 1){         //두번째 이미지에 대한 리스너
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(spaceimgurl[1]);

                            }
                            else if(pos == 2){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(spaceimgurl[2]);

                            }
                            else if(pos == 3){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(spaceimgurl[3]);

                            }
                            else if(pos == 4){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(spaceimgurl[4]);

                            }
                            else if(pos == 5){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(spaceimgurl[5]);

                            }
                            else if(pos == 6){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(spaceimgurl[6]);

                            }
                            else if(pos == 7){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(spaceimgurl[7]);

                            }
                            else if(pos == 8){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(spaceimgurl[8]);

                            }
                            else if(pos == 9){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(spaceimgurl[9]);

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
