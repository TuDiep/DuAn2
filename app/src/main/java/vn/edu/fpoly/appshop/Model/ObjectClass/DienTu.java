package vn.edu.fpoly.appshop.Model.ObjectClass;

import java.util.List;

/**
 * Created by Macanh on 2/27/2017.
 */

public class DienTu {
    List<ThuongHieu> thuongHieus;
    List<SanPham> sanPhams;
    String HinhSanPham;

    public String getHinhSanPham() {
        return HinhSanPham;
    }

    public void setHinhSanPham(String hinhSanPham) {
        HinhSanPham = hinhSanPham;
    }


    public List<ThuongHieu> getThuongHieus() {
        return thuongHieus;
    }

    public void setThuongHieus(List<ThuongHieu> thuongHieus) {
        this.thuongHieus = thuongHieus;
    }

    public List<SanPham> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(List<SanPham> sanPhams) {
        this.sanPhams = sanPhams;
    }


}
