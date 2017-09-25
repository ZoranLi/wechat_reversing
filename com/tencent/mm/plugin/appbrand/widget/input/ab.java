package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.view.z;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.g.p;
import com.tencent.mm.plugin.appbrand.g.r;

public final class ab {
    public final r jde;
    public boolean jvA = false;
    public final a<r, e> jvB = new a<r, e>(this) {
        final /* synthetic */ ab jvD;

        {
            this.jvD = r1;
        }

        final /* synthetic */ View bW(View view) {
            return (e) view.findViewById(R.h.bpl);
        }

        final boolean bV(View view) {
            return view.getId() == R.h.bpk;
        }
    };
    public final a<r, p> jvC = new a<r, p>(this) {
        final /* synthetic */ ab jvD;

        {
            this.jvD = r1;
        }

        final /* bridge */ /* synthetic */ View bW(View view) {
            return (p) view;
        }

        final boolean bV(View view) {
            return view instanceof p;
        }
    };
    public boolean jvy = false;
    public boolean jvz = false;

    private static abstract class a<Source extends View, Target extends View> {
        private Target nw;

        abstract boolean bV(View view);

        abstract Target bW(View view);

        public final Target bX(Source source) {
            if (this.nw != null && z.al(this.nw)) {
                return this.nw;
            }
            if (!z.al(source)) {
                return null;
            }
            while (true) {
                View view = (View) source.getParent();
                if (view != null && !bV(view)) {
                    source = view;
                } else if (view == null) {
                    return null;
                } else {
                    Target bW = bW(view);
                    this.nw = bW;
                    return bW;
                }
            }
            if (view == null) {
                return null;
            }
            Target bW2 = bW(view);
            this.nw = bW2;
            return bW2;
        }
    }

    public ab(r rVar) {
        this.jde = rVar;
    }
}
