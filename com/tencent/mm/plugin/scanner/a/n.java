package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.sdk.platformtools.bg;
import java.util.List;

public final class n {
    public static n oWZ;
    public String aIO;
    public String gku;
    public String iBa;
    public String iBj;
    public b oWI;
    c oWJ;
    public c oWK;
    c oWL;
    public String oWM;
    public a oWN;
    public a oWO;
    public a oWP;
    public a oWQ;
    public List<String> oWR;
    public List<String> oWS;
    public List<String> oWT;
    public List<String> oWU;
    public List<String> oWV;
    public String oWW;
    public String oWX;
    public String oWY;
    public String title;
    public String url;

    public static class a {
        private String country;
        private String hCG;
        private String hTT;
        private String iBn;
        private String iBo;
        private String oXa;
        private String oXb;

        public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            if (str == null) {
                str = "";
            }
            this.oXa = str;
            if (str2 == null) {
                str2 = "";
            }
            this.oXb = str2;
            if (str3 == null) {
                str3 = "";
            }
            this.iBn = str3;
            if (str4 == null) {
                str4 = "";
            }
            this.hCG = str4;
            if (str5 == null) {
                str5 = "";
            }
            this.hTT = str5;
            if (str6 == null) {
                str6 = "";
            }
            this.iBo = str6;
            if (str7 == null) {
                str7 = "";
            }
            this.country = str7;
        }

        public final String Ix() {
            StringBuilder stringBuilder;
            String stringBuilder2;
            if (bg.PH(this.oXa) || bg.PH(this.oXb) || bg.PH(this.iBn) || bg.PH(this.hCG) || bg.PH(this.hTT) || bg.PH(this.country)) {
                stringBuilder = new StringBuilder();
                if (this.country.length() > 0) {
                    stringBuilder.append(this.country);
                    stringBuilder.append("\n");
                }
                if (this.hTT.length() > 0) {
                    stringBuilder.append(this.hTT + " ");
                }
                if (this.hCG.length() > 0) {
                    stringBuilder.append(this.hCG);
                }
                if (this.hTT.length() > 0 || this.hCG.length() > 0) {
                    stringBuilder.append("\n");
                }
                if (this.iBn.length() > 0) {
                    stringBuilder.append(this.iBn + " ");
                    stringBuilder.append("\n");
                }
                if (this.oXb.length() > 0) {
                    stringBuilder.append(this.oXb);
                    stringBuilder.append("\n");
                }
                if (this.oXa.length() > 0) {
                    stringBuilder.append(this.oXa);
                    stringBuilder.append("\n");
                }
                if (this.iBo.length() > 0) {
                    stringBuilder.append(this.iBo);
                }
                stringBuilder2 = stringBuilder.toString();
                if (stringBuilder2.endsWith("\n")) {
                    return stringBuilder2.substring(0, stringBuilder2.length() - 1);
                }
                return stringBuilder2;
            }
            stringBuilder = new StringBuilder();
            if (this.oXa.length() > 0) {
                stringBuilder.append(this.oXa);
                stringBuilder.append("\n");
            }
            if (this.oXb.length() > 0) {
                stringBuilder.append(this.oXb);
                stringBuilder.append("\n");
            }
            if (this.iBn.length() > 0) {
                stringBuilder.append(this.iBn);
                stringBuilder.append("\n");
            }
            if (this.hCG.length() > 0) {
                stringBuilder.append(this.hCG + " ");
            }
            if (this.hTT.length() > 0) {
                stringBuilder.append(this.hTT + " ");
            }
            if (this.iBo.length() > 0) {
                stringBuilder.append(this.iBo);
            }
            if (this.hCG.length() > 0 || this.hTT.length() > 0) {
                stringBuilder.append("\n");
            }
            if (this.country.length() > 0) {
                stringBuilder.append(this.country);
            }
            stringBuilder2 = stringBuilder.toString();
            return stringBuilder2.endsWith("\n") ? stringBuilder2.substring(0, stringBuilder2.length() - 1) : stringBuilder2;
        }
    }

    public static class b {
        private String iBp;
        private String iBq;
        private String iBr;

        public b(String str, String str2, String str3) {
            if (str == null) {
                str = "";
            }
            this.iBp = str;
            if (str2 == null) {
                str2 = "";
            }
            this.iBq = str2;
            if (str3 == null) {
                str3 = "";
            }
            this.iBr = str3;
        }

        public final String Ix() {
            StringBuilder stringBuilder = new StringBuilder();
            if (bg.PH(this.iBp) || bg.PH(this.iBq) || bg.PH(this.iBr)) {
                if (this.iBr.trim().length() > 0) {
                    stringBuilder.append(this.iBr);
                }
                if (this.iBq.trim().length() > 0) {
                    stringBuilder.append(this.iBq);
                }
                if (this.iBp.trim().length() > 0) {
                    stringBuilder.append(this.iBp);
                }
            } else {
                if (this.iBp.trim().length() > 0) {
                    stringBuilder.append(this.iBp);
                }
                if (this.iBq.trim().length() > 0) {
                    stringBuilder.append(" ");
                    stringBuilder.append(this.iBq);
                }
                if (this.iBr.trim().length() > 0) {
                    stringBuilder.append(" ");
                    stringBuilder.append(this.iBr);
                }
            }
            return stringBuilder.toString();
        }
    }

    public static class c {
        public String oXc;
        public String oXd;

        public c(String str, String str2) {
            this.oXc = str;
            this.oXd = str2;
        }
    }
}
