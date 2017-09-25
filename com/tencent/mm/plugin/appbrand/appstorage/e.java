package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.sdk.platformtools.bg;

public final class e {
    public String aIO;
    public String gku;
    public b iAZ;
    public String iBa;
    public a iBb;
    public a iBc;
    public a iBd;
    public String iBe;
    public String iBf;
    public String iBg;
    public String iBh;
    public String iBi;
    public String iBj;
    public String iBk;
    public String iBl;
    public String iBm;
    public String title;
    public String url;

    public static class a {
        private String country;
        private String gkC;
        private String iBn;
        public String iBo;
        private String state;

        public a(String str, String str2, String str3, String str4, String str5) {
            this.country = bg.mz(str);
            this.state = bg.mz(str2);
            this.gkC = bg.mz(str3);
            this.iBn = bg.mz(str4);
            this.iBo = bg.mz(str5);
        }

        public final String Ix() {
            StringBuilder stringBuilder;
            if (bg.PH(this.country) || bg.PH(this.state) || bg.PH(this.gkC) || bg.PH(this.iBn) || bg.PH(this.iBo)) {
                stringBuilder = new StringBuilder();
                if (this.country.length() > 0) {
                    stringBuilder.append(this.country);
                }
                if (this.state.length() > 0) {
                    stringBuilder.append(this.state);
                }
                if (this.gkC.length() > 0) {
                    stringBuilder.append(this.gkC);
                }
                if (this.iBn.length() > 0) {
                    stringBuilder.append(this.iBn);
                }
                if (this.iBo.length() > 0) {
                    stringBuilder.append(" ");
                    stringBuilder.append(this.iBo);
                }
                return stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            if (this.iBn.length() > 0) {
                stringBuilder.append(this.iBn);
                stringBuilder.append(" ");
            }
            if (this.gkC.length() > 0) {
                stringBuilder.append(this.gkC + " ");
            }
            if (this.state.length() > 0) {
                stringBuilder.append(this.state + " ");
            }
            if (this.country.length() > 0) {
                stringBuilder.append(this.country);
            }
            if (this.iBo.length() > 0) {
                stringBuilder.append(" ");
                stringBuilder.append(this.iBo);
            }
            return stringBuilder.toString();
        }
    }

    public static class b {
        public String iBp;
        public String iBq;
        public String iBr;

        public b(String str, String str2, String str3) {
            this.iBp = bg.mz(str);
            this.iBq = bg.mz(str2);
            this.iBr = bg.mz(str3);
        }
    }
}
