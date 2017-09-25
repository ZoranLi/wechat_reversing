package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.extension.f;

public final class a extends com.tencent.mm.ipcinvoker.extension.event.a<a> {
    private static final a iJx = new a();

    public static class a implements f {
        public int height;
        public String id;
        public int width;

        public final void e(Parcel parcel) {
            parcel.writeString(this.id);
            parcel.writeInt(this.width);
            parcel.writeInt(this.height);
        }

        public final void readFromParcel(Parcel parcel) {
            this.id = parcel.readString();
            this.width = parcel.readInt();
            this.height = parcel.readInt();
        }
    }
}
