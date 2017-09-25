package b.a.d;

public final class d implements Comparable<d> {
    final String arH;
    final String value;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        d dVar = (d) obj;
        int compareTo = this.arH.compareTo(dVar.arH);
        return compareTo != 0 ? compareTo : this.value.compareTo(dVar.value);
    }

    public d(String str, String str2) {
        this.arH = str;
        this.value = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (dVar.arH.equals(this.arH) && dVar.value.equals(this.value)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.arH.hashCode() + this.value.hashCode();
    }
}
