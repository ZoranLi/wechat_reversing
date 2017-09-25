package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.map.c;
import com.tencent.mm.ui.widget.h;
import java.lang.ref.WeakReference;

public abstract class b<Input extends EditText & y> extends h implements x {
    public z jsn;
    final String jso;
    public final WeakReference<m> jsp;
    public final OnFocusChangeListener jsq = new OnFocusChangeListener(this) {
        final /* synthetic */ b jss;

        {
            this.jss = r1;
        }

        public final void onFocusChange(View view, boolean z) {
            this.jss.cr(z);
            if (z) {
                m.a((m) this.jss.jsp.get(), (y) this.jss.Yj());
                ((y) this.jss.Yj()).rp(this.jss.Yi());
                m.a(this.jss.Yi(), this.jss);
            }
        }
    };
    private final com.tencent.mm.ui.tools.a.c.a jsr = new a(this) {
        final /* synthetic */ b jss;

        {
            this.jss = r1;
        }

        public final void Yp() {
            if (this.jss.Yj() != null) {
                this.jss.b(this.jss.Yj().getEditableText());
            }
        }
    };

    enum a {
        ;

        public static b a(String str, m mVar) {
            if ("digit".equalsIgnoreCase(str) || "idcard".equalsIgnoreCase(str) || "number".equalsIgnoreCase(str)) {
                return new c(str, mVar);
            }
            return null;
        }
    }

    public abstract String Yi();

    public abstract Input Yj();

    public abstract Rect Yk();

    protected abstract com.tencent.mm.plugin.appbrand.widget.input.a.h b(com.tencent.mm.plugin.appbrand.widget.input.a.h hVar);

    protected abstract boolean cr(boolean z);

    public abstract boolean iK(int i);

    public abstract boolean rk(String str);

    b(String str, m mVar) {
        this.jso = str;
        this.jsp = new WeakReference(mVar);
    }

    public final boolean Yl() {
        return Yn();
    }

    public final Input Ym() {
        return Yj();
    }

    public final boolean Yn() {
        View Yj = Yj();
        if (Yj == null) {
            return false;
        }
        ((y) Yj).b(this.jsq);
        Yj.removeTextChangedListener(this);
        ((y) Yj).destroy();
        m mVar = (m) this.jsp.get();
        if (mVar == null) {
            return false;
        }
        e eVar = mVar.jdd;
        if (eVar == null) {
            return false;
        }
        eVar.bM(Yj);
        return true;
    }

    public final boolean f(m mVar) {
        return mVar != null && mVar == this.jsp.get();
    }

    final void a(Editable editable) {
        if (this.jsn != null) {
            this.jsn.a(editable == null ? "" : editable.toString(), Selection.getSelectionEnd(editable), com.tencent.mm.plugin.appbrand.widget.input.z.a.COMPLETE);
        }
    }

    public final void afterTextChanged(Editable editable) {
        b(editable);
    }

    public final void b(Editable editable) {
        if (this.jsn != null) {
            this.jsn.a(editable == null ? "" : editable.toString(), Selection.getSelectionEnd(editable), com.tencent.mm.plugin.appbrand.widget.input.z.a.CHANGED);
        }
    }

    public final boolean a(com.tencent.mm.plugin.appbrand.widget.input.a.h hVar) {
        com.tencent.mm.plugin.appbrand.widget.input.a.h b = b(hVar);
        if (b == null) {
            return false;
        }
        if (b.jxk == null) {
            b.jxk = Integer.valueOf(c.CTRL_INDEX);
        } else if (b.jxk.intValue() <= 0) {
            b.jxk = Integer.valueOf(Integer.MAX_VALUE);
        }
        if (Yj() == null) {
            return false;
        }
        com.tencent.mm.ui.tools.a.c Ch = n.a(Yj()).Ch(b.jxk.intValue());
        Ch.wpp = false;
        Ch.jtV = com.tencent.mm.ui.tools.h.a.wmF;
        Ch.a(this.jsr);
        return true;
    }

    public final void b(String str, Integer num) {
        rk(str);
        iL(num == null ? -1 : num.intValue());
    }

    public final Editable Yo() {
        return Yj() == null ? null : Yj().getEditableText();
    }

    protected final void iL(int i) {
        if (i > -2 && Yj() != null) {
            if (-1 == i) {
                i = Yj().getEditableText().length();
            }
            Yj().setSelection(i);
        }
    }
}
