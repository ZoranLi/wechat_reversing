package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends LinearLayoutManager {
    private final int syB = j.c(ab.getContext(), true);
    private boolean syC = false;
    public int syD = -1;

    public a(Context context) {
    }

    public final int b(int i, m mVar, q qVar) {
        try {
            return super.b(i, mVar, qVar);
        } catch (Exception e) {
            return 0;
        }
    }

    protected final int a(q qVar) {
        if (this.syD > 0) {
            return this.syD;
        }
        return 900;
    }

    public final void c(m mVar, q qVar) {
        try {
            super.c(mVar, qVar);
        } catch (IndexOutOfBoundsException e) {
        }
    }
}
