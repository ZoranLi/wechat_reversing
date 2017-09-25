package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.c;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.model.a.b.a;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class g extends e {
    private boolean hlN = false;

    public g(a aVar, a aVar2) {
        super(aVar, aVar2);
        com.tencent.mm.plugin.report.service.g.oUh.a(150, 10, 1, true);
    }

    public final boolean bfx() {
        if (this.pYD.pQM != null) {
            int queryQuality;
            String str;
            String e = i.e(this.fVV);
            this.hlN = r.Gw(this.pYD.getPath() + this.pYD.bfv());
            if (this.pZa) {
                this.hlN = true;
            }
            if (this.hlN) {
                com.tencent.mm.plugin.report.service.g.oUh.a(22, 64, 1, true);
            }
            String str2 = this.pYD.getPath() + this.pYD.bfv();
            Options options = new Options();
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeFile(str2, options, null, 0, new int[0]);
            String toLowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
            if (options.outMimeType == null || bg.mA(options.outMimeType)) {
                com.tencent.mm.plugin.report.service.g.oUh.a(150, 35, 1, true);
            }
            if (toLowerCase.contains("jpg") || toLowerCase.contains("jpeg")) {
                queryQuality = MMNativeJpeg.queryQuality(str2);
                if (queryQuality == 0) {
                    queryQuality = -1;
                }
            } else {
                queryQuality = -1;
            }
            long ki = FileOp.ki(str2);
            if (ki <= 0) {
                com.tencent.mm.plugin.report.service.g.oUh.a(150, 23, 1, true);
            }
            long NA = bg.NA();
            String i = i.i(this.fVV);
            FileOp.p(this.pYD.getPath() + this.pYD.bfv(), this.pYD.getPath() + i);
            w.v("MicroMsg.SnsDownloadThumb", "file src" + FileOp.aO(this.pYD.getPath() + i));
            long NA2 = bg.NA();
            if (!r.a(this.pYD.getPath(), this.pYD.bfv(), e, (float) ae.beT())) {
                com.tencent.mm.plugin.report.service.g.oUh.a(150, 27, 1, true);
            }
            NA2 = bg.aB(NA2);
            FileOp.deleteFile(this.pYD.getPath() + this.pYD.bfv());
            NA = bg.aB(NA);
            if (!FileOp.aO(this.pYD.getPath() + e)) {
                com.tencent.mm.plugin.report.service.g.oUh.a(150, 31, 1, true);
            }
            com.tencent.mm.plugin.report.service.g.oUh.i(11696, new Object[]{Integer.valueOf(3), Long.valueOf(NA), Integer.valueOf(this.pYX), Thread.currentThread().getName(), ae.beZ(), e.hgs});
            if (this.pYD.pQM.pQS == 0 || this.pYD.pQM.pQS == 5) {
                i = i.f(this.fVV);
                r.b(this.pYD.getPath(), e, i, (float) ae.beS());
                str = i;
            } else {
                str = e;
            }
            c.a(this.pYD.getPath() + str, this.pYD.url, 1, options.outMimeType, options.outWidth, options.outHeight, queryQuality, ki, NA2);
            this.pYC = i.EK(this.pYD.getPath() + str);
            boolean a = i.a(this.pYC);
            w.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + a + " isWebp: " + this.hlN + " srcImgFileSize: " + ki);
            if (!a) {
                com.tencent.mm.plugin.report.service.g.oUh.a(150, 65, 1, true);
                if (this.pZc) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(150, 50, 1, true);
                } else {
                    com.tencent.mm.plugin.report.service.g.oUh.a(150, 51, 1, true);
                }
                if (this.pZb) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(150, 54, 1, true);
                }
                if (this.pZa) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(150, 57, 1, true);
                }
            }
            if (this.hlN && !a) {
                com.tencent.mm.plugin.report.service.g.oUh.a(22, 65, 1, true);
            }
            if (this.pZc && a) {
                b.mN(com.tencent.mm.plugin.appbrand.jsapi.w.CTRL_INDEX);
            }
        }
        return true;
    }

    protected final int bfy() {
        return 3;
    }
}
