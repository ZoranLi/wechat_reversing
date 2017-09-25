package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.c.ahe;
import com.tencent.mm.protocal.c.ahg;
import com.tencent.mm.protocal.c.awh;
import com.tencent.mm.r.a.c;
import com.tencent.mm.r.a.d;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiLogin extends b {
    public static final int CTRL_INDEX = 52;
    public static final String NAME = "login";

    private static class LoginTask extends MainProcessTask {
        public static final Creator<LoginTask> CREATOR = new Creator<LoginTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LoginTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LoginTask[i];
            }
        };
        public String appId;
        public String code;
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
        public int iQX;
        public String iQY;

        interface a {
            void Tr();

            void a(LinkedList<awh> linkedList, String str, String str2, String str3);

            void pp(String str);
        }

        public LoginTask(Parcel parcel) {
            f(parcel);
        }

        public final void PM() {
            final a anonymousClass1 = new a(this) {
                final /* synthetic */ LoginTask iQZ;

                {
                    this.iQZ = r1;
                }

                public final void pp(String str) {
                    w.i("MicroMsg.JsApiLogin", "onSuccess !");
                    this.iQZ.code = str;
                    this.iQZ.iQM = "ok";
                    this.iQZ.SL();
                }

                public final void Tr() {
                    w.i("MicroMsg.JsApiLogin", "onFailure !");
                    this.iQZ.iQM = "fail";
                    this.iQZ.SL();
                }

                public final void a(LinkedList<awh> linkedList, String str, String str2, String str3) {
                    w.i("MicroMsg.JsApiLogin", "onConfirm !");
                    this.iQZ.iQQ = linkedList.size();
                    int i = 0;
                    while (i < this.iQZ.iQQ) {
                        try {
                            this.iQZ.iQR.putByteArray(String.valueOf(i), ((awh) linkedList.get(i)).toByteArray());
                            i++;
                        } catch (Throwable e) {
                            w.e("MicroMsg.JsApiLogin", "IOException %s", new Object[]{e.getMessage()});
                            w.printErrStackTrace("MicroMsg.JsApiLogin", e, "", new Object[0]);
                            this.iQZ.iQM = "fail";
                            this.iQZ.SL();
                            return;
                        }
                    }
                    this.iQZ.iQY = str3;
                    this.iQZ.iQO = str;
                    this.iQZ.iQP = str2;
                    this.iQZ.iQM = "needConfirm";
                    this.iQZ.SL();
                }
            };
            if (this.iQL.equals("login")) {
                w.i("MicroMsg.JsApiLogin", "start login");
                LinkedList linkedList = new LinkedList();
                this.iQX = 1;
                this.iQY = "";
                h.vH().gXC.a(new c(this.appId, linkedList, this.iQX, "", this.iQY, this.iPk, this.iPl, new com.tencent.mm.r.a.c.a<c>(this) {
                    final /* synthetic */ LoginTask iQZ;

                    public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
                        c cVar = (c) kVar;
                        w.i("MicroMsg.JsApiLogin", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                        if (i == 0 && i2 == 0 && cVar != null) {
                            ahg uF = cVar.uF();
                            int i3 = uF.tLL.fIz;
                            String str2 = uF.tLL.fIA;
                            String str3 = uF.tLN;
                            w.i("MicroMsg.JsApiLogin", "stev NetSceneJSLogin jsErrcode %d", new Object[]{Integer.valueOf(i3)});
                            if (i3 == -12000) {
                                LinkedList linkedList = uF.tBL;
                                w.i("MicroMsg.JsApiLogin", "stev appName %s, appIconUrl %s", new Object[]{uF.muS, uF.tee});
                                anonymousClass1.a(linkedList, str2, r0, str3);
                                return;
                            } else if (i3 == 0) {
                                anonymousClass1.pp(uF.tLO);
                                w.i("MicroMsg.JsApiLogin", "resp data code [%s]", new Object[]{r0});
                                return;
                            } else if (i3 == -12001) {
                                anonymousClass1.Tr();
                                w.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin Invalid Scope %s", new Object[]{str2});
                                return;
                            } else if (i3 == -12002) {
                                anonymousClass1.Tr();
                                w.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin Invalid Data %s", new Object[]{str2});
                                return;
                            } else if (i3 == -12003) {
                                anonymousClass1.Tr();
                                w.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin Invalid ApiName %s", new Object[]{str2});
                                return;
                            } else {
                                anonymousClass1.Tr();
                                w.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin %s", new Object[]{str2});
                                return;
                            }
                        }
                        anonymousClass1.Tr();
                    }
                }), 0);
            } else if (this.iQL.equals("loginConfirm")) {
                w.i("MicroMsg.JsApiLogin", "start loginConfirm");
                a(this.appId, this.iQK, this.iQX, this.iQY, this.iPk, this.iQN, anonymousClass1);
            }
        }

        public final void SK() {
            SN();
            if (!this.iMG.aaI) {
                return;
            }
            if (this.iQM.equals("ok")) {
                Map hashMap = new HashMap();
                hashMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, this.code);
                this.iMG.x(this.iMH, this.iQI.d("ok", hashMap));
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
                        w.e("MicroMsg.JsApiLogin", "parse scope info error %s", new Object[]{e.getMessage()});
                        w.printErrStackTrace("MicroMsg.JsApiLogin", e, "", new Object[0]);
                        this.iQI.a(this.iMG, this.iMH, "fail");
                        this.iQJ.Tn();
                        return;
                    }
                }
                if (linkedList.size() > 0) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ LoginTask iQZ;

                        public final void run() {
                            this.iQZ.iMG.ixr.a(new com.tencent.mm.plugin.appbrand.widget.c(this.iQZ.iQI.a(this.iQZ.iMG), linkedList, this.iQZ.iQO, this.iQZ.iQP, new com.tencent.mm.plugin.appbrand.widget.c.a(this) {
                                final /* synthetic */ AnonymousClass2 iRa;

                                {
                                    this.iRa = r1;
                                }

                                public final void c(int i, Bundle bundle) {
                                    w.i("MicroMsg.JsApiLogin", "stev onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
                                    switch (i) {
                                        case 1:
                                        case 2:
                                            this.iRa.iQZ.iQL = "loginConfirm";
                                            this.iRa.iQZ.iQK = bundle;
                                            this.iRa.iQZ.iQN = i;
                                            AppBrandMainProcessService.a(this.iRa.iQZ);
                                            if (i == 2) {
                                                this.iRa.iQZ.iQI.a(this.iRa.iQZ.iMG, this.iRa.iQZ.iMH, "fail auth deny");
                                                this.iRa.iQZ.iQJ.Tn();
                                                return;
                                            }
                                            return;
                                        default:
                                            w.d("MicroMsg.JsApiLogin", "press back button!");
                                            this.iRa.iQZ.iQI.a(this.iRa.iQZ.iMG, this.iRa.iQZ.iMH, "fail auth cancel");
                                            this.iRa.iQZ.iQJ.Tn();
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
            this.iQL = parcel.readString();
            this.appId = parcel.readString();
            this.code = parcel.readString();
            this.iQM = parcel.readString();
            this.iQY = parcel.readString();
            this.iQX = parcel.readInt();
            this.iQO = parcel.readString();
            this.iQP = parcel.readString();
            this.iQQ = parcel.readInt();
            this.iQR = parcel.readBundle(JsApiLogin.class.getClassLoader());
            this.iQK = parcel.readBundle(JsApiLogin.class.getClassLoader());
            this.iPk = parcel.readInt();
            this.iQN = parcel.readInt();
            this.iPl = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.data);
            parcel.writeInt(this.iMH);
            parcel.writeString(this.iQL);
            parcel.writeString(this.appId);
            parcel.writeString(this.code);
            parcel.writeString(this.iQM);
            parcel.writeString(this.iQY);
            parcel.writeInt(this.iQX);
            parcel.writeString(this.iQO);
            parcel.writeString(this.iQP);
            parcel.writeInt(this.iQQ);
            parcel.writeBundle(this.iQR);
            parcel.writeBundle(this.iQK);
            parcel.writeInt(this.iPk);
            parcel.writeInt(this.iQN);
            parcel.writeInt(this.iPl);
        }

        private void a(String str, Bundle bundle, int i, String str2, int i2, int i3, a aVar) {
            ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
            LinkedList linkedList = new LinkedList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                linkedList.add((String) it.next());
            }
            final a aVar2 = aVar;
            final int i4 = i3;
            h.vH().gXC.a(new d(str, linkedList, i, str2, i2, i3, this.iPl, new com.tencent.mm.r.a.d.a<d>(this) {
                final /* synthetic */ LoginTask iQZ;

                public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
                    d dVar = (d) kVar;
                    w.i("MicroMsg.JsApiLogin", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    if (i != 0 || i2 != 0) {
                        aVar2.Tr();
                    } else if (!(dVar instanceof d)) {
                        w.i("MicroMsg.JsApiLogin", "not jslogin cgi reqeust");
                        aVar2.Tr();
                    } else if (i4 == 2) {
                        w.i("MicroMsg.JsApiLogin", "press reject button");
                        aVar2.Tr();
                    } else {
                        ahe uG = dVar.uG();
                        int i3 = uG.tLL.fIz;
                        String str2 = uG.tLL.fIA;
                        w.i("MicroMsg.JsApiLogin", "stev NetSceneJSLoginConfirm jsErrcode %d", new Object[]{Integer.valueOf(i3)});
                        if (i3 == 0) {
                            aVar2.pp(uG.tLO);
                            w.i("MicroMsg.JsApiLogin", "resp data code [%s]", new Object[]{r0});
                            return;
                        }
                        aVar2.Tr();
                        w.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLoginConfirm %s", new Object[]{str2});
                    }
                }
            }), 0);
        }
    }

    public final /* bridge */ /* synthetic */ void a(m mVar, JSONObject jSONObject, int i) {
        super.a(mVar, jSONObject, i);
    }

    public final void a(m mVar, JSONObject jSONObject, int i, a aVar) {
        MainProcessTask loginTask = new LoginTask();
        loginTask.appId = mVar.ivH;
        loginTask.iQL = "login";
        AppBrandSysConfig mY = b.mY(mVar.ivH);
        if (mY != null) {
            loginTask.iPk = mY.iFk.izV;
        }
        AppBrandStatObject mZ = b.mZ(mVar.ivH);
        if (mZ != null) {
            loginTask.iPl = mZ.scene;
        }
        String jSONObject2 = jSONObject.toString();
        loginTask.iQI = this;
        loginTask.iMG = mVar;
        loginTask.data = jSONObject2;
        loginTask.iMH = i;
        loginTask.iQJ = aVar;
        loginTask.iQR = new Bundle();
        loginTask.SM();
        AppBrandMainProcessService.a(loginTask);
    }
}
