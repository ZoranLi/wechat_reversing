package com.tinkerboots.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.tinker.lib.a.b;
import com.tencent.tinker.lib.c.c;
import com.tencent.tinker.lib.c.d;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tenpay.android.wechat.PayuSecureEncrypt.EncrptType;
import java.io.File;

public final class a {
    public static a xmg;
    private final ApplicationLike applicationLike;
    public final com.tencent.tinker.lib.d.a xmh;
    public final com.tinkerboots.sdk.a.a xmi;

    public static class a {
        public final ApplicationLike applicationLike;
        public final Context context;
        public b xgp;
        public c xgq;
        public d xgr;
        public com.tencent.tinker.lib.b.a xml;
        public Class<? extends AbstractResultService> xmm;
        public com.tinkerboots.sdk.a.a.b xmn;

        public a(ApplicationLike applicationLike) {
            if (applicationLike == null) {
                throw new TinkerRuntimeException("applicationLike must not be null.");
            }
            this.context = applicationLike.getApplication();
            this.applicationLike = applicationLike;
        }
    }

    public a(Context context, ApplicationLike applicationLike, c cVar, d dVar, b bVar, com.tencent.tinker.lib.b.a aVar, Class<? extends AbstractResultService> cls, com.tinkerboots.sdk.a.a.b bVar2) {
        com.tinkerboots.sdk.b.b.context = context;
        this.applicationLike = applicationLike;
        this.xmi = com.tinkerboots.sdk.a.a.a(bVar2);
        com.tencent.tinker.lib.d.a.a aVar2 = new com.tencent.tinker.lib.d.a.a(applicationLike.getApplication());
        int tinkerFlags = applicationLike.getTinkerFlags();
        if (aVar2.status != -1) {
            throw new TinkerRuntimeException("tinkerFlag is already set.");
        }
        aVar2.status = tinkerFlags;
        if (cVar == null) {
            throw new TinkerRuntimeException("loadReporter must not be null.");
        } else if (aVar2.xgq != null) {
            throw new TinkerRuntimeException("loadReporter is already set.");
        } else {
            aVar2.xgq = cVar;
            if (bVar == null) {
                throw new TinkerRuntimeException("listener must not be null.");
            } else if (aVar2.xgp != null) {
                throw new TinkerRuntimeException("listener is already set.");
            } else {
                aVar2.xgp = bVar;
                if (dVar == null) {
                    throw new TinkerRuntimeException("patchReporter must not be null.");
                } else if (aVar2.xgr != null) {
                    throw new TinkerRuntimeException("patchReporter is already set.");
                } else {
                    aVar2.xgr = dVar;
                    Boolean valueOf = Boolean.valueOf(applicationLike.getTinkerLoadVerifyFlag());
                    if (valueOf == null) {
                        throw new TinkerRuntimeException("tinkerLoadVerifyFlag must not be null.");
                    } else if (aVar2.xgz != null) {
                        throw new TinkerRuntimeException("tinkerLoadVerifyFlag is already set.");
                    } else {
                        aVar2.xgz = valueOf;
                        com.tencent.tinker.lib.d.a cgR = aVar2.cgR();
                        com.tencent.tinker.lib.d.a.a(cgR);
                        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
                        com.tencent.tinker.lib.d.a.xgn = true;
                        TinkerPatchService.a(aVar, cls);
                        com.tencent.tinker.lib.e.a.i("Tinker.Tinker", "try to install tinker, isEnable: %b, version: %s", new Object[]{Boolean.valueOf(ShareTinkerInternals.Ea(cgR.tinkerFlags)), "1.8.0"});
                        if (!ShareTinkerInternals.Ea(cgR.tinkerFlags)) {
                            com.tencent.tinker.lib.e.a.e("Tinker.Tinker", "tinker is disabled", new Object[0]);
                        } else if (tinkerResultIntent == null) {
                            throw new TinkerRuntimeException("intentResult must not be null.");
                        } else {
                            String VS;
                            cgR.xgv = new com.tencent.tinker.lib.d.d();
                            com.tencent.tinker.lib.d.d dVar2 = cgR.xgv;
                            com.tencent.tinker.lib.d.a hp = com.tencent.tinker.lib.d.a.hp(cgR.context);
                            dVar2.xgO = ShareIntentUtil.an(tinkerResultIntent);
                            dVar2.jgm = ShareIntentUtil.ao(tinkerResultIntent);
                            dVar2.xgE = ShareIntentUtil.q(tinkerResultIntent, "intent_patch_system_ota");
                            dVar2.xgB = ShareIntentUtil.i(tinkerResultIntent, "intent_patch_oat_dir");
                            dVar2.xgD = "interpet".equals(dVar2.xgB);
                            boolean z = hp.qPN;
                            com.tencent.tinker.lib.e.a.i("Tinker.TinkerLoadResult", "parseTinkerResult loadCode:%d, process name:%s, main process:%b, systemOTA:%b, fingerPrint:%s, oatDir:%s, useInterpretMode:%b", new Object[]{Integer.valueOf(dVar2.xgO), ShareTinkerInternals.hH(r2), Boolean.valueOf(z), Boolean.valueOf(dVar2.xgE), Build.FINGERPRINT, dVar2.xgB, Boolean.valueOf(dVar2.xgD)});
                            String i = ShareIntentUtil.i(tinkerResultIntent, "intent_patch_old_version");
                            String i2 = ShareIntentUtil.i(tinkerResultIntent, "intent_patch_new_version");
                            File file = hp.xgo;
                            File file2 = hp.xgs;
                            if (!(i == null || i2 == null)) {
                                if (z) {
                                    dVar2.xgA = i2;
                                } else {
                                    dVar2.xgA = i;
                                }
                                com.tencent.tinker.lib.e.a.i("Tinker.TinkerLoadResult", "parseTinkerResult oldVersion:%s, newVersion:%s, current:%s", new Object[]{i, i2, dVar2.xgA});
                                VS = SharePatchFileUtil.VS(dVar2.xgA);
                                if (!ShareTinkerInternals.mA(VS)) {
                                    dVar2.xgF = new File(file.getAbsolutePath() + "/" + VS);
                                    dVar2.xgG = new File(dVar2.xgF.getAbsolutePath(), SharePatchFileUtil.VT(dVar2.xgA));
                                    dVar2.xgH = new File(dVar2.xgF, "dex");
                                    dVar2.xgI = new File(dVar2.xgF, "lib");
                                    dVar2.xgJ = new File(dVar2.xgF, "res");
                                    dVar2.xgK = new File(dVar2.xgJ, "resources.apk");
                                }
                                dVar2.patchInfo = new SharePatchInfo(i, i2, Build.FINGERPRINT, dVar2.xgB);
                                dVar2.xgC = !i.equals(i2);
                            }
                            Throwable ap = ShareIntentUtil.ap(tinkerResultIntent);
                            if (ap == null) {
                                switch (dVar2.xgO) {
                                    case -10000:
                                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "can't get the right intent return code", new Object[0]);
                                        throw new TinkerRuntimeException("can't get the right intent return code");
                                    case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                                        if (dVar2.xgK != null) {
                                            com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch resource file md5 is mismatch: %s", new Object[]{dVar2.xgK.getAbsolutePath()});
                                            hp.xgq.a(dVar2.xgK, 6);
                                            break;
                                        }
                                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "resource file md5 mismatch, but patch resource file not found!", new Object[0]);
                                        throw new TinkerRuntimeException("resource file md5 mismatch, but patch resource file not found!");
                                    case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                                        if (dVar2.xgF != null) {
                                            com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch resource file not found:%s", new Object[]{dVar2.xgK.getAbsolutePath()});
                                            hp.xgq.a(dVar2.xgK, 6, false);
                                            break;
                                        }
                                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch resource file not found, warning why the path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch resource file not found, warning why the path is null!!!!");
                                    case DownloadResult.CODE_URL_ERROR /*-21*/:
                                        if (dVar2.xgF != null) {
                                            com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch resource file directory not found:%s", new Object[]{dVar2.xgJ.getAbsolutePath()});
                                            hp.xgq.a(dVar2.xgJ, 6, true);
                                            break;
                                        }
                                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch resource file directory not found, warning why the path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch resource file directory not found, warning why the path is null!!!!");
                                    case -19:
                                        com.tencent.tinker.lib.e.a.i("Tinker.TinkerLoadResult", "rewrite patch info file corrupted", new Object[0]);
                                        hp.xgq.a(i, i2, file2);
                                        break;
                                    case -18:
                                        VS = ShareIntentUtil.i(tinkerResultIntent, "intent_patch_missing_lib_path");
                                        if (VS != null) {
                                            com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch lib file not found:%s", new Object[]{VS});
                                            hp.xgq.a(new File(VS), 5, false);
                                            break;
                                        }
                                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch lib file not found, but path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch lib file not found, but path is null!!!!");
                                    case -17:
                                        if (dVar2.xgF != null) {
                                            com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch lib file directory not found:%s", new Object[]{dVar2.xgI.getAbsolutePath()});
                                            hp.xgq.a(dVar2.xgI, 5, true);
                                            break;
                                        }
                                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch lib file directory not found, warning why the path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch lib file directory not found, warning why the path is null!!!!");
                                    case -16:
                                        hp.xgq.b(2, ShareIntentUtil.aq(tinkerResultIntent));
                                        break;
                                    case -15:
                                        hp.xgq.b(1, ShareIntentUtil.aq(tinkerResultIntent));
                                        break;
                                    case -13:
                                        VS = ShareIntentUtil.i(tinkerResultIntent, "intent_patch_mismatch_dex_path");
                                        if (VS != null) {
                                            com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch: %s", new Object[]{VS});
                                            hp.xgq.a(new File(VS), 3);
                                            break;
                                        }
                                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch, but path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch dex file md5 is mismatch, but path is null!!!!");
                                    case -12:
                                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch dex load fail, classloader is null", new Object[0]);
                                        break;
                                    case -11:
                                        VS = ShareIntentUtil.i(tinkerResultIntent, "intent_patch_missing_dex_path");
                                        if (VS != null) {
                                            com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch dex opt file not found:%s", new Object[]{VS});
                                            hp.xgq.a(new File(VS), 4, false);
                                            break;
                                        }
                                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch dex opt file not found, but path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch dex opt file not found, but path is null!!!!");
                                    case -10:
                                        VS = ShareIntentUtil.i(tinkerResultIntent, "intent_patch_missing_dex_path");
                                        if (VS != null) {
                                            com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch dex file not found:%s", new Object[]{VS});
                                            hp.xgq.a(new File(VS), 3, false);
                                            break;
                                        }
                                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch dex file not found, but path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch dex file not found, but path is null!!!!");
                                    case -9:
                                        if (dVar2.xgH != null) {
                                            com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch dex file directory not found:%s", new Object[]{dVar2.xgH.getAbsolutePath()});
                                            hp.xgq.a(dVar2.xgH, 3, true);
                                            break;
                                        }
                                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch dex file directory not found, warning why the path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch dex file directory not found, warning why the path is null!!!!");
                                    case -8:
                                        com.tencent.tinker.lib.e.a.i("Tinker.TinkerLoadResult", "patch package check fail", new Object[0]);
                                        if (dVar2.xgG != null) {
                                            hp.xgq.b(dVar2.xgG, tinkerResultIntent.getIntExtra("intent_patch_package_patch_check", -10000));
                                            break;
                                        }
                                        throw new TinkerRuntimeException("error patch package check fail , but file is null");
                                    case -7:
                                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch version file not found, current version:%s", new Object[]{dVar2.xgA});
                                        if (dVar2.xgG != null) {
                                            hp.xgq.a(dVar2.xgG, 1, false);
                                            break;
                                        }
                                        throw new TinkerRuntimeException("error load patch version file not exist, but file is null");
                                    case -6:
                                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "patch version directory not found, current version:%s", new Object[]{dVar2.xgA});
                                        hp.xgq.a(dVar2.xgF, 1, true);
                                        break;
                                    case -5:
                                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "path info blank, wait main process to restart", new Object[0]);
                                        break;
                                    case -4:
                                        com.tencent.tinker.lib.e.a.e("Tinker.TinkerLoadResult", "path info corrupted", new Object[0]);
                                        hp.xgq.a(i, i2, file2);
                                        break;
                                    case -3:
                                    case -2:
                                        com.tencent.tinker.lib.e.a.w("Tinker.TinkerLoadResult", "can't find patch file, is ok, just return", new Object[0]);
                                        break;
                                    case -1:
                                        com.tencent.tinker.lib.e.a.w("Tinker.TinkerLoadResult", "tinker is disable, just return", new Object[0]);
                                        break;
                                    case 0:
                                        com.tencent.tinker.lib.e.a.i("Tinker.TinkerLoadResult", "oh yeah, tinker load all success", new Object[0]);
                                        hp.xgw = true;
                                        dVar2.xgL = ShareIntentUtil.ar(tinkerResultIntent);
                                        dVar2.xgM = ShareIntentUtil.as(tinkerResultIntent);
                                        dVar2.xgN = ShareIntentUtil.at(tinkerResultIntent);
                                        if (dVar2.xgD) {
                                            hp.xgq.b(0, null);
                                        }
                                        if (z && dVar2.xgC) {
                                            hp.xgq.a(i, i2, file, dVar2.xgF.getName());
                                            break;
                                        }
                                    default:
                                        break;
                                }
                            }
                            com.tencent.tinker.lib.e.a.i("Tinker.TinkerLoadResult", "Tinker load have exception loadCode:%d", new Object[]{Integer.valueOf(dVar2.xgO)});
                            int i3 = -1;
                            switch (dVar2.xgO) {
                                case DownloadResult.CODE_SOCKET_TIMEOUT_EXCEPTION /*-25*/:
                                    i3 = -4;
                                    break;
                                case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                                    i3 = -3;
                                    break;
                                case EncrptType.HASHED_SECRET_ANSWER /*-20*/:
                                    i3 = -1;
                                    break;
                                case -14:
                                    i3 = -2;
                                    break;
                            }
                            hp.xgq.a(ap, i3);
                            cgR.xgq.a(cgR.xgo, cgR.xgv.xgO, cgR.xgv.jgm);
                            if (!cgR.xgw) {
                                com.tencent.tinker.lib.e.a.w("Tinker.Tinker", "tinker load fail!", new Object[0]);
                            }
                        }
                        this.xmh = cgR;
                    }
                }
            }
        }
    }

    public static a chU() {
        if (xmg != null) {
            return xmg;
        }
        throw new TinkerRuntimeException("you must init TinkerClient sdk first");
    }

    public final a mm(final boolean z) {
        int i = 1;
        if (this.xmi == null || this.xmh == null) {
            com.tencent.tinker.lib.e.a.e("Tinker.TinkerClient", "fetchPatchUpdate, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
            return xmg;
        }
        Context context = com.tinkerboots.sdk.b.b.getContext();
        if (VERSION.SDK_INT >= 23) {
            int i2 = context.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 ? 1 : 0;
            int i3 = context.checkSelfPermission("android.permission.INTERNET") == 0 ? 1 : 0;
            if (i2 == 0 || i3 == 0) {
                i = 0;
            }
        }
        if (i == 0) {
            com.tencent.tinker.lib.e.a.e("Tinker.TinkerClient", "fetchPatchUpdate, permission refuse, you must access INTERNET and ACCESS_NETWORK_STATE permission first", new Object[0]);
            return xmg;
        } else if (ShareTinkerInternals.Ea(this.xmh.tinkerFlags) && ShareTinkerInternals.hD(context)) {
            if (this.xmh.qPN) {
                Looper.getMainLooper();
                Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                    final /* synthetic */ a xmk;

                    public final boolean queueIdle() {
                        com.tinkerboots.sdk.a.a aVar = this.xmk.xmi;
                        boolean z = z;
                        SharedPreferences sharedPreferences = com.tinkerboots.sdk.b.b.getContext().getSharedPreferences("patch_server_config", 0);
                        long j = sharedPreferences.getLong("fetch_patch_last_check", 0);
                        if (j == -1) {
                            com.tencent.tinker.lib.e.a.i("Tinker.ServerClient", "tinker sync is disabled, with never check flag!", new Object[0]);
                        } else {
                            j = System.currentTimeMillis() - j;
                            if (z || aVar.xmr || j >= aVar.xmp) {
                                sharedPreferences.edit().putLong("fetch_patch_last_check", System.currentTimeMillis()).commit();
                                com.tinkerboots.sdk.a.b.a aVar2 = aVar.xmq;
                                com.tinkerboots.sdk.a.a.b bVar = aVar.xmn;
                                if (bVar == null) {
                                    throw new RuntimeException("callback can't be null");
                                } else if (bVar.aDm()) {
                                    bVar.aDn();
                                    bVar.w(aVar2.xms.xmt);
                                }
                            } else {
                                com.tencent.tinker.lib.e.a.i("Tinker.ServerClient", "tinker sync should wait interval %ss", new Object[]{Long.valueOf((aVar.xmp - j) / 1000)});
                            }
                        }
                        return false;
                    }
                });
            }
            return xmg;
        } else {
            com.tencent.tinker.lib.e.a.e("Tinker.TinkerClient", "fetchPatchUpdate, tinker is disable, just return", new Object[0]);
            return xmg;
        }
    }

    public final a fo(String str, String str2) {
        if (this.xmi == null) {
            com.tencent.tinker.lib.e.a.e("Tinker.TinkerClient", "setPatchCondition, tinkerServerClient == null, just return", new Object[0]);
            return xmg;
        }
        com.tencent.tinker.lib.e.a.i("Tinker.TinkerClient", "setPatchCondition %s with value %s", new Object[]{str, str2});
        this.xmi.xmq.xms.xmt.put(str, str2);
        return xmg;
    }

    public final a El(int i) {
        if (this.xmi == null) {
            com.tencent.tinker.lib.e.a.e("Tinker.TinkerClient", "setFetchPatchIntervalByHours, tinkerServerClient == null, just return", new Object[0]);
            return xmg;
        }
        com.tencent.tinker.lib.e.a.i("Tinker.TinkerClient", "setFetchPatchIntervalByHours to %d hours", new Object[]{Integer.valueOf(i)});
        com.tinkerboots.sdk.a.a aVar = this.xmi;
        if (((long) i) == -1) {
            com.tencent.tinker.lib.e.a.i("Tinker.ServerClient", "Warning, disableFetchPatchUpdate", new Object[0]);
            com.tinkerboots.sdk.b.b.getContext().getSharedPreferences("patch_server_config", 0).edit().putLong("fetch_patch_last_check", -1).commit();
        } else if (i < 0 || i > 24) {
            throw new TinkerRuntimeException("hours must be between 0 and 24");
        } else {
            aVar.xmp = (((long) i) * 3600) * 1000;
        }
        return xmg;
    }
}
