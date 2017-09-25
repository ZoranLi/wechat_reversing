package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.c;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.chatting.ah.b;

final class bw extends b {
    private a vCd;

    public bw() {
        super(8);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ah.a) view.getTag()).type == this.knu) {
            return view;
        }
        view = layoutInflater.inflate(R.i.cXT, null);
        dy dyVar = new dy(this.knu);
        dyVar.kxi = (TextView) view.findViewById(R.h.bBA);
        dyVar.piH = (TextView) view.findViewById(R.h.bBG);
        dyVar.vyx = (ImageView) view.findViewById(R.h.bAW);
        dyVar.suU = (TextView) view.findViewById(R.h.bBC);
        dyVar.suV = (TextView) view.findViewById(R.h.bAi);
        dyVar.vBZ = view.findViewById(R.h.bAe);
        view.setTag(dyVar);
        return view;
    }

    public final void a(ah.a aVar, int i, a aVar2, au auVar, String str) {
        this.vCd = aVar2;
        dy dyVar = (dy) aVar;
        ap.yY();
        c At = com.tencent.mm.u.c.wT().At(auVar.field_content);
        dyVar.suU.setText(At.title);
        dyVar.suV.setText(At.content);
        ah.a((ah.a) dyVar, At.hRP);
        dyVar.vyx.setVisibility(At.lJB ? 0 : 8);
        dyVar.vBZ.setTag(new dt(auVar, aVar2.vxp, i, null, 0, (byte) 0));
        dyVar.vBZ.setOnClickListener(aVar2.vBD.vEW);
        dyVar.vBZ.setOnLongClickListener(aVar2.vBD.vEY);
        dyVar.vBZ.setOnTouchListener(aVar2.vBD.vFa);
    }

    protected final boolean bUp() {
        return false;
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        int i = ((dt) view.getTag()).position;
        if (!this.vCd.bVJ()) {
            contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dUp));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, au auVar) {
        return false;
    }

    public final boolean a(View view, a aVar, au auVar) {
        return false;
    }
}
