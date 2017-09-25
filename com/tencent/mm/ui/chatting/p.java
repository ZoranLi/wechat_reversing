package com.tencent.mm.ui.chatting;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.b.e.a;
import com.tencent.mm.e.a.nd;
import com.tencent.mm.modelvoice.c;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.z;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.y.g;
import com.tencent.mm.y.g.b;
import java.util.LinkedList;
import java.util.List;

public final class p implements a, c, SensorController.a, z, g.a, b {
    private static SensorController jXn;
    private int fyT;
    private boolean fyV = false;
    public boolean jXq;
    private ax jXr;
    public long jXs = -1;
    private boolean jXx = false;
    private boolean jYW = false;
    g lEZ;
    private List<au> vzB;
    public long vzC = -1;
    private o vzD;
    public En_5b8fbb1e.a vzE;
    public o vzF;
    boolean vzG;
    boolean vzH = true;
    boolean vzI = false;
    com.tencent.mm.sdk.b.c vzJ = new com.tencent.mm.sdk.b.c<nd>(this) {
        final /* synthetic */ p vzM;

        {
            this.vzM = r2;
            this.usg = nd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            long j = ((nd) bVar).fUm.fGM;
            w.d("MicroMsg.AutoPlay", "playingVoiceId: %s", this.vzM.vzC);
            w.d("MicroMsg.AutoPlay", "msg id is: %s", r11.fUm.fGM);
            if (this.vzM.vzC == j) {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 vzN;

                    {
                        this.vzN = r1;
                    }

                    public final void run() {
                        this.vzN.vzM.le(false);
                        this.vzN.vzM.bTK();
                    }
                });
            }
            return false;
        }
    };
    private ae vzK = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ p vzM;

        public final void handleMessage(Message message) {
            boolean z = true;
            super.handleMessage(message);
            try {
                w.i("MicroMsg.AutoPlay", "reset speaker");
                this.vzM.vzE.cV(true);
                p pVar = this.vzM;
                if (this.vzM.vzE.jXt) {
                    z = false;
                }
                pVar.jXq = z;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.AutoPlay", e, "", new Object[0]);
            }
        }
    };
    private ae vzL = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ p vzM;

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                w.i("MicroMsg.AutoPlay", "startPlayHandler start Play");
                this.vzM.bTP();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.AutoPlay", e, "", new Object[0]);
            }
        }
    };

    public p(En_5b8fbb1e.a aVar, String str) {
        this.vzE = aVar;
        if (jXn == null) {
            jXn = new SensorController(aVar.bPj().getApplicationContext());
        }
        if (this.jXr == null) {
            this.jXr = new ax(aVar.bPj().getApplicationContext());
        }
        Tm(str);
        com.tencent.mm.sdk.b.a.urY.b(this.vzJ);
        ap.oH().a(this);
    }

    public final void Tm(String str) {
        w.i("MicroMsg.AutoPlay", "changeTalker, isResumeFromDisableScreen: %b", Boolean.valueOf(this.vzI));
        if (!this.vzI && this.vzE != null) {
            this.vzB = new LinkedList();
            this.jYW = false;
            this.vzC = -1;
            this.jXq = false;
            this.jXs = -1;
            this.vzG = false;
            this.fyT = 0;
            if (com.tencent.mm.u.o.fq(str)) {
                this.fyT = 1;
                this.lEZ = new com.tencent.mm.c.a.a(this.vzE.bPj(), 1);
                return;
            }
            this.fyT = 0;
            this.lEZ = new com.tencent.mm.c.a.a(this.vzE.bPj(), 0);
        }
    }

    public final void bTK() {
        w.d("MicroMsg.AutoPlay", "clear play list, stack: %s", u.NC());
        if (this.vzD != null) {
            this.vzD.dismiss();
        }
        this.vzB.clear();
    }

    private void AJ(int i) {
        while (this.vzE != null) {
            cw bVT = this.vzE.bVT();
            if (bVT == null) {
                w.e("MicroMsg.AutoPlay", "add next failed: null adapter");
                return;
            }
            w.d("MicroMsg.AutoPlay", "position : " + i + "adapter getCount = " + bVT.getCount());
            if (i >= 0 && i < bVT.getCount()) {
                au auVar = (au) bVT.getItem(i);
                if (auVar != null) {
                    if (auVar.bLZ() && auVar.field_isSend == 0 && !q.C(auVar) && !q.D(auVar)) {
                        ab(auVar);
                    }
                    i++;
                } else {
                    return;
                }
            }
            return;
        }
        w.e("MicroMsg.AutoPlay", "context is null");
    }

    private void ab(au auVar) {
        if (auVar != null) {
            ap.yY();
            if (com.tencent.mm.u.c.isSDCardAvailable()) {
                int size = this.vzB.size();
                int i = 0;
                while (i < size) {
                    if (((au) this.vzB.get(i)).field_msgId != auVar.field_msgId) {
                        i++;
                    } else {
                        return;
                    }
                }
                if (this.vzG || this.vzB.size() == 0) {
                    this.vzB.add(auVar);
                }
                w.d("MicroMsg.AutoPlay", "add voice msg :" + this.vzB.size());
            } else if (this.vzB.size() > 0) {
                this.vzB.clear();
                s.eP(this.vzE.bPj());
            }
        }
    }

    public final void a(int i, au auVar) {
        if (auVar != null && auVar.bLZ()) {
            n nVar = new n(auVar.field_content);
            if (nVar.time != 0 || auVar.field_isSend != 0) {
                if (auVar.field_status != 1 || auVar.field_isSend != 1) {
                    if (auVar.field_isSend != 0 || nVar.time != -1) {
                        bTK();
                        ap.yY();
                        Boolean bool = (Boolean) com.tencent.mm.u.c.vr().get(4115, null);
                        if (bool == null || !bool.booleanValue()) {
                            ap.yY();
                            com.tencent.mm.u.c.vr().set(4115, Boolean.valueOf(true));
                            bTS();
                            this.vzF = s.a(this.vzE.bPj(), this.vzE.getString(R.l.dUN), 4000);
                        }
                        if (this.lEZ.isPlaying() && auVar.field_msgId == this.vzC) {
                            le(true);
                            return;
                        }
                        ab(auVar);
                        if (auVar.field_isSend == 0 && !q.C(auVar)) {
                            AJ(i + 1);
                        }
                        bTO();
                    }
                }
            }
        }
    }

    public final void b(int i, au auVar) {
        if (auVar != null) {
            bTK();
            ap.yY();
            Boolean bool = (Boolean) com.tencent.mm.u.c.vr().get(4115, null);
            if (bool == null || !bool.booleanValue()) {
                ap.yY();
                com.tencent.mm.u.c.vr().set(4115, Boolean.valueOf(true));
                bTS();
                this.vzF = s.a(this.vzE.bPj(), this.vzE.getString(R.l.dUN), 4000);
            }
            if (this.lEZ.isPlaying() && auVar.field_msgId == this.vzC) {
                le(true);
                return;
            }
            ab(auVar);
            if (auVar.field_isSend == 0 && !q.C(auVar)) {
                AJ(i + 1);
            }
            bTO();
        }
    }

    public final void c(int i, au auVar) {
        if (auVar != null) {
            bTK();
            ap.yY();
            Boolean bool = (Boolean) com.tencent.mm.u.c.vr().get(4115, null);
            if (bool == null || !bool.booleanValue()) {
                ap.yY();
                com.tencent.mm.u.c.vr().set(4115, Boolean.valueOf(true));
                bTS();
                this.vzF = s.a(this.vzE.bPj(), this.vzE.getString(R.l.dUN), 4000);
            }
            if (this.lEZ.isPlaying() && auVar.field_msgId == this.vzC) {
                le(true);
                return;
            }
            ab(auVar);
            if (auVar.field_isSend == 0 && !q.C(auVar)) {
                AJ(i + 1);
            }
            bTO();
        }
    }

    public final void d(int i, au auVar) {
        if (auVar != null) {
            bTK();
            ap.yY();
            Boolean bool = (Boolean) com.tencent.mm.u.c.vr().get(4115, null);
            if (bool == null || !bool.booleanValue()) {
                ap.yY();
                com.tencent.mm.u.c.vr().set(4115, Boolean.valueOf(true));
                bTS();
                this.vzF = s.a(this.vzE.bPj(), this.vzE.getString(R.l.dUN), 4000);
            }
            if (this.lEZ.isPlaying() && auVar.field_msgId == this.vzC) {
                le(true);
                return;
            }
            ab(auVar);
            if (auVar.field_isSend == 0 && !q.C(auVar)) {
                AJ(i + 1);
            }
            bTO();
        }
    }

    public final void A(au auVar) {
        if ((!this.vzH || !this.vzB.isEmpty()) && auVar != null && auVar.bLZ() && auVar.field_isSend != 1 && auVar.field_talker != null && auVar.field_talker.equals(this.vzE.bUg()) && ap.vd().foreground && !this.vzE.isFinishing()) {
            if (q.D(auVar)) {
                w.e("MicroMsg.AutoPlay", "should not in this route");
                return;
            }
            ab(auVar);
            if (!this.jYW && !this.lEZ.isPlaying() && u.bp(this.vzE.bPj())) {
                bTO();
            }
        }
    }

    public final void bTL() {
        this.jYW = true;
        le(true);
        bTK();
    }

    public final void bTM() {
        this.jYW = false;
        bTO();
    }

    private void bTN() {
        int size = this.vzB.size();
        int i = 0;
        int i2 = -1;
        while (i < size) {
            int i3;
            if (((au) this.vzB.get(i)).field_msgId == this.vzC) {
                i3 = i;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (i2 != -1) {
            this.vzB.remove(i2);
        }
        w.d("MicroMsg.AutoPlay", "remove voice msg : size = " + this.vzB.size());
    }

    public final void bTO() {
        w.d("MicroMsg.AutoPlay", "play next: size = " + this.vzB.size());
        if (this.vzB.size() <= 0) {
            this.vzK.sendEmptyMessageDelayed(0, 1000);
            return;
        }
        if (!e.qE().qO()) {
            e.qE();
            if (e.qL()) {
                e.qE().a(this);
                int qG = e.qE().qG();
                this.fyV = true;
                if (!(qG == -1 || qG == 0)) {
                    w.i("MicroMsg.AutoPlay", "play next: ret = " + qG);
                    this.vzL.sendEmptyMessageDelayed(0, 1000);
                    return;
                }
            }
        }
        bTP();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bTP() {
        /*
        r12 = this;
        r5 = 1;
        r6 = 0;
        r0 = "MicroMsg.AutoPlay";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00e5 }
        r2 = "realPlayNext play next: size = ";
        r1.<init>(r2);	 Catch:{ Exception -> 0x00e5 }
        r2 = r12.vzB;	 Catch:{ Exception -> 0x00e5 }
        r2 = r2.size();	 Catch:{ Exception -> 0x00e5 }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00e5 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00e5 }
        com.tencent.mm.sdk.platformtools.w.d(r0, r1);	 Catch:{ Exception -> 0x00e5 }
        r0 = r12.vzB;	 Catch:{ Exception -> 0x00e5 }
        r0 = r0.size();	 Catch:{ Exception -> 0x00e5 }
        if (r0 > 0) goto L_0x002f;
    L_0x0026:
        r0 = r12.vzK;	 Catch:{ Exception -> 0x00e5 }
        r1 = 0;
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0.sendEmptyMessageDelayed(r1, r2);	 Catch:{ Exception -> 0x00e5 }
    L_0x002e:
        return;
    L_0x002f:
        r0 = r12.vzB;	 Catch:{ Exception -> 0x00e5 }
        r1 = 0;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x00e5 }
        r0 = (com.tencent.mm.storage.au) r0;	 Catch:{ Exception -> 0x00e5 }
        r2 = r0.field_createTime;	 Catch:{ Exception -> 0x00e5 }
        r0 = r12.vzB;	 Catch:{ Exception -> 0x00e5 }
        r7 = r0.size();	 Catch:{ Exception -> 0x00e5 }
        r4 = r5;
        r1 = r6;
    L_0x0042:
        if (r4 >= r7) goto L_0x0063;
    L_0x0044:
        r0 = r12.vzB;	 Catch:{ Exception -> 0x00e5 }
        r0 = r0.get(r4);	 Catch:{ Exception -> 0x00e5 }
        r0 = (com.tencent.mm.storage.au) r0;	 Catch:{ Exception -> 0x00e5 }
        r8 = r0.field_createTime;	 Catch:{ Exception -> 0x00e5 }
        r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x0245;
    L_0x0052:
        r0 = r12.vzB;	 Catch:{ Exception -> 0x00e5 }
        r0 = r0.get(r4);	 Catch:{ Exception -> 0x00e5 }
        r0 = (com.tencent.mm.storage.au) r0;	 Catch:{ Exception -> 0x00e5 }
        r0 = r0.field_createTime;	 Catch:{ Exception -> 0x00e5 }
        r2 = r4;
    L_0x005d:
        r4 = r4 + 1;
        r10 = r0;
        r1 = r2;
        r2 = r10;
        goto L_0x0042;
    L_0x0063:
        r0 = r12.vzB;	 Catch:{ Exception -> 0x00e5 }
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x00e5 }
        r0 = (com.tencent.mm.storage.au) r0;	 Catch:{ Exception -> 0x00e5 }
        if (r0 == 0) goto L_0x002e;
    L_0x006d:
        if (r0 == 0) goto L_0x00f7;
    L_0x006f:
        r1 = r0.bLZ();	 Catch:{ Exception -> 0x00e5 }
        if (r1 != 0) goto L_0x008f;
    L_0x0075:
        r1 = r0.bMq();	 Catch:{ Exception -> 0x00e5 }
        if (r1 != 0) goto L_0x008f;
    L_0x007b:
        r1 = r0.field_type;	 Catch:{ Exception -> 0x00e5 }
        r2 = -1879048190; // 0xffffffff90000002 float:-2.5243555E-29 double:NaN;
        if (r1 != r2) goto L_0x00f3;
    L_0x0082:
        r1 = r5;
    L_0x0083:
        if (r1 != 0) goto L_0x008f;
    L_0x0085:
        r1 = r0.field_type;	 Catch:{ Exception -> 0x00e5 }
        r2 = -1879048189; // 0xffffffff90000003 float:-2.5243558E-29 double:NaN;
        if (r1 != r2) goto L_0x00f5;
    L_0x008c:
        r1 = r5;
    L_0x008d:
        if (r1 == 0) goto L_0x00f7;
    L_0x008f:
        r1 = r5;
    L_0x0090:
        junit.framework.Assert.assertTrue(r1);	 Catch:{ Exception -> 0x00e5 }
        r1 = "MicroMsg.AutoPlay";
        r2 = "start play msg: %d";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00e5 }
        r4 = 0;
        r8 = r0.field_msgId;	 Catch:{ Exception -> 0x00e5 }
        r7 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x00e5 }
        r3[r4] = r7;	 Catch:{ Exception -> 0x00e5 }
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);	 Catch:{ Exception -> 0x00e5 }
        r1 = jXn;	 Catch:{ Exception -> 0x00e5 }
        r1 = r1.uvF;	 Catch:{ Exception -> 0x00e5 }
        if (r1 != 0) goto L_0x00c4;
    L_0x00ae:
        r1 = jXn;	 Catch:{ Exception -> 0x00e5 }
        r1.a(r12);	 Catch:{ Exception -> 0x00e5 }
        r1 = new com.tencent.mm.ui.chatting.p$4;	 Catch:{ Exception -> 0x00e5 }
        r1.<init>(r12);	 Catch:{ Exception -> 0x00e5 }
        r2 = r12.jXr;	 Catch:{ Exception -> 0x00e5 }
        r1 = r2.M(r1);	 Catch:{ Exception -> 0x00e5 }
        if (r1 == 0) goto L_0x00f9;
    L_0x00c0:
        r2 = 0;
        r12.jXs = r2;	 Catch:{ Exception -> 0x00e5 }
    L_0x00c4:
        com.tencent.mm.u.ap.yY();	 Catch:{ Exception -> 0x00e5 }
        r1 = com.tencent.mm.u.c.isSDCardAvailable();	 Catch:{ Exception -> 0x00e5 }
        if (r1 != 0) goto L_0x00fe;
    L_0x00cd:
        r1 = r0.field_imgPath;	 Catch:{ Exception -> 0x00e5 }
        r1 = com.tencent.mm.platformtools.u.mA(r1);	 Catch:{ Exception -> 0x00e5 }
        if (r1 != 0) goto L_0x00fe;
    L_0x00d5:
        r0 = r12.vzB;	 Catch:{ Exception -> 0x00e5 }
        r0.clear();	 Catch:{ Exception -> 0x00e5 }
        r0 = r12.vzE;	 Catch:{ Exception -> 0x00e5 }
        r0 = r0.bPj();	 Catch:{ Exception -> 0x00e5 }
        com.tencent.mm.ui.base.s.eP(r0);	 Catch:{ Exception -> 0x00e5 }
        goto L_0x002e;
    L_0x00e5:
        r0 = move-exception;
        r1 = "MicroMsg.AutoPlay";
        r2 = "";
        r3 = new java.lang.Object[r6];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r3);
        goto L_0x002e;
    L_0x00f3:
        r1 = r6;
        goto L_0x0083;
    L_0x00f5:
        r1 = r6;
        goto L_0x008d;
    L_0x00f7:
        r1 = r6;
        goto L_0x0090;
    L_0x00f9:
        r2 = -1;
        r12.jXs = r2;	 Catch:{ Exception -> 0x00e5 }
        goto L_0x00c4;
    L_0x00fe:
        com.tencent.mm.u.ap.yY();	 Catch:{ Exception -> 0x00e5 }
        r1 = com.tencent.mm.u.c.isSDCardAvailable();	 Catch:{ Exception -> 0x00e5 }
        if (r1 == 0) goto L_0x015a;
    L_0x0107:
        r1 = r12.vzE;	 Catch:{ Exception -> 0x00e5 }
        r1 = r1.jXt;	 Catch:{ Exception -> 0x00e5 }
        if (r1 == 0) goto L_0x015a;
    L_0x010d:
        r1 = r12.vzD;	 Catch:{ Exception -> 0x00e5 }
        if (r1 == 0) goto L_0x0116;
    L_0x0111:
        r1 = r12.vzD;	 Catch:{ Exception -> 0x00e5 }
        r1.dismiss();	 Catch:{ Exception -> 0x00e5 }
    L_0x0116:
        r1 = com.tencent.mm.compatible.b.e.qE();	 Catch:{ Exception -> 0x00e5 }
        r1 = r1.qO();	 Catch:{ Exception -> 0x00e5 }
        r2 = com.tencent.mm.compatible.b.e.qE();	 Catch:{ Exception -> 0x00e5 }
        r2 = r2.qI();	 Catch:{ Exception -> 0x00e5 }
        r3 = "MicroMsg.AutoPlay";
        r4 = "alvinluo isHeadsetPluged: %b, isBluetoothOn: %b";
        r7 = 2;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x00e5 }
        r8 = 0;
        r9 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x00e5 }
        r7[r8] = r9;	 Catch:{ Exception -> 0x00e5 }
        r8 = 1;
        r9 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x00e5 }
        r7[r8] = r9;	 Catch:{ Exception -> 0x00e5 }
        com.tencent.mm.sdk.platformtools.w.i(r3, r4, r7);	 Catch:{ Exception -> 0x00e5 }
        if (r1 != 0) goto L_0x01f6;
    L_0x0142:
        if (r2 == 0) goto L_0x01f6;
    L_0x0144:
        r1 = r12.vzE;	 Catch:{ Exception -> 0x00e5 }
        r1 = r1.bPj();	 Catch:{ Exception -> 0x00e5 }
        r2 = com.tencent.mm.R.k.dzW;	 Catch:{ Exception -> 0x00e5 }
        r3 = r12.vzE;	 Catch:{ Exception -> 0x00e5 }
        r4 = com.tencent.mm.R.l.dSE;	 Catch:{ Exception -> 0x00e5 }
        r3 = r3.getString(r4);	 Catch:{ Exception -> 0x00e5 }
        r1 = com.tencent.mm.ui.base.s.a(r1, r2, r3);	 Catch:{ Exception -> 0x00e5 }
        r12.vzD = r1;	 Catch:{ Exception -> 0x00e5 }
    L_0x015a:
        r1 = "keep_app_silent";
        com.tencent.mm.sdk.platformtools.ad.Pt(r1);	 Catch:{ Exception -> 0x00e5 }
        com.tencent.mm.modelvoice.q.E(r0);	 Catch:{ Exception -> 0x00e5 }
        r1 = r12.lEZ;	 Catch:{ Exception -> 0x00e5 }
        r2 = 1;
        r1.ap(r2);	 Catch:{ Exception -> 0x00e5 }
        r1 = r12.vzE;	 Catch:{ Exception -> 0x00e5 }
        r1 = r1.vIz;	 Catch:{ Exception -> 0x00e5 }
        r2 = 1;
        r1.setKeepScreenOn(r2);	 Catch:{ Exception -> 0x00e5 }
        r1 = com.tencent.mm.compatible.b.e.qE();	 Catch:{ Exception -> 0x00e5 }
        r1 = r1.qO();	 Catch:{ Exception -> 0x00e5 }
        if (r1 != 0) goto L_0x0185;
    L_0x017b:
        r1 = com.tencent.mm.compatible.b.e.qE();	 Catch:{ Exception -> 0x00e5 }
        r1 = r1.qI();	 Catch:{ Exception -> 0x00e5 }
        if (r1 == 0) goto L_0x01b2;
    L_0x0185:
        r1 = "MicroMsg.AutoPlay";
        r2 = "headset plugged: %b, bluetoothon: %b";
        r3 = 2;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00e5 }
        r4 = 0;
        r7 = com.tencent.mm.compatible.b.e.qE();	 Catch:{ Exception -> 0x00e5 }
        r7 = r7.qO();	 Catch:{ Exception -> 0x00e5 }
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Exception -> 0x00e5 }
        r3[r4] = r7;	 Catch:{ Exception -> 0x00e5 }
        r4 = 1;
        r7 = com.tencent.mm.compatible.b.e.qE();	 Catch:{ Exception -> 0x00e5 }
        r7 = r7.qI();	 Catch:{ Exception -> 0x00e5 }
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Exception -> 0x00e5 }
        r3[r4] = r7;	 Catch:{ Exception -> 0x00e5 }
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);	 Catch:{ Exception -> 0x00e5 }
        r1 = 0;
        r12.jXq = r1;	 Catch:{ Exception -> 0x00e5 }
    L_0x01b2:
        r1 = r0.field_imgPath;	 Catch:{ Exception -> 0x00e5 }
        r2 = r12.fyT;	 Catch:{ Exception -> 0x00e5 }
        if (r2 != r5) goto L_0x020e;
    L_0x01b8:
        r2 = 0;
        r1 = com.tencent.mm.plugin.subapp.c.h.at(r1, r2);	 Catch:{ Exception -> 0x00e5 }
    L_0x01bd:
        r2 = "MicroMsg.AutoPlay";
        r3 = "startplay";
        com.tencent.mm.sdk.platformtools.w.i(r2, r3);	 Catch:{ Exception -> 0x00e5 }
        r2 = r12.lEZ;	 Catch:{ Exception -> 0x00e5 }
        r3 = r12.jXq;	 Catch:{ Exception -> 0x00e5 }
        r4 = 1;
        r7 = -1;
        r1 = r2.a(r1, r3, r4, r7);	 Catch:{ Exception -> 0x00e5 }
        if (r1 == 0) goto L_0x0215;
    L_0x01d2:
        r2 = r12.lEZ;	 Catch:{ Exception -> 0x00e5 }
        r1 = r12.vzB;	 Catch:{ Exception -> 0x00e5 }
        r1 = r1.size();	 Catch:{ Exception -> 0x00e5 }
        if (r1 <= r5) goto L_0x0213;
    L_0x01dc:
        r1 = r5;
    L_0x01dd:
        r2.ar(r1);	 Catch:{ Exception -> 0x00e5 }
        r1 = r12.lEZ;	 Catch:{ Exception -> 0x00e5 }
        r1.a(r12);	 Catch:{ Exception -> 0x00e5 }
        r1 = r12.lEZ;	 Catch:{ Exception -> 0x00e5 }
        r1.a(r12);	 Catch:{ Exception -> 0x00e5 }
        r0 = r0.field_msgId;	 Catch:{ Exception -> 0x00e5 }
        r12.vzC = r0;	 Catch:{ Exception -> 0x00e5 }
    L_0x01ee:
        r12.bSe();	 Catch:{ Exception -> 0x00e5 }
        r0 = 0;
        r12.vzI = r0;	 Catch:{ Exception -> 0x00e5 }
        goto L_0x002e;
    L_0x01f6:
        r1 = r12.vzE;	 Catch:{ Exception -> 0x00e5 }
        r1 = r1.bPj();	 Catch:{ Exception -> 0x00e5 }
        r2 = com.tencent.mm.R.k.dAc;	 Catch:{ Exception -> 0x00e5 }
        r3 = r12.vzE;	 Catch:{ Exception -> 0x00e5 }
        r4 = com.tencent.mm.R.l.dSF;	 Catch:{ Exception -> 0x00e5 }
        r3 = r3.getString(r4);	 Catch:{ Exception -> 0x00e5 }
        r1 = com.tencent.mm.ui.base.s.a(r1, r2, r3);	 Catch:{ Exception -> 0x00e5 }
        r12.vzD = r1;	 Catch:{ Exception -> 0x00e5 }
        goto L_0x015a;
    L_0x020e:
        r1 = com.tencent.mm.modelvoice.q.js(r1);	 Catch:{ Exception -> 0x00e5 }
        goto L_0x01bd;
    L_0x0213:
        r1 = r6;
        goto L_0x01dd;
    L_0x0215:
        r0 = -1;
        r12.vzC = r0;	 Catch:{ Exception -> 0x00e5 }
        r0 = r12.fyV;	 Catch:{ Exception -> 0x00e5 }
        if (r0 == 0) goto L_0x0227;
    L_0x021d:
        r0 = com.tencent.mm.compatible.b.e.qE();	 Catch:{ Exception -> 0x00e5 }
        r0.qH();	 Catch:{ Exception -> 0x00e5 }
        r0 = 0;
        r12.fyV = r0;	 Catch:{ Exception -> 0x00e5 }
    L_0x0227:
        r0 = com.tencent.mm.compatible.b.e.qE();	 Catch:{ Exception -> 0x00e5 }
        r0.b(r12);	 Catch:{ Exception -> 0x00e5 }
        r0 = r12.vzE;	 Catch:{ Exception -> 0x00e5 }
        r0 = r0.bPj();	 Catch:{ Exception -> 0x00e5 }
        r1 = r12.vzE;	 Catch:{ Exception -> 0x00e5 }
        r2 = com.tencent.mm.R.l.dVf;	 Catch:{ Exception -> 0x00e5 }
        r1 = r1.getString(r2);	 Catch:{ Exception -> 0x00e5 }
        r2 = 0;
        r0 = android.widget.Toast.makeText(r0, r1, r2);	 Catch:{ Exception -> 0x00e5 }
        r0.show();	 Catch:{ Exception -> 0x00e5 }
        goto L_0x01ee;
    L_0x0245:
        r10 = r2;
        r2 = r1;
        r0 = r10;
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.p.bTP():void");
    }

    public final void bTQ() {
        if (this.lEZ != null && this.lEZ.isPlaying()) {
            w.i("MicroMsg.AutoPlay", "switchSpeaker, isSpeakerOn: %b, isPlaying: %b", Boolean.valueOf(this.jXq), Boolean.valueOf(this.lEZ.isPlaying()));
            this.lEZ.aq(this.jXq);
        }
    }

    public final void release() {
        w.i("MicroMsg.AutoPlay", "alvinluo AutoPlay release");
        if (this.jXr != null) {
            this.jXr.bJH();
        }
    }

    public final void le(boolean z) {
        w.i("MicroMsg.AutoPlay", "stop play");
        ad.Pu("keep_app_silent");
        this.lEZ.stop();
        this.vzE.releaseWakeLock();
        bTN();
        if (this.fyV) {
            e.qE().qH();
            this.fyV = false;
        }
        e.qE().b(this);
        if (this.vzB.isEmpty()) {
            jXn.bJG();
            this.jXr.bJH();
        }
        if (z) {
            w.i("MicroMsg.AutoPlay", "resetAutoPlay stop play fresh tid[%d] this[%d] looper[%s], stack[%s]", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(hashCode()), Looper.myLooper(), u.NC());
            bSe();
        }
        this.vzC = -1;
        bTS();
        this.vzI = false;
    }

    private void bSe() {
        af.v(new Runnable(this) {
            final /* synthetic */ p vzM;

            {
                this.vzM = r1;
            }

            public final void run() {
                if (this.vzM.vzE != null && this.vzM.vzE.bVT() != null) {
                    w.i("MicroMsg.AutoPlay", "resetAutoPlay notifyDataSetChanged");
                    this.vzM.vzE.bVT().notifyDataSetChanged();
                }
            }
        });
    }

    private void bTR() {
        w.i("MicroMsg.AutoPlay", "stop play complete");
        ad.Pu("keep_app_silent");
        this.vzE.releaseWakeLock();
        bTN();
        if (this.vzB.isEmpty() && this.fyV) {
            e.qE().qH();
            this.fyV = false;
        }
        e.qE().b(this);
        if (this.vzB.isEmpty()) {
            jXn.bJG();
            this.jXr.bJH();
        }
        bSe();
        this.vzC = -1;
        bTS();
    }

    public final boolean isPlaying() {
        return this.lEZ.isPlaying();
    }

    public final void oW() {
        w.v("MicroMsg.AutoPlay", "voice play completion isSpeakerOn " + this.jXq);
        if (this.vzE != null) {
            bTR();
            this.vzE.releaseWakeLock();
            bTO();
        }
    }

    public final void onError() {
        w.e("MicroMsg.AutoPlay", "voice play error");
        le(true);
        bTO();
    }

    public final void cU(final boolean z) {
        boolean z2 = true;
        w.i("MicroMsg.AutoPlay", "onSensorEvent, isON:" + z + "  hasSkip:" + this.jXx + " tick:" + u.aB(this.jXs) + "  lt:" + this.jXs);
        if (this.jXx) {
            if (z) {
                z2 = false;
            }
            this.jXx = z2;
        } else if (this.vzE == null) {
            jXn.bJG();
        } else {
            w.i("MicroMsg.AutoPlay", "isScreenOn: %s", Boolean.valueOf(this.vzE.uSU.uTe));
            if (z || this.jXs == -1 || u.aB(this.jXs) <= 400) {
                this.jXx = false;
                if (!this.lEZ.oS()) {
                    if (ap.yZ().qI()) {
                        bTS();
                        w.d("MicroMsg.AutoPlay", "onSensorEvent, connecting bluetooth, omit sensor event");
                        return;
                    } else if (this.vzE.jXt) {
                        this.jXq = false;
                        if (this.vzC != -1) {
                            this.vzE.cV(z);
                            this.vzI = z;
                        } else {
                            this.vzE.cV(true);
                            this.vzI = true;
                        }
                        bTQ();
                        return;
                    } else {
                        if (this.vzC != -1) {
                            if (this.vzE.uSU.uTe != z) {
                                this.vzE.cV(z);
                                this.vzI = z;
                                new aj(new aj.a(this) {
                                    final /* synthetic */ p vzM;

                                    public final boolean oQ() {
                                        if (z) {
                                            w.i("MicroMsg.AutoPlay", "speaker true");
                                            this.vzM.bTS();
                                            if (this.vzM.vzE != null) {
                                                this.vzM.vzF = s.a(this.vzM.vzE.bPj(), this.vzM.vzE.getString(R.l.elO), 2000);
                                            }
                                            this.vzM.jXq = true;
                                            this.vzM.bTQ();
                                        } else {
                                            w.i("MicroMsg.AutoPlay", "speaker off");
                                            this.vzM.jXq = false;
                                            p pVar = this.vzM;
                                            if (pVar.lEZ.isPlaying()) {
                                                w.d("MicroMsg.AutoPlay", "deal sensor event, play next");
                                                pVar.bTO();
                                            }
                                        }
                                        return false;
                                    }
                                }, false).v(50, 50);
                            } else {
                                return;
                            }
                        }
                        w.i("MicroMsg.AutoPlay", "onSensorEvent, isResumeFromDisableScreen:%b", Boolean.valueOf(this.vzI));
                        return;
                    }
                }
                return;
            }
            this.jXx = true;
        }
    }

    public final void bTS() {
        if (this.vzF != null) {
            this.vzF.dismiss();
        }
    }

    public final void yG() {
        w.i("MicroMsg.AutoPlay", "phone or record stop, resume and do nothing");
    }

    public final void yH() {
        w.i("MicroMsg.AutoPlay", "phone comming or record start, stop play");
        le(true);
        bTK();
    }

    public final void cW(int i) {
        w.i("MicroMsg.AutoPlay", "onBluetoothHeadsetStateChange, status: %d, isRequestStartBluetooth: %b", Integer.valueOf(i), Boolean.valueOf(this.fyV));
        switch (i) {
            case 1:
                if (this.vzL.hasMessages(0)) {
                    this.vzL.removeMessages(0);
                    this.vzL.sendEmptyMessage(0);
                    return;
                }
                return;
            case 2:
            case 4:
                if (this.vzL.hasMessages(0)) {
                    this.vzL.removeMessages(0);
                }
                if (this.fyV) {
                    e.qE().qH();
                    this.fyV = false;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
