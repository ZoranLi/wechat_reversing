package com.tencent.d.b.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.d.a.a.a.d;
import com.tencent.d.b.c.b;
import com.tencent.d.b.e.c;
import com.tencent.d.b.e.f;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.lang.ref.WeakReference;
import java.security.Signature;
import junit.framework.Assert;

public final class h extends d implements a {
    private int hPi = -1;
    private String wZW = null;
    private c xaF = null;
    f xaG = null;
    private WeakReference<Context> xaH = null;
    public com.tencent.d.b.c.a xaI = null;
    public b xaJ = null;
    public com.tencent.d.a.c.h xaK = null;
    private a xaL = null;
    public boolean xaM;
    public boolean xaN;
    public boolean xaO;
    public String xaj = null;

    private class a extends com.tencent.d.a.a.a.b {
        final /* synthetic */ h xaP;
        public Signature xaQ = null;

        public a(h hVar, Signature signature) {
            this.xaP = hVar;
            this.xaQ = signature;
        }

        public static String S(CharSequence charSequence) {
            return charSequence == null ? "unknown error" : charSequence.toString();
        }

        public final void onAuthenticationError(final int i, final CharSequence charSequence) {
            com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: on authentication fatal error: %d, %s", Integer.valueOf(i), charSequence);
            if (i != 10308) {
                g.cfZ().v(new Runnable(this) {
                    final /* synthetic */ a xaT;

                    public final void run() {
                        if (this.xaT.xaP.xaJ != null) {
                            this.xaT.xaP.xaJ.onAuthenticationError(i, charSequence);
                        }
                    }
                });
                this.xaP.b(new com.tencent.d.b.a.a(21, S(charSequence)));
            } else {
                this.xaP.b(new com.tencent.d.b.a.a(25, S(charSequence)));
            }
            cgb();
        }

        public final void onAuthenticationHelp(final int i, final CharSequence charSequence) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: on authentication help. you do not need to cancel the authentication: %d, %s", Integer.valueOf(i), charSequence);
            g.cfZ().v(new Runnable(this) {
                final /* synthetic */ a xaT;

                public final void run() {
                    if (this.xaT.xaP.xaJ != null) {
                        this.xaT.xaP.xaJ.onAuthenticationHelp(i, a.S(charSequence));
                    }
                }
            });
        }

        public final void bma() {
            com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: authentication succeed. start sign and upload upload signature", new Object[0]);
            g.cfZ().y(new Runnable(this) {
                final /* synthetic */ a xaT;

                {
                    this.xaT = r1;
                }

                public final void run() {
                    if (com.tencent.d.a.c.f.mA(this.xaT.xaP.xaj)) {
                        com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: challenge is null. should not happen here", new Object[0]);
                        this.xaT.onAuthenticationError(DownloadResult.CODE_UNDEFINED, "challenge is null");
                        return;
                    }
                    try {
                        this.xaT.xaQ.update(this.xaT.xaP.xaj.getBytes());
                        h hVar = this.xaT.xaP;
                        try {
                            hVar.xaK = com.tencent.d.a.a.bC(this.xaT.xaQ.sign());
                            if (hVar.xaG == null) {
                                com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: no upload wrapper, return directly", new Object[0]);
                                hVar.b(new com.tencent.d.b.a.a(hVar.xaK));
                            } else if (hVar.xaK == null) {
                                hVar.b(new com.tencent.d.b.a.a(22, "sign failed even after user authenticated the key."));
                            } else {
                                hVar.xaG.aS(new com.tencent.d.b.e.f.a(hVar.xaK.signature, hVar.xaK.wZN, hVar.xaK.wZM));
                                hVar.xaG.a(new com.tencent.d.b.e.b<f.b>(hVar) {
                                    final /* synthetic */ h xaP;

                                    {
                                        this.xaP = r1;
                                    }

                                    public final /* synthetic */ void bV(Object obj) {
                                        if (((f.b) obj).lva) {
                                            com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: upload and verify succeed", new Object[0]);
                                            this.xaP.b(new com.tencent.d.b.a.a(this.xaP.xaK));
                                            return;
                                        }
                                        com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: upload or verify failed", new Object[0]);
                                        this.xaP.b(new com.tencent.d.b.a.a(23));
                                    }
                                });
                                hVar.xaG.execute();
                            }
                        } catch (Exception e) {
                            com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: sign failed due to exception: %s", e.getMessage());
                            com.tencent.d.a.c.c.a("Soter.TaskAuthentication", e, "soter: sign failed due to exception");
                            hVar.b(new com.tencent.d.b.a.a(22, "sign failed even after user authenticated the key."));
                        }
                    } catch (Exception e2) {
                        com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: exception in update", new Object[0]);
                        com.tencent.d.a.c.c.a("Soter.TaskAuthentication", e2, "soter: exception in update");
                        this.xaT.onAuthenticationError(DownloadResult.CODE_UNDEFINED, "update signature failed");
                    }
                }
            });
            g.cfZ().v(new Runnable(this) {
                final /* synthetic */ a xaT;

                {
                    this.xaT = r1;
                }

                public final void run() {
                    if (this.xaT.xaP.xaJ != null) {
                        this.xaT.xaP.xaJ.avx();
                    }
                }
            });
            cgb();
        }

        public final void onAuthenticationFailed() {
            super.onAuthenticationFailed();
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: authentication failed once", new Object[0]);
            g.cfZ().v(new Runnable(this) {
                final /* synthetic */ a xaT;

                {
                    this.xaT = r1;
                }

                public final void run() {
                    if (this.xaT.xaP.xaJ != null) {
                        this.xaT.xaP.xaJ.onAuthenticationFailed();
                    }
                }
            });
            if (this.xaP.xaM) {
                com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: should compat lower android version logic.", new Object[0]);
                this.xaP.xaI.mh(false);
                g.cfZ().y(new Runnable(this) {
                    final /* synthetic */ a xaT;

                    {
                        this.xaT = r1;
                    }

                    public final void run() {
                        this.xaT.xaP.xaI.cfR();
                    }
                });
                g.cfZ().i(new Runnable(this) {
                    final /* synthetic */ a xaT;

                    {
                        this.xaT = r1;
                    }

                    public final void run() {
                        this.xaT.xaP.a(this.xaT.xaQ);
                    }
                }, 1000);
            }
        }

        public final void avy() {
            com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: called onAuthenticationCancelled", new Object[0]);
            if (this.xaP.xaO) {
                com.tencent.d.a.c.c.v("Soter.TaskAuthentication", "soter: during ignore cancel period", new Object[0]);
                return;
            }
            super.avy();
            g.cfZ().v(new Runnable(this) {
                final /* synthetic */ a xaT;

                {
                    this.xaT = r1;
                }

                public final void run() {
                    if (this.xaT.xaP.xaJ != null) {
                        this.xaT.xaP.xaJ.avy();
                    }
                }
            });
            this.xaP.b(new com.tencent.d.b.a.a(24, "user cancelled authentication"));
            cgb();
        }

        @SuppressLint({"NewApi"})
        private void cgb() {
            if (this.xaP.xaN) {
                this.xaP.xaI.mh(false);
                this.xaP.xaO = true;
            }
        }
    }

    public h(b bVar) {
        boolean z = true;
        boolean z2 = VERSION.SDK_INT < 23 && Build.MANUFACTURER.equalsIgnoreCase("vivo");
        this.xaM = z2;
        if (VERSION.SDK_INT >= 23) {
            z = false;
        }
        this.xaN = z;
        this.xaO = false;
        if (bVar == null) {
            throw new IllegalArgumentException("param is null!");
        }
        this.hPi = bVar.hPi;
        this.xaF = bVar.xak;
        this.xaG = bVar.xal;
        this.xaH = new WeakReference(bVar.mContext);
        this.xaJ = bVar.xam;
        this.xaI = bVar.lOA;
        this.xaj = bVar.xaj;
    }

    @SuppressLint({"DefaultLocale", "NewApi"})
    final boolean cfV() {
        if (!com.tencent.d.b.b.a.cfM().isInit()) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: not initialized yet", new Object[0]);
            b(new com.tencent.d.b.a.a(14));
            return true;
        } else if (com.tencent.d.b.b.a.cfM().cfL()) {
            boolean z;
            if (VERSION.SDK_INT >= 16) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            this.wZW = (String) com.tencent.d.b.b.a.cfM().cfO().get(this.hPi, "");
            if (com.tencent.d.a.c.f.mA(this.wZW)) {
                com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
                b(new com.tencent.d.b.a.a(15, String.format("auth scene %d not initialized in map", new Object[]{Integer.valueOf(this.hPi)})));
                return true;
            } else if (!com.tencent.d.a.a.cfE()) {
                com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: app secure key not exists. need re-generate", new Object[0]);
                b(new com.tencent.d.b.a.a(3));
                return true;
            } else if (!com.tencent.d.a.a.VD(this.wZW)) {
                com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: auth key %s not exists. need re-generate", this.wZW);
                b(new com.tencent.d.b.a.a(12, String.format("the auth key to scene %d not exists. it may because you haven't prepare it, or user removed them already in system settings. please prepare the key again", new Object[]{Integer.valueOf(this.hPi)})));
                return true;
            } else if (!com.tencent.d.a.a.VE(this.wZW)) {
                com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: auth key %s has already expired, and we've already deleted them. need re-generate", this.wZW);
                b(new com.tencent.d.b.a.a(11, String.format("the auth key to scene %d has already been expired. in Android versions above 6.0, a key would be expired when user enrolls a new fingerprint. please prepare the key again", new Object[]{Integer.valueOf(this.hPi)})));
                return true;
            } else if (this.xaF == null && com.tencent.d.a.c.f.mA(this.xaj)) {
                com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: challenge wrapper is null!", new Object[0]);
                b(new com.tencent.d.b.a.a(16, "neither get challenge wrapper nor challenge str is found in request parameter"));
                return true;
            } else {
                Context context = (Context) this.xaH.get();
                if (context == null) {
                    com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: context instance released in preExecute", new Object[0]);
                    b(new com.tencent.d.b.a.a(17));
                    return true;
                } else if (!com.tencent.d.a.a.a.hf(context).hasEnrolledFingerprints()) {
                    com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: user has not enrolled any fingerprint in system.", new Object[0]);
                    b(new com.tencent.d.b.a.a(18));
                    return true;
                } else if (com.tencent.d.a.a.he(context)) {
                    com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: fingerprint sensor frozen", new Object[0]);
                    b(new com.tencent.d.b.a.a(25, "Too many failed times"));
                    return true;
                } else if (this.xaI == null) {
                    com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: did not pass cancellation obj. We suggest you pass one", new Object[0]);
                    this.xaI = new com.tencent.d.b.c.a();
                    return false;
                } else {
                    if (this.xaG == null) {
                        com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "hy: we strongly recommend you to check the final authentication data in server! Please make sure you upload and check later", new Object[0]);
                    }
                    return false;
                }
            }
        } else {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: not support soter", new Object[0]);
            b(new com.tencent.d.b.a.a(2));
            return true;
        }
    }

    final void cfW() {
        if (this.xaI != null) {
            this.xaI.mh(true);
        }
    }

    final void execute() {
        if (com.tencent.d.a.c.f.mA(this.xaj)) {
            com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: not provide the challenge. we will do the job", new Object[0]);
            this.xaF.aS(new com.tencent.d.b.e.c.a());
            this.xaF.a(new com.tencent.d.b.e.b<c.b>(this) {
                final /* synthetic */ h xaP;

                {
                    this.xaP = r1;
                }

                public final /* synthetic */ void bV(Object obj) {
                    c.b bVar = (c.b) obj;
                    if (com.tencent.d.a.c.f.mA(bVar.lOH)) {
                        com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: get challenge failed", new Object[0]);
                        this.xaP.b(new com.tencent.d.b.a.a(19));
                        return;
                    }
                    this.xaP.xaj = bVar.lOH;
                    this.xaP.cga();
                }
            });
            this.xaF.execute();
            return;
        }
        com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: already provided the challenge. directly authenticate", new Object[0]);
        cga();
    }

    public final void cga() {
        Signature VG = com.tencent.d.a.a.VG(this.wZW);
        if (VG == null) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: error occurred when init sign", new Object[0]);
            b(new com.tencent.d.b.a.a(13));
            return;
        }
        this.xaL = new a(this, VG);
        a(VG);
        g.cfZ().v(new Runnable(this) {
            final /* synthetic */ h xaP;

            {
                this.xaP = r1;
            }

            public final void run() {
                if (this.xaP.xaJ != null) {
                    this.xaP.xaJ.avw();
                }
            }
        });
    }

    @SuppressLint({"NewApi"})
    public final void a(Signature signature) {
        if (this.xaa) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: already finished. can not authenticate", new Object[0]);
            return;
        }
        Context context = (Context) this.xaH.get();
        if (context == null) {
            com.tencent.d.a.c.c.w("Soter.TaskAuthentication", "soter: context instance released in startAuthenticate", new Object[0]);
            b(new com.tencent.d.b.a.a(17));
            return;
        }
        try {
            com.tencent.d.a.c.c.v("Soter.TaskAuthentication", "soter: performing start", new Object[0]);
            com.tencent.d.a.a.a.hf(context).a(new d(signature), this.xaI != null ? this.xaI.wZS : null, this.xaL);
        } catch (Exception e) {
            String message = e.getMessage();
            com.tencent.d.a.c.c.e("Soter.TaskAuthentication", "soter: caused exception when authenticating: %s", message);
            com.tencent.d.a.c.c.a("Soter.TaskAuthentication", e, "soter: caused exception when authenticating");
            b(new com.tencent.d.b.a.a(20, String.format("start authentication failed due to %s", new Object[]{message})));
        }
    }

    public final void cfU() {
        com.tencent.d.a.c.c.i("Soter.TaskAuthentication", "soter: called from cancellation signal", new Object[0]);
        if (this.xaL != null) {
            this.xaL.avy();
        }
    }

    public final boolean isCancelled() {
        return this.xaO;
    }
}
