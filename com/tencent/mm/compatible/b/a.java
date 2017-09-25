package com.tencent.mm.compatible.b;

import java.util.concurrent.locks.Lock;

public final class a {
    public int gNb = 0;
    public int gNc = 0;
    public byte[] gNd = null;
    public int gNe = 0;
    public int gNf = 0;
    public boolean gNg = false;
    public Lock gNh = null;

    public final int qC() {
        if (this.gNg) {
            this.gNh.lock();
        }
        if (this.gNe == this.gNf) {
            return 0;
        }
        if (this.gNe < this.gNf) {
            this.gNc = this.gNf - this.gNe;
        } else if (this.gNe > this.gNf) {
            this.gNc = (this.gNf + this.gNb) - this.gNe;
        }
        if (this.gNg) {
            this.gNh.unlock();
        }
        return this.gNc;
    }
}
