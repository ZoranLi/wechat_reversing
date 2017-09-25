package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.k;

public final class c extends k<CardInfo> {
    private final String TAG = "MicroMsg.CardAdapter";
    private int count = 0;
    com.tencent.mm.plugin.card.base.c kiu;
    private int kkb;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (CardInfo) obj;
        if (obj == null) {
            obj = new CardInfo();
        }
        if (cursor.isClosed()) {
            w.e("MicroMsg.CardAdapter", "cursor is closed!");
        } else {
            obj.b(cursor);
        }
        return obj;
    }

    public c(Context context, int i) {
        super(context, new CardInfo());
        this.kkb = i;
        ko(true);
        this.kiu = new k(context, this);
    }

    public final void OK() {
        w.v("MicroMsg.CardAdapter", "resetCursor");
        Cursor kp = al.aga().kp(this.kkb);
        if (kp != null) {
            this.count = kp.getCount();
            w.v("MicroMsg.CardAdapter", "card count:" + this.count);
        }
        setCursor(kp);
        notifyDataSetChanged();
    }

    protected final void OL() {
        aEW();
        OK();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.kiu.a(i, view, (CardInfo) getItem(i));
    }
}
