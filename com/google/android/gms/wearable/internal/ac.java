package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.wearable.m;
import com.google.android.gms.wearable.n;
import java.util.ArrayList;
import java.util.List;

public final class ac implements n {

    public static class a implements com.google.android.gms.wearable.n.a {
        private final Status aFq;
        private final List<m> aHr;

        public a(Status status, List<m> list) {
            this.aFq = status;
            this.aHr = list;
        }

        public final Status jv() {
            return this.aFq;
        }

        public final List<m> mF() {
            return this.aHr;
        }
    }

    public final e<com.google.android.gms.wearable.n.a> b(c cVar) {
        return cVar.a(new aw<com.google.android.gms.wearable.n.a>(this, cVar) {
            final /* synthetic */ ac aHq;

            protected final /* synthetic */ g b(Status status) {
                return new a(status, new ArrayList());
            }

            protected final /* synthetic */ void b(b bVar) {
                ((x) ((ao) bVar).jY()).d(new c(this));
            }
        });
    }
}
