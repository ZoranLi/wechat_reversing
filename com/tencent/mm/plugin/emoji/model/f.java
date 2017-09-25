package com.tencent.mm.plugin.emoji.model;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.fj;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.c.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class f {
    public Set<String> kLR = Collections.synchronizedSet(new HashSet());
    c<fj> kLS = new c<fj>(this) {
        final /* synthetic */ f kLU;

        {
            this.kLU = r2;
            this.usg = fj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            fj fjVar = (fj) bVar;
            com.tencent.mm.storage.a.c cVar = new com.tencent.mm.storage.a.c();
            cVar.field_designerID = fjVar.fJV.fJX;
            cVar.field_name = fjVar.fJV.name;
            cVar.field_aeskey = fjVar.fJV.aeskey;
            cVar.field_encrypturl = fjVar.fJV.fJY;
            cVar.field_thumbUrl = fjVar.fJV.thumbUrl;
            cVar.field_md5 = fjVar.fJV.fFW;
            cVar.field_groupId = fjVar.fJV.fGa;
            com.tencent.mm.storage.a.c Si = h.amc().kLa.Si(cVar.EP());
            if (fjVar.fJV.fEG == 3) {
                String eN = cVar.eN(fjVar.fJV.fGa, fjVar.fJV.fFW);
                if (Si == null || (Si.field_reserved4 & com.tencent.mm.storage.a.c.uLn) != com.tencent.mm.storage.a.c.uLn) {
                    fjVar.fJW.path = eN;
                } else {
                    String absolutePath = new File(ab.getContext().getCacheDir(), g.n(fjVar.fJV.fFW.getBytes())).getAbsolutePath();
                    if (FileOp.aO(eN) && !FileOp.aO(absolutePath)) {
                        e.e(absolutePath, ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().g(Si));
                    }
                    fjVar.fJW.path = absolutePath;
                }
                w.i("MicroMsg.FTS.FTSEmojiLogic", "gen path: %s", new Object[]{fjVar.fJW.path});
            } else if (fjVar.fJV.fEG == 1) {
                w.i("MicroMsg.FTS.FTSEmojiLogic", "emoji download: %s", new Object[]{cVar.EP()});
                this.kLU.kLR.add(cVar.EP());
                h.alW().h(cVar);
            }
            return false;
        }
    };
    private a kLT = new a(this) {
        final /* synthetic */ f kLU;

        {
            this.kLU = r1;
        }

        public final void i(com.tencent.mm.storage.a.c cVar) {
            if (cVar == null || !this.kLU.kLR.remove(cVar.EP())) {
                w.i("MicroMsg.FTS.FTSEmojiLogic", "somethings error.");
                return;
            }
            w.i("MicroMsg.FTS.FTSEmojiLogic", "emojiServiceCallback onDownload %s", new Object[]{cVar.EP()});
            b fjVar = new fj();
            fjVar.fJV.fEG = 2;
            fjVar.fJV.fJX = cVar.field_designerID;
            fjVar.fJV.name = cVar.field_name;
            fjVar.fJV.aeskey = cVar.field_aeskey;
            fjVar.fJV.fJY = cVar.field_encrypturl;
            fjVar.fJV.thumbUrl = cVar.field_thumbUrl;
            fjVar.fJV.fFW = cVar.field_md5;
            fjVar.fJV.fGa = cVar.field_groupId;
            String eN = cVar.eN(cVar.field_groupId, cVar.EP());
            com.tencent.mm.storage.a.c Si = h.amc().kLa.Si(cVar.EP());
            if (Si == null || (Si.field_reserved4 & com.tencent.mm.storage.a.c.uLn) != com.tencent.mm.storage.a.c.uLn) {
                fjVar.fJW.path = eN;
            } else {
                String absolutePath = new File(ab.getContext().getExternalCacheDir(), g.n(cVar.EP().getBytes())).getAbsolutePath();
                if (FileOp.aO(eN) && !FileOp.aO(absolutePath)) {
                    e.e(absolutePath, ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().g(Si));
                }
                fjVar.fJW.path = absolutePath;
            }
            com.tencent.mm.sdk.b.a.urY.a(fjVar, Looper.getMainLooper());
        }
    };

    public f() {
        this.kLS.bIy();
    }
}
