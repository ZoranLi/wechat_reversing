package com.tencent.mm.ui.tools.a;

import android.text.InputFilter;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.tools.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class c extends a {
    private String jqT;
    public int jtV;
    public boolean wpp = true;
    public WeakReference<EditText> wpq;
    private int wpr;
    private int wps;
    private ArrayList<InputFilter> wpt;
    public a wpu;

    public interface a {
        void YN();

        void Yp();

        void ro(String str);
    }

    public c(WeakReference<EditText> weakReference) {
        this.wpq = weakReference;
        this.jtV = com.tencent.mm.ui.tools.h.a.wmG;
        this.wpp = false;
    }

    public static c d(EditText editText) {
        return new c(new WeakReference(editText));
    }

    public final c em(int i, int i2) {
        this.wps = i;
        this.wpr = i2;
        return this;
    }

    public final c Ch(int i) {
        this.wps = 0;
        this.wpr = i;
        return this;
    }

    public final void a(a aVar) {
        this.wpu = aVar;
        bGm();
    }

    protected final int Ve() {
        Object obj;
        if (bg.mA(this.jqT)) {
            if (this.wpq == null) {
                return 1;
            }
            this.jqT = ((EditText) this.wpq.get()).getText().toString().trim();
        }
        int cY = h.cY(this.jqT, this.jtV);
        if (cY < 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            w.w("MicroMsg.InputTextBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
            return 2;
        } else if (cY < this.wps) {
            return 1;
        } else {
            if (cY > this.wpr) {
                return 2;
            }
            return 0;
        }
    }

    protected final void bGm() {
        if (!this.wpp) {
            if (this.wpq == null) {
                w.w("MicroMsg.InputTextBoundaryCheck", "edit text view is null");
                return;
            } else if (bg.bV(this.wpt)) {
                ((EditText) this.wpq.get()).setFilters(new InputFilter[]{bz(this.wpr, this.jtV)});
            } else {
                this.wpt.add(bz(this.wpr, this.jtV));
                ((EditText) this.wpq.get()).setFilters((InputFilter[]) this.wpt.toArray(new InputFilter[this.wpt.size()]));
            }
        }
        if (this.wpu != null) {
            switch (Ve()) {
                case 0:
                    this.wpu.ro(this.jqT);
                    return;
                case 1:
                    this.wpu.YN();
                    return;
                case 2:
                    this.wpu.Yp();
                    return;
                default:
                    return;
            }
        }
    }

    public h bz(int i, int i2) {
        return new h(i, i2);
    }
}
