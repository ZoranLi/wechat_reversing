package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.pluginsdk.ui.d.h;
import java.util.HashMap;
import java.util.Map;

public final class a extends com.tencent.mm.ui.contact.a.a {
    private static Map<String, c> vvl = new HashMap();
    public CharSequence ipq;
    public long kbc = -1;
    public String username;
    public String vvk;
    private b vvm = new b(this);
    a vvn = new a(this);

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public ImageView ipv;
        public TextView ipx;
        public TextView jWd;
        final /* synthetic */ a vvo;

        public a(a aVar) {
            this.vvo = aVar;
            super(aVar);
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        final /* synthetic */ a vvo;

        public b(a aVar) {
            this.vvo = aVar;
            super(aVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate;
            if (com.tencent.mm.bg.a.dM(context)) {
                inflate = LayoutInflater.from(context).inflate(R.i.dnI, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(R.i.dnH, viewGroup, false);
            }
            a aVar = this.vvo.vvn;
            aVar.ipv = (ImageView) inflate.findViewById(R.h.bqM);
            aVar.jWd = (TextView) inflate.findViewById(R.h.cJh);
            aVar.ipx = (TextView) inflate.findViewById(R.h.bIb);
            aVar.ipx.setVisibility(8);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
            a aVar3 = (a) aVar2;
            a aVar4 = (a) aVar;
            e.a(aVar3.ipq, aVar4.jWd);
            n.GW().a(aVar3.vvk, aVar4.ipv, a.Ti(aVar3.username));
        }

        public final boolean Od() {
            return false;
        }
    }

    public a(int i) {
        super(4, i);
    }

    public static c Ti(String str) {
        if (str == null) {
            return null;
        }
        if (vvl.containsKey(str) && vvl.get(str) != null) {
            return (c) vvl.get(str);
        }
        com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
        aVar.hIO = com.tencent.mm.modelbiz.a.e.iz(str);
        aVar.hIL = true;
        aVar.hJh = true;
        aVar.hJa = R.k.bes;
        c Hg = aVar.Hg();
        vvl.put(str, Hg);
        return Hg;
    }

    public final void br(Context context) {
        this.ipq = h.c(context, this.ipq, com.tencent.mm.bg.a.T(context, R.f.aXI));
    }

    public final com.tencent.mm.ui.contact.a.a.b Ob() {
        return this.vvm;
    }

    protected final com.tencent.mm.ui.contact.a.a.a Oc() {
        return this.vvn;
    }
}
