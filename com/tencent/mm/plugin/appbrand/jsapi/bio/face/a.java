package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.facedetect.ui.FaceTransparentStubUI;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    protected abstract boolean Tv();

    protected abstract String Tw();

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        super.a(mVar, jSONObject, i);
        Context a = a(mVar);
        if (a == null) {
            w.e("MicroMsg.JsApiFaceAsyncBase", "JsApiFaceAsyncBase context is null, appId is %s", new Object[]{mVar.ivH});
            mVar.x(i, d("fail", null));
            return;
        }
        String optString = jSONObject.optString("requestVerifyPreInfo");
        String str = mVar.ivH;
        int i2 = Tv() ? MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED : 1000;
        Bundle bundle = new Bundle();
        bundle.putBoolean("k_need_signature", true);
        bundle.putInt("k_server_scene", 5);
        bundle.putBoolean("key_is_need_video", Tv());
        bundle.putBoolean("is_check_dyncfg", false);
        bundle.putString("k_app_id", str);
        bundle.putString("request_verify_pre_info", optString);
        bundle.putInt("key_business_type", 4);
        bundle.putString("key_function_name", Tw());
        Intent intent = new Intent(a, FaceTransparentStubUI.class);
        intent.putExtra("KEY_EXTRAS", bundle);
        intent.putExtra("KEY_REQUEST_CODE", i2);
        a.uSV = new com.tencent.mm.ui.MMActivity.a(this) {
            final /* synthetic */ a iRu;

            public final void a(int i, int i2, Intent intent) {
                int i3 = 90199;
                Bundle bundle = null;
                if (intent != null) {
                    i3 = intent.getIntExtra("err_code", 90199);
                }
                a aVar;
                m mVar;
                int i4;
                if (i == 1000) {
                    w.i("MicroMsg.JsApiFaceAsyncBase", "alvinluo: requestWxFacePictureVerify errCode: %d", new Object[]{Integer.valueOf(i3)});
                    if (i3 == 0) {
                        aVar = this.iRu;
                        mVar = mVar;
                        i4 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        aVar.a(mVar, i4, bundle, "ok");
                    } else if (i3 == 90100) {
                        aVar = this.iRu;
                        mVar = mVar;
                        i4 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        aVar.a(mVar, i4, bundle, "cancel");
                    } else {
                        aVar = this.iRu;
                        mVar = mVar;
                        i4 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        aVar.a(mVar, i4, bundle, "fail");
                    }
                } else if (i == MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED) {
                    w.i("MicroMsg.JsApiFaceAsyncBase", "hy: REQUEST_FACE_DETECT_WITH_VIDEO errCode: %d", new Object[]{Integer.valueOf(i3)});
                    if (i3 == 0) {
                        aVar = this.iRu;
                        mVar = mVar;
                        i4 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        aVar.a(mVar, i4, bundle, "ok");
                    } else if (i3 == 90100) {
                        aVar = this.iRu;
                        mVar = mVar;
                        i4 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        aVar.a(mVar, i4, bundle, "cancel");
                    } else {
                        aVar = this.iRu;
                        mVar = mVar;
                        i4 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        aVar.a(mVar, i4, bundle, "fail");
                    }
                }
            }
        };
        a.startActivityForResult(intent, i2);
    }

    public final void a(m mVar, int i, Bundle bundle, String str) {
        int i2 = -1;
        String str2 = "not returned";
        Object obj = "";
        if (bundle != null) {
            i2 = bundle.getInt("err_code");
            str2 = bundle.getString("err_msg");
            obj = bundle.getString("verify_result");
        }
        Map hashMap = new HashMap(3);
        hashMap.put("errCode", Integer.valueOf(i2));
        hashMap.put("verifyResult", obj);
        if ("fail".equals(str)) {
            str = str + " " + str2;
        }
        mVar.x(i, d(str, hashMap));
    }
}
