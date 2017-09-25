package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.protocal.c.ahi;
import com.tencent.mm.protocal.c.awh;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiOperateWXData extends b {
    public static final int CTRL_INDEX = 79;
    public static final String NAME = "operateWXData";

    private static class OperateWXDataTask extends MainProcessTask {
        public static final Creator<OperateWXDataTask> CREATOR = new Creator<OperateWXDataTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new OperateWXDataTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new OperateWXDataTask[i];
            }
        };
        public String appId;
        m iMG;
        public int iMH;
        public int iPk;
        int iPl;
        b iQI;
        a iQJ;
        public String iQL;
        public String iQM;
        public int iQN;
        public String iQO;
        public String iQP;
        public int iQQ;
        public Bundle iQR;
        public String iRc;
        public String iRd;
        public String iRe;

        public interface a {
            void a(LinkedList<awh> linkedList, String str, String str2);

            void nu(String str);

            void pp(String str);
        }

        public OperateWXDataTask(Parcel parcel) {
            f(parcel);
        }

        public final void PM() {
            a anonymousClass1 = new a(this) {
                final /* synthetic */ OperateWXDataTask iRf;

                {
                    this.iRf = r1;
                }

                public final void pp(String str) {
                    w.d("MicroMsg.JsApiOperateWXData", "onSuccess !");
                    this.iRf.iRd = str;
                    this.iRf.iQM = "ok";
                    this.iRf.SL();
                }

                public final void nu(String str) {
                    w.e("MicroMsg.JsApiOperateWXData", "onFailure !");
                    this.iRf.iQM = "fail:" + str;
                    this.iRf.SL();
                }

                public final void a(LinkedList<awh> linkedList, String str, String str2) {
                    w.d("MicroMsg.JsApiOperateWXData", "onConfirm !");
                    this.iRf.iQQ = linkedList.size();
                    int i = 0;
                    while (i < this.iRf.iQQ) {
                        try {
                            this.iRf.iQR.putByteArray(String.valueOf(i), ((awh) linkedList.get(i)).toByteArray());
                            i++;
                        } catch (Throwable e) {
                            w.e("MicroMsg.JsApiOperateWXData", "IOException %s", new Object[]{e.getMessage()});
                            w.printErrStackTrace("MicroMsg.JsApiOperateWXData", e, "", new Object[0]);
                            this.iRf.iQM = "fail";
                            this.iRf.SL();
                            return;
                        }
                    }
                    this.iRf.iQO = str;
                    this.iRf.iQP = str2;
                    this.iRf.iQM = "needConfirm";
                    this.iRf.SL();
                }
            };
            if (this.iQL.equals(JsApiOperateWXData.NAME)) {
                a(this.appId, this.iRc, "", this.iPk, this.iQN, anonymousClass1);
            } else if (this.iQL.equals("operateWXDataConfirm")) {
                a(this.appId, this.iRc, this.iRe, this.iPk, this.iQN, anonymousClass1);
            }
        }

        public final void SK() {
            SN();
            if (!this.iMG.aaI) {
                return;
            }
            if (this.iQM.equals("ok")) {
                Map hashMap = new HashMap();
                hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, this.iRd);
                this.iMG.x(this.iMH, this.iQI.d("ok", hashMap));
                this.iQJ.Tn();
            } else if (this.iQM.contains("fail")) {
                this.iQI.a(this.iMG, this.iMH, this.iQM);
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
                        w.e("MicroMsg.JsApiOperateWXData", "IOException %s", new Object[]{e.getMessage()});
                        w.printErrStackTrace("MicroMsg.JsApiOperateWXData", e, "", new Object[0]);
                        this.iQI.a(this.iMG, this.iMH, "fail");
                        this.iQJ.Tn();
                        return;
                    }
                }
                if (linkedList.size() > 0) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ OperateWXDataTask iRf;

                        public final void run() {
                            this.iRf.iMG.ixr.a(new c(this.iRf.iQI.a(this.iRf.iMG), linkedList, this.iRf.iQO, this.iRf.iQP, new com.tencent.mm.plugin.appbrand.widget.c.a(this) {
                                final /* synthetic */ AnonymousClass2 iRg;

                                {
                                    this.iRg = r1;
                                }

                                public final void c(int i, Bundle bundle) {
                                    w.i("MicroMsg.JsApiOperateWXData", "stev onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
                                    switch (i) {
                                        case 1:
                                        case 2:
                                            this.iRg.iRf.iQL = "operateWXDataConfirm";
                                            ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                                            if (arrayList == null || arrayList.size() <= 0) {
                                                this.iRg.iRf.iRe = "";
                                            } else {
                                                this.iRg.iRf.iRe = (String) arrayList.get(0);
                                            }
                                            this.iRg.iRf.iQN = i;
                                            AppBrandMainProcessService.a(this.iRg.iRf);
                                            if (i == 2) {
                                                this.iRg.iRf.iQI.a(this.iRg.iRf.iMG, this.iRg.iRf.iMH, "fail auth deny");
                                                this.iRg.iRf.iQJ.Tn();
                                                return;
                                            }
                                            return;
                                        default:
                                            w.d("MicroMsg.JsApiOperateWXData", "press back button!");
                                            this.iRg.iRf.iQI.a(this.iRg.iRf.iMG, this.iRg.iRf.iMH, "fail auth cancel");
                                            this.iRg.iRf.iQJ.Tn();
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
            this.appId = parcel.readString();
            this.iQM = parcel.readString();
            this.iQO = parcel.readString();
            this.iQP = parcel.readString();
            this.iRc = parcel.readString();
            this.iRd = parcel.readString();
            this.iMH = parcel.readInt();
            this.iQL = parcel.readString();
            this.iRe = parcel.readString();
            this.iQQ = parcel.readInt();
            this.iQR = parcel.readBundle(JsApiOperateWXData.class.getClassLoader());
            this.iPk = parcel.readInt();
            this.iQN = parcel.readInt();
            this.iPl = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeString(this.iQM);
            parcel.writeString(this.iQO);
            parcel.writeString(this.iQP);
            parcel.writeString(this.iRc);
            parcel.writeString(this.iRd);
            parcel.writeInt(this.iMH);
            parcel.writeString(this.iQL);
            parcel.writeString(this.iRe);
            parcel.writeInt(this.iQQ);
            parcel.writeBundle(this.iQR);
            parcel.writeInt(this.iPk);
            parcel.writeInt(this.iQN);
            parcel.writeInt(this.iPl);
        }

        private void a(String str, String str2, String str3, int i, final int i2, final a aVar) {
            ap.vd().a(new b(str, str2, str3, i, i2, this.iPl, new com.tencent.mm.plugin.appbrand.e.b.a<b>(this) {
                final /* synthetic */ OperateWXDataTask iRf;

                public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
                    b bVar = (b) kVar;
                    w.d("MicroMsg.JsApiOperateWXData", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    if (i != 0 || i2 != 0) {
                        aVar.nu("");
                    } else if (!(bVar instanceof b)) {
                    } else {
                        if (i2 == 2) {
                            w.d("MicroMsg.JsApiOperateWXData", "press reject button");
                            return;
                        }
                        ahi com_tencent_mm_protocal_c_ahi = bVar.gUA == null ? null : (ahi) bVar.gUA.hsk.hsr;
                        int i3 = com_tencent_mm_protocal_c_ahi.tLL.fIz;
                        String str2 = com_tencent_mm_protocal_c_ahi.tLL.fIA;
                        awh com_tencent_mm_protocal_c_awh = com_tencent_mm_protocal_c_ahi.tLS;
                        LinkedList linkedList = new LinkedList();
                        if (com_tencent_mm_protocal_c_awh != null) {
                            linkedList.add(com_tencent_mm_protocal_c_awh);
                        }
                        String str3 = com_tencent_mm_protocal_c_ahi.muS;
                        String str4 = com_tencent_mm_protocal_c_ahi.tee;
                        w.d("MicroMsg.JsApiOperateWXData", "stev NetSceneJSOperateWxData jsErrcode %d", new Object[]{Integer.valueOf(i3)});
                        if (i3 == -12000) {
                            aVar.a(linkedList, str3, str4);
                        } else if (i3 == 0) {
                            w.d("MicroMsg.JsApiOperateWXData", "resp data %s", new Object[]{com_tencent_mm_protocal_c_ahi.jMQ.bGX()});
                            aVar.pp(r0);
                        } else {
                            w.e("MicroMsg.JsApiOperateWXData", "onSceneEnd NetSceneJSOperateWxData Failed %s", new Object[]{str2});
                            aVar.nu(str2);
                        }
                    }
                }
            }), 0);
        }
    }

    public final /* bridge */ /* synthetic */ void a(m mVar, JSONObject jSONObject, int i) {
        super.a(mVar, jSONObject, i);
    }

    public final void a(m mVar, JSONObject jSONObject, int i, a aVar) {
        try {
            String string = jSONObject.getString(SlookAirButtonFrequentContactAdapter.DATA);
            MainProcessTask operateWXDataTask = new OperateWXDataTask();
            operateWXDataTask.appId = mVar.ivH;
            operateWXDataTask.iQL = NAME;
            AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(mVar.ivH);
            if (mY != null) {
                operateWXDataTask.iPk = mY.iFk.izV;
            }
            operateWXDataTask.iQI = this;
            operateWXDataTask.iMG = mVar;
            operateWXDataTask.iRc = string;
            operateWXDataTask.iMH = i;
            operateWXDataTask.iQJ = aVar;
            operateWXDataTask.iQR = new Bundle();
            AppBrandStatObject mZ = com.tencent.mm.plugin.appbrand.b.mZ(operateWXDataTask.appId);
            if (mZ != null) {
                operateWXDataTask.iPl = mZ.scene;
            }
            operateWXDataTask.SM();
            AppBrandMainProcessService.a(operateWXDataTask);
        } catch (Exception e) {
            w.e("MicroMsg.JsApiOperateWXData", "Exception %s", new Object[]{e.getMessage()});
            mVar.x(i, d("fail", null));
        }
    }
}
