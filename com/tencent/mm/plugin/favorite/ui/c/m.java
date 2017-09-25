package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.ui.c.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;

public final class m extends a {
    private HashMap<String, SpannableString> lNk = new HashMap();

    public static class a extends b {
        TextView kxh;
    }

    public m(g gVar) {
        super(gVar);
    }

    public final View a(View view, ViewGroup viewGroup, j jVar) {
        b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, R.i.dct, null), aVar, jVar);
            aVar.kxh = (TextView) view.findViewById(R.h.bOW);
            bVar = aVar;
        } else {
            a aVar2 = (a) view.getTag();
        }
        a(bVar, jVar);
        if (jVar.field_favProto.desc == null || jVar.field_favProto.desc.length() <= 0) {
            bVar.kxh.setText("");
        } else {
            w.d("MicroMsg.FavBaseListItem", "desc %s", new Object[]{jVar.field_favProto.desc});
            bVar.kxh.setText(h.b(bVar.kxh.getContext(), jVar.field_favProto.desc, bVar.kxh.getTextSize()));
        }
        return view;
    }

    public final void cg(View view) {
        e.b(view.getContext(), ((a) view.getTag()).lFt);
    }
}
