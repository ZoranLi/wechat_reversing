package com.tencent.wcdb.database;

public class SQLiteCipherSpec {
    public static final String CIPHER_AES256CBC = "aes-256-cbc";
    public static final String CIPHER_DEVLOCK = "devlock";
    public static final String CIPHER_XXTEA = "xxtea";
    public String cipher;
    public boolean hmacEnabled = true;
    public int kdfIteration;
    public int pageSize = SQLiteGlobal.defaultPageSize;

    public SQLiteCipherSpec(SQLiteCipherSpec sQLiteCipherSpec) {
        this.cipher = sQLiteCipherSpec.cipher;
        this.kdfIteration = sQLiteCipherSpec.kdfIteration;
        this.hmacEnabled = sQLiteCipherSpec.hmacEnabled;
        this.pageSize = sQLiteCipherSpec.pageSize;
    }

    public SQLiteCipherSpec setCipher(String str) {
        this.cipher = str;
        return this;
    }

    public SQLiteCipherSpec setKDFIteration(int i) {
        this.kdfIteration = i;
        return this;
    }

    public SQLiteCipherSpec withHMACEnabled(boolean z) {
        this.hmacEnabled = z;
        return this;
    }

    public SQLiteCipherSpec setPageSize(int i) {
        this.pageSize = i;
        return this;
    }

    public SQLiteCipherSpec setSQLCipherVersion(int i) {
        switch (i) {
            case 1:
                this.hmacEnabled = false;
                this.kdfIteration = 4000;
                break;
            case 2:
                this.hmacEnabled = true;
                this.kdfIteration = 4000;
                break;
            case 3:
                this.hmacEnabled = true;
                this.kdfIteration = 64000;
                break;
            default:
                throw new IllegalArgumentException("Unsupported SQLCipher version: " + i);
        }
        return this;
    }
}
