package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import java.util.Arrays;

public abstract class f {
    public int aoU;
    private int aoV;
    public final DataHolder aoy;

    public f(DataHolder dataHolder, int i) {
        this.aoy = (DataHolder) w.Z(dataHolder);
        boolean z = i >= 0 && i < this.aoy.aoJ;
        w.ac(z);
        this.aoU = i;
        this.aoV = this.aoy.bV(this.aoU);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return v.d(Integer.valueOf(fVar.aoU), Integer.valueOf(this.aoU)) && v.d(Integer.valueOf(fVar.aoV), Integer.valueOf(this.aoV)) && fVar.aoy == this.aoy;
    }

    public final byte[] getByteArray(String str) {
        DataHolder dataHolder = this.aoy;
        int i = this.aoU;
        int i2 = this.aoV;
        dataHolder.f(str, i);
        return dataHolder.aoG[i2].getBlob(i, dataHolder.aoF.getInt(str));
    }

    public final int getInteger(String str) {
        DataHolder dataHolder = this.aoy;
        int i = this.aoU;
        int i2 = this.aoV;
        dataHolder.f(str, i);
        return dataHolder.aoG[i2].getInt(i, dataHolder.aoF.getInt(str));
    }

    public final String getString(String str) {
        return this.aoy.b(str, this.aoU, this.aoV);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.aoU), Integer.valueOf(this.aoV), this.aoy});
    }
}
