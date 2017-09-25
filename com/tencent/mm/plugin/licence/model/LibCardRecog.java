package com.tencent.mm.plugin.licence.model;

import com.tencent.mm.compatible.util.k;

public final class LibCardRecog {
    public static native int recognizeBankCardGetVersion();

    public static native int recognizeBankCardInit(int i, int i2, boolean z);

    public static native int recognizeBankCardProcess(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, BankCardInfo bankCardInfo, boolean[] zArr);

    public static native int recognizeBankCardRelease();

    public static native String recognizeBankCardSegmentNumber(String str, int i, int[] iArr);

    public static native int recognizeCardInit(int i, int i2, int i3);

    public static native int recognizeCardProcess(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, CardInfo cardInfo, boolean[] zArr);

    public static native int recognizeCardRelease();

    static {
        k.b("IDCardRecog", LibCardRecog.class.getClassLoader());
    }
}
