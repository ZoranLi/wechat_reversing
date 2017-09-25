package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.w;

class JsApiSetStorageTask extends MainProcessTask {
    public static final Creator<JsApiSetStorageTask> CREATOR = new Creator<JsApiSetStorageTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            JsApiSetStorageTask jsApiSetStorageTask = new JsApiSetStorageTask();
            jsApiSetStorageTask.f(parcel);
            return jsApiSetStorageTask;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiSetStorageTask[i];
        }
    };
    public String appId;
    private String arH;
    public Runnable iMD;
    private boolean iOg;
    private int iOh;
    private int iOi;
    private int iOj;
    public String result;
    private String type;
    private String value;

    JsApiSetStorageTask() {
    }

    public final void w(String str, String str2, String str3) {
        if (cj.g(str, str2, str3) > 102400) {
            this.iOh = cj.g(str);
            this.iOi = cj.g(str2);
            this.iOj = cj.g(str3);
            try {
                cj.f(this.iKz, str, str2, str3);
            } catch (Exception e) {
                w.e("MicroMsg.JsApiSetStorageTask", e.getMessage());
            }
            this.iOg = true;
            return;
        }
        this.iOg = false;
        this.arH = str;
        this.value = str2;
        this.type = str3;
    }

    private void Tj() {
        this.arH = null;
        this.value = null;
        this.type = null;
    }

    public final void SK() {
        if (this.iMD != null) {
            this.iMD.run();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void PM() {
        /*
        r5 = this;
        r0 = r5.iOg;
        if (r0 == 0) goto L_0x0046;
    L_0x0004:
        r0 = r5.iKz;	 Catch:{ Exception -> 0x0058 }
        r0 = com.tencent.mm.plugin.appbrand.jsapi.cj.pn(r0);	 Catch:{ Exception -> 0x0058 }
        r1 = r0.length();	 Catch:{ Exception -> 0x0058 }
        r2 = r5.iOh;	 Catch:{ Exception -> 0x0058 }
        r3 = r5.iOi;	 Catch:{ Exception -> 0x0058 }
        r2 = r2 + r3;
        r3 = r5.iOj;	 Catch:{ Exception -> 0x0058 }
        r2 = r2 + r3;
        if (r1 != r2) goto L_0x0041;
    L_0x0018:
        r1 = 0;
        r2 = r5.iOh;	 Catch:{ Exception -> 0x0058 }
        r1 = r0.substring(r1, r2);	 Catch:{ Exception -> 0x0058 }
        r5.arH = r1;	 Catch:{ Exception -> 0x0058 }
        r1 = r5.iOh;	 Catch:{ Exception -> 0x0058 }
        r2 = r5.iOh;	 Catch:{ Exception -> 0x0058 }
        r3 = r5.iOi;	 Catch:{ Exception -> 0x0058 }
        r2 = r2 + r3;
        r1 = r0.substring(r1, r2);	 Catch:{ Exception -> 0x0058 }
        r5.value = r1;	 Catch:{ Exception -> 0x0058 }
        r1 = r5.iOh;	 Catch:{ Exception -> 0x0058 }
        r2 = r5.iOi;	 Catch:{ Exception -> 0x0058 }
        r1 = r1 + r2;
        r2 = r5.iOh;	 Catch:{ Exception -> 0x0058 }
        r3 = r5.iOi;	 Catch:{ Exception -> 0x0058 }
        r2 = r2 + r3;
        r3 = r5.iOj;	 Catch:{ Exception -> 0x0058 }
        r2 = r2 + r3;
        r0 = r0.substring(r1, r2);	 Catch:{ Exception -> 0x0058 }
        r5.type = r0;	 Catch:{ Exception -> 0x0058 }
    L_0x0041:
        r0 = r5.iKz;
        com.tencent.mm.plugin.appbrand.jsapi.cj.po(r0);
    L_0x0046:
        r0 = com.tencent.mm.plugin.appbrand.app.c.PQ();
        if (r0 != 0) goto L_0x0070;
    L_0x004c:
        r0 = "fail";
        r5.result = r0;
        r5.Tj();
        r5.SL();
    L_0x0057:
        return;
    L_0x0058:
        r0 = move-exception;
        r1 = "MicroMsg.JsApiSetStorageTask";
        r0 = r0.getMessage();	 Catch:{ all -> 0x0069 }
        com.tencent.mm.sdk.platformtools.w.e(r1, r0);	 Catch:{ all -> 0x0069 }
        r0 = r5.iKz;
        com.tencent.mm.plugin.appbrand.jsapi.cj.po(r0);
        goto L_0x0046;
    L_0x0069:
        r0 = move-exception;
        r1 = r5.iKz;
        com.tencent.mm.plugin.appbrand.jsapi.cj.po(r1);
        throw r0;
    L_0x0070:
        r1 = r5.appId;
        r2 = r5.arH;
        r3 = r5.value;
        r4 = r5.type;
        r0 = r0.e(r1, r2, r3, r4);
        r1 = com.tencent.mm.plugin.appbrand.appstorage.b.a.NONE;
        if (r0 != r1) goto L_0x008c;
    L_0x0080:
        r0 = "ok";
        r5.result = r0;
    L_0x0085:
        r5.Tj();
        r5.SL();
        goto L_0x0057;
    L_0x008c:
        r1 = com.tencent.mm.plugin.appbrand.appstorage.b.a.QUOTA_REACHED;
        if (r0 != r1) goto L_0x0096;
    L_0x0090:
        r0 = "fail:quota reached";
        r5.result = r0;
        goto L_0x0085;
    L_0x0096:
        r0 = "fail";
        r5.result = r0;
        goto L_0x0085;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.JsApiSetStorageTask.PM():void");
    }

    public final void f(Parcel parcel) {
        this.appId = parcel.readString();
        this.iOg = parcel.readByte() != (byte) 0;
        this.iOh = parcel.readInt();
        this.iOi = parcel.readInt();
        this.iOj = parcel.readInt();
        this.arH = parcel.readString();
        this.value = parcel.readString();
        this.type = parcel.readString();
        this.result = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeByte(this.iOg ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.iOh);
        parcel.writeInt(this.iOi);
        parcel.writeInt(this.iOj);
        parcel.writeString(this.arH);
        parcel.writeString(this.value);
        parcel.writeString(this.type);
        parcel.writeString(this.result);
    }
}
