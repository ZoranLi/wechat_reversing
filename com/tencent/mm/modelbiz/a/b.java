package com.tencent.mm.modelbiz.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.modelbiz.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;

public final class b extends i<a> implements com.tencent.mm.sdk.e.m.b {
    public static final String[] gUx = new String[]{i.a(a.gTP, "BizChatConversation")};
    public e gUz;
    final k<a, b> hug = new k<a, b>(this) {
        final /* synthetic */ b hwA;

        {
            this.hwA = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((a) obj).a((b) obj2);
        }
    };

    public interface a {

        public enum a {
            ;

            static {
                hwB = 1;
                hwC = 2;
                hwD = 3;
                hwE = new int[]{hwB, hwC, hwD};
            }
        }

        public static class b {
            public String fGs;
            public int hwF;
            public long hwG;
            public a hwH;
        }

        void a(b bVar);
    }

    public final /* synthetic */ boolean b(c cVar) {
        return a((a) cVar);
    }

    public b(e eVar) {
        super(eVar, a.gTP, "BizChatConversation", null);
        this.gUz = eVar;
        eVar.eE("BizChatConversation", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatConversation ( bizChatId )");
        eVar.eE("BizChatConversation", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatConversation ( brandUserName )");
        eVar.eE("BizChatConversation", "CREATE INDEX IF NOT EXISTS unreadCountIndex ON BizChatConversation ( unReadCount )");
        Object obj = null;
        Cursor a = eVar.a("PRAGMA table_info( BizChatConversation)", null, 2);
        while (a.moveToNext()) {
            int columnIndex = a.getColumnIndex("name");
            if (columnIndex >= 0) {
                if ("flag".equalsIgnoreCase(a.getString(columnIndex))) {
                    obj = 1;
                    break;
                }
            }
        }
        a.close();
        if (obj == null) {
            eVar.eE("BizChatConversation", "update BizChatConversation set flag = lastMsgTime");
        }
        ((h) com.tencent.mm.kernel.h.h(h.class)).wR().a(this);
    }

    protected final void finalize() {
        ((h) com.tencent.mm.kernel.h.h(h.class)).wR().b(this);
    }

    public final void a(a aVar, Looper looper) {
        this.hug.a(aVar, looper);
    }

    public final void a(a aVar) {
        if (this.hug != null) {
            this.hug.remove(aVar);
        }
    }

    public final void a(int i, m mVar, Object obj) {
        w.i("MicroMsg.BizConversationStorage", "onNotifyChange");
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (com.tencent.mm.modelbiz.e.dr(str) && !o.eU(str)) {
                e.u(str, true);
            }
        }
    }

    public final a U(long j) {
        c aVar = new a();
        aVar.field_bizChatId = j;
        super.b(aVar, new String[0]);
        return aVar;
    }

    public final boolean V(long j) {
        c U = U(j);
        boolean a = super.a(U, "bizChatId");
        if (a) {
            b bVar = new b();
            bVar.hwG = U.field_bizChatId;
            bVar.fGs = U.field_brandUserName;
            bVar.hwF = a.hwC;
            bVar.hwH = U;
            this.hug.by(bVar);
            this.hug.doNotify();
        }
        return a;
    }

    public final boolean a(a aVar) {
        w.d("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert");
        if (aVar == null) {
            w.w("MicroMsg.BizConversationStorage", "insert wrong argument");
            return false;
        }
        boolean b = super.b((c) aVar);
        w.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage insert res:%s", Boolean.valueOf(b));
        if (b) {
            b bVar = new b();
            bVar.hwG = aVar.field_bizChatId;
            bVar.fGs = aVar.field_brandUserName;
            bVar.hwF = a.hwB;
            bVar.hwH = aVar;
            this.hug.by(bVar);
            this.hug.doNotify();
        }
        return b;
    }

    public final boolean b(a aVar) {
        if (aVar == null) {
            w.w("MicroMsg.BizConversationStorage", "update wrong argument");
            return false;
        }
        boolean a = super.a(aVar);
        w.i("MicroMsg.BizConversationStorage", "BizChatConversationStorage update res:%s", Boolean.valueOf(a));
        if (a) {
            e.g(com.tencent.mm.modelbiz.w.DJ().aa(aVar.field_bizChatId));
            b bVar = new b();
            bVar.hwG = aVar.field_bizChatId;
            bVar.fGs = aVar.field_brandUserName;
            bVar.hwF = a.hwD;
            bVar.hwH = aVar;
            this.hug.by(bVar);
            this.hug.doNotify();
        }
        return a;
    }

    public final Cursor io(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from BizChatConversation");
        stringBuilder.append(" where brandUserName = '").append(str).append("'");
        stringBuilder.append(" order by flag desc , ").append("lastMsgTime desc");
        w.d("MicroMsg.BizConversationStorage", "getBizChatConversationCursor: sql:%s", stringBuilder.toString());
        return this.gUz.rawQuery(stringBuilder.toString(), null);
    }

    public static void a(a aVar, int i, int i2) {
        if (aVar.field_msgCount == 0) {
            aVar.field_msgCount = ((n) com.tencent.mm.kernel.h.h(n.class)).wU().ah(aVar.field_brandUserName, aVar.field_bizChatId);
            w.i("MicroMsg.BizConversationStorage", "getMsgCount from message table");
        } else if (i > 0) {
            aVar.field_msgCount -= i;
            if (aVar.field_msgCount < 0) {
                w.e("MicroMsg.BizConversationStorage", "msg < 0 ,some path must be ignore!");
                aVar.field_msgCount = 0;
            }
        } else if (i2 > 0) {
            aVar.field_msgCount += i2;
        }
        w.i("MicroMsg.BizConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", Integer.valueOf(aVar.field_msgCount), Long.valueOf(aVar.field_bizChatId), Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final boolean W(long j) {
        a U = U(j);
        if (!(U.field_unReadCount == 0 && U.field_bizChatId == j)) {
            U.field_unReadCount = 0;
            U.field_atCount = 0;
            b(U);
        }
        return true;
    }

    public static long a(a aVar, int i, long j) {
        if (aVar == null) {
            return 0;
        }
        if (j == 0) {
            j = bg.Nz();
        }
        switch (i) {
            case 2:
                return a(aVar, j) | 4611686018427387904L;
            case 3:
                return a(aVar, j) & -4611686018427387905L;
            case 4:
                return a(aVar, j) & 4611686018427387904L;
            default:
                return a(aVar, j);
        }
    }

    private static long a(a aVar, long j) {
        return (aVar.field_flag & -72057594037927936L) | (72057594037927935L & j);
    }

    public final boolean X(long j) {
        return c(U(j));
    }

    public static boolean c(a aVar) {
        if (aVar == null) {
            w.e("MicroMsg.BizConversationStorage", "isPlacedTop failed, conversation null");
            return false;
        } else if (a(aVar, 4, 0) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean Y(long j) {
        U(j);
        a U = U(j);
        boolean eE = this.gUz.eE("BizChatConversation", "update BizChatConversation set flag = " + a(U, 2, 0) + " where bizChatId = " + U.field_bizChatId);
        if (eE) {
            U = U(U.field_bizChatId);
            b bVar = new b();
            bVar.hwG = U.field_bizChatId;
            bVar.fGs = U.field_brandUserName;
            bVar.hwF = a.hwD;
            bVar.hwH = U;
            this.hug.by(bVar);
            this.hug.doNotify();
        }
        return eE;
    }

    public final boolean Z(long j) {
        a U = U(j);
        boolean eE = this.gUz.eE("BizChatConversation", "update BizChatConversation set flag = " + a(U, 3, U.field_lastMsgTime) + " where bizChatId = " + U.field_bizChatId);
        if (eE) {
            U = U(U.field_bizChatId);
            b bVar = new b();
            bVar.hwG = U.field_bizChatId;
            bVar.fGs = U.field_brandUserName;
            bVar.hwF = a.hwD;
            bVar.hwH = U;
            this.hug.by(bVar);
            this.hug.doNotify();
        }
        return eE;
    }
}
