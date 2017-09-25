package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.a;

@a(3)
public class FreeWifiEntryUI extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onResume() {
        int i = 1;
        super.onResume();
        if (ap.zb()) {
            Intent intent = getIntent();
            w.i("MicroMsg.FreeWifi.FreeWifiEntryUI", "has notified, now scene is : %d", new Object[]{Integer.valueOf(getIntent().getIntExtra("free_wifi_source", 1))});
            switch (getIntent().getIntExtra("free_wifi_source", 1)) {
                case 1:
                    if (1 != a.lRv.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
                        a.lRv.aU("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
                    }
                    m.d(intent, intent.getStringExtra("free_wifi_mid"));
                    intent.setClass(this, FreeWifiNetCheckUI.class);
                    startActivity(intent);
                    super.overridePendingTransition(R.a.aRN, R.a.aRM);
                    break;
                case 2:
                    c wP = j.awC().wP(d.aww());
                    if (wP != null) {
                        w.i("MicroMsg.FreeWifi.FreeWifiEntryUI", "banner click, freeWifiInfo.field_action:%d, field_showUrl:%s", new Object[]{Integer.valueOf(wP.field_action), wP.field_showUrl});
                        if (wP.field_action != 2 || bg.mA(wP.field_showUrl)) {
                            if (wP.field_action == 1 && !bg.mA(wP.field_showUrl)) {
                                Intent intent2 = new Intent();
                                intent2.putExtra("rawUrl", Uri.parse(wP.field_showUrl).buildUpon().appendQueryParameter("lang", v.d(getSharedPreferences(ab.bIX(), 0))).build().toString());
                                intent2.putExtra("show_bottom", false);
                                com.tencent.mm.bb.d.b(this, "webview", ".ui.tools.WebViewUI", intent2);
                                break;
                            }
                            intent.setClass(this, FreeWifiAuthStateUI.class);
                            startActivity(intent);
                            break;
                        }
                        ((com.tencent.mm.plugin.appbrand.i.d) h.h(com.tencent.mm.plugin.appbrand.i.d.class)).b(this, wP.field_showUrl, 1064, null);
                        break;
                    }
                    w.e("MicroMsg.FreeWifi.FreeWifiEntryUI", "what the fuck, how could it be???");
                    break;
                    break;
                case 3:
                    intent.putExtra("free_wifi_auth_type", 2);
                    intent.setClass(this, FreeWifiMIGNoAuthStateUI.class);
                    startActivity(intent);
                    break;
                case 4:
                    if (1 != a.lRv.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
                        a.lRv.aU("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
                    }
                    intent.setClass(this, FreeWifiNetCheckUI.class);
                    startActivity(intent);
                    super.overridePendingTransition(R.a.aRN, R.a.aRM);
                    break;
                case 5:
                    if (1 != a.lRv.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
                        a.lRv.aU("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
                    }
                    String stringExtra = intent.getStringExtra("free_wifi_ap_key");
                    if (!m.wx(stringExtra)) {
                        getIntent().putExtra("free_wifi_channel_id", 1);
                        if (!"_p33beta".equalsIgnoreCase(stringExtra)) {
                            if (!stringExtra.startsWith("_")) {
                                int intExtra = intent.getIntExtra("free_wifi_threeone_startup_type", 0);
                                if (2 == intExtra) {
                                    i = 11;
                                } else if (3 == intExtra) {
                                    i = 12;
                                } else if (4 == intExtra) {
                                    i = 13;
                                }
                                intent.putExtra("free_wifi_channel_id", i);
                                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
                                m.d(intent, intent.getStringExtra("free_wifi_schema_ticket"));
                                if (intExtra == 4) {
                                    intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID", m.y(intent) + "_" + m.A(intent) + "_" + m.B(intent) + "_" + System.currentTimeMillis());
                                }
                                intent.setClass(this, FreeWifiNetCheckUI.class);
                                startActivity(intent);
                                super.overridePendingTransition(R.a.aRN, R.a.aRM);
                                break;
                            }
                            String string = getString(R.l.emw);
                            intent = new Intent();
                            intent.putExtra("free_wifi_error_ui_error_msg", string);
                            intent.setClass(this, FreeWifiErrorUI.class);
                            startActivity(intent);
                            super.overridePendingTransition(R.a.aRN, R.a.aRM);
                            break;
                        }
                        m.x(intent);
                        intent.putExtra("free_wifi_auth_type", 33);
                        intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 33);
                        intent.putExtra("free_wifi_ssid", m.wA("MicroMsg.FreeWifi.FreeWifiEntryUI"));
                        intent.putExtra("free_wifi_url", stringExtra);
                        intent.putExtra("free_wifi_ap_key", stringExtra);
                        intent.putExtra("free_wifi_source", 5);
                        intent.putExtra("free_wifi_channel_id", 1);
                        intent.setClass(this, FreeWifiFrontPageUI.class);
                        startActivity(intent);
                        super.overridePendingTransition(R.a.aRN, R.a.aRM);
                        break;
                    }
                    break;
                case 6:
                    if (1 != a.lRv.getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0)) {
                        a.lRv.aU("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 1);
                    }
                    intent.setClass(this, FreeWifiNetCheckUI.class);
                    startActivity(intent);
                    super.overridePendingTransition(R.a.aRN, R.a.aRM);
                    break;
                default:
                    break;
            }
        }
        finish();
        finish();
    }
}
