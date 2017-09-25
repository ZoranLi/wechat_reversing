package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;

public class ServicePreference extends Preference {
    private Context context;
    public b qUK;
    List<f> qUn;
    public OnItemClickListener qUq;
    public OnItemClickListener qUr;
    private OnClickListener qUs;
    private int qUt;
    private boolean qUu;
    private int qUv;

    public ServicePreference(Context context) {
        this(context, null);
    }

    public ServicePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ServicePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qUq = null;
        this.qUr = null;
        this.qUs = null;
        this.qUu = false;
        this.qUv = 0;
        this.context = context;
        setLayoutResource(R.i.cUJ);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.fpe);
        this.qUt = obtainStyledAttributes.getInt(R.n.fpf, 8);
        this.qUu = obtainStyledAttributes.getBoolean(R.n.fpg, false);
        this.qUv = obtainStyledAttributes.getResourceId(R.n.fph, 0);
        obtainStyledAttributes.recycle();
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        MMGridView mMGridView = (MMGridView) view.findViewById(R.h.bVD);
        if (mMGridView != null) {
            this.qUK = new b(this.context, this.qUn);
            an.aRr().f(this.qUK);
            an.aRr().c(this.qUK);
            mMGridView.setAdapter(this.qUK);
            mMGridView.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ ServicePreference qUL;

                {
                    this.qUL = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (this.qUL.qUK.nJ(i)) {
                        this.qUL.qUK.hS(false);
                    } else if (this.qUL.qUK.qUl) {
                        if (this.qUL.qUr != null) {
                            this.qUL.qUr.onItemClick(adapterView, view, i, j);
                        }
                    } else if (this.qUL.qUq != null) {
                        this.qUL.qUq.onItemClick(adapterView, view, i, j);
                    }
                }
            });
            if (this.qUu) {
                mMGridView.setOnItemLongClickListener(new OnItemLongClickListener(this) {
                    final /* synthetic */ ServicePreference qUL;

                    {
                        this.qUL = r1;
                    }

                    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                        ServicePreference servicePreference = this.qUL;
                        if (servicePreference.qUK != null) {
                            servicePreference.qUK.hS(!servicePreference.qUK.qUl);
                        }
                        return true;
                    }
                });
            }
            TextView textView = (TextView) view.findViewById(R.h.bMb);
            if (this.qUK.getCount() == 0) {
                textView.setVisibility(0);
                textView.setText(this.qUv);
                mMGridView.setVisibility(8);
            } else {
                textView.setVisibility(8);
                mMGridView.setVisibility(0);
            }
            Button button = (Button) view.findViewById(R.h.buS);
            button.setVisibility(this.qUt);
            button.setOnClickListener(this.qUs);
        }
    }

    public final f uw(int i) {
        if (i < 0 || i >= this.qUK.getCount()) {
            return null;
        }
        return (f) this.qUK.getItem(i);
    }

    public final void onResume() {
        if (this.qUK != null) {
            an.aRr().c(this.qUK);
        }
    }

    public final void onPause() {
        if (this.qUK != null) {
            an.aRr().f(this.qUK);
        }
    }
}
