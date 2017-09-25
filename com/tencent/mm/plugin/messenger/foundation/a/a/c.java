package com.tencent.mm.plugin.messenger.foundation.a.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.storage.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public interface c extends f {

    public interface a {
        void a(c cVar, c cVar2);
    }

    public static class b {
        public long hFg;
        public String name;
        public a[] nyK;
        public int nyL;

        private static class a {
            public long nyM;
            public long nyN;
        }

        public b(int i, String str, a[] aVarArr) {
            boolean z;
            boolean z2 = true;
            Assert.assertTrue(str.length() > 0);
            this.name = str;
            if (aVarArr.length == 2) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            Assert.assertTrue(aVarArr[0].nyN >= aVarArr[0].nyM);
            Assert.assertTrue(aVarArr[1].nyN >= aVarArr[1].nyM);
            if (aVarArr[1].nyM < aVarArr[0].nyN) {
                z2 = false;
            }
            Assert.assertTrue(z2);
            this.nyK = aVarArr;
            this.nyL = i;
            this.hFg = aVarArr[0].nyM;
        }

        public final synchronized void aKj() {
            if (this.hFg == this.nyK[0].nyN) {
                this.hFg = this.nyK[1].nyM;
                com.tencent.mm.plugin.report.c.oTb.a(111, 251, 1, false);
            } else {
                this.hFg++;
            }
            if (!com.tencent.mm.sdk.a.b.bIw()) {
                w.i("MicroMsg.MsgTable", "incMsgLocalId %d  ", Long.valueOf(this.hFg));
            }
        }

        public final boolean cF(long j) {
            for (a aVar : this.nyK) {
                boolean z = j >= aVar.nyM && j <= aVar.nyN;
                if (z) {
                    return true;
                }
            }
            return false;
        }

        public static a[] a(long j, long j2, long j3, long j4) {
            a[] aVarArr = new a[2];
            a aVar = new a();
            aVar.nyM = j;
            aVar.nyN = j2;
            aVarArr[0] = aVar;
            aVar = new a();
            aVar.nyM = j3;
            aVar.nyN = j4;
            aVarArr[1] = aVar;
            return aVarArr;
        }
    }

    public static class c {
        public String fJL;
        public long kbc;
        public String nyO;
        public ArrayList<au> nyP;
        public int nyQ;
        public int nyR;
        public int nyS;
        public long nyT;

        public c(String str, String str2, au auVar) {
            this(str, str2, auVar, 0);
        }

        public c(String str, String str2, au auVar, int i) {
            long j = -1;
            this.nyP = new ArrayList();
            this.nyR = 0;
            this.nyS = 0;
            this.nyT = 0;
            this.kbc = -1;
            this.fJL = str;
            this.nyO = str2;
            this.nyQ = i;
            if (auVar != null) {
                j = auVar.field_bizChatId;
            }
            this.kbc = j;
            if (auVar != null) {
                this.nyP.add(auVar);
            }
        }

        public c(String str, String str2, int i) {
            this(str, str2, null, 0);
            this.nyS = i;
        }

        public static boolean O(au auVar) {
            return auVar != null && auVar.field_isSend == 0 && auVar.field_status == 3;
        }
    }

    List<au> A(String str, long j);

    int AA(String str);

    String AB(String str);

    long AC(String str);

    long AD(String str);

    long AE(String str);

    au AF(String str);

    int AG(String str);

    void Ae(String str);

    void Af(String str);

    Cursor Ag(String str);

    au Ah(String str);

    au Ai(String str);

    au Aj(String str);

    au Ak(String str);

    List<au> Al(String str);

    Cursor Am(String str);

    void An(String str);

    int Ao(String str);

    boolean Ap(String str);

    int Aq(String str);

    Cursor Ar(String str);

    Cursor As(String str);

    com.tencent.mm.storage.au.c At(String str);

    d Au(String str);

    com.tencent.mm.storage.au.a Av(String str);

    com.tencent.mm.storage.au.b Aw(String str);

    int Ax(String str);

    boolean Ay(String str);

    int Az(String str);

    Cursor B(String str, String str2, int i);

    List<au> B(String str, long j);

    boolean C(String str, long j);

    long D(String str, long j);

    List<au> D(String str, int i, int i2);

    int E(String str, long j);

    Cursor E(String str, int i, int i2);

    int F(String str, long j);

    int G(String str, long j);

    String H(String str, long j);

    au I(String str, long j);

    long J(String str, long j);

    void J(ArrayList<Long> arrayList);

    int K(au auVar);

    long K(String str, long j);

    long L(au auVar);

    void M(au auVar);

    int N(au auVar);

    Cursor a(String str, long j, long j2, int i);

    Cursor a(String str, long j, long j2, boolean z);

    void a(long j, au auVar);

    void a(g gVar, String str);

    void a(a aVar);

    void a(a aVar, Looper looper);

    void a(b bVar);

    void a(c cVar);

    void a(e eVar);

    boolean a(long j, String str, String str2, String str3);

    g aJZ();

    void aKa();

    void aKb();

    void aKc();

    ArrayList<au> aKd();

    List<au> aKe();

    Cursor aKf();

    Cursor aKg();

    String aKh();

    String aKi();

    long b(au auVar, boolean z);

    void b(long j, au auVar);

    void b(String str, String str2, String[] strArr);

    List<au> bd(String str, int i);

    List<au> be(String str, int i);

    Cursor bf(String str, int i);

    Cursor bg(String str, int i);

    int bh(String str, int i);

    Cursor bi(String str, int i);

    Cursor bj(String str, int i);

    Cursor bk(String str, int i);

    int bl(String str, int i);

    Cursor bm(String str, int i);

    au[] bn(String str, int i);

    int c(String str, long j, int i);

    List<au> c(String str, long j, boolean z);

    au cA(long j);

    int cB(long j);

    boolean cC(long j);

    boolean cD(long j);

    void cE(long j);

    au cN(String str, String str2);

    Cursor cO(String str, String str2);

    int cP(String str, String str2);

    LinkedList<au> cQ(String str, String str2);

    Cursor e(String str, long j, long j2);

    int f(String str, long j, long j2);

    Cursor f(String str, int i, long j);

    int g(String str, long j, long j2);

    Cursor g(String str, int i, long j);

    Cursor h(String str, long j, long j2);

    int i(String str, long j, long j2);

    Cursor j(String str, long j, long j2);

    au pl(int i);

    void w(String str, long j);

    au x(String str, long j);

    au y(String str, long j);

    au z(String str, long j);
}
