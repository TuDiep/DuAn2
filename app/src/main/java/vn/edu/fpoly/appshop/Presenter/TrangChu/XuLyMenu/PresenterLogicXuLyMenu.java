package vn.edu.fpoly.appshop.Presenter.TrangChu.XuLyMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import vn.edu.fpoly.appshop.ConnectInternet.DownloadJSON;
import vn.edu.fpoly.appshop.Model.ObjectClass.LoaiSanPham;
import vn.edu.fpoly.appshop.Model.TrangChu.XuLyMenu.XuLyJSONMenu;
import vn.edu.fpoly.appshop.View.TrangChu.TrangChuActivity;
import vn.edu.fpoly.appshop.View.TrangChu.ViewXuLyMenu;

/**
 * Created by Macanh on 2/25/2017.
 */

public class PresenterLogicXuLyMenu implements IPresenterXuLyMenu {

    ViewXuLyMenu viewXuLyMenu;

    public  PresenterLogicXuLyMenu(ViewXuLyMenu viewXuLyMenu){
        this.viewXuLyMenu=viewXuLyMenu;
    }

    @Override
    public void LayDanhSachMenu() {
        List<LoaiSanPham> loaiSanPhamList;
        String dataJSON="";
        List<HashMap<String,String>> attrs = new ArrayList<>();
        HashMap<String,String> hsHam = new HashMap<>();
        hsHam.put("ham","LayDanhSachMenu");
////        String duongdan="http://10.0.3.2/appshop/loaisanpham.php?maloaicha=";
//
//        DownloadJSON downloadJSON = new DownloadJSON(duongdan);

        String duongdan= TrangChuActivity.SERVER_NAME;

        HashMap<String,String> hsMaLoaiCha = new HashMap<>();
        hsMaLoaiCha.put("maloaicha","0");
        attrs.add(hsMaLoaiCha);
        attrs.add(hsHam);

        DownloadJSON downloadJSON= new DownloadJSON(duongdan,attrs);
        downloadJSON.execute();

        try {
            dataJSON= downloadJSON.get();
            XuLyJSONMenu xuLyJSONMenu = new XuLyJSONMenu();
            loaiSanPhamList = xuLyJSONMenu.ParserJSONMenu(dataJSON);
            viewXuLyMenu.HienThiDanhSachMenu(loaiSanPhamList);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
