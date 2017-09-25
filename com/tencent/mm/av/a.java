package com.tencent.mm.av;

import android.database.Cursor;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.ArrayList;

public final class a {
    public static ArrayList<String> kT(String str) {
        ArrayList<String> arrayList = new ArrayList();
        h[] F = l.Kz().F(str, 10);
        if (F != null) {
            for (h hVar : F) {
                arrayList.add(hVar.field_sayhicontent);
            }
        }
        w.d("MicroMsg.ExposeDataLogic", "get lbs sayhi msg content");
        return arrayList;
    }

    public static ArrayList<String> kU(String str) {
        ArrayList<String> arrayList = new ArrayList();
        j[] G = l.KA().G(str, 10);
        if (G != null) {
            for (j jVar : G) {
                arrayList.add(jVar.field_sayhicontent);
            }
        }
        w.d("MicroMsg.ExposeDataLogic", "get shake sayhi msg content");
        return arrayList;
    }

    public static ArrayList<String> kV(String str) {
        ArrayList<String> arrayList = new ArrayList();
        ap.yY();
        Cursor Ar = c.wT().Ar(str);
        if (!(Ar == null || Ar.getCount() == 0)) {
            if (Ar.moveToFirst()) {
                int i = 0;
                while (!Ar.isAfterLast()) {
                    ce auVar = new au();
                    auVar.b(Ar);
                    Ar.moveToNext();
                    if (auVar.bMk()) {
                        arrayList.add(auVar.field_content);
                    } else {
                        arrayList.add("");
                    }
                    i++;
                    if (i == 10) {
                        break;
                    }
                }
            }
            Ar.close();
        }
        return arrayList;
    }

    public static ArrayList<String> t(int i, String str) {
        ArrayList<String> arrayList = new ArrayList();
        f[] E = l.Kx().E(str, 10);
        if (E != null) {
            for (f fVar : E) {
                if (fVar.field_type == 1) {
                    arrayList.add(bg.mz(d.RI(fVar.field_msgContent).content));
                }
            }
        }
        w.d("MicroMsg.ExposeDataLogic", "getFMessageContent,scene:%d", new Object[]{Integer.valueOf(i)});
        return arrayList;
    }

    public static ArrayList<au> b(long[] jArr) {
        ArrayList<au> arrayList = new ArrayList();
        if (jArr != null) {
            for (long cA : jArr) {
                ap.yY();
                arrayList.add(c.wT().cA(cA));
            }
        }
        return arrayList;
    }
}
