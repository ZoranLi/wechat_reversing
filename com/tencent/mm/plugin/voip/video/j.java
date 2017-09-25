package com.tencent.mm.plugin.voip.video;

import android.os.Looper;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;

public final class j {
    public ArrayList<a> jRr = new ArrayList();
    public v2protocal rir = new v2protocal(new ae(Looper.myLooper()));
    public int rqA = 0;
    public int rqB;
    public int rqC;
    public boolean rqz = false;

    public interface a {
        void a(int[] iArr, boolean z, int i);
    }

    private class b {
        public int rqD;
        public int rqE;
        public int rqF;
        public int rqG;
        final /* synthetic */ j rqH;

        public b(j jVar) {
            this.rqH = jVar;
        }

        public final String toString() {
            return String.format("topLeftX:%d, topLeftY:%d, rightBottomX:%d, rightBottomY:%d", new Object[]{Integer.valueOf(this.rqD), Integer.valueOf(this.rqE), Integer.valueOf(this.rqF), Integer.valueOf(this.rqG)});
        }
    }
}
