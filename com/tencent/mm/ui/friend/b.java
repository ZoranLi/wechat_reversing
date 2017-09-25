package com.tencent.mm.ui.friend;

import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.protocal.c.anp;
import com.tencent.mm.protocal.c.sq;
import java.util.LinkedList;

final class b extends BaseAdapter {
    private LinkedList<anp> hkm;
    private boolean[] isG;
    private final LayoutInflater myo;
    LinkedList<sq> wgJ;
    boolean wgK;

    static class a {
        TextView isH;
        CheckBox isI;
        TextView jZz;
        TextView kzl;
        int type;
        TextView wgL;

        a() {
        }
    }

    public b(LayoutInflater layoutInflater) {
        this.myo = layoutInflater;
    }

    public final void hk(int i) {
        if (i >= 0 && i < this.isG.length) {
            this.isG[i] = !this.isG[i];
            super.notifyDataSetChanged();
        }
    }

    public final void e(LinkedList<anp> linkedList, int i) {
        if (i < 0) {
            this.hkm = linkedList;
        } else {
            this.hkm = new LinkedList();
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                if (i == ((anp) linkedList.get(i2)).tAA) {
                    this.hkm.add(linkedList.get(i2));
                }
            }
        }
        this.isG = new boolean[this.hkm.size()];
    }

    public final String[] bYT() {
        int i = 0;
        int i2 = 0;
        for (boolean z : this.isG) {
            if (z) {
                i2++;
            }
        }
        String[] strArr = new String[i2];
        int i3 = 0;
        while (i3 < this.hkm.size()) {
            if (this.isG[i3]) {
                int i4 = i + 1;
                strArr[i] = ((anp) this.hkm.get(i3)).jNj;
                i2 = i4;
            } else {
                i2 = i;
            }
            i3++;
            i = i2;
        }
        return strArr;
    }

    public final int getCount() {
        if (this.wgK) {
            if (this.wgJ == null) {
                return 0;
            }
            return this.wgJ.size();
        } else if (this.hkm != null) {
            return this.hkm.size();
        } else {
            return 0;
        }
    }

    public final Object getItem(int i) {
        if (this.wgK) {
            return this.wgJ.get(i);
        }
        return this.hkm.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r9, android.view.View r10, android.view.ViewGroup r11) {
        /*
        r8 = this;
        r7 = 1;
        r6 = 2;
        r5 = 0;
        r0 = r8.wgK;
        if (r0 == 0) goto L_0x0047;
    L_0x0007:
        r0 = r8.wgJ;
        r0 = r0.get(r9);
        r0 = (com.tencent.mm.protocal.c.sq) r0;
        if (r10 == 0) goto L_0x001b;
    L_0x0011:
        r1 = r10.getTag();
        r1 = (com.tencent.mm.ui.friend.b.a) r1;
        r1 = r1.type;
        if (r1 == r6) goto L_0x0040;
    L_0x001b:
        r1 = r8.myo;
        r2 = com.tencent.mm.R.i.dfR;
        r10 = r1.inflate(r2, r11, r5);
        r2 = new com.tencent.mm.ui.friend.b$a;
        r2.<init>();
        r2.type = r6;
        r1 = com.tencent.mm.R.h.ctG;
        r1 = r10.findViewById(r1);
        r1 = (android.widget.TextView) r1;
        r2.kzl = r1;
        r10.setTag(r2);
        r1 = r2;
    L_0x0038:
        r1 = r1.kzl;
        r0 = r0.tAB;
        r1.setText(r0);
    L_0x003f:
        return r10;
    L_0x0040:
        r1 = r10.getTag();
        r1 = (com.tencent.mm.ui.friend.b.a) r1;
        goto L_0x0038;
    L_0x0047:
        r0 = r8.hkm;
        r0 = r0.get(r9);
        r0 = (com.tencent.mm.protocal.c.anp) r0;
        if (r10 == 0) goto L_0x005b;
    L_0x0051:
        r1 = r10.getTag();
        r1 = (com.tencent.mm.ui.friend.b.a) r1;
        r1 = r1.type;
        if (r1 == r7) goto L_0x00d0;
    L_0x005b:
        r1 = r8.myo;
        r2 = com.tencent.mm.R.i.dfQ;
        r10 = r1.inflate(r2, r11, r5);
        r2 = new com.tencent.mm.ui.friend.b$a;
        r2.<init>();
        r2.type = r7;
        r1 = com.tencent.mm.R.h.bYs;
        r1 = r10.findViewById(r1);
        r1 = (android.widget.TextView) r1;
        r2.jZz = r1;
        r1 = com.tencent.mm.R.h.bYq;
        r1 = r10.findViewById(r1);
        r1 = (android.widget.TextView) r1;
        r2.wgL = r1;
        r1 = com.tencent.mm.R.h.bYt;
        r1 = r10.findViewById(r1);
        r1 = (android.widget.CheckBox) r1;
        r2.isI = r1;
        r1 = com.tencent.mm.R.h.bYi;
        r1 = r10.findViewById(r1);
        r1 = (android.widget.TextView) r1;
        r2.isH = r1;
        r10.setTag(r2);
        r1 = r2;
    L_0x0096:
        r2 = com.tencent.mm.modelfriend.af.Gc();
        r3 = r0.jNj;
        r2 = r2.jj(r3);
        if (r2 == 0) goto L_0x00d7;
    L_0x00a2:
        r2 = r1.isH;
        r2.setVisibility(r5);
    L_0x00a7:
        r3 = r1.jZz;
        if (r0 == 0) goto L_0x0106;
    L_0x00ab:
        r2 = r0.tsz;
        if (r2 == 0) goto L_0x00df;
    L_0x00af:
        r4 = r2.length();
        if (r4 <= 0) goto L_0x00df;
    L_0x00b5:
        r3.setText(r2);
        r2 = r1.wgL;
        if (r0 == 0) goto L_0x0149;
    L_0x00bc:
        r3 = r0.tLk;
        if (r3 != 0) goto L_0x010a;
    L_0x00c0:
        r0 = r0.jNj;
    L_0x00c2:
        r2.setText(r0);
        r0 = r1.isI;
        r1 = r8.isG;
        r1 = r1[r9];
        r0.setChecked(r1);
        goto L_0x003f;
    L_0x00d0:
        r1 = r10.getTag();
        r1 = (com.tencent.mm.ui.friend.b.a) r1;
        goto L_0x0096;
    L_0x00d7:
        r2 = r1.isH;
        r3 = 8;
        r2.setVisibility(r3);
        goto L_0x00a7;
    L_0x00df:
        r2 = r0.jOp;
        if (r2 == 0) goto L_0x00e9;
    L_0x00e3:
        r4 = r2.length();
        if (r4 > 0) goto L_0x00b5;
    L_0x00e9:
        r2 = new com.tencent.mm.a.o;
        r4 = r0.leD;
        r2.<init>(r4);
        r2 = r2.toString();
        if (r2 == 0) goto L_0x00fc;
    L_0x00f6:
        r4 = r2.length();
        if (r4 > 0) goto L_0x00b5;
    L_0x00fc:
        r2 = r0.tjk;
        if (r2 == 0) goto L_0x0106;
    L_0x0100:
        r4 = r2.length();
        if (r4 > 0) goto L_0x00b5;
    L_0x0106:
        r2 = "";
        goto L_0x00b5;
    L_0x010a:
        r3 = r0.tLk;
        if (r3 != r6) goto L_0x0111;
    L_0x010e:
        r0 = r0.jNj;
        goto L_0x00c2;
    L_0x0111:
        r3 = r0.tLk;
        if (r3 != r7) goto L_0x0149;
    L_0x0115:
        r0 = r0.jNj;
        r3 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r3 != 0) goto L_0x0149;
    L_0x011d:
        r3 = "@";
        r0 = r0.split(r3);
        if (r0 == 0) goto L_0x0131;
    L_0x0126:
        r3 = r0.length;
        if (r3 < r6) goto L_0x0131;
    L_0x0129:
        r3 = r0[r5];
        r3 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
        if (r3 == 0) goto L_0x0135;
    L_0x0131:
        r0 = "";
        goto L_0x00c2;
    L_0x0135:
        r3 = new java.lang.StringBuilder;
        r4 = "@";
        r3.<init>(r4);
        r0 = r0[r5];
        r0 = r3.append(r0);
        r0 = r0.toString();
        goto L_0x00c2;
    L_0x0149:
        r0 = "";
        goto L_0x00c2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.friend.b.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
