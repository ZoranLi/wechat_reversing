package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.tk;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.Map;

public final class e {
    private WebView saV;
    private Map<String, a> scf;
    private JsapiPermissionWrapper scg;
    private GeneralControlWrapper sch;
    private final JsapiPermissionWrapper sci = new JsapiPermissionWrapper(2);
    private final GeneralControlWrapper scj = GeneralControlWrapper.sYX;
    private int[] sck;
    private int[] scl;

    private static class a {
        public JsapiPermissionWrapper scm;
        public GeneralControlWrapper scn;

        public a(JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
            this.scm = jsapiPermissionWrapper;
            this.scn = generalControlWrapper;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Permission: jsPerm = ");
            stringBuilder.append(this.scm);
            stringBuilder.append(", genCtrl = ");
            stringBuilder.append(this.scn);
            return stringBuilder.toString();
        }
    }

    public e(Activity activity, WebView webView) {
        int i;
        this.scg = (JsapiPermissionWrapper) activity.getIntent().getParcelableExtra("hardcode_jspermission");
        if (r.iiR == null || r.iiR.length() == 0) {
            w.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
        } else {
            try {
                i = bg.getInt(r.iiR, 0);
                if (i < 0) {
                    w.w("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
                } else {
                    this.scg = new JsapiPermissionWrapper(i);
                    w.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.scg);
                }
            } catch (Exception e) {
                w.e("MicroMsg.WebViewPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + e.getMessage());
                this.scg = null;
            }
        }
        this.sch = (GeneralControlWrapper) activity.getIntent().getParcelableExtra("hardcode_general_ctrl");
        if (r.iiS == null || r.iiS.length() == 0) {
            w.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
        } else {
            try {
                w.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, permission = %d", new Object[]{Integer.valueOf(bg.getInt(r.iiS, 0))});
                tk tkVar = new tk();
                tkVar.tBp = i;
                this.sch = new GeneralControlWrapper(tkVar);
            } catch (Exception e2) {
                w.e("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl fail, ex = %s", new Object[]{e2.getMessage()});
                this.sch = null;
            }
            w.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.sch);
        }
        w.i("MicroMsg.WebViewPermission", "edw <init> hardcodeJsPerm = " + this.scg + ", hardcodeGenCtrl = " + this.sch);
        this.saV = webView;
        this.scf = new HashMap();
        this.sck = activity.getIntent().getIntArrayExtra("jsapi_blacklist");
        this.scl = activity.getIntent().getIntArrayExtra("jsapi_whitelist");
        if (!(this.sck == null || this.sck.length <= 0 || this.scg == null)) {
            w.i("MicroMsg.WebViewPermission", "albie: setBlacklist jsapi(%s).", new Object[]{this.sck});
            this.scg.o(this.sck);
        }
        if (this.scl != null && this.scl.length > 0 && this.scg != null) {
            w.i("MicroMsg.WebViewPermission", "albie: setWhitelist jsapi(%s).", new Object[]{this.scl});
            this.scg.p(this.scl);
        }
    }

    public final void a(String str, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        if (bg.mA(str)) {
            w.e("MicroMsg.WebViewPermission", "update fail, url is null");
            return;
        }
        String xI = xI(str);
        if (jsapiPermissionWrapper == null) {
            jsapiPermissionWrapper = this.sci;
        }
        if (generalControlWrapper == null) {
            generalControlWrapper = this.scj;
        }
        if (this.sck != null && this.sck.length > 0) {
            w.i("MicroMsg.WebViewPermission", "albie: update setBlacklist jsapi(%s).", new Object[]{this.sck});
            jsapiPermissionWrapper.o(this.sck);
        }
        if (this.scl != null && this.scl.length > 0) {
            w.i("MicroMsg.WebViewPermission", "albie: update setWhitelist jsapi(%s).", new Object[]{this.scl});
            jsapiPermissionWrapper.p(this.scl);
        }
        w.i("MicroMsg.WebViewPermission", "edw update, jsPerm = " + jsapiPermissionWrapper + ", genCtrl = " + generalControlWrapper + ", url = " + xI);
        this.scf.put(xI, new a(jsapiPermissionWrapper, generalControlWrapper));
    }

    public final boolean has(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.WebViewPermission", "has fail, url is null");
            return false;
        }
        a aVar = (a) this.scf.get(xI(str));
        return (aVar == null || aVar.scm == this.sci || aVar.scn == this.scj) ? false : true;
    }

    public final JsapiPermissionWrapper bxQ() {
        if (this.scg != null) {
            w.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.scg);
            return this.scg;
        }
        return JN(this.saV == null ? null : this.saV.getUrl());
    }

    public final JsapiPermissionWrapper JN(String str) {
        if (this.scg != null) {
            w.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.scg);
            return this.scg;
        } else if (bg.mA(str)) {
            w.e("MicroMsg.WebViewPermission", "getJsPerm fail, url = " + str);
            return this.sci;
        } else {
            String xI = xI(str);
            if (this.scf == null) {
                w.e("MicroMsg.WebViewPermission", "getJsPerm fail, permMap is null");
                return this.sci;
            }
            a aVar = (a) this.scf.get(xI);
            return aVar == null ? this.sci : aVar.scm;
        }
    }

    public final GeneralControlWrapper bxR() {
        Object obj = null;
        if (this.sch != null) {
            w.i("MicroMsg.WebViewPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.sch);
            return this.sch;
        }
        String url;
        if (this.saV != null) {
            url = this.saV.getUrl();
            if (!bg.mA(url)) {
                String xI = xI(url);
                a aVar = (a) this.scf.get(xI);
                String str = "MicroMsg.WebViewPermission";
                StringBuilder stringBuilder = new StringBuilder("edw getGenCtrl, genCtrl = ");
                if (aVar != null) {
                    obj = aVar.scn;
                }
                w.i(str, stringBuilder.append(obj).append(", url = ").append(xI).toString());
                return aVar == null ? this.scj : aVar.scn;
            }
        } else {
            url = null;
        }
        w.e("MicroMsg.WebViewPermission", "getGenCtrl fail, url = " + url);
        return this.scj;
    }

    public final void detach() {
        w.i("MicroMsg.WebViewPermission", "detach");
        this.scf.clear();
        this.scf = null;
        this.saV = null;
    }

    private static String xI(String str) {
        int indexOf = str.indexOf("#");
        return indexOf < 0 ? str : str.substring(0, indexOf);
    }
}
