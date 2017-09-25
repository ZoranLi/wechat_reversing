package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ah.a;

final class cr extends cm {
    public cr() {
        super(43);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((a) view.getTag()).type == this.knu) {
            return view;
        }
        view = new bj(layoutInflater, R.i.cYB);
        view.setTag(new et(this.knu).du(view));
        return view;
    }

    public final void a(a aVar, int i, En_5b8fbb1e.a aVar2, au auVar, String str) {
        et.a((et) aVar, auVar, false, i, aVar2);
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
