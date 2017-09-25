package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.freewifi.d.l;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;

public class FreeWifiPcUI extends MMActivity {
    private String appId;
    private String fGV;
    private Button jMI;
    private String lUg;
    private Button lWs;
    private String lWy;
    private TextView lXn;
    private int lXo;
    private p lXp = null;

    static /* synthetic */ void a(FreeWifiPcUI freeWifiPcUI, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.putExtra("free_wifi_error_ui_error_msg_detail1", str2);
        intent.setClass(freeWifiPcUI, FreeWifiErrorUI.class);
        freeWifiPcUI.finish();
        freeWifiPcUI.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.emO);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FreeWifiPcUI lXq;

            {
                this.lXq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lXq.goBack();
                return true;
            }
        });
        this.appId = getIntent().getStringExtra("free_wifi_appid");
        this.lXo = getIntent().getIntExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", 0);
        this.fGV = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET");
        this.lUg = getIntent().getStringExtra("free_wifi_app_nickname");
        this.lWy = getIntent().getStringExtra("free_wifi_privacy_url");
        this.lXn = (TextView) findViewById(R.h.bRC);
        this.jMI = (Button) findViewById(R.h.bRD);
        this.lXn.setText("由" + this.lUg + "提供");
        this.jMI.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiPcUI lXq;

            {
                this.lXq = r1;
            }

            public final void onClick(View view) {
                this.lXq.jMI.setClickable(false);
                final aj ajVar = new aj(new a(this) {
                    final /* synthetic */ AnonymousClass2 lXr;

                    {
                        this.lXr = r1;
                    }

                    public final boolean oQ() {
                        this.lXr.lXq.lXp = g.a(this.lXr.lXq.uSU.uTo, this.lXr.lXq.getString(R.l.dXu), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass1 lXs;

                            {
                                this.lXs = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                            }
                        });
                        return true;
                    }
                }, false);
                ajVar.v(2000, 2000);
                k.a avZ = k.avZ();
                avZ.lRy = String.valueOf(this.lXq.lXo);
                avZ.lRz = this.lXq.appId;
                avZ.lRA = this.lXq.fGV;
                avZ.lRC = b.SetPcLoginUserInfo.lSn;
                avZ.lRD = b.SetPcLoginUserInfo.name;
                avZ.awb().awa();
                w.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=It starts NetSceneSetPcLoginUserInfo.shopid=%d, appid=%s, ticket=%s", new Object[]{m.y(this.lXq.getIntent()), Integer.valueOf(m.z(this.lXq.getIntent())), Integer.valueOf(this.lXq.lXo), this.lXq.appId, this.lXq.fGV});
                new l(this.lXq.appId, this.lXq.lXo, this.lXq.fGV).b(new e(this) {
                    final /* synthetic */ AnonymousClass2 lXr;

                    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
                        ajVar.KH();
                        if (i == 0 && i2 == 0) {
                            this.lXr.lXq.finish();
                        } else if (!m.ca(i, i2) || m.wx(str)) {
                            FreeWifiPcUI.a(this.lXr.lXq, this.lXr.lXq.getString(R.l.ems), this.lXr.lXq.getString(R.l.emt));
                        } else {
                            FreeWifiPcUI.a(this.lXr.lXq, str + "(" + m.a(m.A(this.lXr.lXq.getIntent()), b.SetPcLoginUserInfoReturn, i2) + ")", "");
                        }
                        k.a avZ = k.avZ();
                        avZ.lRy = String.valueOf(this.lXr.lXq.lXo);
                        avZ.lRz = this.lXr.lXq.appId;
                        avZ.lRA = this.lXr.lXq.fGV;
                        avZ.lRC = b.SetPcLoginUserInfoReturn.lSn;
                        avZ.lRD = b.SetPcLoginUserInfoReturn.name;
                        avZ.result = i2;
                        avZ.awb().awa();
                        w.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=NetSceneSetPcLoginUserInfo returns.shopid=%d, appid=%s, ticket=%s", new Object[]{m.y(this.lXr.lXq.getIntent()), Integer.valueOf(m.z(this.lXr.lXq.getIntent())), Integer.valueOf(this.lXr.lXq.lXo), this.lXr.lXq.appId, this.lXr.lXq.fGV});
                    }
                });
            }
        });
        this.lWs = (Button) findViewById(R.h.bRE);
        this.lWs.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiPcUI lXq;

            {
                this.lXq = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.lXq.lWy);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                d.b(this.lXq.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
    }

    protected final int Ol() {
        return 1;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        com.tencent.mm.plugin.freewifi.g.imv.i(new Intent(), this);
        finish();
    }

    protected final int getLayoutId() {
        return R.i.ddw;
    }
}
