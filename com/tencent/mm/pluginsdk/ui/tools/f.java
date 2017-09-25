package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;

public interface f {

    public interface a {
        void Uc();

        int bI(int i, int i2);

        void bp(int i, int i2);

        void oW();

        void onError(int i, int i2);
    }

    public interface b {
        void dH(int i, int i2);
    }

    public interface c {
        void br(boolean z);
    }

    public interface d {
        void KJ();
    }

    public interface e {
        void aMm();
    }

    String Ls();

    void a(a aVar);

    void a(b bVar);

    void a(c cVar);

    void a(d dVar);

    void a(e eVar);

    void bN(boolean z);

    void bQ(boolean z);

    double bcw();

    long bcx();

    void c(double d, boolean z);

    int getCurrentPosition();

    int getDuration();

    void he(boolean z);

    boolean i(Context context, boolean z);

    boolean isPlaying();

    void k(double d);

    void onDetach();

    void pause();

    void setVideoPath(String str);

    boolean start();

    void stop();
}
