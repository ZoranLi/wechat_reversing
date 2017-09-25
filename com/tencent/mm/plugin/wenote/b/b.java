package com.tencent.mm.plugin.wenote.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.text.Spanned;
import com.tencent.mm.a.f;
import com.tencent.mm.a.g;
import com.tencent.mm.ay.a;
import com.tencent.mm.e.a.ij;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashMap;

public final class b implements e {
    public static HashMap<String, String> swO = new HashMap();
    public static HashMap<String, m> swP = new HashMap();
    public static b swQ = null;
    private static f<String, Integer> swR = new f(30);

    public static String ef(String str, String str2) {
        String str3;
        int i = 1280;
        if (bg.mA(str2)) {
            str3 = a.Mj() + "/" + (g.n((str + System.currentTimeMillis()).getBytes()) + "_HD");
        } else {
            str3 = str2;
        }
        if (com.tencent.mm.a.e.aO(str3)) {
            return str3;
        }
        Options Pe = d.Pe(str);
        if (Pe == null || Pe.outWidth <= 0 || Pe.outHeight <= 0) {
            w.e("MicroMsg.WNNoteUtil", "GetImageOptions Error");
            return null;
        }
        int i2 = Pe.outHeight;
        int i3 = Pe.outWidth;
        if (i3 > 1280) {
            i3 = 1280;
        }
        if (i2 <= 1280) {
            i = i2;
        }
        if (Pe.outHeight >= Pe.outWidth) {
            int i4 = i3;
            i3 = i;
            i = i4;
        }
        if (d.Pf(str) > 0) {
            i2 = Pe.outHeight;
            i3 = Pe.outWidth;
        } else {
            i2 = i3;
            i3 = i;
        }
        d.b(str, i2, i3, CompressFormat.JPEG, 80, str3);
        return str3;
    }

    public static String eg(String str, String str2) {
        String str3;
        int i = 800;
        if (bg.mA(str2)) {
            str3 = a.Mj() + "/" + (g.n((str + System.currentTimeMillis()).getBytes()) + "_TH");
        } else {
            str3 = str2;
        }
        if (com.tencent.mm.a.e.aO(str3)) {
            return str3;
        }
        Options Pe = d.Pe(str);
        if (Pe == null || Pe.outWidth <= 0 || Pe.outHeight <= 0) {
            w.e("MicroMsg.WNNoteUtil", "GetImageOptions Error");
            return null;
        }
        int i2 = Pe.outHeight;
        int i3 = Pe.outWidth;
        while (i3 * i2 > 2764800) {
            i3 >>= 1;
            i2 >>= 1;
        }
        if (i3 > 800) {
            i3 = 800;
        }
        if (i2 <= 800) {
            i = i2;
        }
        if (Pe.outHeight < Pe.outWidth) {
            i2 = i3;
            i3 = i;
        } else {
            i2 = i;
        }
        d.b(str, i2, i3, CompressFormat.JPEG, 52, str3);
        return str3;
    }

    public static String a(m mVar, boolean z) {
        if (!z) {
            return null;
        }
        com.tencent.mm.pluginsdk.location.b bVar = new com.tencent.mm.pluginsdk.location.b(-1, mVar.fOb, mVar.hGU, mVar.fOd, 1);
        com.tencent.mm.sdk.b.b ijVar = new ij();
        ijVar.fNX.fOb = mVar.fOb;
        ijVar.fNX.fOc = mVar.hGU;
        ijVar.fNX.fOd = mVar.fOd;
        ijVar.fNX.fNZ = 1;
        com.tencent.mm.sdk.b.a.urY.m(ijVar);
        String str = ijVar.fNY.path;
        String str2 = a.Mh() + "/" + g.n((bVar.toString()).getBytes()) + ".png";
        String substring = str.substring(str.lastIndexOf(95) + 1);
        if (com.tencent.mm.a.e.aO(str2)) {
            return str2;
        }
        if (com.tencent.mm.a.e.aO(str)) {
            new com.tencent.mm.plugin.wenote.model.b.a().bBl();
            com.tencent.mm.plugin.wenote.model.b.a.e(mVar.suL, mVar.suM, str, a.Mh() + "/", substring);
            return str2;
        }
        if (swQ == null) {
            swQ = new b();
        }
        ap.vd().a(648, swQ);
        com.tencent.mm.sdk.b.b ijVar2 = new ij();
        ijVar2.fNX.fOb = mVar.fOb;
        ijVar2.fNX.fOc = mVar.hGU;
        ijVar2.fNX.fOd = mVar.fOd;
        ijVar2.fNX.height = 450;
        ijVar2.fNX.width = 600;
        ijVar2.fNX.filename = str;
        ijVar2.fNX.fNZ = 2;
        com.tencent.mm.sdk.b.a.urY.m(ijVar2);
        swP.put(str, mVar);
        swO.put(str, str2);
        return str2;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 648) {
            try {
                Thread.sleep(100);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.WNNoteUtil", e, "", new Object[0]);
            }
            com.tencent.mm.sdk.b.b ijVar = new ij();
            ijVar.fNX.fGg = kVar;
            ijVar.fNX.fNZ = 3;
            com.tencent.mm.sdk.b.a.urY.m(ijVar);
            String str2 = ijVar.fNY.path;
            if (bg.mA(str2)) {
                w.e("MicroMsg.WNNoteUtil", "netSceneGetLocalPath is null");
            } else if (!swO.containsKey(str2)) {
            } else {
                if (i == 0 && i2 == 0) {
                    if (!com.tencent.mm.a.e.aO((String) swO.get(str2))) {
                        m mVar = (m) swP.get(str2);
                        new com.tencent.mm.plugin.wenote.model.b.a().bBl();
                        com.tencent.mm.plugin.wenote.model.b.a.e(mVar.suL, mVar.suM, str2, a.Mh() + "/", str2.substring(str2.lastIndexOf(95) + 1));
                    }
                    swO.remove(str2);
                    w.i("MicroMsg.WNNoteUtil", "get filepath:suc");
                    return;
                }
                w.e("MicroMsg.WNNoteUtil", "get filepath:err");
            }
        }
    }

    public static Bitmap Lv(String str) {
        Bitmap aI = c.aI(str, false);
        if (aI != null) {
            return aI;
        }
        if (bg.mA(null)) {
            return null;
        }
        return c.aI(null, false);
    }

    public static com.tencent.mm.plugin.wenote.model.a.a c(com.tencent.mm.plugin.wenote.model.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        com.tencent.mm.plugin.wenote.model.a.a eVar;
        switch (aVar.getType()) {
            case 1:
                eVar = new com.tencent.mm.plugin.wenote.model.a.e();
                ((com.tencent.mm.plugin.wenote.model.a.e) eVar).content = ((com.tencent.mm.plugin.wenote.model.a.e) aVar).content;
                break;
            case 2:
                eVar = new com.tencent.mm.plugin.wenote.model.a.c();
                ((com.tencent.mm.plugin.wenote.model.a.c) eVar).suK = ((com.tencent.mm.plugin.wenote.model.a.c) aVar).suK;
                break;
            case 3:
                eVar = new com.tencent.mm.plugin.wenote.model.a.d();
                com.tencent.mm.plugin.wenote.model.a.d dVar = (com.tencent.mm.plugin.wenote.model.a.d) eVar;
                com.tencent.mm.plugin.wenote.model.a.d dVar2 = (com.tencent.mm.plugin.wenote.model.a.d) aVar;
                dVar.lat = dVar2.lat;
                dVar.lng = dVar2.lng;
                dVar.suO = dVar2.suO;
                dVar.hCE = dVar2.hCE;
                dVar.ndv = dVar2.ndv;
                break;
            case 4:
                eVar = new h();
                h hVar = (h) eVar;
                h hVar2 = (h) aVar;
                hVar.suQ = hVar2.suQ;
                hVar.length = hVar2.length;
                hVar.suP = hVar2.suP;
                hVar.fQH = hVar2.fQH;
                hVar.fKx = hVar2.fKx;
                hVar.fKw = hVar2.fKw;
                hVar.suC = hVar2.suC;
                break;
            case 5:
                eVar = new com.tencent.mm.plugin.wenote.model.a.b();
                com.tencent.mm.plugin.wenote.model.a.b bVar = (com.tencent.mm.plugin.wenote.model.a.b) eVar;
                com.tencent.mm.plugin.wenote.model.a.b bVar2 = (com.tencent.mm.plugin.wenote.model.a.b) aVar;
                bVar.title = bVar2.title;
                bVar.content = bVar2.content;
                bVar.fQH = bVar2.fQH;
                bVar.suC = bVar2.suC;
                break;
            case 6:
                eVar = new com.tencent.mm.plugin.wenote.model.a.g();
                com.tencent.mm.plugin.wenote.model.a.g gVar = (com.tencent.mm.plugin.wenote.model.a.g) eVar;
                com.tencent.mm.plugin.wenote.model.a.g gVar2 = (com.tencent.mm.plugin.wenote.model.a.g) aVar;
                gVar.fKz = gVar2.fKz;
                gVar.duration = gVar2.duration;
                gVar.suC = gVar2.suC;
                break;
            default:
                eVar = null;
                break;
        }
        if (eVar == null) {
            return null;
        }
        ((com.tencent.mm.plugin.wenote.model.a.k) eVar).type = ((com.tencent.mm.plugin.wenote.model.a.k) aVar).type;
        ((com.tencent.mm.plugin.wenote.model.a.k) eVar).suJ = ((com.tencent.mm.plugin.wenote.model.a.k) aVar).suJ;
        ((com.tencent.mm.plugin.wenote.model.a.k) eVar).fQE = ((com.tencent.mm.plugin.wenote.model.a.k) aVar).fQE;
        return eVar;
    }

    public static String d(com.tencent.mm.plugin.wenote.model.a.a aVar) {
        if (aVar == null) {
            return "";
        }
        if (aVar.getType() == 2) {
            return ((com.tencent.mm.plugin.wenote.model.a.c) aVar).suK;
        }
        return ((com.tencent.mm.plugin.wenote.model.a.k) aVar).fQE;
    }

    public static String e(com.tencent.mm.plugin.wenote.model.a.a aVar) {
        if (aVar == null) {
            return "";
        }
        if (aVar.getType() == 2) {
            return ((com.tencent.mm.plugin.wenote.model.a.c) aVar).fQE;
        }
        if (aVar.getType() == 6) {
            return ((com.tencent.mm.plugin.wenote.model.a.g) aVar).fKz;
        }
        return "";
    }

    public static int Lw(String str) {
        if (bg.mA(str)) {
            return 0;
        }
        Spanned Lq = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Lq(str);
        if (Lq != null) {
            return Lx(Lq.toString());
        }
        return 0;
    }

    public static int Lx(String str) {
        int i = 0;
        if (bg.mA(str)) {
            return 0;
        }
        if (swR.aV(str)) {
            return ((Integer) swR.get(str)).intValue();
        }
        if (!bg.mA(str)) {
            int i2 = 0;
            while (i < str.length()) {
                i2 += i(str.charAt(i));
                i++;
            }
            i = i2;
        }
        swR.put(str, Integer.valueOf(i));
        return i;
    }

    public static int i(char c) {
        if (c <= '') {
            return 1;
        }
        return 2;
    }
}
