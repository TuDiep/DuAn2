package vn.edu.fpoly.appshop.Presenter.TrangChu_DienTu;

import java.util.List;

import vn.edu.fpoly.appshop.Model.ObjectClass.SanPham;
import vn.edu.fpoly.appshop.Model.ObjectClass.ThuongHieu;
import vn.edu.fpoly.appshop.Model.TrangChi_DienTu.ModelDienTu;
import vn.edu.fpoly.appshop.View.TrangChu.ViewDienTu;

/**
 * Created by Macanh on 2/27/2017.
 */

public class PresenterLogicDienTu implements IPresenterDienTu {
    ViewDienTu viewDienTu;
    ModelDienTu modelDienTu;

    public PresenterLogicDienTu (ViewDienTu viewDienTu){
        this.viewDienTu = viewDienTu;
        modelDienTu = new ModelDienTu();
    }
    @Override
    public void LayDanhSachDienTu() {
        List<ThuongHieu> thuongHieuList=modelDienTu.LayDanhSachThuongHieuLon();
        List<SanPham> sanPhamList=modelDienTu.LayDanhSachTopDienThoaiVaMayTinhBang();
        if (thuongHieuList.size()>0 ){
            viewDienTu.HienThiDanhSach(thuongHieuList,sanPhamList);

        }
    }
}
