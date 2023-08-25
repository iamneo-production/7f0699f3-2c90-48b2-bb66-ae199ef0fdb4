package com.telecom.packagecustomization.util;

import java.util.ArrayList;
import java.util.List;
import com.telecom.packagecustomization.model.Packages;

public class PackageLoader {
    private List<Packages> packageList = new ArrayList<Packages>();

    public List<Packages> loadPackages() {
        Packages package1 = new Packages();
        package1.setPlanName("Rs. 2545 Plan");
        package1.setPlanType("voice+data+sms");
        package1.setPlanAmount(2545);
        package1.setValidity("336 Days");
        package1.setDataVolume("2GB / Day");
        package1.setVoiceEligibility("Unlimited");
        package1.setSmsEligbility("100 SMS");
        package1.setNetwork("5G");

        Packages packag2 = new Packages();
        packag2.setPlanName("Rs. 2999 Plan");
        packag2.setPlanType("voice+data+sms");
        packag2.setPlanAmount(2999);
        packag2.setValidity("365 Days");
        packag2.setVoiceEligibility("Unlimited");
        packag2.setDataVolume("1.5GB / Day");
        packag2.setSmsEligbility("100 SMS");
        packag2.setNetwork("5G");

        Packages packag3 = new Packages();
        packag3.setPlanName("Rs. 749 Trending");
        packag3.setPlanType("voice+data+sms");
        packag3.setPlanAmount(749);
        packag3.setValidity("256 Days");
        packag3.setDataVolume("2GB / Day");
        packag3.setVoiceEligibility("Unlimited");
        packag3.setSmsEligbility("100 SMS");
        packag3.setNetwork("5G");

        Packages packag4 = new Packages();
        packag4.setPlanName("Rs. 299 Netflix Included");
        packag4.setPlanType("voice+data");
        packag4.setPlanAmount(299);
        packag4.setValidity("28 Days");
        packag4.setDataVolume("56 GB");
        packag4.setVoiceEligibility("Unlimited");
        packag4.setSmsEligbility("No SMS");
        packag4.setNetwork("5G");

        Packages packag5 = new Packages();
        packag5.setPlanName("Rs. 222");
        packag5.setPlanType("Only Data");
        packag5.setPlanAmount(222);
        packag5.setValidity("As per Active Plan");
        packag5.setDataVolume("50 GB");
        packag5.setVoiceEligibility("No Voice");
        packag5.setSmsEligbility("No SMS");
        packag5.setNetwork("5G");

        Packages packag6 = new Packages();
        packag6.setPlanName("Rs. 61");
        packag6.setPlanType("Only Data");
        packag6.setPlanAmount(61);
        packag6.setValidity("As per Active Plan");
        packag6.setDataVolume("6 GB");
        packag6.setVoiceEligibility("No Voice");
        packag6.setSmsEligbility("No SMS");
        packag6.setNetwork("5G");


        Packages packag7 = new Packages();
        packag7.setPlanName("Rs. 121");
        packag7.setPlanType("Only Voice");
        packag7.setPlanAmount(121);
        packag7.setValidity("28 days");
        packag7.setDataVolume("NO Data");
        packag7.setVoiceEligibility("Unlimited");
        packag7.setSmsEligbility("NO SMS");
        packag7.setNetwork("5G");

        packageList.add(package1);
        packageList.add(packag2);
        packageList.add(packag3);
        packageList.add(packag4);
        packageList.add(packag5);
        packageList.add(packag6);
        packageList.add(packag7);

        return packageList;
    }

}
