package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.mall.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.bmj;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bmm;
import com.tencent.mm.protocal.c.bmn;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;

public class MallIndexOSUI extends MallIndexBaseUI {
    private long lastUpdateTime = 0;
    private a[] nwt = new a[3];
    private ab nwu = new ab();
    private TextView nwv = null;
    private View nww = null;
    private boolean nwx = false;

    class a {
        public TextView kvp;
        public CdnImageView nwD;
        public TextView nwE;
        final /* synthetic */ MallIndexOSUI nwz;
        public View view;

        a(MallIndexOSUI mallIndexOSUI) {
            this.nwz = mallIndexOSUI;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nww = View.inflate(this, R.i.dhL, null);
        this.nww.setClickable(false);
        this.nww.setEnabled(false);
        this.nwv = (TextView) this.nww.findViewById(R.h.cRD);
        this.nwu = m.btY().vz(this.nvk);
        hn(1577);
        w.i("MicroMsg.MallIndexOSUI", "walletMallIndexOsUI ");
        k bVar = new b();
        if (this.nwu != null) {
            ab abVar = this.nwu;
            boolean z = abVar.rHZ == null || abVar.rHZ.tCt == null || abVar.rHZ.tCt.size() == 0;
            if (!z) {
                b(bVar, false);
                return;
            }
        }
        q(bVar);
    }

    protected final void aJe() {
        e.a(this.nwl, "1", this.nwu.rIe, this.nwu.nnA);
    }

    public final void a(MallFunction mallFunction, int i) {
        super.a(mallFunction, i);
        g.oUh.i(13720, new Object[]{mallFunction.mER, Long.valueOf(bg.PZ(mallFunction.oKW))});
    }

    protected final void aIV() {
        String str = this.nwu.rIc;
        String str2 = this.nwu.rId;
        qP(str);
        SE(str2);
    }

    protected final void cj(View view) {
        this.nwt[0] = new a(this);
        this.nwt[0].view = view.findViewById(R.h.cpg);
        this.nwt[0].nwD = (CdnImageView) view.findViewById(R.h.cph);
        this.nwt[0].kvp = (TextView) view.findViewById(R.h.cpj);
        this.nwt[0].nwE = (TextView) view.findViewById(R.h.bNt);
        this.nwt[0].nwD.setVisibility(4);
        this.nwt[1] = new a(this);
        this.nwt[1].view = view.findViewById(R.h.brE);
        this.nwt[1].nwD = (CdnImageView) view.findViewById(R.h.brN);
        this.nwt[1].kvp = (TextView) view.findViewById(R.h.brQ);
        this.nwt[1].nwE = (TextView) view.findViewById(R.h.brM);
        this.nwt[1].nwD.setVisibility(4);
        this.nwt[2] = new a(this);
        this.nwt[2].view = view.findViewById(R.h.bsa);
        this.nwt[2].nwD = (CdnImageView) view.findViewById(R.h.bsr);
        this.nwt[2].kvp = (TextView) view.findViewById(R.h.bsu);
        this.nwt[2].nwE = (TextView) view.findViewById(R.h.bNu);
        this.nwt[2].nwD.setVisibility(4);
    }

    protected final void aIW() {
    }

    protected final void aIX() {
    }

    public void onResume() {
        super.onResume();
        w.d("MicroMsg.MallIndexOSUI", "checkUpdate svrTime: %d lastUpdateTime : %d  curTime %d", new Object[]{Integer.valueOf(com.tencent.mm.i.g.sV().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000), Long.valueOf(this.lastUpdateTime), Long.valueOf(System.currentTimeMillis())});
        if (System.currentTimeMillis() - this.lastUpdateTime >= ((long) (com.tencent.mm.i.g.sV().getInt("OverseaPayWalletInfoRefreshInternal", 15) * 1000))) {
            this.lastUpdateTime = System.currentTimeMillis();
            b(new b(), false);
        }
        aIV();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        ho(1577);
    }

    protected final boolean aIZ() {
        bmj com_tencent_mm_protocal_c_bmj = this.nwu.rHZ;
        for (int i = 0; i < this.nwt.length; i++) {
            this.nwt[i].view.setVisibility(8);
            this.nwt[i].nwD.setImageBitmap(null);
        }
        int i2 = 0;
        while (i2 < com_tencent_mm_protocal_c_bmj.tCt.size() && i2 < this.nwt.length) {
            final bmk com_tencent_mm_protocal_c_bmk = (bmk) com_tencent_mm_protocal_c_bmj.tCt.get(i2);
            this.nwt[i2].view.setVisibility(0);
            this.nwt[i2].nwD.L(n.a(com_tencent_mm_protocal_c_bmk.ulS), 0, 0);
            this.nwt[i2].nwD.setVisibility(0);
            this.nwt[i2].kvp.setText(n.a(com_tencent_mm_protocal_c_bmk.ulR));
            w.i("MicroMsg.MallIndexOSUI", "item %d url %s", new Object[]{Integer.valueOf(i2), n.a(com_tencent_mm_protocal_c_bmk.ulS)});
            this.nwt[i2].nwE.setVisibility(8);
            CharSequence a = n.a(com_tencent_mm_protocal_c_bmk.ulU);
            if (!bg.mA(a)) {
                this.nwt[i2].nwE.setText(a);
                this.nwt[i2].nwE.setVisibility(0);
            }
            this.nwt[i2].view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ MallIndexOSUI nwz;

                public final void onClick(View view) {
                    g.oUh.i(13867, new Object[]{n.a(com_tencent_mm_protocal_c_bmk.ulT), Integer.valueOf(this.nwz.nvk)});
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", n.a(com_tencent_mm_protocal_c_bmk.ulT));
                    intent.putExtra("geta8key_username", com.tencent.mm.u.m.xL());
                    intent.putExtra("pay_channel", 1);
                    d.b(this.nwz, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
            });
            i2++;
        }
        if (!(this.nwg == null || this.nww == null || this.nwx)) {
            this.nwg.addFooterView(this.nww);
            this.nwx = true;
        }
        if (!bg.mA(this.nwu.rIf)) {
            this.nwv.setText(this.nwu.rIf);
            this.nwv.setVisibility(0);
        }
        return true;
    }

    protected final void aJf() {
    }

    protected final void aJh() {
        this.uSU.bQf();
        a(0, R.g.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ MallIndexOSUI nwz;

            {
                this.nwz = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String[] strArr;
                final bmm com_tencent_mm_protocal_c_bmm = this.nwz.nwu.rIa;
                final boolean z = this.nwz.nwu.rIb;
                if (z) {
                    strArr = new String[(com_tencent_mm_protocal_c_bmm.tCt.size() + 1)];
                    strArr[com_tencent_mm_protocal_c_bmm.tCt.size()] = this.nwz.getString(R.l.ffY);
                } else {
                    strArr = new String[com_tencent_mm_protocal_c_bmm.tCt.size()];
                }
                for (int i = 0; i < com_tencent_mm_protocal_c_bmm.tCt.size(); i++) {
                    strArr[i] = n.a(((bmn) com_tencent_mm_protocal_c_bmm.tCt.get(i)).ulR);
                }
                com.tencent.mm.ui.base.g.a(this.nwz.uSU.uTo, null, strArr, null, false, new c(this) {
                    final /* synthetic */ AnonymousClass2 nwC;

                    public final void hq(int i) {
                        if (i < com_tencent_mm_protocal_c_bmm.tCt.size()) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", n.a(((bmn) com_tencent_mm_protocal_c_bmm.tCt.get(i)).ulW));
                            d.b(this.nwC.nwz, "webview", ".ui.tools.WebViewUI", intent);
                        } else if (z) {
                            this.nwC.nwz.aJj();
                        }
                    }
                });
                return true;
            }
        });
    }

    protected final void aJi() {
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        super.d(i, i2, str, kVar);
        if (kVar.getType() == 1577) {
            this.nwu = m.btY().vz(this.nvk);
            aJe();
            aIZ();
            aIV();
        }
        return true;
    }
}
