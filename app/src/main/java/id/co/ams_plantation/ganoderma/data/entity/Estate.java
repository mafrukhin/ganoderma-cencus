package id.co.ams_plantation.ganoderma.data.entity;

/**
 * Created by PASPC-02009 on 04/08/2016.
 */
public class Estate {

    public static final String tag_estate_asistensi = "asistensi";
    public static final String tag_estate_user = "estateuser";

    private String estCode;
    private String estName;
    private String companyShortName;
    private String estateTag;
    private String nikMember;

    public String getEstCode() {
        return estCode;
    }

    public void setEstCode(String estCode) {
        this.estCode = estCode;
    }

    public String getEstName() {
        return estName;
    }

    public void setEstName(String estName) {
        this.estName = estName;
    }

    public String getCompanyShortName() {
        return companyShortName;
    }

    public void setCompanyShortName(String companyShortName) {
        this.companyShortName = companyShortName;
    }

    public String getEstateTag() {
        return estateTag;
    }

    public void setEstateTag(String estateTag) {
        this.estateTag = estateTag;
    }

    public String getNikMember() {
        return nikMember;
    }

    public void setNikMember(String nikMember) {
        this.nikMember = nikMember;
    }
}