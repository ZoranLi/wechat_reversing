package b.a.d;

import b.a.g.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class e {
    public final List<d> xpu;

    public e() {
        this.xpu = new ArrayList();
    }

    public e(List<d> list) {
        this.xpu = new ArrayList(list);
    }

    public e(Map<String, String> map) {
        this();
        for (Entry entry : map.entrySet()) {
            this.xpu.add(new d((String) entry.getKey(), (String) entry.getValue()));
        }
    }

    public final String ciJ() {
        if (this.xpu.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (d dVar : this.xpu) {
            stringBuilder.append('&').append(c.encode(dVar.arH).concat("=").concat(c.encode(dVar.value)));
        }
        return stringBuilder.toString().substring(1);
    }

    public final void a(e eVar) {
        this.xpu.addAll(eVar.xpu);
    }

    public final void Wv(String str) {
        if (str != null && str.length() > 0) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                this.xpu.add(new d(c.decode(split2[0]), split2.length > 1 ? c.decode(split2[1]) : ""));
            }
        }
    }
}
