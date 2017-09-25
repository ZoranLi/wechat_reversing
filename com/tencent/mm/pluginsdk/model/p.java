package com.tencent.mm.pluginsdk.model;

public final class p {
    public String fGa;
    private int sCA;
    public String sCB;
    public String sCC;
    public String sCD;
    public int sCE;

    p(int i, String str, String str2, String str3, String str4, int i2) {
        this.sCA = i;
        this.fGa = str;
        this.sCB = str2;
        this.sCE = i2;
        this.sCC = str3;
        this.sCD = str4;
    }

    public final String toString() {
        return "id:" + this.sCA + ";productId:" + this.fGa + ";full:" + this.sCB + ";productState:" + this.sCE + ";priceCurrencyCode:" + this.sCC + ";priceAmountMicros:" + this.sCD;
    }
}
