package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.k;

final class a extends k<ae> implements b {
    private final MMActivity fCi;
    protected f jVY;
    protected c jVZ;
    protected e jWa;
    protected d jWb = MMSlideDelView.bSo();

    public static class a {
        public ImageView ipv;
        public TextView jWd;
        public TextView jWe;
        public TextView jWf;
        public ImageView jWg;
        public TextView jWh;
        public View jWi;
        public TextView jWj;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (ae) obj;
        if (obj == null) {
            obj = new ae();
        }
        obj.cu("");
        obj.cv("");
        obj.b(cursor);
        return obj;
    }

    public a(Context context, com.tencent.mm.ui.k.a aVar) {
        super(context, new ae());
        this.uSN = aVar;
        this.fCi = (MMActivity) context;
    }

    public final void OK() {
        ap.yY();
        setCursor(com.tencent.mm.u.c.wW().bLJ());
        if (this.uSN != null) {
            this.uSN.OH();
        }
        super.notifyDataSetChanged();
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final void a(f fVar) {
        this.jVY = fVar;
    }

    public final void a(e eVar) {
        this.jWa = eVar;
    }

    public final void a(c cVar) {
        this.jVZ = cVar;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void onPause() {
        if (this.jWb != null) {
            this.jWb.aFh();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int i2;
        ae aeVar = (ae) getItem(i);
        if (view == null) {
            a aVar2 = new a();
            View view2 = (MMSlideDelView) View.inflate(this.fCi, R.i.cVu, null);
            View inflate = View.inflate(this.fCi, R.i.dpf, null);
            aVar2.ipv = (ImageView) inflate.findViewById(R.h.bqM);
            aVar2.jWd = (TextView) inflate.findViewById(R.h.cof);
            aVar2.jWe = (TextView) inflate.findViewById(R.h.cKN);
            aVar2.jWf = (TextView) inflate.findViewById(R.h.cat);
            aVar2.jWg = (ImageView) inflate.findViewById(R.h.cGp);
            aVar2.jWh = (TextView) inflate.findViewById(R.h.cIL);
            aVar2.jWi = view2.findViewById(R.h.cFy);
            aVar2.jWj = (TextView) view2.findViewById(R.h.cFz);
            view2.setView(inflate);
            view2.jVY = this.jVY;
            view2.jVZ = this.jVZ;
            view2.jWb = this.jWb;
            view2.lPM = false;
            view2.setTag(aVar2);
            aVar = aVar2;
            view = view2;
        } else {
            aVar = (a) view.getTag();
        }
        ap.yY();
        aVar.jWd.setText(A(com.tencent.mm.u.c.wR().Rc(aeVar.field_username)));
        aVar.jWe.setText(aeVar.field_status == 1 ? this.fCi.getString(R.l.ezo) : o.c(this.fCi, aeVar.field_conversationTime, true));
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.ipv, x.QR(aeVar.field_username));
        ap.yY();
        aVar.jWf.setText(h.b(this.fCi, com.tencent.mm.u.c.wW().oG().a(aeVar.field_isSend, aeVar.field_username, aeVar.field_content, rZ(aeVar.field_msgType), this.fCi), aVar.jWf.getTextSize()));
        aVar.jWf.setTextColor(com.tencent.mm.bg.a.S(this.fCi, R.e.aVd));
        if (rZ(aeVar.field_msgType) == 34 && aeVar.field_isSend == 0 && !bg.mA(aeVar.field_content) && !new n(aeVar.field_content).iai) {
            aVar.jWf.setTextColor(com.tencent.mm.bg.a.S(this.fCi, R.e.aVe));
        }
        switch (aeVar.field_status) {
            case 0:
                i2 = -1;
                break;
            case 1:
                i2 = R.k.dxO;
                break;
            case 2:
                i2 = -1;
                break;
            case 5:
                i2 = R.k.dxN;
                break;
            default:
                i2 = -1;
                break;
        }
        if (i2 != -1) {
            aVar.jWg.setBackgroundResource(i2);
            aVar.jWg.setVisibility(0);
        } else {
            aVar.jWg.setVisibility(8);
        }
        aVar.jWi.setTag(aeVar.field_username);
        aVar.jWi.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a jWc;

            {
                this.jWc = r1;
            }

            public final void onClick(View view) {
                w.v("MicroMsg.BottleConversationAdapter", "on delView clicked");
                this.jWc.jWb.aFi();
                if (this.jWc.jWa != null) {
                    this.jWc.jWa.aQ(view.getTag());
                }
            }
        });
        i2 = view.getPaddingBottom();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingLeft = view.getPaddingLeft();
        if (aeVar.field_unReadCount > 100) {
            aVar.jWh.setText("...");
            aVar.jWh.setVisibility(0);
            w.v("MicroMsg.BottleConversationAdapter", "has unread 100");
        } else if (aeVar.field_unReadCount > 0) {
            aVar.jWh.setText(aeVar.field_unReadCount);
            aVar.jWh.setVisibility(0);
            w.v("MicroMsg.BottleConversationAdapter", "has unread");
        } else {
            aVar.jWh.setVisibility(4);
            w.v("MicroMsg.BottleConversationAdapter", "no unread");
        }
        view.setBackgroundResource(R.g.bgZ);
        view.setPadding(paddingLeft, paddingTop, paddingRight, i2);
        return view;
    }

    final String A(x xVar) {
        return com.tencent.mm.plugin.bottle.a.c.a(this.fCi, xVar);
    }

    private static int rZ(String str) {
        int i = 1;
        if (str != null && str.length() > 0) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    protected final void OL() {
        OK();
    }
}
