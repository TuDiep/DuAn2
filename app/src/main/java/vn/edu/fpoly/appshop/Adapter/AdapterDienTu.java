package vn.edu.fpoly.appshop.Adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

import vn.edu.fpoly.appshop.Model.ObjectClass.DienTu;
import vn.edu.fpoly.appshop.Model.ObjectClass.SanPham;
import vn.edu.fpoly.appshop.R;

/**
 * Created by Macanh on 2/27/2017.
 */

public class AdapterDienTu extends RecyclerView.Adapter<AdapterDienTu.ViewHolderDienTu> {
    Context context;
    List<DienTu> dienTuList;
    public AdapterDienTu (Context context, List<DienTu> dienTuList){
        this.context = context;
        this.dienTuList=dienTuList;
    }


    public class ViewHolderDienTu extends RecyclerView.ViewHolder {
        ImageView imHinhGiamGia;
        RecyclerView recyclerViewThuongHieuLon,recyclerViewTopSanPham;
        public ViewHolderDienTu(View itemView) {
            super(itemView);
            recyclerViewThuongHieuLon = (RecyclerView) itemView.findViewById(R.id.recyclerTHLon);
            recyclerViewTopSanPham = (RecyclerView) itemView.findViewById(R.id.recyclerTopDTMTbang);
            imHinhGiamGia = (ImageView) itemView.findViewById(R.id.imKhuyenMaiDienTu);
        }
    }

    @Override
    public ViewHolderDienTu onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_layout_recyclerview_dientu,parent,false);
        ViewHolderDienTu viewHolderDienTu = new ViewHolderDienTu(view);

        return viewHolderDienTu;
    }

    @Override
    public void onBindViewHolder(ViewHolderDienTu holder, int position) {
        DienTu dienTu = dienTuList.get(position);
        AdapterThuongHieuLon adapterThuongHieuLon = new AdapterThuongHieuLon(context,dienTu.getThuongHieus());
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context,3, GridLayout.HORIZONTAL,false);
        holder.recyclerViewThuongHieuLon.setLayoutManager(layoutManager);
        holder.recyclerViewThuongHieuLon.setAdapter(adapterThuongHieuLon);
        adapterThuongHieuLon.notifyDataSetChanged();

        AdapterTopDienThoaiDienTu adapterTopDienThoaiDienTu = new AdapterTopDienThoaiDienTu(context,dienTu.getSanPhams());
        RecyclerView.LayoutManager layoutManagerTopDienThoai = new LinearLayoutManager(context, LinearLayout.HORIZONTAL,false);
        holder.recyclerViewTopSanPham.setLayoutManager(layoutManagerTopDienThoai);

        holder.recyclerViewTopSanPham.setAdapter(adapterTopDienThoaiDienTu);
        adapterTopDienThoaiDienTu.notifyDataSetChanged();


    }

    @Override
    public int getItemCount() {
        return dienTuList.size();
    }


}
