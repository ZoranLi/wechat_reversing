package com.tencent.mm.plugin.emoji.ui.smiley;

import android.content.Context;
import android.widget.BaseAdapter;

public abstract class a extends BaseAdapter {
    public int jZR;
    public f kTj;
    public int kTk;
    public int kTl;
    public int kTm;
    public int kTn;
    public String kTo;
    public int kTp;
    public int kTq;
    public Context mContext;

    public a(Context context, f fVar) {
        this.mContext = context;
        this.kTj = fVar;
    }

    public final void b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.kTk = i;
        this.jZR = i2;
        this.kTl = i3;
        this.kTm = i4;
        this.kTn = i5;
        this.kTp = i6;
        this.kTq = i7;
    }
}
