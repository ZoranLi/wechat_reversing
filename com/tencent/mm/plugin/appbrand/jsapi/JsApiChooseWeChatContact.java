package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.x.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class JsApiChooseWeChatContact extends a {
    public static final int CTRL_INDEX = 195;
    public static final String NAME = "chooseWeChatContact";

    private static class GetUserDataTask extends MainProcessTask {
        public static final Creator<GetUserDataTask> CREATOR = new Creator<GetUserDataTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new GetUserDataTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetUserDataTask[i];
            }
        };
        String aIO;
        String aIP;
        public String iMm;
        String iMn = "";
        public String userName;

        public GetUserDataTask(String str) {
            this.userName = str;
        }

        public GetUserDataTask(Parcel parcel) {
            f(parcel);
        }

        public final void PM() {
            this.iMm = m.xL();
            if (!TextUtils.isEmpty(this.userName)) {
                this.aIO = n.eJ(this.userName);
                this.aIP = n.eL(this.userName);
                h hs = com.tencent.mm.x.n.Bm().hs(this.userName);
                if (hs != null) {
                    this.iMn = hs.Bs();
                    if (bg.mA(this.iMn)) {
                        this.iMn = hs.Bt();
                    }
                }
            }
        }

        public final void f(Parcel parcel) {
            this.iMm = parcel.readString();
            this.userName = parcel.readString();
            this.aIO = parcel.readString();
            this.aIP = parcel.readString();
            this.iMn = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.iMm);
            parcel.writeString(this.userName);
            parcel.writeString(this.aIO);
            parcel.writeString(this.aIP);
            parcel.writeString(this.iMn);
        }
    }

    JsApiChooseWeChatContact() {
    }

    public final void a(final com.tencent.mm.plugin.appbrand.m mVar, JSONObject jSONObject, final int i) {
        MMActivity a = a(mVar);
        if (a == null) {
            w.e("MicroMsg.JsApiChooseWeChatContact", "ChooseWeChatContact context is null, appId is %s", new Object[]{mVar.ivH});
            mVar.x(i, d("fail", null));
            return;
        }
        w.i("MicroMsg.JsApiChooseWeChatContact", "ChooseWeChatContact appId:%s", new Object[]{mVar.ivH});
        Intent intent = new Intent();
        String string = a.getString(R.l.eQw);
        int i2 = 259;
        int[] iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075};
        w.i("MicroMsg.JsApiChooseWeChatContact", "ChooseWeChatContact data %s:", new Object[]{jSONObject});
        if (!(jSONObject == null || jSONObject.optJSONArray("contactMode") == null || jSONObject.optJSONArray("contactMode").length() <= 0)) {
            String jSONArray = jSONObject.optJSONArray("contactMode").toString();
            if (jSONArray.contains("singleContact") && !jSONArray.contains("chatroom")) {
                i2 = 263;
                string = a.getString(R.l.eQu);
                iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
            } else if (jSONArray.contains("chatroom") && !jSONArray.contains("singleContact")) {
                i2 = aq.CTRL_BYTE;
                iArr = new int[]{131075};
            }
        }
        intent.putExtra("Select_Conv_Type", i2);
        intent.putExtra("jsapi_select_mode", 1);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("scene_from", 9);
        intent.putExtra("Select_Conv_ui_title", string);
        intent.putExtra("search_range", iArr);
        MainProcessTask getUserDataTask = new GetUserDataTask("");
        AppBrandMainProcessService.b(getUserDataTask);
        intent.putExtra("Select_block_List", getUserDataTask.iMm);
        d.a(a, ".ui.transmit.SelectConversationUI", intent, 100, new a(this) {
            final /* synthetic */ JsApiChooseWeChatContact iMl;

            public final void a(int i, int i2, Intent intent) {
                if (100 != i) {
                    w.e("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact requestCode not equal, requestCode = %d", new Object[]{Integer.valueOf(i)});
                    mVar.x(i, this.iMl.d("fail", null));
                } else if (i2 == 0 || i2 == 1) {
                    w.e("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact user cancel, resultCode = %d", new Object[]{Integer.valueOf(i)});
                    mVar.x(i, this.iMl.d("cancel", null));
                } else if (i2 == -1) {
                    String str;
                    if (intent == null) {
                        str = null;
                    } else {
                        str = intent.getStringExtra("Select_Conv_User");
                    }
                    if (str == null || str.length() == 0) {
                        w.e("MicroMsg.JsApiChooseWeChatContact", "mmOnActivityResult, selectSingleContact fail, user is null");
                        mVar.x(i, this.iMl.d("fail", null));
                        return;
                    }
                    MainProcessTask getUserDataTask = new GetUserDataTask(str);
                    AppBrandMainProcessService.b(getUserDataTask);
                    String str2 = getUserDataTask.aIO;
                    String str3 = getUserDataTask.aIP;
                    String str4 = getUserDataTask.iMn;
                    Map hashMap = new HashMap();
                    hashMap.put("avatarUrl", str4);
                    hashMap.put("userName", str);
                    hashMap.put("nickName", str2);
                    hashMap.put("remarkName", str3);
                    w.i("MicroMsg.JsApiChooseWeChatContact", "selectSingleContact: nickName:%s, remarkName:%s", new Object[]{str2, str3});
                    mVar.x(i, this.iMl.d("ok", hashMap));
                }
            }
        });
    }
}
