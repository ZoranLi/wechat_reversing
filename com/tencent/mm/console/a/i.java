package com.tencent.mm.console.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class i implements a {
    static {
        b.a(new i(), "//warpgate");
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr) {
        int i = 8888;
        if (w.getLogLevel() > 1) {
            return false;
        }
        if (strArr.length < 2) {
            return true;
        }
        String str = strArr[1];
        boolean z = true;
        switch (str.hashCode()) {
            case 3551:
                if (str.equals("on")) {
                    z = false;
                    break;
                }
                break;
            case 109935:
                if (str.equals("off")) {
                    z = true;
                    break;
                }
                break;
            case 3540994:
                if (str.equals("stop")) {
                    z = true;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                r.ijN = true;
                r.ijM = true;
                break;
            case true:
                r.ijN = false;
                r.ijM = false;
                break;
            case true:
                if (strArr.length >= 3) {
                    i = bg.getInt(strArr[2], 8888);
                }
                try {
                    Class.forName("com.tencent.mm.plugin.sl_warpgate.server.WarpGateHttpServer").getMethod("startServer", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(i)});
                    Toast.makeText(ab.getContext(), "start server on " + i, 1).show();
                    break;
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.WarpgateCommand", e, "", new Object[0]);
                    break;
                }
            case true:
                try {
                    Class.forName("com.tencent.mm.plugin.sl_warpgate.server.WarpGateHttpServer").getMethod("stopServer", new Class[0]).invoke(null, new Object[0]);
                    Toast.makeText(ab.getContext(), "stop server", 1).show();
                    break;
                } catch (Throwable e2) {
                    w.printErrStackTrace("MicroMsg.WarpgateCommand", e2, "", new Object[0]);
                    break;
                }
        }
        return true;
    }
}
