package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.CountDownTimer;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.ui.AppBrandRedirectUI;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ahh;
import com.tencent.mm.protocal.c.ahi;
import com.tencent.mm.protocal.c.aye;
import com.tencent.mm.protocal.c.ayf;
import com.tencent.mm.protocal.c.le;
import com.tencent.mm.protocal.c.lf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.b;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public final class ag extends a {
    public static final int CTRL_INDEX = 209;
    public static final String NAME = "getPhoneNumber";
    String fOI = "";
    public int iMH;
    String iNA;
    String iNB = "";
    public boolean iNC = false;
    public View iND;
    public EditVerifyCodeView iNE;
    public TextView iNF;
    a iNG;
    public com.tencent.mm.plugin.ad.a iNH = null;
    private h iNI;
    public int iNJ = 0;
    public int iNK = 0;
    public int iNL = 0;
    com.tencent.mm.plugin.ad.a.a iNM = new com.tencent.mm.plugin.ad.a.a(this) {
        final /* synthetic */ ag iNN;

        {
            this.iNN = r1;
        }

        public final void pl(String str) {
            w.i("MicroMsg.JsApiGetPhoneNumber", "smsListener onchange");
            w.d("MicroMsg.JsApiGetPhoneNumber", "smsVerifyCode:%s", new Object[]{str});
            this.iNN.iNE.setText(str);
        }
    };
    public m iNv;
    private String iNw;
    private boolean iNx;
    String iNy;
    String iNz;
    String signature;

    class AnonymousClass11 implements OnClickListener {
        final /* synthetic */ ag iNN;
        final /* synthetic */ boolean iNU;

        AnonymousClass11(ag agVar, boolean z) {
            this.iNN = agVar;
            this.iNU = z;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            w.i("MicroMsg.JsApiGetPhoneNumber", "confirm login");
            dialogInterface.dismiss();
            if (this.iNU) {
                this.iNN.Tc();
                this.iNN.Tb();
                return;
            }
            w.i("MicroMsg.JsApiGetPhoneNumber", "not need to verify sms, and do callback");
            this.iNN.Ta();
            g.oUh.i(14249, new Object[]{this.iNN.iNv.ivH, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.iNN.iNK), Integer.valueOf(this.iNN.iNL), Integer.valueOf(this.iNN.iNJ)});
        }
    }

    class AnonymousClass7 implements com.tencent.mm.ui.MMActivity.a {
        final /* synthetic */ ag iNN;
        final /* synthetic */ MMActivity iNR;

        AnonymousClass7(ag agVar, MMActivity mMActivity) {
            this.iNN = agVar;
            this.iNR = mMActivity;
        }

        public final void a(int i, int i2, Intent intent) {
            if (i == 100) {
                this.iNN.iNK = 1;
                if (i2 == -1) {
                    this.iNN.iNL = 1;
                    w.i("MicroMsg.JsApiGetPhoneNumber", "mmOnActivityResult RESULT_OK");
                    g.oUh.i(14249, new Object[]{this.iNN.iNv.ivH, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.iNN.iNK), Integer.valueOf(this.iNN.iNL), Integer.valueOf(this.iNN.iNJ)});
                    com.tencent.mm.ui.base.g.bl(this.iNR.uSU.uTo, this.iNR.getResources().getString(R.l.dEg));
                    this.iNN.SZ();
                } else {
                    this.iNN.iNL = 0;
                    this.iNN.iNv.x(this.iNN.iMH, this.iNN.d("fail:user cancel", null));
                    w.e("MicroMsg.JsApiGetPhoneNumber", "mmOnActivityResult RESULT_CANCEL OR RESULT_FIRST_USER");
                    g.oUh.i(14249, new Object[]{this.iNN.iNv.ivH, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.iNN.iNK), Integer.valueOf(this.iNN.iNL), Integer.valueOf(this.iNN.iNJ)});
                }
                this.iNR.uSV = null;
            }
        }
    }

    class a extends CountDownTimer {
        final /* synthetic */ ag iNN;

        public a(ag agVar) {
            this.iNN = agVar;
            super(60000, 1000);
        }

        public final void onTick(long j) {
            this.iNN.iNF.setText(this.iNN.iNv.jbY.getResources().getString(R.l.dEm, new Object[]{(j / 1000)}));
        }

        public final void onFinish() {
            this.iNN.Td();
        }
    }

    class AnonymousClass4 implements com.tencent.mm.ipcinvoker.wx_extension.b.a {
        final /* synthetic */ ag iNN;
        final /* synthetic */ p iNO;

        AnonymousClass4(ag agVar, p pVar) {
            this.iNN = agVar;
            this.iNO = pVar;
        }

        public final void a(int i, int i2, String str, b bVar) {
            this.iNO.dismiss();
            if (i == 0 && i2 == 0 && bVar.hsk.hsr != null) {
                w.i("MicroMsg.JsApiGetPhoneNumber", "checkVerifyCode success");
                final lf lfVar = (lf) bVar.hsk.hsr;
                this.iNN.iNv.jbY.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 iNQ;

                    public final void run() {
                        ag agVar = this.iNQ.iNN;
                        int i = lfVar.status;
                        w.i("MicroMsg.JsApiGetPhoneNumber", "handleCheckVerifyCodeStatus:%d", new Object[]{Integer.valueOf(i)});
                        if (i == 0) {
                            g.oUh.i(14249, new Object[]{agVar.iNv.ivH, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(agVar.iNK), Integer.valueOf(agVar.iNL), Integer.valueOf(agVar.iNJ)});
                            agVar.Ta();
                        } else if (i == 1) {
                            agVar.pk(agVar.iNv.jbY.getResources().getString(R.l.dEp));
                            g.oUh.i(14249, new Object[]{agVar.iNv.ivH, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(agVar.iNK), Integer.valueOf(agVar.iNL), Integer.valueOf(agVar.iNJ)});
                        } else if (i == 3 || i == 4) {
                            com.tencent.mm.ui.base.g.a(agVar.iNv.mContext, agVar.iNv.jbY.getResources().getString(R.l.dEr), "", false, new OnClickListener(agVar) {
                                final /* synthetic */ ag iNN;

                                {
                                    this.iNN = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                    w.e("MicroMsg.JsApiGetPhoneNumber", "verify code is error, do send the right code");
                                    this.iNN.Tc();
                                }
                            });
                        } else {
                            agVar.pk(agVar.iNv.jbY.getResources().getString(R.l.dEu));
                            g.oUh.i(14249, new Object[]{agVar.iNv.ivH, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(agVar.iNK), Integer.valueOf(agVar.iNL), Integer.valueOf(agVar.iNJ)});
                        }
                    }
                });
                return;
            }
            w.e("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber checkVerifyCode cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hsk.hsr});
            this.iNN.iNv.x(this.iNN.iMH, this.iNN.d("fail:checkVerifyCode cgi fail", null));
            g.oUh.i(14249, new Object[]{this.iNN.iNv.ivH, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(this.iNN.iNK), Integer.valueOf(this.iNN.iNL), Integer.valueOf(this.iNN.iNJ)});
        }
    }

    public final void a(final m mVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            w.e("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber data is null");
            mVar.x(i, d("fail:data is null", null));
            return;
        }
        this.iNv = mVar;
        this.iMH = i;
        w.i("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber data:%s", new Object[]{jSONObject.toString()});
        Object optString = jSONObject.optString("api_name", "webapi_getuserwxphone");
        boolean optBoolean = jSONObject.optBoolean("with_credentials", true);
        if (TextUtils.isEmpty(optString)) {
            w.e("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber api_name is null");
            mVar.x(i, d("fail:api_name is null", null));
            return;
        }
        e.a(mVar.ivH, new e.b(this) {
            final /* synthetic */ ag iNN;

            public final void onDestroy() {
                w.i("MicroMsg.JsApiGetPhoneNumber", "AppBrandLifeCycle onDestroy");
                e.b(mVar.ivH, this);
                this.iNN.Te();
            }
        });
        this.iNw = optString;
        this.iNx = optBoolean;
        SZ();
    }

    public final void SZ() {
        w.i("MicroMsg.JsApiGetPhoneNumber", "requestBindPhoneNumber");
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.object();
            jSONStringer.key("api_name");
            jSONStringer.value(this.iNw);
            jSONStringer.key("with_credentials");
            jSONStringer.value(this.iNx);
            jSONStringer.endObject();
        } catch (JSONException e) {
            w.e("MicroMsg.JsApiGetPhoneNumber", "JSONException:%s", new Object[]{e.getMessage()});
        }
        w.i("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber appId:%s, api_name:%s, with_credentials:%b", new Object[]{this.iNv.ivH, this.iNw, Boolean.valueOf(this.iNx)});
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new ahh();
        aVar.hsn = new ahi();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-getuserwxphone";
        aVar.hsl = 1141;
        aVar.hso = 0;
        aVar.hsp = 0;
        b BE = aVar.BE();
        ahh com_tencent_mm_protocal_c_ahh = (ahh) BE.hsj.hsr;
        com_tencent_mm_protocal_c_ahh.mtb = this.iNv.ivH;
        com_tencent_mm_protocal_c_ahh.jMQ = new com.tencent.mm.bd.b(jSONStringer.toString().getBytes());
        com.tencent.mm.ipcinvoker.wx_extension.b.a(BE, new com.tencent.mm.ipcinvoker.wx_extension.b.a(this) {
            final /* synthetic */ ag iNN;

            {
                this.iNN = r1;
            }

            public final void a(int i, int i2, String str, b bVar) {
                if (i == 0 && i2 == 0 && bVar.hsk.hsr != null) {
                    w.i("MicroMsg.JsApiGetPhoneNumber", "JsOperateWxData success");
                    final ahi com_tencent_mm_protocal_c_ahi = (ahi) bVar.hsk.hsr;
                    this.iNN.iNv.jbY.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass10 iNT;

                        public final void run() {
                            d dVar = this.iNT.iNN;
                            ahi com_tencent_mm_protocal_c_ahi = com_tencent_mm_protocal_c_ahi;
                            w.i("MicroMsg.JsApiGetPhoneNumber", "handleOperateWxData");
                            Object obj = "";
                            if (com_tencent_mm_protocal_c_ahi.jMQ != null) {
                                obj = com_tencent_mm_protocal_c_ahi.jMQ.bGX();
                            }
                            w.i("MicroMsg.JsApiGetPhoneNumber", "resp data:%s", new Object[]{obj});
                            if (TextUtils.isEmpty(obj)) {
                                w.e("MicroMsg.JsApiGetPhoneNumber", "resp data is empty");
                                dVar.iNv.x(dVar.iMH, dVar.d("fail:resp data is empty", null));
                                return;
                            }
                            JSONObject jSONObject;
                            Object obj2 = com_tencent_mm_protocal_c_ahi.tee;
                            CharSequence charSequence = com_tencent_mm_protocal_c_ahi.muS;
                            String str = "";
                            if (com_tencent_mm_protocal_c_ahi.tLS != null) {
                                str = com_tencent_mm_protocal_c_ahi.tLS.msk;
                                dVar.iNB = com_tencent_mm_protocal_c_ahi.tLS.iNB;
                            }
                            w.i("MicroMsg.JsApiGetPhoneNumber", "appName:%s, desc:%s, IconUrl:%s, ext_desc:%s", new Object[]{charSequence, str, obj2, dVar.iNB});
                            try {
                                jSONObject = new JSONObject(obj);
                            } catch (JSONException e) {
                                w.e("MicroMsg.JsApiGetPhoneNumber", "new data json exception:%s", new Object[]{e.getMessage()});
                                jSONObject = null;
                            }
                            if (jSONObject == null) {
                                w.e("MicroMsg.JsApiGetPhoneNumber", "jsonObj is null");
                                dVar.iNv.x(dVar.iMH, dVar.d("fail:jsonObj is null", null));
                                return;
                            }
                            boolean z;
                            dVar.iNy = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA);
                            JSONObject optJSONObject = jSONObject.optJSONObject(SlookAirButtonFrequentContactAdapter.DATA);
                            if (optJSONObject == null && !TextUtils.isEmpty(dVar.iNy)) {
                                try {
                                    optJSONObject = new JSONObject(dVar.iNy);
                                } catch (JSONException e2) {
                                    w.e("MicroMsg.JsApiGetPhoneNumber", "new dataJson exist exception, e:%s", new Object[]{e2.getMessage()});
                                }
                            }
                            if (optJSONObject != null) {
                                dVar.fOI = optJSONObject.optString("mobile");
                                boolean optBoolean = optJSONObject.optBoolean("need_auth", false);
                                dVar.iNC = optJSONObject.optBoolean("allow_send_sms", false);
                                z = optBoolean;
                            } else {
                                z = false;
                            }
                            dVar.signature = jSONObject.optString("signature");
                            dVar.iNz = jSONObject.optString("encryptedData");
                            dVar.iNA = jSONObject.optString("iv");
                            w.i("MicroMsg.JsApiGetPhoneNumber", "mobile:%s, need_auth:%b, allow_send_sms:%b", new Object[]{dVar.fOI, Boolean.valueOf(z), Boolean.valueOf(dVar.iNC)});
                            if (dVar.iNJ == 0) {
                                if (TextUtils.isEmpty(dVar.fOI)) {
                                    dVar.iNJ = 3;
                                } else if (z) {
                                    dVar.iNJ = 2;
                                } else {
                                    dVar.iNJ = 1;
                                }
                            }
                            if (TextUtils.isEmpty(dVar.fOI)) {
                                w.i("MicroMsg.JsApiGetPhoneNumber", "show the confirm bind phone dialog");
                                com.tencent.mm.ui.base.g.a(dVar.iNv.mContext, dVar.iNv.jbY.getResources().getString(R.l.dEj), dVar.iNv.jbY.getResources().getString(R.l.dEk), dVar.iNv.jbY.getResources().getString(R.l.dEq), dVar.iNv.jbY.getResources().getString(R.l.dGs), false, new OnClickListener(dVar) {
                                    final /* synthetic */ ag iNN;

                                    {
                                        this.iNN = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        w.i("MicroMsg.JsApiGetPhoneNumber", "confirm bind phone number");
                                        dialogInterface.dismiss();
                                        ag agVar = this.iNN;
                                        w.i("MicroMsg.JsApiGetPhoneNumber", "doBindPhoneNumber()");
                                        Intent intent = new Intent(agVar.iNv.mContext, AppBrandRedirectUI.class);
                                        intent.putExtra("key_from_scene", 0);
                                        MMActivity mMActivity = (MMActivity) agVar.iNv.mContext;
                                        mMActivity.uSV = new AnonymousClass7(agVar, mMActivity);
                                        mMActivity.startActivityForResult(intent, 100);
                                    }
                                }, new OnClickListener(dVar) {
                                    final /* synthetic */ ag iNN;

                                    {
                                        this.iNN = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        w.i("MicroMsg.JsApiGetPhoneNumber", "cancel to bind phone number");
                                        dialogInterface.dismiss();
                                        this.iNN.iNv.x(this.iNN.iMH, this.iNN.d("fail:cancel to bind phone", null));
                                        g.oUh.i(14249, new Object[]{this.iNN.iNv.ivH, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.iNN.iNK), Integer.valueOf(this.iNN.iNL), Integer.valueOf(this.iNN.iNJ)});
                                    }
                                });
                                return;
                            }
                            w.i("MicroMsg.JsApiGetPhoneNumber", "show the confirm login dialog");
                            View inflate = ((LayoutInflater) dVar.iNv.mContext.getSystemService("layout_inflater")).inflate(R.i.cTZ, null);
                            ImageView imageView = (ImageView) inflate.findViewById(R.h.boY);
                            TextView textView = (TextView) inflate.findViewById(R.h.boW);
                            TextView textView2 = (TextView) inflate.findViewById(R.h.boX);
                            TextView textView3 = (TextView) inflate.findViewById(R.h.boZ);
                            if (TextUtils.isEmpty(charSequence)) {
                                textView.setVisibility(8);
                            } else {
                                textView.setText(charSequence);
                                textView.setVisibility(0);
                            }
                            textView2.setText(r6);
                            if (TextUtils.isEmpty(dVar.iNB)) {
                                textView3.setVisibility(8);
                            } else {
                                textView3.setText(dVar.iNB);
                                textView3.setVisibility(0);
                            }
                            if (TextUtils.isEmpty(obj2)) {
                                imageView.setImageDrawable(com.tencent.mm.modelappbrand.a.a.AX());
                            } else {
                                com.tencent.mm.modelappbrand.a.b.AY().a(imageView, obj2, com.tencent.mm.modelappbrand.a.a.AX(), com.tencent.mm.modelappbrand.a.e.hqF);
                            }
                            com.tencent.mm.ui.base.g.a(dVar.iNv.mContext, false, dVar.iNv.jbY.getResources().getString(R.l.dEi), inflate, dVar.iNv.jbY.getResources().getString(R.l.dEh), dVar.iNv.jbY.getResources().getString(R.l.dGs), new AnonymousClass11(dVar, z), new OnClickListener(dVar) {
                                final /* synthetic */ ag iNN;

                                {
                                    this.iNN = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    w.i("MicroMsg.JsApiGetPhoneNumber", "cancel to confirm login");
                                    dialogInterface.dismiss();
                                    this.iNN.iNv.x(this.iNN.iMH, this.iNN.d("fail:cancel to confirm login", null));
                                    g.oUh.i(14249, new Object[]{this.iNN.iNv.ivH, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.iNN.iNK), Integer.valueOf(this.iNN.iNL), Integer.valueOf(this.iNN.iNJ)});
                                }
                            });
                        }
                    });
                    return;
                }
                w.e("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber JsOperateWxData cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hsk.hsr});
                this.iNN.iNv.x(this.iNN.iMH, this.iNN.d("fail:JsOperateWxData cgi fail", null));
            }
        });
    }

    public final void Ta() {
        w.i("MicroMsg.JsApiGetPhoneNumber", "doSuccCallback");
        Map hashMap = new HashMap(5);
        hashMap.put("encryptedData", this.iNz);
        hashMap.put("iv", this.iNA);
        this.iNv.x(this.iMH, d("ok", hashMap));
    }

    public final void Tb() {
        w.i("MicroMsg.JsApiGetPhoneNumber", "doSendVerifyCode");
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new aye();
        aVar.hsn = new ayf();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/sendverifycode";
        aVar.hsl = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        aVar.hso = 0;
        aVar.hsp = 0;
        b BE = aVar.BE();
        aye com_tencent_mm_protocal_c_aye = (aye) BE.hsj.hsr;
        com_tencent_mm_protocal_c_aye.fTO = this.iNv.ivH;
        com_tencent_mm_protocal_c_aye.fOI = this.fOI;
        final p a = com.tencent.mm.ui.base.g.a(this.iNv.mContext, "", false, null);
        com.tencent.mm.ipcinvoker.wx_extension.b.a(BE, new com.tencent.mm.ipcinvoker.wx_extension.b.a(this) {
            final /* synthetic */ ag iNN;

            public final void a(int i, int i2, String str, b bVar) {
                a.dismiss();
                if (i == 0 && i2 == 0 && bVar.hsk.hsr != null) {
                    final ayf com_tencent_mm_protocal_c_ayf = (ayf) bVar.hsk.hsr;
                    w.i("MicroMsg.JsApiGetPhoneNumber", "SendVerifyCode cgi success");
                    this.iNN.iNv.jbY.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass15 iNW;

                        public final void run() {
                            ag agVar = this.iNW.iNN;
                            int i = com_tencent_mm_protocal_c_ayf.status;
                            w.i("MicroMsg.JsApiGetPhoneNumber", "handleSendVerifyCodeStatus:%d", new Object[]{Integer.valueOf(i)});
                            if (i == 0) {
                                w.i("MicroMsg.JsApiGetPhoneNumber", "startSmsListener");
                                if (agVar.iNG != null) {
                                    agVar.iNG.cancel();
                                } else {
                                    agVar.iNG = new a(agVar);
                                }
                                agVar.iNG.start();
                                if (agVar.iNH == null) {
                                    agVar.iNH = new com.tencent.mm.plugin.ad.a(agVar.iNv.mContext);
                                }
                                agVar.iNH.pyE = agVar.iNv.jbY.getResources().getStringArray(R.c.aSu);
                                agVar.iNH.pyC = agVar.iNM;
                                com.tencent.mm.plugin.appbrand.b.a(agVar.iNv.ivH, new android.support.v4.app.a.a(agVar) {
                                    final /* synthetic */ ag iNN;

                                    {
                                        this.iNN = r1;
                                    }

                                    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                                        if (i != FileUtils.S_IWUSR) {
                                            w.e("MicroMsg.JsApiGetPhoneNumber", "requestSMSPermission requestCode is not for sms");
                                        } else if (iArr == null || iArr.length <= 0) {
                                            String str = "MicroMsg.JsApiGetPhoneNumber";
                                            String str2 = "requestSMSPermission, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
                                            Object[] objArr = new Object[4];
                                            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
                                            objArr[1] = Integer.valueOf(i);
                                            objArr[2] = strArr;
                                            objArr[3] = bg.bJZ();
                                            w.w(str, str2, objArr);
                                        } else if (iArr[0] == 0) {
                                            w.i("MicroMsg.JsApiGetPhoneNumber", "requestSMSPermission permission is grant for sms");
                                            if (this.iNN.iNH != null) {
                                                this.iNN.iNH.start();
                                            }
                                        } else {
                                            w.e("MicroMsg.JsApiGetPhoneNumber", "requestSMSPermission sys perm denied for sms");
                                        }
                                    }
                                });
                                boolean a = com.tencent.mm.pluginsdk.i.a.a((Activity) agVar.iNv.mContext, "android.permission.READ_SMS", FileUtils.S_IWUSR, "", "");
                                if (a) {
                                    com.tencent.mm.plugin.appbrand.b.mX(agVar.iNv.ivH);
                                }
                                if (a) {
                                    w.i("MicroMsg.JsApiGetPhoneNumber", "request sms permission success");
                                } else {
                                    w.e("MicroMsg.JsApiGetPhoneNumber", "request sms permission fail");
                                }
                                agVar.iNH.start();
                            } else if (i == 1 || i != 2) {
                                agVar.pk(agVar.iNv.jbY.getResources().getString(R.l.dEo));
                                g.oUh.i(14249, new Object[]{agVar.iNv.ivH, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(agVar.iNK), Integer.valueOf(agVar.iNL), Integer.valueOf(agVar.iNJ)});
                            } else {
                                agVar.pk(agVar.iNv.jbY.getResources().getString(R.l.dEp));
                                g.oUh.i(14249, new Object[]{agVar.iNv.ivH, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(agVar.iNK), Integer.valueOf(agVar.iNL), Integer.valueOf(agVar.iNJ)});
                            }
                        }
                    });
                    return;
                }
                w.e("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber SendVerifyCode cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hsk.hsr});
                this.iNN.iNv.x(this.iNN.iMH, this.iNN.d("fail:SendVerifyCode cgi fail", null));
                g.oUh.i(14249, new Object[]{this.iNN.iNv.ivH, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(this.iNN.iNK), Integer.valueOf(this.iNN.iNL), Integer.valueOf(this.iNN.iNJ)});
            }
        });
    }

    public final void Tc() {
        w.i("MicroMsg.JsApiGetPhoneNumber", "showVerifyMobileDialog");
        LayoutInflater layoutInflater = (LayoutInflater) this.iNv.mContext.getSystemService("layout_inflater");
        if (this.iND == null) {
            this.iND = layoutInflater.inflate(R.i.cUy, null);
            this.iNE = (EditVerifyCodeView) this.iND.findViewById(R.h.bpv);
            this.iNF = (TextView) this.iND.findViewById(R.h.bpt);
        }
        if (this.iND.getParent() != null) {
            ((ViewGroup) this.iND.getParent()).removeAllViews();
        }
        TextView textView = (TextView) this.iND.findViewById(R.h.bpw);
        if (this.iNB == null) {
            this.iNB = "";
        }
        textView.setText(this.iNv.jbY.getResources().getString(R.l.dEv, new Object[]{this.iNB}));
        this.iNE.setText("");
        Td();
        OnClickListener anonymousClass16 = new OnClickListener(this) {
            final /* synthetic */ ag iNN;

            {
                this.iNN = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                w.i("MicroMsg.JsApiGetPhoneNumber", "to verify sms");
                if (!TextUtils.isEmpty(this.iNN.iNE.mBuilder.toString()) && this.iNN.iNE.mBuilder.toString().length() == 6) {
                    w.e("MicroMsg.JsApiGetPhoneNumber", "code is length is 6");
                    dialogInterface.dismiss();
                    this.iNN.Te();
                    this.iNN.iND.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass16 iNX;

                        {
                            this.iNX = r1;
                        }

                        public final void run() {
                            ((MMActivity) this.iNX.iNN.iNv.mContext).aHf();
                        }
                    });
                    ag agVar = this.iNN;
                    String str = this.iNN.iNE.mBuilder.toString().toString();
                    w.i("MicroMsg.JsApiGetPhoneNumber", "doVerifyCode");
                    com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
                    aVar.hsm = new le();
                    aVar.hsn = new lf();
                    aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkverifycode";
                    aVar.hsl = 1010;
                    aVar.hso = 0;
                    aVar.hsp = 0;
                    b BE = aVar.BE();
                    le leVar = (le) BE.hsj.hsr;
                    leVar.fTO = agVar.iNv.ivH;
                    leVar.fOI = agVar.fOI;
                    leVar.rHy = str;
                    com.tencent.mm.ipcinvoker.wx_extension.b.a(BE, new AnonymousClass4(agVar, com.tencent.mm.ui.base.g.a(agVar.iNv.mContext, "", false, null)));
                } else if (TextUtils.isEmpty(this.iNN.iNE.mBuilder.toString()) || this.iNN.iNE.mBuilder.toString().length() >= 6) {
                    w.e("MicroMsg.JsApiGetPhoneNumber", "code is empty");
                    com.tencent.mm.ui.base.g.bl(this.iNN.iNv.mContext, this.iNN.iNv.jbY.getResources().getString(R.l.dEs));
                } else {
                    com.tencent.mm.ui.base.g.bl(this.iNN.iNv.mContext, this.iNN.iNv.jbY.getResources().getString(R.l.dEt));
                    w.e("MicroMsg.JsApiGetPhoneNumber", "code is length is < 6");
                }
            }
        };
        this.iNI = com.tencent.mm.ui.base.g.a(this.iNv.mContext, false, this.iNv.jbY.getResources().getString(R.l.dEw), this.iND, this.iNv.jbY.getResources().getString(R.l.dHT), this.iNv.jbY.getResources().getString(R.l.dGs), anonymousClass16, new OnClickListener(this) {
            final /* synthetic */ ag iNN;

            {
                this.iNN = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                w.i("MicroMsg.JsApiGetPhoneNumber", "cancel to verify sms");
                dialogInterface.dismiss();
                this.iNN.iNv.x(this.iNN.iMH, this.iNN.d("fail:cancel to verify sms", null));
                this.iNN.Te();
                this.iNN.iND.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass17 iNY;

                    {
                        this.iNY = r1;
                    }

                    public final void run() {
                        ((MMActivity) this.iNY.iNN.iNv.mContext).aHf();
                    }
                });
                g.oUh.i(14249, new Object[]{this.iNN.iNv.ivH, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(this.iNN.iNK), Integer.valueOf(this.iNN.iNL), Integer.valueOf(this.iNN.iNJ)});
            }
        });
        this.iNI.a(this.iNv.jbY.getResources().getString(R.l.dHT), false, anonymousClass16);
        this.iND.post(new Runnable(this) {
            final /* synthetic */ ag iNN;

            {
                this.iNN = r1;
            }

            public final void run() {
                ((MMActivity) this.iNN.iNv.mContext).aHj();
            }
        });
    }

    public final void Td() {
        w.i("MicroMsg.JsApiGetPhoneNumber", "updateSendText()");
        Object string = this.iNv.jbY.getResources().getString(R.l.dEl);
        Object string2 = this.iNv.jbY.getResources().getString(R.l.dEn);
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(string);
        spannableStringBuilder.append(string2);
        int length = string.length();
        int length2 = string2.length();
        spannableStringBuilder.setSpan(new ClickableSpan(this) {
            final /* synthetic */ ag iNN;

            {
                this.iNN = r1;
            }

            public final void onClick(View view) {
                w.i("MicroMsg.JsApiGetPhoneNumber", "click the resend spanBuilder, do resend sms");
                if (this.iNN.iNC) {
                    this.iNN.Tb();
                    return;
                }
                w.e("MicroMsg.JsApiGetPhoneNumber", "allow_send_sms is false, show send_verify_code_frequent error");
                this.iNN.pk(this.iNN.iNv.jbY.getResources().getString(R.l.dEp));
            }
        }, length, length + length2, 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.iNv.mContext.getResources().getColor(R.e.aUA)), length, length2 + length, 17);
        this.iNF.setText(spannableStringBuilder);
        this.iNF.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void pk(String str) {
        Te();
        com.tencent.mm.ui.base.g.a(this.iNv.mContext, str, "", false, new OnClickListener(this) {
            final /* synthetic */ ag iNN;

            {
                this.iNN = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.iNN.iNv.x(this.iNN.iMH, this.iNN.d("fail", null));
            }
        });
    }

    public final void Te() {
        w.i("MicroMsg.JsApiGetPhoneNumber", "stopSmsListener");
        if (this.iNG != null) {
            this.iNG.cancel();
        }
        if (this.iNH != null) {
            this.iNH.stop();
            this.iNH.pyC = null;
        }
    }
}
