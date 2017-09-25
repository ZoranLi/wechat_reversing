package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import com.tencent.mm.pluginsdk.ui.applet.i;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.regex.Matcher;

public final class a {
    public static ArrayList<i> aV(Context context, String str) {
        ArrayList<i> arrayList = new ArrayList();
        Matcher matcher = com.tencent.mm.pluginsdk.ui.d.g.a.sTo.matcher(str);
        while (matcher.find()) {
            i a = a(context, matcher.group(), matcher.start(), matcher.end());
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    public static i a(Context context, String str, int i, int i2) {
        return a(context, str, i, i2, 0, 0);
    }

    public static i a(Context context, String str, int i, int i2, int i3, int i4) {
        if (context == null) {
            context = ab.getContext();
        }
        i q = com.tencent.mm.pluginsdk.ui.d.b.a.sTh.q(context, str);
        if (q != null) {
            q.start = i;
            q.end = i2;
            q.linkColor = i3;
            q.backgroundColor = i4;
        }
        return q;
    }
}
