package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory;
import android.view.View;

final class i {

    static class a implements Factory {
        final k xa;

        a(k kVar) {
            this.xa = kVar;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.xa.onCreateView(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.xa + "}";
        }
    }
}
