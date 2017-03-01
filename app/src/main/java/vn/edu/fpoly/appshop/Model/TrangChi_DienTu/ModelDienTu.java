package vn.edu.fpoly.appshop.Model.TrangChi_DienTu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import vn.edu.fpoly.appshop.ConnectInternet.DownloadJSON;
import vn.edu.fpoly.appshop.Model.ObjectClass.SanPham;
import vn.edu.fpoly.appshop.Model.ObjectClass.ThuongHieu;
import vn.edu.fpoly.appshop.Model.TrangChu.XuLyMenu.XuLyJSONMenu;
import vn.edu.fpoly.appshop.View.TrangChu.TrangChuActivity;

/**
 * Created by Macanh on 2/26/2017.
 */

public class ModelDienTu {
    public  List<SanPham> LayDanhSachTopDienThoaiVaMayTinhBang(){
        List<SanPham> sanPhams = new ArrayList<>();
        List<HashMap<String,String>> attrs = new ArrayList<>();
        String duongdan = TrangChuActivity.SERVER_NAME;
        String dataJSON="";
        HashMap<String,String> hsHam = new HashMap<>();


        hsHam.put("ham","LayDanhSachTopDienThoaiVaMayTinhBang");
        attrs.add(hsHam);

        DownloadJSON downloadJSON = new DownloadJSON(duongdan,attrs);
        downloadJSON.execute();

        try {

            dataJSON = downloadJSON.get();
            JSONObject jsonObject = new JSONObject(dataJSON);
            JSONArray jsonArrayTopDienThoaiVaMTB = jsonObject.getJSONArray("TOPDIENTHOAIVAMAYTINHBANG");
            int dem = jsonArrayTopDienThoaiVaMTB.length();

            for (int i = 0; i< dem ; i++){
                SanPham sanPham = new SanPham();
                JSONObject object = jsonArrayTopDienThoaiVaMTB.getJSONObject(i);
                sanPham.setMASP(object.getInt("MASP"));
                sanPham.setTENSP(object.getString("TENSP"));
                sanPham.setGIA(object.getInt("GIATIEN"));
                sanPham.setANHLON(object.getString("HINHSANPHAM"));

                sanPhams.add(sanPham);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sanPhams;
    }
    public List<ThuongHieu> LayDanhSachThuongHieuLon(){
        List<ThuongHieu> thuongHieuList = new ArrayList<>();

        List<HashMap<String,String>> attrs = new ArrayList<>();
        String duongdan= TrangChuActivity.SERVER_NAME;
        String dataJSON="";
        HashMap<String,String> hsHam = new HashMap<>();
        hsHam.put("ham","LayDanhSachCacThuongHieuLon");

        attrs.add(hsHam);
        DownloadJSON downloadJSON= new DownloadJSON(duongdan,attrs);
        downloadJSON.execute();

        try {
            dataJSON= downloadJSON.get();
            JSONObject jsonObject = new JSONObject(dataJSON);
            JSONArray jsonArrayDanhSachThuongHieu=jsonObject.getJSONArray("DANHSACHTHUONGHIEU");
            int dem =jsonArrayDanhSachThuongHieu.length();
            for (int i = 0; i<dem;i++){
                ThuongHieu thuongHieu = new ThuongHieu();

                JSONObject object = jsonArrayDanhSachThuongHieu.getJSONObject(i);
                thuongHieu.setMATHUONGHIEU(object.getInt("MATHUONGHIEU"));
                thuongHieu.setTENTHUONGHIEU(object.getString("TENTHUONGHIEU"));
                thuongHieu.setHINHTHUONGHIEU(object.getString("HINHTHUONGHIEU"));

                thuongHieuList.add(thuongHieu);

            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return thuongHieuList;
    }
}
