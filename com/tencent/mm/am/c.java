package com.tencent.mm.am;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.tencent.mm.i.g;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public final class c {
    public static boolean HN() {
        if (!b.HK() || b.HJ()) {
            return false;
        }
        b.qQ();
        return true;
    }

    public static boolean HO() {
        if (!b.HJ()) {
            return false;
        }
        b.qP();
        return true;
    }

    public static boolean HP() {
        if (!b.HK()) {
            return false;
        }
        b.HH();
        return true;
    }

    public static boolean jS(String str) {
        anf HL = b.HL();
        if (HL == null || !HL.tRN.equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean HQ() {
        return HS() || HR();
    }

    public static boolean HR() {
        w.i("MicroMsg.Music.MusicHelperUtils", "isShakeMusicGlobalUser: %d", new Object[]{Integer.valueOf(g.sV().getInt("ShakeMusicGlobalSwitch", 0))});
        if (g.sV().getInt("ShakeMusicGlobalSwitch", 0) == 0) {
            return false;
        }
        return true;
    }

    public static boolean HS() {
        if (TimeZone.getDefault().getRawOffset() != TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
            return false;
        }
        TelephonyManager telephonyManager = (TelephonyManager) ab.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!(bg.mA(networkCountryIso) || networkCountryIso.equalsIgnoreCase("cn"))) {
                return false;
            }
        }
        return true;
    }

    private static float[] I(List<float[]> list) {
        float[] fArr;
        if (list.size() > 4) {
            float[] fArr2 = null;
            int i = 0;
            while (i < list.size()) {
                if (((float[]) list.get(i))[2] < Float.MAX_VALUE) {
                    fArr = (float[]) list.get(i);
                } else {
                    fArr = fArr2;
                }
                i++;
                fArr2 = fArr;
            }
            if (((double) fArr2[2]) <= 0.15d) {
                return fArr2;
            }
            if (((double) fArr2[1]) > 0.5d) {
                fArr2[1] = fArr2[1] - 0.1f;
            }
            fArr2[2] = fArr2[2] - 0.1f;
            return fArr2;
        }
        fArr = (float[]) list.get(0);
        fArr[2] = 0.15f;
        return fArr;
    }

    public static int[] m(Bitmap bitmap) {
        int i;
        int i2;
        int[] iArr = new int[16];
        Bitmap.createScaledBitmap(bitmap, 4, 4, false).getPixels(iArr, 0, 4, 0, 0, 4, 4);
        float[][] fArr = new float[16][];
        for (int i3 = 0; i3 < 16; i3++) {
            float[] fArr2 = new float[3];
            Color.colorToHSV(iArr[i3], fArr2);
            fArr[i3] = fArr2;
        }
        int[] iArr2 = new int[8];
        SparseArray sparseArray = new SparseArray();
        for (i = 0; i < 16; i++) {
            i2 = 1;
            while (i2 <= 7) {
                if (fArr[i][0] < 360.0f * (((float) i2) / 7.0f)) {
                    iArr2[i2] = iArr2[i2] + 1;
                    List list = (List) sparseArray.get(i2);
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(fArr[i]);
                    sparseArray.put(i2, list);
                } else {
                    i2++;
                }
            }
        }
        i2 = -1;
        boolean z = false;
        for (i = 1; i <= 7; i++) {
            if (iArr2[i] > z) {
                z = iArr2[i];
                i2 = i;
            }
        }
        float[] I = I((List) sparseArray.get(i2, new ArrayList()));
        float[] fArr3 = new float[3];
        if (((double) I[2]) <= 0.15d) {
            fArr3[0] = I[0];
            fArr3[1] = I[1];
            fArr3[2] = I[2] + 0.7f;
        } else {
            fArr3[0] = I[0];
            fArr3[1] = I[1];
            if (((double) I[2]) + 0.5d >= 1.0d) {
                fArr3[2] = I[2] - 0.5f;
            } else {
                fArr3[2] = I[2] + 0.5f;
            }
        }
        if (fArr3[1] > 0.5f) {
            fArr3[1] = fArr3[1] - 0.1f;
        }
        return new int[]{Color.HSVToColor(I), Color.HSVToColor(fArr3)};
    }
}
