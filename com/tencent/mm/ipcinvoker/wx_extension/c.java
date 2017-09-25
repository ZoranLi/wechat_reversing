package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.mm.ipcinvoker.extension.a;
import com.tencent.mm.sdk.platformtools.w;

public final class c implements a {
    public final boolean am(Object obj) {
        return obj instanceof com.tencent.mm.bd.a;
    }

    public final void a(Object obj, Parcel parcel) {
        if (obj == null) {
            parcel.writeString(null);
            return;
        }
        byte[] toByteArray;
        com.tencent.mm.bd.a aVar = (com.tencent.mm.bd.a) obj;
        parcel.writeString(aVar.getClass().getName());
        try {
            toByteArray = aVar.toByteArray();
        } catch (Exception e) {
            w.e("MicroMsg.XIPC.MMProtoBufTransfer", "writeToParcel, e = %s", new Object[]{e});
            toByteArray = new byte[0];
        }
        parcel.writeInt(toByteArray.length);
        parcel.writeByteArray(toByteArray);
    }

    public final Object d(Parcel parcel) {
        Object readString = parcel.readString();
        if (TextUtils.isEmpty(readString)) {
            return null;
        }
        com.tencent.mm.bd.a aVar;
        byte[] bArr = new byte[parcel.readInt()];
        parcel.readByteArray(bArr);
        try {
            aVar = (com.tencent.mm.bd.a) Class.forName(readString).newInstance();
            aVar.aD(bArr);
        } catch (Exception e) {
            w.e("MicroMsg.XIPC.MMProtoBufTransfer", "readFromParcel, e = %s", new Object[]{e});
            aVar = null;
        }
        return aVar;
    }
}
