package android.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class e {

    static class AnonymousClass1 extends AccessibilityNodeProvider {
        final /* synthetic */ a Ap;

        AnonymousClass1(a aVar) {
            this.Ap = aVar;
        }

        public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            this.Ap.cf();
            return null;
        }

        public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return this.Ap.cd();
        }

        public final boolean performAction(int i, int i2, Bundle bundle) {
            return this.Ap.cc();
        }

        public final AccessibilityNodeInfo findFocus(int i) {
            this.Ap.cg();
            return null;
        }
    }

    interface a {
        boolean cc();

        List<Object> cd();

        Object cf();

        Object cg();
    }
}
