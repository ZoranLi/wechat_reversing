package com.tencent.mm.modelvideo;

import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.c;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class m {
    public static int fBq = 0;
    public boolean fBm = false;
    public boolean fBn = false;
    public int fBo = 0;
    public com.tencent.mm.compatible.util.g.a fBs = new com.tencent.mm.compatible.util.g.a();
    public aj fBt = new aj(h.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ m hZz;

        {
            this.hZz = r1;
        }

        public final boolean oQ() {
            this.hZz.pq();
            return false;
        }

        public final String toString() {
            return super.toString() + "|scenePusher";
        }
    }, false);
    public LinkedList<Long> hZt = new LinkedList();
    public Map<Long, com.tencent.mm.compatible.util.g.a> hZu = new HashMap();
    public Map<Long, String> hZv = new HashMap();
    public Object hZw = new Object();
    public String hZx;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ long hZy;
        final /* synthetic */ m hZz;

        AnonymousClass1(m mVar, long j) {
            this.hZz = mVar;
            this.hZy = j;
        }

        public final void run() {
            long j = 0;
            m.fBq++;
            this.hZz.fBm = false;
            this.hZz.hZx = "";
            if (this.hZy > 0 && this.hZz.hZu.get(Long.valueOf(this.hZy)) != null) {
                j = ((com.tencent.mm.compatible.util.g.a) this.hZz.hZu.get(Long.valueOf(this.hZy))).se();
            }
            w.d("MicroMsg.SightMassSendService", "onJobEnd ok massSendId:" + this.hZy + " time:" + j + " inCnt:" + m.fBq + " stop:" + this.hZz.fBo + " running:" + this.hZz.fBn + " sending:" + this.hZz.fBm);
            if (this.hZz.fBo > 0) {
                this.hZz.pq();
            } else if (!this.hZz.fBm) {
                this.hZz.pr();
            }
            m.fBq--;
        }

        public final String toString() {
            return super.toString() + "|onSceneEnd";
        }
    }

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ long hZy;
        final /* synthetic */ m hZz;

        public AnonymousClass5(m mVar, long j) {
            this.hZz = mVar;
            this.hZy = j;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r10 = this;
            r0 = r10.hZz;
            r8 = r0.hZw;
            monitor-enter(r8);
            r0 = r10.hZz;	 Catch:{ all -> 0x00ab }
            r0 = r0.hZv;	 Catch:{ all -> 0x00ab }
            r2 = r10.hZy;	 Catch:{ all -> 0x00ab }
            r1 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x00ab }
            r0 = r0.get(r1);	 Catch:{ all -> 0x00ab }
            r0 = (java.lang.String) r0;	 Catch:{ all -> 0x00ab }
            r1 = "MicroMsg.SightMassSendService";
            r2 = "cancel item, massSendId %d, cdnClientId %s";
            r3 = 2;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00ab }
            r4 = 0;
            r6 = r10.hZy;	 Catch:{ all -> 0x00ab }
            r5 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x00ab }
            r3[r4] = r5;	 Catch:{ all -> 0x00ab }
            r4 = 1;
            r3[r4] = r0;	 Catch:{ all -> 0x00ab }
            com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);	 Catch:{ all -> 0x00ab }
            r1 = "done_upload_cdn_client_id";
            r1 = r1.equals(r0);	 Catch:{ all -> 0x00ab }
            if (r1 == 0) goto L_0x0041;
        L_0x0036:
            r0 = "MicroMsg.SightMassSendService";
            r1 = "doing mass send cgi, ignore cancel!";
            com.tencent.mm.sdk.platformtools.w.w(r0, r1);	 Catch:{ all -> 0x00ab }
            monitor-exit(r8);	 Catch:{ all -> 0x00ab }
        L_0x0040:
            return;
        L_0x0041:
            r1 = com.tencent.mm.sdk.platformtools.bg.mA(r0);	 Catch:{ all -> 0x00ab }
            if (r1 != 0) goto L_0x0067;
        L_0x0047:
            r1 = r10.hZz;	 Catch:{ all -> 0x00ab }
            r1 = r1.hZv;	 Catch:{ all -> 0x00ab }
            r2 = r10.hZy;	 Catch:{ all -> 0x00ab }
            r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x00ab }
            r3 = "";
            r1.put(r2, r3);	 Catch:{ all -> 0x00ab }
            r1 = com.tencent.mm.modelcdntran.g.El();	 Catch:{ all -> 0x00ab }
            r1.iO(r0);	 Catch:{ all -> 0x00ab }
            r0 = r10.hZz;	 Catch:{ all -> 0x00ab }
            r2 = r10.hZy;	 Catch:{ all -> 0x00ab }
            r1 = 0;
            r4 = 0;
            r0.c(r2, r1, r4);	 Catch:{ all -> 0x00ab }
        L_0x0067:
            r0 = com.tencent.mm.modelvideo.o.KV();	 Catch:{ all -> 0x00ab }
            r6 = r10.hZy;	 Catch:{ all -> 0x00ab }
            r1 = r0.hnH;	 Catch:{ all -> 0x00ab }
            r2 = "videoinfo2";
            r3 = "masssendid= ?";
            r4 = 1;
            r4 = new java.lang.String[r4];	 Catch:{ all -> 0x00ab }
            r5 = 0;
            r9 = java.lang.String.valueOf(r6);	 Catch:{ all -> 0x00ab }
            r4[r5] = r9;	 Catch:{ all -> 0x00ab }
            r1 = r1.delete(r2, r3, r4);	 Catch:{ all -> 0x00ab }
            if (r1 <= 0) goto L_0x00a9;
        L_0x0085:
            r1 = new com.tencent.mm.modelvideo.s$a$a;	 Catch:{ all -> 0x00ab }
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ab }
            r3 = "DELETE_";
            r2.<init>(r3);	 Catch:{ all -> 0x00ab }
            r2 = r2.append(r6);	 Catch:{ all -> 0x00ab }
            r2 = r2.toString();	 Catch:{ all -> 0x00ab }
            r3 = com.tencent.mm.modelvideo.s.a.b.iaI;	 Catch:{ all -> 0x00ab }
            r4 = com.tencent.mm.modelvideo.s.a.c.NORMAL;	 Catch:{ all -> 0x00ab }
            r5 = 3;
            r1.<init>(r2, r3, r4, r5, r6);	 Catch:{ all -> 0x00ab }
            r2 = r0.hrc;	 Catch:{ all -> 0x00ab }
            r2.by(r1);	 Catch:{ all -> 0x00ab }
            r0 = r0.hrc;	 Catch:{ all -> 0x00ab }
            r0.doNotify();	 Catch:{ all -> 0x00ab }
        L_0x00a9:
            monitor-exit(r8);	 Catch:{ all -> 0x00ab }
            goto L_0x0040;
        L_0x00ab:
            r0 = move-exception;
            monitor-exit(r8);	 Catch:{ all -> 0x00ab }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvideo.m.5.run():void");
        }
    }

    private final class a implements com.tencent.mm.modelcdntran.h.a, e {
        long hYG;
        r hYH;
        String hZA;
        final /* synthetic */ m hZz;
        List<r> hoP;
        long startTime;

        public a(m mVar) {
            this.hZz = mVar;
        }

        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            w.d("MicroMsg.SightMassSendService", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.hZA, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult);
            if (i == -21005) {
                w.d("MicroMsg.SightMassSendService", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", this.hZA);
                return 0;
            } else if (i != 0) {
                m.N(this.hoP);
                w.e("MicroMsg.SightMassSendService", "upload to CDN error, massSendId %d, errCode %d", Long.valueOf(this.hYG), Integer.valueOf(i));
                g.oUh.i(10421, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(b.MediaType_TinyVideo), Integer.valueOf(0), "");
                this.hZz.c(this.hYG, 3, i);
                return 0;
            } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                w.v("MicroMsg.SightMassSendService", "progress length %d", Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength));
                for (r rVar : this.hoP) {
                    rVar.ian = bg.Ny();
                    rVar.hYV = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                    rVar.fRW = 1032;
                    t.e(rVar);
                }
                return 0;
            } else {
                if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        w.e("MicroMsg.SightMassSendService", "cdntra sceneResult.retCode :%d arg[%s] info[%s], massSendId[%d]", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult.field_arg, com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, Long.valueOf(this.hYG));
                        m.N(this.hoP);
                        g.oUh.i(10421, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(b.MediaType_TinyVideo), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                        g.oUh.i(13937, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(b.MediaType_TinyVideo), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                        this.hZz.c(this.hYG, 3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                    } else {
                        w.i("MicroMsg.SightMassSendService", "uploadvideo by cdn, isHitCacheUpload[%d] massSendId[%d]", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Long.valueOf(this.hYG));
                        w.i("MicroMsg.SightMassSendService", "cdn callback new build cdnInfo:%s", ((("<msg><videomsg aeskey=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey + "\" cdnthumbaeskey=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey + "\" cdnvideourl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" ") + "cdnthumburl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" ") + "length=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + "\" ") + "cdnthumblength=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength + "\"/></msg>");
                        for (r rVar2 : this.hoP) {
                            if (bg.mA(rVar2.Lh())) {
                                rVar2.iav = r1;
                                rVar2.fRW = 2097152;
                                boolean e = t.e(rVar2);
                                w.i("MicroMsg.SightMassSendService", "massSendId[%d] info %s, update recv xml ret %B", Long.valueOf(this.hYG), rVar2.getFileName(), Boolean.valueOf(e));
                            }
                        }
                        synchronized (this.hZz.hZw) {
                            if (bg.mA((String) this.hZz.hZv.get(Long.valueOf(this.hYG)))) {
                                w.i("MicroMsg.SightMassSendService", "check cdn client id FAIL do NOTHING, massSendId %d, oldClientId %s, selfClientId %s", Long.valueOf(this.hYG), (String) this.hZz.hZv.get(Long.valueOf(this.hYG)), this.hZA);
                            } else {
                                w.i("MicroMsg.SightMassSendService", "check cdn client id ok do MASS SEND, massSendId %d, oldClientId %s, selfClientId %s", Long.valueOf(this.hYG), (String) this.hZz.hZv.get(Long.valueOf(this.hYG)), this.hZA);
                                this.hZz.hZv.put(Long.valueOf(this.hYG), "done_upload_cdn_client_id");
                                h.vd().a(245, (e) this);
                                if (!h.vd().a(new e(this.hYG, this.hYH, com_tencent_mm_modelcdntran_keep_SceneResult, this.hZA), 0)) {
                                    w.e("MicroMsg.SightMassSendService", "try to do NetSceneMassUploadSight fail");
                                    h.vd().b(245, (e) this);
                                    this.hZz.c(this.hYG, 3, 0);
                                }
                            }
                        }
                    }
                }
                return 0;
            }
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] i(String str, byte[] bArr) {
            return null;
        }

        public final void a(int i, int i2, String str, k kVar) {
            h.vd().b(245, (e) this);
            if (i == 4 && i2 == -22) {
                w.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd BLACK  errtype:" + i + " errCode:" + i2 + " massSendId:" + this.hYG);
                m.O(this.hoP);
                this.hZz.c(this.hYG, i, i2);
            } else if (i == 4 && i2 != 0) {
                w.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd SERVER FAILED errtype:" + i + " errCode:" + i2 + "  massSendId:" + this.hYG);
                m.N(this.hoP);
                this.hZz.c(this.hYG, i, i2);
            } else if (i == 0 && i2 == 0) {
                for (r rVar : this.hoP) {
                    rVar.ian = bg.Ny();
                    rVar.status = 199;
                    rVar.fRW = 1280;
                    if (t.e(rVar)) {
                        if (rVar == null) {
                            w.e("MicroMsg.VideoLogic", "video info is null");
                        } else if (rVar.iaq > 0) {
                            au cA = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cA((long) rVar.iaq);
                            int i3 = cA.field_type;
                            w.i("MicroMsg.VideoLogic", "ashutest::updateWriteFinMassMsgInfo, msg type %d", Integer.valueOf(i3));
                            if (43 == i3 || 62 == i3) {
                                cA.dw(1);
                                cA.cH(rVar.Le());
                                cA.y(rVar.fTQ);
                                cA.dv(2);
                                cA.setContent(p.b(rVar.Lf(), (long) rVar.iap, false));
                                ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().a((long) rVar.iaq, cA);
                                w.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo msgId:%d", Long.valueOf(cA.field_msgId));
                            }
                        } else {
                            ce auVar = new au();
                            auVar.cH(rVar.Le());
                            auVar.setType(62);
                            auVar.dw(1);
                            auVar.cI(rVar.getFileName());
                            auVar.dv(2);
                            auVar.z(ay.gk(rVar.Le()));
                            rVar.iaq = (int) ay.i(auVar);
                            rVar.fRW = 8192;
                            t.e(rVar);
                            w.d("MicroMsg.VideoLogic", "updateWriteFinMassMsgInfo insert msgId:%d", Long.valueOf(auVar.field_msgId));
                        }
                    }
                    w.v("MicroMsg.SightMassSendService", "massSendId %d, file %s, set status %d", Long.valueOf(this.hYG), rVar.getFileName(), Integer.valueOf(199));
                }
                h.vL().D(new AnonymousClass1(this.hZz, this.hYG));
            } else {
                w.e("MicroMsg.SightMassSendService", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i + " errCode:" + i2 + "  massSendId:" + this.hYG);
                m.N(this.hoP);
                this.hZz.c(this.hYG, i, i2);
            }
        }
    }

    public final void pq() {
        if (!this.fBm && this.hZt.isEmpty()) {
            List<r> Lm = o.KV().Lm();
            if (Lm.isEmpty()) {
                w.d("MicroMsg.SightMassSendService", "unfinish massinfo count 0");
            } else {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                for (r rVar : Lm) {
                    if (this.hZu.containsKey(Long.valueOf(rVar.hYG))) {
                        w.d("MicroMsg.SightMassSendService", "Mass Send File is Already running %s, massSendId %d", rVar.getFileName(), Long.valueOf(rVar.hYG));
                    } else {
                        w.d("MicroMsg.SightMassSendService", "Get file:" + rVar.getFileName() + " status:" + rVar.status + " user" + rVar.Le() + " human:" + rVar.Lf() + " massSendId:" + rVar.hYG + " massSendList:" + rVar.iax + " create:" + bg.ev(rVar.iam) + " last:" + bg.ev(rVar.ian) + " now:" + bg.ev(currentTimeMillis) + " " + (currentTimeMillis - rVar.ian));
                        if (rVar.status == com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
                            this.hZt.offer(Long.valueOf(rVar.hYG));
                            this.hZu.put(Long.valueOf(rVar.hYG), null);
                        }
                    }
                }
                w.d("MicroMsg.SightMassSendService", "GetNeedRun procing:" + this.hZu.size() + " [send:" + this.hZt.size() + "]");
                this.hZt.size();
            }
        }
        if (!this.fBm && this.hZt.isEmpty()) {
            pr();
            w.d("MicroMsg.SightMassSendService", "No Data Any More , Stop Service");
        } else if (!this.fBm && this.hZt.size() > 0) {
            Long l = (Long) this.hZt.poll();
            w.d("MicroMsg.SightMassSendService", "Start Mass Send, ID: %s", l);
            if (l != null) {
                this.hZu.put(l, new com.tencent.mm.compatible.util.g.a());
                this.fBm = true;
                this.hZx = as(l.longValue());
                if (this.hZx == null) {
                    this.fBm = false;
                    this.fBt.v(10, 10);
                    return;
                }
                this.hZv.put(l, this.hZx);
            }
        }
    }

    public static void N(List<r> list) {
        if (list != null && !list.isEmpty()) {
            for (r fileName : list) {
                t.lA(fileName.getFileName());
            }
        }
    }

    public static void O(List<r> list) {
        if (list != null && !list.isEmpty()) {
            for (r fileName : list) {
                t.lB(fileName.getFileName());
            }
        }
    }

    private String as(long j) {
        List<r> au = o.KV().au(j);
        if (au.isEmpty()) {
            w.e("MicroMsg.SightMassSendService", "check use cdn fail: mass send video list empty");
            return null;
        }
        for (r rVar : au) {
            r rVar2;
            if (o.fF(rVar2.Le())) {
                w.w("MicroMsg.SightMassSendService", "cdntra not use cdn user:%s, list %s, massSendId %d", rVar2.Le(), rVar2.iax, Long.valueOf(j));
                return null;
            }
            com.tencent.mm.modelcdntran.g.El();
            if (!c.fA(2) && rVar2.iau != 1) {
                r5 = new Object[4];
                com.tencent.mm.modelcdntran.g.El();
                r5[0] = Boolean.valueOf(c.fA(2));
                r5[1] = Integer.valueOf(rVar2.iau);
                r5[2] = rVar2.iax;
                r5[3] = Long.valueOf(j);
                w.w("MicroMsg.SightMassSendService", "cdntra not use cdn flag:%b getCdnInfo:%d, list %s, massSendId %d", r5);
                return null;
            }
        }
        if (au == null || au.isEmpty()) {
            rVar2 = null;
        } else {
            for (int i = 0; i < au.size(); i++) {
                r lH = t.lH(((r) au.get(i)).getFileName());
                if (lH != null) {
                    w.i("MicroMsg.SightMassSendService", "check %s ok, index %d, size %d, massSendId %d, massSendList %s", rVar2.getFileName(), Integer.valueOf(i), Integer.valueOf(au.size()), Long.valueOf(j), rVar2.iax);
                    au.remove(i);
                    au.add(i, lH);
                    rVar2 = lH;
                    break;
                }
                w.w("MicroMsg.SightMassSendService", "check %s fail, index %d, size %d, massSendId %d, massSendList %s", rVar2.getFileName(), Integer.valueOf(i), Integer.valueOf(au.size()), Long.valueOf(j), rVar2.iax);
            }
            rVar2 = null;
        }
        if (rVar2 == null) {
            w.w("MicroMsg.SightMassSendService", "check use cdn fail: no valid info");
            return null;
        }
        String a = d.a("upvideo", rVar2.iam, rVar2.iax, rVar2.getFileName());
        if (bg.mA(a)) {
            w.w("MicroMsg.SightMassSendService", "cdntra genClientId failed not use cdn file:%s, massSendId %d, massSendList %s", rVar2.getFileName(), Long.valueOf(rVar2.hYG), rVar2.iax);
            return null;
        }
        String fileName = rVar2.getFileName();
        o.KV();
        String lw = s.lw(fileName);
        o.KV();
        fileName = s.lv(fileName);
        com.tencent.mm.modelcdntran.h.a aVar = new a(this);
        aVar.hoP = au;
        aVar.hYG = j;
        aVar.hZA = a;
        aVar.startTime = bg.Nz();
        aVar.hYH = rVar2;
        com.tencent.mm.modelcdntran.h hVar = new com.tencent.mm.modelcdntran.h();
        hVar.hze = aVar;
        hVar.field_mediaId = a;
        hVar.field_fullpath = fileName;
        hVar.field_thumbpath = lw;
        hVar.field_fileType = b.MediaType_VIDEO;
        hVar.field_smallVideoFlag = 1;
        hVar.field_talker = rVar2.iax;
        hVar.field_priority = b.hxL;
        hVar.field_needStorage = false;
        hVar.field_isStreamMedia = false;
        Map q = bh.q(rVar2.Lh(), "msg");
        if (q != null) {
            hVar.field_fileId = (String) q.get(".msg.videomsg.$cdnvideourl");
            hVar.field_aesKey = (String) q.get(".msg.videomsg.$aeskey");
        } else {
            w.i("MicroMsg.SightMassSendService", "cdntra parse video recv xml failed");
        }
        if (com.tencent.mm.modelcdntran.g.El().b(hVar)) {
            for (r rVar22 : au) {
                if (rVar22.iau != 1) {
                    rVar22.iau = 1;
                    rVar22.fRW = SQLiteGlobal.journalSizeLimit;
                    boolean e = t.e(rVar22);
                    w.i("MicroMsg.SightMassSendService", "update %s useCDN, result %B", rVar22.getFileName(), Boolean.valueOf(e));
                }
            }
            return a;
        }
        w.e("MicroMsg.SightMassSendService", "cdntra addSendTask failed.");
        return null;
    }

    public final void c(long j, int i, int i2) {
        final long j2 = j;
        final int i3 = i;
        final int i4 = i2;
        h.vL().D(new Runnable(this) {
            final /* synthetic */ m hZz;

            public final void run() {
                m.fBq++;
                this.hZz.fBm = false;
                this.hZz.hZx = "";
                long j = 0;
                if (j2 > 0 && this.hZz.hZu.get(Long.valueOf(j2)) != null) {
                    j = ((com.tencent.mm.compatible.util.g.a) this.hZz.hZu.get(Long.valueOf(j2))).se();
                }
                w.i("MicroMsg.SightMassSendService", "on ERROR massSendId: %d time: %d errType %d errCode %d", Long.valueOf(j2), Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(i4));
                if (!(i3 == 0 && i4 == 0)) {
                    m mVar = this.hZz;
                    mVar.fBo--;
                }
                w.i("MicroMsg.SightMassSendService", "onSceneEnd  inCnt: %d stop: %d running: %B sending: %B", Integer.valueOf(m.fBq), Integer.valueOf(this.hZz.fBo), Boolean.valueOf(this.hZz.fBn), Boolean.valueOf(this.hZz.fBm));
                if (this.hZz.fBo > 0) {
                    this.hZz.pq();
                } else if (!this.hZz.fBm) {
                    w.w("MicroMsg.SightMassSendService", "StopFlag ERROR force do stop, fail all job");
                    s KV = o.KV();
                    List list = this.hZz.hZt;
                    if (!(list == null || list.isEmpty())) {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append('(');
                        for (int i = 0; i < list.size() - 1; i++) {
                            stringBuilder.append((Long) list.get(i));
                            stringBuilder.append(',');
                        }
                        Long l = (Long) list.get(list.size() - 1);
                        if (l != null) {
                            stringBuilder.append(l);
                        }
                        stringBuilder.append(')');
                        w.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", "UPDATE videoinfo2 SET status=198, lastmodifytime=" + currentTimeMillis + " WHERE masssendid IN " + stringBuilder.toString());
                        KV.hnH.eE("videoinfo2", r0);
                    }
                    this.hZz.pr();
                }
                m.fBq--;
            }

            public final String toString() {
                return super.toString() + "|onSceneEnd";
            }
        });
    }

    public final void pr() {
        this.hZv.clear();
        this.hZu.clear();
        this.hZt.clear();
        this.fBm = false;
        this.fBn = false;
        w.d("MicroMsg.SightMassSendService", "Finish service use time(ms):" + this.fBs.se());
    }
}
