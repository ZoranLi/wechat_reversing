package android.support.v7.view;

import android.support.v4.view.ai;
import android.support.v4.view.am;
import android.support.v4.view.an;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public final class h {
    public am Pr;
    boolean Ps;
    private final an Pt = new an(this) {
        private boolean Pu = false;
        private int Pv = 0;
        final /* synthetic */ h Pw;

        {
            this.Pw = r2;
        }

        public final void p(View view) {
            if (!this.Pu) {
                this.Pu = true;
                if (this.Pw.Pr != null) {
                    this.Pw.Pr.p(null);
                }
            }
        }

        public final void q(View view) {
            int i = this.Pv + 1;
            this.Pv = i;
            if (i == this.Pw.mc.size()) {
                if (this.Pw.Pr != null) {
                    this.Pw.Pr.q(null);
                }
                this.Pv = 0;
                this.Pu = false;
                this.Pw.Ps = false;
            }
        }
    };
    private long mDuration = -1;
    private Interpolator mInterpolator;
    public final ArrayList<ai> mc = new ArrayList();

    public final h a(ai aiVar) {
        if (!this.Ps) {
            this.mc.add(aiVar);
        }
        return this;
    }

    public final h a(ai aiVar, ai aiVar2) {
        this.mc.add(aiVar);
        View view = (View) aiVar.zv.get();
        aiVar2.d(view != null ? ai.zz.ar(view) : 0);
        this.mc.add(aiVar2);
        return this;
    }

    public final void start() {
        if (!this.Ps) {
            Iterator it = this.mc.iterator();
            while (it.hasNext()) {
                ai aiVar = (ai) it.next();
                if (this.mDuration >= 0) {
                    aiVar.c(this.mDuration);
                }
                if (this.mInterpolator != null) {
                    aiVar.b(this.mInterpolator);
                }
                if (this.Pr != null) {
                    aiVar.a(this.Pt);
                }
                aiVar.start();
            }
            this.Ps = true;
        }
    }

    public final void cancel() {
        if (this.Ps) {
            Iterator it = this.mc.iterator();
            while (it.hasNext()) {
                ((ai) it.next()).cancel();
            }
            this.Ps = false;
        }
    }

    public final h dk() {
        if (!this.Ps) {
            this.mDuration = 250;
        }
        return this;
    }

    public final h c(Interpolator interpolator) {
        if (!this.Ps) {
            this.mInterpolator = interpolator;
        }
        return this;
    }

    public final h b(am amVar) {
        if (!this.Ps) {
            this.Pr = amVar;
        }
        return this;
    }
}
