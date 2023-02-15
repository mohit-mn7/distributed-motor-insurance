package service.core;

import java.util.List;

public class ClientApplication {
    private int applicationNumber = 0;
    private ClientInfo info;
    private List<Quotation> quotationList;

    public ClientApplication(){}
    
    public ClientApplication(ClientInfo info, List<Quotation> quotationList) {
        this.applicationNumber = (int) (Math.random()*1000);
        this.info = info;
        this.quotationList = quotationList;
    }

    public int getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(int applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public ClientInfo getInfo() {
        return info;
    }

    public void setInfo(ClientInfo info) {
        this.info = info;
    }

    public List<Quotation> getQuotationList() {
        return quotationList;
    }

    public void setQuotationList(List<Quotation> quotationList) {
        this.quotationList = quotationList;
    }
}
