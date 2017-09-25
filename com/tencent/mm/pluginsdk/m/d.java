package com.tencent.mm.pluginsdk.m;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;

public final class d {
    public static final String a(ContentResolver contentResolver, Uri uri) {
        OutputStream fileOutputStream;
        Throwable e;
        if (uri == null) {
            return null;
        }
        String type = contentResolver.getType(uri);
        String b = b(contentResolver, uri);
        if (bg.mA(b)) {
            b = "share_file" + MB(type);
        }
        File file = new File(e.gSx, b);
        if (FileOp.aO(file.getAbsolutePath())) {
            FileOp.deleteFile(file.getAbsolutePath());
        }
        InputStream openInputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                openInputStream = contentResolver.openInputStream(uri);
            } catch (Exception e2) {
                e = e2;
                openInputStream = null;
                try {
                    w.printErrStackTrace("MicroMsg.ShareUtil", e, "copy google photo img fail", new Object[0]);
                    com.tencent.mm.a.e.b(openInputStream);
                    com.tencent.mm.a.e.a(fileOutputStream);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    com.tencent.mm.a.e.b(openInputStream);
                    com.tencent.mm.a.e.a(fileOutputStream);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                openInputStream = null;
                com.tencent.mm.a.e.b(openInputStream);
                com.tencent.mm.a.e.a(fileOutputStream);
                throw e;
            }
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int read = openInputStream.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        b = file.getAbsolutePath();
                        com.tencent.mm.a.e.b(openInputStream);
                        com.tencent.mm.a.e.a(fileOutputStream);
                        return b;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                w.printErrStackTrace("MicroMsg.ShareUtil", e, "copy google photo img fail", new Object[0]);
                com.tencent.mm.a.e.b(openInputStream);
                com.tencent.mm.a.e.a(fileOutputStream);
                return null;
            }
        } catch (Exception e4) {
            e = e4;
            openInputStream = null;
            fileOutputStream = null;
            w.printErrStackTrace("MicroMsg.ShareUtil", e, "copy google photo img fail", new Object[0]);
            com.tencent.mm.a.e.b(openInputStream);
            com.tencent.mm.a.e.a(fileOutputStream);
            return null;
        } catch (Throwable th3) {
            e = th3;
            openInputStream = null;
            fileOutputStream = null;
            com.tencent.mm.a.e.b(openInputStream);
            com.tencent.mm.a.e.a(fileOutputStream);
            throw e;
        }
    }

    private static String b(ContentResolver contentResolver, Uri uri) {
        Cursor query;
        String name;
        Throwable e;
        String[] split;
        try {
            query = contentResolver.query(uri, new String[]{"_data"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        name = new File(query.getString(0)).getName();
                        if (query != null) {
                            query.close();
                        }
                        return name;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        w.printErrStackTrace("MicroMsg.ShareUtil", e, "getFileName", new Object[0]);
                        split = URLDecoder.decode(uri.toString(), "utf8").split("/");
                        name = split[split.length - 1];
                    } catch (Throwable e3) {
                        w.printErrStackTrace("MicroMsg.ShareUtil", e3, "getFileName From Uri", new Object[0]);
                        name = null;
                    } catch (Throwable th) {
                        e3 = th;
                        if (query != null) {
                            query.close();
                        }
                        throw e3;
                    }
                    if (query != null) {
                        query.close();
                    }
                    return name;
                }
            }
            name = null;
            if (query != null) {
                query.close();
            }
        } catch (Exception e4) {
            e3 = e4;
            query = null;
            w.printErrStackTrace("MicroMsg.ShareUtil", e3, "getFileName", new Object[0]);
            split = URLDecoder.decode(uri.toString(), "utf8").split("/");
            name = split[split.length - 1];
            if (query != null) {
                query.close();
            }
            return name;
        } catch (Throwable th2) {
            e3 = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e3;
        }
        return name;
    }

    public static final String a(ContentResolver contentResolver, Uri uri, int i) {
        OutputStream fileOutputStream;
        InputStream openInputStream;
        Throwable e;
        Throwable th;
        if (uri == null) {
            return null;
        }
        String absolutePath = new File(ab.getContext().getCacheDir(), "share_img_tmp_" + i + MB(contentResolver.getType(uri))).getAbsolutePath();
        if (FileOp.aO(absolutePath)) {
            FileOp.deleteFile(absolutePath);
        }
        try {
            fileOutputStream = new FileOutputStream(absolutePath);
            try {
                openInputStream = contentResolver.openInputStream(uri);
            } catch (Exception e2) {
                e = e2;
                openInputStream = null;
                try {
                    w.printErrStackTrace("MicroMsg.ShareUtil", e, "copy google photo img fail", new Object[0]);
                    com.tencent.mm.a.e.b(openInputStream);
                    com.tencent.mm.a.e.a(fileOutputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    com.tencent.mm.a.e.b(openInputStream);
                    com.tencent.mm.a.e.a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable e3) {
                openInputStream = null;
                th = e3;
                com.tencent.mm.a.e.b(openInputStream);
                com.tencent.mm.a.e.a(fileOutputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int read = openInputStream.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        com.tencent.mm.a.e.b(openInputStream);
                        com.tencent.mm.a.e.a(fileOutputStream);
                        return absolutePath;
                    }
                }
            } catch (Exception e4) {
                e3 = e4;
                w.printErrStackTrace("MicroMsg.ShareUtil", e3, "copy google photo img fail", new Object[0]);
                com.tencent.mm.a.e.b(openInputStream);
                com.tencent.mm.a.e.a(fileOutputStream);
                return null;
            }
        } catch (Exception e5) {
            e3 = e5;
            openInputStream = null;
            fileOutputStream = null;
            w.printErrStackTrace("MicroMsg.ShareUtil", e3, "copy google photo img fail", new Object[0]);
            com.tencent.mm.a.e.b(openInputStream);
            com.tencent.mm.a.e.a(fileOutputStream);
            return null;
        } catch (Throwable e32) {
            openInputStream = null;
            fileOutputStream = null;
            th = e32;
            com.tencent.mm.a.e.b(openInputStream);
            com.tencent.mm.a.e.a(fileOutputStream);
            throw th;
        }
    }

    private static String MB(String str) {
        if (bg.mA(str)) {
            return "";
        }
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
        if (extensionFromMimeType == null || extensionFromMimeType.length() == 0) {
            String[] split = str.split("/");
            if (split != null && split.length > 1) {
                extensionFromMimeType = split[1];
            }
        }
        return "." + extensionFromMimeType;
    }
}
