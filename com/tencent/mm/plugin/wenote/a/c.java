package com.tencent.mm.plugin.wenote.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.kb;
import com.tencent.mm.e.a.kq;
import com.tencent.mm.plugin.wenote.model.i;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class c extends com.tencent.mm.sdk.b.c<kq> {
    public c() {
        this.usg = kq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        kq kqVar = (kq) bVar;
        b kbVar = new kb();
        kbVar.fQz.type = 3;
        kbVar.fQz.fQv = 3;
        a.urY.m(kbVar);
        w.i("MicroMsg.OpenNoteFromSessionListener", "do OpenNoteFromSessionListener");
        com.tencent.mm.plugin.wenote.model.b iVar = new i();
        com.tencent.mm.plugin.wenote.model.a.bAZ().stz = iVar;
        String str = kqVar.fRi.fRj;
        Long valueOf = Long.valueOf(kqVar.fRi.fGM);
        boolean z = kqVar.fRi.fQy;
        Context context = kqVar.fRi.context;
        iVar.fRj = str;
        iVar.sui = valueOf;
        iVar.fQy = z;
        if (com.tencent.mm.pluginsdk.model.c.sCd) {
            Intent intent = new Intent();
            intent.putExtra("from_session", true);
            intent.putExtra("edit_status", iVar.soD);
            intent.putExtra("message_id", iVar.sui);
            intent.putExtra("record_show_share", iVar.fQy);
            d.b(context, "wenote", ".ui.nativenote.NoteEditorUI", intent);
            ap.vL().D(new Runnable(iVar) {
                final /* synthetic */ i suk;

                {
                    this.suk = r1;
                }

                public final void run() {
                    this.suk.bBe();
                    this.suk.g(this.suk.stA.oOQ, true);
                    if (k.bBS() != null) {
                        k.bBS().swt.jh(true);
                    }
                }

                public final String toString() {
                    return super.toString() + "|dealWNoteInfo";
                }
            });
        } else {
            iVar.dh(context);
            ap.vL().D(new Runnable(iVar) {
                final /* synthetic */ i suk;

                {
                    this.suk = r1;
                }

                public final void run() {
                    this.suk.bBe();
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 sul;

                        {
                            this.sul = r1;
                        }

                        public final void run() {
                            this.sul.suk.bBa();
                        }
                    });
                }

                public final String toString() {
                    return super.toString() + "|dealWNoteInfo";
                }
            });
        }
        return false;
    }
}
