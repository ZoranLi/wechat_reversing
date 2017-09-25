package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import java.io.Serializable;

public class e implements Serializable {
    public int abH;
    public int wd;

    public e(int i, int i2) {
        this.abH = i;
        this.wd = i2;
        if (this.abH > this.wd) {
            int i3 = this.wd;
            this.wd = this.abH;
            this.abH = i3;
        }
    }

    public String toString() {
        return "[" + this.abH + ", " + this.wd + "]";
    }
}
