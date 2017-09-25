package com.tencent.mm.f;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.sdk.platformtools.bg;

public final class a {
    public String desc;
    public String fDC;
    private c gMA;
    public int showType;
    public String url;

    public static a dn(String str) {
        c dp = c.dp(str);
        if (dp == null) {
            return null;
        }
        a aVar = new a();
        aVar.gMA = dp;
        aVar.url = dp.url;
        aVar.desc = dp.desc;
        aVar.showType = dp.showType;
        aVar.fDC = dp.fDC;
        return aVar;
    }

    public final boolean a(Context context, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if (this.showType == 3 || this.showType == 4) {
            String str = this.gMA.gMM;
            String str2 = this.gMA.gMN;
            if (bg.mA(str) && bg.mA(str2)) {
                str = context.getString(this.showType == 3 ? g.dJe : g.dHT);
                str2 = context.getString(this.showType == 3 ? g.dHQ : g.dGs);
            }
            if (bg.mA(str) || bg.mA(str2)) {
                String str3 = this.desc;
                String str4 = this.fDC;
                if (!bg.mA(str)) {
                    str2 = str;
                }
                if (!bg.mA(str)) {
                    onClickListener2 = onClickListener;
                }
                com.tencent.mm.ui.base.g.a(context, str3, str4, str2, onClickListener2);
            } else {
                com.tencent.mm.ui.base.g.a(context, this.desc, this.fDC, str, str2, onClickListener, onClickListener2);
            }
            return true;
        } else if (this.showType == 1) {
            com.tencent.mm.ui.base.g.b(context, this.desc, this.fDC, true);
            return true;
        } else if (this.showType != 5) {
            return false;
        } else {
            com.tencent.mm.ui.base.g.b(context, this.desc, this.fDC, true);
            return true;
        }
    }
}
