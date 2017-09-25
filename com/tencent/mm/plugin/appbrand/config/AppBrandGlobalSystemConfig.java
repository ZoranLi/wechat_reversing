package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.pluginsdk.k.a.b.b;
import com.tencent.mm.pluginsdk.k.a.b.b.c;
import com.tencent.mm.pluginsdk.k.a.b.i;
import com.tencent.mm.pluginsdk.k.a.d.q;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AppBrandGlobalSystemConfig implements Parcelable {
    public static final Creator<AppBrandGlobalSystemConfig> CREATOR = new Creator<AppBrandGlobalSystemConfig>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandGlobalSystemConfig(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandGlobalSystemConfig[i];
        }
    };
    private static volatile AppBrandGlobalSystemConfig iEl;
    public static final AppBrandGlobalSystemConfig iEm;
    public int iEn = Integer.MAX_VALUE;
    public int iEo;
    public int iEp;
    public int iEq;
    public int iEr;
    public String iEs;
    public HttpSetting iEt;
    public int[] iEu;
    public int iEv;
    public int iEw;
    public int iEx;
    public int iEy;

    public static final class HttpSetting implements Parcelable {
        public static final Creator<HttpSetting> CREATOR = new Creator<HttpSetting>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new HttpSetting(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new HttpSetting[i];
            }
        };
        public ArrayList<String> iEA;
        public ArrayList<String> iEB;
        public int iEC;
        public int iED;
        public int iEE;
        public int iEF;
        public String iEG;
        public int mode;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mode);
            parcel.writeStringList(this.iEA);
            parcel.writeStringList(this.iEB);
            parcel.writeInt(this.iEC);
            parcel.writeInt(this.iED);
            parcel.writeInt(this.iEE);
            parcel.writeInt(this.iEF);
            parcel.writeString(this.iEG);
        }

        HttpSetting(Parcel parcel) {
            this.mode = parcel.readInt();
            this.iEA = parcel.createStringArrayList();
            this.iEB = parcel.createStringArrayList();
            this.iEC = parcel.readInt();
            this.iED = parcel.readInt();
            this.iEE = parcel.readInt();
            this.iEF = parcel.readInt();
            this.iEG = parcel.readString();
        }
    }

    public interface a {
        public static final int[] iEz = new int[0];
    }

    static {
        AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
        iEm = appBrandGlobalSystemConfig;
        appBrandGlobalSystemConfig.iEo = 5;
        iEm.iEp = e.CTRL_INDEX;
        iEm.iEq = 10;
        iEm.iEr = 1048576;
        iEm.iEu = a.iEz;
        iEm.iEv = 10;
        iEm.iEw = 1800;
        iEm.iEx = 307200;
        iEm.iEy = 25;
    }

    static synchronized void Rx() {
        synchronized (AppBrandGlobalSystemConfig.class) {
            iEl = null;
        }
    }

    private static synchronized AppBrandGlobalSystemConfig Ry() {
        AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = null;
        int i = 0;
        synchronized (AppBrandGlobalSystemConfig.class) {
            if (iEl == null) {
                String aT;
                try {
                    aT = com.tencent.mm.a.e.aT(d.RA());
                } catch (FileNotFoundException e) {
                    b bVar = c.sFE;
                    b bVar2 = c.sFE;
                    r6 = com.tencent.mm.pluginsdk.k.a.d.o.a.sGQ.Mu(i.dG(38, 1));
                    q Mu;
                    if (Mu != null) {
                        i = bg.getInt(Mu.field_fileVersion, 0);
                    }
                    bVar.e(38, 1, i, false);
                    aT = null;
                } catch (IOException e2) {
                    w.e("MicroMsg.AppBrandGlobalSystemConfig", "read config file, exp = %s", new Object[]{e2});
                    aT = null;
                }
                if (!bg.mA(aT)) {
                    iEl = od(aT);
                }
            }
            appBrandGlobalSystemConfig = iEl;
        }
        return appBrandGlobalSystemConfig;
    }

    public static AppBrandGlobalSystemConfig Rz() {
        AppBrandGlobalSystemConfig Ry = Ry();
        return Ry == null ? iEm : Ry;
    }

    private static AppBrandGlobalSystemConfig od(String str) {
        w.d("MicroMsg.AppBrandGlobalSystemConfig", "parse json = %s", new Object[]{str});
        try {
            int i;
            JSONObject jSONObject = new JSONObject(str);
            AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
            JSONObject optJSONObject = jSONObject.optJSONObject("HTTPSetting");
            if (optJSONObject != null) {
                appBrandGlobalSystemConfig.iEt = new HttpSetting();
                String optString = optJSONObject.optString("HTTPHeaderMode", "");
                if (optString.equals("BlackList")) {
                    appBrandGlobalSystemConfig.iEt.mode = 1;
                } else if (optString.equals("WhiteList")) {
                    appBrandGlobalSystemConfig.iEt.mode = 2;
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("HeaderBlackList");
                if (optJSONArray != null) {
                    appBrandGlobalSystemConfig.iEt.iEA = new ArrayList();
                    for (i = 0; i < optJSONArray.length(); i++) {
                        appBrandGlobalSystemConfig.iEt.iEA.add(optJSONArray.getString(i));
                    }
                }
                optJSONArray = optJSONObject.optJSONArray("HeaderWhiteList");
                if (optJSONArray != null) {
                    appBrandGlobalSystemConfig.iEt.iEB = new ArrayList();
                    for (i = 0; i < optJSONArray.length(); i++) {
                        appBrandGlobalSystemConfig.iEt.iEB.add(optJSONArray.getString(i));
                    }
                }
                appBrandGlobalSystemConfig.iEt.iEC = optJSONObject.optInt("WebsocketMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.iEt.iED = optJSONObject.optInt("UploadMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.iEt.iEE = optJSONObject.optInt("DownloadMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.iEt.iEF = optJSONObject.optInt("RequestMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.iEt.iEG = optJSONObject.optString("HTTPHeaderReferer");
            }
            appBrandGlobalSystemConfig.iEs = jSONObject.optString("CDNBaseURL");
            appBrandGlobalSystemConfig.iEo = jSONObject.optInt("AppMaxRunningCount", 5);
            appBrandGlobalSystemConfig.iEp = jSONObject.optInt("TempFileSizeLimitTotal", e.CTRL_INDEX);
            appBrandGlobalSystemConfig.iEq = jSONObject.optInt("DownloadFileSizeLimit", 10);
            appBrandGlobalSystemConfig.iEr = jSONObject.optInt("MaxLocalStorageItemSize", 1048576);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("SyncLaunchSceneList");
            if (optJSONArray2 != null) {
                appBrandGlobalSystemConfig.iEu = new int[optJSONArray2.length()];
                for (i = 0; i < optJSONArray2.length(); i++) {
                    appBrandGlobalSystemConfig.iEu[i] = optJSONArray2.optInt(i, 0);
                }
            }
            if (appBrandGlobalSystemConfig.iEu == null) {
                appBrandGlobalSystemConfig.iEu = a.iEz;
            }
            appBrandGlobalSystemConfig.iEv = jSONObject.optInt("StarNumberLimitation", 10);
            appBrandGlobalSystemConfig.iEw = jSONObject.optInt("WidgetImageFlowLimitDuration", 1800);
            appBrandGlobalSystemConfig.iEx = jSONObject.optInt("WidgetImageFlowLimitMaxSize", 307200);
            appBrandGlobalSystemConfig.iEy = jSONObject.optInt("WidgetDrawMinInterval", 25);
            return appBrandGlobalSystemConfig;
        } catch (Throwable e) {
            w.e("MicroMsg.AppBrandGlobalSystemConfig", "parse exception = %s", new Object[]{bg.g(e)});
            return null;
        }
    }

    private AppBrandGlobalSystemConfig() {
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.iEn);
        parcel.writeInt(this.iEo);
        parcel.writeInt(this.iEp);
        parcel.writeInt(this.iEq);
        parcel.writeInt(this.iEr);
        parcel.writeString(this.iEs);
        parcel.writeParcelable(this.iEt, i);
        parcel.writeIntArray(this.iEu);
    }

    public AppBrandGlobalSystemConfig(Parcel parcel) {
        this.iEn = parcel.readInt();
        this.iEo = parcel.readInt();
        this.iEp = parcel.readInt();
        this.iEq = parcel.readInt();
        this.iEr = parcel.readInt();
        this.iEs = parcel.readString();
        this.iEt = (HttpSetting) parcel.readParcelable(HttpSetting.class.getClassLoader());
        this.iEu = parcel.createIntArray();
    }
}
