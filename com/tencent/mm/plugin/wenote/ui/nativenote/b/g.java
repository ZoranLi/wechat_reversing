package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.text.Layout;
import android.text.Spanned;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.a;
import com.tencent.mm.plugin.wenote.model.a.e;
import com.tencent.mm.plugin.wenote.model.nativenote.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.ArrayList;

public final class g extends a {
    public WXRTEditText syW;

    public g(View view, final k kVar) {
        super(view, kVar);
        this.syW = (WXRTEditText) view.findViewById(R.h.czw);
        if (kVar.swv) {
            this.syW.setKeyListener(null);
            this.syW.setFocusable(false);
            this.syW.setClickable(true);
        }
        this.syW.swc = this;
        this.syW.swa = 0;
        this.sxO.i(this.syW);
        this.syW.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ g syY;

            public final void onGlobalLayout() {
                ap.vL().D(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 syZ;

                    {
                        this.syZ = r1;
                    }

                    public final void run() {
                        int i = 0;
                        if (!this.syZ.syY.syW.hasFocus()) {
                            k kVar = kVar;
                            WXRTEditText wXRTEditText = this.syZ.syY.syW;
                            if (k.swA < 0) {
                                k.swA = kVar.swz / wXRTEditText.getLineHeight();
                            }
                            if (wXRTEditText != null && wXRTEditText.swa == 0) {
                                int lineCount = wXRTEditText.getLineCount();
                                if (lineCount > k.swA) {
                                    Layout layout = wXRTEditText.getLayout();
                                    if (layout != null) {
                                        int bBN = wXRTEditText.bBN();
                                        a wS = c.bBv().wS(bBN);
                                        if (wS != null && wS.getType() == 1) {
                                            e eVar = (e) wS;
                                            String str = eVar.content;
                                            if (!bg.mA(str)) {
                                                Spanned Lq = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Lq(str);
                                                if (!bg.J(Lq)) {
                                                    try {
                                                        ArrayList arrayList = new ArrayList();
                                                        int i2 = k.swA - 2;
                                                        int length = i2 >= lineCount ? Lq.length() : layout.getLineStart(i2);
                                                        int i3 = i2;
                                                        int i4 = 0;
                                                        while (i4 < Lq.length()) {
                                                            arrayList.add(b.a((Spanned) Lq.subSequence(i4, length < Lq.length() ? length : Lq.length())));
                                                            i3 += i2;
                                                            i4 = length;
                                                            length = i3 >= lineCount ? Lq.length() : layout.getLineStart(i3);
                                                        }
                                                        if (arrayList.size() > 1) {
                                                            for (length = 0; length < arrayList.size() - 1; length++) {
                                                                String str2 = (String) arrayList.get(length);
                                                                if (bg.mA(str2) || !str2.endsWith("<br/>")) {
                                                                    i3 = 0;
                                                                } else {
                                                                    arrayList.set(length, str2.substring(0, str2.length() - 5));
                                                                    i3 = 1;
                                                                }
                                                                str2 = (String) arrayList.get(length + 1);
                                                                if (i3 == 0 && !bg.mA(str2) && str2.startsWith("<br/>")) {
                                                                    arrayList.set(length + 1, str2.substring(5, str2.length()));
                                                                }
                                                            }
                                                            while (i < arrayList.size()) {
                                                                if (i == 0) {
                                                                    eVar.content = (String) arrayList.get(i);
                                                                } else {
                                                                    a eVar2 = new e();
                                                                    eVar2.content = (String) arrayList.get(i);
                                                                    eVar2.sut = false;
                                                                    eVar2.suz = false;
                                                                    c.bBv().a(bBN + i, eVar2, false);
                                                                }
                                                                i++;
                                                            }
                                                            kVar.swt.dz(bBN + 1, arrayList.size() - 1);
                                                            kVar.swt.dA(bBN, c.bBv().size() - bBN);
                                                        }
                                                    } catch (Exception e) {
                                                        if (!eVar.content.equals(str)) {
                                                            eVar.content = str;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
            }
        });
    }

    public final void a(a aVar, int i, int i2) {
        final e eVar = (e) aVar;
        eVar.suy = this.syW;
        eVar.suw = null;
        eVar.sux = null;
        a wS = c.bBv().wS(i - 1);
        if (wS != null && wS.getType() == 1) {
            LayoutParams layoutParams = (LayoutParams) this.syW.getLayoutParams();
            layoutParams.topMargin = 0;
            this.syW.setLayoutParams(layoutParams);
        }
        wS = c.bBv().wS(i + 1);
        if (wS != null && wS.getType() == 1) {
            layoutParams = (LayoutParams) this.syW.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.syW.setLayoutParams(layoutParams);
        }
        af.v(new Runnable(this) {
            final /* synthetic */ g syY;

            public final void run() {
                this.syY.syW.Ls(eVar.content);
                this.syY.syW.bBO();
                h.i(this.syY.syW);
                this.syY.syW.bBP();
                if (eVar.sut) {
                    if (eVar.suv == -1 || eVar.suv >= this.syY.syW.getText().toString().length()) {
                        this.syY.syW.setSelection(this.syY.syW.getText().toString().length());
                    } else {
                        this.syY.syW.setSelection(eVar.suv);
                    }
                    this.syY.syW.requestFocus();
                } else if (this.syY.syW.hasFocus()) {
                    this.syY.syW.clearFocus();
                }
                if (eVar.suB) {
                    eVar.suB = false;
                    this.syY.syW.suB = true;
                    this.syY.syW.onTextContextMenuItem(16908322);
                }
            }
        });
        w.i("MicroMsg.NoteTextItemHolder", "TextItemHolder position is " + ge());
    }

    public final int bCe() {
        return 1;
    }
}
