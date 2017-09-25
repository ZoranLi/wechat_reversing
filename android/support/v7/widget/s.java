package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

final class s {
    final b VL;
    final a VM = new a();
    final List<View> VN = new ArrayList();

    static class a {
        long VO = 0;
        a VP;

        a() {
        }

        final void set(int i) {
            while (i >= 64) {
                eH();
                this = this.VP;
                i -= 64;
            }
            this.VO |= 1 << i;
        }

        private void eH() {
            if (this.VP == null) {
                this.VP = new a();
            }
        }

        final void clear(int i) {
            while (i >= 64) {
                if (this.VP != null) {
                    this = this.VP;
                    i -= 64;
                } else {
                    return;
                }
            }
            this.VO &= (1 << i) ^ -1;
        }

        final boolean get(int i) {
            while (i >= 64) {
                eH();
                this = this.VP;
                i -= 64;
            }
            return (this.VO & (1 << i)) != 0;
        }

        final void n(int i, boolean z) {
            while (true) {
                if (i >= 64) {
                    eH();
                    this = this.VP;
                    i -= 64;
                } else {
                    boolean z2 = (this.VO & Long.MIN_VALUE) != 0;
                    long j = (1 << i) - 1;
                    this.VO = (((j ^ -1) & this.VO) << 1) | (this.VO & j);
                    if (z) {
                        set(i);
                    } else {
                        clear(i);
                    }
                    if (z2 || this.VP != null) {
                        eH();
                        this = this.VP;
                        i = 0;
                        z = z2;
                    } else {
                        return;
                    }
                }
            }
        }

        final boolean aO(int i) {
            while (i >= 64) {
                eH();
                this = this.VP;
                i -= 64;
            }
            long j = 1 << i;
            boolean z = (this.VO & j) != 0;
            this.VO &= j ^ -1;
            j--;
            this.VO = Long.rotateRight((j ^ -1) & this.VO, 1) | (this.VO & j);
            if (this.VP != null) {
                if (this.VP.get(0)) {
                    set(63);
                }
                this.VP.aO(0);
            }
            return z;
        }

        final int aP(int i) {
            if (this.VP == null) {
                if (i >= 64) {
                    return Long.bitCount(this.VO);
                }
                return Long.bitCount(this.VO & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.VO & ((1 << i) - 1));
            } else {
                return this.VP.aP(i - 64) + Long.bitCount(this.VO);
            }
        }

        public final String toString() {
            return this.VP == null ? Long.toBinaryString(this.VO) : this.VP.toString() + "xx" + Long.toBinaryString(this.VO);
        }
    }

    interface b {
        t aQ(View view);

        void aR(View view);

        void aS(View view);

        void addView(View view, int i);

        void attachViewToParent(View view, int i, LayoutParams layoutParams);

        void detachViewFromParent(int i);

        View getChildAt(int i);

        int getChildCount();

        int indexOfChild(View view);

        void removeAllViews();

        void removeViewAt(int i);
    }

    s(b bVar) {
        this.VL = bVar;
    }

    final void aN(View view) {
        this.VN.add(view);
        this.VL.aR(view);
    }

    final boolean aO(View view) {
        if (!this.VN.remove(view)) {
            return false;
        }
        this.VL.aS(view);
        return true;
    }

    final void a(View view, int i, boolean z) {
        int childCount;
        if (i < 0) {
            childCount = this.VL.getChildCount();
        } else {
            childCount = aM(i);
        }
        this.VM.n(childCount, z);
        if (z) {
            aN(view);
        }
        this.VL.addView(view, childCount);
    }

    final int aM(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.VL.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int aP = i - (i2 - this.VM.aP(i2));
            if (aP == 0) {
                while (this.VM.get(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += aP;
        }
        return -1;
    }

    final View getChildAt(int i) {
        return this.VL.getChildAt(aM(i));
    }

    final void a(View view, int i, LayoutParams layoutParams, boolean z) {
        int childCount;
        if (i < 0) {
            childCount = this.VL.getChildCount();
        } else {
            childCount = aM(i);
        }
        this.VM.n(childCount, z);
        if (z) {
            aN(view);
        }
        this.VL.attachViewToParent(view, childCount, layoutParams);
    }

    final int getChildCount() {
        return this.VL.getChildCount() - this.VN.size();
    }

    final int eG() {
        return this.VL.getChildCount();
    }

    final View aN(int i) {
        return this.VL.getChildAt(i);
    }

    final void detachViewFromParent(int i) {
        int aM = aM(i);
        this.VM.aO(aM);
        this.VL.detachViewFromParent(aM);
    }

    final int indexOfChild(View view) {
        int indexOfChild = this.VL.indexOfChild(view);
        if (indexOfChild == -1 || this.VM.get(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.VM.aP(indexOfChild);
    }

    final boolean aP(View view) {
        return this.VN.contains(view);
    }

    public final String toString() {
        return this.VM.toString() + ", hidden list:" + this.VN.size();
    }
}
