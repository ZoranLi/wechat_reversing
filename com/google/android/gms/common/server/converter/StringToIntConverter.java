package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter implements SafeParcelable, a<String, Integer> {
    public static final b CREATOR = new b();
    final HashMap<String, Integer> aro;
    private final HashMap<Integer, String> arp;
    private final ArrayList<Entry> arq;
    final int mVersionCode;

    public static final class Entry implements SafeParcelable {
        public static final c CREATOR = new c();
        final String arr;
        final int ars;
        final int versionCode;

        Entry(int i, String str, int i2) {
            this.versionCode = i;
            this.arr = str;
            this.ars = i2;
        }

        Entry(String str, int i) {
            this.versionCode = 1;
            this.arr = str;
            this.ars = i;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            c.a(this, parcel);
        }
    }

    public StringToIntConverter() {
        this.mVersionCode = 1;
        this.aro = new HashMap();
        this.arp = new HashMap();
        this.arq = null;
    }

    StringToIntConverter(int i, ArrayList<Entry> arrayList) {
        this.mVersionCode = i;
        this.aro = new HashMap();
        this.arp = new HashMap();
        this.arq = null;
        b(arrayList);
    }

    private void b(ArrayList<Entry> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String str = entry.arr;
            int i = entry.ars;
            this.aro.put(str, Integer.valueOf(i));
            this.arp.put(Integer.valueOf(i), str);
        }
    }

    public final /* synthetic */ Object convertBack(Object obj) {
        String str = (String) this.arp.get((Integer) obj);
        return (str == null && this.aro.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel);
    }
}
