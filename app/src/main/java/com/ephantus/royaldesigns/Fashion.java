package com.ephantus.royaldesigns;

public class Fashion {
    private String mName;
    private String mImageUrl;
    private String mUsername;
    private String mLocation;

    public Fashion(String imageUrl, String name, String username, String location){
        this.mName = name;
        this.mImageUrl = imageUrl;
        this.mUsername = username;
        this.mLocation = location;

    }

    public String getmName() {
        return mName;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmUsername() {
        return mUsername;
    }

    public String getmLocation() {
        return mLocation;
    }
}
