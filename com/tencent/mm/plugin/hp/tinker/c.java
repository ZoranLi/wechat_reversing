package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tinker.lib.c.a;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public final class c extends a {
    public c(Context context) {
        super(context);
    }

    public final void a(Throwable th, int i) {
        super.a(th, i);
        b.a(th, i);
    }

    public final void a(File file, int i) {
        super.a(file, i);
        b.oe(i);
    }

    public final void a(File file, int i, boolean z) {
        com.tencent.tinker.lib.e.a.i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType:%d, isDirectory:%b", new Object[]{file.getAbsolutePath(), Integer.valueOf(i), Boolean.valueOf(z)});
        if (i == 4) {
            aDj();
        } else {
            cgP();
        }
        if (i == 1) {
            d dVar = com.tencent.tinker.lib.d.a.hp(this.context).xgv;
            if (dVar.xgA != null && "00000000000000000000000000000000".equals(dVar.xgA)) {
                com.tencent.tinker.lib.e.a.e("Tinker.TinkerPatchLoadReporter", "Roll back patch when restarting main process, restart all other process also!", new Object[0]);
                ShareTinkerInternals.hG(this.context);
            }
        }
        b.od(i);
    }

    public final void b(int i, Throwable th) {
        com.tencent.tinker.lib.e.a.i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret: type: %d, throwable: %s", new Object[]{Integer.valueOf(i), th});
        switch (i) {
            case 0:
                com.tencent.tinker.lib.e.a.i("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret ok", new Object[0]);
                break;
            case 1:
                com.tencent.tinker.lib.e.a.e("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret fail, can get instruction set from existed oat file", new Object[0]);
                break;
            case 2:
                com.tencent.tinker.lib.e.a.e("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret fail, command line to interpret return error", new Object[0]);
                break;
        }
        aDj();
        b.a(i, th);
    }

    public final void b(File file, int i) {
        super.b(file, i);
        b.i(ab.usY, i);
    }

    public final void a(String str, String str2, File file) {
        super.a(str, str2, file);
        b.aDf();
    }

    public final void a(String str, String str2, File file, String str3) {
        super.a(str, str2, file, str3);
        b.aDg();
    }

    public final void a(File file, int i, long j) {
        super.a(file, i, j);
        switch (i) {
            case 0:
                b.i(j, com.tencent.tinker.lib.d.a.hp(this.context).qPN);
                break;
        }
        if (com.tencent.tinker.lib.d.a.hp(this.context).qPN) {
            String absolutePath = new File(SharePatchFileUtil.hy(this.context), "temp.apk").getAbsolutePath();
            if (absolutePath == null || !new File(absolutePath).exists()) {
                com.tencent.tinker.lib.e.a.w("Tinker.TinkerPatchLoadReporter", "onPatchRetryLoad patch file: %s is not exist, just return", new Object[]{absolutePath});
            } else {
                a aVar = new a(this.context, new a.a(this) {
                    final /* synthetic */ c mLH;

                    {
                        this.mLH = r1;
                    }

                    public final void aDi() {
                        if (com.tencent.tinker.lib.e.c.hu(this.mLH.context).cgS()) {
                            b.aDc();
                        }
                    }
                });
            }
        } else {
            com.tencent.tinker.lib.e.a.w("Tinker.TinkerPatchLoadReporter", "onPatchRetryLoad retry is not main process, just return", new Object[0]);
        }
        w.d("Tinker.TinkerPatchLoadReporter", "onLoadResult loadcode:%d icost:%d", new Object[]{Integer.valueOf(i), Long.valueOf(j)});
        if (i == 0) {
            d dVar = com.tencent.tinker.lib.d.a.hp(this.context).xgv;
            w.i("Tinker.TinkerPatchLoadReporter", "onLoadResult currentVersion:%s", new Object[]{dVar.xgA});
            if (!TextUtils.isEmpty(dVar.xgA)) {
                Context context = this.context;
                context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_version_key", dVar.xgA).apply();
            }
        }
    }

    public final void c(File file, int i) {
        super.c(file, i);
        if (i == -26 || i == -5) {
            ShareTinkerInternals.hC(this.context);
            com.tencent.tinker.lib.d.a.hp(this.context).tinkerFlags = 0;
        }
        b.oa(i);
    }

    private void aDj() {
        a aVar = new a(this.context, new a.a(this) {
            final /* synthetic */ c mLH;

            {
                this.mLH = r1;
            }

            public final void aDi() {
                if (this.mLH.cgQ()) {
                    b.aDc();
                }
            }
        });
    }
}
