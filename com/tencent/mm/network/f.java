package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mm.network.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.protocal.ab;
import java.util.ArrayList;
import java.util.List;

public interface f extends IInterface {

    public static abstract class a extends Binder implements f {

        private static class a implements f {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final int a(q qVar, k kVar) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(qVar != null ? qVar.asBinder() : null);
                    if (kVar != null) {
                        iBinder = kVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void cancel(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final d Mp() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    d A = com.tencent.mm.network.d.a.A(obtain2.readStrongBinder());
                    return A;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void reset() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(ab abVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(abVar != null ? abVar.asBinder() : null);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4) {
                int i3 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i3 = 1;
                    }
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeIntArray(iArr);
                    obtain.writeIntArray(iArr2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String[] getIPsString(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    String[] createStringArray = obtain2.createStringArray();
                    return createStringArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String getNetworkServerIp() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void aZ(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void d(String str, String str2, String str3, String str4) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void setNewDnsDebugHost(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void Mq() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean BS() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(13, obtain, obtain2, 0);
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

            public final void a(b bVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void hv(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final h Mr() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    h C = com.tencent.mm.network.h.a.C(obtain2.readStrongBinder());
                    return C;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int getHostByName(String str, List<String> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readStringList(list);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int a(boolean z, List<String> list) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    i = obtain2.readInt();
                    obtain2.readStringList(list);
                    return i;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int a(String str, boolean z, List<String> list) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    i = obtain2.readInt();
                    obtain2.readStringList(list);
                    return i;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void reportFailIp(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void setHostInfo(String[] strArr, String[] strArr2, int[] iArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStringArray(strArr);
                    obtain.writeStringArray(strArr2);
                    obtain.writeIntArray(iArr);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i, String str, int i2, boolean z) {
                int i3 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    if (z) {
                        i3 = 1;
                    }
                    obtain.writeInt(i3);
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void Ce() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String getIspId() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int g(int i, byte[] bArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void setSignallingStrategy(long j, long j2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.mRemote.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void keepSignalling() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void stopSignalling() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    this.mRemote.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(n nVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(nVar != null ? nVar.asBinder() : null);
                    this.mRemote.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(r rVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(rVar != null ? rVar.asBinder() : null);
                    this.mRemote.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(g gVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeStrongBinder(gVar != null ? gVar.asBinder() : null);
                    this.mRemote.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void hw(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void ba(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void bb(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void bc(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.network.IDispatcher_AIDL");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.network.IDispatcher_AIDL");
        }

        public static f B(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.network.IDispatcher_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof f)) {
                return new a(iBinder);
            }
            return (f) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            g gVar = null;
            boolean z = false;
            IInterface queryLocalInterface;
            int a;
            IBinder asBinder;
            IBinder readStrongBinder;
            String networkServerIp;
            int i3;
            switch (i) {
                case 1:
                    k aVar;
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    q F = com.tencent.mm.network.q.a.F(parcel.readStrongBinder());
                    IBinder readStrongBinder2 = parcel.readStrongBinder();
                    if (readStrongBinder2 != null) {
                        queryLocalInterface = readStrongBinder2.queryLocalInterface("com.tencent.mm.network.IOnGYNetEnd_AIDL");
                        aVar = (queryLocalInterface == null || !(queryLocalInterface instanceof k)) ? new a(readStrongBinder2) : (k) queryLocalInterface;
                    }
                    a = a(F, aVar);
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    cancel(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    d Mp = Mp();
                    parcel2.writeNoException();
                    if (Mp != null) {
                        asBinder = Mp.asBinder();
                    }
                    parcel2.writeStrongBinder(asBinder);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    reset();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    ab aVar2;
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.protocal.MMSyncCheckCoder_AIDL");
                        aVar2 = (queryLocalInterface == null || !(queryLocalInterface instanceof ab)) ? new a(readStrongBinder) : (ab) queryLocalInterface;
                    }
                    a(aVar2);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    a(z, parcel.readString(), parcel.readString(), parcel.createIntArray(), parcel.createIntArray(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    String[] iPsString = getIPsString(z);
                    parcel2.writeNoException();
                    parcel2.writeStringArray(iPsString);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    networkServerIp = getNetworkServerIp();
                    parcel2.writeNoException();
                    parcel2.writeString(networkServerIp);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    aZ(z);
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    d(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    setNewDnsDebugHost(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    Mq();
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    boolean BS = BS();
                    parcel2.writeNoException();
                    if (BS) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 14:
                    b aVar3;
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.network.connpool.IConnPoolMoniter_AIDL");
                        aVar3 = (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new a(readStrongBinder) : (b) queryLocalInterface;
                    }
                    a(aVar3);
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    hv(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    h Mr = Mr();
                    parcel2.writeNoException();
                    if (Mr != null) {
                        asBinder = Mr.asBinder();
                    }
                    parcel2.writeStrongBinder(asBinder);
                    return true;
                case 17:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    networkServerIp = parcel.readString();
                    List arrayList = new ArrayList();
                    a = getHostByName(networkServerIp, arrayList);
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    parcel2.writeStringList(arrayList);
                    return true;
                case 18:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    List arrayList2 = new ArrayList();
                    i3 = a(z, arrayList2);
                    parcel2.writeNoException();
                    parcel2.writeInt(i3);
                    parcel2.writeStringList(arrayList2);
                    return true;
                case 19:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    networkServerIp = parcel.readString();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    List arrayList3 = new ArrayList();
                    a = a(networkServerIp, z, arrayList3);
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    parcel2.writeStringList(arrayList3);
                    return true;
                case 20:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    reportFailIp(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    setHostInfo(parcel.createStringArray(), parcel.createStringArray(), parcel.createIntArray());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    a = parcel.readInt();
                    String readString = parcel.readString();
                    int readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    a(a, readString, readInt, z);
                    parcel2.writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    Ce();
                    parcel2.writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    networkServerIp = getIspId();
                    parcel2.writeNoException();
                    parcel2.writeString(networkServerIp);
                    return true;
                case 25:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    a = g(parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 26:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    setSignallingStrategy(parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    keepSignalling();
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    stopSignalling();
                    parcel2.writeNoException();
                    return true;
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                    n aVar4;
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.network.IOnReportKV_AIDL");
                        aVar4 = (queryLocalInterface == null || !(queryLocalInterface instanceof n)) ? new a(readStrongBinder) : (n) queryLocalInterface;
                    }
                    a(aVar4);
                    parcel2.writeNoException();
                    return true;
                case 30:
                    r aVar5;
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.network.IWorkerCallback_AIDL");
                        aVar5 = (queryLocalInterface == null || !(queryLocalInterface instanceof r)) ? new a(readStrongBinder) : (r) queryLocalInterface;
                    }
                    a(aVar5);
                    parcel2.writeNoException();
                    return true;
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    readStrongBinder = parcel.readStrongBinder();
                    if (readStrongBinder != null) {
                        queryLocalInterface = readStrongBinder.queryLocalInterface("com.tencent.mm.network.IIpxxCallback_AIDL");
                        gVar = (queryLocalInterface == null || !(queryLocalInterface instanceof g)) ? new a(readStrongBinder) : (g) queryLocalInterface;
                    }
                    a(gVar);
                    parcel2.writeNoException();
                    return true;
                case 32:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    hw(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    ba(z);
                    parcel2.writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    bb(z);
                    parcel2.writeNoException();
                    return true;
                case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                    parcel.enforceInterface("com.tencent.mm.network.IDispatcher_AIDL");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    bc(z);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.network.IDispatcher_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean BS();

    void Ce();

    d Mp();

    void Mq();

    h Mr();

    int a(q qVar, k kVar);

    int a(String str, boolean z, List<String> list);

    int a(boolean z, List<String> list);

    void a(int i, String str, int i2, boolean z);

    void a(b bVar);

    void a(g gVar);

    void a(n nVar);

    void a(r rVar);

    void a(ab abVar);

    void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4);

    void aZ(boolean z);

    void ba(boolean z);

    void bb(boolean z);

    void bc(boolean z);

    void cancel(int i);

    void d(String str, String str2, String str3, String str4);

    int g(int i, byte[] bArr);

    int getHostByName(String str, List<String> list);

    String[] getIPsString(boolean z);

    String getIspId();

    String getNetworkServerIp();

    void hv(String str);

    void hw(String str);

    void keepSignalling();

    void reportFailIp(String str);

    void reset();

    void setHostInfo(String[] strArr, String[] strArr2, int[] iArr);

    void setNewDnsDebugHost(String str, String str2);

    void setSignallingStrategy(long j, long j2);

    void stopSignalling();
}
