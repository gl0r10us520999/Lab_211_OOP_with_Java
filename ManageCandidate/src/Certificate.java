import java.util.ArrayList;
public class Certificate {

  private ArrayList<Certificate> certificates = new ArrayList<>();
  private String certId;
  private String certType;
  private String certName;
  private String placeOfIssue;
  private String issueDate;

  public Certificate(String certId, String certType, String certName, String placeOfIssue, String issueDate) {
    this.certId = certId;
    this.certType = certType;
    this.certName = certName;
    this.placeOfIssue = placeOfIssue;
    this.issueDate = issueDate;
  }

  public String getCertId() {
    return certId;
  }

  public void setCertId(String certId) {
    this.certId = certId;
  }

  public String getCertType() {
    return certType;
  }

  public void setCertType(String certType) {
    this.certType = certType;
  }

  public String getCertName() {
    return certName;
  }

  public void setCertName(String certName) {
    this.certName = certName;
  }

  public String getPlaceOfIssue() {
    return placeOfIssue;
  }

  public void setPlaceOfIssue(String placeOfIssue) {
    this.placeOfIssue = placeOfIssue;
  }

  public String getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(String issueDate) {
    this.issueDate = issueDate;
  }

  public void addCert(Certificate certificate){
    certificates.add(certificate);
  }

  public ArrayList<Certificate> getCertificates(){
    return certificates;
  }
}
