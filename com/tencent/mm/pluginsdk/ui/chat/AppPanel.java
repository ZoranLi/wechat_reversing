package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.cp;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.base.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AppPanel extends LinearLayout {
    private static int pcn = cp.CTRL_INDEX;
    private static int pco = 158;
    private static boolean sOm = false;
    Context context;
    private SharedPreferences hgx;
    private boolean isInit = false;
    private int pcA;
    public MMFlipper pcB;
    private MMDotView pcC;
    private boolean pcy = false;
    private int pcz;
    private int sNH = 16;
    private List<f> sNK = new LinkedList();
    private final boolean[] sNS = new boolean[16];
    a sNT;
    b sNU;
    private List<AppGrid> sNV;
    private int sNW = this.sNH;
    public a sNX;
    private int sNY = 0;
    private int sNZ = 0;
    int sOa = 0;
    private boolean sOb = false;
    private boolean sOc = false;
    private boolean sOd = false;
    private boolean sOe = false;
    boolean sOf = false;
    boolean sOg = false;
    boolean sOh = false;
    private Map<String, f> sOi = null;
    private boolean sOj = true;
    private final int sOk = 2;
    private com.tencent.mm.pluginsdk.ui.chat.AppGrid.b sOl = new com.tencent.mm.pluginsdk.ui.chat.AppGrid.b(this) {
        final /* synthetic */ AppPanel sOp;

        {
            this.sOp = r1;
        }

        public final int xx(int i) {
            int i2 = 0;
            if (i < this.sOp.sNH) {
                int length = this.sOp.sNS.length;
                int i3 = 0;
                while (i2 < length) {
                    if (this.sOp.sNS[i2]) {
                        if (i3 == i) {
                            return i2;
                        }
                        i3++;
                    }
                    i2++;
                }
            } else if (i >= this.sOp.sNH && i < this.sOp.sNW) {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }

        public final void xy(int i) {
            if (i != 0) {
                return;
            }
            if (this.sOp.sNX.sOt.value) {
                AppPanel.a(this.sOp, true);
            } else {
                Toast.makeText(this.sOp.context, this.sOp.context.getString(R.l.dUL), 0).show();
            }
        }

        public final void a(int i, f fVar) {
            int i2 = 0;
            String str = "MicroMsg.AppPanel";
            String str2 = "pos=%d, has appInfo = %b";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Boolean.valueOf(fVar != null);
            w.d(str, str2, objArr);
            if (fVar != null && g.j(fVar)) {
                Map hashMap = new HashMap();
                m.b(327682, hashMap);
                hashMap.put(fVar.field_appId, "1");
                m.a(327682, hashMap);
            }
            com.tencent.mm.sdk.b.b qkVar;
            String str3;
            f fVar2;
            int intValue;
            List f;
            switch (i) {
                case Integer.MIN_VALUE:
                    if (!this.sOp.sNX.sOA.value) {
                        Toast.makeText(this.sOp.context, this.sOp.context.getString(R.l.dUL), 0).show();
                        return;
                    } else if (fVar == null) {
                        w.e("MicroMsg.AppPanel", "APP_MSG_POS bug appInfo is null");
                        return;
                    } else {
                        if (fVar.bCV() || fVar.bCX()) {
                            if (this.sOp.hgx == null) {
                                this.sOp.hgx = this.sOp.context.getSharedPreferences(ab.bIX(), 0);
                            }
                            if (this.sOp.hgx.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar.field_appId, true)) {
                                this.sOp.hgx.edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar.field_appId, false).commit();
                            }
                            if (fVar.bCX()) {
                                com.tencent.mm.plugin.report.service.g.oUh.i(10923, Integer.valueOf(16), fVar.field_appId, Integer.valueOf(0));
                            }
                            com.tencent.mm.plugin.report.service.g.oUh.i(10923, Integer.valueOf(13), fVar.field_appId, Integer.valueOf(0));
                        } else {
                            com.tencent.mm.plugin.report.service.g.oUh.i(10923, Integer.valueOf(11), fVar.field_appId);
                        }
                        this.sOp.sNT.b(fVar);
                        return;
                    }
                case 0:
                    if (this.sOp.sNX.sOt.value) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(10923, Integer.valueOf(1));
                        AppPanel.a(this.sOp, false);
                        return;
                    }
                    Toast.makeText(this.sOp.context, this.sOp.context.getString(R.l.dUL), 0).show();
                    return;
                case 1:
                    com.tencent.mm.plugin.report.service.g.oUh.i(10923, Integer.valueOf(14));
                    a k = this.sOp.sNT;
                    if (!this.sOp.sNX.sOJ.value) {
                        i2 = 2;
                    }
                    k.pi(i2);
                    return;
                case 2:
                    if (this.sOp.sNX.sOw.value) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(10923, Integer.valueOf(8));
                        ap.yY();
                        c.vr().set(54, Boolean.valueOf(false));
                        if (this.sOp.sNT != null) {
                            qkVar = new qk();
                            qkVar.fXu.fXw = true;
                            com.tencent.mm.sdk.b.a.urY.m(qkVar);
                            str3 = qkVar.fXv.fXy;
                            if (bg.mA(str3)) {
                                this.sOp.sNT.aJD();
                                return;
                            }
                            w.v("MicroMsg.AppPanel", "Talkroom is on: " + str3);
                            com.tencent.mm.ui.base.g.a(this.sOp.context, this.sOp.context.getString(R.l.eXz), "", this.sOp.context.getString(R.l.dHT), this.sOp.context.getString(R.l.dGs), new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass3 sOq;

                                {
                                    this.sOq = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    com.tencent.mm.sdk.b.b qkVar = new qk();
                                    qkVar.fXu.fXx = true;
                                    com.tencent.mm.sdk.b.a.urY.m(qkVar);
                                    this.sOq.sOp.sNT.aJD();
                                    dialogInterface.dismiss();
                                }
                            }, new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass3 sOq;

                                {
                                    this.sOq = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                            return;
                        }
                        return;
                    }
                    Toast.makeText(this.sOp.context, this.sOp.context.getString(R.l.dUL), 0).show();
                    return;
                case 3:
                    if (this.sOp.sNT != null) {
                        this.sOp.sNT.aJN();
                        return;
                    }
                    return;
                case 4:
                    if (this.sOp.sNX.sOC.value) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(10923, Integer.valueOf(7));
                        ap.yY();
                        c.vr().set(62, Boolean.valueOf(false));
                        qkVar = new qk();
                        qkVar.fXu.fXw = true;
                        com.tencent.mm.sdk.b.a.urY.m(qkVar);
                        str3 = qkVar.fXv.fXy;
                        if (bg.mA(str3)) {
                            this.sOp.sNT.aJE();
                            return;
                        }
                        w.v("MicroMsg.AppPanel", "Talkroom is on: " + str3);
                        com.tencent.mm.ui.base.g.a(this.sOp.context, this.sOp.context.getString(R.l.eXz), "", this.sOp.context.getString(R.l.dHT), this.sOp.context.getString(R.l.dGs), new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass3 sOq;

                            {
                                this.sOq = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.sdk.b.b qkVar = new qk();
                                qkVar.fXu.fXx = true;
                                com.tencent.mm.sdk.b.a.urY.m(qkVar);
                                this.sOq.sOp.sNT.aJE();
                                dialogInterface.dismiss();
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass3 sOq;

                            {
                                this.sOq = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        return;
                    }
                    Toast.makeText(this.sOp.context, this.sOp.context.getString(R.l.dUL), 0).show();
                    return;
                case 5:
                    if (this.sOp.sNT != null) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(10923, Integer.valueOf(6));
                        ap.yY();
                        c.vr().set(67, Boolean.valueOf(false));
                        this.sOp.sNT.aJF();
                        return;
                    }
                    return;
                case 6:
                    if (this.sOp.sNX.sOG.value && this.sOp.sNX.sOH.value) {
                        ap.yY();
                        if (((Boolean) c.vr().get(290817, Boolean.valueOf(true))).booleanValue()) {
                            ap.yY();
                            c.vr().set(290817, Boolean.valueOf(false));
                            this.sOp.refresh();
                        }
                        com.tencent.mm.plugin.report.service.g.oUh.i(10923, Integer.valueOf(3));
                        this.sOp.sNT.aJG();
                        return;
                    }
                    Toast.makeText(this.sOp.context, this.sOp.context.getString(R.l.dUL), 0).show();
                    return;
                case 7:
                    if (this.sOp.sNX.sOK.value) {
                        if (fVar == null) {
                            fVar2 = (f) this.sOp.sOi.get(f.sDf);
                            if (fVar2 == null) {
                                return;
                            }
                        }
                        fVar2 = fVar;
                        if (fVar2.bCV() || fVar2.bCX()) {
                            if (this.sOp.hgx == null) {
                                this.sOp.hgx = this.sOp.context.getSharedPreferences(ab.bIX(), 0);
                            }
                            if (this.sOp.hgx.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, true)) {
                                this.sOp.hgx.edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, false).commit();
                            }
                            com.tencent.mm.plugin.report.service.g.oUh.i(10923, Integer.valueOf(13), fVar2.field_appId, Integer.valueOf(0));
                        } else {
                            com.tencent.mm.plugin.report.service.g.oUh.i(10923, Integer.valueOf(11), fVar2.field_appId);
                        }
                        ap.yY();
                        intValue = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                        ap.yY();
                        f = bg.f(((String) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_HONGBAO_STRING_SYNC, (Object) "")).split(";"));
                        if (!f.contains(String.valueOf(intValue))) {
                            f.add(String.valueOf(intValue));
                            ap.yY();
                            c.vr().a(com.tencent.mm.storage.w.a.USERINFO_WALLET_HONGBAO_STRING_SYNC, bg.c(f, ";"));
                            this.sOp.refresh();
                        }
                        this.sOp.sNT.aJM();
                        return;
                    }
                    Toast.makeText(this.sOp.context, this.sOp.context.getString(R.l.dUL), 0).show();
                    return;
                case 8:
                    if (fVar == null) {
                        fVar = (f) this.sOp.sOi.get(f.sDd);
                    }
                    ap.yY();
                    intValue = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                    ap.yY();
                    f = bg.f(((String) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_REMITTANCE_STRING_SYNC, (Object) "")).split(";"));
                    if (!f.contains(String.valueOf(intValue))) {
                        f.add(String.valueOf(intValue));
                        ap.yY();
                        c.vr().a(com.tencent.mm.storage.w.a.USERINFO_WALLET_REMITTANCE_STRING_SYNC, bg.c(f, ";"));
                        this.sOp.refresh();
                    }
                    ap.yY();
                    c.vr().set(80, Boolean.valueOf(false));
                    this.sOp.sNT.b(fVar);
                    return;
                case 9:
                    if (this.sOp.sNT != null) {
                        if (fVar == null) {
                            fVar2 = (f) this.sOp.sOi.get(f.sDg);
                            if (fVar2 == null) {
                                w.i("MicroMsg.AppPanel", "empty info");
                                return;
                            }
                        }
                        fVar2 = fVar;
                        if (fVar2.bCV() || fVar2.bCX()) {
                            if (this.sOp.hgx == null) {
                                this.sOp.hgx = this.sOp.context.getSharedPreferences(ab.bIX(), 0);
                            }
                            if (this.sOp.hgx.getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, true)) {
                                this.sOp.hgx.edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar2.field_appId, false).commit();
                            }
                        }
                        this.sOp.sNT.aJP();
                        return;
                    }
                    return;
                case 10:
                    com.tencent.mm.plugin.report.service.g.oUh.i(10923, Integer.valueOf(9));
                    ap.yY();
                    c.vr().set(73, Boolean.valueOf(false));
                    this.sOp.sNU.bFn();
                    return;
                case 11:
                    if (this.sOp.sNX.sOu.value) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(10923, Integer.valueOf(4));
                        this.sOp.sNT.aJH();
                        return;
                    }
                    Toast.makeText(this.sOp.context, this.sOp.context.getString(R.l.dUL), 0).show();
                    return;
                case 12:
                    if (this.sOp.sNX.sOv.value) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(10923, Integer.valueOf(5));
                        if (this.sOp.sNT != null) {
                            this.sOp.sNT.aJJ();
                            return;
                        }
                        return;
                    }
                    Toast.makeText(this.sOp.context, this.sOp.context.getString(R.l.dUL), 0).show();
                    return;
                case 13:
                    if (this.sOp.sNX.sOI.value) {
                        if (this.sOp.sNT != null) {
                            this.sOp.sNT.aJL();
                        }
                        com.tencent.mm.plugin.report.service.g.oUh.i(10923, Integer.valueOf(15));
                        ap.yY();
                        boolean booleanValue = ((Boolean) c.vr().get(208899, Boolean.valueOf(false))).booleanValue();
                        ap.yY();
                        boolean booleanValue2 = ((Boolean) c.vr().get(208913, Boolean.valueOf(false))).booleanValue();
                        if (booleanValue) {
                            com.tencent.mm.plugin.report.service.g.oUh.i(11594, Integer.valueOf(3));
                            return;
                        } else if (booleanValue2) {
                            com.tencent.mm.plugin.report.service.g.oUh.i(11594, Integer.valueOf(4));
                            return;
                        } else {
                            return;
                        }
                    }
                    Toast.makeText(this.sOp.context, this.sOp.context.getString(R.l.dUL), 0).show();
                    return;
                case 14:
                    if (this.sOp.sNX.sOy.value) {
                        ap.yY();
                        if (((Boolean) c.vr().get(327744, Boolean.valueOf(true))).booleanValue()) {
                            ap.yY();
                            c.vr().set(327744, Boolean.valueOf(false));
                            this.sOp.refresh();
                        }
                        com.tencent.mm.plugin.report.service.g.oUh.i(10923, Integer.valueOf(12));
                        this.sOp.sNT.aJK();
                        return;
                    }
                    Toast.makeText(this.sOp.context, this.sOp.context.getString(R.l.dUL), 0).show();
                    return;
                case 15:
                    if (this.sOp.sNX.sOM.value) {
                        this.sOp.sNT.aJO();
                        return;
                    } else {
                        Toast.makeText(this.sOp.context, this.sOp.context.getString(R.l.dUL), 0).show();
                        return;
                    }
                case Integer.MAX_VALUE:
                    if (this.sOp.sNK == null) {
                        w.e("MicroMsg.AppPanel", "infoList == null");
                        return;
                    }
                    com.tencent.mm.plugin.report.service.g.oUh.A(10305, String.valueOf(this.sOp.sNK.size()));
                    com.tencent.mm.plugin.report.service.g.oUh.i(10923, Integer.valueOf(10));
                    h.vI().vr().set(69121, "");
                    this.sOp.sNT.aJI();
                    return;
                default:
                    return;
            }
        }
    };
    boolean sOn = true;
    private int sOo = -1;

    public interface a {
        void aJD();

        void aJE();

        void aJF();

        void aJG();

        void aJH();

        void aJI();

        void aJJ();

        void aJK();

        void aJL();

        void aJM();

        void aJN();

        void aJO();

        void aJP();

        void b(f fVar);

        void ph(int i);

        void pi(int i);
    }

    public interface b {
        void bFn();
    }

    static /* synthetic */ void a(AppPanel appPanel, boolean z) {
        ap.yY();
        if (c.isSDCardAvailable()) {
            if (!sOm) {
                sOm = true;
                e.post(new Runnable(appPanel) {
                    final /* synthetic */ AppPanel sOp;

                    {
                        this.sOp = r1;
                    }

                    public final void run() {
                        com.tencent.mm.modelcdntran.g.Em();
                        w.i("MicroMsg.AppPanel", "preMakeConnection ret:%d", Integer.valueOf(0));
                        AppPanel.sOm = false;
                    }
                }, "AppPanel_preMakeConnection");
            }
            if (z) {
                appPanel.sNT.ph(0);
                return;
            } else {
                appPanel.sNT.ph(1);
                return;
            }
        }
        s.eP(appPanel.context);
    }

    public AppPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public final void init(int i) {
        this.sNX = new a();
        this.sOa = i;
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            this.sNY = defaultDisplay.getWidth();
            this.sNZ = defaultDisplay.getHeight();
        } else {
            this.sNY = defaultDisplay.getHeight();
            this.sNZ = defaultDisplay.getWidth();
        }
        View.inflate(this.context, R.i.cUI, this);
        this.pcC = (MMDotView) findViewById(R.h.bpM);
        this.pcB = (MMFlipper) findViewById(R.h.bpN);
        try {
            String value = com.tencent.mm.i.g.sV().getValue("ShowAPPSuggestion");
            if (bg.mA(value) || Integer.valueOf(value).intValue() != 1) {
                this.sNK = g.a(this.context, false, this.sOa);
                if (!bFl()) {
                    bS(this.sNK);
                }
                bR(this.sNK);
                bFi();
                bFe();
            }
            this.sNK = g.a(this.context, true, this.sOa);
            if (bFl()) {
                bS(this.sNK);
            }
            bR(this.sNK);
            bFi();
            bFe();
        } catch (Exception e) {
            w.e("MicroMsg.AppPanel", "exception in appPanel init, %s", e.getMessage());
            this.sNK = g.a(this.context, false, this.sOa);
        }
    }

    private void bR(List<f> list) {
        boolean z = this.sOb;
        this.sOb = false;
        boolean z2 = this.sOc;
        boolean z3 = this.sOd;
        boolean z4 = this.sOe;
        this.sOc = false;
        this.sOd = false;
        this.sOe = false;
        int i = this.sOa;
        ArrayList arrayList = new ArrayList();
        if (com.tencent.mm.plugin.w.a.a.a.aRv() == null) {
            w.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
            i = 0;
        } else {
            Cursor cG = com.tencent.mm.plugin.w.a.a.a.aRv().cG(0, i);
            if (cG == null) {
                i = 0;
            } else {
                i = cG.getCount();
                cG.close();
            }
        }
        w.d("MicroMsg.AppPanel", "serviceCount, %d", Integer.valueOf(i));
        this.sOi = new HashMap();
        if (i > 0 && list != null && list.size() > 0) {
            int i2 = 0;
            while (i2 < list.size()) {
                f fVar = (f) list.get(i2);
                if (!(fVar == null || fVar.field_appId == null || !fVar.bCV())) {
                    boolean z5;
                    int i3;
                    if ((fVar.field_serviceAppInfoFlag & 1) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (!z5) {
                        this.sOb = true;
                    }
                    if (f.sDd.equals(fVar.field_appId)) {
                        this.sOi.put(f.sDd, fVar);
                        if (!this.sOg) {
                            this.sOc = true;
                        }
                        i3 = i2 - 1;
                        list.remove(i2);
                        i2 = i3;
                    }
                    if (f.sDf.equals(fVar.field_appId)) {
                        this.sOi.put(f.sDf, fVar);
                        if (!this.sOf) {
                            this.sOd = true;
                        }
                        i3 = i2 - 1;
                        list.remove(i2);
                        i2 = i3;
                    }
                    if (f.sDg.equals(fVar.field_appId)) {
                        this.sOi.put(f.sDg, fVar);
                        if (!this.sOh) {
                            this.sOe = true;
                        }
                        i = i2 - 1;
                        list.remove(i2);
                        i2 = i;
                    }
                }
                i2++;
            }
        }
        w.d("MicroMsg.AppPanel", "hasService %b", Boolean.valueOf(this.sOb));
        if (z != this.sOb || z2 != this.sOc || z3 != this.sOd || z4 != this.sOe) {
            this.sNX.jx(this.sOb);
            this.sNX.jy(this.sOc);
            this.sNX.jz(this.sOd);
            this.sNX.jA(this.sOe);
            bFg();
        }
    }

    public final void bFe() {
        a aVar = this.sNX;
        aVar.sOr.value = true;
        aVar.sOs.value = true;
        aVar.sOt.value = true;
        aVar.sOu.value = true;
        aVar.sOv.value = true;
        aVar.sOw.value = true;
        aVar.sOx.value = true;
        aVar.sOG.value = true;
        aVar.sOE.value = true;
        aVar.sOy.value = true;
        aVar.sOz.value = true;
        aVar.sOA.value = true;
        aVar.sOB.value = true;
        aVar.sOC.value = true;
        aVar.sOD.value = true;
        aVar.sOF.value = true;
        aVar.sOH.value = true;
        aVar.sOI.value = false;
        aVar.sOJ.value = true;
        aVar.sOK.value = true;
        aVar.sOM.value = true;
        aVar.sON.value = true;
        aVar.sOM.value = false;
        this.sOf = false;
        this.sOg = false;
        this.sOh = false;
        bFf();
        this.sNX.jx(this.sOb);
        this.sNX.jy(this.sOc);
        this.sNX.jz(this.sOd);
        this.sNX.jA(this.sOe);
        bFg();
    }

    public final void bFf() {
        boolean z = true;
        com.tencent.mm.i.g.sW();
        boolean z2 = com.tencent.mm.i.c.sF() == 2;
        this.sNX.sOx.value = true;
        this.sNX.sOD.value = z2;
        this.sNX.sOH.value = d.Jt("location");
        if ((m.xW() & 33554432) != 0) {
            z = false;
        }
        this.sNX.sOF.value = z;
    }

    public final void jw(boolean z) {
        this.sNX.sOC.value = false;
        bFg();
        w.d("MicroMsg.AppPanel", "enable " + this.sNX.sOD.value + " isVoipAudioEnable false");
    }

    public final void bFg() {
        int i = 1;
        int length = this.sNS.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.sNS[i2] = true;
        }
        if (this.sNX.sOt.value) {
            i = 0;
        } else {
            this.sNS[0] = false;
        }
        if (!(this.sNX.sOG.value && this.sNX.sOH.value)) {
            this.sNS[6] = false;
            i++;
        }
        if (!this.sNX.sOy.value) {
            this.sNS[14] = false;
            i++;
        }
        if (!this.sNX.sOz.value) {
            this.sNS[8] = false;
            i++;
        }
        if (!this.sNX.sOu.value) {
            this.sNS[11] = false;
            i++;
        }
        if (!this.sNX.sOI.value) {
            this.sNS[13] = false;
            i++;
        }
        if (!this.sNX.sOL.value) {
            this.sNS[3] = false;
            i++;
        }
        if (!this.sNX.sOv.value) {
            this.sNS[12] = false;
            i++;
        }
        if (!this.sNX.sOB.value) {
            this.sNS[5] = false;
            i++;
        }
        if (!(this.sNX.sOD.value && this.sNX.sOC.value)) {
            this.sNS[4] = false;
            i++;
        }
        if (!(this.sNX.sOx.value && this.sNX.sOw.value)) {
            this.sNS[2] = false;
            i++;
        }
        if (!(this.sNX.sOF.value && this.sNX.sOE.value)) {
            this.sNS[10] = false;
            i++;
        }
        if (!this.sNX.sOK.value) {
            this.sNS[7] = false;
            i++;
        }
        if (!this.sNX.sOM.value) {
            this.sNS[15] = false;
            i++;
        }
        this.sNS[9] = false;
        this.sNH = 16 - (i + 1);
    }

    private int bFh() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            return 1;
        }
        return 2;
    }

    private void bFi() {
        w.d("MicroMsg.AppPanel", "AppPanel initFlipper");
        this.pcB.removeAllViews();
        this.pcB.vji = new com.tencent.mm.ui.base.MMFlipper.a(this) {
            final /* synthetic */ AppPanel sOp;

            {
                this.sOp = r1;
            }

            public final void cN(int i, int i2) {
                w.d("MicroMsg.AppPanel", "onMeasure width:" + i + " height:" + i2 + " isMeasured:" + this.sOp.pcy);
                if (!this.sOp.pcy && i2 != 0 && i != 0) {
                    if (this.sOp.bFh() == 2) {
                        w.d("MicroMsg.AppPanel", "landspace");
                    } else {
                        w.d("MicroMsg.AppPanel", "portrait");
                    }
                    this.sOp.pcy = true;
                    this.sOp.pcA = i2;
                    this.sOp.pcz = i;
                    this.sOp.bFj();
                } else if (i2 == 0 || i == 0) {
                    w.d("MicroMsg.AppPanel", "onMeasure, width or height is 0");
                }
            }
        };
        this.pcB.vjh = new com.tencent.mm.ui.base.MMFlipper.b(this) {
            final /* synthetic */ AppPanel sOp;

            {
                this.sOp = r1;
            }

            public final void sh(int i) {
                this.sOp.pcC.Ae(i);
            }
        };
        bFk();
    }

    public final void refresh() {
        w.v("MicroMsg.AppPanel", "app panel refleshed");
        try {
            String value = com.tencent.mm.i.g.sV().getValue("ShowAPPSuggestion");
            int bRR;
            if (bg.mA(value) || Integer.valueOf(value).intValue() != 1) {
                this.sNK = g.a(this.context, false, this.sOa);
                w.d("MicroMsg.AppPanel", "jacks not show App Suggestion");
                if (!bFl()) {
                    bS(this.sNK);
                }
                bR(this.sNK);
                if (this.sNX != null) {
                    this.sNX.jx(this.sOb);
                    this.sNX.jy(this.sOc);
                    this.sNX.jz(this.sOd);
                    this.sNX.jA(this.sOe);
                }
                bRR = this.pcB.bRR();
                bFj();
                this.pcB.Ah(bRR);
                this.pcC.Ae(bRR);
            }
            w.d("MicroMsg.AppPanel", "jacks show App Suggestion");
            this.sNK = g.a(this.context, true, this.sOa);
            if (bFl()) {
                bS(this.sNK);
            }
            bR(this.sNK);
            if (this.sNX != null) {
                this.sNX.jx(this.sOb);
                this.sNX.jy(this.sOc);
                this.sNX.jz(this.sOd);
                this.sNX.jA(this.sOe);
            }
            bRR = this.pcB.bRR();
            bFj();
            this.pcB.Ah(bRR);
            this.pcC.Ae(bRR);
        } catch (Exception e) {
            w.e("MicroMsg.AppPanel", "exception in appPanel init, %s", e.getMessage());
            this.sNK = g.a(this.context, false, this.sOa);
        }
    }

    private void bFj() {
        if (this.pcz != 0 && this.pcA != 0) {
            AppGrid appGrid;
            this.sNV = new ArrayList();
            this.pcB.removeAllViews();
            int a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.context, 82.0f);
            int a2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.context, 90.0f);
            requestLayout();
            bFg();
            if (this.sOj) {
                a = 4;
            } else {
                a = this.pcz / a;
            }
            int i = this.pcA / a2;
            if (i > 2) {
                i = 2;
            }
            int i2 = (this.pcA - (a2 * i)) / (i + 1);
            w.d("MicroMsg.AppPanel", "jacks spacing2 = %d", Integer.valueOf(i2));
            w.d("MicroMsg.AppPanel", "in initAppGrid, gridWidth = %d, gridHeight = %d", Integer.valueOf(this.pcz), Integer.valueOf(this.pcA));
            if (a == 0) {
                a2 = 1;
            } else {
                a2 = a;
            }
            if (i == 0) {
                i = 1;
            }
            int i3 = a2 * i;
            if (this.sNX.sOA.value) {
                this.sNW = this.sNH + this.sNK.size();
            } else {
                this.sNW = this.sNH;
            }
            int ceil = (int) Math.ceil(((double) this.sNW) / ((double) i3));
            w.d("MicroMsg.AppPanel", "in initAppGrid, totalItemCount = %d, itemsPerPage = %d, pageCount = %d", Integer.valueOf(this.sNW), Integer.valueOf(i3), Integer.valueOf(ceil));
            for (i = 0; i < ceil; i++) {
                appGrid = (AppGrid) inflate(this.context, R.i.cUE, null);
                appGrid.sNI = new a(appGrid, appGrid.context, this.sNK, this.sOi);
                appGrid.setBackgroundResource(0);
                appGrid.setAdapter(appGrid.sNI);
                appGrid.setOnItemClickListener(appGrid.kbd);
                appGrid.setOnItemLongClickListener(appGrid.lID);
                appGrid.setPadding(com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(appGrid.context, 16.0f), com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(appGrid.context, 6.0f), com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(appGrid.context, 16.0f), 0);
                int i4 = this.sNW;
                int i5 = this.sNH;
                appGrid.sNG = i;
                appGrid.sND = i4;
                appGrid.sNE = i3;
                appGrid.sNF = ceil;
                appGrid.sNH = i5;
                appGrid.setNumColumns(a2);
                if (i2 > 0) {
                    appGrid.setPadding(com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(appGrid.context, 16.0f), i2, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(appGrid.context, 16.0f), 0);
                    appGrid.setVerticalSpacing(i2 / 2);
                }
                this.pcB.addView(appGrid, new LayoutParams(-1, -2));
                this.sNV.add(appGrid);
            }
            if (this.sNV != null) {
                for (AppGrid appGrid2 : this.sNV) {
                    appGrid2.sNC = this.sOl;
                }
            }
            if (this.sNV.size() <= 1) {
                this.pcC.setVisibility(4);
                return;
            }
            this.pcC.setVisibility(0);
            this.pcC.Ad(this.sNV.size());
            a = this.pcB.bRR();
            this.pcB.Ah(a);
            this.pcC.Ae(a);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            w.d("MicroMsg.AppPanel", "onConfigChanged:" + configuration.orientation);
            if (configuration.orientation == 1) {
                this.sOj = true;
            } else {
                this.sOj = false;
            }
            this.sOn = true;
            anM();
        }
    }

    public final void anM() {
        this.pcy = false;
        this.pcB.Ah(0);
        bFi();
        requestLayout();
    }

    public final void xz(int i) {
        if (this.sOo != i) {
            this.sOo = i;
            this.sOn = true;
        }
    }

    public final void bFk() {
        if (this.sOn) {
            LayoutParams layoutParams;
            int a;
            View view;
            ViewGroup.LayoutParams layoutParams2;
            View findViewById;
            if (bFh() == 2) {
                w.d("MicroMsg.AppPanel", "initFlipper, landscape");
                findViewById = findViewById(R.h.bpL);
                layoutParams = new LayoutParams(-1, 0);
                a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.context, (float) pco);
                view = findViewById;
                layoutParams2 = layoutParams;
            } else {
                w.d("MicroMsg.AppPanel", "initFlipper, portrait: %d", Integer.valueOf(pcn));
                findViewById = findViewById(R.h.bpL);
                ViewGroup.LayoutParams layoutParams3 = new LayoutParams(-1, 0);
                if (this.sOo > 0) {
                    a = this.sOo;
                    view = findViewById;
                    layoutParams2 = layoutParams3;
                } else {
                    a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.context, (float) pcn);
                    view = findViewById;
                    layoutParams2 = layoutParams3;
                }
            }
            layoutParams.height = a;
            view.setLayoutParams(layoutParams2);
            this.sOn = false;
        }
    }

    private static void bS(List<f> list) {
        if (list != null && !list.isEmpty()) {
            int i = 0;
            while (i < list.size()) {
                f fVar = (f) list.get(i);
                if (fVar == null || !f.sDe.equals(fVar.field_appId)) {
                    i++;
                } else {
                    list.remove(fVar);
                    return;
                }
            }
        }
    }

    private static boolean bFl() {
        l.c cVar = com.tencent.mm.pluginsdk.l.a.sBv;
        if (cVar == null || !cVar.afJ() || cVar.afM() <= 0) {
            return false;
        }
        return true;
    }
}
