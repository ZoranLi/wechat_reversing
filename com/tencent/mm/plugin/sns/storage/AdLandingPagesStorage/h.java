package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.ui.al;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public final class h {
    private int bgColor;
    private Context context;
    private int jYp;
    private int jYq;
    private ViewGroup oDu;
    private LinkedHashMap<String, i> qlx;
    private LayoutInflater qly;
    private List<p> qnc;

    public h(List<p> list, Context context, int i, ViewGroup viewGroup) {
        this.qnc = list;
        this.context = context;
        this.bgColor = i;
        this.oDu = viewGroup;
    }

    public final void bt(List<p> list) {
        if (list != null && !list.equals(this.qnc)) {
            this.qnc = list;
            layout();
        }
    }

    public final void layout() {
        if (this.qnc != null && !this.qnc.isEmpty()) {
            if (this.qlx == null) {
                this.qlx = new LinkedHashMap();
            }
            if (this.qly == null) {
                this.qly = (LayoutInflater) this.context.getSystemService("layout_inflater");
                WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
                this.jYp = windowManager.getDefaultDisplay().getWidth();
                this.jYq = windowManager.getDefaultDisplay().getHeight();
            }
            for (int i = 0; i < this.qnc.size(); i++) {
                p pVar = (p) this.qnc.get(i);
                i iVar = (i) this.qlx.get(pVar.qfI);
                if (iVar != null) {
                    iVar.a(pVar);
                } else {
                    iVar = al.a(this.context, pVar, this.oDu, this.bgColor);
                    if (iVar != null) {
                        this.qlx.put(pVar.qfI, iVar);
                    }
                }
                try {
                    if (this.oDu != iVar.getView().getParent()) {
                        if (this.oDu.getChildCount() > i) {
                            this.oDu.addView(iVar.getView(), i);
                        } else {
                            this.oDu.addView(iVar.getView());
                        }
                    }
                } catch (Throwable e) {
                    w.e("CompRenderer", "component may have same id %s,%s", new Object[]{pVar.qfI, bg.g(e)});
                }
            }
        }
    }

    public final Collection<i> bgQ() {
        return this.qlx == null ? Collections.EMPTY_LIST : this.qlx.values();
    }
}
