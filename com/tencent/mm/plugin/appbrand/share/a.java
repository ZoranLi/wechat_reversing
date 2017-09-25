package com.tencent.mm.plugin.appbrand.share;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import com.tencent.mm.modelappbrand.a.b.e;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.w;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class a implements e {
    private int RQ;
    private int aar;

    public a(int i, int i2) {
        this.aar = i;
        this.RQ = i2;
    }

    public final Bitmap e(InputStream inputStream) {
        try {
            if (!inputStream.markSupported()) {
                if (inputStream instanceof FileInputStream) {
                    inputStream = new i((FileInputStream) inputStream);
                } else if (!inputStream.markSupported()) {
                    inputStream = new BufferedInputStream(inputStream);
                }
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            inputStream.mark(8388608);
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            inputStream.reset();
            if (decodeStream != null) {
                decodeStream.recycle();
            }
            if (options.outHeight <= 0 || options.outWidth <= 0) {
                w.e("MicroMsg.AppBrand.BitmapDecoderImpl", "decode[%s] error, outHeight[%d] outWidth[%d]", new Object[]{inputStream, Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth)});
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
                return null;
            }
            options.inSampleSize = (int) ((((double) options.outWidth) * 1.0d) / ((double) this.aar));
            if (options.inSampleSize <= 1) {
                options.inSampleSize = 1;
            }
            while (((options.outHeight * options.outWidth) / options.inSampleSize) / options.inSampleSize > 2764800) {
                options.inSampleSize++;
            }
            options.inJustDecodeBounds = false;
            options.inMutable = true;
            Bitmap decodeRegion = BitmapRegionDecoder.newInstance(inputStream, false).decodeRegion(new Rect(0, 0, options.outWidth, (int) (((((float) options.outWidth) * 1.0f) * ((float) this.RQ)) / ((float) this.aar))), options);
            if (inputStream == null) {
                return decodeRegion;
            }
            try {
                inputStream.close();
                return decodeRegion;
            } catch (IOException e2) {
                return decodeRegion;
            }
        } catch (IOException e3) {
            w.e("MicroMsg.AppBrand.BitmapDecoderImpl", "%s", new Object[]{e3});
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
            return null;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
        }
    }
}
