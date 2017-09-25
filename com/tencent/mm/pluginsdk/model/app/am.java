package com.tencent.mm.pluginsdk.model.app;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class am {

    public static class a implements e {
        public static int fBq = 0;
        Queue<Long> fBi = new LinkedList();
        Queue<Long> fBj = new LinkedList();
        Map<Long, com.tencent.mm.compatible.util.g.a> fBk = new HashMap();
        public boolean fBl = false;
        public boolean fBm = false;
        public boolean fBn = false;
        public int fBo = 0;
        public long fBp = 0;
        com.tencent.mm.compatible.util.g.a fBs = new com.tencent.mm.compatible.util.g.a();
        public aj fBt = new aj(ap.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ a sEk;

            {
                this.sEk = r1;
            }

            public final boolean oQ() {
                this.sEk.pq();
                return false;
            }

            public final String toString() {
                return super.toString() + "|scenePusher";
            }
        }, false);
        public HashMap<Long, String> sEj = new HashMap();

        public a() {
            ap.vd().a(220, (e) this);
            ap.vd().a(221, (e) this);
            ap.vd().a(222, (e) this);
        }

        protected final void finalize() {
            ap.vd().b(220, (e) this);
            ap.vd().b(221, (e) this);
            ap.vd().b(222, (e) this);
            this.sEj.clear();
            super.finalize();
        }

        public final void s(long j, String str) {
            this.sEj.put(Long.valueOf(j), str);
        }

        public static void eg(long j) {
            ap.vd().a(new ah(j, null, null), 0);
        }

        public static void t(long j, String str) {
            ap.vd().a(new ah(j, str, null), 0);
        }

        public static void c(long j, String str, String str2) {
            ap.vd().a(new ah(j, str, str2), 0);
        }

        private boolean bDh() {
            List list;
            try {
                Cursor rawQuery = an.abL().rawQuery("select *  , rowid  from appattach where status = 101", new String[0]);
                if (rawQuery == null) {
                    list = null;
                } else {
                    int count = rawQuery.getCount();
                    w.d("MicroMsg.AppAttachInfoStorage", "getUnfinishInfo resCount:" + count);
                    if (count == 0) {
                        rawQuery.close();
                        list = null;
                    } else {
                        list = new ArrayList();
                        for (int i = 0; i < count; i++) {
                            rawQuery.moveToPosition(i);
                            b bVar = new b();
                            bVar.b(rawQuery);
                            list.add(bVar);
                        }
                        rawQuery.close();
                    }
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SceneAppMsg", e, "", new Object[0]);
                c abL = an.abL();
                abL.gUz.eE("appattach", " update appattach set status = 198 , lastModifyTime = " + bg.Ny() + " where status = 101");
                abL.doNotify();
                list = null;
            }
            if (r0 == null || r0.size() == 0) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String ev = bg.ev(currentTimeMillis);
            for (b bVar2 : r0) {
                if (this.fBk.containsKey(Long.valueOf(bVar2.uxb))) {
                    w.d("MicroMsg.SceneAppMsg", "summerbig File is Already running:" + bVar2.uxb);
                } else {
                    w.d("MicroMsg.SceneAppMsg", "summerbig Get file:" + bVar2.field_fileFullPath + " status:" + bVar2.field_status + " create:(" + bg.ev(bVar2.field_createTime) + "," + bg.ev(bVar2.field_createTime / 1000) + ", last:" + bg.ev(bVar2.field_lastModifyTime) + " now:" + bg.ev(currentTimeMillis) + " " + (currentTimeMillis - bVar2.field_lastModifyTime));
                    if (bVar2.field_isUpload) {
                        if (currentTimeMillis - bVar2.field_lastModifyTime <= 600 || bVar2.field_status != 101) {
                            this.fBi.offer(Long.valueOf(bVar2.uxb));
                            this.fBk.put(Long.valueOf(bVar2.uxb), null);
                        } else {
                            w.e("MicroMsg.SceneAppMsg", "summerbig time out file: " + bVar2.field_fileFullPath + " last:" + bg.ev(bVar2.field_lastModifyTime) + " now:" + ev);
                            l.ee(bVar2.uxb);
                        }
                    }
                }
            }
            w.d("MicroMsg.SceneAppMsg", "summerbig GetNeedRun procing:" + this.fBk.size() + " [recv:" + this.fBj.size() + ",send:" + this.fBi.size() + "]");
            if (this.fBj.size() + this.fBi.size() == 0) {
                return false;
            }
            return true;
        }

        public final void pq() {
            String str = null;
            w.d("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene recving[%b][%d], sending[%b][%d]", Boolean.valueOf(this.fBl), Integer.valueOf(this.fBj.size()), Boolean.valueOf(this.fBm), Integer.valueOf(this.fBi.size()));
            this.fBp = System.currentTimeMillis();
            if ((!this.fBl && this.fBj.size() == 0) || (!this.fBm && this.fBi.size() == 0)) {
                bDh();
            }
            if (!this.fBl && this.fBj.size() == 0 && !this.fBm && this.fBi.size() == 0) {
                pr();
                w.d("MicroMsg.SceneAppMsg", "summerbig No Data Any More , Stop Service");
            } else if (!this.fBm && this.fBi.size() > 0) {
                long a = bg.a((Long) this.fBi.poll(), -1);
                w.i("MicroMsg.SceneAppMsg", "summerbig Start Send :" + a);
                if (a != -1) {
                    this.fBk.put(Long.valueOf(a), new com.tencent.mm.compatible.util.g.a());
                    this.fBm = true;
                    c bVar = new b();
                    au cA;
                    if (an.abL().b(a, bVar)) {
                        if (bVar.field_type == 8) {
                            String str2;
                            ap.yY();
                            ce cA2 = com.tencent.mm.u.c.wT().cA(bVar.field_msgInfoId);
                            if (cA2.field_msgId == 0) {
                                w.e("MicroMsg.SceneAppMsg", "getEmoticonMd5 fail, msg is null :" + bVar.field_msgInfoId);
                                str2 = null;
                            } else {
                                com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(cA2.field_content);
                                str2 = ek != null ? ek.hhs : com.tencent.mm.storage.aj.RD(cA2.field_content).fFW;
                            }
                            if (str2 == null) {
                                w.e("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene fail, send emoji, emoticonMd5 can not be null");
                                ap.yY();
                                cA = com.tencent.mm.u.c.wT().cA(bVar.field_msgInfoId);
                                cA.dv(5);
                                ap.yY();
                                com.tencent.mm.u.c.wT().a(cA.field_msgId, cA);
                                this.fBm = false;
                                return;
                            }
                            str = str2;
                        }
                        ap.vd().a(new ak(a, str, (String) this.sEj.get(Long.valueOf(bVar.field_msgInfoId))), 0);
                        return;
                    }
                    w.e("MicroMsg.SceneAppMsg", "summerbig tryStartNetscene fail, getAttachInfo fail, infoId = " + a);
                    ap.yY();
                    cA = com.tencent.mm.u.c.wT().cA(bVar.field_msgInfoId);
                    cA.dv(5);
                    ap.yY();
                    com.tencent.mm.u.c.wT().a(cA.field_msgId, cA);
                    this.fBm = false;
                }
            }
        }

        public final void a(final int i, final int i2, String str, final k kVar) {
            w.d("MicroMsg.SceneAppMsg", "summersafecdn onSceneEnd type:%d errType:%d errCode:%d", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ a sEk;

                public final void run() {
                    int i;
                    long j;
                    long j2 = 0;
                    a.fBq++;
                    if (kVar.getType() == 222) {
                        w.d("MicroMsg.SceneAppMsg", "onSceneEnd  SendAppMsg errtype:" + i + " errCode:" + i2);
                        i = 0;
                        j = -1;
                    } else if (kVar.getType() == 221) {
                        this.sEk.fBl = false;
                        j = ((ab) kVar).sDI;
                        i = ((ab) kVar).fEX;
                    } else if (kVar.getType() == 220) {
                        boolean z;
                        this.sEk.fBm = false;
                        long j3 = ((ak) kVar).sDI;
                        int i2 = ((ak) kVar).fEX;
                        ak akVar = (ak) kVar;
                        String str = akVar.sDF == null ? null : akVar.sDF.field_mediaSvrId;
                        akVar = (ak) kVar;
                        String str2 = (String) this.sEk.sEj.remove(Long.valueOf(akVar.sDF == null ? 0 : akVar.sDF.field_msgInfoId));
                        if (bg.mA(((ak) kVar).hGx)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!(z || bg.mA(str))) {
                            c bVar = new b();
                            an.abL().b(j3, bVar);
                            if (bVar.uxb == j3) {
                                l.a(bVar.field_msgInfoId, str, null);
                                w.d("MicroMsg.SceneAppMsg", "onSceneEnd, finish update app attach, start send app msg");
                                a.t(bVar.field_msgInfoId, str2);
                            }
                        }
                        i = i2;
                        j = j3;
                    } else {
                        w.e("MicroMsg.SceneAppMsg", "onSceneEnd Error SceneType:" + kVar.getType());
                        a.fBq--;
                        return;
                    }
                    if (!(j == -1 || this.sEk.fBk.get(Long.valueOf(j)) == null)) {
                        j2 = ((com.tencent.mm.compatible.util.g.a) this.sEk.fBk.get(Long.valueOf(j))).se();
                        this.sEk.fBk.remove(Long.valueOf(j));
                    }
                    w.d("MicroMsg.SceneAppMsg", "onSceneEnd SceneType:" + kVar.getType() + " errtype:" + i + " errCode:" + i2 + " retCode:" + i + " rowid:" + j + " time:" + j2);
                    if (i == 3 && i != 0) {
                        a aVar = this.sEk;
                        aVar.fBo--;
                    } else if (i != 0) {
                        this.sEk.fBo = 0;
                    }
                    w.d("MicroMsg.SceneAppMsg", "onSceneEnd  inCnt:" + a.fBq + " stop:" + this.sEk.fBo + " running:" + this.sEk.fBn + " recving:" + this.sEk.fBl + " sending:" + this.sEk.fBm);
                    if (this.sEk.fBo > 0) {
                        this.sEk.pq();
                    } else if (!(this.sEk.fBm || this.sEk.fBl)) {
                        this.sEk.pr();
                    }
                    a.fBq--;
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
            w.d("MicroMsg.SceneAppMsg", "Finish service use time(ms):" + this.fBs.se());
        }

        public final void run() {
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ a sEk;

                {
                    this.sEk = r1;
                }

                public final void run() {
                    long currentTimeMillis = System.currentTimeMillis() - this.sEk.fBp;
                    w.d("MicroMsg.SceneAppMsg", "summerbig Try Run service runningFlag:" + this.sEk.fBn + " timeWait:" + currentTimeMillis + " sending:" + this.sEk.fBm + " recving:" + this.sEk.fBl);
                    if (this.sEk.fBn) {
                        if (currentTimeMillis >= 180000) {
                            w.e("MicroMsg.SceneAppMsg", "summerbig ERR: Try Run service runningFlag:" + this.sEk.fBn + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.sEk.fBm + " recving:" + this.sEk.fBl);
                        } else {
                            return;
                        }
                    }
                    this.sEk.fBn = true;
                    this.sEk.fBm = false;
                    this.sEk.fBo = 4;
                    this.sEk.fBl = false;
                    this.sEk.fBs.gSO = SystemClock.elapsedRealtime();
                    this.sEk.fBt.v(10, 10);
                }

                public final String toString() {
                    return super.toString() + "|run";
                }
            });
        }
    }
}
