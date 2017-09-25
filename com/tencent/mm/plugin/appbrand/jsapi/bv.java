package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.protocal.c.ds;
import com.tencent.mm.protocal.c.dt;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.b;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bv extends a {
    public static final int CTRL_INDEX = 208;
    public static final String NAME = "requestAuthUserAutoFillData";

    class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ m iMo;
        final /* synthetic */ bv iPr;

        AnonymousClass2(bv bvVar, m mVar) {
            this.iPr = bvVar;
            this.iMo = mVar;
        }

        public final void onClick(View view) {
            w.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do know the auth auto fill data protocol");
            String str = this.iMo.mContext.getString(R.l.dDF) + v.bIN();
            w.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do open url:" + str);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            d.b(this.iMo.mContext, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    class AnonymousClass3 implements DialogInterface.OnClickListener {
        final /* synthetic */ b htZ;
        final /* synthetic */ int iHi;
        final /* synthetic */ m iMo;
        final /* synthetic */ ds iPn;
        final /* synthetic */ bv iPr;

        AnonymousClass3(bv bvVar, ds dsVar, m mVar, int i, b bVar) {
            this.iPr = bvVar;
            this.iPn = dsVar;
            this.iMo = mVar;
            this.iHi = i;
            this.htZ = bVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            w.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do accept the auto fill data protocol");
            this.iPn.thw = true;
            this.iMo.x(this.iHi, this.iPr.d("ok", null));
            com.tencent.mm.ipcinvoker.wx_extension.b.a(this.htZ, new a(this) {
                final /* synthetic */ AnonymousClass3 iPs;

                {
                    this.iPs = r1;
                }

                public final void a(int i, int i2, String str, b bVar) {
                    if (i == 0 && i2 == 0 && bVar.hsk.hsr != null) {
                        w.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData success");
                        return;
                    }
                    w.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hsk.hsr});
                }
            });
        }
    }

    class AnonymousClass4 implements DialogInterface.OnClickListener {
        final /* synthetic */ b htZ;
        final /* synthetic */ int iHi;
        final /* synthetic */ m iMo;
        final /* synthetic */ ds iPn;
        final /* synthetic */ bv iPr;

        AnonymousClass4(bv bvVar, ds dsVar, m mVar, int i, b bVar) {
            this.iPr = bvVar;
            this.iPn = dsVar;
            this.iMo = mVar;
            this.iHi = i;
            this.htZ = bVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            w.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do not accept the auto fill data protocol");
            this.iPn.thw = false;
            this.iMo.x(this.iHi, this.iPr.d("cancel", null));
            com.tencent.mm.ipcinvoker.wx_extension.b.a(this.htZ, new a(this) {
                final /* synthetic */ AnonymousClass4 iPt;

                {
                    this.iPt = r1;
                }

                public final void a(int i, int i2, String str, b bVar) {
                    if (i == 0 && i2 == 0 && bVar.hsk.hsr != null) {
                        w.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData success");
                        return;
                    }
                    w.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hsk.hsr});
                }
            });
        }
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            w.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData data is invalid");
            mVar.x(i, d("fail:data is invalid", null));
            return;
        }
        int i2;
        LinkedList linkedList = new LinkedList();
        JSONArray optJSONArray = jSONObject.optJSONArray("fields");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                linkedList.add(optJSONArray.optString(i2));
            }
        }
        final Object optString = jSONObject.optString("wording");
        final int optInt = jSONObject.optInt("authStatus", 2);
        final LinkedList linkedList2 = new LinkedList();
        optJSONArray = jSONObject.optJSONArray("authGroupList");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                linkedList2.add("  " + optJSONArray.optString(i2));
            }
        }
        if (linkedList.size() == 0) {
            w.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData fields is empty");
            mVar.x(i, d("fail:fields is empty", null));
        } else if (TextUtils.isEmpty(optString)) {
            w.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData wording is empty");
            mVar.x(i, d("fail:wording is empty", null));
        } else {
            w.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData appId:%s", new Object[]{mVar.ivH});
            w.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "wording:%s, authType:%d, fieldIds:%s", new Object[]{optString, Integer.valueOf(optInt), jSONObject.optJSONArray("fields").toString()});
            if (jSONObject.optJSONArray("authGroupList") != null) {
                w.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "authGroupList:%s", new Object[]{jSONObject.optJSONArray("authGroupList").toString()});
            }
            b.a aVar = new b.a();
            aVar.hsm = new ds();
            aVar.hsn = new dt();
            aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/authinfo";
            aVar.hsl = 1183;
            aVar.hso = 0;
            aVar.hsp = 0;
            final b BE = aVar.BE();
            final ds dsVar = (ds) BE.hsj.hsr;
            dsVar.thv = linkedList;
            dsVar.fTO = r0;
            dsVar.thx = optInt;
            final m mVar2 = mVar;
            final int i3 = i;
            af.v(new Runnable(this) {
                final /* synthetic */ bv iPr;

                public final void run() {
                    bv bvVar = this.iPr;
                    m mVar = mVar2;
                    int i = i3;
                    ds dsVar = dsVar;
                    b bVar = BE;
                    int i2 = optInt;
                    CharSequence charSequence = optString;
                    LinkedList linkedList = linkedList2;
                    String string = i2 == 2 ? mVar.mContext.getString(R.l.dDC) : mVar.mContext.getString(R.l.dDD);
                    String string2 = mVar.mContext.getString(R.l.dDE);
                    String string3 = mVar.mContext.getString(R.l.dDB);
                    CharSequence string4 = mVar.mContext.getString(R.l.dDA);
                    LayoutInflater layoutInflater = (LayoutInflater) mVar.mContext.getSystemService("layout_inflater");
                    View inflate = layoutInflater.inflate(R.i.cTV, null);
                    TextView textView = (TextView) inflate.findViewById(R.h.boQ);
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.h.boR);
                    ((TextView) inflate.findViewById(R.h.boP)).setText(charSequence);
                    textView.setText(string4);
                    textView.setOnClickListener(new AnonymousClass2(bvVar, mVar));
                    linearLayout.removeAllViews();
                    if (linkedList == null || linkedList.size() <= 0) {
                        LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
                        layoutParams.leftMargin = 0;
                        textView.setLayoutParams(layoutParams);
                        linearLayout.setVisibility(8);
                    } else {
                        linearLayout.setVisibility(0);
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            textView = (TextView) layoutInflater.inflate(R.i.cTR, null);
                            textView.setText((String) it.next());
                            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, -2);
                            layoutParams2.bottomMargin = mVar.jbY.getResources().getDimensionPixelOffset(R.f.aYh);
                            textView.setLayoutParams(layoutParams2);
                            linearLayout.addView(textView);
                        }
                    }
                    w.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "show the auto fill data protocol dialog!");
                    g.a(mVar.mContext, false, string, inflate, string2, string3, new AnonymousClass3(bvVar, dsVar, mVar, i, bVar), new AnonymousClass4(bvVar, dsVar, mVar, i, bVar));
                }
            });
        }
    }
}
