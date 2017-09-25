package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.database.DataSetObserver;
import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Filter.FilterListener;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.plugin.appbrand.ui.g;
import com.tencent.mm.plugin.appbrand.widget.input.y;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.widget.h;

public final class b {
    public final y jvV;
    public final e jvW;
    private final FilterListener jvX;
    public final c jvY;
    final a jvZ;
    int jwa = f.jwy;
    public a jwb;
    private int jwc;
    private int jwd;

    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] jwg = new int[f.Zx().length];

        static {
            try {
                jwg[f.jwx - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jwg[f.jwy - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static class a implements h {
        public h jwh;

        public void a(String str, com.tencent.mm.plugin.appbrand.widget.input.autofill.h.a aVar) {
            if (this.jwh != null) {
                this.jwh.a(str, aVar);
            }
        }
    }

    public b(y yVar) {
        this.jvV = yVar;
        this.jvW = new e(yVar.getContext());
        this.jvY = new c(yVar, this.jvW);
        this.jvV.a(new com.tencent.mm.plugin.appbrand.widget.input.y.a(this) {
            final /* synthetic */ b jwe;

            {
                this.jwe = r1;
            }

            public final void Zq() {
                this.jwe.Zu();
            }
        });
        this.jvV.a(new com.tencent.mm.plugin.appbrand.widget.input.y.b(this) {
            final /* synthetic */ b jwe;

            {
                this.jwe = r1;
            }

            public final void YS() {
                this.jwe.Zu();
            }
        });
        this.jvV.a(new OnFocusChangeListener(this) {
            final /* synthetic */ b jwe;

            {
                this.jwe = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    this.jwe.Zv();
                    return;
                }
                b bVar = this.jwe;
                if (bVar.jvW.iuS.isShowing()) {
                    g gVar = (g) bVar.jvW.jwq.getAdapter();
                    bVar.jvW.dismiss();
                    gVar.Zt();
                }
            }
        });
        this.jvV.addTextChangedListener(new h(this) {
            final /* synthetic */ b jwe;
            private boolean jwf = false;

            {
                this.jwe = r2;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.jwf = this.jwe.jvW.iuS.isShowing();
            }

            public final void afterTextChanged(Editable editable) {
                if (!this.jwf || this.jwe.jvW.iuS.isShowing()) {
                    if (!this.jwe.jvW.iuS.isShowing()) {
                        this.jwe.Zv();
                    }
                    this.jwe.t(editable);
                }
            }
        });
        this.jvX = new FilterListener(this) {
            final /* synthetic */ b jwe;

            {
                this.jwe = r1;
            }

            public final void onFilterComplete(int i) {
                if (i <= 0) {
                    this.jwe.jvW.dismiss();
                } else if (this.jwe.jvW.iuS.isShowing()) {
                    this.jwe.jvW.show();
                }
            }
        };
        this.jvZ = new a(this) {
            final /* synthetic */ b jwe;

            {
                this.jwe = r1;
            }

            public final void a(String str, com.tencent.mm.plugin.appbrand.widget.input.autofill.h.a aVar) {
                if (aVar == com.tencent.mm.plugin.appbrand.widget.input.autofill.h.a.DELETE) {
                    this.jwe.t(this.jwe.jvV.getText());
                }
                super.a(str, aVar);
            }
        };
    }

    public final void t(CharSequence charSequence) {
        if (this.jwb != null) {
            this.jwb.getFilter().filter(charSequence, this.jvX);
        }
    }

    public final void Zu() {
        switch (AnonymousClass7.jwg[this.jwa - 1]) {
            case 1:
                this.jvW.Vf = g.Xf()[0];
                break;
            case 2:
                this.jvW.Vf = this.jvV.getView().getMeasuredWidth();
                break;
        }
        if (this.jwc != 0) {
            this.jvW.XX = this.jwc;
            this.jvW.Vf -= this.jwc;
        }
        if (this.jwd != 0) {
            this.jvW.Vf -= this.jwd;
        }
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.jvW.iuS.setOnDismissListener(onDismissListener);
    }

    final void Zv() {
        if (this.jwb != null) {
            CharSequence text = this.jvV.getText();
            if (!bg.J(text)) {
                t(text);
            }
            this.jvW.Yg = this.jvV.getView();
            this.jvW.show();
            ((g) this.jvW.jwq.getAdapter()).a(this);
            c cVar = this.jvY;
            cVar.iX(2);
            cVar.jwk = Integer.MIN_VALUE;
            if (!bg.J(text)) {
                cVar.jwl = true;
            }
            ListView listView = cVar.jvW.jwq;
            if (listView != null) {
                listView.getAdapter().registerDataSetObserver(new DataSetObserver(cVar) {
                    final /* synthetic */ c jwm;

                    {
                        this.jwm = r1;
                    }

                    public final void onChanged() {
                        if (this.jwm.jvW.iuS.isShowing()) {
                            this.jwm.iX(1);
                        }
                    }
                });
            }
        }
    }
}
