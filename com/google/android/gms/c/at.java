package com.google.android.gms.c;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class at {

    public static class a {
        public final Map<String, com.google.android.gms.c.b.a> aBL;
        public final com.google.android.gms.c.b.a aBM;

        public final String toString() {
            return "Properties: " + Collections.unmodifiableMap(this.aBL) + " pushAfterEvaluate: " + this.aBM;
        }
    }

    public static class b {
        public final List<a> aBN;
        public final List<a> aBO;
        public final List<a> aBP;
        public final List<a> aBQ;
        private final List<a> aBR;
        private final List<a> aBS;

        public final String toString() {
            return "Positive predicates: " + this.aBN + "  Negative predicates: " + this.aBO + "  Add tags: " + this.aBP + "  Remove tags: " + this.aBQ + "  Add macros: " + this.aBR + "  Remove macros: " + this.aBS;
        }
    }

    public static com.google.android.gms.c.b.a a(com.google.android.gms.c.b.a aVar) {
        com.google.android.gms.c.b.a aVar2 = new com.google.android.gms.c.b.a();
        aVar2.type = aVar.type;
        aVar2.ayJ = (int[]) aVar.ayJ.clone();
        if (aVar.ayK) {
            aVar2.ayK = aVar.ayK;
        }
        return aVar2;
    }
}
