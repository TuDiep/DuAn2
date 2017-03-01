package vn.edu.fpoly.appshop.View.TrangChu.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vn.edu.fpoly.appshop.Adapter.AdapterDienTu;
import vn.edu.fpoly.appshop.Model.ObjectClass.DienTu;
import vn.edu.fpoly.appshop.Model.ObjectClass.SanPham;
import vn.edu.fpoly.appshop.Model.ObjectClass.ThuongHieu;
import vn.edu.fpoly.appshop.Presenter.TrangChu_DienTu.PresenterLogicDienTu;
import vn.edu.fpoly.appshop.R;
import vn.edu.fpoly.appshop.View.TrangChu.ViewDienTu;

/**
 * Created by Macanh on 2/20/2017.
 */

public class FragmentDienTu extends Fragment implements ViewDienTu {
    RecyclerView recyclerView;
    List<DienTu> dienTuList;
    PresenterLogicDienTu presenterLogicDienTu;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_dientu,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerViewDienTu);
        presenterLogicDienTu = new PresenterLogicDienTu(this);


        dienTuList = new ArrayList<>();
        presenterLogicDienTu.LayDanhSachDienTu();
        return view;
    }

    @Override
    public void HienThiDanhSach(List<ThuongHieu> thuongHieus, List<SanPham> sanPhams) {
        DienTu dienTu = new DienTu();
        dienTu.setThuongHieus(thuongHieus);
        dienTu.setSanPhams(sanPhams);
        dienTuList.add(dienTu);

        AdapterDienTu adapterDienTu = new AdapterDienTu(getContext(),dienTuList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterDienTu);
        adapterDienTu.notifyDataSetChanged();


    }
}
