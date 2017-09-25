package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.media.MediaMetadataRetriever;
import android.os.SystemClock;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class t {
    public static boolean lz(String str) {
        if (str == null) {
            return false;
        }
        r lH = lH(str);
        if (lH == null || lH.iar >= 2500) {
            return false;
        }
        lH.iar++;
        lH.fRW = 16384;
        return e(lH);
    }

    public static boolean lA(String str) {
        g.oUh.a(111, 218, 1, false);
        w.w("MicroMsg.VideoLogic", "setError file:%s stack:[%s]", str, bg.bJZ());
        o.La().fBk.remove(str);
        if (str == null) {
            return false;
        }
        r lH = lH(str);
        if (lH == null) {
            w.e("MicroMsg.VideoLogic", "Set error failed file:" + str);
            return false;
        }
        lH.status = 198;
        lH.ian = System.currentTimeMillis() / 1000;
        lH.fRW = 1280;
        aks com_tencent_mm_protocal_c_aks = lH.iaz;
        com_tencent_mm_protocal_c_aks.tOt = 0;
        lH.iaz = com_tencent_mm_protocal_c_aks;
        boolean e = e(lH);
        w.d("MicroMsg.VideoLogic", "setError file:" + str + " msgid:" + lH.iaq + " old stat:" + lH.status);
        if (lH == null || lH.iaq == 0) {
            return e;
        }
        au cA = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().cA((long) lH.iaq);
        int i = cA.field_type;
        w.i("MicroMsg.VideoLogic", "set error, msg type %d", Integer.valueOf(i));
        if (43 != i && 62 != i) {
            return e;
        }
        c.oTb.a(111, 32, 1, true);
        cA.cH(lH.Le());
        cA.setContent(p.b(lH.Lf(), -1, true));
        w.d("MicroMsg.VideoLogic", "[oneliang][setError]");
        ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().a(cA.field_msgId, cA);
        return e;
    }

    public static boolean lB(String str) {
        r lH = lH(str);
        if (lH == null || lH.iaq == 0) {
            return false;
        }
        au cA = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().cA((long) lH.iaq);
        int i = cA.field_type;
        w.i("MicroMsg.VideoLogic", "ashutest::setBlack, msg type %d", Integer.valueOf(i));
        if (43 != i && 62 != i) {
            return false;
        }
        cA.setContent(p.b(lH.Lf(), (long) lH.iap, false));
        cA.dv(2);
        ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().a((long) lH.iaq, cA);
        lH.status = 197;
        lH.ian = bg.Ny();
        lH.fRW = 1280;
        w.d("MicroMsg.VideoLogic", "[oneliang][setBlack]");
        return e(lH);
    }

    public static boolean b(String str, int i, String str2, String str3) {
        return a(str, i, str2, str3, 0, "", 43);
    }

    public static boolean a(String str, int i, String str2, String str3, int i2, String str4, int i3) {
        return a(str, i, str2, str3, i2, str4, i3, null, "");
    }

    public static boolean a(String str, int i, String str2, String str3, int i2, String str4, int i3, bdu com_tencent_mm_protocal_c_bdu, String str5) {
        r rVar = new r();
        rVar.fyF = str;
        rVar.iap = i;
        rVar.fSf = str2;
        rVar.iah = (String) com.tencent.mm.kernel.h.vI().vr().get(2, (Object) "");
        rVar.iam = bg.Ny();
        rVar.ian = bg.Ny();
        rVar.iav = str4;
        rVar.hXX = str3;
        rVar.iay = com_tencent_mm_protocal_c_bdu;
        rVar.fUY = str5;
        if (!bg.mA(str3)) {
            rVar.iat = 1;
        }
        if (i2 > 0) {
            rVar.iat = 1;
        }
        if (62 == i3) {
            rVar.iaw = 3;
        } else if (i2 > 0) {
            rVar.iaw = 2;
        } else {
            rVar.iaw = 1;
        }
        o.KV();
        int lx = s.lx(s.lv(str));
        if (lx <= 0) {
            w.e("MicroMsg.VideoLogic", "get Video size failed :" + str);
            return false;
        }
        rVar.hrs = lx;
        o.KV();
        String lw = s.lw(str);
        int lx2 = s.lx(lw);
        if (lx2 <= 0) {
            w.e("MicroMsg.VideoLogic", "get Thumb size failed :" + lw + " size:" + lx2);
            return false;
        }
        rVar.ial = lx2;
        w.i("MicroMsg.VideoLogic", "init record file:" + str + " thumbsize:" + rVar.ial + " videosize:" + rVar.hrs + " msgType:" + i3);
        rVar.status = 102;
        au auVar = new au();
        auVar.cH(rVar.Le());
        auVar.setType(i3);
        auVar.dw(1);
        auVar.cI(str);
        auVar.dv(1);
        auVar.z(ay.gk(rVar.Le()));
        rVar.iaq = (int) ay.i(auVar);
        return o.KV().a(rVar);
    }

    public static long a(String str, int i, String str2, String str3, int i2) {
        if (bg.mA(str)) {
            w.w("MicroMsg.VideoLogic", "do prepare, but file name is null, type %d", Integer.valueOf(i2));
            return -1;
        } else if (bg.mA(str2)) {
            w.w("MicroMsg.VideoLogic", "do prepare, but toUser is null, type %d", Integer.valueOf(i2));
            return -1;
        } else {
            int i3;
            r rVar;
            r rVar2 = new r();
            rVar2.fyF = str;
            rVar2.iap = 1;
            rVar2.fSf = str2;
            rVar2.iah = (String) com.tencent.mm.kernel.h.vI().vr().get(2, (Object) "");
            rVar2.iam = bg.Ny();
            rVar2.ian = bg.Ny();
            rVar2.iav = null;
            rVar2.hXX = str3;
            if (!bg.mA(str3)) {
                rVar2.iat = 1;
            }
            if (62 == i2) {
                rVar2.iat = 0;
                i3 = 3;
                rVar = rVar2;
            } else if (rVar2.iat == 0) {
                i3 = 1;
                rVar = rVar2;
            } else {
                i3 = -1;
                rVar = rVar2;
            }
            rVar.iaw = i3;
            rVar2.hrs = 0;
            rVar2.status = MMGIFException.D_GIF_ERR_NO_COLOR_MAP;
            au auVar = new au();
            auVar.cH(rVar2.Le());
            auVar.setType(i2);
            auVar.dw(1);
            auVar.cI(str);
            auVar.dv(8);
            auVar.z(ay.gk(rVar2.Le()));
            long i4 = ay.i(auVar);
            rVar2.iaq = (int) i4;
            if (o.KV().a(rVar2)) {
                return i4;
            }
            return -1;
        }
    }

    public static void i(String str, int i, int i2) {
        r lH = lH(str);
        if (lH == null) {
            w.w("MicroMsg.VideoLogic", "update, but video info is null, fileName %s, msgType %d", str, Integer.valueOf(i2));
            return;
        }
        o.KV();
        w.i("MicroMsg.VideoLogic", "update, video size %d, msgType %d", Integer.valueOf(s.lx(s.lv(str))), Integer.valueOf(i2));
        lH.hrs = r0;
        lH.iap = i;
        aks com_tencent_mm_protocal_c_aks = lH.iaz;
        com_tencent_mm_protocal_c_aks.tOr = false;
        lH.iaz = com_tencent_mm_protocal_c_aks;
        lH.status = 102;
        o.KV();
        lH.ial = s.lx(s.lw(str));
        w.i("MicroMsg.VideoLogic", "update prepare:" + str + " thumbsize:" + lH.ial);
        lH.fRW = 4512;
        w.i("MicroMsg.VideoLogic", "update to db, result %B, msgType %d", Boolean.valueOf(e(lH)), Integer.valueOf(i2));
        au cA = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().cA((long) lH.iaq);
        w.i("MicroMsg.VideoLogic", "before update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", Long.valueOf(cA.field_msgId), Long.valueOf(cA.field_msgSvrId), cA.field_talker, Integer.valueOf(cA.field_type), Integer.valueOf(cA.field_isSend), cA.field_imgPath, Integer.valueOf(cA.field_status), Long.valueOf(cA.field_createTime));
        cA.cH(lH.Le());
        cA.setType(i2);
        cA.dw(1);
        cA.cI(str);
        cA.dv(1);
        w.i("MicroMsg.VideoLogic", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", Long.valueOf(cA.field_msgId), Long.valueOf(cA.field_msgSvrId), cA.field_talker, Integer.valueOf(cA.field_type), Integer.valueOf(cA.field_isSend), cA.field_imgPath, Integer.valueOf(cA.field_status), Long.valueOf(cA.field_createTime));
        ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().a((long) lH.iaq, cA);
    }

    public static int lC(String str) {
        r lH = lH(str);
        if (lH == null) {
            w.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " getinfo failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.sb();
        } else if (lH.status == 102 || lH.status == MMGIFException.D_GIF_ERR_NO_IMAG_DSCR) {
            int i = lH.status;
            if (lH.status == 102 || lH.ial != lH.iak) {
                lH.status = 103;
            } else {
                lH.status = 104;
            }
            w.d("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.g.sd() + "startSend file:" + str + " status:[" + i + "->" + lH.status + "]");
            lH.iao = bg.Ny();
            lH.ian = bg.Ny();
            lH.fRW = 3328;
            if (e(lH)) {
                o.La().run();
                return 0;
            }
            w.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " update failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.sb();
        } else {
            w.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " get status failed: " + str + " status:" + lH.status);
            return 0 - com.tencent.mm.compatible.util.g.sb();
        }
    }

    public static int av(long j) {
        for (r rVar : o.KV().au(j)) {
            int i = rVar.status;
            rVar.status = m.CTRL_INDEX;
            w.d("MicroMsg.VideoLogic", com.tencent.mm.compatible.util.g.sd() + "startSend file:" + rVar.getFileName() + " status:[" + i + "->" + rVar.status + "]");
            rVar.iao = bg.Ny();
            rVar.ian = bg.Ny();
            rVar.fRW = 3328;
            if (!e(rVar)) {
                w.e("MicroMsg.VideoLogic", "ERR on start MassSend:" + com.tencent.mm.compatible.util.g.sd() + " update failed: " + rVar.getFileName());
                return 0 - com.tencent.mm.compatible.util.g.sb();
            }
        }
        com.tencent.mm.kernel.h.vL().D(new Runnable(o.Lb()) {
            final /* synthetic */ m hZz;

            {
                this.hZz = r1;
            }

            public final void run() {
                w.d("MicroMsg.SightMassSendService", "Try Run service runningFlag:" + this.hZz.fBn + " sending:" + this.hZz.fBm);
                if (!this.hZz.fBn) {
                    this.hZz.fBo = 5;
                    this.hZz.fBs.gSO = SystemClock.elapsedRealtime();
                    this.hZz.fBm = false;
                }
                this.hZz.fBn = true;
                this.hZz.fBt.v(10, 10);
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
        return 0;
    }

    public static void c(r rVar) {
        if (rVar == null) {
            w.e("MicroMsg.VideoLogic", "video info is null");
            return;
        }
        au cA = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().cA((long) rVar.iaq);
        int i = cA.field_type;
        w.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMsgInfo, msg type %d", Integer.valueOf(i));
        if (43 == i || 62 == i) {
            cA.dw(1);
            cA.cH(rVar.Le());
            cA.y(rVar.fTQ);
            cA.dv(2);
            cA.setContent(p.b(rVar.Lf(), (long) rVar.iap, false));
            ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().a((long) rVar.iaq, cA);
            w.d("MicroMsg.VideoLogic", "[oneliang][updateWriteFinMsgInfo], msgId:%d", Long.valueOf(cA.field_msgId));
        }
    }

    static boolean d(r rVar) {
        au cA = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().cA((long) rVar.iaq);
        int i = cA.field_type;
        w.i("MicroMsg.VideoLogic", "ashutest::update read fin msg info, msg type %d", Integer.valueOf(i));
        if (43 != i && 62 != i) {
            return false;
        }
        cA.y(rVar.fTQ);
        cA.setContent(p.b(rVar.Lf(), (long) rVar.iap, false));
        cA.cH(rVar.Le());
        w.d("MicroMsg.VideoLogic", "set msg content :" + cA.field_content);
        ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().b(rVar.fTQ, cA);
        w.d("MicroMsg.VideoLogic", "[oneliang][updateReadFinMsgInfo], msgId:%d", Long.valueOf(cA.field_msgId));
        if (cA.bMm()) {
            w.i("MicroMsg.VideoLogic", "on receive sight, sightFileSize %d bytes", Integer.valueOf(rVar.hrs));
        }
        return true;
    }

    public static int lD(String str) {
        r lH = lH(str);
        if (lH == null) {
            w.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " getinfo failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.sb();
        } else if (lH.status == 111 || lH.status == 113 || lH.status == 121 || lH.status == 122) {
            lH.status = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
            lH.iao = bg.Ny();
            lH.ian = bg.Ny();
            lH.fRW = 3328;
            if (e(lH)) {
                o.La().Lt();
                o.La().run();
                return 0;
            }
            w.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " update failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.sb();
        } else {
            w.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " get status failed: " + str + " status:" + lH.status);
            return 0 - com.tencent.mm.compatible.util.g.sb();
        }
    }

    public static int lE(String str) {
        r lH = lH(str);
        if (lH == null) {
            w.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " getinfo failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.sb();
        } else if (lH.status == MMGIFException.D_GIF_ERR_IMAGE_DEFECT || lH.status == 120 || lH.status == 122) {
            lH.status = 113;
            lH.ian = bg.Ny();
            lH.fRW = 1280;
            if (e(lH)) {
                return 0;
            }
            w.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " update failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.sb();
        } else {
            w.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " get status failed: " + str + " status:" + lH.status);
            return 0 - com.tencent.mm.compatible.util.g.sb();
        }
    }

    public static boolean H(String str, int i) {
        int i2 = 0;
        r lH = lH(str);
        if (lH == null) {
            w.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " getinfo failed: " + str);
            return false;
        }
        if (i != lH.hrs) {
            w.w("MicroMsg.VideoLogic", "download video finish, but file size is not equals db size[%d, %d]", Integer.valueOf(i), Integer.valueOf(lH.hrs));
            lH.hrs = i;
            i2 = 32;
        }
        lH.iaj = i;
        lH.ian = bg.Ny();
        d(lH);
        lH.status = 199;
        lH.fRW = i2 | 1296;
        boolean e = e(lH);
        w.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + str + " newsize:" + i + " total:" + lH.hrs + " status:" + lH.status + " netTimes:" + lH.iar + " update ret: " + e);
        return e;
    }

    public static boolean lF(String str) {
        w.i("MicroMsg.VideoLogic", "resetMsgRecv fileName : " + str);
        r rVar = new r();
        rVar.status = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
        rVar.ian = bg.Ny();
        rVar.iao = bg.Ny();
        rVar.fyF = str;
        rVar.fRW = 3328;
        if (!e(rVar)) {
            return false;
        }
        o.La().run();
        return true;
    }

    public static boolean lG(String str) {
        r lH = lH(str);
        if (lH == null) {
            return false;
        }
        w.i("MicroMsg.VideoLogic", "rsetMsgSend %s", str);
        aks com_tencent_mm_protocal_c_aks = lH.iaz;
        if (com_tencent_mm_protocal_c_aks != null) {
            com_tencent_mm_protocal_c_aks.tOt = 0;
            lH.iaz = com_tencent_mm_protocal_c_aks;
        }
        if (lH.iak < lH.ial) {
            lH.status = 103;
        } else {
            lH.status = 104;
        }
        lH.iam = bg.Ny();
        lH.ian = bg.Ny();
        lH.iao = bg.Ny();
        lH.fRW = 536874752;
        if (!e(lH)) {
            return false;
        }
        o.La().run();
        return true;
    }

    public static r lH(String str) {
        if (bg.mA(str)) {
            return null;
        }
        return o.KV().ls(str);
    }

    public static boolean e(r rVar) {
        if (rVar == null) {
            return false;
        }
        if ((rVar.getFileName() == null || rVar.getFileName().length() <= 0) && rVar.fRW == -1) {
            return false;
        }
        return o.KV().b(rVar);
    }

    public static String lI(String str) {
        String str2 = e.gSz + bg.Nz() + ".mp4";
        if (j.ex(str, str2)) {
            return str2;
        }
        return null;
    }

    public static int f(r rVar) {
        if (rVar.hrs == 0) {
            return 0;
        }
        w.d("MicroMsg.VideoLogic", "cdntra getDownloadProgress :" + rVar.iaj + " " + rVar.hrs);
        return (rVar.iaj * 100) / rVar.hrs;
    }

    public static int g(r rVar) {
        if (rVar.hrs == 0) {
            return 0;
        }
        w.d("MicroMsg.VideoLogic", "cdntra getUploadProgress :" + rVar.hYV + " " + rVar.hrs);
        return (rVar.hYV * 100) / rVar.hrs;
    }

    public static boolean lJ(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.VideoLogic", "check short video was replaced, but filename is null.");
            return false;
        }
        w.d("MicroMsg.VideoLogic", "checkShortVideoWasReplaced filename: " + str);
        r lH = lH(str);
        if (lH == null || lH.status != 199) {
            return false;
        }
        int i = lH.hrs;
        o.KV();
        int aN = com.tencent.mm.a.e.aN(s.lv(str));
        w.d("MicroMsg.VideoLogic", "it short video file size[%d] infoLen[%d]", Integer.valueOf(aN), Integer.valueOf(i));
        if (aN <= 0 || Math.abs(aN - i) <= 16) {
            return false;
        }
        w.w("MicroMsg.VideoLogic", "it error short video can not retransmit. file size[%d], video info size[%d]", Integer.valueOf(aN), Integer.valueOf(i));
        String fileName = lH.getFileName();
        g.oUh.a(111, 217, 1, false);
        r lH2 = lH(fileName);
        if (lH2 != null) {
            au cA = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().cA((long) lH2.iaq);
            int i2 = cA.field_type;
            w.i("MicroMsg.VideoLogic", "ashutest::setBroken, msg type %d", Integer.valueOf(i2));
            if (43 == i2 || 62 == i2) {
                cA.setContent(p.b(lH2.Lf(), (long) lH2.iap, false));
                cA.dv(2);
                ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().a((long) lH2.iaq, cA);
                lH2.status = 196;
                lH2.ian = bg.Ny();
                lH2.fRW = 1280;
                w.d("MicroMsg.VideoLogic", "[oneliang][setBroken]");
                e(lH2);
            }
        }
        return true;
    }

    public static int u(int i, String str) {
        int i2;
        long NA = bg.NA();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        if (!o.KY().b(str, pInt, pInt2) || bg.az((long) pInt.value) >= 300) {
            i2 = 0;
        } else {
            i2 = pInt2.value;
        }
        if (i2 < 0 || i2 >= i - 1) {
            i2 = 0;
        }
        w.d("MicroMsg.VideoLogic", "check last play duration result[%d] startTime[%d] filename[%s] cost %d", Integer.valueOf(i2), Integer.valueOf(pInt.value), str, Long.valueOf(bg.aB(NA)));
        return i2;
    }

    public static void d(String str, int i, boolean z) {
        if (bg.mA(str)) {
            w.w("MicroMsg.VideoLogic", "noteVideoPlayHistory error filename[%s]", str);
            return;
        }
        boolean z2;
        if (i < 0) {
            i = 0;
        }
        int i2 = i / 1000;
        long NA = bg.NA();
        long update;
        if (o.KY().lN(str)) {
            w KY = o.KY();
            int Nz = (int) (bg.Nz() / 1000);
            if (!bg.mA(str)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("starttime", Integer.valueOf(Nz));
                contentValues.put("playduration", Integer.valueOf(i2));
                update = (long) KY.gUz.update("VideoPlayHistory", contentValues, "filename=?", new String[]{str});
                w.i("MicroMsg.VideoPlayHistoryStorage", "update video play history ret : " + update);
                if (update > 0) {
                    z2 = true;
                }
            }
            z2 = false;
        } else {
            w KY2 = o.KY();
            int Nz2 = (int) (bg.Nz() / 1000);
            int i3 = z ? 1 : 0;
            if (!bg.mA(str)) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put(FFmpegMetadataRetriever.METADATA_KEY_FILENAME, str);
                contentValues2.put("starttime", Integer.valueOf(Nz2));
                contentValues2.put("playduration", Integer.valueOf(i2));
                contentValues2.put("downloadway", Integer.valueOf(i3));
                update = KY2.gUz.insert("VideoPlayHistory", FFmpegMetadataRetriever.METADATA_KEY_FILENAME, contentValues2);
                w.i("MicroMsg.VideoPlayHistoryStorage", "insert video play history ret : " + update);
                if (update > 0) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        w.d("MicroMsg.VideoLogic", "noteVideoPlayHistory ret %b filename %s playDuration %d isOnlinePlay %b cost %d", Boolean.valueOf(z2), str, Integer.valueOf(i2), Boolean.valueOf(z), Long.valueOf(bg.aB(NA)));
    }

    public static void lK(String str) {
        boolean z = true;
        if (!bg.mA(str)) {
            if (o.KY().gUz.delete("VideoPlayHistory", "filename= ?", new String[]{str}) <= 0) {
                z = false;
            }
            w.d("MicroMsg.VideoLogic", "delete video play history ret : " + z + " filename : " + str);
        }
    }

    public static String e(long j, int i) {
        return j + "_" + i;
    }

    public static int e(long j, String str) {
        int i = -1;
        if (!bg.mA(str)) {
            try {
                String[] split = str.split("_");
                if (split != null && split.length == 2 && bg.getLong(split[0], 0) == j) {
                    i = bg.getInt(split[1], 0);
                }
            } catch (Exception e) {
                w.e("MicroMsg.VideoLogic", "parseEnterVideoOpTips error: " + e.toString());
            }
        }
        return i;
    }

    public static void I(String str, int i) {
        r lH = lH(str);
        if (lH != null) {
            lH.status = 122;
            lH.iao = bg.Ny();
            lH.ian = bg.Ny();
            lH.hzv = i;
            lH.fRW = 268438784;
            w.i("MicroMsg.VideoLogic", "set online video Completion ret: " + o.KV().b(lH) + " status: " + lH.status);
        }
    }

    public static int lL(String str) {
        r lH = lH(str);
        if (lH == null) {
            w.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " getinfo failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.sb();
        } else if (lH.status == 111 || lH.status == 113 || lH.status == 121 || lH.status == 122) {
            int i = 256;
            d.Eu();
            if (d.Ez()) {
                lH.status = 122;
            } else {
                w.w("MicroMsg.VideoLogic", "start complete online video, but can not stream video now!");
                lH.status = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                lH.iaj = 0;
                i = com.tencent.mm.plugin.appbrand.jsapi.f.e.CTRL_INDEX;
            }
            lH.iao = bg.Ny();
            lH.ian = bg.Ny();
            lH.fRW = (i | 2048) | WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
            if (e(lH)) {
                o.La().Lt();
                o.La().run();
                return 0;
            }
            w.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " update failed: " + str);
            return 0 - com.tencent.mm.compatible.util.g.sb();
        } else {
            w.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " get status failed: " + str + " status:" + lH.status);
            return 0 - com.tencent.mm.compatible.util.g.sb();
        }
    }

    public static boolean J(String str, int i) {
        return b(lH(str), i);
    }

    public static boolean b(r rVar, int i) {
        if (rVar == null) {
            return false;
        }
        rVar.hzv = i;
        rVar.fRW = SQLiteDatabase.CREATE_IF_NECESSARY;
        return e(rVar);
    }

    public static boolean a(String str, PInt pInt, PInt pInt2) {
        Throwable e;
        Throwable th;
        if (bg.mA(str)) {
            w.w("MicroMsg.VideoLogic", "get media info but path is null");
            return false;
        }
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                pInt.value = bg.ex((long) bg.getInt(mediaMetadataRetriever.extractMetadata(9), 0));
                pInt2.value = bg.getInt(mediaMetadataRetriever.extractMetadata(20), 0) / 1000;
                mediaMetadataRetriever.release();
            } catch (Exception e2) {
                e = e2;
                try {
                    w.printErrStackTrace("MicroMsg.VideoLogic", e, "get video bitrate error. path %s", str);
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    w.d("MicroMsg.VideoLogic", "video bitrate %d kbps duration %d path %s", Integer.valueOf(pInt2.value), Integer.valueOf(pInt.value), str);
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            mediaMetadataRetriever = null;
            w.printErrStackTrace("MicroMsg.VideoLogic", e, "get video bitrate error. path %s", str);
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            w.d("MicroMsg.VideoLogic", "video bitrate %d kbps duration %d path %s", Integer.valueOf(pInt2.value), Integer.valueOf(pInt.value), str);
            return true;
        } catch (Throwable th3) {
            th = th3;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
        w.d("MicroMsg.VideoLogic", "video bitrate %d kbps duration %d path %s", Integer.valueOf(pInt2.value), Integer.valueOf(pInt.value), str);
        return true;
    }
}
