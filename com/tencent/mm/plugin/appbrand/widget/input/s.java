package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ab;

final class s implements com.tencent.mm.plugin.appbrand.widget.c.a {
    private int juj = 0;
    private final Rect juk = new Rect();
    private boolean jul = false;
    private View jum;
    a jun;

    interface a {
        void cy(boolean z);

        int getHeight();

        void iO(int i);
    }

    s() {
    }

    private void getWindowVisibleDisplayFrame(Rect rect) {
        if (this.jum != null) {
            this.jum.getWindowVisibleDisplayFrame(rect);
        }
    }

    private Context getContext() {
        return this.jum == null ? ab.getContext() : this.jum.getContext();
    }

    private int YT() {
        if ((this.jum == null ? null : this.jum.getRootView()) == null) {
            return 0;
        }
        Rect rect = this.juk;
        getWindowVisibleDisplayFrame(rect);
        return getContext().getResources().getDisplayMetrics().heightPixels - rect.top;
    }

    public final void bQ(View view) {
        boolean o;
        Object obj = 1;
        this.jum = view;
        Rect rect = this.juk;
        getWindowVisibleDisplayFrame(rect);
        int height = rect.height();
        if (this.juj == 0) {
            this.juj = height;
        } else {
            int YT = YT() - height;
            if (YT > 0) {
                if (j.aD(getContext()) != YT) {
                    o = j.o(getContext(), YT);
                } else {
                    o = false;
                }
                if (!(!o || this.jun == null || this.jun.getHeight() == YT)) {
                    this.jun.iO(YT);
                }
            }
        }
        if (YT() > height) {
            o = true;
        } else {
            o = false;
        }
        if (this.jul == o) {
            obj = null;
        }
        if (!(obj == null || this.jun == null)) {
            this.jun.cy(o);
        }
        this.jul = o;
        this.juj = height;
        this.jum = null;
    }
}
