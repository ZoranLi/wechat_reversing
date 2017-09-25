package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mm.protocal.g;
import com.tencent.mm.protocal.h;

public interface q extends IInterface {

    public static abstract class a extends Binder implements q {

        private static class a implements q {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final int getType() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String getUri() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final h Cn() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    h Z = com.tencent.mm.protocal.h.a.Z(obtain2.readStrongBinder());
                    return Z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final g Cm() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    g Y = com.tencent.mm.protocal.g.a.Y(obtain2.readStrongBinder());
                    return Y;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(i iVar, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    obtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int BM() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean BH() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    this.mRemote.transact(7, obtain, obtain2, 0);
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

            public final int BD() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void hz(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(i iVar, int i, int i2, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    obtain.writeStrongBinder(iVar != null ? iVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(d dVar, i iVar, int i, int i2) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    if (iVar != null) {
                        iBinder = iVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int Co() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IReqResp_AIDL");
                    this.mRemote.transact(12, obtain, obtain2, 0);
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
            attachInterface(this, "com.tencent.mm.network.IReqResp_AIDL");
        }

        public static q F(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.network.IReqResp_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof q)) {
                return new a(iBinder);
            }
            return (q) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder = null;
            int type;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    type = getType();
                    parcel2.writeNoException();
                    parcel2.writeInt(type);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    String uri = getUri();
                    parcel2.writeNoException();
                    parcel2.writeString(uri);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    h Cn = Cn();
                    parcel2.writeNoException();
                    if (Cn != null) {
                        iBinder = Cn.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    g Cm = Cm();
                    parcel2.writeNoException();
                    if (Cm != null) {
                        iBinder = Cm.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    a(com.tencent.mm.network.i.a.D(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    type = BM();
                    parcel2.writeNoException();
                    parcel2.writeInt(type);
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    boolean BH = BH();
                    parcel2.writeNoException();
                    parcel2.writeInt(BH ? 1 : 0);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    type = BD();
                    parcel2.writeNoException();
                    parcel2.writeInt(type);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    hz(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    a(com.tencent.mm.network.i.a.D(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    a(com.tencent.mm.network.d.a.A(parcel.readStrongBinder()), com.tencent.mm.network.i.a.D(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.network.IReqResp_AIDL");
                    type = Co();
                    parcel2.writeNoException();
                    parcel2.writeInt(type);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.IReqResp_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    int BD();

    boolean BH();

    int BM();

    g Cm();

    h Cn();

    int Co();

    void a(d dVar, i iVar, int i, int i2);

    void a(i iVar, int i, int i2);

    void a(i iVar, int i, int i2, String str);

    int getType();

    String getUri();

    void hz(String str);
}
