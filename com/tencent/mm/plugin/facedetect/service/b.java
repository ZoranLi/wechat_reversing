package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class b extends a {
    public String ivH = "";
    public long lvO = -1;

    public final void w(Intent intent) {
        this.lvO = intent.getLongExtra("k_bio_id", -1);
        this.ivH = intent.getStringExtra("key_app_id");
        w.i("MicroMsg.FaceDetectServiceControllerMp", "hy: got bioid: %d, appid: %s", new Object[]{Long.valueOf(this.lvO), this.ivH});
        w.i("MicroMsg.FaceDetectServiceControllerMp", "hy: requesting release and send video");
        if (a.asA().lAH && (a.asA().lAD == a.a.lBj || a.asA().lAD == a.a.lBk || a.asA().lAD == a.a.lBl)) {
            final long NA = bg.NA();
            a.asA().a(new com.tencent.mm.plugin.facedetect.e.a.b(this) {
                final /* synthetic */ b lyi;

                public final void vK(String str) {
                    w.i("MicroMsg.FaceDetectServiceControllerMp", "hy: video release done. using: %d ms. file path: %s", new Object[]{Long.valueOf(bg.aB(NA)), str});
                    if (!bg.mA(str)) {
                        Intent intent = new Intent(ab.getContext(), FaceUploadVideoService.class);
                        intent.putExtra("key_video_file_name", str);
                        intent.putExtra("k_bio_id", this.lyi.lvO);
                        intent.putExtra("key_app_id", this.lyi.ivH);
                        ab.getContext().startService(intent);
                    }
                }
            });
            return;
        }
        w.i("MicroMsg.FaceDetectServiceControllerMp", "hy: not recording video");
    }
}
