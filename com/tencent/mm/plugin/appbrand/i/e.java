package com.tencent.mm.plugin.appbrand.i;

import android.content.Context;
import java.util.List;

public interface e extends com.tencent.mm.kernel.c.a {

    public enum a {
        CLICK("1"),
        SWIPE("2");
        
        public final String tag;

        private a(String str) {
            this.tag = str;
        }
    }

    public static final class b {
        public String fNG;
        public List<c> hoO;
        public int jhd;
    }

    public static final class c {
        public String fFa;
        public int fWF;
        public int iPk;
        public String jhe;
        public String username;
    }

    b Ro();

    void a(Context context, c cVar, String str);

    void a(Context context, String str, a aVar);
}
