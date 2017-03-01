package vn.edu.fpoly.appshop.View.TrangChu.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import vn.edu.fpoly.appshop.Adapter.AdapterNoiBat;
import vn.edu.fpoly.appshop.R;

/**
 * Created by Macanh on 2/20/2017.
 */

public class FragmentNoiBat extends Fragment {
    AdapterNoiBat adapterNoiBat;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_noibat,container,false);
        recyclerView= (RecyclerView) view.findViewById(R.id.recyclenoibat);
        List<String> dulieu  = new ArrayList<>();
        for (int i=0 ; i<50;i++){
            String ten =  "noi bat "+ i;
            dulieu.add(ten);
        }
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2);


        adapterNoiBat = new AdapterNoiBat(getActivity(),dulieu);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterNoiBat);
        adapterNoiBat.notifyDataSetChanged();
        return view;
    }
}
