package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.k;
import android.util.AttributeSet;
import com.tencent.mm.R;
import com.tencent.mm.plugin.chatroom.a.a;
import com.tencent.mm.plugin.chatroom.a.b;
import java.util.Collection;

public class DayPickerView extends RecyclerView {
    private TypedArray ksA;
    private a ksB;
    protected b kub;
    protected int kuc;
    protected long kud;
    protected int kue;
    private k kuf;
    private Collection<com.tencent.mm.plugin.chatroom.d.a> kug;
    long kuh;
    protected Context mContext;

    public DayPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DayPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kuc = 0;
        this.kue = 0;
        this.kuh = -1;
        if (!isInEditMode()) {
            this.ksA = context.obtainStyledAttributes(attributeSet, R.n.fpr);
            setLayoutParams(new LayoutParams(-1, -1));
            a(new LinearLayoutManager());
            this.mContext = context;
            setVerticalScrollBarEnabled(false);
            this.ZM = this.kuf;
            setFadingEdgeLength(0);
            this.kuf = new k(this) {
                final /* synthetic */ DayPickerView kui;

                {
                    this.kui = r1;
                }

                public final void c(RecyclerView recyclerView, int i, int i2) {
                    super.c(recyclerView, i, i2);
                    if (((b) recyclerView.getChildAt(0)) != null) {
                        this.kui.kud = (long) i2;
                        this.kui.kue = this.kui.kuc;
                    }
                }
            };
        }
    }

    public final void a(a aVar, Collection<com.tencent.mm.plugin.chatroom.d.a> collection) {
        this.kug = collection;
        this.ksB = aVar;
        if (this.kub == null) {
            this.kub = new b(getContext(), this.ksB, this.ksA, this.kuh, collection);
        }
        a(this.kub);
        aX(this.kub.getItemCount() - 1);
        this.kub.aab.notifyChanged();
    }
}
