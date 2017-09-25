package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.e.a.gd;
import com.tencent.mm.modelsimple.ah;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.d;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.b;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.c.bfs;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.u.q;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author = 50, fComment = "checked", lastDate = "20141016", reviewer = 50, vComment = {EType.ACTIVITYCHECK})
public class WXCustomSchemeEntryActivity extends AutoLoginActivity {
    private List<String> jPB;

    public void onCreate(Bundle bundle) {
        w.i("MicroMsg.WXCustomSchemeEntryActivity", "onCreate");
        this.jPB = new ArrayList();
        this.jPB.add("cardpackage");
        this.jPB.add("connectToFreeWifi");
        this.jPB.add("wap");
        super.onCreate(bundle);
        zg(0);
    }

    protected final int getLayoutId() {
        return R.i.cVO;
    }

    protected final boolean u(Intent intent) {
        Uri data;
        try {
            data = getIntent().getData();
        } catch (Exception e) {
            w.e("MicroMsg.WXCustomSchemeEntryActivity", "get url from intent failed : %s", e.getMessage());
            data = null;
        }
        if (data != null) {
            if (d.LD(data.toString())) {
                return true;
            }
            String scheme = data.getScheme();
            String host = data.getHost();
            String query = data.getQuery();
            w.i("MicroMsg.WXCustomSchemeEntryActivity", "uri is %s,scheme is %s, host is %s, query is %s", data.toString(), scheme, host, query);
            if (!bg.mA(host) && this.jPB.contains(host)) {
                w.i("MicroMsg.WXCustomSchemeEntryActivity", "match the host : %s", host);
                if (host.equals("cardpackage")) {
                    scheme = data.getQueryParameter("encrystr");
                    w.i("MicroMsg.WXCustomSchemeEntryActivity", "card encrypt value = %s", scheme);
                    if (!bg.mA(scheme) && scheme.length() < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                        return true;
                    }
                }
                if (host.equals("connectToFreeWifi")) {
                    if (!bg.mA(query) && query.startsWith("apKey=") && query.length() > 6) {
                        scheme = query.substring(6);
                        w.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", scheme);
                        if (!bg.mA(scheme) && scheme.length() < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                            return true;
                        }
                    } else if (data.toString().startsWith("weixin://connectToFreeWifi/friendWifi")) {
                        return true;
                    }
                }
                if (host.equals("wap") && data.toString().startsWith("weixin://wap/pay")) {
                    w.i("MicroMsg.WXCustomSchemeEntryActivity", "preLogin for WX_WAP_PAY");
                    return true;
                }
            }
        }
        finish();
        return false;
    }

    protected final void a(b bVar, Intent intent) {
        switch (bVar) {
            case LOGIN_OK:
                Uri data;
                try {
                    data = getIntent().getData();
                } catch (Exception e) {
                    w.e("MicroMsg.WXCustomSchemeEntryActivity", "post login get url from intent failed : %s", e.getMessage());
                    data = null;
                }
                if (data != null) {
                    int i;
                    if (data != null) {
                        int a;
                        if (intent != null) {
                            a = s.a(intent, "translate_link_scene", 2);
                        } else {
                            a = 2;
                        }
                        w.i("MicroMsg.WXCustomSchemeEntryActivity", "translateLinkScene = %d", Integer.valueOf(a));
                        String host;
                        if (!d.LD(data.toString())) {
                            String scheme = data.getScheme();
                            host = data.getHost();
                            Object query = data.getQuery();
                            w.i("MicroMsg.WXCustomSchemeEntryActivity", "scheme is %s, host is %s, query is %s", scheme, host, query);
                            if (!bg.mA(host) && this.jPB.contains(host)) {
                                if (host.equals("cardpackage") && !bg.mA(data.getQueryParameter("encrystr"))) {
                                    intent.setClassName(this, "com.tencent.mm.ui.CheckSmsCanAddCardUI");
                                    startActivity(intent);
                                }
                                if (host.equals("connectToFreeWifi")) {
                                    if (!bg.mA(query) && query.startsWith("apKey=")) {
                                        String queryParameter = data.getQueryParameter("apKey");
                                        w.i("MicroMsg.WXCustomSchemeEntryActivity", "apKey value = %s", queryParameter);
                                        scheme = data.getQueryParameter("ticket");
                                        if (!bg.mA(queryParameter) && queryParameter.length() < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                                            Intent intent2 = new Intent();
                                            intent2.putExtra("free_wifi_schema_uri", data.toString());
                                            intent2.putExtra("free_wifi_ap_key", queryParameter);
                                            intent2.putExtra("free_wifi_source", 5);
                                            intent2.putExtra("free_wifi_threeone_startup_type", 1);
                                            if (!bg.mA(scheme)) {
                                                intent2.putExtra("free_wifi_schema_ticket", scheme);
                                            }
                                            if (queryParameter.startsWith("_") || bg.mA(scheme)) {
                                                intent2.addFlags(67108864);
                                                com.tencent.mm.bb.d.b((Context) this, "freewifi", ".ui.FreeWifiEntryUI", intent2);
                                            } else {
                                                com.tencent.mm.sdk.b.b gdVar = new gd();
                                                gdVar.fLt.intent = intent2;
                                                a.urY.m(gdVar);
                                            }
                                        }
                                    } else if (data.toString().startsWith("weixin://connectToFreeWifi/friendWifi")) {
                                        Intent intent3 = new Intent();
                                        intent3.putExtra("key_connected_router", data.toString());
                                        com.tencent.mm.bb.d.b((Context) this, "exdevice", ".ui.ExdeviceConnectedRouterActivateStateUI", intent3);
                                        w.i("MicroMsg.WXCustomSchemeEntryActivity", "Jump to ExdeviceConnectedRouterUi.");
                                    }
                                }
                                if (host.equals("wap") && data.toString().startsWith("weixin://wap/pay")) {
                                    w.i("MicroMsg.WXCustomSchemeEntryActivity", "postLogin for WX_WAP_PAY");
                                    if (!TextUtils.isEmpty(query)) {
                                        e.a((Context) this, com.tencent.mm.pluginsdk.h.a.LM(query), false);
                                    }
                                }
                            }
                        } else if (d.i(data)) {
                            w.i("MicroMsg.WXCustomSchemeEntryActivity", "isTicketLink uri:%s, %b", data.toString(), Boolean.valueOf(d.j(data)));
                            if (d.j(data)) {
                                d.a((Context) this, data.toString(), a, new d.a(this) {
                                    final /* synthetic */ WXCustomSchemeEntryActivity jPC;

                                    {
                                        this.jPC = r1;
                                    }

                                    public final void a(int i, int i2, String str, k kVar, boolean z) {
                                        w.i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                                        if (!(kVar == null || i == 0 || i2 == 0 || !(kVar instanceof ah))) {
                                            bfs Jz = ((ah) kVar).Jz();
                                            if (!(Jz == null || this.jPC.isFinishing())) {
                                                com.tencent.mm.ui.base.s.makeText(this.jPC, this.jPC.getString(R.l.dIO) + " : " + bg.mz(Jz.ugf), 0).show();
                                            }
                                        }
                                        this.jPC.finish();
                                    }
                                });
                                i = 1;
                                if (i != 0) {
                                    return;
                                }
                            }
                            d.a((Context) this, data.toString(), a, new d.a(this) {
                                final /* synthetic */ WXCustomSchemeEntryActivity jPC;

                                {
                                    this.jPC = r1;
                                }

                                public final void a(int i, int i2, String str, k kVar, boolean z) {
                                    this.jPC.finish();
                                }
                            });
                        } else if (d.LE(data.toString())) {
                            if (a == 1) {
                                q.b fO = q.yC().fO("key_data_center_session_id");
                                if (fO == null) {
                                    w.e("MicroMsg.WXCustomSchemeEntryActivity", "null keyvalue for opensdk scene");
                                    finish();
                                } else {
                                    w.i("MicroMsg.WXCustomSchemeEntryActivity", "pkg = %s, sig = %s, intentpkg = %s, intentsig = %s", fO.getString("key_package_name", ""), fO.getString("key_package_signature", ""), intent.getStringExtra("key_package_name"), intent.getStringExtra("key_package_signature"));
                                    q.yC().fP("key_data_center_session_id");
                                    if (!(fO.getString("key_package_name", "").equals(intent.getStringExtra("key_package_name")) && r1.equals(r8))) {
                                        w.e("MicroMsg.WXCustomSchemeEntryActivity", "signature or package check failed");
                                        finish();
                                    }
                                }
                            }
                            d.a((Context) this, data.toString(), a, new d.a(this) {
                                final /* synthetic */ WXCustomSchemeEntryActivity jPC;

                                {
                                    this.jPC = r1;
                                }

                                public final void a(int i, int i2, String str, k kVar, boolean z) {
                                    w.i("MicroMsg.WXCustomSchemeEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                                    if (!(kVar == null || i == 0 || i2 == 0 || !(kVar instanceof ah))) {
                                        bfs Jz = ((ah) kVar).Jz();
                                        if (!(Jz == null || this.jPC.isFinishing())) {
                                            com.tencent.mm.ui.base.s.makeText(this.jPC, this.jPC.getString(R.l.dIO) + " : " + bg.mz(Jz.ugf), 0).show();
                                        }
                                    }
                                    this.jPC.finish();
                                }
                            }, intent.getStringExtra("key_package_name"), intent.getStringExtra("key_package_signature"));
                            i = 1;
                            if (i != 0) {
                                return;
                            }
                        } else {
                            host = m.xL();
                            w.i("MicroMsg.WXCustomSchemeEntryActivity", "not TicketLink uri:%s", data.toString());
                            d.a((Context) this, data.toString(), host, 23, data.toString(), new d.a(this) {
                                final /* synthetic */ WXCustomSchemeEntryActivity jPC;

                                {
                                    this.jPC = r1;
                                }

                                public final void a(int i, int i2, String str, k kVar, boolean z) {
                                    this.jPC.finish();
                                }
                            });
                        }
                    }
                    boolean z = false;
                    if (i != 0) {
                        return;
                    }
                }
                break;
        }
        finish();
    }
}
