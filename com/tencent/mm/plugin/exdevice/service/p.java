package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface p extends IInterface {

    public static abstract class a extends Binder implements p {

        private static class a implements p {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final o apR() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    o M = com.tencent.mm.plugin.exdevice.service.o.a.M(obtain2.readStrongBinder());
                    return M;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final l apS() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    l L = com.tencent.mm.plugin.exdevice.service.l.a.L(obtain2.readStrongBinder());
                    return L;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
        }

        public static p N(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof p)) {
                return new a(iBinder);
            }
            return (p) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder = null;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    o apR = apR();
                    parcel2.writeNoException();
                    if (apR != null) {
                        iBinder = apR.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    l apS = apS();
                    parcel2.writeNoException();
                    if (apS != null) {
                        iBinder = apS.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    o apR();

    l apS();
}
