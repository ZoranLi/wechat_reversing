package com.tencent.mm.ui.a;

import android.content.Context;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.tencent.mm.s.a.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Locale;

public final class a {
    Vibrator jYD;
    private AccessibilityManager jl;
    public Context ty;
    public TextToSpeech uWU = null;

    class AnonymousClass1 implements OnInitListener {
        final /* synthetic */ String hRW;
        final /* synthetic */ a uWV;

        AnonymousClass1(a aVar, String str) {
            this.uWV = aVar;
            this.hRW = str;
        }

        public final void onInit(int i) {
            if (this.uWV.uWU != null) {
                this.uWV.uWU.setLanguage(v.bIJ() ? Locale.CHINESE : Locale.ENGLISH);
                this.uWV.uWU.speak(this.hRW, 0, null);
            }
        }
    }

    private static class a {
        public static final a uWW = new a(ab.getContext());
    }

    public a(Context context) {
        this.ty = context;
        this.jl = (AccessibilityManager) this.ty.getSystemService("accessibility");
    }

    public final boolean bQH() {
        return this.jl.isEnabled() && this.jl.isTouchExplorationEnabled();
    }

    public final void a(View view, String str, int i, String str2, String str3) {
        if (bQH() && this.ty != null && view != null && str != null && str2 != null && str3 != null) {
            b bVar = new b();
            bVar.SK(str);
            if (i > 0) {
                bVar.SK(this.ty.getResources().getQuantityString(i.heR, 1, new Object[]{Integer.valueOf(i)}));
            }
            bVar.SK(str2).SK(str3);
            bVar.cZ(view);
        }
    }

    public final void F(View view, int i) {
        if (bQH() && this.ty != null && view != null) {
            int max = Math.max(i, 1);
            b bVar = new b();
            bVar.SK(this.ty.getResources().getQuantityString(i.heQ, max, new Object[]{Integer.valueOf(max)}));
            bVar.cZ(view);
        }
    }
}
