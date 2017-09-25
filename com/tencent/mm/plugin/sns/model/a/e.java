package com.tencent.mm.plugin.sns.model.a;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.compatible.d.m;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.i.g;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.map.i;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.model.a.b.a;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public abstract class e extends b {
    protected boolean pZa = false;
    protected boolean pZb = false;
    protected boolean pZc = false;
    protected boolean pZd = false;

    public e(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final String FK(String str) {
        String str2;
        Exception e;
        int i = 2;
        Object obj = null;
        try {
            int i2;
            Object obj2;
            Object obj3;
            int i3;
            String value = g.sV().getValue("SnsCloseDownloadWebp");
            if (bg.mA(value)) {
                i2 = 0;
            } else {
                i2 = bg.PY(value);
            }
            if (i2 != 0) {
                obj2 = null;
            } else if (VERSION.SDK_INT < 14) {
                obj2 = null;
            } else if (p.gRl.gQH == 2) {
                obj2 = null;
            } else if (bg.mA(r.ijL)) {
                int i4 = 1;
            } else {
                obj2 = null;
            }
            if (!m.rs()) {
                obj3 = null;
            } else if (!ae.beV()) {
                obj3 = null;
            } else if (bg.mA(r.ijL)) {
                i2 = 1;
            } else {
                obj3 = null;
            }
            if (m.rs() && ae.beU() && bg.mA(r.ijL)) {
                i3 = 1;
            }
            if (!bg.mA(r.ijK) || !bg.mA(r.ijL)) {
                if (!bg.mA(r.ijK)) {
                    String[] split = str.split("(//?)");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(split[0]).append("//").append(r.ijK);
                    while (i < split.length) {
                        stringBuilder.append("/").append(split[i]);
                        i++;
                    }
                    str = stringBuilder.toString();
                    w.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
                }
                if (!bg.mA(r.ijL)) {
                    str = j(str, "tp=" + r.ijL);
                    w.i("MicroMsg.SnsDownloadImageBase", "(dbg) new url  " + str);
                }
            } else if (obj3 != null) {
                str = j(str, "tp=wxpc");
                w.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
            } else if (obj != null) {
                str = j(str, "tp=hevc");
                w.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
            } else if (obj2 != null) {
                str = j(str, "tp=webp");
                w.i("MicroMsg.SnsDownloadImageBase", "new url  " + str);
            }
            if (!(this.pYD == null || this.pYD.pTY.tPu == 0)) {
                str = j(str, "enc=1");
                w.i("MicroMsg.SnsDownloadImageBase", "test for enckey " + this.pYD.pTY.tPv + " " + this.pYD.pTY.tPu + " " + str);
                b.mN(i.CTRL_INDEX);
                this.pZd = true;
            }
            str2 = str;
            try {
                if (!(this.pYD == null || this.pYD.pTY == null)) {
                    Object obj4;
                    alh com_tencent_mm_protocal_c_alh = this.pYD.pTY;
                    if (this.pYD.pYx) {
                        obj4 = com_tencent_mm_protocal_c_alh.tPA;
                    } else {
                        String str3 = com_tencent_mm_protocal_c_alh.tPx;
                    }
                    i3 = this.pYD.pYx ? com_tencent_mm_protocal_c_alh.tPB : com_tencent_mm_protocal_c_alh.tPy;
                    if (!TextUtils.isEmpty(obj4)) {
                        str2 = j(str2, "token=" + obj4, "idx=" + i3);
                    }
                }
            } catch (Exception e2) {
                e = e2;
                w.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + e.getMessage());
                return str2;
            }
        } catch (Exception e3) {
            e = e3;
            str2 = str;
            w.e("MicroMsg.SnsDownloadImageBase", "error get dyna by webp " + e.getMessage());
            return str2;
        }
        return str2;
    }

    private static String j(String str, String... strArr) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append(str.contains("?") ? "&" : "?");
        Object obj = 1;
        for (String str2 : strArr) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append("&");
            }
            stringBuilder.append(str2);
        }
        return stringBuilder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.io.InputStream r11, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r12) {
        /*
        r10 = this;
        r1 = 0;
        r0 = "Content-Type";
        r0 = r12.get(r0);
        r0 = (java.util.List) r0;
        if (r0 == 0) goto L_0x0030;
    L_0x000c:
        r2 = r0.size();
        if (r2 <= 0) goto L_0x0030;
    L_0x0012:
        r2 = 0;
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r2 = "";
        r0 = com.tencent.mm.sdk.platformtools.bg.ap(r0, r2);
        r2 = r0.toLowerCase();
        r3 = "webp";
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x0134;
    L_0x002d:
        r0 = 1;
        r10.pZa = r0;
    L_0x0030:
        r0 = "X-Enc";
        r0 = r12.get(r0);
        r0 = (java.util.List) r0;
        if (r0 == 0) goto L_0x005f;
    L_0x003b:
        r2 = r0.size();
        if (r2 <= 0) goto L_0x005f;
    L_0x0041:
        r2 = 0;
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r2 = "";
        r0 = com.tencent.mm.sdk.platformtools.bg.ap(r0, r2);
        r0 = r0.toLowerCase();
        r2 = "1";
        r0 = r0.contains(r2);
        if (r0 == 0) goto L_0x005f;
    L_0x005c:
        r0 = 1;
        r10.pZc = r0;
    L_0x005f:
        r0 = r10.pZd;
        if (r0 == 0) goto L_0x006c;
    L_0x0063:
        r0 = r10.pZc;
        if (r0 != 0) goto L_0x006c;
    L_0x0067:
        r0 = 138; // 0x8a float:1.93E-43 double:6.8E-322;
        com.tencent.mm.plugin.sns.lucky.a.b.mN(r0);
    L_0x006c:
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r4 = new byte[r0];	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r0 = "MicroMsg.SnsDownloadImageBase";
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r3 = "isEnc ";
        r2.<init>(r3);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r3 = r10.pZc;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r3 = " ";
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r3.<init>();	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r5 = r10.pYD;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r5 = r5.getPath();	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r3 = r3.append(r5);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r5 = r10.pYD;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r5 = r5.bfv();	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r3 = r3.append(r5);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r3 = com.tencent.mm.modelsfs.f.kq(r3);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r0 = r10.pZc;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        if (r0 == 0) goto L_0x0160;
    L_0x00b8:
        r0 = "";
        r2 = r10.pYD;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r2 = r2.pTY;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        if (r2 == 0) goto L_0x00cd;
    L_0x00c1:
        r0 = r10.pYD;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r0 = r0.pYx;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        if (r0 == 0) goto L_0x0158;
    L_0x00c7:
        r0 = r10.pYD;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r0 = r0.pTY;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r0 = r0.tPC;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
    L_0x00cd:
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r2.<init>();	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r3 = r10.pYD;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r3 = r3.getPath();	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r3 = r10.pYD;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r3 = r3.bfv();	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r1 = com.tencent.mm.modelsfs.FileOp.ah(r2, r0);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
    L_0x00ee:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        r0 = r10.pYO;	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        r5 = "";
        r0.value = r5;	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        r0 = 0;
    L_0x00fa:
        r5 = r11.read(r4);	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        r6 = -1;
        if (r5 == r6) goto L_0x01f7;
    L_0x0101:
        r6 = r10.pYR;	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        r8 = 0;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 != 0) goto L_0x0111;
    L_0x0109:
        r6 = r10.pYS;	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        r6 = com.tencent.mm.sdk.platformtools.bg.aA(r6);	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        r10.pYR = r6;	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
    L_0x0111:
        r0 = r10.pYP;	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        if (r5 <= r0) goto L_0x011d;
    L_0x0115:
        r10.pYP = r5;	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        r6 = com.tencent.mm.sdk.platformtools.bg.Ny();	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        r10.pYQ = r6;	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
    L_0x011d:
        r0 = com.tencent.mm.plugin.sns.model.ae.xv();	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        r0 = com.tencent.mm.plugin.sns.data.i.EN(r0);	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        if (r0 != 0) goto L_0x01dc;
    L_0x0127:
        r1.close();	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        r11.close();	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        if (r1 == 0) goto L_0x0132;
    L_0x012f:
        r1.close();	 Catch:{ IOException -> 0x01cd }
    L_0x0132:
        r0 = 0;
    L_0x0133:
        return r0;
    L_0x0134:
        r2 = r0.toLowerCase();
        r3 = "hevc";
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x0146;
    L_0x0141:
        r0 = 1;
        r10.pZb = r0;
        goto L_0x0030;
    L_0x0146:
        r0 = r0.toLowerCase();
        r2 = "wxpc";
        r0 = r0.contains(r2);
        if (r0 == 0) goto L_0x0030;
    L_0x0153:
        r0 = 1;
        r10.pZb = r0;
        goto L_0x0030;
    L_0x0158:
        r0 = r10.pYD;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r0 = r0.pTY;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r0 = r0.tPz;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        goto L_0x00cd;
    L_0x0160:
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r0.<init>();	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r2 = r10.pYD;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r2 = r2.getPath();	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r0 = r0.append(r2);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r2 = r10.pYD;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r2 = r2.bfv();	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r0 = r0.append(r2);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r0 = com.tencent.mm.modelsfs.f.kp(r0);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        if (r0 == 0) goto L_0x01a6;
    L_0x0183:
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r0.<init>();	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r2 = r10.pYD;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r2 = r2.getPath();	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r0 = r0.append(r2);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r2 = r10.pYD;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r2 = r2.bfv();	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r0 = r0.append(r2);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r1 = com.tencent.mm.modelsfs.FileOp.gQ(r0);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        goto L_0x00ee;
    L_0x01a6:
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r0.<init>();	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r2 = r10.pYD;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r2 = r2.getPath();	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r0 = r0.append(r2);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r2 = r10.pYD;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r2 = r2.bfv();	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r0 = r0.append(r2);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r0 = com.tencent.mm.modelsfs.f.kq(r0);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r1 = com.tencent.mm.modelsfs.FileOp.gQ(r0);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        goto L_0x00ee;
    L_0x01cd:
        r0 = move-exception;
        r1 = "MicroMsg.SnsDownloadImageBase";
        r2 = "";
        r3 = 0;
        r3 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r3);
        goto L_0x0132;
    L_0x01dc:
        r0 = 0;
        r1.write(r4, r0, r5);	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        r0 = r10.pYX;	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        r0 = r0 + r5;
        r10.pYX = r0;	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        r0 = 1;
        r5 = r10.pYX;	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        r6 = r10.pYO;	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        r5 = com.tencent.mm.plugin.sns.model.a.b.a(r5, r2, r6);	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        if (r5 == 0) goto L_0x00fa;
    L_0x01f0:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        r0 = 0;
        goto L_0x00fa;
    L_0x01f7:
        r1.close();	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        r11.close();	 Catch:{ IOException -> 0x02cd, Exception -> 0x02ca, all -> 0x02b2 }
        r1 = 0;
        if (r0 == 0) goto L_0x0209;
    L_0x0200:
        r0 = r10.pYX;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        r2 = 0;
        r4 = r10.pYO;	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
        com.tencent.mm.plugin.sns.model.a.b.a(r0, r2, r4);	 Catch:{ IOException -> 0x020c, Exception -> 0x025f, all -> 0x02b2 }
    L_0x0209:
        r0 = 1;
        goto L_0x0133;
    L_0x020c:
        r0 = move-exception;
        r9 = r1;
    L_0x020e:
        r1 = r10.pYD;	 Catch:{ all -> 0x02c7 }
        r1 = r1.pYx;	 Catch:{ all -> 0x02c7 }
        if (r1 == 0) goto L_0x0220;
    L_0x0214:
        r1 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ all -> 0x02c7 }
        r2 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r4 = 17;
        r6 = 1;
        r8 = 1;
        r1.a(r2, r4, r6, r8);	 Catch:{ all -> 0x02c7 }
    L_0x0220:
        r1 = "MicroMsg.SnsDownloadImageBase";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02c7 }
        r3 = "snscdndownload IOException fail : ";
        r2.<init>(r3);	 Catch:{ all -> 0x02c7 }
        r3 = r0.getMessage();	 Catch:{ all -> 0x02c7 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x02c7 }
        r2 = r2.toString();	 Catch:{ all -> 0x02c7 }
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x02c7 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r3);	 Catch:{ all -> 0x02c7 }
        r1 = "MicroMsg.SnsDownloadImageBase";
        r2 = "";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x02c7 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r3);	 Catch:{ all -> 0x02c7 }
        if (r9 == 0) goto L_0x024e;
    L_0x024b:
        r9.close();	 Catch:{ IOException -> 0x0251 }
    L_0x024e:
        r0 = 0;
        goto L_0x0133;
    L_0x0251:
        r0 = move-exception;
        r1 = "MicroMsg.SnsDownloadImageBase";
        r2 = "";
        r3 = 0;
        r3 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r3);
        goto L_0x024e;
    L_0x025f:
        r0 = move-exception;
        r9 = r1;
    L_0x0261:
        r1 = r10.pYD;	 Catch:{ all -> 0x02c7 }
        r1 = r1.pYx;	 Catch:{ all -> 0x02c7 }
        if (r1 == 0) goto L_0x0273;
    L_0x0267:
        r1 = com.tencent.mm.plugin.report.service.g.oUh;	 Catch:{ all -> 0x02c7 }
        r2 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r4 = 20;
        r6 = 1;
        r8 = 1;
        r1.a(r2, r4, r6, r8);	 Catch:{ all -> 0x02c7 }
    L_0x0273:
        r1 = "MicroMsg.SnsDownloadImageBase";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02c7 }
        r3 = "snscdndownload Exception fail : ";
        r2.<init>(r3);	 Catch:{ all -> 0x02c7 }
        r3 = r0.getMessage();	 Catch:{ all -> 0x02c7 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x02c7 }
        r2 = r2.toString();	 Catch:{ all -> 0x02c7 }
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x02c7 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r3);	 Catch:{ all -> 0x02c7 }
        r1 = "MicroMsg.SnsDownloadImageBase";
        r2 = "";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x02c7 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r3);	 Catch:{ all -> 0x02c7 }
        if (r9 == 0) goto L_0x02a1;
    L_0x029e:
        r9.close();	 Catch:{ IOException -> 0x02a4 }
    L_0x02a1:
        r0 = 0;
        goto L_0x0133;
    L_0x02a4:
        r0 = move-exception;
        r1 = "MicroMsg.SnsDownloadImageBase";
        r2 = "";
        r3 = 0;
        r3 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r3);
        goto L_0x02a1;
    L_0x02b2:
        r0 = move-exception;
    L_0x02b3:
        if (r1 == 0) goto L_0x02b8;
    L_0x02b5:
        r1.close();	 Catch:{ IOException -> 0x02b9 }
    L_0x02b8:
        throw r0;
    L_0x02b9:
        r1 = move-exception;
        r2 = "MicroMsg.SnsDownloadImageBase";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x02b8;
    L_0x02c7:
        r0 = move-exception;
        r1 = r9;
        goto L_0x02b3;
    L_0x02ca:
        r0 = move-exception;
        r9 = r1;
        goto L_0x0261;
    L_0x02cd:
        r0 = move-exception;
        r9 = r1;
        goto L_0x020e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.a.e.a(java.io.InputStream, java.util.Map):boolean");
    }

    protected final boolean bfA() {
        return true;
    }
}
