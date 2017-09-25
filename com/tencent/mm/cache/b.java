package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface b extends IInterface {

    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "com.tencent.mm.cache.IMMCache_AIDL");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            Bitmap bitmap;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.cache.IMMCache_AIDL");
                    cZ(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.cache.IMMCache_AIDL");
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        MCacheItem.CREATOR.createFromParcel(parcel);
                    }
                    da(readString);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.cache.IMMCache_AIDL");
                    bitmap = getBitmap(parcel.readString());
                    parcel2.writeNoException();
                    if (bitmap != null) {
                        parcel2.writeInt(1);
                        bitmap.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.cache.IMMCache_AIDL");
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bitmap = (Bitmap) Bitmap.CREATOR.createFromParcel(parcel);
                    } else {
                        bitmap = null;
                    }
                    a(readString2, bitmap);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.cache.IMMCache_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void a(String str, Bitmap bitmap);

    MCacheItem cZ(String str);

    void da(String str);

    Bitmap getBitmap(String str);
}
