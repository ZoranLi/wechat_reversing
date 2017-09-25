package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a;

import android.text.Spannable;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class a extends LinkedHashMap<Spannable, Float> {
    public long duration = 0;
    public b qgr = new b();
    public Interpolator qgs = null;
    private String qgt = "";

    public a(b bVar) {
        this.qgr = bVar;
    }

    public final boolean a(a aVar) {
        if (size() != aVar.size()) {
            return false;
        }
        for (Entry key : aVar.entrySet()) {
            if (!containsKey(key.getKey())) {
                return false;
            }
        }
        return true;
    }

    public final Spannable[] bfX() {
        ArrayList arrayList = new ArrayList();
        for (Entry key : entrySet()) {
            arrayList.add(key.getKey());
        }
        return (Spannable[]) arrayList.toArray(new Spannable[arrayList.size()]);
    }
}
