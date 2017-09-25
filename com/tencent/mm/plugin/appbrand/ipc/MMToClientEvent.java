package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MMToClientEvent extends MainProcessTask {
    public static final Creator<MMToClientEvent> CREATOR = new Creator<MMToClientEvent>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MMToClientEvent(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MMToClientEvent[i];
        }
    };
    private static MMToClientEvent iKr;
    private static final Set<a> iKs = new HashSet();
    public String appId;
    int fCK;
    String fJu;
    public int iKo;
    String iKp;
    Object iKq;
    public int type;

    public interface a {
        void aF(Object obj);
    }

    private MMToClientEvent() {
    }

    public MMToClientEvent(Parcel parcel) {
        f(parcel);
    }

    private static MMToClientEvent SJ() {
        if (iKr == null) {
            synchronized (MMToClientEvent.class) {
                if (iKr == null) {
                    iKr = new MMToClientEvent();
                }
            }
        }
        return iKr;
    }

    public final void PM() {
        switch (this.iKo) {
            case 1:
                d.a(this);
                return;
            case 2:
                d.b(this);
                return;
            default:
                return;
        }
    }

    public static void oZ(String str) {
        SJ().iKo = 1;
        SJ().appId = str;
        AppBrandMainProcessService.a(SJ());
    }

    public static void pa(String str) {
        SJ().iKo = 2;
        SJ().appId = str;
        AppBrandMainProcessService.a(SJ());
    }

    public static void a(a aVar) {
        synchronized (iKs) {
            iKs.add(aVar);
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            synchronized (iKs) {
                iKs.remove(aVar);
            }
        }
    }

    private void aI(final Object obj) {
        if (obj != null) {
            final List linkedList = new LinkedList();
            synchronized (iKs) {
                for (a add : iKs) {
                    linkedList.add(add);
                }
            }
            d.vL().D(new Runnable(this) {
                final /* synthetic */ MMToClientEvent iKv;

                public final void run() {
                    for (a aF : linkedList) {
                        aF.aF(obj);
                    }
                }
            });
        }
    }

    public final void SK() {
        Map hashMap;
        switch (this.iKo) {
            case 3:
                com.tencent.mm.plugin.appbrand.jsapi.ab.a aVar = new com.tencent.mm.plugin.appbrand.jsapi.ab.a();
                hashMap = new HashMap();
                hashMap.put(Columns.TYPE, Integer.valueOf(this.type));
                hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, this.fJu);
                aVar.ad(this.appId, 0).q(hashMap).SR();
                return;
            case 4:
                com.tencent.mm.plugin.appbrand.jsapi.contact.b.a aVar2 = new com.tencent.mm.plugin.appbrand.jsapi.contact.b.a();
                hashMap = new HashMap();
                hashMap.put("count", Integer.valueOf(this.fCK));
                hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, this.fJu);
                aVar2.ad(this.appId, 0).q(hashMap).SR();
                return;
            case 5:
                aI(this.iKq);
                return;
            default:
                return;
        }
    }

    public final void f(Parcel parcel) {
        this.iKo = parcel.readInt();
        this.appId = parcel.readString();
        this.type = parcel.readInt();
        this.fJu = parcel.readString();
        this.fCK = parcel.readInt();
        try {
            this.iKp = parcel.readString();
            if (!bg.mA(this.iKp)) {
                Class cls = Class.forName(this.iKp);
                if (cls != null) {
                    this.iKq = parcel.readParcelable(cls.getClassLoader());
                }
            }
        } catch (Exception e) {
            w.v("MicroMsg.MMToClientEvent", "unparcel custom data e %s", new Object[]{e});
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.iKo);
        parcel.writeString(this.appId);
        parcel.writeInt(this.type);
        parcel.writeString(this.fJu);
        parcel.writeInt(this.fCK);
        if (!bg.mA(this.iKp) && this.iKq != null) {
            parcel.writeString(this.iKp);
            parcel.writeParcelable((Parcelable) this.iKq, i);
        }
    }
}
