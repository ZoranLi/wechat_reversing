package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.text.SpannableString;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.ui.c.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rs;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;

public final class j extends a {
    private final int lMT;
    private final String lNi;
    private final SparseIntArray lNj = new SparseIntArray();
    private HashMap<String, SpannableString> lNk = new HashMap();

    public static class a extends b {
        ImageView jbU;
        ImageView lNl;
        ImageView lNm;
        TextView lNn;
        TextView lNo;
        TextView lNp;
        TextView lNq;
        FrameLayout lNr;
    }

    public j(g gVar) {
        super(gVar);
        this.lMT = com.tencent.mm.bg.a.fromDPToPix(gVar.context, 60);
        this.lNi = " ";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View a(android.view.View r12, android.view.ViewGroup r13, com.tencent.mm.plugin.favorite.b.j r14) {
        /*
        r11 = this;
        r0 = r13.getContext();
        if (r12 != 0) goto L_0x0095;
    L_0x0006:
        r1 = new com.tencent.mm.plugin.favorite.ui.c.j$a;
        r1.<init>();
        r2 = com.tencent.mm.R.i.dcr;
        r3 = 0;
        r0 = android.view.View.inflate(r0, r2, r3);
        r12 = r11.a(r0, r1, r14);
        r0 = com.tencent.mm.R.h.bOx;
        r0 = r12.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.jbU = r0;
        r0 = com.tencent.mm.R.h.bOZ;
        r0 = r12.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.lNn = r0;
        r0 = com.tencent.mm.R.h.bOk;
        r0 = r12.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.lNo = r0;
        r0 = com.tencent.mm.R.h.bPa;
        r0 = r12.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.lNp = r0;
        r0 = com.tencent.mm.R.h.bOl;
        r0 = r12.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1.lNq = r0;
        r0 = com.tencent.mm.R.h.bOB;
        r0 = r12.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.lNl = r0;
        r0 = com.tencent.mm.R.h.bOA;
        r0 = r12.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1.lNm = r0;
        r0 = com.tencent.mm.R.h.bOy;
        r0 = r12.findViewById(r0);
        r0 = (android.widget.FrameLayout) r0;
        r1.lNr = r0;
        r8 = r1;
    L_0x0067:
        r11.a(r8, r14);
        r4 = 0;
        r3 = 0;
        r2 = 0;
        r1 = 0;
        r0 = 0;
        r5 = r14.field_favProto;
        r6 = r5.tzn;
        r7 = r6.iterator();
        r5 = r4;
        r4 = r3;
        r3 = r2;
        r2 = r1;
        r1 = r0;
    L_0x007c:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x00ab;
    L_0x0082:
        r0 = r7.next();
        r0 = (com.tencent.mm.protocal.c.rm) r0;
        r0 = r0.aMw;
        switch(r0) {
            case 1: goto L_0x00a4;
            case 2: goto L_0x009d;
            case 3: goto L_0x00a4;
            case 4: goto L_0x009d;
            case 5: goto L_0x00a4;
            case 6: goto L_0x00a4;
            case 7: goto L_0x00a4;
            case 8: goto L_0x00a4;
            case 9: goto L_0x008d;
            case 10: goto L_0x00a4;
            case 11: goto L_0x00a4;
            case 12: goto L_0x008d;
            case 13: goto L_0x008d;
            case 14: goto L_0x00a4;
            case 15: goto L_0x009d;
            case 16: goto L_0x00a4;
            case 17: goto L_0x00a4;
            default: goto L_0x008d;
        };
    L_0x008d:
        r0 = r1;
        r1 = r2;
    L_0x008f:
        r2 = r3 + 1;
        r3 = r2;
        r2 = r1;
        r1 = r0;
        goto L_0x007c;
    L_0x0095:
        r0 = r12.getTag();
        r0 = (com.tencent.mm.plugin.favorite.ui.c.j.a) r0;
        r8 = r0;
        goto L_0x0067;
    L_0x009d:
        if (r2 != 0) goto L_0x008d;
    L_0x009f:
        r2 = 1;
        r0 = r1;
        r4 = r3;
        r1 = r2;
        goto L_0x008f;
    L_0x00a4:
        if (r1 != 0) goto L_0x008d;
    L_0x00a6:
        r1 = 1;
        r0 = r1;
        r5 = r3;
        r1 = r2;
        goto L_0x008f;
    L_0x00ab:
        r0 = "MicroMsg.FavRecordListItem";
        r1 = "hasThumb %s, firstRemarkIndex %d";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r7 = 0;
        r9 = java.lang.Boolean.valueOf(r2);
        r3[r7] = r9;
        r7 = 1;
        r9 = java.lang.Integer.valueOf(r5);
        r3[r7] = r9;
        com.tencent.mm.sdk.platformtools.w.d(r0, r1, r3);
        r0 = r6.size();
        if (r0 > 0) goto L_0x00d5;
    L_0x00cb:
        r0 = "MicroMsg.FavRecordListItem";
        r1 = "dataList size is null";
        com.tencent.mm.sdk.platformtools.w.w(r0, r1);
    L_0x00d4:
        return r12;
    L_0x00d5:
        r0 = r6.get(r5);
        r0 = (com.tencent.mm.protocal.c.rm) r0;
        r1 = r8.lNn;
        r3 = r8.lNo;
        a(r1, r3, r0);
        if (r2 == 0) goto L_0x0179;
    L_0x00e4:
        r0 = r8.lNr;
        r1 = 0;
        r0.setVisibility(r1);
        r0 = r8.jbU;
        r1 = 0;
        r0.setVisibility(r1);
        r1 = r8.jbU;
        r0 = r6.get(r4);
        r7 = r0;
        r7 = (com.tencent.mm.protocal.c.rm) r7;
        r0 = r7.aMw;
        switch(r0) {
            case 2: goto L_0x010d;
            case 4: goto L_0x016b;
            case 15: goto L_0x016b;
            default: goto L_0x00fe;
        };
    L_0x00fe:
        r0 = r8.lNp;
        r1 = 8;
        r0.setVisibility(r1);
        r0 = r8.lNq;
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x00d4;
    L_0x010d:
        r9 = r11.lDs;
        r4 = com.tencent.mm.R.k.dzh;
        r5 = r11.lMT;
        r6 = r11.lMT;
        if (r1 == 0) goto L_0x00fe;
    L_0x0117:
        r0 = com.tencent.mm.compatible.util.f.rZ();
        if (r0 != 0) goto L_0x0123;
    L_0x011d:
        r0 = com.tencent.mm.R.g.bhP;
        r1.setImageResource(r0);
        goto L_0x00fe;
    L_0x0123:
        if (r7 == 0) goto L_0x00fe;
    L_0x0125:
        if (r14 == 0) goto L_0x00fe;
    L_0x0127:
        r3 = r7.lKv;
        if (r3 == 0) goto L_0x00fe;
    L_0x012b:
        r2 = 0;
        r0 = r7.lKv;
        if (r0 == 0) goto L_0x0150;
    L_0x0130:
        r0 = r9.lGj;
        r0 = r0.get(r3);
        r0 = (java.lang.String[]) r0;
        if (r0 != 0) goto L_0x01da;
    L_0x013a:
        r0 = 2;
        r2 = new java.lang.String[r0];
        r0 = 0;
        r10 = com.tencent.mm.plugin.favorite.b.x.g(r7);
        r2[r0] = r10;
        r0 = 1;
        r10 = com.tencent.mm.plugin.favorite.b.x.h(r7);
        r2[r0] = r10;
        r0 = r9.lGj;
        r0.put(r3, r2);
    L_0x0150:
        r0 = r9.lGi;
        r3 = 0;
        r0.a(r1, r2, r3, r4, r5, r6);
        if (r2 == 0) goto L_0x00fe;
    L_0x0158:
        r0 = r2.length;
        if (r0 <= 0) goto L_0x00fe;
    L_0x015b:
        r0 = 0;
        r0 = r2[r0];
        r1 = com.tencent.mm.u.ap.vL();
        r2 = new com.tencent.mm.plugin.favorite.c.g$2;
        r2.<init>(r9, r0, r14, r7);
        r1.D(r2);
        goto L_0x00fe;
    L_0x016b:
        r0 = r11.lDs;
        r4 = com.tencent.mm.R.k.dwS;
        r5 = r11.lMT;
        r6 = r11.lMT;
        r2 = r7;
        r3 = r14;
        r0.b(r1, r2, r3, r4, r5, r6);
        goto L_0x00fe;
    L_0x0179:
        r0 = r8.lNr;
        r1 = 8;
        r0.setVisibility(r1);
        r0 = r8.jbU;
        r1 = 8;
        r0.setVisibility(r1);
        r0 = r5 + 1;
        r1 = r6.size();
        if (r0 >= r1) goto L_0x01ac;
    L_0x018f:
        r0 = r8.lNp;
        r1 = 0;
        r0.setVisibility(r1);
        r0 = r8.lNq;
        r1 = 0;
        r0.setVisibility(r1);
        r1 = r8.lNp;
        r2 = r8.lNq;
        r0 = r5 + 1;
        r0 = r6.get(r0);
        r0 = (com.tencent.mm.protocal.c.rm) r0;
        a(r1, r2, r0);
        goto L_0x00d4;
    L_0x01ac:
        r0 = "MicroMsg.FavRecordListItem";
        r1 = "outofbound %d, size %d";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = java.lang.Integer.valueOf(r5);
        r2[r3] = r4;
        r3 = 1;
        r4 = r6.size();
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.w.d(r0, r1, r2);
        r0 = r8.lNp;
        r1 = 8;
        r0.setVisibility(r1);
        r0 = r8.lNq;
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x00d4;
    L_0x01da:
        r2 = r0;
        goto L_0x0150;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.favorite.ui.c.j.a(android.view.View, android.view.ViewGroup, com.tencent.mm.plugin.favorite.b.j):android.view.View");
    }

    private static void a(TextView textView, TextView textView2, rm rmVar) {
        if (rmVar.tyf) {
            textView.setVisibility(0);
            textView.setText(h.b(textView.getContext(), rmVar.tye, textView.getTextSize()));
        } else {
            w.d("MicroMsg.FavRecordListItem", "has no datasrcname");
            textView.setVisibility(8);
        }
        w.d("MicroMsg.FavRecordListItem", "field type %d", new Object[]{Integer.valueOf(rmVar.aMw)});
        switch (rmVar.aMw) {
            case 1:
                textView2.setText(h.b(textView2.getContext(), rmVar.desc, textView2.getTextSize()));
                return;
            case 2:
                textView2.setText(x(textView2.getContext(), R.l.ejw));
                return;
            case 3:
                textView2.setText(x(textView2.getContext(), R.l.ejC));
                return;
            case 4:
                textView2.setText(x(textView2.getContext(), R.l.ejB));
                return;
            case 5:
                textView2.setText(x(textView2.getContext(), R.l.ejA) + rmVar.title);
                return;
            case 6:
                rs rsVar = rmVar.tyc.tyw;
                textView2.setText(x(textView2.getContext(), R.l.ejx) + (bg.mA(rsVar.fRX) ? rsVar.label : rsVar.fRX));
                return;
            case 7:
                textView2.setText(x(textView2.getContext(), R.l.ejy) + rmVar.title);
                return;
            case 8:
                textView2.setText(x(textView2.getContext(), R.l.ejv) + rmVar.title);
                return;
            case 10:
                textView2.setText(x(textView2.getContext(), R.l.eiH) + rmVar.tyc.tyA.title);
                return;
            case 15:
                textView2.setText(x(textView2.getContext(), R.l.ejt));
                return;
            case 16:
                textView2.setText(x(textView2.getContext(), R.l.eiu));
                return;
            case 17:
                textView2.setText(x(textView2.getContext(), R.l.ejz));
                return;
            default:
                return;
        }
    }

    private static String x(Context context, int i) {
        return "[" + context.getResources().getString(i) + "]";
    }

    public final void cg(View view) {
        e.b(view.getContext(), ((a) view.getTag()).lFt);
    }
}
