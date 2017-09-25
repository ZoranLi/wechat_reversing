package com.tencent.mm.plugin.sight.draft.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.sight.draft.ui.b.d;

public class SightDraftContainerView extends ListView {
    private boolean pwt;
    a pwu;
    b pwv;

    public SightDraftContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public SightDraftContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SightDraftContainerView(Context context) {
        super(context);
        init();
    }

    private void init() {
        setBackgroundColor(getResources().getColor(R.e.black));
        setSelector(R.e.transparent);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.aXR);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.aXt);
        View textView = new TextView(getContext());
        textView.setText(R.l.eWF);
        textView.setTextSize(0, (float) a.T(getContext(), R.f.aXs));
        textView.setGravity(17);
        textView.setTextColor(getResources().getColor(R.e.aUp));
        textView.setTextSize(1, 11.0f);
        textView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize2);
        addFooterView(textView);
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SightDraftContainerView pww;

            {
                this.pww = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                SightDraftContainerView sightDraftContainerView = this.pww;
                if (sightDraftContainerView.pwv != null) {
                    b bVar = sightDraftContainerView.pwv;
                    bVar.a(null);
                    bVar.pvY.bcD();
                }
                return false;
            }
        });
    }

    public final void bcE() {
        if (this.pwt) {
            this.pwv.pwf = 12;
            this.pwv.a(d.NORMAL, false);
            this.pwv.a(null, null);
            setSelection(0);
            return;
        }
        this.pwt = true;
        this.pwv = new b(getContext(), this.pwu);
        this.pwv.pwf = 12;
        setAdapter(this.pwv);
    }
}
