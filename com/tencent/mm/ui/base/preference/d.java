package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.ui.r;
import java.util.HashMap;
import junit.framework.Assert;

final class d extends BaseAdapter {
    private final Context context;
    protected int oqL = -1;
    private final int style;
    protected String value;
    protected final HashMap<CharSequence, c> values = new HashMap();
    protected CharSequence[] vqr;
    protected CharSequence[] vqs;

    static class a {
        TextView oqM;
        CheckBox oqN;
        RadioButton oqO;

        a() {
        }
    }

    public d(Context context) {
        this.context = context;
        this.style = 1;
    }

    protected final void bSV() {
        boolean z;
        int i = 0;
        if (this.vqr == null) {
            this.vqr = new CharSequence[0];
        }
        if (this.vqs == null) {
            this.vqs = new CharSequence[0];
        }
        String str = "entries count different";
        if (this.vqr.length == this.vqs.length) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        this.values.clear();
        while (i < this.vqs.length) {
            this.values.put(this.vqs[i], new c(this.vqr[i], 1048576 + i));
            i++;
        }
    }

    public final int getCount() {
        return this.vqs.length;
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = r.eC(this.context).inflate(h.djb, null);
            a aVar = new a();
            aVar.oqM = (TextView) view.findViewById(g.text);
            aVar.oqN = (CheckBox) view.findViewById(g.bCd);
            aVar.oqO = (RadioButton) view.findViewById(g.cvd);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        aVar2.oqM.setText(this.vqr[i]);
        switch (this.style) {
            case 1:
                aVar2.oqN.setVisibility(8);
                aVar2.oqO.setVisibility(0);
                aVar2.oqO.setChecked(this.vqs[i].equals(this.value));
                break;
            case 2:
                aVar2.oqN.setVisibility(0);
                aVar2.oqO.setVisibility(8);
                aVar2.oqN.setChecked(this.vqs[i].equals(this.value));
                break;
            default:
                aVar2.oqN.setVisibility(8);
                aVar2.oqO.setVisibility(8);
                break;
        }
        return view;
    }
}
