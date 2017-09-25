package com.tencent.mm.c.b;

import android.os.Build;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class g {
    public static final String fAI = (e.hgu + "test.wav");
    public static final String fAJ = (e.hgu + "test.pcm");

    public static class a {
        public byte[] buf;
        public int fAK = 0;
        public boolean fAL = false;

        public a(byte[] bArr, int i) {
            this.buf = bArr;
            this.fAK = i;
            this.fAL = false;
        }

        public a(byte[] bArr, int i, boolean z) {
            this.buf = bArr;
            this.fAK = i;
            this.fAL = z;
        }
    }

    public static class b {
        private static boolean fAM;
        private static boolean fAN;

        static {
            fAM = false;
            fAN = false;
            int rl = l.rl();
            w.i("MicroMsg.RecorderUtil", "abi: %s, abi2: %s, cpuFlag: %d", Build.CPU_ABI, Build.CPU_ABI2, Integer.valueOf(rl));
            if (!bg.mA(Build.CPU_ABI) && !Build.CPU_ABI.contains("armeabi") && !bg.mA(Build.CPU_ABI2) && !Build.CPU_ABI2.contains("armeabi")) {
                w.i("MicroMsg.RecorderUtil", "don't contains armeabi");
                k.b("wechatvoicesilk_v5", g.class.getClassLoader());
                fAM = true;
                fAN = false;
            } else if ((rl & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                try {
                    k.b("wechatvoicesilk_v7a", g.class.getClassLoader());
                    fAM = true;
                    fAN = true;
                } catch (UnsatisfiedLinkError e) {
                    w.e("MicroMsg.RecorderUtil", "load library failed!");
                    fAM = false;
                    fAN = false;
                }
            } else if ((rl & 512) != 0) {
                k.b("wechatvoicesilk", g.class.getClassLoader());
                fAM = true;
                fAN = true;
            } else {
                k.b("wechatvoicesilk_v5", g.class.getClassLoader());
                fAM = true;
                fAN = false;
            }
            w.i("MicroMsg.RecorderUtil", "finish load silk so, canUseSilkDecode: %b, canUseSilkEncode: %b", Boolean.valueOf(fAM), Boolean.valueOf(fAN));
        }

        public static boolean pk() {
            return fAN;
        }
    }

    public static int j(String str, int i) {
        try {
            i = bg.getInt(((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue(str), i);
        } catch (Exception e) {
            w.e("MicroMsg.RecorderUtil", "getIntValFromDynamicConfig parseInt failed, key: " + str);
        } catch (Error e2) {
            w.e("MicroMsg.RecorderUtil", "error on parseInt failed, key: " + str);
        }
        return i;
    }
}
