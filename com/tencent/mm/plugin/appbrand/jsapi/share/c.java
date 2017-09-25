package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import android.util.Log;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.menu.j;
import com.tencent.mm.plugin.appbrand.menu.k;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 240;
    public static final String NAME = "shareAppMessageDirectly";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.JsApiShareAppMessageDirectly", "invoke share app message directly.");
        if (jSONObject == null) {
            w.i("MicroMsg.JsApiShareAppMessageDirectly", "data is null");
            mVar.x(i, d("fail:data is null", null));
            return;
        }
        final MMActivity a = a(mVar);
        if (a == null) {
            w.i("MicroMsg.JsApiShareAppMessageDirectly", "share app message fail, context is null");
            mVar.x(i, d("fail: page context is null", null));
            return;
        }
        final com.tencent.mm.plugin.appbrand.g.m b = d.b(mVar);
        if (b == null) {
            w.i("MicroMsg.JsApiShareAppMessageDirectly", "share app message fail, pageView is null");
            mVar.x(i, d("fail:current page do not exist", null));
            return;
        }
        j ic = b.ic(k.jay);
        if (ic == null) {
            w.i("MicroMsg.JsApiShareAppMessageDirectly", "share app message fail, menuInfo is null.");
            mVar.x(i, d("fail:menu is null", null));
            return;
        }
        final AppBrandSysConfig mY = b.mY(mVar.ivH);
        final boolean z = ic.iHR.getBoolean("enable_share_with_share_ticket", false);
        final int i2 = z ? 3 : 2;
        final String optString = jSONObject.optString("title");
        final String optString2 = jSONObject.optString("desc", "");
        final String optString3 = jSONObject.optString("path");
        final String optString4 = jSONObject.optString("imageUrl");
        final String optString5 = jSONObject.optString("cacheKey");
        final boolean fR = ic.iHR.fR("enable_share_dynamic");
        final String str = mVar.ivH;
        final String str2 = mY.fCJ;
        int i3 = mY.iFk.izV;
        int i4 = mY.iFk.izW;
        final String nx = n.nx(mVar.ivH);
        final String a2 = i.a(b, optString4);
        Serializable hashMap = new HashMap();
        hashMap.put("desc", optString2);
        hashMap.put(Columns.TYPE, Integer.valueOf(i2));
        hashMap.put("title", optString);
        hashMap.put("app_id", str);
        hashMap.put("pkg_type", Integer.valueOf(i3));
        hashMap.put("pkg_version", Integer.valueOf(i4));
        hashMap.put("img_url", optString4);
        hashMap.put("is_dynamic", Boolean.valueOf(fR));
        hashMap.put("cache_key", optString5);
        hashMap.put("path", optString3);
        if (!bg.mA(a2)) {
            hashMap.put("delay_load_img_path", "file://" + a2);
        }
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("mutil_select_is_ret", !z);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("scene_from", 3);
        intent.putExtra("appbrand_params", hashMap);
        intent.putExtra("Retr_Msg_Type", 2);
        final m mVar2 = mVar;
        final int i5 = i;
        com.tencent.mm.bb.d.a(a, ".ui.transmit.SelectConversationUI", intent, 1, new MMActivity.a(this) {
            final /* synthetic */ c iVr;

            public final void a(int i, int i2, Intent intent) {
                if (i != 1) {
                    w.i("MicroMsg.JsApiShareAppMessageDirectly", "requestCode(%d) not corrected.", new Object[]{Integer.valueOf(i)});
                } else if (i2 != -1) {
                    w.i("MicroMsg.JsApiShareAppMessageDirectly", "resultCode is not RESULT_OK(%d)", new Object[]{Integer.valueOf(i2)});
                    mVar2.x(i5, this.iVr.d("cancel", null));
                } else {
                    String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                    if (stringExtra == null || stringExtra.length() == 0) {
                        w.e("MicroMsg.JsApiShareAppMessageDirectly", "mmOnActivityResult fail, toUser is null");
                        mVar2.x(i5, this.iVr.d("fail:selected user is nil", null));
                        return;
                    }
                    w.i("MicroMsg.JsApiShareAppMessageDirectly", "result success toUser : %s ", new Object[]{stringExtra});
                    String stringExtra2 = intent.getStringExtra("custom_send_text");
                    final MainProcessTask sendAppMessageTask = new SendAppMessageTask();
                    sendAppMessageTask.iVv = stringExtra2;
                    sendAppMessageTask.toUser = stringExtra;
                    sendAppMessageTask.appId = str;
                    sendAppMessageTask.userName = str2;
                    sendAppMessageTask.title = optString;
                    sendAppMessageTask.description = optString2;
                    sendAppMessageTask.url = nx;
                    sendAppMessageTask.path = optString3;
                    sendAppMessageTask.type = i2;
                    sendAppMessageTask.iVw = optString4;
                    sendAppMessageTask.iconUrl = mY.iEP;
                    sendAppMessageTask.fKL = mY.iFk.izV;
                    sendAppMessageTask.iGd = mY.iFk.izZ;
                    sendAppMessageTask.version = mY.iFk.izW;
                    sendAppMessageTask.fFa = mY.fGs;
                    l nt = l.nt(str);
                    int i3 = nt.ixp;
                    nt.ixp = i3 + 1;
                    sendAppMessageTask.ixp = i3;
                    sendAppMessageTask.iVz = b.jde.jdU;
                    sendAppMessageTask.iVA = b.VR();
                    AppBrandStatObject mZ = b.mZ(str);
                    if (mZ != null) {
                        sendAppMessageTask.scene = mZ.scene == 0 ? 1000 : mZ.scene;
                        sendAppMessageTask.fCN = bg.mz(mZ.fCN);
                        sendAppMessageTask.iVy = bg.mz(l.ns(str).ixn);
                    }
                    sendAppMessageTask.iVx = a2;
                    sendAppMessageTask.withShareTicket = z;
                    sendAppMessageTask.iVB = fR;
                    sendAppMessageTask.iHY = optString5;
                    com.tencent.mm.plugin.appbrand.jsapi.l.a VT = b.VT();
                    if (VT == null) {
                        stringExtra = "";
                    } else {
                        stringExtra = VT.iYA.getUrl();
                    }
                    sendAppMessageTask.iVC = stringExtra;
                    if (z) {
                        sendAppMessageTask.iMD = new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 iVs;

                            public final void run() {
                                w.i("MicroMsg.JsApiShareAppMessageDirectly", "task callback");
                                sendAppMessageTask.SN();
                                Map hashMap = new HashMap();
                                JSONArray jSONArray = new JSONArray();
                                try {
                                    if (!bg.bV(sendAppMessageTask.iVD)) {
                                        Iterator it = sendAppMessageTask.iVD.iterator();
                                        while (it.hasNext()) {
                                            ShareInfo shareInfo = (ShareInfo) it.next();
                                            JSONObject jSONObject = new JSONObject();
                                            jSONObject.put("shareKey", shareInfo.hpT);
                                            jSONObject.put("shareName", shareInfo.hpS);
                                            jSONArray.put(jSONObject);
                                        }
                                    }
                                } catch (Throwable e) {
                                    w.e("MicroMsg.JsApiShareAppMessageDirectly", Log.getStackTraceString(e));
                                }
                                hashMap.put("shareInfos", jSONArray);
                                mVar2.x(i5, this.iVs.iVr.d("ok", hashMap));
                            }
                        };
                        sendAppMessageTask.SM();
                        AppBrandMainProcessService.a(sendAppMessageTask);
                    } else {
                        AppBrandMainProcessService.a(sendAppMessageTask);
                        mVar2.x(i5, this.iVr.d("ok", null));
                    }
                    if (a != null) {
                        g.bl(a, a.getResources().getString(R.l.dDv));
                    }
                }
            }
        });
    }
}
