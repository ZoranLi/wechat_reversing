package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.R;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.g.m.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

final class JsApiGetLocation extends a {
    public static final int CTRL_INDEX = 37;
    public static final String NAME = "getLocation";
    private static final HashSet<String> iNc;

    private static final class LocationTask extends MainProcessTask implements b {
        public static final Creator<LocationTask> CREATOR = new Creator<LocationTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LocationTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LocationTask[i];
            }
        };
        public double aKg;
        public double aKh;
        public double aKj;
        public c gKi = null;
        public int iLf;
        public WeakReference<m> iNd;
        public JsApiGetLocation iNe;
        public String iNf;
        public boolean iNg;
        public float iNh;
        public float iNi;
        public double iNj;
        public double iNk;
        public volatile a iNl = null;
        private ae iNm;
        int iNn = 0;
        long iNo = 0;
        public com.tencent.mm.plugin.appbrand.m iwq;

        public final void SK() {
            super.SK();
            SX();
            d.aO(this);
            if (this.iwq == null) {
                return;
            }
            if (this.iNg) {
                Map hashMap = new HashMap(4);
                hashMap.put("latitude", Float.valueOf(this.iNh));
                hashMap.put("longitude", Float.valueOf(this.iNi));
                hashMap.put("speed", Double.valueOf(this.aKj));
                hashMap.put("accuracy", Double.valueOf(this.aKh));
                hashMap.put("altitude", Double.valueOf(this.aKg));
                hashMap.put("verticalAccuracy", Double.valueOf(this.iNj));
                hashMap.put("horizontalAccuracy", Double.valueOf(this.iNk));
                this.iwq.x(this.iLf, this.iNe.d("ok", hashMap));
                return;
            }
            this.iwq.x(this.iLf, this.iNe.d("fail", null));
        }

        public final void PM() {
            d.aN(this);
            switch (this.iNn) {
                case 1:
                    if (this.gKi == null) {
                        this.gKi = c.Gk();
                    }
                    if (this.gKi == null) {
                        w.e("MicroMsg.JsApiGetLocation", "getLocationInMMProcess, iGetLocation == null");
                        this.iNg = false;
                        SL();
                        return;
                    }
                    if (this.iNl == null) {
                        this.iNl = new a(this) {
                            final /* synthetic */ LocationTask iNp;

                            {
                                this.iNp = r1;
                            }

                            public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                                if (!z) {
                                    return true;
                                }
                                w.v("MicroMsg.JsApiGetLocation", "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f, altitude : %s", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2), Double.valueOf(d3)});
                                if (!(d3 == 0.0d || this.iNp.gKi == null)) {
                                    this.iNp.gKi.c(this.iNp.iNl);
                                }
                                if (this.iNp.iNl == null) {
                                    w.w("MicroMsg.JsApiGetLocation", "already callback");
                                    return false;
                                }
                                this.iNp.iNg = true;
                                this.iNp.iNh = f2;
                                this.iNp.iNi = f;
                                this.iNp.aKj = d;
                                this.iNp.aKh = d2;
                                this.iNp.aKg = d3;
                                this.iNp.iNj = 0.0d;
                                this.iNp.iNk = d2;
                                if (d3 != 0.0d) {
                                    this.iNp.SL();
                                    this.iNp.iNl = null;
                                } else {
                                    h.vL().e(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass1 iNq;

                                        {
                                            this.iNq = r1;
                                        }

                                        public final void run() {
                                            if (this.iNq.iNp.iNl != null) {
                                                if (this.iNq.iNp.gKi != null) {
                                                    this.iNq.iNp.gKi.c(this.iNq.iNp.iNl);
                                                }
                                                this.iNq.iNp.SL();
                                                this.iNq.iNp.iNl = null;
                                            }
                                        }
                                    }, 5000);
                                    w.i("MicroMsg.JsApiGetLocation", "post delay 5 sec.");
                                }
                                return false;
                            }
                        };
                    }
                    if (this.iNm == null) {
                        this.iNm = new ae(Looper.getMainLooper());
                    }
                    this.iNm.postDelayed(new Runnable(this) {
                        final /* synthetic */ LocationTask iNp;

                        {
                            this.iNp = r1;
                        }

                        public final void run() {
                            if (this.iNp.SW()) {
                                this.iNp.iNg = false;
                                this.iNp.SL();
                            }
                        }
                    }, 20000);
                    if (this.iNf.equalsIgnoreCase("gcj02")) {
                        this.gKi.b(this.iNl, false);
                        return;
                    } else if (this.iNf.equalsIgnoreCase("wgs84")) {
                        this.gKi.a(this.iNl, false);
                        return;
                    } else {
                        return;
                    }
                case 2:
                    SW();
                    return;
                default:
                    this.iNg = false;
                    SL();
                    return;
            }
        }

        public final boolean SW() {
            if (this.gKi != null) {
                this.gKi.c(this.iNl);
            }
            if (this.iNl == null) {
                w.w("MicroMsg.JsApiGetLocation", "already callback");
                return false;
            }
            this.iNl = null;
            return true;
        }

        private void SX() {
            if (this.iNd != null && this.iNd.get() != null) {
                long currentTimeMillis = System.currentTimeMillis() - this.iNo;
                if (currentTimeMillis < 3000) {
                    ((m) this.iNd.get()).jbY.postDelayed(new Runnable(this) {
                        final /* synthetic */ LocationTask iNp;

                        {
                            this.iNp = r1;
                        }

                        public final void run() {
                            if (this.iNp.iNd.get() != null) {
                                ((m) this.iNp.iNd.get()).qq(null);
                            }
                        }
                    }, 3000 - currentTimeMillis);
                } else {
                    ((m) this.iNd.get()).qq(null);
                }
            }
        }

        public final void SY() {
            if (!(this.iNd == null || this.iNd.get() == null)) {
                ((m) this.iNd.get()).b((b) this);
            }
            SX();
            this.iNn = 2;
            AppBrandMainProcessService.a((MainProcessTask) this);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.iNf);
            parcel.writeByte(this.iNg ? (byte) 1 : (byte) 0);
            parcel.writeFloat(this.iNh);
            parcel.writeFloat(this.iNi);
            parcel.writeDouble(this.aKj);
            parcel.writeDouble(this.aKh);
            parcel.writeDouble(this.aKg);
            parcel.writeDouble(this.iNj);
            parcel.writeDouble(this.iNk);
            parcel.writeInt(this.iNn);
        }

        public final void f(Parcel parcel) {
            super.f(parcel);
            this.iNf = parcel.readString();
            this.iNg = parcel.readByte() != (byte) 0;
            this.iNh = parcel.readFloat();
            this.iNi = parcel.readFloat();
            this.aKj = parcel.readDouble();
            this.aKh = parcel.readDouble();
            this.aKg = parcel.readDouble();
            this.iNj = parcel.readDouble();
            this.iNk = parcel.readDouble();
            this.iNn = parcel.readInt();
        }

        LocationTask() {
        }

        LocationTask(Parcel parcel) {
            f(parcel);
        }
    }

    JsApiGetLocation() {
    }

    static {
        HashSet hashSet = new HashSet();
        iNc = hashSet;
        hashSet.add("gcj02");
        iNc.add("wgs84");
    }

    public final void a(com.tencent.mm.plugin.appbrand.m mVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString(Columns.TYPE, "wgs84");
        w.v("MicroMsg.JsApiGetLocation", "doGeoLocation, geoType = %s", new Object[]{optString});
        if (bg.mA(optString)) {
            optString = "wgs84";
        }
        if (bg.mA(optString) || iNc.contains(optString)) {
            m b = d.b(mVar);
            if (b == null) {
                mVar.x(i, d("fail", null));
                return;
            }
            MainProcessTask locationTask = new LocationTask();
            locationTask.iwq = mVar;
            locationTask.iLf = i;
            locationTask.iNe = this;
            locationTask.iNf = optString;
            locationTask.iNd = new WeakReference(b);
            d.aN(locationTask);
            if (!(locationTask.iNd == null || locationTask.iNd.get() == null)) {
                ((m) locationTask.iNd.get()).a((b) locationTask);
                if (!(locationTask.iNd == null || locationTask.iNd.get() == null)) {
                    ((m) locationTask.iNd.get()).qq(ab.getContext().getString(R.l.dEG));
                    ((m) locationTask.iNd.get()).VS();
                    locationTask.iNo = System.currentTimeMillis();
                }
            }
            locationTask.iNn = 1;
            AppBrandMainProcessService.a(locationTask);
            return;
        }
        w.e("MicroMsg.JsApiGetLocation", "doGeoLocation fail, unsupported type = %s", new Object[]{optString});
        mVar.x(i, d("fail:unsupported type", null));
    }
}
