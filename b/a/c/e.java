package b.a.c;

import b.a.d.c;
import b.a.g.d;
import java.util.Map;

public final class e implements d {
    public final String a(c cVar) {
        d.d(cVar, "Cannot extract a header from a null object");
        if (cVar.xpt == null || cVar.xpt.size() <= 0) {
            throw new b.a.b.c(cVar);
        }
        Map map = cVar.xpt;
        StringBuffer stringBuffer = new StringBuffer(map.size() * 20);
        stringBuffer.append("OAuth ");
        for (String str : map.keySet()) {
            if (stringBuffer.length() > 6) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(String.format("%s=\"%s\"", new Object[]{str, b.a.g.c.encode((String) map.get(str))}));
        }
        return stringBuffer.toString();
    }
}
