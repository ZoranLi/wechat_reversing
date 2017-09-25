package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.y.b;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;

public final class GameWebviewRunCgi {

    public interface a {
        void a(int i, int i2, String str, b bVar);
    }

    private static final class RemoteCgiTask extends GWMainProcessTask implements com.tencent.mm.y.u.a {
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
        int mjD = 0;
        private b mjE;
        b mjF;
        a mjG;

        public final void PM() {
            u.a(this.mjF, this, true);
        }

        public final int a(int i, int i2, String str, b bVar, k kVar) {
            this.laH = i;
            this.lav = i2;
            this.laI = str;
            this.mjE = bVar;
            this.mjD = 2;
            SL();
            return 0;
        }

        public final void SK() {
            d.aO(this);
            if (this.mjG != null) {
                this.mjG.a(this.laH, this.lav, this.laI, this.mjE);
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
                    GameWebviewRunCgi.a(this.mjF, parcel);
                    return;
                case 2:
                    parcel.writeInt(this.laH);
                    parcel.writeInt(this.lav);
                    parcel.writeString(this.laI);
                    GameWebviewRunCgi.a(this.mjE, parcel);
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
                    this.mjF = GameWebviewRunCgi.j(parcel);
                    return;
                case 2:
                    this.laH = parcel.readInt();
                    this.lav = parcel.readInt();
                    this.laI = parcel.readString();
                    this.mjE = GameWebviewRunCgi.j(parcel);
                    return;
                default:
                    return;
            }
        }

        RemoteCgiTask() {
        }

        RemoteCgiTask(Parcel parcel) {
            f(parcel);
        }
    }

    public static void a(b bVar, final a aVar) {
        if (ab.bJb()) {
            u.a(bVar, new com.tencent.mm.y.u.a() {
                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    if (aVar != null) {
                        aVar.a(i, i2, str, bVar);
                    }
                    return 0;
                }
            });
            return;
        }
        GWMainProcessTask remoteCgiTask = new RemoteCgiTask();
        d.aN(remoteCgiTask);
        remoteCgiTask.mjF = bVar;
        remoteCgiTask.mjG = aVar;
        remoteCgiTask.mjD = 1;
        GameWebViewMainProcessService.a(remoteCgiTask);
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
                } catch (Exception e3) {
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
