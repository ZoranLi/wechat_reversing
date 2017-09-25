package com.google.android.gms.c;

import android.graphics.drawable.Drawable;
import java.util.Arrays;

public final class l extends o<a, Drawable> {

    public static final class a {
        public final int azX;
        public final int azY;

        public a(int i, int i2) {
            this.azX = i;
            this.azY = i2;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            a aVar = (a) obj;
            return aVar.azX == this.azX && aVar.azY == this.azY;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{Integer.valueOf(this.azX), Integer.valueOf(this.azY)});
        }
    }
}
