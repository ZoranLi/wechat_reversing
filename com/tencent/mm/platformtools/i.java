package com.tencent.mm.platformtools;

import android.graphics.Bitmap;

public interface i {

    public enum a {
        NET,
        DISK
    }

    public interface b {
        Bitmap ms(String str);
    }

    void F(String str, boolean z);

    b Nl();

    String Nm();

    String Nn();

    String No();

    String Np();

    boolean Nq();

    boolean Nr();

    Bitmap Ns();

    void Nt();

    Bitmap a(Bitmap bitmap, a aVar, String str);

    void a(a aVar, String str);
}
