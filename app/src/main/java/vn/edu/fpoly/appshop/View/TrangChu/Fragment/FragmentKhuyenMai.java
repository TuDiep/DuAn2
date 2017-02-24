package vn.edu.fpoly.appshop.View.TrangChu.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.fpoly.appshop.R;

/**
 * Created by Macanh on 2/20/2017.
 */

public class FragmentKhuyenMai extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_khuyenmai,container,false);
        return view;
    }
}
