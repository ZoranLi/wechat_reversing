package com.tencent.mm.plugin.v;

import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.v.a.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.al;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.k;
import java.io.ByteArrayOutputStream;
import java.io.File;

public final class e implements a, al {
    public static e nOy;
    public int fOR;
    private String gKJ;
    private h.a hGH = new h.a(this) {
        final /* synthetic */ e nOK;

        {
            this.nOK = r1;
        }

        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            w.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdnCallback clientid:%s, startRet:%d proginfo:[%s], res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
            if (i == -21005) {
                w.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[]{str});
                return 0;
            } else if (i != 0) {
                w.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback startRet failed. clientid:%s, startRet:%d", new Object[]{str, Integer.valueOf(i)});
                g.oUh.a(466, 2, 1, false);
                g.oUh.i(14108, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(this.nOK.fOR)});
                return 0;
            } else {
                if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        w.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback failed. sceneResult.retCode[%d], arg[%s], info[%s], clientid[%s], filemd5[%s]", new Object[]{Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult.field_arg, com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, str, com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5});
                        g.oUh.a(466, 2, 1, false);
                        g.oUh.i(14108, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(this.nOK.fOR)});
                    } else {
                        w.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback success. clientid[%s], filemd5[%s], isHitCacheUpload[%d]", new Object[]{str, com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType)});
                        PByteArray pByteArray = new PByteArray();
                        if (MMProtocalJni.rsaPublicEncryptPemkey(com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey.getBytes(), pByteArray, this.nOK.nOA)) {
                            String bo = bg.bo(pByteArray.value);
                            this.nOK.nOB = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                            this.nOK.nOC = bo;
                            this.nOK.nOD = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength;
                            if (com.tencent.mm.kernel.a.eN(com.tencent.mm.kernel.h.vG().gXk)) {
                                w.i("MicroMsg.MsgSynchronizeServer", "sendAppMsg immediately.");
                                this.nOK.aMr();
                            } else {
                                w.i("MicroMsg.MsgSynchronizeServer", "wait getOnlineInfoExtDeviceOnlineListener to sendAppMsg.");
                                ap.yY();
                                c.a(this.nOK);
                                this.nOK.nOI = true;
                            }
                        } else {
                            w.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize MMProtocalJni rsaPublicEncryptPemkey failed!");
                            return -1;
                        }
                    }
                }
                return 0;
            }
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] i(String str, byte[] bArr) {
            return new byte[0];
        }
    };
    public byte[] nOA;
    public String nOB;
    public String nOC;
    public int nOD;
    public long nOE;
    public long nOF;
    public long nOG;
    public long nOH;
    public boolean nOI = false;
    public final com.tencent.mm.y.e nOJ = new com.tencent.mm.y.e(this) {
        final /* synthetic */ e nOK;

        {
            this.nOK = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            ap.vd().b(222, this.nOK.nOJ);
            if (i == 0 && i2 == 0) {
                w.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize success. ");
                com.tencent.mm.a.e.d(new File(f.aMt()));
                com.tencent.mm.a.e.d(new File(f.aMu()));
                long aA = bg.aA(this.nOK.nOE);
                g.oUh.a(466, 1, 1, false);
                g.oUh.a(466, 5, this.nOK.nOH, false);
                g.oUh.a(466, 7, aA, false);
                g.oUh.a(466, 11, this.nOK.nOG, false);
                g.oUh.a(466, 12, this.nOK.nOF, false);
                g.oUh.i(14108, new Object[]{Long.valueOf(this.nOK.nOH), Long.valueOf(aA), Long.valueOf(this.nOK.nOG), Long.valueOf(this.nOK.nOF), Integer.valueOf(0), Integer.valueOf(this.nOK.fOR)});
                return;
            }
            w.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize appmsg.  errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            g.oUh.a(466, 3, 1, false);
            g.oUh.i(14108, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(this.nOK.fOR)});
        }
    };
    public c nOz = new c();

    public final void a(String str, int i, String str2, int i2, long j, long j2) {
        w.i("MicroMsg.MsgSynchronizeServer", "onMsgSynchronizePackFinish filePath:%s, conversationSize:%d", new Object[]{str, Integer.valueOf(i)});
        this.nOF = (long) i2;
        this.nOG = j;
        this.nOH = j2;
        this.gKJ = str2;
        String str3 = "MSG_SYNCHRONIZE_" + i + "_" + bg.Nz();
        h hVar = new h();
        hVar.hze = this.hGH;
        hVar.field_mediaId = str3;
        hVar.field_fullpath = str;
        hVar.field_fileType = b.MediaType_FILE;
        hVar.field_talker = (String) com.tencent.mm.plugin.backup.g.a.abC().abD().vr().get(2, null);
        hVar.field_priority = b.hxL;
        if (!com.tencent.mm.modelcdntran.g.El().b(hVar)) {
            w.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize addSendTask failed. clientid:%s", new Object[]{str3});
            g.oUh.a(466, 2, 1, false);
            g.oUh.i(14108, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(this.fOR)});
        }
    }

    public final void yP() {
        w.i("MicroMsg.MsgSynchronizeServer", "receive onNotifyUserStatusChange, needWaitExtLoginCallback[%b], isWebWXOnline:[%b]", new Object[]{Boolean.valueOf(this.nOI), Boolean.valueOf(com.tencent.mm.kernel.a.eN(com.tencent.mm.kernel.h.vG().gXk))});
        if (this.nOI && com.tencent.mm.kernel.a.eN(com.tencent.mm.kernel.h.vG().gXk)) {
            w.i("MicroMsg.MsgSynchronizeServer", "onNotifyUserStatusChange need send msgSynchronize appMsg.");
            ap.yY();
            c.b(this);
            this.nOI = false;
            aMr();
        }
    }

    public final void aMr() {
        w.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize start send AppMsg.");
        ap.vd().a(222, this.nOJ);
        ap.vd().a(new d(this.nOB, this.nOC, this.nOD, this.gKJ), 0);
    }

    public final void aaa() {
        w.e("MicroMsg.MsgSynchronizeServer", "MsgSynchronizeServer cancel, Caller:%s", new Object[]{ah.bJn()});
        this.nOz.nOr = true;
    }
}
