package com.franlopez.betabeersdemo;

import java.io.Serializable;

public class ModelAndroidVersion implements Serializable {

    private String mName;
    private String mAPIVersion;
    private String mVersionCode;
    private String mUrl;

    public ModelAndroidVersion(String mName, String mAPIVersion, String mVersionCode, String mUrl) {
        this.mName = mName;
        this.mAPIVersion = mAPIVersion;
        this.mVersionCode = mVersionCode;
        this.mUrl = mUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getAPIVersion() {
        return mAPIVersion;
    }

    public void setAPIVersion(String mAPIVersion) {
        this.mAPIVersion = mAPIVersion;
    }

    public String getVersionCode() {
        return mVersionCode;
    }

    public void setVersionCode(String mVersionCode) {
        this.mVersionCode = mVersionCode;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
