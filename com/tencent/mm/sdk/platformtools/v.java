package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import java.util.Locale;

public final class v {
    public static Locale usH = Locale.getDefault();

    public static boolean Pn(String str) {
        if (bg.mA(str)) {
            return false;
        }
        if (str.equalsIgnoreCase("zh_TW") || str.equalsIgnoreCase("zh_HK") || str.equalsIgnoreCase("zh_CN") || str.equalsIgnoreCase("en") || str.equalsIgnoreCase("th") || str.equals(SlookAirButtonFrequentContactAdapter.ID) || str.equals("vi") || str.equalsIgnoreCase("pt") || str.equalsIgnoreCase("es") || str.equalsIgnoreCase("ru") || str.equalsIgnoreCase("ar") || str.equalsIgnoreCase("he") || str.equalsIgnoreCase("pl") || str.equalsIgnoreCase("hi") || str.equalsIgnoreCase("ja") || str.equalsIgnoreCase("it") || str.equalsIgnoreCase("ko") || str.equalsIgnoreCase("ms") || str.equalsIgnoreCase("tr") || str.equalsIgnoreCase("de") || str.equalsIgnoreCase("fr") || str.equalsIgnoreCase("my") || str.equalsIgnoreCase("lo")) {
            return true;
        }
        return false;
    }

    public static boolean bIJ() {
        String bIN = bIN();
        return bIN.equals("zh_CN") || bIN.equals("zh_TW") || bIN.equals("zh_HK");
    }

    public static boolean bIK() {
        if (bIN().equals("zh_CN")) {
            return true;
        }
        return false;
    }

    public static boolean bIL() {
        return bIN().equals("zh_TW") || bIN().equals("zh_HK");
    }

    public static void a(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        if (!configuration.locale.equals(locale)) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            configuration.locale = locale;
            resources.updateConfiguration(configuration, displayMetrics);
            Resources.getSystem().updateConfiguration(configuration, displayMetrics);
        }
    }

    public static Locale Po(String str) {
        if (str.equals("zh_TW")) {
            return Locale.TAIWAN;
        }
        if (str.equals("zh_HK")) {
            return new Locale("zh", "HK");
        }
        if (str.equals("en")) {
            return Locale.ENGLISH;
        }
        if (str.equals("zh_CN")) {
            return Locale.CHINA;
        }
        if (str.equalsIgnoreCase("th") || str.equalsIgnoreCase(SlookAirButtonFrequentContactAdapter.ID) || str.equalsIgnoreCase("vi") || str.equalsIgnoreCase("pt") || str.equalsIgnoreCase("es") || str.equalsIgnoreCase("ru") || str.equalsIgnoreCase("ar") || str.equalsIgnoreCase("he") || str.equalsIgnoreCase("pl") || str.equalsIgnoreCase("hi") || str.equalsIgnoreCase("ja") || str.equalsIgnoreCase("it") || str.equalsIgnoreCase("ko") || str.equalsIgnoreCase("ms") || str.equalsIgnoreCase("tr") || str.equalsIgnoreCase("de") || str.equalsIgnoreCase("fr") || str.equalsIgnoreCase("my") || str.equalsIgnoreCase("lo")) {
            return new Locale(str);
        }
        if (str.equalsIgnoreCase("in_ID")) {
            return new Locale(SlookAirButtonFrequentContactAdapter.ID);
        }
        w.e("MicroMsg.LocaleUtil", "transLanguageToLocale country = " + str);
        return Locale.ENGLISH;
    }

    public static void b(Configuration configuration) {
        if (VERSION.SDK_INT >= 24 && configuration != null) {
            Locale.setDefault(configuration.locale);
            usH = Locale.getDefault();
            w.i("MicroMsg.LocaleUtil", "current locale:%s", usH);
        }
    }

    public static String bIM() {
        return Locale.getDefault().getCountry().trim();
    }

    private static String Pp(String str) {
        String trim = Locale.getDefault().getLanguage().trim();
        String str2 = trim + "_" + Locale.getDefault().getCountry().trim();
        if (trim.equals("en")) {
            return trim;
        }
        if (str2.equals("zh_TW")) {
            return "zh_TW";
        }
        if (str2.equals("zh_HK")) {
            return "zh_HK";
        }
        if (str2.equals("zh_CN")) {
            return "zh_CN";
        }
        if (trim.equals("th")) {
            return "th";
        }
        if (trim.equals(SlookAirButtonFrequentContactAdapter.ID)) {
            return SlookAirButtonFrequentContactAdapter.ID;
        }
        if (str2.equals("in_ID")) {
            return SlookAirButtonFrequentContactAdapter.ID;
        }
        if (trim.equals("vi")) {
            return "vi";
        }
        if (trim.equals("pt")) {
            return "pt";
        }
        if (trim.equals("es")) {
            return "es";
        }
        if (trim.equals("ru")) {
            return "ru";
        }
        if (trim.equals("ar")) {
            return "ar";
        }
        if (trim.equals("he")) {
            return "he";
        }
        if (trim.equals("pl")) {
            return "pl";
        }
        if (trim.equals("hi")) {
            return "hi";
        }
        if (trim.equals("ja")) {
            return "ja";
        }
        if (trim.equals("it")) {
            return "it";
        }
        if (trim.equals("ko")) {
            return "ko";
        }
        if (trim.equals("ms")) {
            return "ms";
        }
        if (trim.equals("tr")) {
            return "tr";
        }
        if (trim.equals("de")) {
            return "de";
        }
        if (trim.equals("fr")) {
            return "fr";
        }
        if (trim.equals("my")) {
            return "my";
        }
        if (trim.equals("lo")) {
            return "lo";
        }
        return str;
    }

    public static String bIN() {
        String mz = bg.mz(bc.getProperty("language_key"));
        return (mz.length() <= 0 || mz.equals("language_default")) ? Pp("en") : mz;
    }

    public static String d(SharedPreferences sharedPreferences) {
        String mz = bg.mz(sharedPreferences.getString("language_key", null));
        if (mz.length() <= 0 || mz.equals("language_default")) {
            mz = Pp("en");
            bc.setProperty("language_key", mz);
            return mz;
        }
        bc.setProperty("language_key", mz);
        return mz;
    }

    public static String e(SharedPreferences sharedPreferences) {
        String mz = bg.mz(sharedPreferences.getString("language_key", null));
        return !bg.mA(mz) ? mz : "language_default";
    }

    public static void a(SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences.edit().putString("language_key", str).commit()) {
            bc.setProperty("language_key", str);
            w.w("MicroMsg.LocaleUtil", "save application lang as:" + str);
            return;
        }
        w.e("MicroMsg.LocaleUtil", "saving application lang failed");
    }

    public static String ea(Context context) {
        String e = e(context.getSharedPreferences(ab.bIX(), 0));
        return e.equalsIgnoreCase("language_default") ? bIN() : e;
    }

    public static String g(Context context, int i, int i2) {
        int i3 = 0;
        String[] stringArray = context.getResources().getStringArray(i);
        String e = e(context.getSharedPreferences(ab.bIX(), 0));
        if (e == null) {
            return context.getString(i2);
        }
        String[] strArr = u.plf;
        int length = strArr.length;
        int i4 = 0;
        while (i3 < length) {
            if (strArr[i3].equals(e)) {
                return stringArray[i4];
            }
            i4++;
            i3++;
        }
        return context.getString(i2);
    }
}
