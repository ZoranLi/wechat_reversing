package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.protocal.c.aha;
import com.tencent.mm.protocal.c.ahc;
import com.tencent.mm.protocal.c.awh;
import com.tencent.mm.r.a.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiAuthorize extends b {
    private static final int CTRL_INDEX = 54;
    private static final String NAME = "authorize";

    private static class AuthorizeTask extends MainProcessTask {
        public static final Creator<AuthorizeTask> CREATOR = new Creator<AuthorizeTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new AuthorizeTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AuthorizeTask[i];
            }
        };
        public String appId;
        public String data;
        m iMG;
        public int iMH;
        public int iPk;
        public int iPl;
        b iQI;
        a iQJ;
        public Bundle iQK;
        public String iQL;
        public String iQM;
        public int iQN;
        public String iQO;
        public String iQP;
        public int iQQ;
        public Bundle iQR;

        public interface a {
            void Tr();

            void a(LinkedList<awh> linkedList, String str, String str2);

            void onSuccess();
        }

        public AuthorizeTask(Parcel parcel) {
            f(parcel);
        }

        public final void PM() {
            final a anonymousClass1 = new a(this) {
                final /* synthetic */ AuthorizeTask iQS;

                {
                    this.iQS = r1;
                }

                public final void onSuccess() {
                    w.d("MicroMsg.JsApiAuthorize", "onSuccess !");
                    this.iQS.iQM = "ok";
                    this.iQS.SL();
                }

                public final void Tr() {
                    w.e("MicroMsg.JsApiAuthorize", "onFailure !");
                    this.iQS.iQM = "fail";
                    this.iQS.SL();
                }

                public final void a(LinkedList<awh> linkedList, String str, String str2) {
                    w.d("MicroMsg.JsApiAuthorize", "onConfirm !");
                    this.iQS.iQQ = linkedList.size();
                    int i = 0;
                    while (i < this.iQS.iQQ) {
                        try {
                            this.iQS.iQR.putByteArray(String.valueOf(i), ((awh) linkedList.get(i)).toByteArray());
                            i++;
                        } catch (Throwable e) {
                            w.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[]{e.getMessage()});
                            w.printErrStackTrace("MicroMsg.JsApiAuthorize", e, "", new Object[0]);
                            this.iQS.iQM = "fail";
                            this.iQS.SL();
                            return;
                        }
                    }
                    this.iQS.iQO = str;
                    this.iQS.iQP = str2;
                    this.iQS.iQM = "needConfirm";
                    this.iQS.SL();
                }
            };
            if (this.iQL.equals("authorize")) {
                try {
                    JSONArray jSONArray = new JSONArray(new JSONObject(this.data).optString("scope"));
                    LinkedList linkedList = new LinkedList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        linkedList.add(jSONArray.optString(i));
                    }
                    ap.vd().a(new com.tencent.mm.r.a.a(this.appId, linkedList, this.iPk, this.iPl, new com.tencent.mm.r.a.a.a<com.tencent.mm.r.a.a>(this) {
                        final /* synthetic */ AuthorizeTask iQS;

                        public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
                            com.tencent.mm.r.a.a aVar = (com.tencent.mm.r.a.a) kVar;
                            w.d("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                            if (i != 0 || i2 != 0) {
                                anonymousClass1.Tr();
                            } else if (aVar instanceof com.tencent.mm.r.a.a) {
                                ahc uD = aVar.uD();
                                int i3 = uD.tLL.fIz;
                                String str2 = uD.tLL.fIA;
                                w.i("MicroMsg.JsApiAuthorize", "stev NetSceneJSAuthorize jsErrcode %d", new Object[]{Integer.valueOf(i3)});
                                if (i3 == -12000) {
                                    anonymousClass1.a(uD.tBL, uD.muS, uD.tee);
                                } else if (i3 == 0) {
                                    anonymousClass1.onSuccess();
                                } else {
                                    w.e("MicroMsg.JsApiAuthorize", "onSceneEnd NetSceneJSAuthorize ERROR %s", new Object[]{str2});
                                    anonymousClass1.Tr();
                                }
                            }
                        }
                    }), 0);
                } catch (Exception e) {
                    w.e("MicroMsg.JsApiAuthorize", "Exception %s", new Object[]{e.getMessage()});
                    this.iQM = "fail";
                    SL();
                }
            } else if (this.iQL.equals("authorizeConfirm")) {
                a(this.appId, this.iQK, this.iPk, this.iQN, anonymousClass1);
            }
        }

        public final void SK() {
            SN();
            if (!this.iMG.aaI) {
                return;
            }
            if (this.iQM.equals("ok")) {
                this.iQI.a(this.iMG, this.iMH, "ok");
                this.iQJ.Tn();
            } else if (this.iQM.equals("fail")) {
                this.iQI.a(this.iMG, this.iMH, "fail");
                this.iQJ.Tn();
            } else if (this.iQM.equals("needConfirm")) {
                final LinkedList linkedList = new LinkedList();
                int i = 0;
                while (i < this.iQQ) {
                    byte[] byteArray = this.iQR.getByteArray(String.valueOf(i));
                    awh com_tencent_mm_protocal_c_awh = new awh();
                    try {
                        com_tencent_mm_protocal_c_awh.aD(byteArray);
                        linkedList.add(com_tencent_mm_protocal_c_awh);
                        i++;
                    } catch (Throwable e) {
                        w.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[]{e.getMessage()});
                        w.printErrStackTrace("MicroMsg.JsApiAuthorize", e, "", new Object[0]);
                        this.iQI.a(this.iMG, this.iMH, "fail");
                        this.iQJ.Tn();
                        return;
                    }
                }
                if (linkedList.size() > 0) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ AuthorizeTask iQS;

                        public final void run() {
                            this.iQS.iMG.ixr.a(new c(this.iQS.iQI.a(this.iQS.iMG), linkedList, this.iQS.iQO, this.iQS.iQP, new com.tencent.mm.plugin.appbrand.widget.c.a(this) {
                                final /* synthetic */ AnonymousClass2 iQU;

                                {
                                    this.iQU = r1;
                                }

                                public final void c(int i, Bundle bundle) {
                                    w.i("MicroMsg.JsApiAuthorize", "stev onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
                                    switch (i) {
                                        case 1:
                                        case 2:
                                            this.iQU.iQS.iQL = "authorizeConfirm";
                                            this.iQU.iQS.iQK = bundle;
                                            this.iQU.iQS.iQN = i;
                                            AppBrandMainProcessService.a(this.iQU.iQS);
                                            if (i == 2) {
                                                this.iQU.iQS.iQI.a(this.iQU.iQS.iMG, this.iQU.iQS.iMH, "fail auth deny");
                                                this.iQU.iQS.iQJ.Tn();
                                                return;
                                            }
                                            return;
                                        default:
                                            w.d("MicroMsg.JsApiAuthorize", "press back button!");
                                            this.iQU.iQS.iQI.a(this.iQU.iQS.iMG, this.iQU.iQS.iMH, "fail auth cancel");
                                            this.iQU.iQS.iQJ.Tn();
                                            return;
                                    }
                                }
                            }));
                        }
                    });
                    return;
                }
                this.iQI.a(this.iMG, this.iMH, "fail");
                this.iQJ.Tn();
            }
        }

        public final void f(Parcel parcel) {
            this.data = parcel.readString();
            this.iMH = parcel.readInt();
            this.appId = parcel.readString();
            this.iQM = parcel.readString();
            this.iQL = parcel.readString();
            this.iQO = parcel.readString();
            this.iQP = parcel.readString();
            this.iQQ = parcel.readInt();
            this.iQR = parcel.readBundle(JsApiAuthorize.class.getClassLoader());
            this.iQK = parcel.readBundle(JsApiAuthorize.class.getClassLoader());
            this.iPk = parcel.readInt();
            this.iQN = parcel.readInt();
            this.iPl = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.data);
            parcel.writeInt(this.iMH);
            parcel.writeString(this.appId);
            parcel.writeString(this.iQM);
            parcel.writeString(this.iQL);
            parcel.writeString(this.iQO);
            parcel.writeString(this.iQP);
            parcel.writeInt(this.iQQ);
            parcel.writeBundle(this.iQR);
            parcel.writeBundle(this.iQK);
            parcel.writeInt(this.iPk);
            parcel.writeInt(this.iQN);
            parcel.writeInt(this.iPl);
        }

        private void a(String str, Bundle bundle, int i, final int i2, final a aVar) {
            ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
            LinkedList linkedList = new LinkedList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                linkedList.add((String) it.next());
            }
            ap.vd().a(new b(str, linkedList, i, i2, this.iPl, new com.tencent.mm.r.a.b.a<b>(this) {
                final /* synthetic */ AuthorizeTask iQS;

                public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
                    b bVar = (b) kVar;
                    w.d("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    if (i != 0 || i2 != 0) {
                        aVar.Tr();
                    } else if (!(bVar instanceof b)) {
                    } else {
                        if (i2 == 2) {
                            w.d("MicroMsg.JsApiAuthorize", "press reject button");
                            return;
                        }
                        aha uE = bVar.uE();
                        int i3 = uE.tLL.fIz;
                        String str2 = uE.tLL.fIA;
                        w.i("MicroMsg.JsApiAuthorize", "stev NetSceneJSAuthorizeConfirm jsErrcode %d", new Object[]{Integer.valueOf(i3)});
                        if (i3 == 0) {
                            aVar.onSuccess();
                            return;
                        }
                        w.e("MicroMsg.JsApiAuthorize", "onSceneEnd NetSceneJSAuthorizeConfirm ERROR %s", new Object[]{str2});
                        aVar.Tr();
                    }
                }
            }), 0);
        }
    }

    public final /* bridge */ /* synthetic */ void a(m mVar, JSONObject jSONObject, int i) {
        super.a(mVar, jSONObject, i);
    }

    public final void a(m mVar, JSONObject jSONObject, int i, a aVar) {
        w.d("MicroMsg.JsApiAuthorize", "stev JsApiAuthorize!");
        MainProcessTask authorizeTask = new AuthorizeTask();
        authorizeTask.appId = mVar.ivH;
        authorizeTask.iQL = "authorize";
        AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(mVar.ivH);
        if (mY != null) {
            authorizeTask.iPk = mY.iFk.izV;
        }
        AppBrandStatObject mZ = com.tencent.mm.plugin.appbrand.b.mZ(mVar.ivH);
        if (mZ != null) {
            authorizeTask.iPl = mZ.scene;
        }
        String jSONObject2 = jSONObject.toString();
        authorizeTask.iQI = this;
        authorizeTask.iMG = mVar;
        authorizeTask.data = jSONObject2;
        authorizeTask.iMH = i;
        authorizeTask.iQJ = aVar;
        authorizeTask.iQR = new Bundle();
        authorizeTask.SM();
        AppBrandMainProcessService.a(authorizeTask);
    }
}
