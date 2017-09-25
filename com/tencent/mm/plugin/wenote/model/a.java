package com.tencent.mm.plugin.wenote.model;

import com.tencent.mm.a.e;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.wenote.a.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

public final class a implements am {
    private static HashMap<Integer, c> gJr = new HashMap();
    private com.tencent.mm.plugin.wenote.a.c stw = new com.tencent.mm.plugin.wenote.a.c();
    private com.tencent.mm.plugin.wenote.a.a stx = new com.tencent.mm.plugin.wenote.a.a();
    private b sty = new b();
    public b stz = null;

    public static a bAZ() {
        a aVar = (a) ap.yR().gs("plugin.wenote");
        if (aVar != null) {
            return aVar;
        }
        Object aVar2 = new a();
        ap.yR().a("plugin.wenote", aVar2);
        return aVar2;
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        InputStream open;
        w.d("MicroMsg.SubCoreWNNoteMsg", "on account post reset");
        com.tencent.mm.sdk.b.a.urY.b(this.stw);
        com.tencent.mm.sdk.b.a.urY.b(this.stx);
        com.tencent.mm.sdk.b.a.urY.b(this.sty);
        File file = new File(h.xt());
        if (!(file.exists() && file.isDirectory())) {
            w.d("MicroMsg.SubCoreWNNoteMsg", "record stg dir[%s] not exsit, create it");
            file.mkdirs();
        }
        File file2 = new File(com.tencent.mm.ay.a.Mf());
        w.i("MicroMsg.SubCoreWNNoteMsg", "copy to path %s", new Object[]{file2.getAbsolutePath()});
        if (d.sYQ || d.sYR) {
            w.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile develop version delete template");
            e.d(file2);
        } else {
            com.tencent.mm.ay.a.idX = com.tencent.mm.ay.a.EI();
            if (z) {
                w.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need update assetVersion=%d currentVersion=%d", new Object[]{Integer.valueOf(com.tencent.mm.ay.a.EJ()), Integer.valueOf(com.tencent.mm.ay.a.idX)});
                if (com.tencent.mm.ay.a.idX < com.tencent.mm.ay.a.EJ()) {
                    e.d(file2);
                }
            } else if (com.tencent.mm.ay.a.idX == 1) {
                w.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need init template");
                e.d(file2);
            } else {
                w.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile currentVersion=%d", new Object[]{Integer.valueOf(com.tencent.mm.ay.a.idX)});
            }
        }
        if (!file2.exists()) {
            file2.mkdirs();
        }
        try {
            open = ab.getContext().getAssets().open("WNNote.zip");
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", e, "", new Object[0]);
            open = null;
        }
        if (open == null) {
            w.e("MicroMsg.SubCoreWNNoteMsg", "file inputStream not found");
            return;
        }
        File file3 = new File(file2, "WNNote.zip");
        if (file3.exists()) {
            w.i("MicroMsg.SubCoreWNNoteMsg", "wenote template already exists");
            e.b(open);
            return;
        }
        OutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file3);
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", e2, "", new Object[0]);
            fileOutputStream = null;
        }
        if (fileOutputStream != null) {
            try {
                a(open, fileOutputStream);
            } catch (Throwable e3) {
                w.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", e3, "", new Object[0]);
            }
        }
        e.b(open);
        e.a(fileOutputStream);
        int eA = bg.eA(file3.getAbsolutePath(), file3.getParent());
        if (eA < 0) {
            w.e("MicroMsg.SubCoreWNNoteMsg", "unzip fail, ret = " + eA + ", zipFilePath = " + file3.getAbsolutePath() + ", unzipPath = " + file3.getParent());
        }
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        w.d("MicroMsg.SubCoreWNNoteMsg", "on account post release");
        com.tencent.mm.sdk.b.a.urY.c(this.stw);
        com.tencent.mm.sdk.b.a.urY.c(this.stx);
        com.tencent.mm.sdk.b.a.urY.c(this.sty);
    }

    private static void a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
