package com.tencent.mm.ay;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Set;
import org.json.JSONObject;

public final class a {
    private static String hgr = "";
    public static Set<String> idW;
    public static int idX = 1;

    private static String by(boolean z) {
        if (z && c.sCd) {
            ap.yY();
            return com.tencent.mm.u.c.xv();
        }
        if (bg.mA(hgr)) {
            hgr = e.hgr.replace("/data/user/0", "/data/data");
        }
        return hgr;
    }

    public static String Me() {
        String str = e.hgr;
        if (!bg.mA(str)) {
            str = e.hgr.replace("/data/user/0", "/data/data");
        }
        return "file://" + new File(str, "wenote").getAbsolutePath();
    }

    public static String Mf() {
        File file;
        if (av.bJD() > 1048576) {
            file = new File(by(false), "wenote/res");
        } else {
            file = new File(e.hgu, "wenote/res");
        }
        return file.getAbsolutePath();
    }

    public static String Mg() {
        File file = new File(by(false), "wenote/res");
        if (new File(file, "WNNote.zip").exists()) {
            return file.getAbsolutePath();
        }
        file = new File(e.hgu, "wenote/res");
        if (new File(file, "WNNote.zip").exists()) {
            return file.getAbsolutePath();
        }
        return "";
    }

    public static String Mh() {
        File file = new File(by(true), "wenote/loc/data");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String Mi() {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(by(false), "wenote/html/upload");
        if (!file.exists()) {
            file.mkdirs();
        }
        return stringBuilder.append(file.getAbsolutePath()).append("/wenoteupload.htm").toString();
    }

    public static String Mj() {
        File file = new File(by(true), "wenote/image/localpath");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String Mk() {
        File file = new File(by(true), "wenote/voice/data");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static int EI() {
        Throwable e;
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(Mg(), "config.conf"));
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String str = "";
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        str = str + readLine;
                    } else {
                        w.d("MicroMsg.WNNote.WNNoteExportLogic", "config file content:%s version:%d", new Object[]{str, Integer.valueOf(new JSONObject(str).getInt("version"))});
                        com.tencent.mm.a.e.b(fileInputStream);
                        return r0;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    w.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
                    com.tencent.mm.a.e.b(fileInputStream);
                    return 1;
                } catch (Throwable th) {
                    e = th;
                    com.tencent.mm.a.e.b(fileInputStream);
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            w.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
            com.tencent.mm.a.e.b(fileInputStream);
            return 1;
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            com.tencent.mm.a.e.b(fileInputStream);
            throw e;
        }
    }

    public static int EJ() {
        InputStream open;
        Throwable e;
        InputStream inputStream;
        Reader reader = null;
        Reader inputStreamReader;
        Reader bufferedReader;
        try {
            open = ab.getContext().getAssets().open("wenote_config.conf");
            try {
                inputStreamReader = new InputStreamReader(open);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader = null;
                    reader = inputStreamReader;
                    inputStream = open;
                    try {
                        w.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
                        com.tencent.mm.a.e.b(inputStream);
                        com.tencent.mm.a.e.a(reader);
                        com.tencent.mm.a.e.a(bufferedReader);
                        return 1;
                    } catch (Throwable th) {
                        e = th;
                        open = inputStream;
                        inputStreamReader = reader;
                        com.tencent.mm.a.e.b(open);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(bufferedReader);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    bufferedReader = null;
                    com.tencent.mm.a.e.b(open);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(bufferedReader);
                    throw e;
                }
                try {
                    String str = "";
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            str = str + readLine;
                        } else {
                            w.d("MicroMsg.WNNote.WNNoteExportLogic", "config file content:%s version:%d", new Object[]{str, Integer.valueOf(new JSONObject(str).getInt("version"))});
                            com.tencent.mm.a.e.b(open);
                            com.tencent.mm.a.e.a(inputStreamReader);
                            com.tencent.mm.a.e.a(bufferedReader);
                            return r0;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    reader = inputStreamReader;
                    inputStream = open;
                    w.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
                    com.tencent.mm.a.e.b(inputStream);
                    com.tencent.mm.a.e.a(reader);
                    com.tencent.mm.a.e.a(bufferedReader);
                    return 1;
                } catch (Throwable th3) {
                    e = th3;
                    com.tencent.mm.a.e.b(open);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(bufferedReader);
                    throw e;
                }
            } catch (Exception e4) {
                e = e4;
                bufferedReader = null;
                inputStream = open;
                w.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
                com.tencent.mm.a.e.b(inputStream);
                com.tencent.mm.a.e.a(reader);
                com.tencent.mm.a.e.a(bufferedReader);
                return 1;
            } catch (Throwable th4) {
                e = th4;
                bufferedReader = null;
                inputStreamReader = null;
                com.tencent.mm.a.e.b(open);
                com.tencent.mm.a.e.a(inputStreamReader);
                com.tencent.mm.a.e.a(bufferedReader);
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
            inputStream = null;
            w.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
            com.tencent.mm.a.e.b(inputStream);
            com.tencent.mm.a.e.a(reader);
            com.tencent.mm.a.e.a(bufferedReader);
            return 1;
        } catch (Throwable th5) {
            e = th5;
            bufferedReader = null;
            inputStreamReader = null;
            open = null;
            com.tencent.mm.a.e.b(open);
            com.tencent.mm.a.e.a(inputStreamReader);
            com.tencent.mm.a.e.a(bufferedReader);
            throw e;
        }
    }
}
