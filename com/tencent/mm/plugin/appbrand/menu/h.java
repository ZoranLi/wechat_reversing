package com.tencent.mm.plugin.appbrand.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.l;

final class h extends a {
    h() {
        super(k.jaB - 1);
    }

    public final void a(Context context, m mVar, l lVar, String str) {
        if (b.bIu()) {
            lVar.e(this.jaM, context.getString(R.l.dGf));
        }
    }

    @SuppressLint({"DefaultLocale"})
    public final void a(Context context, m mVar, String str, j jVar) {
        CharSequence charSequence;
        AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(str);
        String str2 = "";
        if (mY.iFl.izV == 0) {
            StringBuilder append = new StringBuilder().append(str2);
            String str3 = "公共库版本: %d%s\n";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(mY.iFl.izW);
            objArr[1] = mY.iFl.izY ? " [ LOCAL ]" : "";
            str2 = append.append(String.format(str3, objArr)).toString();
        } else {
            str2 = str2 + String.format("测试版公共库更新时间: %s\n", new Object[]{bg.ev(mY.iFl.izX)});
        }
        if (mY.iFk.izV == 0) {
            charSequence = str2 + String.format("正式包版本: %d", new Object[]{Integer.valueOf(mY.iFk.izW)});
        } else {
            charSequence = str2 + String.format(com.tencent.mm.plugin.appbrand.appcache.a.hu(mY.iFk.izV) + " 更新时间: %s", new Object[]{bg.ev(mY.iFk.izX)});
        }
        Toast.makeText(context, charSequence, 1).show();
    }
}
