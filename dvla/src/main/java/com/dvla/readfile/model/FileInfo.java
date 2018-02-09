package com.dvla.readfile.model;

public class FileInfo {

    private String name;
    private String extension;
    private String size;
    private String mimeType;

    public FileInfo(String name, String extension, String size, String mimeType) {
        this.name = name;
        this.extension = extension;
        this.size = size;
        this.mimeType = mimeType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
}
