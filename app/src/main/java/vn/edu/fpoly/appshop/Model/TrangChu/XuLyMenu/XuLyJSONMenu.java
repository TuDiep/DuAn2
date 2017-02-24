package vn.edu.fpoly.appshop.Model.TrangChu.XuLyMenu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import vn.edu.fpoly.appshop.ConnectInternet.DownloadJSON;
import vn.edu.fpoly.appshop.Model.ObjectClass.LoaiSanPham;

/**
 * Created by Macanh on 2/25/2017.
 */

public class XuLyJSONMenu {
    public List<LoaiSanPham> ParserJSONMenu(String dulieujson){

        List<LoaiSanPham> loaiSanPhamList = new ArrayList<>();


        try {

            JSONObject jsonObject = new JSONObject(dulieujson);
            JSONArray loaisanpham = jsonObject.getJSONArray("LOAISANPHAM");

            int count = loaisanpham.length();

            for (int i = 0; i < count; i++){

                JSONObject value = loaisanpham.getJSONObject(i);
                LoaiSanPham dataloaiSanPham = new LoaiSanPham();
                dataloaiSanPham.setMALOAISP(Integer.parseInt(value.getString("MALOAISP")));
                dataloaiSanPham.setMALOAICHA(Integer.parseInt(value.getString("MALOAI_CHA")));
                dataloaiSanPham.setTENLOAISP(value.getString("TENLOAISP"));

                loaiSanPhamList.add(dataloaiSanPham);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return loaiSanPhamList;
    }
    public  List<LoaiSanPham> LayLoaiSPTheoMaLoai(int maloaisp){

        List<LoaiSanPham> loaiSanPhamList = new ArrayList<>();
        List<HashMap<String,String>> attrs = new ArrayList<>();
        String duongdan="http://10.0.3.2/appshop/loaisanpham.php";
        String dataJSON="";

        HashMap<String,String> hsMaLoaiCha = new HashMap<>();
        hsMaLoaiCha.put("maloaicha",String.valueOf(maloaisp));
        attrs.add(hsMaLoaiCha);
        DownloadJSON downloadJSON= new DownloadJSON(duongdan,attrs);
        downloadJSON.execute();

        try {
            dataJSON= downloadJSON.get();
            XuLyJSONMenu xuLyJSONMenu = new XuLyJSONMenu();
            loaiSanPhamList = xuLyJSONMenu.ParserJSONMenu(dataJSON);


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return loaiSanPhamList;

    }
}
