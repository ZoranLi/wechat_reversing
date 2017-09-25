package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo.State;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public abstract class FreeWifiActivateStateUI extends MMActivity implements a, b {
    protected int cGa;
    private int fHm = 1;
    protected int fuV;
    protected String lUe;
    private aj lVA = new aj(new aj.a(this) {
        final /* synthetic */ FreeWifiActivateStateUI lVD;

        {
            this.lVD = r1;
        }

        public final boolean oQ() {
            if (!bg.mA(this.lVD.ssid)) {
                this.lVD.fHm = this.lVD.axh();
                w.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[]{this.lVD.ssid, Integer.valueOf(this.lVD.fHm)});
                this.lVD.lVB.KH();
                if (this.lVD.fHm != 2) {
                    this.lVD.axl();
                    this.lVD.axj();
                    d.a(this.lVD.ssid, 3, this.lVD.getIntent());
                }
            }
            return false;
        }
    }, false);
    private aj lVB = new aj(new aj.a(this) {
        final /* synthetic */ FreeWifiActivateStateUI lVD;

        {
            this.lVD = r1;
        }

        public final boolean oQ() {
            if (!d.wG(this.lVD.ssid)) {
                return true;
            }
            this.lVD.a(State.CONNECTED);
            this.lVD.lVB.KH();
            return false;
        }
    }, true);
    private j.a lVC = new j.a(this) {
        final /* synthetic */ FreeWifiActivateStateUI lVD;

        {
            this.lVD = r1;
        }

        public final void a(String str, l lVar) {
            this.lVD.fHm = this.lVD.axh();
            this.lVD.lW(this.lVD.fHm);
        }
    };
    private FreeWifiStateView lVr;
    private TextView lVs;
    private TextView lVt;
    private Button lVu;
    protected Button lVv;
    protected String lVw;
    protected FreeWifiNetworkReceiver lVx;
    protected boolean lVy = false;
    private boolean lVz = false;
    protected String ssid;

    protected abstract void Tq();

    protected abstract void axg();

    protected abstract int axh();

    static /* synthetic */ void d(FreeWifiActivateStateUI freeWifiActivateStateUI) {
        if (freeWifiActivateStateUI.lVx == null) {
            freeWifiActivateStateUI.axm();
        }
        freeWifiActivateStateUI.lVx.lTv = freeWifiActivateStateUI;
        d.awq();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r9) {
        /*
        r8 = this;
        r7 = 3;
        r6 = 2;
        r1 = 1;
        r2 = 0;
        super.onCreate(r9);
        r0 = r8.getIntent();
        r3 = "free_wifi_ssid";
        r0 = r0.getStringExtra(r3);
        r8.ssid = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_mid";
        r0 = r0.getStringExtra(r3);
        r8.lVw = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_url";
        r0 = r0.getStringExtra(r3);
        r8.lUe = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_source";
        r0 = r0.getIntExtra(r3, r1);
        r8.cGa = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_channel_id";
        r0 = r0.getIntExtra(r3, r2);
        r8.fuV = r0;
        r0 = r8.cGa;
        switch(r0) {
            case 1: goto L_0x00a3;
            case 2: goto L_0x006b;
            case 3: goto L_0x00a3;
            case 4: goto L_0x00a3;
            case 5: goto L_0x00a3;
            default: goto L_0x004d;
        };
    L_0x004d:
        r0 = r8.ssid;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 == 0) goto L_0x0101;
    L_0x0055:
        r0 = "MicroMsg.FreeWifi.FreeWifiActivateStateUI";
        r1 = "ssid is null";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
    L_0x005e:
        r8.KC();
        r0 = com.tencent.mm.plugin.freewifi.model.j.awC();
        r1 = r8.lVC;
        r0.c(r1);
        return;
    L_0x006b:
        r0 = com.tencent.mm.plugin.freewifi.model.j.awC();
        r0 = r0.axe();
        if (r0 == 0) goto L_0x0099;
    L_0x0075:
        r3 = r0.field_ssid;
        r8.ssid = r3;
        r3 = r0.field_mid;
        r8.lVw = r3;
        r0 = r0.field_url;
        r8.lUe = r0;
        r0 = "MicroMsg.FreeWifi.FreeWifiActivateStateUI";
        r3 = "source from mainui banner, ssid : %s, mid : %s, url : %s";
        r4 = new java.lang.Object[r7];
        r5 = r8.ssid;
        r4[r2] = r5;
        r5 = r8.lVw;
        r4[r1] = r5;
        r5 = r8.lUe;
        r4[r6] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r0, r3, r4);
        goto L_0x004d;
    L_0x0099:
        r0 = "MicroMsg.FreeWifi.FreeWifiActivateStateUI";
        r3 = "there is no connect sucessfull wifi info";
        com.tencent.mm.sdk.platformtools.w.i(r0, r3);
        goto L_0x004d;
    L_0x00a3:
        r0 = r8.ssid;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 == 0) goto L_0x00b5;
    L_0x00ab:
        r0 = "MicroMsg.FreeWifi.FreeWifiActivateStateUI";
        r1 = "ssid is null";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        goto L_0x005e;
    L_0x00b5:
        r0 = com.tencent.mm.plugin.freewifi.model.j.awC();
        r3 = r8.ssid;
        r0 = r0.wP(r3);
        if (r0 != 0) goto L_0x011e;
    L_0x00c1:
        r0 = new com.tencent.mm.plugin.freewifi.g.c;
        r0.<init>();
        r3 = r8.ssid;
        r3 = com.tencent.mm.sdk.platformtools.aa.Pq(r3);
        r0.field_ssidmd5 = r3;
        r3 = r8.ssid;
        r0.field_ssid = r3;
        r0.field_connectState = r1;
        r3 = r0;
        r0 = r1;
    L_0x00d6:
        r4 = r8.lUe;
        r3.field_url = r4;
        r4 = r8.lVw;
        r3.field_mid = r4;
        r4 = r8.getIntent();
        r5 = "free_wifi_auth_type";
        r4 = r4.getIntExtra(r5, r6);
        r3.field_wifiType = r4;
        if (r0 == 0) goto L_0x00f6;
    L_0x00ed:
        r0 = com.tencent.mm.plugin.freewifi.model.j.awC();
        r0.b(r3);
        goto L_0x004d;
    L_0x00f6:
        r0 = com.tencent.mm.plugin.freewifi.model.j.awC();
        r4 = new java.lang.String[r2];
        r0.c(r3, r4);
        goto L_0x004d;
    L_0x0101:
        r0 = "MicroMsg.FreeWifi.FreeWifiActivateStateUI";
        r3 = "ssid : %s, mid : %s, source : %d";
        r4 = new java.lang.Object[r7];
        r5 = r8.ssid;
        r4[r2] = r5;
        r2 = r8.lVw;
        r4[r1] = r2;
        r1 = r8.cGa;
        r1 = java.lang.Integer.valueOf(r1);
        r4[r6] = r1;
        com.tencent.mm.sdk.platformtools.w.i(r0, r3, r4);
        goto L_0x005e;
    L_0x011e:
        r3 = r0;
        r0 = r2;
        goto L_0x00d6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.onCreate(android.os.Bundle):void");
    }

    protected final int Ol() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
        if (!bg.mA(this.ssid)) {
            axn();
        }
    }

    protected void KC() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FreeWifiActivateStateUI lVD;

            {
                this.lVD = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lVD.goBack();
                return true;
            }
        });
        this.lVr = (FreeWifiStateView) findViewById(R.h.bRj);
        this.lVs = (TextView) findViewById(R.h.bRk);
        this.lVt = (TextView) findViewById(R.h.bRl);
        if (this.cGa == 3) {
            this.lVt.setText(getString(R.l.eAS, new Object[]{this.ssid}));
        } else {
            this.lVt.setText(getString(R.l.dXv, new Object[]{this.ssid}));
        }
        this.lVu = (Button) findViewById(R.h.cvn);
        this.lVu.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiActivateStateUI lVD;

            {
                this.lVD = r1;
            }

            public final void onClick(View view) {
                if (this.lVD.axh() == 2) {
                    this.lVD.finish();
                    return;
                }
                d.a(this.lVD.ssid, 1, this.lVD.getIntent());
                this.lVD.lVy = false;
                this.lVD.axn();
            }
        });
        this.lVv = (Button) findViewById(R.h.bWi);
        this.lVv.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiActivateStateUI lVD;

            {
                this.lVD = r1;
            }

            public final void onClick(View view) {
                String string = this.lVD.getString(R.l.emy);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.bb.d.b(this.lVD.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
    }

    protected final void axj() {
        if (this.lVx != null) {
            w.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister wifi state change receiver");
            this.lVx.lTv = null;
        }
    }

    protected final void axk() {
        if (this.lVx == null) {
            axm();
        }
        this.lVx.lTw = this;
    }

    protected final void axl() {
        if (this.lVx != null) {
            w.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister network changed receiver");
            this.lVx.lTw = null;
        }
    }

    private void axm() {
        this.lVx = new FreeWifiNetworkReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        registerReceiver(this.lVx, intentFilter);
    }

    protected final void axn() {
        if (d.isWifiEnabled()) {
            this.fHm = axh();
            w.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now before connect, the connect state : %d", new Object[]{Integer.valueOf(this.fHm)});
            if (this.fHm != 2) {
                this.lVA.v(60000, 60000);
                this.lVB.v(1000, 1000);
                if (d.wG(this.ssid)) {
                    w.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "start auth now, isAuting : %b", new Object[]{Boolean.valueOf(this.lVy)});
                    if (this.lVy) {
                        w.d("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now it is authing");
                        return;
                    }
                    this.lVA.v(60000, 60000);
                    this.lVB.v(1000, 1000);
                    Tq();
                    this.lVy = true;
                    return;
                }
                com.tencent.mm.plugin.freewifi.model.j.awF().awp().post(new Runnable(this) {
                    final /* synthetic */ FreeWifiActivateStateUI lVD;

                    {
                        this.lVD = r1;
                    }

                    public final void run() {
                        w.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now network ssid is not wechat freewifi :%s", new Object[]{this.lVD.ssid});
                        this.lVD.axg();
                    }
                });
                return;
            }
            lW(this.fHm);
            return;
        }
        this.lVA.v(60000, 60000);
        this.lVB.v(1000, 1000);
        w.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "wifi is not enable, enable it");
        com.tencent.mm.plugin.freewifi.model.j.awF().awp().post(new Runnable(this) {
            final /* synthetic */ FreeWifiActivateStateUI lVD;

            {
                this.lVD = r1;
            }

            public final void run() {
                FreeWifiActivateStateUI.d(this.lVD);
            }
        });
    }

    protected final void lW(int i) {
        this.lVr.setOnClickListener(null);
        w.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "Current connection state : %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case -2014:
                this.lVA.KH();
                this.lVB.KH();
                this.lVr.setImageResource(R.g.bfo);
                this.lVr.setState(3);
                this.lVs.setText(R.l.emB);
                this.lVs.setVisibility(0);
                this.lVt.setText(R.l.emC);
                this.lVt.setVisibility(0);
                break;
            case 1:
                this.lVr.setImageResource(R.g.bfp);
                this.lVr.setState(1);
                this.lVs.setText(R.l.dXs);
                break;
            case 2:
                this.lVr.setImageResource(R.g.bfn);
                this.lVr.setState(2);
                this.lVs.setText(R.l.dXr);
                this.lVu.setVisibility(0);
                this.lVu.setText(R.l.emh);
                this.lVA.KH();
                this.lVB.KH();
                if (this.cGa == 1 || this.cGa == 5 || this.cGa == 4) {
                    this.lVu.setVisibility(4);
                    final c wP = com.tencent.mm.plugin.freewifi.model.j.awC().wP(this.ssid);
                    if (!(wP == null || bg.mA(wP.field_showUrl) || this.lVz)) {
                        this.lVz = true;
                        af.f(new Runnable(this) {
                            final /* synthetic */ FreeWifiActivateStateUI lVD;

                            public final void run() {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", wP.field_showUrl + "&lang=" + v.d(this.lVD.getSharedPreferences(ab.bIX(), 0)));
                                intent.putExtra("show_bottom", false);
                                intent.putExtra("stastic_scene", 7);
                                com.tencent.mm.bb.d.b(this.lVD, "webview", ".ui.tools.WebViewUI", intent);
                                w.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "jump to ad page after auth success, url is : %s", new Object[]{intent.getStringExtra("rawUrl")});
                                this.lVD.finish();
                            }
                        }, 1000);
                    }
                }
                d.qg();
                return;
            case 3:
                this.lVr.setImageResource(R.g.bfp);
                this.lVr.setState(3);
                this.lVr.lkG = 2;
                this.lVs.setText(R.l.dXw);
                this.lVu.setVisibility(0);
                this.lVu.setText(R.l.emK);
                this.lVA.KH();
                this.lVB.KH();
                return;
            default:
                this.lVr.setImageResource(R.g.bfp);
                this.lVs.setText(R.l.dXs);
                if (this.cGa != 3) {
                    this.lVt.setText(getString(R.l.dXv, new Object[]{this.ssid}));
                    break;
                }
                this.lVt.setText(getString(R.l.eAS, new Object[]{this.ssid}));
                break;
        }
        this.lVu.setVisibility(8);
    }

    protected final int getLayoutId() {
        return R.i.ddy;
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.freewifi.model.j.awC().f(this.lVC);
        axj();
        axl();
        if (this.lVx != null) {
            unregisterReceiver(this.lVx);
        }
        this.lVA.KH();
        this.lVB.KH();
        com.tencent.mm.plugin.freewifi.model.j.awF().release();
    }

    public final void mM(int i) {
        w.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now wifi state : %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 3:
                axj();
                axn();
                return;
            default:
                return;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        finish();
        if (getIntent().getBooleanExtra("free_wifi_jump_to_main_ui", false)) {
            g.imv.i(new Intent(), this);
        }
    }
}
