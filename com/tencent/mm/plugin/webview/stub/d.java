package com.tencent.mm.plugin.webview.stub;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.bl;
import com.tencent.mm.plugin.appbrand.jsapi.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.wcdb.FileUtils;
import java.util.List;
import java.util.Map;

public interface d extends IInterface {

    public static abstract class a extends Binder implements d {

        private static class a implements d {
            private IBinder mRemote;

            a(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public final IBinder asBinder() {
                return this.mRemote;
            }

            public final boolean Jt(String str) {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
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

            public final String eK(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean eU(String str) {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
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

            public final boolean fE(String str) {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
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

            public final boolean eV(String str) {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
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

            public final String Jp(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean rZ() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
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

            public final boolean isSDCardAvailable() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(8, obtain, obtain2, 0);
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

            public final boolean azg() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(9, obtain, obtain2, 0);
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

            public final boolean ys() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(10, obtain, obtain2, 0);
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

            public final int dw(int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void dx(int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String aw(int i, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(int i, Bundle bundle, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i2);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final b P(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    b U = com.tencent.mm.plugin.webview.stub.b.a.U(obtain2.readStrongBinder());
                    return U;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean Q(Bundle bundle) {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(16, obtain, obtain2, 0);
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

            public final int Jw(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void favEditTag() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean q(int i, Bundle bundle) {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(19, obtain, obtain2, 0);
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

            public final boolean q(long j, String str) {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeLong(j);
                    obtain.writeString(str);
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

            public final void Jx(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean Dw() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(22, obtain, obtain2, 0);
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

            public final List<String> Dv() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    List<String> createStringArrayList = obtain2.createStringArrayList();
                    return createStringArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void f(int i, List<String> list) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    obtain.writeStringList(list);
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean a(String str, boolean z, Bundle bundle) {
                boolean z2 = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(25, obtain, obtain2, 0);
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

            public final String Jq(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void ca(String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void ay(String str, boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean bu(String str) {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(29, obtain, obtain2, 0);
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

            public final void p(int i, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final Bundle l(int i, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    Bundle bundle2;
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle2 = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void i(String str, boolean z, int i) {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    obtain.writeInt(i);
                    this.mRemote.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final Bundle vZ(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    Bundle bundle;
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean wa(int i) {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(34, obtain, obtain2, 0);
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

            public final boolean a(String str, String str2, String str3, Bundle bundle, Bundle bundle2, int i) {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(35, obtain, obtain2, 0);
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

            public final void D(String str, String str2, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.mRemote.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(String str, Bundle bundle, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void Jr(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String Js(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void Q(int i, int i2, int i3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.mRemote.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void a(e eVar, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeStrongBinder(eVar != null ? eVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.mRemote.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void wb(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String[] bxn() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                    String[] createStringArray = obtain2.createStringArray();
                    return createStringArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String bxo() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String xH(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String bxp() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String Ju(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final Map bxr() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                    Map readHashMap = obtain2.readHashMap(getClass().getClassLoader());
                    return readHashMap;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String dS(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void Jv(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String cb(String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String getLanguage() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String bxq() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int bxs() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(54, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int bxt() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(55, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void bxu() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(56, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void bxv() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void wc(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(58, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void wd(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(59, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void vX(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    this.mRemote.transact(60, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void cc(String str, int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(61, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean bxw() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(62, obtain, obtain2, 0);
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

            public final String JA(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(63, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean bxy() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(64, obtain, obtain2, 0);
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

            public final boolean bxx() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(65, obtain, obtain2, 0);
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

            public final boolean bxB() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(66, obtain, obtain2, 0);
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

            public final void Jy(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(67, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void Jz(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    this.mRemote.transact(68, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void f(String str, String str2, String str3, int i, int i2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(69, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final Bundle d(int i, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    Bundle bundle2;
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(70, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle2 = null;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void V(Intent intent) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(71, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void t(int i, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(72, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final List<String> bxz() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(73, obtain, obtain2, 0);
                    obtain2.readException();
                    List<String> createStringArrayList = obtain2.createStringArrayList();
                    return createStringArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final int bxA() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(74, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String[] bxC() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    this.mRemote.transact(75, obtain, obtain2, 0);
                    obtain2.readException();
                    String[] createStringArray = obtain2.createStringArray();
                    return createStringArray;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final void o(int i, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(76, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        }

        public static d V(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
                return new a(iBinder);
            }
            return (d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            Bundle bundle = null;
            int i3 = 0;
            boolean Jt;
            String eK;
            int dw;
            int readInt;
            Bundle bundle2;
            List Dv;
            String readString;
            boolean z;
            String readString2;
            String[] bxn;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jt = Jt(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(Jt ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    eK = eK(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(eK);
                    return true;
                case 3:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jt = eU(parcel.readString());
                    parcel2.writeNoException();
                    if (Jt) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 4:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jt = fE(parcel.readString());
                    parcel2.writeNoException();
                    if (Jt) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 5:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jt = eV(parcel.readString());
                    parcel2.writeNoException();
                    if (Jt) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 6:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    eK = Jp(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(eK);
                    return true;
                case 7:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jt = rZ();
                    parcel2.writeNoException();
                    if (Jt) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 8:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jt = isSDCardAvailable();
                    parcel2.writeNoException();
                    if (Jt) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 9:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jt = azg();
                    parcel2.writeNoException();
                    if (Jt) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 10:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jt = ys();
                    parcel2.writeNoException();
                    if (Jt) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 11:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    dw = dw(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(dw);
                    return true;
                case 12:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    dx(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    eK = aw(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(eK);
                    return true;
                case 14:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    a(readInt, bundle2, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    IBinder asBinder;
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    b P = P(bundle2);
                    parcel2.writeNoException();
                    if (P != null) {
                        asBinder = P.asBinder();
                    }
                    parcel2.writeStrongBinder(asBinder);
                    return true;
                case 16:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    Jt = Q(bundle2);
                    parcel2.writeNoException();
                    if (Jt) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 17:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    dw = Jw(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(dw);
                    return true;
                case 18:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    favEditTag();
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    Jt = q(readInt, bundle2);
                    parcel2.writeNoException();
                    if (Jt) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 20:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jt = q(parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    if (Jt) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 21:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jx(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jt = Dw();
                    parcel2.writeNoException();
                    if (Jt) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 23:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Dv = Dv();
                    parcel2.writeNoException();
                    parcel2.writeStringList(Dv);
                    return true;
                case 24:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    f(parcel.readInt(), parcel.createStringArrayList());
                    parcel2.writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    readString = parcel.readString();
                    boolean z2 = parcel.readInt() != 0;
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    Jt = a(readString, z2, bundle2);
                    parcel2.writeNoException();
                    if (Jt) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 26:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    eK = Jq(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(eK);
                    return true;
                case 27:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    ca(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 28:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    eK = parcel.readString();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    ay(eK, z);
                    parcel2.writeNoException();
                    return true;
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jt = bu(parcel.readString());
                    parcel2.writeNoException();
                    if (Jt) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 30:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    p(readInt, bundle2);
                    parcel2.writeNoException();
                    return true;
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    bundle2 = l(readInt, bundle2);
                    parcel2.writeNoException();
                    if (bundle2 != null) {
                        parcel2.writeInt(1);
                        bundle2.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 32:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    eK = parcel.readString();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    i(eK, z, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 33:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    bundle2 = vZ(parcel.readInt());
                    parcel2.writeNoException();
                    if (bundle2 != null) {
                        parcel2.writeInt(1);
                        bundle2.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 34:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jt = wa(parcel.readInt());
                    parcel2.writeNoException();
                    if (Jt) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                    Bundle bundle3;
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    readString2 = parcel.readString();
                    readString = parcel.readString();
                    String readString3 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle3 = null;
                    }
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    }
                    Jt = a(readString2, readString, readString3, bundle3, bundle, parcel.readInt());
                    parcel2.writeNoException();
                    if (Jt) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 36:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    D(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case JsApiGetLocation.CTRL_INDEX /*37*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    a(readString2, bundle2, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 38:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jr(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 39:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    eK = Js(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(eK);
                    return true;
                case 40:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Q(parcel.readInt(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case v.CTRL_BYTE /*41*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    a(com.tencent.mm.plugin.webview.stub.e.a.W(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    wb(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    bxn = bxn();
                    parcel2.writeNoException();
                    parcel2.writeStringArray(bxn);
                    return true;
                case 44:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    eK = bxo();
                    parcel2.writeNoException();
                    parcel2.writeString(eK);
                    return true;
                case 45:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    eK = xH(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(eK);
                    return true;
                case JsApiGetMusicPlayerState.CTRL_INDEX /*46*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    eK = bxp();
                    parcel2.writeNoException();
                    parcel2.writeString(eK);
                    return true;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    eK = Ju(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(eK);
                    return true;
                case 48:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Map bxr = bxr();
                    parcel2.writeNoException();
                    parcel2.writeMap(bxr);
                    return true;
                case 49:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    eK = dS(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(eK);
                    return true;
                case 50:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jv(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 51:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    eK = cb(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(eK);
                    return true;
                case 52:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    eK = getLanguage();
                    parcel2.writeNoException();
                    parcel2.writeString(eK);
                    return true;
                case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    eK = bxq();
                    parcel2.writeNoException();
                    parcel2.writeString(eK);
                    return true;
                case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    dw = bxs();
                    parcel2.writeNoException();
                    parcel2.writeInt(dw);
                    return true;
                case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    dw = bxt();
                    parcel2.writeNoException();
                    parcel2.writeInt(dw);
                    return true;
                case FileUtils.S_IRWXG /*56*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    bxu();
                    parcel2.writeNoException();
                    return true;
                case b.CTRL_INDEX /*57*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    bxv();
                    parcel2.writeNoException();
                    return true;
                case m.CTRL_INDEX /*58*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    wc(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case bc.CTRL_INDEX /*59*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    wd(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 60:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    vX(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    cc(parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 62:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jt = bxw();
                    parcel2.writeNoException();
                    if (Jt) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 63:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    eK = JA(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(eK);
                    return true;
                case 64:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jt = bxy();
                    parcel2.writeNoException();
                    if (Jt) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 65:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jt = bxx();
                    parcel2.writeNoException();
                    if (Jt) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 66:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jt = bxB();
                    parcel2.writeNoException();
                    if (Jt) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 67:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jy(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case bl.CTRL_INDEX /*68*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Jz(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 69:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    f(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 70:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    bundle2 = d(readInt, bundle2);
                    parcel2.writeNoException();
                    if (bundle2 != null) {
                        parcel2.writeInt(1);
                        bundle2.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 71:
                    Intent intent;
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    if (parcel.readInt() != 0) {
                        intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                    } else {
                        intent = null;
                    }
                    V(intent);
                    parcel2.writeNoException();
                    return true;
                case q.CTRL_INDEX /*72*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    t(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case com.tencent.mm.plugin.appbrand.jsapi.share.b.CTRL_INDEX /*73*/:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    Dv = bxz();
                    parcel2.writeNoException();
                    parcel2.writeStringList(Dv);
                    return true;
                case 74:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    dw = bxA();
                    parcel2.writeNoException();
                    parcel2.writeInt(dw);
                    return true;
                case 75:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    bxn = bxC();
                    parcel2.writeNoException();
                    parcel2.writeStringArray(bxn);
                    return true;
                case 76:
                    parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    readInt = parcel.readInt();
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    o(readInt, bundle2);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void D(String str, String str2, int i);

    List<String> Dv();

    boolean Dw();

    String JA(String str);

    String Jp(String str);

    String Jq(String str);

    void Jr(String str);

    String Js(String str);

    boolean Jt(String str);

    String Ju(String str);

    void Jv(String str);

    int Jw(String str);

    void Jx(String str);

    void Jy(String str);

    void Jz(String str);

    b P(Bundle bundle);

    void Q(int i, int i2, int i3);

    boolean Q(Bundle bundle);

    void V(Intent intent);

    void a(int i, Bundle bundle, int i2);

    void a(e eVar, int i);

    void a(String str, Bundle bundle, int i);

    boolean a(String str, String str2, String str3, Bundle bundle, Bundle bundle2, int i);

    boolean a(String str, boolean z, Bundle bundle);

    String aw(int i, String str);

    void ay(String str, boolean z);

    boolean azg();

    boolean bu(String str);

    int bxA();

    boolean bxB();

    String[] bxC();

    String[] bxn();

    String bxo();

    String bxp();

    String bxq();

    Map bxr();

    int bxs();

    int bxt();

    void bxu();

    void bxv();

    boolean bxw();

    boolean bxx();

    boolean bxy();

    List<String> bxz();

    void ca(String str, int i);

    String cb(String str, int i);

    void cc(String str, int i);

    Bundle d(int i, Bundle bundle);

    String dS(String str, String str2);

    int dw(int i, int i2);

    void dx(int i, int i2);

    String eK(String str);

    boolean eU(String str);

    boolean eV(String str);

    void f(int i, List<String> list);

    void f(String str, String str2, String str3, int i, int i2);

    boolean fE(String str);

    void favEditTag();

    String getLanguage();

    void i(String str, boolean z, int i);

    boolean isSDCardAvailable();

    Bundle l(int i, Bundle bundle);

    void o(int i, Bundle bundle);

    void p(int i, Bundle bundle);

    boolean q(int i, Bundle bundle);

    boolean q(long j, String str);

    boolean rZ();

    void t(int i, String str, String str2);

    void vX(int i);

    Bundle vZ(int i);

    boolean wa(int i);

    void wb(int i);

    void wc(int i);

    void wd(int i);

    String xH(String str);

    boolean ys();
}
