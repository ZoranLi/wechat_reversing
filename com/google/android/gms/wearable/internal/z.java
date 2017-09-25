package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.wearable.k;
import com.google.android.gms.wearable.k.b;

public final class z implements k {

    public static class a implements b {
        private final Status aFq;
        private final int aHf;

        public a(Status status, int i) {
            this.aFq = status;
            this.aHf = i;
        }

        public final Status jv() {
            return this.aFq;
        }
    }

    public final e<b> a(c cVar, String str, String str2, byte[] bArr) {
        final String str3 = str;
        final String str4 = str2;
        final byte[] bArr2 = bArr;
        return cVar.a(new aw<b>(this, cVar) {
            final /* synthetic */ z aHp;

            protected final /* synthetic */ g b(Status status) {
                return new a(status, -1);
            }

            protected final /* synthetic */ void b(com.google.android.gms.common.api.a.b bVar) {
                ao aoVar = (ao) bVar;
                ((x) aoVar.jY()).a(new h(this), str3, str4, bArr2);
            }
        });
    }
}
