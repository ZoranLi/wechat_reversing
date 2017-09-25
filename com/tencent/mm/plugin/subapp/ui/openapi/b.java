package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import java.util.List;

public final class b extends BaseAdapter implements a {
    private Context context;
    boolean qUl = false;
    private List<f> qUn;

    public b(Context context, List<f> list) {
        this.context = context;
        this.qUn = list;
    }

    public final void hS(boolean z) {
        this.qUl = z;
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            cVar = new c();
            view = View.inflate(this.context, R.i.cUG, null);
            cVar.jla = (ImageView) view.findViewById(R.h.bpT);
            cVar.qUI = (TextView) view.findViewById(R.h.bpS);
            cVar.iuF = (TextView) view.findViewById(R.h.bpU);
            cVar.qUJ = view.findViewById(R.h.bpV);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.qUJ.setVisibility(4);
        if (nJ(i)) {
            cVar.jla.setVisibility(4);
            cVar.qUI.setVisibility(4);
            cVar.iuF.setVisibility(4);
        } else {
            f fVar = (f) getItem(i);
            cVar.jla.setVisibility(0);
            Bitmap b = g.b(fVar.field_appId, 5, com.tencent.mm.bg.a.getDensity(this.context));
            if (b == null) {
                cVar.jla.setBackgroundResource(R.g.bcg);
            } else {
                cVar.jla.setBackgroundDrawable(new BitmapDrawable(b));
            }
            cVar.iuF.setVisibility(0);
            cVar.iuF.setText(g.a(this.context, fVar, null));
            if (this.qUl) {
                cVar.qUI.setVisibility(0);
            } else {
                cVar.qUI.setVisibility(8);
            }
        }
        return view;
    }

    public final int getCount() {
        return ano() + aBV();
    }

    public final boolean nJ(int i) {
        int size = this.qUn.size();
        return i >= size && i < size + aBV();
    }

    public final Object getItem(int i) {
        if (nJ(i)) {
            return null;
        }
        return this.qUn.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    private int ano() {
        return this.qUn.size();
    }

    private int aBV() {
        return (4 - (ano() % 4)) % 4;
    }

    public final void a(String str, l lVar) {
        notifyDataSetChanged();
    }
}
