package com.tencent.mm.vending.g;

import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.b;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.vending.j.e;
import com.tencent.mm.vending.j.f;
import java.util.Stack;

public final class g {
    private static final a wDz = new a();

    public static final c<Void> cbJ() {
        return new e().t(new Object[0]);
    }

    public static final <Var1> c<Var1> bN(Var1 var1) {
        return new e().t(var1);
    }

    public static final <Var1, Var2> c<c<Var1, Var2>> s(Var1 var1, Var2 var2) {
        return new e().t(var1, var2);
    }

    public static final <Var1, Var2, Var3> c<d<Var1, Var2, Var3>> a(Var1 var1, Var2 var2, Var3 var3) {
        return new e().t(var1, var2, var3);
    }

    public static final <Var1, Var2, Var3, Var4> c<e<Var1, Var2, Var3, Var4>> a(Var1 var1, Var2 var2, Var3 var3, Var4 var4) {
        return new e().t(var1, var2, var3, var4);
    }

    public static final <Var1, Var2, Var3, Var4, Var5> c<f<Var1, Var2, Var3, Var4, Var5>> a(Var1 var1, Var2 var2, Var3 var3, Var4 var4, Var5 var5) {
        return new e().t(var1, var2, var3, var4, var5);
    }

    public static <$1> b<$1> bO($1 $1) {
        b bVar = new b();
        return a.bP($1);
    }

    public static <$1, $2> c<$1, $2> t($1 $1, $2 $2) {
        c cVar = new c();
        return a.u($1, $2);
    }

    public static final b cbB() {
        f cbI = f.cbI();
        Stack stack = (Stack) cbI.wDy.get();
        c cVar = stack == null ? null : stack.size() == 0 ? null : (c) ((Stack) cbI.wDy.get()).peek();
        return cVar != null ? cVar.cbB() : wDz;
    }

    public static final b cbK() {
        b cbB = cbB();
        if (cbB != null) {
            cbB.cbA();
        } else {
            com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
        }
        return cbB;
    }

    public static final void a(b bVar, Object... objArr) {
        if (bVar == null) {
            com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
        } else if (objArr.length > 0) {
            bVar.s(objArr);
        } else {
            bVar.resume();
        }
    }

    public static final void a(b bVar) {
        if (bVar == null) {
            com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
        } else {
            bVar.bJ(null);
        }
    }

    public static final <_Var> void a(d<_Var> dVar) {
        final b cbK = cbK();
        dVar.a(new d.b<_Var>() {
            public final void ar(_Var _Var) {
                g.a(cbK, _Var);
            }
        }).a(new d.a() {
            public final void aD(Object obj) {
                cbK.bJ(obj);
            }
        });
    }
}
