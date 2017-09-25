package com.tencent.mm.plugin.webwx.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.iz;
import com.tencent.mm.plugin.webwx.a.b;
import com.tencent.mm.plugin.webwx.a.d;
import com.tencent.mm.protocal.c.qo;
import com.tencent.mm.protocal.c.su;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

@a(3)
public class ExtDeviceWXLoginUI extends MMActivity implements e {
    private boolean fOS = false;
    private String fUM = null;
    private int hSo = 0;
    private ProgressDialog mWt = null;
    private boolean srE = false;
    private String srM = null;
    private int srN;
    private int srO;
    private boolean srP = false;
    private Button srQ;
    private TextView srR;
    private int type = 0;

    static /* synthetic */ boolean a(ExtDeviceWXLoginUI extDeviceWXLoginUI) {
        final k bVar = new b(extDeviceWXLoginUI.fUM);
        ap.vd().a(bVar, 0);
        extDeviceWXLoginUI.mWt = g.a(extDeviceWXLoginUI.uSU.uTo, extDeviceWXLoginUI.getString(R.l.cbS), true, new OnCancelListener(extDeviceWXLoginUI) {
            final /* synthetic */ ExtDeviceWXLoginUI srS;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(bVar);
                if (this.srS.mWt != null) {
                    this.srS.mWt.cancel();
                }
            }
        });
        return true;
    }

    static /* synthetic */ boolean b(ExtDeviceWXLoginUI extDeviceWXLoginUI, boolean z) {
        final k dVar = new d(extDeviceWXLoginUI.fUM, extDeviceWXLoginUI.srM, z);
        ap.vd().a(dVar, 0);
        extDeviceWXLoginUI.mWt = g.a(extDeviceWXLoginUI.uSU.uTo, extDeviceWXLoginUI.getString(R.l.cbS), true, new OnCancelListener(extDeviceWXLoginUI) {
            final /* synthetic */ ExtDeviceWXLoginUI srS;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(dVar);
                if (this.srS.mWt != null) {
                    this.srS.mWt.cancel();
                }
            }
        });
        return true;
    }

    static /* synthetic */ void d(ExtDeviceWXLoginUI extDeviceWXLoginUI) {
        int[] iArr = new int[2];
        View findViewById = extDeviceWXLoginUI.findViewById(R.h.cSF);
        int height = findViewById.getHeight();
        findViewById.getLocationInWindow(iArr);
        int i = iArr[1];
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            extDeviceWXLoginUI.getWindowManager().getDefaultDisplay().getRealSize(point);
        } else {
            extDeviceWXLoginUI.getWindowManager().getDefaultDisplay().getSize(point);
        }
        w.i("MicroMsg.ExtDeviceWXLoginUI", "statusbarheight:%d,screenheight:%d,actionbarheight:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(point.y), Integer.valueOf(height)});
        extDeviceWXLoginUI.findViewById(R.h.cGv).setPadding(0, (((int) (((double) r1) / 4.0d)) - i) - height, 0, 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cO().cP().hide();
        KC();
        overridePendingTransition(R.a.aRq, R.a.aQL);
    }

    protected void onResume() {
        super.onResume();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void KC() {
        /*
        r14 = this;
        r13 = 3;
        r12 = 8;
        r11 = 2;
        r2 = 1;
        r3 = 0;
        r0 = r14.getIntent();
        r1 = "intent.key.login.url";
        r0 = r0.getStringExtra(r1);
        r14.fUM = r0;
        r0 = r14.getIntent();
        r1 = "intent.key.type";
        r0 = r0.getIntExtra(r1, r3);
        r14.type = r0;
        r0 = r14.getIntent();
        r1 = "intent.key.title.string";
        r1 = r0.getStringExtra(r1);
        r0 = r14.getIntent();
        r4 = "intent.key.icon.type";
        r0 = r0.getIntExtra(r4, r3);
        r14.hSo = r0;
        r0 = r14.getIntent();
        r4 = "intent.key.ok.string";
        r4 = r0.getStringExtra(r4);
        r0 = r14.getIntent();
        r5 = "intent.key.cancel.string";
        r5 = r0.getStringExtra(r5);
        r0 = r14.getIntent();
        r6 = "intent.key.content.string";
        r6 = r0.getStringExtra(r6);
        r0 = r14.getIntent();
        r7 = "intent.key.ok.session.list";
        r0 = r0.getStringExtra(r7);
        r14.srM = r0;
        r0 = r14.getIntent();
        r7 = "intent.key.login.client.version";
        r0 = r0.getIntExtra(r7, r3);
        r14.srN = r0;
        r0 = r14.getIntent();
        r7 = "intent.key.function.control";
        r0 = r0.getIntExtra(r7, r3);
        r14.srO = r0;
        r0 = "MicroMsg.ExtDeviceWXLoginUI";
        r7 = "type:%s title:%s ok:%s content:%s";
        r8 = 4;
        r8 = new java.lang.Object[r8];
        r9 = r14.type;
        r9 = java.lang.Integer.valueOf(r9);
        r8[r3] = r9;
        r8[r2] = r1;
        r8[r11] = r4;
        r8[r13] = r6;
        com.tencent.mm.sdk.platformtools.w.i(r0, r7, r8);
        r0 = "";
        r14.qP(r0);
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r0 != 0) goto L_0x00b1;
    L_0x00a6:
        r0 = com.tencent.mm.R.h.cGA;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r0.setText(r1);
    L_0x00b1:
        r0 = new com.tencent.mm.e.a.iy;
        r0.<init>();
        r1 = com.tencent.mm.sdk.b.a.urY;
        r1.m(r0);
        r1 = r0.fOL;
        r1 = r1.fOM;
        r7 = r0.fOL;
        r7 = r7.fON;
        r0 = r0.fOL;
        r0 = r0.fOO;
        r8 = r14.hSo;
        switch(r8) {
            case 1: goto L_0x0188;
            case 2: goto L_0x019a;
            default: goto L_0x00cc;
        };
    L_0x00cc:
        com.tencent.mm.u.ap.yY();
        r8 = com.tencent.mm.u.c.vr();
        r9 = com.tencent.mm.storage.w.a.uFu;
        r10 = java.lang.Integer.valueOf(r3);
        r8.a(r9, r10);
    L_0x00dc:
        r8 = com.tencent.mm.sdk.platformtools.bg.mA(r6);
        if (r8 != 0) goto L_0x01ad;
    L_0x00e2:
        r0 = com.tencent.mm.R.h.cGs;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r0.setVisibility(r12);
        r0 = com.tencent.mm.R.h.cGr;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r0.setVisibility(r3);
        r0 = com.tencent.mm.R.h.cGr;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r0.setText(r6);
    L_0x0103:
        r0 = com.tencent.mm.R.h.cGv;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r1 = r14.hSo;
        if (r1 == r2) goto L_0x0292;
    L_0x010f:
        r1 = r14.hSo;
        if (r1 != r11) goto L_0x027b;
    L_0x0113:
        r1 = com.tencent.mm.R.k.dvZ;
        r0.setImageResource(r1);
    L_0x0118:
        r0 = com.tencent.mm.R.h.cSH;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r14.srR = r0;
        r0 = r14.srR;
        r0.setText(r5);
        r0 = r14.srR;
        r1 = new com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI$1;
        r1.<init>(r14);
        r0.setOnClickListener(r1);
        r0 = com.tencent.mm.R.h.cSE;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.Button) r0;
        r14.srQ = r0;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r0 != 0) goto L_0x02bb;
    L_0x0141:
        r0 = r14.srQ;
        r0.setText(r4);
        r0 = r14.type;
        if (r0 != 0) goto L_0x0299;
    L_0x014a:
        r0 = r14.srQ;
        r0.setEnabled(r2);
    L_0x014f:
        r0 = r14.srQ;
        r1 = new com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI$2;
        r1.<init>(r14);
        r0.setOnClickListener(r1);
        r0 = r14.uSU;
        r0 = r0.ipu;
        r1 = new com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI$3;
        r1.<init>(r14);
        r0.post(r1);
        r0 = com.tencent.mm.R.h.cSG;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1 = new com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI$4;
        r1.<init>(r14);
        r0.setOnClickListener(r1);
        r0 = com.tencent.mm.u.ap.vd();
        r1 = 972; // 0x3cc float:1.362E-42 double:4.8E-321;
        r0.a(r1, r14);
        r0 = com.tencent.mm.u.ap.vd();
        r1 = 973; // 0x3cd float:1.363E-42 double:4.807E-321;
        r0.a(r1, r14);
        return;
    L_0x0188:
        com.tencent.mm.u.ap.yY();
        r8 = com.tencent.mm.u.c.vr();
        r9 = com.tencent.mm.storage.w.a.uFu;
        r10 = java.lang.Integer.valueOf(r13);
        r8.a(r9, r10);
        goto L_0x00dc;
    L_0x019a:
        com.tencent.mm.u.ap.yY();
        r8 = com.tencent.mm.u.c.vr();
        r9 = com.tencent.mm.storage.w.a.uFu;
        r10 = 4;
        r10 = java.lang.Integer.valueOf(r10);
        r8.a(r9, r10);
        goto L_0x00dc;
    L_0x01ad:
        if (r1 < 0) goto L_0x0103;
    L_0x01af:
        r1 = r14.srO;
        r1 = r1 & 1;
        if (r1 <= 0) goto L_0x0224;
    L_0x01b5:
        r1 = r2;
    L_0x01b6:
        r6 = "MicroMsg.ExtDeviceWXLoginUI";
        r8 = "msgsynchronize needCheckedSync[%b], iconType[%d]";
        r9 = new java.lang.Object[r11];
        r10 = java.lang.Boolean.valueOf(r1);
        r9[r3] = r10;
        r10 = r14.hSo;
        r10 = java.lang.Integer.valueOf(r10);
        r9[r2] = r10;
        com.tencent.mm.sdk.platformtools.w.i(r6, r8, r9);
        r6 = r14.hSo;
        if (r6 != r2) goto L_0x0226;
    L_0x01d3:
        r6 = r14.srN;
        if (r6 < r7) goto L_0x0226;
    L_0x01d7:
        r14.srE = r2;
        r0 = com.tencent.mm.R.h.cGr;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r0.setVisibility(r12);
        r0 = com.tencent.mm.R.h.cGs;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r0.setVisibility(r3);
        r0 = com.tencent.mm.R.h.cGs;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r6 = com.tencent.mm.R.l.fmM;
        r0.setText(r6);
        if (r1 == 0) goto L_0x0217;
    L_0x01fe:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.vr();
        r1 = com.tencent.mm.storage.w.a.uFt;
        r6 = java.lang.Boolean.valueOf(r2);
        r0 = r0.get(r1, r6);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x0103;
    L_0x0217:
        r0 = com.tencent.mm.R.h.cGs;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r0.setChecked(r3);
        goto L_0x0103;
    L_0x0224:
        r1 = r3;
        goto L_0x01b6;
    L_0x0226:
        r6 = r14.hSo;
        if (r6 != r11) goto L_0x0103;
    L_0x022a:
        r6 = r14.srN;
        if (r6 < r0) goto L_0x0103;
    L_0x022e:
        r14.srE = r2;
        r0 = com.tencent.mm.R.h.cGr;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r0.setVisibility(r12);
        r0 = com.tencent.mm.R.h.cGs;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r0.setVisibility(r3);
        r0 = com.tencent.mm.R.h.cGs;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r6 = com.tencent.mm.R.l.fmL;
        r0.setText(r6);
        if (r1 == 0) goto L_0x026e;
    L_0x0255:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.vr();
        r1 = com.tencent.mm.storage.w.a.uFt;
        r6 = java.lang.Boolean.valueOf(r2);
        r0 = r0.get(r1, r6);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 != 0) goto L_0x0103;
    L_0x026e:
        r0 = com.tencent.mm.R.h.cGs;
        r0 = r14.findViewById(r0);
        r0 = (android.widget.CheckBox) r0;
        r0.setChecked(r3);
        goto L_0x0103;
    L_0x027b:
        r1 = r14.hSo;
        if (r1 != r13) goto L_0x0286;
    L_0x027f:
        r1 = com.tencent.mm.R.k.dvY;
        r0.setImageResource(r1);
        goto L_0x0118;
    L_0x0286:
        r1 = r14.hSo;
        r6 = 5;
        if (r1 != r6) goto L_0x0292;
    L_0x028b:
        r1 = com.tencent.mm.R.k.dwf;
        r0.setImageResource(r1);
        goto L_0x0118;
    L_0x0292:
        r1 = com.tencent.mm.R.k.dwd;
        r0.setImageResource(r1);
        goto L_0x0118;
    L_0x0299:
        r0 = r14.type;
        r1 = -1;
        if (r0 != r1) goto L_0x02af;
    L_0x029e:
        r0 = r14.srQ;
        r0.setEnabled(r3);
        r0 = r14.hSo;
        r1 = 5;
        if (r0 != r1) goto L_0x014f;
    L_0x02a8:
        r0 = r14.srR;
        r0.setVisibility(r12);
        goto L_0x014f;
    L_0x02af:
        r0 = r14.type;
        r1 = -2;
        if (r0 != r1) goto L_0x014f;
    L_0x02b4:
        r0 = r14.srQ;
        r0.setEnabled(r2);
        goto L_0x014f;
    L_0x02bb:
        r0 = r14.srQ;
        r1 = 4;
        r0.setVisibility(r1);
        goto L_0x014f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webwx.ui.ExtDeviceWXLoginUI.KC():void");
    }

    protected void onPause() {
        super.onPause();
        if (this.srP && ap.zb()) {
            com.tencent.mm.bd.a suVar = new su();
            suVar.tAG = 27;
            suVar.tAH = m.eV(m.xR()) ? 1 : 2;
            ap.yY();
            c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(23, suVar));
            this.srP = false;
        }
    }

    protected final int getLayoutId() {
        return R.i.daf;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.a.aQL, R.a.aRo);
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(972, this);
        ap.vd().b(973, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.mWt != null) {
            this.mWt.dismiss();
            this.mWt = null;
        }
        if (i == 0 && i2 == 0) {
            w.i("MicroMsg.ExtDeviceWXLoginUI", "onSceneEnd type[%d], [%d, %d]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i2), Integer.valueOf(i)});
            ap.vd().b(972, this);
            if (kVar.getType() == 972) {
                d dVar = (d) kVar;
                if (dVar.srE || this.fOS) {
                    byte[] toByteArray = ((qo) dVar.hKp.hsk.hsr).twl.toByteArray();
                    com.tencent.mm.sdk.b.b izVar = new iz();
                    izVar.fOP.fOQ = toByteArray;
                    izVar.fOP.fOR = this.hSo;
                    izVar.fOP.fOS = this.fOS;
                    com.tencent.mm.sdk.b.a.urY.m(izVar);
                }
            } else {
                kVar.getType();
            }
            this.type = 0;
            finish();
            return;
        }
        if (i2 == -1) {
            this.type = -1;
        } else if (i2 == -2) {
            this.type = -2;
        }
        if (!bg.mA(str)) {
            ((CheckBox) findViewById(R.h.cGs)).setVisibility(8);
            ((TextView) findViewById(R.h.cGr)).setVisibility(0);
            ((TextView) findViewById(R.h.cGr)).setText(str);
        }
        if (this.type == -1) {
            if (this.srQ != null) {
                this.srQ.setEnabled(false);
            }
        } else if (this.type == -2) {
            if (this.srQ != null) {
                this.srQ.setEnabled(true);
                this.srQ.setText(R.l.fmN);
            }
            if (this.srR != null) {
                this.srR.setVisibility(4);
            }
        }
        w.i("MicroMsg.ExtDeviceWXLoginUI", "[oneliang][onSceneEnd]errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }
}
