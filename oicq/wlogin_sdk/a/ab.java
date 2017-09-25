package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ab extends a {
    public int xoy;

    public ab() {
        this.xoy = 0;
        this.xnn = 306;
    }

    public final Boolean ciq() {
        if (this.xnX < 2) {
            return Boolean.valueOf(false);
        }
        this.xoy = util.K(this.xnh, this.xnW);
        if (this.xoy + 2 > this.xnX) {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }
}
