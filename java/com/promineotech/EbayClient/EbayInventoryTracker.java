
//org.springframework.boot.web.support.SpringBootServletInitializer

//@ComponentScan(excludeFilters={@ComponentScan.Filter
//		(type= FilterType.ASSIGNABLE_TYPE, value=<classThatYouWantToExclued>.class)})  

//@SpringBootApplication(exclude = {EbayInventoryTracker.class })
//import org.springframework.context.annotation.ComponentScan;

package com.promineotech.EbayClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class })

public class EbayInventoryTracker {

	public static void main(String[] args) {
		SpringApplication.run(EbayInventoryTracker.class, args);

	}

}

//@SpringBootApplication(scanBasePackages = {"com"})
