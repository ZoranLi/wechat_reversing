package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.s.a.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;

public final class DialogPreference extends Preference {
    public h oHT;
    public com.tencent.mm.ui.base.preference.Preference.a vqt;
    public final d vqv;
    public a vqw;

    public interface a {
        void bSW();
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vqv = new d(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.fpl, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(m.hfC, -1);
        if (resourceId != -1) {
            this.vqv.vqr = context.getResources().getStringArray(resourceId);
        }
        this.vqv.vqs = obtainStyledAttributes.getTextArray(m.hfD);
        obtainStyledAttributes.recycle();
        this.vqv.bSV();
    }

    public final void a(com.tencent.mm.ui.base.preference.Preference.a aVar) {
        this.vqt = aVar;
    }

    public final String getValue() {
        return this.vqv.value;
    }

    public final void setValue(String str) {
        this.vqv.value = str;
        c cVar = (c) this.vqv.values.get(str);
        if (cVar == null) {
            this.vqv.oqL = -1;
            return;
        }
        this.vqv.oqL = cVar.id;
    }

    public final void onBindView(View view) {
        c cVar = (c) this.vqv.values.get(this.vqv.value);
        if (cVar != null) {
            setSummary(cVar.text);
        }
        super.onBindView(view);
    }

    protected final void showDialog() {
        ListView listView = (ListView) View.inflate(this.mContext, com.tencent.mm.s.a.h.diA, null);
        listView.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ DialogPreference vqx;

            {
                this.vqx = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.vqx.oHT != null) {
                    this.vqx.oHT.dismiss();
                }
                this.vqx.setValue((String) this.vqx.vqv.vqs[i]);
                if (this.vqx.vqw != null) {
                    this.vqx.vqw.bSW();
                }
                if (this.vqx.vqt != null) {
                    this.vqx.vqt.a(this.vqx, this.vqx.getValue());
                }
            }
        });
        listView.setAdapter(this.vqv);
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this.mContext);
        aVar.SW(getTitle().toString());
        aVar.dd(listView);
        this.oHT = aVar.WJ();
        this.oHT.show();
        g.a(this.mContext, this.oHT);
    }
}
