package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.List;

public final class c extends o {
    public static boolean pxu = true;
    public static boolean pxv = false;
    List<String> pxs;
    private boolean pxt;

    public class a extends d {
        final /* synthetic */ c pxw;

        public class a extends com.tencent.mm.ui.contact.a.d.a {
            public View pwq;
            public View pxx;
            final /* synthetic */ a pxy;

            public a(a aVar) {
                this.pxy = aVar;
                super(aVar);
            }
        }

        public class b extends com.tencent.mm.ui.contact.a.d.b {
            final /* synthetic */ a pxy;

            public b(a aVar) {
                this.pxy = aVar;
                super(aVar);
            }

            public final View a(Context context, ViewGroup viewGroup) {
                View inflate = LayoutInflater.from(context).inflate(R.i.doF, viewGroup, false);
                a aVar = (a) this.pxy.Oc();
                aVar.ipv = (ImageView) inflate.findViewById(R.h.bqM);
                aVar.ipw = (TextView) inflate.findViewById(R.h.cJh);
                aVar.ipx = (TextView) inflate.findViewById(R.h.bIb);
                aVar.ipu = inflate.findViewById(R.h.cBS);
                aVar.ipy = (CheckBox) inflate.findViewById(R.h.cBH);
                aVar.pwq = inflate.findViewById(R.h.bZH);
                aVar.pxx = inflate.findViewById(R.h.cBe);
                inflate.setTag(aVar);
                aVar.ipw.setTextColor(-1);
                LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
                layoutParams.width = -1;
                inflate.setLayoutParams(layoutParams);
                inflate.setBackgroundResource(R.e.black);
                return inflate;
            }

            public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
                af afVar = aVar2.jiL;
                a aVar3 = (a) aVar;
                aVar3.ipu.setVisibility(0);
                aVar3.pxx.setVisibility(8);
                aVar3.pwq.setVisibility(8);
                if (c.Ew(afVar.field_username)) {
                    aVar3.ipv.setImageResource(R.k.dzA);
                    aVar3.ipw.setText(R.l.eWG);
                    aVar3.ipx.setText(R.l.eWE);
                    aVar3.ipx.setVisibility(0);
                    aVar3.ipy.setEnabled(false);
                    if (c.pxv) {
                        aVar3.ipu.setBackgroundResource(R.g.bjV);
                        aVar3.ipy.setVisibility(0);
                        aVar3.ipy.setBackgroundResource(R.k.dzC);
                        aVar3.pwq.setVisibility(0);
                    } else {
                        aVar3.ipu.setBackgroundResource(R.g.bjW);
                        aVar3.ipy.setVisibility(8);
                        aVar3.ipy.setBackgroundResource(R.k.dzD);
                        aVar3.pwq.setVisibility(8);
                    }
                    c cVar = this.pxy.pxw;
                    c.d(context, aVar3.ipu);
                    ViewGroup.LayoutParams layoutParams = aVar3.ipv.getLayoutParams();
                    layoutParams.width = com.tencent.mm.bg.a.T(context, R.f.bba);
                    layoutParams.height = com.tencent.mm.bg.a.T(context, R.f.bba);
                    aVar3.ipv.setLayoutParams(layoutParams);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar3.ipy.getLayoutParams();
                    layoutParams2.height = com.tencent.mm.bg.a.T(context, R.f.bbb);
                    layoutParams2.width = com.tencent.mm.bg.a.T(context, R.f.bbb);
                    layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, 0, layoutParams2.bottomMargin);
                    aVar3.ipy.setLayoutParams(layoutParams2);
                    return;
                }
                if (c.Eu(afVar.field_username)) {
                    aVar3.ipv.setImageResource(R.k.dzB);
                    aVar3.ipy.setVisibility(8);
                    aVar3.ipw.setText(context.getString(R.l.eWJ));
                    aVar3.ipx.setVisibility(8);
                    if (c.pxu) {
                        aVar3.ipu.setBackgroundResource(R.g.bjW);
                        aVar3.pwq.setVisibility(8);
                    } else {
                        aVar3.ipu.setBackgroundResource(R.g.bjV);
                        aVar3.pwq.setVisibility(0);
                    }
                    cVar = this.pxy.pxw;
                    c.d(context, aVar3.ipu);
                } else if (c.Ev(afVar.field_username)) {
                    aVar3.ipu.setVisibility(8);
                    aVar3.pxx.setVisibility(0);
                    return;
                } else {
                    super.a(context, aVar, aVar2, z, z2);
                    aVar3.ipu.setBackgroundResource(R.g.bjW);
                    cVar = this.pxy.pxw;
                    c.d(context, aVar3.ipu);
                }
                layoutParams = aVar3.ipv.getLayoutParams();
                layoutParams.width = com.tencent.mm.bg.a.T(context, R.f.bba);
                layoutParams.height = com.tencent.mm.bg.a.T(context, R.f.bba);
                aVar3.ipv.setLayoutParams(layoutParams);
                layoutParams2 = (LinearLayout.LayoutParams) aVar3.ipy.getLayoutParams();
                layoutParams2.height = com.tencent.mm.bg.a.T(context, R.f.bbb);
                layoutParams2.width = com.tencent.mm.bg.a.T(context, R.f.bbb);
                layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, 0, layoutParams2.bottomMargin);
                aVar3.ipy.setLayoutParams(layoutParams2);
                aVar3.ipy.setBackgroundResource(R.g.bjU);
            }
        }

        public a(c cVar, int i) {
            this.pxw = cVar;
            super(i);
        }

        public final com.tencent.mm.ui.contact.a.a.b Ob() {
            return new b(this);
        }

        protected final com.tencent.mm.ui.contact.a.a.a Oc() {
            return new a(this);
        }
    }

    static /* synthetic */ void d(Context context, View view) {
        if (view != null && context != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.height = com.tencent.mm.bg.a.T(context, R.f.bbd);
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
            view.setLayoutParams(layoutParams);
            view.setPadding(com.tencent.mm.bg.a.fromDPToPix(context, 10), view.getPaddingTop(), com.tencent.mm.bg.a.fromDPToPix(context, 10), view.getPaddingTop());
        }
    }

    public c(l lVar) {
        super(lVar, new ArrayList(), true, true);
        this.pxt = true;
        this.pxt = true;
        this.pxs = null;
    }

    public final int getCount() {
        return this.pxs == null ? 0 : this.pxs.size();
    }

    protected final com.tencent.mm.ui.contact.a.a hg(int i) {
        if (this.pxs == null) {
            return null;
        }
        if (i < 0 || i >= getCount()) {
            w.e("MicroMsg.MainSightSelectContactAdapter", "create Data Item Error position=%d", new Object[]{Integer.valueOf(i)});
            return null;
        }
        x xVar;
        com.tencent.mm.ui.contact.a.a aVar = new a(this, i);
        String str = (String) this.pxs.get(i);
        if (Eu(str)) {
            xVar = new x("@sns.tencent");
        } else if (Ev(str)) {
            xVar = new x("@search.tencent");
        } else if (Ew(str)) {
            xVar = new x("@draft.tencent");
        } else {
            ap.yY();
            xVar = com.tencent.mm.u.c.wR().Rc((String) this.pxs.get(i));
        }
        aVar.jiL = xVar;
        aVar.vYg = this.pxt;
        return aVar;
    }

    public static boolean Eu(String str) {
        return bg.mA(str) ? false : str.endsWith("@sns.tencent");
    }

    public static boolean Ev(String str) {
        return bg.mA(str) ? false : str.endsWith("@search.tencent");
    }

    public static boolean Ew(String str) {
        return bg.mA(str) ? false : str.endsWith("@draft.tencent");
    }

    public final boolean bcP() {
        return this.pxt;
    }
}
