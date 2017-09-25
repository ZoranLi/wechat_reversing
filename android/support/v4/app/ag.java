package android.support.v4.app;

import android.app.RemoteInput;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;

public final class ag extends android.support.v4.app.ai.a {
    private static final b tf;
    public static final android.support.v4.app.ai.a.a tg = new android.support.v4.app.ai.a.a() {
    };
    private final Bundle mExtras;
    private final String tb;
    private final CharSequence tc;
    private final CharSequence[] td;
    private final boolean te;

    public static final class a {
        public Bundle mExtras = new Bundle();
        public final String tb;
        public CharSequence tc;
        public CharSequence[] td;
        public boolean te = true;

        public a(String str) {
            this.tb = str;
        }
    }

    interface b {
        Bundle getResultsFromIntent(Intent intent);
    }

    static class c implements b {
        c() {
        }

        public final Bundle getResultsFromIntent(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    static class d implements b {
        d() {
        }

        public final Bundle getResultsFromIntent(Intent intent) {
            return null;
        }
    }

    static class e implements b {
        e() {
        }

        public final Bundle getResultsFromIntent(Intent intent) {
            ClipData clipData = intent.getClipData();
            if (clipData != null) {
                ClipDescription description = clipData.getDescription();
                if (description.hasMimeType("text/vnd.android.intent") && description.getLabel().equals("android.remoteinput.results")) {
                    return (Bundle) clipData.getItemAt(0).getIntent().getExtras().getParcelable("android.remoteinput.resultsData");
                }
            }
            return null;
        }
    }

    public ag(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle) {
        this.tb = str;
        this.tc = charSequence;
        this.td = charSequenceArr;
        this.te = z;
        this.mExtras = bundle;
    }

    public final String getResultKey() {
        return this.tb;
    }

    public final CharSequence getLabel() {
        return this.tc;
    }

    public final CharSequence[] getChoices() {
        return this.td;
    }

    public final boolean getAllowFreeFormInput() {
        return this.te;
    }

    public final Bundle getExtras() {
        return this.mExtras;
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        return tf.getResultsFromIntent(intent);
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            tf = new c();
        } else if (VERSION.SDK_INT >= 16) {
            tf = new e();
        } else {
            tf = new d();
        }
    }
}
