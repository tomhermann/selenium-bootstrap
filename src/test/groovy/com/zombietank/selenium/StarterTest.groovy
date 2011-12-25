package com.zombietank.selenium;

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.htmlunit.HtmlUnitDriver

class StarterTest extends GroovyTestCase {
	
	void testTableParsing() {
		WebDriver driver = new HtmlUnitDriver()
		driver.get "http://www.mobilefish.com/tutorials/whois_servers_list/whois_servers_list.html"
		WebElement table = driver.findElement By.id("sort")
		List<WebElement> rows = table.findElements By.tagName("tr")
		
		for(WebElement row : rows) {
			def dataElements = row.findElements By.tagName("td")
			if(dataElements[2].text.trim() != '-') {
				println "insert into whois_servers (tld, server, description) values ('${dataElements[0].text}', '${dataElements[2].text}', '${dataElements[1].text}');"
			}
		}
	} 
}
