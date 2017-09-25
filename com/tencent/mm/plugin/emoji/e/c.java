package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import java.util.ArrayList;

public class c {
    public static c kJK;
    public ArrayList<String> kJL = new ArrayList();
    public boolean kJM = true;
    public boolean kJN = false;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ com.tencent.mm.storage.a.c kJO;
        final /* synthetic */ c kJP;

        AnonymousClass1(c cVar, com.tencent.mm.storage.a.c cVar2) {
            this.kJP = cVar;
            this.kJO = cVar2;
        }

        public final void run() {
            if (this.kJO != null && !this.kJO.bNx()) {
                w.i("MicroMsg.emoji.EmojiFileCheckerMgr", "chatting emoji broken. try to recover:%s", new Object[]{this.kJO.EP()});
                c.a(this.kJO, true);
            }
        }
    }

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ com.tencent.mm.storage.a.c kJO;
        final /* synthetic */ c kJP;
        final /* synthetic */ Context val$context;

        AnonymousClass2(c cVar, com.tencent.mm.storage.a.c cVar2, Context context) {
            this.kJP = cVar;
            this.kJO = cVar2;
            this.val$context = context;
        }

        public final void run() {
            if (this.kJO != null && !this.kJO.bNx()) {
                if (bg.mA(this.kJO.field_groupId)) {
                    w.i("MicroMsg.emoji.EmojiFileCheckerMgr", "smiley pannel emoji broken. try to recover:%s", new Object[]{this.kJO.EP()});
                    c.a(this.kJO, false);
                    return;
                }
                c cVar = this.kJP;
                Context context = this.val$context;
                com.tencent.mm.storage.a.c cVar2 = this.kJO;
                if (context != null && cVar2 != null && !cVar.kJL.contains(cVar2.field_groupId)) {
                    if (!c.alx() || cVar.kJN) {
                        if (c.alx()) {
                            cVar.b(cVar2, false);
                            w.i("MicroMsg.emoji.EmojiFileCheckerMgr", "smiley pannel emotion broken. try to recover in mobile netword:%s", new Object[]{cVar2.field_groupId});
                            return;
                        }
                        cVar.b(cVar2, true);
                        w.i("MicroMsg.emoji.EmojiFileCheckerMgr", "smiley pannel emotion broken. try to recover in wifi netword:%s", new Object[]{cVar2.field_groupId});
                    } else if (cVar.kJM) {
                        g.a(context, context.getString(R.l.edy), "", new AnonymousClass3(cVar, cVar2), new OnClickListener(cVar) {
                            final /* synthetic */ c kJP;

                            {
                                this.kJP = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.kJP.kJN = false;
                            }
                        });
                        cVar.kJM = false;
                    } else {
                        w.i("MicroMsg.emoji.EmojiFileCheckerMgr", "has alert recover.");
                    }
                }
            }
        }
    }

    class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ com.tencent.mm.storage.a.c kJO;
        final /* synthetic */ c kJP;

        AnonymousClass3(c cVar, com.tencent.mm.storage.a.c cVar2) {
            this.kJP = cVar;
            this.kJO = cVar2;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.kJP.b(this.kJO, false);
            this.kJP.kJN = true;
            w.i("MicroMsg.emoji.EmojiFileCheckerMgr", "smiley pannel emotion broken. try to recover in mobile netword:%s", new Object[]{this.kJO.field_groupId});
        }
    }

    public static c alw() {
        if (kJK == null) {
            synchronized (c.class) {
                kJK = new c();
            }
        }
        return kJK;
    }

    public static void a(com.tencent.mm.storage.a.c cVar, boolean z) {
        if (cVar != null) {
            cVar.field_reserved4 = 0;
            h.amc().kLa.u(cVar);
            h.alW().h(cVar);
            if (z) {
                com.tencent.mm.plugin.report.service.g.oUh.a(231, 0, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.g.oUh.a(231, 1, 1, false);
            }
        }
    }

    public final void b(com.tencent.mm.storage.a.c cVar, boolean z) {
        if (this.kJL == null) {
            this.kJL = new ArrayList();
        }
        this.kJL.add(cVar.field_groupId);
        ap.vd().a(new com.tencent.mm.plugin.emoji.f.g(cVar.field_groupId), 0);
        if (z) {
            com.tencent.mm.plugin.report.service.g.oUh.a(231, 3, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.g.oUh.a(231, 2, 1, false);
        }
    }

    static boolean alx() {
        return am.is3G(ab.getContext()) || am.is4G(ab.getContext()) || am.is2G(ab.getContext());
    }
}
