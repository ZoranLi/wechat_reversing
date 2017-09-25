package android.support.v4.a;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

final class e implements c {

    private static class a implements g {
        List<b> eE = new ArrayList();
        public long mDuration = 200;
        public long mStartTime;
        public Runnable nA = new Runnable(this) {
            final /* synthetic */ a nB;

            {
                this.nB = r1;
            }

            public final void run() {
                float drawingTime = (((float) (this.nB.nw.getDrawingTime() - this.nB.mStartTime)) * 1.0f) / ((float) this.nB.mDuration);
                if (drawingTime > 1.0f || this.nB.nw.getParent() == null) {
                    drawingTime = 1.0f;
                }
                this.nB.nx = drawingTime;
                g gVar = this.nB;
                for (int size = gVar.nv.size() - 1; size >= 0; size--) {
                    ((d) gVar.nv.get(size)).b(gVar);
                }
                if (this.nB.nx >= 1.0f) {
                    this.nB.aD();
                } else {
                    this.nB.nw.postDelayed(this.nB.nA, 16);
                }
            }
        };
        List<d> nv = new ArrayList();
        View nw;
        public float nx = 0.0f;
        private boolean ny = false;
        private boolean nz = false;

        public final void w(View view) {
            this.nw = view;
        }

        public final void a(b bVar) {
            this.eE.add(bVar);
        }

        public final void setDuration(long j) {
            if (!this.ny) {
                this.mDuration = j;
            }
        }

        public final void start() {
            if (!this.ny) {
                this.ny = true;
                for (int size = this.eE.size() - 1; size >= 0; size--) {
                    this.eE.get(size);
                }
                this.nx = 0.0f;
                this.mStartTime = this.nw.getDrawingTime();
                this.nw.postDelayed(this.nA, 16);
            }
        }

        public final void aD() {
            for (int size = this.eE.size() - 1; size >= 0; size--) {
                ((b) this.eE.get(size)).a(this);
            }
        }

        public final void cancel() {
            if (!this.nz) {
                this.nz = true;
                if (this.ny) {
                    for (int size = this.eE.size() - 1; size >= 0; size--) {
                        ((b) this.eE.get(size)).aC();
                    }
                }
                aD();
            }
        }

        public final void a(d dVar) {
            this.nv.add(dVar);
        }

        public final float getAnimatedFraction() {
            return this.nx;
        }
    }

    e() {
    }

    public final g aB() {
        return new a();
    }

    public final void v(View view) {
    }
}
