package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.R;
import com.tencent.mm.storage.au;

final class ca extends ah {
    private cb vEr = new cb();
    private bx vEs = new bx();

    interface a {
        void a(com.tencent.mm.ui.chatting.ah.a aVar, int i, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar2, au auVar);
    }

    final class b extends com.tencent.mm.ui.chatting.ah.a {
        View mil;
        TextView suV;
        final /* synthetic */ ca vEt;

        public b(ca caVar, int i) {
            this.vEt = caVar;
            super(i);
        }
    }

    public ca() {
        super(5);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((com.tencent.mm.ui.chatting.ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = layoutInflater.inflate(R.i.cYi, null);
        b bVar = new b(this, this.knu);
        bVar.mil = view;
        bVar.kxi = (TextView) view.findViewById(R.h.bBA);
        bVar.suV = (TextView) view.findViewById(R.h.bAi);
        view.setTag(bVar);
        return view;
    }

    public final void a(com.tencent.mm.ui.chatting.ah.a aVar, int i, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar2, au auVar, String str) {
        a aVar3;
        if (auVar.field_type == CdnLogic.MediaType_FAVORITE_VIDEO) {
            aVar3 = this.vEs;
        } else {
            aVar3 = this.vEr;
        }
        aVar3.a(aVar, i, aVar2, auVar);
    }

    protected final boolean bUp() {
        return false;
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        return false;
    }

    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, au auVar) {
        return false;
    }

    public final boolean a(View view, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, au auVar) {
        return false;
    }
}
