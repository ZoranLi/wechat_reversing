package com.tencent.d.a.a;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public final class a {
    static final e wYW;
    private Context mContext;

    public static abstract class b {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void bma() {
        }

        public void onAuthenticationFailed() {
        }

        public void avy() {
        }
    }

    public static final class c {
        private d wYZ;

        public c(d dVar) {
            this.wYZ = dVar;
        }
    }

    public static class d {
        final Signature wZa;
        final Cipher wZb;
        final Mac wZc;

        public d(Signature signature) {
            this.wZa = signature;
            this.wZb = null;
            this.wZc = null;
        }

        public d(Cipher cipher) {
            this.wZb = cipher;
            this.wZa = null;
            this.wZc = null;
        }

        public d(Mac mac) {
            this.wZc = mac;
            this.wZb = null;
            this.wZa = null;
        }
    }

    private interface e {
        void a(Context context, d dVar, int i, CancellationSignal cancellationSignal, b bVar, Handler handler);

        boolean hg(Context context);

        boolean hh(Context context);
    }

    private static class a implements e {
        public final boolean hg(Context context) {
            return b.hg(context);
        }

        public final boolean hh(Context context) {
            return b.hh(context);
        }

        public final void a(final Context context, d dVar, int i, CancellationSignal cancellationSignal, final b bVar, Handler handler) {
            com.tencent.d.a.a.b.c cVar;
            com.tencent.d.a.a.b.a anonymousClass1;
            FingerprintManager hi;
            CryptoObject cryptoObject;
            if (dVar != null) {
                if (dVar.wZb != null) {
                    cVar = new com.tencent.d.a.a.b.c(dVar.wZb);
                } else if (dVar.wZa != null) {
                    cVar = new com.tencent.d.a.a.b.c(dVar.wZa);
                } else if (dVar.wZc != null) {
                    cVar = new com.tencent.d.a.a.b.c(dVar.wZc);
                }
                anonymousClass1 = new com.tencent.d.a.a.b.a() {
                    private boolean wYX = false;

                    public final void onAuthenticationError(int i, CharSequence charSequence) {
                        while (true) {
                            com.tencent.d.a.c.c.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationError", new Object[0]);
                            if (!this.wYX) {
                                this.wYX = true;
                                if (i == 5) {
                                    com.tencent.d.a.c.c.i("Soter.FingerprintManagerCompat", "soter: user cancelled fingerprint authen", new Object[0]);
                                    bVar.avy();
                                    return;
                                } else if (i == 7) {
                                    com.tencent.d.a.c.c.i("Soter.FingerprintManagerCompat", "soter: system call too many trial.", new Object[0]);
                                    if (!(c.hn(context) || c.hm(context) || c.cfH())) {
                                        c.hk(context);
                                    }
                                    this.wYX = false;
                                    i = 10308;
                                    charSequence = "Too many failed times";
                                } else {
                                    bVar.onAuthenticationError(i, charSequence);
                                    return;
                                }
                            }
                            return;
                        }
                    }

                    public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                        com.tencent.d.a.c.c.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationHelp", new Object[0]);
                        if (!this.wYX && !a.a(this, context)) {
                            bVar.onAuthenticationHelp(i, charSequence);
                        }
                    }

                    public final void a(com.tencent.d.a.a.b.b bVar) {
                        com.tencent.d.a.c.c.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationSucceeded", new Object[0]);
                        if (!this.wYX && !a.a(this, context)) {
                            d dVar;
                            c cVar;
                            if (!c.cfH()) {
                                c.hl(context);
                            }
                            this.wYX = true;
                            b bVar2 = bVar;
                            com.tencent.d.a.a.b.c cVar2 = bVar.wZe;
                            if (cVar2 != null) {
                                if (cVar2.wZb != null) {
                                    dVar = new d(cVar2.wZb);
                                } else if (cVar2.wZa != null) {
                                    dVar = new d(cVar2.wZa);
                                } else if (cVar2.wZc != null) {
                                    dVar = new d(cVar2.wZc);
                                }
                                cVar = new c(dVar);
                                bVar2.bma();
                            }
                            dVar = null;
                            cVar = new c(dVar);
                            bVar2.bma();
                        }
                    }

                    public final void onAuthenticationFailed() {
                        com.tencent.d.a.c.c.d("Soter.FingerprintManagerCompat", "soter: basic onAuthenticationFailed", new Object[0]);
                        if (!this.wYX && !a.a(this, context)) {
                            if (!c.cfH()) {
                                Context context = context;
                                c.am(context, Integer.valueOf(Integer.valueOf(c.hj(context)).intValue() + 1).intValue());
                                if (!c.hn(context)) {
                                    com.tencent.d.a.c.c.w("Soter.FingerprintManagerCompat", "soter: too many fail trials", new Object[0]);
                                    c.hk(context);
                                    a.a(this);
                                    return;
                                }
                            }
                            bVar.onAuthenticationFailed();
                        }
                    }
                };
                if (b.d(context, "android.permission.USE_FINGERPRINT") == 0) {
                    com.tencent.d.a.c.c.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: authenticate", new Object[0]);
                }
                try {
                    hi = b.hi(context);
                    if (hi == null) {
                        if (cVar != null) {
                            if (cVar.wZb != null) {
                                cryptoObject = new CryptoObject(cVar.wZb);
                            } else if (cVar.wZa != null) {
                                cryptoObject = new CryptoObject(cVar.wZa);
                            } else if (cVar.wZc != null) {
                                cryptoObject = new CryptoObject(cVar.wZc);
                            }
                            hi.authenticate(cryptoObject, cancellationSignal, 0, new com.tencent.d.a.a.b.AnonymousClass1(anonymousClass1), null);
                            return;
                        }
                        cryptoObject = null;
                        hi.authenticate(cryptoObject, cancellationSignal, 0, new com.tencent.d.a.a.b.AnonymousClass1(anonymousClass1), null);
                        return;
                    }
                    com.tencent.d.a.c.c.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in authenticate! Should never happen", new Object[0]);
                    return;
                } catch (SecurityException e) {
                    com.tencent.d.a.c.c.e("Soter.FingerprintManagerCompatApi23", "soter: triggered SecurityException in authenticate! Make sure you declared USE_FINGERPRINT in AndroidManifest.xml", new Object[0]);
                    return;
                }
            }
            cVar = null;
            anonymousClass1 = /* anonymous class already generated */;
            if (b.d(context, "android.permission.USE_FINGERPRINT") == 0) {
                hi = b.hi(context);
                if (hi == null) {
                    com.tencent.d.a.c.c.e("Soter.FingerprintManagerCompatApi23", "soter: fingerprint manager is null in authenticate! Should never happen", new Object[0]);
                    return;
                }
                if (cVar != null) {
                    if (cVar.wZb != null) {
                        cryptoObject = new CryptoObject(cVar.wZb);
                    } else if (cVar.wZa != null) {
                        cryptoObject = new CryptoObject(cVar.wZa);
                    } else if (cVar.wZc != null) {
                        cryptoObject = new CryptoObject(cVar.wZc);
                    }
                    hi.authenticate(cryptoObject, cancellationSignal, 0, new com.tencent.d.a.a.b.AnonymousClass1(anonymousClass1), null);
                    return;
                }
                cryptoObject = null;
                hi.authenticate(cryptoObject, cancellationSignal, 0, new com.tencent.d.a.a.b.AnonymousClass1(anonymousClass1), null);
                return;
            }
            com.tencent.d.a.c.c.e("Soter.FingerprintManagerCompatApi23", "soter: permission check failed: authenticate", new Object[0]);
        }

        public static boolean a(com.tencent.d.a.a.b.a aVar, Context context) {
            if (c.cfH()) {
                com.tencent.d.a.c.c.v("Soter.FingerprintManagerCompat", "soter: using system anti brute force strategy", new Object[0]);
                return false;
            } else if (c.hm(context)) {
                if (c.hn(context)) {
                    return false;
                }
                com.tencent.d.a.c.c.v("Soter.FingerprintManagerCompat", "soter: unfreeze former frozen status", new Object[0]);
                c.hl(context);
                return false;
            } else if (c.hn(context)) {
                com.tencent.d.a.c.c.v("Soter.FingerprintManagerCompat", "soter: failure time available", new Object[0]);
                return false;
            } else {
                a(aVar);
                return true;
            }
        }

        public static void a(com.tencent.d.a.a.b.a aVar) {
            com.tencent.d.a.c.c.w("Soter.FingerprintManagerCompat", "soter: too many fail fingerprint callback. inform it.", new Object[0]);
            aVar.onAuthenticationError(10308, "Too many failed times");
        }
    }

    private static class f implements e {
        public final boolean hg(Context context) {
            return false;
        }

        public final boolean hh(Context context) {
            return false;
        }

        public final void a(Context context, d dVar, int i, CancellationSignal cancellationSignal, b bVar, Handler handler) {
        }
    }

    public static a hf(Context context) {
        return new a(context);
    }

    private a(Context context) {
        this.mContext = context;
    }

    static {
        if (com.tencent.d.a.a.cfB()) {
            wYW = new a();
        } else {
            wYW = new f();
        }
    }

    public final boolean hasEnrolledFingerprints() {
        return wYW.hg(this.mContext);
    }

    public final boolean isHardwareDetected() {
        return wYW.hh(this.mContext);
    }

    public final void a(d dVar, CancellationSignal cancellationSignal, b bVar) {
        wYW.a(this.mContext, dVar, 0, cancellationSignal, bVar, null);
    }
}
