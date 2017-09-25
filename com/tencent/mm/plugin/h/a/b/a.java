package com.tencent.mm.plugin.h.a.b;

import android.bluetooth.BluetoothGattCharacteristic;

public final class a {
    private int jQX = 20;
    private byte[] jQY = null;
    private int jQZ = 0;
    private int jRa = 0;
    BluetoothGattCharacteristic jRb = null;

    public final void setData(byte[] bArr) {
        if (bArr == null) {
            this.jQY = null;
            this.jRa = 0;
            this.jQZ = 0;
            return;
        }
        this.jQY = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.jQY, 0, bArr.length);
        this.jRa = bArr.length;
        this.jQZ = 0;
    }

    public final byte[] acU() {
        int i = this.jRa - this.jQZ;
        if (i == 0) {
            return null;
        }
        if (i >= this.jQX) {
            i = this.jQX;
        }
        Object obj = new byte[i];
        System.arraycopy(this.jQY, this.jQZ, obj, 0, i);
        this.jQZ = i + this.jQZ;
        return obj;
    }
}
