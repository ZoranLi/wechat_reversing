package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.mm.e.b.dz;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class WxaAttributes extends dz {
    public static final com.tencent.mm.sdk.e.c.a iFJ;
    public static final String iFy;
    private a iFK;
    private b iFL;
    private c iFM;
    private List<WxaEntryInfo> iFN = null;

    public static final class WxaEntryInfo implements Parcelable {
        public static final Creator<WxaEntryInfo> CREATOR = new Creator<WxaEntryInfo>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new WxaEntryInfo(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WxaEntryInfo[i];
            }
        };
        public String hvx;
        public String iconUrl;
        public String title;
        public String username;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.username);
            parcel.writeString(this.title);
            parcel.writeString(this.hvx);
            parcel.writeString(this.iconUrl);
        }

        protected WxaEntryInfo(Parcel parcel) {
            this.username = parcel.readString();
            this.title = parcel.readString();
            this.hvx = parcel.readString();
            this.iconUrl = parcel.readString();
        }
    }

    public static final class a {
        public long iCb = 0;
        public String iFO;
        public int iFP = 0;
        public List<String> iFQ;
        public List<String> iFR;
        public List<String> iFS;
        public List<String> iFT;
        public String iFU;
        public String iFV;
    }

    public static final class b {
        public a iFW = new a();
        public List<Pair<String, String>> iFX;

        public static final class a {
            public int iEU;
            public int iEV;
            public int iEW;
            public int iEX;
            public int iEY;
            public int iFY;
            public int iFZ;
            public boolean iFh;
            public int iFi;
            public int iFj;
            public int iGa;
            public int iGb;
        }
    }

    public static final class c {
        public int fWF;
        public int iGc;
        public String iyA;
    }

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hXH = new Field[18];
        aVar.columns = new String[19];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "usernameHash";
        aVar.uxd.put("usernameHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" usernameHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "usernameHash";
        aVar.columns[1] = "username";
        aVar.uxd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appId";
        aVar.uxd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "nickname";
        aVar.uxd.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "brandIconURL";
        aVar.uxd.put("brandIconURL", "TEXT");
        stringBuilder.append(" brandIconURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "roundedSquareIconURL";
        aVar.uxd.put("roundedSquareIconURL", "TEXT");
        stringBuilder.append(" roundedSquareIconURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "bigHeadURL";
        aVar.uxd.put("bigHeadURL", "TEXT");
        stringBuilder.append(" bigHeadURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "smallHeadURL";
        aVar.uxd.put("smallHeadURL", "TEXT");
        stringBuilder.append(" smallHeadURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "signature";
        aVar.uxd.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "appOpt";
        aVar.uxd.put("appOpt", "INTEGER default '0' ");
        stringBuilder.append(" appOpt INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "registerSource";
        aVar.uxd.put("registerSource", "TEXT");
        stringBuilder.append(" registerSource TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "appInfo";
        aVar.uxd.put("appInfo", "TEXT");
        stringBuilder.append(" appInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "versionInfo";
        aVar.uxd.put("versionInfo", "TEXT");
        stringBuilder.append(" versionInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "bindWxaInfo";
        aVar.uxd.put("bindWxaInfo", "TEXT");
        stringBuilder.append(" bindWxaInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "dynamicInfo";
        aVar.uxd.put("dynamicInfo", "TEXT");
        stringBuilder.append(" dynamicInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "reserved";
        aVar.uxd.put("reserved", "TEXT");
        stringBuilder.append(" reserved TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "syncTimeSecond";
        aVar.uxd.put("syncTimeSecond", "LONG default '0' ");
        stringBuilder.append(" syncTimeSecond LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[17] = "syncVersion";
        aVar.uxd.put("syncVersion", "TEXT");
        stringBuilder.append(" syncVersion TEXT");
        aVar.columns[18] = "rowid";
        aVar.uxe = stringBuilder.toString();
        iFJ = aVar;
        iFy = i.a(aVar, "WxaAttributesTable");
    }

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return iFJ;
    }

    public final a RH() {
        if (this.iFK == null && !bg.mA(this.field_appInfo)) {
            try {
                JSONObject jSONObject = new JSONObject(this.field_appInfo);
                this.iFK = new a();
                JSONObject optJSONObject = jSONObject.optJSONObject("RunningFlagInfo");
                if (optJSONObject != null) {
                    this.iFK.iCb = optJSONObject.optLong("RunningFlag");
                    this.iFK.iFO = optJSONObject.optString("AppOpenForbiddenUrl");
                }
                optJSONObject = jSONObject.optJSONObject("Network");
                if (optJSONObject != null) {
                    this.iFK.iFQ = r.g(optJSONObject.optJSONArray("RequestDomain"));
                    this.iFK.iFR = r.g(optJSONObject.optJSONArray("WsRequestDomain"));
                    this.iFK.iFS = r.g(optJSONObject.optJSONArray("UploadDomain"));
                    this.iFK.iFT = r.g(optJSONObject.optJSONArray("DownloadDomain"));
                }
                this.iFK.iFU = jSONObject.optString("Template");
                this.iFK.iFP = jSONObject.optInt("WechatPluginApp", 0);
                this.iFK.iFV = jSONObject.optString("fromBusinessUsername");
            } catch (Exception e) {
                this.iFK = null;
            }
        }
        return this.iFK;
    }

    public final b RI() {
        int i = 0;
        if (this.iFL == null) {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(this.field_dynamicInfo);
            } catch (Exception e) {
                jSONObject = null;
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            this.iFL = new b();
            JSONObject optJSONObject = jSONObject.optJSONObject("NewSetting");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            this.iFL.iFW.iFY = optJSONObject.optInt("MaxLocalstorageSize", 5);
            this.iFL.iFW.iFZ = optJSONObject.optInt("MaxCodeSize", 5);
            this.iFL.iFW.iEU = optJSONObject.optInt("MaxWebviewDepth", 5);
            this.iFL.iFW.iEV = optJSONObject.optInt("MaxBackgroundLifespan", 600);
            this.iFL.iFW.iEW = optJSONObject.optInt("MaxRequestConcurrent", 5);
            this.iFL.iFW.iEX = optJSONObject.optInt("MaxUploadConcurrent", 5);
            this.iFL.iFW.iEY = optJSONObject.optInt("MaxDownloadConcurrent", 5);
            this.iFL.iFW.iGa = optJSONObject.optInt("MaxFileStorageSize", 10);
            this.iFL.iFW.iGb = optJSONObject.optInt("BackgroundNetworkInterruptedTimeout", 5);
            this.iFL.iFW.iFh = optJSONObject.optInt("CanKeepAliveByAudioPlay", 0) > 0;
            this.iFL.iFW.iFi = optJSONObject.optInt("LifeSpanBeforeSuspend", 5);
            this.iFL.iFW.iFj = optJSONObject.optInt("LifeSpanAfterSuspend", e.CTRL_INDEX);
            JSONArray optJSONArray = jSONObject.optJSONArray("NewCategories");
            if (optJSONArray != null) {
                this.iFL.iFX = new LinkedList();
                while (i < optJSONArray.length()) {
                    optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        this.iFL.iFX.add(new Pair(optJSONObject.optString("first"), optJSONObject.optString("second")));
                    }
                    i++;
                }
            }
        }
        return this.iFL;
    }

    public final c RJ() {
        if (this.iFM == null && !bg.mA(this.field_versionInfo)) {
            try {
                JSONObject jSONObject = new JSONObject(this.field_versionInfo);
                this.iFM = new c();
                this.iFM.fWF = jSONObject.optInt("AppVersion", 0);
                this.iFM.iGc = jSONObject.optInt("VersionState", -1);
                this.iFM.iyA = jSONObject.optString("VersionMD5");
            } catch (Exception e) {
                this.iFM = null;
            }
        }
        return this.iFM;
    }

    public final List<WxaEntryInfo> RK() {
        if (this.iFN == null && !bg.mA(this.field_bindWxaInfo)) {
            try {
                JSONArray optJSONArray = new JSONObject(this.field_bindWxaInfo).optJSONArray("bizEntryInfo");
                if (optJSONArray != null) {
                    this.iFN = new LinkedList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("username");
                            if (!bg.mA(optString)) {
                                WxaEntryInfo wxaEntryInfo = new WxaEntryInfo();
                                wxaEntryInfo.username = optString;
                                wxaEntryInfo.title = optJSONObject.optString("title");
                                wxaEntryInfo.iconUrl = optJSONObject.optString("icon_url");
                                this.iFN.add(wxaEntryInfo);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                this.iFN = null;
            }
        }
        return this.iFN;
    }

    public final String toString() {
        return "WxaAttributes{field_username='" + this.field_username + '\'' + ", field_appId='" + this.field_appId + '\'' + ", field_nickname='" + this.field_nickname + '\'' + ", field_brandIconURL='" + this.field_brandIconURL + '\'' + ", field_roundedSquareIconURL='" + this.field_roundedSquareIconURL + '\'' + ", field_bigHeadURL='" + this.field_bigHeadURL + '\'' + ", field_smallHeadURL='" + this.field_smallHeadURL + '\'' + ", field_signature='" + this.field_signature + '\'' + ", field_appOpt=" + this.field_appOpt + ", field_registerSource='" + this.field_registerSource + '\'' + ", field_appInfo='" + this.field_appInfo + '\'' + ", field_versionInfo='" + this.field_versionInfo + '\'' + ", field_bindWxaInfo='" + this.field_bindWxaInfo + '\'' + ", field_dynamicInfo='" + this.field_dynamicInfo + '\'' + '}';
    }
}
