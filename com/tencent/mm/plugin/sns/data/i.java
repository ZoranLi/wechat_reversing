package com.tencent.mm.plugin.sns.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.f;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.plugin.sns.h.c;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.v;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

public final class i {
    public static String jGa = "<TimelineObject>";
    public static String jGb = "</TimelineObject>";
    public static int pRf = Integer.MAX_VALUE;
    public static String pRg = "/";
    private static String pRh = "snsb";
    private static int pRi = -1;
    private static int pRj = -1;
    public static int pRk = 4194304;
    public static int pRl = 1048576;

    public static String an(int i, String str) {
        return i + "-" + str;
    }

    public static String bo(List<alh> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        String str = "";
        int i = 0;
        for (alh com_tencent_mm_protocal_c_alh : list) {
            if (str.length() > 0) {
                str = str + "-";
            }
            str = str + com_tencent_mm_protocal_c_alh.mQY;
            int i2 = i + 1;
            if (i2 >= 4) {
                return str;
            }
            i = i2;
        }
        return str;
    }

    private static String c(alh com_tencent_mm_protocal_c_alh) {
        if (!bg.mA(com_tencent_mm_protocal_c_alh.tPw)) {
            return com_tencent_mm_protocal_c_alh.tPw;
        }
        String str = "";
        try {
            return g.n(com_tencent_mm_protocal_c_alh.toByteArray());
        } catch (Exception e) {
            return str;
        }
    }

    public static String EB(String str) {
        return "snst_" + EM(str);
    }

    public static String EC(String str) {
        return "snsu_" + EM(str);
    }

    public static String ED(String str) {
        return "snsb_" + EM(str);
    }

    public static String d(alh com_tencent_mm_protocal_c_alh) {
        String str = "snsb_" + EM(com_tencent_mm_protocal_c_alh.mQY);
        if (com_tencent_mm_protocal_c_alh.tPu == 1) {
            return f.l(str + c(com_tencent_mm_protocal_c_alh), com_tencent_mm_protocal_c_alh.tPv);
        }
        return str;
    }

    public static String e(alh com_tencent_mm_protocal_c_alh) {
        String str = "snst_" + EM(com_tencent_mm_protocal_c_alh.mQY);
        if (com_tencent_mm_protocal_c_alh.tPu == 1) {
            return f.l(str + c(com_tencent_mm_protocal_c_alh), com_tencent_mm_protocal_c_alh.tPv);
        }
        return str;
    }

    public static String EE(String str) {
        return "snsu_" + EM(str);
    }

    public static String f(alh com_tencent_mm_protocal_c_alh) {
        String str = "snsu_" + EM(com_tencent_mm_protocal_c_alh.mQY);
        if (com_tencent_mm_protocal_c_alh.tPu == 1) {
            return f.l(str + c(com_tencent_mm_protocal_c_alh), com_tencent_mm_protocal_c_alh.tPv);
        }
        return str;
    }

    public static String g(alh com_tencent_mm_protocal_c_alh) {
        String str = "snsblurt_" + EM(com_tencent_mm_protocal_c_alh.mQY);
        if (com_tencent_mm_protocal_c_alh.tPu == 1) {
            return f.l(str + c(com_tencent_mm_protocal_c_alh), com_tencent_mm_protocal_c_alh.tPv);
        }
        return str;
    }

    public static String h(alh com_tencent_mm_protocal_c_alh) {
        String str = "snsblurs_" + EM(com_tencent_mm_protocal_c_alh.mQY);
        if (com_tencent_mm_protocal_c_alh.tPu == 1) {
            return f.l(str + c(com_tencent_mm_protocal_c_alh), com_tencent_mm_protocal_c_alh.tPv);
        }
        return str;
    }

    public static String i(alh com_tencent_mm_protocal_c_alh) {
        String str = "snstblur_src_" + EM(com_tencent_mm_protocal_c_alh.mQY);
        if (com_tencent_mm_protocal_c_alh.tPu == 1) {
            return f.l(str + c(com_tencent_mm_protocal_c_alh), com_tencent_mm_protocal_c_alh.tPv);
        }
        return str;
    }

    public static String j(alh com_tencent_mm_protocal_c_alh) {
        String str = "sight_" + EM(com_tencent_mm_protocal_c_alh.mQY);
        if (com_tencent_mm_protocal_c_alh.tPu == 1) {
            return f.l(str + c(com_tencent_mm_protocal_c_alh), com_tencent_mm_protocal_c_alh.tPv);
        }
        return str;
    }

    public static String k(alh com_tencent_mm_protocal_c_alh) {
        String str = "sightad_" + EM(com_tencent_mm_protocal_c_alh.mQY);
        if (com_tencent_mm_protocal_c_alh.tPu == 1) {
            return f.l(str, com_tencent_mm_protocal_c_alh.tPv);
        }
        return str;
    }

    public static String l(alh com_tencent_mm_protocal_c_alh) {
        String str = "snsb_" + EM(com_tencent_mm_protocal_c_alh.mQY);
        if (com_tencent_mm_protocal_c_alh.tPu == 1) {
            return f.l(str + c(com_tencent_mm_protocal_c_alh), com_tencent_mm_protocal_c_alh.tPv);
        }
        return str;
    }

    public static String m(alh com_tencent_mm_protocal_c_alh) {
        String str = "sns_tmpb_" + EM(com_tencent_mm_protocal_c_alh.mQY);
        if (com_tencent_mm_protocal_c_alh.tPu == 1) {
            return f.l(str + c(com_tencent_mm_protocal_c_alh), com_tencent_mm_protocal_c_alh.tPv);
        }
        return str;
    }

    public static String EF(String str) {
        return "sns_tmpb_" + EM(str);
    }

    public static String n(alh com_tencent_mm_protocal_c_alh) {
        String str = "sns_tmpt_" + EM(com_tencent_mm_protocal_c_alh.mQY);
        if (com_tencent_mm_protocal_c_alh.tPu == 1) {
            return f.l(str + c(com_tencent_mm_protocal_c_alh), com_tencent_mm_protocal_c_alh.tPv);
        }
        return str;
    }

    public static String EG(String str) {
        return "sns_tmpt_" + EM(str);
    }

    public static String o(alh com_tencent_mm_protocal_c_alh) {
        String str = "sns_tmpu_" + EM(com_tencent_mm_protocal_c_alh.mQY);
        if (com_tencent_mm_protocal_c_alh.tPu == 1) {
            return f.l(str + c(com_tencent_mm_protocal_c_alh), com_tencent_mm_protocal_c_alh.tPv);
        }
        return str;
    }

    public static String p(alh com_tencent_mm_protocal_c_alh) {
        String str = "sns_tmps_" + EM(com_tencent_mm_protocal_c_alh.mQY);
        if (com_tencent_mm_protocal_c_alh.tPu == 1) {
            return f.l(str + c(com_tencent_mm_protocal_c_alh), com_tencent_mm_protocal_c_alh.tPv);
        }
        return str;
    }

    public static String EH(String str) {
        return "sns_tmps_" + EM(str);
    }

    public static String q(alh com_tencent_mm_protocal_c_alh) {
        String str = "sns_tmpsad_" + EM(com_tencent_mm_protocal_c_alh.mQY);
        if (com_tencent_mm_protocal_c_alh.tPu == 1) {
            return f.l(str + c(com_tencent_mm_protocal_c_alh), com_tencent_mm_protocal_c_alh.tPv);
        }
        return str;
    }

    public static String ao(int i, String str) {
        return i + "-" + str;
    }

    public static void Q(String str, long j) {
        w.d("MicroMsg.SnsUtil", " name " + str + " allTime " + (System.currentTimeMillis() - j));
    }

    public static boolean k(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        return true;
    }

    public static boolean a(n nVar) {
        if (nVar == null || nVar.isRecycled()) {
            return false;
        }
        return true;
    }

    public static Bitmap r(String str, Bitmap bitmap) {
        int orientationInDegree;
        Throwable e;
        Throwable th;
        if (bitmap == null) {
            return null;
        }
        String str2;
        if (bg.mA(str)) {
            str2 = "";
        } else {
            int lastIndexOf = str.lastIndexOf(pRg);
            if (lastIndexOf > 0 && lastIndexOf + 1 < str.length()) {
                str2 = str.substring(lastIndexOf + 1);
                if (str2.startsWith(pRh) || str2.startsWith("sns_tmpb_")) {
                    str2 = str;
                } else if (str2.startsWith("snst_") || str2.startsWith("snsu_")) {
                    str2 = "";
                }
            }
            str2 = str;
        }
        if (bg.mA(str2)) {
            return bitmap;
        }
        Exif exif = new Exif();
        InputStream openRead;
        try {
            w.i("MicroMsg.SnsUtil", "[tomys] parsing jpg, path: %s, size: %s", new Object[]{str, Long.valueOf(FileOp.ki(str))});
            openRead = FileOp.openRead(str);
            try {
                exif.parseFromStream(openRead);
                orientationInDegree = exif.getOrientationInDegree();
                if (openRead != null) {
                    try {
                        openRead.close();
                    } catch (Throwable th2) {
                    }
                }
            } catch (IOException e2) {
                e = e2;
                try {
                    w.printErrStackTrace("MicroMsg.SnsUtil", e, "Failed parsing JPEG file: " + str2, new Object[0]);
                    if (openRead == null) {
                        orientationInDegree = 0;
                    } else {
                        try {
                            openRead.close();
                            orientationInDegree = 0;
                        } catch (Throwable th3) {
                            orientationInDegree = 0;
                        }
                    }
                    w.d("MicroMsg.SnsUtil", "exifPath : %s degree : %d", new Object[]{str2, Integer.valueOf(orientationInDegree)});
                    return d.b(bitmap, (float) orientationInDegree);
                } catch (Throwable th4) {
                    th = th4;
                    if (openRead != null) {
                        try {
                            openRead.close();
                        } catch (Throwable th5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable e3) {
            Throwable th6 = e3;
            openRead = null;
            e = th6;
            w.printErrStackTrace("MicroMsg.SnsUtil", e, "Failed parsing JPEG file: " + str2, new Object[0]);
            if (openRead == null) {
                openRead.close();
                orientationInDegree = 0;
            } else {
                orientationInDegree = 0;
            }
            w.d("MicroMsg.SnsUtil", "exifPath : %s degree : %d", new Object[]{str2, Integer.valueOf(orientationInDegree)});
            return d.b(bitmap, (float) orientationInDegree);
        } catch (Throwable th7) {
            th = th7;
            openRead = null;
            if (openRead != null) {
                openRead.close();
            }
            throw th;
        }
        w.d("MicroMsg.SnsUtil", "exifPath : %s degree : %d", new Object[]{str2, Integer.valueOf(orientationInDegree)});
        return d.b(bitmap, (float) orientationInDegree);
    }

    public static n EI(String str) {
        n nVar = null;
        try {
            w.i("MicroMsg.SnsUtil", "decodeFileToBlurThumbBitmap " + FileOp.aO(str));
            if (FileOp.aO(str)) {
                nVar = EK(str);
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SnsUtil", e, "snsdecode error", new Object[0]);
        }
        return nVar;
    }

    public static Bitmap EJ(String str) {
        InputStream openRead;
        Throwable th;
        try {
            InputStream inputStream;
            if (!FileOp.aO(str)) {
                return null;
            }
            Options options = new Options();
            d.b(options);
            options.inSampleSize = 1;
            while (options.inSampleSize <= 10) {
                try {
                    openRead = FileOp.openRead(str);
                    try {
                        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                        long NA = bg.NA();
                        Bitmap decodeStream = MMBitmapFactory.decodeStream(openRead, null, options, decodeResultLogger, 0, new int[0]);
                        long aB = bg.aB(NA);
                        if (options.inSampleSize > 1) {
                            w.w("MicroMsg.SnsUtil", "decode succ in " + options.inSampleSize);
                        }
                        if (decodeStream != null) {
                            decodeStream = r(str, decodeStream);
                            c.R(str, aB);
                        } else if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                            com.tencent.mm.plugin.report.service.g.oUh.A(12712, KVStatHelper.getKVStatString(str, 10, decodeResultLogger));
                        }
                        if (openRead == null) {
                            return decodeStream;
                        }
                        try {
                            openRead.close();
                            return decodeStream;
                        } catch (IOException e) {
                            return decodeStream;
                        }
                    } catch (OutOfMemoryError e2) {
                    }
                } catch (OutOfMemoryError e3) {
                    openRead = null;
                    try {
                        options.inSampleSize++;
                        if (openRead != null) {
                            try {
                                openRead.close();
                            } catch (IOException e4) {
                            }
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        inputStream = openRead;
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                }
            }
            return null;
            throw th;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        } catch (Throwable th5) {
            w.printErrStackTrace("MicroMsg.SnsUtil", th5, "snsdecode error", new Object[0]);
            return null;
        }
    }

    public static n EK(String str) {
        try {
            if (!FileOp.aO(str)) {
                return null;
            }
            Options options = new Options();
            d.b(options);
            options.inSampleSize = 1;
            while (options.inSampleSize <= 10) {
                try {
                    DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                    long NA = bg.NA();
                    n c = a.c(str, options, decodeResultLogger);
                    NA = bg.aB(NA);
                    if (c != null) {
                        c.R(str, NA);
                    } else if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                        com.tencent.mm.plugin.report.service.g.oUh.A(12712, KVStatHelper.getKVStatString(str, 10, decodeResultLogger));
                    }
                    return c;
                } catch (OutOfMemoryError e) {
                    options.inSampleSize++;
                }
            }
            return null;
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.SnsUtil", e2, "snsdecode error", new Object[0]);
            return null;
        }
    }

    public static String EL(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        while (stringBuffer.length() < 25) {
            stringBuffer.insert(0, "0");
        }
        return stringBuffer.toString();
    }

    public static String df(long j) {
        return new BigInteger(Long.toBinaryString(j), 2).toString();
    }

    public static String dg(long j) {
        if (j == 0) {
            return "";
        }
        return EL(new BigInteger(Long.toBinaryString(j), 2).toString());
    }

    private static String EM(String str) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        int i = 0;
        while (i < length && str.charAt(i) == '0') {
            i++;
        }
        return str.substring(i);
    }

    private static Rect C(Bitmap bitmap) {
        int width = bitmap.getWidth();
        return new Rect(width / 4, 0, (int) (((double) (width * 3)) / 4.0d), bitmap.getHeight());
    }

    private static Rect D(Bitmap bitmap) {
        return new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    public static Bitmap h(List<n> list, int i) {
        for (n a : list) {
            if (!a(a)) {
                return null;
            }
        }
        if (i <= 0) {
            return null;
        }
        Rect rect;
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Config.ARGB_8888);
        int size = list.size();
        List linkedList = new LinkedList();
        int i2 = i >> 1;
        int i3 = i2 + 2;
        i2 -= 2;
        Rect rect2;
        if (size == 2) {
            rect = new Rect(0, 0, i2, i);
            rect2 = new Rect(i3, 0, i, i);
            linkedList.add(rect);
            linkedList.add(rect2);
        } else if (size == 3) {
            rect = new Rect(0, 0, i2, i);
            r7 = new Rect(i3, 0, i, i2);
            rect2 = new Rect(i3, i3, i, i);
            linkedList.add(rect);
            linkedList.add(r7);
            linkedList.add(rect2);
        } else if (size >= 4) {
            rect = new Rect(0, 0, i2, i2);
            r7 = new Rect(0, i3, i2, i);
            Rect rect3 = new Rect(i3, 0, i, i2);
            rect2 = new Rect(i3, i3, i, i);
            linkedList.add(rect);
            linkedList.add(r7);
            linkedList.add(rect3);
            linkedList.add(rect2);
        }
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        i2 = 0;
        for (i3 = 0; i3 < list.size() && i2 < 4; i3++) {
            Rect D;
            Bitmap wx = ((n) list.get(i3)).wx();
            rect = (Rect) linkedList.get(i3);
            switch (list.size()) {
                case 1:
                    D = D(wx);
                    break;
                case 2:
                    D = C(wx);
                    break;
                case 3:
                    if (i3 != 0) {
                        D = D(wx);
                        break;
                    }
                    D = C(wx);
                    break;
                default:
                    D = D(wx);
                    break;
            }
            canvas.drawBitmap(wx, D, rect, null);
            i2++;
        }
        canvas.save(31);
        canvas.restore();
        return createBitmap;
    }

    public static boolean EN(String str) {
        return str.startsWith(e.hgs);
    }

    public static boolean EO(String str) {
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            if (i2 >= i * 2 || i >= i2 * 2) {
                return true;
            }
            return false;
        } catch (Exception e) {
            w.e("MicroMsg.SnsUtil", "get error setImageExtInfo");
            return false;
        }
    }

    public static boolean EP(String str) {
        int i = pRk;
        try {
            Options Pe = d.Pe(str);
            int i2 = Pe.outWidth;
            int i3 = Pe.outHeight;
            if ((i3 > 0 || i2 > 0) && i3 < i2 * 2 && i2 < i3 * 2 && i3 * i2 > i) {
                return true;
            }
            return false;
        } catch (Exception e) {
            w.e("MicroMsg.SnsUtil", "get error setImageExtInfo");
            return false;
        }
    }

    public static boolean sQ(int i) {
        ab.getContext().getSharedPreferences(ab.bIX(), 0).edit().putInt("sns_control_flag", i).commit();
        return true;
    }

    public static int bdA() {
        return ab.getContext().getSharedPreferences(ab.bIX(), 0).getInt("sns_control_flag", 0);
    }

    public static boolean sR(int i) {
        ab.getContext().getSharedPreferences(ab.bIX(), 0).edit().putInt("sns_respone_count", i).commit();
        return true;
    }

    public static int bdB() {
        return ab.getContext().getSharedPreferences(ab.bIX(), 0).getInt("sns_respone_count", 20);
    }

    public static String w(CharSequence charSequence) {
        int i = 0;
        if (charSequence == null) {
            return "";
        }
        SpannableString spannableString = new SpannableString(charSequence);
        m[] mVarArr = (m[]) spannableString.getSpans(0, spannableString.length(), m.class);
        w.d("MicroMsg.SnsUtil", "removeClickSpanInString, clickSpans.length:%d", new Object[]{Integer.valueOf(mVarArr.length)});
        while (i < mVarArr.length) {
            spannableString.removeSpan(mVarArr[i]);
            i++;
        }
        return spannableString.toString();
    }

    public static void b(View view, Context context) {
        if (view != null && v.dI(context) > 1.0f) {
            float dI = v.dI(context);
            LayoutParams layoutParams = view.getLayoutParams();
            int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(context, 60);
            if (layoutParams.width >= 0 && layoutParams.height >= 0) {
                int i = (int) (((float) layoutParams.width) * dI);
                int i2 = (int) (dI * ((float) layoutParams.height));
                if (i > fromDPToPix) {
                    i = fromDPToPix;
                }
                layoutParams.width = i;
                if (i2 <= fromDPToPix) {
                    fromDPToPix = i2;
                }
                layoutParams.height = fromDPToPix;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    public static int bdC() {
        Context context = ab.getContext();
        if (am.is2G(context)) {
            return 1;
        }
        if (am.is3G(context)) {
            return 2;
        }
        if (am.is4G(context)) {
            return 3;
        }
        if (am.isWifi(context)) {
            return 4;
        }
        return 0;
    }

    public static boolean f(com.tencent.mm.plugin.sns.storage.m mVar) {
        if (mVar.field_type == 3 || mVar.field_type == 4 || mVar.field_type == 5 || mVar.field_type == 6 || mVar.field_type == 9 || mVar.field_type == 10 || mVar.field_type == 11 || mVar.field_type == 12 || mVar.field_type == 13 || mVar.field_type == 14 || mVar.field_type == 17 || mVar.field_type == 22 || mVar.field_type == 23) {
            return true;
        }
        return false;
    }

    public static long Eq() {
        return ((long) ((int) (((long) TimeZone.getDefault().getRawOffset()) / 60000))) / 60;
    }

    public static SpannableString a(String str, Context context, TextView textView) {
        if (bg.mA(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("<img src=\"original_label.png\"/>  ");
        stringBuilder.append(str);
        return new SpannableString(h.c(context, stringBuilder.toString(), (float) ((int) textView.getTextSize())));
    }

    public static String g(com.tencent.mm.plugin.sns.storage.m mVar) {
        return mVar == null ? "0" : df(mVar.field_snsId);
    }

    public static long EQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        w.i("MicroMsg.SnsUtil", "seq %s to snsId %d ", new Object[]{str, Long.valueOf(new BigInteger(str).longValue())});
        return new BigInteger(str).longValue();
    }

    public static int ER(String str) {
        int i = 0;
        try {
            if (!bg.mA(str)) {
                w.i("MicroMsg.SnsUtil", "getSnsSightVideoDurationInSeconds, path: %s", new Object[]{str});
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                i = bg.ex((long) bg.getInt(mediaMetadataRetriever.extractMetadata(9), 0));
            }
        } catch (Throwable th) {
            w.e("MicroMsg.SnsUtil", "getSnsSightVideoDurationInSeconds error: %s", new Object[]{str});
        }
        return i;
    }
}
