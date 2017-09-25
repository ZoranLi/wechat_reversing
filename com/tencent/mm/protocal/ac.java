package com.tencent.mm.protocal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class ac {
    public String tal;
    public String tam;
    public int ver;

    public static void G(String str, String str2, int i) {
        w.d("MicroMsg.RsaInfo", "summercert dkcert saveRsaInfo ver:%d keye:%s keyn:%s  ", Integer.valueOf(i), str, str2);
        Editor edit = ab.getContext().getSharedPreferences("rsa_public_key_prefs", 4).edit();
        edit.putString("keye", str);
        edit.putString("keyn", str2);
        edit.putInt("version", i);
        edit.putInt("client_version", d.sYN);
        edit.commit();
    }

    public static ac bHs() {
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("rsa_public_key_prefs", 4);
        ac acVar = new ac(sharedPreferences.getString("keye", ""), sharedPreferences.getString("keyn", ""), sharedPreferences.getInt("version", 0));
        int i = sharedPreferences.getInt("client_version", 0);
        if (!acVar.bHv()) {
            if (i > 637665843) {
                return acVar;
            }
            boolean commit = sharedPreferences.edit().clear().commit();
            c.oTb.a(148, 38, 1, false);
            w.i("MicroMsg.RsaInfo", "summercert clear old rsa lastClientVer[%d] nowVer[%d], commit[%b]", Integer.valueOf(i), Integer.valueOf(d.sYN), Boolean.valueOf(commit));
        }
        c.oTb.a(148, 39, 1, false);
        w.d("MicroMsg.RsaInfo", "summercert default req keye[%s], keyn[%s], ver[%d]", "010001", "E161DA03D0B6AAD21F9A4FB27C32A3208AF25A707BB0E8ECE79506FBBAF97519D9794B7E1B44D2C6F2588495C4E040303B4C915F172DD558A49552762CB28AB309C08152A8C55A4DFC6EA80D1F4D860190A8EE251DF8DECB9B083674D56CD956FF652C3C724B9F02BE5C7CBC63FC0124AA260D889A73E91292B6A02121D25AAA7C1A87752575C181FFB25A6282725B0C38A2AD57676E0884FE20CF56256E14529BC7E82CD1F4A1155984512BD273D68F769AF46E1B0E3053816D39EB1F0588384F2F4B286E5CFAFB4D0435BDF7D3AA8D3E0C45716EAD190FDC66884B275BA08D8ED94B1F84E7729C25BD014E7FA3A23123E10D3A93B4154452DDB9EE5F8DAB67".substring(0, 4) + "_" + "E161DA03D0B6AAD21F9A4FB27C32A3208AF25A707BB0E8ECE79506FBBAF97519D9794B7E1B44D2C6F2588495C4E040303B4C915F172DD558A49552762CB28AB309C08152A8C55A4DFC6EA80D1F4D860190A8EE251DF8DECB9B083674D56CD956FF652C3C724B9F02BE5C7CBC63FC0124AA260D889A73E91292B6A02121D25AAA7C1A87752575C181FFB25A6282725B0C38A2AD57676E0884FE20CF56256E14529BC7E82CD1F4A1155984512BD273D68F769AF46E1B0E3053816D39EB1F0588384F2F4B286E5CFAFB4D0435BDF7D3AA8D3E0C45716EAD190FDC66884B275BA08D8ED94B1F84E7729C25BD014E7FA3A23123E10D3A93B4154452DDB9EE5F8DAB67".substring(507, 511), Integer.valueOf(158));
        return new ac("010001", "E161DA03D0B6AAD21F9A4FB27C32A3208AF25A707BB0E8ECE79506FBBAF97519D9794B7E1B44D2C6F2588495C4E040303B4C915F172DD558A49552762CB28AB309C08152A8C55A4DFC6EA80D1F4D860190A8EE251DF8DECB9B083674D56CD956FF652C3C724B9F02BE5C7CBC63FC0124AA260D889A73E91292B6A02121D25AAA7C1A87752575C181FFB25A6282725B0C38A2AD57676E0884FE20CF56256E14529BC7E82CD1F4A1155984512BD273D68F769AF46E1B0E3053816D39EB1F0588384F2F4B286E5CFAFB4D0435BDF7D3AA8D3E0C45716EAD190FDC66884B275BA08D8ED94B1F84E7729C25BD014E7FA3A23123E10D3A93B4154452DDB9EE5F8DAB67", 158);
    }

    public static ac bHt() {
        return new ac("010001", "D8D2AE73FF601B93B1471B35870A1B59D7649EEA815CDD8CE5496BBD0C6CFE19C0E082F4E513B615C6030CCFCE3153E25AA00E8156D0311AF72ABBB9BBEC8B1D3751592234B1A621CA774E2EC50047A93FA0BC60DF0C10E8A65C3B29D13167EC217FC6A29034494870705CBF4AC929FBA0E1E656A8F8B50E779AD89BB4EEF6FF", 125);
    }

    public static ac bHu() {
        w.d("MicroMsg.RsaInfo", "summercert default base keye[%s], keyn[%s], ver[%d]", "010001", "DFCA42006DB7133D885F1A96C5619061A164C450C2003DCD4DD6268A01C2EAD9A75441E7DE44C5D9FC0E17B85C07FF044F62387EE3224080F3C04C6441EC683FE7BC7D97F1115B720B240BBF62CA28004160B30951AE80C75DF5D7C67D2C2241D291550E68890914CAC9F575599570D26F58883E4685A50FAF2C6C2C85C03CE90D6DCC52AEA0960DFBC5A86344ECCD6F3D6B8C898EDA99A43FE3D5D2BA716AA67E947FB97C67F78B7B2BF349079D796E1B0B2F49143F7587A6A186D608065FDB6D238FF1F1BC34DF908D81E09AC37B5A5E9DA7AF468FBBF9BDD423B3FB884FAF3AE00F3E1C7E29FDCB6E95F44ACC12B06F30C672DF245E2FC0D5CE7347AC092B".substring(0, 4) + "_" + "DFCA42006DB7133D885F1A96C5619061A164C450C2003DCD4DD6268A01C2EAD9A75441E7DE44C5D9FC0E17B85C07FF044F62387EE3224080F3C04C6441EC683FE7BC7D97F1115B720B240BBF62CA28004160B30951AE80C75DF5D7C67D2C2241D291550E68890914CAC9F575599570D26F58883E4685A50FAF2C6C2C85C03CE90D6DCC52AEA0960DFBC5A86344ECCD6F3D6B8C898EDA99A43FE3D5D2BA716AA67E947FB97C67F78B7B2BF349079D796E1B0B2F49143F7587A6A186D608065FDB6D238FF1F1BC34DF908D81E09AC37B5A5E9DA7AF468FBBF9BDD423B3FB884FAF3AE00F3E1C7E29FDCB6E95F44ACC12B06F30C672DF245E2FC0D5CE7347AC092B".substring(507, 511), Integer.valueOf(157));
        return new ac("010001", "DFCA42006DB7133D885F1A96C5619061A164C450C2003DCD4DD6268A01C2EAD9A75441E7DE44C5D9FC0E17B85C07FF044F62387EE3224080F3C04C6441EC683FE7BC7D97F1115B720B240BBF62CA28004160B30951AE80C75DF5D7C67D2C2241D291550E68890914CAC9F575599570D26F58883E4685A50FAF2C6C2C85C03CE90D6DCC52AEA0960DFBC5A86344ECCD6F3D6B8C898EDA99A43FE3D5D2BA716AA67E947FB97C67F78B7B2BF349079D796E1B0B2F49143F7587A6A186D608065FDB6D238FF1F1BC34DF908D81E09AC37B5A5E9DA7AF468FBBF9BDD423B3FB884FAF3AE00F3E1C7E29FDCB6E95F44ACC12B06F30C672DF245E2FC0D5CE7347AC092B", 157);
    }

    public final boolean bHv() {
        return this.ver == 0 || bg.mA(this.tal) || bg.mA(this.tam);
    }

    ac(String str, String str2, int i) {
        this.tal = str;
        this.tam = str2;
        this.ver = i;
    }

    public static boolean bHw() {
        FileWriter fileWriter;
        Throwable e;
        Throwable th;
        boolean z = false;
        try {
            fileWriter = new FileWriter(e.hgu + "DefaultRSA.java");
            try {
                fileWriter.write("package com.tencent.mm.protocal;\n\n");
                fileWriter.write("/**\n *\n * @ClientVersion: " + com.tencent.mm.sdk.platformtools.e.CLIENT_VERSION + "\n");
                fileWriter.write(" * @DumpTime: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " \n */\n");
                fileWriter.write("public final class DefaultRSA {\n");
                fileWriter.write("\n\tpublic final static int BASE_RSA_PUBLIC_VERSION = 157;");
                fileWriter.write("\n\tpublic final static String BASE_RSA_PUBLIC_KEYN = \"DFCA42006DB7133D885F1A96C5619061A164C450C2003DCD4DD6268A01C2EAD9A75441E7DE44C5D9FC0E17B85C07FF044F62387EE3224080F3C04C6441EC683FE7BC7D97F1115B720B240BBF62CA28004160B30951AE80C75DF5D7C67D2C2241D291550E68890914CAC9F575599570D26F58883E4685A50FAF2C6C2C85C03CE90D6DCC52AEA0960DFBC5A86344ECCD6F3D6B8C898EDA99A43FE3D5D2BA716AA67E947FB97C67F78B7B2BF349079D796E1B0B2F49143F7587A6A186D608065FDB6D238FF1F1BC34DF908D81E09AC37B5A5E9DA7AF468FBBF9BDD423B3FB884FAF3AE00F3E1C7E29FDCB6E95F44ACC12B06F30C672DF245E2FC0D5CE7347AC092B\";");
                fileWriter.write("\n\tpublic final static String BASE_RSA_PUBLIC_KEYE = \"010001\";\n");
                fileWriter.write("\n\tpublic final static int REQ_RSA_PUBLIC_VERSION = 158;");
                fileWriter.write("\n\tpublic final static String REQ_RSA_PUBLIC_KEYN = \"E161DA03D0B6AAD21F9A4FB27C32A3208AF25A707BB0E8ECE79506FBBAF97519D9794B7E1B44D2C6F2588495C4E040303B4C915F172DD558A49552762CB28AB309C08152A8C55A4DFC6EA80D1F4D860190A8EE251DF8DECB9B083674D56CD956FF652C3C724B9F02BE5C7CBC63FC0124AA260D889A73E91292B6A02121D25AAA7C1A87752575C181FFB25A6282725B0C38A2AD57676E0884FE20CF56256E14529BC7E82CD1F4A1155984512BD273D68F769AF46E1B0E3053816D39EB1F0588384F2F4B286E5CFAFB4D0435BDF7D3AA8D3E0C45716EAD190FDC66884B275BA08D8ED94B1F84E7729C25BD014E7FA3A23123E10D3A93B4154452DDB9EE5F8DAB67\";");
                fileWriter.write("\n\tpublic final static String REQ_RSA_PUBLIC_KEYE = \"010001\";\n\n}\n");
                z = true;
                try {
                    fileWriter.close();
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    w.printErrStackTrace("MicroMsg.RsaInfo", e, "", new Object[0]);
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception e4) {
                        }
                    }
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileWriter = null;
            w.printErrStackTrace("MicroMsg.RsaInfo", e, "", new Object[0]);
            if (fileWriter != null) {
                fileWriter.close();
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileWriter = null;
            if (fileWriter != null) {
                fileWriter.close();
            }
            throw th;
        }
        return z;
    }
}
