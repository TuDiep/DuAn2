package vn.edu.fpoly.appshop.View.Account;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import vn.edu.fpoly.appshop.Adapter.ViewPagerAdapterAccount;
import vn.edu.fpoly.appshop.R;

public class AccountActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_layout);

        tabLayout = (TabLayout)findViewById(R.id.tabDangnhap);
        viewPager = (ViewPager)findViewById(R.id.viewDangnhap);
        toolbar = (Toolbar)findViewById(R.id.toolBarDangNhap);

        setSupportActionBar(toolbar);

        ViewPagerAdapterAccount viewPagerAdapterAccount = new ViewPagerAdapterAccount(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapterAccount);
        viewPagerAdapterAccount.notifyDataSetChanged();

        tabLayout.setupWithViewPager(viewPager);
    }
}
