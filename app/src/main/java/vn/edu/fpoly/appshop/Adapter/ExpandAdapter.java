package vn.edu.fpoly.appshop.Adapter;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ListView;

import java.util.List;

import vn.edu.fpoly.appshop.Model.ObjectClass.LoaiSanPham;
import vn.edu.fpoly.appshop.Model.TrangChu.XuLyMenu.XuLyJSONMenu;
import vn.edu.fpoly.appshop.R;

/**
 * Created by Macanh on 2/25/2017.
 */

public class ExpandAdapter extends BaseExpandableListAdapter {
    Context context;
    List<LoaiSanPham> loaiSanPhams;
    ViewHolderMenu viewHolderMenu;
    public  ExpandAdapter (Context context, List<LoaiSanPham> loaiSanPhams){
        this.context = context;
        this.loaiSanPhams = loaiSanPhams;

        XuLyJSONMenu xuLyJSONMenu = new XuLyJSONMenu();

        int count = loaiSanPhams.size();
        for (int i= 0;i<count;i++){
            int maloaisp= loaiSanPhams.get(i).getMALOAISP();
            loaiSanPhams.get(i).setListcon( xuLyJSONMenu.LayLoaiSPTheoMaLoai(maloaisp));
        }


    }
    @Override
    public int getGroupCount() {
        return loaiSanPhams.size();
    }

    @Override
    public int getChildrenCount(int vitriGroupCha) {
        if(loaiSanPhams.get(vitriGroupCha).getListcon().size() !=0){
            return 1;
        } else {
            return 0;
        }

    }

    @Override
    public Object getGroup(int vitriGroupCha) {
        return loaiSanPhams.get(vitriGroupCha);
    }

    @Override
    public Object getChild(int vitriGroupCha, int vitriGroupCon) {
        return loaiSanPhams.get(vitriGroupCha).getListcon().get(vitriGroupCon);
    }

    @Override
    public long getGroupId(int vitriGroupCha) {
        return loaiSanPhams.get(vitriGroupCha).getMALOAISP();
    }

    @Override
    public long getChildId(int vitriGroupCha, int vitriGroupCon) {
        return loaiSanPhams.get(vitriGroupCha).getListcon().get(vitriGroupCon).getMALOAISP();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    public class ViewHolderMenu{
        TextView txtTenToaiSP;
        ImageView hinhMenu;
    }

    @Override
    public View getGroupView(final int vitriGroupCha, boolean isExpanded, View convertView, ViewGroup parent) {

        View view = convertView;
         if (view==null){
            viewHolderMenu = new ViewHolderMenu();

             LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
              view = layoutInflater.inflate(R.layout.custom_layout_group_cha,parent,false);
             viewHolderMenu.hinhMenu = (ImageView) view.findViewById(R.id.ImPlus);
             viewHolderMenu.txtTenToaiSP = (TextView) view.findViewById(R.id.txtTenloaisp);
             view.setTag(viewHolderMenu);
         }
        else {
             viewHolderMenu = (ViewHolderMenu) view.getTag();
         }


        viewHolderMenu.txtTenToaiSP.setText(loaiSanPhams.get(vitriGroupCha).getTENLOAISP());
        int demlist = loaiSanPhams.get(vitriGroupCha).getListcon().size();

        if (demlist>0){
            viewHolderMenu.hinhMenu.setVisibility(View.VISIBLE);
        }else {
            viewHolderMenu.hinhMenu.setVisibility(View.INVISIBLE);
        }

        if(isExpanded){
            viewHolderMenu.hinhMenu.setImageResource(R.drawable.ic_remove_black_24dp);

        }else {
            viewHolderMenu.hinhMenu.setImageResource(R.drawable.ic_add_black_24dp);
        }
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("loaisp", loaiSanPhams.get(vitriGroupCha).getTENLOAISP()+ " - " + loaiSanPhams.get(vitriGroupCha).getMALOAISP() );
                return false;
            }
        });

        return view;
    }

    @Override
    public View getChildView(int vitriGroupCha, int vitriGroupCon, boolean isExpanded, View convertView, ViewGroup parent) {
//        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = layoutInflater.inflate(R.layout.custom_layout_group_con,parent,false);
//        ExpandableListView expandableListView = (ExpandableListView) view.findViewById(R.id.epMenuCon);
        SecondExpanable secondExpanable = new SecondExpanable(context);
        ExpandAdapter secondAdapter = new ExpandAdapter(context,loaiSanPhams.get(vitriGroupCha).getListcon());
        secondExpanable.setAdapter(secondAdapter);

        secondExpanable.setGroupIndicator(null);
        secondExpanable.deferNotifyDataSetChanged();
        return secondExpanable;
    }

    public  class SecondExpanable extends  ExpandableListView{
        public SecondExpanable(Context context) {
            super(context);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            WindowManager windowManager = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
            Display display = windowManager.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);

            int width = size.x;
            int height = size.y;

//            widthMeasureSpec = MeasureSpec.makeMeasureSpec(width,MeasureSpec.AT_MOST);
            heightMeasureSpec =MeasureSpec.makeMeasureSpec(height,MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

//    public  class SecondAdapter extends  BaseExpandableListAdapter {
//        List<LoaiSanPham> listCon;
//        public  SecondAdapter(List<LoaiSanPham> listCon){
//            this.listCon = listCon;
//
//            XuLyJSONMenu xuLyJSONMenu = new XuLyJSONMenu();
//
//            int count = listCon.size();
//            for (int i= 0;i<count;i++){
//                int maloaisp= listCon.get(i).getMALOAISP();
//                listCon.get(i).setListcon( xuLyJSONMenu.LayLoaiSPTheoMaLoai(maloaisp));
//            }
//        }
//        @Override
//        public int getGroupCount() {
//            return listCon.size();
//        }
//
//        @Override
//        public int getChildrenCount(int vitriGroupCha) {
//            return listCon.get(vitriGroupCha).getListcon().size();
//        }
//
//        @Override
//        public Object getGroup(int vitriGroupCha) {
//            return listCon.get(vitriGroupCha);
//        }
//
//        @Override
//        public Object getChild(int vitriGroupCha, int vitriGroupCon) {
//            return listCon.get(vitriGroupCha).getListcon().get(vitriGroupCon);
//        }
//
//        @Override
//        public long getGroupId(int vitriGroupCha) {
//            return listCon.get(vitriGroupCha).getMALOAISP();
//        }
//
//        @Override
//        public long getChildId(int vitriGroupCha, int vitriGroupCon) {
//            return listCon.get(vitriGroupCha).getListcon().get(vitriGroupCon).getMALOAISP();
//        }
//
//        @Override
//        public boolean hasStableIds() {
//            return false;
//        }
//
//        @Override
//        public View getGroupView(int vitriGroupCha, boolean isExpanded, View convertView, ViewGroup parent) {
//            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View view = layoutInflater.inflate(R.layout.custom_layout_group_cha,parent,false);
//            TextView txtTenloaisp = (TextView) view.findViewById(R.id.txtTenloaisp);
//            txtTenloaisp.setText(listCon.get(vitriGroupCha).getTENLOAISP());
//            return view;
//        }
//
//        @Override
//        public View getChildView(int vitriGroupCha, int vitriGroupCon, boolean isExpanded, View convertView, ViewGroup parent) {
//            TextView tv = new TextView(context);
//           tv.setText(listCon.get(vitriGroupCha).getListcon().get(vitriGroupCon).getTENLOAISP());tv.setPadding(15, 5, 5, 5);
//          tv.setLayoutParams(new ListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//           return tv;
//        }
//        @Override
//        public boolean isChildSelectable(int groupPosition, int childPosition) {
//            return false;
//        }
//    }

}
