package com.tencent.mm.pluginsdk.l.a;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class a {
    public static final String[] sHi = new String[]{"LDPI", "HDPI", "MDPI"};
    public String desc;
    public String how;
    public String hox;
    public String id;
    public int oMr;
    public String platform;
    public String sHb;
    public boolean sHc;
    public boolean sHd;
    public int sHe;
    public Rect sHf;
    public Rect sHg;
    public Map<String, String> sHh;
    public String title;
    public String url;

    public enum a {
        ASSET,
        DOWNLOAD,
        ERROR
    }

    private a(String str, String str2, String str3, boolean z, boolean z2) {
        this.id = str;
        this.platform = str2;
        this.sHb = str3;
        this.sHc = z;
        this.sHd = z2;
    }

    private boolean Nd() {
        long Nz = bg.Nz();
        long j = Long.MAX_VALUE;
        long j2 = 0;
        try {
            if (this.hox != null) {
                j = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.hox).getTime();
            }
            if (this.how != null) {
                j2 = new SimpleDateFormat("yyyy-MM-dd-HH").parse(this.how).getTime();
            }
            w.d("MicroMsg.PushMessage", "CHECKTIME : [" + j2 + "," + j + "]");
            if (j <= Nz || j2 > Nz) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    public final String toString() {
        return "ad.id=" + this.id + ", platform=" + this.platform + ", device=" + this.sHb + (this.sHc ? ", closable" : "") + (this.sHd ? ", trans-closable" : "");
    }

    public static String Mz(String str) {
        a MA = MA(str);
        if (MA == a.ASSET) {
            return str;
        }
        if (MA != a.DOWNLOAD) {
            return null;
        }
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            int lastIndexOf = str.lastIndexOf("/");
            str2 = (lastIndexOf < 0 || lastIndexOf >= str.length() - 1) ? null : str.substring(lastIndexOf + 1);
        }
        if (str2 == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        return stringBuilder.append(c.xb()).append(str2).toString();
    }

    public static a MA(String str) {
        if (str.indexOf("tips/") == 0) {
            return a.ASSET;
        }
        if (str.indexOf("weixin://") == 0) {
            return a.DOWNLOAD;
        }
        return a.ERROR;
    }

    public static ArrayList<a> aU(Context context, String str) {
        if (str == null || str.length() < 0) {
            return null;
        }
        HashSet hashSet;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        String str2 = displayMetrics.heightPixels + "x" + displayMetrics.widthPixels;
        if (str2 == null) {
            hashSet = null;
        } else {
            HashSet hashSet2 = new HashSet();
            hashSet2.add(str2);
            str2 = b.dV(context);
            w.d("MicroMsg.PushMessage", "getDisplaySizeType :" + str2);
            if (str2 != null) {
                String[] split = str2.split("_");
                str2 = (split == null || split.length < 2) ? null : split[0];
                hashSet2.add(str2 + "_L");
                hashSet2.add(str2 + "_P");
            }
            hashSet = hashSet2;
        }
        if (hashSet == null || hashSet.size() <= 0) {
            return null;
        }
        Map q = bh.q(str, "tips");
        if (q == null) {
            return null;
        }
        ArrayList<a> arrayList = new ArrayList();
        int i = 0;
        while (true) {
            String str3 = ".tips.tip" + (i > 0 ? Integer.valueOf(i) : "");
            if (q.get(str3) == null) {
                break;
            }
            String str4 = (String) q.get(str3 + ".$id");
            w.d("MicroMsg.PushMessage", "parseMessages id:" + str4);
            String str5 = (String) q.get(str3 + ".$platform");
            if (str5.equals("android")) {
                a aVar = new a(str4, str5, (String) q.get(str3 + ".$device"), bg.e(Boolean.valueOf((String) q.get(str3 + ".$enableclose"))), bg.e(Boolean.valueOf((String) q.get(str3 + ".$transparentclose"))));
                int i2 = bg.getInt((String) q.get(str3 + ".title.$x"), 0);
                int i3 = bg.getInt((String) q.get(str3 + ".title.$y"), 0);
                int i4 = bg.getInt((String) q.get(str3 + ".title.$width"), 0);
                int i5 = bg.getInt((String) q.get(str3 + ".title.$font"), 0);
                int PQ = bg.PQ((String) q.get(str3 + ".title.$color"));
                aVar.title = (String) q.get(str3 + ".title");
                aVar.sHe = PQ;
                aVar.sHf = new Rect(i2, i3, i4 + i2, i5 + i3);
                i2 = bg.getInt((String) q.get(str3 + ".description.$x"), 0);
                i3 = bg.getInt((String) q.get(str3 + ".description.$y"), 0);
                i4 = bg.getInt((String) q.get(str3 + ".description.$width"), 0);
                i5 = bg.getInt((String) q.get(str3 + ".description.$font"), 0);
                PQ = bg.PQ((String) q.get(str3 + ".description.$color"));
                aVar.desc = (String) q.get(str3 + ".description");
                aVar.oMr = PQ;
                aVar.sHg = new Rect(i2, i3, i4 + i2, i5 + i3);
                aVar.url = (String) q.get(str3 + ".url");
                aVar.how = (String) q.get(str3 + ".time.start");
                aVar.hox = (String) q.get(str3 + ".time.end");
                w.d("MicroMsg.PushMessage", "parseMessages id:" + aVar.id + " start:" + aVar.how + " end:" + aVar.hox);
                Map hashMap = new HashMap();
                i3 = 0;
                while (true) {
                    str5 = str3 + ".images.image" + (i3 > 0 ? Integer.valueOf(i3) : "");
                    str4 = (String) q.get(str5);
                    w.d("MicroMsg.PushMessage", " img res:" + str4);
                    if (str4 == null) {
                        break;
                    }
                    str5 = (String) q.get(str5 + ".$type");
                    if (hashSet.contains(str5)) {
                        hashMap.put(str5, str4);
                    }
                    i3++;
                }
                if (hashMap.size() > 0) {
                    aVar.sHh = hashMap;
                }
                w.d("MicroMsg.PushMessage", "msgid :" + aVar.id);
                arrayList.add(aVar);
            }
            i++;
        }
        w.d("MicroMsg.PushMessage", "msgs size: " + arrayList.size());
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    public static void bDJ() {
        ap.yY();
        c.vr().set(8193, "");
        ap.yY();
        c.vr().set(8449, Long.valueOf(0));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.pluginsdk.l.a.a dB(android.content.Context r10) {
        /*
        r2 = 1;
        r3 = 0;
        r1 = 0;
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.vr();
        r4 = 8449; // 0x2101 float:1.184E-41 double:4.1744E-320;
        r0 = r0.get(r4, r1);
        r0 = com.tencent.mm.sdk.platformtools.bg.n(r0, r3);
        r4 = (long) r0;
        r6 = com.tencent.mm.sdk.platformtools.bg.Ny();
        r6 = r6 - r4;
        r8 = 0;
        r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x002c;
    L_0x0020:
        r4 = 86400; // 0x15180 float:1.21072E-40 double:4.26873E-319;
        r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r0 < 0) goto L_0x002c;
    L_0x0027:
        bDJ();
    L_0x002a:
        r0 = r1;
    L_0x002b:
        return r0;
    L_0x002c:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.vr();
        r4 = 8193; // 0x2001 float:1.1481E-41 double:4.048E-320;
        r0 = r0.get(r4, r1);
        r0 = (java.lang.String) r0;
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r4 != 0) goto L_0x002a;
    L_0x0041:
        r4 = "id=\"setavatar\"";
        r4 = r0.contains(r4);
        if (r4 == 0) goto L_0x004e;
    L_0x004a:
        bDJ();
        goto L_0x002a;
    L_0x004e:
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r4 != 0) goto L_0x0081;
    L_0x0054:
        r0 = aU(r10, r0);
        if (r0 == 0) goto L_0x0060;
    L_0x005a:
        r4 = r0.size();
        if (r4 == r2) goto L_0x0067;
    L_0x0060:
        r0 = r1;
    L_0x0061:
        if (r0 != 0) goto L_0x002b;
    L_0x0063:
        bDJ();
        goto L_0x002a;
    L_0x0067:
        r0 = r0.get(r3);
        r0 = (com.tencent.mm.pluginsdk.l.a.a) r0;
        r4 = r0.sHh;
        if (r4 == 0) goto L_0x0083;
    L_0x0071:
        r4 = r0.sHh;
        r4 = r4.size();
        if (r4 <= 0) goto L_0x0083;
    L_0x0079:
        if (r2 == 0) goto L_0x0081;
    L_0x007b:
        r2 = r0.Nd();
        if (r2 != 0) goto L_0x0061;
    L_0x0081:
        r0 = r1;
        goto L_0x0061;
    L_0x0083:
        r2 = r3;
        goto L_0x0079;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.l.a.a.dB(android.content.Context):com.tencent.mm.pluginsdk.l.a.a");
    }
}
