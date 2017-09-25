package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.mm.bd.a;
import com.tencent.mm.protocal.c.bjl;
import com.tencent.mm.protocal.c.cq;
import com.tencent.mm.protocal.c.cw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public enum SysConfigUtil {
    ;

    private static final class StringPair extends Pair<String, String> implements Parcelable {
        public static final Creator<StringPair> CREATOR = null;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString((String) this.first);
            parcel.writeString((String) this.second);
        }

        StringPair(Parcel parcel) {
            super(parcel.readString(), parcel.readString());
        }

        static {
            CREATOR = new Creator<StringPair>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return new StringPair(parcel);
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new StringPair[i];
                }
            };
        }
    }

    public static <T extends a> boolean a(T t, T t2) {
        boolean z = false;
        if (t == null && t2 == null) {
            throw new IllegalArgumentException("both null!!!");
        }
        if (!(t == null || t2 == null)) {
            try {
                z = bg.isEqual(t.toByteArray(), t2.toByteArray());
            } catch (Exception e) {
            }
        }
        return z;
    }

    static cq e(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("AppConfig");
        cq cqVar = new cq();
        if (optJSONObject != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("VersionList");
            cqVar.tfK = new LinkedList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    bjl com_tencent_mm_protocal_c_bjl = new bjl();
                    com_tencent_mm_protocal_c_bjl.type = optJSONObject2.optInt(Columns.TYPE);
                    com_tencent_mm_protocal_c_bjl.version = optJSONObject2.optInt("version");
                    cqVar.tfK.add(com_tencent_mm_protocal_c_bjl);
                }
            }
        }
        return cqVar;
    }

    static String a(cw cwVar) {
        if (cwVar == null) {
            return "AppRunningFlagInfo{null}";
        }
        return "AppRunningFlagInfo{RunningFlag=" + cwVar.tgd + ", StopServiceTime" + cwVar.tge + ", AppForbiddenReason" + cwVar.tgf + ", SessionOpenForbiddenReason" + cwVar.tgg + ", TimelineOpenForbiddenReason" + cwVar.tgh + "}";
    }

    public static <L extends List<T>, T> L e(L l, List<T> list) {
        if (list != null) {
            l.addAll(list);
        }
        return l;
    }
}
