package com.tencent.mm.plugin.emoji.c;

import com.tencent.mm.a.e;
import com.tencent.mm.ac.a;
import com.tencent.mm.e.a.bb;
import com.tencent.mm.plugin.emoji.e.i;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.json.JSONObject;

public final class b extends c<bb> {
    public b() {
        this.usg = bb.class.getName().hashCode();
    }

    private static boolean a(bb bbVar) {
        Throwable th;
        Throwable e;
        if (bbVar instanceof bb) {
            String readLine;
            if (bbVar.fEA.fEB == 33) {
                File file = new File(bbVar.fEA.filePath);
                if (file.exists()) {
                    int i;
                    w.i("MicroMsg.emoji.EmojiResUpdateListener", "checkResUpdateListener callback to update %s", new Object[]{file.getAbsoluteFile()});
                    File file2 = new File(a.EG(), "temp");
                    File file3 = new File(file2, "emoji_template.zip");
                    file2.mkdirs();
                    e.p(file.getAbsolutePath(), file3.getAbsolutePath());
                    if (bg.eA(file3.getAbsolutePath(), file2.getAbsolutePath()) >= 0) {
                        InputStream fileInputStream;
                        Reader inputStreamReader;
                        Reader reader;
                        try {
                            String str;
                            fileInputStream = new FileInputStream(new File(file2, "config.conf"));
                            try {
                                inputStreamReader = new InputStreamReader(fileInputStream);
                            } catch (Throwable e2) {
                                reader = null;
                                inputStreamReader = null;
                                th = e2;
                                i = 1;
                                try {
                                    w.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", th, th.getMessage(), new Object[0]);
                                    e.b(fileInputStream);
                                    e.a(inputStreamReader);
                                    e.a(reader);
                                    e.d(file2);
                                    com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                                    if (a.hAa >= i) {
                                        w.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.hAa), Integer.valueOf(i)});
                                    } else {
                                        w.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.hAa), Integer.valueOf(i)});
                                        a.k(file);
                                    }
                                    return false;
                                } catch (Throwable th2) {
                                    e2 = th2;
                                    e.b(fileInputStream);
                                    e.a(inputStreamReader);
                                    e.a(reader);
                                    throw e2;
                                }
                            } catch (Throwable th3) {
                                e2 = th3;
                                reader = null;
                                inputStreamReader = null;
                                e.b(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                                throw e2;
                            }
                            try {
                                reader = new BufferedReader(inputStreamReader);
                                try {
                                    str = "";
                                    while (true) {
                                        readLine = reader.readLine();
                                        if (readLine == null) {
                                            break;
                                        }
                                        str = str + readLine;
                                    }
                                    i = new JSONObject(str).getInt("version");
                                } catch (Throwable e22) {
                                    th = e22;
                                    i = 1;
                                    w.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", th, th.getMessage(), new Object[0]);
                                    e.b(fileInputStream);
                                    e.a(inputStreamReader);
                                    e.a(reader);
                                    e.d(file2);
                                    com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                                    if (a.hAa >= i) {
                                        w.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.hAa), Integer.valueOf(i)});
                                        a.k(file);
                                    } else {
                                        w.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.hAa), Integer.valueOf(i)});
                                    }
                                    return false;
                                }
                            } catch (Throwable e222) {
                                reader = null;
                                th = e222;
                                i = 1;
                                w.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", th, th.getMessage(), new Object[0]);
                                e.b(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                                e.d(file2);
                                com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                                if (a.hAa >= i) {
                                    w.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.hAa), Integer.valueOf(i)});
                                } else {
                                    w.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.hAa), Integer.valueOf(i)});
                                    a.k(file);
                                }
                                return false;
                            } catch (Throwable th4) {
                                e222 = th4;
                                reader = null;
                                e.b(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                                throw e222;
                            }
                            try {
                                w.d("MicroMsg.emoji.EmojiResUpdateListener", "config file content:%s version:%d", new Object[]{str, Integer.valueOf(i)});
                                e.b(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                            } catch (Exception e3) {
                                th = e3;
                                w.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", th, th.getMessage(), new Object[0]);
                                e.b(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                                e.d(file2);
                                com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                                if (a.hAa >= i) {
                                    w.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.hAa), Integer.valueOf(i)});
                                    a.k(file);
                                } else {
                                    w.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.hAa), Integer.valueOf(i)});
                                }
                                return false;
                            }
                        } catch (Throwable e2222) {
                            reader = null;
                            inputStreamReader = null;
                            fileInputStream = null;
                            th = e2222;
                            i = 1;
                            w.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", th, th.getMessage(), new Object[0]);
                            e.b(fileInputStream);
                            e.a(inputStreamReader);
                            e.a(reader);
                            e.d(file2);
                            com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                            if (a.hAa >= i) {
                                w.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.hAa), Integer.valueOf(i)});
                            } else {
                                w.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.hAa), Integer.valueOf(i)});
                                a.k(file);
                            }
                            return false;
                        } catch (Throwable th5) {
                            e2222 = th5;
                            reader = null;
                            inputStreamReader = null;
                            fileInputStream = null;
                            e.b(fileInputStream);
                            e.a(inputStreamReader);
                            e.a(reader);
                            throw e2222;
                        }
                    }
                    i = 1;
                    e.d(file2);
                    com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                    if (a.hAa >= i) {
                        w.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.hAa), Integer.valueOf(i)});
                        a.k(file);
                    } else {
                        w.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(a.hAa), Integer.valueOf(i)});
                    }
                } else {
                    w.e("MicroMsg.emoji.EmojiResUpdateListener", "checkResUpdateListener file not exist");
                }
            } else if (bbVar.fEA.fEB == 37) {
                File file4;
                if (bbVar.fEA.fEC == 1) {
                    if (!i.alH().a(bbVar, i.a.EMOJI)) {
                        w.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji need no update.");
                    } else if (i.a(bbVar, i.a.EMOJI, i.kKc)) {
                        file4 = new File(new File(i.alI(), i.kKc), i.kKn);
                        if (file4.exists()) {
                            i.s(file4);
                        } else {
                            w.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji config don't exist.");
                        }
                    } else {
                        w.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmoji unzip file failed.");
                    }
                } else if (bbVar.fEA.fEC == 2) {
                    if (!i.alH().a(bbVar, i.a.PANEL) && !i.alJ()) {
                        w.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel need no update.");
                    } else if (i.a(bbVar, i.a.PANEL, i.kKd)) {
                        File file5 = new File(i.alI(), i.kKd);
                        readLine = n.alP();
                        if (bg.mA(readLine)) {
                            readLine = i.kKo;
                            w.i("MicroMsg.emoji.EmojiResUpdateMgr", "no dynamic config panel file name. use default.");
                        } else {
                            if (!new File(file5, readLine).exists()) {
                                readLine = i.kKo;
                            }
                            w.i("MicroMsg.emoji.EmojiResUpdateMgr", "dynamic config panel file name :%s", new Object[]{readLine});
                        }
                        file4 = new File(file5, readLine);
                        if (file4.exists()) {
                            i.t(file4);
                            ap.yY();
                            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzZ, readLine);
                        } else {
                            w.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel config don't exist.");
                        }
                    } else {
                        w.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiPanel unzip file failed.");
                    }
                } else if (bbVar.fEA.fEC == 3) {
                    if (!i.alH().a(bbVar, i.a.SUGGEST)) {
                        w.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiSuggest need no update.");
                    } else if (i.a(bbVar, i.a.SUGGEST, i.kKe)) {
                        file4 = new File(new File(i.alI(), i.kKe), i.kKp);
                        if (file4.exists()) {
                            i.u(file4);
                        } else {
                            w.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiSuggest config don't exist.");
                        }
                    } else {
                        w.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiSuggest unzip file failed.");
                    }
                } else if (bbVar.fEA.fEC == 5) {
                    if (i.alH().a(bbVar, i.a.EGG)) {
                        if (i.a(bbVar, i.a.EGG, i.kKf)) {
                            file4 = new File(new File(i.alI(), i.kKf), i.kKq);
                            if (file4.exists()) {
                                i.v(file4);
                            } else {
                                w.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiEgg unzip file failed.");
                            }
                        } else {
                            w.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiEgg unzip file failed.");
                        }
                    }
                } else if (bbVar.fEA.fEC == 4) {
                    i.alH();
                    w.d("MicroMsg.emoji.EmojiResUpdateMgr", "updateAppleColorEmoji");
                    if (i.b(bbVar)) {
                        com.tencent.mm.bi.b.bKy();
                        readLine = bbVar.fEA.filePath;
                        com.tencent.mm.bi.b.bKz();
                        j.ex(readLine, com.tencent.mm.bi.b.uxV);
                        com.tencent.mm.bi.b.bKy().init();
                    }
                }
            }
        }
        return false;
    }
}
