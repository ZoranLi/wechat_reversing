package com.google.android.gms.tagmanager;

final class ae extends ad {
    public static final Object aEQ = new Object();
    private static ae aEZ;
    public j aER;
    private volatile i aES;
    public int aET = 1800000;
    private boolean aEU = true;
    private boolean aEV = false;
    private boolean aEW = true;
    private k aEX = new k(this) {
        final /* synthetic */ ae aFa;

        {
            this.aFa = r1;
        }
    };
    public boolean aEY = false;
    public boolean connected = true;

    private ae() {
    }

    public static ae mp() {
        if (aEZ == null) {
            aEZ = new ae();
        }
        return aEZ;
    }

    public final synchronized void mo() {
        if (this.aEV) {
            i iVar = this.aES;
            AnonymousClass2 anonymousClass2 = new Runnable(this) {
                final /* synthetic */ ae aFa;

                {
                    this.aFa = r1;
                }

                public final void run() {
                    j jVar = this.aFa.aER;
                }
            };
        } else {
            m.lU();
            this.aEU = true;
        }
    }
}
