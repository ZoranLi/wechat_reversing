package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.bb.d;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.network.e;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.l.k;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.c;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.chatting.ev;
import com.tencent.mm.ui.chatting.ew;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;
import java.util.Map;

@a(7)
public class UIEntryStub extends Activity {
    private Intent fNO;
    private int jPf;
    private boolean jPg;
    private String uq;

    static /* synthetic */ void a(UIEntryStub uIEntryStub, final Bundle bundle) {
        boolean z = false;
        uIEntryStub.uq = bundle.getString(ConstantsAPI.APP_PACKAGE);
        uIEntryStub.jPf = bundle.getInt(ConstantsAPI.SDK_VERSION);
        String queryParameter = Uri.parse(bundle.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid");
        w.d("MicroMsg.UIEntryStub", "handleWXAppMessage, appId = " + queryParameter);
        if (g.bo(queryParameter)) {
            k kVar = l.a.sBw;
            if (kVar != null) {
                kVar.m(uIEntryStub, queryParameter, uIEntryStub.uq);
            }
        }
        int i = bundle.getInt("_wxapi_command_type");
        w.i("MicroMsg.UIEntryStub", "handle wxapp message: " + uIEntryStub.uq + ", sdkver=" + uIEntryStub.jPf + ", cmd=" + i);
        switch (i) {
            case 1:
                if (ap.zb() && !ap.uP()) {
                    c dX = com.tencent.mm.u.c.c.Az().dX("100273");
                    if (dX.isValid()) {
                        Map bKK = dX.bKK();
                        if (bKK == null) {
                            w.i("MicroMsg.UIEntryStub", "isSDKOauthNative args == null");
                        } else if (bKK.containsKey("isUseNative") && "1".equals(bKK.get("isUseNative"))) {
                            z = true;
                        } else {
                            w.i("MicroMsg.UIEntryStub", "isSDKOauthNative not contain the isUseNative key or the value is not 1");
                        }
                    } else {
                        w.i("MicroMsg.UIEntryStub", "isSDKOauthNative item.isValid is false");
                    }
                    if (!z) {
                        Intent putExtras = new Intent().putExtras(bundle);
                        putExtras.putExtra("mode", 1);
                        putExtras.putExtra("forceHideShare", true);
                        putExtras.putExtra("neverGetA8Key", true);
                        putExtras.putExtra("geta8key_scene", 6);
                        putExtras.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                        putExtras.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
                        d.b((Context) uIEntryStub, "webview", ".ui.tools.OAuthUI", putExtras);
                        break;
                    }
                    d.b((Context) uIEntryStub, "webview", ".ui.tools.SDKOAuthUI", new Intent().putExtras(bundle));
                    break;
                }
                w.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                break;
                break;
            case 2:
                final Req req = new Req(bundle);
                if (req.message != null && req.message.getType() == 2) {
                    WXImageObject wXImageObject = (WXImageObject) req.message.mediaObject;
                    if (!(wXImageObject == null || wXImageObject.checkArgs())) {
                        w.e("MicroMsg.UIEntryStub", "dealSendMsgToWx fail, WXImageObject checkArgs fail, maybe use deprecated field imageUrl");
                        ReportUtil.a(uIEntryStub, ReportUtil.b(uIEntryStub.getIntent().getExtras(), -5));
                        uIEntryStub.finish();
                        return;
                    }
                }
                if (req.message.getType() != 38 || req.scene == 1) {
                    if (req.scene == 1) {
                        w.i("MicroMsg.UIEntryStub", "sendMessageToWx, req.scene = send to timeline");
                        if (req.message.getType() == 8) {
                            w.e("MicroMsg.UIEntryStub", "sendMessageToWx fail, emoji does not support WXSceneTimeline");
                            ReportUtil.a(uIEntryStub, ReportUtil.b(uIEntryStub.getIntent().getExtras(), -5));
                        } else {
                            new d(uIEntryStub, queryParameter, req.openId, new d.a(uIEntryStub) {
                                final /* synthetic */ UIEntryStub jPh;

                                public final void cR(boolean z) {
                                    boolean isFinishing = this.jPh.isFinishing();
                                    w.d("MicroMsg.UIEntryStub", "onCheckEnd, isPass = " + z + ", isFinishing = " + isFinishing);
                                    if (z && !isFinishing) {
                                        Intent intent = new Intent(this.jPh, SendAppMessageWrapperUI.class);
                                        intent.putExtras(bundle);
                                        intent.putExtra("Select_Conv_User", "weixinfile");
                                        intent.putExtra("SendAppMessageWrapper_Scene", req.scene);
                                        this.jPh.startActivity(intent);
                                    }
                                    this.jPh.finish();
                                }
                            }).acH();
                            return;
                        }
                    }
                    Parcelable b = ReportUtil.b(bundle, -2);
                    Intent intent = new Intent(uIEntryStub, SelectConversationUI.class);
                    intent.putExtra("Select_Report_Args", b);
                    intent.putExtra("Select_Conv_NextStep", new Intent(uIEntryStub, SendAppMessageWrapperUI.class).putExtras(bundle).putExtra("SendAppMessageWrapper_Scene", req.scene).putExtra("animation_pop_in", true));
                    intent.putExtra("Select_App_Id", queryParameter);
                    intent.putExtra("Select_Open_Id", req.openId);
                    intent.putExtra("Select_Conv_Type", 3);
                    intent.putExtra("mutil_select_is_ret", true);
                    if (!ap.zb() || ap.uP()) {
                        w.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                    } else {
                        uIEntryStub.startActivity(intent);
                    }
                    uIEntryStub.finish();
                    return;
                }
                w.e("MicroMsg.UIEntryStub", "dealSendMsgToWx fail, video file object only supported share to timeline");
                ReportUtil.a(uIEntryStub, ReportUtil.b(uIEntryStub.getIntent().getExtras(), -5));
                uIEntryStub.finish();
                return;
            case 3:
                if (ap.zb() && !ap.uP()) {
                    ev.ad(bundle);
                    break;
                } else {
                    w.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                    break;
                }
                break;
            case 4:
                if (ap.zb() && !ap.uP()) {
                    ew.ad(bundle);
                    break;
                } else {
                    w.e("MicroMsg.UIEntryStub", "not logged in, ignore");
                    break;
                }
                break;
        }
        uIEntryStub.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NotifyReceiver.pX();
        this.jPg = false;
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.fNO = intent;
        w.i("MicroMsg.UIEntryStub", "onNewIntent mHasHandled: %b", Boolean.valueOf(this.jPg));
        this.jPg = false;
    }

    public void onResume() {
        super.onResume();
        if (this.fNO == null) {
            this.fNO = getIntent();
        }
        ap.vd().a(new bb(new bb.a(this) {
            final /* synthetic */ UIEntryStub jPh;

            {
                this.jPh = r1;
            }

            public final void a(e eVar) {
                if (eVar == null) {
                    this.jPh.finish();
                    return;
                }
                w.i("MicroMsg.UIEntryStub", "onResume mHasHandled: %b", Boolean.valueOf(this.jPh.jPg));
                if (!this.jPh.jPg) {
                    this.jPh.jPg = true;
                    UIEntryStub.a(this.jPh, this.jPh.fNO.getExtras());
                }
            }
        }), 0);
    }
}
