package vn.edu.fpoly.appshop.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import vn.edu.fpoly.appshop.Model.ObjectClass.SanPham;
import vn.edu.fpoly.appshop.R;

/**
 * Created by Macanh on 2/27/2017.
 */

public class AdapterTopDienThoaiDienTu extends RecyclerView.Adapter<AdapterTopDienThoaiDienTu.ViewHolderTopDienThoai> {
    Context context;
    List<SanPham> sanPhamList;
    public AdapterTopDienThoaiDienTu(Context context, List<SanPham> sanPhamList){
        this.context =context;
        this.sanPhamList = sanPhamList;
    }
    public class   ViewHolderTopDienThoai extends RecyclerView.ViewHolder {
        ImageView imageHinhSanPham;
        TextView txtTenSP,txtGiaTien,txtGiamGia;
        public ViewHolderTopDienThoai(View itemView) {
            super(itemView);
            imageHinhSanPham= (ImageView) itemView.findViewById(R.id.imTopDienThoaiDienTu);
            txtTenSP = (TextView) itemView.findViewById(R.id.txtTieuDeTopDienTu);
            txtGiaTien = (TextView) itemView.findViewById(R.id.txtGiaDienTu);
            txtGiamGia = (TextView) itemView.findViewById(R.id.txtDienTuGiamGia);
        }
    }
    @Override
    public ViewHolderTopDienThoai onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout_topdienthoaivamaytinhbang,parent,false);
        ViewHolderTopDienThoai viewHolderTopDienThoai = new ViewHolderTopDienThoai(view);
        return viewHolderTopDienThoai;
    }

    @Override
    public void onBindViewHolder(ViewHolderTopDienThoai holder, int position) {
        SanPham sanPham= sanPhamList.get(position);
        Picasso.with(context).load(sanPham.getANHLON()).resize(140,142).centerInside().into(holder.imageHinhSanPham);
        holder.txtTenSP.setText(sanPham.getTENSP());
        NumberFormat numberFormat = new DecimalFormat("###,###");
        String gia = numberFormat.format(sanPham.getGIA()).toString();
        holder.txtGiaTien.setText(gia + " VNĐ");
    }

    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }


}
