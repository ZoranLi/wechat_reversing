package com.tencent.mm.plugin.sight.encode.ui;

import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class d implements TextWatcher, OnClickListener, OnFocusChangeListener, j {
    private ae handler = new ae(Looper.getMainLooper());
    public TextView pxA;
    public View pxB;
    private com.tencent.mm.plugin.fts.a.a.a pxC;
    public InputMethodManager pxD;
    public int pxE = b.pxH;
    public a pxF;
    public EditText pxz;

    public interface a {
        void bcT();

        void bcU();

        void bn(List<String> list);
    }

    public enum b {
        ;

        static {
            pxG = 1;
            pxH = 2;
            pxI = new int[]{pxG, pxH};
        }
    }

    public final boolean bcQ() {
        return this.pxE == b.pxG;
    }

    public final void onFocusChange(View view, boolean z) {
        if (!z) {
            this.pxz.clearFocus();
            bg.cX(this.pxz);
        }
    }

    public final void onClick(View view) {
        if (view.getId() == R.h.cAm && bcQ()) {
            bcR();
        }
    }

    public final void bcR() {
        if (bcQ()) {
            bcS();
        } else if (!bcQ()) {
            this.pxE = b.pxG;
            this.pxB.setVisibility(0);
            if (this.pxF != null) {
                this.pxF.bcT();
            }
            this.pxz.requestFocus();
            this.pxD.showSoftInput(this.pxz, 0);
        }
    }

    public final void bcS() {
        if (bcQ()) {
            this.pxz.setText("");
            this.pxz.clearFocus();
            bg.cX(this.pxz);
            this.pxE = b.pxH;
            this.pxB.setVisibility(8);
            if (this.pxF != null) {
                this.pxF.bcU();
            }
        }
    }

    public final void a(g gVar) {
        if (gVar.aMA == 0 && gVar.maj != null && this.pxF != null) {
            List arrayList = new ArrayList();
            for (i iVar : gVar.maj) {
                arrayList.add(iVar.lZO);
            }
            this.pxF.bn(arrayList);
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (!bg.mA(editable.toString())) {
            w.i("MicroMsg.MainSightSelectContactSearchHelper", "doSearch: query=%s", new Object[]{editable.toString()});
            if (this.pxC != null) {
                ((l) h.j(l.class)).cancelSearchTask(this.pxC);
                this.pxC = null;
            }
            this.pxC = ((l) h.j(l.class)).search(2, f.a(r0, new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075}, null, 3, new HashSet(), com.tencent.mm.plugin.fts.a.b.b.maC, this, this.handler));
        }
    }
}
