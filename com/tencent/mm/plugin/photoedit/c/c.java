package com.tencent.mm.plugin.photoedit.c;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public interface c<T> extends Cloneable {
    void a(Canvas canvas, boolean z, Object... objArr);

    void aSi();

    Bitmap aSk();

    boolean aSl();

    void gf(boolean z);

    int gg(boolean z);

    void h(Canvas canvas);

    void onCreate();

    void onDestroy();

    T pop();

    void v(Bitmap bitmap);
}
