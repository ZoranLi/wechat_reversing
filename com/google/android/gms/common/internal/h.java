package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.e;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class h {
    public final Account akV;
    public final Set<Scope> amq;
    private final int amr;
    private final View ams;
    public final String amt;
    final String amu;
    final Set<Scope> aqm;
    public final Map<com.google.android.gms.common.api.a<?>, a> aqn;
    public final e aqo;
    public Integer aqp;

    public static final class a {
        public final Set<Scope> amK;
        public final boolean aqq;
    }

    public h(Account account, Set<Scope> set, Map<com.google.android.gms.common.api.a<?>, a> map, int i, View view, String str, String str2, e eVar) {
        Map map2;
        this.akV = account;
        this.amq = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.aqn = map2;
        this.ams = view;
        this.amr = i;
        this.amt = str;
        this.amu = str2;
        this.aqo = eVar;
        Set hashSet = new HashSet(this.amq);
        for (a aVar : this.aqn.values()) {
            hashSet.addAll(aVar.amK);
        }
        this.aqm = Collections.unmodifiableSet(hashSet);
    }
}
