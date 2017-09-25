package com.tencent.mm.plugin.sns.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.modelcdntran.c;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.c.ale;
import com.tencent.mm.protocal.c.alk;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bax;
import com.tencent.mm.protocal.c.bcn;
import com.tencent.mm.protocal.c.bco;
import com.tencent.mm.protocal.c.bfw;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.ByteArrayOutputStream;

public final class y extends k implements j {
    private b gUA;
    public e gUD;
    private a hGH;
    private int hGQ;
    public String hGx;
    public int hGy;
    private int hrs;
    private int offset;
    private int pRa;
    private String pUJ;
    private bcn pUK;
    private String pUL;
    private boolean pUM;
    private boolean pUN;
    private boolean pUO;
    public long pUP;
    public int pUQ;
    private String path;
    public long startTime;

    public y(int i, String str, boolean z, int i2) {
        this.hGQ = 8192;
        this.offset = 0;
        this.path = "";
        this.pUJ = "";
        this.pRa = 0;
        this.pUL = "";
        this.hGx = "";
        this.pUM = false;
        this.pUN = false;
        this.pUO = false;
        this.pUP = 0;
        this.startTime = 0;
        this.hGy = 0;
        this.pUQ = 0;
        this.hGH = new a(this) {
            final /* synthetic */ y pUR;

            {
                this.pUR = r1;
            }

            public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                if (i == -21005) {
                    w.d("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.pUR.hGx, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    this.pUR.gUD.a(3, -1, "doScene failed", this.pUR);
                    return 0;
                } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == 0) {
                    w.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.pUR.hGx, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    this.pUR.a(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl, 1, com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbUrl, 1, "upload_" + this.pUR.hGx, com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5);
                    w.i("MicroMsg.NetSceneMMSnsUpload", "uploadsns cdndone pass: " + (System.currentTimeMillis() - this.pUR.pUP) + " " + com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5);
                    g.oUh.i(10421, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.pUR.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(this.pUR.hGy), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    this.pUR.gUD.a(0, 0, "doScene", this.pUR);
                    return 0;
                } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                    w.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.pUR.hGx, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    if (this.pUR.pUQ == 21) {
                        if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode <= -10000 && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode > -20000) {
                            com.tencent.mm.plugin.sns.lucky.a.b.mN(10);
                        } else if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode <= -20000 && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode >= -22000) {
                            com.tencent.mm.plugin.sns.lucky.a.b.mN(11);
                        } else if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode > -5103000 || com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode < -5103087) {
                            com.tencent.mm.plugin.sns.lucky.a.b.mN(15);
                        } else {
                            com.tencent.mm.plugin.sns.lucky.a.b.mN(9);
                        }
                    }
                    this.pUR.sU(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                    g.oUh.i(10421, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.pUR.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(this.pUR.hGy), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    g.oUh.i(13937, new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.pUR.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(this.pUR.hGy), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    this.pUR.gUD.a(3, -1, "doScene failed", this.pUR);
                    return 0;
                } else if (i != 0) {
                    w.i("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.pUR.hGx, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                    this.pUR.sV(0);
                    if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                        g.oUh.i(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.pUR.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(this.pUR.hGy), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2});
                    }
                    this.pUR.gUD.a(3, -1, "doScene failed", this.pUR);
                    return 0;
                } else {
                    w.d("MicroMsg.NetSceneMMSnsUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{this.pUR.hGx, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
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
        this.pRa = i;
        this.pUL = str;
        this.pUQ = i2;
        b.a aVar = new b.a();
        aVar.hsm = new bcn();
        aVar.hsn = new bco();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsupload";
        aVar.hsl = 207;
        aVar.hso = 95;
        aVar.hsp = 1000000095;
        this.gUA = aVar.BE();
        this.pUK = (bcn) this.gUA.hsj.hsr;
        q dH = ae.beA().dH((long) i);
        this.pUO = z;
        w.i("MicroMsg.NetSceneMMSnsUpload", "start snsupload netscene localId " + i + "  offset " + dH.offset + " path " + dH.olJ + " totallen " + dH.qnP);
        if (!z) {
            this.pUK.tQZ = 1;
            w.i("MicroMsg.NetSceneMMSnsUpload", "this is single upload");
        }
        try {
            Object obj;
            alk com_tencent_mm_protocal_c_alk = (alk) new alk().aD(dH.qnT);
            this.pUJ = i.EF(dH.olJ);
            this.path = am.du(ae.getAccSnsPath(), dH.olJ) + this.pUJ;
            this.hrs = (int) FileOp.ki(this.path);
            this.pUM = i.EO(this.path);
            w.i("MicroMsg.NetSceneMMSnsUpload", "totallen " + this.hrs + " isLongPic: " + this.pUM);
            String str2 = com_tencent_mm_protocal_c_alk.tQf;
            if (bg.mA(str2)) {
                str2 = com.tencent.mm.a.g.n((bg.NA()).getBytes());
                com_tencent_mm_protocal_c_alk.tQf = str2;
                try {
                    dH.qnT = com_tencent_mm_protocal_c_alk.toByteArray();
                    ae.beA().a(dH.qnk, dH);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.NetSceneMMSnsUpload", e, "", new Object[0]);
                }
            }
            this.pUK.tgJ = this.hrs;
            this.pUK.tgK = dH.offset;
            this.pUK.teW = str2;
            this.hGx = str2;
            w.d("MicroMsg.NetSceneMMSnsUpload", "filter style " + com_tencent_mm_protocal_c_alk.tPE);
            this.pUK.tPE = com_tencent_mm_protocal_c_alk.tPE;
            w.d("MicroMsg.NetSceneMMSnsUpload", "syncWeibo " + com_tencent_mm_protocal_c_alk.tPF);
            this.pUK.tgT = com_tencent_mm_protocal_c_alk.msk;
            this.pUK.tPF = com_tencent_mm_protocal_c_alk.tPF;
            w.d("MicroMsg.NetSceneMMSnsUpload", "request upload type " + dH.type + " md5: " + com_tencent_mm_protocal_c_alk.fFW + " appid " + com_tencent_mm_protocal_c_alk.fTO + " contenttype " + com_tencent_mm_protocal_c_alk.jFe);
            this.pUK.jOc = dH.type;
            bfw com_tencent_mm_protocal_c_bfw = new bfw();
            com_tencent_mm_protocal_c_bfw.ugm = com_tencent_mm_protocal_c_alk.token;
            com_tencent_mm_protocal_c_bfw.ugn = com_tencent_mm_protocal_c_alk.tPO;
            this.pUK.tVq = com_tencent_mm_protocal_c_bfw;
            if (!bg.mA(com_tencent_mm_protocal_c_alk.fFW)) {
                this.pUK.tuy = com_tencent_mm_protocal_c_alk.fFW;
            }
            if (!bg.mA(com_tencent_mm_protocal_c_alk.fTO)) {
                this.pUK.mtb = com_tencent_mm_protocal_c_alk.fTO;
            }
            this.pUK.udD = com_tencent_mm_protocal_c_alk.jFe;
            if (r.iiz) {
                this.pUK.jOc = 0;
            }
            if (this.startTime == 0) {
                this.startTime = bg.Nz();
                this.hGy = com.tencent.mm.modelcdntran.b.MediaType_FRIENDS;
            }
            bcn com_tencent_mm_protocal_c_bcn = this.pUK;
            com.tencent.mm.modelcdntran.g.El();
            if (!c.fA(32)) {
                Object[] objArr = new Object[1];
                com.tencent.mm.modelcdntran.g.El();
                objArr[0] = Boolean.valueOf(c.fA(32));
                w.w("MicroMsg.NetSceneMMSnsUpload", "cdntra not use cdn flag:%b", objArr);
                obj = null;
            } else if (r.ijo == 2) {
                obj = null;
            } else {
                this.hGx = com_tencent_mm_protocal_c_bcn.teW;
                if (bg.mA(this.hGx)) {
                    w.w("MicroMsg.NetSceneMMSnsUpload", "cdntra genClientId failed not use cdn");
                    obj = null;
                } else {
                    obj = 1;
                }
            }
            if (obj != null) {
                this.pUN = true;
            } else if (!bei()) {
                onError();
            }
        } catch (Exception e2) {
            w.e("MicroMsg.NetSceneMMSnsUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
        }
    }

    private boolean bei() {
        q dH = ae.beA().dH((long) this.pRa);
        int i = dH.qnP - dH.offset;
        if (i > this.hGQ) {
            i = this.hGQ;
        }
        this.offset = dH.offset;
        byte[] c = FileOp.c(this.path, this.offset, i);
        if (c == null || c.length <= 0) {
            return false;
        }
        avw com_tencent_mm_protocal_c_avw = new avw();
        com_tencent_mm_protocal_c_avw.bb(c);
        this.pUK.tij = com_tencent_mm_protocal_c_avw;
        this.pUK.tgK = this.offset;
        return true;
    }

    protected final int a(p pVar) {
        return k.b.hsT;
    }

    protected final int ub() {
        if (this.pUM) {
            return 675;
        }
        return 100;
    }

    public final int getType() {
        return 207;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneMMSnsUpload", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bco com_tencent_mm_protocal_c_bco = (bco) ((b) pVar).hsk.hsr;
        if (i2 == 4) {
            sV(i3);
            if (this.pUQ == 21) {
                com.tencent.mm.plugin.sns.lucky.a.b.mN(12);
            }
            this.gUD.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            q dH = ae.beA().dH((long) this.pRa);
            if (com_tencent_mm_protocal_c_bco.tgK < 0 || (com_tencent_mm_protocal_c_bco.tgK > dH.qnP && dH.qnP > 0)) {
                onError();
                if (i2 == 3) {
                    com.tencent.mm.plugin.sns.lucky.a.b.mN(14);
                }
            } else if (com_tencent_mm_protocal_c_bco.tgK < dH.offset) {
                onError();
                if (i2 == 3) {
                    com.tencent.mm.plugin.sns.lucky.a.b.mN(14);
                }
            } else {
                w.d("MicroMsg.NetSceneMMSnsUpload", " bufferUrl: " + com_tencent_mm_protocal_c_bco.udE.msN + " bufferUrlType: " + com_tencent_mm_protocal_c_bco.udE.jOc + "  id:" + com_tencent_mm_protocal_c_bco.tmx + " thumb Count: " + com_tencent_mm_protocal_c_bco.tQc + "  type " + com_tencent_mm_protocal_c_bco.jOc + " startPos : " + com_tencent_mm_protocal_c_bco.tgK);
                dH.offset = com_tencent_mm_protocal_c_bco.tgK;
                ae.beA().a(this.pRa, dH);
                Object obj = (dH.offset != dH.qnP || dH.qnP == 0) ? null : 1;
                if (obj != null) {
                    w.i("MicroMsg.NetSceneMMSnsUpload", "uploadsns done pass: " + (System.currentTimeMillis() - this.pUP));
                    if (com_tencent_mm_protocal_c_bco.tQd.size() == 0 || com_tencent_mm_protocal_c_bco.tQd.size() <= 0) {
                        a(com_tencent_mm_protocal_c_bco.udE.msN, com_tencent_mm_protocal_c_bco.udE.jOc, "", 0, com_tencent_mm_protocal_c_bco.tmx, this.pUK.tuy);
                    } else {
                        a(com_tencent_mm_protocal_c_bco.udE.msN, com_tencent_mm_protocal_c_bco.udE.jOc, ((bax) com_tencent_mm_protocal_c_bco.tQd.get(0)).msN, ((bax) com_tencent_mm_protocal_c_bco.tQd.get(0)).jOc, com_tencent_mm_protocal_c_bco.tmx, this.pUK.tuy);
                    }
                    this.gUD.a(i2, i3, str, this);
                } else if (bei() && a(this.hsD, this.gUD) < 0) {
                    this.gUD.a(3, -1, "doScene failed", this);
                }
            }
        } else {
            onError();
            if (this.pUQ == 21) {
                com.tencent.mm.plugin.sns.lucky.a.b.mN(13);
            }
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final boolean a(String str, int i, String str2, int i2, String str3, String str4) {
        alk com_tencent_mm_protocal_c_alk;
        q dH = ae.beA().dH((long) this.pRa);
        w.i("MicroMsg.NetSceneMMSnsUpload", "upload ok " + str + "  " + str3 + "  " + i + " thumbUrl: " + str2);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeFile(this.path, options, null, 0, new int[0]);
        String toLowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
        int i3 = -1;
        if (toLowerCase.endsWith("jpg") || toLowerCase.endsWith("jpeg")) {
            i3 = MMNativeJpeg.queryQuality(this.path);
            if (i3 == 0) {
                i3 = -1;
            }
        }
        com.tencent.mm.plugin.sns.h.c.a(str, options.outMimeType, options.outWidth, options.outHeight, i3, FileOp.ki(this.path));
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
        com_tencent_mm_protocal_c_ale.jOc = i;
        com_tencent_mm_protocal_c_ale.msN = str;
        com_tencent_mm_protocal_c_alk.tQb = com_tencent_mm_protocal_c_ale;
        com_tencent_mm_protocal_c_alk.tQe = 0;
        com_tencent_mm_protocal_c_alk.fFW = str4;
        if (!bg.mA(str2)) {
            com_tencent_mm_protocal_c_ale = new ale();
            com_tencent_mm_protocal_c_ale.jOc = i2;
            com_tencent_mm_protocal_c_ale.msN = str2;
            com_tencent_mm_protocal_c_alk.tQd.add(com_tencent_mm_protocal_c_ale);
        }
        try {
            dH.qnT = com_tencent_mm_protocal_c_alk.toByteArray();
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.NetSceneMMSnsUpload", e2, "", new Object[0]);
        }
        dH.bhU();
        ae.beA().a(this.pRa, dH);
        ae.beK().ta(this.pRa);
        if (ae.beH() != null) {
            ae.beH().bdz();
        }
        return true;
    }

    public final void sU(int i) {
        for (int i2 : com.tencent.mm.modelcdntran.a.hxJ) {
            if (i == i2) {
                sV(0);
                return;
            }
        }
        onError();
    }

    public final void sV(int i) {
        q dH = ae.beA().dH((long) this.pRa);
        try {
            alk com_tencent_mm_protocal_c_alk = (alk) new alk().aD(dH.qnT);
            com_tencent_mm_protocal_c_alk.tQe = 1;
            com_tencent_mm_protocal_c_alk.tPN = i;
            dH.qnT = com_tencent_mm_protocal_c_alk.toByteArray();
        } catch (Exception e) {
        }
        ae.beK().ta(this.pRa);
        ae.beA().a(this.pRa, dH);
    }

    private void onError() {
        q dH = ae.beA().dH((long) this.pRa);
        dH.offset = 0;
        try {
            alk com_tencent_mm_protocal_c_alk = (alk) new alk().aD(dH.qnT);
            com_tencent_mm_protocal_c_alk.tQf = "";
            dH.qnT = com_tencent_mm_protocal_c_alk.toByteArray();
            ae.beA().a(this.pRa, dH);
            ae.beK().ta(this.pRa);
        } catch (Exception e) {
            w.e("MicroMsg.NetSceneMMSnsUpload", "parseFrom MediaUploadInfo error in NetSceneSnsUpload");
        }
    }

    protected final void cancel() {
        super.cancel();
        if (this.pUN && !bg.mA(this.hGx)) {
            w.i("MicroMsg.NetSceneMMSnsUpload", "cancel by cdn " + this.hGx);
            com.tencent.mm.modelcdntran.g.El().iO(this.hGx);
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 108;
        this.gUD = eVar2;
        if (!this.pUN) {
            return a(eVar, this.gUA, this);
        }
        this.hGx = this.pUK.teW;
        if (bg.mA(this.hGx)) {
            w.w("MicroMsg.NetSceneMMSnsUpload", "cdntra genClientId failed not use cdn");
        } else {
            h hVar = new h();
            hVar.hze = this.hGH;
            hVar.field_mediaId = this.hGx;
            hVar.field_fullpath = this.path;
            hVar.field_thumbpath = "";
            hVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FRIENDS;
            hVar.field_talker = "";
            hVar.field_priority = com.tencent.mm.modelcdntran.b.hxL;
            hVar.field_needStorage = true;
            hVar.field_isStreamMedia = false;
            if (com.tencent.mm.plugin.sns.storage.r.bhW()) {
                if (!this.pUO) {
                    i = MMGIFException.D_GIF_ERR_WRONG_RECORD;
                }
                hVar.field_appType = i;
            } else if (com.tencent.mm.plugin.sns.storage.r.bhV()) {
                if (!this.pUO) {
                    i = MMGIFException.D_GIF_ERR_WRONG_RECORD;
                }
                hVar.field_appType = i;
            } else {
                com.tencent.mm.modelcdntran.g.El();
                if (c.fA(64)) {
                    hVar.field_appType = this.pUO ? 104 : 103;
                } else {
                    hVar.field_appType = this.pUO ? 101 : 100;
                }
            }
            hVar.field_bzScene = 1;
            if (!com.tencent.mm.modelcdntran.g.El().b(hVar)) {
                w.e("MicroMsg.NetSceneMMSnsUpload", "cdntra addSendTask failed. clientid:%s", new Object[]{this.hGx});
                this.hGx = "";
            }
        }
        return 0;
    }
}
