package com.tencent.mm.plugin.record.a;

import android.database.Cursor;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class p implements com.tencent.mm.plugin.record.a.i.a, com.tencent.mm.y.e {
    public boolean oOj = false;
    public SparseArray<e> oOm = new SparseArray();
    LinkedList<k> oOn = new LinkedList();

    private class a implements Runnable {
        final /* synthetic */ p oOD;
        private k oOg;

        public a(p pVar, k kVar) {
            this.oOD = pVar;
            this.oOg = kVar;
        }

        public final void run() {
            Iterator it = this.oOg.field_dataProto.tzn.iterator();
            boolean z = false;
            while (it.hasNext()) {
                String c;
                rm rmVar = (rm) it.next();
                if (!bg.mA(rmVar.txi) || com.tencent.mm.a.e.aO(rmVar.txG)) {
                    String str;
                    str = rmVar.txG;
                    c = m.c(rmVar, this.oOg.field_msgId);
                    w.d("MicroMsg.RecordMsgSendService", "summerrecord CdnDataUrl[%s] copy[%s] to [%s] result[%B]", rmVar.txi, str, c, Boolean.valueOf(j.p(str, c, false)));
                    if (j.p(str, c, false)) {
                        if (bg.mA(rmVar.txz)) {
                            w.i("MicroMsg.RecordMsgSendService", "summerrecord not find full md5, try to calculate");
                            rmVar.NW(g.aV(c));
                            z = true;
                        }
                        if (bg.mA(rmVar.txB)) {
                            w.i("MicroMsg.RecordMsgSendService", "summerrecord not find head 256 md5, try to calculate");
                            rmVar.NX(g.aW(c));
                            z = true;
                        }
                    }
                    if (com.tencent.mm.a.e.aN(c) != 0) {
                        rmVar.ej((long) com.tencent.mm.a.e.aN(c));
                    }
                    str = m.d(rmVar.lKv, this.oOg.field_msgId, false);
                    if (s.aWF().Do(str) == null) {
                        g gVar = new g();
                        gVar.field_cdnKey = rmVar.txk;
                        gVar.field_cdnUrl = rmVar.txi;
                        gVar.field_dataId = rmVar.lKv;
                        gVar.field_mediaId = str;
                        gVar.field_totalLen = (int) rmVar.txD;
                        gVar.field_localId = gVar.field_mediaId.hashCode();
                        gVar.field_path = m.c(rmVar, this.oOg.field_msgId);
                        gVar.field_type = 2;
                        gVar.field_fileType = m.rS(rmVar.aMw);
                        gVar.field_recordLocalId = this.oOg.field_localId;
                        gVar.field_toUser = this.oOg.field_toUser;
                        gVar.field_isThumb = false;
                        boolean a = s.aWF().a(gVar);
                        w.d("MicroMsg.RecordMsgSendService", "summerrecord insert localId[%d] result[%B] fileType[%d], mediaId[%s]", Integer.valueOf(gVar.field_localId), Boolean.valueOf(a), Integer.valueOf(gVar.field_fileType), str);
                    }
                }
                if (!bg.mA(rmVar.hhy) || com.tencent.mm.a.e.aO(rmVar.txI)) {
                    str = rmVar.txI;
                    c = m.f(rmVar, this.oOg.field_msgId);
                    w.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", str, c, Boolean.valueOf(j.p(str, c, false)));
                    rmVar.ek((long) com.tencent.mm.a.e.aN(c));
                    if (j.p(str, c, false)) {
                        if (bg.mA(rmVar.txK)) {
                            w.i("MicroMsg.RecordMsgSendService", "not find ThumbMd5 md5, try to calculate");
                            rmVar.Ob(g.aV(c));
                            z = true;
                        }
                        if (bg.mA(rmVar.txM)) {
                            w.i("MicroMsg.RecordMsgSendService", "not find Thumb Head 256 Md5, try to calculate");
                            rmVar.Oc(g.aW(c));
                            z = true;
                        }
                    }
                    str = m.vZ(rmVar.lKv);
                    c = m.d(str, this.oOg.field_msgId, false);
                    if (s.aWF().Do(c) == null) {
                        g gVar2 = new g();
                        gVar2.field_cdnKey = rmVar.txe;
                        gVar2.field_cdnUrl = rmVar.hhy;
                        gVar2.field_dataId = str;
                        gVar2.field_mediaId = c;
                        gVar2.field_totalLen = (int) rmVar.txO;
                        gVar2.field_localId = gVar2.field_mediaId.hashCode();
                        gVar2.field_path = m.f(rmVar, this.oOg.field_msgId);
                        gVar2.field_type = 2;
                        gVar2.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
                        gVar2.field_recordLocalId = this.oOg.field_localId;
                        gVar2.field_toUser = this.oOg.field_toUser;
                        gVar2.field_isThumb = true;
                        boolean a2 = s.aWF().a(gVar2);
                        w.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", Integer.valueOf(gVar2.field_localId), Boolean.valueOf(a2));
                    }
                }
                z = z;
            }
            if (z) {
                w.d("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", Integer.valueOf(this.oOg.field_localId), Long.valueOf(this.oOg.field_msgId), Integer.valueOf(this.oOg.field_type));
                s.aWE().c(this.oOg, "localId");
            }
            s.aWH().run();
        }
    }

    private class c implements Runnable {
        final /* synthetic */ p oOD;
        private k oOg;

        public c(p pVar, k kVar) {
            this.oOD = pVar;
            this.oOg = kVar;
        }

        public final void run() {
            Iterator it = this.oOg.field_dataProto.tzn.iterator();
            while (it.hasNext()) {
                rm rmVar = (rm) it.next();
                com.tencent.mm.sdk.b.b fpVar = new fp();
                fpVar.fKp.type = 2;
                fpVar.fKp.fKr = rmVar;
                com.tencent.mm.sdk.b.a.urY.m(fpVar);
                w.d("MicroMsg.RecordMsgSendService", "check dataid[%s] type[%d]", rmVar.lKv, Integer.valueOf(rmVar.aMw));
                if (!bg.mA(fpVar.fKq.path)) {
                    String c = m.c(rmVar, this.oOg.field_msgId);
                    w.d("MicroMsg.RecordMsgSendService", "check data ok, try copy[%s] to[%s]", fpVar.fKq.path, c);
                    if (!fpVar.fKq.path.equals(c)) {
                        j.p(fpVar.fKq.path, c, false);
                    }
                }
                if (!bg.mA(fpVar.fKq.fKz)) {
                    String f = m.f(rmVar, this.oOg.field_msgId);
                    w.d("MicroMsg.RecordMsgSendService", "check thumb ok, try copy[%s] to[%s]", fpVar.fKq.fKz, f);
                    if (!fpVar.fKq.fKz.equals(f)) {
                        j.p(fpVar.fKq.fKz, f, false);
                    }
                }
            }
            ap.vd().a(new a(this.oOg), 0);
        }
    }

    private class d implements Runnable {
        final /* synthetic */ p oOD;
        private k oOg;

        public d(p pVar, k kVar) {
            this.oOD = pVar;
            this.oOg = kVar;
        }

        public final void run() {
            Iterator it = this.oOg.field_dataProto.tzn.iterator();
            boolean z = false;
            while (it.hasNext()) {
                String c;
                rm rmVar = (rm) it.next();
                if (!bg.mA(rmVar.txi)) {
                    String c2;
                    c2 = m.c(rmVar, this.oOg.field_oriMsgId);
                    c = m.c(rmVar, this.oOg.field_msgId);
                    w.d("MicroMsg.RecordMsgSendService", "copy[%s] to [%s] result[%B]", c2, c, Boolean.valueOf(j.p(c2, c, false)));
                    if (j.p(c2, c, false)) {
                        if (bg.mA(rmVar.txz)) {
                            w.i("MicroMsg.RecordMsgSendService", "not find full md5, try to calculate");
                            rmVar.NW(g.aV(c));
                            z = true;
                        }
                        if (bg.mA(rmVar.txB)) {
                            w.i("MicroMsg.RecordMsgSendService", "not find head 256 md5, try to calculate");
                            rmVar.NX(g.aW(c));
                            z = true;
                        }
                    }
                    c2 = m.d(rmVar.lKv, this.oOg.field_msgId, false);
                    if (s.aWF().Do(c2) == null) {
                        g gVar = new g();
                        gVar.field_cdnKey = rmVar.txk;
                        gVar.field_cdnUrl = rmVar.txi;
                        gVar.field_dataId = rmVar.lKv;
                        gVar.field_mediaId = c2;
                        gVar.field_totalLen = (int) rmVar.txD;
                        gVar.field_localId = gVar.field_mediaId.hashCode();
                        gVar.field_path = m.c(rmVar, this.oOg.field_msgId);
                        gVar.field_type = 2;
                        gVar.field_fileType = m.rS(rmVar.aMw);
                        gVar.field_recordLocalId = this.oOg.field_localId;
                        gVar.field_toUser = this.oOg.field_toUser;
                        gVar.field_isThumb = false;
                        boolean a = s.aWF().a(gVar);
                        w.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", Integer.valueOf(gVar.field_localId), Boolean.valueOf(a));
                    }
                }
                if (!bg.mA(rmVar.hhy)) {
                    boolean p = j.p(m.f(rmVar, this.oOg.field_oriMsgId), m.f(rmVar, this.oOg.field_msgId), false);
                    w.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", c2, c, Boolean.valueOf(p));
                    c2 = m.vZ(rmVar.lKv);
                    c = m.d(c2, this.oOg.field_msgId, false);
                    if (s.aWF().Do(c) == null) {
                        g gVar2 = new g();
                        gVar2.field_cdnKey = rmVar.txe;
                        gVar2.field_cdnUrl = rmVar.hhy;
                        gVar2.field_dataId = c2;
                        gVar2.field_mediaId = c;
                        gVar2.field_totalLen = (int) rmVar.txO;
                        gVar2.field_localId = gVar2.field_mediaId.hashCode();
                        gVar2.field_path = m.f(rmVar, this.oOg.field_msgId);
                        gVar2.field_type = 2;
                        gVar2.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
                        gVar2.field_recordLocalId = this.oOg.field_localId;
                        gVar2.field_toUser = this.oOg.field_toUser;
                        gVar2.field_isThumb = true;
                        boolean a2 = s.aWF().a(gVar2);
                        w.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", Integer.valueOf(gVar2.field_localId), Boolean.valueOf(a2));
                    }
                }
            }
            if (z) {
                w.d("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", Integer.valueOf(this.oOg.field_localId), Long.valueOf(this.oOg.field_msgId), Integer.valueOf(this.oOg.field_type));
                s.aWE().c(this.oOg, "localId");
            }
            s.aWH().run();
        }
    }

    private static final class e {
        int ihV = 3;
        long oOp = SystemClock.elapsedRealtime();
    }

    private class b implements com.tencent.mm.modelvideo.s.a, com.tencent.mm.y.e, Runnable {
        public int i = 0;
        public boolean miY = false;
        HashMap<Long, Boolean> oOA = new HashMap();
        final /* synthetic */ p oOD;
        HashMap<Long, String> oOE = new HashMap();
        public k oOg;

        public b(p pVar, k kVar) {
            this.oOD = pVar;
            this.oOg = kVar;
            o.KV().a(this, Looper.getMainLooper());
            ap.vd().a(221, (com.tencent.mm.y.e) this);
        }

        public final void run() {
            this.i = 0;
            this.miY = false;
            Iterator it = this.oOg.field_dataProto.tzn.iterator();
            while (it.hasNext()) {
                rm rmVar = (rm) it.next();
                final long j = rmVar.tyo;
                if (j > 0) {
                    ap.yY();
                    final au cA = com.tencent.mm.u.c.wT().cA(j);
                    String str = rmVar.txG;
                    Object obj = (System.currentTimeMillis() - cA.field_createTime <= 259200000 || (!bg.mA(str) && com.tencent.mm.a.e.aO(str))) ? null : 1;
                    if (obj != null) {
                        w.i("MicroMsg.RecordMsgSendService", "dataItem is expired!! msgType:%s", Integer.valueOf(cA.field_type));
                    } else if (rmVar.aMw == 2) {
                        if (cA.bMh()) {
                            int i;
                            final com.tencent.mm.ah.d ai = n.GS().ai(cA.field_msgSvrId);
                            if (cA.field_isSend == 1) {
                                int i2;
                                if (ai.GB()) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                i = i2;
                            } else if (ai.GB()) {
                                if (com.tencent.mm.a.e.aO(n.GS().m(com.tencent.mm.ah.e.a(ai).hEZ, "", ""))) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                            } else {
                                i = 0;
                            }
                            if (ai.offset < ai.hrs || ai.hrs == 0) {
                                this.oOA.put(Long.valueOf(j), Boolean.valueOf(false));
                                this.i = this.oOg.field_dataProto.tzn.indexOf(rmVar);
                                n.GT().a(ai.hEY, cA.field_msgId, i, rmVar, cA.field_isSend == 1 ? R.g.bdJ : R.g.bdH, new com.tencent.mm.ah.c.a(this) {
                                    final /* synthetic */ b oOG;

                                    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, k kVar) {
                                    }

                                    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, k kVar) {
                                        boolean z = i3 == 0 && i4 == 0;
                                        w.i("MicroMsg.RecordMsgSendService", "download image succed: %s, errType: %s, errCode:%s", Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4));
                                        if (obj instanceof rm) {
                                            rm rmVar = (rm) obj;
                                            rmVar.NZ(n.GS().m(com.tencent.mm.ah.e.c(ai), "", ""));
                                            rmVar.Oa(n.GS().v(cA.field_imgPath, true));
                                            Map q = bh.q(ai.hFj, "msg");
                                            if (q != null) {
                                                rmVar.NP((String) q.get(".msg.img.$cdnbigimgurl"));
                                                rmVar.ej((long) bg.getInt((String) q.get(".msg.img.$length"), 0));
                                                rmVar.NQ((String) q.get(".msg.img.$aeskey"));
                                                this.oOG.oOg.field_dataProto.tzn.set(this.oOG.i, rmVar);
                                            } else {
                                                w.i("MicroMsg.RecordMsgSendService", "parse cdnInfo failed. [%s]", ai.hFj);
                                            }
                                            this.oOG.oOA.put(Long.valueOf(rmVar.tyo), Boolean.valueOf(true));
                                        } else {
                                            this.oOG.oOA.put(Long.valueOf(j), Boolean.valueOf(true));
                                        }
                                        this.oOG.a(this.oOG.oOA, this.oOG.miY, this.oOG.oOg);
                                    }

                                    public final void a(long j, long j2, int i, int i2, Object obj) {
                                        this.oOG.oOA.put(Long.valueOf(j), Boolean.valueOf(true));
                                        this.oOG.a(this.oOG.oOA, this.oOG.miY, this.oOG.oOg);
                                    }
                                });
                            }
                        } else if (cA.bMp()) {
                            com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(cA.field_content);
                            if (ek == null) {
                                w.e("MicroMsg.RecordMsgSendService", "parse msgContent error, %s", cA.field_content);
                            } else {
                                if (bg.mA(ek.fCW) && !bg.mA(ek.hhx)) {
                                    w.e("MicroMsg.RecordMsgSendService", "msgContent format error, %s", cA.field_content);
                                    ek.fCW = ek.hhx.hashCode();
                                }
                                str = ek.fCW;
                                if (!l.a(cA, l.Y(str, cA.field_msgId))) {
                                    this.oOA.put(Long.valueOf(cA.field_msgId), Boolean.valueOf(false));
                                    this.oOE.put(Long.valueOf(cA.field_msgId), str);
                                    l.a(cA, null);
                                }
                            }
                        }
                    } else if (rmVar.aMw == 4 || rmVar.aMw == 15) {
                        r lH = t.lH(cA.field_imgPath);
                        if (!(lH == null || lH.status == 199)) {
                            this.oOA.put(Long.valueOf(j), Boolean.valueOf(false));
                            if (lH.Lj()) {
                                w.i("MicroMsg.RecordMsgSendService", "start complete online video");
                                t.lL(cA.field_imgPath);
                            } else {
                                w.i("MicroMsg.RecordMsgSendService", "start complete offline video");
                                t.lD(cA.field_imgPath);
                            }
                        }
                    }
                }
            }
            this.miY = true;
            this.oOD.oOj = false;
            a(this.oOA, this.miY, this.oOg);
        }

        public final void a(com.tencent.mm.modelvideo.s.a.a aVar) {
            r lH = t.lH(aVar.fyF);
            if (lH != null) {
                ap.yY();
                ce cA = com.tencent.mm.u.c.wT().cA((long) lH.iaq);
                if (lH.Lk()) {
                    this.oOA.put(Long.valueOf(cA.field_msgId), Boolean.valueOf(true));
                    a(this.oOA, this.miY, this.oOg);
                    return;
                }
                return;
            }
            a(null, this.miY, this.oOg);
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (kVar instanceof ab) {
                ap.vd().b(221, (com.tencent.mm.y.e) this);
                if (this.oOE != null) {
                    for (Entry entry : this.oOE.entrySet()) {
                        long longValue = ((Long) entry.getKey()).longValue();
                        String str2 = (String) entry.getValue();
                        if (longValue > 0 && !((Boolean) this.oOA.get(Long.valueOf(longValue))).booleanValue()) {
                            ap.yY();
                            com.tencent.mm.u.c.wT().cA(longValue);
                            com.tencent.mm.pluginsdk.model.app.b Y = l.Y(str2, longValue);
                            if (Y != null) {
                                str2 = Y.field_fileFullPath;
                            } else {
                                str2 = null;
                            }
                            if (str2 != null && str2.length() > 0) {
                                this.oOA.put(Long.valueOf(longValue), Boolean.valueOf(true));
                                Iterator it = this.oOg.field_dataProto.tzn.iterator();
                                while (it.hasNext()) {
                                    rm rmVar = (rm) it.next();
                                    if (rmVar.tyo == longValue) {
                                        rmVar.NZ(Y.field_fileFullPath);
                                    }
                                }
                            }
                        }
                    }
                }
                a(this.oOA, this.miY, this.oOg);
                return;
            }
            a(null, this.miY, this.oOg);
        }

        public final void a(HashMap<Long, Boolean> hashMap, boolean z, k kVar) {
            int i;
            if (hashMap != null) {
                for (Entry value : hashMap.entrySet()) {
                    if (!Boolean.valueOf(((Boolean) value.getValue()).booleanValue()).booleanValue()) {
                        i = 0;
                        break;
                    }
                }
            }
            i = 1;
            if (i != 0 && z) {
                o.KV().a((com.tencent.mm.modelvideo.s.a) this);
                kVar.field_type = 2;
                s.aWE().c(kVar, "localId");
                s.aWG().a(kVar);
            }
        }
    }

    public p() {
        ap.vd().a(632, (com.tencent.mm.y.e) this);
        s.aWF().a((com.tencent.mm.plugin.record.a.i.a) this);
    }

    public final void a(final k kVar) {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ p oOD;

            public final void run() {
                if (kVar != null) {
                    if (((e) this.oOD.oOm.get(kVar.field_localId)) == null) {
                        w.d("MicroMsg.RecordMsgSendService", "summerrecord do add job, localid %d, msgid %d", Integer.valueOf(kVar.field_localId), Long.valueOf(kVar.field_msgId));
                        this.oOD.oOm.put(kVar.field_localId, new e());
                    }
                    this.oOD.b(kVar);
                }
                p pVar = this.oOD;
                if (pVar.oOj) {
                    w.d("MicroMsg.RecordMsgSendService", "summerrecord is working, return");
                    return;
                }
                k kVar;
                e eVar;
                if (pVar.oOn.isEmpty()) {
                    w.w("MicroMsg.RecordMsgSendService", "summerrecord jobs list size is 0");
                    l aWE = s.aWE();
                    List<k> linkedList = new LinkedList();
                    Cursor Kk = aWE.Kk();
                    if (Kk != null) {
                        Kk.moveToFirst();
                        while (!Kk.isAfterLast()) {
                            k kVar2 = new k();
                            kVar2.b(Kk);
                            linkedList.add(kVar2);
                            Kk.moveToNext();
                        }
                        Kk.close();
                    }
                    w.d("MicroMsg.RecordMsgStorage", "get all finish, result count %d", Integer.valueOf(linkedList.size()));
                    for (k kVar3 : linkedList) {
                        ap.yY();
                        if (com.tencent.mm.u.c.wT().cA(kVar3.field_msgId).field_type != 49) {
                            w.w("MicroMsg.RecordMsgSendService", "summerrecord record msg not exist, delete record info, localid[%d], msgid[%d]", Integer.valueOf(kVar3.field_localId), Long.valueOf(kVar3.field_msgId));
                            s.aWE().rR(kVar3.field_localId);
                        } else {
                            eVar = (e) pVar.oOm.get(kVar3.field_localId);
                            if (eVar == null) {
                                pVar.oOm.put(kVar3.field_localId, new e());
                            } else if (eVar.ihV >= 0 || SystemClock.elapsedRealtime() - eVar.oOp >= 300000) {
                                if (eVar.ihV < 0) {
                                    eVar.ihV = 3;
                                }
                            }
                            w.d("MicroMsg.RecordMsgSendService", "summerrecord do add job from db, localid %d, msgid %d", Integer.valueOf(kVar3.field_localId), Long.valueOf(kVar3.field_msgId));
                            pVar.b(kVar3);
                        }
                    }
                }
                if (pVar.oOn.isEmpty()) {
                    w.w("MicroMsg.RecordMsgSendService", "try to do job, but job list size is empty, return");
                    pVar.finish();
                    return;
                }
                boolean z;
                kVar3 = (k) pVar.oOn.removeFirst();
                eVar = (e) pVar.oOm.get(kVar3.field_localId);
                if (eVar == null) {
                    eVar = new e();
                    pVar.oOm.put(kVar3.field_localId, eVar);
                }
                eVar.ihV--;
                if (eVar.ihV < 0) {
                    if (300000 > SystemClock.elapsedRealtime() - eVar.oOp) {
                        z = false;
                        if (z) {
                            pVar.a(null);
                            return;
                        }
                        pVar.oOj = true;
                        switch (kVar3.field_type) {
                            case 0:
                                com.tencent.mm.sdk.f.e.post(new d(pVar, kVar3), "RecordMsgSendService_normalDataCopy");
                                return;
                            case 1:
                                com.tencent.mm.sdk.f.e.post(new c(pVar, kVar3), "RecordMsgSendService_favDataCopy");
                                return;
                            case 2:
                                com.tencent.mm.sdk.f.e.post(new a(pVar, kVar3), "RecordMsgSendService_chatDataCopy");
                                return;
                            case 3:
                                com.tencent.mm.sdk.f.e.post(new b(pVar, kVar3), "RecordMsgSendService_chatDataDownLoad");
                                return;
                            default:
                                pVar.oOj = false;
                                return;
                        }
                    }
                    eVar.ihV = 2;
                }
                eVar.oOp = SystemClock.elapsedRealtime();
                z = true;
                if (z) {
                    pVar.a(null);
                    return;
                }
                pVar.oOj = true;
                switch (kVar3.field_type) {
                    case 0:
                        com.tencent.mm.sdk.f.e.post(new d(pVar, kVar3), "RecordMsgSendService_normalDataCopy");
                        return;
                    case 1:
                        com.tencent.mm.sdk.f.e.post(new c(pVar, kVar3), "RecordMsgSendService_favDataCopy");
                        return;
                    case 2:
                        com.tencent.mm.sdk.f.e.post(new a(pVar, kVar3), "RecordMsgSendService_chatDataCopy");
                        return;
                    case 3:
                        com.tencent.mm.sdk.f.e.post(new b(pVar, kVar3), "RecordMsgSendService_chatDataDownLoad");
                        return;
                    default:
                        pVar.oOj = false;
                        return;
                }
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
    }

    public final void b(k kVar) {
        if (!this.oOn.contains(kVar)) {
            this.oOn.add(kVar);
        }
    }

    final void finish() {
        this.oOn.clear();
        this.oOm.clear();
        this.oOj = false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.RecordMsgSendService", "on scene end, errType %d errCode %d errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar == null) {
            w.w("MicroMsg.RecordMsgSendService", "on scene end, scene is null");
            return;
        }
        switch (kVar.getType()) {
            case 632:
                w.d("MicroMsg.RecordMsgSendService", "batch tran cdn callback, errType %d, errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
                a aVar = (a) kVar;
                if (i == 3) {
                    Object obj;
                    Iterator it = aVar.oOg.field_dataProto.tzn.iterator();
                    while (it.hasNext()) {
                        if (((rm) it.next()).aMw != 1) {
                            obj = null;
                            if (obj != null) {
                                i = 0;
                                i2 = 0;
                            }
                        }
                    }
                    int i3 = 1;
                    if (obj != null) {
                        i = 0;
                        i2 = 0;
                    }
                }
                if (i == 0 && r10 == 0) {
                    ap.yY();
                    au cA = com.tencent.mm.u.c.wT().cA(aVar.oOg.field_msgId);
                    if (cA.field_msgId == aVar.oOg.field_msgId) {
                        cA.setContent(aVar.oOf);
                        cA.dv(1);
                        ap.yY();
                        com.tencent.mm.u.c.wT().a(aVar.oOg.field_msgId, cA);
                    }
                    com.tencent.mm.sdk.e.c ec = an.bDk().ec(aVar.oOg.field_msgId);
                    if (ec != null) {
                        ec.field_xml = cA.field_content;
                        an.bDk().c(ec, "msgId");
                    }
                    s.aWE().rR(aVar.oOg.field_localId);
                    this.oOm.remove(aVar.oOg.field_localId);
                    an.bDm();
                    com.tencent.mm.pluginsdk.model.app.am.a.eg(aVar.oOg.field_msgId);
                    w.d("MicroMsg.RecordMsgSendService", "batch tran cdn ok, msgId[%d], recordLocalId[%d], begin send appmsg", Long.valueOf(aVar.oOg.field_msgId), Integer.valueOf(aVar.oOg.field_localId));
                    break;
                }
                w.w("MicroMsg.RecordMsgSendService", "batch tran cdn fail, msgId[%d], recordLocalId[%d]", Long.valueOf(aVar.oOg.field_msgId), Integer.valueOf(aVar.oOg.field_localId));
                w.w("MicroMsg.RecordMsgSendService", "try upload from local");
                Iterator it2 = aVar.oOg.field_dataProto.tzn.iterator();
                while (it2.hasNext()) {
                    String d;
                    rm rmVar = (rm) it2.next();
                    if (rmVar.txD > 0) {
                        d = m.d(rmVar.lKv, aVar.oOg.field_msgId, false);
                        if (s.aWF().Do(d) == null) {
                            g gVar = new g();
                            gVar.field_cdnKey = rmVar.txk;
                            gVar.field_cdnUrl = rmVar.txi;
                            gVar.field_dataId = rmVar.lKv;
                            gVar.field_mediaId = d;
                            gVar.field_totalLen = (int) rmVar.txD;
                            gVar.field_localId = gVar.field_mediaId.hashCode();
                            gVar.field_path = m.c(rmVar, aVar.oOg.field_msgId);
                            gVar.field_type = 2;
                            gVar.field_fileType = m.rS(rmVar.aMw);
                            gVar.field_recordLocalId = aVar.oOg.field_localId;
                            gVar.field_toUser = aVar.oOg.field_toUser;
                            gVar.field_isThumb = false;
                            boolean a = s.aWF().a(gVar);
                            w.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", Integer.valueOf(gVar.field_localId), Boolean.valueOf(a));
                        }
                    }
                    if (rmVar.txO > 0) {
                        d = m.vZ(rmVar.lKv);
                        String d2 = m.d(d, aVar.oOg.field_msgId, false);
                        if (s.aWF().Do(d2) == null) {
                            g gVar2 = new g();
                            gVar2.field_cdnKey = rmVar.txe;
                            gVar2.field_cdnUrl = rmVar.hhy;
                            gVar2.field_dataId = d;
                            gVar2.field_mediaId = d2;
                            gVar2.field_totalLen = (int) rmVar.txO;
                            gVar2.field_localId = gVar2.field_mediaId.hashCode();
                            gVar2.field_path = m.f(rmVar, aVar.oOg.field_msgId);
                            gVar2.field_type = 2;
                            gVar2.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
                            gVar2.field_recordLocalId = aVar.oOg.field_localId;
                            gVar2.field_toUser = aVar.oOg.field_toUser;
                            gVar2.field_isThumb = true;
                            boolean a2 = s.aWF().a(gVar2);
                            w.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", Integer.valueOf(gVar2.field_localId), Boolean.valueOf(a2));
                        }
                    }
                }
                s.aWH().run();
                return;
        }
        this.oOj = false;
        a(null);
    }

    public final void a(int i, g gVar) {
        if (1 != i) {
            w.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care type %d", Integer.valueOf(i));
        } else if (gVar == null) {
            w.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo is null");
        } else if (2 != gVar.field_type) {
            w.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo type is not upload");
        } else if (gVar.field_status == 0 || 1 == gVar.field_status) {
            w.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care status");
        } else {
            Object obj;
            i aWF = s.aWF();
            int i2 = gVar.field_recordLocalId;
            List<g> linkedList = new LinkedList();
            Cursor a = aWF.gUz.a("SELECT * FROM RecordCDNInfo WHERE recordLocalId = " + i2, null, 2);
            if (a != null) {
                while (a.moveToNext()) {
                    g gVar2 = new g();
                    gVar2.b(a);
                    linkedList.add(gVar2);
                }
                a.close();
            }
            w.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", Integer.valueOf(linkedList.size()));
            for (g gVar3 : linkedList) {
                if (gVar3.field_status != 0) {
                    if (1 == gVar3.field_status) {
                    }
                }
                w.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but %s not finish", gVar3.field_mediaId);
                obj = null;
            }
            int i3 = 1;
            if (obj != null) {
                k kVar;
                l aWE = s.aWE();
                w.d("MicroMsg.RecordMsgStorage", "get by local id, sql[%s], local[%d]", "SELECT * FROM RecordMessageInfo WHERE localId=" + gVar.field_recordLocalId, Integer.valueOf(r1));
                Cursor a2 = aWE.gUz.a(r2, null, 2);
                if (a2 == null || !a2.moveToFirst()) {
                    kVar = null;
                } else {
                    k kVar2 = new k();
                    kVar2.b(a2);
                    kVar = kVar2;
                }
                if (a2 != null) {
                    a2.close();
                }
                String str = "MicroMsg.RecordMsgSendService";
                String str2 = "finish get record info, id %d result %B";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(gVar.field_recordLocalId);
                objArr[1] = Boolean.valueOf(kVar != null);
                w.d(str, str2, objArr);
                if (kVar != null) {
                    List<rm> list = kVar.field_dataProto.tzn;
                    for (g gVar4 : linkedList) {
                        w.v("MicroMsg.RecordMsgSendService", "check dataid[%s] isThumb[%B]", gVar4.field_dataId, Boolean.valueOf(gVar4.field_isThumb));
                        if (!gVar4.field_isThumb) {
                            for (rm rmVar : list) {
                                if (gVar4.field_dataId.equals(rmVar.lKv)) {
                                    w.d("MicroMsg.RecordMsgSendService", "match data, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", rmVar.txk, gVar4.field_cdnKey, rmVar.txi, gVar4.field_cdnUrl, Long.valueOf(rmVar.txD), Integer.valueOf(gVar4.field_totalLen));
                                    rmVar.NQ(gVar4.field_cdnKey);
                                    rmVar.NP(gVar4.field_cdnUrl);
                                    break;
                                }
                            }
                        }
                        for (rm rmVar2 : list) {
                            if (gVar4.field_dataId.equals(m.vZ(rmVar2.lKv))) {
                                w.d("MicroMsg.RecordMsgSendService", "match thumb, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", rmVar2.txe, gVar4.field_cdnKey, rmVar2.hhy, gVar4.field_cdnUrl, Long.valueOf(rmVar2.txO), Integer.valueOf(gVar4.field_totalLen));
                                rmVar2.NO(gVar4.field_cdnKey);
                                rmVar2.NN(gVar4.field_cdnUrl);
                                break;
                            }
                        }
                    }
                    ap.yY();
                    au cA = com.tencent.mm.u.c.wT().cA(kVar.field_msgId);
                    w.i("MicroMsg.RecordMsgSendService", "update msg content, msg null ? %B, msgId %d recordInfoId %d", Boolean.valueOf(false), Long.valueOf(cA.field_msgId), Long.valueOf(kVar.field_msgId));
                    if (cA.field_msgId == kVar.field_msgId) {
                        cA.setContent(m.b(kVar.field_title, kVar.field_desc, list, kVar.field_favFrom));
                        cA.dv(1);
                        ap.yY();
                        com.tencent.mm.u.c.wT().a(kVar.field_msgId, cA);
                    }
                    com.tencent.mm.sdk.e.c ec = an.bDk().ec(kVar.field_msgId);
                    if (ec != null) {
                        ec.field_xml = cA.field_content;
                        an.bDk().c(ec, "msgId");
                    }
                    s.aWE().rR(kVar.field_localId);
                    this.oOm.remove(kVar.field_localId);
                    an.bDm();
                    com.tencent.mm.pluginsdk.model.app.am.a.eg(kVar.field_msgId);
                }
                for (g gVar32 : linkedList) {
                    s.aWF().a(gVar32, "localId");
                }
                this.oOj = false;
                a(null);
            }
        }
    }
}
