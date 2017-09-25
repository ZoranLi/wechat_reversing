package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.pluginsdk.ui.applet.g.AnonymousClass3;
import com.tencent.mm.pluginsdk.ui.applet.g.AnonymousClass4;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.List;

public class ContactListExpandPreference extends Preference {
    private int sNj = -1;
    public e sNk;
    public g sNl;

    public interface a {
        void ajs();

        void kK(int i);

        void kL(int i);

        void kM(int i);
    }

    public ContactListExpandPreference(Context context, int i) {
        super(context);
        if (i == 0) {
            bEZ();
        } else if (i == 1) {
            this.sNj = 1;
            this.sNl = new g();
        }
        setLayoutResource(e.kDI);
    }

    public ContactListExpandPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bEZ();
        setLayoutResource(e.kDI);
    }

    public ContactListExpandPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bEZ();
        setLayoutResource(e.kDI);
    }

    private void bEZ() {
        this.sNj = 0;
        this.sNk = new e(this.mContext);
    }

    public final void onBindView(View view) {
        if (this.sNj == 1) {
            g gVar = this.sNl;
            ViewGroup viewGroup = view.getId() == d.kDC ? (ViewGroup) view : (ViewGroup) view.findViewById(d.kDC);
            if (gVar.row == 0) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getResources().getDimensionPixelSize(b.aXw), viewGroup.getPaddingRight(), viewGroup.getResources().getDimensionPixelSize(b.aXz));
            } else if (gVar.row == (gVar.sMx.getCount() / f.sMH) - 1) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getResources().getDimensionPixelSize(b.aXw));
            } else {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getResources().getDimensionPixelSize(b.aXz), viewGroup.getPaddingRight(), viewGroup.getResources().getDimensionPixelSize(b.aXz));
            }
            if ((gVar.sMx.sMQ % f.sMH == f.sMH - 1 || gVar.sMx.sMQ % f.sMH == 0) && gVar.kto && gVar.row == (gVar.sMx.getCount() / f.sMH) - 1) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), 0);
            } else if (!gVar.kto && gVar.sMx.sMQ % f.sMH == 0 && gVar.row == (gVar.sMx.getCount() / f.sMH) - 1) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), (int) viewGroup.getContext().getResources().getDimension(b.aXR));
            }
            if (gVar.sMx != null) {
                int i;
                viewGroup.setOnClickListener(gVar.oPX);
                if (viewGroup.getChildCount() > f.sMH) {
                    int childCount = viewGroup.getChildCount();
                    for (i = 0; i < childCount - f.sMH; i++) {
                        viewGroup.removeViewAt(i);
                    }
                    viewGroup.requestLayout();
                }
                for (i = 0; i < gVar.sNm; i++) {
                    View inflate;
                    int dimensionPixelSize;
                    if (viewGroup.getChildAt(i) == null) {
                        inflate = View.inflate(viewGroup.getContext(), e.dmK, null);
                        viewGroup.addView(inflate);
                    } else {
                        inflate = viewGroup.getChildAt(i);
                    }
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    if (f.sMH == 4) {
                        dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(b.aXH);
                        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    } else {
                        dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(b.aXz);
                        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    }
                    if (!gVar.sMx.bEX() && gVar.sMx.sMQ == 1) {
                        dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(b.aWG);
                        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    }
                    inflate.setLayoutParams(layoutParams);
                    int i2 = (gVar.row * gVar.sNm) + i;
                    gVar.sMx.getView(i2, inflate, viewGroup);
                    if (gVar.sMD != null) {
                        inflate.setOnClickListener(new AnonymousClass3(gVar, viewGroup, i2));
                    }
                    if (gVar.sNn != null) {
                        inflate.setOnLongClickListener(new AnonymousClass4(gVar, viewGroup, i2));
                    }
                }
                if (gVar.sMx.bEX() || gVar.sMx.sMQ > 1) {
                    ((LinearLayout) viewGroup).setGravity(17);
                } else {
                    ((LinearLayout) viewGroup).setGravity(19);
                }
            }
        }
        super.onBindView(view);
    }

    public final void a(f fVar, String str) {
        if (this.sNk != null) {
            e eVar = this.sNk;
            if (fVar != null && str != null) {
                eVar.isJ = fVar;
                eVar.sMt = str;
                fVar.aV(str, true);
            }
        }
    }

    public final void a(com.tencent.mm.pluginsdk.ui.d dVar) {
        if (this.sNk != null) {
            this.sNk.sMx.sMR = dVar;
        }
    }

    public final void notifyChanged() {
        if (this.sNk != null) {
            this.sNk.aVJ();
        }
    }

    public final void k(String str, List<String> list) {
        if (this.sNk != null) {
            e eVar = this.sNk;
            eVar.username = str;
            if (list == null) {
                list = new ArrayList(0);
            }
            eVar.sMx.bw(list);
            eVar.zF(str);
        }
    }

    public final void ae(ArrayList<x> arrayList) {
        if (this.sNk != null) {
            e eVar = this.sNk;
            eVar.sMx.ad(arrayList);
            eVar.zF(null);
        }
    }

    public final void bFa() {
        if (this.sNk != null) {
            this.sNk.sMx.sNd = false;
        }
    }

    public final void MT(String str) {
        if (this.sNk != null) {
            this.sNk.sMx.sMY = str;
        }
    }

    public final boolean xt(int i) {
        if (this.sNk != null) {
            return this.sNk.sMx.xt(i);
        }
        return false;
    }

    public final Object getItem(int i) {
        if (this.sNk == null || !this.sNk.sMx.xt(i)) {
            return null;
        }
        return this.sNk.sMx.getItem(i);
    }

    public final String xu(int i) {
        if (this.sNk == null || !this.sNk.sMx.xt(i)) {
            return "";
        }
        return ((x) this.sNk.sMx.getItem(i)).field_username;
    }

    public final String xv(int i) {
        if (this.sNk == null || !this.sNk.sMx.xt(i)) {
            return "";
        }
        return ((x) this.sNk.sMx.getItem(i)).field_nickname;
    }

    public final String xw(int i) {
        if (this.sNk == null || !this.sNk.sMx.xt(i)) {
            return "";
        }
        return ((x) this.sNk.sMx.getItem(i)).field_conRemark;
    }

    public final void bFb() {
        if (this.sNk != null) {
            f fVar = this.sNk.sMx;
            fVar.kvm = false;
            fVar.notifyChanged();
        }
    }

    public final ContactListExpandPreference ju(boolean z) {
        if (this.sNk != null) {
            this.sNk.sMx.sMT = z;
        }
        return this;
    }

    public final ContactListExpandPreference jv(boolean z) {
        if (this.sNk != null) {
            this.sNk.sMx.sMS = z;
        }
        return this;
    }

    public final ContactListExpandPreference bFc() {
        if (this.sNk != null) {
            this.sNk.sMx.sMU = false;
        }
        return this;
    }

    public final void bFd() {
        boolean z = false;
        if (this.sNk != null) {
            e eVar = this.sNk;
            eVar.sMv = false;
            if (eVar.sMv) {
                z = true;
            }
            eVar.sMw = z;
        }
    }

    public final void refresh() {
        if (this.sNk != null) {
            this.sNk.sMx.notifyChanged();
        }
    }

    public final void aN(List<String> list) {
        if (this.sNk != null) {
            f fVar = this.sNk.sMx;
            fVar.bw(list);
            fVar.notifyChanged();
        }
    }

    public final void a(g.b bVar) {
        if (this.sNk != null) {
            this.sNk.sMy = bVar;
        }
    }

    public final void a(a aVar) {
        if (this.sNk != null) {
            this.sNk.qRO = aVar;
        }
    }
}
