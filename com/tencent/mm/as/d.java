package com.tencent.mm.as;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.o;
import com.tencent.mm.bi.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.aiz;
import com.tencent.mm.protocal.c.anw;
import com.tencent.mm.protocal.c.beo;
import com.tencent.mm.protocal.c.bin;
import com.tencent.mm.protocal.c.bov;
import com.tencent.mm.protocal.c.bqr;
import com.tencent.mm.protocal.c.ma;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class d {
    public static final int hPm = Color.parseColor("#45C01A");
    public static final Pattern hPn = Pattern.compile(";");
    public static int hPo = 1;
    private static String hgr = "";

    static class a {
        int end = -1;
        int start = -1;

        a() {
        }

        final boolean isAvailable() {
            return this.start >= 0;
        }
    }

    public static class b {
        public String aQd;
        public String fDs;
        public int fRO;
        public int hPA;
        public String hPB;
        public beo hPC;
        public LinkedList<ma> hPD = new LinkedList();
        public LinkedList<anw> hPE = new LinkedList();
        public int hPF;
        public bqr hPG;
        public bov hPH;
        public int hPp;
        public int hPq;
        public int hPr;
        public LinkedList<bin> hPs = new LinkedList();
        public String hPt;
        public int hPu;
        public String hPv;
        public String hPw;
        public int hPx;
        public LinkedList<String> hPy = new LinkedList();
        public int hPz;
        public int offset;
        public int scene;
    }

    public static Spannable a(CharSequence charSequence, String str) {
        com.tencent.mm.plugin.fts.d.b.b b = f.b(com.tencent.mm.plugin.fts.d.b.a.d(charSequence, str));
        if (b.mdL instanceof Spannable) {
            return (Spannable) b.mdL;
        }
        return new SpannableString(b.mdL);
    }

    public static Spannable a(CharSequence charSequence, List<String> list) {
        com.tencent.mm.plugin.fts.d.b.b b = f.b(com.tencent.mm.plugin.fts.d.b.a.b(charSequence, list));
        if (b.mdL instanceof Spannable) {
            return (Spannable) b.mdL;
        }
        return new SpannableString(b.mdL);
    }

    public static String b(String str, List<String> list, String str2) {
        if (bg.mA(str)) {
            return "";
        }
        if (str2 == null) {
            str2 = bg.c(list, "");
        }
        a c = c(SpellMap.mx(str.toString().toLowerCase()), SpellMap.mx(str2.toLowerCase()));
        if (c.isAvailable()) {
            return a(str, c);
        }
        c = b((CharSequence) str, bg.c(list, ""));
        if (c.isAvailable()) {
            return a(str, c);
        }
        CharSequence mx = SpellMap.mx(str.toString().toLowerCase());
        ArrayList arrayList = new ArrayList();
        for (String toLowerCase : list) {
            c = c(mx, SpellMap.mx(toLowerCase.toLowerCase()));
            if (c.isAvailable()) {
                arrayList.add(c);
            }
        }
        if (arrayList.size() <= 0) {
            return str;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            str = a(str, (a) it.next());
        }
        return str;
    }

    public static Spannable a(CharSequence charSequence, List<String> list, String str) {
        com.tencent.mm.plugin.fts.d.b.b b = f.b(com.tencent.mm.plugin.fts.d.b.a.a(charSequence, str, list));
        if (b.mdL instanceof Spannable) {
            return (Spannable) b.mdL;
        }
        return new SpannableString(b.mdL);
    }

    private static a b(CharSequence charSequence, String str) {
        String mx = SpellMap.mx(str.toLowerCase());
        g.bKH();
        String str2 = "";
        String eG = com.tencent.mm.bi.f.bKE().eG(charSequence.toString(), str2);
        com.tencent.mm.bi.b.bKy();
        a c = c(SpellMap.mx(com.tencent.mm.bi.b.eF(eG, str2).replaceAll(" ", "").toLowerCase()), mx);
        if (c.isAvailable()) {
            int i = c.start;
            while (i < c.end && i < charSequence.length()) {
                if (charSequence.charAt(i) == ' ') {
                    c.end++;
                }
                i++;
            }
        }
        return c;
    }

    public static String a(String str, List<String> list, boolean z, String str2) {
        if (bg.mA(str)) {
            return "";
        }
        a b = b((CharSequence) str, str2);
        if (b.isAvailable()) {
            return a(str, b);
        }
        List arrayList = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (com.tencent.mm.plugin.fts.a.d.f(charAt)) {
                String d = SpellMap.d(charAt);
                if (d == null || d.length() <= 1) {
                    arrayList.add("");
                } else if (z) {
                    arrayList.add(d.substring(0, 1).toLowerCase());
                } else {
                    arrayList.add(d);
                }
            } else {
                arrayList.add("");
            }
        }
        Iterator it = c(arrayList, (List) list).iterator();
        while (it.hasNext()) {
            str = a(str, (a) it.next());
        }
        return str;
    }

    public static Spannable a(CharSequence charSequence, List<String> list, boolean z, String str) {
        com.tencent.mm.plugin.fts.d.b.b b = f.b(com.tencent.mm.plugin.fts.d.b.a.a(charSequence, str, (List) list, true, z));
        if (b.mdL instanceof Spannable) {
            return (Spannable) b.mdL;
        }
        return new SpannableString(b.mdL);
    }

    private static String a(String str, a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.substring(0, aVar.start));
        stringBuffer.append("<em class=\"highlight\">");
        stringBuffer.append(str.substring(aVar.start, aVar.end));
        stringBuffer.append("</em>");
        if (aVar.end < str.length()) {
            stringBuffer.append(str.substring(aVar.end, str.length()));
        }
        return stringBuffer.toString();
    }

    private static ArrayList<a> c(List<String> list, List<String> list2) {
        ArrayList<a> arrayList = new ArrayList();
        for (String toLowerCase : list2) {
            a b = b((List) list, toLowerCase.toLowerCase());
            if (b.isAvailable()) {
                arrayList.add(b);
            }
        }
        return arrayList;
    }

    private static a b(List<String> list, String str) {
        a aVar = new a();
        for (int i = 0; i < list.size(); i++) {
            String str2 = (String) list.get(i);
            if (!bg.mA(str2)) {
                if (str2.startsWith(str)) {
                    if (aVar.start < 0) {
                        aVar.start = i;
                    }
                    aVar.end = i + 1;
                    return aVar;
                } else if (str.startsWith(str2)) {
                    int i2 = i + 1;
                    String str3 = str2;
                    while (i2 < list.size() && !bg.mA((String) list.get(i2))) {
                        str3 = str3 + ((String) list.get(i2));
                        if (str.length() > str3.length() && str.startsWith(str3)) {
                            i2++;
                        } else if (str.length() <= str3.length() && str3.startsWith(str)) {
                            aVar.start = i;
                            aVar.end = i2 + 1;
                        }
                    }
                }
            }
        }
        return aVar;
    }

    private static a c(CharSequence charSequence, String str) {
        int indexOf = charSequence.toString().indexOf(str);
        a aVar = new a();
        if (indexOf >= 0) {
            aVar.start = indexOf;
            aVar.end = aVar.start + str.length();
        }
        return aVar;
    }

    public static aiz AU() {
        try {
            ap.yY();
            String str = (String) c.vr().get(67591, null);
            if (str != null) {
                aiz com_tencent_mm_protocal_c_aiz = new aiz();
                String[] split = str.split(",");
                com_tencent_mm_protocal_c_aiz.twQ = Integer.valueOf(split[0]).intValue();
                com_tencent_mm_protocal_c_aiz.twT = Integer.valueOf(split[1]).intValue();
                com_tencent_mm_protocal_c_aiz.tna = ((float) Integer.valueOf(split[2]).intValue()) / 1000000.0f;
                com_tencent_mm_protocal_c_aiz.tmZ = ((float) Integer.valueOf(split[3]).intValue()) / 1000000.0f;
                w.i("MicroMsg.FTS.FTSExportLogic", "lbs location is not null, %f, %f", Float.valueOf(com_tencent_mm_protocal_c_aiz.tna), Float.valueOf(com_tencent_mm_protocal_c_aiz.tmZ));
                return com_tencent_mm_protocal_c_aiz;
            }
            w.i("MicroMsg.FTS.FTSExportLogic", "lbs location is null, lbsContent is null!");
            return null;
        } catch (Exception e) {
            w.i("MicroMsg.FTS.FTSExportLogic", "lbs location is null, reason %s", e.getMessage());
            return null;
        }
    }

    public static int EJ() {
        AssetManager assets = ab.getContext().getAssets();
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = assets.open("config.conf");
            properties.load(inputStream);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.FTS.FTSExportLogic", e, e.getMessage(), new Object[0]);
        } finally {
            e.b(inputStream);
        }
        return Integer.valueOf(properties.getProperty("version", "1")).intValue();
    }

    public static boolean Ii() {
        return hPo > 1;
    }

    public static int EI() {
        InputStream fileInputStream;
        Throwable e;
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(Ij(), "config.conf"));
            try {
                properties.load(fileInputStream);
                e.b(fileInputStream);
            } catch (Exception e2) {
                e = e2;
                try {
                    w.printErrStackTrace("MicroMsg.FTS.FTSExportLogic", e, e.getMessage(), new Object[0]);
                    e.b(fileInputStream);
                    return Integer.valueOf(properties.getProperty("version", "1")).intValue();
                } catch (Throwable th) {
                    e = th;
                    inputStream = fileInputStream;
                    e.b(inputStream);
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            w.printErrStackTrace("MicroMsg.FTS.FTSExportLogic", e, e.getMessage(), new Object[0]);
            e.b(fileInputStream);
            return Integer.valueOf(properties.getProperty("version", "1")).intValue();
        } catch (Throwable th2) {
            e = th2;
            e.b(inputStream);
            throw e;
        }
        return Integer.valueOf(properties.getProperty("version", "1")).intValue();
    }

    public static String Ij() {
        if (bg.mA(hgr)) {
            hgr = com.tencent.mm.compatible.util.e.hgr.replace("/data/user/0", "/data/data");
        }
        File file = new File(hgr, "fts/res");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static boolean iW(String str) {
        InputStream open;
        try {
            open = ab.getContext().getAssets().open("fts_template.zip");
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.FTS.FTSExportLogic", e, "", new Object[0]);
            open = null;
        }
        if (open == null) {
            w.e("MicroMsg.FTS.FTSExportLogic", "file inputStream not found");
            return false;
        }
        OutputStream fileOutputStream;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        file.getParentFile().mkdirs();
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.FTS.FTSExportLogic", e2, "", new Object[0]);
            fileOutputStream = null;
        }
        if (fileOutputStream != null) {
            try {
                a(open, fileOutputStream);
                return true;
            } catch (Throwable e3) {
                w.printErrStackTrace("MicroMsg.FTS.FTSExportLogic", e3, "", new Object[0]);
                return false;
            } finally {
                e.b(open);
                e.a(fileOutputStream);
            }
        } else {
            e.b(open);
            return false;
        }
    }

    private static void a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static Map<String, String> aV(int i, int i2) {
        switch (i) {
            case bh.CTRL_INDEX /*201*/:
                return n.a(i, false, i2);
            default:
                return a(i, false, i2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> a(int r10, boolean r11, int r12) {
        /*
        r3 = new java.util.HashMap;
        r3.<init>();
        r0 = "scene";
        r1 = java.lang.String.valueOf(r10);
        r3.put(r0, r1);
        r0 = "type";
        r1 = java.lang.String.valueOf(r12);
        r3.put(r0, r1);
        r0 = "lang";
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r1 = com.tencent.mm.sdk.platformtools.v.ea(r1);
        r3.put(r0, r1);
        r0 = "platform";
        r1 = "android";
        r3.put(r0, r1);
        r0 = "version";
        r1 = hPo;
        r1 = java.lang.String.valueOf(r1);
        r3.put(r0, r1);
        r0 = 0;
        r2 = 0;
        r1 = 0;
        switch(r10) {
            case 3: goto L_0x010c;
            case 6: goto L_0x0264;
            case 9: goto L_0x0264;
            case 11: goto L_0x027c;
            case 14: goto L_0x019c;
            case 20: goto L_0x010c;
            case 22: goto L_0x019c;
            case 300: goto L_0x010c;
            default: goto L_0x0042;
        };
    L_0x0042:
        r9 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r9;
    L_0x0046:
        r4 = "MicroMsg.FTS.FTSExportLogic";
        r5 = "genFTSParams scene=%d isHomePage=%b type=%d %b %b %b";
        r6 = 6;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = java.lang.Integer.valueOf(r10);
        r6[r7] = r8;
        r7 = 1;
        r8 = java.lang.Boolean.valueOf(r11);
        r6[r7] = r8;
        r7 = 2;
        r8 = java.lang.Integer.valueOf(r12);
        r6[r7] = r8;
        r7 = 3;
        r8 = java.lang.Boolean.valueOf(r2);
        r6[r7] = r8;
        r7 = 4;
        r8 = java.lang.Boolean.valueOf(r1);
        r6[r7] = r8;
        r7 = 5;
        r8 = java.lang.Boolean.valueOf(r0);
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
        if (r2 == 0) goto L_0x0087;
    L_0x007e:
        r2 = "isSug";
        r4 = "1";
        r3.put(r2, r4);
    L_0x0087:
        if (r1 == 0) goto L_0x0092;
    L_0x0089:
        r1 = "isLocalSug";
        r2 = "1";
        r3.put(r1, r2);
    L_0x0092:
        if (r0 == 0) goto L_0x009d;
    L_0x0094:
        r0 = "isMostSearchBiz";
        r1 = "1";
        r3.put(r0, r1);
    L_0x009d:
        if (r11 != 0) goto L_0x00a8;
    L_0x009f:
        r0 = "isHomePage";
        r1 = "0";
        r3.put(r0, r1);
    L_0x00a8:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r0 = com.tencent.mm.bg.a.dI(r0);
        r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r1 == 0) goto L_0x00e3;
    L_0x00b6:
        r1 = 1063256064; // 0x3f600000 float:0.875 double:5.25318294E-315;
        r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r1 == 0) goto L_0x00e3;
    L_0x00bc:
        r1 = 1066401792; // 0x3f900000 float:1.125 double:5.2687249E-315;
        r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r1 == 0) goto L_0x00e3;
    L_0x00c2:
        r1 = 1067450368; // 0x3fa00000 float:1.25 double:5.273905555E-315;
        r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r1 == 0) goto L_0x00e3;
    L_0x00c8:
        r1 = 1068498944; // 0x3fb00000 float:1.375 double:5.27908621E-315;
        r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r1 == 0) goto L_0x00e3;
    L_0x00ce:
        r1 = 1070596096; // 0x3fd00000 float:1.625 double:5.289447516E-315;
        r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r1 == 0) goto L_0x00e3;
    L_0x00d4:
        r1 = 1072693248; // 0x3ff00000 float:1.875 double:5.299808824E-315;
        r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r1 == 0) goto L_0x00e3;
    L_0x00da:
        r1 = 1073846682; // 0x4001999a float:2.025 double:5.305507545E-315;
        r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r1 == 0) goto L_0x00e3;
    L_0x00e1:
        r0 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
    L_0x00e3:
        r1 = "fontRatio";
        r0 = java.lang.String.valueOf(r0);
        r3.put(r1, r0);
        r0 = "netType";
        r1 = Ik();
        r3.put(r0, r1);
        r0 = com.tencent.mm.am.b.HJ();
        if (r0 == 0) goto L_0x010b;
    L_0x00fd:
        r0 = com.tencent.mm.am.b.HL();
        if (r0 == 0) goto L_0x010b;
    L_0x0103:
        r1 = "musicSnsId";
        r0 = r0.tqY;
        r3.put(r1, r0);
    L_0x010b:
        return r3;
    L_0x010c:
        r4 = "mixGlobal";
        r4 = com.tencent.mm.as.j.kb(r4);
        if (r11 == 0) goto L_0x0127;
    L_0x0115:
        r5 = "mixSugSwitch";
        r6 = 0;
        r4 = r4.optInt(r5, r6);
        r5 = 1;
        if (r4 != r5) goto L_0x0042;
    L_0x0120:
        r0 = 1;
        r9 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r9;
        goto L_0x0046;
    L_0x0127:
        r5 = 1;
        if (r12 != r5) goto L_0x013c;
    L_0x012a:
        r5 = "bizSugSwitch";
        r6 = 0;
        r4 = r4.optInt(r5, r6);
        r5 = 1;
        if (r4 != r5) goto L_0x0042;
    L_0x0135:
        r0 = 1;
        r9 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r9;
        goto L_0x0046;
    L_0x013c:
        r5 = 8;
        if (r12 != r5) goto L_0x0152;
    L_0x0140:
        r5 = "snsSugSwitch";
        r6 = 0;
        r4 = r4.optInt(r5, r6);
        r5 = 1;
        if (r4 != r5) goto L_0x0042;
    L_0x014b:
        r0 = 1;
        r9 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r9;
        goto L_0x0046;
    L_0x0152:
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        if (r12 != r5) goto L_0x0168;
    L_0x0156:
        r5 = "novelSugSwitch";
        r6 = 0;
        r4 = r4.optInt(r5, r6);
        r5 = 1;
        if (r4 != r5) goto L_0x0042;
    L_0x0161:
        r0 = 1;
        r9 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r9;
        goto L_0x0046;
    L_0x0168:
        r5 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        if (r12 != r5) goto L_0x017e;
    L_0x016c:
        r5 = "musicSugSwitch";
        r6 = 0;
        r4 = r4.optInt(r5, r6);
        r5 = 1;
        if (r4 != r5) goto L_0x0042;
    L_0x0177:
        r0 = 1;
        r9 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r9;
        goto L_0x0046;
    L_0x017e:
        r5 = 384; // 0x180 float:5.38E-43 double:1.897E-321;
        if (r12 == r5) goto L_0x018a;
    L_0x0182:
        r5 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r12 == r5) goto L_0x018a;
    L_0x0186:
        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r12 != r5) goto L_0x0042;
    L_0x018a:
        r5 = "emotionSugSwitch";
        r6 = 0;
        r4 = r4.optInt(r5, r6);
        r5 = 1;
        if (r4 != r5) goto L_0x0042;
    L_0x0195:
        r0 = 1;
        r9 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r9;
        goto L_0x0046;
    L_0x019c:
        r4 = 1;
        if (r12 != r4) goto L_0x01b2;
    L_0x019f:
        r4 = "bizTab";
        r4 = com.tencent.mm.as.j.kb(r4);
        r5 = "bizSugSwitch";
        r6 = 0;
        r4 = r4.optInt(r5, r6);
        r5 = 1;
        if (r4 != r5) goto L_0x01b2;
    L_0x01b1:
        r0 = 1;
    L_0x01b2:
        r4 = 2;
        if (r12 != r4) goto L_0x01c8;
    L_0x01b5:
        r4 = "articleTab";
        r4 = com.tencent.mm.as.j.kb(r4);
        r5 = "sugSwitch";
        r6 = 0;
        r4 = r4.optInt(r5, r6);
        r5 = 1;
        if (r4 != r5) goto L_0x01c8;
    L_0x01c7:
        r0 = 1;
    L_0x01c8:
        r4 = 8;
        if (r12 != r4) goto L_0x01eb;
    L_0x01cc:
        r4 = "snsTab";
        r4 = com.tencent.mm.as.j.kb(r4);
        r5 = "sugSwitch";
        r6 = 0;
        r5 = r4.optInt(r5, r6);
        r6 = 1;
        if (r5 != r6) goto L_0x01df;
    L_0x01de:
        r0 = 1;
    L_0x01df:
        r5 = "localSugSwitch";
        r6 = 0;
        r4 = r4.optInt(r5, r6);
        r5 = 1;
        if (r4 != r5) goto L_0x01eb;
    L_0x01ea:
        r2 = 1;
    L_0x01eb:
        if (r11 != 0) goto L_0x0203;
    L_0x01ed:
        r4 = 4;
        if (r12 != r4) goto L_0x0203;
    L_0x01f0:
        r4 = "bizTab";
        r4 = com.tencent.mm.as.j.kb(r4);
        r5 = "bizServiceSugSwitch";
        r6 = 0;
        r4 = r4.optInt(r5, r6);
        r5 = 1;
        if (r4 != r5) goto L_0x0203;
    L_0x0202:
        r0 = 1;
    L_0x0203:
        r4 = 1;
        if (r12 != r4) goto L_0x0219;
    L_0x0206:
        r4 = "bizTab";
        r4 = com.tencent.mm.as.j.kb(r4);
        r5 = "mfsBizSwitch";
        r6 = 0;
        r4 = r4.optInt(r5, r6);
        r5 = 1;
        if (r4 != r5) goto L_0x0219;
    L_0x0218:
        r1 = 1;
    L_0x0219:
        r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        if (r12 != r4) goto L_0x0230;
    L_0x021d:
        r4 = "novelTab";
        r4 = com.tencent.mm.as.j.kb(r4);
        r5 = "sugSwitch";
        r6 = 0;
        r4 = r4.optInt(r5, r6);
        r5 = 1;
        if (r4 != r5) goto L_0x0230;
    L_0x022f:
        r0 = 1;
    L_0x0230:
        r4 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        if (r12 != r4) goto L_0x0247;
    L_0x0234:
        r4 = "musicTab";
        r4 = com.tencent.mm.as.j.kb(r4);
        r5 = "sugSwitch";
        r6 = 0;
        r4 = r4.optInt(r5, r6);
        r5 = 1;
        if (r4 != r5) goto L_0x0247;
    L_0x0246:
        r0 = 1;
    L_0x0247:
        r4 = 384; // 0x180 float:5.38E-43 double:1.897E-321;
        if (r12 != r4) goto L_0x0042;
    L_0x024b:
        r4 = "emotionTab";
        r4 = com.tencent.mm.as.j.kb(r4);
        r5 = "sugSwitch";
        r6 = 0;
        r4 = r4.optInt(r5, r6);
        r5 = 1;
        if (r4 != r5) goto L_0x025e;
    L_0x025d:
        r0 = 1;
    L_0x025e:
        r9 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r9;
        goto L_0x0046;
    L_0x0264:
        r4 = "bizEntry";
        r4 = com.tencent.mm.as.j.kb(r4);
        r5 = "sugSwitch";
        r4 = r4.optInt(r5);
        r5 = 1;
        if (r4 != r5) goto L_0x0042;
    L_0x0275:
        r0 = 1;
        r9 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r9;
        goto L_0x0046;
    L_0x027c:
        r4 = "bizUnionTopEntry";
        r4 = com.tencent.mm.as.j.kb(r4);
        r5 = "sugSwitch";
        r4 = r4.optInt(r5);
        r5 = 1;
        if (r4 != r5) goto L_0x0042;
    L_0x028d:
        r0 = 1;
        r9 = r1;
        r1 = r2;
        r2 = r0;
        r0 = r9;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.as.d.a(int, boolean, int):java.util.Map<java.lang.String, java.lang.String>");
    }

    public static String c(int i, Map<String, String> map) {
        switch (i) {
            case bh.CTRL_INDEX /*201*/:
                return n.m(map);
            default:
                return m(map);
        }
    }

    public static String Ik() {
        if (am.isWifi(ab.getContext())) {
            return "wifi";
        }
        if (am.is4G(ab.getContext())) {
            return "4g";
        }
        if (am.is3G(ab.getContext())) {
            return "3g";
        }
        if (am.is2G(ab.getContext())) {
            return "2g";
        }
        if (am.isConnected(ab.getContext())) {
            return "";
        }
        return "fail";
    }

    public static String m(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        stringBuffer.append(Ij());
        if (map.size() > 0) {
            stringBuffer.append("/app.html?");
            for (Entry entry : map.entrySet()) {
                stringBuffer.append((String) entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append((String) entry.getValue());
                stringBuffer.append("&");
            }
            if (!map.containsKey("sessionId")) {
                stringBuffer.append("sessionId");
                stringBuffer.append("=");
                stringBuffer.append(gm(bg.PY((String) map.get("scene"))));
                stringBuffer.append("&");
            }
            return stringBuffer.substring(0, stringBuffer.length() - 1);
        }
        stringBuffer.append("/app.html");
        return stringBuffer.toString();
    }

    public static Intent Il() {
        Intent intent = new Intent();
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
        intent.putExtra("neverGetA8Key", true);
        return intent;
    }

    public static final String gm(int i) {
        StringBuilder append = new StringBuilder().append(i).append("_");
        h.vG();
        return append.append(o.getString(com.tencent.mm.kernel.a.uH())).append("_").append(System.currentTimeMillis()).toString();
    }

    public static boolean Im() {
        return w.getLogLevel() == 0;
    }

    public static String n(Map<String, ? extends Object> map) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Entry entry : map.entrySet()) {
            stringBuffer.append((String) entry.getKey());
            stringBuffer.append("=");
            if (entry.getValue() != null) {
                stringBuffer.append(entry.getValue().toString());
            }
            stringBuffer.append("&");
        }
        return stringBuffer.substring(0, stringBuffer.length() - 1).toString();
    }

    public static int a(JSONObject jSONObject, String str, Context context) {
        int optInt = jSONObject == null ? 0 : jSONObject.optInt("businessType");
        if (optInt != 0) {
            return optInt;
        }
        if (str.equals(context.getString(R.l.ePP))) {
            return 2;
        }
        if (str.equals(context.getString(R.l.ePS))) {
            return 8;
        }
        if (str.equals(context.getString(R.l.ePQ))) {
            return 1;
        }
        w.i("MicroMsg.FTS.FTSExportLogic", "option " + str + " no type");
        return optInt;
    }

    public static Drawable a(int i, Context context) {
        int i2 = R.k.dzN;
        switch (i) {
            case 1:
                i2 = R.k.dzM;
                break;
            case 2:
                i2 = R.k.dzE;
                break;
            case 8:
                i2 = R.k.dzJ;
                break;
            case 64:
                i2 = R.k.dzI;
                break;
            case 256:
            case 384:
                i2 = R.k.dzF;
                break;
            case 512:
                i2 = R.k.dzK;
                break;
            case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                i2 = R.k.dzL;
                break;
        }
        return context.getResources().getDrawable(i2);
    }

    public static int gn(int i) {
        if (i == bh.CTRL_INDEX) {
            return MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT;
        }
        if (i == 3) {
            return MMBitmapFactory.ERROR_IO_FAILED;
        }
        if (i == 16) {
            return 1042;
        }
        if (i == 20) {
            return 1053;
        }
        return 1000;
    }

    public static boolean af(String str, String str2) {
        int i = 0;
        if (str == str2) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith(str2)) {
            return true;
        }
        String str3;
        if (TextUtils.isEmpty(str)) {
            str3 = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder(str.length());
            while (i < str.length()) {
                stringBuilder.append(SpellMap.d(str.charAt(i)));
                i++;
            }
            str3 = stringBuilder.toString();
        }
        return str3.startsWith(str2);
    }
}
