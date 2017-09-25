package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public final class a extends BaseAdapter implements com.tencent.mm.sdk.e.j.a {
    private Context context;
    boolean qUl = false;
    private int qUm = 0;
    private List<f> qUn;

    public a(Context context, int i) {
        this.context = context;
        this.qUm = i;
        init();
    }

    private void init() {
        int i = 0;
        this.qUn = new ArrayList();
        Cursor rawQuery = an.aRr().rawQuery("select * from AppInfo where status = " + this.qUm + " and (appType is null or appType not like ',1,')", new String[0]);
        if (rawQuery == null) {
            w.e("MicroMsg.AppInfoStorage", "getAppByStatusExcludeByType: curosr is null");
            rawQuery = null;
        }
        if (rawQuery != null) {
            int count = rawQuery.getCount();
            while (i < count) {
                rawQuery.moveToPosition(i);
                f fVar = new f();
                fVar.b(rawQuery);
                if (g.n(this.context, fVar.field_appId)) {
                    this.qUn.add(fVar);
                }
                i++;
            }
            rawQuery.close();
        }
    }

    public final void hS(boolean z) {
        this.qUl = z;
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        if (view == null) {
            dVar = new d();
            view = View.inflate(this.context, R.i.cUG, null);
            dVar.jla = (ImageView) view.findViewById(R.h.bpT);
            dVar.qUI = (TextView) view.findViewById(R.h.bpS);
            dVar.iuF = (TextView) view.findViewById(R.h.bpU);
            dVar.qUJ = view.findViewById(R.h.bpV);
            view.setTag(dVar);
        } else {
            dVar = (d) view.getTag();
        }
        dVar.qUJ.setVisibility(4);
        if (nJ(i)) {
            dVar.jla.setVisibility(4);
            dVar.qUI.setVisibility(4);
            dVar.iuF.setVisibility(4);
        } else {
            f fVar = (f) getItem(i);
            dVar.jla.setVisibility(0);
            Bitmap b = g.b(fVar.field_appId, 1, com.tencent.mm.bg.a.getDensity(this.context));
            if (b == null) {
                dVar.jla.setBackgroundResource(R.g.bcg);
            } else {
                dVar.jla.setBackgroundDrawable(new BitmapDrawable(b));
            }
            dVar.iuF.setVisibility(0);
            dVar.iuF.setText(g.a(this.context, fVar, null));
            if (this.qUl) {
                dVar.qUI.setVisibility(0);
            } else {
                dVar.qUI.setVisibility(8);
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
        init();
        super.notifyDataSetChanged();
    }
}
