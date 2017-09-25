package com.tencent.mm.ac;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import org.json.JSONObject;

public final class a {
    public static int hAa = 1;
    private static String hgr = "";

    private static String EF() {
        if (bg.mA(hgr)) {
            hgr = e.hgr.replace("/data/user/0", "/data/data");
        }
        return hgr;
    }

    public static String EG() {
        File file = new File(EF(), "emoji/res");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.getAbsolutePath();
    }

    public static String EH() {
        return EF() + "emoji/newemoji";
    }

    public static int EI() {
        Throwable e;
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(EG(), "config.conf"));
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String str = "";
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        str = str + readLine;
                    } else {
                        w.d("MicroMsg.emoji.EmojiStoreExportLogic", "config file content:%s version:%d", str, Integer.valueOf(new JSONObject(str).getInt("version")));
                        com.tencent.mm.a.e.b(fileInputStream);
                        return r0;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    w.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
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
            w.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
            com.tencent.mm.a.e.b(fileInputStream);
            return 1;
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            com.tencent.mm.a.e.b(fileInputStream);
            throw e;
        }
    }

    private static int EJ() {
        InputStream open;
        Reader inputStreamReader;
        Throwable e;
        InputStream inputStream;
        Reader reader = null;
        Reader bufferedReader;
        try {
            open = ab.getContext().getAssets().open("emoji_config.conf");
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
                        w.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
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
                            w.d("MicroMsg.emoji.EmojiStoreExportLogic", "config file content:%s version:%d", str, Integer.valueOf(new JSONObject(str).getInt("version")));
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
                    w.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
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
                w.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
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
            w.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
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

    private static boolean iW(String str) {
        InputStream open;
        try {
            open = ab.getContext().getAssets().open("emoji_template.zip");
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, "", new Object[0]);
            open = null;
        }
        if (open == null) {
            w.e("MicroMsg.emoji.EmojiStoreExportLogic", "file inputStream not found");
            return false;
        }
        OutputStream fileOutputStream;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        file.getParentFile().mkdirs();
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e2, "", new Object[0]);
            fileOutputStream = null;
        }
        if (fileOutputStream != null) {
            try {
                a(open, fileOutputStream);
                return true;
            } catch (Throwable e3) {
                w.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e3, "", new Object[0]);
                return false;
            } finally {
                com.tencent.mm.a.e.b(open);
                com.tencent.mm.a.e.a(fileOutputStream);
            }
        } else {
            com.tencent.mm.a.e.b(open);
            return false;
        }
    }

    private static void a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static void bf(boolean z) {
        File file = new File(EG());
        w.i("MicroMsg.emoji.EmojiStoreExportLogic", "copy search template file to path: %s", file.getAbsoluteFile());
        if (d.sYQ || d.sYR) {
            w.i("MicroMsg.emoji.EmojiStoreExportLogic", "need to init search template folder %b", Boolean.valueOf(z));
            com.tencent.mm.a.e.d(file);
            j(file);
        } else {
            hAa = EI();
            if (z) {
                w.i("MicroMsg.emoji.EmojiStoreExportLogic", "need update assetVersion=%d currentVersion=%d", Integer.valueOf(EJ()), Integer.valueOf(hAa));
                if (hAa < EJ()) {
                    com.tencent.mm.a.e.d(file);
                    j(file);
                }
            } else if (hAa == 1) {
                w.i("MicroMsg.emoji.EmojiStoreExportLogic", "no need update currentVersion=%d", Integer.valueOf(hAa));
                com.tencent.mm.a.e.d(file);
                j(file);
            }
        }
        com.tencent.mm.a.e.d(new File(e.hgu, "emoji"));
    }

    private static void j(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, ".nomedia");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, "create nomedia file error", new Object[0]);
            }
        }
        file2 = new File(file, "emoji_template.zip");
        if (iW(file2.getAbsolutePath())) {
            int eA = bg.eA(file2.getAbsolutePath(), file2.getParent());
            if (eA < 0) {
                w.e("MicroMsg.emoji.EmojiStoreExportLogic", "unzip fail, ret = " + eA + ", zipFilePath = " + file2.getAbsolutePath() + ", unzipPath = " + file2.getParent());
                return;
            }
            hAa = EI();
            w.i("MicroMsg.emoji.EmojiStoreExportLogic", "Unzip Path%s version=%d", file2.getParent(), Integer.valueOf(hAa));
            return;
        }
        w.i("MicroMsg.emoji.EmojiStoreExportLogic", "copy template file from asset fail %s", file2.getAbsolutePath());
    }

    public static void k(File file) {
        File file2 = new File(EG());
        com.tencent.mm.a.e.d(file2);
        file2.mkdirs();
        File file3 = new File(file2, ".nomedia");
        if (!file3.exists()) {
            try {
                file3.createNewFile();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, "create nomedia file error", new Object[0]);
            }
        }
        file3 = new File(file2, "emoji_template.zip");
        com.tencent.mm.a.e.p(file.getAbsolutePath(), file3.getAbsolutePath());
        int eA = bg.eA(file3.getAbsolutePath(), file3.getParent());
        if (eA < 0) {
            w.e("MicroMsg.emoji.EmojiStoreExportLogic", "unzip fail, ret = " + eA + ", zipFilePath = " + file3.getAbsolutePath() + ", unzipPath = " + file3.getParent());
            return;
        }
        hAa = EI();
        w.i("MicroMsg.emoji.EmojiStoreExportLogic", "Unzip Path%s version=%d", file3.getParent(), Integer.valueOf(hAa));
    }
}
