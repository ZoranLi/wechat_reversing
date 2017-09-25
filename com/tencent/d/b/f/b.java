package com.tencent.d.b.f;

import android.content.Context;
import com.tencent.d.b.e.c;
import com.tencent.d.b.e.f;

public final class b {
    public int hPi;
    public com.tencent.d.b.c.a lOA;
    public Context mContext;
    public String xaj;
    public c xak;
    public f xal;
    public com.tencent.d.b.c.b xam;

    public static class a {
        public b xan = new b();

        public final a Df(int i) {
            this.xan.hPi = i;
            return this;
        }

        public final a VK(String str) {
            this.xan.xaj = str;
            return this;
        }

        public final a ho(Context context) {
            this.xan.mContext = context;
            return this;
        }

        public final a a(com.tencent.d.b.c.a aVar) {
            this.xan.lOA = aVar;
            return this;
        }

        public final a a(com.tencent.d.b.c.b bVar) {
            this.xan.xam = bVar;
            return this;
        }
    }

    public final String toString() {
        return "AuthenticationParam{mScene=" + this.hPi + ", mChallenge='" + this.xaj + '\'' + ", mIWrapGetChallengeStr=" + this.xak + ", mIWrapUploadSignature=" + this.xal + ", mContext=" + this.mContext + ", mFingerprintCanceller=" + this.lOA + ", mSoterFingerprintStateCallback=" + this.xam + '}';
    }
}
