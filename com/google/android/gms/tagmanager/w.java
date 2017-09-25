package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class w {
    private static w aEm;
    volatile String aDJ = null;
    volatile int aEn = a.aEq;
    volatile String aEo = null;
    private volatile String aEp = null;

    enum a {
        ;

        static {
            aEq = 1;
            aEr = 2;
            aEs = 3;
            aEt = new int[]{aEq, aEr, aEs};
        }

        public static int[] mm() {
            return (int[]) aEt.clone();
        }
    }

    w() {
    }

    private static String an(String str) {
        return str.split("&")[0].split("=")[1];
    }

    static w ml() {
        w wVar;
        synchronized (w.class) {
            if (aEm == null) {
                aEm = new w();
            }
            wVar = aEm;
        }
        return wVar;
    }

    final synchronized boolean d(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), "UTF-8");
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    new StringBuilder("Container preview url: ").append(decode);
                    m.lU();
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.aEn = a.aEs;
                    } else {
                        this.aEn = a.aEr;
                    }
                    this.aEp = uri.getQuery().replace("&gtm_debug=x", "");
                    if (this.aEn == a.aEr || this.aEn == a.aEs) {
                        this.aEo = "/r?" + this.aEp;
                    }
                    this.aDJ = an(this.aEp);
                } else {
                    if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                        new StringBuilder("Invalid preview uri: ").append(decode);
                        m.lS();
                        z = false;
                    } else if (an(uri.getQuery()).equals(this.aDJ)) {
                        new StringBuilder("Exit preview mode for container: ").append(this.aDJ);
                        m.lU();
                        this.aEn = a.aEq;
                        this.aEo = null;
                    } else {
                        z = false;
                    }
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }
}
