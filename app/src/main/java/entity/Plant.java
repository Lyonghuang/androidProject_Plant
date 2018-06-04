package entity;


/**
 * 植物的实体
 */
public class Plant {

    private String name;
    private int id;
    private String description;
    private String lignt;
    private int highTemperature;
    private int lowTemperature;
    private String baikeURL;
    private int imgId;


    public Plant(String name,int imgId,String description){
        this.name=name;
        this.imgId=imgId;
        this.description=description;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLignt() {
        return lignt;
    }

    public void setLignt(String lignt) {
        this.lignt = lignt;
    }

    public int getHighTemperature() {
        return highTemperature;
    }

    public void setHighTemperature(int highTemperature) {
        this.highTemperature = highTemperature;
    }

    public int getLowTemperature() {
        return lowTemperature;
    }

    public void setLowTemperature(int lowTemperature) {
        this.lowTemperature = lowTemperature;
    }

    public String getBaikeURL() {
        return baikeURL;
    }

    public void setBaikeURL(String baikeURL) {
        this.baikeURL = baikeURL;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
