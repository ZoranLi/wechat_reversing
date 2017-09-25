package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import java.io.ByteArrayOutputStream;

public final class j implements com.tencent.mm.modelcdntran.h.a {
    public String lfn = null;
    public a nmS;
    public String nmT;
    private boolean nmU = true;

    public interface a {
        void a(keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, String str, boolean z);
    }

    public static String aHW() {
        return bg.mz(d.a("NewYearImg", System.currentTimeMillis(), m.yr().field_username, ""));
    }

    public final boolean a(String str, String str2, int i, String str3, a aVar) {
        w.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: downloadImage. imageId:%s", new Object[]{str});
        this.nmU = false;
        this.lfn = aHW();
        w.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: downloadImage. client id:%s", new Object[]{this.lfn});
        this.nmT = str3;
        this.nmS = aVar;
        h hVar = new h();
        hVar.fZK = false;
        hVar.hze = this;
        hVar.field_fullpath = str3;
        hVar.field_mediaId = this.lfn;
        hVar.field_fileId = str;
        hVar.field_aesKey = str2;
        hVar.field_totalLen = i;
        hVar.field_fileType = b.MediaType_FILE;
        hVar.field_priority = b.hxL;
        hVar.field_needStorage = false;
        hVar.field_isStreamMedia = false;
        hVar.field_appType = 0;
        hVar.field_bzScene = 0;
        if (g.El().b(hVar, -1)) {
            return true;
        }
        w.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: cdntra addSendTask failed. imageId:%s", new Object[]{str});
        return false;
    }

    public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
        w.d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
        if (com_tencent_mm_modelcdntran_keep_SceneResult != null && this.lfn.equals(str) && !bg.mA(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId)) {
            w.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer success, sceneResult.field_retCode:" + com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
            if (i == 0 && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == 0) {
                if (this.nmU) {
                    w.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, upload callback success");
                } else {
                    w.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, download callback success");
                }
                w.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:transfer done, mediaid=%s, completeInfo=%s", new Object[]{str, com_tencent_mm_modelcdntran_keep_SceneResult.toString()});
                if (this.nmS != null) {
                    this.nmS.a(com_tencent_mm_modelcdntran_keep_SceneResult, this.nmT, true);
                }
            } else {
                w.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail");
                if (this.nmS != null) {
                    this.nmS.a(com_tencent_mm_modelcdntran_keep_SceneResult, this.nmT, false);
                }
            }
        } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null && this.lfn.equals(str) && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
            w.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail, sceneResult.field_retCode:" + com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
            if (this.nmS != null) {
                this.nmS.a(com_tencent_mm_modelcdntran_keep_SceneResult, this.nmT, false);
            }
        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
            w.d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: upload progressing....");
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return null;
    }
}
