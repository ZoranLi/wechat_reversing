package com.tencent.mm.pluginsdk.ui.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class q {
    static Pattern sXJ = Pattern.compile("(?:(http|https|file)\\:\\/\\/)?(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?([a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_-][a-zA-Z0-9 -퟿豈-﷏ﷰ-￯%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?(?:\\:([0-9]*))?(\\/?[^#]*)?.*", 2);
    String aGN;
    String iNZ;
    String sXG;
    String sXH;
    int sXI;

    public q(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.sXG = "";
        this.sXH = "";
        this.sXI = -1;
        this.aGN = "/";
        this.iNZ = "";
        Matcher matcher = sXJ.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            if (group != null) {
                this.sXG = group.toLowerCase();
            }
            group = matcher.group(2);
            if (group != null) {
                this.iNZ = group;
            }
            group = matcher.group(3);
            if (group != null) {
                this.sXH = group;
            }
            group = matcher.group(4);
            if (group != null && group.length() > 0) {
                try {
                    this.sXI = Integer.parseInt(group);
                } catch (NumberFormatException e) {
                    throw new Exception("Bad port");
                }
            }
            String group2 = matcher.group(5);
            if (group2 != null && group2.length() > 0) {
                if (group2.charAt(0) == '/') {
                    this.aGN = group2;
                } else {
                    this.aGN = "/" + group2;
                }
            }
            if (this.sXI == 443 && this.sXG.equals("")) {
                this.sXG = "https";
            } else if (this.sXI == -1) {
                if (this.sXG.equals("https")) {
                    this.sXI = 443;
                } else {
                    this.sXI = 80;
                }
            }
            if (this.sXG.equals("")) {
                this.sXG = "http";
                return;
            }
            return;
        }
        throw new Exception("Bad address");
    }

    public final String toString() {
        String str = "";
        if ((this.sXI != 443 && this.sXG.equals("https")) || (this.sXI != 80 && this.sXG.equals("http"))) {
            str = ":" + Integer.toString(this.sXI);
        }
        String str2 = "";
        if (this.iNZ.length() > 0) {
            str2 = this.iNZ + "@";
        }
        return this.sXG + "://" + str2 + this.sXH + str + this.aGN;
    }
}
