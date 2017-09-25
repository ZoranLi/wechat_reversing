package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.w;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public abstract class l {
    private static j hgJ = new j();
    private static m hgK = new m();
    private static int hgL = -1;

    public abstract Bitmap a(String str, Options options, DecodeResultLogger decodeResultLogger);

    public abstract Bitmap a(String str, Rect rect, Options options, DecodeResultLogger decodeResultLogger);

    public abstract void f(Bitmap bitmap);

    public static l wu() {
        if (hgL == -1) {
            if (wv()) {
                hgL = 1;
            } else {
                hgL = 2;
            }
        }
        switch (hgL) {
            case 1:
                return hgJ;
            case 2:
                return hgK;
            default:
                return hgK;
        }
    }

    public static boolean wv() {
        boolean eo = d.eo(19);
        boolean bKc = bg.bKc();
        w.i("MicroMsg.PlatformBitmapFactory", "canUseInBitmapFactory, isVersionMatch: %b, isART: %b, result: %s", Boolean.valueOf(eo), Boolean.valueOf(bKc), Boolean.valueOf(eo));
        return eo;
    }

    protected static void d(InputStream inputStream) {
        if (!inputStream.markSupported()) {
            if (inputStream instanceof FileInputStream) {
                inputStream = new i((FileInputStream) inputStream);
            } else {
                inputStream = new BufferedInputStream(inputStream, 65536);
            }
        }
        try {
            inputStream.reset();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.PlatformBitmapFactory", e, "reset stream error: %s", e.getMessage());
        }
    }
}
