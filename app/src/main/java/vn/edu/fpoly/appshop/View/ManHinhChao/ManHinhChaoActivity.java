package vn.edu.fpoly.appshop.View.ManHinhChao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import vn.edu.fpoly.appshop.R;
import vn.edu.fpoly.appshop.View.TrangChu.TrangChuActivity;

/**
 * Created by Macanh on 2/19/2017.
 */

public class ManHinhChaoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinhchao_layout);
        Thread thread = new  Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                }catch (Exception e){

                }finally {
                    Intent iTranchu = new Intent(ManHinhChaoActivity.this, TrangChuActivity.class);
                    startActivity(iTranchu);
                }
            }
        });
        thread.start();
    }
}
