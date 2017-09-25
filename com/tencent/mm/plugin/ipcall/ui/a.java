package com.tencent.mm.plugin.ipcall.ui;

final class a {
    String countryCode;
    String hJF;
    private int mRg;
    String mRh;

    public a(String str, String str2, int i, String str3) {
        this.hJF = str;
        this.countryCode = str2;
        this.mRg = i;
        this.mRh = str3;
    }

    public final int aER() {
        if (this.mRg == 0) {
            return 0;
        }
        for (String equals : IPCallCountryCodeScrollbar.mTu) {
            if (equals.equals(String.valueOf((char) this.mRg))) {
                return this.mRg;
            }
        }
        return "#".charAt(0);
    }
}
