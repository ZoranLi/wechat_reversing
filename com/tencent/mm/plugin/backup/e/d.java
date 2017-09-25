package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public final class d extends com.tencent.mm.plugin.backup.a.a {
    private static String END = "img";
    private static String jFP = "icon_";
    private static String jFQ = "iphone";
    private static String jFR = "android";
    private static String jFS = "s60v3";
    private static String jFT = "s60v5";
    private static d jFU;
    private Map<String, a> jFV = null;

    public static class a {
        public String fFW = "";
        public String jFW = "";
        public String jFX = "";
        public String jFY = "";
        public String jFZ = "";

        public final String toString() {
            return this.jFW + " " + this.jFX + " " + this.jFY + " " + this.jFZ;
        }
    }

    public static a rF(String str) {
        if (jFU == null) {
            jFU = new d();
        }
        d dVar = jFU;
        if (dVar.jFV == null) {
            dVar.abb();
        }
        for (a aVar : dVar.jFV.values()) {
            if (aVar.jFX != null && aVar.jFX.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public static a rG(String str) {
        if (jFU == null) {
            com.tencent.mm.plugin.backup.a.a dVar = new d();
            jFU = dVar;
            com.tencent.mm.plugin.backup.a.a.a(dVar);
        }
        d dVar2 = jFU;
        if (dVar2.jFV == null) {
            dVar2.abb();
        }
        return (a) dVar2.jFV.get(str);
    }

    public final void ZY() {
        jFU = null;
    }

    public d() {
        abb();
    }

    private void abb() {
        InputStream open;
        BufferedReader bufferedReader;
        int i;
        Throwable e;
        Throwable e2;
        this.jFV = new HashMap();
        try {
            open = ab.getContext().getAssets().open("emojiconf");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(open, ProtocolPackage.ServerEncoding));
                i = 0;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            break;
                        } catch (Exception e3) {
                        }
                    } else if (readLine.contains(jFP)) {
                        a aVar = new a();
                        while (true) {
                            String readLine2 = bufferedReader.readLine();
                            if (readLine2 != null && !readLine2.contains(END)) {
                                int indexOf = readLine2.indexOf("=");
                                if (indexOf + 1 >= readLine2.length()) {
                                    break;
                                }
                                String substring = readLine2.substring(indexOf + 1);
                                if (readLine2.startsWith(jFQ)) {
                                    aVar.jFX = substring;
                                } else if (readLine2.startsWith(jFR)) {
                                    aVar.jFW = substring;
                                } else {
                                    try {
                                        if (readLine2.startsWith(jFS)) {
                                            aVar.jFY = substring;
                                        } else if (readLine2.startsWith(jFT)) {
                                            aVar.jFZ = substring;
                                        }
                                    } catch (IOException e4) {
                                        e = e4;
                                    }
                                }
                                this.jFV.put(aVar.jFW, aVar);
                            } else {
                                break;
                            }
                        }
                        w.d("MicroMsg.EmojiCovertMap", "emojiValue " + aVar.toString());
                        i++;
                    }
                }
                bufferedReader.close();
                if (open != null) {
                    open.close();
                }
            } catch (Throwable e22) {
                bufferedReader = null;
                e = e22;
                i = 0;
                try {
                    w.printErrStackTrace("MicroMsg.EmojiCovertMap", e, "", new Object[0]);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e5) {
                        }
                    }
                    if (open != null) {
                        open.close();
                    }
                    w.d("MicroMsg.EmojiCovertMap", "id " + i);
                } catch (Throwable th) {
                    e22 = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e6) {
                            throw e22;
                        }
                    }
                    if (open != null) {
                        open.close();
                    }
                    throw e22;
                }
            } catch (Throwable th2) {
                e22 = th2;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (open != null) {
                    open.close();
                }
                throw e22;
            }
        } catch (Throwable e222) {
            bufferedReader = null;
            open = null;
            e = e222;
            i = 0;
            w.printErrStackTrace("MicroMsg.EmojiCovertMap", e, "", new Object[0]);
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (open != null) {
                open.close();
            }
            w.d("MicroMsg.EmojiCovertMap", "id " + i);
        } catch (Throwable th3) {
            e222 = th3;
            bufferedReader = null;
            open = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (open != null) {
                open.close();
            }
            throw e222;
        }
        w.d("MicroMsg.EmojiCovertMap", "id " + i);
    }
}
