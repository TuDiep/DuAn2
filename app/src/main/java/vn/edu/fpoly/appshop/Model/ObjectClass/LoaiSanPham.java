package vn.edu.fpoly.appshop.Model.ObjectClass;

import java.util.List;

/**
 * Created by Macanh on 2/25/2017.
 */

public class LoaiSanPham {
    public String getTENLOAISP() {
        return TENLOAISP;
    }

    public void setTENLOAISP(String TENLOAISP) {
        this.TENLOAISP = TENLOAISP;
    }

    public int getMALOAICHA() {
        return MALOAICHA;
    }

    public void setMALOAICHA(int MALOAICHA) {
        this.MALOAICHA = MALOAICHA;
    }

    public int getMALOAISP() {
        return MALOAISP;
    }

    public void setMALOAISP(int MALOAISP) {
        this.MALOAISP = MALOAISP;
    }

    public List<LoaiSanPham> getListcon() {
        return listcon;
    }

    public void setListcon(List<LoaiSanPham> listcon) {
        this.listcon = listcon;
    }

    int MALOAISP,MALOAICHA;
    String TENLOAISP;
    List<LoaiSanPham> listcon;
}
