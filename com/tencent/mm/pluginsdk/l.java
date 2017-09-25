package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.e.a.ko;
import com.tencent.mm.protocal.c.aca;
import com.tencent.mm.protocal.c.beu;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Deprecated
public interface l {

    public static class a {
        public static w sBA;
        public static i sBB;
        public static d sBC;
        public static b sBD;
        public static n sBr;
        public static o sBs;
        public static f sBt;
        public static j sBu;
        public static c sBv;
        public static k sBw;
        public static q sBx;
        public static s sBy;
        public static h sBz;

        public static j bCn() {
            if (sBu == null) {
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.IPluginEvent.Factory", "get shake mgr is null, new default");
                sBu = new com.tencent.mm.pluginsdk.c.c();
            }
            return sBu;
        }

        public static k bCo() {
            return sBw;
        }
    }

    public static class aa {
        public static l sBG;
    }

    public static class ab {
        public static a sBH;
    }

    public interface b {
        String jc(String str);

        String jd(String str);
    }

    public interface c {
        boolean afJ();

        boolean afK();

        String afL();

        int afM();

        boolean ko(int i);
    }

    public interface d {
        int a(com.tencent.mm.pluginsdk.wallet.b bVar, int i, boolean z);

        void a(ko koVar, int i);

        void a(ko koVar, int i, String str);

        boolean a(boolean z, boolean z2, Bundle bundle);

        boolean auS();

        boolean auT();

        boolean auU();

        void auW();

        com.tencent.mm.pluginsdk.wallet.g auY();

        boolean auZ();

        boolean ava();

        void avb();

        boolean avc();

        boolean avd();

        void ave();

        void avf();

        void avg();

        Map<String, String> avh();

        com.tencent.mm.pluginsdk.wallet.h avi();

        Map<String, String> avj();

        boolean avk();

        void bY(Context context);

        void bZ(Context context);

        void ek(boolean z);

        int type();
    }

    public interface e {
        boolean axD();

        boolean bmF();

        String bmH();

        String bmI();

        boolean bmJ();

        String bmK();

        String bmL();
    }

    public interface f {
        void a(Context context, boolean z);

        void ai(Context context);

        boolean oK();
    }

    public interface g {
        void LI(String str);
    }

    public interface h {
        void AY(String str);

        boolean AZ(String str);

        boolean Ba(String str);

        List<String> Bb(String str);

        boolean Bc(String str);

        boolean Bd(String str);

        void Be(String str);

        boolean Bf(String str);

        boolean Bg(String str);

        void Bh(String str);

        com.tencent.mm.al.b Bl(String str);

        void a(g gVar);

        boolean aJ(Context context);

        boolean aMM();

        boolean aMO();

        boolean aNa();

        boolean aNb();

        void b(g gVar);

        boolean cS(String str, String str2);

        String cT(String str, String str2);

        int cU(String str, String str2);

        String eK(String str);

        boolean gR(String str);
    }

    public interface i {
        boolean a(Context context, String str, OnDismissListener onDismissListener);

        boolean bu(String str);

        String p(Context context, String str);
    }

    public interface j {
        String Ee(String str);

        int baL();

        void baM();

        boolean baN();

        void baO();

        void baP();

        boolean baQ();
    }

    public interface k {
        void B(String str, int i, int i2);

        void I(String str, String str2, String str3);

        void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, long j, String str5);

        void a(Context context, String str, String str2, String str3, int i, String str4, int i2);

        void a(String str, String str2, int i, int i2, String str3, int i3);

        void a(String str, String str2, int i, int i2, String str3, long j);

        boolean aBI();

        void cl(Context context);

        void m(Context context, String str, String str2);
    }

    public interface l {
        boolean bmN();

        boolean bmO();

        void bmP();

        void bmQ();

        void bmT();

        String bmV();

        e bmW();
    }

    public interface m {
        void B(String str, String str2, String str3);
    }

    public interface n {
        boolean Hr(String str);

        LinkedList<beu> Hs(String str);

        void a(m mVar);

        void a(String str, LinkedList<beu> linkedList, String str2, String str3, int i);

        void b(m mVar);

        boolean bnI();
    }

    public interface o {
        void a(p pVar);

        void b(p pVar);

        void bR(String str, int i);

        boolean bnO();

        void bnP();

        short bnU();

        short bnV();

        boolean bnW();

        void bnx();
    }

    public interface p {
        void C(String str, int i, int i2);

        void aGO();

        void aGP();

        void aGQ();

        void aGR();

        void aGS();

        void aGT();

        void cI(String str, String str2);

        void k(int i, int i2, String str);

        void oE(int i);

        void zC(String str);
    }

    public interface q {
        String aGl();
    }

    public interface r {
        void LJ(String str);
    }

    public interface s {
        void a(r rVar);

        void a(String str, LinkedList<String> linkedList, double d, double d2, String str2, String str3, String str4);

        boolean aGu();

        String aGv();

        void b(r rVar);

        boolean cH(String str, String str2);

        LinkedList<String> zq(String str);

        boolean zs(String str);
    }

    public interface t {
        void update(int i);
    }

    public interface u {
        int bCp();

        String[] bCq();

        aca bCr();
    }

    public interface v {
        String DE(String str);

        t a(Context context, OnCancelListener onCancelListener);

        void aXT();

        u aXU();

        t b(Context context, OnCancelListener onCancelListener);

        t cL(Context context);

        void cM(Context context);

        void d(String str, int i, String str2, String str3);

        void gG(boolean z);

        void o(Context context, Intent intent);

        void p(Context context, Intent intent);
    }

    public interface w {
        boolean a(Context context, String str, boolean z);

        boolean a(Context context, String str, boolean z, Bundle bundle);

        boolean a(Context context, String str, boolean z, o oVar);

        boolean b(Context context, String str, boolean z, o oVar);

        boolean b(Context context, String str, Object... objArr);
    }

    public interface x {

        public interface a {
            String bvI();

            void bvJ();

            boolean bvK();
        }
    }

    public static class y {
        private static v sBE;
        public static boolean sBF = false;

        public static void a(v vVar) {
            sBE = vVar;
        }

        public static v bCs() {
            return sBE;
        }
    }

    public static class z {
        public static com.tencent.mm.plugin.sns.b.f bCt() {
            return com.tencent.mm.plugin.sns.b.m.pQG;
        }
    }
}
