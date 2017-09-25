package com.tencent.mm.console.a;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

public final class h implements a {
    static {
        b.a(new h(), "//version");
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr) {
        int i;
        CharSequence stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("[ver  ] %s %08X\n", new Object[]{f.b(context, d.sYN, true), Integer.valueOf(d.sYN)}));
        stringBuilder.append(e.aKs());
        stringBuilder.append(String.format("[cid  ] %d\n", new Object[]{Integer.valueOf(f.fuV)}));
        stringBuilder.append(String.format("[s.ver] %d\n", new Object[]{Integer.valueOf(com.tencent.mm.as.d.hPo)}));
        stringBuilder.append(String.format("[r.ver] %s\n", new Object[]{"0x26050D40"}));
        try {
            Map q = bh.q(bg.convertStreamToString(context.getAssets().open("merged_features.xml")), "merged");
            if (q != null) {
                for (i = 0; ((String) q.get("merged.feature#" + i)) != null; i++) {
                    stringBuilder.append(String.format("[feature#%02d] %s\n", new Object[]{Integer.valueOf(i), (String) q.get("merged.feature#" + i)}));
                }
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Version", e, "", new Object[0]);
        }
        View textView = new TextView(context);
        textView.setText(stringBuilder);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(WebView.NIGHT_MODE_COLOR);
        textView.setTypeface(Typeface.MONOSPACE);
        i = context.getResources().getDimensionPixelSize(R.f.aXt);
        textView.setPadding(i, i, i, i);
        g.a(context, null, textView, null);
        return true;
    }
}
