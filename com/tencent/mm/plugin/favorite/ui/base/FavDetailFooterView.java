package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.u;

public class FavDetailFooterView extends TextView {
    public FavDetailFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FavDetailFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void z(j jVar) {
        if (jVar != null) {
            if (jVar.field_edittime > 0) {
                setText(getContext().getString(R.l.ehR) + u.e(getContext(), jVar.field_edittime * 1000));
            } else {
                setText(getContext().getString(R.l.ejG) + u.e(getContext(), jVar.field_updateTime));
            }
        }
    }
}
