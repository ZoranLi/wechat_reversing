package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import android.util.Log;
import com.tencent.mm.R;
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

public final class b extends a {
    public static final int CTRL_INDEX = 73;
    public static final String NAME = "shareAppMessage";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            w.i("MicroMsg.JsApiShareAppMessage", "data is null");
            mVar.x(i, d("fail:data is null", null));
            return;
        }
        final com.tencent.mm.plugin.appbrand.g.m b = d.b(mVar);
        if (b == null) {
            w.i("MicroMsg.JsApiShareAppMessage", "share app message fail, pageView is null");
            mVar.x(i, d("fail:current page do not exist", null));
            return;
        }
        j ic = b.ic(k.jay);
        if (ic == null) {
            w.i("MicroMsg.JsApiShareAppMessage", "share app message fail, menuInfo is null.");
            mVar.x(i, d("fail:menu is null", null));
            return;
        }
        com.tencent.mm.u.q.b bVar = ic.iHR;
        if (bVar.fR("user_clicked_share_btn")) {
            w.i("MicroMsg.JsApiShareAppMessage", "invoke share app message");
            bVar.o("user_clicked_share_btn", false);
            final MMActivity a = a(mVar);
            if (a == null) {
                w.i("MicroMsg.JsApiShareAppMessage", "share app message fail, context is null");
                mVar.x(i, d("fail: page context is null", null));
                return;
            }
            final AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(mVar.ivH);
            final boolean z = bVar.getBoolean("enable_share_with_share_ticket", false);
            final int i2 = z ? 3 : 2;
            final String optString = jSONObject.optString("title");
            final String optString2 = jSONObject.optString("desc", "");
            final String optString3 = jSONObject.optString("path");
            final String optString4 = jSONObject.optString("imageUrl");
            final String optString5 = jSONObject.optString("cacheKey");
            final boolean fR = bVar.fR("enable_share_dynamic");
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
                final /* synthetic */ b iVn;

                public final void a(int i, final int i2, Intent intent) {
                    int i3 = 16;
                    if (i != 1) {
                        w.i("MicroMsg.JsApiShareAppMessage", "requestCode(%d) not corrected.", new Object[]{Integer.valueOf(i)});
                    } else if (i2 != -1) {
                        w.i("MicroMsg.JsApiShareAppMessage", "resultCode is not RESULT_OK(%d)", new Object[]{Integer.valueOf(i2)});
                        mVar2.x(i5, this.iVn.d("cancel", null));
                        r0 = str;
                        r1 = optString3;
                        if (!z) {
                            i3 = 2;
                        }
                        b.a(r0, r1, i3, "", 3, i2);
                    } else {
                        r1 = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                        if (r1 == null || r1.length() == 0) {
                            w.e("MicroMsg.JsApiShareAppMessage", "mmOnActivityResult fail, toUser is null");
                            mVar2.x(i5, this.iVn.d("fail:selected user is nil", null));
                            if (!z) {
                                i3 = 2;
                            }
                            b.a(str, optString3, i3, "", 2, i2);
                            return;
                        }
                        w.i("MicroMsg.JsApiShareAppMessage", "result success toUser : %s ", new Object[]{r1});
                        r0 = intent.getStringExtra("custom_send_text");
                        final MainProcessTask sendAppMessageTask = new SendAppMessageTask();
                        sendAppMessageTask.iVv = r0;
                        sendAppMessageTask.toUser = r1;
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
                        int i4 = nt.ixp;
                        nt.ixp = i4 + 1;
                        sendAppMessageTask.ixp = i4;
                        sendAppMessageTask.iVz = b.jde.jdU;
                        sendAppMessageTask.iVA = b.VR();
                        AppBrandStatObject mZ = com.tencent.mm.plugin.appbrand.b.mZ(str);
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
                            r0 = "";
                        } else {
                            r0 = VT.iYA.getUrl();
                        }
                        sendAppMessageTask.iVC = r0;
                        if (z) {
                            sendAppMessageTask.iMD = new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 iVq;

                                public final void run() {
                                    w.i("MicroMsg.JsApiShareAppMessage", "task callback");
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
                                        w.e("MicroMsg.JsApiShareAppMessage", Log.getStackTraceString(e));
                                    }
                                    hashMap.put("shareInfos", jSONArray);
                                    mVar2.x(i5, this.iVq.iVn.d("ok", hashMap));
                                    int i = 16;
                                    String str = r1 + ":";
                                    if (r1.toLowerCase().endsWith("@chatroom")) {
                                        i = 15;
                                    }
                                    b.a(str, optString3, i, str, 1, i2);
                                }
                            };
                            sendAppMessageTask.SM();
                            AppBrandMainProcessService.a(sendAppMessageTask);
                        } else {
                            AppBrandMainProcessService.a(sendAppMessageTask);
                            mVar2.x(i5, this.iVn.d("ok", null));
                            if (r1.toLowerCase().endsWith("@chatroom")) {
                                i3 = 9;
                            } else {
                                i3 = 2;
                            }
                            b.a(str, optString3, i3, "", 1, i2);
                        }
                        if (a != null) {
                            g.bl(a, a.getResources().getString(R.l.dDv));
                        }
                    }
                }
            });
            return;
        }
        w.i("MicroMsg.JsApiShareAppMessage", "share app message fail, not allow to share");
        mVar.x(i, d("fail:not allow to share", null));
    }

    public static void a(String str, String str2, int i, String str3, int i2, int i3) {
        com.tencent.mm.plugin.appbrand.report.a.a(str, str2, i, str3, bg.Ny(), i2, i3);
    }
}
