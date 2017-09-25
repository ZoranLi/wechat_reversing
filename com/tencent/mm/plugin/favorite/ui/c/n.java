package com.tencent.mm.plugin.favorite.ui.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.c.g;

public final class n extends a {
    public n(g gVar) {
        super(gVar);
    }

    public final View a(View view, ViewGroup viewGroup, j jVar) {
        return new View(viewGroup.getContext());
    }

    public final void cg(View view) {
        if (view != null) {
            Toast.makeText(view.getContext(), R.l.ejJ, 0).show();
        }
    }
}
