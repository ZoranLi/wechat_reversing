package com.tencent.d.a.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.security.keystore.KeyGenParameterSpec.Builder;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

public abstract class a {

    static class a extends a {
        public final AlgorithmParameterSpec cfI() {
            return null;
        }

        public final a J(String... strArr) {
            return null;
        }

        public final a K(String... strArr) {
            return null;
        }

        public final a cfJ() {
            return null;
        }
    }

    @TargetApi(23)
    private static class b extends a {
        private Builder wZf = null;

        public b(String str, int i) {
            this.wZf = new Builder(str, 4);
        }

        public final AlgorithmParameterSpec cfI() {
            return this.wZf.build();
        }

        @SuppressLint({"WrongConstant"})
        public final a J(String... strArr) {
            this.wZf.setDigests(strArr);
            return this;
        }

        @SuppressLint({"WrongConstant"})
        public final a K(String... strArr) {
            this.wZf.setSignaturePaddings(strArr);
            return this;
        }

        public final a cfJ() {
            this.wZf.setUserAuthenticationRequired(true);
            return this;
        }
    }

    static class c extends a {
        private final String wZg;
        private int wZh;
        private int wZi = -1;
        private AlgorithmParameterSpec wZj;
        private X500Principal wZk;
        private BigInteger wZl;
        private Date wZm;
        private Date wZn;
        private Date wZo;
        private Date wZp;
        private Date wZq;
        private String[] wZr;
        private String[] wZs;
        private String[] wZt;
        private String[] wZu;
        private boolean wZv = true;
        private boolean wZw;
        private int wZx = -1;

        public c(String str, int i) {
            if (str == null) {
                throw new NullPointerException("keystoreAlias == null");
            } else if (str.isEmpty()) {
                throw new IllegalArgumentException("keystoreAlias must not be empty");
            } else {
                this.wZg = str;
                this.wZh = 4;
            }
        }

        public final a J(String... strArr) {
            this.wZr = a.L(strArr);
            return this;
        }

        public final a K(String... strArr) {
            this.wZt = a.L(strArr);
            return this;
        }

        public final a cfJ() {
            this.wZw = true;
            return this;
        }

        public final AlgorithmParameterSpec cfI() {
            return (AlgorithmParameterSpec) Class.forName("android.security.keystore.KeyGenParameterSpec").getConstructor(new Class[]{String.class, Integer.TYPE, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, Integer.TYPE, String[].class, String[].class, String[].class, String[].class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE}).newInstance(new Object[]{this.wZg, Integer.valueOf(this.wZi), this.wZj, this.wZk, this.wZl, this.wZm, this.wZn, this.wZo, this.wZp, this.wZq, Integer.valueOf(this.wZh), this.wZr, this.wZs, this.wZt, this.wZu, Boolean.valueOf(this.wZv), Boolean.valueOf(this.wZw), Integer.valueOf(this.wZx)});
        }
    }

    public abstract a J(String... strArr);

    public abstract a K(String... strArr);

    public abstract AlgorithmParameterSpec cfI();

    public abstract a cfJ();

    public static a VI(String str) {
        if (!com.tencent.d.a.a.cfB()) {
            com.tencent.d.a.c.c.e("Soter.KeyGenParameterSpecCompatBuilder", "soter: not support soter. return dummy", new Object[0]);
            return new a();
        } else if (VERSION.SDK_INT >= 23) {
            return new b(str, 4);
        } else {
            return new c(str, 4);
        }
    }

    public static String[] L(String[] strArr) {
        return (strArr == null || strArr.length <= 0) ? strArr : (String[]) strArr.clone();
    }
}
