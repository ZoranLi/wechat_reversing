package com.tencent.mm.insane_statistic;

import com.tencent.mm.ah.d;
import com.tencent.mm.e.a.lw;
import com.tencent.mm.e.a.lx;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bhv;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.j;
import java.net.URLEncoder;

public final class b implements com.tencent.mm.ah.q.a {

    private static class a {
        public au fCZ = null;
        public final com.tencent.mm.y.b gUA;
        public long gVi;
        public int gVj;
        d gVk;
        public String gVl;
        boolean gVm = false;
        public String gVn;
        public int gVo = 0;
        public keep_SceneResult gVp;
        public boolean gVq = false;
        c gVr = new c<ly>(this) {
            final /* synthetic */ a gVt;

            {
                this.gVt = r2;
                this.usg = ly.class.getName().hashCode();
            }

            private boolean a(ly lyVar) {
                if (lyVar.fTe.filePath.equals(this.gVt.gVn)) {
                    String encode;
                    String str = "";
                    try {
                        encode = URLEncoder.encode(lyVar.fTe.result, "UTF-8");
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.OnNetSceneUploadMsgImgEnd", e, "", new Object[0]);
                        encode = str;
                    }
                    if (this.gVt.gVq) {
                        w.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "androidSystemShareFixed(13717) , imgLocalId:%d, scene.hash:%d, %s, filePath:%s", new Object[]{Long.valueOf(this.gVt.gVi), Integer.valueOf(this.gVt.hashCode()), this.gVt.gVl + encode, lyVar.fTe.filePath});
                        g.oUh.A(13717, str);
                    }
                    if (this.gVt.gVo == 1) {
                        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                        bhv com_tencent_mm_protocal_c_bhv = (bhv) this.gVt.gUA.hsj.hsr;
                        dVar.n("20toUser", com_tencent_mm_protocal_c_bhv.tfe.tZr + ",");
                        dVar.n("21source", this.gVt.gVj + ",");
                        dVar.n("22qrUrl", encode + ",");
                        dVar.n("23md5", (this.gVt.gVp == null ? "" : this.gVt.gVp.field_filemd5) + ",");
                        dVar.n("24cdnFileId", (this.gVt.gVp == null ? "" : this.gVt.gVp.field_fileId) + ",");
                        dVar.n("25cdnAesKey", (this.gVt.gVp == null ? "" : this.gVt.gVp.field_aesKey) + ",");
                        encode = "";
                        if (this.gVt.fCZ.axO()) {
                            com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(this.gVt.fCZ.field_content);
                            if (ek != null) {
                                encode = ek.appId;
                            }
                        }
                        dVar.n("26appip", encode + ",");
                        dVar.n("27toUsersCount", j.eC(com_tencent_mm_protocal_c_bhv.tfe.tZr) + ",");
                        w.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "report qrCodeImgChatting(13628): " + dVar.JG());
                        n.s(13628, dVar.toString());
                    }
                    this.gVt.ul();
                }
                return false;
            }
        };
        c gVs = new c<lx>(this) {
            final /* synthetic */ a gVt;

            {
                this.gVt = r2;
                this.usg = lx.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                if (((lx) bVar).fTd.filePath.equals(this.gVt.gVn)) {
                    if (this.gVt.gVq) {
                        w.i("MicroMsg.OnNetSceneUploadMsgImgEnd", "androidSystemShareFixed(13717), imgLocalId:%d, scene.hash:%d, %s", new Object[]{Long.valueOf(this.gVt.gVi), Integer.valueOf(this.gVt.hashCode()), this.gVt.gVl});
                        g.oUh.A(13717, this.gVt.gVl);
                    }
                    this.gVt.ul();
                }
                return false;
            }
        };

        a(long j, au auVar, com.tencent.mm.y.b bVar, boolean z, int i) {
            this.gVi = j;
            this.fCZ = auVar;
            this.gUA = bVar;
            this.gVj = i;
            this.gVq = z;
        }

        public final void ul() {
            com.tencent.mm.sdk.b.a.urY.c(this.gVr);
            com.tencent.mm.sdk.b.a.urY.c(this.gVs);
        }
    }

    public final void a(long j, au auVar, com.tencent.mm.y.b bVar, int i, boolean z, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        a aVar = new a(j, auVar, bVar, z, i);
        com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100131");
        if (dX.isValid()) {
            aVar.gVo = u.getInt((String) dX.bKK().get("needUploadData"), 1);
        }
        if (!aVar.gVm) {
            if (aVar.gVq || aVar.gVo != 0) {
                aVar.gVp = com_tencent_mm_modelcdntran_keep_SceneResult;
                aVar.gVm = true;
                String str = ((bhv) aVar.gUA.hsj.hsr).tfe.tZr;
                Object obj = (bg.mA(str) || !str.endsWith("@chatroom")) ? null : 1;
                aVar.gVl = "2," + (obj != null ? 2 : 1) + ",,";
                if (aVar.gVk == null) {
                    aVar.gVk = com.tencent.mm.ah.n.GS().b(Long.valueOf(aVar.gVi));
                }
                d dVar = aVar.gVk;
                if (dVar != null) {
                    com.tencent.mm.sdk.b.b lwVar = new lw();
                    com.tencent.mm.sdk.b.a.urY.b(aVar.gVr);
                    com.tencent.mm.sdk.b.a.urY.b(aVar.gVs);
                    aVar.gVn = com.tencent.mm.ah.n.GS().m(dVar.hEZ, "", "");
                    lwVar.fTb.filePath = aVar.gVn;
                    com.tencent.mm.sdk.b.a.urY.m(lwVar);
                }
            }
        }
    }
}
