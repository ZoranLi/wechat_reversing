package b.a.c;

import b.a.d.e;
import b.a.g.d;
import java.util.Collections;

public final class c implements b {
    public final String a(b.a.d.c cVar) {
        d.d(cVar, "Cannot extract base string from null object");
        if (cVar.xpt == null || cVar.xpt.size() <= 0) {
            throw new b.a.b.c(cVar);
        }
        String encode = b.a.g.c.encode(cVar.ciD().name());
        String encode2 = b.a.g.c.encode(cVar.ciI());
        e eVar = new e();
        eVar.a(cVar.ciC());
        eVar.a(cVar.ciH());
        eVar.a(new e(cVar.xpt));
        e eVar2 = new e(eVar.xpu);
        Collections.sort(eVar2.xpu);
        String encode3 = b.a.g.c.encode(eVar2.ciJ());
        return String.format("%s&%s&%s", new Object[]{encode, encode2, encode3});
    }
}
