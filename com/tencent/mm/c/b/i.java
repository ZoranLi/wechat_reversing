package com.tencent.mm.c.b;

import android.os.SystemClock;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class i implements e {
    public static int fBq = 0;
    public static boolean fBr = true;
    Queue<String> fBi = new LinkedList();
    Queue<p> fBj = new LinkedList();
    Map<String, a> fBk = new HashMap();
    public boolean fBl = false;
    public boolean fBm = false;
    public boolean fBn = false;
    public int fBo = 0;
    public long fBp = 0;
    a fBs = new a();
    public aj fBt = new aj(h.vL().nJF.getLooper(), new aj.a(this) {
        final /* synthetic */ i fBx;

        {
            this.fBx = r1;
        }

        public final boolean oQ() {
            w.d("MicroMsg.SceneVoiceService", "onTimerExpired");
            this.fBx.pq();
            return false;
        }

        public final String toString() {
            return super.toString() + "|scenePusher";
        }
    }, false);

    public i() {
        h.vd().a(127, (e) this);
        h.vd().a((int) FileUtils.S_IWUSR, (e) this);
    }

    public final void pq() {
        p pVar;
        this.fBp = System.currentTimeMillis();
        if ((!this.fBl && this.fBj.size() == 0) || (!this.fBm && this.fBi.size() == 0)) {
            List<p> LD = q.LD();
            if (!(LD == null || LD.size() == 0)) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String ev = bg.ev(currentTimeMillis);
                for (p pVar2 : LD) {
                    if (this.fBk.containsKey(pVar2.fyF)) {
                        w.d("MicroMsg.SceneVoiceService", "File is Already running:" + pVar2.fyF);
                    } else {
                        w.i("MicroMsg.SceneVoiceService", "Get file:" + pVar2.fyF + " status:" + pVar2.status + " user" + pVar2.fSf + " human:" + pVar2.iah + " create:" + bg.ev(pVar2.iam) + " last:" + bg.ev(pVar2.ian) + " now:" + bg.ev(currentTimeMillis) + " " + (currentTimeMillis - pVar2.ian));
                        if (pVar2.LB()) {
                            if (currentTimeMillis - pVar2.ian > 80 && pVar2.status == 5) {
                                w.e("MicroMsg.SceneVoiceService", "time out file: " + pVar2.fyF + " last:" + bg.ev(pVar2.ian) + " now:" + ev + " msgLocalId:" + pVar2.iaq + " status:" + pVar2.status);
                                if (pVar2.iaq == 0) {
                                    pVar2.ian = System.currentTimeMillis() / 1000;
                                    pVar2.fRW = 320;
                                    m.Ly().a(pVar2.fyF, pVar2);
                                } else {
                                    q.lA(pVar2.fyF);
                                }
                            }
                            if (currentTimeMillis - pVar2.ian > 300 && pVar2.status == 6) {
                                w.e("MicroMsg.SceneVoiceService", "time out file: " + pVar2.fyF + " last:" + bg.ev(pVar2.ian) + " now:" + ev + " msgLocalId:" + pVar2.iaq + " status:" + pVar2.status);
                                if (pVar2.iaq == 0) {
                                    pVar2.ian = System.currentTimeMillis() / 1000;
                                    pVar2.fRW = 320;
                                    m.Ly().a(pVar2.fyF, pVar2);
                                } else {
                                    q.lA(pVar2.fyF);
                                }
                            }
                            if (pVar2.iaj >= pVar2.hYV) {
                                w.i("MicroMsg.SceneVoiceService", "file: " + pVar2.fyF + " stat:" + pVar2.status + " now:" + pVar2.iaj + " net:" + pVar2.hYV);
                            } else {
                                this.fBj.offer(pVar2);
                                this.fBk.put(pVar2.fyF, null);
                            }
                        }
                        if (pVar2.LC()) {
                            w.i("MicroMsg.SceneVoiceService", "now " + currentTimeMillis + "info.getLastModifyTime()  " + pVar2.ian + "  info.getStatus() " + pVar2.status + "  info.getCreateTime() " + pVar2.iam);
                            if (currentTimeMillis - pVar2.ian > 10 && (pVar2.status == 2 || pVar2.status == 1)) {
                                w.e("MicroMsg.SceneVoiceService", "time out file: " + pVar2.fyF + " last:" + bg.ev(pVar2.ian) + " now:" + ev);
                                q.lA(pVar2.fyF);
                            } else if (currentTimeMillis - pVar2.iam > 600 && pVar2.status == 3) {
                                w.e("MicroMsg.SceneVoiceService", "time out file: " + pVar2.fyF + " last:" + bg.ev(pVar2.ian) + " now:" + ev);
                                q.lA(pVar2.fyF);
                            } else if (pVar2.fSf.length() <= 0) {
                                w.e("MicroMsg.SceneVoiceService", "Create a new ChatRoom? , set username first :" + pVar2.fyF);
                            } else {
                                this.fBi.offer(pVar2.fyF);
                                this.fBk.put(pVar2.fyF, null);
                            }
                        }
                    }
                }
                w.i("MicroMsg.SceneVoiceService", "GetNeedRun procing:" + this.fBk.size() + " [recv:" + this.fBj.size() + ",send:" + this.fBi.size() + "]");
                this.fBj.size();
                this.fBi.size();
            }
        }
        if (this.fBl || this.fBj.size() != 0 || this.fBm || this.fBi.size() != 0) {
            if (!this.fBl && this.fBj.size() > 0) {
                Object obj;
                pVar2 = (p) this.fBj.poll();
                String str = pVar2.fyF;
                if (((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cC(pVar2.fTQ)) {
                    w.i("MicroMsg.SceneVoiceService", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", Long.valueOf(pVar2.fTQ));
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    w.i("MicroMsg.SceneVoiceService", "Start Recv :" + str);
                    if (str != null) {
                        this.fBk.put(str, new a());
                        this.fBl = true;
                        h.vd().a(new com.tencent.mm.modelvoice.e(pVar2), 0);
                    }
                } else if (bg.mz(pVar2.fyF).length() > 0) {
                    m.Ly().gR(pVar2.fyF);
                    return;
                } else {
                    w.i("MicroMsg.SceneVoiceService", "[oneliang] the length of voice info file name is zero");
                    return;
                }
            }
            if (!this.fBm && this.fBi.size() > 0) {
                String str2 = (String) this.fBi.poll();
                w.i("MicroMsg.SceneVoiceService", "Start Send :" + str2);
                if (str2 != null) {
                    this.fBk.put(str2, new a());
                    this.fBm = true;
                    h.vd().a(new f(str2), 0);
                    return;
                }
                return;
            }
            return;
        }
        pr();
        w.i("MicroMsg.SceneVoiceService", "No Data Any More , Stop Service");
    }

    public final void a(final int i, final int i2, String str, final k kVar) {
        h.vL().D(new Runnable(this) {
            final /* synthetic */ i fBx;

            public final void run() {
                int i;
                String str;
                i.fBq++;
                String str2;
                if (kVar.getType() == FileUtils.S_IWUSR) {
                    this.fBx.fBl = false;
                    str2 = ((com.tencent.mm.modelvoice.e) kVar).fyF;
                    i = ((com.tencent.mm.modelvoice.e) kVar).fEX;
                    str = str2;
                } else if (kVar.getType() == 127) {
                    this.fBx.fBm = false;
                    str2 = ((f) kVar).fyF;
                    i = ((f) kVar).fEX;
                    str = str2;
                } else {
                    w.e("MicroMsg.SceneVoiceService", "onSceneEnd Error SceneType:" + kVar.getType());
                    i.fBq--;
                    return;
                }
                long j = 0;
                if (!(str == null || this.fBx.fBk.get(str) == null)) {
                    j = ((a) this.fBx.fBk.get(str)).se();
                    this.fBx.fBk.remove(str);
                }
                w.i("MicroMsg.SceneVoiceService", "onSceneEnd SceneType:" + kVar.getType() + " errtype:" + i + " errCode:" + i2 + " retCode:" + i + " file:" + str + " time:" + j);
                if (i == 3 && i != 0) {
                    i iVar = this.fBx;
                    iVar.fBo--;
                } else if (i != 0) {
                    this.fBx.fBo = 0;
                }
                w.i("MicroMsg.SceneVoiceService", "onSceneEnd  inCnt:" + i.fBq + " stop:" + this.fBx.fBo + " running:" + this.fBx.fBn + " recving:" + this.fBx.fBl + " sending:" + this.fBx.fBm);
                if (this.fBx.fBo > 0) {
                    this.fBx.pq();
                } else if (!(this.fBx.fBm || this.fBx.fBl)) {
                    this.fBx.pr();
                    w.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try next delay 3s [%d, %d] [%b]", Integer.valueOf(i), Integer.valueOf(i), Boolean.valueOf(i.fBr));
                    if (i.fBr && i == 4) {
                        h.vL().e(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 fBy;

                            {
                                this.fBy = r1;
                            }

                            public final void run() {
                                w.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try run");
                                this.fBy.fBx.run();
                            }
                        }, 10000);
                    }
                }
                i.fBq--;
            }

            public final String toString() {
                return super.toString() + "|onSceneEnd";
            }
        });
    }

    public final void pr() {
        this.fBk.clear();
        this.fBi.clear();
        this.fBj.clear();
        this.fBm = false;
        this.fBl = false;
        this.fBn = false;
        w.i("MicroMsg.SceneVoiceService", "Finish service use time(ms):" + this.fBs.se());
    }

    public final void run() {
        h.vL().D(new Runnable(this) {
            final /* synthetic */ i fBx;

            {
                this.fBx = r1;
            }

            public final void run() {
                long currentTimeMillis = System.currentTimeMillis() - this.fBx.fBp;
                w.i("MicroMsg.SceneVoiceService", "Try Run service runningFlag:" + this.fBx.fBn + " timeWait:" + currentTimeMillis + " sending:" + this.fBx.fBm + " recving:" + this.fBx.fBl);
                if (this.fBx.fBn) {
                    if (currentTimeMillis >= 60000) {
                        w.e("MicroMsg.SceneVoiceService", "ERR: Try Run service runningFlag:" + this.fBx.fBn + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.fBx.fBm + " recving:" + this.fBx.fBl);
                    } else {
                        return;
                    }
                }
                this.fBx.fBn = true;
                this.fBx.fBm = false;
                this.fBx.fBo = 3;
                this.fBx.fBl = false;
                this.fBx.fBs.gSO = SystemClock.elapsedRealtime();
                this.fBx.fBt.v(10, 10);
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
    }
}
