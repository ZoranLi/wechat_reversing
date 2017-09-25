package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.mm.pluginsdk.l.i;
import com.tencent.mm.pluginsdk.ui.d.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class d implements i {
    public final String p(Context context, String str) {
        Object aV = a.aV(context, str);
        if (aV.size() != 0) {
            Collections.sort(aV, new Comparator<com.tencent.mm.pluginsdk.ui.applet.i>(this) {
                final /* synthetic */ d fxV;

                {
                    this.fxV = r1;
                }

                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    com.tencent.mm.pluginsdk.ui.applet.i iVar = (com.tencent.mm.pluginsdk.ui.applet.i) obj2;
                    int i = ((com.tencent.mm.pluginsdk.ui.applet.i) obj).start;
                    int i2 = iVar.start;
                    if (i < i2) {
                        return -1;
                    }
                    return i > i2 ? 1 : 0;
                }
            });
            Iterator it = aV.iterator();
            String str2 = str;
            while (it.hasNext()) {
                String format;
                com.tencent.mm.pluginsdk.ui.applet.i iVar = (com.tencent.mm.pluginsdk.ui.applet.i) it.next();
                String str3 = null;
                int i = iVar.start;
                int i2 = iVar.end;
                switch (iVar.type) {
                    case 1:
                        str3 = "<a href=\"%s\">%s</a>";
                        break;
                    case 24:
                        str3 = "<a href=\"%s@mailto@\">%s</a>";
                        break;
                    case 25:
                        str3 = "<a href=\"%s@tel@\">%s</a>";
                        break;
                }
                if (str3 != null) {
                    String str4 = iVar.url;
                    if (iVar.type != 1 || str4.startsWith("http://")) {
                        format = String.format(str3, new Object[]{str4.trim(), str4.trim()});
                    } else {
                        format = String.format(str3, new Object[]{"http://" + str4.trim(), str4.trim()});
                    }
                    format = a(str2, i, i2, format);
                    if (format.length() == 0) {
                        w.d("MicroMsg.QrCodeURLHelper", "formatQRString, result:%s", str);
                    }
                } else {
                    format = str2;
                }
                str2 = format;
            }
            str = str2;
            w.d("MicroMsg.QrCodeURLHelper", "formatQRString, result:%s", str);
        }
        return str;
    }

    private static String a(String str, int i, int i2, String str2) {
        if (bg.mA(str) || bg.mA(str2) || i >= i2) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(str.subSequence(0, i + 0));
            stringBuilder.append(str2);
            stringBuilder.append(str.subSequence(i2 + 0, str.length()));
            str2.length();
            return stringBuilder.toString();
        } catch (Exception e) {
            w.e("MicroMsg.QrCodeURLHelper", e.getMessage());
            return "";
        }
    }

    public final boolean a(Context context, String str, OnDismissListener onDismissListener) {
        w.d("MicroMsg.QrCodeURLHelper", "tryHandleEvents, url:%s", str);
        if (bg.mA(str)) {
            return false;
        }
        if (str.endsWith("@mailto@")) {
            j.b(context, str.substring(0, str.length() - 8), onDismissListener);
        } else if (!str.endsWith("@tel@")) {
            return false;
        } else {
            String substring = str.substring(0, str.length() - 5);
            Bundle bundle = new Bundle();
            bundle.putInt("fromScene", 3);
            j.a(context, substring, onDismissListener, bundle);
        }
        return true;
    }

    public final boolean bu(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (str.endsWith("@mailto@") || str.endsWith("@tel@")) {
            return true;
        }
        return false;
    }
}
