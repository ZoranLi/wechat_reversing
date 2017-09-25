package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ay;

public final class br extends ah {

    final class a extends com.tencent.mm.ui.chatting.ah.a {
        protected ImageView hBi;
        protected TextView vDS;
        final /* synthetic */ br vDT;

        public a(br brVar, int i) {
            this.vDT = brVar;
            super(i);
        }

        public final a dr(View view) {
            super.dn(view);
            this.mfD = (CheckBox) view.findViewById(R.h.bAd);
            this.hBi = (ImageView) view.findViewById(R.h.ctA);
            this.vDS = (TextView) view.findViewById(R.h.cIG);
            return this;
        }
    }

    public br() {
        super(58);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof a) && ((a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYd);
        view.setTag(new a(this, this.knu).dr(view));
        return view;
    }

    public final void a(com.tencent.mm.ui.chatting.ah.a aVar, int i, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar2, au auVar, String str) {
        com.tencent.mm.t.f.a aVar3;
        a aVar4 = (a) aVar;
        f ec = an.bDk().ec(auVar.field_msgId);
        String str2 = auVar.field_content;
        if (ec == null || str2 == null) {
            String str3 = "MicroMsg.ChattingItemHardDeviceMsgPush";
            String str4 = "amessage:%b, %s, %d, %s";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(ec == null);
            objArr[1] = str2;
            objArr[2] = Long.valueOf(auVar.field_msgId);
            objArr[3] = str;
            w.e(str3, str4, objArr);
            aVar3 = null;
        } else {
            aVar3 = com.tencent.mm.t.f.a.B(str2, auVar.field_reserved);
        }
        dt dtVar = new dt(auVar, aVar2.vxp, i, null, 0, (byte) 0);
        if (aVar3 != null && (aVar3.showType == 3 || aVar3.hik == 3)) {
            aVar4.hBi.setImageResource(R.g.bfG);
            aVar4.vDS.setText(aVar3.hip);
        }
        aVar.vBZ.setOnLongClickListener(aVar2.vBD.vEY);
        aVar.vBZ.setOnTouchListener(aVar2.vBD.vFa);
        aVar.vBZ.setTag(dtVar);
        aVar.vBZ.setOnClickListener(aVar2.vBD.vEW);
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        contextMenu.add(((dt) view.getTag()).position, 100, 0, view.getContext().getString(R.l.dUp));
        return false;
    }

    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, au auVar) {
        switch (menuItem.getItemId()) {
            case 100:
                String str = auVar.field_content;
                com.tencent.mm.t.f.a aVar2 = null;
                if (str != null) {
                    aVar2 = com.tencent.mm.t.f.a.ek(str);
                }
                if (aVar2 != null) {
                    l.ed(auVar.field_msgId);
                }
                ay.L(auVar.field_msgId);
                break;
        }
        return false;
    }

    public final boolean a(View view, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, au auVar) {
        return false;
    }
}
