package b.a.d;

import b.a.g.d;
import java.io.Serializable;

public final class i implements Serializable {
    public final String tPO;
    public final String token;
    private final String xpH;

    public i(String str, String str2) {
        this(str, str2, null);
    }

    public i(String str, String str2, String str3) {
        d.d(str, "Token can't be null");
        d.d(str2, "Secret can't be null");
        this.token = str;
        this.tPO = str2;
        this.xpH = str3;
    }

    public final String toString() {
        return String.format("Token[%s , %s]", new Object[]{this.token, this.tPO});
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (this.token.equals(iVar.token) && this.tPO.equals(iVar.tPO)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.token.hashCode() * 31) + this.tPO.hashCode();
    }
}
