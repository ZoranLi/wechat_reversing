package com.tencent.mm.modelcontrol;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.l;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class d implements am {
    private static final int hzB = c.mE("dscp");
    private a hzC = new a();
    private byte[] hzD = null;
    private b hzE;
    private e[] hzF;
    private e[] hzG;
    private e[] hzH;
    private e[] hzI;
    private e[] hzJ;

    public static d Eu() {
        return (d) l.o(d.class);
    }

    private e[] iU(String str) {
        int i = 0;
        String value = ((a) h.h(a.class)).sV().getValue(str);
        if (bg.mA(value)) {
            w.i("MicroMsg.SubCoreVideoControl", "key %s config is null", str);
            return null;
        }
        if (!value.startsWith("[")) {
            value = "[" + value;
        }
        if (!value.endsWith("]")) {
            value = value + "]";
        }
        w.i("MicroMsg.SubCoreVideoControl", "%s=%s ", str, value);
        try {
            JSONArray jSONArray = new JSONArray(value);
            int length = jSONArray.length();
            w.d("MicroMsg.SubCoreVideoControl", "parse config root length %d", Integer.valueOf(length));
            e[] eVarArr = new e[length];
            while (i < length) {
                eVarArr[i] = b(jSONArray.getJSONObject(i));
                i++;
            }
            return eVarArr;
        } catch (Exception e) {
            w.e("MicroMsg.SubCoreVideoControl", "parse Configs error : " + e.toString());
            return null;
        }
    }

    private static e b(JSONObject jSONObject) {
        e eVar = new e();
        try {
            String str;
            String string = jSONObject.isNull("time") ? "" : jSONObject.getString("time");
            String string2 = jSONObject.getString("abr");
            String string3 = jSONObject.getString("intval");
            String string4 = jSONObject.getString("prof");
            String string5 = jSONObject.getString("preset");
            if (jSONObject.isNull("stepbr")) {
                str = "0";
            } else {
                str = jSONObject.getString("stepbr");
            }
            w.i("MicroMsg.SubCoreVideoControl", "busy time %s audio bitrate %s iframe %s profile %s preset %s stepbr %s", string, string2, string3, string4, string5, str);
            eVar.a(string, string2, string3, string4, string5, str);
            JSONArray jSONArray = jSONObject.getJSONArray("conf");
            List arrayList = new ArrayList();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            PInt pInt3 = new PInt();
            PInt pInt4 = new PInt();
            PInt pInt5 = new PInt();
            PInt pInt6 = new PInt();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (a(!jSONObject2.isNull("dura") ? jSONObject2.getString("dura") : "", jSONObject2.getString("wh"), jSONObject2.getString("fps"), jSONObject2.getString("vbr"), pInt, pInt2, pInt3, pInt4, pInt5, pInt6)) {
                    arrayList.add(new f(pInt.value, pInt2.value, pInt3.value, pInt4.value, pInt5.value, pInt6.value, pInt6.value));
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2 && !eVar.hzP) {
                int i2 = ((f) arrayList.get(0)).hzX;
                for (int i3 = 1; i3 < arrayList.size(); i3++) {
                    f fVar = (f) arrayList.get(i3);
                    fVar.hzW = i2;
                    i2 = fVar.hzX;
                }
            }
            eVar.hzQ = new f[arrayList.size()];
            arrayList.toArray(eVar.hzQ);
            w.d("MicroMsg.SubCoreVideoControl", "parseJsonObject %s", eVar);
            return eVar;
        } catch (Exception e) {
            w.e("MicroMsg.SubCoreVideoControl", "parseJsonObject error : " + e.toString());
            return null;
        }
    }

    private static boolean a(String str, String str2, String str3, String str4, PInt pInt, PInt pInt2, PInt pInt3, PInt pInt4, PInt pInt5, PInt pInt6) {
        if (bg.mA(str2) || bg.mA(str3) || bg.mA(str4)) {
            return false;
        }
        try {
            String[] split;
            if (bg.mA(str)) {
                pInt2.value = 0;
                pInt.value = 0;
            } else {
                split = str.split("~");
                pInt.value = bg.getInt(split[0], -1);
                pInt2.value = bg.getInt(split[1], -1);
                if (pInt.value < 0 || pInt2.value < 0) {
                    return false;
                }
            }
            split = str2.split("x");
            pInt3.value = bg.getInt(split[0], -1);
            pInt4.value = bg.getInt(split[1], -1);
            if (pInt3.value < 0 || pInt4.value < 0) {
                return false;
            }
            pInt5.value = bg.getInt(str3, -1);
            pInt6.value = bg.getInt(str4, -1);
            if (pInt5.value < 0 || pInt6.value < 0) {
                return false;
            }
            pInt6.value *= 1000;
            w.i("MicroMsg.SubCoreVideoControl", "config[%s, %s, %s, %s], args[%d, %d, %d, %d, %d, %d]", str, str2, str3, str4, Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(pInt3.value), Integer.valueOf(pInt4.value), Integer.valueOf(pInt5.value), Integer.valueOf(pInt6.value));
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.SubCoreVideoControl", "parse video para error." + e.toString());
        }
    }

    public final byte[] getWeixinMeta() {
        if (bg.bm(this.hzD)) {
            try {
                this.hzD = ("{\"WXVer\":" + com.tencent.mm.protocal.d.sYN + "}").getBytes("UTF-8");
                w.i("MicroMsg.SubCoreVideoControl", "get weixin video meta %s", r0);
            } catch (Exception e) {
                w.e("MicroMsg.SubCoreVideoControl", "get weixin meta error %s ", e.toString());
            }
        }
        return this.hzD;
    }

    public final boolean iV(String str) {
        Exception e;
        Throwable th;
        if (this.hzE == null) {
            this.hzE = new b();
        }
        b bVar = this.hzE;
        bVar.ilE = -1;
        bVar.ilG = -1;
        bVar.ilH = null;
        long NA = bg.NA();
        long mC = this.hzE.mC(str);
        if (mC <= 0) {
            return false;
        }
        String str2 = null;
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(new File(str), "r");
            try {
                randomAccessFile.seek(mC);
                byte[] bArr = new byte[8];
                com.tencent.mm.plugin.a.a aVar = null;
                for (com.tencent.mm.plugin.a.a a = c.a(randomAccessFile, bArr, com.tencent.mm.plugin.a.a.ilu); a != null; a = c.a(randomAccessFile, bArr, com.tencent.mm.plugin.a.a.ilu)) {
                    aVar = c.a(randomAccessFile, bArr, hzB);
                    if (aVar != null) {
                        break;
                    }
                    randomAccessFile.seek(a.NF());
                }
                if (aVar != null) {
                    byte[] bArr2 = new byte[(((int) aVar.getSize()) - 8)];
                    randomAccessFile.seek(aVar.ilD + 8);
                    if (randomAccessFile.read(bArr2) > 0) {
                        str2 = new String(bArr2, "UTF-8");
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (IOException e2) {
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    w.e("MicroMsg.SubCoreVideoControl", "check is wx meta error %s %s", str, e.toString());
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e4) {
                        }
                    }
                    w.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", str2, Long.valueOf(mC), Long.valueOf(bg.aB(NA)), str);
                    if (bg.mA(str2)) {
                        return str2.contains("WXVer");
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            randomAccessFile = null;
            w.e("MicroMsg.SubCoreVideoControl", "check is wx meta error %s %s", str, e.toString());
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            w.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", str2, Long.valueOf(mC), Long.valueOf(bg.aB(NA)), str);
            if (bg.mA(str2)) {
                return str2.contains("WXVer");
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
        w.i("MicroMsg.SubCoreVideoControl", "check is wx meta dscp %s moov %d cost %d %s", str2, Long.valueOf(mC), Long.valueOf(bg.aB(NA)), str);
        if (bg.mA(str2)) {
            return str2.contains("WXVer");
        }
        return false;
    }

    public final VideoTransPara Ev() {
        VideoTransPara EE;
        boolean z;
        VideoTransPara videoTransPara;
        long NA = bg.NA();
        if (this.hzF == null) {
            this.hzF = iU("C2CRecordVideoConfig");
        }
        if (this.hzF != null) {
            for (e eVar : this.hzF) {
                if (eVar != null && eVar.ED()) {
                    w.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get c2c Record config.");
                    EE = eVar.EE();
                    z = eVar.hzP;
                    break;
                }
            }
        }
        EE = null;
        z = true;
        if (EE == null) {
            EE = new VideoTransPara();
            EE.isDefault = true;
            EE.width = 540;
            EE.height = 960;
            EE.gPE = 30;
            EE.hzY = 1200000;
            EE.hzM = 1;
            EE.hzL = 64000;
            EE.hzN = 2;
            EE.hzO = 1;
            videoTransPara = EE;
        } else {
            videoTransPara = EE;
        }
        videoTransPara.audioSampleRate = 44100;
        videoTransPara.hzM = 1;
        videoTransPara.duration = 10;
        if (z) {
            g.oUh.a(422, 12, 1, false);
        } else {
            g.oUh.a(422, 11, 1, false);
        }
        g.oUh.a(422, (long) bg.f((Integer) g.a(videoTransPara.hzY / 1000, new int[]{350, 544, 800, 1200, 1600}, 13, 18)), 1, false);
        w.i("MicroMsg.SubCoreVideoControl", "get c2c record para cost %d. %s rpt %d", Long.valueOf(bg.aB(NA)), videoTransPara, Integer.valueOf(r0));
        return videoTransPara;
    }

    public final VideoTransPara Ew() {
        VideoTransPara EE;
        boolean z;
        VideoTransPara Ey;
        long NA = bg.NA();
        if (this.hzG == null) {
            this.hzG = iU("SnsRecordVideoConfig");
        }
        if (this.hzG != null) {
            for (e eVar : this.hzG) {
                if (eVar != null && eVar.ED()) {
                    w.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns Record config.");
                    EE = eVar.EE();
                    z = eVar.hzP;
                    break;
                }
            }
        }
        EE = null;
        z = true;
        if (EE == null) {
            Ey = Ey();
        } else {
            Ey = EE;
        }
        Ey.audioSampleRate = 44100;
        Ey.hzM = 1;
        Ey.duration = 10;
        Ey.hzZ = m.CTRL_INDEX;
        if (z) {
            g.oUh.a(422, 32, 1, false);
        } else {
            g.oUh.a(422, 31, 1, false);
        }
        g.oUh.a(422, (long) bg.f((Integer) g.a(Ey.hzY / 1000, new int[]{350, 544, 800, 1200, 1600}, 33, 38)), 1, false);
        w.i("MicroMsg.SubCoreVideoControl", "get sns record para cost %d. %s rpt %d", Long.valueOf(bg.aB(NA)), Ey, Integer.valueOf(r0));
        return Ey;
    }

    public final VideoTransPara Ex() {
        VideoTransPara EE;
        boolean z;
        VideoTransPara Ey;
        long NA = bg.NA();
        if (this.hzH == null) {
            this.hzH = iU("SnsAlbumVideoConfig");
        }
        if (this.hzH != null) {
            for (e eVar : this.hzH) {
                if (eVar != null && eVar.ED()) {
                    w.i("MicroMsg.SubCoreVideoControl", "it busy time, try to get sns album config.");
                    EE = eVar.EE();
                    z = eVar.hzP;
                    break;
                }
            }
        }
        EE = null;
        z = true;
        if (EE == null) {
            Ey = Ey();
        } else {
            Ey = EE;
        }
        Ey.audioSampleRate = 44100;
        Ey.hzM = 1;
        Ey.hzZ = m.CTRL_INDEX;
        if (z) {
            g.oUh.a(422, 22, 1, false);
        } else {
            g.oUh.a(422, 21, 1, false);
        }
        g.oUh.a(422, (long) bg.f((Integer) g.a(Ey.hzY / 1000, new int[]{350, 544, 800, 1200, 1600}, 23, 28)), 1, false);
        w.i("MicroMsg.SubCoreVideoControl", "get sns album para cost %d. %s rpt %d ", Long.valueOf(bg.aB(NA)), Ey, Integer.valueOf(r0));
        return Ey;
    }

    public final VideoTransPara a(VideoTransPara videoTransPara) {
        if (videoTransPara.duration >= e.CTRL_INDEX) {
            w.w("MicroMsg.SubCoreVideoControl", "this video duration is large than %s s", Integer.valueOf(e.CTRL_INDEX));
            return null;
        }
        e[] eVarArr;
        boolean z;
        int i;
        long NA = bg.NA();
        VideoTransPara fB = fB(videoTransPara.duration);
        int i2 = 1;
        com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100157");
        if (dX.isValid()) {
            i2 = bg.getInt((String) dX.bKK().get("VideoEncodeStep"), 1);
        }
        w.i("MicroMsg.SubCoreVideoControl", "check c2c album encode step %d", Integer.valueOf(i2));
        if ((i2 > 0 ? 1 : null) != null) {
            if (this.hzJ == null) {
                this.hzJ = iU("C2CAlbumVideoStepConfig");
            }
            eVarArr = this.hzJ;
        } else {
            if (this.hzI == null) {
                this.hzI = iU("C2CAlbumVideoConfig");
            }
            eVarArr = this.hzI;
        }
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                if (eVar != null && eVar.ED()) {
                    w.i("MicroMsg.SubCoreVideoControl", "it busy time, try to calc c2c album config.");
                    int a = a.a(eVar.hzQ, videoTransPara, fB);
                    z = eVar.hzP;
                    i = a;
                    break;
                }
            }
            z = true;
            i = 0;
        } else {
            w.i("MicroMsg.SubCoreVideoControl", "it not busy time, try to calc c2c album default config.");
            i = a.a(null, videoTransPara, fB);
            z = true;
        }
        if (i <= 0) {
            fB = fB(videoTransPara.duration);
        } else {
            fB.isDefault = false;
        }
        if (z) {
            g.oUh.a(422, 2, 1, false);
        } else {
            g.oUh.a(422, 1, 1, false);
        }
        g.oUh.a(422, (long) bg.f((Integer) g.a(fB.hzY / 1000, new int[]{350, 544, 800, 1200, 1600}, 3, 8)), 1, false);
        w.i("MicroMsg.SubCoreVideoControl", "get c2c album para cost %d rpt %d. bitrate %d new para %s, original para %s", Long.valueOf(bg.aB(NA)), Integer.valueOf(i2), Integer.valueOf(i), fB, videoTransPara);
        return fB;
    }

    private static VideoTransPara Ey() {
        VideoTransPara videoTransPara = new VideoTransPara();
        videoTransPara.isDefault = true;
        videoTransPara.width = 540;
        videoTransPara.height = 960;
        videoTransPara.gPE = 30;
        videoTransPara.hzY = 1600000;
        videoTransPara.hzM = 1;
        videoTransPara.hzL = 64000;
        videoTransPara.hzN = 2;
        videoTransPara.hzO = 1;
        return videoTransPara;
    }

    private static VideoTransPara fB(int i) {
        VideoTransPara videoTransPara = new VideoTransPara();
        videoTransPara.isDefault = true;
        videoTransPara.hzM = 1;
        videoTransPara.hzL = 48000;
        videoTransPara.hzN = 2;
        videoTransPara.hzO = 1;
        if (i <= 120) {
            videoTransPara.gPE = 30;
            videoTransPara.width = 540;
            videoTransPara.height = 960;
            videoTransPara.hzY = 1200000;
        } else {
            videoTransPara.gPE = 24;
            videoTransPara.width = 360;
            videoTransPara.height = 640;
            videoTransPara.hzY = 544000;
        }
        return videoTransPara;
    }

    public static boolean Ez() {
        int i;
        int intValue = ((Integer) h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue();
        com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100136");
        if (dX.isValid()) {
            i = bg.getInt((String) dX.bKK().get("streamingDownload"), 0);
        } else {
            i = 0;
        }
        boolean z = (intValue == 0 || i == -1 || !EB()) ? false : intValue > 0 ? true : i > 0;
        w.i("MicroMsg.SubCoreVideoControl", "check can c2c online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", Boolean.valueOf(z), Boolean.valueOf(r5), Integer.valueOf(intValue), Integer.valueOf(i));
        return z;
    }

    public static boolean EA() {
        int i;
        int intValue = ((Integer) h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue();
        com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100153");
        if (dX.isValid()) {
            i = bg.getInt((String) dX.bKK().get("snsStreamDownload"), 0);
        } else {
            i = 0;
        }
        boolean z = (intValue == 0 || i == -1 || !EB()) ? false : intValue > 0 ? true : i > 0;
        w.i("MicroMsg.SubCoreVideoControl", "check can sns online play video [%b] mmvideoplayer[%b] opcode[%d] abTestFlag[%d]", Boolean.valueOf(z), Boolean.valueOf(r5), Integer.valueOf(intValue), Integer.valueOf(i));
        return z;
    }

    public static boolean EB() {
        int i;
        String str;
        boolean z;
        String str2 = null;
        long NA = bg.NA();
        int intValue = ((Integer) h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue();
        com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100190");
        if (dX.isValid()) {
            Map bKK = dX.bKK();
            i = bg.getInt((String) bKK.get("player"), 1);
            str = (String) bKK.get("apilevel");
            str2 = (String) bKK.get("devices");
        } else {
            str = null;
            i = 1;
        }
        int i2 = VERSION.SDK_INT;
        String str3 = Build.BRAND + Build.MODEL;
        if (!bg.mA(str)) {
            for (String str4 : str.split(";")) {
                if (bg.getInt(str4, 0) == i2) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (!bg.mA(str2)) {
            for (String equalsIgnoreCase : str2.split(";")) {
                if (equalsIgnoreCase.equalsIgnoreCase(str3)) {
                    z = false;
                    break;
                }
            }
        }
        if (com.tencent.mm.compatible.util.d.ep(18)) {
            z = false;
        }
        if (Build.BRAND.equalsIgnoreCase("meizu")) {
            h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_VIDEO_NEED_RESET_EXTRACTOR_BOOLEAN, Boolean.valueOf(true));
        }
        if (intValue == 0) {
            z = false;
        }
        if (i <= 0) {
            z = false;
        }
        w.i("MicroMsg.SubCoreVideoControl", "check can use mmvideoplayer[%b] api[%d, %s] device[%s, %s] abTestFlag[%d] costTime[%d]", Boolean.valueOf(z), Integer.valueOf(i2), str, str3, str2, Integer.valueOf(i), Long.valueOf(bg.aB(NA)));
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(int r13, com.tencent.mm.modelvideo.r r14) {
        /*
        r1 = 0;
        r6 = -1;
        r5 = 2;
        r2 = 1;
        r8 = 0;
        switch(r13) {
            case 0: goto L_0x0028;
            case 1: goto L_0x002a;
            case 2: goto L_0x002a;
            default: goto L_0x0008;
        };
    L_0x0008:
        r0 = r2;
    L_0x0009:
        r1 = "MicroMsg.SubCoreVideoControl";
        r3 = "check c2c video format[%d]";
        r2 = new java.lang.Object[r2];
        r4 = java.lang.Integer.valueOf(r0);
        r2[r8] = r4;
        com.tencent.mm.sdk.platformtools.w.i(r1, r3, r2);
        if (r0 != r5) goto L_0x013d;
    L_0x001c:
        r1 = com.tencent.mm.plugin.report.service.g.oUh;
        r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
        r4 = 130; // 0x82 float:1.82E-43 double:6.4E-322;
        r6 = 1;
        r1.a(r2, r4, r6, r8);
    L_0x0027:
        return r0;
    L_0x0028:
        r0 = r2;
        goto L_0x0009;
    L_0x002a:
        r0 = com.tencent.mm.kernel.h.vI();
        r0 = r0.vr();
        r3 = com.tencent.mm.storage.w.a.USERINFO_SUPPORT_HEVC_VIDEO_INT;
        r4 = java.lang.Integer.valueOf(r6);
        r0 = r0.get(r3, r4);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        if (r0 != r6) goto L_0x005c;
    L_0x0044:
        r0 = com.tencent.mm.plugin.s.e.aKo();
        if (r0 == 0) goto L_0x0085;
    L_0x004a:
        r0 = r2;
    L_0x004b:
        r3 = com.tencent.mm.kernel.h.vI();
        r3 = r3.vr();
        r4 = com.tencent.mm.storage.w.a.USERINFO_SUPPORT_HEVC_VIDEO_INT;
        r6 = java.lang.Integer.valueOf(r6);
        r3.a(r4, r6);
    L_0x005c:
        r3 = "MicroMsg.SubCoreVideoControl";
        r4 = "check device support hevc[%d]";
        r6 = new java.lang.Object[r2];
        r7 = java.lang.Integer.valueOf(r0);
        r6[r8] = r7;
        com.tencent.mm.sdk.platformtools.w.d(r3, r4, r6);
        if (r0 > 0) goto L_0x0087;
    L_0x006f:
        r4 = r8;
    L_0x0070:
        if (r4 == 0) goto L_0x0008;
    L_0x0072:
        com.tencent.mm.modelvideo.o.KV();
        r0 = r14.getFileName();
        r0 = com.tencent.mm.modelvideo.s.lv(r0);
        r1 = com.tencent.mm.a.e.aO(r0);
        if (r1 != 0) goto L_0x0134;
    L_0x0083:
        r0 = r5;
        goto L_0x0009;
    L_0x0085:
        r0 = r8;
        goto L_0x004b;
    L_0x0087:
        r0 = com.tencent.mm.u.c.c.Az();
        r3 = "100253";
        r0 = r0.dX(r3);
        r3 = r0.isValid();
        if (r3 == 0) goto L_0x014c;
    L_0x0098:
        r1 = r0.bKK();
        r0 = "openHevc";
        r0 = r1.get(r0);
        r0 = (java.lang.String) r0;
        r3 = com.tencent.mm.sdk.platformtools.bg.getInt(r0, r8);
        r0 = "brands";
        r0 = r1.get(r0);
        r0 = (java.lang.String) r0;
        r4 = "devices";
        r1 = r1.get(r4);
        r1 = (java.lang.String) r1;
    L_0x00bb:
        r7 = android.os.Build.BRAND;
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r4 != 0) goto L_0x014a;
    L_0x00c3:
        r4 = ";";
        r6 = r0.split(r4);
        r9 = r6.length;
        r4 = r8;
    L_0x00cc:
        if (r4 >= r9) goto L_0x014a;
    L_0x00ce:
        r10 = r6[r4];
        r10 = r10.equalsIgnoreCase(r7);
        if (r10 == 0) goto L_0x012e;
    L_0x00d6:
        r4 = r8;
    L_0x00d7:
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r9 = android.os.Build.BRAND;
        r6 = r6.append(r9);
        r9 = android.os.Build.MODEL;
        r6 = r6.append(r9);
        r9 = r6.toString();
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r6 != 0) goto L_0x0106;
    L_0x00f2:
        r6 = ";";
        r10 = r1.split(r6);
        r11 = r10.length;
        r6 = r8;
    L_0x00fb:
        if (r6 >= r11) goto L_0x0106;
    L_0x00fd:
        r12 = r10[r6];
        r12 = r12.equalsIgnoreCase(r9);
        if (r12 == 0) goto L_0x0131;
    L_0x0105:
        r4 = r8;
    L_0x0106:
        if (r3 > 0) goto L_0x0109;
    L_0x0108:
        r4 = r8;
    L_0x0109:
        r6 = "MicroMsg.SubCoreVideoControl";
        r10 = "check support hevc [%b] abtestFlag[%d] brands[%s, %s] device[%s, %s]";
        r11 = 6;
        r11 = new java.lang.Object[r11];
        r12 = java.lang.Boolean.valueOf(r4);
        r11[r8] = r12;
        r3 = java.lang.Integer.valueOf(r3);
        r11[r2] = r3;
        r11[r5] = r7;
        r3 = 3;
        r11[r3] = r0;
        r0 = 4;
        r11[r0] = r9;
        r0 = 5;
        r11[r0] = r1;
        com.tencent.mm.sdk.platformtools.w.i(r6, r10, r11);
        goto L_0x0070;
    L_0x012e:
        r4 = r4 + 1;
        goto L_0x00cc;
    L_0x0131:
        r6 = r6 + 1;
        goto L_0x00fb;
    L_0x0134:
        r0 = com.tencent.mm.modelvideo.q.lp(r0);
        if (r0 == 0) goto L_0x0008;
    L_0x013a:
        r0 = r5;
        goto L_0x0009;
    L_0x013d:
        r1 = com.tencent.mm.plugin.report.service.g.oUh;
        r2 = 354; // 0x162 float:4.96E-43 double:1.75E-321;
        r4 = 131; // 0x83 float:1.84E-43 double:6.47E-322;
        r6 = 1;
        r1.a(r2, r4, r6, r8);
        goto L_0x0027;
    L_0x014a:
        r4 = r2;
        goto L_0x00d7;
    L_0x014c:
        r0 = r1;
        r3 = r8;
        goto L_0x00bb;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelcontrol.d.a(int, com.tencent.mm.modelvideo.r):int");
    }

    public static boolean EC() {
        String str = null;
        com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100253");
        if (dX.isValid()) {
            str = (String) dX.bKK().get("noCompleteRange");
        }
        if (bg.mA(str)) {
            str = "20:00-22:00";
        }
        w.i("MicroMsg.SubCoreVideoControl", "check complete hevc needControl [%b] no complete range[%s]", Boolean.valueOf(b.iT(str)), str);
        return !b.iT(str);
    }

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        this.hzF = null;
        this.hzJ = null;
        this.hzI = null;
        this.hzG = null;
        this.hzH = null;
    }
}
