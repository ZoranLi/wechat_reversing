package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.c;
import com.tencent.mm.plugin.sns.model.a.b.a;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class d extends e {
    public d(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final boolean bfx() {
        Object obj;
        long NA;
        long j = -1;
        String l = i.l(this.fVV);
        String str = this.pYD.getPath() + this.pYD.bfv();
        Options options = new Options();
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeFile(str, options, null, 0, new int[0]);
        String toLowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
        long ki = FileOp.ki(str);
        if (this.pZa || toLowerCase.contains("webp")) {
            obj = null;
        } else if (this.pZb || toLowerCase.contains("vcodec")) {
            r16 = 1;
        } else {
            r16 = 2;
        }
        long NA2;
        long aB;
        switch (obj) {
            case null:
                g.oUh.a(22, 64, 1, true);
                FileOp.deleteFile(this.pYD.getPath() + l);
                NA2 = bg.NA();
                r.d(this.pYD.getPath(), this.pYD.getPath() + this.pYD.bfv(), l, false);
                aB = bg.aB(NA2);
                FileOp.deleteFile(this.pYD.getPath() + this.pYD.bfv());
                j = bg.aB(NA2);
                c.a(this.pYD.getPath() + l, this.pYD.url, 0, options.outMimeType, options.outWidth, options.outHeight, -1, ki, aB);
                break;
            case 1:
                w.i("MicroMsg.SnsDownloadImage", "found vcodec:%s, reencoded.", new Object[]{this.pYD.getPath() + this.pYD.bfv()});
                FileOp.deleteFile(this.pYD.getPath() + l);
                NA2 = bg.NA();
                r.d(this.pYD.getPath(), this.pYD.getPath() + this.pYD.bfv(), l, false);
                aB = bg.aB(NA2);
                FileOp.deleteFile(this.pYD.getPath() + this.pYD.bfv());
                j = bg.aB(NA2);
                c.a(this.pYD.getPath() + l, this.pYD.url, 0, options.outMimeType, options.outWidth, options.outHeight, -1, ki, aB);
                break;
            case 2:
                aB = -1;
                if (i.EP(this.pYD.getPath() + this.pYD.bfv())) {
                    w.w("MicroMsg.SnsDownloadImage", "the " + this.pYD.mediaId + " is too max ! " + this.pYD.url);
                    FileOp.deleteFile(this.pYD.getPath() + l);
                    NA = bg.NA();
                    r.T(this.pYD.getPath(), this.pYD.getPath() + this.pYD.bfv(), l);
                    aB = bg.aB(NA);
                    FileOp.deleteFile(this.pYD.getPath() + this.pYD.bfv());
                    j = bg.aB(NA);
                } else {
                    FileOp.h(this.pYD.getPath(), this.pYD.bfv(), l);
                    j = 0;
                }
                int i = -1;
                if (toLowerCase.contains("jpg") || toLowerCase.contains("jpeg")) {
                    i = MMNativeJpeg.queryQuality(this.pYD.getPath() + l);
                    if (i == 0) {
                        i = -1;
                    }
                }
                c.a(this.pYD.getPath() + l, this.pYD.url, 0, options.outMimeType, options.outWidth, options.outHeight, i, ki, aB);
                break;
        }
        w.i("MicroMsg.SnsDownloadImage", "donwload big pic isWebp " + (obj == null));
        NA = FileOp.ki(this.pYD.getPath() + l);
        g.oUh.i(11696, new Object[]{Integer.valueOf(3), Long.valueOf(j), Long.valueOf(NA), Thread.currentThread().getName(), ae.beZ(), e.hgs});
        Object obj2 = this.pYD.pYz != 3 ? 1 : null;
        if (!(this.pYD.pQM == null || this.pYD.pQM.pQS == 4 || this.pYD.pQM.pQS == 5)) {
            obj2 = null;
        }
        if (obj2 != null) {
            toLowerCase = i.e(this.fVV);
            if (FileOp.aO(this.pYD.getPath() + toLowerCase)) {
                FileOp.deleteFile(this.pYD.getPath() + toLowerCase);
            }
            long NA3 = bg.NA();
            r.a(this.pYD.getPath(), l, toLowerCase, (float) ae.beT());
            NA3 = bg.aB(NA3);
            FileOp.ki(this.pYD.getPath() + toLowerCase);
            g.oUh.i(11696, new Object[]{Integer.valueOf(3), Long.valueOf(NA3), Long.valueOf(NA), Thread.currentThread().getName(), ae.beZ(), e.hgs});
            toLowerCase = i.f(this.fVV);
            if (!FileOp.aO(this.pYD.getPath() + toLowerCase)) {
                r.b(this.pYD.getPath(), l, toLowerCase, (float) ae.beS());
            }
        }
        return true;
    }

    protected final int bfy() {
        return 1;
    }
}
