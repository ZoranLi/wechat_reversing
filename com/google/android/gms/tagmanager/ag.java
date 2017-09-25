package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import java.util.Map;

final class ag implements b {
    private final Context context;

    public ag(Context context) {
        this.context = context;
    }

    public final void g(Map<String, Object> map) {
        Object obj;
        Object obj2 = map.get("gtm.url");
        if (obj2 == null) {
            obj = map.get("gtm");
            if (obj != null && (obj instanceof Map)) {
                obj = ((Map) obj).get(SlookSmartClipMetaTag.TAG_TYPE_URL);
                if (obj != null && (obj instanceof String)) {
                    String queryParameter = Uri.parse((String) obj).getQueryParameter("referrer");
                    if (queryParameter != null) {
                        l.j(this.context, queryParameter);
                        return;
                    }
                    return;
                }
            }
        }
        obj = obj2;
        if (obj != null) {
        }
    }
}
