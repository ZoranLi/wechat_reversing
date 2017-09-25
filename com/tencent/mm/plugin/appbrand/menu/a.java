package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.plugin.appbrand.ui.g;
import com.tencent.mm.plugin.appbrand.widget.e.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.l;

public final class a extends com.tencent.mm.plugin.appbrand.menu.a.a {
    public a() {
        super(k.jaG - 1);
    }

    public final void a(Context context, m mVar, l lVar, String str) {
        CharSequence charSequence;
        AppBrandSysConfig appBrandSysConfig = mVar.ixr.iwo;
        int i = k.jaG - 1;
        String str2 = appBrandSysConfig.fGs;
        int i2 = appBrandSysConfig.iFk.izV;
        CharSequence string = context.getString(R.l.dDo, new Object[]{str2});
        str2 = com.tencent.mm.plugin.appbrand.appcache.a.hu(i2);
        if (bg.mA(str2)) {
            charSequence = string;
        } else {
            b bVar = new b(str2, com.tencent.mm.bg.a.fromDPToPix(context, 11), com.tencent.mm.bg.a.fromDPToPix(context, 11), com.tencent.mm.bg.a.fromDPToPix(context, 9), Color.parseColor("#42000000"), com.tencent.mm.bg.a.fromDPToPix(context, 2));
            int a = bVar.a(null);
            int[] Xf = g.Xf();
            int T = com.tencent.mm.bg.a.T(context, R.f.aYq);
            int b = com.tencent.mm.bg.a.b(context, R.e.aSY);
            TextPaint textPaint = new TextPaint(new Paint(b));
            textPaint.setTextSize((float) T);
            CharSequence ellipsize = TextUtils.ellipsize(string, textPaint, (float) ((Xf[0] - com.tencent.mm.bg.a.T(context, R.f.aYp)) - a), TruncateAt.END);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ellipsize + str2);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(T, false), 0, ellipsize.length(), 18);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(b), 0, ellipsize.length(), 18);
            spannableStringBuilder.setSpan(bVar, ellipsize.length(), spannableStringBuilder.length(), 18);
            Object obj = spannableStringBuilder;
        }
        lVar.e(i, charSequence);
    }

    public final void a(Context context, m mVar, String str, j jVar) {
        AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(str);
        if (mY != null) {
            String str2 = "";
            if (com.tencent.mm.plugin.appbrand.b.mZ(str) != null) {
                str2 = bg.mz(com.tencent.mm.plugin.appbrand.l.ns(str).ixn);
            }
            com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.a.TS();
            com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a aVar = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a();
            aVar.appId = mY.appId;
            aVar.fFr = 3;
            aVar.iGe = mVar.jde.jdU;
            aVar.izV = mY.iFk.izV;
            aVar.izW = mY.iFk.izW;
            AppBrandProfileUI.a(context, mY.fCJ, str2, aVar.RL());
            com.tencent.mm.plugin.appbrand.report.a.a(str, mVar.jde.jdU, 6, "", bg.Ny(), 1, 0);
        }
    }
}
