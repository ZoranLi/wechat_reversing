package com.tencent.d.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.Build.VERSION;
import com.tencent.d.a.c.f;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@SuppressLint({"NewApi"})
final class b {

    static class AnonymousClass1 extends AuthenticationCallback {
        final /* synthetic */ a wZd;

        AnonymousClass1(a aVar) {
            this.wZd = aVar;
        }

        public final void onAuthenticationError(int i, CharSequence charSequence) {
            com.tencent.d.a.c.c.d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationError", new Object[0]);
            this.wZd.onAuthenticationError(i, charSequence);
        }

        public final void onAuthenticationHelp(int i, CharSequence charSequence) {
            com.tencent.d.a.c.c.d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationHelp", new Object[0]);
            this.wZd.onAuthenticationHelp(i, charSequence);
        }

        public final void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
            c cVar;
            com.tencent.d.a.c.c.d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
            a aVar = this.wZd;
            CryptoObject cryptoObject = authenticationResult.getCryptoObject();
            if (cryptoObject != null) {
                if (cryptoObject.getCipher() != null) {
                    cVar = new c(cryptoObject.getCipher());
                } else if (cryptoObject.getSignature() != null) {
                    cVar = new c(cryptoObject.getSignature());
                } else if (cryptoObject.getMac() != null) {
                    cVar = new c(cryptoObject.getMac());
                }
                aVar.a(new b(cVar));
            }
            cVar = null;
            aVar.a(new b(cVar));
        }

        public final void onAuthenticationFailed() {
            com.tencent.d.a.c.c.d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationFailed", new Object[0]);
            this.wZd.onAuthenticationFailed();
        }
    }

    public static abstract class a {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void a(b bVar) {
        }

        public void onAuthenticationFailed() {
        }
    }

    public static final class b {
        c wZe;

        public b(c cVar) {
            this.wZe = cVar;
        }
    }

    public static class c {
        final Signature wZa;
        final Cipher wZb;
        final Mac wZc;

        public c(Signature signature) {
            this.wZa = signature;
            this.wZb = null;
            this.wZc = null;
        }

        public c(Cipher cipher) {
            this.wZb = cipher;
            this.wZa = null;
            this.wZc = null;
        }

        public c(Mac mac) {
            this.wZc = mac;
            this.wZb = null;
            this.wZa = null;
        }
    }

    static FingerprintManager hi(Context context) {
        return (FingerprintManager) context.getSystemService("fingerprint");
    }

    public static boolean hg(Context context) {
        if (d(context, "android.permission.USE_FINGERPRINT") != 0) {
            com.tencent.d.a.c.c.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: hasEnrolledFingerprints", new Object[0]);
            return false;
        }
        try {
            FingerprintManager hi = hi(context);
            if (hi != null) {
                return hi.hasEnrolledFingerprints();
            }
            com.tencent.d.a.c.c.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in hasEnrolledFingerprints! Should never happen", new Object[0]);
            return false;
        } catch (SecurityException e) {
            com.tencent.d.a.c.c.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in hasEnrolledFingerprints! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
            return false;
        }
    }

    static int d(Context context, String str) {
        if (context == null) {
            com.tencent.d.a.c.c.e("Soter.FingerprintManagerCompatApi23", "soter: check self permission: context is null", new Object[0]);
            return -1;
        } else if (f.mA(str)) {
            com.tencent.d.a.c.c.e("Soter.FingerprintManagerCompatApi23", "soter: requested permission is null or nil", new Object[0]);
            return -1;
        } else if (VERSION.SDK_INT >= 23) {
            return context.checkSelfPermission(str);
        } else {
            com.tencent.d.a.c.c.d("Soter.FingerprintManagerCompatApi23", "soter: below 23. directly return.", new Object[0]);
            return 0;
        }
    }

    public static boolean hh(Context context) {
        if (d(context, "android.permission.USE_FINGERPRINT") != 0) {
            com.tencent.d.a.c.c.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: isHardwareDetected", new Object[0]);
            return false;
        }
        try {
            FingerprintManager hi = hi(context);
            if (hi != null) {
                return hi.isHardwareDetected();
            }
            com.tencent.d.a.c.c.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in isHardwareDetected! Should never happen", new Object[0]);
            return false;
        } catch (SecurityException e) {
            com.tencent.d.a.c.c.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in isHardwareDetected! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
            return false;
        }
    }
}
