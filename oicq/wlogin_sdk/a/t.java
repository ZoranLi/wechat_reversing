package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class t extends a {
    public int xot;

    public t() {
        this.xot = 0;
        this.xnn = 282;
    }

    public final Boolean ciq() {
        if (this.xnX < 5) {
            return Boolean.valueOf(false);
        }
        int J = util.J(this.xnh, ((this.xnW + 2) + 1) + 1);
        if (this.xnX < J + 5) {
            return Boolean.valueOf(false);
        }
        this.xot = J;
        return Boolean.valueOf(true);
    }
}
