package com.tencent.mm.plugin.emoji.ui.smiley;

import com.tencent.mm.bi.e;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class d {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelInfo";
    String kMS;
    f kTE;
    e kTF;
    int kTG;
    int kTH;
    int kTI;
    int kTJ;
    int kTK;
    boolean kTL = false;
    int kTM;

    public d(a aVar, int i, int i2, f fVar, e eVar, boolean z) {
        if (aVar == null || bg.mA(aVar.field_productID)) {
            w.i("MicroMsg.emoji.SmileyPanel.SmileyPanelInfo", "catch invalid Smiley Tab want add??!!");
            return;
        }
        this.kTF = eVar;
        this.kTE = fVar;
        this.kMS = aVar.field_productID;
        this.kTH = i;
        this.kTM = i2;
        if (z || aVar.field_productID.equalsIgnoreCase(String.valueOf(a.uKQ))) {
            int YZ;
            f fVar2 = this.kTE;
            if (aVar.field_productID.equals("TAG_DEFAULT_TAB")) {
                YZ = e.bKD().YZ();
            } else if (aVar.field_productID.equals(String.valueOf(a.uKR))) {
                ap.yY();
                YZ = c.isSDCardAvailable() ? h.amc().kLa.jZ(true) + 1 : 0;
            } else if (aVar.field_productID.equalsIgnoreCase(String.valueOf(a.uKQ))) {
                ap.yY();
                YZ = c.isSDCardAvailable() ? 16 : 0;
            } else if (f.a(aVar)) {
                YZ = 1;
                if (aVar != null) {
                    if (aVar.field_count > 0) {
                        YZ = aVar.field_count;
                    } else {
                        YZ = h.amc().kLa.Se(aVar.field_productID);
                        aVar.field_count = YZ;
                        long currentTimeMillis = System.currentTimeMillis();
                        h.amc().kLb.c(aVar, new String[]{"productID"});
                        w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    }
                }
                if (YZ == 0) {
                    YZ = 1;
                }
                ap.yY();
                if (!c.isSDCardAvailable()) {
                    YZ = 0;
                }
            } else {
                YZ = 1;
            }
            if (fVar2.kVe) {
                YZ--;
            }
            this.kTG = YZ;
            f fVar3 = this.kTE;
            String str = this.kMS;
            if (fVar3.kUW <= 0 || bg.mA(str)) {
                YZ = 1;
            } else if (str.equals("TAG_STORE_TAB")) {
                YZ = 1;
            } else {
                int uH = fVar3.kUW / fVar3.uH(str);
                YZ = bg.mA(str) ? 0 : str.equals("TAG_DEFAULT_TAB") ? 3 : 2;
                if (uH <= YZ) {
                    YZ = uH;
                }
                if (YZ <= 0) {
                    YZ = 1;
                }
            }
            this.kTI = YZ;
            this.kTJ = this.kTE.uK(this.kMS);
            this.kTK = this.kTE.aL(this.kMS, this.kTI);
        } else {
            this.kTG = 1;
            this.kTI = 1;
            this.kTJ = 1;
            this.kTK = this.kTE.aL(this.kMS, this.kTI);
        }
        this.kTL = z;
        w.i("MicroMsg.emoji.SmileyPanel.SmileyPanelInfo", "smiley panel tab: productId: %s, startIndex: %d mAllEmojiNums: %d mRow:%d mCol:%d mSpacing:%d ", new Object[]{this.kMS, Integer.valueOf(i), Integer.valueOf(this.kTG), Integer.valueOf(this.kTI), Integer.valueOf(this.kTJ), Integer.valueOf(this.kTK)});
    }

    public final int getType() {
        String str = this.kMS;
        if (str.equals("TAG_DEFAULT_TAB")) {
            return 20;
        }
        return str.equals(String.valueOf(a.uKR)) ? 25 : 23;
    }

    public final int anU() {
        return this.kTI * this.kTJ;
    }

    public final int anV() {
        if (anU() <= 0) {
            return 0;
        }
        if ("TAG_DEFAULT_TAB".equals(this.kMS)) {
            return (int) Math.ceil(((double) this.kTG) / ((double) (anU() - 1)));
        }
        return (int) Math.ceil(((double) this.kTG) / ((double) anU()));
    }

    public final int getColumnWidth() {
        return this.kTE.aog() / (this.kTE.aog() / this.kTE.kUO);
    }

    public final j anR() {
        e eVar = this.kTF;
        return eVar.kUc == null ? null : eVar.kUc.anR();
    }
}
