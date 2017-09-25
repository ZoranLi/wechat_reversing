package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class d {
    private static volatile d lvI = null;
    public static final Object mLock = new Object();
    public List<a> lvJ = null;

    private class a {
        public byte[] data;
        public b lvK;
        final /* synthetic */ d lvL;

        a(d dVar, b bVar) {
            this.lvL = dVar;
            this.lvK = bVar;
        }
    }

    public interface b {
        void an(byte[] bArr);

        com.tencent.mm.memory.a<byte[]> arv();
    }

    public static final d aru() {
        if (lvI != null) {
            return lvI;
        }
        d dVar;
        synchronized (mLock) {
            if (lvI == null) {
                lvI = new d();
            }
            dVar = lvI;
        }
        return dVar;
    }

    public final synchronized void a(b bVar) {
        if (bVar == null) {
            w.w("MicroMsg.FaceCameraDataCallbackHolder", "hy: invalid callbacker");
        } else {
            synchronized (mLock) {
                if (this.lvJ == null) {
                    this.lvJ = Collections.synchronizedList(new ArrayList(5));
                }
                this.lvJ.add(new a(this, bVar));
            }
        }
    }

    public final void b(b bVar) {
        synchronized (mLock) {
            if (this.lvJ != null) {
                this.lvJ.remove(bVar);
            }
        }
    }
}
