package com.tencent.mm.plugin.brandservice.a;

import android.content.Context;
import android.os.Looper;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.as.d;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.protocal.c.mz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.List;

public final class a {
    public static ae hgZ = new ae(Looper.getMainLooper());

    public static class a {
        public String iconUrl;
        public ImageView ipv;
        public String username;
    }

    public static BizInfo a(BizInfo bizInfo, mz mzVar) {
        if (mzVar != null) {
            bizInfo.field_brandFlag = mzVar.hAR;
            bizInfo.field_brandIconURL = mzVar.hAU;
            bizInfo.field_brandInfo = mzVar.hAT;
            bizInfo.field_extInfo = mzVar.hAS;
        }
        return bizInfo;
    }

    public static Spanned b(Context context, String str, List<String> list) {
        if (bg.mA(str)) {
            return null;
        }
        if (context == null || list == null) {
            return new SpannableString(str);
        }
        return d.a(str, list);
    }

    public static boolean b(TextView textView, CharSequence charSequence) {
        if (textView == null) {
            return false;
        }
        if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            return false;
        }
        textView.setVisibility(0);
        textView.setText(charSequence);
        return true;
    }
}
