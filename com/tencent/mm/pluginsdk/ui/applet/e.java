package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.g.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;

public final class e {
    private Context context;
    public f isJ;
    private View nsQ;
    private View nww;
    public OnClickListener oPX;
    public a qRO;
    private OnClickListener sMA;
    private OnClickListener sMB;
    private b sMC;
    private g.a sMD;
    private f.a sME;
    String sMt;
    private HashMap<String, Preference> sMu = new HashMap();
    boolean sMv = false;
    boolean sMw;
    public f sMx;
    b sMy;
    private OnClickListener sMz;
    public String username;

    public e(Context context) {
        boolean z = false;
        if (this.sMv) {
            z = true;
        }
        this.sMw = z;
        this.sMy = null;
        this.oPX = null;
        this.qRO = null;
        this.sMB = new OnClickListener(this) {
            final /* synthetic */ e sMF;

            {
                this.sMF = r1;
            }

            public final void onClick(View view) {
                w.d("MicroMsg.ContactListArchor", "OnClickListener = onClick ");
            }
        };
        this.sMC = new b(this) {
            final /* synthetic */ e sMF;

            {
                this.sMF = r1;
            }

            public final boolean kJ(int i) {
                if (this.sMF.sMx.sMS && this.sMF.sMx.xt(i) && !this.sMF.sMx.xs(i)) {
                    w.d("MicroMsg.ContactListArchor", "onItemLongClick " + i);
                }
                return true;
            }
        };
        this.sMD = new g.a(this) {
            final /* synthetic */ e sMF;

            {
                this.sMF = r1;
            }

            public final void xr(int i) {
                int i2 = 1;
                if (this.sMF.qRO != null && this.sMF.sMx != null) {
                    f fVar = this.sMF.sMx;
                    int i3 = fVar.sMS ? (fVar.kvm || i != fVar.sMQ + 2) ? 0 : 1 : (fVar.kvm || i != fVar.sMQ + 1) ? 0 : 1;
                    if (i3 == 0) {
                        fVar = this.sMF.sMx;
                        if (fVar.kvm || i != fVar.sMQ) {
                            i3 = 0;
                        } else {
                            i3 = 1;
                        }
                        if (i3 != 0) {
                            this.sMF.qRO.kM(i);
                            return;
                        }
                        fVar = this.sMF.sMx;
                        if (fVar.kvm || i != fVar.sMQ + 1) {
                            i2 = 0;
                        }
                        if (i2 != 0) {
                            if (!this.sMF.sMx.sMS) {
                                return;
                            }
                            if (o.dH(this.sMF.username)) {
                                this.sMF.qRO.kK(i);
                            } else {
                                this.sMF.sMx.xs(0);
                            }
                        } else if (this.sMF.sMx.kvm && this.sMF.sMx.xt(i)) {
                            this.sMF.qRO.kK(i);
                        } else if (this.sMF.sMx.kvm && !this.sMF.sMx.xt(i)) {
                            this.sMF.qRO.ajs();
                        } else if (!this.sMF.sMx.kvm && this.sMF.sMx.xt(i)) {
                            this.sMF.qRO.kL(i);
                        }
                    }
                }
            }
        };
        this.sME = new f.a(this) {
            final /* synthetic */ e sMF;

            {
                this.sMF = r1;
            }

            public final void bCb() {
                if (this.sMF.isJ != null) {
                    this.sMF.isJ.notifyDataSetChanged();
                }
            }
        };
        this.context = context;
        this.sMx = new f(this.context);
        this.sMx.sMI = this.sME;
    }

    final void zF(String str) {
        f fVar = this.sMx;
        fVar.username = str;
        fVar.fOg = o.dH(str);
        if (!(fVar.fOg || j.a.sNr == null)) {
            fVar.sMK = j.a.sNr.MM(str);
        }
        if (!fVar.sMK) {
            fVar.ktr = ((com.tencent.mm.plugin.chatroom.b.a) h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().fV(str);
        }
        if (fVar.sMK && j.a.sNr != null) {
            fVar.kwq = j.a.sNr.MO(fVar.username);
        }
        this.sMx.sMW = this.sMw;
        this.sMx.notifyChanged();
        aVJ();
    }

    private static String xq(int i) {
        if (i >= 0) {
            return "pref_contact_list_row_" + i;
        }
        String str = "unkown";
        if (i == -1) {
            str = "header";
        } else if (i == -2) {
            str = "footer";
        }
        return "pref_contact_list_row_" + str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aVJ() {
        /*
        r15 = this;
        r0 = r15.isJ;
        if (r0 == 0) goto L_0x0008;
    L_0x0004:
        r0 = r15.sMt;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = r15.sMu;
        r0 = r0.keySet();
        r1 = r0.iterator();
    L_0x0013:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0025;
    L_0x0019:
        r0 = r1.next();
        r0 = (java.lang.String) r0;
        r2 = r15.isJ;
        r2.Te(r0);
        goto L_0x0013;
    L_0x0025:
        r0 = r15.sMu;
        r0.clear();
        r0 = r15.isJ;
        r1 = r15.sMt;
        r1 = r0.indexOf(r1);
        r0 = 0;
        r2 = 0;
        r3 = r15.nsQ;
        if (r3 == 0) goto L_0x0039;
    L_0x0038:
        r0 = 1;
    L_0x0039:
        r3 = r15.nww;
        if (r3 == 0) goto L_0x01e4;
    L_0x003d:
        r3 = r15.sMv;
        if (r3 == 0) goto L_0x004c;
    L_0x0041:
        r3 = r15.sMx;
        r4 = r3.sMP;
        r3 = r3.sMX;
        if (r4 <= r3) goto L_0x0110;
    L_0x0049:
        r3 = 1;
    L_0x004a:
        if (r3 == 0) goto L_0x01e4;
    L_0x004c:
        r2 = 1;
        r7 = r2;
    L_0x004e:
        if (r0 == 0) goto L_0x007b;
    L_0x0050:
        r0 = new com.tencent.mm.pluginsdk.ui.applet.ContactListCustomPreference;
        r2 = r15.context;
        r0.<init>(r2);
        r2 = -1;
        r2 = xq(r2);
        r0.setKey(r2);
        r2 = r15.nsQ;
        r0.setCustomView(r2);
        r2 = com.tencent.mm.plugin.comm.a.c.beo;
        r0.background = r2;
        r2 = r15.sMz;
        r0.oPX = r2;
        r2 = r15.isJ;
        r2.a(r0, r1);
        r2 = r15.sMu;
        r3 = r0.igL;
        r2.put(r3, r0);
        r0 = r1 + 1;
        r1 = r0;
    L_0x007b:
        r0 = r15.sMy;
        if (r0 == 0) goto L_0x0113;
    L_0x007f:
        r0 = r15.sMy;
        r2 = r0;
    L_0x0082:
        r0 = r15.oPX;
        if (r0 == 0) goto L_0x0118;
    L_0x0086:
        r0 = r15.oPX;
        r3 = r0;
    L_0x0089:
        r0 = r15.sMx;
        r0 = r0.sMY;
        r4 = r15.sMx;
        r5 = r4.bEX();
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r4 != 0) goto L_0x00a5;
    L_0x0099:
        if (r0 == 0) goto L_0x011d;
    L_0x009b:
        r4 = com.tencent.mm.u.m.xL();
        r0 = r0.equals(r4);
        if (r0 != 0) goto L_0x011d;
    L_0x00a5:
        r0 = 0;
    L_0x00a6:
        r4 = r15.sMx;
        r4 = r4.sMK;
        if (r4 == 0) goto L_0x01e1;
    L_0x00ac:
        r0 = r15.sMx;
        r0 = r0.sML;
        r4 = r0;
    L_0x00b1:
        r0 = r15.sMx;
        r6 = r0.sMQ;
        if (r5 == 0) goto L_0x00b9;
    L_0x00b7:
        if (r4 == 0) goto L_0x011f;
    L_0x00b9:
        r0 = 2;
    L_0x00ba:
        r8 = r6 + r0;
        r6 = 0;
        r5 = r15.sMx;
        r9 = r15.context;
        if (r9 != 0) goto L_0x0121;
    L_0x00c3:
        r0 = 0;
    L_0x00c4:
        r5 = 0;
    L_0x00c5:
        r9 = r15.sMx;
        r9 = r9.getCount();
        if (r5 >= r9) goto L_0x01b8;
    L_0x00cd:
        if (r5 >= r8) goto L_0x01b8;
    L_0x00cf:
        r9 = new com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
        r10 = r15.context;
        r11 = 1;
        r9.<init>(r10, r11);
        r10 = xq(r6);
        r9.setKey(r10);
        r10 = r9.sNl;
        r11 = r15.sMx;
        r10.sMx = r11;
        r10.row = r6;
        r10.index = r5;
        r10 = r9.sNl;
        r10.sNm = r0;
        r10 = r9.sNl;
        r10.kto = r4;
        r10 = r9.sNl;
        r10.oPX = r3;
        r10 = r9.sNl;
        r11 = r15.sMD;
        r10.sMD = r11;
        r10 = r9.sNl;
        r10.sNn = r2;
        r10 = r15.isJ;
        r11 = r1 + r6;
        r10.a(r9, r11);
        r10 = r15.sMu;
        r11 = r9.igL;
        r10.put(r11, r9);
        r5 = r5 + r0;
        r6 = r6 + 1;
        goto L_0x00c5;
    L_0x0110:
        r3 = 0;
        goto L_0x004a;
    L_0x0113:
        r0 = r15.sMC;
        r2 = r0;
        goto L_0x0082;
    L_0x0118:
        r0 = r15.sMB;
        r3 = r0;
        goto L_0x0089;
    L_0x011d:
        r0 = 1;
        goto L_0x00a6;
    L_0x011f:
        r0 = 1;
        goto L_0x00ba;
    L_0x0121:
        r0 = "window";
        r0 = r9.getSystemService(r0);
        r0 = (android.view.WindowManager) r0;
        r0 = r0.getDefaultDisplay();
        r10 = r0.getWidth();
        r0 = r0.getHeight();
        r11 = (float) r10;
        r12 = r9.getResources();
        r13 = com.tencent.mm.plugin.comm.a.b.aXD;
        r12 = r12.getDimension(r13);
        r13 = r9.getResources();
        r14 = com.tencent.mm.plugin.comm.a.b.aXz;
        r13 = r13.getDimension(r14);
        r14 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r13 = r13 * r14;
        r12 = r12 + r13;
        r11 = r11 / r12;
        r12 = 1084227584; // 0x40a00000 float:5.0 double:5.356796015E-315;
        r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1));
        if (r11 < 0) goto L_0x01a9;
    L_0x0156:
        if (r0 <= r10) goto L_0x01a9;
    L_0x0158:
        r0 = 1;
        r5.sNe = r0;
    L_0x015b:
        r0 = r9.getResources();
        r11 = com.tencent.mm.plugin.comm.a.b.aXz;
        r0 = r0.getDimension(r11);
        r11 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r11 = r11 * r0;
        r0 = r5.sNe;
        if (r0 == 0) goto L_0x01ad;
    L_0x016c:
        r0 = r9.getResources();
        r5 = com.tencent.mm.plugin.comm.a.b.aXD;
        r0 = r0.getDimension(r5);
    L_0x0176:
        r0 = r0 + r11;
        r0 = (int) r0;
        r5 = (float) r10;
        r9 = r9.getResources();
        r10 = com.tencent.mm.plugin.comm.a.b.aXw;
        r9 = r9.getDimension(r10);
        r10 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r9 = r9 * r10;
        r5 = r5 - r9;
        r0 = (float) r0;
        r0 = r5 / r0;
        r0 = (int) r0;
        r5 = "MicroMsg.ContactsListArchAdapter";
        r9 = "[getWrapColNum] :%s";
        r10 = 1;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r12 = java.lang.Integer.valueOf(r0);
        r10[r11] = r12;
        com.tencent.mm.sdk.platformtools.w.i(r5, r9, r10);
        com.tencent.mm.pluginsdk.ui.applet.f.sMH = r0;
        r5 = 4;
        if (r0 != r5) goto L_0x00c4;
    L_0x01a3:
        r5 = 43;
        com.tencent.mm.pluginsdk.ui.applet.f.sMG = r5;
        goto L_0x00c4;
    L_0x01a9:
        r0 = 0;
        r5.sNe = r0;
        goto L_0x015b;
    L_0x01ad:
        r0 = r9.getResources();
        r5 = com.tencent.mm.plugin.comm.a.b.aXB;
        r0 = r0.getDimension(r5);
        goto L_0x0176;
    L_0x01b8:
        if (r7 == 0) goto L_0x0008;
    L_0x01ba:
        r0 = new com.tencent.mm.pluginsdk.ui.applet.ContactListCustomPreference;
        r2 = r15.context;
        r0.<init>(r2);
        r2 = -2;
        r2 = xq(r2);
        r0.setKey(r2);
        r2 = r15.nww;
        r0.setCustomView(r2);
        r2 = r15.sMA;
        r0.oPX = r2;
        r2 = r15.isJ;
        r1 = r1 + r6;
        r2.a(r0, r1);
        r1 = r15.sMu;
        r2 = r0.igL;
        r1.put(r2, r0);
        goto L_0x0008;
    L_0x01e1:
        r4 = r0;
        goto L_0x00b1;
    L_0x01e4:
        r7 = r2;
        goto L_0x004e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.applet.e.aVJ():void");
    }
}
