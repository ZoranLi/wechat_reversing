package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;

public final class eb {
    private static eb vNY;
    Object vNX;

    @TargetApi(14)
    public static class a implements OnHoverListener {
        private b vNZ;

        public a(b bVar) {
            this.vNZ = bVar;
        }

        public final boolean onHover(View view, MotionEvent motionEvent) {
            if (this.vNZ != null) {
                return this.vNZ.e(view, motionEvent);
            }
            return false;
        }
    }

    public interface b {
        boolean e(View view, MotionEvent motionEvent);
    }

    public static synchronized eb bWo() {
        eb ebVar;
        synchronized (eb.class) {
            if (vNY == null) {
                vNY = new eb();
            }
            ebVar = vNY;
        }
        return ebVar;
    }
}
