package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class z extends a {
    public int xov;
    public int xow;

    public z() {
        this.xov = 0;
        this.xow = 0;
        this.xnn = 293;
    }

    public final Boolean ciq() {
        if (this.xnX < 2) {
            return Boolean.valueOf(false);
        }
        this.xov = util.K(this.xnh, this.xnW);
        if (this.xnX < (this.xov + 2) + 2) {
            return Boolean.valueOf(false);
        }
        this.xow = util.K(this.xnh, (this.xnW + 2) + this.xov);
        return Boolean.valueOf(true);
    }
}
