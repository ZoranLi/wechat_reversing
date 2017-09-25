package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Looper;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.a.e;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting;
import com.tencent.mm.plugin.appbrand.jsapi.bd;
import com.tencent.mm.plugin.appbrand.jsapi.cc;
import com.tencent.mm.plugin.appbrand.jsapi.cs;
import com.tencent.mm.plugin.appbrand.jsapi.map.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class j extends Thread {
    private static HashMap<String, b> svC = new HashMap();
    private static Object svD = new byte[0];
    private static ar svE;
    private Context context;
    private String fJL;
    private Intent intent;
    private boolean isStop;
    private int sCp;
    private a sCq;
    private List<String> svs;
    private List<Integer> svt = new ArrayList();
    private List<String> svu = new ArrayList();
    private List<String> svv = new ArrayList();
    private List<Integer> svw = new ArrayList();

    public interface a {
        void bCH();
    }

    private static final class b implements com.tencent.mm.sdk.platformtools.ar.a {
        String fyF;
        String hXX;
        int sCp;
        String svH;
        int svI;
        VideoTransPara svJ;
        private int svK;
        private int svL;
        private boolean svM;
        private int svN = 0;
        String toUser;

        public final boolean Bn() {
            synchronized (j.svD) {
                Object obj = !j.svC.containsKey(this.fyF) ? 1 : null;
            }
            if (obj == null) {
                obj = t.lH(this.fyF) == null ? 1 : null;
            }
            if (obj != null) {
                w.w("MicroMsg.ImportMultiVideo", "remuxing job has been removed, filename %s", this.fyF);
                return true;
            }
            if (this.svJ == null || this.svJ.isDefault) {
                int[] iArr = new int[2];
                j.b(this.hXX, iArr);
                this.svK = iArr[0];
                this.svL = iArr[1];
            } else {
                this.svK = this.svJ.width;
                this.svL = this.svJ.height;
            }
            PString pString = new PString();
            PInt pInt = new PInt();
            if (((com.tencent.mm.plugin.r.a.a) h.h(com.tencent.mm.plugin.r.a.a.class)).wY().a(this.hXX, pString, pInt) && com.tencent.mm.sdk.platformtools.j.ex(pString.value, this.svH)) {
                w.i("MicroMsg.ImportMultiVideo", "copy remuxing file success, do not remuxing again.");
                this.svI = pInt.value;
                this.svM = true;
                return true;
            }
            long NA = bg.NA();
            if (this.svJ != null) {
                w.i("MicroMsg.ImportMultiVideo", "remuxing new para %s", this.svJ);
                if (com.tencent.mm.plugin.sight.base.b.pty) {
                    this.svJ.hzY = (int) (((double) this.svJ.hzY) * 0.915d);
                }
                this.svI = SightVideoJNI.remuxing(this.hXX, this.svH, this.svK, this.svL, this.svJ.hzY, this.svJ.hzO, 8, this.svJ.hzN, 25.0f, (float) this.svJ.gPE, null, 0, com.tencent.mm.plugin.sight.base.b.pty);
            } else {
                w.w("MicroMsg.ImportMultiVideo", "remuxing but new para is null. %s", this.fyF);
                if (com.tencent.mm.plugin.sight.base.b.pty) {
                    com.tencent.mm.plugin.sight.base.b.ptA = (int) (((double) com.tencent.mm.plugin.sight.base.b.ptA) * 0.915d);
                }
                this.svI = SightVideoJNI.remuxing(this.hXX, this.svH, this.svK, this.svL, com.tencent.mm.plugin.sight.base.b.ptA, com.tencent.mm.plugin.sight.base.b.ptz, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.b.ptB, null, 0, com.tencent.mm.plugin.sight.base.b.pty);
            }
            this.svN = (int) bg.aB(NA);
            w.i("MicroMsg.ImportMultiVideo", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", this.hXX, this.svH, Integer.valueOf(this.svI), Integer.valueOf(this.svK), Integer.valueOf(this.svL));
            this.svM = this.svI >= 0;
            PInt pInt2 = new PInt();
            if (t.a(this.svH, pInt2, new PInt())) {
                this.svI = pInt2.value;
            }
            if (this.svM) {
                w.i("MicroMsg.ImportMultiVideo", "remuxing video sucess,insert to media duplication storage");
                try {
                    String name = new File(this.svH).getName();
                    String str = this.svH + ".tmp";
                    PInt pInt3 = new PInt(0);
                    if (d.b(this.svH, str, pInt3)) {
                        boolean deleteFile = com.tencent.mm.loader.stub.b.deleteFile(this.svH);
                        File file = new File(str);
                        boolean h = e.h(file.getParent() + File.separator, file.getName(), name);
                        w.i("MicroMsg.ImportMultiVideo", "fast start success. delOld[%b] rename[%b] path[%s] target[%s]", Boolean.valueOf(deleteFile), Boolean.valueOf(h), file.getAbsolutePath(), this.svH);
                        g.oUh.a(354, 30, 1, false);
                    } else {
                        if (pInt3.value != 1) {
                            g.oUh.a(354, 31, 1, false);
                        } else {
                            g.oUh.a(354, 32, 1, false);
                            g.oUh.i(13836, Integer.valueOf(600), Long.valueOf(bg.Ny()), this.svH);
                        }
                        w.i("MicroMsg.ImportMultiVideo", "fast start fail. msg[%d] importpath[%s] targetPath[%s]", Integer.valueOf(pInt3.value), this.hXX, this.svH);
                    }
                    ((com.tencent.mm.plugin.r.a.a) h.h(com.tencent.mm.plugin.r.a.a.class)).wY().H(this.hXX, this.svH, this.svI);
                } catch (Exception e) {
                    w.e("MicroMsg.ImportMultiVideo", "fast start exception e[%s]", e.toString());
                }
            } else {
                w.w("MicroMsg.ImportMultiVideo", "remuxing video error, copy source video to send.");
                com.tencent.mm.loader.stub.b.deleteFile(this.svH);
                com.tencent.mm.sdk.platformtools.j.p(this.hXX, this.svH, false);
            }
            return true;
        }

        public final boolean Bo() {
            int i;
            int i2;
            synchronized (j.svD) {
                j.svC.remove(this.fyF);
            }
            if (this.svM) {
                j.cs(this.svH, this.sCp);
            } else {
                j.cr(this.svH, this.sCp);
            }
            j.d(this.svM, this.hXX, this.svH);
            if (com.tencent.mm.plugin.sight.base.b.pty) {
                i = 1;
            } else {
                i = 0;
            }
            j.a(i, this.svN, this.hXX, this.svH, this.svI);
            if (this.sCp == 1) {
                i2 = 8;
            } else {
                i2 = 1;
            }
            n.KT().a(this.hXX, this.svH, this.toUser, "", "", i2, this.svM ? 1 : 3);
            t.i(this.fyF, this.svI, 43);
            t.lC(this.fyF);
            return false;
        }
    }

    static /* synthetic */ void a(int i, int i2, String str, String str2, int i3) {
        long aN = (long) e.aN(str);
        if (aN > 0) {
            int aN2 = (int) ((100 * ((long) e.aN(str2))) / aN);
            w.i("MicroMsg.ImportMultiVideo", "kv report video compression isNew[%d], oriSize[%d], remuxingSize[%d], compressionRatio[%d], bitrate[%d], preset[%d], retDuration[%d]", Integer.valueOf(i), Long.valueOf(aN), Long.valueOf((long) e.aN(str2)), Integer.valueOf(aN2), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3));
            g.oUh.i(13432, Integer.valueOf(i), Long.valueOf(aN), Long.valueOf(r2), Integer.valueOf(aN2), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3));
            return;
        }
        w.e("MicroMsg.ImportMultiVideo", "file canot be empty");
    }

    static /* synthetic */ void cs(String str, int i) {
        if (i == 2) {
            long aN = (long) e.aN(str);
            int f = bg.f((Integer) g.a((int) (aN / AppSupportContentFlag.MMAPP_SUPPORT_XLS), new int[]{512, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2048, 5120, 8192, 10240, 15360, 20480}, (int) bd.CTRL_INDEX, 255));
            g.oUh.a(106, (long) f, 1, false);
            g.oUh.a(106, 246, 1, false);
            w.d("MicroMsg.ImportMultiVideo", "report compress video report id : " + f + " file len : " + (aN / AppSupportContentFlag.MMAPP_SUPPORT_XLS) + "K");
        }
    }

    public j(Context context, List<String> list, Intent intent, String str, int i, a aVar) {
        this.context = context;
        this.svs = list;
        this.intent = intent;
        this.sCq = aVar;
        this.fJL = str;
        this.sCp = i;
    }

    public final void run() {
        if (this.svs == null || this.svs.size() <= 0) {
            u(this.context, this.intent);
        } else {
            for (int i = 0; i < this.svs.size() && !this.isStop; i++) {
                w.i("MicroMsg.ImportMultiVideo", "start to import %s", this.svs.get(i));
                Intent intent = new Intent();
                intent.setData(Uri.parse("file://" + ((String) this.svs.get(i))));
                u(this.context, intent);
            }
        }
        if (this.sCq != null && !this.isStop) {
            af.v(new Runnable(this) {
                final /* synthetic */ j sCr;

                {
                    this.sCr = r1;
                }

                public final void run() {
                    a e = this.sCr.sCq;
                    this.sCr.svt;
                    this.sCr.svu;
                    this.sCr.svv;
                    this.sCr.svw;
                    e.bCH();
                }
            });
        }
    }

    private void u(Context context, Intent intent) {
        String lu = s.lu((String) h.vI().vr().get(2, (Object) ""));
        o.KV();
        String lw = s.lw(lu);
        o.KV();
        String lv = s.lv(lu);
        boolean is2G = am.is2G(ab.getContext());
        String h = com.tencent.mm.compatible.i.a.h(context, intent);
        if (bg.mA(h)) {
            w.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
            a(-50005, lu, h, 0, null, intent);
            return;
        }
        VideoTransPara videoTransPara;
        int i;
        Object obj;
        int i2;
        com.tencent.mm.compatible.i.a.a i3;
        boolean mD = c.mD(h);
        int aN = e.aN(h);
        if (mD) {
            VideoTransPara videoTransPara2;
            PInt pInt = new PInt();
            if (com.tencent.mm.modelcontrol.d.Eu().iV(h)) {
                w.i("MicroMsg.ImportMultiVideo", "check remuxing, this video had wx meta do not remuxing. %s ", h);
                pInt.value = 1;
                g.oUh.a(422, 51, 1, false);
                videoTransPara2 = null;
            } else {
                VideoTransPara videoTransPara3 = new VideoTransPara();
                PInt pInt2 = new PInt();
                PInt pInt3 = new PInt();
                PInt pInt4 = new PInt();
                PInt pInt5 = new PInt();
                PInt pInt6 = new PInt();
                com.tencent.mm.plugin.sight.base.d.a(h, pInt2, pInt3, pInt4, pInt5, pInt6);
                videoTransPara3.duration = pInt2.value / 1000;
                videoTransPara3.width = pInt3.value;
                videoTransPara3.height = pInt4.value;
                videoTransPara3.gPE = pInt5.value;
                videoTransPara3.hzY = pInt6.value;
                w.d("MicroMsg.ImportMultiVideo", "check remuxing old para %s", videoTransPara3);
                videoTransPara2 = com.tencent.mm.modelcontrol.d.Eu().a(videoTransPara3);
                if (videoTransPara2 == null) {
                    w.i("MicroMsg.ImportMultiVideo", "get C2C album video para is null. old para %s", videoTransPara3);
                    pInt.value = -5;
                    videoTransPara2 = null;
                } else {
                    w.d("MicroMsg.ImportMultiVideo", "check remuxing new para %s", videoTransPara2);
                    if (videoTransPara3.hzY <= 640000 || videoTransPara2.hzY > videoTransPara3.hzY) {
                        w.i("MicroMsg.ImportMultiVideo", "new bitrate is bigger than old bitrate %s %s", videoTransPara2, videoTransPara3);
                        pInt.value = 1;
                        videoTransPara2 = null;
                    } else if (videoTransPara3.gPE < 45 || videoTransPara3.duration * 1000 < 180000) {
                        boolean is2G2 = am.is2G(ab.getContext());
                        pInt.value = SightVideoJNI.shouldRemuxing(h, videoTransPara2.width, videoTransPara2.height, is2G2 ? 10485760 : 20971520, is2G2 ? 60000.0d : 300000.0d, Constants.MAX_BUFFER_SIZE);
                    } else {
                        pInt.value = -6;
                        videoTransPara2 = null;
                    }
                }
            }
            videoTransPara = videoTransPara2;
            i = pInt.value;
        } else {
            if (aN > (is2G ? 10485760 : 20971520)) {
                i = -5;
                videoTransPara = null;
            } else {
                i = 1;
                videoTransPara = null;
            }
        }
        w.i("MicroMsg.ImportMultiVideo", "check remuxing, ret %d isMp4 %b length %d", Integer.valueOf(i), Boolean.valueOf(mD), Integer.valueOf(aN));
        switch (i) {
            case -6:
            case -4:
            case -3:
            case -2:
                a(-50002, lu, h, 0, null, intent);
                return;
            case -5:
                a(-50008, lu, h, 0, null, intent);
                return;
            case -1:
                a(-50007, lu, h, 0, null, intent);
                return;
            case 0:
                obj = 1;
                i2 = 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                if (aN <= 20971520) {
                    obj = null;
                    i2 = 0;
                    break;
                }
                a(-50002, lu, h, 0, null, intent);
                obj = null;
                i2 = -50002;
                break;
            default:
                w.e("MicroMsg.ImportMultiVideo", "unknown check type");
                a(-50001, lu, h, 0, null, intent);
                return;
        }
        com.tencent.mm.compatible.i.a.a aVar = null;
        try {
            i3 = com.tencent.mm.compatible.i.a.i(context, intent);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ImportMultiVideo", e, "", new Object[0]);
            i3 = aVar;
        }
        if (i3 == null) {
            w.e("MicroMsg.ImportMultiVideo", "GetVideoMetadata filed.");
            a(-50005, lu, h, 0, null, intent);
            return;
        }
        if (obj == null) {
            com.tencent.mm.sdk.platformtools.j.p(h, lv, false);
            cr(lv, this.sCp);
            d(false, h, lv);
        } else {
            i2 = -50006;
        }
        int ex = bg.ex((long) i3.duration);
        Object obj2 = 1;
        if (i3.bitmap != null) {
            try {
                com.tencent.mm.sdk.platformtools.d.a(i3.bitmap, 60, CompressFormat.JPEG, lw, true);
                obj2 = null;
                ji(true);
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.ImportMultiVideo", e2, "", new Object[0]);
            }
        }
        if (obj2 != null) {
            try {
                ji(false);
                com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.U(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, lw, true);
            } catch (Throwable e22) {
                w.printErrStackTrace("MicroMsg.ImportMultiVideo", e22, "", new Object[0]);
            }
        }
        if (obj == null && !e.aO(lv)) {
            i2 = -50003;
        }
        if (!e.aO(lw)) {
            i2 = -50004;
        }
        a(i2, lu, h, ex, videoTransPara, intent);
    }

    public final void bCF() {
        this.isStop = true;
        interrupt();
    }

    private void a(int i, String str, String str2, int i2, VideoTransPara videoTransPara, Intent intent) {
        w.i("MicroMsg.ImportMultiVideo", "finish to import %s to %s | ret %d | duration %d", str2, str, Integer.valueOf(i), Integer.valueOf(i2));
        d(i, str, str2, i2);
        int i3;
        if (i == -50002) {
            i3 = this.sCp == 1 ? cs.CTRL_INDEX : 245;
            w.d("MicroMsg.ImportMultiVideo", "report video too big reportId : " + i3 + " importType : " + this.sCp);
            g.oUh.a(106, (long) i3, 1, false);
            a(this.fJL, str, str2, intent, i2, (int) k.CTRL_INDEX);
        } else if (i == -50008) {
            g.oUh.a(106, 210, 1, false);
            a(this.fJL, str, str2, intent, i2, (int) com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX);
        } else if (i == -50006) {
            if (t.a(str, 1, this.fJL, str2, 43) < 0) {
                a(this.fJL, str, str2, intent, i2, 142);
                w.e("MicroMsg.ImportMultiVideo", "prepare");
                return;
            }
            if (svE == null) {
                svE = new ar(5, "remuxing-thread-" + System.currentTimeMillis(), 1, Looper.getMainLooper());
            }
            com.tencent.mm.sdk.platformtools.ar.a bVar = new b();
            synchronized (svD) {
                svC.put(str, bVar);
            }
            bVar.fyF = str;
            bVar.hXX = str2;
            o.KV();
            bVar.svH = s.lv(str);
            bVar.sCp = this.sCp;
            bVar.toUser = this.fJL;
            bVar.svJ = videoTransPara;
            svE.c(bVar);
        } else if (i < 0) {
            i3 = this.sCp == 1 ? cc.CTRL_INDEX : com.tencent.mm.plugin.appbrand.jsapi.f.d.a.CTRL_INDEX;
            w.d("MicroMsg.ImportMultiVideo", "report video file error reportId : " + i3 + " importType : " + this.sCp);
            g.oUh.a(106, (long) i3, 1, false);
            a(this.fJL, str, str2, intent, i2, 142);
        } else {
            t.b(str, i2, this.fJL, str2);
            t.lC(str);
            int i4 = this.sCp == 1 ? 8 : 1;
            o.KV();
            n.KT().a(str2, s.lv(str), this.fJL, "", "", i4, 2);
        }
    }

    private void a(String str, String str2, String str3, Intent intent, int i, int i2) {
        ce auVar = new au();
        auVar.dv(5);
        auVar.cH(str);
        auVar.z(ay.gk(str));
        auVar.dw(1);
        auVar.cI(str2);
        auVar.setType(43);
        long L = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().L(auVar);
        w.i("MicroMsg.ImportMultiVideo", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", Long.valueOf(auVar.field_msgId), Long.valueOf(auVar.field_msgSvrId), auVar.field_talker, Integer.valueOf(auVar.field_type), Integer.valueOf(auVar.field_isSend), auVar.field_imgPath, Integer.valueOf(auVar.field_status), Long.valueOf(auVar.field_createTime));
        if (-1 == L) {
            w.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] :%s", str);
        } else if (t.lH(str2) == null) {
            o.KV();
            String lw = s.lw(str2);
            try {
                com.tencent.mm.compatible.i.a.a i3 = com.tencent.mm.compatible.i.a.i(this.context, intent);
                int lx;
                int lx2;
                r rVar;
                if (i3 == null || i3.bitmap == null) {
                    com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.U(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, lw, true);
                    lx = s.lx(lw);
                    o.KV();
                    lx2 = s.lx(s.lv(str2));
                    rVar = new r();
                    rVar.fyF = str2;
                    if (lx2 <= 0) {
                        lx2 = 0;
                    }
                    rVar.hrs = lx2;
                    rVar.ial = lx;
                    rVar.iap = i;
                    rVar.fSf = str;
                    rVar.iah = (String) h.vI().vr().get(2, (Object) "");
                    rVar.iam = bg.Ny();
                    rVar.ian = bg.Ny();
                    rVar.iav = null;
                    rVar.hXX = str3;
                    if (!bg.mA(str3)) {
                        rVar.iat = 1;
                    }
                    rVar.iaw = -1;
                    rVar.status = i2;
                    rVar.iaq = (int) L;
                    if (!o.KV().a(rVar)) {
                        w.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] localMsgId:%s", Long.valueOf(L));
                    }
                }
                i = bg.ex((long) i3.duration);
                com.tencent.mm.sdk.platformtools.d.a(i3.bitmap, 60, CompressFormat.JPEG, lw, true);
                lx = s.lx(lw);
                o.KV();
                lx2 = s.lx(s.lv(str2));
                rVar = new r();
                rVar.fyF = str2;
                if (lx2 <= 0) {
                    lx2 = 0;
                }
                rVar.hrs = lx2;
                rVar.ial = lx;
                rVar.iap = i;
                rVar.fSf = str;
                rVar.iah = (String) h.vI().vr().get(2, (Object) "");
                rVar.iam = bg.Ny();
                rVar.ian = bg.Ny();
                rVar.iav = null;
                rVar.hXX = str3;
                if (bg.mA(str3)) {
                    rVar.iat = 1;
                }
                rVar.iaw = -1;
                rVar.status = i2;
                rVar.iaq = (int) L;
                if (!o.KV().a(rVar)) {
                    w.e("MicroMsg.ImportMultiVideo", "[insertErrMsg] localMsgId:%s", Long.valueOf(L));
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ImportMultiVideo", e, "", new Object[0]);
            }
        }
    }

    public static void b(String str, int[] iArr) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        int i = bg.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
        int i2 = bg.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
        iArr[0] = i;
        iArr[1] = i2;
        int i3 = 0;
        while (i3 < 3) {
            if (i % 2 == 0 && i2 % 2 == 0) {
                if ((i >= i2 && (i <= 640 || i2 <= 480)) || (i <= i2 && (i <= 480 || i2 <= 640))) {
                    break;
                }
                i /= 2;
                i2 /= 2;
                i3++;
            } else {
                return;
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private synchronized void d(int i, String str, String str2, int i2) {
        this.svt.add(Integer.valueOf(i));
        this.svu.add(str);
        this.svv.add(str2);
        this.svw.add(Integer.valueOf(i2));
    }

    public static void bCG() {
        synchronized (svD) {
            int size = svC.size();
            svC.clear();
        }
        if (svE == null) {
            w.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, worker is null, setCount %d", Integer.valueOf(size));
            return;
        }
        w.i("MicroMsg.ImportMultiVideo", "do clear remuxing job, setCount %d, workerJobCount %d", Integer.valueOf(size), Integer.valueOf(svE.uuS.size()));
        svE.uuS.clear();
        svE = null;
    }

    public static boolean LS(String str) {
        boolean containsKey;
        synchronized (svD) {
            containsKey = svC.containsKey(str);
        }
        w.i("MicroMsg.ImportMultiVideo", "check %s is remuxing, ret %B", str, Boolean.valueOf(containsKey));
        return containsKey;
    }

    public static void LT(String str) {
        boolean z = true;
        synchronized (svD) {
            if (svC.remove(str) == null) {
                z = false;
            }
            w.i("MicroMsg.ImportMultiVideo", "remove remuxing job, filename %s, ret %B", str, Boolean.valueOf(z));
        }
    }

    private void ji(boolean z) {
        int i;
        if (this.sCp == 1) {
            if (z) {
                i = com.tencent.mm.plugin.appbrand.jsapi.e.b.CTRL_INDEX;
            } else {
                i = 218;
            }
        } else if (z) {
            i = 231;
        } else {
            i = 232;
        }
        w.d("MicroMsg.ImportMultiVideo", "report video thumb reportId : " + i + " had Thumb : " + z + " importType : " + this.sCp);
        g.oUh.a(106, (long) i, 1, false);
    }

    private static void cr(String str, int i) {
        int i2;
        int i3;
        int i4;
        if (i == 1) {
            i2 = 219;
            i3 = JsApiOpenWeRunSetting.CTRL_INDEX;
            i4 = 220;
        } else {
            i2 = 233;
            i3 = 242;
            i4 = 234;
        }
        long aN = (long) e.aN(str);
        i3 = bg.f((Integer) g.a((int) (aN / AppSupportContentFlag.MMAPP_SUPPORT_XLS), new int[]{512, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2048, 5120, 8192, 10240, 15360, 20480}, i4, i3));
        g.oUh.a(106, (long) i3, 1, false);
        g.oUh.a(106, (long) i2, 1, false);
        w.d("MicroMsg.ImportMultiVideo", "report no compress video report id : " + i3 + " file len : " + (aN / AppSupportContentFlag.MMAPP_SUPPORT_XLS) + "K");
    }

    private static void d(boolean z, String str, String str2) {
        int i = 1;
        if (!z) {
            i = 0;
        }
        if (bg.mA(str) || bg.mA(str2)) {
            w.w("MicroMsg.AtomStatUtil", "report video remuxing but path is null.");
            return;
        }
        try {
            long aN = (long) e.aN(str);
            long aN2 = (long) e.aN(str2);
            int i2 = (int) ((100 * aN2) / aN);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i).append(";").append(aN).append(";");
            stringBuilder.append(aN2).append(";").append(i2);
            w.d("MicroMsg.AtomStatUtil", "report video remuxing : " + stringBuilder.toString());
            g.oUh.i(11098, Integer.valueOf(8001), r0);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.AtomStatUtil", e, "", new Object[0]);
            w.e("MicroMsg.AtomStatUtil", "reportVideoRemuxing error : " + e.toString());
        }
    }
}
