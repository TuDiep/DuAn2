package vn.edu.fpoly.appshop.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import vn.edu.fpoly.appshop.View.TrangChu.Fragment.FragmentDienThoai;
import vn.edu.fpoly.appshop.View.TrangChu.Fragment.FragmentDungCuGiaDinh;
import vn.edu.fpoly.appshop.View.TrangChu.Fragment.FragmentKhuyenMai;
import vn.edu.fpoly.appshop.View.TrangChu.Fragment.FragmentLapTop;
import vn.edu.fpoly.appshop.View.TrangChu.Fragment.FragmentNoiBat;
import vn.edu.fpoly.appshop.View.TrangChu.Fragment.FragmentThuongHieu;

/**
 * Created by Macanh on 2/20/2017.
 */

public class ViewpagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList = new ArrayList<Fragment>();
    List<String> titlefragment = new ArrayList<String>();
    public ViewpagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentList.add(new FragmentNoiBat());
        fragmentList.add(new FragmentKhuyenMai());
        fragmentList.add(new FragmentDienThoai());
        fragmentList.add(new FragmentLapTop());
        fragmentList.add(new FragmentDungCuGiaDinh());
        fragmentList.add(new FragmentThuongHieu());

        titlefragment.add("Nổi Bật");
        titlefragment.add("Chương Trình Khuyến Mãi");
        titlefragment.add("Điện Thoại");
        titlefragment.add("Máy Tính Xách Tay");
        titlefragment.add("Dụng Cụ Gia Đình");
        titlefragment.add("Thương Hiệu");
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titlefragment.get(position);
    }
}
