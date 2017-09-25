package com.tencent.mm.ah;

import android.net.TrafficStats;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.format.DateFormat;
import com.tencent.mm.e.a.kt;
import com.tencent.mm.e.a.u;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;
import java.lang.ref.WeakReference;
import java.util.Stack;

public final class a implements com.tencent.mm.ah.c.a {
    public long hEA = 0;
    public long hEB = 0;
    public int hEC;
    public int hED;
    public aj hEE = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ a hEH;

        {
            this.hEH = r1;
        }

        public final boolean oQ() {
            long uidRxBytes = TrafficStats.getUidRxBytes(this.hEH.hEC);
            long uidTxBytes = TrafficStats.getUidTxBytes(this.hEH.hEC);
            long j = (uidRxBytes - this.hEH.hEA) + (uidTxBytes - this.hEH.hEB);
            w.d("MicroMsg.AutoGetBigImgLogic", "delta of data: " + (j / AppSupportContentFlag.MMAPP_SUPPORT_XLS));
            if (j <= 20480) {
                this.hEH.hEz = false;
                this.hEH.start();
            } else {
                this.hEH.hEA = uidRxBytes;
                this.hEH.hEB = uidTxBytes;
                this.hEH.hEE.v(1000, 1000);
            }
            return true;
        }
    }, false);
    c hEF = new c<kt>(this) {
        final /* synthetic */ a hEH;

        {
            this.hEH = r2;
            this.usg = kt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            kt ktVar = (kt) bVar;
            this.hEH.hEy = (ktVar.fRn.fRo ? 1 : -1) + this.hEH.hEy;
            if (this.hEH.hEy < 0) {
                this.hEH.hEy = 0;
                w.e("MicroMsg.AutoGetBigImgLogic", "mPauseCnt < 0");
            }
            w.i("MicroMsg.AutoGetBigImgLogic", "req pause: " + ktVar.fRn.fRo + " count:" + this.hEH.hEy);
            this.hEH.start();
            return false;
        }
    };
    c hEG = new c<u>(this) {
        final /* synthetic */ a hEH;

        {
            this.hEH = r2;
            this.usg = u.class.getName().hashCode();
        }

        private boolean a(u uVar) {
            this.hEH.hED = uVar.fDb.mode;
            w.d("MicroMsg.AutoGetBigImgLogic", "mode = " + this.hEH.hED);
            com.tencent.mm.modelcontrol.c.Er();
            if (!com.tencent.mm.modelcontrol.c.Es()) {
                synchronized (this.hEH.hEt) {
                    this.hEH.hEt.clear();
                }
            }
            return false;
        }
    };
    private a hEs;
    public Stack<Long> hEt;
    long hEu = 0;
    public int hEv = 0;
    boolean hEw = false;
    public long hEx = 0;
    public int hEy = 0;
    public boolean hEz = false;

    static class a extends ae {
        private WeakReference<a> hEI;

        public a(a aVar, Looper looper) {
            super(looper);
            this.hEI = new WeakReference(aVar);
        }

        public final void handleMessage(Message message) {
            a aVar = (a) this.hEI.get();
            if (aVar != null && 1 == message.what) {
                if (!aVar.hEw && System.currentTimeMillis() - aVar.hEx > 1200000) {
                    w.d("MicroMsg.AutoGetBigImgLogic", "running to long in blackground");
                } else if (aVar.hEu != 0 || aVar.hEt.size() <= 0 || aVar.hEy != 0 || aVar.hEz) {
                    w.d("MicroMsg.AutoGetBigImgLogic", "curMsgId: " + aVar.hEu + " size: " + aVar.hEt.size() + " cnt: " + aVar.hEy + " pauseOnMonitor: " + aVar.hEz);
                } else {
                    synchronized (aVar.hEt) {
                        aVar.hEu = ((Long) aVar.hEt.pop()).longValue();
                    }
                    ce cA = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().cA(aVar.hEu);
                    d ai = n.GS().ai(cA.field_msgSvrId);
                    if (ai.gxK == 1) {
                        w.d("MicroMsg.AutoGetBigImgLogic", aVar.hEu + " already has hd thumb");
                        aVar.hEu = 0;
                        aVar.start();
                        return;
                    }
                    w.d("MicroMsg.AutoGetBigImgLogic", "start download cdnautostart " + aVar.hEu + "  image_" + cA.field_msgId);
                    g.El().hyr.add("image_" + cA.field_msgId);
                    n.GT().a(ai.hEY, cA.field_msgId, 0, Long.valueOf(aVar.hEu), aVar.hEv, aVar);
                }
            }
        }
    }

    public a(Looper looper) {
        this.hEs = new a(this, looper);
        this.hEt = new Stack();
        this.hEC = Process.myUid();
        Integer num = (Integer) com.tencent.mm.kernel.h.vI().vr().get(327681, null);
        int intValue = (num == null || 3 == num.intValue()) ? 1 : num.intValue();
        this.hED = intValue;
        com.tencent.mm.sdk.b.a.urY.b(this.hEF);
        com.tencent.mm.sdk.b.a.urY.b(this.hEG);
    }

    public final void start() {
        this.hEs.sendEmptyMessage(1);
    }

    public final void aX(boolean z) {
        w.d("MicroMsg.AutoGetBigImgLogic", "is foreground: " + z);
        this.hEw = z;
        this.hEx = System.currentTimeMillis();
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, k kVar) {
    }

    public static void a(long j, long j2, boolean z) {
        if (!z) {
            w.i("MicroMsg.AutoGetBigImgLogic", "imglocalId " + j + " msglocalid " + j2 + " false");
        } else if (am.isWifi(ab.getContext())) {
            w.v("MicroMsg.AutoGetBigImgLogic", "is wifi pass count");
        } else {
            long a = bg.a((Long) com.tencent.mm.kernel.h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, null), 0);
            long PZ = bg.PZ((String) DateFormat.format("M", System.currentTimeMillis()));
            w.d("MicroMsg.AutoGetBigImgLogic", "img " + j + " msgLocalId: " + j2 + " has been downloaded current %d month %d", Long.valueOf(1 + a), Long.valueOf(PZ));
            com.tencent.mm.kernel.h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, Long.valueOf(a + 1));
            com.tencent.mm.kernel.h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, Long.valueOf(PZ));
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, k kVar) {
        if (i3 == 0 && i4 == 0) {
            a(j, j2, true);
        } else {
            w.e("MicroMsg.AutoGetBigImgLogic", "img " + j + "msgLocalId " + j2 + " download failed");
        }
        this.hEu = 0;
        com.tencent.mm.modelcontrol.c.Er();
        if (com.tencent.mm.modelcontrol.c.Es()) {
            this.hEA = TrafficStats.getUidRxBytes(this.hEC);
            this.hEB = TrafficStats.getUidTxBytes(this.hEC);
            this.hEE.v(1000, 1000);
            return;
        }
        w.d("MicroMsg.AutoGetBigImgLogic", "don't allow auto download, clear task list");
        synchronized (this.hEt) {
            this.hEt.clear();
        }
    }

    public final void a(long j, long j2, int i, int i2, Object obj) {
        w.i("MicroMsg.AutoGetBigImgLogic", "img " + j + " has been canceled");
    }
}
