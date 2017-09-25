package com.tencent.mm.modelvideo;

import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.appbrand.jsapi.g.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import junit.framework.Assert;

public final class x {
    public static String iaS = null;

    public static class a implements e {
        public static int fBq = 0;
        Queue<String> fBi = new LinkedList();
        Queue<String> fBj = new LinkedList();
        Map<String, com.tencent.mm.compatible.util.g.a> fBk = new HashMap();
        public boolean fBl = false;
        public boolean fBm = false;
        public boolean fBn = false;
        public int fBo = 0;
        public long fBp = 0;
        com.tencent.mm.compatible.util.g.a fBs = new com.tencent.mm.compatible.util.g.a();
        public aj fBt = null;
        HandlerThread iaT = com.tencent.mm.sdk.f.e.cE("VideoService_runThread", 0);
        ae iaU;
        boolean iaV = false;
        public List<v> iaW = new ArrayList();
        Queue<String> iaX = new LinkedList();
        Queue<String> iaY = new LinkedList();
        public d iaZ = null;
        public g iba = null;

        public a() {
            h.vd().a((int) c.CTRL_INDEX, (e) this);
            h.vd().a((int) ck.CTRL_INDEX, (e) this);
            this.iaT.start();
            this.iaV = true;
            this.iaU = new ae(this.iaT.getLooper());
            this.fBt = new aj(this.iaT.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
                final /* synthetic */ a ibb;

                {
                    this.ibb = r1;
                }

                public final boolean oQ() {
                    this.ibb.pq();
                    return false;
                }

                public final String toString() {
                    return super.toString() + "|scenePusher";
                }
            }, false);
            w.i("MicroMsg.VideoService", "create VideoService, start video send thread");
        }

        public final void pq() {
            String str;
            boolean z = true;
            this.fBp = System.currentTimeMillis();
            if ((!this.fBl && this.fBj.size() + this.iaX.size() == 0) || (!this.fBm && this.fBi.size() == 0)) {
                long NA = bg.NA();
                List<String> Lr = o.KV().Lr();
                List<String> Lo = o.KV().Lo();
                List<String> Lp = o.KV().Lp();
                List<String> Lq = o.KV().Lq();
                if (Lr != null) {
                    w.d("MicroMsg.VideoService", "getNeedRunInfo needSendList size: " + Lr.size());
                    for (String str2 : Lr) {
                        if (this.fBk.containsKey(str2)) {
                            w.d("MicroMsg.VideoService", "need sendList File is Already running:" + str2);
                        } else {
                            this.fBi.offer(str2);
                            this.fBk.put(str2, null);
                        }
                    }
                }
                if (Lo != null) {
                    w.d("MicroMsg.VideoService", "getNeedRunInfo needRecvList size: " + Lo.size());
                    for (String str22 : Lo) {
                        if (this.fBk.containsKey(str22)) {
                            w.d("MicroMsg.VideoService", "need recvList File is Already running:" + str22);
                        } else {
                            this.fBj.offer(str22);
                            this.fBk.put(str22, null);
                        }
                    }
                }
                if (Lp != null) {
                    w.d("MicroMsg.VideoService", "getNeedRunInfo online video list size: " + Lp.size());
                    for (String str222 : Lp) {
                        if (this.fBk.containsKey(str222)) {
                            w.d("MicroMsg.VideoService", "online videoList File is Already running:" + str222);
                        } else {
                            this.iaX.offer(str222);
                            this.fBk.put(str222, null);
                        }
                    }
                }
                if (Lq != null) {
                    w.d("MicroMsg.VideoService", "getNeedRunInfo hevc video list size: " + Lq.size());
                    for (String str2222 : Lq) {
                        if (this.fBk.containsKey(str2222)) {
                            w.d("MicroMsg.VideoService", "hevc videoList File is Already running:" + str2222);
                        } else {
                            this.iaY.offer(str2222);
                            this.fBk.put(str2222, null);
                        }
                    }
                }
                w.i("MicroMsg.VideoService", "GetNeedRun cost time[%d] procing[%d] [recv:%d, online:%d, send:%d hevc:%d]", Long.valueOf(bg.aB(NA)), Integer.valueOf(this.fBk.size()), Integer.valueOf(this.fBj.size()), Integer.valueOf(this.iaX.size()), Integer.valueOf(this.fBi.size()), Integer.valueOf(this.iaY.size()));
                this.fBj.size();
                this.fBi.size();
                this.iaX.size();
                this.iaY.size();
            }
            int i = (this.iaY.size() == 0 || !d.EC()) ? true : 0;
            if (this.fBl || this.fBj.size() + this.iaX.size() != 0 || i == 0 || this.fBm || this.fBi.size() != 0) {
                if (!this.fBl && (this.fBj.size() > 0 || this.iaX.size() > 0 || i == 0)) {
                    if (this.iaX.size() > 0) {
                        str2222 = (String) this.iaX.poll();
                        w.i("MicroMsg.VideoService", "Start Recv :" + str2222);
                        if (!bg.mA(str2222)) {
                            this.fBk.put(str2222, new com.tencent.mm.compatible.util.g.a());
                            this.fBl = true;
                            Assert.assertTrue("sceneDown should null", this.iaZ == null);
                            this.iaZ = new d(str2222, true);
                            h.vd().a(this.iaZ, 0);
                        }
                    }
                    if (!this.fBl && this.fBj.size() > 0) {
                        str2222 = (String) this.fBj.poll();
                        w.i("MicroMsg.VideoService", "Start Recv :" + str2222);
                        if (str2222 != null) {
                            this.fBk.put(str2222, new com.tencent.mm.compatible.util.g.a());
                            this.fBl = true;
                            Assert.assertTrue("sceneDown should null", this.iaZ == null);
                            this.iaZ = new d(str2222);
                            h.vd().a(this.iaZ, 0);
                        }
                    }
                    if (!this.fBl) {
                        str2222 = (String) this.iaY.poll();
                        w.i("MicroMsg.VideoService", "Start recv hecv: " + str2222);
                        if (!bg.mA(str2222)) {
                            this.fBk.put(str2222, new com.tencent.mm.compatible.util.g.a());
                            this.fBl = true;
                            Assert.assertTrue("sceneDown should null", this.iaZ == null);
                            this.iaZ = new d(str2222, true);
                            h.vd().a(this.iaZ, 0);
                        }
                    }
                }
                if (!this.fBm && this.fBi.size() > 0) {
                    str2222 = (String) this.fBi.poll();
                    w.i("MicroMsg.VideoService", "Start Send :" + str2222);
                    if (str2222 != null) {
                        this.fBk.put(str2222, new com.tencent.mm.compatible.util.g.a());
                        this.fBm = true;
                        String str3 = "sceneUp should null";
                        if (this.iba != null) {
                            z = false;
                        }
                        Assert.assertTrue(str3, z);
                        if (this.iaW != null && this.iaW.size() > 0) {
                            for (v lM : this.iaW) {
                                lM.lM(str2222);
                            }
                        }
                        this.iba = new g(str2222);
                        h.vd().a(this.iba, 0);
                        return;
                    }
                    return;
                }
                return;
            }
            pr();
            w.d("MicroMsg.VideoService", "No Data Any More , Stop Service");
        }

        public final void a(final int i, final int i2, String str, final k kVar) {
            if (this.iaT == null || !this.iaV || this.iaU == null) {
                w.e("MicroMsg.VideoService", "onSceneEnd error!, handler or thread is null!");
            } else {
                this.iaU.post(new Runnable(this) {
                    final /* synthetic */ a ibb;

                    public final void run() {
                        int i;
                        String str;
                        a.fBq++;
                        String str2;
                        if (kVar.getType() == ck.CTRL_INDEX) {
                            this.ibb.fBl = false;
                            str2 = ((d) kVar).fyF;
                            x.iaS = str2;
                            int i2 = ((d) kVar).fEX;
                            this.ibb.iaZ = null;
                            i = i2;
                            str = str2;
                        } else if (kVar.getType() == c.CTRL_INDEX) {
                            this.ibb.fBm = false;
                            this.ibb.iba = null;
                            if (kVar instanceof g) {
                                str2 = ((g) kVar).fyF;
                                i = ((g) kVar).fEX;
                                str = str2;
                            } else if (kVar instanceof h) {
                                i = 0;
                                str = ((h) kVar).fyF;
                            } else {
                                str = null;
                                i = 0;
                            }
                        } else {
                            w.e("MicroMsg.VideoService", "onSceneEnd Error SceneType:" + kVar.getType());
                            a.fBq--;
                            return;
                        }
                        long j = 0;
                        if (!(str == null || this.ibb.fBk.get(str) == null)) {
                            j = ((com.tencent.mm.compatible.util.g.a) this.ibb.fBk.get(str)).se();
                            this.ibb.fBk.remove(str);
                        }
                        w.d("MicroMsg.VideoService", "onSceneEnd SceneType:" + kVar.getType() + " errtype:" + i + " errCode:" + i2 + " retCode:" + i + " file:" + str + " time:" + j);
                        if (i == 3 && i != 0) {
                            a aVar = this.ibb;
                            aVar.fBo--;
                        } else if (i != 0) {
                            this.ibb.fBo = 0;
                        }
                        w.d("MicroMsg.VideoService", "onSceneEnd  inCnt:" + a.fBq + " stop:" + this.ibb.fBo + " running:" + this.ibb.fBn + " recving:" + this.ibb.fBl + " sending:" + this.ibb.fBm);
                        if (this.ibb.fBo > 0) {
                            this.ibb.pq();
                        } else if (!(this.ibb.fBm || this.ibb.fBl)) {
                            this.ibb.pr();
                        }
                        a.fBq--;
                    }

                    public final String toString() {
                        return super.toString() + "|onSceneEnd";
                    }
                });
            }
        }

        public final void pr() {
            this.fBk.clear();
            this.fBi.clear();
            this.fBj.clear();
            this.iaX.clear();
            this.iaY.clear();
            this.fBm = false;
            this.fBl = false;
            this.fBn = false;
            w.i("MicroMsg.VideoService", "Finish service use time(ms):" + this.fBs.se());
        }

        public final void run() {
            if (this.iaT == null || !this.iaV || this.iaU == null) {
                w.e("MicroMsg.VideoService", "run error!, handler or thread is null!");
            } else {
                this.iaU.post(new Runnable(this) {
                    final /* synthetic */ a ibb;

                    {
                        this.ibb = r1;
                    }

                    public final void run() {
                        long currentTimeMillis = System.currentTimeMillis() - this.ibb.fBp;
                        w.d("MicroMsg.VideoService", "Try Run service runningFlag:" + this.ibb.fBn + " timeWait:" + currentTimeMillis + " sending:" + this.ibb.fBm + " recving:" + this.ibb.fBl);
                        if (this.ibb.fBn) {
                            if (currentTimeMillis >= 60000) {
                                w.e("MicroMsg.VideoService", "ERR: Try Run service runningFlag:" + this.ibb.fBn + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.ibb.fBm + " recving:" + this.ibb.fBl);
                            } else {
                                return;
                            }
                        }
                        this.ibb.fBo = 3;
                        this.ibb.fBn = true;
                        this.ibb.fBm = false;
                        this.ibb.fBl = false;
                        this.ibb.iba = null;
                        this.ibb.iaZ = null;
                        this.ibb.fBs.gSO = SystemClock.elapsedRealtime();
                        this.ibb.fBt.v(10, 10);
                    }

                    public final String toString() {
                        return super.toString() + "|run";
                    }
                });
            }
        }

        public final boolean Lt() {
            boolean pd;
            if (this.iaZ != null) {
                pd = this.iaZ.pd();
                this.fBn = false;
            } else {
                pd = false;
            }
            this.fBk.clear();
            this.fBi.clear();
            this.fBj.clear();
            this.iaX.clear();
            this.iaY.clear();
            return pd;
        }
    }
}
