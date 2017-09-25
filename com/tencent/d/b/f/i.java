package com.tencent.d.b.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import com.tencent.d.a.a;
import com.tencent.d.a.c.b;
import com.tencent.d.a.c.c;
import com.tencent.d.a.c.f;
import com.tencent.d.b.e.d;

public class i extends d {
    private boolean xaW = false;
    private String xaX = "";
    private d xar;
    public String xas = "";
    public int[] xat;

    public i(Context context, e eVar) {
        b bVar = eVar.xau;
        if (bVar != null) {
            c.a(bVar);
        }
        a.setUp();
        boolean z = a.cfB() && a.hc(context);
        this.xaW = z;
        this.xar = eVar.xar;
        this.xat = eVar.xat;
        this.xas = eVar.xas;
        this.xaX = eVar.xav;
        com.tencent.d.b.b.a cfM = com.tencent.d.b.b.a.cfM();
        SharedPreferences sharedPreferences = context.getSharedPreferences("soter_status", 0);
        synchronized (com.tencent.d.b.b.a.class) {
            cfM.wZR = sharedPreferences;
        }
    }

    final boolean cfV() {
        int[] iArr = this.xat;
        int i = (iArr == null || iArr.length <= 0) ? true : 0;
        if (i != 0) {
            c.e("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24", new Object[0]);
            b(new com.tencent.d.b.a.d(27, "no business scene provided"));
            return true;
        } else if (f.mz(this.xas).length() > 24) {
            c.e("Soter.TaskInit", "soter: the salt string used to distinguish is longer than 24", new Object[0]);
            b(new com.tencent.d.b.a.d(28, "the account salt length is too long"));
            return true;
        } else if (f.mA(this.xaX) || this.xaX.length() <= 24) {
            if (this.xar == null) {
                c.w("Soter.TaskInit", "soter: it is strongly recommended to check device support from server, so you'd better provider a net wrapper to check it", new Object[0]);
            }
            if (!f.mA(this.xaX)) {
                c.i("Soter.TaskInit", "soter: provided valid ASK name", new Object[0]);
                com.tencent.d.a.c.d.cfK().wZB = this.xaX;
            }
            g.cfZ().y(new Runnable(this) {
                final /* synthetic */ i xaY;

                {
                    this.xaY = r1;
                }

                public final void run() {
                    this.xaY.a(this.xaY.xas, this.xaY.xat);
                    i iVar = this.xaY;
                    SharedPreferences cfP = com.tencent.d.b.b.a.cfM().cfP();
                    c.d("Soter.TaskInit", "soter: ask status: %d", new Object[]{Integer.valueOf(cfP.getInt(com.tencent.d.a.c.d.cfK().wZB, 0))});
                    if (i.Dg(cfP.getInt(com.tencent.d.a.c.d.cfK().wZB, 0)) && a.cfE()) {
                        a.cfD();
                    }
                    for (int i : iVar.xat) {
                        String str = (String) com.tencent.d.b.b.a.cfM().cfO().get(i, "");
                        if (!f.mA(str)) {
                            c.d("Soter.TaskInit", "soter: %s status: %d", new Object[]{str, Integer.valueOf(cfP.getInt(str, 0))});
                            if (i.Dg(cfP.getInt(str, 0)) && a.VD(str)) {
                                a.bd(str, false);
                            }
                        }
                    }
                }
            });
            return false;
        } else {
            c.e("Soter.TaskInit", "soter: the passed ask name is too long (larger than 24).", new Object[0]);
            b(new com.tencent.d.b.a.d(29, "the passed ask name is too long (larger than 24)"));
            return true;
        }
    }

    final void cfW() {
    }

    final void execute() {
        if (!this.xaW) {
            b(new com.tencent.d.b.a.d(2));
            synchronized (com.tencent.d.b.b.a.class) {
                com.tencent.d.b.b.a.cfM().mg(false);
                com.tencent.d.b.b.a.cfM().cfN();
            }
        } else if (this.xar == null) {
            com.tencent.d.b.b.a.cfM().mg(true);
            com.tencent.d.b.b.a.cfM().cfN();
            b(new com.tencent.d.b.a.d(0));
        } else {
            this.xar.aS(new d.a(a.cfG()));
            this.xar.a(new com.tencent.d.b.e.b<d.b>(this) {
                final /* synthetic */ i xaY;

                {
                    this.xaY = r1;
                }

                public final /* synthetic */ void bV(Object obj) {
                    c.i("Soter.TaskInit", "soter: got support tag from backend: %b", new Object[]{Boolean.valueOf(((d.b) obj).fXh)});
                    synchronized (com.tencent.d.b.b.a.class) {
                        com.tencent.d.b.b.a.cfM().mg(r6.fXh);
                        com.tencent.d.b.b.a.cfM().cfN();
                    }
                    this.xaY.b(new com.tencent.d.b.a.d(0));
                }
            });
            this.xar.execute();
        }
    }

    @SuppressLint({"DefaultLocale"})
    public void a(String str, int[] iArr) {
        for (int put : iArr) {
            com.tencent.d.b.b.a.cfM().cfO().put(put, String.format("%suid%d_%s_scene%d", new Object[]{"Wechat", Integer.valueOf(Process.myUid()), f.mz(str), Integer.valueOf(iArr[r0])}));
        }
    }

    static boolean Dg(int i) {
        return i == 2 || i == 1;
    }
}
