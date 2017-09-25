package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.n;
import com.tencent.mm.sdk.platformtools.w;

public final class XIPCInvoker {

    private static class WrapperParcelable implements Parcelable {
        public static final Creator<WrapperParcelable> CREATOR = new Creator<WrapperParcelable>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                WrapperParcelable wrapperParcelable = new WrapperParcelable();
                wrapperParcelable.gWp = parcel.readString();
                if (parcel.readInt() == 1) {
                    wrapperParcelable.gWm = c.a(parcel.readString(), parcel);
                }
                return wrapperParcelable;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new WrapperParcelable[i];
            }
        };
        Object gWm;
        String gWp;

        public WrapperParcelable(String str, Object obj) {
            this.gWp = str;
            this.gWm = obj;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.gWp);
            if (this.gWm != null) {
                a an = c.an(this.gWm);
                if (an != null) {
                    parcel.writeInt(1);
                    parcel.writeString(an.getClass().getName());
                    an.a(this.gWm, parcel);
                    return;
                }
            }
            parcel.writeInt(1);
        }
    }

    private static class a implements g<WrapperParcelable, WrapperParcelable> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, final h hVar) {
            WrapperParcelable wrapperParcelable = (WrapperParcelable) obj;
            Object obj2 = wrapperParcelable.gWm;
            String str = wrapperParcelable.gWp;
            if (str == null || str.length() == 0) {
                w.e("IPC.IPCAsyncInvokeTaskProxy", "proxy AsyncInvoke failed, class is null or nil.");
                return;
            }
            g gVar = (g) n.b(str, g.class);
            if (gVar == null) {
                w.w("IPC.IPCAsyncInvokeTaskProxy", "proxy AsyncInvoke failed, newInstance(%s) return null.", new Object[]{str});
                return;
            }
            gVar.a(obj2, new h(this) {
                final /* synthetic */ a gWo;

                public final void ak(Object obj) {
                    if (hVar != null) {
                        hVar.ak(new WrapperParcelable(null, obj));
                    }
                }
            });
        }
    }

    private static class b implements i<WrapperParcelable, WrapperParcelable> {
        private b() {
        }

        public final /* synthetic */ Object al(Object obj) {
            WrapperParcelable wrapperParcelable = (WrapperParcelable) obj;
            Object obj2 = wrapperParcelable.gWm;
            String str = wrapperParcelable.gWp;
            if (str == null || str.length() == 0) {
                w.e("IPC.XIPCInvoker", "proxy SyncInvoke failed, class is null or nil.");
                return new WrapperParcelable(null, null);
            }
            i iVar = (i) n.b(str, i.class);
            if (iVar != null) {
                return new WrapperParcelable(null, iVar.al(obj2));
            }
            w.w("IPC.XIPCInvoker", "proxy SyncInvoke failed, newInstance(%s) return null.", new Object[]{str});
            return new WrapperParcelable(null, null);
        }
    }

    public static <T extends g<InputType, ResultType>, InputType, ResultType> void a(String str, InputType inputType, Class<T> cls, final h<ResultType> hVar) {
        e.a(str, new WrapperParcelable(cls.getName(), inputType), a.class, new h<WrapperParcelable>() {
            public final /* synthetic */ void ak(Object obj) {
                WrapperParcelable wrapperParcelable = (WrapperParcelable) obj;
                if (hVar == null) {
                    return;
                }
                if (wrapperParcelable == null) {
                    w.w("IPC.XIPCInvoker", "async invoke callback error, wrapper parcelable data is null!");
                    hVar.ak(null);
                    return;
                }
                hVar.ak(wrapperParcelable.gWm);
            }
        });
    }

    public static <T extends i<InputType, ResultType>, InputType, ResultType> ResultType a(String str, InputType inputType, Class<T> cls) {
        WrapperParcelable wrapperParcelable = (WrapperParcelable) e.a(str, new WrapperParcelable(cls.getName(), inputType), b.class);
        if (wrapperParcelable != null) {
            return wrapperParcelable.gWm;
        }
        w.w("IPC.XIPCInvoker", "sync invoke error, wrapper parcelable data is null!");
        return null;
    }
}
