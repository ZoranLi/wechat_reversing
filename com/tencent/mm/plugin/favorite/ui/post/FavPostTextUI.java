package com.tencent.mm.plugin.favorite.ui.post;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.m;
import com.tencent.mm.plugin.favorite.c.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.tools.MMTextInputUI;

public class FavPostTextUI extends MMTextInputUI {
    protected final int getLayoutId() {
        return R.i.dcj;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.eiT);
    }

    protected final void v(CharSequence charSequence) {
        if (charSequence == null || bg.mA(charSequence.toString())) {
            w.w("MicroMsg.MMTextInputUI", "text is null");
            return;
        }
        String charSequence2 = charSequence.toString();
        if (bg.mA(charSequence2) || charSequence2.trim().length() == 0) {
            w.e("MicroMsg.FavPostLogic", "postText text null");
            return;
        }
        j jVar = new j();
        jVar.field_type = 1;
        jVar.field_sourceType = 6;
        jVar.field_favProto.OC(charSequence2);
        m.f(jVar);
        a.w(jVar);
        g.oUh.i(10648, new Object[]{Integer.valueOf(0), Integer.valueOf(0)});
    }
}
