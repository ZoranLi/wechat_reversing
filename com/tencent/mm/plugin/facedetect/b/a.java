package com.tencent.mm.plugin.facedetect.b;

import android.os.Bundle;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.ByteArrayOutputStream;

public final class a implements e {
    public boolean fCk = false;
    public d luA = null;
    public c luB = null;
    public boolean luC = false;
    public long luD = 0;
    public int luE = 0;
    public k luF = null;
    public k luG = null;
    public long luH = -1;
    public int luI = -1;
    public com.tencent.mm.modelcdntran.h.a luJ = new com.tencent.mm.modelcdntran.h.a(this) {
        final /* synthetic */ a luK;

        {
            this.luK = r1;
        }

        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            if (i == -21005) {
                w.i("MicroMsg.FaceUploadProcessor", "hy: ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
            } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == 0) {
                w.i("MicroMsg.FaceUploadProcessor", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                String str2 = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                Bundle bundle = new Bundle();
                bundle.putString("key_pic_cdn_id", str2);
                bundle.putString("key_cdn_aes_key", com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey);
                a aVar = this.luK;
                String str3 = "ok";
                if (aVar.luA != null) {
                    aVar.luA.a(0, 0, str3, bundle);
                }
            } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                w.w("MicroMsg.FaceUploadProcessor", "hy: cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                this.luK.f(3, 90020, "cdn ret error");
            } else if (i != 0) {
                w.w("MicroMsg.FaceUploadProcessor", "hy: start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                this.luK.f(3, 90021, "cdn start error");
            } else {
                w.i("MicroMsg.FaceUploadProcessor", "hy: on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                    w.d("MicroMsg.FaceUploadProcessor", "hy: cdn process: %f", new Object[]{Double.valueOf(((double) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength) / ((double) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength))});
                    a aVar2 = this.luK;
                    if (aVar2.luA != null) {
                        aVar2.luA.f(r0);
                    }
                }
            }
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] i(String str, byte[] bArr) {
            return null;
        }
    };
    public int luz = -1;

    public a(int i) {
        this.luz = i;
    }

    public final void arj() {
        if (this.luG != null) {
            h.vd().b(this.luG.getType(), this);
        }
    }

    public final void f(final int i, final int i2, final String str) {
        af.v(new Runnable(this) {
            final /* synthetic */ a luK;

            public final void run() {
                if (this.luK.luA != null) {
                    this.luK.luA.a(this.luK.luE, i, i2, str);
                }
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        boolean z = false;
        w.i("MicroMsg.FaceUploadProcessor", "hy: scene: %s, errType: %d, errCode: %d, errMsg: %s", new Object[]{kVar.toString(), Integer.valueOf(i), Integer.valueOf(i2), str});
        if ((kVar instanceof u) || (kVar instanceof v)) {
            if (i == 0 && i2 == 0) {
                b bVar = (b) kVar;
                this.luD = bVar.ark();
                com.tencent.mm.plugin.facedetect.model.e.bN(this.luD);
                if (bVar.arl() == null) {
                    w.e("MicroMsg.FaceUploadProcessor", "hy: backend not return config");
                    f(2, 90015, "face motion config from server is null");
                    return;
                }
                byte[] arl = bVar.arl();
                String str2 = "MicroMsg.FaceUploadProcessor";
                String str3 = "configLen: %d, mUploadCallback == null: %b";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(arl.length);
                if (this.luA == null) {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                w.i(str2, str3, objArr);
                if (this.luB != null) {
                    this.luB.e(this.luD, arl);
                }
            } else if (this.luB != null) {
                this.luB.N(i, "get face bio config failed");
            }
        } else if (this.luG != null && kVar.getType() == this.luG.getType()) {
            this.luI = (int) (System.currentTimeMillis() - this.luH);
            if (this.luA != null) {
                this.luA.g(i, i2, str, kVar);
            }
        }
    }
}
