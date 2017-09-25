package com.tencent.mm.as;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public final class n {
    public static String Ij() {
        File file = new File(e.hgr.replace("/data/user/0", "/data/data"), "wxa_fts/res");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static Properties l(File file) {
        Throwable e;
        Properties properties = new Properties();
        if (file.isFile()) {
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    com.tencent.mm.a.e.b(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        w.printErrStackTrace("MicroMsg.WxaFTSExportLogic", e, "", new Object[0]);
                        com.tencent.mm.a.e.b(fileInputStream);
                        return properties;
                    } catch (Throwable th) {
                        e = th;
                        com.tencent.mm.a.e.b(fileInputStream);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
                w.printErrStackTrace("MicroMsg.WxaFTSExportLogic", e, "", new Object[0]);
                com.tencent.mm.a.e.b(fileInputStream);
                return properties;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                com.tencent.mm.a.e.b(fileInputStream);
                throw e;
            }
        }
        return properties;
    }

    public static int Iy() {
        return Integer.valueOf(l(new File(Ij(), "config.conf")).getProperty("version", "0")).intValue();
    }

    public static String m(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        stringBuffer.append(Ij());
        stringBuffer.append("/app.html?");
        for (Entry entry : map.entrySet()) {
            stringBuffer.append("&");
            stringBuffer.append((String) entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append((String) entry.getValue());
        }
        if (!map.containsKey("sessionId")) {
            stringBuffer.append("&");
            stringBuffer.append("sessionId");
            stringBuffer.append("=");
            stringBuffer.append(d.gm(bg.PY((String) map.get("scene"))));
        }
        return stringBuffer.toString();
    }

    public static Map<String, String> a(int i, boolean z, int i2) {
        boolean z2;
        Map<String, String> hashMap = new HashMap();
        hashMap.put("scene", String.valueOf(i));
        hashMap.put(Columns.TYPE, String.valueOf(i2));
        hashMap.put("lang", v.ea(ab.getContext()));
        hashMap.put("platform", "android");
        hashMap.put("version", String.valueOf(Iy()));
        hashMap.put("isHomePage", z ? "1" : "0");
        c dX = com.tencent.mm.u.c.c.Az().dX("100192");
        if (dX.isValid() && "1".equals(dX.bKK().get("openSearchSuggestion"))) {
            z2 = true;
        } else {
            z2 = false;
        }
        w.i("MicroMsg.WxaFTSExportLogic", "genFTSParams scene=%d isHomePage=%b type=%d %b %b", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), Boolean.valueOf(false));
        if (z2) {
            hashMap.put("isSug", "1");
        }
        return hashMap;
    }

    public static final boolean Iz() {
        c dX = com.tencent.mm.u.c.c.Az().dX("100223");
        if (!dX.isValid()) {
            return false;
        }
        if (bg.getInt((String) dX.bKK().get("switchWeAppTemplate"), 0) == 1) {
            return true;
        }
        return false;
    }
}
