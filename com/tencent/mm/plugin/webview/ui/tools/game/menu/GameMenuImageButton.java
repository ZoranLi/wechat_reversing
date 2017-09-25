package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.R;

public class GameMenuImageButton extends LinearLayout {
    private ImageView fKf;
    public boolean siO;

    public interface a {
        void aAa();
    }

    public GameMenuImageButton(Context context) {
        super(context);
        bV(context);
    }

    public GameMenuImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bV(context);
    }

    public GameMenuImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bV(context);
    }

    private void bV(Context context) {
        this.fKf = new ImageView(context);
        this.fKf.setLayoutParams(new LayoutParams(com.tencent.mm.bg.a.U(context, R.f.aZY), com.tencent.mm.bg.a.U(context, R.f.aZY)));
        this.fKf.setScaleType(ScaleType.FIT_CENTER);
        this.fKf.setImageResource(R.g.bfv);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, com.tencent.mm.bg.a.U(context, R.f.aZX), com.tencent.mm.bg.a.U(context, R.f.aZX), 0);
        addView(this.fKf, layoutParams);
    }

    public final void a(FrameLayout frameLayout, final a aVar) {
        if (getParent() == null && frameLayout != null) {
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            frameLayout.addView(this, layoutParams);
        }
        if (this.fKf != null) {
            this.fKf.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ GameMenuImageButton siQ;

                public final void onClick(View view) {
                    if (aVar != null) {
                        aVar.aAa();
                    }
                }
            });
        }
        this.siO = true;
    }
}
