package vn.edu.fpoly.appshop.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import vn.edu.fpoly.appshop.Model.ObjectClass.ThuongHieu;
import vn.edu.fpoly.appshop.R;

/**
 * Created by Macanh on 2/26/2017.
 */

public class AdapterThuongHieuLon extends RecyclerView.Adapter<AdapterThuongHieuLon.ViewHolderThuongHieu> {
    Context context;
    List<ThuongHieu> thuongHieus;
    public  AdapterThuongHieuLon(Context context, List<ThuongHieu> thuongHieus) {
        this.context=context;
        this.thuongHieus =thuongHieus;
    }

    public class ViewHolderThuongHieu extends RecyclerView.ViewHolder {
        TextView txtTieuDeThuongHieu;
        ImageView imHinhThuongHieu;
        ProgressBar progressBar;
        LinearLayout linearLayout;
        public ViewHolderThuongHieu(View itemView) {
            super(itemView);
           txtTieuDeThuongHieu = (TextView) itemView.findViewById(R.id.tieudeThuongHieuLonDienTu);
            imHinhThuongHieu = (ImageView) itemView.findViewById(R.id.imHinhThuongHieuLonDienTu);
            progressBar = (ProgressBar) itemView.findViewById(R.id.Process_Bar_Download);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.LinearThuongHieuLon);
        }
    }
    @Override
    public ViewHolderThuongHieu onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_layout_recycler_thuonghieulon,parent,false);
        ViewHolderThuongHieu viewHolderThuongHieu = new ViewHolderThuongHieu(view);
        return viewHolderThuongHieu;
    }

    @Override
    public void onBindViewHolder(final ViewHolderThuongHieu holder, int position) {
        ThuongHieu thuongHieu = thuongHieus.get(position);
        holder.txtTieuDeThuongHieu.setText(thuongHieu.getTENTHUONGHIEU());
        Picasso.with(context).load(thuongHieu.getHINHTHUONGHIEU()).resize(120,120).into(holder.imHinhThuongHieu, new Callback() {
            @Override
            public void onSuccess() {
                holder.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });
    }

    @Override
    public int getItemCount() {
        return thuongHieus.size();
    }
}
