package com.tencent.mm.protocal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface g extends IInterface {

    public static abstract class a extends Binder implements g {

        private static class a implements g {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final boolean a(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, boolean z) {
                boolean z2 = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    obtain.writeByteArray(bArr2);
                    obtain.writeByteArray(bArr3);
                    obtain.writeInt(i2);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final byte[] Cf() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void B(byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final byte[] vc() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void dj(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int uH() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void fr(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int getClientVersion() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void hx(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String Cg() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String Ch() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void hy(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void fs(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int Ci() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final byte[] Cj() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    byte[] createByteArray = obtain2.createByteArray();
                    return createByteArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String getUserName() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String getPassword() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String Ck() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int getCmdId() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean Cl() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    this.mRemote.transact(20, obtain, obtain2, 0);
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
        }

        public a() {
            attachInterface(this, "com.tencent.mm.protocal.IMMBaseReq_AIDL");
        }

        public static g Y(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof g)) {
                return new a(iBinder);
            }
            return (g) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            boolean a;
            byte[] Cf;
            int uH;
            String Cg;
            switch (i) {
                case 1:
                    boolean z;
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    int readInt = parcel.readInt();
                    byte[] createByteArray = parcel.createByteArray();
                    byte[] createByteArray2 = parcel.createByteArray();
                    byte[] createByteArray3 = parcel.createByteArray();
                    int readInt2 = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    a = a(readInt, createByteArray, createByteArray2, createByteArray3, readInt2, z);
                    parcel2.writeNoException();
                    if (a) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    Cf = Cf();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(Cf);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    B(parcel.createByteArray());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    Cf = vc();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(Cf);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    dj(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    uH = uH();
                    parcel2.writeNoException();
                    parcel2.writeInt(uH);
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    fr(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    uH = getClientVersion();
                    parcel2.writeNoException();
                    parcel2.writeInt(uH);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    hx(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    Cg = Cg();
                    parcel2.writeNoException();
                    parcel2.writeString(Cg);
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    Cg = Ch();
                    parcel2.writeNoException();
                    parcel2.writeString(Cg);
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    hy(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    fs(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    uH = Ci();
                    parcel2.writeNoException();
                    parcel2.writeInt(uH);
                    return true;
                case 15:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    Cf = Cj();
                    parcel2.writeNoException();
                    parcel2.writeByteArray(Cf);
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    Cg = getUserName();
                    parcel2.writeNoException();
                    parcel2.writeString(Cg);
                    return true;
                case 17:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    Cg = getPassword();
                    parcel2.writeNoException();
                    parcel2.writeString(Cg);
                    return true;
                case 18:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    Cg = Ck();
                    parcel2.writeNoException();
                    parcel2.writeString(Cg);
                    return true;
                case 19:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    uH = getCmdId();
                    parcel2.writeNoException();
                    parcel2.writeInt(uH);
                    return true;
                case 20:
                    parcel.enforceInterface("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    a = Cl();
                    parcel2.writeNoException();
                    if (a) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.protocal.IMMBaseReq_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void B(byte[] bArr);

    byte[] Cf();

    String Cg();

    String Ch();

    int Ci();

    byte[] Cj();

    String Ck();

    boolean Cl();

    boolean a(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, boolean z);

    void dj(int i);

    void fr(int i);

    void fs(int i);

    int getClientVersion();

    int getCmdId();

    String getPassword();

    String getUserName();

    void hx(String str);

    void hy(String str);

    int uH();

    byte[] vc();
}
