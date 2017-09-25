package android.support.v4.e;

public final class h {

    public interface a<T> {
        T bF();

        boolean i(T t);
    }

    public static class b<T> implements a<T> {
        private final Object[] wf;
        private int wg;

        public b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.wf = new Object[i];
        }

        public T bF() {
            if (this.wg <= 0) {
                return null;
            }
            int i = this.wg - 1;
            T t = this.wf[i];
            this.wf[i] = null;
            this.wg--;
            return t;
        }

        public boolean i(T t) {
            boolean z;
            for (int i = 0; i < this.wg; i++) {
                if (this.wf[i] == t) {
                    z = true;
                    break;
                }
            }
            z = false;
            if (z) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.wg >= this.wf.length) {
                return false;
            } else {
                this.wf[this.wg] = t;
                this.wg++;
                return true;
            }
        }
    }

    public static class c<T> extends b<T> {
        private final Object mLock = new Object();

        public c() {
            super(16);
        }

        public final T bF() {
            T bF;
            synchronized (this.mLock) {
                bF = super.bF();
            }
            return bF;
        }

        public final boolean i(T t) {
            boolean i;
            synchronized (this.mLock) {
                i = super.i(t);
            }
            return i;
        }
    }
}
