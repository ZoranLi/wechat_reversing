package android.support.v4.d;

import java.util.Locale;

public final class e {
    public static final d vA = new e(b.vH, false);
    public static final d vB = new e(b.vH, true);
    public static final d vC = new e(a.vF, false);
    public static final d vD = f.vK;
    public static final d vy = new e(null, false);
    public static final d vz = new e(null, true);

    private interface c {
        int a(CharSequence charSequence, int i, int i2);
    }

    private static class a implements c {
        public static final a vF = new a(true);
        public static final a vG = new a(false);
        private final boolean vE;

        public final int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                switch (e.M(Character.getDirectionality(charSequence.charAt(i5)))) {
                    case 0:
                        if (!this.vE) {
                            i4 = 1;
                            break;
                        }
                        return 0;
                    case 1:
                        if (this.vE) {
                            i4 = 1;
                            break;
                        }
                        return 1;
                    default:
                        break;
                }
            }
            if (i4 == 0) {
                return 2;
            }
            if (this.vE) {
                return 1;
            }
            return 0;
        }

        private a(boolean z) {
            this.vE = z;
        }
    }

    private static class b implements c {
        public static final b vH = new b();

        public final int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + 0;
            int i4 = 2;
            for (int i5 = 0; i5 < i3 && i4 == 2; i5++) {
                i4 = e.N(Character.getDirectionality(charSequence.charAt(i5)));
            }
            return i4;
        }

        private b() {
        }
    }

    private static abstract class d implements d {
        private final c vI;

        protected abstract boolean by();

        public d(c cVar) {
            this.vI = cVar;
        }

        public final boolean a(CharSequence charSequence, int i) {
            if (charSequence == null || i < 0 || charSequence.length() - i < 0) {
                throw new IllegalArgumentException();
            } else if (this.vI == null) {
                return by();
            } else {
                switch (this.vI.a(charSequence, 0, i)) {
                    case 0:
                        return true;
                    case 1:
                        return false;
                    default:
                        return by();
                }
            }
        }
    }

    private static class e extends d {
        private final boolean vJ;

        public e(c cVar, boolean z) {
            super(cVar);
            this.vJ = z;
        }

        protected final boolean by() {
            return this.vJ;
        }
    }

    private static class f extends d {
        public static final f vK = new f();

        public f() {
            super(null);
        }

        protected final boolean by() {
            if (f.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                return true;
            }
            return false;
        }
    }

    public static int M(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    public static int N(int i) {
        switch (i) {
            case 0:
            case 14:
            case 15:
                return 1;
            case 1:
            case 2:
            case 16:
            case 17:
                return 0;
            default:
                return 2;
        }
    }
}
