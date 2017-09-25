package com.tencent.mm.plugin.record.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.Iterator;
import java.util.Vector;

public final class i extends com.tencent.mm.sdk.e.i<g> {
    public static final String[] gUx = new String[]{com.tencent.mm.sdk.e.i.a(g.gTP, "RecordCDNInfo")};
    e gUz;
    public Vector<a> oOu = new Vector();

    public interface a {
        void a(int i, g gVar);
    }

    public final /* synthetic */ boolean a(long j, c cVar) {
        g gVar = (g) cVar;
        if (!super.a(j, (c) gVar)) {
            return false;
        }
        b(1, gVar);
        return true;
    }

    public final /* synthetic */ boolean a(c cVar) {
        g gVar = (g) cVar;
        if (!super.a(gVar)) {
            return false;
        }
        b(1, gVar);
        return true;
    }

    public final /* synthetic */ boolean b(c cVar) {
        return a((g) cVar);
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        return b((g) cVar, strArr);
    }

    public i(e eVar) {
        super(eVar, g.gTP, "RecordCDNInfo", null);
        this.gUz = eVar;
    }

    public final void a(final a aVar) {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ i oOw;

            public final void run() {
                if (!this.oOw.oOu.contains(aVar)) {
                    this.oOw.oOu.add(aVar);
                }
            }
        });
    }

    public final void b(final a aVar) {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ i oOw;

            public final void run() {
                this.oOw.oOu.remove(aVar);
            }
        });
    }

    private void b(final int i, final g gVar) {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ i oOw;

            public final void run() {
                Iterator it = this.oOw.oOu.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).a(i, gVar);
                }
            }
        });
    }

    public final g Do(String str) {
        g gVar = null;
        Cursor a = this.gUz.a("SELECT * FROM RecordCDNInfo WHERE mediaId='" + str + "'", null, 2);
        if (a != null && a.moveToFirst()) {
            gVar = new g();
            gVar.b(a);
        }
        if (a != null) {
            a.close();
        }
        return gVar;
    }

    public final boolean a(g gVar, String... strArr) {
        if (!super.a((c) gVar, strArr)) {
            return false;
        }
        b(0, gVar);
        return true;
    }

    public final boolean b(g gVar, String... strArr) {
        if (!super.c(gVar, strArr)) {
            return false;
        }
        b(1, gVar);
        return true;
    }

    public final boolean a(g gVar) {
        if (gVar != null) {
            w.v("MicroMsg.RecordMsgCDNStorage", "insert record cdn info %s", gVar);
            if (!super.b((c) gVar)) {
                return false;
            }
            b(2, gVar);
            return true;
        }
        w.e("MicroMsg.RecordMsgCDNStorage", "insert null record cdn info");
        return false;
    }
}
