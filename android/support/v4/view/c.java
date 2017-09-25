package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

final class c {

    static class AnonymousClass1 extends AccessibilityDelegate {
        final /* synthetic */ a wv;

        AnonymousClass1(a aVar) {
            this.wv = aVar;
        }

        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.wv.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.wv.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.wv.b(view, accessibilityNodeInfo);
        }

        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.wv.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.wv.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        public final void sendAccessibilityEvent(View view, int i) {
            this.wv.sendAccessibilityEvent(view, i);
        }

        public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.wv.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }

        public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            return (AccessibilityNodeProvider) this.wv.B(view);
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.wv.performAccessibilityAction(view, i, bundle);
        }
    }

    public interface a {
        Object B(View view);

        void b(View view, Object obj);

        boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent);

        boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        boolean performAccessibilityAction(View view, int i, Bundle bundle);

        void sendAccessibilityEvent(View view, int i);

        void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent);
    }
}
