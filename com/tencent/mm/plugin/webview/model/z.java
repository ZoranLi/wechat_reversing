package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class z {
    private static final Set<String> rWS;

    static {
        Set hashSet = new HashSet();
        rWS = hashSet;
        hashSet.add("file:///android_asset/");
        String str = e.hgr;
        if (!bg.mA(str)) {
            str = e.hgr.replace("/data/user/0", "/data/data");
        }
        rWS.add("file://" + new File(str, "fts/res").getAbsolutePath());
        rWS.add("file://" + new File(e.hgu, "fts/res").getAbsolutePath());
        rWS.add("file://" + new File(str, "wenote/res").getAbsolutePath());
        rWS.add("file://" + new File(e.hgu, "wenote/res").getAbsolutePath());
        w.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[]{r1.getAbsolutePath(), r2.getAbsolutePath()});
        rWS.add("file://" + new File(str, "emoji/res").getAbsolutePath());
        rWS.add("file://" + new File(e.hgu, "emoji/res").getAbsolutePath());
        w.i("MicroMsg.URLFilter", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[]{r1.getAbsolutePath(), r0.getAbsolutePath()});
        Iterator it = rWS.iterator();
        while (it.hasNext()) {
            w.i("MicroMsg.URLFilter", "WebViewUI white list path : %s", new Object[]{(String) it.next()});
        }
    }

    public static boolean IN(String str) {
        if (r.iiT) {
            w.w("MicroMsg.URLFilter", "skipLoadUrlCheck");
            return true;
        } else if (bg.mA(str)) {
            return true;
        } else {
            String toLowerCase = str.toLowerCase();
            if (toLowerCase.startsWith("about:blank")) {
                return false;
            }
            if (toLowerCase.startsWith("file://")) {
                for (String startsWith : rWS) {
                    if (toLowerCase.startsWith(startsWith)) {
                        return true;
                    }
                }
                return false;
            }
            Uri parse = Uri.parse(toLowerCase);
            if (bg.mA(parse.getHost())) {
                return true;
            }
            return !parse.getHost().contains(s.bGM());
        }
    }
}
