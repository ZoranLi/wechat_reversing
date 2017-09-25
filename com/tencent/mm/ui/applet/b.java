package com.tencent.mm.ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;

public final class b {
    public int direction = 0;
    private GestureDetector nlD = new GestureDetector(new OnGestureListener(this) {
        final /* synthetic */ b vff;

        {
            this.vff = r1;
        }

        public final boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        public final void onShowPress(MotionEvent motionEvent) {
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.vff.direction = f2 >= 0.0f ? 0 : 1;
            return false;
        }

        public final void onLongPress(MotionEvent motionEvent) {
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }
    });
    private IdleHandler uQB;
    private int vfb;
    private c vfc;
    public LinkedList<String> vfd;
    public a vfe;

    public interface a {
        Bitmap jf(String str);
    }

    public interface b {
        int Fh();

        String fE(int i);
    }

    private class c {
        private LinkedList<String> gMT;
        private int maxSize;
        final /* synthetic */ b vff;

        public c(b bVar, int i) {
            this.vff = bVar;
            this.gMT = null;
            this.maxSize = 40;
            this.gMT = new LinkedList();
        }

        final void Jl(String str) {
            if (!this.gMT.contains(str)) {
                this.gMT.add(str);
                if (this.gMT.size() >= this.maxSize) {
                    this.gMT.removeFirst();
                }
            }
        }

        final boolean contains(String str) {
            return this.gMT.contains(str);
        }
    }

    public b(a aVar) {
        this.vfe = aVar;
        this.vfb = 15;
        this.vfc = new c(this, 40);
        this.vfd = new LinkedList();
        this.uQB = new IdleHandler(this) {
            final /* synthetic */ b vff;

            {
                this.vff = r1;
            }

            public final boolean queueIdle() {
                while (this.vff.vfd.size() > 0) {
                    this.vff.vfe.jf((String) this.vff.vfd.removeFirst());
                }
                return true;
            }
        };
        Looper.myQueue().addIdleHandler(this.uQB);
    }

    public final void a(int i, b bVar) {
        if (bVar == null) {
            w.e("MicroMsg.EarlyGetHeadImg", "earlyGet, getter is null, no early get headimg will be performed");
        } else if (this.vfb <= 0) {
            w.e("MicroMsg.EarlyGetHeadImg", "earlyGet fail, threshold is invalid");
        } else {
            int Fh = bVar.Fh();
            for (int i2 = 1; i2 <= this.vfb; i2++) {
                String fE;
                if (this.direction == 1) {
                    if (i - i2 >= 0) {
                        fE = bVar.fE(i - i2);
                        if (!(fE == null || fE.length() == 0 || this.vfc.contains(fE))) {
                            this.vfc.Jl(fE);
                            this.vfd.add(fE);
                        }
                    } else {
                        return;
                    }
                } else if (i + i2 < Fh) {
                    fE = bVar.fE(i + i2);
                    if (!(fE == null || fE.length() == 0 || this.vfc.contains(fE))) {
                        this.vfc.Jl(fE);
                        this.vfd.add(fE);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final void onTouchEvent(MotionEvent motionEvent) {
        if (this.nlD != null) {
            this.nlD.onTouchEvent(motionEvent);
        }
    }

    public final void detach() {
        if (this.uQB != null) {
            Looper.myQueue().removeIdleHandler(this.uQB);
        }
    }
}
