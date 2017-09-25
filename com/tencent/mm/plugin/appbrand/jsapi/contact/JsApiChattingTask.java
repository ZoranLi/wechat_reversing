package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.j.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.i.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public class JsApiChattingTask extends MainProcessTask {
    public static final Creator<JsApiChattingTask> CREATOR = new Creator<JsApiChattingTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsApiChattingTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiChattingTask[i];
        }
    };
    public String fFa;
    public Runnable iMD;
    public String sessionFrom;
    public String username;

    public JsApiChattingTask(Parcel parcel) {
        f(parcel);
    }

    public final void PM() {
        ap.yY();
        a Rc = c.wR().Rc(this.username);
        w.d("MicroMsg.JsApiChattingTask", "sessionFrom:%s,username:%s,nickname:%s", new Object[]{this.sessionFrom, this.username, this.fFa});
        if (Rc == null || ((int) Rc.gTQ) == 0) {
            x xVar = new x(this.username);
            xVar.setType(0);
            xVar.bR(this.fFa);
            ap.yY();
            c.wR().R(xVar);
            w.i("MicroMsg.JsApiChattingTask", "%s save to contact_table", new Object[]{this.username});
        }
        ((b) h.h(b.class)).oh(this.username);
        SL();
    }

    public final void SK() {
        if (this.iMD != null) {
            this.iMD.run();
        }
    }

    public final void f(Parcel parcel) {
        this.sessionFrom = parcel.readString();
        this.username = parcel.readString();
        this.fFa = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sessionFrom);
        parcel.writeString(this.username);
        parcel.writeString(this.fFa);
    }
}
