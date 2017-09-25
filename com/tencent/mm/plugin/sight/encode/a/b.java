package com.tencent.mm.plugin.sight.encode.a;

import android.database.Cursor;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public final class b {

    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ int hMC = -1;
        final /* synthetic */ a pwR;

        AnonymousClass2(a aVar, int i) {
            this.pwR = aVar;
        }

        public final void run() {
        }
    }

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String fxL;
        final /* synthetic */ String iMk;
        final /* synthetic */ a pwR;
        final /* synthetic */ int pwS;
        final /* synthetic */ b pwT;

        public AnonymousClass3(b bVar, String str, a aVar, String str2, int i) {
            this.pwT = bVar;
            this.fxL = str;
            this.pwR = aVar;
            this.iMk = str2;
            this.pwS = i;
        }

        public final void run() {
            w.i("MicroMsg.SightRecorderHelper", "do prepare sight message for %s", new Object[]{this.fxL});
            String lu = s.lu(this.fxL);
            if (-1 == t.a(lu, 1, this.fxL, null, 62)) {
                w.e("MicroMsg.SightRecorderHelper", "prepare sight error, filename %s", new Object[]{lu});
                b.a(this.pwR, -1);
                return;
            }
            String Eo = d.Eo(this.iMk);
            if (!e.aO(Eo)) {
                w.w("MicroMsg.SightRecorderHelper", "thumb data not found, try to create thumb");
                try {
                    com.tencent.mm.sdk.platformtools.d.a(d.J(this.iMk, 320, 240), 60, CompressFormat.JPEG, Eo, true);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.SightRecorderHelper", e, "", new Object[0]);
                    w.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
                }
            }
            o.KV();
            e.p(Eo, s.lw(lu));
            o.KV();
            w.i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightFileSize %d bytes", new Object[]{this.fxL, Long.valueOf(e.p(this.iMk, s.lv(lu)))});
            if (e.p(this.iMk, s.lv(lu)) <= 0) {
                w.e("MicroMsg.SightRecorderHelper", "copy remux video path from %s to %s error", new Object[]{this.iMk, r0});
                b.a(this.pwR, -1);
                t.lA(lu);
                return;
            }
            t.i(lu, this.pwS, 62);
            t.lC(lu);
            a aVar = this.pwR;
            if (aVar != null) {
                af.v(new AnonymousClass2(aVar, -1));
            }
            com.tencent.mm.loader.stub.b.deleteFile(this.iMk);
            com.tencent.mm.loader.stub.b.deleteFile(Eo);
        }
    }

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ String iMk;
        final /* synthetic */ a pwR;
        final /* synthetic */ int pwS;
        final /* synthetic */ b pwT;
        final /* synthetic */ List pwU;
        final /* synthetic */ String pwV;

        public AnonymousClass4(b bVar, String str, List list, String str2, a aVar, int i) {
            this.pwT = bVar;
            this.iMk = str;
            this.pwU = list;
            this.pwV = str2;
            this.pwR = aVar;
            this.pwS = i;
        }

        public final void run() {
            int i;
            long j;
            String Eo = d.Eo(this.iMk);
            if (!e.aO(Eo)) {
                w.w("MicroMsg.SightRecorderHelper", "thumb data not found, try to create thumb");
                try {
                    com.tencent.mm.sdk.platformtools.d.a(d.J(this.iMk, 320, 240), 60, CompressFormat.JPEG, Eo, true);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.SightRecorderHelper", e, "", new Object[0]);
                    w.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String) this.pwU.get(0));
            for (i = 1; i < this.pwU.size(); i++) {
                stringBuilder.append(',');
                stringBuilder.append((String) this.pwU.get(i));
            }
            String stringBuilder2 = stringBuilder.toString();
            Cursor a = o.KV().hnH.a("SELECT MAX(masssendid) FROM videoinfo2", null, 2);
            if (a == null) {
                j = 0;
            } else {
                j = 0;
                if (a.moveToFirst()) {
                    j = a.getLong(0);
                }
                a.close();
            }
            long j2 = 1 + j;
            for (i = 0; i < this.pwU.size(); i++) {
                String str = (String) this.pwU.get(i);
                w.i("MicroMsg.SightRecorderHelper", "do prepare sight message for %s, massSendId %d, massSendList %s, videoMD5 %s", new Object[]{str, Long.valueOf(j2), stringBuilder2, this.pwV});
                String lu = s.lu(str);
                o.KV();
                String lw = s.lw(lu);
                o.KV();
                String lv = s.lv(lu);
                w.i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightThumbSize %d bytes", new Object[]{str, Long.valueOf(e.p(Eo, lw))});
                if (e.p(Eo, lw) <= 0) {
                    w.e("MicroMsg.SightRecorderHelper", "copy remux thumb path from %s to %s error, index %d", new Object[]{Eo, lw, Integer.valueOf(i)});
                    b.a(this.pwR, i);
                } else {
                    w.i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightFileSize %d bytes", new Object[]{str, Long.valueOf(e.p(this.iMk, lv))});
                    if (e.p(this.iMk, lv) <= 0) {
                        w.e("MicroMsg.SightRecorderHelper", "copy remux video path from %s to %s error, index %d", new Object[]{this.iMk, lv, Integer.valueOf(i)});
                        b.a(this.pwR, i);
                    } else {
                        int i2 = this.pwS;
                        lv = this.pwV;
                        r rVar = new r();
                        rVar.fyF = lu;
                        rVar.iap = i2;
                        rVar.fSf = str;
                        rVar.iah = (String) h.vI().vr().get(2, "");
                        rVar.iam = bg.Ny();
                        rVar.ian = bg.Ny();
                        rVar.iav = null;
                        rVar.hXX = null;
                        rVar.iat = 0;
                        rVar.iaw = 3;
                        o.KV();
                        int lx = s.lx(s.lv(lu));
                        if (lx <= 0) {
                            w.e("MicroMsg.VideoLogic", "initMassSendSight::get Video size failed:" + lu);
                        } else {
                            rVar.hrs = lx;
                            o.KV();
                            str = s.lw(lu);
                            i2 = s.lx(str);
                            if (i2 <= 0) {
                                w.e("MicroMsg.VideoLogic", "get Thumb size failed :" + str + " size:" + i2);
                            } else {
                                rVar.ial = i2;
                                w.i("MicroMsg.VideoLogic", "initMassSendSight file:" + lu + " thumbsize:" + rVar.ial + " videosize:" + rVar.hrs);
                                rVar.status = m.CTRL_INDEX;
                                w.i("MicroMsg.VideoLogic", "massSendId %d, videoMD5 %s, massSendList %s", new Object[]{Long.valueOf(j2), lv, stringBuilder2});
                                rVar.iax = stringBuilder2;
                                rVar.hYG = j2;
                                rVar.fVC = lv;
                                o.KV().a(rVar);
                            }
                        }
                    }
                }
            }
            t.av(j2);
            com.tencent.mm.loader.stub.b.deleteFile(this.iMk);
            com.tencent.mm.loader.stub.b.deleteFile(Eo);
        }
    }

    public interface a {
        void onError(int i);
    }

    public static void a(final a aVar, final int i) {
        if (aVar != null) {
            af.v(new Runnable() {
                public final void run() {
                    aVar.onError(i);
                }
            });
        }
    }
}
