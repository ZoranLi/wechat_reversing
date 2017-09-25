package com.tencent.mm.plugin.facedetect.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.facedetect.b.r;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class FaceUploadVideoService extends Service implements e {

    private class a implements com.tencent.mm.modelcdntran.h.a {
        private String ivH = null;
        private long lvO = -1;
        final /* synthetic */ FaceUploadVideoService lyj;
        private String mFileName = null;

        public a(FaceUploadVideoService faceUploadVideoService, long j, String str, String str2) {
            this.lyj = faceUploadVideoService;
            this.lvO = j;
            this.ivH = str;
            this.mFileName = str2;
        }

        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            w.i("MicroMsg.FaceUploadVideoService", "hy: sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
            if (com_tencent_mm_modelcdntran_keep_SceneResult != null && com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == 0) {
                w.i("MicroMsg.FaceUploadVideoService", "hy: upload video done. now upload");
                FaceDetectReporter.d(this.lvO, 0, 0);
                h.vd().a(1197, this.lyj);
                h.vd().a(new r(this.mFileName, this.lvO, this.ivH, com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId, com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey), 0);
            } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                w.w("MicroMsg.FaceUploadVideoService", "hy: upload video cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                b.deleteFile(this.mFileName);
                FaceDetectReporter.d(this.lvO, 1, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
            } else if (i != 0) {
                w.w("MicroMsg.FaceUploadVideoService", "hy: upload video start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[]{str, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult});
                b.deleteFile(this.mFileName);
                FaceDetectReporter.d(this.lvO, 1, i);
            }
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] i(String str, byte[] bArr) {
            return new byte[0];
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        String stringExtra = intent.getStringExtra("key_video_file_name");
        long longExtra = intent.getLongExtra("k_bio_id", -1);
        String stringExtra2 = intent.getStringExtra("key_app_id");
        w.i("MicroMsg.FaceUploadVideoService", "hy: start uploading %s", new Object[]{stringExtra});
        if (bg.mA(stringExtra)) {
            w.w("MicroMsg.FaceUploadVideoService", "hy: null file name");
            return super.onStartCommand(intent, i, i2);
        } else if (!new File(stringExtra).exists()) {
            w.w("MicroMsg.FaceUploadVideoService", "hy: file not exist");
            return super.onStartCommand(intent, i, i2);
        } else if (longExtra == -1 && bg.mA(stringExtra2)) {
            w.w("MicroMsg.FaceUploadVideoService", "hy: bioId or app id null");
            b.deleteFile(stringExtra);
            return super.onStartCommand(intent, i, i2);
        } else {
            com.tencent.mm.modelcdntran.h hVar = new com.tencent.mm.modelcdntran.h();
            hVar.hze = new a(this, longExtra, stringExtra2, stringExtra);
            hVar.field_mediaId = o.vJ(stringExtra);
            hVar.field_fullpath = stringExtra;
            hVar.field_thumbpath = "";
            hVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FILE;
            hVar.field_talker = "";
            hVar.field_priority = com.tencent.mm.modelcdntran.b.hxL;
            hVar.field_needStorage = false;
            hVar.field_isStreamMedia = false;
            hVar.field_appType = 0;
            hVar.field_bzScene = 0;
            hVar.field_largesvideo = false;
            if (!g.El().b(hVar)) {
                w.e("MicroMsg.FaceUploadVideoService", "hy: video task info failed. clientid:%s", new Object[]{hVar.field_mediaId});
                b.deleteFile(stringExtra);
                FaceDetectReporter.d(longExtra, 1, 10086);
            }
            return super.onStartCommand(intent, i, i2);
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof r) {
            r rVar = (r) kVar;
            w.i("MicroMsg.FaceUploadVideoService", "hy: bind video errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            h.vd().b(1197, this);
            b.deleteFile(rVar.mFileName);
            stopSelf();
        }
    }
}
