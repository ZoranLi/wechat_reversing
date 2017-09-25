package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.a.f.a;

public final class g extends f {
    private int kIo = 0;
    private int kIp = 0;
    private int kIq = 0;

    public final /* synthetic */ Object getItem(int i) {
        return super.lj(i);
    }

    public g(Context context) {
        super(context);
    }

    public final int getCount() {
        return super.getCount();
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        final a aVar = (a) view.getTag();
        if (this.kIo > 0) {
            if (i == 0) {
                aVar.kHM.setVisibility(0);
                aVar.kHM.setText(this.mContext.getString(R.l.edm));
            } else if (this.kIp > 0 && i == this.kIo) {
                aVar.kHM.setVisibility(0);
                aVar.kHM.setText(this.mContext.getString(R.l.edx));
            } else if (i == this.kIo + this.kIp) {
                aVar.kHM.setVisibility(0);
                aVar.kHM.setText(this.mContext.getString(R.l.edb));
            } else {
                aVar.kHM.setVisibility(8);
            }
        } else if (this.kIp > 0) {
            if (i == 0) {
                aVar.kHM.setVisibility(0);
                aVar.kHM.setText(this.mContext.getString(R.l.edx));
            } else if (i == this.kIo + this.kIp) {
                aVar.kHM.setVisibility(0);
                aVar.kHM.setText(this.mContext.getString(R.l.edb));
            } else {
                aVar.kHM.setVisibility(8);
            }
        }
        if (aVar.kHO != null) {
            aVar.kHO.postDelayed(new Runnable(this) {
                final /* synthetic */ g kIs;

                public final void run() {
                    aVar.kHO.setPressed(false);
                }
            }, 100);
        }
        return super.b(i, view, viewGroup);
    }

    public final f lj(int i) {
        return super.lj(i);
    }

    public final int alm() {
        return this.kIo;
    }

    public final void lg(int i) {
        this.kIo = i;
    }

    public final int aln() {
        return this.kIp;
    }

    public final void lh(int i) {
        this.kIp = i;
    }

    public final int alo() {
        return this.kIq;
    }

    public final void li(int i) {
        this.kIq = i;
    }
}
