package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ai extends a {
    public int xoF;
    public int xoG;
    public int xoH;

    public ai() {
        this.xoF = 0;
        this.xoG = 0;
        this.xoH = 0;
        this.xnn = 326;
    }

    public final Boolean ciq() {
        if (this.xnX < 12) {
            return Boolean.valueOf(false);
        }
        int K = util.K(this.xnh, this.xnW + 4);
        if (this.xnX < K + 12) {
            return Boolean.valueOf(false);
        }
        this.xoF = K;
        K = util.K(this.xnh, (this.xnW + 6) + this.xoF);
        if (this.xnX < (this.xoF + 12) + K) {
            return Boolean.valueOf(false);
        }
        this.xoG = K;
        K = util.K(this.xnh, ((this.xnW + 10) + this.xoF) + this.xoG);
        if (this.xnX < ((this.xoF + 12) + this.xoG) + K) {
            return Boolean.valueOf(false);
        }
        this.xoH = K;
        return Boolean.valueOf(true);
    }
}
