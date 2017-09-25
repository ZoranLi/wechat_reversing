package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ah.a;

final class cu extends ah {
    public cu() {
        super(38);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((a) view.getTag()).type == this.knu) {
            return view;
        }
        view = layoutInflater.inflate(R.i.cYG, null);
        view.setTag(new eu(this.knu).du(view));
        return view;
    }

    protected final boolean bUp() {
        return false;
    }

    public final void a(a aVar, int i, En_5b8fbb1e.a aVar2, au auVar, String str) {
        aVar.kxi.setVisibility(0);
        aVar.kxi.setText(o.o(aVar2.uSU.uTo, auVar.field_createTime));
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        return false;
    }

    public final boolean a(MenuItem menuItem, En_5b8fbb1e.a aVar, au auVar) {
        return false;
    }

    public final boolean a(View view, En_5b8fbb1e.a aVar, au auVar) {
        return false;
    }
}
