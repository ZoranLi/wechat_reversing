package com.tencent.mm.accessibility;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.View;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.FileUtils;

public class Util {
    public static Activity getActivityOfView(View view) {
        if (view == null) {
            return null;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public static boolean resourceHasPackage(int i) {
        return (i >>> 24) != 0;
    }

    public static String getViewIdName(View view) {
        if (view == null) {
            return "NO_ID";
        }
        int id = view.getId();
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
        if (id != -1) {
            Resources resources = view.getResources();
            if (resourceHasPackage(id) && resources != null) {
                String str;
                switch (WebView.NIGHT_MODE_COLOR & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (Throwable th) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        return stringBuilder.toString();
    }
}
