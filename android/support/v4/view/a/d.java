package android.support.v4.view.a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class d {

    static class AnonymousClass1 extends AccessibilityNodeProvider {
        final /* synthetic */ a Ao;

        AnonymousClass1(a aVar) {
            this.Ao = aVar;
        }

        public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            this.Ao.cf();
            return null;
        }

        public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return this.Ao.cd();
        }

        public final boolean performAction(int i, int i2, Bundle bundle) {
            return this.Ao.cc();
        }
    }

    interface a {
        boolean cc();

        List<Object> cd();

        Object cf();
    }
}
