package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public final class r {
    private static List<a> sXK = new ArrayList();

    public interface a {
        void byK();

        void byL();

        void dd(Context context);

        String getName();
    }

    public static void a(a aVar) {
        if (aVar != null) {
            w.d("MicroMsg.WebViewPluginCenter", "add, plugin name = " + aVar.getName());
            if (!sXK.contains(aVar)) {
                sXK.add(aVar);
            }
        }
    }

    public static List<a> bGL() {
        return sXK;
    }

    public static void clear() {
        w.d("MicroMsg.WebViewPluginCenter", "clear");
        sXK.clear();
    }
}
