package com.tencent.mm.compatible.loader;

import android.content.Context;
import com.tencent.mm.a.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class d {
    private static Map<String, String> gSc;

    public static String u(Context context, String str) {
        long Nz = bg.Nz();
        if (gSc == null) {
            try {
                Map Pl = q.Pl(bg.convertStreamToString(context.getAssets().open("preload/libraries.ini")));
                w.v("MicroMsg.PluginClassLoader", "libraries.ini content\n%s", r0);
                if (Pl == null || Pl.size() <= 0) {
                    w.e("MicroMsg.PluginClassLoader", "parse libraries.ini failed");
                } else {
                    gSc = new HashMap(Pl.size());
                    for (Entry entry : Pl.entrySet()) {
                        w.d("MicroMsg.PluginClassLoader", "preload file, plugin=%s, md5=%s", entry.getKey(), entry.getValue());
                        gSc.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Throwable e) {
                w.e("MicroMsg.PluginClassLoader", "load preload libraries failed");
                w.printErrStackTrace("MicroMsg.PluginClassLoader", e, "", new Object[0]);
            }
        }
        String absolutePath = context.getDir("lib", 0).getAbsolutePath();
        if (gSc == null) {
            w.e("MicroMsg.PluginClassLoader", "extractVoipDex preload so files loaded failed");
            return null;
        }
        String str2 = absolutePath + "/" + str;
        absolutePath = (String) gSc.get(str);
        if (absolutePath == null) {
            w.w("MicroMsg.PluginClassLoader", "extractVoipDex not in preloadfiles");
            return null;
        }
        File file = new File(str2);
        if (file.exists()) {
            String f = g.f(file);
            if (f == null || !f.equalsIgnoreCase(absolutePath)) {
                w.e("MicroMsg.PluginClassLoader", "extractVoipDex target file exists, but md5 check failed, target=%s assets=%s", f, absolutePath);
            } else {
                w.d("MicroMsg.PluginClassLoader", "extractVoipDex: targetFilePath:[%s] time:%d", file, Long.valueOf(bg.aA(Nz)));
                return str2;
            }
        }
        b.deleteFile(str2);
        if (j.y(context, "preload/" + str, str2)) {
            w.i("MicroMsg.PluginClassLoader", "extractVoipDex time:%d so:%s md5:%s ", Long.valueOf(bg.aA(Nz)), str, absolutePath);
            return str2;
        }
        w.f("MicroMsg.PluginClassLoader", "extractVoipDex  copyAssets failed");
        return null;
    }
}
