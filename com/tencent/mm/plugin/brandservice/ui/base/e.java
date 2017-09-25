package com.tencent.mm.plugin.brandservice.ui.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e extends BaseAdapter {
    List<f> kbK = null;
    private Map<String, Integer> kch;
    private a kci;
    Runnable kcj = new Runnable(this) {
        final /* synthetic */ e kck;

        {
            this.kck = r1;
        }

        public final void run() {
            this.kck.W(this.kck.kbK);
        }
    };

    public interface a {
        View a(f fVar, View view, boolean z, boolean z2);
    }

    public e(a aVar) {
        if (aVar == null) {
            throw new RuntimeException("ViewCreator can not be null.");
        }
        this.kci = aVar;
        this.kbK = new ArrayList();
        this.kch = new HashMap();
    }

    public final void W(List<f> list) {
        if (this.kbK != list) {
            this.kbK.clear();
            if (list != null) {
                this.kbK.addAll(list);
            }
        }
        this.kch.clear();
        int i = 0;
        String str = null;
        while (i < this.kbK.size()) {
            f fVar = (f) this.kbK.get(i);
            String str2 = (fVar == null || fVar.kcl == null) ? null : fVar.kcl;
            if (str2 == null || str2.equalsIgnoreCase(str)) {
                str2 = str;
            } else {
                this.kch.put(str2, Integer.valueOf(i));
            }
            i++;
            str = str2;
        }
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.kbK.size();
    }

    public final Object getItem(int i) {
        return this.kbK.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z = true;
        f fVar = (f) getItem(i);
        String kk = kk(i);
        String kk2 = kk(i + 1);
        boolean z2 = i == se(kk);
        if (kk.equalsIgnoreCase(kk2)) {
            z = false;
        }
        a aVar = this.kci;
        getCount();
        return aVar.a(fVar, view, z2, z);
    }

    private String kk(int i) {
        if (i < 0 || i >= this.kbK.size()) {
            return null;
        }
        return ((f) this.kbK.get(i)).kcl;
    }

    public final int se(String str) {
        return bg.a((Integer) this.kch.get(str), -1);
    }
}
