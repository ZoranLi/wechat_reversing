package com.tencent.mm.storage;

public final class ak {
    public String fGa;
    public String kSV;
    public int uJr;
    private boolean uJs;
    public int uJt;
    public int uJu;
    public String uJv;

    public ak() {
        this.uJs = false;
        this.uJr = -1;
    }

    public ak(String str) {
        this.uJs = false;
        this.fGa = str;
        this.uJr = -1;
    }

    public final void yD(int i) {
        if (!(this.uJr == -1 || this.uJr == i || i != 7)) {
            this.uJs = true;
        }
        this.uJr = i;
    }
}
