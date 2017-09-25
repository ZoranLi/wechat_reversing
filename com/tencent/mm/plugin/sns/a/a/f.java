package com.tencent.mm.plugin.sns.a.a;

import android.util.Base64;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bdi;
import com.tencent.mm.protocal.c.bdj;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;

public final class f {
    public static void a(String str, d dVar) {
        m Gf = ae.beL().Gf(str);
        if (Gf != null) {
            bfc bhd = Gf.bhd();
            if (bhd != null) {
                o.a(bhd.qui, dVar);
                return;
            }
            w.v("SnsAdExtUtil", "timeLineObject null, snsId %s", new Object[]{str});
            return;
        }
        w.v("SnsAdExtUtil", "snsInfo null, snsId %s", new Object[]{str});
    }

    public static String a(long j, Object... objArr) {
        ae.beF();
        StringBuilder stringBuilder = new StringBuilder(i.k(objArr));
        a(j, stringBuilder);
        return stringBuilder.toString();
    }

    public static void a(long j, StringBuilder stringBuilder) {
        e dz = ae.beN().dz(j);
        if (dz != null) {
            bfc bhd = dz.bhd();
            if (bhd != null) {
                bdj kS = o.kS(bhd.qui);
                stringBuilder.append(",").append(kS == null ? -1 : kS.cGa);
                stringBuilder.append(",").append(o.a(kS));
                return;
            }
            w.v("SnsAdExtUtil", "l timeLineObject null, snsId %d", new Object[]{Long.valueOf(j)});
            return;
        }
        w.v("SnsAdExtUtil", "l snsInfo null, snsId %d", new Object[]{Long.valueOf(j)});
    }

    public static String Ex(String str) {
        if (bg.mA(str)) {
            return "";
        }
        byte[] decode = Base64.decode(str, 0);
        bdi com_tencent_mm_protocal_c_bdi = new bdi();
        try {
            com_tencent_mm_protocal_c_bdi.aD(decode);
            return o.a(com_tencent_mm_protocal_c_bdi.ueA);
        } catch (IOException e) {
            w.e("SnsAdExtUtil", "", new Object[]{e});
            return "";
        }
    }
}
