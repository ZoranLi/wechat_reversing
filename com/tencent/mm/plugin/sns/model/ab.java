package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.e.a.pg;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.plugin.mmsight.model.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.protocal.c.ale;
import com.tencent.mm.protocal.c.alk;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayOutputStream;

public final class ab {
    private String aGN;
    private String clientId;
    private String fKz;
    private com.tencent.mm.modelcdntran.h.a hGH;
    public String hGx;
    public int hGy;
    public int hZS;
    private String kPx;
    private int pRa;
    private long pUP;
    public q pVg;
    public a pVh;
    private alk pVi;
    public long startTime;

    public interface a {
        void hk(boolean z);
    }

    public ab(int i, q qVar, String str, String str2, a aVar) {
        this.clientId = "";
        this.pUP = 0;
        this.startTime = 0;
        this.hGy = 0;
        this.kPx = "";
        this.pVi = new alk();
        this.hGH = new com.tencent.mm.modelcdntran.h.a(this) {
            final /* synthetic */ ab pVl;

            {
                this.pVl = r1;
            }

            public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                if (i == -21005) {
                    w.d("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.pVl.hGx, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    this.pVl.pVh.hk(true);
                    return 0;
                } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == 0) {
                    w.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.pVl.hGx, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    this.pVl.P(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl, com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbUrl, "upload_" + this.pVl.hGx);
                    g.oUh.i(10421, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.pVl.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(com.tencent.mm.sdk.platformtools.ab.getContext())), Integer.valueOf(this.pVl.hGy), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    n KT = n.KT();
                    int i2 = this.pVl.hZS;
                    if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                        String str2 = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl;
                        String str3 = str2.hashCode();
                        com.tencent.mm.modelvideo.n.a aVar = (com.tencent.mm.modelvideo.n.a) KT.hZB.get(str3);
                        if (aVar == null) {
                            aVar = new com.tencent.mm.modelvideo.n.a(KT);
                        }
                        String str4 = "";
                        aVar.gxF = str4;
                        aVar.toUser = str4;
                        aVar.hZO = str4;
                        aVar.hZS = i2;
                        aVar.hZR = 1;
                        aVar.fOz = str2;
                        aVar.hZf = com_tencent_mm_modelcdntran_keep_SceneResult;
                        aVar.startTime = bg.Nz();
                        KT.hZB.put(str3, aVar);
                        w.i("MicroMsg.SubCoreMediaRpt", "note sns video sendScene %d snsKey[%s] url[%s]", new Object[]{Integer.valueOf(i2), str3, str2});
                    }
                    this.pVl.pVh.hk(true);
                    return 0;
                } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                    w.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.pVl.hGx, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    this.pVl.sV(0);
                    g.oUh.i(10421, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.pVl.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(com.tencent.mm.sdk.platformtools.ab.getContext())), Integer.valueOf(this.pVl.hGy), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    g.oUh.i(13937, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.pVl.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(com.tencent.mm.sdk.platformtools.ab.getContext())), Integer.valueOf(this.pVl.hGy), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    this.pVl.pVh.hk(false);
                    return 0;
                } else if (i != 0) {
                    w.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.pVl.hGx, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    this.pVl.sV(0);
                    if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                        g.oUh.i(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.pVl.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(com.tencent.mm.sdk.platformtools.ab.getContext())), Integer.valueOf(this.pVl.hGy), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    }
                    this.pVl.pVh.hk(false);
                    return 0;
                } else {
                    w.d("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.pVl.hGx, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    return 0;
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] i(String str, byte[] bArr) {
                return null;
            }
        };
        this.pUP = System.currentTimeMillis();
        this.aGN = str;
        this.fKz = str2;
        this.pVh = aVar;
        this.pRa = i;
        this.pVg = qVar;
        try {
            this.pVi = (alk) new alk().aD(qVar.qnT);
            this.clientId = this.pVi.tQf;
            this.kPx = this.pVi.fFW;
            if (bg.mA(this.clientId)) {
                this.clientId = com.tencent.mm.a.g.n((bg.NA()).getBytes());
                this.pVi.tQf = this.clientId;
                try {
                    qVar.qnT = this.pVi.toByteArray();
                    ae.beA().a(qVar.qnk, qVar);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.SightCdnUpload", e, "", new Object[0]);
                }
            }
            int ki = (int) FileOp.ki(str);
            w.i("MicroMsg.SightCdnUpload", "sightupload %d videopath %s sightFileSize %d md5 %s", new Object[]{Integer.valueOf(i), str, Integer.valueOf(ki), this.kPx});
        } catch (Exception e2) {
            w.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
        }
    }

    public final boolean bek() {
        String aV = com.tencent.mm.a.g.aV(this.aGN);
        if (bg.mA(this.kPx) || this.kPx.equals(aV)) {
            aks com_tencent_mm_protocal_c_aks;
            if (this.pVi.tQi != null) {
                com_tencent_mm_protocal_c_aks = this.pVi.tQi;
            } else {
                com_tencent_mm_protocal_c_aks = new aks();
            }
            w.i("MicroMsg.SightCdnUpload", "check upload %s %d %s", new Object[]{this.aGN, Integer.valueOf(com_tencent_mm_protocal_c_aks.tOt), Boolean.valueOf(com_tencent_mm_protocal_c_aks.tOs)});
            if (com_tencent_mm_protocal_c_aks.tOs) {
                int i = h.nCG;
                if (com_tencent_mm_protocal_c_aks.tOt >= 3) {
                    onError();
                    return false;
                }
                w.i("MicroMsg.SightCdnUpload", "try need remux %d %s", new Object[]{Integer.valueOf(i), this.aGN});
                final b pgVar = new pg();
                pgVar.nFq = new Runnable(this) {
                    final /* synthetic */ ab pVl;

                    public final void run() {
                        w.i("MicroMsg.SightCdnUpload", "event callback errcode %d", new Object[]{Integer.valueOf(pgVar.fWh.result)});
                        if (pgVar.fWh.result >= 0) {
                            this.pVl.bel();
                            this.pVl.a(com_tencent_mm_protocal_c_aks);
                            return;
                        }
                        this.pVl.onError();
                    }
                };
                pgVar.fWg.fWk = new com.tencent.mm.plugin.mmsight.model.d(this) {
                    final /* synthetic */ ab pVl;

                    {
                        this.pVl = r1;
                    }

                    public final boolean aJQ() {
                        w.i("MicroMsg.SightCdnUpload", "iUpdateVideoFile");
                        this.pVl.bel();
                        return false;
                    }
                };
                pgVar.fWg.fVT = this.aGN;
                pgVar.fWg.scene = i;
                pgVar.fWg.fWi = com_tencent_mm_protocal_c_aks;
                pgVar.fWg.fWj = new Runnable(this) {
                    final /* synthetic */ ab pVl;

                    public final void run() {
                        com_tencent_mm_protocal_c_aks.tOt++;
                        try {
                            w.i("MicroMsg.SightCdnUpload", "add try count %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aks.tOt)});
                            alk com_tencent_mm_protocal_c_alk = (alk) new alk().aD(this.pVl.pVg.qnT);
                            com_tencent_mm_protocal_c_alk.tQi = com_tencent_mm_protocal_c_aks;
                            this.pVl.pVg.qnT = com_tencent_mm_protocal_c_alk.toByteArray();
                            ae.beA().a(this.pVl.pVg.qnk, this.pVl.pVg);
                        } catch (Exception e) {
                            w.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in checkUploadaddCount %s", new Object[]{e.getMessage()});
                        }
                    }
                };
                com.tencent.mm.sdk.b.a.urY.a(pgVar, ae.bey().getLooper());
                return true;
            }
            a(com_tencent_mm_protocal_c_aks);
            return true;
        }
        w.i("MicroMsg.SightCdnUpload", "checkUpload isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[]{this.kPx, aV});
        sV(-2);
        this.pVh.hk(false);
        return false;
    }

    public final void bel() {
        try {
            this.pVi = (alk) new alk().aD(this.pVg.qnT);
            this.kPx = com.tencent.mm.a.g.aV(this.aGN);
            this.pVi.fFW = this.kPx;
            this.pVg.qnT = this.pVi.toByteArray();
            w.i("MicroMsg.SightCdnUpload", "new md5 is %s %s", new Object[]{this.aGN, this.kPx});
            ae.beA().a(this.pVg.qnk, this.pVg);
        } catch (Exception e) {
            w.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in updateMd5Info %s", new Object[]{e.getMessage()});
        }
    }

    public final boolean a(aks com_tencent_mm_protocal_c_aks) {
        if (this.startTime == 0) {
            this.startTime = bg.Nz();
            this.hGy = com.tencent.mm.modelcdntran.b.hxP;
        }
        String str = this.clientId;
        if (bg.mA(str)) {
            w.w("MicroMsg.SightCdnUpload", "cdntra genClientId failed not use cdn");
            return false;
        }
        com.tencent.mm.modelcdntran.h hVar = new com.tencent.mm.modelcdntran.h();
        hVar.hze = this.hGH;
        hVar.field_mediaId = str;
        hVar.field_fullpath = this.aGN;
        hVar.field_thumbpath = this.fKz;
        hVar.field_fileType = com.tencent.mm.modelcdntran.b.hxP;
        hVar.field_talker = "";
        hVar.field_priority = com.tencent.mm.modelcdntran.b.hxL;
        hVar.field_needStorage = true;
        hVar.field_isStreamMedia = false;
        hVar.field_appType = 102;
        hVar.field_bzScene = 1;
        hVar.field_largesvideo = true;
        String aV = com.tencent.mm.a.g.aV(this.aGN);
        if (!bg.mA(this.kPx) && !this.kPx.equals(aV)) {
            w.i("MicroMsg.SightCdnUpload", "isNotSafeSightVideo old srcmd5 %s newmd5 %s ", new Object[]{this.kPx, aV});
            sV(-2);
            this.pVh.hk(false);
            return false;
        } else if (com.tencent.mm.modelcdntran.g.El().b(hVar)) {
            int i = (com_tencent_mm_protocal_c_aks == null || !com_tencent_mm_protocal_c_aks.tOs) ? 5 : 4;
            this.hZS = i;
            return true;
        } else {
            w.e("MicroMsg.SightCdnUpload", "cdntra addSendTask failed. clientid:%s", new Object[]{str});
            return false;
        }
    }

    public final boolean P(String str, String str2, String str3) {
        alk com_tencent_mm_protocal_c_alk;
        q dH = ae.beA().dH((long) this.pRa);
        w.d("MicroMsg.SightCdnUpload", "upload ok " + str + "  " + str3 + "  1");
        dH.qnS = str3;
        try {
            com_tencent_mm_protocal_c_alk = (alk) new alk().aD(dH.qnT);
        } catch (Exception e) {
            com_tencent_mm_protocal_c_alk = null;
        }
        if (com_tencent_mm_protocal_c_alk == null) {
            com_tencent_mm_protocal_c_alk = new alk();
        }
        ale com_tencent_mm_protocal_c_ale = new ale();
        com_tencent_mm_protocal_c_ale.jOc = 1;
        com_tencent_mm_protocal_c_ale.msN = str;
        com_tencent_mm_protocal_c_alk.tQb = com_tencent_mm_protocal_c_ale;
        com_tencent_mm_protocal_c_alk.tQe = 0;
        com.tencent.mm.modelcdntran.g.Em();
        com_tencent_mm_protocal_c_alk.tPD = com.tencent.mm.modelcdntran.b.iL(this.aGN);
        w.i("MicroMsg.SightCdnUpload", "onPostScene videomd5 %s", new Object[]{com_tencent_mm_protocal_c_alk.tPD});
        if (!bg.mA(str2)) {
            com_tencent_mm_protocal_c_ale = new ale();
            com_tencent_mm_protocal_c_ale.jOc = 1;
            com_tencent_mm_protocal_c_ale.msN = str2;
            com_tencent_mm_protocal_c_alk.tQd.add(com_tencent_mm_protocal_c_ale);
        }
        try {
            dH.qnT = com_tencent_mm_protocal_c_alk.toByteArray();
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.SightCdnUpload", e2, "", new Object[0]);
        }
        dH.bhU();
        ae.beA().a(this.pRa, dH);
        ae.beK().ta(this.pRa);
        if (ae.beH() != null) {
            ae.beH().bdz();
        }
        return true;
    }

    public final void sV(int i) {
        w.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
        q dH = ae.beA().dH((long) this.pRa);
        try {
            alk com_tencent_mm_protocal_c_alk = (alk) new alk().aD(dH.qnT);
            com_tencent_mm_protocal_c_alk.tQe = 1;
            com_tencent_mm_protocal_c_alk.tPN = i;
            if (this.pVi.tQi != null) {
                this.pVi.tQi.tOt = 0;
            }
            dH.qnT = com_tencent_mm_protocal_c_alk.toByteArray();
        } catch (Exception e) {
        }
        ae.beK().ta(this.pRa);
        ae.beA().a(this.pRa, dH);
    }

    public final void onError() {
        w.i("MicroMsg.SightCdnUpload", "snsupload sight by cdn error!");
        q dH = ae.beA().dH((long) this.pRa);
        dH.offset = 0;
        try {
            alk com_tencent_mm_protocal_c_alk = (alk) new alk().aD(dH.qnT);
            com_tencent_mm_protocal_c_alk.tQf = "";
            if (com_tencent_mm_protocal_c_alk.tQi != null) {
                com_tencent_mm_protocal_c_alk.tQi.tOt = 0;
            }
            dH.qnT = com_tencent_mm_protocal_c_alk.toByteArray();
            ae.beA().a(this.pRa, dH);
            ae.beK().ta(this.pRa);
        } catch (Exception e) {
            w.e("MicroMsg.SightCdnUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
        }
    }
}
