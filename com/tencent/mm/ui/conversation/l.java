package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.i.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public final class l {
    public static h weq = null;

    public static void eZ(Context context) {
        if (bg.bKe()) {
            String value = g.sV().getValue("NewShowRating");
            if (!bg.mA(value)) {
                Map q = bh.q(value, "ShowRatingNode");
                value = (q == null || q.get(".ShowRatingNode.MinVer") == null) ? "0" : (String) q.get(".ShowRatingNode.MinVer");
                int intValue = Integer.decode(value).intValue();
                value = (q == null || q.get(".ShowRatingNode.MaxVer") == null) ? "0" : (String) q.get(".ShowRatingNode.MaxVer");
                int intValue2 = Integer.decode(value).intValue();
                if (q == null || q.get(".ShowRatingNode.WaitDays") == null) {
                    value = "0";
                } else {
                    value = (String) q.get(".ShowRatingNode.WaitDays");
                }
                int intValue3 = Integer.decode(value).intValue();
                if (intValue <= d.sYN && d.sYN <= intValue2) {
                    Object obj;
                    final SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
                    int i = sharedPreferences.getInt("show_rating_flag", 0);
                    int i2 = sharedPreferences.getInt("show_rating_version", 0);
                    long j = sharedPreferences.getLong("show_rating_timestamp", 0);
                    boolean z = sharedPreferences.getBoolean("show_rating_again", false);
                    long j2 = ((long) (intValue3 == 0 ? 7 : intValue3)) * 86400000;
                    if (i2 == 0 || intValue > i2 || i2 > intValue2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        sharedPreferences.edit().putInt("show_rating_version", d.sYN).commit();
                        sharedPreferences.edit().putInt("show_rating_flag", 0).commit();
                        i = 0;
                        j = System.currentTimeMillis();
                        sharedPreferences.edit().putLong("show_rating_timestamp", j).commit();
                        sharedPreferences.edit().putBoolean("show_rating_again", false).commit();
                        sharedPreferences.edit().putInt("show_rating_wait_days", intValue3).commit();
                        sharedPreferences.edit().putInt("show_rating_first_second_time", (int) (System.currentTimeMillis() / 1000)).commit();
                        w.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]current clientVersion=%s,has rating clientVersion=%s,dynamic config showRatting min version=%s,max version:%s,waitDaysMillis:%s", Integer.valueOf(d.sYN), Integer.valueOf(i2), Integer.valueOf(intValue), Integer.valueOf(intValue2), Long.valueOf(j2));
                    }
                    if (intValue <= d.sYN && d.sYN <= intValue2 && i == 0 && r2 != 0 && System.currentTimeMillis() >= r2 + j2) {
                        w.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show enjoy app dialog.");
                        Context context2 = context;
                        String string = context.getString(R.l.eWr);
                        String string2 = context.getString(R.l.eWq);
                        context2 = context;
                        OnClickListener anonymousClass1 = new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                sharedPreferences.edit().putInt("show_rating_flag", 1).commit();
                                if (dialogInterface != null) {
                                    dialogInterface.dismiss();
                                }
                                l.weq = null;
                                l.l(context2, true);
                                w.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog from enjoy app dialog.");
                            }
                        };
                        context2 = context;
                        weq = com.tencent.mm.ui.base.g.a(context, false, context2.getString(R.l.eWy), "", string, string2, anonymousClass1, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                sharedPreferences.edit().putInt("show_rating_flag", 2).commit();
                                if (dialogInterface != null) {
                                    dialogInterface.dismiss();
                                }
                                l.weq = null;
                                l.fa(context2);
                                w.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show feedback dialog.");
                            }
                        });
                    } else if (z && r2 != 0 && System.currentTimeMillis() >= (r2 + j2) + 345600000) {
                        w.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog again.");
                        l(context, false);
                        sharedPreferences.edit().putInt("show_rating_flag", 3).commit();
                    } else if (i == 1) {
                        l(context, true);
                    } else if (i == 2) {
                        fa(context);
                    } else if (i == 3) {
                        l(context, false);
                    }
                }
            }
        }
    }

    public static void l(Context context, boolean z) {
        String string;
        String str;
        String str2;
        final SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
        final boolean z2 = sharedPreferences.getBoolean("show_rating_again", false);
        final int i = sharedPreferences.getInt("show_rating_wait_days", 0);
        final int i2 = sharedPreferences.getInt("show_rating_first_second_time", 0);
        String string2;
        String string3;
        if (z) {
            string2 = context.getString(R.l.eWx);
            string3 = context.getString(R.l.eWw);
            string = context.getString(R.l.eWv);
            str = string3;
            str2 = string2;
        } else {
            string2 = context.getString(R.l.eWu);
            string3 = context.getString(R.l.eWt);
            string = context.getString(R.l.eWs);
            str = string3;
            str2 = string2;
        }
        final Context context2 = context;
        weq = com.tencent.mm.ui.base.g.a(context, false, str2, "", str, string, (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                String str = "market://details?id=" + ab.getPackageName();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                context2.startActivity(intent);
                w.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]start market intent");
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                sharedPreferences.edit().putBoolean("show_rating_again", false).commit();
                l.weq = null;
                if (z2) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(11216, Integer.valueOf(5), Integer.valueOf(i2), Integer.valueOf(i));
                    return;
                }
                com.tencent.mm.plugin.report.service.g.oUh.i(11216, Integer.valueOf(4), Integer.valueOf(i2), Integer.valueOf(i));
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                if (z2) {
                    sharedPreferences.edit().putBoolean("show_rating_again", false).commit();
                    com.tencent.mm.plugin.report.service.g.oUh.i(11216, Integer.valueOf(3), Integer.valueOf(i2), Integer.valueOf(i));
                } else {
                    w.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]need to show rating dialog again.");
                    sharedPreferences.edit().putBoolean("show_rating_again", true).commit();
                    com.tencent.mm.plugin.report.service.g.oUh.i(11216, Integer.valueOf(6), Integer.valueOf(i2), Integer.valueOf(i));
                }
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                l.weq = null;
            }
        });
    }

    public static void fa(final Context context) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
        final int i = sharedPreferences.getInt("show_rating_wait_days", 0);
        final int i2 = sharedPreferences.getInt("show_rating_first_second_time", 0);
        String string = context.getString(R.l.eWA);
        String string2 = context.getString(R.l.eWz);
        OnClickListener anonymousClass5 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                com.tencent.mm.pluginsdk.d.c(context, (int) System.currentTimeMillis(), "weixin://dl/feedback");
                l.weq = null;
                com.tencent.mm.plugin.report.service.g.oUh.i(11216, Integer.valueOf(2), Integer.valueOf(i2), Integer.valueOf(i));
            }
        };
        OnClickListener anonymousClass6 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                l.weq = null;
                com.tencent.mm.plugin.report.service.g.oUh.i(11216, Integer.valueOf(1), Integer.valueOf(i2), Integer.valueOf(i));
            }
        };
        weq = com.tencent.mm.ui.base.g.a(context, false, context.getString(R.l.eWB), "", string, string2, anonymousClass5, anonymousClass6);
    }

    public static void bYP() {
        if (weq != null) {
            weq.dismiss();
            weq = null;
        }
    }
}
