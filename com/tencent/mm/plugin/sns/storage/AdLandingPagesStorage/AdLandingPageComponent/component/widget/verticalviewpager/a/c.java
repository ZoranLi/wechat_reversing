package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.support.v4.app.Fragment;
import android.support.v4.app.l;
import android.support.v4.app.n;
import java.util.ArrayList;
import java.util.List;

public final class c extends n {
    public List<Fragment> pZ = new ArrayList();

    public c(l lVar, List<Fragment> list) {
        super(lVar);
        this.pZ = list;
    }

    public final Fragment I(int i) {
        return (Fragment) this.pZ.get(i);
    }

    public final int getCount() {
        return this.pZ.size();
    }

    public final CharSequence bK() {
        return "";
    }
}
