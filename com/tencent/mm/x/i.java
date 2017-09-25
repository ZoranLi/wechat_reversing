package com.tencent.mm.x;

import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;
import junit.framework.Assert;

public final class i extends j {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS img_flag ( username VARCHAR(40) PRIMARY KEY , imgflag int , lastupdatetime int , reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )", "CREATE INDEX IF NOT EXISTS img_flag_small_url_index ON img_flag ( reserved2 )"};
    g hnH;
    final f<String, h> hrE = new f(800);

    public i(g gVar) {
        this.hnH = gVar;
    }

    public final h hs(String str) {
        h hVar = (h) this.hrE.get(str);
        if (hVar != null && hVar.getUsername().equals(str)) {
            return hVar;
        }
        Cursor a = this.hnH.a("select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.username=\"" + bg.my(str) + "\"", null, 2);
        if (a == null) {
            return null;
        }
        if (a.moveToFirst()) {
            hVar = new h();
            hVar.b(a);
        } else {
            hVar = null;
        }
        a.close();
        this.hrE.k(str, hVar);
        return hVar;
    }

    public final boolean a(h hVar) {
        boolean z;
        w.i("MicroMsg.ImgFlagStorage", "new smallImageUrl = %s, bigImageUrl = %s", hVar.Bt(), hVar.Bs());
        if (hs(hVar.getUsername()) == null) {
            this.hrE.k(hVar.getUsername(), hVar);
            if (hVar == null || hVar.getUsername() == null) {
                z = false;
            } else {
                z = true;
            }
            Assert.assertTrue(z);
            hVar.hrz = (int) (System.currentTimeMillis() / 1000);
            hVar.Bu();
            hVar.fRW = -1;
            z = ((int) this.hnH.insert("img_flag", "username", hVar.Br())) >= 0;
            if (z) {
                a(hVar.getUsername(), 2, hVar.getUsername());
            }
        } else {
            w.i("MicroMsg.ImgFlagStorage", "old, smallImageUrl = %s, bigImageUrl = %s", hs(hVar.getUsername()).Bt(), hs(hVar.getUsername()).Bs());
            this.hrE.remove(hVar.getUsername());
            z = (hVar == null || hVar.getUsername() == null) ? false : true;
            Assert.assertTrue(z);
            hVar.hrz = (int) (System.currentTimeMillis() / 1000);
            hVar.fRW |= 4;
            z = this.hnH.update("img_flag", hVar.Br(), "username=?", new String[]{new StringBuilder().append(hVar.getUsername()).toString()}) > 0;
            if (z) {
                a(hVar.getUsername(), 3, hVar.getUsername());
            }
        }
        return z;
    }

    public final boolean z(List<h> list) {
        if (list.size() == 0) {
            return false;
        }
        boolean z;
        long cs = this.hnH.cs(Thread.currentThread().getId());
        int i = 0;
        while (i < list.size()) {
            try {
                a((h) list.get(i));
                i++;
            } catch (Exception e) {
                w.e("MicroMsg.ImgFlagStorage", e.getMessage());
                z = false;
            }
        }
        z = true;
        this.hnH.aD(cs);
        return z;
    }

    public final void ht(String str) {
        if (!bg.mA(str)) {
            this.hrE.remove(str);
            this.hnH.delete("img_flag", "username=?", new String[]{str});
        }
    }
}
