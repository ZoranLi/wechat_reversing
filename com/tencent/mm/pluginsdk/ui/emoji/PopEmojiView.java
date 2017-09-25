package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.m.a.f;

public class PopEmojiView extends LinearLayout {
    private ViewGroup kYV;
    public MMEmojiView sRx;
    private ProgressBar sRy;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] sRz = new int[a.bGj().length];

        static {
            try {
                sRz[a.sRA - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                sRz[a.sRB - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum a {
        ;

        static {
            sRA = 1;
            sRB = 2;
            sRC = new int[]{sRA, sRB};
        }

        public static int[] bGj() {
            return (int[]) sRC.clone();
        }
    }

    public PopEmojiView(Context context) {
        super(context);
        bGi();
    }

    public PopEmojiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bGi();
    }

    public PopEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bGi();
    }

    private void bGi() {
        this.kYV = (ViewGroup) inflate(getContext(), f.lam, null);
        this.sRx = (MMEmojiView) this.kYV.findViewById(e.Kd);
        this.sRy = (ProgressBar) this.kYV.findViewById(e.progress);
        addView(this.kYV, -1, -1);
    }

    public final void xM(int i) {
        switch (AnonymousClass1.sRz[i - 1]) {
            case 1:
                this.sRx.setVisibility(4);
                this.sRy.setVisibility(0);
                return;
            case 2:
                this.sRx.setVisibility(0);
                this.sRy.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
