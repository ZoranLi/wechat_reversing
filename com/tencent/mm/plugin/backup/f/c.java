package com.tencent.mm.plugin.backup.f;

import android.util.Pair;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.backup.h.x;
import com.tencent.mm.plugin.backup.h.y;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.eh;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.LinkedList;

public final class c extends b {
    public static String TAG = "MicroMsg.dkBackupDataPush";
    private e htR;
    public a jHA = null;
    public x jHw = new x();
    y jHx = new y();
    int jHy = 0;
    PByteArray jHz = new PByteArray();

    private static class a {
        String filePath = null;
        int hrs = 0;
        HashSet<c> jHD = new HashSet();
        byte[] jHE = null;
        private FileInputStream jHF = null;
        int offset = 0;

        public a(String str) {
            int i;
            this.filePath = str;
            this.jHE = null;
            String str2 = this.filePath;
            ap.yY();
            if (str2.startsWith(com.tencent.mm.u.c.xi())) {
                com.tencent.mm.storage.a.c ub = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(this.filePath.substring(this.filePath.lastIndexOf("/") + 1));
                if (ub == null) {
                    i = 0;
                } else if ((ub.field_reserved4 & com.tencent.mm.storage.a.c.uLn) != com.tencent.mm.storage.a.c.uLn) {
                    i = 0;
                } else {
                    this.jHE = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().g(ub);
                    i = bg.bn(this.jHE) <= 0 ? 0 : 1;
                }
            } else {
                i = 0;
            }
            if (i != 0) {
                this.hrs = bg.bn(this.jHE);
            } else {
                this.hrs = com.tencent.mm.a.e.aN(this.filePath);
            }
            if (this.hrs < 0) {
                this.hrs = 0;
            }
        }

        final boolean a(byte[] bArr, boolean z) {
            try {
                if (this.jHF == null) {
                    this.jHF = new FileInputStream(this.filePath);
                }
                if (this.jHF.read(bArr) != bArr.length) {
                    return false;
                }
                if (z) {
                    this.jHF.close();
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    public interface b {
        void c(boolean z, String str, int i);
    }

    public interface c {
        void a(c cVar);
    }

    public static void a(b bVar, c cVar, String str, String str2, byte[] bArr) {
        int i;
        a aVar = new a(str2);
        if (aVar.hrs <= 0) {
            i = 1;
        } else {
            i = (int) (((long) aVar.hrs) / 524288);
            if (((long) aVar.hrs) % 524288 != 0) {
                i++;
            }
        }
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < i; i2++) {
            cVar.a(new c(bVar, str, aVar, bArr));
        }
    }

    public static void a(b bVar, c cVar, String str, LinkedList<eh> linkedList, byte[] bArr) {
        cVar.a(new c(bVar, str, (LinkedList) linkedList, bArr));
    }

    private c(final b bVar, String str, a aVar, byte[] bArr) {
        Pair pair;
        boolean z = true;
        this.jHw.jOf = str;
        this.jHw.jOg = 2;
        this.htR = new e(this) {
            final /* synthetic */ c jHC;

            public final void a(int i, int i2, String str, k kVar) {
                c cVar = (c) kVar;
                b bVar = bVar;
                a aVar = cVar.jHA;
                if (!aVar.jHD.contains(cVar) && cVar.jHw.jOg == 2) {
                    w.e(c.TAG, "!!!!!Error checkSceneAllFinish media scene not in sceneHashSet");
                }
                aVar.jHD.remove(cVar);
                bVar.c(aVar.jHD.isEmpty(), cVar.jHw.jOf, cVar.abx());
            }
        };
        this.jHA = aVar;
        aVar.jHD.add(this);
        a aVar2 = this.jHA;
        if (aVar2.hrs <= 0) {
            pair = new Pair(Integer.valueOf(0), new byte[0]);
        } else {
            int i = (int) (((long) (aVar2.hrs - aVar2.offset)) > 524288 ? 524288 : (long) (aVar2.hrs - aVar2.offset));
            Object obj = new byte[i];
            if (aVar2.jHE != null) {
                System.arraycopy(aVar2.jHE, aVar2.offset, obj, 0, i);
            } else {
                aVar2.a(obj, ((long) i) < 524288);
            }
            int i2 = aVar2.offset;
            aVar2.offset += i;
            pair = new Pair(Integer.valueOf(i2), obj);
        }
        if (pair.second == null || pair.first == null) {
            w.w(TAG, "doScene Error Read OVERFLOW    file:%s", new Object[]{this.jHA.filePath});
            this.jHw.jMQ = null;
            return;
        }
        byte[] bArr2 = (byte[]) pair.second;
        this.jHw.jOh = this.jHA.hrs;
        this.jHw.jOi = ((Integer) pair.first).intValue();
        this.jHw.jOj = this.jHw.jOi + bArr2.length;
        x xVar = this.jHw;
        if (this.jHw.jOj != this.jHw.jOh) {
            z = false;
        }
        xVar.jMQ = a(bArr2, z, bArr);
        abw();
    }

    private c(final b bVar, String str, LinkedList<eh> linkedList, byte[] bArr) {
        byte[] toByteArray;
        this.jHw.jOf = str;
        this.jHw.jOg = 1;
        this.htR = new e(this) {
            final /* synthetic */ c jHC;

            public final void a(int i, int i2, String str, k kVar) {
                c cVar = (c) kVar;
                bVar.c(true, cVar.jHw.jOf, cVar.abx());
            }
        };
        try {
            ei eiVar = new ei();
            eiVar.jNe = linkedList;
            eiVar.jNd = linkedList.size();
            toByteArray = eiVar.toByteArray();
        } catch (Exception e) {
            Exception exception = e;
            String str2 = TAG;
            String str3 = "ERROR: BakChatMsgList to Buffer list:%d :%s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
            objArr[1] = exception.getMessage();
            w.e(str2, str3, objArr);
            toByteArray = null;
        }
        if (toByteArray == null) {
            toByteArray = new byte[0];
        }
        this.jHw.jOi = 0;
        this.jHw.jOj = toByteArray.length;
        this.jHw.jOh = toByteArray.length;
        this.jHw.jMQ = a(toByteArray, true, bArr);
        abw();
    }

    public final void abp() {
        this.htR.a(0, this.jHx.jNB, "", this);
    }

    private void abw() {
        this.jHy = abv();
        try {
            com.tencent.mm.plugin.backup.e.c.a(this.jHw.toByteArray(), this.jHy, (short) 6, this.jHz, b.jBq);
        } catch (Throwable e) {
            w.printErrStackTrace(TAG, e, "req to buf fail: " + e.toString(), new Object[0]);
        }
    }

    public final boolean abt() {
        byte[] bArr = this.jHz.value;
        int i = this.jHy;
        long currentTimeMillis = System.currentTimeMillis();
        int j = b.jHp.j(i, bArr);
        w.i("MicroMsg.BackupBaseScene", "BackupBaseScene doscene [%d] ret:%d sendSeq:%d, type:%d, len:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(getType()), Integer.valueOf(bArr.length)});
        return true;
    }

    private static com.tencent.mm.bd.b a(byte[] bArr, boolean z, byte[] bArr2) {
        if (bg.bn(bArr2) <= 0 || bg.bn(bArr) <= 0) {
            return new com.tencent.mm.bd.b(bArr);
        }
        return new com.tencent.mm.bd.b(AesEcb.aesCryptEcb(bArr, bArr2, true, z));
    }

    public final int abx() {
        if (this.jHz.value == null) {
            return 0;
        }
        return this.jHz.value.length;
    }

    public final com.tencent.mm.bd.a abn() {
        return this.jHx;
    }

    public final com.tencent.mm.bd.a abo() {
        return this.jHw;
    }

    public final int getType() {
        return 6;
    }
}
