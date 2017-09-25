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

public class AppPreference extends Preference {
    private Context context;
    int qUm;
    public a qUp;
    public OnItemClickListener qUq;
    public OnItemClickListener qUr;
    private OnClickListener qUs;
    private int qUt;
    private boolean qUu;
    private int qUv;

    public AppPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qUq = null;
        this.qUr = null;
        this.qUs = null;
        this.qUm = 0;
        this.qUu = false;
        this.qUv = 0;
        this.context = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.fpe);
        this.qUt = obtainStyledAttributes.getInt(R.n.fpf, 8);
        this.qUu = obtainStyledAttributes.getBoolean(R.n.fpg, false);
        this.qUv = obtainStyledAttributes.getResourceId(R.n.fph, 0);
        obtainStyledAttributes.recycle();
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        MMGridView mMGridView = (MMGridView) view.findViewById(R.h.bVD);
        this.qUp = new a(this.context, this.qUm);
        mMGridView.setAdapter(this.qUp);
        mMGridView.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ AppPreference qUw;

            {
                this.qUw = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.qUw.qUp.nJ(i)) {
                    this.qUw.qUp.hS(false);
                } else if (this.qUw.qUp.qUl) {
                    if (this.qUw.qUr != null) {
                        this.qUw.qUr.onItemClick(adapterView, view, i, j);
                    }
                } else if (this.qUw.qUq != null) {
                    this.qUw.qUq.onItemClick(adapterView, view, i, j);
                }
            }
        });
        if (this.qUu) {
            mMGridView.setOnItemLongClickListener(new OnItemLongClickListener(this) {
                final /* synthetic */ AppPreference qUw;

                {
                    this.qUw = r1;
                }

                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppPreference appPreference = this.qUw;
                    if (appPreference.qUp != null) {
                        appPreference.qUp.hS(!appPreference.qUp.qUl);
                    }
                    return true;
                }
            });
        }
        TextView textView = (TextView) view.findViewById(R.h.bMb);
        if (this.qUp.getCount() == 0) {
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

    public final f uw(int i) {
        if (i < 0 || i >= this.qUp.getCount()) {
            return null;
        }
        return (f) this.qUp.getItem(i);
    }

    public final void onResume() {
        if (this.qUp != null) {
            an.aRr().c(this.qUp);
        }
    }

    public final void onPause() {
        if (this.qUp != null) {
            an.aRr().f(this.qUp);
        }
    }
}
