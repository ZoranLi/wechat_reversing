package com.tencent.mm.plugin.webview.stub;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        private static class a implements b {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final boolean bxg() {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean getResult() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int getRet() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int getType() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
        }

        public static b U(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof b)) {
                return new a(iBinder);
            }
            return (b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            boolean bxg;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    bxg = bxg();
                    parcel2.writeNoException();
                    if (bxg) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    bxg = getResult();
                    parcel2.writeNoException();
                    if (bxg) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    i3 = getRet();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    i3 = getType();
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.webview.stub.FavUrl_Result_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean bxg();

    boolean getResult();

    int getRet();

    int getType();
}
