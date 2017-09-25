package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.mm.protocal.c.avi;
import com.tencent.mm.protocal.c.avk;
import com.tencent.mm.protocal.c.avl;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;

final class e {
    private static boolean n(String str, Map<String, String> map) {
        if (map.get(str) == null && map.get(str + ".resType") == null && map.get(str + ".subType") == null) {
            return true;
        }
        return false;
    }

    static void f(String str, String str2, Map<String, String> map) {
        if (!n(String.format("%s.%s", new Object[]{str, str2}), map)) {
            int g = g(str, str2, map) | 0;
            int i = 0;
            while (true) {
                i++;
                if (n(String.format("%s.%s%d", new Object[]{str, str2, Integer.valueOf(i)}), map)) {
                    break;
                }
                g |= g(str, str2, map);
            }
            i = b.Mr(str2);
            if (b.xg(i)) {
                j.u(0, 32);
                if (g == 0) {
                    j.u(0, 33);
                }
            } else if (b.xh(i)) {
                j.u(0, 35);
                if (g == 0) {
                    j.u(0, 36);
                }
            } else if (b.xi(i)) {
                j.u(0, 38);
                if (g == 0) {
                    j.u(0, 39);
                }
            }
        }
    }

    private static boolean g(String str, String str2, Map<String, String> map) {
        String format = String.format("%s.%s.%s", new Object[]{str, str2, "Resource"});
        int Mr = b.Mr(str2);
        if (n(format, map)) {
            return true;
        }
        boolean a = a(Mr, format, map) | 0;
        int i = 0;
        while (true) {
            i++;
            String format2 = String.format("%s.%s.%s%d", new Object[]{str, str2, "Resource", Integer.valueOf(i)});
            if (n(format2, map)) {
                return a;
            }
            a |= a(Mr, format2, map);
        }
    }

    private static boolean a(int i, String str, Map<String, String> map) {
        if (map.get(str + ".resType") == null && map.get(str + ".subType") == null) {
            return true;
        }
        int i2;
        int i3;
        avi com_tencent_mm_protocal_c_avi;
        if (b.xi(i)) {
            w.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDelete()");
            i2 = bg.getInt((String) map.get(str + ".resType"), -1);
            i3 = bg.getInt((String) map.get(str + ".subType"), -1);
            if (-1 == i2 || -1 == i3) {
                return false;
            }
            com_tencent_mm_protocal_c_avi = new avi();
            com_tencent_mm_protocal_c_avi.tVQ = i3;
            com_tencent_mm_protocal_c_avi.tYO = new avl();
            com_tencent_mm_protocal_c_avi.tYO.tYY = bg.getInt((String) map.get(str + ".resVer"), 0);
            com_tencent_mm_protocal_c_avi.tYR = (String) map.get(str + ".sampleID");
            com_tencent_mm_protocal_c_avi.tYQ = bg.getInt((String) map.get(str + ".reportID"), 0);
            com_tencent_mm_protocal_c_avi.tEV = b.DoDelete.fRW;
            c.sFE.a(i2, com_tencent_mm_protocal_c_avi, true);
            j.u((long) com_tencent_mm_protocal_c_avi.tYQ, 40);
            return true;
        } else if (b.xg(i)) {
            w.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceCache()");
            String str2 = (String) map.get(str + ".CDNUrl");
            int i4 = bg.getInt((String) map.get(str + ".subType"), -1);
            int i5 = bg.getInt((String) map.get(str + ".resType"), -1);
            String str3 = (String) map.get(str + ".md5");
            int i6 = bg.getInt((String) map.get(str + ".priority"), 0);
            if (bg.mA(str2) || bg.mA(str3) || -1 == i4 || -1 == i5 || i6 < 0) {
                return false;
            }
            int bDu;
            avi com_tencent_mm_protocal_c_avi2 = new avi();
            com_tencent_mm_protocal_c_avi2.tYO = new avl();
            if (bg.getInt((String) map.get(str + ".fileEncrypt"), 0) > 0) {
                bDu = a.bDu();
            } else {
                bDu = 0;
            }
            if (bg.getInt((String) map.get(str + ".fileCompress"), 0) > 0) {
                bDu = a.xe(bDu);
            }
            com_tencent_mm_protocal_c_avi2.tVQ = i4;
            com_tencent_mm_protocal_c_avi2.tYT = bg.getInt((String) map.get(str + ".networkType"), 2);
            com_tencent_mm_protocal_c_avi2.tmG = bg.getInt((String) map.get(str + ".expireTime"), 1);
            com_tencent_mm_protocal_c_avi2.tYO.msN = str2;
            com_tencent_mm_protocal_c_avi2.tYO.tYY = bg.getInt((String) map.get(str + ".resVer"), 0);
            com_tencent_mm_protocal_c_avi2.tYO.tuy = str3;
            com_tencent_mm_protocal_c_avi2.tYO.tZb = (String) map.get(str + ".originalmd5");
            com_tencent_mm_protocal_c_avi2.tYO.tYZ = bDu;
            com_tencent_mm_protocal_c_avi2.tYO.tZa = null;
            com_tencent_mm_protocal_c_avi2.tYO.tug = null;
            com_tencent_mm_protocal_c_avi2.tKt = i6;
            com_tencent_mm_protocal_c_avi2.tEV = b.DoCache.fRW;
            com_tencent_mm_protocal_c_avi2.tYQ = bg.getInt((String) map.get(str + ".reportID"), 0);
            com_tencent_mm_protocal_c_avi2.tYR = (String) map.get(str + ".sampleID");
            com_tencent_mm_protocal_c_avi2.tYS = bg.getInt((String) map.get(str + ".retryTime"), 3);
            com_tencent_mm_protocal_c_avi2.tYU = bg.getInt((String) map.get(str + ".retryInterval"), 0);
            com_tencent_mm_protocal_c_avi2.sFI = 0;
            c.sFE.b(i5, com_tencent_mm_protocal_c_avi2, true);
            j.u((long) com_tencent_mm_protocal_c_avi2.tYQ, 34);
            return true;
        } else if (!b.xh(i)) {
            return false;
        } else {
            w.d("MicroMsg.CheckResUpdateNewXmlParser", "handleResourceDecrypt()");
            i2 = bg.getInt((String) map.get(str + ".resType"), -1);
            i3 = bg.getInt((String) map.get(str + ".subType"), -1);
            if (-1 == i2 || -1 == i3) {
                return false;
            }
            com_tencent_mm_protocal_c_avi = new avi();
            com_tencent_mm_protocal_c_avi.tYP = new avk();
            com_tencent_mm_protocal_c_avi.tVQ = i3;
            com_tencent_mm_protocal_c_avi.tYP.tYX = (String) map.get(str + ".resKey");
            com_tencent_mm_protocal_c_avi.tYP.tYW = bg.getInt((String) map.get(str + ".resKeyVersion"), 0);
            com_tencent_mm_protocal_c_avi.tYR = (String) map.get(str + ".sampleID");
            com_tencent_mm_protocal_c_avi.tYQ = bg.getInt((String) map.get(str + ".reportID"), 0);
            com_tencent_mm_protocal_c_avi.tEV = b.DoDecrypt.fRW;
            com_tencent_mm_protocal_c_avi.tYO = new avl();
            com_tencent_mm_protocal_c_avi.tYO.tZb = (String) map.get(str + ".originalmd5");
            c.sFE.c(i2, com_tencent_mm_protocal_c_avi, true);
            j.u((long) com_tencent_mm_protocal_c_avi.tYQ, 37);
            return true;
        }
    }
}
