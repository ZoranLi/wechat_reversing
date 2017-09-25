package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mm.bg.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.protocal.c.bba;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;

public final class b {
    public static CharSequence a(Context context, bba com_tencent_mm_protocal_c_bba, au auVar, int i, String str) {
        String str2;
        String str3 = "";
        CharSequence a = a(com_tencent_mm_protocal_c_bba);
        CharSequence charSequence = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = i == 21 ? 3 : 2;
        String str4 = com_tencent_mm_protocal_c_bba.opI;
        x xVar = null;
        if (!bg.mA(str)) {
            h.vJ();
            xVar = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Ra(str);
        }
        CharSequence charSequence2;
        if (com_tencent_mm_protocal_c_bba.ubP == 1) {
            if (xVar != null) {
                if (!(xVar == null || TextUtils.isEmpty(xVar.tL()))) {
                    str = xVar.tL();
                }
                String str5 = a + context.getString(j.pKt);
                int length = str5.length();
                str2 = str5 + str;
                i3 = length;
            } else {
                w.w("SnsCommentUtil", "feedContact null by feedOwnUserName %s", new Object[]{str});
                str = null;
                charSequence2 = a;
            }
        } else if (bg.mA(com_tencent_mm_protocal_c_bba.uce)) {
            str = null;
            charSequence2 = a;
        } else {
            xVar = ae.bez().Rb(com_tencent_mm_protocal_c_bba.uce);
            str2 = xVar == null ? com_tencent_mm_protocal_c_bba.uce : xVar.tL();
            String str6 = a + context.getString(j.pMj);
            i2 = str6.length();
            str = null;
            String str7 = str2;
            str2 = str6 + str2;
            Object obj = str7;
        }
        SpannableString a2 = com.tencent.mm.pluginsdk.ui.d.h.a(context, (str3 + str2 + ": ") + str4, a.fromDPToPix(context, (int) (14.0f * a.dI(context))), 2);
        int i5 = i == 21 ? 3 : 2;
        h.vJ();
        ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Ra(com_tencent_mm_protocal_c_bba.tgG);
        Object iVar = new i(a2);
        iVar.a(new m(com_tencent_mm_protocal_c_bba.tgG, auVar.qzO, i5), a, 0, 33);
        if (str != null) {
            iVar.a(new m(com_tencent_mm_protocal_c_bba.uce, auVar.qzO, i4), (CharSequence) str, i3, 33);
        } else if (charSequence != null) {
            iVar.a(new m(com_tencent_mm_protocal_c_bba.uce, auVar.qzO, i4), charSequence, i2, 33);
        }
        return iVar;
    }

    public static String a(bba com_tencent_mm_protocal_c_bba) {
        com.tencent.mm.j.a Rb = ae.bez().Rb(com_tencent_mm_protocal_c_bba.tgG);
        if (Rb != null) {
            return Rb.tL();
        }
        return com_tencent_mm_protocal_c_bba.tNz != null ? com_tencent_mm_protocal_c_bba.tNz : com_tencent_mm_protocal_c_bba.tgG;
    }
}
