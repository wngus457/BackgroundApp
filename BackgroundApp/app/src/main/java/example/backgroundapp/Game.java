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

public class Game extends MainActivity {
    String[] gameimgurl = {"http://cfile4.uf.tistory.com/image/2147DF3A53C8EA990D4D51", "http://upload2.inven.co.kr/upload/2017/02/14/bbs/i14639283108.jpg",
    "http://cfile8.uf.tistory.com/image/2179573A53C9E21F2AA54A", "http://upload2.inven.co.kr/upload/2016/07/28/bbs/i12502663791.png",
    "http://www.fmkorea.com/files/attach/new/20160826/383486389/268307298/446876333/53126dfe55fc01a4e1874c5c9aa89390.jpg","http://s.nx.com/s2/Game/Maplestory2/wallpaper/wallpaper_14032418_galaxy.jpg",
    "http://s.nx.com/s2/Game/Maplestory2/wallpaper/wallpaper_140904_galaxy.jpg","http://s.nx.com/s2/Game/Maplestory2/wallpaper/wallpaper_150314_white_galaxy.jpg"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        setTitle("게임");
        GridView gv = (GridView)findViewById(R.id.gamebackground);  //그리드뷰 생성
        Game.GridAdaptergame gadapter = new Game.GridAdaptergame(this); //해당클래스를 가져와 gadapter에 저장함
        gv.setAdapter(gadapter);   //그리드뷰에 어뎁터를 적용시킴
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {   // 타이틀바 설정
        getMenuInflater().inflate(R.menu.game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){  //타이틀바 아이템에대한 리스너
        int id = item.getItemId();

        if(id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
    public class GridAdaptergame extends BaseAdapter {   //그리드뷰 어뎁터 생성

        Context context;
        public GridAdaptergame(Context c){
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
                R.drawable.game01, R.drawable.game02, R.drawable.game03, R.drawable.game04, R.drawable.game05, R.drawable.game06, R.drawable.game07, R.drawable.game08
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
                    View dialogView = (View)View.inflate(Game.this, R.layout.dialog, null);   //다이얼로그 레이아웃을 보여줌
                    AlertDialog.Builder dlg = new AlertDialog.Builder(Game.this);  //다이얼로그 생성
                    final ImageView backgournd = (ImageView)dialogView.findViewById(R.id.imagebackgournd);
                    backgournd.setImageResource(backgroundID[pos]);   //보여질 이미지는 누르는 이미지의 이미지를 보여줌
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("저장", new DialogInterface.OnClickListener() {       //다이얼로그의 저장부분에 대한 클릭 이벤트
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(pos == 0){                     //첫번째 이미지에대한 리스너
                                DownloadTask downloadTask = new DownloadTask();     //Downloadtask 클래스를 상속받아 변수값에 저장
                                downloadTask.execute(gameimgurl[0]);        //정해진 url로 downloadtask클래스 실행

                            }
                            else if(pos == 1){         //두번째 이미지에 대한 리스너
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(gameimgurl[1]);

                            }
                            else if(pos == 2){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(gameimgurl[2]);

                            }
                            else if(pos == 3){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(gameimgurl[3]);

                            }
                            else if(pos == 4){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(gameimgurl[4]);

                            }
                            else if(pos == 5){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(gameimgurl[5]);

                            }
                            else if(pos == 6){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(gameimgurl[6]);

                            }
                            else if(pos == 7){
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.execute(gameimgurl[7]);

                            }

                        }
                    });
                    dlg.setPositiveButton("닫기", null);
                    dlg.show();  //다이얼로그 보여줌
                }
            });
            return imageView;
        }
    }
}
