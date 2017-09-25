package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class g extends a {
    public int xoh;
    public int xoi;
    public int xoj;
    public int xok;

    public g() {
        this.xoh = 0;
        this.xoi = 0;
        this.xoj = 0;
        this.xok = 0;
        this.xnn = 261;
    }

    public final Boolean ciq() {
        if (this.xnX < 2) {
            return Boolean.valueOf(false);
        }
        this.xoi = util.K(this.xnh, this.xnW);
        if (this.xnX < (this.xoi + 2) + 2) {
            return Boolean.valueOf(false);
        }
        this.xoh = util.K(this.xnh, (this.xnW + 2) + this.xoi);
        if (this.xnX < ((this.xoi + 2) + 2) + this.xoh) {
            return Boolean.valueOf(false);
        }
        this.xok = this.xnW + 2;
        this.xoj = ((this.xoi + 2) + 2) + this.xnW;
        return Boolean.valueOf(true);
    }
}
