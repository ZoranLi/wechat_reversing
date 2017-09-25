package com.tencent.mm.x;

import android.database.Cursor;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public final class m {
    public static List<String> hrN = null;
    public static int hrO = 0;
    private static a hrP = new a(new b());

    static class b implements com.tencent.mm.sdk.platformtools.aj.a {
        Runnable hrR;

        b() {
        }

        public final boolean oQ() {
            int size = m.hrN.size();
            w.e("MicroMsg.RemoveAvatarTask", "RemoveOldAvatar left count:" + size);
            if (size <= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN || m.hrO >= e.CTRL_INDEX) {
                if (this.hrR != null) {
                    this.hrR.run();
                }
                m.hrO = 0;
                return false;
            }
            long cs = h.vI().gYg.cs(Thread.currentThread().getId());
            for (int i = size - 1; i >= size - 30; i--) {
                m.hrO++;
                String str = (String) m.hrN.get(i);
                m.hrN.remove(i);
                n.Bl();
                d.s(str, false);
                n.Bl();
                d.s(str, true);
                n.Bm().ht(str);
            }
            h.vI().gYg.aD(cs);
            return true;
        }
    }

    static class a extends aj {
        final b hrQ;

        public a(b bVar) {
            super(bVar, true);
            this.hrQ = bVar;
        }
    }

    public static void g(Runnable runnable) {
        if (h.vG().uV()) {
            i Bm = n.Bm();
            List arrayList = new ArrayList();
            Cursor a = Bm.hnH.a("select username from img_flag where username not in (select username from rcontact ) and username not like \"%@qqim\" and username not like \"%@bottle\";", null, 2);
            while (a.moveToNext()) {
                arrayList.add(a.getString(0));
            }
            a.close();
            hrN = arrayList;
            if (arrayList.size() > 0) {
                hrP.hrQ.hrR = runnable;
                hrP.v(10, 10);
            }
        }
    }

    public static void Bw() {
        hrO = 0;
        hrP.KH();
    }
}
