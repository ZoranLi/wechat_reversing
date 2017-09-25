package com.tencent.mm.plugin.sport.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface a extends IInterface {

    public static abstract class a extends Binder implements a {

        private static class a implements a {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final long bmi() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void Hh(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void bmj() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void D(int i, long j) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final long getLong(int i, long j) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void bmk() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
        }

        public static a Q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof a)) {
                return new a(iBinder);
            }
            return (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            long bmi;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
                    bmi = bmi();
                    parcel2.writeNoException();
                    parcel2.writeLong(bmi);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
                    Hh(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
                    bmj();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
                    D(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
                    bmi = getLong(parcel.readInt(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeLong(bmi);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
                    bmk();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.sport.aidl.ISport_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void D(int i, long j);

    void Hh(String str);

    long bmi();

    void bmj();

    void bmk();

    long getLong(int i, long j);
}
