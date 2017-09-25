package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import com.tencent.mm.plugin.voip.video.CaptureView;

public interface b {
    void HD(String str);

    void a(int i, int i2, int[] iArr);

    void a(CaptureView captureView);

    void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6);

    void aFs();

    void at(int i, String str);

    void bQ(boolean z);

    void bpR();

    Context bqR();

    void bqS();

    void dS(long j);

    void dm(int i, int i2);

    void uninit();

    void vb(int i);
}
