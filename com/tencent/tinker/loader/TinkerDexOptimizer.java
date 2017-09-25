package com.tencent.tinker.loader;

import android.os.Build.VERSION;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class TinkerDexOptimizer {

    private static class OptimizeWorker {
        private static String xhg = null;
        private final boolean xgD;
        private final File xhh;
        private final File xhi;
        private final ResultCallback xhj;

        OptimizeWorker(File file, File file2, boolean z, String str, ResultCallback resultCallback) {
            this.xhh = file;
            this.xhi = file2;
            this.xgD = z;
            this.xhj = resultCallback;
            xhg = str;
        }

        public final boolean cgT() {
            try {
                if (SharePatchFileUtil.U(this.xhh) || this.xhj == null) {
                    if (this.xhj != null) {
                        this.xhj.N(this.xhh);
                    }
                    String l = SharePatchFileUtil.l(this.xhh, this.xhi);
                    if (this.xgD) {
                        String absolutePath = this.xhh.getAbsolutePath();
                        File file = new File(l);
                        if (!file.exists()) {
                            file.getParentFile().mkdirs();
                        }
                        List arrayList = new ArrayList();
                        arrayList.add("dex2oat");
                        if (VERSION.SDK_INT >= 24) {
                            arrayList.add("--runtime-arg");
                            arrayList.add("-classpath");
                            arrayList.add("--runtime-arg");
                            arrayList.add("&");
                        }
                        arrayList.add("--dex-file=" + absolutePath);
                        arrayList.add("--oat-file=" + l);
                        arrayList.add("--instruction-set=" + xhg);
                        if (VERSION.SDK_INT > 25) {
                            arrayList.add("--compiler-filter=quicken");
                        } else {
                            arrayList.add("--compiler-filter=interpret-only");
                        }
                        ProcessBuilder processBuilder = new ProcessBuilder(arrayList);
                        processBuilder.redirectErrorStream(true);
                        Process start = processBuilder.start();
                        StreamConsumer.r(start.getInputStream());
                        StreamConsumer.r(start.getErrorStream());
                        int waitFor = start.waitFor();
                        if (waitFor != 0) {
                            throw new IOException("dex2oat works unsuccessfully, exit code: " + waitFor);
                        }
                    }
                    DexFile.loadDex(this.xhh.getAbsolutePath(), l, 0);
                    if (this.xhj != null) {
                        this.xhj.j(this.xhh, new File(l));
                    }
                    return true;
                }
                this.xhj.b(this.xhh, new IOException("dex file " + this.xhh.getAbsolutePath() + " is not exist!"));
                return false;
            } catch (Throwable e) {
                throw new IOException("dex2oat is interrupted, msg: " + e.getMessage(), e);
            } catch (Throwable e2) {
                new StringBuilder("Failed to optimize dex: ").append(this.xhh.getAbsolutePath());
                if (this.xhj != null) {
                    this.xhj.b(this.xhh, e2);
                    return false;
                }
            }
        }
    }

    public interface ResultCallback {
        void N(File file);

        void b(File file, Throwable th);

        void j(File file, File file2);
    }

    private static class StreamConsumer {
        static final Executor xhk = Executors.newSingleThreadExecutor();

        private StreamConsumer() {
        }

        static void r(final InputStream inputStream) {
            xhk.execute(new Runnable() {
                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                    r2 = this;
                    r0 = r2;
                    if (r0 != 0) goto L_0x0005;
                L_0x0004:
                    return;
                L_0x0005:
                    r0 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
                    r0 = new byte[r0];
                L_0x0009:
                    r1 = r2;	 Catch:{ IOException -> 0x0019, all -> 0x0022 }
                    r1 = r1.read(r0);	 Catch:{ IOException -> 0x0019, all -> 0x0022 }
                    if (r1 > 0) goto L_0x0009;
                L_0x0011:
                    r0 = r2;	 Catch:{ Exception -> 0x0017 }
                    r0.close();	 Catch:{ Exception -> 0x0017 }
                    goto L_0x0004;
                L_0x0017:
                    r0 = move-exception;
                    goto L_0x0004;
                L_0x0019:
                    r0 = move-exception;
                    r0 = r2;	 Catch:{ Exception -> 0x0020 }
                    r0.close();	 Catch:{ Exception -> 0x0020 }
                    goto L_0x0004;
                L_0x0020:
                    r0 = move-exception;
                    goto L_0x0004;
                L_0x0022:
                    r0 = move-exception;
                    r1 = r2;	 Catch:{ Exception -> 0x0029 }
                    r1.close();	 Catch:{ Exception -> 0x0029 }
                L_0x0028:
                    throw r0;
                L_0x0029:
                    r1 = move-exception;
                    goto L_0x0028;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.TinkerDexOptimizer.StreamConsumer.1.run():void");
                }
            });
        }
    }

    public static boolean a(Collection<File> collection, File file, ResultCallback resultCallback) {
        return a(collection, file, false, null, resultCallback);
    }

    public static boolean a(Collection<File> collection, File file, boolean z, String str, ResultCallback resultCallback) {
        Object arrayList = new ArrayList(collection);
        Collections.sort(arrayList, new Comparator<File>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                long length = ((File) obj).length() - ((File) obj2).length();
                if (length > 0) {
                    return 1;
                }
                return length == 0 ? 0 : -1;
            }
        });
        Collections.reverse(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!new OptimizeWorker((File) it.next(), file, z, str, resultCallback).cgT()) {
                return false;
            }
        }
        return true;
    }
}
