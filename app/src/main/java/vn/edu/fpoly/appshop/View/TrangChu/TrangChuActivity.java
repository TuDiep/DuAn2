package vn.edu.fpoly.appshop.View.TrangChu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.List;

import vn.edu.fpoly.appshop.Adapter.ExpandAdapter;
import vn.edu.fpoly.appshop.Adapter.ViewpagerAdapter;
import vn.edu.fpoly.appshop.Model.ObjectClass.LoaiSanPham;
import vn.edu.fpoly.appshop.Presenter.TrangChu.XuLyMenu.PresenterLogicXuLyMenu;
import vn.edu.fpoly.appshop.R;
import vn.edu.fpoly.appshop.View.Account.AccountActivity;

public class TrangChuActivity extends AppCompatActivity implements  ViewXuLyMenu{
    public static final String SERVER_NAME = "http://10.0.3.2/appshop/loaisanpham.php";
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    ExpandableListView expandableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu_layout);

        toolbar = (Toolbar) findViewById(R.id.Toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        expandableListView = (ExpandableListView) findViewById(R.id.epMenu);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle.syncState();

        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewpagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        PresenterLogicXuLyMenu logicXuLyMenu = new PresenterLogicXuLyMenu(this);
        logicXuLyMenu.LayDanhSachMenu();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutrangchu, menu);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Log.d("Item ID: ", String.valueOf(item.getItemId()));
        switch (item.getItemId()){
            case R.id.itDangNhap:
                Intent intent = new Intent(this, AccountActivity.class);
                startActivity(intent);
                break;
            case R.id.itThongBao:
                Toast.makeText(this, "Thong Bao", Toast.LENGTH_LONG).show();
                break;
            case R.id.itDanhSachMongMuon:
                Toast.makeText(this, "Danh sach mong muon", Toast.LENGTH_LONG).show();
                break;
            case R.id.itDonHangCuaToi:
                Toast.makeText(this, "Don Hang", Toast.LENGTH_LONG).show();
                break;
            case R.id.itCaiDat:
                Toast.makeText(this, "Cai dat", Toast.LENGTH_LONG).show();
                break;
            case R.id.itChinhSach:
                Toast.makeText(this, "Chinh sach", Toast.LENGTH_LONG).show();
                break;
            case R.id.itTroGiup:
                Toast.makeText(this, "Tro giup", Toast.LENGTH_LONG).show();
                break;

        }

        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return true;
    }


    @Override
    public void HienThiDanhSachMenu(List<LoaiSanPham> loaiSanPhamList) {
        ExpandAdapter expandAdapter = new ExpandAdapter(this,loaiSanPhamList);
        expandableListView.setAdapter(expandAdapter);
        expandAdapter.notifyDataSetChanged();
    }
}
