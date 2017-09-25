package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.a.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.avy;
import com.tencent.mm.protocal.c.eh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.c;
import java.util.LinkedList;

public final class b {

    public static class a {
        int fIL;
        String filePath;
        u jFG;
        eh jFJ;
        LinkedList<u> jFK;
        boolean jFL = true;
        String jFM;
        boolean jFN;
        c jFO;

        public a(String str, eh ehVar, LinkedList<u> linkedList, int i, boolean z, boolean z2, u uVar) {
            this.filePath = str;
            this.jFJ = ehVar;
            this.jFK = linkedList;
            this.fIL = i;
            this.jFL = z;
            this.jFN = z2;
            this.jFG = uVar;
        }

        public a(String str, eh ehVar, LinkedList<u> linkedList, int i, boolean z, String str2, boolean z2) {
            this.filePath = str;
            this.jFJ = ehVar;
            this.jFK = linkedList;
            this.fIL = i;
            this.jFL = z;
            this.jFM = str2;
            this.jFN = z2;
            this.jFG = null;
        }

        public a(String str, eh ehVar, LinkedList<u> linkedList, boolean z, boolean z2, c cVar) {
            this.filePath = str;
            this.jFJ = ehVar;
            this.jFK = linkedList;
            this.fIL = 5;
            this.jFL = z;
            this.jFN = z2;
            this.jFG = null;
            this.jFO = cVar;
        }
    }

    public static int a(a aVar) {
        int aN = e.aN(aVar.filePath);
        if (aN <= 0 || aVar.jFJ == null) {
            boolean z;
            String str = "MicroMsg.BackupPackUtil";
            StringBuilder append = new StringBuilder("filePath error or bakitem is null ").append(aVar.filePath);
            if (aVar.jFJ == null) {
                z = true;
            } else {
                z = false;
            }
            w.e(str, append.append(z).toString());
            return 0;
        } else if (aVar.jFL) {
            return aN;
        } else {
            if (aN < 8192 && aVar.jFJ.tij.tZn == 0) {
                byte[] d;
                if (aVar.fIL != 5) {
                    d = e.d(aVar.filePath, 0, -1);
                } else if (aVar.jFO == null) {
                    w.e("MicroMsg.BackupPackUtil", "MMBAK_EMOJI type but emojiInfo is null!");
                    d = null;
                } else {
                    d = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().g(aVar.jFO);
                }
                avw bb = new avw().bb(d);
                aVar.jFJ.tik = aN;
                aVar.jFJ.til = aVar.fIL;
                aVar.jFJ.tij = bb;
                return aN;
            } else if (aVar.jFK == null) {
                w.e("MicroMsg.BackupPackUtil", "error addupMediaList == null");
                return 0;
            } else {
                String str2 = aVar.jFJ.tfd.toString() + "_" + aVar.jFJ.tfe.toString() + "_" + aVar.jFJ.tfk + "_backup" + aVar.jFM;
                w.d("MicroMsg.BackupPackUtil", "filePath " + aVar.filePath + " " + str2);
                aVar.jFJ.tih.add(new avx().OV(str2));
                aVar.jFJ.tii.add(new avy().yn(aVar.fIL));
                if (aVar.jFG == null) {
                    aVar.jFG = new u();
                }
                aVar.jFG.jNZ = aVar.jFJ.tfk;
                aVar.jFG.mediaId = str2;
                aVar.jFG.path = aVar.filePath;
                aVar.jFG.type = aVar.fIL;
                if (!aVar.jFN) {
                    aVar.jFK.add(aVar.jFG);
                }
                aVar.jFJ.tig = aVar.jFJ.tih.size();
                return 0;
            }
        }
    }
}
