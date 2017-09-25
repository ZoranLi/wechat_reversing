package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.plugin.licence.model.CardInfo;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Arrays;

public final class l extends b {
    private final Object lock = new Object();
    public boolean[] pdE = new boolean[4];
    private boolean pdF = false;
    private boolean pdH = false;
    private final int pel;
    private Bitmap pem;
    public Bitmap pen;

    public l(a aVar, int i) {
        super(aVar);
        this.pel = i;
    }

    public final boolean a(byte[] bArr, Point point, Rect rect) {
        boolean z;
        w.d("MicroMsg.ScanLicenceDecoder", "smoothie, decode, resolution = %s, coverage = %s, data.length = %d", new Object[]{point, rect, Integer.valueOf(bArr.length)});
        synchronized (this.lock) {
            if (!(this.pem == null || this.pem.isRecycled())) {
                w.d("MicroMsg.ScanLicenceDecoder", "[smoothie] recycle last bitmap");
                this.pem.recycle();
            }
            w.d("MicroMsg.ScanLicenceDecoder", "resolution:%s, coverage:%s", new Object[]{point, rect});
            if (this.pdF) {
                w.d("MicroMsg.ScanLicenceDecoder", "recognize id succeed, no need more handle");
                z = false;
            } else {
                int i;
                for (i = 0; i < 4; i++) {
                    this.pdE[i] = false;
                }
                float min = Math.min(Math.min(((float) point.x) / ((float) rect.width()), ((float) point.y) / ((float) rect.height())), 1.0f);
                int width = rect.width();
                int height = rect.height();
                w.d("MicroMsg.ScanLicenceDecoder", "rate:%f, cropWidth:%d, cropHeight:%d", new Object[]{Float.valueOf(min), Integer.valueOf(width), Integer.valueOf(height)});
                if (!this.pdH) {
                    w.d("MicroMsg.ScanLicenceDecoder", "init param:%d, %d, %d, %d", new Object[]{Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(rect.width()), Integer.valueOf(rect.height())});
                    try {
                        LibCardRecog.recognizeCardInit(width, height, this.pel);
                        this.pdH = true;
                    } catch (Exception e) {
                        w.e("MicroMsg.ScanLicenceDecoder", "lib init failed, exp = %s", new Object[]{e});
                        this.pdH = false;
                        aZi();
                        z = false;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                CardInfo cardInfo = new CardInfo(width, height);
                int i2 = rect.top;
                try {
                    i = LibCardRecog.recognizeCardProcess(bArr, point.y, point.x, rect.left, i2, height, width, cardInfo, this.pdE);
                    w.d("MicroMsg.ScanLicenceDecoder", "[smoothie] recognizeProcess, ret = %d", new Object[]{Integer.valueOf(i)});
                    w.d("MicroMsg.ScanLicenceDecoder", "focusedEngineProcess cost: " + (System.currentTimeMillis() - currentTimeMillis));
                    w.d("MicroMsg.ScanLicenceDecoder", "mRecogRectEdge: %s", new Object[]{Arrays.toString(this.pdE)});
                    if (i == 0) {
                        z = false;
                    } else if (1 != i) {
                        for (i = 0; i < 4; i++) {
                            this.pdE[i] = false;
                        }
                        w.d("MicroMsg.ScanLicenceDecoder", "image is not enough clear");
                        z = false;
                    } else {
                        for (i = 0; i < 4; i++) {
                            this.pdE[i] = true;
                        }
                        this.pem = BitmapFactory.decodeByteArray(cardInfo.bitmapData, 0, cardInfo.bitmapLen);
                        this.pen = this.pem.copy(Config.ARGB_8888, true);
                        this.pdF = true;
                        z = true;
                    }
                } catch (Exception e2) {
                    w.e("MicroMsg.ScanLicenceDecoder", "recognizeProcess failed, exp = %s", new Object[]{e2});
                    this.pdF = false;
                    z = false;
                }
            }
        }
        return z;
    }

    public final void aKx() {
        if (!(this.pem == null || this.pem.isRecycled())) {
            this.pem.recycle();
        }
        aZi();
    }

    public final void aYV() {
        this.pdF = false;
    }

    private static void aZi() {
        w.i("MicroMsg.ScanLicenceDecoder", "lib release");
        try {
            LibCardRecog.recognizeCardRelease();
        } catch (Exception e) {
            w.e("MicroMsg.ScanLicenceDecoder", "lib release, exp = %s", new Object[]{e});
        }
    }
}
