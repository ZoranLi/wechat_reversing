package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.appstorage.b;
import com.tencent.mm.plugin.appbrand.appstorage.b.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.w;

class JsApiGetStorageTask extends MainProcessTask {
    public static final Creator<JsApiGetStorageTask> CREATOR = new Creator<JsApiGetStorageTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            JsApiGetStorageTask jsApiGetStorageTask = new JsApiGetStorageTask();
            jsApiGetStorageTask.f(parcel);
            return jsApiGetStorageTask;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiGetStorageTask[i];
        }
    };
    public String appId;
    public String arH;
    public Runnable iMD;
    private boolean iOg;
    private int iOh;
    private int iOi;
    private int iOj;
    public String type;
    public String value;

    public final void PM() {
        b PQ = c.PQ();
        if (PQ == null) {
            SL();
            return;
        }
        Object[] aA = PQ.aA(this.appId, this.arH);
        if (((a) aA[0]) == a.NONE) {
            if (cj.g((String) aA[1], (String) aA[2]) > 102400) {
                this.iOi = cj.g((String) aA[1]);
                this.iOj = cj.g(r1);
                try {
                    cj.f(this.iKz, r0, r1);
                } catch (Exception e) {
                    w.e("MicroMsg.JsApiGetStorageTask", e.getMessage());
                }
                this.iOg = true;
            } else {
                this.iOg = false;
                this.value = r0;
                this.type = r1;
            }
        }
        SL();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void SK() {
        /*
        r4 = this;
        r0 = r4.iOg;
        if (r0 == 0) goto L_0x0030;
    L_0x0004:
        r0 = r4.iKz;	 Catch:{ Exception -> 0x003a }
        r0 = com.tencent.mm.plugin.appbrand.jsapi.cj.pn(r0);	 Catch:{ Exception -> 0x003a }
        r1 = r0.length();	 Catch:{ Exception -> 0x003a }
        r2 = r4.iOi;	 Catch:{ Exception -> 0x003a }
        r3 = r4.iOj;	 Catch:{ Exception -> 0x003a }
        r2 = r2 + r3;
        if (r1 != r2) goto L_0x002b;
    L_0x0015:
        r1 = 0;
        r2 = r4.iOi;	 Catch:{ Exception -> 0x003a }
        r1 = r0.substring(r1, r2);	 Catch:{ Exception -> 0x003a }
        r4.value = r1;	 Catch:{ Exception -> 0x003a }
        r1 = r4.iOi;	 Catch:{ Exception -> 0x003a }
        r2 = r4.iOi;	 Catch:{ Exception -> 0x003a }
        r3 = r4.iOj;	 Catch:{ Exception -> 0x003a }
        r2 = r2 + r3;
        r0 = r0.substring(r1, r2);	 Catch:{ Exception -> 0x003a }
        r4.type = r0;	 Catch:{ Exception -> 0x003a }
    L_0x002b:
        r0 = r4.iKz;
        com.tencent.mm.plugin.appbrand.jsapi.cj.po(r0);
    L_0x0030:
        r0 = r4.iMD;
        if (r0 == 0) goto L_0x0039;
    L_0x0034:
        r0 = r4.iMD;
        r0.run();
    L_0x0039:
        return;
    L_0x003a:
        r0 = move-exception;
        r1 = "MicroMsg.JsApiGetStorageTask";
        r0 = r0.getMessage();	 Catch:{ all -> 0x004b }
        com.tencent.mm.sdk.platformtools.w.e(r1, r0);	 Catch:{ all -> 0x004b }
        r0 = r4.iKz;
        com.tencent.mm.plugin.appbrand.jsapi.cj.po(r0);
        goto L_0x0030;
    L_0x004b:
        r0 = move-exception;
        r1 = r4.iKz;
        com.tencent.mm.plugin.appbrand.jsapi.cj.po(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.JsApiGetStorageTask.SK():void");
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
    }
}
