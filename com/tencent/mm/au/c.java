package com.tencent.mm.au;

import com.tencent.mm.c.b.g;
import com.tencent.mm.c.c.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ar.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class c implements a {
    public BlockingQueue<g.a> hTP = new ArrayBlockingQueue(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    public String mFileName = null;

    public final boolean Bn() {
        w.d("MicroMsg.SpeexEncoderWorker", "doEncode");
        d dVar = new d();
        String JJ = b.JJ();
        try {
            w.i("MicroMsg.SpeexEncoderWorker", "path " + JJ);
            File file = new File(JJ);
            if (!file.exists()) {
                file.mkdir();
            }
            dVar.bz(JJ + this.mFileName + ".temp");
            while (this.hTP.size() > 0) {
                g.a aVar = (g.a) this.hTP.poll();
                if (aVar.buf != null && aVar.fAK > 0) {
                    dVar.a(aVar, 0, false);
                }
            }
            dVar.ps();
            try {
                new File(JJ + this.mFileName + ".temp").renameTo(new File(JJ + this.mFileName + ".spx"));
            } catch (Throwable e) {
                w.e("MicroMsg.SpeexEncoderWorker", "exception:%s", bg.g(e));
            }
            e.JR().start();
        } catch (Exception e2) {
            w.e("MicroMsg.SpeexEncoderWorker", "filename open failed, ", e2);
        }
        return true;
    }

    public final boolean Bo() {
        return false;
    }
}
