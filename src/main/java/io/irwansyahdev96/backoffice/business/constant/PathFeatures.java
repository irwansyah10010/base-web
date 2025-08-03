package io.irwansyahdev96.backoffice.business.constant;

public enum PathFeatures {
    LOGIN(UriFeatures.LOGIN, "Login"),

    HOME(UriFeatures.HOME, "Home"), 
    
    LEGACY_BILLER(UriFeatures.LEGACY_BILLER,"Mst Biller"),
    UBP_BILLER(UriFeatures.UBP_BILLER,"Ubp Biller"),

    GL_AND_FEE(UriFeatures.GL_AND_FEE,"Gl And Fee Management"),

    LIVE_STATUS(UriFeatures.LIVE_STATUS,"Live Status"),

    TRANSACTION_LOG(UriFeatures.TRANSACTION_LOG,"Transaction Log"),
    SETTLEMENT_LOG(UriFeatures.SETTLEMENT_LOG,"Settlement Log"),

    CARD_FFID(UriFeatures.CARD_FFID,"Card Ffid"),
    RESPONSE_CODE(UriFeatures.RESPONSE_CODE,"Response Code"),
    RESPONSE_MESSAGE(UriFeatures.RESPONSE_MESSAGE,"Response Message"),

    PENDING_TASK(UriFeatures.PENDING_TASK,"Pending Task"),

    PARAMETER(UriFeatures.PARAMETER,"Parameter"),
    QUICK_SHORTCUT(UriFeatures.QUICK_SHORTCUT,"Quick Shorcut"),
    BRANCH(UriFeatures.BRANCH,"Branch"),

    TRANSACTION_TRACK(UriFeatures.TRANSACTION_TRACK,"Transaction Track"),

    USER(UriFeatures.USER,"User"),
    ROLE(UriFeatures.ROLE,"Role");

    private String path;
    private String title;

    PathFeatures(String path, String title){
        this.path = path;
        this.title = title;
    }

    /**
     * path
     */
    public String getPath() {
        return path;
    }

    public String getIndexPath(){
        return "views".concat(path.concat("/index"));
    }

    public String getCustomPath(String filename){
        return path.concat(filename);
    }

    /**
     * title
     */
    public String getTitle() {
        return title;
    }

}
