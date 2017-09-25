package com.tencent.mm.accessibility;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ViewSearchTool {
    private static final String GET_DEFAULT_IMPL = "getDefault";
    private static final String GET_GLOBAL_INSTANCE = "getInstance";
    private static final String TAG = "ViewSearchTool";
    private static final String VIEWS_FIELD = "mViews";
    private static final String WINDOW_MANAGER_GLOBAL_CLAZZ = "android.view.WindowManagerGlobal";
    private static final String WINDOW_MANAGER_IMPL_CLAZZ = "android.view.WindowManagerImpl";
    private static final String WINDOW_PARAMS_FIELD = "mParams";

    public interface Matcher {
        boolean match(View view);
    }

    private List<View> findRoots() {
        List<View> asList;
        String str = VERSION.SDK_INT > 16 ? WINDOW_MANAGER_GLOBAL_CLAZZ : WINDOW_MANAGER_IMPL_CLAZZ;
        String str2 = VERSION.SDK_INT > 16 ? GET_GLOBAL_INSTANCE : GET_DEFAULT_IMPL;
        Class cls = Class.forName(str);
        Object invoke = cls.getMethod(str2, new Class[0]).invoke(null, new Object[0]);
        Field declaredField = cls.getDeclaredField(VIEWS_FIELD);
        declaredField.setAccessible(true);
        cls.getDeclaredField(WINDOW_PARAMS_FIELD).setAccessible(true);
        if (VERSION.SDK_INT < 19) {
            asList = Arrays.asList((View[]) declaredField.get(invoke));
        } else {
            asList = (List) declaredField.get(invoke);
        }
        if (asList.size() != 0) {
            return asList;
        }
        throw new RuntimeException("something wrong");
    }

    public List<View> findView(Matcher matcher) {
        for (View filter : findRoots()) {
            List<View> filter2 = filter(filter, matcher);
            if (filter2 != null && filter2.size() > 0) {
                return filter2;
            }
        }
        return null;
    }

    private List<View> filter(View view, Matcher matcher) {
        List<List> arrayList = new ArrayList();
        arrayList.add(0, Collections.singletonList(view));
        int i = 0;
        while (true) {
            List arrayList2 = new ArrayList();
            for (View view2 : (List) arrayList.get(i)) {
                if (view2 instanceof ViewGroup) {
                    for (int i2 = 0; i2 < ((ViewGroup) view2).getChildCount(); i2++) {
                        arrayList2.add(((ViewGroup) view2).getChildAt(i2));
                    }
                }
            }
            if (arrayList2.isEmpty()) {
                break;
            }
            int i3 = i + 1;
            arrayList.add(arrayList2);
            i = i3;
        }
        List<View> arrayList3 = new ArrayList();
        for (List<View> it : arrayList) {
            for (View view22 : it) {
                if (matcher.match(view22)) {
                    arrayList3.add(view22);
                }
            }
        }
        return arrayList3;
    }

    @Deprecated
    public static String findText(View view) {
        if (view == null) {
            return null;
        }
        CharSequence contentDescription = view.getContentDescription();
        if (contentDescription != null) {
            return contentDescription.toString();
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null && ((childAt instanceof ViewGroup) || (childAt instanceof TextView))) {
                    contentDescription = findText(childAt);
                    if (contentDescription != null) {
                        break;
                    }
                }
            }
        } else if (view instanceof TextView) {
            contentDescription = ((TextView) view).getText();
        }
        if (contentDescription != null) {
            return contentDescription.toString();
        }
        return null;
    }

    @Deprecated
    public static String findViewDepth(View view, View view2, String str) {
        if (view == null || view2 == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        if (!view.equals(view2)) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                int i = 0;
                while (i < childCount) {
                    String findViewDepth = findViewDepth(viewGroup.getChildAt(i), view2, str + "_" + i);
                    if (findViewDepth == null || findViewDepth.equals("")) {
                        i++;
                    } else {
                        if (findViewDepth.startsWith("_")) {
                            findViewDepth = findViewDepth.substring(1);
                        }
                        return findViewDepth;
                    }
                }
            }
            return null;
        } else if (str.startsWith("_")) {
            return str.substring(1);
        } else {
            return str;
        }
    }
}
