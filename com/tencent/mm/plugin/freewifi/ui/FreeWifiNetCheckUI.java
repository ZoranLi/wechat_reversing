package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.d.h;
import com.tencent.mm.plugin.freewifi.d.i;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.c.asr;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.c.cj;
import com.tencent.mm.protocal.c.sr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.e;
import java.util.LinkedList;
import java.util.List;

public class FreeWifiNetCheckUI extends MMActivity {
    private String arH;
    private int fRr;
    private aj fyI;
    private Intent intent;
    ImageView lWT;
    private final int lWW = 1;
    private final int lWX = 2;
    private int[] lWZ = new int[]{R.g.bfi, R.g.bfj, R.g.bfk, R.g.bfl, R.g.bfm};
    ae lXa = new ae(this) {
        int i = 0;
        final /* synthetic */ FreeWifiNetCheckUI lXi;

        {
            this.lXi = r2;
        }

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                if (this.i >= this.lXi.lWZ.length) {
                    this.i = 0;
                }
                this.lXi.lWT.setImageResource(this.lXi.lWZ[this.i]);
                this.i++;
            } else if (message.what == 2) {
                this.lXi.lWT.setImageResource(this.lXi.lWZ[this.lXi.lWZ.length - 1]);
            }
            super.handleMessage(message);
        }
    };
    private b lXh;
    private int scene;

    static /* synthetic */ void a(FreeWifiNetCheckUI freeWifiNetCheckUI, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.putExtra("free_wifi_error_ui_error_msg_detail1", str2);
        intent.setClass(freeWifiNetCheckUI, FreeWifiErrorUI.class);
        freeWifiNetCheckUI.finish();
        freeWifiNetCheckUI.startActivity(intent);
    }

    static /* synthetic */ void c(FreeWifiNetCheckUI freeWifiNetCheckUI) {
        Intent intent = new Intent();
        intent.setClass(freeWifiNetCheckUI, FreeWifiNoWifiUI.class);
        freeWifiNetCheckUI.startActivity(intent);
    }

    public void finish() {
        if (this.fyI != null) {
            this.fyI.KH();
        }
        this.lXa.sendEmptyMessage(2);
        super.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.emO);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FreeWifiNetCheckUI lXi;

            {
                this.lXi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lXi.finish();
                return true;
            }
        });
        this.intent = getIntent();
        m.x(this.intent);
        this.arH = getIntent().getStringExtra("free_wifi_ap_key");
        this.scene = getIntent().getIntExtra("free_wifi_source", 1);
        w.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.onCreate, desc=it goes into black loading ui and starts to connect. get qrcode key = %s, current connected ssid = %s", new Object[]{m.y(this.intent), Integer.valueOf(m.z(this.intent)), this.arH, d.awt()});
        this.lWT = (ImageView) findViewById(R.h.bRh);
        this.fyI = new aj(new a(this) {
            final /* synthetic */ FreeWifiNetCheckUI lXi;

            {
                this.lXi = r1;
            }

            public final boolean oQ() {
                this.lXi.lXa.sendEmptyMessage(1);
                return true;
            }
        }, true);
        this.fyI.v(200, 200);
        String str;
        switch (this.scene) {
            case 1:
                getIntent().putExtra("free_wifi_channel_id", 2);
                this.fRr = 2;
                if (!bg.mA(this.arH)) {
                    Uri uri = null;
                    str = "";
                    try {
                        uri = Uri.parse(this.arH);
                        str = uri.getQueryParameter("q");
                    } catch (Exception e) {
                        finish();
                    }
                    if (!"pc".equalsIgnoreCase(str)) {
                        "_test".equals(str);
                        axx();
                        break;
                    }
                    str = uri.getQueryParameter("appid");
                    final String queryParameter = uri.getQueryParameter("shopid");
                    final String queryParameter2 = uri.getQueryParameter("ticket");
                    m.d(getIntent(), queryParameter2);
                    k.a avZ = k.avZ();
                    avZ.lRy = queryParameter;
                    avZ.lRz = str;
                    avZ.lRA = queryParameter2;
                    avZ.lRC = b.GetPcFrontPage.lSn;
                    avZ.lRD = b.GetPcFrontPage.name;
                    avZ.awb().awa();
                    w.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=It starts NetSceneGetPcFrontPage.shopid=%s, appid=%s, ticket=%s", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), queryParameter, str, queryParameter2});
                    new h(str, Integer.valueOf(queryParameter).intValue(), queryParameter2).b(new e(this) {
                        final /* synthetic */ FreeWifiNetCheckUI lXi;

                        public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
                            if (i == 0 && i2 == 0) {
                                sr awN = ((h) kVar).awN();
                                if (awN != null) {
                                    Intent intent = this.lXi.getIntent();
                                    intent.putExtra("free_wifi_appid", awN.teQ);
                                    intent.putExtra("free_wifi_head_img_url", awN.mtf);
                                    intent.putExtra("free_wifi_welcome_msg", awN.tAC);
                                    intent.putExtra("free_wifi_welcome_sub_title", awN.msH);
                                    intent.putExtra("free_wifi_privacy_url", awN.tAD);
                                    intent.putExtra("free_wifi_app_nickname", awN.jOp);
                                    intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", queryParameter);
                                    intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET", queryParameter2);
                                    intent.setClass(this.lXi, FreeWifiPcUI.class);
                                    this.lXi.finish();
                                    this.lXi.startActivity(intent);
                                }
                            } else if (!m.ca(i, i2) || m.wx(str)) {
                                FreeWifiNetCheckUI.a(this.lXi, this.lXi.getString(R.l.emq), this.lXi.getString(R.l.emr));
                            } else {
                                FreeWifiNetCheckUI.a(this.lXi, str + "(" + m.a(m.A(this.lXi.intent), b.GetPcFrontPageReturn, i2) + ")", "");
                            }
                            k.a avZ = k.avZ();
                            avZ.lRy = queryParameter;
                            avZ.lRz = str;
                            avZ.lRA = queryParameter2;
                            avZ.lRC = b.GetPcFrontPageReturn.lSn;
                            avZ.lRD = b.GetPcFrontPageReturn.name;
                            avZ.result = i2;
                            avZ.awb().awa();
                            w.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=NetSceneGetPcFrontPage returns.errcode=%d", new Object[]{m.y(this.lXi.getIntent()), Integer.valueOf(m.z(this.lXi.getIntent())), Integer.valueOf(i2)});
                        }
                    });
                    break;
                }
                w.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
                finish();
                break;
            case 4:
                str = getIntent().getStringExtra("free_wifi_jsapi_param_type");
                if ("1".equals(str)) {
                    getIntent().putExtra("free_wifi_channel_id", 9);
                    this.fRr = 9;
                } else if ("0".equals(str)) {
                    getIntent().putExtra("free_wifi_channel_id", 8);
                    this.fRr = 8;
                } else {
                    getIntent().putExtra("free_wifi_channel_id", 4);
                    this.fRr = 4;
                }
                str = getIntent().getStringExtra("free_wifi_jsapi_param_type");
                if (!str.equals("0") || !bg.mA(this.arH)) {
                    if (!str.equals("0")) {
                        if (!str.equals("1")) {
                            w.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "undefined jsapi type");
                            finish();
                            break;
                        }
                        str = getIntent().getStringExtra("free_wifi_jsapi_param_username");
                        if (!d.isWifiEnabled()) {
                            d.awq();
                        }
                        b.lTA.a(new com.tencent.mm.plugin.freewifi.model.h.a(this) {
                            final /* synthetic */ FreeWifiNetCheckUI lXi;

                            public final void aB(List<ScanResult> list) {
                                if (list == null || list.size() == 0) {
                                    this.lXi.finish();
                                    FreeWifiNetCheckUI.c(this.lXi);
                                    return;
                                }
                                awe com_tencent_mm_protocal_c_awe = new awe();
                                com_tencent_mm_protocal_c_awe.tZw = new LinkedList();
                                for (ScanResult scanResult : list) {
                                    if (scanResult != null) {
                                        cj cjVar = new cj();
                                        cjVar.mac = scanResult.BSSID;
                                        cjVar.tfB = scanResult.level;
                                        cjVar.ssid = scanResult.SSID;
                                        com_tencent_mm_protocal_c_awe.tZw.add(cjVar);
                                    }
                                }
                                k.a avZ = k.avZ();
                                avZ.lRA = m.y(this.lXi.intent);
                                avZ.lRC = b.ScanNearFieldWifiAndReport.lSn;
                                avZ.lRD = b.ScanNearFieldWifiAndReport.name;
                                avZ.fRr = 9;
                                avZ.awb().awa();
                                new com.tencent.mm.plugin.freewifi.d.k(str, com_tencent_mm_protocal_c_awe, 9, m.y(this.lXi.getIntent())).b(new e(this) {
                                    final /* synthetic */ AnonymousClass5 lXl;

                                    {
                                        this.lXl = r1;
                                    }

                                    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
                                        String awX = ((com.tencent.mm.plugin.freewifi.d.k) kVar).awX();
                                        if (bg.mA(awX)) {
                                            this.lXl.lXi.finish();
                                            FreeWifiNetCheckUI.c(this.lXl.lXi);
                                            return;
                                        }
                                        this.lXl.lXi.arH = awX;
                                        this.lXl.lXi.getIntent().putExtra("free_wifi_ap_key", awX);
                                        this.lXl.lXi.fRr = 9;
                                        this.lXl.lXi.axx();
                                    }
                                });
                            }
                        });
                        break;
                    }
                    axx();
                    break;
                }
                w.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key fail");
                finish();
                break;
                break;
            case 5:
                this.fRr = getIntent().getIntExtra("free_wifi_channel_id", 1);
                if (!bg.mA(this.arH)) {
                    axx();
                    break;
                }
                w.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
                finish();
                break;
            case 6:
                getIntent().putExtra("free_wifi_channel_id", 10);
                this.fRr = 10;
                if (!bg.mA(this.arH)) {
                    axx();
                    break;
                }
                w.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
                finish();
                break;
            default:
                w.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "unkown scene, just finish");
                finish();
                break;
        }
        w.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.handleRequstByScene, desc=it decides the channel. channel=%d", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(this.intent)), Integer.valueOf(this.fRr)});
    }

    private void axx() {
        if (bg.mA(this.arH)) {
            w.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
            finish();
            return;
        }
        this.lXh = new b(this, this.arH, this.fRr);
        w.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.connectFreewifi, desc=base params are ready and it will connets wifi.apKey=%s, channel=%d", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(this.intent)), this.arH, Integer.valueOf(this.fRr)});
        b bVar = this.lXh;
        if (bg.mA(bVar.fEN)) {
            w.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
            bVar.activity.finish();
        }
        bVar.activity.getIntent().putExtra("free_wifi_url", bVar.fEN);
        bVar.activity.getIntent().putExtra("free_wifi_ap_key", bVar.fEN);
        if (bg.mA(bVar.fEN)) {
            w.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ap key is null");
            bVar.activity.finish();
            return;
        }
        w.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo, desc=it starts net request [getApInfo] for retrieving protocol type and frontpage info. apKey=%s, channel=%d", new Object[]{m.y(bVar.intent), Integer.valueOf(m.z(bVar.intent)), bVar.fEN, Integer.valueOf(bVar.fRr)});
        k.a avZ = k.avZ();
        avZ.fEN = bVar.fEN;
        avZ.lRA = m.y(bVar.intent);
        avZ.lRC = b.GetFrontPage.lSn;
        avZ.lRD = b.GetFrontPage.name;
        avZ.fRr = bVar.fRr;
        avZ.lRB = m.A(bVar.intent);
        avZ.awb().b(bVar.intent, false).awa();
        new com.tencent.mm.plugin.freewifi.d.a(bVar.fEN, bVar.fRr, m.y(bVar.intent)).C(bVar.activity).b(new e(bVar) {
            final /* synthetic */ b lVS;

            {
                this.lVS = r1;
            }

            public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
                k.a avZ = k.avZ();
                avZ.fEN = this.lVS.fEN;
                avZ.lRA = m.y(this.lVS.intent);
                avZ.lRC = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturn.lSn;
                avZ.lRD = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturn.name;
                avZ.lRB = m.A(this.lVS.intent);
                avZ.fRr = this.lVS.fRr;
                avZ.result = i2;
                avZ.ksO = str;
                avZ.awb().b(this.lVS.intent, i2 != 0).awa();
                w.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback, desc=net request [getApInfo] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.y(this.lVS.intent), Integer.valueOf(m.z(this.lVS.intent)), Integer.valueOf(i), Integer.valueOf(i2), str});
                if (i == 0 && i2 == 0) {
                    b bVar = this.lVS;
                    if (kVar instanceof com.tencent.mm.plugin.freewifi.d.a) {
                        com.tencent.mm.plugin.freewifi.d.a aVar = (com.tencent.mm.plugin.freewifi.d.a) kVar;
                        bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", aVar.awM());
                        sr awN = aVar.awN();
                        if (awN != null) {
                            w.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo/getFrontPage), desc=net request [getapinfo] gets response. frontpageinfo:  appid: %s, nickName: %s, userName: %s, headImgUrl: %s, welcomeMsg: %s, privacyDescriUrl: %s, timestamp=%s, sign=%s, HasMobile=%d", new Object[]{m.y(bVar.intent), Integer.valueOf(m.z(bVar.intent)), awN.teQ, awN.jOp, awN.jNj, awN.mtf, awN.tAC, awN.tAD, awN.tju, awN.trh, Integer.valueOf(awN.tci)});
                            bVar.intent.putExtra("free_wifi_appid", awN.teQ);
                            bVar.intent.putExtra("free_wifi_head_img_url", awN.mtf);
                            bVar.intent.putExtra("free_wifi_welcome_msg", awN.tAC);
                            bVar.intent.putExtra("free_wifi_privacy_url", awN.tAD);
                            bVar.intent.putExtra("free_wifi_app_nickname", awN.jOp);
                            bVar.intent.putExtra("free_wifi_welcome_sub_title", awN.msH);
                        }
                        if (bVar.fRr != 2) {
                            bVar.activity.getIntent().putExtra("free_wifi_jump_to_main_ui", true);
                        }
                        asr awL = aVar.awL();
                        if (awL == null) {
                            w.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstring from server is null");
                            bVar.activity.finish();
                            avZ = k.avZ();
                            avZ.fEN = bVar.fEN;
                            avZ.lRA = m.y(bVar.intent);
                            avZ.lRC = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.lSn;
                            avZ.lRD = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.name;
                            avZ.lRB = m.A(bVar.intent);
                            avZ.fRr = bVar.fRr;
                            avZ.result = -1;
                            avZ.ksO = "qstrInfo is null.";
                            avZ.awb().b(bVar.intent, true).awa();
                            return;
                        } else if (m.wx(awL.leE)) {
                            w.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstrInfo.ssid from server is empty");
                            bVar.activity.finish();
                            avZ = k.avZ();
                            avZ.fEN = bVar.fEN;
                            avZ.lRA = m.y(bVar.intent);
                            avZ.lRC = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.lSn;
                            avZ.lRD = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.name;
                            avZ.lRB = m.A(bVar.intent);
                            avZ.fRr = bVar.fRr;
                            avZ.result = -1;
                            avZ.ksO = "qstrInfo.Ssid is empty.";
                            avZ.awb().b(bVar.intent, true).awa();
                            return;
                        } else {
                            bVar.intent.putExtra("free_wifi_ssid", awL.leE);
                            w.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. qstrInfo:  prototype = %d, ssid : %s, pssword : %s", new Object[]{m.y(bVar.intent), Integer.valueOf(m.z(bVar.intent)), Integer.valueOf(awL.tXk), awL.leE, awL.twP});
                            String awO = aVar.awO();
                            String awP = aVar.awP();
                            bVar.intent.putExtra("free_wifi_openid", awO);
                            bVar.intent.putExtra("free_wifi_tid", awP);
                            bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP", awN.tju);
                            bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SIGN", awN.trh);
                            w.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. openId=%s, tid=%s", new Object[]{m.y(bVar.intent), Integer.valueOf(m.z(bVar.intent)), awO, awP});
                            bVar.intent.putExtra("free_wifi_protocol_type", awL.tXk);
                            if (awL.tXk == 10) {
                                if (bg.mA(awL.leE) || bg.mA(awL.twP)) {
                                    w.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
                                    bVar.activity.finish();
                                    return;
                                }
                                bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 4);
                                bVar.intent.putExtra("free_wifi_auth_type", 2);
                                bVar.intent.putExtra("free_wifi_passowrd", awL.twP);
                                bVar.intent.setClass(bVar.activity, FreeWifiFrontPageUI.class);
                                bVar.activity.startActivity(bVar.intent);
                                bVar.activity.finish();
                                bVar.activity.overridePendingTransition(R.a.aRN, R.a.aRM);
                                return;
                            } else if (awL.tXk == 11) {
                                if (bg.mA(awL.leE) || bg.mA(awL.twP)) {
                                    w.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
                                    bVar.activity.finish();
                                    return;
                                }
                                bVar.intent.putExtra("free_wifi_auth_type", 2);
                                bVar.intent.putExtra("free_wifi_passowrd", awL.twP);
                                bVar.intent.setClass(bVar.activity, FreewifiActivateWeChatNoAuthStateUI.class);
                                bVar.activity.startActivity(bVar.intent);
                                bVar.activity.finish();
                                bVar.activity.overridePendingTransition(R.a.aRN, R.a.aRM);
                                return;
                            } else if (awL.tXk == 12) {
                                bVar.intent.putExtra("free_wifi_auth_type", 1);
                                bVar.intent.setClass(bVar.activity, FreeWifiActivateAuthStateUI.class);
                                bVar.activity.startActivity(bVar.intent);
                                bVar.activity.finish();
                                bVar.activity.overridePendingTransition(R.a.aRN, R.a.aRM);
                                return;
                            } else if (awL.tXk == 31) {
                                bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
                                w.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 31 handle branch.", new Object[]{m.y(bVar.intent), Integer.valueOf(m.z(bVar.intent))});
                                String stringExtra = bVar.intent.getStringExtra("free_wifi_schema_ticket");
                                w.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it tries to get ticket. ticket=%s.", new Object[]{m.y(bVar.intent), Integer.valueOf(m.z(bVar.intent)), stringExtra});
                                if (bg.mA(stringExtra)) {
                                    bVar.activity.finish();
                                    avZ = k.avZ();
                                    avZ.fEN = bVar.fEN;
                                    avZ.lRA = m.y(bVar.intent);
                                    avZ.lRC = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.lSn;
                                    avZ.lRD = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.name;
                                    avZ.fRr = bVar.fRr;
                                    avZ.lRB = m.A(bVar.intent);
                                    avZ.result = -1;
                                    avZ.ksO = "31 ticket is empty.";
                                    avZ.awb().b(bVar.intent, true).awa();
                                    return;
                                }
                                String str2 = awL.leE;
                                String str3 = awN.tju;
                                String str4 = awN.trh;
                                WifiInfo awu = d.awu();
                                if (awu == null) {
                                    w.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it tries to get current connected wifi info but return null, so it fails to connect wifi. ", new Object[]{m.y(bVar.intent), Integer.valueOf(m.z(bVar.intent))});
                                    bVar.wR(bVar.activity.getString(R.l.emu));
                                    avZ = k.avZ();
                                    avZ.fEN = bVar.fEN;
                                    avZ.lRA = m.y(bVar.intent);
                                    avZ.lRC = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.lSn;
                                    avZ.lRD = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.name;
                                    avZ.fRr = bVar.fRr;
                                    avZ.lRB = m.A(bVar.intent);
                                    avZ.result = -1;
                                    avZ.ksO = "wifiInfo is empty.";
                                    avZ.awb().b(bVar.intent, true).awa();
                                    return;
                                }
                                boolean wG = d.wG(str2);
                                String str5 = "MicroMsg.FreeWifi.FreeWifiNetCheckUI";
                                String str6 = "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets connected wifi info. wifiInfo=%s, is_current_connected_ssid_equals_target_ssid=%b";
                                Object[] objArr = new Object[4];
                                objArr[0] = m.y(bVar.intent);
                                objArr[1] = Integer.valueOf(m.z(bVar.intent));
                                objArr[2] = awu == null ? "null" : awu.toString();
                                objArr[3] = Boolean.valueOf(wG);
                                w.i(str5, str6, objArr);
                                str5 = m.wy(awu.getSSID());
                                str6 = awu.getBSSID();
                                String macAddress = awu.getMacAddress();
                                if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
                                    macAddress = m.awe();
                                }
                                w.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo desc=it starts net request [GetPortalApInfo]  for portal ap info. apKey=%s, apSsid=%s, apBssid=%s, mobileMac=%s, ticket=%s", new Object[]{m.y(bVar.intent), Integer.valueOf(m.z(bVar.intent)), bVar.fEN, str5, str6, macAddress, stringExtra});
                                avZ = k.avZ();
                                avZ.fEN = bVar.fEN;
                                avZ.lRA = m.y(bVar.intent);
                                avZ.lRC = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.lSn;
                                avZ.lRD = com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturnDataCheck.name;
                                avZ.fRr = bVar.fRr;
                                avZ.lRB = m.A(bVar.intent);
                                avZ.result = 0;
                                avZ.ksO = "";
                                avZ.awb().b(bVar.intent, true).awa();
                                avZ = k.avZ();
                                avZ.ssid = bVar.intent.getStringExtra("free_wifi_ssid");
                                avZ.fEN = bVar.fEN;
                                avZ.lRz = bVar.intent.getStringExtra("free_wifi_appid");
                                avZ.lRA = m.y(bVar.intent);
                                avZ.lRB = m.A(bVar.intent);
                                avZ.lRC = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfo.lSn;
                                avZ.lRD = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfo.name;
                                avZ.fRr = m.B(bVar.intent);
                                avZ.lRB = m.A(bVar.intent);
                                avZ.awb().b(bVar.intent, false).awa();
                                new i(bVar.fEN, str5, str6, macAddress, stringExtra, m.y(bVar.intent)).C(bVar.activity).b(new AnonymousClass2(bVar, awO, awP, str3, str4));
                                return;
                            } else if (awL.tXk == 32) {
                                bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 32);
                                w.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 32 handle branch.", new Object[]{m.y(bVar.intent), Integer.valueOf(m.z(bVar.intent))});
                                bVar.intent.setClass(bVar.activity, FreeWifiFrontPageUI.class);
                                bVar.activity.startActivity(bVar.intent);
                                bVar.activity.finish();
                                bVar.activity.overridePendingTransition(R.a.aRN, R.a.aRM);
                                return;
                            } else if (awL.tXk == 1) {
                                bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 1);
                                bVar.intent.putExtra("free_wifi_auth_type", 1);
                                bVar.intent.setClass(bVar.activity, FreeWifiFrontPageUI.class);
                                bVar.activity.startActivity(bVar.intent);
                                bVar.activity.finish();
                                bVar.activity.overridePendingTransition(R.a.aRN, R.a.aRM);
                                return;
                            } else {
                                bVar.activity.finish();
                                bVar.wR(bVar.activity.getString(R.l.emw));
                                return;
                            }
                        }
                    }
                    bVar.wR(bVar.activity.getString(R.l.emu));
                } else if (m.ca(i, i2) && !m.wx(str)) {
                    this.lVS.wR(str + "(" + m.a(m.A(this.lVS.intent), com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturn, i2) + ")");
                } else if (i2 == -30031) {
                    this.lVS.wR(this.lVS.activity.getString(R.l.emv));
                } else {
                    this.lVS.wR(this.lVS.activity.getString(R.l.emu) + "(" + String.format("%02d", new Object[]{Integer.valueOf(m.A(this.lVS.intent))}) + com.tencent.mm.plugin.freewifi.k.b.GetFrontPageReturn.lSn + Math.abs(i2) + ")");
                }
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.ddu;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.lXh != null) {
            this.lXh = null;
        }
        this.fyI.KH();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }
}
