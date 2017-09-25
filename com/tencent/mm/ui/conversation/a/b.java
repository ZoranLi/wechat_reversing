package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.l.a.a;
import com.tencent.mm.ui.k;
import java.util.ArrayList;

public final class b extends k<c> {
    private ArrayList<c> vaQ = new ArrayList();
    a weI = null;

    public final /* bridge */ /* synthetic */ Object a(Object obj, Cursor cursor) {
        return null;
    }

    public final /* synthetic */ Object getItem(int i) {
        return BQ(i);
    }

    public b(Context context) {
        super(context, null);
        OL();
    }

    protected final void OL() {
        OK();
    }

    public final void OK() {
        this.vaQ.clear();
        if (this.weI != null) {
            this.vaQ.add(new c(this.weI));
            notifyDataSetChanged();
        }
    }

    public final int getCount() {
        return this.vaQ.size();
    }

    public final c BQ(int i) {
        return (c) this.vaQ.get(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        c cVar = (c) this.vaQ.get(i);
        if (view == null) {
            view = View.inflate(this.context, R.i.cTI, null);
            d dVar2 = new d();
            dVar2.weK = view;
            dVar2.weL = (Button) view.findViewById(R.h.bnn);
            view.setTag(dVar2);
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
        }
        if (cVar.a(dVar) != 0) {
            return null;
        }
        return view;
    }
}
