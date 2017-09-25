package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ad extends a {
    public int xoz;

    public ad() {
        this.xoz = 0;
        this.xnn = 312;
    }

    public final Boolean ciq() {
        if (this.xnX < 4) {
            return Boolean.valueOf(false);
        }
        this.xoz = util.L(this.xnh, this.xnW);
        if (this.xnX < (this.xoz * 10) + 4) {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }

    public final int cir() {
        for (int i = 0; i < this.xoz; i++) {
            if (util.K(this.xnh, (this.xnW + 4) + (i * 10)) == 266) {
                return util.L(this.xnh, ((i * 10) + (this.xnW + 4)) + 2);
            }
        }
        return 0;
    }
}
