package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;

public final class a implements com.tencent.mm.ipcinvoker.extension.a {
    public final boolean am(Object obj) {
        return obj instanceof b;
    }

    public final void a(Object obj, Parcel parcel) {
        b bVar = (b) obj;
        c.a(bVar.hsj.hsr, parcel);
        if (ab.bJb()) {
            c.a(bVar.hsk.hsr, parcel);
        } else {
            parcel.writeString(bVar.hsk.hsr.getClass().getName());
        }
        parcel.writeString(bVar.uri);
        parcel.writeInt(bVar.hsl);
        parcel.writeInt(bVar.hsj.cmdId);
        parcel.writeInt(bVar.hsk.cmdId);
    }

    public final Object d(Parcel parcel) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = (com.tencent.mm.bd.a) c.a(c.class.getName(), parcel);
        if (ab.bJb()) {
            try {
                aVar.hsn = (com.tencent.mm.bd.a) Class.forName(parcel.readString()).newInstance();
            } catch (Exception e) {
                w.e("MicroMsg.XIPC.CommReqRespTransfer", "readFromParcel, mm process initiate resp e = %s", new Object[]{e});
                aVar.hsn = new com.tencent.mm.bd.a();
            }
        } else {
            com.tencent.mm.bd.a aVar2 = (com.tencent.mm.bd.a) c.a(c.class.getName(), parcel);
            if (aVar2 == null) {
                aVar2 = new com.tencent.mm.bd.a();
            }
            aVar.hsn = aVar2;
        }
        aVar.uri = parcel.readString();
        aVar.hsl = parcel.readInt();
        aVar.hso = parcel.readInt();
        aVar.hsp = parcel.readInt();
        return aVar.BE();
    }
}
