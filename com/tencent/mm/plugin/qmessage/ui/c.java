package com.tencent.mm.plugin.qmessage.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.k;

final class c extends k<ae> implements b {
    private final MMActivity fCi;
    protected f jVY;
    protected com.tencent.mm.ui.base.MMSlideDelView.c jVZ;
    protected e jWa;
    protected d jWb = MMSlideDelView.bSo();

    public static class a {
        public ImageView ipv;
        public TextView jWd;
        public TextView jWe;
        public TextView jWf;
        public ImageView jWg;
        public TextView jWh;
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

    public c(Context context, com.tencent.mm.ui.k.a aVar) {
        super(context, new ae());
        this.uSN = aVar;
        this.fCi = (MMActivity) context;
    }

    public final void OK() {
        ap.yY();
        setCursor(com.tencent.mm.u.c.wW().Ru(o.hlt));
        if (this.uSN != null) {
            this.uSN.OH();
        }
        super.notifyDataSetChanged();
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void a(f fVar) {
        this.jVY = fVar;
    }

    public final void a(e eVar) {
        this.jWa = eVar;
    }

    public final void a(com.tencent.mm.ui.base.MMSlideDelView.c cVar) {
        this.jVZ = cVar;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int i2;
        int paddingTop;
        int paddingRight;
        int paddingLeft;
        ae aeVar = (ae) getItem(i);
        if (view == null) {
            a aVar2 = new a();
            view = View.inflate(this.fCi, R.i.dpf, null);
            aVar2.ipv = (ImageView) view.findViewById(R.h.bqM);
            aVar2.jWd = (TextView) view.findViewById(R.h.cof);
            aVar2.jWe = (TextView) view.findViewById(R.h.cKN);
            aVar2.jWf = (TextView) view.findViewById(R.h.cat);
            aVar2.jWg = (ImageView) view.findViewById(R.h.cGp);
            aVar2.jWh = (TextView) view.findViewById(R.h.cIL);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.jWd.setText(n.eK(aeVar.field_username));
        TextView textView = aVar.jWe;
        CharSequence string = aeVar.field_status == 1 ? this.fCi.getString(R.l.ezo) : aeVar.field_conversationTime == Long.MAX_VALUE ? "" : com.tencent.mm.pluginsdk.j.o.c(this.fCi, aeVar.field_conversationTime, true);
        textView.setText(string);
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.ipv, aeVar.field_username);
        ap.yY();
        as.b oG = com.tencent.mm.u.c.wW().oG();
        if (!bg.mA(aeVar.field_digest)) {
            if (bg.mA(aeVar.field_digestUser)) {
                string = aeVar.field_digest;
            } else {
                String E = (aeVar.field_isSend == 0 && o.dH(aeVar.field_username)) ? n.E(aeVar.field_digestUser, aeVar.field_username) : n.eK(aeVar.field_digestUser);
                try {
                    string = String.format(aeVar.field_digest, new Object[]{E});
                } catch (Exception e) {
                }
            }
            aVar.jWf.setText(h.b(this.fCi, string, aVar.jWf.getTextSize()));
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
            if (i2 == -1) {
                aVar.jWg.setBackgroundResource(i2);
                aVar.jWg.setVisibility(0);
            } else {
                aVar.jWg.setVisibility(8);
            }
            i2 = view.getPaddingBottom();
            paddingTop = view.getPaddingTop();
            paddingRight = view.getPaddingRight();
            paddingLeft = view.getPaddingLeft();
            if (aeVar.field_unReadCount > 100) {
                aVar.jWh.setText("...");
                aVar.jWh.setVisibility(0);
            } else if (aeVar.field_unReadCount <= 0) {
                aVar.jWh.setText(aeVar.field_unReadCount);
                aVar.jWh.setVisibility(0);
            } else {
                aVar.jWh.setVisibility(4);
            }
            view.setBackgroundResource(R.g.bgZ);
            view.setPadding(paddingLeft, paddingTop, paddingRight, i2);
            return view;
        }
        string = oG.a(aeVar.field_isSend, aeVar.field_username, aeVar.field_content, rZ(aeVar.field_msgType), this.fCi);
        aVar.jWf.setText(h.b(this.fCi, string, aVar.jWf.getTextSize()));
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
        if (i2 == -1) {
            aVar.jWg.setVisibility(8);
        } else {
            aVar.jWg.setBackgroundResource(i2);
            aVar.jWg.setVisibility(0);
        }
        i2 = view.getPaddingBottom();
        paddingTop = view.getPaddingTop();
        paddingRight = view.getPaddingRight();
        paddingLeft = view.getPaddingLeft();
        if (aeVar.field_unReadCount > 100) {
            aVar.jWh.setText("...");
            aVar.jWh.setVisibility(0);
        } else if (aeVar.field_unReadCount <= 0) {
            aVar.jWh.setVisibility(4);
        } else {
            aVar.jWh.setText(aeVar.field_unReadCount);
            aVar.jWh.setVisibility(0);
        }
        view.setBackgroundResource(R.g.bgZ);
        view.setPadding(paddingLeft, paddingTop, paddingRight, i2);
        return view;
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

    public final void onPause() {
        if (this.jWb != null) {
            this.jWb.aFh();
        }
    }

    protected final void OL() {
        OK();
    }
}
