package com.tencent.mm.ai;

import android.content.Context;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public final class b {
    private static Map<String, a> hJB = null;
    private static String hJC = null;

    public static class a {
        public String hJD;
        public String hJE;
        public String hJF;
    }

    public static boolean Hl() {
        return !v.ea(ab.getContext()).equals("zh_CN");
    }

    public static boolean Hm() {
        return bg.Hp();
    }

    public static boolean Hn() {
        if (m.xK() == 0 && bg.Hp()) {
            return false;
        }
        return true;
    }

    public static boolean Ho() {
        if (!v.bIN().equals("zh_CN")) {
            return true;
        }
        if (TimeZone.getDefault().getRawOffset() == TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
            return false;
        }
        return true;
    }

    public static boolean Hp() {
        return bg.Hp();
    }

    public static a g(Context context, String str, String str2) {
        String str3 = null;
        try {
            str3 = context.getResources().getConfiguration().locale.getLanguage();
            if (str3 == null || !str3.equals(hJC)) {
                hJB = null;
            }
        } catch (Exception e) {
        }
        if (hJB == null) {
            hJB = new HashMap();
            hJC = str3;
            InputStream inputStream = null;
            String str4 = "";
            try {
                inputStream = context.getAssets().open("country_code.txt");
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                str3 = new String(bArr);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e2) {
                        w.e("MicroMsg.InternationaPluginlLogic", "exception:%s", bg.g(e2));
                    }
                }
            } catch (Throwable e3) {
                w.e("MicroMsg.InternationaPluginlLogic", "exception:%s", bg.g(e3));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        str3 = str4;
                    } catch (Throwable e32) {
                        w.e("MicroMsg.InternationaPluginlLogic", "exception:%s", bg.g(e32));
                        str3 = str4;
                    }
                } else {
                    str3 = str4;
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e22) {
                        w.e("MicroMsg.InternationaPluginlLogic", "exception:%s", bg.g(e22));
                    }
                }
            }
            String[] split = str3.trim().split("\n");
            String[] split2 = bg.mz(str2).trim().split(",");
            for (String str42 : split) {
                String[] split3 = str42.trim().split(" ");
                if (split3.length < 2) {
                    w.e("MicroMsg.InternationaPluginlLogic", "this country item has problem %s", split[r0]);
                } else {
                    a aVar = new a();
                    aVar.hJD = split3[0];
                    aVar.hJE = split3[1];
                    for (String trim : split2) {
                        String[] split4 = trim.trim().split(":");
                        if (split4.length < 2) {
                            w.e("MicroMsg.InternationaPluginlLogic", "this country item has problem %s", trim);
                        } else {
                            if (split3[1].equals(split4[0])) {
                                aVar.hJF = split4[1];
                                break;
                            }
                        }
                    }
                    hJB.put(aVar.hJD, aVar);
                }
            }
        }
        return (a) hJB.get(str.toUpperCase());
    }

    public static boolean jN(String str) {
        if (str == null || str.length() <= 1 || !str.startsWith("+") || str.startsWith("+86")) {
            return false;
        }
        return true;
    }

    public static String jO(String str) {
        if (str.startsWith("+886") || str.startsWith("+86")) {
            return "zh-TW";
        }
        if (str.startsWith("+852") || str.startsWith("+853")) {
            return "zh-HK";
        }
        if (str.startsWith("+81")) {
            return "ja";
        }
        if (str.startsWith("+82")) {
            return "ko";
        }
        if (str.startsWith("+66")) {
            return "th";
        }
        if (str.startsWith("+84")) {
            return "vi";
        }
        if (str.startsWith("+62")) {
            return SlookAirButtonFrequentContactAdapter.ID;
        }
        if (str.startsWith("+55")) {
            return "pt";
        }
        if (str.startsWith("+34")) {
            return "es-419";
        }
        return "en";
    }
}
