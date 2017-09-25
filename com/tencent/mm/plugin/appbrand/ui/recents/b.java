package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class b {
    View abf;
    ThreeDotsLoadingView jmH = ((ThreeDotsLoadingView) this.abf.findViewById(R.h.cbU));
    View jmI = this.abf.findViewById(R.h.bQX);
    View jmJ = this.abf.findViewById(R.h.bMg);

    final void setLoading(boolean z) {
        if (z) {
            if (this.jmH != null) {
                this.jmH.setVisibility(0);
                this.jmH.caQ();
            }
            if (this.jmJ != null) {
                this.jmJ.setVisibility(8);
                return;
            }
            return;
        }
        if (this.jmH != null) {
            this.jmH.Wd();
            this.jmH.setVisibility(8);
        }
        if (this.jmJ != null) {
            this.jmJ.setVisibility(0);
        }
    }

    b(Context context, ViewGroup viewGroup) {
        this.abf = LayoutInflater.from(context).inflate(R.i.cUm, viewGroup, false);
    }
}
