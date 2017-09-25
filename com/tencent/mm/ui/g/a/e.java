package com.tencent.mm.ui.g.a;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class e {
    private static String j(Bundle bundle, String str) {
        if (bundle == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : bundle.keySet()) {
            if (bundle.getByteArray(str2) == null) {
                stringBuilder.append("Content-Disposition: form-data; name=\"" + str2 + "\"\r\n\r\n" + bundle.getString(str2));
                stringBuilder.append("\r\n--" + str + "\r\n");
            }
        }
        return stringBuilder.toString();
    }

    public static String ae(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : bundle.keySet()) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append('&');
            }
            stringBuilder.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(bundle.getString(str)));
        }
        return stringBuilder.toString();
    }

    private static Bundle TZ(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                bundle.putString(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
            }
        }
        return bundle;
    }

    public static Bundle Ua(String str) {
        try {
            URL url = new URL(str.replace("fbconnect", "http"));
            Bundle TZ = TZ(url.getQuery());
            TZ.putAll(TZ(url.getRef()));
            return TZ;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }

    public static String e(String str, String str2, Bundle bundle) {
        String str3 = "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f";
        String str4 = "\r\n";
        if (str2.equals("GET")) {
            str = str + "?" + ae(bundle);
        }
        w.d("Facebook-Util", str2 + " URL: " + str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(20000);
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setRequestProperty("User-Agent", System.getProperties().getProperty("http.agent") + " FacebookAndroidSDK");
        if (!str2.equals("GET")) {
            Bundle bundle2 = new Bundle();
            for (String str5 : bundle.keySet()) {
                if (bundle.getByteArray(str5) != null) {
                    bundle2.putByteArray(str5, bundle.getByteArray(str5));
                }
            }
            if (!bundle.containsKey("method")) {
                bundle.putString("method", str2);
            }
            if (bundle.containsKey("access_token")) {
                bundle.putString("access_token", URLDecoder.decode(bundle.getString("access_token")));
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + str3);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.connect();
            OutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
            bufferedOutputStream.write(("--" + str3 + str4).getBytes());
            bufferedOutputStream.write(j(bundle, str3).getBytes());
            bufferedOutputStream.write((str4 + "--" + str3 + str4).getBytes());
            if (!bundle2.isEmpty()) {
                for (String str52 : bundle2.keySet()) {
                    bufferedOutputStream.write(("Content-Disposition: form-data; filename=\"" + str52 + "\"" + str4).getBytes());
                    bufferedOutputStream.write(("Content-Type: content/unknown" + str4 + str4).getBytes());
                    bufferedOutputStream.write(bundle2.getByteArray(str52));
                    bufferedOutputStream.write((str4 + "--" + str3 + str4).getBytes());
                }
            }
            bufferedOutputStream.flush();
        }
        try {
            return n(httpURLConnection.getInputStream());
        } catch (FileNotFoundException e) {
            return n(httpURLConnection.getErrorStream());
        }
    }

    private static String n(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1000);
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            stringBuilder.append(readLine);
        }
        inputStream.close();
        return stringBuilder.toString();
    }

    public static JSONObject Ub(String str) {
        if (str.equals("false")) {
            throw new d("request failed");
        }
        if (str.equals("true")) {
            str = "{value : true}";
        }
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("error")) {
            jSONObject = jSONObject.getJSONObject("error");
            throw new d(jSONObject.getString("message"), jSONObject.getString(Columns.TYPE), 0);
        } else if (jSONObject.has("error_code") && jSONObject.has("error_msg")) {
            throw new d(jSONObject.getString("error_msg"), "", Integer.parseInt(jSONObject.getString("error_code")));
        } else if (jSONObject.has("error_code")) {
            throw new d("request failed", "", Integer.parseInt(jSONObject.getString("error_code")));
        } else if (jSONObject.has("error_msg")) {
            throw new d(jSONObject.getString("error_msg"));
        } else if (!jSONObject.has("error_reason")) {
            return jSONObject;
        } else {
            throw new d(jSONObject.getString("error_reason"));
        }
    }

    public static void A(Context context, String str, String str2) {
        Builder builder = new Builder(context);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.create().show();
    }
}
