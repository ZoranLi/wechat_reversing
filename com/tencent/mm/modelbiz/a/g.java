package com.tencent.mm.modelbiz.a;

import android.database.Cursor;
import com.tencent.mm.e.b.v;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class g extends i<v> {
    public static final String[] gUx = new String[]{i.a(f.gTP, "BizChatMyUserInfo")};
    private e gUz;
    private final k<a, b> hug = new k<a, b>(this) {
        final /* synthetic */ g hwY;

        {
            this.hwY = r1;
        }

        protected final /* bridge */ /* synthetic */ void o(Object obj, Object obj2) {
        }
    };

    public interface a {

        public enum a {
            ;

            static {
                hwZ = 1;
                hxa = 2;
                hxb = 3;
                hxc = new int[]{hwZ, hxa, hxb};
            }
        }

        public static class b {
            public String fGs;
            public int hxd;
            public f hxe;
        }
    }

    public g(e eVar) {
        super(eVar, f.gTP, "BizChatMyUserInfo", null);
        this.gUz = eVar;
        eVar.eE("BizChatMyUserInfo", "CREATE INDEX IF NOT EXISTS bizChatbrandUserNameIndex ON BizChatMyUserInfo ( brandUserName )");
    }

    public final f iB(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.BizChatMyUserInfoStorage", "get： wrong argument");
            return null;
        }
        c fVar = new f();
        fVar.field_brandUserName = str;
        super.b(fVar, new String[0]);
        return fVar;
    }

    public final boolean iC(String str) {
        boolean z = false;
        if (bg.mA(str)) {
            w.w("MicroMsg.BizChatMyUserInfoStorage", "delete wrong argument");
        } else {
            c fVar = new f();
            fVar.field_brandUserName = str;
            z = super.a(fVar, "brandUserName");
            if (z) {
                b bVar = new b();
                bVar.fGs = fVar.field_brandUserName;
                bVar.hxd = a.hxa;
                bVar.hxe = fVar;
                this.hug.by(bVar);
                this.hug.doNotify();
            }
        }
        return z;
    }

    public final boolean a(f fVar) {
        w.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert");
        boolean b = super.b((c) fVar);
        if (b) {
            b bVar = new b();
            bVar.fGs = fVar.field_brandUserName;
            bVar.hxd = a.hwZ;
            bVar.hxe = fVar;
            this.hug.by(bVar);
            this.hug.doNotify();
        } else {
            w.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert fail");
        }
        return b;
    }

    public final boolean b(f fVar) {
        w.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update");
        if (fVar == null) {
            w.w("MicroMsg.BizChatMyUserInfoStorage", "update wrong argument");
            return false;
        }
        boolean a = super.a(fVar);
        if (a) {
            b bVar = new b();
            bVar.fGs = fVar.field_brandUserName;
            bVar.hxd = a.hxb;
            bVar.hxe = fVar;
            this.hug.by(bVar);
            this.hug.doNotify();
            return a;
        }
        w.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update fail");
        return a;
    }

    public final int getCount() {
        int i = 0;
        w.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage getCount");
        Cursor a = this.gUz.a("SELECT COUNT(*) FROM BizChatMyUserInfo", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }
}
