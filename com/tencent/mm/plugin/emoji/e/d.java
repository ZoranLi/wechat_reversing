package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.io.File;
import java.util.regex.Pattern;

public class d {
    public static d kJQ;
    public boolean kJR = false;
    private Pattern kJS = Pattern.compile("_\\d");

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String iih;
        final /* synthetic */ d kJT;

        AnonymousClass1(d dVar, String str) {
            this.kJT = dVar;
            this.iih = str;
        }

        public final void run() {
            this.kJT.tZ(this.iih);
            if (this.kJT.kJR) {
                ap.yY();
                c.vr().a(a.uzP, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    public static d aly() {
        if (kJQ == null) {
            synchronized (d.class) {
                kJQ = new d();
            }
        }
        return kJQ;
    }

    public final void tZ(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (this.kJR) {
                        if (file2.isDirectory()) {
                            tZ(file2.getPath());
                        } else {
                            Object name = file2.getName();
                            if (this.kJS.matcher(name).find() || name.startsWith("temp")) {
                                file2.delete();
                            }
                        }
                        i++;
                    } else {
                        w.i("MicroMsg.emoji.EmojiFileCleanTaskManager", "stop run");
                        return;
                    }
                }
            }
        }
    }

    public final void ua(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        ua(file2.getPath());
                    } else {
                        file2.getName();
                        file2.delete();
                    }
                }
            }
        }
    }
}
