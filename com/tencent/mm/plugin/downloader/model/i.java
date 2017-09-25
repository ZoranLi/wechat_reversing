package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;

public abstract class i implements n {
    protected b kGM;

    public i(b bVar) {
        this.kGM = bVar;
    }

    public static void tQ(String str) {
        if (!bg.mA(str)) {
            if (new File(str).exists()) {
                w.i("MicroMsg.FileDownloaderImplBase", "Delete previous file result: %b", Boolean.valueOf(new File(str).delete()));
            }
        }
    }
}
