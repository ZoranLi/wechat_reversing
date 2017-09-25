package com.tencent.mm.modelbiz.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.e.b.u;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.concurrent.atomic.AtomicLong;

public final class d extends i<u> {
    public static final String[] gUx = new String[]{i.a(c.gTP, "BizChatInfo")};
    public e gUz;
    final k<a, b> hug = new k<a, b>(this) {
        final /* synthetic */ d hwL;

        {
            this.hwL = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((a) obj).a((b) obj2);
        }
    };
    private AtomicLong hwK = new AtomicLong(-1);

    public interface a {

        public enum a {
            ;

            static {
                hwM = 1;
                hwN = 2;
                hwO = 3;
                hwP = new int[]{hwM, hwN, hwO};
            }
        }

        public static class b {
            public String fGs;
            public long hwG;
            public int hwQ;
            public c hwR;
        }

        void a(b bVar);
    }

    public d(e eVar) {
        super(eVar, c.gTP, "BizChatInfo", null);
        this.gUz = eVar;
        eVar.eE("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatLocalIdIndex ON BizChatInfo ( bizChatLocalId )");
        eVar.eE("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatInfo ( bizChatServId )");
        eVar.eE("BizChatInfo", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatInfo ( brandUserName )");
        synchronized (this.hwK) {
            Cursor a = this.gUz.a("select max(bizChatLocalId) from BizChatInfo", null, 2);
            long j = 0;
            if (a.moveToFirst()) {
                j = (long) a.getInt(0);
                if (j > this.hwK.get()) {
                    this.hwK.set(j);
                }
            }
            a.close();
            w.i("MicroMsg.BizChatInfoStorage", "loading new BizChat id:" + j);
        }
    }

    public final void a(a aVar, Looper looper) {
        this.hug.a(aVar, looper);
    }

    public final void a(a aVar) {
        if (this.hug != null) {
            this.hug.remove(aVar);
        }
    }

    public final c aa(long j) {
        c cVar = new c();
        cVar.field_bizChatLocalId = j;
        super.b(cVar, new String[0]);
        return cVar;
    }

    public final c iq(String str) {
        c cVar = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * ");
        stringBuilder.append(" from BizChatInfo");
        stringBuilder.append(" where bizChatServId = '").append(str).append("' ");
        stringBuilder.append(" limit 1");
        w.d("MicroMsg.BizChatInfoStorage", "getByServId sql %s", stringBuilder.toString());
        Cursor rawQuery = rawQuery(r1, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                cVar = new c();
                cVar.b(rawQuery);
            }
            rawQuery.close();
        }
        return cVar;
    }

    public final boolean V(long j) {
        c aa = aa(j);
        boolean a = super.a(aa, "bizChatLocalId");
        if (a) {
            b bVar = new b();
            bVar.hwG = aa.field_bizChatLocalId;
            bVar.fGs = aa.field_brandUserName;
            bVar.hwQ = a.hwN;
            bVar.hwR = aa;
            this.hug.by(bVar);
            this.hug.doNotify();
        }
        return a;
    }

    public final boolean a(c cVar) {
        if (cVar == null) {
            w.w("MicroMsg.BizChatInfoStorage", "insert wrong argument");
            return false;
        } else if (bg.mA(cVar.field_bizChatServId)) {
            w.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid null");
            return false;
        } else {
            c iq = iq(cVar.field_bizChatServId);
            if (iq != null) {
                cVar.field_bizChatLocalId = iq.field_bizChatLocalId;
                w.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid exist");
                return true;
            }
            cVar.field_bizChatLocalId = DX();
            boolean b = super.b((c) cVar);
            if (!b) {
                return b;
            }
            b bVar = new b();
            bVar.hwG = cVar.field_bizChatLocalId;
            bVar.fGs = cVar.field_brandUserName;
            bVar.hwQ = a.hwM;
            bVar.hwR = cVar;
            this.hug.by(bVar);
            this.hug.doNotify();
            return b;
        }
    }

    public final boolean b(c cVar) {
        boolean z = false;
        if (cVar == null) {
            w.w("MicroMsg.BizChatInfoStorage", "update wrong argument");
        } else if (cVar.field_bizChatLocalId < 0) {
            w.e("MicroMsg.BizChatInfoStorage", "update bizchat localid neg");
        } else {
            c aa = aa(cVar.field_bizChatLocalId);
            if (bg.mA(aa.field_bizChatServId) || aa.field_bizChatServId.equals(cVar.field_bizChatServId)) {
                if (cVar == null || bg.mA(cVar.field_chatName)) {
                    w.i("MicroMsg.BizChatInfoStorage", "dealWithChatNamePY null");
                } else {
                    cVar.field_chatNamePY = com.tencent.mm.platformtools.c.mp(cVar.field_chatName);
                }
                z = super.a(cVar);
                if (z) {
                    e.g(cVar);
                    b bVar = new b();
                    bVar.hwG = cVar.field_bizChatLocalId;
                    bVar.fGs = cVar.field_brandUserName;
                    bVar.hwQ = a.hwO;
                    bVar.hwR = cVar;
                    this.hug.by(bVar);
                    this.hug.doNotify();
                }
            } else {
                w.e("MicroMsg.BizChatInfoStorage", "update bizchat servid nequal");
            }
        }
        return z;
    }

    private long DX() {
        synchronized (this.hwK) {
            w.i("MicroMsg.BizChatInfoStorage", "incBizChatLocalId %d  ", Long.valueOf(this.hwK.incrementAndGet()));
        }
        return r2;
    }
}
