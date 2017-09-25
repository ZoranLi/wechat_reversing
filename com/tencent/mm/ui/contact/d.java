package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.k;
import java.util.List;

public final class d extends k<x> {
    protected MMActivity fCi;
    b hBe = null;
    private b.b hBf = null;
    protected List<String> jBA = null;
    protected f jVY;
    protected c jVZ;
    protected com.tencent.mm.ui.base.MMSlideDelView.d jWb = MMSlideDelView.bSo();
    protected e nWW;
    com.tencent.mm.pluginsdk.ui.d sMR;
    protected String vUP = null;

    protected static class a {
        public TextView jZz;
        public MaskLayout kwV;
        public TextView mTs;
        public ViewGroup vWx;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        ap.yY();
        Object QX = com.tencent.mm.u.c.wR().QX(x.h(cursor));
        if (QX != null) {
            return QX;
        }
        x xVar = new x();
        xVar.b(cursor);
        ap.yY();
        com.tencent.mm.u.c.wR().O(xVar);
        return xVar;
    }

    public d(Context context, String str) {
        super(context, new x());
        this.fCi = (MMActivity) context;
        this.vUP = str;
        this.hBe = new b(new com.tencent.mm.ui.applet.b.a(this) {
            final /* synthetic */ d vWw;

            {
                this.vWw = r1;
            }

            public final Bitmap jf(String str) {
                return com.tencent.mm.x.b.a(str, false, -1);
            }
        });
    }

    public final void a(f fVar) {
        this.jVY = fVar;
    }

    public final void a(e eVar) {
        this.nWW = eVar;
    }

    public final void a(c cVar) {
        this.jVZ = cVar;
    }

    public final int getCount() {
        return getCursor().getCount();
    }

    protected final void OL() {
        OK();
    }

    public final synchronized void OK() {
        ap.yY();
        Cursor c = com.tencent.mm.u.c.wR().c(this.vUP, "", this.jBA);
        aEW();
        setCursor(c);
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.hBf == null) {
            this.hBf = new b.b(this) {
                final /* synthetic */ d vWw;

                {
                    this.vWw = r1;
                }

                public final String fE(int i) {
                    if (i < 0 || i >= this.vWw.getCount()) {
                        w.e("MicroMsg.ChatroomContactAdapter", "pos is invalid");
                        return null;
                    }
                    x xVar = (x) this.vWw.getItem(i);
                    return xVar == null ? null : xVar.field_username;
                }

                public final int Fh() {
                    return this.vWw.getCount();
                }
            };
        }
        if (this.hBe != null) {
            this.hBe.a(i, this.hBf);
        }
        if (view == null) {
            view = View.inflate(this.fCi, R.i.cXi, null);
            a aVar2 = new a();
            aVar2.mTs = (TextView) view.findViewById(R.h.bGk);
            aVar2.kwV = (MaskLayout) view.findViewById(R.h.bGi);
            aVar2.jZz = (TextView) view.findViewById(R.h.bGm);
            aVar2.vWx = (ViewGroup) view.findViewById(R.h.bGl);
            LayoutParams layoutParams = aVar2.vWx.getLayoutParams();
            layoutParams.height = (int) (((float) com.tencent.mm.bg.a.U(this.fCi, R.f.aWM)) * com.tencent.mm.bg.a.dL(this.fCi));
            aVar2.vWx.setLayoutParams(layoutParams);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        x xVar = (x) getItem(i - 1);
        int i2 = xVar == null ? -1 : xVar.field_showHead;
        xVar = (x) getItem(i);
        if (i == 0) {
            CharSequence W = W(xVar);
            if (u.mA(W)) {
                w.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", xVar.field_username, Integer.valueOf(i));
                aVar.mTs.setVisibility(8);
            } else {
                aVar.mTs.setVisibility(0);
                aVar.mTs.setText(W);
                aVar.mTs.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            if (getItem(i + 1) == null) {
                aVar.vWx.setBackgroundResource(0);
            }
        } else if (i <= 0 || xVar.field_showHead == i2) {
            aVar.mTs.setVisibility(8);
            a(aVar, i, i2);
        } else {
            CharSequence W2 = W(xVar);
            aVar.vWx.setBackgroundResource(R.g.beo);
            if (u.mA(W2)) {
                w.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", xVar.field_username, Integer.valueOf(i));
                aVar.mTs.setVisibility(8);
            } else {
                aVar.mTs.setVisibility(0);
                aVar.mTs.setText(W2);
                if (xVar.field_showHead == 32) {
                    aVar.mTs.setCompoundDrawablesWithIntrinsicBounds(R.g.bgX, 0, 0, 0);
                    aVar.mTs.setCompoundDrawablePadding(2);
                } else {
                    aVar.mTs.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
            }
            a(aVar, i, i2);
        }
        aVar.jZz.setTextColor(com.tencent.mm.bg.a.S(this.fCi, !o.fE(xVar.field_username) ? R.e.aVa : R.e.aVb));
        ImageView imageView = (ImageView) aVar.kwV.view;
        com.tencent.mm.pluginsdk.ui.a.b.a(imageView, xVar.field_username);
        com.tencent.mm.pluginsdk.ui.a aVar3 = (com.tencent.mm.pluginsdk.ui.a) imageView.getDrawable();
        if (this.sMR != null) {
            this.sMR.a(aVar3);
        }
        aVar.kwV.bSH();
        try {
            aVar.jZz.setText(h.c(this.fCi, n.eK(xVar.field_username), (int) aVar.jZz.getTextSize()));
        } catch (Exception e) {
            aVar.jZz.setText("");
        }
        return view;
    }

    private void a(a aVar, int i, int i2) {
        x xVar = (x) getItem(i + 1);
        if (xVar == null || !(xVar.field_showHead == i2 || u.mA(W(xVar)))) {
            aVar.vWx.setBackgroundResource(0);
        }
    }

    private String W(x xVar) {
        if (xVar.field_showHead == 31) {
            return "";
        }
        if (xVar.field_showHead == 43) {
            return this.fCi.getString(R.l.eMB);
        }
        return String.valueOf((char) xVar.field_showHead);
    }
}
