package com.tencent.mm.plugin.facedetect.model;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.bd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.pluginsdk.k.a.b.m;
import com.tencent.mm.protocal.c.gk;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ao;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class o {

    public static class a {
        public static byte[] g(byte[] bArr, String str) {
            int i;
            int i2;
            int i3 = 0;
            byte[] bytes = str.getBytes();
            byte[] bArr2 = new byte[256];
            for (i = 0; i < 256; i++) {
                bArr2[i] = (byte) i;
            }
            if (bytes == null || bytes.length == 0) {
                bArr2 = null;
            } else {
                i2 = 0;
                int i4 = 0;
                for (i = 0; i < 256; i++) {
                    i2 = (i2 + ((bytes[i4] & 255) + (bArr2[i] & 255))) & 255;
                    byte b = bArr2[i];
                    bArr2[i] = bArr2[i2];
                    bArr2[i2] = b;
                    i4 = (i4 + 1) % bytes.length;
                }
            }
            byte[] bArr3 = new byte[bArr.length];
            i = 0;
            i2 = 0;
            while (i3 < bArr.length) {
                i2 = (i2 + 1) & 255;
                i = (i + (bArr2[i2] & 255)) & 255;
                byte b2 = bArr2[i2];
                bArr2[i2] = bArr2[i];
                bArr2[i] = b2;
                int i5 = ((bArr2[i2] & 255) + (bArr2[i] & 255)) & 255;
                bArr3[i3] = (byte) (bArr2[i5] ^ bArr[i3]);
                i3++;
            }
            return bArr3;
        }
    }

    public static String a(FaceResult faceResult) {
        if (faceResult == null || faceResult.result != 0) {
            w.e("MicroMsg.FaceUtils", "alvinluo face result is null or result code not 0");
            return null;
        }
        try {
            String str = arS() + File.separator + "release_out.fd";
            gk gkVar = new gk();
            gkVar.tkj = b.aU(faceResult.sidedata);
            gkVar.tkk = b.aU(faceResult.data);
            byte[] toByteArray = gkVar.toByteArray();
            try {
                if (FileOp.km(str)) {
                    FileOp.k(str, toByteArray);
                    return str;
                }
                w.e("MicroMsg.FaceUtils", "hy: create file failed!");
                return str;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FaceUtils", e, "hy: err in save debug jpeg", new Object[0]);
                return str;
            }
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.FaceUtils", e2, "", new Object[0]);
            return null;
        }
    }

    public static Bitmap vH(String str) {
        try {
            if (bg.mA(str)) {
                w.i("MicroMsg.FaceUtils", "hy: username is null or nil. return");
                return null;
            }
            String str2 = com.tencent.mm.plugin.facedetect.model.a.a.lvE + aa.Pq(str);
            if (new File(str2).exists()) {
                byte[] c = FileOp.c(str2, 0, -1);
                if (c != null) {
                    c = a.g(c, vI(str));
                    if (c.length > 0) {
                        return com.tencent.mm.compatible.f.a.decodeByteArray(c, 0, c.length);
                    }
                    w.w("MicroMsg.FaceUtils", "hy: decrypt err. return null");
                    return null;
                }
                w.w("MicroMsg.FaceUtils", "hy: nothing in file");
                return null;
            }
            w.w("MicroMsg.FaceUtils", "hy: no last file. return");
            return null;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.FaceUtils", e, "hy: err in encrypt", new Object[0]);
            return null;
        }
    }

    public static boolean a(Bitmap bitmap, String str) {
        if (bitmap == null) {
            try {
                w.w("MicroMsg.FaceUtils", "hy: bm is null. abort");
                return false;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FaceUtils", e, "hy: err in encrypt", new Object[0]);
                return false;
            }
        } else if (bg.mA(str)) {
            w.i("MicroMsg.FaceUtils", "hy: username is null or nil. return");
            return false;
        } else {
            File file = new File(com.tencent.mm.plugin.facedetect.model.a.a.lvE);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = com.tencent.mm.plugin.facedetect.model.a.a.lvE + aa.Pq(str);
            File file2 = new File(str2);
            if (!file2.exists()) {
                w.i("MicroMsg.FaceUtils", "hy: last file already exists. del");
                file2.createNewFile();
            }
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            if (toByteArray != null) {
                byte[] g = a.g(toByteArray, vI(str));
                if (g.length <= 0) {
                    w.w("MicroMsg.FaceUtils", "hy: enc err. return null");
                    return false;
                }
                FileOp.k(str2, g);
                return true;
            }
            w.w("MicroMsg.FaceUtils", "hy: nothing in stream");
            return false;
        }
    }

    private static String vI(String str) {
        return Base64.encodeToString((str + str.hashCode()).getBytes(), 0);
    }

    public static boolean v(Activity activity) {
        boolean aT = com.tencent.mm.pluginsdk.i.a.aT(activity, "android.permission.CAMERA");
        boolean aT2 = com.tencent.mm.pluginsdk.i.a.aT(activity, "android.permission.RECORD_AUDIO");
        w.d("MicroMsg.FaceUtils", "summerper checkPermission checkCamera[%b], checkAudio[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(aT), Boolean.valueOf(aT2), bg.bJZ(), activity});
        ArrayList arrayList = new ArrayList();
        if (!aT) {
            arrayList.add("android.permission.CAMERA");
        }
        if (!aT2) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        if (aT && aT2) {
            return true;
        }
        w.i("MicroMsg.FaceUtils", "hy: above 23 and no permission. requesting...");
        android.support.v4.app.a.a(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), 23);
        return false;
    }

    public static void w(Activity activity) {
        activity.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    }

    public static boolean arR() {
        boolean z;
        String arT = arT();
        String arU = arU();
        if (bg.mA(arT) || bg.mA(arU)) {
            w.w("MicroMsg.FaceUtils", "hy: not valid model path. start ");
            z = false;
        } else {
            File file = new File(arT);
            File file2 = new File(arU);
            if (file.exists() || ml(0)) {
                z = true;
            } else {
                w.e("MicroMsg.FaceUtils", "hy: no detect model in storage and sdcard");
                z = false;
            }
            if (!(file2.exists() || ml(1))) {
                w.e("MicroMsg.FaceUtils", "hy: no alignment model in storage and sdcard");
                z = false;
            }
        }
        if (!z) {
            w.i("MicroMsg.FaceUtils", "hy: trigger start download model file");
            h.vd().a(new m(42), 0);
        }
        return z;
    }

    public static String arS() {
        String str = ab.getContext().getFilesDir().getParent() + File.separator + "face_detect";
        File file = new File(str);
        if (!file.exists()) {
            w.i("MicroMsg.FaceUtils", "hy: face dir not exist. mk dir");
            file.mkdirs();
        }
        return str;
    }

    public static String arT() {
        return arS() + File.separator + "detect_model.bin";
    }

    public static String arU() {
        return arS() + File.separator + "alignment_file_name.bin";
    }

    public static boolean ml(int i) {
        String str = "";
        switch (i) {
            case 0:
                str = ao.hlW.A("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_DETECT", "");
                break;
            case 1:
                str = ao.hlW.A("LAST_LOGIN_FACE_MODEL_SDCARD_PATH_ALIGNMENT", "");
                break;
        }
        if (bg.mA(str)) {
            w.w("MicroMsg.FaceUtils", "hy: no such path for type: %d", new Object[]{Integer.valueOf(i)});
            return false;
        } else if (new File(str).exists()) {
            File file = new File(mm(i));
            if (file.exists()) {
                file.delete();
            }
            e.p(str, mm(i));
            return true;
        } else {
            w.e("MicroMsg.FaceUtils", "originFile file not exist");
            return false;
        }
    }

    public static String mm(int i) {
        switch (i) {
            case 0:
                return arT();
            case 1:
                return arU();
            default:
                return "";
        }
    }

    public static Bitmap m(String str, Bitmap bitmap) {
        Bitmap bitmap2;
        long currentTimeMillis = System.currentTimeMillis();
        if (bitmap == null) {
            bitmap2 = null;
        } else {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            long currentTimeMillis2 = System.currentTimeMillis();
            bitmap2 = Bitmap.createScaledBitmap(bitmap, Math.round(((float) bitmap.getWidth()) * 0.1f), Math.round(((float) bitmap.getHeight()) * 0.1f), false);
            bitmap2 = bitmap2.copy(bitmap2.getConfig(), true);
            int width = bitmap2.getWidth();
            int height = bitmap2.getHeight();
            int[] iArr = new int[(width * height)];
            w.e("pix", width + " " + height + " " + iArr.length);
            bitmap2.getPixels(iArr, 0, width, 0, 0, width, height);
            int i12 = width - 1;
            int i13 = height - 1;
            int i14 = width * height;
            int[] iArr2 = new int[i14];
            int[] iArr3 = new int[i14];
            int[] iArr4 = new int[i14];
            int[] iArr5 = new int[Math.max(width, height)];
            int[] iArr6 = new int[246016];
            for (int i15 = 0; i15 < 246016; i15++) {
                iArr6[i15] = i15 / 961;
            }
            int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{61, 3});
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (i16 < height) {
                i = 0;
                if (b.bM(currentTimeMillis2)) {
                    bitmap2 = null;
                    break;
                }
                int[] iArr8;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                i9 = 0;
                for (i10 = -30; i10 <= 30; i10++) {
                    i11 = iArr[Math.min(i12, Math.max(i10, 0)) + i18];
                    iArr8 = iArr7[i10 + 30];
                    iArr8[0] = (16711680 & i11) >> 16;
                    iArr8[1] = (65280 & i11) >> 8;
                    iArr8[2] = i11 & 255;
                    i11 = 31 - Math.abs(i10);
                    i6 += iArr8[0] * i11;
                    i7 += iArr8[1] * i11;
                    i8 += i11 * iArr8[2];
                    if (i10 > 0) {
                        i += iArr8[0];
                        i9 += iArr8[1];
                        i2 += iArr8[2];
                    } else {
                        i3 += iArr8[0];
                        i4 += iArr8[1];
                        i5 += iArr8[2];
                    }
                }
                i11 = 30;
                if (b.bM(currentTimeMillis2)) {
                    bitmap2 = null;
                    break;
                }
                i10 = i5;
                i5 = i4;
                i4 = i3;
                i3 = i2;
                i2 = i9;
                i9 = i;
                for (i = 0; i < width; i++) {
                    iArr2[i18] = iArr6[i6];
                    iArr3[i18] = iArr6[i7];
                    iArr4[i18] = iArr6[i8];
                    i6 -= i4;
                    i7 -= i5;
                    i8 -= i10;
                    iArr8 = iArr7[((i11 - 30) + 61) % 61];
                    i4 -= iArr8[0];
                    i5 -= iArr8[1];
                    i10 -= iArr8[2];
                    if (i16 == 0) {
                        iArr5[i] = Math.min((i + 30) + 1, i12);
                    }
                    int i19 = iArr[iArr5[i] + i17];
                    iArr8[0] = (16711680 & i19) >> 16;
                    iArr8[1] = (65280 & i19) >> 8;
                    iArr8[2] = i19 & 255;
                    i9 += iArr8[0];
                    i2 += iArr8[1];
                    i3 += iArr8[2];
                    i6 += i9;
                    i7 += i2;
                    i8 += i3;
                    i11 = (i11 + 1) % 61;
                    iArr8 = iArr7[i11 % 61];
                    i4 += iArr8[0];
                    i5 += iArr8[1];
                    i10 += iArr8[2];
                    i9 -= iArr8[0];
                    i2 -= iArr8[1];
                    i3 -= iArr8[2];
                    i18++;
                }
                i16++;
                i17 += width;
            }
            for (i11 = 0; i11 < width; i11++) {
                i9 = 0;
                i2 = width * -30;
                if (b.bM(currentTimeMillis2)) {
                    bitmap2 = null;
                    break;
                }
                int[] iArr9;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i10 = 0;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                i = i2;
                i2 = 0;
                for (i18 = -30; i18 <= 30; i18++) {
                    i16 = Math.max(0, i) + i11;
                    iArr9 = iArr7[i18 + 30];
                    iArr9[0] = iArr2[i16];
                    iArr9[1] = iArr3[i16];
                    iArr9[2] = iArr4[i16];
                    i12 = 31 - Math.abs(i18);
                    i6 += iArr2[i16] * i12;
                    i7 += iArr3[i16] * i12;
                    i8 += iArr4[i16] * i12;
                    if (i18 > 0) {
                        i9 += iArr9[0];
                        i2 += iArr9[1];
                        i3 += iArr9[2];
                    } else {
                        i4 += iArr9[0];
                        i5 += iArr9[1];
                        i10 += iArr9[2];
                    }
                    if (i18 < i13) {
                        i += width;
                    }
                }
                if (b.bM(currentTimeMillis2)) {
                    bitmap2 = null;
                    break;
                }
                i16 = 30;
                i18 = i11;
                int i20 = i3;
                i3 = i4;
                i4 = i5;
                i5 = i10;
                i10 = i6;
                i6 = i7;
                i7 = i8;
                i = i9;
                i9 = i2;
                i2 = i20;
                for (i8 = 0; i8 < height; i8++) {
                    iArr[i18] = (((WebView.NIGHT_MODE_COLOR & iArr[i18]) | (iArr6[i10] << 16)) | (iArr6[i6] << 8)) | iArr6[i7];
                    i10 -= i3;
                    i6 -= i4;
                    i7 -= i5;
                    iArr9 = iArr7[((i16 - 30) + 61) % 61];
                    i3 -= iArr9[0];
                    i4 -= iArr9[1];
                    i5 -= iArr9[2];
                    if (i11 == 0) {
                        iArr5[i8] = Math.min(i8 + 31, i13) * width;
                    }
                    i12 = iArr5[i8] + i11;
                    iArr9[0] = iArr2[i12];
                    iArr9[1] = iArr3[i12];
                    iArr9[2] = iArr4[i12];
                    i += iArr9[0];
                    i9 += iArr9[1];
                    i2 += iArr9[2];
                    i10 += i;
                    i6 += i9;
                    i7 += i2;
                    i16 = (i16 + 1) % 61;
                    iArr9 = iArr7[i16];
                    i3 += iArr9[0];
                    i4 += iArr9[1];
                    i5 += iArr9[2];
                    i -= iArr9[0];
                    i9 -= iArr9[1];
                    i2 -= iArr9[2];
                    i18 += width;
                }
            }
            w.e("pix", width + " " + height + " " + i14);
            bitmap2.setPixels(iArr, 0, width, 0, 0, width, height);
        }
        w.i("MicroMsg.FaceUtils", "hy: blur using %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        Object obj = 1;
        if (bitmap2 == null) {
            w.w("MicroMsg.FaceUtils", "hy: null on blur. use default");
            obj = null;
            bitmap2 = vH(str);
            if (bitmap2 == null) {
                bitmap2 = d.yp(com.tencent.mm.plugin.facedetect.a.d.lss);
            }
        }
        if (obj != null) {
            final String str2 = str;
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    long NA = bg.NA();
                    o.a(bitmap2, str2);
                    w.i("MicroMsg.FaceUtils", "hy: saving blur bm using: %d ms", new Object[]{Long.valueOf(bg.aB(NA))});
                }
            }, "FaceUtils_SaveFile");
        }
        return bitmap2;
    }

    public static String vJ(String str) {
        return g.n((bg.NA() + ", " + str).getBytes());
    }
}
