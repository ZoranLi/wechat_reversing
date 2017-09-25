package com.tencent.mm.modelvideo;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.e.a.iv;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.l;
import com.tencent.mm.y.d;
import java.io.File;
import java.util.HashMap;

public class o implements am {
    private static HashMap<Integer, c> gJr;
    private static af iaa = null;
    private static ae iab = null;
    public static boolean iae = false;
    private u hZT = new u();
    private s hZU;
    private w hZV;
    private a hZW = null;
    private l hZX = null;
    private k hZY = null;
    private m hZZ = null;
    private f iac = null;
    private i iad = null;
    private com.tencent.mm.sdk.b.c<iv> iaf = new com.tencent.mm.sdk.b.c<iv>(this) {
        final /* synthetic */ o iag;

        {
            this.iag = r2;
            this.usg = iv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            iv ivVar = (iv) bVar;
            if (ivVar != null) {
                w.w("MicroMsg.SubCoreVideo", "event audio[%b %d] mediaplayer[%b %d] hadRpt[%b]", Boolean.valueOf(ivVar.fOC.fOD), Integer.valueOf(ivVar.fOC.fOE), Boolean.valueOf(ivVar.fOC.fOF), Integer.valueOf(ivVar.fOC.fOG), Boolean.valueOf(o.iae));
                if (ivVar.fOC.fOD) {
                    g.oUh.a(650, 2, 1, false);
                }
                if (ivVar.fOC.fOF) {
                    g.oUh.a(650, 12, 1, false);
                }
                if (!o.iae && (ivVar.fOC.fOE > 10 || ivVar.fOC.fOG > 10)) {
                    g.oUh.d("mediaLeak", e.qW(), null);
                    o.iae = true;
                }
            }
            return false;
        }
    };

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("VIDEOINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return s.gUx;
            }
        });
        gJr.put(Integer.valueOf("VIDEOPLAYHISTORY_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return w.gUx;
            }
        });
        gJr.put(Integer.valueOf("SIGHTDRAFTSINFO_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return l.gUx;
            }
        });
    }

    public static o KU() {
        return (o) l.o(o.class);
    }

    public static s KV() {
        if (h.vG().uV()) {
            if (KU().hZU == null) {
                KU().hZU = new s(h.vI().gYg);
            }
            return KU().hZU;
        }
        throw new com.tencent.mm.u.b();
    }

    public static f KW() {
        h.vG().uQ();
        if (KU().iac == null) {
            KU().iac = new f();
        }
        if ((com.tencent.mm.modelcdntran.g.Em().hyi == null ? 1 : null) != null) {
            com.tencent.mm.modelcdntran.g.Em().hyi = KU().iac;
        }
        return KU().iac;
    }

    public static i KX() {
        h.vG().uQ();
        if (KU().iad == null) {
            KU().iad = new i();
        }
        return KU().iad;
    }

    public static w KY() {
        if (h.vG().uV()) {
            if (KU().hZV == null) {
                KU().hZV = new w(h.vI().gYg);
            }
            return KU().hZV;
        }
        throw new com.tencent.mm.u.b();
    }

    public static l KZ() {
        if (h.vG().uV()) {
            if (KU().hZX == null) {
                KU().hZX = new l(h.vI().gYg);
            }
            return KU().hZX;
        }
        throw new com.tencent.mm.u.b();
    }

    public static a La() {
        if (h.vG().uV()) {
            if (KU().hZW == null) {
                KU().hZW = new a();
            }
            return KU().hZW;
        }
        throw new com.tencent.mm.u.b();
    }

    public static m Lb() {
        if (h.vG().uV()) {
            if (KU().hZZ == null) {
                KU().hZZ = new m();
            }
            return KU().hZZ;
        }
        throw new com.tencent.mm.u.b();
    }

    private static void Lc() {
        boolean z = false;
        if (iab == null || iaa == null) {
            String str = "MicroMsg.SubCoreVideo";
            String str2 = "check decoder thread available fail, handler[%B] thread[%B] stack[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(iab != null);
            if (iaa != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = bg.bJZ();
            w.w(str, str2, objArr);
            if (iab != null) {
                iab.removeCallbacksAndMessages(null);
            }
            if (iaa != null) {
                iaa.a(null);
            } else {
                iaa = new af("Short-Video-Decoder-Thread-" + System.currentTimeMillis());
            }
            iab = new ae(iaa.nJF.getLooper());
        }
    }

    public static boolean b(Runnable runnable, long j) {
        if (runnable == null) {
            return false;
        }
        Lc();
        if (j > 0) {
            iab.postDelayed(runnable, j);
        } else {
            iab.post(runnable);
        }
        return true;
    }

    public static boolean h(Runnable runnable) {
        if (runnable == null) {
            return true;
        }
        Lc();
        if (iab == null) {
            w.e("MicroMsg.SubCoreVideo", "short video decoder handler is null");
            return false;
        }
        iab.removeCallbacks(runnable);
        return true;
    }

    public final void onAccountRelease() {
        w.i("MicroMsg.SubCoreVideo", "%d onAccountRelease ", Integer.valueOf(hashCode()));
        try {
            if (KU().hZW != null) {
                com.tencent.mm.y.e eVar = KU().hZW;
                eVar.fBo = 0;
                if (eVar.iaZ != null) {
                    eVar.iaZ.pd();
                }
                if (eVar.iba != null) {
                    g gVar = eVar.iba;
                    w.i("MicroMsg.NetSceneUploadVideo", "%s stop %s", gVar.KO(), gVar.hGx);
                    if (!bg.mA(gVar.hGx)) {
                        com.tencent.mm.modelcdntran.g.El().iO(gVar.hGx);
                    }
                    gVar.hYC = true;
                }
                h.vd().b((int) com.tencent.mm.plugin.appbrand.jsapi.g.c.CTRL_INDEX, eVar);
                h.vd().b((int) ck.CTRL_INDEX, eVar);
            }
            if (KU().hZZ != null) {
                m mVar = KU().hZZ;
                mVar.fBo = 0;
                w.i("MicroMsg.SightMassSendService", "stop, cur cdn client id %s", mVar.hZx);
                if (!bg.mA(mVar.hZx)) {
                    com.tencent.mm.modelcdntran.g.El().iO(mVar.hZx);
                }
            }
            if (KU().iad != null) {
                i iVar = KU().iad;
                iVar.stopDownload();
                iVar.hZh.clear();
            }
            if (KU().iac != null) {
                h.vd().b(379, KU().iac);
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SubCoreVideo", e, "", new Object[0]);
        }
        d.c.aA(Integer.valueOf(43));
        d.c.aA(Integer.valueOf(44));
        d.c.aA(Integer.valueOf(62));
        com.tencent.mm.sdk.b.a.urY.c(this.iaf);
        if (iab != null) {
            iab.removeCallbacksAndMessages(null);
        }
        try {
            a La = La();
            w.i("MicroMsg.VideoService", "quitVideoSendThread: %s", La.iaT);
            if (La.iaT != null) {
                try {
                    La.iaT.quit();
                    La.iaV = false;
                    La.iaU = null;
                    La.iaT = null;
                } catch (Exception e2) {
                    w.e("MicroMsg.VideoService", "quitVideoSendThread error: %s", e2.getMessage());
                }
            }
        } catch (Exception e22) {
            w.e("MicroMsg.SubCoreVideo", "onAccountRelease, quitVideoSendThread error: %s", e22.getMessage());
        }
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        w.i("MicroMsg.SubCoreVideo", "%d onAccountPostReset ", Integer.valueOf(hashCode()));
        d.c.a(Integer.valueOf(43), this.hZT);
        d.c.a(Integer.valueOf(44), this.hZT);
        d.c.a(Integer.valueOf(62), this.hZT);
        com.tencent.mm.sdk.b.a.urY.a(this.iaf);
        if (iab != null) {
            iab.removeCallbacksAndMessages(null);
        }
        h.vL().D(new Runnable(this) {
            final /* synthetic */ o iag;

            {
                this.iag = r1;
            }

            public final void run() {
                if (h.vG().uV()) {
                    s KV = o.KV();
                    w.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", "UPDATE videoinfo2 SET status = 198, lastmodifytime = " + (System.currentTimeMillis() / 1000) + " WHERE masssendid > 0  AND status" + " = 200");
                    KV.hnH.eE("videoinfo2", r1);
                    o.KZ().gUz.eE("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 1 WHERE fileStatus = 6");
                    l KZ = o.KZ();
                    if (1209600000 <= 0) {
                        w.w("MicroMsg.SightDraftStorage", "keep 0 sight draft");
                        KZ.gUz.eE("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1");
                    } else {
                        w.i("MicroMsg.SightDraftStorage", "check delete ITEM, create time %d", Long.valueOf(bg.Nz() - 1209600000));
                        KZ.gUz.eE("SightDraftInfo", "UPDATE SightDraftInfo SET fileStatus = 7 WHERE fileStatus = 1 AND createTime < " + r2);
                    }
                    for (j jVar : o.KZ().KS()) {
                        w.i("MicroMsg.SubCoreVideo", "do delete sight draft file, name %s", jVar.field_fileName);
                        com.tencent.mm.loader.stub.b.deleteFile(k.lm(jVar.field_fileName));
                        com.tencent.mm.loader.stub.b.deleteFile(k.ln(jVar.field_fileName));
                    }
                }
            }
        });
        File file = new File(k.KR());
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
    }

    public static String getAccVideoPath() {
        StringBuilder stringBuilder = new StringBuilder();
        h.vJ();
        return stringBuilder.append(h.vI().gYf).append("video/").toString();
    }

    public final void aN(boolean z) {
    }
}
