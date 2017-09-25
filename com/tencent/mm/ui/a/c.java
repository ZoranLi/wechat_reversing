package com.tencent.mm.ui.a;

import android.annotation.TargetApi;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings.Secure;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.EditText;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.a.a.AnonymousClass1;
import com.tencent.wcdb.FileUtils;
import java.lang.reflect.Method;
import java.util.Locale;

@TargetApi(14)
public final class c extends AccessibilityDelegate {
    private boolean uWY = false;

    public c() {
        boolean z;
        a aVar = a.uWW;
        AudioManager audioManager = (AudioManager) aVar.ty.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (!aVar.bQH() || (Secure.getInt(aVar.ty.getContentResolver(), "speak_password", 0) == 0 && !audioManager.isWiredHeadsetOn())) {
            z = false;
        } else {
            z = true;
        }
        this.uWY = z;
    }

    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        return null;
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
    }

    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
    }

    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
    }

    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return true;
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return true;
    }

    public final void sendAccessibilityEvent(View view, int i) {
        if (!this.uWY || view == null) {
            return;
        }
        if (i == FileUtils.S_IWUSR || i == 1) {
            CharSequence text;
            if (view instanceof EditText) {
                EditText editText = (EditText) view;
                text = !bg.J(editText.getText()) ? editText.getText() : !bg.J(editText.getContentDescription()) ? editText.getContentDescription() : editText.getHint() != null ? editText.getHint() : null;
            } else {
                text = view instanceof TextView ? bg.J(view.getContentDescription()) ? ((TextView) view).getText() : view.getContentDescription() : view.getContentDescription();
            }
            w.d("MicroMsg.MMSecureAccessibilityDelegate", "speak content: %s", text);
            if (!bg.J(text)) {
                a aVar = a.uWW;
                String charSequence = text.toString();
                if (aVar.uWU == null) {
                    aVar.uWU = new TextToSpeech(aVar.ty, new AnonymousClass1(aVar, charSequence));
                } else {
                    aVar.uWU.setLanguage(v.bIJ() ? Locale.CHINESE : Locale.ENGLISH);
                    aVar.uWU.speak(charSequence, 0, null);
                }
                Class cls = View.class;
                try {
                    Method method = cls.getMethod("clearAccessibilityFocus", new Class[0]);
                    method.setAccessible(true);
                    method.invoke(view, new Object[0]);
                    Method method2 = cls.getMethod("requestAccessibilityFocus", new Class[0]);
                    method2.setAccessible(true);
                    method2.invoke(view, new Object[0]);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.Accessibility.AccessibilityHelper", e, "", new Object[0]);
                }
                if (aVar.jYD != null) {
                    aVar.jYD = (Vibrator) ab.getContext().getSystemService("vibrator");
                }
                if (aVar.jYD != null) {
                    aVar.jYD.vibrate(50);
                }
            }
        }
    }

    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
    }
}
