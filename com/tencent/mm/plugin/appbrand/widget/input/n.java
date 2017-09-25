package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Spanned;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.tools.h;
import java.lang.ref.WeakReference;

final class n extends c {

    static abstract class a implements com.tencent.mm.ui.tools.a.c.a {
        a() {
        }

        public final void ro(String str) {
        }

        public final void YN() {
        }

        public void Yp() {
        }
    }

    private final class b extends h {
        private final int jtU;
        private final int jtV;
        final /* synthetic */ n jtW;

        b(n nVar, int i, int i2) {
            this.jtW = nVar;
            super(i, i2);
            this.jtU = i;
            this.jtV = i2;
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int i5 = 0;
            if (cY(spanned.subSequence(0, i3).toString() + spanned.subSequence(i4, spanned.length()).toString(), this.jtV) + cY(charSequence.subSequence(i, i2).toString(), this.jtV) > this.jtU) {
                i5 = 1;
            }
            if (i5 != 0) {
                charSequence = charSequence.subSequence(i, Math.max(i, Math.min(this.jtU - (spanned.length() - (i4 - i3)), i2)));
            }
            if (i5 != 0 && bg.J(charSequence)) {
                EditText editText = this.jtW.wpq == null ? null : (EditText) this.jtW.wpq.get();
                final com.tencent.mm.ui.tools.a.c.a aVar = this.jtW.wpu;
                if (!(editText == null || aVar == null)) {
                    editText.post(new Runnable(this) {
                        final /* synthetic */ b jtY;

                        public final void run() {
                            aVar.Yp();
                        }
                    });
                }
            }
            return charSequence;
        }
    }

    private n(WeakReference<EditText> weakReference) {
        super(weakReference);
    }

    public static n a(EditText editText) {
        return new n(new WeakReference(editText));
    }

    protected final h bz(int i, int i2) {
        return new b(this, i, i2);
    }
}
