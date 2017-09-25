package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.i;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.mm.R;

public final class e extends i {
    private Context mContext;

    public e(Context context) {
        this(context, (byte) 0);
    }

    private e(Context context, byte b) {
        super(context, R.m.fou);
        cZ();
        this.mContext = context;
    }

    public final void setContentView(int i) {
        super.setContentView(b(i, null, null));
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setLayout(-1, -1);
    }

    public final void setContentView(View view) {
        super.setContentView(b(0, view, null));
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(b(0, view, layoutParams));
    }

    private View b(int i, View view, LayoutParams layoutParams) {
        FrameLayout frameLayout;
        boolean z;
        Window window = getWindow();
        if (aKK()) {
            window.setGravity(5);
            window.setWindowAnimations(R.m.foE);
        } else {
            window.setGravity(80);
            window.setWindowAnimations(R.m.for);
        }
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.i.deW, null);
        View findViewById = viewGroup.findViewById(R.h.av);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, viewGroup, false);
        }
        if (aKK()) {
            frameLayout = (FrameLayout) viewGroup.findViewById(R.h.cjM);
        } else {
            frameLayout = (FrameLayout) viewGroup.findViewById(R.h.cjL);
        }
        frameLayout.setVisibility(0);
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        if (VERSION.SDK_INT < 11) {
            z = true;
        } else {
            TypedValue typedValue = new TypedValue();
            z = getContext().getTheme().resolveAttribute(16843611, typedValue, true) ? typedValue.data != 0 : false;
        }
        if (z) {
            findViewById.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ e sjw;

                {
                    this.sjw = r1;
                }

                public final void onClick(View view) {
                    if (this.sjw.isShowing()) {
                        this.sjw.cancel();
                    }
                }
            });
        }
        return viewGroup;
    }

    private boolean aKK() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }
}
