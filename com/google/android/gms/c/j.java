package com.google.android.gms.c;

import android.os.Binder;

public abstract class j<T> {
    private static final Object agS = new Object();
    public static a azS = null;
    private static int azT = 0;
    private static String azU = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    private T akH = null;
    protected final String azV;
    protected final T azW;

    private interface a {
        Boolean kO();

        Long kP();

        Integer kQ();

        Float kR();

        String kS();
    }

    protected j(String str, T t) {
        this.azV = str;
        this.azW = t;
    }

    public static j<Float> a(String str, Float f) {
        return new j<Float>(str, f) {
            protected final /* synthetic */ Object kM() {
                return j.azS.kR();
            }
        };
    }

    public static j<Integer> a(String str, Integer num) {
        return new j<Integer>(str, num) {
            protected final /* synthetic */ Object kM() {
                return j.azS.kQ();
            }
        };
    }

    public static j<Long> a(String str, Long l) {
        return new j<Long>(str, l) {
            protected final /* synthetic */ Object kM() {
                return j.azS.kP();
            }
        };
    }

    public static j<Boolean> e(String str, boolean z) {
        return new j<Boolean>(str, Boolean.valueOf(z)) {
            protected final /* synthetic */ Object kM() {
                return j.azS.kO();
            }
        };
    }

    public static boolean isInitialized() {
        return azS != null;
    }

    public static j<String> j(String str, String str2) {
        return new j<String>(str, str2) {
            protected final /* synthetic */ Object kM() {
                return j.azS.kS();
            }
        };
    }

    public static int kL() {
        return azT;
    }

    public final T get() {
        return this.akH != null ? this.akH : kM();
    }

    protected abstract T kM();

    public final T kN() {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            T t = get();
            return t;
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }
}
