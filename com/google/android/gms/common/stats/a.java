package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public final class a implements Creator<ConnectionEvent> {
    static void a(ConnectionEvent connectionEvent, Parcel parcel) {
        int t = b.t(parcel, 20293);
        b.c(parcel, 1, connectionEvent.mVersionCode);
        b.a(parcel, 2, connectionEvent.arN);
        b.a(parcel, 4, connectionEvent.arP);
        b.a(parcel, 5, connectionEvent.arQ);
        b.a(parcel, 6, connectionEvent.arR);
        b.a(parcel, 7, connectionEvent.arS);
        b.a(parcel, 8, connectionEvent.arT);
        b.a(parcel, 10, connectionEvent.arV);
        b.a(parcel, 11, connectionEvent.arW);
        b.c(parcel, 12, connectionEvent.arO);
        b.a(parcel, 13, connectionEvent.arU);
        b.u(parcel, t);
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int i = 0;
        long j = 0;
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        long j2 = 0;
        long j3 = 0;
        while (parcel.dataPosition() < b) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.a.f(parcel, readInt);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 7:
                    str4 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 8:
                    str5 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                case 10:
                    j2 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, readInt);
                    break;
                case 11:
                    j3 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, readInt);
                    break;
                case 12:
                    i2 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
                    break;
                case 13:
                    str6 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, readInt);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new ConnectionEvent(i, j, i2, str, str2, str3, str4, str5, str6, j2, j3);
        }
        throw new com.google.android.gms.common.internal.safeparcel.a.a("Overread allowed size end=" + b, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ConnectionEvent[i];
    }
}
