package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.signin.internal.h;
import com.google.android.gms.signin.internal.i;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

public final class b {
    public static final c aDA = new h();
    public static final c<i> aDs = new c();
    public static final c<i> aDt = new c();
    public static final a<i, e> aDu = new a<i, e>() {
        public final /* synthetic */ com.google.android.gms.common.api.a.b a(Context context, Looper looper, com.google.android.gms.common.internal.h hVar, Object obj, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.c cVar) {
            return new i(context, looper, true, hVar, bVar, cVar, Executors.newSingleThreadExecutor());
        }

        public final /* synthetic */ List jj() {
            return Arrays.asList(new Scope[]{b.aDw, b.aDx});
        }
    };
    static final a<i, Object> aDv = new a<i, Object>() {
        public final /* synthetic */ com.google.android.gms.common.api.a.b a(Context context, Looper looper, com.google.android.gms.common.internal.h hVar, Object obj, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.c cVar) {
            e eVar = e.aDB;
            return new i(context, looper, false, hVar, bVar, cVar, Executors.newSingleThreadExecutor());
        }
    };
    public static final Scope aDw = new Scope("profile");
    public static final Scope aDx = new Scope("email");
    public static final com.google.android.gms.common.api.a<e> aDy = new com.google.android.gms.common.api.a("SignIn.API", aDu, aDs);
    public static final com.google.android.gms.common.api.a<Object> aDz = new com.google.android.gms.common.api.a("SignIn.INTERNAL_API", aDv, aDt);
}
