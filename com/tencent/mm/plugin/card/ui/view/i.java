package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import com.tencent.mm.plugin.card.ui.m;

public abstract class i {
    m kqe;

    public abstract void KC();

    public final void a(m mVar) {
        this.kqe = mVar;
        KC();
    }

    public void destroy() {
        this.kqe = null;
    }

    public void update() {
    }

    public void aiz() {
    }

    protected final View findViewById(int i) {
        return this.kqe.findViewById(i);
    }

    protected final String getString(int i) {
        return this.kqe.getString(i);
    }
}
