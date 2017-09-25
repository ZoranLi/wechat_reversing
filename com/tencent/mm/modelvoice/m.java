package com.tencent.mm.modelvoice;

import android.content.Context;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.c.b.i;
import com.tencent.mm.e.a.mx;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.bg;
import com.tencent.mm.u.am;
import com.tencent.mm.u.l;
import com.tencent.mm.y.d;
import java.util.HashMap;
import junit.framework.Assert;

public class m implements am {
    private static HashMap<Integer, c> gJr;
    private u icg;
    private bg ich;
    private i ici;
    private r icj = new r();
    private com.tencent.mm.sdk.b.c ick = new com.tencent.mm.sdk.b.c<mx>(this) {
        final /* synthetic */ m icl;

        {
            this.icl = r2;
            this.usg = mx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            q.gQ((int) ((mx) bVar).fUg.fCZ.field_msgId);
            return false;
        }
    };

    static class a implements com.tencent.mm.pluginsdk.b.a {
        a() {
        }

        public final boolean a(Context context, String[] strArr) {
            String str = strArr[0];
            int i = -1;
            switch (str.hashCode()) {
                case -1560895490:
                    if (str.equals("//voicetrymore")) {
                        i = 0;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    if (strArr.length > 1 && strArr[1] != null) {
                        boolean z;
                        if (com.tencent.mm.sdk.platformtools.bg.getInt(strArr[1], 1) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        i.fBr = z;
                        w.i("MicroMsg.SubCoreVoice", "summervoicetrymore enable[%d]", Integer.valueOf(r3));
                        return true;
                    }
            }
            return false;
        }
    }

    private static m Lx() {
        return (m) l.o(m.class);
    }

    public static u Ly() {
        h.vG().uQ();
        if (Lx().icg == null) {
            Assert.assertTrue("dataDB is null ", h.vI().gYg != null);
            Lx().icg = new u(h.vI().gYg);
        }
        return Lx().icg;
    }

    public static bg Lz() {
        h.vG().uQ();
        if (Lx().ich == null) {
            Assert.assertTrue("dataDB is null ", h.vI().gYg != null);
            Lx().ich = new bg(h.vI().gYg);
        }
        return Lx().ich;
    }

    public static i LA() {
        h.vG().uQ();
        if (Lx().ici == null) {
            Lx().ici = new i();
        }
        return Lx().ici;
    }

    public final void onAccountRelease() {
        if (Lx().ici != null) {
            Lx().ici.fBo = 0;
        }
        d.c.aA(Integer.valueOf(34));
        com.tencent.mm.sdk.b.a.urY.c(this.ick);
        com.tencent.mm.pluginsdk.b.b.B("//voicetrymore");
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("VOICE_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return u.gUx;
            }
        });
        gJr.put(Integer.valueOf("VOICETRANSTEXT_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return bg.gUx;
            }
        });
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        d.c.a(Integer.valueOf(34), this.icj);
        com.tencent.mm.sdk.b.a.urY.b(this.ick);
        com.tencent.mm.pluginsdk.b.b.a(new a(), "//voicetrymore");
    }

    public final void aN(boolean z) {
    }
}
