package com.tencent.mm.modelvideo;

import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.b;
import com.tencent.mm.u.o;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i implements a {
    public LinkedList<au> hZh = new LinkedList();
    long hZi = 0;
    private int hZj = 0;
    private int hZk = 0;
    public boolean hZl = false;
    public boolean hZm = false;
    private boolean hZn = false;
    private boolean hZo = false;
    public f hZp = null;
    long hZq = 0;

    public final void stopDownload() {
        w.i("MicroMsg.PreloadVideoService", "%d stop download", Integer.valueOf(hashCode()));
        h.vL().D(new Runnable(this) {
            final /* synthetic */ i hZr;

            {
                this.hZr = r1;
            }

            public final void run() {
                if (this.hZr.hZp != null) {
                    this.hZr.hZp.stop();
                }
                this.hZr.hZp = null;
            }
        });
    }

    public final void KP() {
        h.vL().D(new Runnable(this) {
            final /* synthetic */ i hZr;

            {
                this.hZr = r1;
            }

            public final void run() {
                if (!o.La().fBl && this.hZr.hZp == null && !this.hZr.hZl && !this.hZr.hZm) {
                    if (this.hZr.hZh.isEmpty()) {
                        Object obj;
                        i iVar = this.hZr;
                        if (bg.az(iVar.hZq) > 600) {
                            iVar.hZq = bg.Ny();
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            this.hZr.KQ();
                            return;
                        }
                        return;
                    }
                    ce ceVar = null;
                    PBool pBool = new PBool();
                    synchronized (this.hZr.hZh) {
                        Iterator it = this.hZr.hZh.iterator();
                        while (it.hasNext()) {
                            Object obj2;
                            ceVar = (au) it.next();
                            i iVar2 = this.hZr;
                            if (ceVar == null) {
                                pBool.value = true;
                                obj2 = null;
                            } else {
                                r lH = t.lH(ceVar.field_imgPath);
                                if (lH != null && lH.Lk()) {
                                    w.i("MicroMsg.PreloadVideoService", "%d it finish download all file[%s], needn't preload", Integer.valueOf(iVar2.hashCode()), lH.getFileName());
                                    String str = (String) bh.q(lH.Lh(), "msg").get(".msg.videomsg.$newmd5");
                                    boolean dH = o.dH(lH.Le());
                                    iVar2.a(str, dH ? 2 : 1, (long) lH.hrs);
                                    g.oUh.a(354, 146, 1, false);
                                    if (dH) {
                                        g.oUh.a(354, 126, 1, false);
                                    } else {
                                        g.oUh.a(354, 125, 1, false);
                                    }
                                    pBool.value = true;
                                    obj2 = null;
                                } else if (bg.aA(ceVar.field_createTime) >= 86400000) {
                                    w.i("MicroMsg.PreloadVideoService", "%d more than 1 day don't preload", Integer.valueOf(iVar2.hashCode()));
                                    pBool.value = true;
                                    obj2 = null;
                                } else {
                                    if (iVar2.bu(true)) {
                                        w.i("MicroMsg.PreloadVideoService", "%d check c2c video preload timestamp[%d]", Integer.valueOf(iVar2.hashCode()), Long.valueOf(iVar2.hZi));
                                    } else {
                                        w.i("MicroMsg.PreloadVideoService", "%d check c2c video preload %d %s", Integer.valueOf(iVar2.hashCode()), Long.valueOf(ceVar.field_msgId), ceVar.gxF);
                                        b gm = ay.gm(ceVar.gxF);
                                        if (gm == null) {
                                            pBool.value = true;
                                            obj2 = null;
                                        } else if (gm.hna <= 0) {
                                            pBool.value = true;
                                            obj2 = null;
                                        } else if (!com.tencent.mm.modelcontrol.b.iT(gm.hnc)) {
                                            int i;
                                            if (am.isWifi(ab.getContext())) {
                                                i = gm.hnb | 1;
                                            } else if (am.is4G(ab.getContext())) {
                                                i = gm.hnb | 2;
                                            } else if (am.is3G(ab.getContext())) {
                                                i = gm.hnb | 4;
                                            } else {
                                                pBool.value = false;
                                                obj2 = null;
                                            }
                                            if (i > 0) {
                                                pBool.value = false;
                                                obj2 = 1;
                                            }
                                        }
                                    }
                                    pBool.value = false;
                                    obj2 = null;
                                }
                            }
                            if (pBool.value) {
                                it.remove();
                            }
                            if (obj2 != null) {
                                break;
                            }
                            ceVar = null;
                        }
                    }
                    if (ceVar != null) {
                        this.hZr.hZp = new f(ceVar.field_msgId);
                        w.i("MicroMsg.PreloadVideoService", "%s start to preload video[%s]", Integer.valueOf(this.hZr.hashCode()), this.hZr.hZp.KM());
                        if (this.hZr.hZp.a(this.hZr) < 0) {
                            w.w("MicroMsg.PreloadVideoService", "%s curr preload task do scene error.", Integer.valueOf(this.hZr.hashCode()));
                            synchronized (this.hZr.hZh) {
                                Iterator it2 = this.hZr.hZh.iterator();
                                while (it2.hasNext()) {
                                    au auVar = (au) it2.next();
                                    if (auVar != null && auVar.field_msgId == this.hZr.hZp.fGM) {
                                        w.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", Integer.valueOf(this.hZr.hashCode()), Long.valueOf(this.hZr.hZp.fGM));
                                        it2.remove();
                                    }
                                }
                            }
                            this.hZr.hZp = null;
                        }
                    }
                }
            }
        });
    }

    public final void a(final f fVar, boolean z, int i, int i2) {
        if (fVar == null) {
            w.e("MicroMsg.PreloadVideoService", "%d on preload finish but scene is null?", Integer.valueOf(hashCode()));
            return;
        }
        if (this.hZp != fVar) {
            w.w("MicroMsg.PreloadVideoService", "%d on preload finish, but scene callback not same object.", Integer.valueOf(hashCode()));
        }
        w.i("MicroMsg.PreloadVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", Integer.valueOf(hashCode()), fVar.KM(), Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2));
        h.vL().D(new Runnable(this) {
            final /* synthetic */ i hZr;

            public final void run() {
                long j = fVar.fGM;
                synchronized (this.hZr.hZh) {
                    Iterator it = this.hZr.hZh.iterator();
                    while (it.hasNext()) {
                        au auVar = (au) it.next();
                        if (auVar != null && auVar.field_msgId == j) {
                            w.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", Integer.valueOf(this.hZr.hashCode()), Long.valueOf(j));
                            it.remove();
                        }
                    }
                }
                this.hZr.bt(true);
                if (this.hZr.hZp != null) {
                    this.hZr.hZp.hYQ = null;
                }
                this.hZr.hZp = null;
                this.hZr.KQ();
                this.hZr.KP();
            }
        });
    }

    public final void bt(boolean z) {
        if (z) {
            this.hZj = ((Integer) h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_C2C_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0))).intValue();
            this.hZj++;
            h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_C2C_HAD_PRELOAD_COUNT_INT, Integer.valueOf(this.hZj));
            return;
        }
        this.hZk = ((Integer) h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_SNS_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0))).intValue();
        this.hZk++;
        h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_SNS_HAD_PRELOAD_COUNT_INT, Integer.valueOf(this.hZk));
    }

    public final boolean bu(boolean z) {
        int i;
        int i2;
        boolean z2;
        int i3 = 100;
        this.hZi = ((Long) h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_HAD_PRELOAD_TIME_LONG, Long.valueOf(-1))).longValue();
        if (bg.aA(this.hZi) >= 86400000) {
            this.hZi = bg.Nz();
            h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_HAD_PRELOAD_TIME_LONG, Long.valueOf(this.hZi));
            h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_C2C_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0));
            h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_SNS_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0));
            this.hZo = false;
            this.hZn = false;
        }
        this.hZj = ((Integer) h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_C2C_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0))).intValue();
        this.hZk = ((Integer) h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_SNS_HAD_PRELOAD_COUNT_INT, Integer.valueOf(0))).intValue();
        if (z) {
            i = this.hZj;
            i2 = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getInt("C2CMaxPreloadVideo", 100);
        } else {
            i = this.hZk;
            i2 = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getInt("SnsMaxPreloadVideo", 100);
        }
        if (i2 > 0) {
            i3 = i2;
        }
        if (i >= i3) {
            z2 = true;
        } else {
            z2 = false;
        }
        w.i("MicroMsg.PreloadVideoService", "%d check more preload count result[%b] config[%d] hadPreloadCount[%d %d %d] ", Integer.valueOf(hashCode()), Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(this.hZj), Integer.valueOf(this.hZk));
        if (z2) {
            if (z) {
                if (!this.hZn) {
                    this.hZn = true;
                    g.oUh.a(354, 127, 1, false);
                }
            } else if (!this.hZo) {
                this.hZo = true;
                g.oUh.a(354, 128, 1, false);
            }
        }
        return z2;
    }

    public final boolean KQ() {
        long NA = bg.NA();
        w.i("MicroMsg.PreloadVideoService", "%d start to delete expired file limit[%d] status[%d] expiredTime[%d] isC2C[%b]", Integer.valueOf(hashCode()), Integer.valueOf(1), Integer.valueOf(111), Long.valueOf(bg.Ny() - (((long) ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getInt("PreLoadVideoExpiredTime", 1)) * 86400)), Boolean.valueOf(true));
        List<r> a = o.KV().a(111, 1, r0);
        if (a == null || a.isEmpty()) {
            return false;
        }
        int i = 0;
        for (r rVar : a) {
            if (rVar != null) {
                int i2;
                o.KV();
                String lv = s.lv(rVar.getFileName());
                if (!bg.mA(lv)) {
                    File file = new File(lv);
                    if (file.exists()) {
                        long length = file.length();
                        w.i("MicroMsg.PreloadVideoService", "%s file[%d %d] lastmodifytime[%d] path[%s]", rVar.getFileName(), Long.valueOf(length), Integer.valueOf(rVar.fOA), Long.valueOf(rVar.ian), lv);
                        if (length > 0 && length <= ((long) rVar.fOA)) {
                            file.delete();
                            i2 = i + 1;
                            rVar.fOA = 0;
                            rVar.fRW = 1;
                            t.e(rVar);
                            i = i2;
                        }
                    }
                }
                i2 = i;
                rVar.fOA = 0;
                rVar.fRW = 1;
                t.e(rVar);
                i = i2;
            }
        }
        g.oUh.a(354, 144, (long) i, false);
        w.i("MicroMsg.PreloadVideoService", "%d delete expire file size %d delete count %d costTime[%d]", Integer.valueOf(hashCode()), Integer.valueOf(a.size()), Integer.valueOf(i), Long.valueOf(bg.aB(NA)));
        return false;
    }

    public final void a(String str, int i, long j) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(bg.Ny()).append(",");
        stringBuffer.append(bg.Ny()).append(",");
        stringBuffer.append(0).append(",");
        stringBuffer.append(str).append(",");
        stringBuffer.append(i).append(",");
        stringBuffer.append(0).append(",");
        stringBuffer.append(j);
        w.d("MicroMsg.PreloadVideoService", "%d rpt content[%s]", Integer.valueOf(hashCode()), stringBuffer.toString());
        g.oUh.A(14499, r0);
    }
}
