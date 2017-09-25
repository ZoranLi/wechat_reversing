package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.c.a.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;

public class ExdeviceConnectedRouterActivateStateUI extends MMActivity {
    private String appId;
    private String fGl;
    private String fwJ;
    private String laQ;
    private ExdeviceConnectedRouterStateView lkA;
    private TextView lkB;
    private TextView lkC;
    private b<a> lkD = new b<a>(this) {
        final /* synthetic */ ExdeviceConnectedRouterActivateStateUI lkE;

        {
            this.lkE = r1;
        }

        public final /* synthetic */ void b(final int i, final int i2, String str, k kVar) {
            try {
                w.d("MicroMsg.ConnectedRouterActivateStateUi", "onNetSceneEndCallback, errType(%s), errCode(%s), errMsg(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                if (this.lkE.isFinishing()) {
                    w.i("MicroMsg.ConnectedRouterActivateStateUi", "ExdeviceConnectedRouter destroyed.");
                } else {
                    this.lkE.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 lkF;

                        public final void run() {
                            if (i2 == 0 && (i == 0 || i == 4)) {
                                this.lkF.lkE.lW(2);
                            } else if (i != 4) {
                                this.lkF.lkE.lW(4);
                            } else if (i2 == 90000) {
                                this.lkF.lkE.lW(3);
                            } else {
                                this.lkF.lkE.lW(5);
                            }
                        }
                    });
                }
            } catch (Exception e) {
                w.d("MicroMsg.ConnectedRouterActivateStateUi", e.toString());
            }
        }
    };
    private final int lkz = 90000;
    private String ssid;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.d("MicroMsg.ConnectedRouterActivateStateUi", "create activity");
        zi(R.l.efR);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceConnectedRouterActivateStateUI lkE;

            {
                this.lkE = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lkE.aqf();
                return true;
            }
        });
        this.lkA = (ExdeviceConnectedRouterStateView) findViewById(R.h.bMH);
        this.lkB = (TextView) findViewById(R.h.bMG);
        this.lkC = (TextView) findViewById(R.h.bMI);
        try {
            Uri parse = Uri.parse(getIntent().getStringExtra("key_connected_router"));
            this.fwJ = parse.getQueryParameter("deviceid");
            this.fGl = parse.getQueryParameter("devicetype");
            this.laQ = parse.getQueryParameter(ClientInfoTable.TABLE_NAME);
            this.appId = parse.getQueryParameter("appid");
            if (bg.mA(this.fwJ) || bg.mA(this.fGl) || bg.mA(this.laQ) || bg.mA(this.appId)) {
                w.e("MicroMsg.ConnectedRouterActivateStateUi", "loss param %s", new Object[]{parse.toString()});
                finish();
            }
            this.ssid = parse.getQueryParameter("ssid");
            w.d("MicroMsg.ConnectedRouterActivateStateUi", "uri: %s, deviceid: %s, devicetype: %s, clientinfo: %s. ssid: %s", new Object[]{parse.toString(), this.fwJ, this.fGl, this.laQ, this.ssid});
            if (this.ssid == null) {
                this.ssid = "";
            }
        } catch (Exception e) {
            w.d("MicroMsg.ConnectedRouterActivateStateUi", e.toString());
        }
        lW(1);
        ap.vd().a(new a(this.fwJ, this.fGl, this.laQ, this.appId, this.lkD), 0);
    }

    protected final int Ol() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
    }

    protected final void lW(int i) {
        this.lkA.setOnClickListener(null);
        w.d("MicroMsg.ConnectedRouterActivateStateUi", "Current connection state : %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 1:
                this.lkA.setImageResource(R.k.dwh);
                this.lkA.setState(1);
                this.lkB.setText(R.l.efL);
                return;
            case 2:
                this.lkA.setImageResource(R.k.dwi);
                this.lkA.setState(2);
                this.lkB.setText(getString(R.l.efP, new Object[]{this.ssid}));
                a(0, getString(R.l.efK), new OnMenuItemClickListener(this) {
                    final /* synthetic */ ExdeviceConnectedRouterActivateStateUI lkE;

                    {
                        this.lkE = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        this.lkE.aqf();
                        return true;
                    }
                });
                return;
            case 3:
                this.lkA.setImageResource(R.k.dwg);
                this.lkA.setState(3);
                this.lkA.lkG = 2;
                this.lkB.setText(R.l.efM);
                this.lkC.setText(getString(R.l.efN, new Object[]{this.ssid}));
                return;
            case 4:
                this.lkA.setImageResource(R.k.dwg);
                this.lkA.setState(3);
                this.lkA.lkG = 2;
                this.lkB.setText(R.l.efM);
                this.lkC.setText(getString(R.l.efO));
                return;
            case 5:
                this.lkA.setImageResource(R.k.dwg);
                this.lkA.setState(3);
                this.lkA.lkG = 2;
                this.lkB.setText(R.l.efM);
                this.lkC.setText(getString(R.l.efQ));
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.dby;
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        aqf();
        return true;
    }

    private void aqf() {
        finish();
        Intent intent = new Intent();
        intent.putExtra("From_fail_notify", true);
        w.d("MicroMsg.ConnectedRouterActivateStateUi", "startMainUI");
        d.a(this, "com.tencent.mm.ui.LauncherUI", intent);
    }
}
