package com.tencent.mm.plugin.webview.stub;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.e.a.rh;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.plugin.webview.ui.tools.WebViewStubCallbackWrapper;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.l.f;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ay;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

@a(7)
public class WebViewStubProxyUI extends MMActivity {
    public static boolean rZL = false;
    private aj fyI = new aj(new aj.a(this) {
        final /* synthetic */ WebViewStubProxyUI rZS;

        {
            this.rZS = r1;
        }

        public final boolean oQ() {
            if (this.rZS.getWindow() != null && this.rZS.getWindow().getDecorView() != null && this.rZS.getWindow().getDecorView().getWindowToken() != null) {
                WebViewStubProxyUI.e(this.rZS);
                this.rZS.rZM = true;
                return false;
            } else if (this.rZS.lHz < 10) {
                WebViewStubProxyUI.d(this.rZS);
                return true;
            } else {
                w.e("MicroMsg.WebViewStubProxyUI", "timer reach max retry time, finish ProxyUI");
                this.rZS.finish();
                return false;
            }
        }
    }, true);
    private int lHz = 0;
    private e rXh = null;
    private boolean rZM = false;
    private int rZN;
    private final e rZO = new e(this) {
        final /* synthetic */ WebViewStubProxyUI rZS;

        {
            this.rZS = r1;
        }

        public final IBinder asBinder() {
            return null;
        }

        public final boolean vY(int i) {
            this.rZS.rXh.vY(i);
            return false;
        }

        public final boolean m(int i, Bundle bundle) {
            this.rZS.rXh.m(i, bundle);
            return false;
        }

        public final boolean a(c cVar) {
            this.rZS.rXh.a(cVar);
            return false;
        }

        public final boolean a(String str, String str2, Bundle bundle, boolean z) {
            w.i("MicroMsg.callbackerWrapper", "onHandleEnd in callbackerWrapper");
            WebViewStubProxyUI.rZL = WebViewStubProxyUI.Jm(str2);
            final String str3 = str;
            final String str4 = str2;
            final Bundle bundle2 = bundle;
            final boolean z2 = z;
            this.rZS.runOnUiThread(new Runnable(this) {
                final /* synthetic */ AnonymousClass5 rZX;

                public final void run() {
                    h.wH(this.rZX.rZS.rZN).a(null, null, null);
                    this.rZX.rZS.finish();
                    try {
                        this.rZX.rZS.rXh.a(str3, str4, bundle2, z2);
                    } catch (Exception e) {
                        w.w("MicroMsg.callbackerWrapper", "wrapper onHandleEnd, ex = " + e.getMessage());
                    }
                }
            });
            return false;
        }

        public final String bxj() {
            return this.rZS.rXh.bxj();
        }

        public final String VD() {
            return this.rZS.rXh.VD();
        }

        public final String bxk() {
            return this.rZS.rXh.bxk();
        }

        public final void iN(boolean z) {
            this.rZS.rXh.iN(z);
        }

        public final void iO(boolean z) {
            this.rZS.rXh.iO(z);
        }

        public final void n(int i, Bundle bundle) {
            this.rZS.rXh.n(i, bundle);
        }

        public final void bxl() {
            this.rZS.rXh.bxl();
        }

        public final void M(Bundle bundle) {
            this.rZS.rXh.M(bundle);
        }

        public final void Jn(String str) {
            this.rZS.rXh.Jn(str);
        }

        public final void bxm() {
            if (this.rZS.rXh != null) {
                this.rZS.rXh.bxm();
            }
        }

        public final void e(String str, String str2, int i, int i2) {
        }

        public final void dQ(String str, String str2) {
            this.rZS.rXh.dQ(str, str2);
        }

        public final Bundle d(int i, Bundle bundle) {
            return this.rZS.rXh.d(i, bundle);
        }

        public final void N(Bundle bundle) {
            this.rZS.rXh.N(bundle);
        }

        public final void iP(boolean z) {
            this.rZS.rXh.iP(z);
        }

        public final void dR(String str, String str2) {
            this.rZS.rXh.dR(str, str2);
        }
    };
    private OnDismissListener rZP = new OnDismissListener(this) {
        final /* synthetic */ WebViewStubProxyUI rZS;

        {
            this.rZS = r1;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            if (!this.rZS.isFinishing()) {
                this.rZS.finish();
            }
        }
    };
    private aj rZQ = new aj(new aj.a(this) {
        final /* synthetic */ WebViewStubProxyUI rZS;

        {
            this.rZS = r1;
        }

        public final boolean oQ() {
            if (!this.rZS.isFinishing()) {
                this.rZS.finish();
            }
            return false;
        }
    }, true);

    static /* synthetic */ boolean Jm(String str) {
        if (str == null) {
            return false;
        }
        String[] split = str.split(":");
        return split.length > 0 && split[0].equals("startMonitoringBeacons");
    }

    static /* synthetic */ int d(WebViewStubProxyUI webViewStubProxyUI) {
        int i = webViewStubProxyUI.lHz + 1;
        webViewStubProxyUI.lHz = i;
        return i;
    }

    static /* synthetic */ void e(WebViewStubProxyUI webViewStubProxyUI) {
        Intent intent = webViewStubProxyUI.getIntent();
        int intExtra = intent.getIntExtra("proxyui_action_code_key", 0);
        w.i("MicroMsg.WebViewStubProxyUI", "onCreate, dealAfterWindowTokenInited = " + intExtra);
        JsapiPermissionWrapper jsapiPermissionWrapper;
        switch (intExtra) {
            case 1:
                i iVar = new i();
                iVar.type = intent.getStringExtra("proxyui_type_key");
                iVar.smN = intent.getStringExtra("proxyui_function_key");
                iVar.smL = intent.getStringExtra("proxyui_callback_key");
                iVar.ozE = i.W(intent.getExtras());
                jsapiPermissionWrapper = (JsapiPermissionWrapper) intent.getExtras().getParcelable("proxyui_perm_key");
                if (jsapiPermissionWrapper == null) {
                    jsapiPermissionWrapper = new JsapiPermissionWrapper(2);
                }
                h.wH(webViewStubProxyUI.rZN).a((Context) webViewStubProxyUI, webViewStubProxyUI.rZO, webViewStubProxyUI.rXh);
                if (!h.wH(webViewStubProxyUI.rZN).a(iVar, jsapiPermissionWrapper)) {
                    try {
                        webViewStubProxyUI.rZO.a(null, null, null, true);
                        return;
                    } catch (Exception e) {
                        w.w("MicroMsg.WebViewStubProxyUI", "onHandleEnd, ex = " + e.getMessage());
                        return;
                    }
                }
                return;
            case 4:
                if (((JsapiPermissionWrapper) intent.getExtras().getParcelable("proxyui_perm_key")) == null) {
                    jsapiPermissionWrapper = new JsapiPermissionWrapper(2);
                }
                h.wH(webViewStubProxyUI.rZN).a((Context) webViewStubProxyUI, webViewStubProxyUI.rZO);
                if (!h.wH(webViewStubProxyUI.rZN).Ki(intent.getStringExtra("proxyui_username_key"))) {
                    w.w("MicroMsg.WebViewStubProxyUI", "doProfile fail, finish");
                    webViewStubProxyUI.finish();
                    return;
                }
                return;
            default:
                w.e("MicroMsg.WebViewStubProxyUI", "dealAfterWindowTokenInited unknown actionCode = " + intExtra);
                webViewStubProxyUI.finish();
                return;
        }
    }

    @TargetApi(21)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (d.eo(21)) {
            getWindow().setStatusBarColor(0);
        }
        WebViewStubCallbackWrapper webViewStubCallbackWrapper = (WebViewStubCallbackWrapper) getIntent().getParcelableExtra("webview_stub_callbacker_key");
        if (webViewStubCallbackWrapper != null) {
            this.rXh = webViewStubCallbackWrapper.scI;
        }
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("proxyui_action_code_key", 0);
        this.rZN = intent.getIntExtra("webview_binder_id", 0);
        w.i("MicroMsg.WebViewStubProxyUI", "onCreate, actionCode = %d, binderID = %d", new Object[]{Integer.valueOf(intExtra), Integer.valueOf(this.rZN)});
        if ("startMonitoringBeacons".equals(intent.getStringExtra("proxyui_function_key"))) {
            rZL = true;
        }
        String stringExtra;
        switch (intExtra) {
            case 1:
                if (!this.rZM) {
                    this.fyI.v(100, 100);
                }
                if (rZL) {
                    this.rZQ.v(5000, 5000);
                    return;
                }
                return;
            case 2:
                final b rhVar = new rh();
                rhVar.nFq = new Runnable(this) {
                    final /* synthetic */ WebViewStubProxyUI rZS;

                    public final void run() {
                        if (rhVar.fYo.fYp) {
                            if (this.rZS.rXh != null) {
                                try {
                                    this.rZS.rXh.m(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, null);
                                } catch (RemoteException e) {
                                    w.w("MicroMsg.WebViewStubProxyUI", "dealUpdate fail, ex = " + e.getMessage());
                                }
                            }
                            this.rZS.finish();
                            f fVar = l.a.sBt;
                            if (fVar != null) {
                                fVar.ai(this.rZS);
                                return;
                            }
                            return;
                        }
                        this.rZS.finish();
                    }
                };
                rhVar.fYn.context = this;
                rhVar.fYn.type = intent.getIntExtra("update_type_key", 0);
                if (rhVar.fYn.type <= 0) {
                    w.e("MicroMsg.WebViewStubProxyUI", "doUpdate fail, invalid type = " + rhVar.fYn.type);
                    finish();
                    return;
                }
                com.tencent.mm.sdk.b.a.urY.a(rhVar, Looper.myLooper());
                return;
            case 3:
                Dialog a;
                ap.yY();
                ay AH = c.wZ().AH("@t.qq.com");
                if (!m.ys()) {
                    a = g.a(this, R.l.dYL, R.l.dIO, new OnClickListener(this) {
                        final /* synthetic */ WebViewStubProxyUI rZS;

                        {
                            this.rZS = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.webview.a.a.imv.h(new Intent(), this.rZS);
                        }
                    }, null);
                } else if (AH == null || bg.mA(AH.name)) {
                    a = g.h(this, R.l.eUB, R.l.dIO);
                } else {
                    ap.vd().a(new ab(getIntent().getIntExtra(Columns.TYPE, 0), bg.mz(getIntent().getStringExtra("shortUrl"))), 0);
                    try {
                        this.rXh.vY(0);
                        a = null;
                    } catch (Exception e) {
                        w.w("MicroMsg.WebViewStubProxyUI", "setTitlePbVisibility, ex = " + e.getMessage());
                        a = null;
                    }
                }
                if (a == null) {
                    finish();
                    return;
                } else {
                    a.setOnDismissListener(this.rZP);
                    return;
                }
            case 4:
                this.fyI.v(100, 100);
                return;
            case 5:
                if (l.a.sBB != null) {
                    l.a.sBB.a(this, intent.getStringExtra("proxyui_handle_event_url"), this.rZP);
                    return;
                }
                return;
            case 6:
                int intExtra2 = getIntent().getIntExtra("proxyui_expired_errtype", 0);
                int intExtra3 = getIntent().getIntExtra("proxyui_expired_errcode", 0);
                if (intExtra2 == 0 && intExtra3 == 0) {
                    w.e("MicroMsg.WebViewStubProxyUI", "PROXY_AC_VALUE_ACCOUNT_EXPIRED, errType & errCode should not both be 0");
                    return;
                }
                b cVar = new com.tencent.mm.e.a.c();
                cVar.fCh.fCi = this;
                cVar.fCh.errType = intExtra2;
                cVar.fCh.errCode = intExtra3;
                com.tencent.mm.sdk.b.a.urY.m(cVar);
                return;
            case 8:
                stringExtra = getIntent().getStringExtra("proxyui_phone");
                if (bg.mA(stringExtra)) {
                    w.e("MicroMsg.WebViewStubProxyUI", "show phone span dialog, phone is empty");
                    finish();
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("fromScene", 3);
                j.a(this, stringExtra, this.rZP, bundle2);
                return;
            case 9:
                intent = (Intent) getIntent().getExtras().getParcelable("proxyui_next_intent_key");
                intent.setFlags(603979776);
                com.tencent.mm.bb.d.a(this, "accountsync", "com.tencent.mm.ui.account.SimpleLoginUI", null, intent);
                finish();
                return;
            case 10:
                stringExtra = getIntent().getStringExtra("KAppId");
                String stringExtra2 = getIntent().getStringExtra("shortcut_user_name");
                if (!bg.mA(stringExtra) && !bg.mA(stringExtra2)) {
                    getString(R.l.dIO);
                    final p a2 = g.a(this, getString(R.l.dJd), true, new OnCancelListener(this) {
                        final /* synthetic */ WebViewStubProxyUI rZS;

                        {
                            this.rZS = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            w.i("MicroMsg.WebViewStubProxyUI", "addshortcut, user cancel");
                            this.rZS.finish();
                        }
                    });
                    a2.show();
                    com.tencent.mm.plugin.base.model.d.a(com.tencent.mm.sdk.platformtools.ab.getContext(), stringExtra2, stringExtra, new com.tencent.mm.plugin.base.model.d.a(this) {
                        final /* synthetic */ WebViewStubProxyUI rZS;

                        public final void cQ(boolean z) {
                            if (a2 != null) {
                                a2.dismiss();
                            }
                            Bundle bundle;
                            if (z) {
                                if (this.rZS.rXh != null) {
                                    bundle = new Bundle();
                                    bundle.putBoolean("add_shortcut_status", true);
                                    try {
                                        this.rZS.rXh.d(54, bundle);
                                    } catch (Exception e) {
                                        w.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + e.getMessage());
                                    }
                                }
                                g.a(this.rZS, R.l.fnj, R.l.dIO, false, new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass4 rZT;

                                    {
                                        this.rZT = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.rZT.rZS.finish();
                                    }
                                });
                                return;
                            }
                            Toast.makeText(this.rZS.uSU.uTo, this.rZS.uSU.uTo.getString(R.l.fni), 0).show();
                            if (this.rZS.rXh != null) {
                                bundle = new Bundle();
                                bundle.putBoolean("add_shortcut_status", false);
                                try {
                                    this.rZS.rXh.d(54, bundle);
                                } catch (Exception e2) {
                                    w.e("MicroMsg.WebViewStubProxyUI", "notify add shortcut status failed: " + e2.getMessage());
                                }
                            }
                            this.rZS.finish();
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final int Ol() {
        return getIntent().getIntExtra("screen_orientation", -1);
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!rZL) {
            this.rXh = null;
        }
        w.i("MicroMsg.WebViewStubProxyUI", "onDestroy proxyui");
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        switch (i) {
            case 113:
            case 115:
            case 116:
            case 117:
            case 118:
                if (iArr[0] == 0) {
                    h.wH(this.rZN).a(i, -1, null);
                    return;
                } else {
                    h.wH(this.rZN).a(i, 0, null);
                    return;
                }
            default:
                return;
        }
    }
}
