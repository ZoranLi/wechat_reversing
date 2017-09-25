package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.nt;
import com.tencent.mm.e.a.nv;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.model.h;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.snackbar.b.c;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

public final class GameJsApiSendAppMessage extends a {
    public static final int CTRL_BYTE = 6;
    public static final String NAME = "sendAppMessage";
    public static int gaz;

    private static class SendAppMessageTask extends GameProcessActivityTask {
        public static final Creator<SendAppMessageTask> CREATOR = new Creator<SendAppMessageTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SendAppMessageTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SendAppMessageTask[i];
            }
        };
        String appId;
        String description;
        String extInfo;
        String fUR;
        String fWY;
        String iVv;
        String mkR;
        String mkS;
        String mkT;
        String mkU;
        Bundle mkV;
        int scene;
        String thumbUrl;
        String title;
        String toUser;
        String verifyAppId;

        public final void a(Context context, final GameProcessActivityTask.a aVar) {
            b cbVar;
            switch (this.scene) {
                case 1:
                    w.i("MicroMsg.GameJsApiSendAppMessage", "favoriteUrl");
                    cbVar = new cb();
                    com.tencent.mm.plugin.webview.model.b.a aVar2 = new com.tencent.mm.plugin.webview.model.b.a();
                    aVar2.url = this.mkS;
                    aVar2.thumbUrl = this.thumbUrl;
                    aVar2.title = this.title;
                    aVar2.desc = this.description;
                    aVar2.fTO = this.appId;
                    if (this.mkV != null) {
                        String fQ = q.fQ(bg.mz(this.mkV.getString("KPublisherId")));
                        q.b n = q.yC().n(fQ, true);
                        n.l("sendAppMsgScene", Integer.valueOf(2));
                        n.l("preChatName", this.mkV.getString("preChatName"));
                        n.l("preMsgIndex", Integer.valueOf(this.mkV.getInt("preMsgIndex")));
                        n.l("prePublishId", this.mkV.getString("prePublishId"));
                        n.l("preUsername", this.mkV.getString("preUsername"));
                        n.l("getA8KeyScene", Integer.valueOf(this.mkV.getInt("getA8KeyScene")));
                        n.l("referUrl", this.mkV.getString("referUrl"));
                        if (!bg.mA(null)) {
                            n.l("adExtStr", null);
                        }
                        cbVar.fFA.fFF = fQ;
                    }
                    if (context != null && (context instanceof MMActivity)) {
                        cbVar.fFA.activity = (Activity) context;
                        cbVar.fFA.fFH = 36;
                    }
                    cbVar.fFA.fFJ = new c(this) {
                        final /* synthetic */ SendAppMessageTask mkW;

                        public final void azn() {
                        }

                        public final void onHide() {
                            w.d("MicroMsg.GameJsApiSendAppMessage", "onHide");
                            aVar.TP();
                        }

                        public final void azo() {
                        }
                    };
                    com.tencent.mm.plugin.webview.model.b.a(cbVar, aVar2);
                    com.tencent.mm.sdk.b.a.urY.m(cbVar);
                    return;
                default:
                    w.i("MicroMsg.GameJsApiSendAppMessage", "sendToFriend");
                    if (bg.mA(this.toUser)) {
                        w.e("MicroMsg.GameJsApiSendAppMessage", "toUser is null");
                        return;
                    }
                    n.GR();
                    Bitmap gS = com.tencent.mm.ah.b.gS(this.thumbUrl);
                    IMediaObject wXWebpageObject = new WXWebpageObject();
                    wXWebpageObject.webpageUrl = this.mkS;
                    wXWebpageObject.extInfo = this.extInfo;
                    WXMediaMessage wXMediaMessage = new WXMediaMessage();
                    wXMediaMessage.mediaObject = wXWebpageObject;
                    wXMediaMessage.title = this.title;
                    wXMediaMessage.description = this.description;
                    if (!(gS == null || gS.isRecycled())) {
                        w.i("MicroMsg.GameJsApiSendAppMessage", "thumb image is not null");
                        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        gS.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                        wXMediaMessage.thumbData = byteArrayOutputStream.toByteArray();
                    }
                    f aJ = g.aJ(this.appId, true);
                    b ntVar = new nt();
                    ntVar.fUP.fNK = wXMediaMessage;
                    ntVar.fUP.appId = this.appId;
                    ntVar.fUP.appName = aJ == null ? "" : aJ.field_appName;
                    ntVar.fUP.toUser = this.toUser;
                    ntVar.fUP.fUQ = 2;
                    if (bg.mA(this.fUR)) {
                        ntVar.fUP.fUT = null;
                    } else {
                        ntVar.fUP.fUR = this.fUR;
                        ntVar.fUP.fUS = this.mkR;
                    }
                    ntVar.fUP.fUU = this.fWY;
                    ntVar.fUP.fUX = this.mkU;
                    ntVar.fUP.fFF = q.fQ(this.mkU);
                    ntVar.fUP.fUV = this.mkT;
                    ntVar.fUP.fUW = this.verifyAppId;
                    com.tencent.mm.sdk.b.a.urY.m(ntVar);
                    if (!bg.mA(this.iVv)) {
                        cbVar = new nv();
                        cbVar.fVa.fVb = this.toUser;
                        cbVar.fVa.content = this.iVv;
                        cbVar.fVa.type = o.fG(this.toUser);
                        cbVar.fVa.flags = 0;
                        com.tencent.mm.sdk.b.a.urY.m(cbVar);
                    }
                    aVar.TP();
                    return;
            }
        }

        public final void f(Parcel parcel) {
            this.scene = parcel.readInt();
            this.appId = parcel.readString();
            this.fUR = parcel.readString();
            this.mkR = parcel.readString();
            this.iVv = parcel.readString();
            this.toUser = parcel.readString();
            this.thumbUrl = parcel.readString();
            this.title = parcel.readString();
            this.description = parcel.readString();
            this.mkS = parcel.readString();
            this.extInfo = parcel.readString();
            this.fWY = parcel.readString();
            this.mkT = parcel.readString();
            this.verifyAppId = parcel.readString();
            this.mkU = parcel.readString();
            this.mkV = parcel.readBundle();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.scene);
            parcel.writeString(this.appId);
            parcel.writeString(this.fUR);
            parcel.writeString(this.mkR);
            parcel.writeString(this.iVv);
            parcel.writeString(this.toUser);
            parcel.writeString(this.thumbUrl);
            parcel.writeString(this.title);
            parcel.writeString(this.description);
            parcel.writeString(this.mkS);
            parcel.writeString(this.fWY);
            parcel.writeString(this.mkT);
            parcel.writeString(this.verifyAppId);
            parcel.writeString(this.mkU);
            parcel.writeString(this.extInfo);
            parcel.writeBundle(this.mkV);
        }

        public SendAppMessageTask(Context context) {
            super(context);
        }

        public SendAppMessageTask(Parcel parcel) {
            f(parcel);
        }
    }

    public final void a(final d dVar, final JSONObject jSONObject, final int i) {
        w.i("MicroMsg.GameJsApiSendAppMessage", "invoke");
        if (jSONObject == null) {
            w.e("MicroMsg.GameJsApiSendAppMessage", "sendAppMessage fail, appmsg is null");
            dVar.x(i, a.d("send_app_msg:fail_null_params", null));
        } else if (bg.mA(jSONObject.optString("link"))) {
            w.e("MicroMsg.GameJsApiSendAppMessage", "link is null");
            dVar.x(i, a.d("send_app_msg:fail_invalid_params", null));
        } else {
            switch (gaz) {
                case 1:
                    SendAppMessageTask sendAppMessageTask = new SendAppMessageTask(dVar.azK());
                    sendAppMessageTask.scene = gaz;
                    sendAppMessageTask.appId = jSONObject.optString("appid");
                    sendAppMessageTask.thumbUrl = jSONObject.optString("img_url");
                    sendAppMessageTask.fUR = jSONObject.optString("src_username");
                    sendAppMessageTask.mkR = jSONObject.optString("src_displayname");
                    sendAppMessageTask.title = jSONObject.optString("title");
                    sendAppMessageTask.description = jSONObject.optString("desc");
                    sendAppMessageTask.mkS = dVar.xH(jSONObject.optString("link"));
                    sendAppMessageTask.fWY = bg.mz(dVar.mlI);
                    sendAppMessageTask.mkT = dVar.azN();
                    sendAppMessageTask.verifyAppId = dVar.azO();
                    sendAppMessageTask.extInfo = jSONObject.optString("review_data");
                    Bundle bundle = new Bundle();
                    bundle.putString("KPublisherId", bg.mz(dVar.uT.getString("KPublisherId")));
                    int ab = com.tencent.mm.plugin.game.gamewebview.a.d.ab(dVar.scene, dVar.uT.getString("geta8key_username"));
                    bundle.putString("preChatName", dVar.uT.getString("preChatName"));
                    bundle.putInt("preMsgIndex", dVar.uT.getInt("preMsgIndex", 0));
                    bundle.putString("prePublishId", dVar.uT.getString("prePublishId"));
                    bundle.putString("preUsername", dVar.uT.getString("preUsername"));
                    bundle.putInt("getA8KeyScene", ab);
                    bundle.putString("referUrl", dVar.mmO);
                    sendAppMessageTask.mkV = bundle;
                    sendAppMessageTask.avz();
                    dVar.x(i, "send_app_msg:ok");
                    break;
                default:
                    h.a(dVar, jSONObject);
                    Serializable hashMap = new HashMap();
                    hashMap.put("img_url", jSONObject.optString("img_url"));
                    hashMap.put("desc", jSONObject.optString("desc"));
                    hashMap.put("title", jSONObject.optString("title"));
                    hashMap.put(SlookSmartClipMetaTag.TAG_TYPE_URL, jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL));
                    Intent intent = new Intent();
                    intent.putExtra("Select_Conv_Type", 3);
                    intent.putExtra("scene_from", 2);
                    intent.putExtra("mutil_select_is_ret", true);
                    intent.putExtra("webview_params", hashMap);
                    intent.putExtra("Retr_Msg_Type", 2);
                    com.tencent.mm.bb.d.a(dVar.azK(), ".ui.transmit.SelectConversationUI", intent, 1, new MMActivity.a(this) {
                        final /* synthetic */ GameJsApiSendAppMessage mkQ;

                        public final void a(int i, int i2, Intent intent) {
                            if (i == 1) {
                                String str;
                                String optString = jSONObject.optString("appid");
                                if (this.mkQ.mjH == null || !bg.mA(optString)) {
                                    str = optString;
                                } else {
                                    str = this.mkQ.mjH.getString("jsapi_args_appid");
                                }
                                switch (i2) {
                                    case -1:
                                        if (intent == null) {
                                            optString = null;
                                        } else {
                                            optString = intent.getStringExtra("Select_Conv_User");
                                        }
                                        d dVar;
                                        int i3;
                                        GameJsApiSendAppMessage gameJsApiSendAppMessage;
                                        if (optString == null || optString.length() == 0) {
                                            w.e("MicroMsg.GameJsApiSendAppMessage", "mmOnActivityResult fail, toUser is null");
                                            dVar = dVar;
                                            i3 = i;
                                            gameJsApiSendAppMessage = this.mkQ;
                                            dVar.x(i3, a.d("send_app_msg:fail", null));
                                            return;
                                        }
                                        SendAppMessageTask sendAppMessageTask = new SendAppMessageTask(dVar.azK());
                                        sendAppMessageTask.scene = GameJsApiSendAppMessage.gaz;
                                        sendAppMessageTask.appId = str;
                                        sendAppMessageTask.toUser = optString;
                                        sendAppMessageTask.thumbUrl = (String) jSONObject.opt("img_url");
                                        sendAppMessageTask.fUR = (String) jSONObject.opt("src_username");
                                        sendAppMessageTask.mkR = (String) jSONObject.opt("src_displayname");
                                        sendAppMessageTask.iVv = intent.getStringExtra("custom_send_text");
                                        sendAppMessageTask.title = jSONObject.optString("title");
                                        sendAppMessageTask.description = jSONObject.optString("desc");
                                        sendAppMessageTask.mkS = dVar.xH(jSONObject.optString("link"));
                                        sendAppMessageTask.fWY = bg.mz(dVar.mlI);
                                        sendAppMessageTask.mkT = dVar.azN();
                                        sendAppMessageTask.verifyAppId = dVar.azO();
                                        sendAppMessageTask.extInfo = jSONObject.optString("review_data");
                                        sendAppMessageTask.avz();
                                        com.tencent.mm.ui.base.g.bl(dVar.azK(), dVar.getResources().getString(R.l.dIG));
                                        dVar = dVar;
                                        i3 = i;
                                        gameJsApiSendAppMessage = this.mkQ;
                                        dVar.x(i3, a.d("send_app_msg:ok", null));
                                        return;
                                    default:
                                        return;
                                }
                            }
                        }
                    });
                    break;
            }
            gaz = 0;
        }
    }
}
