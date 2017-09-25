package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.w;
import junit.framework.Assert;

public final class bc extends i<bb> implements g {
    public static final String[] gUx = new String[]{i.a(bb.gTP, "Stranger")};
    private e gUz;
    private final k<a, bb> uKz = new k<a, bb>(this) {
        final /* synthetic */ bc uKM;

        {
            this.uKM = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((a) obj).a((bb) obj2);
        }
    };

    public final /* synthetic */ boolean a(c cVar) {
        bb bbVar = (bb) cVar;
        Assert.assertTrue("stranger NULL !", bbVar != null);
        w.d("MicroMsg.StrangerStorage", "replace : encryptUsername=%s, conRemark=%s", bbVar.field_encryptUsername, bbVar.field_conRemark);
        if (this.gUz.replace("Stranger", "", bbVar.pv()) > 0) {
            int i = 1;
        } else {
            boolean z = false;
        }
        if (i == 0) {
            return false;
        }
        b(bbVar);
        return true;
    }

    private void b(bb bbVar) {
        if (this.uKz.by(bbVar)) {
            this.uKz.doNotify();
        }
    }

    public final void a(a aVar) {
        this.uKz.a(aVar, null);
    }

    public final void b(a aVar) {
        this.uKz.remove(aVar);
    }

    public bc(e eVar) {
        super(eVar, bb.gTP, "Stranger", null);
        this.gUz = eVar;
    }

    public final bb AI(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        bb bbVar = new bb();
        Cursor a = this.gUz.a("Stranger", null, "encryptUsername = ?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            bbVar.b(a);
        }
        a.close();
        return bbVar;
    }

    public final int AJ(String str) {
        int delete = this.gUz.delete("Stranger", "(encryptUsername=?)", new String[]{str});
        if (delete > 0) {
            doNotify();
        }
        w.i("MicroMsg.StrangerStorage", "delByEncryptUsername:" + str + " result:" + delete);
        return delete;
    }
}
