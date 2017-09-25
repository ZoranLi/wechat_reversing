package com.tencent.mm.plugin.webview.wepkg.utils;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;

public final class WepkgRunCgi {

    static class AnonymousClass1 implements com.tencent.mm.y.u.a {
        final /* synthetic */ a srB;

        public AnonymousClass1(a aVar) {
            this.srB = aVar;
        }

        public final int a(int i, int i2, String str, b bVar, k kVar) {
            if (this.srB != null) {
                this.srB.a(i, i2, str, bVar);
            }
            return 0;
        }
    }

    public interface a {
        void a(int i, int i2, String str, b bVar);
    }

    private static final class RemoteCgiTask extends WepkgMainProcessTask implements com.tencent.mm.y.u.a {
        public static final Creator<RemoteCgiTask> CREATOR = new Creator<RemoteCgiTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new RemoteCgiTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new RemoteCgiTask[i];
            }
        };
        private int laH;
        private String laI;
        private int lav;
        public int mjD = 0;
        private b mjE;
        public b mjF;
        public a srC;

        public final void PM() {
            u.a(this.mjF, this, true);
        }

        public final int a(int i, int i2, String str, b bVar, k kVar) {
            this.laH = i;
            this.lav = i2;
            this.laI = str;
            this.mjE = bVar;
            this.mjD = 2;
            vM();
            return 0;
        }

        public final void SK() {
            d.aO(this);
            if (this.srC != null) {
                this.srC.a(this.laH, this.lav, this.laI, this.mjE);
            }
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mjD);
            switch (this.mjD) {
                case 1:
                    WepkgRunCgi.a(this.mjF, parcel);
                    return;
                case 2:
                    parcel.writeInt(this.laH);
                    parcel.writeInt(this.lav);
                    parcel.writeString(this.laI);
                    WepkgRunCgi.a(this.mjE, parcel);
                    return;
                default:
                    return;
            }
        }

        public final void f(Parcel parcel) {
            super.f(parcel);
            this.mjD = parcel.readInt();
            switch (this.mjD) {
                case 1:
                    this.mjF = WepkgRunCgi.j(parcel);
                    return;
                case 2:
                    this.laH = parcel.readInt();
                    this.lav = parcel.readInt();
                    this.laI = parcel.readString();
                    this.mjE = WepkgRunCgi.j(parcel);
                    return;
                default:
                    return;
            }
        }

        RemoteCgiTask(Parcel parcel) {
            f(parcel);
        }
    }

    public static b j(Parcel parcel) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        String readString = parcel.readString();
        byte[] bArr = new byte[parcel.readInt()];
        parcel.readByteArray(bArr);
        try {
            aVar.hsm = ((com.tencent.mm.bd.a) Class.forName(readString).newInstance()).aD(bArr);
        } catch (Exception e) {
        }
        String readString2 = parcel.readString();
        byte[] bArr2 = new byte[parcel.readInt()];
        parcel.readByteArray(bArr2);
        try {
            aVar.hsn = ((com.tencent.mm.bd.a) Class.forName(readString2).newInstance()).aD(bArr2);
        } catch (Exception e2) {
            if (e2 instanceof a.a.a.b) {
                try {
                    aVar.hsn = (com.tencent.mm.bd.a) Class.forName(readString2).newInstance();
                } catch (Throwable e3) {
                    w.e("MicroMsg.Wepkg.WepkgRunCgi", "readCommReqRespFromParcel, resp fields not ready, re-create one but exp = %s", new Object[]{bg.g(e3)});
                }
            }
        }
        aVar.uri = parcel.readString();
        aVar.hsl = parcel.readInt();
        aVar.hso = parcel.readInt();
        aVar.hsp = parcel.readInt();
        return aVar.BE();
    }

    public static void a(b bVar, Parcel parcel) {
        parcel.writeString(bVar.hsj.hsr.getClass().getName());
        byte[] bArr = new byte[0];
        try {
            bArr = bVar.hsj.hsr.toByteArray();
        } catch (Exception e) {
        }
        parcel.writeInt(bArr.length);
        parcel.writeByteArray(bArr);
        parcel.writeString(bVar.hsk.hsr.getClass().getName());
        bArr = new byte[0];
        try {
            bArr = bVar.hsk.hsr.toByteArray();
        } catch (Exception e2) {
        }
        parcel.writeInt(bArr.length);
        parcel.writeByteArray(bArr);
        parcel.writeString(bVar.uri);
        parcel.writeInt(bVar.hsl);
        parcel.writeInt(bVar.hsj.cmdId);
        parcel.writeInt(bVar.hsk.cmdId);
    }
}
