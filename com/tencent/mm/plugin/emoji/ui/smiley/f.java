package com.tencent.mm.plugin.emoji.ui.smiley;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.protocal.c.baj;
import com.tencent.mm.protocal.c.bak;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class f {
    private final String TAG;
    int Xd;
    int hPi;
    int kUJ;
    int kUK;
    int kUL;
    int kUM;
    int kUN;
    int kUO;
    int kUP;
    int kUQ;
    private int kUR;
    int kUS;
    int kUT;
    int kUU;
    int kUV;
    int kUW;
    int kUX;
    int kUY;
    int kUZ;
    int kUt;
    String kVa;
    String kVb;
    int kVc;
    boolean kVd;
    boolean kVe;
    boolean kVf;
    boolean kVg;
    boolean kVh;
    boolean kVi;
    boolean kVj;
    boolean kVk;
    boolean kVl;
    public int[] kVm;
    public boolean kVn;
    public boolean kVo;
    ArrayList<d> kVp;
    HashMap<String, Integer> kVq;
    c kVr;
    volatile boolean kVs;
    private Context ty;

    public enum a {
        RECOMMEND,
        DEFAULT,
        EMOJI
    }

    public f() {
        this.TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelStg";
        this.kUT = 0;
        this.kUU = 0;
        this.Xd = 0;
        this.kUZ = 0;
        this.kVb = "";
        this.kVc = 0;
        this.kVk = false;
        this.kVl = false;
        this.kVp = new ArrayList();
        this.kVq = new HashMap();
        this.kVs = false;
        this.ty = ab.getContext();
        this.kUK = this.ty.getResources().getDimensionPixelSize(R.f.aZK);
        this.kUJ = this.ty.getResources().getDimensionPixelSize(R.f.aZM);
        this.kUL = this.ty.getResources().getDimensionPixelSize(R.f.aZL);
        this.kUQ = com.tencent.mm.bg.a.fromDPToPix(this.ty, 48);
        this.kUR = com.tencent.mm.bg.a.fromDPToPix(this.ty, 43);
        this.kUN = com.tencent.mm.bg.a.fromDPToPix(this.ty, 86);
        this.kUO = com.tencent.mm.bg.a.fromDPToPix(this.ty, 80);
        this.kUP = com.tencent.mm.bg.a.fromDPToPix(this.ty, 65);
        this.kUM = com.tencent.mm.bg.a.T(this.ty, R.f.aWA);
        this.kUY = com.tencent.mm.bg.a.fromDPToPix(this.ty, 6);
        this.kVb = "TAG_DEFAULT_TAB";
        this.kVc = 0;
        this.kUt = com.tencent.mm.bg.a.T(this.ty, R.f.bbe);
        this.kUS = com.tencent.mm.bg.a.T(this.ty, R.f.aWA);
        aor();
        aoi();
    }

    public final void onPause() {
        this.kVi = false;
        aoq();
    }

    public static boolean aoe() {
        boolean booleanValue;
        Exception e;
        boolean booleanValue2;
        try {
            ap.yY();
            booleanValue2 = ((Boolean) com.tencent.mm.u.c.vr().get(208913, Boolean.valueOf(false))).booleanValue();
            try {
                ap.yY();
                booleanValue = ((Boolean) com.tencent.mm.u.c.vr().get(208899, Boolean.valueOf(false))).booleanValue();
            } catch (Exception e2) {
                e = e2;
                w.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", new Object[]{e.toString()});
                booleanValue = false;
                if (!booleanValue) {
                }
                return true;
            }
        } catch (Exception e3) {
            e = e3;
            booleanValue2 = false;
            w.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", new Object[]{e.toString()});
            booleanValue = false;
            if (booleanValue) {
            }
            return true;
        }
        if (booleanValue || r3) {
            return true;
        }
        return false;
    }

    public static boolean aof() {
        boolean aC;
        boolean aC2;
        Exception e;
        try {
            aC = com.tencent.mm.q.c.uk().aC(262147, 266244);
            try {
                aC2 = com.tencent.mm.q.c.uk().aC(262149, 266244);
            } catch (Exception e2) {
                e = e2;
                w.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", new Object[]{e.toString()});
                aC2 = false;
                if (!aC) {
                }
                return true;
            }
        } catch (Exception e3) {
            e = e3;
            aC = false;
            w.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", new Object[]{e.toString()});
            aC2 = false;
            if (aC) {
            }
            return true;
        }
        if (aC || r2) {
            return true;
        }
        return false;
    }

    public final int uH(String str) {
        if ("TAG_DEFAULT_TAB".equals(str)) {
            return this.kUQ;
        }
        return this.kUN;
    }

    public final void lB(int i) {
        this.kUW = i;
        w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "set viewpager height px: %d mViewPagerHeightPx:%d ", new Object[]{Integer.valueOf(i), Integer.valueOf(this.kUW)});
    }

    public final int aog() {
        if (this.kUX <= 1) {
            this.kUX = Xf()[0];
        }
        return this.kUX;
    }

    public final void uI(String str) {
        if (!bg.mA(str)) {
            this.kVb = str;
        }
    }

    public final void aoh() {
        if (!bg.mA(this.kVb) && !this.kVd) {
            w.i("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "save product Id:%s selected index:%d", new Object[]{this.kVb, Integer.valueOf(this.kVc)});
            ap.yY();
            com.tencent.mm.u.c.vr().set(-29414086, this.kVb);
        }
    }

    public final void aoi() {
        if (!this.kVd) {
            ap.yY();
            this.kVb = (String) com.tencent.mm.u.c.vr().get(-29414086, "TAG_DEFAULT_TAB");
            this.kVc = bg.a((Integer) this.kVq.get(this.kVb), 0);
            w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "restoreShowProductId product id: %s selected index:%d", new Object[]{this.kVb, Integer.valueOf(this.kVc)});
        } else if (!this.kVb.equals("TAG_DEFAULT_TAB")) {
            this.kVb = "TAG_DEFAULT_TAB";
            this.kVc = bg.a((Integer) this.kVq.get(this.kVb), 0);
        }
    }

    public static com.tencent.mm.storage.a.a aoj() {
        com.tencent.mm.storage.a.a aVar = new com.tencent.mm.storage.a.a();
        aVar.field_productID = "TAG_DEFAULT_TAB";
        return aVar;
    }

    public static com.tencent.mm.storage.a.a aok() {
        com.tencent.mm.storage.a.a aVar = new com.tencent.mm.storage.a.a();
        aVar.field_productID = String.valueOf(com.tencent.mm.storage.a.a.uKR);
        return aVar;
    }

    public static boolean a(com.tencent.mm.storage.a.a aVar) {
        return aVar != null && aVar.field_packStatus == 1;
    }

    public final boolean aol() {
        ap.yY();
        return ((Boolean) com.tencent.mm.u.c.vr().get(66832, Boolean.valueOf(false))).booleanValue() && !this.kVj;
    }

    public final d uJ(String str) {
        if (this.kVp == null || str == null) {
            w.w("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "getTab failed.");
            return null;
        }
        Iterator it = this.kVp.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar == null) {
                w.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "get null tab");
            } else if (dVar.kMS == null) {
                w.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "get null tab productId");
            } else if (dVar.kMS.equals(str)) {
                return dVar;
            }
        }
        return null;
    }

    public final d lC(int i) {
        if (this.kVp == null) {
            return null;
        }
        return (d) this.kVp.get(lD(i));
    }

    public final int lD(int i) {
        if (this.kVm == null || i >= this.kVm.length || i <= 0) {
            return 0;
        }
        return this.kVm[i];
    }

    public final int aom() {
        String str = this.kVb;
        if (this.kVp != null) {
            for (int i = 0; i < this.kVp.size(); i++) {
                d dVar = (d) this.kVp.get(i);
                if (dVar != null && dVar.kMS.equals(str)) {
                    return i;
                }
            }
        }
        return 0;
    }

    public final d aon() {
        return uJ(this.kVb);
    }

    public final void aoo() {
        this.kUZ = 0;
        if (this.kVp != null) {
            d dVar;
            Iterator it = this.kVp.iterator();
            while (it.hasNext()) {
                dVar = (d) it.next();
                this.kUZ = dVar.anV() + this.kUZ;
            }
            if (this.kVp != null) {
                try {
                    this.kVm = new int[this.kUZ];
                    int i = 0;
                    int i2 = 0;
                    loop1:
                    while (i < this.kVp.size()) {
                        dVar = (d) this.kVp.get(i);
                        int i3 = i2;
                        i2 = 0;
                        while (i2 < dVar.anV()) {
                            if (i3 >= this.kUZ) {
                                break loop1;
                            }
                            int i4 = i3 + 1;
                            this.kVm[i3] = i;
                            i2++;
                            i3 = i4;
                        }
                        i++;
                        i2 = i3;
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", e, "", new Object[0]);
                }
            }
            w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "refreshAllCount count: %d", new Object[]{Integer.valueOf(this.kUZ)});
        }
    }

    public final int uK(String str) {
        int i = 4;
        if (bg.mA(str)) {
            return 0;
        }
        if (str.equals("TAG_DEFAULT_TAB")) {
            if (aop()) {
                return 7;
            }
            return aog() / this.kUR;
        } else if (this.kUW <= 0) {
            return 0;
        } else {
            if (str.equals("TAG_STORE_TAB")) {
                return 3;
            }
            int aog = aog() / this.kUO;
            if (!aop()) {
                i = aog;
            } else if (aog <= 4) {
                i = aog;
            }
            w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "return calc Col Nums: %d", new Object[]{Integer.valueOf(i)});
            return i;
        }
    }

    public final int aL(String str, int i) {
        return (this.kUW - (uH(str) * i)) / (i + 1);
    }

    public final boolean aop() {
        if (this.Xd == 0) {
            int[] Xf = Xf();
            if (Xf[0] < Xf[1]) {
                this.Xd = 1;
            } else {
                this.Xd = 2;
            }
        }
        return this.Xd == 1;
    }

    private int[] Xf() {
        int[] iArr = new int[2];
        if (this.ty instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) this.ty).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) this.ty.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        return iArr;
    }

    public final void aoq() {
        if (this.kVr != null) {
            w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "remove succeed send listener");
            com.tencent.mm.sdk.b.a.urY.c(this.kVr);
            this.kVr = null;
        }
    }

    public final int getColumnWidth() {
        int i = 4;
        if (this.kUT == 0) {
            int aog = aog() / this.kUO;
            if (!aop()) {
                i = aog;
            } else if (aog <= 4) {
                i = aog;
            }
            this.kUT = aog() / i;
        }
        return this.kUT;
    }

    final void aor() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.kVq == null) {
            this.kVq = new HashMap();
        }
        this.kVq.clear();
        baj bNH = h.amc().kLd.bNH();
        if (!(bNH == null || bNH.ubu == null || bNH.ubu.isEmpty())) {
            Iterator it = bNH.ubu.iterator();
            while (it.hasNext()) {
                bak com_tencent_mm_protocal_c_bak = (bak) it.next();
                this.kVq.put(com_tencent_mm_protocal_c_bak.tgW, Integer.valueOf(com_tencent_mm_protocal_c_bak.tiI));
            }
        }
        w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "restore smiley tab map use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }
}
