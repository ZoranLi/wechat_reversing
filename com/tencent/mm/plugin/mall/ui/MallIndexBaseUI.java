package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.mq;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.z;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.x;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class MallIndexBaseUI extends WalletBaseUI implements a, i {
    private String nqr = null;
    private String nvf = null;
    private ArrayList<MallFunction> nvg = null;
    protected int nvk;
    private TextView nwf = null;
    protected ListView nwg = null;
    private b nwh = null;
    protected ImageView nwi = null;
    protected ImageView nwj;
    protected TextView nwk = null;
    protected TextView nwl;
    private int nwm = 0;
    private boolean nwn = true;
    private boolean nwo = false;

    protected abstract void aIV();

    protected abstract void aIW();

    protected abstract void aIX();

    protected abstract boolean aIZ();

    protected abstract void aJe();

    protected abstract void aJf();

    protected abstract void aJh();

    protected abstract void aJi();

    protected abstract void cj(View view);

    protected final int getLayoutId() {
        return R.i.dhO;
    }

    public void onCreate(Bundle bundle) {
        w.i("MicroMsg.MallIndexBaseUI", "onCreate");
        super.onCreate(bundle);
        if (!ap.zb()) {
            w.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
            finish();
        }
        ap.yY();
        int intValue = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.uDY, Integer.valueOf(0))).intValue();
        this.nvk = getIntent().getIntExtra("key_wallet_region", intValue);
        hn(495);
        m.btZ();
        z.a(this);
        this.nvf = getIntent().getStringExtra("key_func_id");
        w.i("MicroMsg.MallIndexBaseUI", "mFuncId:" + this.nvf + " wallet_region: " + this.nvk + " walletType: " + com.tencent.mm.u.m.xS() + " default_region: " + intValue);
        this.nqr = getIntent().getStringExtra("key_native_url");
        w.i("MicroMsg.MallIndexBaseUI", "mNativeUrl:" + this.nqr);
        if (!aIY()) {
            re(0);
            w.i("MicroMsg.MallIndexBaseUI", "index Oncreate");
            aIV();
            KC();
            com.tencent.mm.plugin.wallet_core.model.mall.c.buF();
            aIW();
            w.i("MicroMsg.MallIndexBaseUI", "hy: use default controller for MallIndexUI");
            aIX();
            if (com.tencent.mm.u.m.xY()) {
                w.e("MicroMsg.MallIndexBaseUI", "it is payu account ,not initFingerPrint");
            } else {
                d dVar = l.a.sBC;
                if (dVar != null) {
                    w.i("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null, do showFingerPrintEntrance()");
                    dVar.bY(this);
                } else {
                    w.e("MicroMsg.MallIndexBaseUI", "IFingerPrintMgr is not null");
                }
            }
            o.ev(1, 0);
            g.oUh.i(11850, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
        }
    }

    public final boolean aIY() {
        if (bg.mA(this.nvf) && bg.mA(this.nqr)) {
            return false;
        }
        return true;
    }

    public void onResume() {
        boolean z = true;
        super.onResume();
        f.xT(1);
        w.i("MicroMsg.MallIndexBaseUI", "index onResume");
        if (!ap.zb()) {
            w.v("MicroMsg.MallIndexBaseUI", "MMCore is not ready");
            finish();
        }
        if (aIY()) {
            this.nvg = com.tencent.mm.plugin.mall.a.c.aIQ().pf(this.nvk);
            if (this.nvg == null || this.nvg.size() <= 0) {
                w.i("MicroMsg.MallIndexBaseUI", "mFunctionList == null");
                try {
                    if (getIntent().getIntExtra("key_scene", 0) == 1 || !bg.mA(this.nqr)) {
                        q(new com.tencent.mm.plugin.mall.a.a(this.nvk, b.buB()));
                        return;
                    }
                    String stringExtra = getIntent().getStringExtra("key_url");
                    if (stringExtra == null) {
                        stringExtra = "";
                    }
                    q(new com.tencent.mm.plugin.mall.a.a(this.nvk, b.buB(), getIntent().getStringExtra("key_app_id"), this.nvf, stringExtra));
                    return;
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.MallIndexBaseUI", e, "", new Object[0]);
                    aJd();
                    return;
                }
            }
            MallFunction aQ = aQ(this.nvg);
            if (aQ == null) {
                aQ = aR(this.nvg);
            }
            a(aQ, -1);
            finish();
            return;
        }
        aIZ();
        w.d("MicroMsg.MallIndexBaseUI", "initFunctionList");
        if (com.tencent.mm.plugin.mall.a.c.aIQ().pf(this.nvk) == null) {
            b(new com.tencent.mm.plugin.mall.a.a(this.nvk, b.buB()), true);
            w.e("MicroMsg.MallIndexBaseUI", "funcitonlist invalid");
            z = false;
        } else {
            b(new com.tencent.mm.plugin.mall.a.a(this.nvk, b.buB()), false);
            this.nvg = com.tencent.mm.plugin.mall.a.c.aIQ().pf(this.nvk);
        }
        if (z) {
            w.i("MicroMsg.MallIndexBaseUI", "has data");
            ar();
        }
    }

    private void aJa() {
        boolean booleanExtra = getIntent().getBooleanExtra("key_wallet_has_red", false);
        if (this.nwg.getChildCount() != 0) {
            w.i("MicroMsg.MallIndexBaseUI", "initCheckNew %s fpos %s top %s", new Object[]{Boolean.valueOf(booleanExtra), Integer.valueOf(this.nwg.getFirstVisiblePosition()), Integer.valueOf(this.nwg.getChildAt(0).getTop())});
            if (this.nwg.getFirstVisiblePosition() == 0 && r2 == 0 && booleanExtra && !this.nwo && this.nvg != null) {
                this.nwo = true;
                int count = this.nwh.getCount() + this.nwg.getHeaderViewsCount();
                List list = this.nwh.nvC;
                if (list != null) {
                    int i = count;
                    for (count = list.size() - 1; count > 0; count--) {
                        Iterator it = ((ArrayList) list.get(count)).iterator();
                        while (it.hasNext()) {
                            c cVar = (c) it.next();
                            if (cVar != null && cVar.nwd != null && b.a(cVar.nwd)) {
                                w.i("MicroMsg.MallIndexBaseUI", "get listview show top %s bottom %s redPos: %d", new Object[]{Integer.valueOf(this.nwg.getFirstVisiblePosition()), Integer.valueOf(this.nwg.getLastVisiblePosition()), Integer.valueOf(i)});
                                if (i < this.nwg.getFirstVisiblePosition() || i > r1) {
                                    count = a.aIT();
                                    int aIS = (a.aIS() + (a.aIR() * (i + 1))) + count;
                                    if (i > 2) {
                                        aIS += count;
                                    }
                                    if (i > 3) {
                                        aIS += count;
                                    }
                                    count = (aIS + (a.aIR() / 3)) - this.nwg.getScrollY();
                                    aIS = x.eG(this).y;
                                    if (x.eF(this)) {
                                        aIS -= x.eE(this);
                                    }
                                    if (cO().cP() != null) {
                                        aIS -= cO().cP().getHeight();
                                    }
                                    this.nwg.smoothScrollBy(count - aIS, 1000);
                                    return;
                                }
                                return;
                            }
                        }
                        i--;
                    }
                }
            }
        }
    }

    public void a(MallFunction mallFunction, int i) {
        int i2;
        if (mallFunction != null && i >= 0) {
            String str = "";
            if (!(mallFunction.rID == null || bg.mA(mallFunction.rID.qSx))) {
                str = mallFunction.rID.qSx;
            }
            int size = this.nvg == null ? 0 : this.nvg.size();
            boolean a = b.a(mallFunction);
            g gVar = g.oUh;
            Object[] objArr = new Object[6];
            objArr[0] = mallFunction.oKW;
            objArr[1] = Integer.valueOf(size);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(i);
            objArr[4] = str;
            if (a) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            objArr[5] = Integer.valueOf(i2);
            gVar.i(10881, objArr);
        }
        if (mallFunction == null || bg.mA(mallFunction.fZF) || !((com.tencent.mm.plugin.appbrand.i.d) h.h(com.tencent.mm.plugin.appbrand.i.d.class)).pM(mallFunction.fZF)) {
            if (mallFunction != null) {
                com.tencent.mm.plugin.wallet_core.model.mall.c.buC().Ib(mallFunction.oKW);
                com.tencent.mm.plugin.wallet_core.model.mall.d.buG().Ib(mallFunction.oKW);
                if (mallFunction.rID != null) {
                    com.tencent.mm.plugin.wallet_core.model.mall.c.buC();
                    com.tencent.mm.plugin.wallet_core.model.mall.c.c(mallFunction);
                }
                if ("wxpay://bizmall/mobile_recharge".equals(mallFunction.fZF)) {
                    i2 = 0;
                } else if ("wxpay://bizmall/weixin_hongbao".equals(mallFunction.fZF)) {
                    i2 = 4;
                } else if ("wxpay://bizmall/weixin_scan_qrcode".equals(mallFunction.fZF)) {
                    i2 = 8;
                } else if ("wxpay://bizmall/weixin_transfer".equals(mallFunction.fZF)) {
                    i2 = 5;
                } else if ("wxpay://bizmall/weixin_offline_pay".equals(mallFunction.fZF)) {
                    i2 = 6;
                } else if ("wxpay://bizmall/old_mobile_recharge".equals(mallFunction.fZF)) {
                    i2 = 7;
                } else if (!bg.mA(mallFunction.mER)) {
                    i2 = 1;
                } else if ("wxpay://bizmall/f2f_hongbao".equals(mallFunction.fZF)) {
                    i2 = 9;
                } else {
                    w.w("MicroMsg.MallIndexUIHelper", "doSelectFunction no jump");
                    i2 = 2;
                }
            } else {
                i2 = 3;
            }
            w.i("MicroMsg.MallIndexBaseUI", "functionType : " + i2);
            Intent intent;
            switch (i2) {
                case 0:
                    intent = new Intent();
                    if (aIY()) {
                        intent.putExtra("key_is_hide_progress", true);
                    }
                    intent.putExtra("key_func_info", mallFunction);
                    com.tencent.mm.bb.d.b(this, "recharge", ".ui.PhoneRechargeUI", intent);
                    o.ev(15, 0);
                    return;
                case 1:
                    intent = new Intent();
                    intent.putExtra("rawUrl", mallFunction.mER);
                    intent.putExtra("geta8key_username", com.tencent.mm.u.m.xL());
                    intent.putExtra("pay_channel", 1);
                    intent.putExtra("KPublisherId", "pay_wallet");
                    com.tencent.mm.bb.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    return;
                case 2:
                    w.w("MicroMsg.MallIndexBaseUI", "doSelectFunction no jump");
                    return;
                case 3:
                    w.w("MicroMsg.MallIndexBaseUI", "doSelectFunction do nothing");
                    s.makeText(this, "fuction list error", 1).show();
                    return;
                case 4:
                    g.oUh.i(11701, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
                    intent = new Intent();
                    intent.putExtra("pay_channel", 1);
                    com.tencent.mm.bb.d.b(this, "luckymoney", ".ui.LuckyMoneyIndexUI", intent);
                    o.ev(13, 0);
                    g.oUh.i(11850, new Object[]{Integer.valueOf(4), Integer.valueOf(0)});
                    return;
                case 5:
                    g.oUh.i(11458, new Object[]{Integer.valueOf(1)});
                    if (com.tencent.mm.u.m.xY()) {
                        List linkedList = new LinkedList();
                        List linkedList2 = new LinkedList();
                        linkedList.add(getString(R.l.eLB));
                        linkedList2.add(Integer.valueOf(0));
                        linkedList.add(getString(R.l.dXa));
                        linkedList2.add(Integer.valueOf(1));
                        com.tencent.mm.ui.base.g.a(this, getString(R.l.eKw), linkedList, linkedList2, null, true, new com.tencent.mm.ui.base.g.d(this) {
                            final /* synthetic */ MallIndexBaseUI nwp;

                            {
                                this.nwp = r1;
                            }

                            public final void bN(int i, int i2) {
                                switch (i2) {
                                    case 0:
                                        g.oUh.i(11458, new Object[]{Integer.valueOf(2)});
                                        if (com.tencent.mm.u.m.xY()) {
                                            com.tencent.mm.wallet_core.a.b(this.nwp.uSU.uTo, "PayURemittanceProcess", null);
                                            return;
                                        } else {
                                            com.tencent.mm.wallet_core.a.b(this.nwp.uSU.uTo, "RemittanceProcess", null);
                                            return;
                                        }
                                    case 1:
                                        g.oUh.i(11458, new Object[]{Integer.valueOf(3)});
                                        e.P(this.nwp, 2);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        });
                    } else {
                        ap.yY();
                        if (((Boolean) c.vr().get(com.tencent.mm.storage.w.a.uAq, Boolean.valueOf(false))).booleanValue()) {
                            aJg();
                        } else {
                            ap.yY();
                            c.vr().a(com.tencent.mm.storage.w.a.uAq, Boolean.valueOf(true));
                            com.tencent.mm.ui.base.g.a(this, getString(R.l.ffT), "", new OnClickListener(this) {
                                final /* synthetic */ MallIndexBaseUI nwp;

                                {
                                    this.nwp = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.nwp.aJg();
                                }
                            });
                        }
                    }
                    o.ev(14, 0);
                    g.oUh.i(11850, new Object[]{Integer.valueOf(3), Integer.valueOf(0)});
                    return;
                case 6:
                    intent = new Intent();
                    intent.putExtra("key_from_scene", 1);
                    com.tencent.mm.bb.d.b(this.uSU.uTo, "offline", ".ui.WalletOfflineEntranceUI", intent);
                    o.ev(9, 0);
                    g.oUh.i(11850, new Object[]{Integer.valueOf(5), Integer.valueOf(0)});
                    return;
                case 7:
                    intent = new Intent();
                    if (aIY()) {
                        intent.putExtra("key_is_hide_progress", true);
                    }
                    intent.putExtra("key_func_info", mallFunction);
                    com.tencent.mm.bb.d.b(this, "recharge", ".ui.RechargeUI", intent);
                    return;
                case 8:
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", 1);
                    com.tencent.mm.bb.d.b(this.uSU.uTo, "scanner", ".ui.BaseScanUI", intent);
                    return;
                case 9:
                    com.tencent.mm.bb.d.w(this.uSU.uTo, "luckymoney", ".f2f.ui.LuckyMoneyF2FQRCodeUI");
                    return;
                default:
                    return;
            }
        }
        w.i("MicroMsg.MallIndexBaseUI", "handleFunction, intercept by AppBrandNativeLink, nativeUrl = %s", new Object[]{mallFunction.fZF});
        com.tencent.mm.plugin.wallet_core.model.mall.c.buC().Ib(mallFunction.oKW);
        com.tencent.mm.plugin.wallet_core.model.mall.d.buG().Ib(mallFunction.oKW);
        if (mallFunction.rID != null) {
            com.tencent.mm.plugin.wallet_core.model.mall.c.buC();
            com.tencent.mm.plugin.wallet_core.model.mall.c.c(mallFunction);
        }
    }

    public void onDestroy() {
        ho(495);
        m.btZ();
        z.b(this);
        super.onDestroy();
    }

    public boolean d(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.MallIndexBaseUI", "onOtherSceneEnd");
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.b.a) {
            w.d("MicroMsg.MallIndexBaseUI", "hy: query bound scene end");
            if (i != 0 || i2 != 0) {
                finish();
                return true;
            } else if (this.nwn) {
                this.nwn = false;
                if (m.btO().buL().buj()) {
                    com.tencent.mm.wallet_core.a.b(this, "PayUOpenProcess", null);
                    return true;
                }
            }
        }
        switch (kVar.getType()) {
            case 495:
                com.tencent.mm.plugin.mall.a.a aVar = (com.tencent.mm.plugin.mall.a.a) kVar;
                if (aVar.nvk != this.nvk) {
                    w.i("MicroMsg.MallIndexBaseUI", "pass wallet local: %d cgi: %d", new Object[]{Integer.valueOf(this.nvk), Integer.valueOf(aVar.nvk)});
                }
                if (aIY()) {
                    w.d("MicroMsg.MallIndexBaseUI", "errorType:%d | errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    if (i != 0 || i2 != 0 || aVar.nvg == null || aVar.nvg.size() <= 0) {
                        aJd();
                        return true;
                    }
                    MallFunction aQ;
                    if (getIntent().getIntExtra("key_scene", 0) == 1) {
                        aQ = aQ(aVar.nvg);
                        if (aQ != null) {
                            a(aQ, -1);
                        }
                    } else if (!bg.mA(this.nqr)) {
                        w.d("MicroMsg.MallIndexBaseUI", "NativeUrl: %s", new Object[]{this.nqr});
                        aQ = aR(aVar.nvg);
                        if (aQ != null) {
                            a(aQ, -1);
                        } else {
                            aJd();
                            return true;
                        }
                    } else if (aVar.nvg != null && aVar.nvg.size() > 0) {
                        w.i("MicroMsg.MallIndexBaseUI", "functionScene.mFunctionList != null");
                        a(aQ(aVar.nvg), -1);
                    } else if (com.tencent.mm.plugin.mall.a.c.aIQ().pf(this.nvk) == null || com.tencent.mm.plugin.mall.a.c.aIQ().pf(this.nvk).size() <= 0) {
                        w.e("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() == null");
                    } else {
                        w.i("MicroMsg.MallIndexBaseUI", "SubCoreMall.getCore().getFunctionList() != null");
                        a(aQ(com.tencent.mm.plugin.mall.a.c.aIQ().pf(this.nvk)), -1);
                    }
                    setResult(-1);
                    finish();
                    return true;
                }
                if (i == 0 && i2 == 0 && com.tencent.mm.plugin.mall.a.c.aIQ().pf(this.nvk) != null && aVar.nvg != null && aVar.nvg.size() > 0) {
                    this.nvg = com.tencent.mm.plugin.mall.a.c.aIQ().pf(this.nvk);
                    w.i("MicroMsg.MallIndexBaseUI", "get from server now! " + this.nvk + " " + this.nvg.size());
                    com.tencent.mm.plugin.wallet_core.model.mall.c.buC().U(this.nvg);
                }
                ar();
                aJa();
                return true;
            default:
                return false;
        }
    }

    private MallFunction aQ(List<MallFunction> list) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(this.nvf)) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            MallFunction mallFunction = (MallFunction) list.get(i);
            if (mallFunction != null && this.nvf.equals(mallFunction.oKW)) {
                return mallFunction;
            }
        }
        return null;
    }

    private MallFunction aR(List<MallFunction> list) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(this.nqr)) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            MallFunction mallFunction = (MallFunction) list.get(i);
            if (mallFunction != null && this.nqr.equals(mallFunction.fZF)) {
                return mallFunction;
            }
        }
        return null;
    }

    protected final boolean aJb() {
        if (!aIY()) {
            ar();
        }
        return true;
    }

    public final boolean aJc() {
        return false;
    }

    public final void k(String str, Bitmap bitmap) {
    }

    private void aJd() {
        setResult(0);
        finish();
    }

    private void ar() {
        ks(true);
        b bVar = this.nwh;
        ArrayList arrayList = this.nvg;
        bVar.nvC.clear();
        if (arrayList != null) {
            int i;
            int i2;
            int i3 = 0;
            while (i3 < arrayList.size()) {
                ArrayList arrayList2 = new ArrayList();
                i = 0;
                while (i < 3 && i3 + i < arrayList.size()) {
                    int i4 = i3 + i;
                    if (i > 0) {
                        i2 = (i3 + i) - 1;
                        if (i2 >= 0 && ((MallFunction) arrayList.get(i2)).type != ((MallFunction) arrayList.get(i4)).type) {
                            break;
                        }
                    }
                    c cVar = new c(bVar);
                    cVar.nwe = i3 + i;
                    cVar.nwd = (MallFunction) arrayList.get(i3 + i);
                    arrayList2.add(cVar);
                    i++;
                }
                if (arrayList2.size() > 0) {
                    bVar.nvC.add(arrayList2);
                }
                i3 += i;
            }
            bVar.nvF = 0;
            bVar.nvG = 0;
            i = -1;
            for (ArrayList arrayList3 : bVar.nvC) {
                if (arrayList3.size() > 0) {
                    if (i != -1 && i != ((c) arrayList3.get(0)).nwd.type) {
                        break;
                    }
                    bVar.nvF += arrayList3.size();
                    bVar.nvG++;
                    i2 = ((c) arrayList3.get(0)).nwd.type;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            bVar.nvG--;
        }
        bVar.nvj = com.tencent.mm.plugin.mall.a.c.aIQ().pe(bVar.nvk).nvj;
        bVar.nvH = bVar.aIU();
        bVar.notifyDataSetChanged();
        aJf();
        aJh();
        if (this.nwf != null) {
            this.nwf.setVisibility(8);
        }
        aJi();
    }

    public void onStop() {
        super.onStop();
    }

    public final void KC() {
        w.d("MicroMsg.MallIndexBaseUI", "index initView");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MallIndexBaseUI nwp;

            {
                this.nwp = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("preferred_tab", 3);
                com.tencent.mm.bb.d.a(this.nwp, "com.tencent.mm.ui.LauncherUI", intent);
                this.nwp.finish();
                g.oUh.i(14419, new Object[]{Integer.valueOf(6)});
                w.i("MicroMsg.MallIndexBaseUI", "set BackBtn");
                return true;
            }
        });
        a.c(this);
        this.nwg = (ListView) findViewById(R.h.chi);
        View inflate = r.eC(this).inflate(R.i.dhN, null);
        this.nwg.addHeaderView(inflate);
        LayoutParams layoutParams = (AbsListView.LayoutParams) inflate.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2);
        }
        layoutParams.height = a.aIS();
        inflate.setLayoutParams(layoutParams);
        this.nwh = new b(this, this.nvk);
        this.nwg.setAdapter(this.nwh);
        this.nwh.nvD = new b.d(this) {
            final /* synthetic */ MallIndexBaseUI nwp;

            {
                this.nwp = r1;
            }

            public final void a(final int i, final MallFunction mallFunction) {
                if (mallFunction != null) {
                    int i2;
                    String str = mallFunction.oKW;
                    if (bg.mA(str)) {
                        i2 = 1;
                    } else {
                        ap.yY();
                        String str2 = (String) c.vr().get(com.tencent.mm.storage.w.a.uCM, null);
                        if (bg.mA(str2)) {
                            i2 = 0;
                        } else {
                            String[] split = str2.split(",");
                            if (split == null || split.length == 0) {
                                i2 = 0;
                            } else {
                                for (String equals : split) {
                                    if (equals.equals(str)) {
                                        i2 = 1;
                                        break;
                                    }
                                }
                                i2 = 0;
                            }
                        }
                    }
                    if (i2 != 0 || bg.mA(mallFunction.rIE)) {
                        this.nwp.a(mallFunction, i);
                    } else {
                        w.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick show disclaimer funcId=%s", new Object[]{mallFunction.oKW});
                        com.tencent.mm.ui.base.g.a(this.nwp.uSU.uTo, mallFunction.rIE, this.nwp.getString(R.l.eAt), this.nwp.getString(R.l.dAN), new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass2 nws;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Object obj = null;
                                String str = mallFunction.oKW;
                                if (!bg.mA(str)) {
                                    ap.yY();
                                    Object obj2 = (String) c.vr().get(com.tencent.mm.storage.w.a.uCM, null);
                                    if (bg.mA(obj2)) {
                                        obj2 = str;
                                    } else {
                                        String[] split = obj2.split(",");
                                        if (split == null || split.length == 0) {
                                            String str2 = str;
                                        } else {
                                            for (String equals : split) {
                                                if (equals.equals(str)) {
                                                    obj = 1;
                                                    break;
                                                }
                                            }
                                            if (obj == null) {
                                                obj2 = obj2 + "," + str;
                                            }
                                        }
                                    }
                                    ap.yY();
                                    c.vr().a(com.tencent.mm.storage.w.a.uCM, obj2);
                                }
                                this.nws.nwp.a(mallFunction, i);
                            }
                        });
                    }
                    g.oUh.i(14419, new Object[]{Integer.valueOf(4)});
                    return;
                }
                w.w("MicroMsg.MallIndexBaseUI", "onFunctionItemClick functionItem null; pos=%d", new Object[]{Integer.valueOf(i)});
            }
        };
        cj(inflate);
        this.nwl = (TextView) findViewById(R.h.bsx);
        aJe();
    }

    private void aJg() {
        if (com.tencent.mm.u.m.xY()) {
            com.tencent.mm.wallet_core.a.b(this.uSU.uTo, "PayURemittanceProcess", null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("pay_channel", 1);
        com.tencent.mm.wallet_core.a.b(this.uSU.uTo, "RemittanceProcess", bundle);
    }

    public void finish() {
        super.finish();
    }

    protected final int Ol() {
        return 1;
    }

    public final void pg(int i) {
        if (i == 12 && this.nwk != null) {
            aJf();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            ap.yY();
            this.nvk = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.uDY, Integer.valueOf(0))).intValue();
            if (i2 != -1) {
                return;
            }
            if (com.tencent.mm.u.m.xZ()) {
                finish();
                return;
            }
            finish();
            com.tencent.mm.sdk.b.b mqVar = new mq();
            mqVar.fTW.context = this.uSU.uTo;
            com.tencent.mm.sdk.b.a.urY.m(mqVar);
        }
    }

    protected final void aJj() {
        com.tencent.mm.bb.d.b(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
    }

    protected static void E(Activity activity) {
        w.i("MicroMsg.WalletSwitchConfig", "isShowH5TradeDetail, ret = %s switchBit %s", new Object[]{Boolean.valueOf((m.btS().buq().rIi & 65536) > 0), Integer.valueOf(m.btS().buq().rIi)});
        if ((m.btS().buq().rIi & 65536) > 0) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", "https://wx.tenpay.com/userroll/readtemplate?t=userroll/index_tmpl");
            com.tencent.mm.bb.d.b(activity, "webview", ".ui.tools.WebViewUI", intent);
        } else {
            com.tencent.mm.wallet_core.a.b(activity, "ShowOrdersInfoProcess", null);
        }
        com.tencent.mm.wallet_core.ui.e.CM(20);
    }
}
