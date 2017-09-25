package com.tencent.mm.plugin.appbrand.media;

import com.tencent.mm.c.b.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    private static b jaj = null;
    private static String jak = null;
    private static a jal = null;
    private static aj jam = null;

    public interface a {
        void hL(int i);
    }

    private static void KH() {
        if (jam != null) {
            jam.KH();
        }
        jam = null;
    }

    private static b Vj() {
        if (jaj == null) {
            jaj = new b(com.tencent.mm.compatible.b.b.a.gNk);
        }
        return jaj;
    }

    public static boolean a(String str, a aVar, int i) {
        hX(1);
        if (bg.mA(str)) {
            w.e("MicroMsg.AppBrand.AudioRecorder", "startRecord, path is null or nil");
            return false;
        } else if (Vj() == null) {
            return false;
        } else {
            b Vj = Vj();
            if (Vj.fzw == com.tencent.mm.compatible.b.b.a.gNj) {
                if (Vj.fzu != null) {
                    Vj.fzu.reset();
                }
            } else if (Vj.fzx != b.b.fzG) {
                Vj.release();
                Vj.pc();
            }
            Vj().pa();
            Vj().pb();
            Vj().oZ();
            Vj().setOutputFile(str);
            Vj().a(new com.tencent.mm.c.b.b.a() {
                public final void onError() {
                    w.e("MicroMsg.AppBrand.AudioRecorder", "onError");
                    a.hX(-1);
                }
            });
            try {
                Vj().prepare();
                Vj().start();
                jal = aVar;
                jak = str;
                long j = (long) i;
                KH();
                aj ajVar = new aj(new com.tencent.mm.sdk.platformtools.aj.a() {
                    public final boolean oQ() {
                        a.hX(1);
                        return false;
                    }
                }, false);
                jam = ajVar;
                ajVar.v(j, j);
                return true;
            } catch (Throwable e) {
                w.e("MicroMsg.AppBrand.AudioRecorder", "record prepare, exp = %s", new Object[]{bg.g(e)});
                return false;
            }
        }
    }

    public static void hX(int i) {
        if (!bg.mA(jak)) {
            Vj().a(null);
            Vj().pd();
            Vj().release();
            KH();
            jak = null;
            if (jal != null) {
                jal.hL(i);
            }
            jal = null;
        }
    }
}
