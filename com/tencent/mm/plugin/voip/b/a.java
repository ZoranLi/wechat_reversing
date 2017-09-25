package com.tencent.mm.plugin.voip.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.protocal.c.bdc;
import com.tencent.mm.protocal.c.bjx;
import com.tencent.mm.protocal.c.bjy;
import com.tencent.mm.protocal.c.blq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.BufferedOutputStream;
import java.net.InetAddress;

public final class a {
    public static boolean rob = false;
    static BufferedOutputStream roc = null;

    public static int getNetType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 2;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 4;
            }
            if (activeNetworkInfo.getType() != 0) {
                return 2;
            }
            if (activeNetworkInfo.getSubtype() == 1) {
                return 1;
            }
            if (activeNetworkInfo.getSubtype() == 2) {
                return 1;
            }
            if (activeNetworkInfo.getSubtype() == 13) {
                return 5;
            }
            if ((activeNetworkInfo.getSubtype() < 3 || activeNetworkInfo.getSubtype() >= 13) && activeNetworkInfo.getSubtype() <= 13) {
                return 1;
            }
            return 3;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Voip", e, "", new Object[0]);
            return 2;
        }
    }

    public static boolean bre() {
        if (rob || getNetType(ab.getContext()) == 1) {
            return true;
        }
        return false;
    }

    private static void HG(String str) {
        if (roc != null) {
            try {
                roc.write(str.getBytes());
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Voip", e, "", new Object[0]);
            }
        }
    }

    public static void brf() {
        if (roc != null) {
            try {
                roc.flush();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Voip", e, "", new Object[0]);
            }
        }
    }

    public static int aM(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (i < 4) {
            i2 |= (bArr[i] & 255) << (i * 8);
            i++;
        }
        return i2;
    }

    public static byte[] vc(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) (i >>> (i2 * 8));
        }
        return bArr;
    }

    public static void dI(String str, String str2) {
        w.e(str, "[" + Thread.currentThread().getId() + "]" + str2);
        HG(str + ":" + str2 + " \n");
    }

    public static void dJ(String str, String str2) {
        w.i(str, "[" + Thread.currentThread().getId() + "]" + str2);
        HG(str + ":" + str2 + " \n");
    }

    public static void dK(String str, String str2) {
        w.d(str, "[" + Thread.currentThread().getId() + "]" + str2);
        HG(str + ":" + str2 + " \n");
    }

    public static void dL(String str, String str2) {
        w.w(str, "[" + Thread.currentThread().getId() + "]" + str2);
        HG(str + ":" + str2 + " \n");
    }

    public static void a(byte[] bArr, String str, int i) {
        if (bg.bm(bArr)) {
            bArr = new byte[0];
        }
        String str2 = new String(bArr);
        if (i == 4) {
            w.e(str, str2);
        } else if (i == 2) {
            w.i(str, str2);
        } else {
            w.d(str, str2);
        }
        if (str.equals("MicroMsg.v2Core")) {
            HG(str + ":" + str2);
        } else {
            HG(str + ":" + str2 + " \n");
        }
    }

    public static void vd(int i) {
        try {
            Thread.sleep((long) i);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Voip", e, "", new Object[0]);
        }
    }

    public static int[] a(bjy com_tencent_mm_protocal_c_bjy) {
        int i;
        w.d("MicroMsg.Voip", "convertSvrAddr: voipAddr.Cnt " + com_tencent_mm_protocal_c_bjy.ujy);
        if (3 >= com_tencent_mm_protocal_c_bjy.ujy) {
            i = com_tencent_mm_protocal_c_bjy.ujy;
        } else {
            i = 3;
        }
        w.d("MicroMsg.Voip", "convertSvrAddr: addrCnt " + i);
        int[] iArr = new int[(i * 2)];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2 * 2] = ((bjx) com_tencent_mm_protocal_c_bjy.ujz.get(i2)).ufq;
            iArr[(i2 * 2) + 1] = ((bjx) com_tencent_mm_protocal_c_bjy.ujz.get(i2)).tVV;
            w.d("MicroMsg.Voip", "convertSvrAddr: ip " + ve(((bjx) com_tencent_mm_protocal_c_bjy.ujz.get(i2)).ufq) + " Port: " + ((bjx) com_tencent_mm_protocal_c_bjy.ujz.get(i2)).tVV);
        }
        return iArr;
    }

    public static int[] a(blq com_tencent_mm_protocal_c_blq) {
        int i;
        w.d("MicroMsg.Voip", "convertSpeedTestPara: testID= " + com_tencent_mm_protocal_c_blq.ulr + " SvrListCnt= " + com_tencent_mm_protocal_c_blq.ulw);
        if (3 >= com_tencent_mm_protocal_c_blq.ulw) {
            i = com_tencent_mm_protocal_c_blq.ulw;
        } else {
            i = 3;
        }
        int[] iArr = new int[(i * 6)];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2 * 6] = ((bdc) com_tencent_mm_protocal_c_blq.ulx.get(i2)).udT.ufq;
            iArr[(i2 * 6) + 1] = ((bdc) com_tencent_mm_protocal_c_blq.ulx.get(i2)).udT.tVV;
            iArr[(i2 * 6) + 2] = ((bdc) com_tencent_mm_protocal_c_blq.ulx.get(i2)).udS;
            iArr[(i2 * 6) + 3] = ((bdc) com_tencent_mm_protocal_c_blq.ulx.get(i2)).ueo;
            iArr[(i2 * 6) + 4] = ((bdc) com_tencent_mm_protocal_c_blq.ulx.get(i2)).uep;
            iArr[(i2 * 6) + 5] = ((bdc) com_tencent_mm_protocal_c_blq.ulx.get(i2)).ueq;
            w.d("MicroMsg.Voip", "convertSpeedTestPara: ip " + ve(((bdc) com_tencent_mm_protocal_c_blq.ulx.get(i2)).udT.ufq) + " Port: " + ((bdc) com_tencent_mm_protocal_c_blq.ulx.get(i2)).udT.tVV + " TestCnt= " + ((bdc) com_tencent_mm_protocal_c_blq.ulx.get(i2)).udS + " TestGap= " + ((bdc) com_tencent_mm_protocal_c_blq.ulx.get(i2)).ueo + " Timeout= " + ((bdc) com_tencent_mm_protocal_c_blq.ulx.get(i2)).uep + " PktSize= " + ((bdc) com_tencent_mm_protocal_c_blq.ulx.get(i2)).ueq);
        }
        return iArr;
    }

    private static String ve(int i) {
        try {
            return InetAddress.getByAddress(new byte[]{(byte) ((i >>> 24) & 255), (byte) ((i >>> 16) & 255), (byte) ((i >>> 8) & 255), (byte) (i & 255)}).getHostAddress();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Voip", e, "", new Object[0]);
            return null;
        }
    }
}
