package com.tencent.mm.modelbiz;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class l {

    public static final class a {
        List<a> hwa = new ArrayList();
        Map<String, Integer> hwb = new HashMap();
        Map<String, WeakReference<Bitmap>> hwc = new HashMap();
        ar hwd = null;

        public interface a {
            void in(String str);
        }

        public final void a(a aVar) {
            this.hwa.add(aVar);
        }

        public final void b(a aVar) {
            this.hwa.remove(aVar);
        }

        public final void DB() {
            this.hwa.clear();
        }

        public static String im(String str) {
            if (h.vG().uV()) {
                return ((n) h.h(n.class)).xo() + "/brand_" + g.n(str.getBytes());
            }
            return "";
        }

        final void e(String str, Bitmap bitmap) {
            Bitmap bitmap2 = this.hwc.containsKey(str) ? (Bitmap) ((WeakReference) this.hwc.get(str)).get() : null;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                try {
                    bitmap2 = Bitmap.createScaledBitmap(bitmap, FileUtils.S_IWUSR, FileUtils.S_IWUSR, true);
                    bitmap2 = d.a(bitmap2, true, (float) (bitmap2.getWidth() >> 1));
                } catch (OutOfMemoryError e) {
                    bitmap2 = bitmap;
                }
                this.hwc.remove(str);
                this.hwc.put(str, new WeakReference(bitmap2));
            }
            if (bitmap2 != bitmap) {
                w.i("MicroMsg.BrandLogic", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
            }
        }
    }

    private static class b implements com.tencent.mm.sdk.platformtools.ar.a {
        public byte[] hqV = null;
        private final String hwe;
        private final String url;

        public b(String str, String str2) {
            this.hwe = str;
            this.url = str2;
        }

        public final boolean Bn() {
            if (bg.mA(this.hwe) || bg.mA(this.url)) {
                return false;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                InputStream k = com.tencent.mm.network.b.k(this.url, 3000, Downloads.MIN_RETYR_AFTER);
                if (k == null) {
                    return false;
                }
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int read = k.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                k.close();
                this.hqV = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                if (bg.bm(this.hqV)) {
                    w.e("MicroMsg.BrandLogic", "imgBuff null brand:" + this.hwe);
                    return false;
                }
                if (h.vG().uV()) {
                    com.tencent.mm.u.ag.a.hlT.aH(this.hqV.length, 0);
                    a DP = w.DP();
                    String str = this.hwe;
                    String str2 = this.url;
                    byte[] bArr2 = this.hqV;
                    try {
                        str2 = str + str2;
                        Bitmap bd = d.bd(bArr2);
                        d.a(bd, 100, CompressFormat.PNG, a.im(str2), false);
                        DP.e(str, bd);
                        w.i("MicroMsg.BrandLogic", "update brand icon for  " + str + ", done");
                        DP.hwb.remove(str);
                    } catch (Throwable e) {
                        w.e("MicroMsg.BrandLogic", "exception:%s", bg.g(e));
                    }
                }
                return true;
            } catch (Throwable e2) {
                w.e("MicroMsg.BrandLogic", "exception:%s", bg.g(e2));
                w.e("MicroMsg.BrandLogic", "get url:" + this.url + " failed.");
                this.hqV = null;
                return false;
            }
        }

        public final boolean Bo() {
            a DP = w.DP();
            String str = this.hwe;
            int i = 0;
            while (i < DP.hwa.size()) {
                try {
                    ((a) DP.hwa.get(i)).in(str);
                    i++;
                } catch (Throwable e) {
                    w.e("MicroMsg.BrandLogic", "exception:%s", bg.g(e));
                }
            }
            return false;
        }
    }

    public static Bitmap ik(String str) {
        boolean z = false;
        if (bg.mA(str) || !h.vI().isSDCardAvailable() || !h.vG().uV()) {
            return null;
        }
        Bitmap bitmap;
        a DP = w.DP();
        String format = String.format("%s%f", new Object[]{str, Float.valueOf(DownloadHelper.SAVE_FATOR)});
        if (DP.hwc.containsKey(format)) {
            bitmap = (Bitmap) ((WeakReference) DP.hwc.get(format)).get();
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.c(str, DownloadHelper.SAVE_FATOR);
                DP.hwc.remove(format);
                DP.hwc.put(format, new WeakReference(bitmap));
            }
        } else {
            bitmap = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.c(str, DownloadHelper.SAVE_FATOR);
            DP.hwc.put(format, new WeakReference(bitmap));
        }
        String str2 = "MicroMsg.BrandLogic";
        format = "get verify user icon = %s, is null ? %s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (bitmap == null) {
            z = true;
        }
        objArr[1] = String.valueOf(z);
        w.i(str2, format, objArr);
        return bitmap;
    }

    public static Bitmap b(final String str, String str2, int i) {
        if (!h.vI().isSDCardAvailable()) {
            return fz(i);
        }
        if (str == null || !h.vG().uV()) {
            return null;
        }
        Bitmap bitmap;
        if (str2 == null) {
            str2 = V(str, null);
            if (str2 == null) {
                return null;
            }
        }
        a DP = w.DP();
        WeakReference weakReference;
        if (DP.hwc.containsKey(str)) {
            bitmap = (Bitmap) ((WeakReference) DP.hwc.get(str)).get();
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = d.Pg(a.im(str + V(str, str2)));
                if (bitmap == null) {
                    w.i("MicroMsg.BrandLogic", "not found brand icon local");
                } else {
                    DP.e(str, bitmap);
                }
            }
            weakReference = (WeakReference) DP.hwc.get(str);
            if (weakReference != null) {
                bitmap = (Bitmap) weakReference.get();
                if (bitmap == null) {
                    return bitmap;
                }
                af.v(new Runnable() {
                    public final void run() {
                        a DP = w.DP();
                        String str = str;
                        String str2 = str2;
                        if (bg.mA(str) || bg.mA(str2)) {
                            w.e("MicroMsg.BrandLogic", "pushing for brand " + str + ", url " + str2);
                        } else if (bg.az((long) bg.f((Integer) DP.hwb.get(str))) < 300) {
                            w.i("MicroMsg.BrandLogic", "downloading interval less than 5 mins for " + str);
                        } else {
                            DP.hwb.put(str, Integer.valueOf((int) bg.Ny()));
                            if (DP.hwd == null || DP.hwd.bJx()) {
                                DP.hwd = new ar(1, "brand-logic");
                            }
                            DP.hwd.c(new b(str, l.V(str, str2)));
                        }
                    }
                });
                return null;
            }
        }
        bitmap = d.Pg(a.im(str + V(str, str2)));
        if (bitmap == null) {
            w.i("MicroMsg.BrandLogic", "not found brand icon local");
        } else {
            DP.e(str, bitmap);
            weakReference = (WeakReference) DP.hwc.get(str);
            if (weakReference != null) {
                bitmap = (Bitmap) weakReference.get();
                if (bitmap == null) {
                    return bitmap;
                }
                af.v(/* anonymous class already generated */);
                return null;
            }
        }
        bitmap = null;
        if (bitmap == null) {
            return bitmap;
        }
        af.v(/* anonymous class already generated */);
        return null;
    }

    public static Bitmap il(String str) {
        if (!h.vI().isSDCardAvailable()) {
            return fz(0);
        }
        if (str == null || !h.vG().uV()) {
            return null;
        }
        Bitmap bitmap;
        a DP = w.DP();
        if (DP.hwc.containsKey(str)) {
            bitmap = (Bitmap) ((WeakReference) DP.hwc.get(str)).get();
            if (bitmap == null || bitmap.isRecycled()) {
                return null;
            }
        }
        bitmap = null;
        return bitmap;
    }

    private static Bitmap fz(int i) {
        if (i <= 0) {
            return null;
        }
        Options options = new Options();
        d.b(options);
        Bitmap decodeStream = BitmapFactory.decodeStream(ab.getContext().getResources().openRawResource(i), null, options);
        if (decodeStream != null) {
            return d.a(decodeStream, false, (float) (decodeStream.getWidth() >> 1));
        }
        return decodeStream;
    }

    public static String V(String str, String str2) {
        if (str == null || !h.vG().uV()) {
            return null;
        }
        BizInfo hO = w.DH().hO(str);
        if (hO.field_brandIconURL != null) {
            return hO.field_brandIconURL;
        }
        return str2;
    }
}
