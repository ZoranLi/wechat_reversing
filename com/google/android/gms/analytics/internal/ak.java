package com.google.android.gms.analytics.internal;

public final class ak extends ab<b> {

    private static class a implements com.google.android.gms.analytics.internal.ab.a<b> {
        private final q ahK;
        private final b akI = new b();

        public a(q qVar) {
            this.ahK = qVar;
        }

        public final void b(String str, boolean z) {
            if ("ga_dryRun".equals(str)) {
                this.akI.ahw = z ? 1 : 0;
                return;
            }
            this.ahK.ig().f("Bool xml configuration name not recognized", str);
        }

        public final void d(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.akI.ahv = i;
            } else {
                this.ahK.ig().f("Int xml configuration name not recognized", str);
            }
        }

        public final void g(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.akI.ahs = str2;
            } else if ("ga_appVersion".equals(str)) {
                this.akI.aht = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.akI.ahu = str2;
            } else {
                this.ahK.ig().f("String xml configuration name not recognized", str);
            }
        }

        public final /* synthetic */ aa iI() {
            return this.akI;
        }
    }

    public ak(q qVar) {
        super(qVar, new a(qVar));
    }
}
