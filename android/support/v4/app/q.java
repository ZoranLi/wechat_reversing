package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class q {

    static class AnonymousClass2 implements OnPreDrawListener {
        final /* synthetic */ View rf;
        final /* synthetic */ Transition rg;
        final /* synthetic */ View rh;
        final /* synthetic */ b ri;
        final /* synthetic */ Map rj;
        final /* synthetic */ Map rk;
        final /* synthetic */ ArrayList rl;

        AnonymousClass2(View view, Transition transition, View view2, b bVar, Map map, Map map2, ArrayList arrayList) {
            this.rf = view;
            this.rg = transition;
            this.rh = view2;
            this.ri = bVar;
            this.rj = map;
            this.rk = map2;
            this.rl = arrayList;
        }

        public final boolean onPreDraw() {
            this.rf.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.rg != null) {
                this.rg.removeTarget(this.rh);
            }
            View view = this.ri.getView();
            if (view != null) {
                if (!this.rj.isEmpty()) {
                    q.a(this.rk, view);
                    this.rk.keySet().retainAll(this.rj.values());
                    for (Entry entry : this.rj.entrySet()) {
                        View view2 = (View) this.rk.get((String) entry.getValue());
                        if (view2 != null) {
                            view2.setTransitionName((String) entry.getKey());
                        }
                    }
                }
                if (this.rg != null) {
                    q.a(this.rl, view);
                    this.rl.removeAll(this.rk.values());
                    this.rl.add(this.rh);
                    q.b(this.rg, this.rl);
                }
            }
            return true;
        }
    }

    static class AnonymousClass3 extends EpicenterCallback {
        private Rect rm;
        final /* synthetic */ a rn;

        AnonymousClass3(a aVar) {
            this.rn = aVar;
        }

        public final Rect onGetEpicenter(Transition transition) {
            if (this.rm == null && this.rn.rt != null) {
                this.rm = q.y(this.rn.rt);
            }
            return this.rm;
        }
    }

    static class AnonymousClass4 implements OnPreDrawListener {
        final /* synthetic */ View oi;
        final /* synthetic */ ArrayList ok;
        final /* synthetic */ Transition rg;
        final /* synthetic */ View rh;
        final /* synthetic */ Map rk;
        final /* synthetic */ ArrayList rl;
        final /* synthetic */ Transition ro;
        final /* synthetic */ ArrayList rp;
        final /* synthetic */ Transition rq;
        final /* synthetic */ ArrayList rr;
        final /* synthetic */ Transition rs;

        AnonymousClass4(View view, Transition transition, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4, View view2) {
            this.oi = view;
            this.rg = transition;
            this.rl = arrayList;
            this.ro = transition2;
            this.rp = arrayList2;
            this.rq = transition3;
            this.ok = arrayList3;
            this.rk = map;
            this.rr = arrayList4;
            this.rs = transition4;
            this.rh = view2;
        }

        public final boolean onPreDraw() {
            this.oi.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.rg != null) {
                q.a(this.rg, this.rl);
            }
            if (this.ro != null) {
                q.a(this.ro, this.rp);
            }
            if (this.rq != null) {
                q.a(this.rq, this.ok);
            }
            for (Entry entry : this.rk.entrySet()) {
                ((View) entry.getValue()).setTransitionName((String) entry.getKey());
            }
            int size = this.rr.size();
            for (int i = 0; i < size; i++) {
                this.rs.excludeTarget((View) this.rr.get(i), false);
            }
            this.rs.excludeTarget(this.rh, false);
            return true;
        }
    }

    public static class a {
        public View rt;
    }

    public interface b {
        View getView();
    }

    public static Object e(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return obj;
    }

    public static void a(Object obj, View view, boolean z) {
        ((Transition) obj).excludeTarget(view, z);
    }

    public static void a(Object obj, View view) {
        Transition transition = (Transition) obj;
        final Rect y = y(view);
        transition.setEpicenterCallback(new EpicenterCallback() {
            public final Rect onGetEpicenter(Transition transition) {
                return y;
            }
        });
    }

    public static void a(Object obj, View view, Map<String, View> map, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        arrayList.clear();
        arrayList.addAll(map.values());
        List targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view2 = (View) arrayList.get(i);
            int size2 = targets.size();
            if (!a(targets, view2, size2)) {
                targets.add(view2);
                for (int i2 = size2; i2 < targets.size(); i2++) {
                    view2 = (View) targets.get(i2);
                    if (view2 instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view2;
                        int childCount = viewGroup.getChildCount();
                        for (int i3 = 0; i3 < childCount; i3++) {
                            View childAt = viewGroup.getChildAt(i3);
                            if (!a(targets, childAt, size2)) {
                                targets.add(childAt);
                            }
                        }
                    }
                }
            }
        }
        arrayList.add(view);
        b(transitionSet, arrayList);
    }

    private static boolean a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    public static Rect y(View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        return rect;
    }

    public static void a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.isTransitionGroup()) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a((ArrayList) arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    public static void a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a((Map) map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public static void a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            for (int i = 0; i < transitionCount; i++) {
                a(transitionSet.getTransitionAt(i), (ArrayList) arrayList);
            }
        } else if (!a(transition)) {
            List targets = transition.getTargets();
            if (targets != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                for (transitionCount = arrayList.size() - 1; transitionCount >= 0; transitionCount--) {
                    transition.removeTarget((View) arrayList.get(transitionCount));
                }
            }
        }
    }

    public static void b(Object obj, ArrayList<View> arrayList) {
        int i = 0;
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                b(transitionSet.getTransitionAt(i), arrayList);
                i++;
            }
        } else if (!a(transition) && d(transition.getTargets())) {
            int size = arrayList.size();
            for (transitionCount = 0; transitionCount < size; transitionCount++) {
                transition.addTarget((View) arrayList.get(transitionCount));
            }
        }
    }

    private static boolean a(Transition transition) {
        return (d(transition.getTargetIds()) && d(transition.getTargetNames()) && d(transition.getTargetTypes())) ? false : true;
    }

    private static boolean d(List list) {
        return list == null || list.isEmpty();
    }
}
