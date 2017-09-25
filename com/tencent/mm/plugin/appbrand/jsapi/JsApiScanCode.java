package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.b;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import com.tencent.mm.y.u.a;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class JsApiScanCode extends a {
    public static final int CTRL_INDEX = 148;
    public static final String NAME = "scanCode";
    public static volatile boolean iPu = false;

    public static class GetA8KeyTask extends MainProcessTask {
        public static final Creator<GetA8KeyTask> CREATOR = new Creator<GetA8KeyTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                GetA8KeyTask getA8KeyTask = new GetA8KeyTask();
                getA8KeyTask.f(parcel);
                return getA8KeyTask;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetA8KeyTask[i];
            }
        };
        public int actionCode;
        public int fFo;
        public int fFp;
        public String iPA;
        public String iPB;
        public Runnable iPC;

        public final void PM() {
            final l lVar = new l(this.iPA, 36, this.fFo, this.fFp, null, (int) System.currentTimeMillis());
            u.a(lVar.gUA, new a(this) {
                final /* synthetic */ GetA8KeyTask iPE;

                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    if (i == 0 && i2 == 0) {
                        this.iPE.actionCode = lVar.IS();
                        switch (this.iPE.actionCode) {
                            case 26:
                                this.iPE.iPB = lVar.IQ();
                                break;
                            default:
                                this.iPE.iPB = "";
                                break;
                        }
                        this.iPE.SL();
                    } else {
                        this.iPE.actionCode = -1;
                        this.iPE.SL();
                    }
                    return 0;
                }
            });
        }

        public final void SK() {
            if (this.iPC != null) {
                this.iPC.run();
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.iPA);
            parcel.writeInt(this.actionCode);
            parcel.writeString(this.iPB);
            parcel.writeInt(this.fFo);
            parcel.writeInt(this.fFp);
        }

        public final void f(Parcel parcel) {
            this.iPA = parcel.readString();
            this.actionCode = parcel.readInt();
            this.iPB = parcel.readString();
            this.fFo = parcel.readInt();
            this.fFp = parcel.readInt();
        }
    }

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        if (iPu) {
            mVar.x(i, d("cancel", null));
            return;
        }
        iPu = true;
        Context a = a(mVar);
        if (a == null) {
            mVar.x(i, d("fail", null));
            return;
        }
        a.uSV = new MMActivity.a(this) {
            final /* synthetic */ JsApiScanCode iPw;

            public final void a(int i, int i2, Intent intent) {
                JsApiScanCode.iPu = false;
                if (i == (this.iPw.hashCode() & 65535)) {
                    switch (i2) {
                        case -1:
                            Object stringExtra;
                            int intExtra;
                            int intExtra2;
                            int intExtra3;
                            String str = "";
                            if (intent != null) {
                                stringExtra = intent.getStringExtra("key_scan_result");
                                intExtra = intent.getIntExtra("key_scan_result_type", 0);
                                intExtra2 = intent.getIntExtra("key_scan_result_code_type", 0);
                                intExtra3 = intent.getIntExtra("key_scan_result_code_version", 0);
                            } else {
                                intExtra2 = 0;
                                intExtra = 0;
                                String str2 = str;
                                intExtra3 = 0;
                            }
                            final HashMap hashMap = new HashMap();
                            hashMap.put("charSet", ProtocolPackage.ServerEncoding);
                            if (intExtra != 1) {
                                String[] split = stringExtra.split(",");
                                String str3 = "result";
                                if (split.length > 1) {
                                    stringExtra = split[1];
                                }
                                hashMap.put(str3, stringExtra);
                                hashMap.put("scanType", split.length > 1 ? split[0] : "");
                                mVar.x(i, this.iPw.d("ok", hashMap));
                                return;
                            }
                            hashMap.put("result", intExtra2 == 22 ? "" : stringExtra);
                            hashMap.put("scanType", "QR_CODE");
                            final MainProcessTask getA8KeyTask = new GetA8KeyTask();
                            getA8KeyTask.iPA = stringExtra;
                            getA8KeyTask.fFo = intExtra2;
                            getA8KeyTask.fFp = intExtra3;
                            getA8KeyTask.iPC = new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 iPz;

                                public final void run() {
                                    getA8KeyTask.SN();
                                    if (getA8KeyTask.actionCode == 26) {
                                        Uri parse = Uri.parse(getA8KeyTask.iPB);
                                        if (com.tencent.mm.plugin.appbrand.b.mY(mVar.ivH).fCJ.equals(parse.getQueryParameter("username"))) {
                                            hashMap.put("path", URLDecoder.decode(bg.mz(parse.getQueryParameter("path"))));
                                        }
                                    }
                                    mVar.x(i, this.iPz.iPw.d("ok", hashMap));
                                }
                            };
                            getA8KeyTask.SM();
                            AppBrandMainProcessService.a(getA8KeyTask);
                            return;
                        case 0:
                            mVar.x(i, this.iPw.d("cancel", null));
                            return;
                        default:
                            mVar.x(i, this.iPw.d("fail", null));
                            return;
                    }
                }
            }
        };
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 1);
        intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
        intent.putExtra("key_is_finish_on_scanned", true);
        intent.putExtra("key_is_hide_right_btn", jSONObject.optBoolean("onlyFromCamera", false));
        d.a(a, "scanner", ".ui.SingleTopScanUI", intent, hashCode() & 65535, false);
    }
}
