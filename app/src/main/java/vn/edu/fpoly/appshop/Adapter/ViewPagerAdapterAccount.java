package vn.edu.fpoly.appshop.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import vn.edu.fpoly.appshop.View.Account.Fragment.FragmentDangKy;
import vn.edu.fpoly.appshop.View.Account.Fragment.FragmentDangNhap;

/**
 * Created by vuong_000 on 2/20/2017.
 */

public class ViewPagerAdapterAccount extends FragmentPagerAdapter {

    public ViewPagerAdapterAccount(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FragmentDangNhap fragmentDangNhap = new FragmentDangNhap();
                return fragmentDangNhap;
            case 1:
                FragmentDangKy fragmentDangKy = new FragmentDangKy();
                return fragmentDangKy;
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Đăng Nhập";
            case 1:
                return "Đăng Ký";
            default: return null;
        }
    }
}
