package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FieldMappingDictionary implements SafeParcelable {
    public static final c CREATOR = new c();
    final HashMap<String, Map<String, Field<?, ?>>> arD;
    private final ArrayList<Entry> arE = null;
    final String arF;
    final int mVersionCode;

    public static class Entry implements SafeParcelable {
        public static final d CREATOR = new d();
        final ArrayList<FieldMapPair> arG;
        final String className;
        final int versionCode;

        Entry(int i, String str, ArrayList<FieldMapPair> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.arG = arrayList;
        }

        Entry(String str, Map<String, Field<?, ?>> map) {
            this.versionCode = 1;
            this.className = str;
            this.arG = b(map);
        }

        private static ArrayList<FieldMapPair> b(Map<String, Field<?, ?>> map) {
            if (map == null) {
                return null;
            }
            ArrayList<FieldMapPair> arrayList = new ArrayList();
            for (String str : map.keySet()) {
                arrayList.add(new FieldMapPair(str, (Field) map.get(str)));
            }
            return arrayList;
        }

        public int describeContents() {
            return 0;
        }

        final HashMap<String, Field<?, ?>> ku() {
            HashMap<String, Field<?, ?>> hashMap = new HashMap();
            int size = this.arG.size();
            for (int i = 0; i < size; i++) {
                FieldMapPair fieldMapPair = (FieldMapPair) this.arG.get(i);
                hashMap.put(fieldMapPair.arH, fieldMapPair.arI);
            }
            return hashMap;
        }

        public void writeToParcel(Parcel parcel, int i) {
            d.a(this, parcel);
        }
    }

    public static class FieldMapPair implements SafeParcelable {
        public static final b CREATOR = new b();
        final String arH;
        final Field<?, ?> arI;
        final int versionCode;

        FieldMapPair(int i, String str, Field<?, ?> field) {
            this.versionCode = i;
            this.arH = str;
            this.arI = field;
        }

        FieldMapPair(String str, Field<?, ?> field) {
            this.versionCode = 1;
            this.arH = str;
            this.arI = field;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            b.a(this, parcel, i);
        }
    }

    FieldMappingDictionary(int i, ArrayList<Entry> arrayList, String str) {
        this.mVersionCode = i;
        this.arD = c(arrayList);
        this.arF = (String) w.Z(str);
        kt();
    }

    private static HashMap<String, Map<String, Field<?, ?>>> c(ArrayList<Entry> arrayList) {
        HashMap<String, Map<String, Field<?, ?>>> hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = (Entry) arrayList.get(i);
            hashMap.put(entry.className, entry.ku());
        }
        return hashMap;
    }

    private void kt() {
        for (String str : this.arD.keySet()) {
            Map map = (Map) this.arD.get(str);
            for (String str2 : map.keySet()) {
                ((Field) map.get(str2)).arB = this;
            }
        }
    }

    public final Map<String, Field<?, ?>> X(String str) {
        return (Map) this.arD.get(str);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.arD.keySet()) {
            stringBuilder.append(str).append(":\n");
            Map map = (Map) this.arD.get(str);
            for (String str2 : map.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(map.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        c.a(this, parcel);
    }
}
