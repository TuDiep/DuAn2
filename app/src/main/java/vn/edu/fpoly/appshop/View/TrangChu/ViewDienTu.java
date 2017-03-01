package vn.edu.fpoly.appshop.View.TrangChu;

import java.util.List;

import vn.edu.fpoly.appshop.Model.ObjectClass.SanPham;
import vn.edu.fpoly.appshop.Model.ObjectClass.ThuongHieu;

/**
 * Created by Macanh on 2/27/2017.
 */

public interface ViewDienTu {
    void HienThiDanhSach(List<ThuongHieu> thuongHieus, List<SanPham> sanPhams);

}
