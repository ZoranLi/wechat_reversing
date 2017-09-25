package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import com.tencent.mm.plugin.mmsight.model.f;

public interface d {

    public interface a {
        void asE();
    }

    public interface b {
    }

    public enum c {
        WaitStart,
        Start,
        PrepareStop,
        WaitStop,
        Stop,
        WaitSend,
        Sent,
        Error,
        Initialized,
        Pause
    }

    void A(Runnable runnable);

    void AQ(String str);

    void AR(String str);

    String EP();

    void F(int i, int i2, int i3);

    void a(a aVar);

    boolean aKK();

    String aLd();

    float aLe();

    long aLf();

    f aLg();

    c aLh();

    int aLi();

    Point aLj();

    int aLk();

    boolean aLl();

    void aLm();

    com.tencent.mm.c.b.c.a aLn();

    int b(int i, boolean z, int i2);

    void cancel();

    String getFileName();

    String getFilePath();

    void j(int i, int i2, int i3, int i4);

    boolean pE(int i);

    void pause();

    void reset();

    void setFilePath(String str);
}
