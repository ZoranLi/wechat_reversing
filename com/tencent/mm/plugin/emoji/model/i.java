package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.e.a.cm;
import com.tencent.mm.e.a.sj;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class i {
    public Set<String> kMv;
    public Set<String> kMw;
    public Set<String> kMx;
    c kMy = new c<sj>(this) {
        final /* synthetic */ i kMA;

        {
            this.kMA = r2;
            this.usg = sj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            sj sjVar = (sj) bVar;
            switch (sjVar.gaa.fEG) {
                case 1:
                    this.kMA.kMv.addAll(bg.f(sjVar.gaa.gab));
                    this.kMA.kMw.addAll(this.kMA.kMv);
                    this.kMA.amg();
                    break;
            }
            return false;
        }
    };
    c kMz = new c<cm>(this) {
        final /* synthetic */ i kMA;

        {
            this.kMA = r2;
            this.usg = cm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            cm cmVar = (cm) bVar;
            if (this.kMA.kMv.contains(cmVar.fFV.fFW)) {
                this.kMA.kMx.remove(cmVar.fFV.fFW);
                if (cmVar.fFV.success) {
                    w.i("MicroMsg.emoji.WearEmojiLogic", "emoji downloaded %s success", new Object[]{cmVar.fFV.fFW});
                    h.amc().kLb.Sd(cmVar.fFV.fFW);
                    ap.vd().a(new q(cmVar.fFV.fFW, 2), 0);
                } else {
                    w.i("MicroMsg.emoji.WearEmojiLogic", "emoji downloaded %s fail", new Object[]{cmVar.fFV.fFW});
                }
                this.kMA.amg();
            }
            return false;
        }
    };

    public i() {
        a.urY.b(this.kMy);
        a.urY.b(this.kMz);
        this.kMv = Collections.synchronizedSet(new HashSet());
        this.kMw = Collections.synchronizedSet(new HashSet());
        this.kMx = Collections.synchronizedSet(new HashSet());
    }

    public final void amg() {
        while (!this.kMw.isEmpty()) {
            if (this.kMx.isEmpty()) {
                Iterator it = this.kMw.iterator();
                if (it != null) {
                    String str = (String) it.next();
                    this.kMw.remove(str);
                    com.tencent.mm.storage.a.a aP = h.amc().kLb.aP(str, true);
                    if (aP == null || (aP.field_flag & 256) <= 0) {
                        w.i("MicroMsg.emoji.WearEmojiLogic", "start to download emoji %s", new Object[]{str});
                        this.kMx.add(str);
                        ap.vd().a(new g(str, ""), 0);
                        return;
                    }
                    w.i("MicroMsg.emoji.WearEmojiLogic", "emoji already exist %s", new Object[]{str});
                } else {
                    return;
                }
            }
            w.i("MicroMsg.emoji.WearEmojiLogic", "downloading emoji %s", new Object[]{this.kMx.toString()});
            return;
        }
        w.i("MicroMsg.emoji.WearEmojiLogic", "no emoji need download");
    }
}
